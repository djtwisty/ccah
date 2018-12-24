package de.appplant.cordova.emailcomposer;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmailComposer extends CordovaPlugin {
    /* renamed from: a */
    private JSONArray f848a;
    /* renamed from: b */
    private final C0497a f849b = new C0497a();
    /* renamed from: c */
    private CallbackContext f850c;

    public void initialize(CordovaInterface cordovaInterface, CordovaWebView cordovaWebView) {
        super.initialize(cordovaInterface, cordovaWebView);
        this.f849b.m1317a(m1290a());
    }

    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        this.f848a = jSONArray;
        this.f850c = callbackContext;
        if ("open".equalsIgnoreCase(str)) {
            m1293a(jSONArray.getJSONObject(0));
            return true;
        } else if ("isAvailable".equalsIgnoreCase(str)) {
            if (this.cordova.hasPermission("android.permission.GET_ACCOUNTS")) {
                m1292a(jSONArray.getString(0));
                return true;
            }
            requestPermissions(0);
            return true;
        } else if ("hasPermission".equalsIgnoreCase(str)) {
            m1295b();
            return true;
        } else if (!"requestPermission".equalsIgnoreCase(str)) {
            return false;
        } else {
            requestPermissions(1);
            return true;
        }
    }

    /* renamed from: a */
    private Context m1290a() {
        return this.cordova.getActivity();
    }

    /* renamed from: a */
    private void m1292a(final String str) {
        this.cordova.getThreadPool().execute(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ EmailComposer f844b;

            public void run() {
                boolean[] a = this.f844b.f849b.m1318a(str, this.f844b.m1290a());
                List arrayList = new ArrayList();
                arrayList.add(new PluginResult(Status.OK, a[0]));
                arrayList.add(new PluginResult(Status.OK, a[1]));
                this.f844b.f850c.sendPluginResult(new PluginResult(Status.OK, arrayList));
            }
        });
    }

    /* renamed from: a */
    private void m1293a(JSONObject jSONObject) {
        final Intent createChooser = Intent.createChooser(this.f849b.m1316a(jSONObject, m1290a()), jSONObject.optString("chooserHeader", "Open with"));
        this.cordova.getThreadPool().execute(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ EmailComposer f847c;

            public void run() {
                this.f847c.cordova.startActivityForResult(this, createChooser, 0);
            }
        });
    }

    /* renamed from: b */
    private void m1295b() {
        this.f850c.sendPluginResult(new PluginResult(Status.OK, Boolean.valueOf(this.cordova.hasPermission("android.permission.GET_ACCOUNTS")).booleanValue()));
    }

    public void requestPermissions(int i) {
        this.cordova.requestPermission(this, i, "android.permission.GET_ACCOUNTS");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.f850c != null) {
            this.f850c.success();
        }
    }

    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
        switch (i) {
            case 0:
                m1292a(this.f848a.getString(0));
                return;
            case 1:
                try {
                    m1295b();
                    return;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            default:
                return;
        }
        e.printStackTrace();
    }
}
