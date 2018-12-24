package com.phonegap.plugin.mobileaccessibility;

import android.os.Build.VERSION;
import android.webkit.WebView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.InvocationTargetException;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MobileAccessibility extends CordovaPlugin {
    /* renamed from: a */
    private C0452a f677a;
    /* renamed from: b */
    private CallbackContext f678b = null;
    /* renamed from: c */
    private boolean f679c = false;
    /* renamed from: d */
    private boolean f680d = false;
    /* renamed from: e */
    private boolean f681e = false;
    /* renamed from: f */
    private boolean f682f = false;
    /* renamed from: g */
    private float f683g = 1.0f;

    /* renamed from: com.phonegap.plugin.mobileaccessibility.MobileAccessibility$1 */
    class C04431 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ MobileAccessibility f662a;

        C04431(MobileAccessibility mobileAccessibility) {
            this.f662a = mobileAccessibility;
        }

        public void run() {
            try {
                ((WebView) this.f662a.webView).reload();
            } catch (ClassCastException e) {
                try {
                    this.f662a.webView.getClass().getMethod("getView", new Class[0]).invoke(this.f662a.webView, new Object[0]).getClass().getMethod("reload", new Class[0]).invoke(this.f662a.webView, new Object[0]);
                } catch (NoSuchMethodException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                } catch (IllegalAccessException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.phonegap.plugin.mobileaccessibility.MobileAccessibility$5 */
    class C04475 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ MobileAccessibility f669a;

        C04475(MobileAccessibility mobileAccessibility) {
            this.f669a = mobileAccessibility;
        }

        public void run() {
            this.f669a.m1108a();
        }
    }

    /* renamed from: com.phonegap.plugin.mobileaccessibility.MobileAccessibility$6 */
    class C04486 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ MobileAccessibility f670a;

        C04486(MobileAccessibility mobileAccessibility) {
            this.f670a = mobileAccessibility;
        }

        public void run() {
            this.f670a.m1108a();
        }
    }

    /* renamed from: com.phonegap.plugin.mobileaccessibility.MobileAccessibility$7 */
    class C04497 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ MobileAccessibility f671a;

        C04497(MobileAccessibility mobileAccessibility) {
            this.f671a = mobileAccessibility;
        }

        public void run() {
            this.f671a.m1108a();
        }
    }

    public void initialize(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
        super.initialize(cordovaInterface, cordovaWebView);
        if (VERSION.SDK_INT >= 19) {
            this.f677a = new C0461e();
        } else if (VERSION.SDK_INT >= 16) {
            this.f677a = new C0458d();
        } else if (VERSION.SDK_INT >= 14) {
            this.f677a = new C0457c();
        } else {
            this.f677a = new C0454b();
        }
        this.f677a.mo1621a(this);
    }

    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        try {
            if (str.equals("isScreenReaderRunning")) {
                m1111a(callbackContext);
                return true;
            } else if (str.equals("isClosedCaptioningEnabled")) {
                m1114b(callbackContext);
                return true;
            } else if (str.equals("isTouchExplorationEnabled")) {
                m1117c(callbackContext);
                return true;
            } else if (str.equals("postNotification")) {
                if (jSONArray.length() <= 1) {
                    return true;
                }
                CharSequence string = jSONArray.getString(1);
                if (string.isEmpty()) {
                    return true;
                }
                m1110a(string, callbackContext);
                return true;
            } else if (str.equals("getTextZoom")) {
                m1120d(callbackContext);
                return true;
            } else if (str.equals("setTextZoom")) {
                if (jSONArray.length() <= 0) {
                    return true;
                }
                double d = jSONArray.getDouble(0);
                if (d <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    return true;
                }
                m1109a(d, callbackContext);
                return true;
            } else if (str.equals("updateTextZoom")) {
                m1122e(callbackContext);
                return true;
            } else if (str.equals("start")) {
                m1123f(callbackContext);
                return true;
            } else {
                if (str.equals("stop")) {
                    m1116c();
                    return true;
                }
                return false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            callbackContext.sendPluginResult(new PluginResult(Status.JSON_EXCEPTION));
        }
    }

    public void onPause(boolean z) {
        this.f682f = this.f679c;
    }

    public void onResume(boolean z) {
        if (this.f679c && !this.f682f) {
            this.f682f = this.f679c;
            m1116c();
            this.cordova.getActivity().runOnUiThread(new C04431(this));
        }
    }

    public void onDestroy() {
        m1116c();
    }

    /* renamed from: a */
    private void m1111a(final CallbackContext callbackContext) {
        this.f679c = this.f677a.mo1624b();
        this.cordova.getThreadPool().execute(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ MobileAccessibility f664b;

            public void run() {
                callbackContext.success(this.f664b.f679c ? 1 : 0);
            }
        });
    }

    /* renamed from: b */
    private void m1114b(final CallbackContext callbackContext) {
        this.f680d = this.f677a.mo1623a();
        this.cordova.getThreadPool().execute(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ MobileAccessibility f666b;

            public void run() {
                callbackContext.success(this.f666b.f680d ? 1 : 0);
            }
        });
    }

    /* renamed from: c */
    private void m1117c(final CallbackContext callbackContext) {
        this.f681e = this.f677a.mo1625c();
        this.cordova.getThreadPool().execute(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ MobileAccessibility f668b;

            public void run() {
                callbackContext.success(this.f668b.f681e ? 1 : 0);
            }
        });
    }

    /* renamed from: a */
    private void m1110a(CharSequence charSequence, CallbackContext callbackContext) {
        this.f677a.mo1622a(charSequence);
        if (callbackContext != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("stringValue", charSequence);
                jSONObject.put("wasSuccessful", this.f679c);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            callbackContext.success(jSONObject);
        }
    }

    /* renamed from: a */
    public void m1124a(boolean z) {
        this.f679c = z;
        this.cordova.getActivity().runOnUiThread(new C04475(this));
    }

    /* renamed from: b */
    public void m1125b(boolean z) {
        this.f680d = z;
        this.cordova.getActivity().runOnUiThread(new C04486(this));
    }

    /* renamed from: c */
    public void m1126c(boolean z) {
        this.f681e = z;
        this.cordova.getActivity().runOnUiThread(new C04497(this));
    }

    /* renamed from: d */
    private void m1120d(final CallbackContext callbackContext) {
        this.cordova.getActivity().runOnUiThread(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ MobileAccessibility f673b;

            public void run() {
                double f = this.f673b.f677a.mo1628f();
                if (callbackContext != null) {
                    callbackContext.success((int) f);
                }
            }
        });
    }

    /* renamed from: a */
    private void m1109a(final double d, final CallbackContext callbackContext) {
        this.cordova.getActivity().runOnUiThread(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ MobileAccessibility f676c;

            public void run() {
                this.f676c.f677a.mo1620a(d);
                if (callbackContext != null) {
                    callbackContext.success((int) this.f676c.f677a.mo1628f());
                }
            }
        });
    }

    /* renamed from: e */
    private void m1122e(CallbackContext callbackContext) {
        float f = this.cordova.getActivity().getResources().getConfiguration().fontScale;
        if (f != this.f683g) {
            this.f683g = f;
        }
        m1109a((double) Math.round(this.f683g * 100.0f), callbackContext);
    }

    /* renamed from: a */
    private void m1108a() {
        if (this.f678b != null) {
            PluginResult pluginResult = new PluginResult(Status.OK, m1113b());
            pluginResult.setKeepCallback(true);
            this.f678b.sendPluginResult(pluginResult);
        }
    }

    /* renamed from: b */
    private JSONObject m1113b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isScreenReaderRunning", this.f679c);
            jSONObject.put("isClosedCaptioningEnabled", this.f680d);
            jSONObject.put("isTouchExplorationEnabled", this.f681e);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: f */
    private void m1123f(CallbackContext callbackContext) {
        this.f678b = callbackContext;
        this.f677a.mo1626d();
        m1108a();
    }

    /* renamed from: c */
    private void m1116c() {
        if (this.f678b != null) {
            m1108a();
            this.f677a.mo1627e();
            this.f678b = null;
        }
    }
}
