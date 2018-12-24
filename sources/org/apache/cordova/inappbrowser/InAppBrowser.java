package org.apache.cordova.inappbrowser;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.HttpAuthHandler;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.AppMeasurement.Param;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.StringTokenizer;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.Config;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaHttpAuthHandler;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginManager;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"SetJavaScriptEnabled"})
public class InAppBrowser extends CordovaPlugin {
    private static final String CLEAR_ALL_CACHE = "clearcache";
    private static final String CLEAR_SESSION_CACHE = "clearsessioncache";
    private static final String EXIT_EVENT = "exit";
    private static final String HARDWARE_BACK_BUTTON = "hardwareback";
    private static final String HIDDEN = "hidden";
    private static final String LOAD_ERROR_EVENT = "loaderror";
    private static final String LOAD_START_EVENT = "loadstart";
    private static final String LOAD_STOP_EVENT = "loadstop";
    private static final String LOCATION = "location";
    protected static final String LOG_TAG = "InAppBrowser";
    private static final String MEDIA_PLAYBACK_REQUIRES_USER_ACTION = "mediaPlaybackRequiresUserAction";
    private static final String NULL = "null";
    private static final String SELF = "_self";
    private static final String SYSTEM = "_system";
    private static final String ZOOM = "zoom";
    private CallbackContext callbackContext;
    private boolean clearAllCache = false;
    private boolean clearSessionCache = false;
    private InAppBrowserDialog dialog;
    private EditText edittext;
    private boolean hadwareBackButton = true;
    private WebView inAppWebView;
    private boolean mediaPlaybackRequiresUserGesture = false;
    private boolean openWindowHidden = false;
    private boolean showLocationBar = true;
    private boolean showZoomControls = true;

    /* renamed from: org.apache.cordova.inappbrowser.InAppBrowser$2 */
    class C05662 implements Runnable {
        C05662() {
        }

        public void run() {
            InAppBrowser.this.dialog.show();
        }
    }

    /* renamed from: org.apache.cordova.inappbrowser.InAppBrowser$4 */
    class C05694 implements Runnable {

        /* renamed from: org.apache.cordova.inappbrowser.InAppBrowser$4$1 */
        class C05681 extends WebViewClient {
            C05681() {
            }

            public void onPageFinished(WebView webView, String str) {
                if (InAppBrowser.this.dialog != null) {
                    InAppBrowser.this.dialog.dismiss();
                    InAppBrowser.this.dialog = null;
                }
            }
        }

        C05694() {
        }

