package hu.dpal.phonegap.plugins;

import android.content.Context;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;

public class UniqueDeviceID extends CordovaPlugin {
    /* renamed from: a */
    public CallbackContext f851a;

    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        this.f851a = callbackContext;
        try {
            if (str.equals("get")) {
                if (m1320a("android.permission.READ_PHONE_STATE")) {
                    m1321a();
                } else {
                    m1319a(this, 0, "android.permission.READ_PHONE_STATE");
                }
                return true;
            }
            this.f851a.error("Invalid action");
            return false;
        } catch (Exception e) {
            this.f851a.error("Exception occurred: ".concat(e.getMessage()));
            return false;
        }
    }

    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            m1321a();
        }
    }

    /* renamed from: a */
    protected void m1321a() {
        try {
            Context applicationContext = this.cordova.getActivity().getApplicationContext();
            TelephonyManager telephonyManager = (TelephonyManager) applicationContext.getSystemService("phone");
            String string = Secure.getString(applicationContext.getContentResolver(), "android_id");
            String deviceId = telephonyManager.getDeviceId();
            String simSerialNumber = telephonyManager.getSimSerialNumber();
            if ("9774d56d682e549c".equals(string) || string == null) {
                string = "";
            }
            if (deviceId == null) {
                deviceId = "";
            }
            if (simSerialNumber == null) {
                simSerialNumber = "";
            }
            this.f851a.success(String.format("%32s", new Object[]{string + deviceId + simSerialNumber}).replace(' ', '0').substring(0, 32).replaceAll("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5"));
        } catch (Exception e) {
            this.f851a.error("Exception occurred: ".concat(e.getMessage()));
        }
    }

    /* renamed from: a */
    private boolean m1320a(String str) {
        try {
            return ((Boolean) this.cordova.getClass().getMethod("hasPermission", new Class[]{str.getClass()}).invoke(this.cordova, new Object[]{str})).booleanValue();
        } catch (NoSuchMethodException e) {
            Log.w("UniqueDeviceID", "Cordova v6.2.3 does not support API 23 runtime permissions so defaulting to GRANTED for " + str);
            return true;
        }
    }

    /* renamed from: a */
    private void m1319a(CordovaPlugin cordovaPlugin, int i, String str) {
        try {
            this.cordova.getClass().getMethod("requestPermission", new Class[]{CordovaPlugin.class, Integer.TYPE, String.class}).invoke(this.cordova, new Object[]{cordovaPlugin, Integer.valueOf(i), str});
        } catch (NoSuchMethodException e) {
            throw new Exception("requestPermission() method not found in CordovaInterface implementation of Cordova v6.2.3");
        }
    }
}
