package com.phonegap.plugins.barcodescanner;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.Contents.Type;
import com.google.zxing.client.android.Intents.Encode;
import com.google.zxing.client.android.Intents.Scan;
import com.google.zxing.client.android.encode.EncodeActivity;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PermissionHelper;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BarcodeScanner extends CordovaPlugin {
    /* renamed from: a */
    private String[] f699a = new String[]{"android.permission.CAMERA"};
    /* renamed from: b */
    private JSONArray f700b;
    /* renamed from: c */
    private CallbackContext f701c;

    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        this.f701c = callbackContext;
        this.f700b = jSONArray;
        if (str.equals("encode")) {
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString(Param.TYPE);
                String optString2 = optJSONObject.optString("data");
                if (optString == null) {
                    optString = Type.TEXT;
                }
                if (optString2 == null) {
                    callbackContext.error("User did not specify data to encode");
                    return true;
                }
                m1159a(optString, optString2);
                return true;
            }
            callbackContext.error("User did not specify data to encode");
            return true;
        } else if (!str.equals("scan")) {
            return false;
        } else {
            if (hasPermisssion()) {
                m1160a(jSONArray);
                return true;
            }
            requestPermissions(0);
            return true;
        }
    }

    /* renamed from: a */
    public void m1160a(final JSONArray jSONArray) {
        this.cordova.getThreadPool().execute(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ BarcodeScanner f698c;

            public void run() {
                Intent intent = new Intent(this.cordova.getActivity().getBaseContext(), CaptureActivity.class);
                intent.setAction(Scan.ACTION);
                intent.addCategory("android.intent.category.DEFAULT");
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            JSONArray names = jSONObject.names();
                            for (int i2 = 0; i2 < names.length(); i2++) {
                                try {
                                    String string = names.getString(i2);
                                    Object obj = jSONObject.get(string);
                                    if (obj instanceof Integer) {
                                        intent.putExtra(string, (Integer) obj);
                                    } else if (obj instanceof String) {
                                        intent.putExtra(string, (String) obj);
                                    }
                                } catch (JSONException e) {
                                    Log.i("CordovaLog", e.getLocalizedMessage());
                                }
                            }
                            intent.putExtra(Scan.CAMERA_ID, jSONObject.optBoolean("preferFrontCamera", false) ? 1 : 0);
                            intent.putExtra(Scan.SHOW_FLIP_CAMERA_BUTTON, jSONObject.optBoolean("showFlipCameraButton", false));
                            intent.putExtra(Scan.SHOW_TORCH_BUTTON, jSONObject.optBoolean("showTorchButton", false));
                            intent.putExtra(Scan.TORCH_ON, jSONObject.optBoolean("torchOn", false));
                            if (jSONObject.has("resultDisplayDuration")) {
                                intent.putExtra(Scan.RESULT_DISPLAY_DURATION_MS, "" + jSONObject.optLong("resultDisplayDuration"));
                            }
                            if (jSONObject.has("formats")) {
                                intent.putExtra(Scan.FORMATS, jSONObject.optString("formats"));
                            }
                            if (jSONObject.has("prompt")) {
                                intent.putExtra(Scan.PROMPT_MESSAGE, jSONObject.optString("prompt"));
                            }
                            if (jSONObject.has("orientation")) {
                                intent.putExtra(Scan.ORIENTATION_LOCK, jSONObject.optString("orientation"));
                            }
                        } catch (JSONException e2) {
                            Log.i("CordovaLog", e2.getLocalizedMessage());
                        }
                    }
                }
                intent.setPackage(this.cordova.getActivity().getApplicationContext().getPackageName());
                this.cordova.startActivityForResult(this, intent, 195543262);
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 195543262 && this.f701c != null) {
            JSONObject jSONObject;
            if (i2 == -1) {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("text", intent.getStringExtra(Scan.RESULT));
                    jSONObject.put("format", intent.getStringExtra(Scan.RESULT_FORMAT));
                    jSONObject.put("cancelled", false);
                } catch (JSONException e) {
                    Log.d("BarcodeScanner", "This should never happen");
                }
                this.f701c.success(jSONObject);
            } else if (i2 == 0) {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("text", "");
                    jSONObject.put("format", "");
                    jSONObject.put("cancelled", true);
                } catch (JSONException e2) {
                    Log.d("BarcodeScanner", "This should never happen");
                }
                this.f701c.success(jSONObject);
            } else {
                this.f701c.error("Unexpected error");
            }
        }
    }

    /* renamed from: a */
    public void m1159a(String str, String str2) {
        Intent intent = new Intent(this.cordova.getActivity().getBaseContext(), EncodeActivity.class);
        intent.setAction(Encode.ACTION);
        intent.putExtra(Encode.TYPE, str);
        intent.putExtra(Encode.DATA, str2);
        intent.setPackage(this.cordova.getActivity().getApplicationContext().getPackageName());
        this.cordova.getActivity().startActivity(intent);
    }

    public boolean hasPermisssion() {
        for (String hasPermission : this.f699a) {
            if (!PermissionHelper.hasPermission(this, hasPermission)) {
                return false;
            }
        }
        return true;
    }

    public void requestPermissions(int i) {
        PermissionHelper.requestPermissions(this, i, this.f699a);
    }

    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == -1) {
                Log.d("BarcodeScanner", "Permission Denied!");
                this.f701c.sendPluginResult(new PluginResult(Status.ILLEGAL_ACCESS_EXCEPTION));
                return;
            }
        }
        switch (i) {
            case 0:
                m1160a(this.f700b);
                return;
            default:
                return;
        }
    }

    public void onRestoreStateForActivityResult(Bundle bundle, CallbackContext callbackContext) {
        this.f701c = callbackContext;
    }
}
