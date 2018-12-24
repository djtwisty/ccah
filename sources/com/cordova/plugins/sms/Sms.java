package com.cordova.plugins.sms;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.SmsManager;
import java.util.ArrayList;
import java.util.UUID;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;

public class Sms extends CordovaPlugin {
    /* renamed from: a */
    public final String f621a = "send";
    /* renamed from: b */
    public final String f622b = "has_permission";
    /* renamed from: c */
    private CallbackContext f623c;
    /* renamed from: d */
    private JSONArray f624d;

    /* renamed from: com.cordova.plugins.sms.Sms$1 */
    class C03151 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ Sms f615a;

        C03151(Sms sms) {
            this.f615a = sms;
        }

        public void run() {
            try {
                String str = ";";
                if (Build.MANUFACTURER.equalsIgnoreCase("Samsung")) {
                    str = ",";
                }
                String replace = this.f615a.f624d.getJSONArray(0).join(str).replace("\"", "");
                str = this.f615a.f624d.getString(1);
                String string = this.f615a.f624d.getString(2);
                if (Boolean.parseBoolean(this.f615a.f624d.getString(3))) {
                    str = str.replace("\\n", System.getProperty("line.separator"));
                }
                if (!this.f615a.m1059d()) {
                    this.f615a.f623c.sendPluginResult(new PluginResult(Status.ERROR, "SMS not supported on this platform"));
                } else if (string.equalsIgnoreCase("INTENT")) {
                    this.f615a.m1052a(replace, str);
                    this.f615a.f623c.sendPluginResult(new PluginResult(Status.OK));
                } else {
                    this.f615a.m1053a(this.f615a.f623c, replace, str);
                }
            } catch (JSONException e) {
                this.f615a.f623c.sendPluginResult(new PluginResult(Status.JSON_EXCEPTION));
            }
        }
    }

    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        this.f623c = callbackContext;
        this.f624d = jSONArray;
        if (str.equals("send")) {
            if (m1054a()) {
                m1058c();
                return true;
            }
            m1055b();
            return true;
        } else if (!str.equals("has_permission")) {
            return false;
        } else {
            callbackContext.sendPluginResult(new PluginResult(Status.OK, m1054a()));
            return true;
        }
    }

    /* renamed from: a */
    private boolean m1054a() {
        return this.cordova.hasPermission("android.permission.SEND_SMS");
    }

    /* renamed from: b */
    private void m1055b() {
        this.cordova.requestPermission(this, 0, "android.permission.SEND_SMS");
    }

    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == -1) {
                this.f623c.sendPluginResult(new PluginResult(Status.ERROR, "User has denied permission"));
                return;
            }
        }
        m1058c();
    }

    /* renamed from: c */
    private boolean m1058c() {
        this.cordova.getThreadPool().execute(new C03151(this));
        return true;
    }

    /* renamed from: d */
    private boolean m1059d() {
        return this.cordova.getActivity().getPackageManager().hasSystemFeature("android.hardware.telephony");
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private void m1052a(String str, String str2) {
        Intent intent;
        if (!"".equals(str) || VERSION.SDK_INT < 19) {
            intent = new Intent("android.intent.action.VIEW");
            intent.putExtra("sms_body", str2);
            intent.putExtra("address", str);
            intent.setData(Uri.parse("smsto:" + Uri.encode(str)));
        } else {
            String defaultSmsPackage = android.provider.Telephony.Sms.getDefaultSmsPackage(this.cordova.getActivity());
            intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", str2);
            if (defaultSmsPackage != null) {
                intent.setPackage(defaultSmsPackage);
            }
        }
        this.cordova.getActivity().startActivity(intent);
    }

    /* renamed from: a */
    private void m1053a(final CallbackContext callbackContext, String str, String str2) {
        int i = 0;
        SmsManager smsManager = SmsManager.getDefault();
        final ArrayList divideMessage = smsManager.divideMessage(str2);
        BroadcastReceiver c03162 = new BroadcastReceiver(this) {
            /* renamed from: a */
            boolean f616a = false;
            /* renamed from: b */
            int f617b = divideMessage.size();
            /* renamed from: e */
            final /* synthetic */ Sms f620e;

            public void onReceive(Context context, Intent intent) {
                switch (getResultCode()) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        this.f616a = true;
                        break;
                }
                this.f617b--;
                if (this.f617b == 0) {
                    if (this.f616a) {
                        callbackContext.sendPluginResult(new PluginResult(Status.ERROR));
                    } else {
                        callbackContext.sendPluginResult(new PluginResult(Status.OK));
                    }
                    this.f620e.cordova.getActivity().unregisterReceiver(this);
                }
            }
        };
        String str3 = "SMS_SENT" + UUID.randomUUID().toString();
        this.cordova.getActivity().registerReceiver(c03162, new IntentFilter(str3));
        PendingIntent broadcast = PendingIntent.getBroadcast(this.cordova.getActivity(), 0, new Intent(str3), 0);
        if (divideMessage.size() > 1) {
            ArrayList arrayList = new ArrayList();
            while (i < divideMessage.size()) {
                arrayList.add(broadcast);
                i++;
            }
            smsManager.sendMultipartTextMessage(str, null, divideMessage, arrayList, null);
            return;
        }
        smsManager.sendTextMessage(str, null, str2, broadcast, null);
    }
}
