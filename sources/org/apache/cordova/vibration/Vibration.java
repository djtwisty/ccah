package org.apache.cordova.vibration;

import android.media.AudioManager;
import android.os.Vibrator;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;

public class Vibration extends CordovaPlugin {
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        int i = 0;
        if (str.equals("vibrate")) {
            vibrate(jSONArray.getLong(0));
        } else if (str.equals("vibrateWithPattern")) {
            JSONArray jSONArray2 = jSONArray.getJSONArray(0);
            int i2 = jSONArray.getInt(1);
            long[] jArr = new long[(jSONArray2.length() + 1)];
            jArr[0] = 0;
            while (i < jSONArray2.length()) {
                jArr[i + 1] = jSONArray2.getLong(i);
                i++;
            }
            vibrateWithPattern(jArr, i2);
        } else if (!str.equals("cancelVibration")) {
            return false;
        } else {
            cancelVibration();
        }
        callbackContext.success();
        return true;
    }

    public void vibrate(long j) {
        if (j == 0) {
            j = 500;
        }
        if (((AudioManager) this.cordova.getActivity().getSystemService("audio")).getRingerMode() != 0) {
            ((Vibrator) this.cordova.getActivity().getSystemService("vibrator")).vibrate(j);
        }
    }

    public void vibrateWithPattern(long[] jArr, int i) {
        if (((AudioManager) this.cordova.getActivity().getSystemService("audio")).getRingerMode() != 0) {
            ((Vibrator) this.cordova.getActivity().getSystemService("vibrator")).vibrate(jArr, i);
        }
    }

    public void cancelVibration() {
        ((Vibrator) this.cordova.getActivity().getSystemService("vibrator")).cancel();
    }
}
