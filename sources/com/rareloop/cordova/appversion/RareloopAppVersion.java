package com.rareloop.cordova.appversion;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONObject;

public class RareloopAppVersion extends CordovaPlugin {
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        if (!str.equals("getAppVersion")) {
            return false;
        }
        try {
            PackageManager packageManager = this.cordova.getActivity().getPackageManager();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ClientCookie.VERSION_ATTR, packageManager.getPackageInfo(this.cordova.getActivity().getPackageName(), 0).versionName);
            jSONObject.put("build", packageManager.getPackageInfo(this.cordova.getActivity().getPackageName(), 0).versionCode);
            callbackContext.success(jSONObject);
        } catch (NameNotFoundException e) {
            callbackContext.error("Exception thrown");
        }
        return true;
    }
}