        public void run() {
            WebView access$100 = InAppBrowser.this.inAppWebView;
            if (access$100 != null) {
                access$100.setWebViewClient(new C05681());
                access$100.loadUrl("about:blank");
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(Param.TYPE, InAppBrowser.EXIT_EVENT);
                    InAppBrowser.this.sendUpdate(jSONObject, false);
                } catch (JSONException e) {
                    Log.d(InAppBrowser.LOG_TAG, "Should never happen");
                }
            }
        }
    }

    public class InAppBrowserClient extends WebViewClient {
        EditText edittext;
        CordovaWebView webView;

        public InAppBrowserClient(CordovaWebView cordovaWebView, EditText editText) {
            this.webView = cordovaWebView;
            this.edittext = editText;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Intent intent;
            if (str.startsWith("tel:")) {
                try {
                    intent = new Intent("android.intent.action.DIAL");
                    intent.setData(Uri.parse(str));
                    InAppBrowser.this.cordova.getActivity().startActivity(intent);
                    return true;
                } catch (ActivityNotFoundException e) {
                    LOG.m1348e(InAppBrowser.LOG_TAG, "Error dialing " + str + ": " + e.toString());
                }
            } else if (str.startsWith("geo:") || str.startsWith("mailto:") || str.startsWith("market:")) {
                try {
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    InAppBrowser.this.cordova.getActivity().startActivity(intent);
                    return true;
                } catch (ActivityNotFoundException e2) {
                    LOG.m1348e(InAppBrowser.LOG_TAG, "Error with " + str + ": " + e2.toString());
                }
            } else {
                if (str.startsWith("sms:")) {
                    try {
                        String substring;
                        Intent intent2 = new Intent("android.intent.action.VIEW");
                        int indexOf = str.indexOf(63);
                        if (indexOf == -1) {
                            substring = str.substring(4);
                        } else {
                            substring = str.substring(4, indexOf);
                            String query = Uri.parse(str).getQuery();
                            if (query != null && query.startsWith("body=")) {
                                intent2.putExtra("sms_body", query.substring(5));
                            }
                        }
                        intent2.setData(Uri.parse("sms:" + substring));
                        intent2.putExtra("address", substring);
                        intent2.setType("vnd.android-dir/mms-sms");
                        InAppBrowser.this.cordova.getActivity().startActivity(intent2);
                        return true;
                    } catch (ActivityNotFoundException e22) {
                        LOG.m1348e(InAppBrowser.LOG_TAG, "Error sending sms " + str + ":" + e22.toString());
                    }
                }
                return false;
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            String str2 = "";
            if (!(str.startsWith("http:") || str.startsWith("https:") || str.startsWith("file:"))) {
                LOG.m1348e(InAppBrowser.LOG_TAG, "Possible Uncaught/Unknown URI");
                str = "http://" + str;
            }
            if (!str.equals(this.edittext.getText().toString())) {
                this.edittext.setText(str);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Param.TYPE, InAppBrowser.LOAD_START_EVENT);
                jSONObject.put(ImagesContract.URL, str);
                InAppBrowser.this.sendUpdate(jSONObject, true);
            } catch (JSONException e) {
                LOG.m1348e(InAppBrowser.LOG_TAG, "URI passed in has caused a JSON error.");
            }
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (VERSION.SDK_INT >= 21) {
                CookieManager.getInstance().flush();
            } else {
                CookieSyncManager.getInstance().sync();
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Param.TYPE, InAppBrowser.LOAD_STOP_EVENT);
                jSONObject.put(ImagesContract.URL, str);
                InAppBrowser.this.sendUpdate(jSONObject, true);
            } catch (JSONException e) {
                Log.d(InAppBrowser.LOG_TAG, "Should never happen");
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Param.TYPE, InAppBrowser.LOAD_ERROR_EVENT);
                jSONObject.put(ImagesContract.URL, str2);
                jSONObject.put("code", i);
                jSONObject.put("message", str);
                InAppBrowser.this.sendUpdate(jSONObject, true, Status.ERROR);
            } catch (JSONException e) {
                Log.d(InAppBrowser.LOG_TAG, "Should never happen");
            }
        }

        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            PluginManager pluginManager;
            PluginManager pluginManager2 = null;
            try {
                pluginManager2 = (PluginManager) this.webView.getClass().getMethod("getPluginManager", new Class[0]).invoke(this.webView, new Object[0]);
            } catch (NoSuchMethodException e) {
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
            }
            if (pluginManager2 == null) {
                try {
                    pluginManager = (PluginManager) this.webView.getClass().getField("pluginManager").get(this.webView);
                } catch (NoSuchFieldException e4) {
                    pluginManager = pluginManager2;
                } catch (IllegalAccessException e5) {
                    pluginManager = pluginManager2;
                }
            } else {
                pluginManager = pluginManager2;
            }
            if (pluginManager == null || !pluginManager.onReceivedHttpAuthRequest(this.webView, new CordovaHttpAuthHandler(httpAuthHandler), str, str2)) {
                super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }
    }

    public boolean execute(String str, CordovaArgs cordovaArgs, CallbackContext callbackContext) {
        if (str.equals("open")) {
            this.callbackContext = callbackContext;
            final String string = cordovaArgs.getString(0);
            String optString = cordovaArgs.optString(1);
            if (optString == null || optString.equals("") || optString.equals(NULL)) {
                optString = SELF;
            }
            final HashMap parseFeature = parseFeature(cordovaArgs.optString(2));
            Log.d(LOG_TAG, "target = " + optString);
            final CallbackContext callbackContext2 = callbackContext;
            this.cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    Boolean bool;
                    String str;
                    Boolean bool2 = null;
                    String str2 = "";
                    if (InAppBrowser.SELF.equals(optString)) {
                        Object obj;
                        Log.d(InAppBrowser.LOG_TAG, "in self");
                        if (string.startsWith("javascript:")) {
                            bool2 = Boolean.valueOf(true);
                        }
                        if (bool2 == null) {
                            try {
                                bool2 = (Boolean) Config.class.getMethod("isUrlWhiteListed", new Class[]{String.class}).invoke(null, new Object[]{string});
                            } catch (NoSuchMethodException e) {
                            } catch (IllegalAccessException e2) {
                            } catch (InvocationTargetException e3) {
                            }
                        }
                        if (bool2 == null) {
                            try {
                                PluginManager pluginManager = (PluginManager) InAppBrowser.this.webView.getClass().getMethod("getPluginManager", new Class[0]).invoke(InAppBrowser.this.webView, new Object[0]);
                                obj = (Boolean) pluginManager.getClass().getMethod("shouldAllowNavigation", new Class[]{String.class}).invoke(pluginManager, new Object[]{string});
                            } catch (NoSuchMethodException e4) {
                                bool = bool2;
                            } catch (IllegalAccessException e5) {
                                bool = bool2;
                            } catch (InvocationTargetException e6) {
                                bool = bool2;
                            }
                        } else {
                            bool = bool2;
                        }
                        if (Boolean.TRUE.equals(obj)) {
                            Log.d(InAppBrowser.LOG_TAG, "loading in webview");
                            InAppBrowser.this.webView.loadUrl(string);
                            str = str2;
                        } else if (string.startsWith("tel:")) {
                            try {
                                Log.d(InAppBrowser.LOG_TAG, "loading in dialer");
                                Intent intent = new Intent("android.intent.action.DIAL");
                                intent.setData(Uri.parse(string));
                                InAppBrowser.this.cordova.getActivity().startActivity(intent);
                                str = str2;
                            } catch (ActivityNotFoundException e7) {
                                LOG.m1348e(InAppBrowser.LOG_TAG, "Error dialing " + string + ": " + e7.toString());
                                str = str2;
                            }
                        } else {
                            Log.d(InAppBrowser.LOG_TAG, "loading in InAppBrowser");
                            str = InAppBrowser.this.showWebPage(string, parseFeature);
                        }
                    } else if (InAppBrowser.SYSTEM.equals(optString)) {
                        Log.d(InAppBrowser.LOG_TAG, "in system");
                        str = InAppBrowser.this.openExternal(string);
                    } else {
                        Log.d(InAppBrowser.LOG_TAG, "in blank");
                        str = InAppBrowser.this.showWebPage(string, parseFeature);
                    }
                    PluginResult pluginResult = new PluginResult(Status.OK, str);
                    pluginResult.setKeepCallback(true);
                    callbackContext2.sendPluginResult(pluginResult);
                }
            });
        } else if (str.equals("close")) {
            closeDialog();
        } else if (str.equals("injectScriptCode")) {
            r0 = null;
            if (cordovaArgs.getBoolean(1)) {
                r0 = String.format("(function(){prompt(JSON.stringify([eval(%%s)]), 'gap-iab://%s')})()", new Object[]{callbackContext.getCallbackId()});
            }
            injectDeferredObject(cordovaArgs.getString(0), r0);
        } else if (str.equals("injectScriptFile")) {
            if (cordovaArgs.getBoolean(1)) {
                r0 = String.format("(function(d) { var c = d.createElement('script'); c.src = %%s; c.onload = function() { prompt('', 'gap-iab://%s'); }; d.body.appendChild(c); })(document)", new Object[]{callbackContext.getCallbackId()});
            } else {
                r0 = "(function(d) { var c = d.createElement('script'); c.src = %s; d.body.appendChild(c); })(document)";
            }
            injectDeferredObject(cordovaArgs.getString(0), r0);
        } else if (str.equals("injectStyleCode")) {
            if (cordovaArgs.getBoolean(1)) {
                r0 = String.format("(function(d) { var c = d.createElement('style'); c.innerHTML = %%s; d.body.appendChild(c); prompt('', 'gap-iab://%s');})(document)", new Object[]{callbackContext.getCallbackId()});
            } else {
                r0 = "(function(d) { var c = d.createElement('style'); c.innerHTML = %s; d.body.appendChild(c); })(document)";
            }
            injectDeferredObject(cordovaArgs.getString(0), r0);
        } else if (str.equals("injectStyleFile")) {
            if (cordovaArgs.getBoolean(1)) {
                r0 = String.format("(function(d) { var c = d.createElement('link'); c.rel='stylesheet'; c.type='text/css'; c.href = %%s; d.head.appendChild(c); prompt('', 'gap-iab://%s');})(document)", new Object[]{callbackContext.getCallbackId()});
            } else {
                r0 = "(function(d) { var c = d.createElement('link'); c.rel='stylesheet'; c.type='text/css'; c.href = %s; d.head.appendChild(c); })(document)";
            }
            injectDeferredObject(cordovaArgs.getString(0), r0);
        } else if (!str.equals("show")) {
            return false;
        } else {
            this.cordova.getActivity().runOnUiThread(new C05662());
            PluginResult pluginResult = new PluginResult(Status.OK);
            pluginResult.setKeepCallback(true);
            this.callbackContext.sendPluginResult(pluginResult);
        }
        return true;
    }

    public void onReset() {
        closeDialog();
    }

    public void onDestroy() {
        closeDialog();
    }

    private void injectDeferredObject(String str, String str2) {
        if (str2 != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str);
            String jSONArray2 = jSONArray.toString();
            jSONArray2 = jSONArray2.substring(1, jSONArray2.length() - 1);
            str = String.format(str2, new Object[]{jSONArray2});
        }
        this.cordova.getActivity().runOnUiThread(new Runnable() {
            @SuppressLint({"NewApi"})
            public void run() {
                if (VERSION.SDK_INT < 19) {
                    InAppBrowser.this.inAppWebView.loadUrl("javascript:" + str);
                } else {
                    InAppBrowser.this.inAppWebView.evaluateJavascript(str, null);
                }
            }
        });
    }

    private HashMap<String, Boolean> parseFeature(String str) {
        if (str.equals(NULL)) {
            return null;
        }
        HashMap<String, Boolean> hashMap = new HashMap();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        while (stringTokenizer.hasMoreElements()) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(stringTokenizer.nextToken(), "=");
            if (stringTokenizer2.hasMoreElements()) {
                hashMap.put(stringTokenizer2.nextToken(), stringTokenizer2.nextToken().equals("no") ? Boolean.FALSE : Boolean.TRUE);
            }
        }
        return hashMap;
    }

    public String openExternal(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            Uri parse = Uri.parse(str);
            if ("file".equals(parse.getScheme())) {
                intent.setDataAndType(parse, this.webView.getResourceApi().getMimeType(parse));
            } else {
                intent.setData(parse);
            }
            intent.putExtra("com.android.browser.application_id", this.cordova.getActivity().getPackageName());
            this.cordova.getActivity().startActivity(intent);
            return "";
        } catch (ActivityNotFoundException e) {
            Log.d(LOG_TAG, "InAppBrowser: Error loading url " + str + ":" + e.toString());
            return e.toString();
        }
    }

    public void closeDialog() {
        this.cordova.getActivity().runOnUiThread(new C05694());
    }

    public void goBack() {
        if (this.inAppWebView.canGoBack()) {
            this.inAppWebView.goBack();
        }
    }

    public boolean canGoBack() {
        return this.inAppWebView.canGoBack();
    }

    public boolean hardwareBack() {
        return this.hadwareBackButton;
    }

    private void goForward() {
        if (this.inAppWebView.canGoForward()) {
            this.inAppWebView.goForward();
        }
    }

    private void navigate(String str) {
        ((InputMethodManager) this.cordova.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.edittext.getWindowToken(), 0);
        if (str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || str.startsWith("file:")) {
            this.inAppWebView.loadUrl(str);
        } else {
            this.inAppWebView.loadUrl("http://" + str);
        }
        this.inAppWebView.requestFocus();
    }

    private boolean getShowLocationBar() {
        return this.showLocationBar;
    }

    private InAppBrowser getInAppBrowser() {
        return this;
    }

    public String showWebPage(final String str, HashMap<String, Boolean> hashMap) {
        this.showLocationBar = true;
        this.showZoomControls = true;
        this.openWindowHidden = false;
        this.mediaPlaybackRequiresUserGesture = false;
        if (hashMap != null) {
            Boolean bool = (Boolean) hashMap.get("location");
            if (bool != null) {
                this.showLocationBar = bool.booleanValue();
            }
            bool = (Boolean) hashMap.get(ZOOM);
            if (bool != null) {
                this.showZoomControls = bool.booleanValue();
            }
            bool = (Boolean) hashMap.get(HIDDEN);
            if (bool != null) {
                this.openWindowHidden = bool.booleanValue();
            }
            bool = (Boolean) hashMap.get(HARDWARE_BACK_BUTTON);
            if (bool != null) {
                this.hadwareBackButton = bool.booleanValue();
            }
            bool = (Boolean) hashMap.get(MEDIA_PLAYBACK_REQUIRES_USER_ACTION);
            if (bool != null) {
                this.mediaPlaybackRequiresUserGesture = bool.booleanValue();
            }
            bool = (Boolean) hashMap.get(CLEAR_ALL_CACHE);
            if (bool != null) {
                this.clearAllCache = bool.booleanValue();
            } else {
                bool = (Boolean) hashMap.get(CLEAR_SESSION_CACHE);
                if (bool != null) {
                    this.clearSessionCache = bool.booleanValue();
                }
            }
        }
        final CordovaWebView cordovaWebView = this.webView;
        this.cordova.getActivity().runOnUiThread(new Runnable() {

            /* renamed from: org.apache.cordova.inappbrowser.InAppBrowser$5$1 */
            class C05701 implements OnClickListener {
                C05701() {
                }

                public void onClick(View view) {
                    InAppBrowser.this.goBack();
                }
            }

            /* renamed from: org.apache.cordova.inappbrowser.InAppBrowser$5$2 */
            class C05712 implements OnClickListener {
                C05712() {
                }

                public void onClick(View view) {
                    InAppBrowser.this.goForward();
                }
            }

            /* renamed from: org.apache.cordova.inappbrowser.InAppBrowser$5$3 */
            class C05723 implements OnKeyListener {
                C05723() {
                }

                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (keyEvent.getAction() != 0 || i != 66) {
                        return false;
                    }
                    InAppBrowser.this.navigate(InAppBrowser.this.edittext.getText().toString());
                    return true;
                }
            }

            /* renamed from: org.apache.cordova.inappbrowser.InAppBrowser$5$4 */
            class C05734 implements OnClickListener {
                C05734() {
                }

                public void onClick(View view) {
                    InAppBrowser.this.closeDialog();
                }
            }

            private int dpToPixels(int i) {
                return (int) TypedValue.applyDimension(1, (float) i, InAppBrowser.this.cordova.getActivity().getResources().getDisplayMetrics());
            }

            @SuppressLint({"NewApi"})
            public void run() {
                if (InAppBrowser.this.dialog != null) {
                    InAppBrowser.this.dialog.dismiss();
                }
                InAppBrowser.this.dialog = new InAppBrowserDialog(InAppBrowser.this.cordova.getActivity(), 16973830);
                InAppBrowser.this.dialog.getWindow().getAttributes().windowAnimations = 16973826;
                InAppBrowser.this.dialog.requestWindowFeature(1);
                InAppBrowser.this.dialog.setCancelable(true);
                InAppBrowser.this.dialog.setInAppBroswer(InAppBrowser.this.getInAppBrowser());
                View linearLayout = new LinearLayout(InAppBrowser.this.cordova.getActivity());
                linearLayout.setOrientation(1);
                View relativeLayout = new RelativeLayout(InAppBrowser.this.cordova.getActivity());
                relativeLayout.setBackgroundColor(-3355444);
                relativeLayout.setLayoutParams(new LayoutParams(-1, dpToPixels(44)));
                relativeLayout.setPadding(dpToPixels(2), dpToPixels(2), dpToPixels(2), dpToPixels(2));
                relativeLayout.setHorizontalGravity(3);
                relativeLayout.setVerticalGravity(48);
                View relativeLayout2 = new RelativeLayout(InAppBrowser.this.cordova.getActivity());
                relativeLayout2.setLayoutParams(new LayoutParams(-2, -2));
                relativeLayout2.setHorizontalGravity(3);
                relativeLayout2.setVerticalGravity(16);
                relativeLayout2.setId(Integer.valueOf(1).intValue());
                View imageButton = new ImageButton(InAppBrowser.this.cordova.getActivity());
                ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -1);
                layoutParams.addRule(5);
                imageButton.setLayoutParams(layoutParams);
                imageButton.setContentDescription("Back Button");
                imageButton.setId(Integer.valueOf(2).intValue());
                Resources resources = InAppBrowser.this.cordova.getActivity().getResources();
                Drawable drawable = resources.getDrawable(resources.getIdentifier("ic_action_previous_item", "drawable", InAppBrowser.this.cordova.getActivity().getPackageName()));
                imageButton.setBackground(null);
                imageButton.setImageDrawable(drawable);
                imageButton.setScaleType(ScaleType.FIT_CENTER);
                imageButton.setPadding(0, dpToPixels(10), 0, dpToPixels(10));
                imageButton.getAdjustViewBounds();
                imageButton.setOnClickListener(new C05701());
                View imageButton2 = new ImageButton(InAppBrowser.this.cordova.getActivity());
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -1);
                layoutParams2.addRule(1, 2);
                imageButton2.setLayoutParams(layoutParams2);
                imageButton2.setContentDescription("Forward Button");
                imageButton2.setId(Integer.valueOf(3).intValue());
                Drawable drawable2 = resources.getDrawable(resources.getIdentifier("ic_action_next_item", "drawable", InAppBrowser.this.cordova.getActivity().getPackageName()));
                imageButton2.setBackground(null);
                imageButton2.setImageDrawable(drawable2);
                imageButton2.setScaleType(ScaleType.FIT_CENTER);
                imageButton2.setPadding(0, dpToPixels(10), 0, dpToPixels(10));
                imageButton2.getAdjustViewBounds();
                imageButton2.setOnClickListener(new C05712());
                InAppBrowser.this.edittext = new EditText(InAppBrowser.this.cordova.getActivity());
                layoutParams2 = new LayoutParams(-1, -1);
                layoutParams2.addRule(1, 1);
                layoutParams2.addRule(0, 5);
                InAppBrowser.this.edittext.setLayoutParams(layoutParams2);
                InAppBrowser.this.edittext.setId(Integer.valueOf(4).intValue());
                InAppBrowser.this.edittext.setSingleLine(true);
                InAppBrowser.this.edittext.setText(str);
                InAppBrowser.this.edittext.setInputType(16);
                InAppBrowser.this.edittext.setImeOptions(2);
                InAppBrowser.this.edittext.setInputType(0);
                InAppBrowser.this.edittext.setOnKeyListener(new C05723());
                View imageButton3 = new ImageButton(InAppBrowser.this.cordova.getActivity());
                ViewGroup.LayoutParams layoutParams3 = new LayoutParams(-2, -1);
                layoutParams3.addRule(11);
                imageButton3.setLayoutParams(layoutParams3);
                imageButton2.setContentDescription("Close Button");
                imageButton3.setId(Integer.valueOf(5).intValue());
                Drawable drawable3 = resources.getDrawable(resources.getIdentifier("ic_action_remove", "drawable", InAppBrowser.this.cordova.getActivity().getPackageName()));
                imageButton3.setBackground(null);
                imageButton3.setImageDrawable(drawable3);
                imageButton3.setScaleType(ScaleType.FIT_CENTER);
                imageButton.setPadding(0, dpToPixels(10), 0, dpToPixels(10));
                imageButton3.getAdjustViewBounds();
                imageButton3.setOnClickListener(new C05734());
                InAppBrowser.this.inAppWebView = new WebView(InAppBrowser.this.cordova.getActivity());
                InAppBrowser.this.inAppWebView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                InAppBrowser.this.inAppWebView.setId(Integer.valueOf(6).intValue());
                InAppBrowser.this.inAppWebView.setWebChromeClient(new InAppChromeClient(cordovaWebView));
                InAppBrowser.this.inAppWebView.setWebViewClient(new InAppBrowserClient(cordovaWebView, InAppBrowser.this.edittext));
                WebSettings settings = InAppBrowser.this.inAppWebView.getSettings();
                settings.setJavaScriptEnabled(true);
                settings.setJavaScriptCanOpenWindowsAutomatically(true);
                settings.setBuiltInZoomControls(InAppBrowser.this.showZoomControls);
                settings.setPluginState(PluginState.ON);
                if (VERSION.SDK_INT >= 17) {
                    settings.setMediaPlaybackRequiresUserGesture(InAppBrowser.this.mediaPlaybackRequiresUserGesture);
                }
                String string = InAppBrowser.this.preferences.getString("OverrideUserAgent", null);
                String string2 = InAppBrowser.this.preferences.getString("AppendUserAgent", null);
                if (string != null) {
                    settings.setUserAgentString(string);
                }
                if (string2 != null) {
                    settings.setUserAgentString(settings.getUserAgentString() + string2);
                }
                Bundle extras = InAppBrowser.this.cordova.getActivity().getIntent().getExtras();
                if (extras == null ? true : extras.getBoolean("InAppBrowserStorageEnabled", true)) {
                    settings.setDatabasePath(InAppBrowser.this.cordova.getActivity().getApplicationContext().getDir("inAppBrowserDB", 0).getPath());
                    settings.setDatabaseEnabled(true);
                }
                settings.setDomStorageEnabled(true);
                if (InAppBrowser.this.clearAllCache) {
                    CookieManager.getInstance().removeAllCookie();
                } else if (InAppBrowser.this.clearSessionCache) {
                    CookieManager.getInstance().removeSessionCookie();
                }
                InAppBrowser.this.inAppWebView.loadUrl(str);
                InAppBrowser.this.inAppWebView.setId(Integer.valueOf(6).intValue());
                InAppBrowser.this.inAppWebView.getSettings().setLoadWithOverviewMode(true);
                InAppBrowser.this.inAppWebView.getSettings().setUseWideViewPort(true);
                InAppBrowser.this.inAppWebView.requestFocus();
                InAppBrowser.this.inAppWebView.requestFocusFromTouch();
                relativeLayout2.addView(imageButton);
                relativeLayout2.addView(imageButton2);
                relativeLayout.addView(relativeLayout2);
                relativeLayout.addView(InAppBrowser.this.edittext);
                relativeLayout.addView(imageButton3);
                if (InAppBrowser.this.getShowLocationBar()) {
                    linearLayout.addView(relativeLayout);
                }
                linearLayout.addView(InAppBrowser.this.inAppWebView);
                WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams();
                layoutParams4.copyFrom(InAppBrowser.this.dialog.getWindow().getAttributes());
                layoutParams4.width = -1;
                layoutParams4.height = -1;
                InAppBrowser.this.dialog.setContentView(linearLayout);
                InAppBrowser.this.dialog.show();
                InAppBrowser.this.dialog.getWindow().setAttributes(layoutParams4);
                if (InAppBrowser.this.openWindowHidden) {
                    InAppBrowser.this.dialog.hide();
                }
            }
        });
        return "";
    }

    private void sendUpdate(JSONObject jSONObject, boolean z) {
        sendUpdate(jSONObject, z, Status.OK);
    }

    private void sendUpdate(JSONObject jSONObject, boolean z, Status status) {
        if (this.callbackContext != null) {
            PluginResult pluginResult = new PluginResult(status, jSONObject);
            pluginResult.setKeepCallback(z);
            this.callbackContext.sendPluginResult(pluginResult);
            if (!z) {
                this.callbackContext = null;
            }
        }
    }
}
