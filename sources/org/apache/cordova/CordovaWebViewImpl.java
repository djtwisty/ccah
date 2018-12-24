package org.apache.cordova;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.cordova.CordovaWebViewEngine.Client;
import org.apache.cordova.CordovaWebViewEngine.EngineView;
import org.apache.cordova.NativeToJsMessageQueue.LoadUrlBridgeMode;
import org.apache.cordova.NativeToJsMessageQueue.NoOpBridgeMode;
import org.apache.cordova.engine.SystemWebViewEngine;
import org.json.JSONException;
import org.json.JSONObject;

public class CordovaWebViewImpl implements CordovaWebView {
    static final /* synthetic */ boolean $assertionsDisabled = (!CordovaWebViewImpl.class.desiredAssertionStatus());
    public static final String TAG = "CordovaWebViewImpl";
    private CoreAndroid appPlugin;
    private Set<Integer> boundKeyCodes = new HashSet();
    private CordovaInterface cordova;
    protected final CordovaWebViewEngine engine;
    private EngineClient engineClient = new EngineClient();
    private boolean hasPausedEver;
    private int loadUrlTimeout = 0;
    String loadedUrl;
    private View mCustomView;
    private CustomViewCallback mCustomViewCallback;
    private NativeToJsMessageQueue nativeToJsMessageQueue;
    private PluginManager pluginManager;
    private CordovaPreferences preferences;
    private CordovaResourceApi resourceApi;

    protected class EngineClient implements Client {

        /* renamed from: org.apache.cordova.CordovaWebViewImpl$EngineClient$1 */
        class C05181 implements Runnable {

            /* renamed from: org.apache.cordova.CordovaWebViewImpl$EngineClient$1$1 */
            class C05171 implements Runnable {
                C05171() {
                }

                public void run() {
                    CordovaWebViewImpl.this.pluginManager.postMessage("spinner", "stop");
                }
            }

            C05181() {
            }

            public void run() {
                try {
                    Thread.sleep(2000);
                    CordovaWebViewImpl.this.cordova.getActivity().runOnUiThread(new C05171());
                } catch (InterruptedException e) {
                }
            }
        }

        protected EngineClient() {
        }

        public void clearLoadTimeoutTimer() {
            CordovaWebViewImpl.this.loadUrlTimeout = CordovaWebViewImpl.this.loadUrlTimeout + 1;
        }

        public void onPageStarted(String str) {
            LOG.m1345d(CordovaWebViewImpl.TAG, "onPageDidNavigate(" + str + ")");
            CordovaWebViewImpl.this.boundKeyCodes.clear();
            CordovaWebViewImpl.this.pluginManager.onReset();
            CordovaWebViewImpl.this.pluginManager.postMessage("onPageStarted", str);
        }

