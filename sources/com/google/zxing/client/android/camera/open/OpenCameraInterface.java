package com.google.zxing.client.android.camera.open;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.util.Log;

public final class OpenCameraInterface {
    public static final int NO_REQUESTED_CAMERA = -1;
    private static final String TAG = OpenCameraInterface.class.getName();

    private OpenCameraInterface() {
    }

    public static OpenCamera open(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            Log.w(TAG, "No cameras!");
            return null;
        }
        int i2;
        CameraInfo cameraInfo;
        int i3;
        Camera open;
        if (numberOfCameras == 1) {
            i2 = 0;
        } else {
            i2 = i;
        }
        int i4 = i2 >= 0 ? 1 : 0;
        if (i4 != 0) {
            cameraInfo = new CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            i3 = i2;
        } else {
            i3 = 0;
            while (i3 < numberOfCameras) {
                cameraInfo = new CameraInfo();
                Camera.getCameraInfo(i3, cameraInfo);
                if (CameraFacing.values()[cameraInfo.facing] == CameraFacing.BACK) {
                    break;
                }
                i3++;
            }
            cameraInfo = null;
        }
        if (i3 < numberOfCameras) {
            Log.i(TAG, "Opening camera #" + i3);
            open = Camera.open(i3);
        } else if (i4 != 0) {
            Log.w(TAG, "Requested camera does not exist: " + i2);
            open = null;
        } else {
            Log.i(TAG, "No camera facing " + CameraFacing.BACK + "; returning camera #0");
            open = Camera.open(0);
            cameraInfo = new CameraInfo();
            Camera.getCameraInfo(0, cameraInfo);
        }
        if (open != null) {
            return new OpenCamera(i3, open, CameraFacing.values()[cameraInfo.facing], cameraInfo.orientation);
        }
        return null;
    }
}
