package org.apache.cordova;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.TelephonyManager;
import java.util.HashMap;
import java.util.Map;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CoreAndroid extends CordovaPlugin {
    public static final String PLUGIN_NAME = "CoreAndroid";
    protected static final String TAG = "CordovaApp";
    private CallbackContext messageChannel;
    private final Object messageChannelLock = new Object();
    private PluginResult pendingResume;
    private BroadcastReceiver telephonyReceiver;

    /* renamed from: org.apache.cordova.CoreAndroid$1 */
    class C05191 implements Runnable {
        C05191() {
        }

        public void run() {
            CoreAndroid.this.webView.getPluginManager().postMessage("spinner", "stop");
        }
    }

    /* renamed from: org.apache.cordova.CoreAndroid$2 */
    class C05202 implements Runnable {
        C05202() {
        }

        public void run() {
            CoreAndroid.this.webView.clearCache(true);
        }
    }

    /* renamed from: org.apache.cordova.CoreAndroid$3 */
    class C05213 implements Runnable {
        C05213() {
        }

        public void run() {
            CoreAndroid.this.webView.clearHistory();
        }
    }

    /* renamed from: org.apache.cordova.CoreAndroid$4 */
    class C05224 implements Runnable {
        C05224() {
        }

        public void run() {
            CoreAndroid.this.webView.backHistory();
        }
    }

    /* renamed from: org.apache.cordova.CoreAndroid$5 */
    class C05235 extends BroadcastReceiver {
        C05235() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction().equals("android.intent.action.PHONE_STATE") && intent.hasExtra("state")) {
                String stringExtra = intent.getStringExtra("state");
                if (stringExtra.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                    LOG.m1351i(CoreAndroid.TAG, "Telephone RINGING");
                    CoreAndroid.this.webView.getPluginManager().postMessage("telephone", "ringing");
                } else if (stringExtra.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
                    LOG.m1351i(CoreAndroid.TAG, "Telephone OFFHOOK");
                    CoreAndroid.this.webView.getPluginManager().postMessage("telephone", "offhook");
                } else if (stringExtra.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
                    LOG.m1351i(CoreAndroid.TAG, "Telephone IDLE");
                    CoreAndroid.this.webView.getPluginManager().postMessage("telephone", "idle");
                }
            }
        }
    }

    public void fireJavascriptEvent(String str) {
        sendEventMessage(str);
    }

    public void pluginInitialize() {
        initTelephonyReceiver();
    }

    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        Status status = Status.OK;
        String str2 = "";
        try {
            if (str.equals("clearCache")) {
                clearCache();
            } else if (str.equals("show")) {
                this.cordova.getActivity().runOnUiThread(new C05191());
            } else if (str.equals("loadUrl")) {
                loadUrl(jSONArray.getString(0), jSONArray.optJSONObject(1));
            } else if (!str.equals("cancelLoadUrl")) {
                if (str.equals("clearHistory")) {
                    clearHistory();
                } else if (str.equals("backHistory")) {
                    backHistory();
                } else if (str.equals("overrideButton")) {
                    overrideButton(jSONArray.getString(0), jSONArray.getBoolean(1));
                } else if (str.equals("overrideBackbutton")) {
                    overrideBackbutton(jSONArray.getBoolean(0));
                } else if (str.equals("exitApp")) {
                    exitApp();
                } else if (str.equals("messageChannel")) {
                    synchronized (this.messageChannelLock) {
                        this.messageChannel = callbackContext;
                        if (this.pendingResume != null) {
                            sendEventMessage(this.pendingResume);
                            this.pendingResume = null;
                        }
                    }
                    return true;
                }
            }
            callbackContext.sendPluginResult(new PluginResult(status, str2));
            return true;
        } catch (JSONException e) {
            callbackContext.sendPluginResult(new PluginResult(Status.JSON_EXCEPTION));
            return false;
        }
    }

    public void clearCache() {
        this.cordova.getActivity().runOnUiThread(new C05202());
    }

    public void loadUrl(String str, JSONObject jSONObject) {
        boolean z;
        boolean z2;
        int i;
        LOG.m1345d("App", "App.loadUrl(" + str + "," + jSONObject + ")");
        Map hashMap = new HashMap();
        if (jSONObject != null) {
            JSONArray names = jSONObject.names();
            z = false;
            z2 = false;
            i = 0;
            for (int i2 = 0; i2 < names.length(); i2++) {
                String string = names.getString(i2);
                if (string.equals("wait")) {
                    i = jSONObject.getInt(string);
                } else if (string.equalsIgnoreCase("openexternal")) {
                    z2 = jSONObject.getBoolean(string);
                } else if (string.equalsIgnoreCase("clearhistory")) {
                    z = jSONObject.getBoolean(string);
                } else {
                    Object obj = jSONObject.get(string);
                    if (obj != null) {
                        if (obj.getClass().equals(String.class)) {
                            hashMap.put(string, (String) obj);
                        } else if (obj.getClass().equals(Boolean.class)) {
                            hashMap.put(string, (Boolean) obj);
                        } else if (obj.getClass().equals(Integer.class)) {
                            hashMap.put(string, (Integer) obj);
                        }
                    }
                }
            }
        } else {
            z = false;
            z2 = false;
            i = 0;
        }
        if (i > 0) {
            try {
                synchronized (this) {
                    wait((long) i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.webView.showWebPage(str, z2, z, hashMap);
    }

    public void clearHistory() {
        this.cordova.getActivity().runOnUiThread(new C05213());
    }

    public void backHistory() {
        this.cordova.getActivity().runOnUiThread(new C05224());
    }

    public void overrideBackbutton(boolean z) {
        LOG.m1351i("App", "WARNING: Back Button Default Behavior will be overridden.  The backbutton event will be fired!");
        this.webView.setButtonPlumbedToJs(4, z);
    }

    public void overrideButton(String str, boolean z) {
        LOG.m1351i("App", "WARNING: Volume Button Default Behavior will be overridden.  The volume event will be fired!");
        if (str.equals("volumeup")) {
            this.webView.setButtonPlumbedToJs(24, z);
        } else if (str.equals("volumedown")) {
            this.webView.setButtonPlumbedToJs(25, z);
        } else if (str.equals("menubutton")) {
            this.webView.setButtonPlumbedToJs(82, z);
        }
    }

    public boolean isBackbuttonOverridden() {
        return this.webView.isButtonPlumbedToJs(4);
    }

    public void exitApp() {
        this.webView.getPluginManager().postMessage("exit", null);
    }

    private void initTelephonyReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        this.telephonyReceiver = new C05235();
        this.webView.getContext().registerReceiver(this.telephonyReceiver, intentFilter);
    }

    private void sendEventMessage(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", str);
        } catch (Throwable e) {
            LOG.m1349e(TAG, "Failed to create event message", e);
        }
        sendEventMessage(new PluginResult(Status.OK, jSONObject));
    }

    private void sendEventMessage(PluginResult pluginResult) {
        pluginResult.setKeepCallback(true);
        if (this.messageChannel != null) {
            this.messageChannel.sendPluginResult(pluginResult);
        }
    }

    public void onDestroy() {
        this.webView.getContext().unregisterReceiver(this.telephonyReceiver);
    }

    public void sendResumeEvent(PluginResult pluginResult) {
        synchronized (this.messageChannelLock) {
            if (this.messageChannel != null) {
                sendEventMessage(pluginResult);
            } else {
                this.pendingResume = pluginResult;
            }
        }
    }

    public static Object getBuildConfigValue(Context context, String str) {
        Object obj = null;
        try {
            obj = Class.forName(context.getPackageName() + ".BuildConfig").getField(str).get(null);
        } catch (ClassNotFoundException e) {
            LOG.m1345d(TAG, "Unable to get the BuildConfig, is this built with ANT?");
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            LOG.m1345d(TAG, str + " is not a valid field. Check your build.gradle");
        } catch (IllegalAccessException e3) {
            LOG.m1345d(TAG, "Illegal Access Exception: Let's print a stack trace.");
            e3.printStackTrace();
        }
        return obj;
    }
}