        public void onReceivedError(int i, String str, String str2) {
            clearLoadTimeoutTimer();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errorCode", i);
                jSONObject.put("description", str);
                jSONObject.put(ImagesContract.URL, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            CordovaWebViewImpl.this.pluginManager.postMessage("onReceivedError", jSONObject);
        }

        public void onPageFinishedLoading(String str) {
            LOG.m1345d(CordovaWebViewImpl.TAG, "onPageFinished(" + str + ")");
            clearLoadTimeoutTimer();
            CordovaWebViewImpl.this.pluginManager.postMessage("onPageFinished", str);
            if (CordovaWebViewImpl.this.engine.getView().getVisibility() != 0) {
                new Thread(new C05181()).start();
            }
            if (str.equals("about:blank")) {
                CordovaWebViewImpl.this.pluginManager.postMessage("exit", null);
            }
        }

        public Boolean onDispatchKeyEvent(KeyEvent keyEvent) {
            int keyCode = keyEvent.getKeyCode();
            boolean z = keyCode == 4;
            if (keyEvent.getAction() == 0) {
                if (z && CordovaWebViewImpl.this.mCustomView != null) {
                    return Boolean.valueOf(true);
                }
                if (CordovaWebViewImpl.this.boundKeyCodes.contains(Integer.valueOf(keyCode))) {
                    return Boolean.valueOf(true);
                }
                if (z) {
                    return Boolean.valueOf(CordovaWebViewImpl.this.engine.canGoBack());
                }
            } else if (keyEvent.getAction() == 1) {
                if (z && CordovaWebViewImpl.this.mCustomView != null) {
                    CordovaWebViewImpl.this.hideCustomView();
                    return Boolean.valueOf(true);
                } else if (CordovaWebViewImpl.this.boundKeyCodes.contains(Integer.valueOf(keyCode))) {
                    String str;
                    switch (keyCode) {
                        case 4:
                            str = "backbutton";
                            break;
                        case 24:
                            str = "volumeupbutton";
                            break;
                        case 25:
                            str = "volumedownbutton";
                            break;
                        case 82:
                            str = "menubutton";
                            break;
                        case 84:
                            str = "searchbutton";
                            break;
                        default:
                            str = null;
                            break;
                    }
                    if (str != null) {
                        CordovaWebViewImpl.this.sendJavascriptEvent(str);
                        return Boolean.valueOf(true);
                    }
                } else if (z) {
                    return Boolean.valueOf(CordovaWebViewImpl.this.engine.goBack());
                }
            }
            return null;
        }

        public boolean onNavigationAttempt(String str) {
            if (CordovaWebViewImpl.this.pluginManager.onOverrideUrlLoading(str)) {
                return true;
            }
            if (CordovaWebViewImpl.this.pluginManager.shouldAllowNavigation(str)) {
                return false;
            }
            if (CordovaWebViewImpl.this.pluginManager.shouldOpenExternalUrl(str).booleanValue()) {
                CordovaWebViewImpl.this.showWebPage(str, true, false, null);
                return true;
            }
            LOG.m1357w(CordovaWebViewImpl.TAG, "Blocked (possibly sub-frame) navigation to non-allowed URL: " + str);
            return true;
        }
    }

    public static CordovaWebViewEngine createEngine(Context context, CordovaPreferences cordovaPreferences) {
        try {
            return (CordovaWebViewEngine) Class.forName(cordovaPreferences.getString("webview", SystemWebViewEngine.class.getCanonicalName())).getConstructor(new Class[]{Context.class, CordovaPreferences.class}).newInstance(new Object[]{context, cordovaPreferences});
        } catch (Throwable e) {
            throw new RuntimeException("Failed to create webview. ", e);
        }
    }

    public CordovaWebViewImpl(CordovaWebViewEngine cordovaWebViewEngine) {
        this.engine = cordovaWebViewEngine;
    }

    public void init(CordovaInterface cordovaInterface) {
        init(cordovaInterface, new ArrayList(), new CordovaPreferences());
    }

    public void init(CordovaInterface cordovaInterface, List<PluginEntry> list, CordovaPreferences cordovaPreferences) {
        if (this.cordova != null) {
            throw new IllegalStateException();
        }
        this.cordova = cordovaInterface;
        this.preferences = cordovaPreferences;
        this.pluginManager = new PluginManager(this, this.cordova, list);
        this.resourceApi = new CordovaResourceApi(this.engine.getView().getContext(), this.pluginManager);
        this.nativeToJsMessageQueue = new NativeToJsMessageQueue();
        this.nativeToJsMessageQueue.addBridgeMode(new NoOpBridgeMode());
        this.nativeToJsMessageQueue.addBridgeMode(new LoadUrlBridgeMode(this.engine, cordovaInterface));
        if (cordovaPreferences.getBoolean("DisallowOverscroll", false)) {
            this.engine.getView().setOverScrollMode(2);
        }
        this.engine.init(this, cordovaInterface, this.engineClient, this.resourceApi, this.pluginManager, this.nativeToJsMessageQueue);
        if ($assertionsDisabled || (this.engine.getView() instanceof EngineView)) {
            this.pluginManager.addService(CoreAndroid.PLUGIN_NAME, "org.apache.cordova.CoreAndroid");
            this.pluginManager.init();
            return;
        }
        throw new AssertionError();
    }

    public boolean isInitialized() {
        return this.cordova != null;
    }

    public void loadUrlIntoView(final String str, boolean z) {
        boolean z2 = false;
        LOG.m1345d(TAG, ">>> loadUrl(" + str + ")");
        if (str.equals("about:blank") || str.startsWith("javascript:")) {
            this.engine.loadUrl(str, false);
            return;
        }
        if (z || this.loadedUrl == null) {
            z2 = true;
        }
        if (z2) {
            if (this.loadedUrl != null) {
                this.appPlugin = null;
                this.pluginManager.init();
            }
            this.loadedUrl = str;
        }
        final int i = this.loadUrlTimeout;
        final int integer = this.preferences.getInteger("LoadUrlTimeoutValue", 20000);
        final Runnable c05141 = new Runnable() {
            public void run() {
                CordovaWebViewImpl.this.stopLoading();
                LOG.m1348e(CordovaWebViewImpl.TAG, "CordovaWebView: TIMEOUT ERROR!");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errorCode", -6);
                    jSONObject.put("description", "The connection to the server was unsuccessful.");
                    jSONObject.put(ImagesContract.URL, str);
                } catch (JSONException e) {
                }
                CordovaWebViewImpl.this.pluginManager.postMessage("onReceivedError", jSONObject);
            }
        };
        final Runnable c05152 = new Runnable() {
            public void run() {
                try {
                    synchronized (this) {
                        wait((long) integer);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (CordovaWebViewImpl.this.loadUrlTimeout == i) {
                    CordovaWebViewImpl.this.cordova.getActivity().runOnUiThread(c05141);
                }
            }
        };
        final String str2 = str;
        this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                if (integer > 0) {
                    CordovaWebViewImpl.this.cordova.getThreadPool().execute(c05152);
                }
                CordovaWebViewImpl.this.engine.loadUrl(str2, z2);
            }
        });
    }

    public void loadUrl(String str) {
        loadUrlIntoView(str, true);
    }

    public void showWebPage(String str, boolean z, boolean z2, Map<String, Object> map) {
        LOG.m1347d(TAG, "showWebPage(%s, %b, %b, HashMap)", str, Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z2) {
            this.engine.clearHistory();
        }
        if (!z) {
            if (this.pluginManager.shouldAllowNavigation(str)) {
                loadUrlIntoView(str, true);
            } else {
                LOG.m1357w(TAG, "showWebPage: Refusing to load URL into webview since it is not in the <allow-navigation> whitelist. URL=" + str);
            }
        }
        if (this.pluginManager.shouldOpenExternalUrl(str).booleanValue()) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                Uri parse = Uri.parse(str);
                if ("file".equals(parse.getScheme())) {
                    intent.setDataAndType(parse, this.resourceApi.getMimeType(parse));
                } else {
                    intent.setData(parse);
                }
                this.cordova.getActivity().startActivity(intent);
                return;
            } catch (Throwable e) {
                LOG.m1349e(TAG, "Error loading url " + str, e);
                return;
            }
        }
        LOG.m1357w(TAG, "showWebPage: Refusing to send intent for URL since it is not in the <allow-intent> whitelist. URL=" + str);
    }

    @Deprecated
    public void showCustomView(View view, CustomViewCallback customViewCallback) {
        LOG.m1345d(TAG, "showing Custom View");
        if (this.mCustomView != null) {
            customViewCallback.onCustomViewHidden();
            return;
        }
        this.mCustomView = view;
        this.mCustomViewCallback = customViewCallback;
        ViewGroup viewGroup = (ViewGroup) this.engine.getView().getParent();
        viewGroup.addView(view, new LayoutParams(-1, -1, 17));
        this.engine.getView().setVisibility(8);
        viewGroup.setVisibility(0);
        viewGroup.bringToFront();
    }

    @Deprecated
    public void hideCustomView() {
        if (this.mCustomView != null) {
            LOG.m1345d(TAG, "Hiding Custom View");
            this.mCustomView.setVisibility(8);
            ((ViewGroup) this.engine.getView().getParent()).removeView(this.mCustomView);
            this.mCustomView = null;
            this.mCustomViewCallback.onCustomViewHidden();
            this.engine.getView().setVisibility(0);
        }
    }

    @Deprecated
    public boolean isCustomViewShowing() {
        return this.mCustomView != null;
    }

    @Deprecated
    public void sendJavascript(String str) {
        this.nativeToJsMessageQueue.addJavaScript(str);
    }

    public void sendPluginResult(PluginResult pluginResult, String str) {
        this.nativeToJsMessageQueue.addPluginResult(pluginResult, str);
    }

    public PluginManager getPluginManager() {
        return this.pluginManager;
    }

    public CordovaPreferences getPreferences() {
        return this.preferences;
    }

    public ICordovaCookieManager getCookieManager() {
        return this.engine.getCookieManager();
    }

    public CordovaResourceApi getResourceApi() {
        return this.resourceApi;
    }

    public CordovaWebViewEngine getEngine() {
        return this.engine;
    }

    public View getView() {
        return this.engine.getView();
    }

    public Context getContext() {
        return this.engine.getView().getContext();
    }

    private void sendJavascriptEvent(String str) {
        if (this.appPlugin == null) {
            this.appPlugin = (CoreAndroid) this.pluginManager.getPlugin(CoreAndroid.PLUGIN_NAME);
        }
        if (this.appPlugin == null) {
            LOG.m1357w(TAG, "Unable to fire event without existing plugin");
        } else {
            this.appPlugin.fireJavascriptEvent(str);
        }
    }

    public void setButtonPlumbedToJs(int i, boolean z) {
        switch (i) {
            case 4:
            case 24:
            case 25:
            case 82:
                if (z) {
                    this.boundKeyCodes.add(Integer.valueOf(i));
                    return;
                } else {
                    this.boundKeyCodes.remove(Integer.valueOf(i));
                    return;
                }
            default:
                throw new IllegalArgumentException("Unsupported keycode: " + i);
        }
    }

    public boolean isButtonPlumbedToJs(int i) {
        return this.boundKeyCodes.contains(Integer.valueOf(i));
    }

    public Object postMessage(String str, Object obj) {
        return this.pluginManager.postMessage(str, obj);
    }

    public String getUrl() {
        return this.engine.getUrl();
    }

    public void stopLoading() {
        this.loadUrlTimeout++;
    }

    public boolean canGoBack() {
        return this.engine.canGoBack();
    }

    public void clearCache() {
        this.engine.clearCache();
    }

    @Deprecated
    public void clearCache(boolean z) {
        this.engine.clearCache();
    }

    public void clearHistory() {
        this.engine.clearHistory();
    }

    public boolean backHistory() {
        return this.engine.goBack();
    }

    public void onNewIntent(Intent intent) {
        if (this.pluginManager != null) {
            this.pluginManager.onNewIntent(intent);
        }
    }

    public void handlePause(boolean z) {
        if (isInitialized()) {
            this.hasPausedEver = true;
            this.pluginManager.onPause(z);
            sendJavascriptEvent("pause");
            if (!z) {
                this.engine.setPaused(true);
            }
        }
    }

    public void handleResume(boolean z) {
        if (isInitialized()) {
            this.engine.setPaused(false);
            this.pluginManager.onResume(z);
            if (this.hasPausedEver) {
                sendJavascriptEvent("resume");
            }
        }
    }

    public void handleStart() {
        if (isInitialized()) {
            this.pluginManager.onStart();
        }
    }

    public void handleStop() {
        if (isInitialized()) {
            this.pluginManager.onStop();
        }
    }

    public void handleDestroy() {
        if (isInitialized()) {
            this.loadUrlTimeout++;
            this.pluginManager.onDestroy();
            loadUrl("about:blank");
            this.engine.destroy();
            hideCustomView();
        }
    }
}
