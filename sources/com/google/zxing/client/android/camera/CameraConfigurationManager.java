package com.google.zxing.client.android.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.google.zxing.client.android.PreferencesActivity;
import com.google.zxing.client.android.camera.open.CameraFacing;
import com.google.zxing.client.android.camera.open.OpenCamera;

final class CameraConfigurationManager {
    private static final String TAG = "CameraConfiguration";
    private Point bestPreviewSize;
    private Point cameraResolution;
    private final Context context;
    private int cwNeededRotation;
    private int cwRotationFromDisplayToCamera;
    private Point previewSizeOnScreen;
    private Point screenResolution;

    CameraConfigurationManager(Context context) {
        this.context = context.getApplicationContext();
    }

    void initFromCameraParameters(OpenCamera openCamera) {
        Object obj = 1;
        Parameters parameters = openCamera.getCamera().getParameters();
        Display defaultDisplay = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay();
        int rotation = defaultDisplay.getRotation();
        switch (rotation) {
            case 0:
                rotation = 0;
                break;
            case 1:
                rotation = 90;
                break;
            case 2:
                rotation = 180;
                break;
            case 3:
                rotation = 270;
                break;
            default:
                if (rotation % 90 == 0) {
                    rotation = (rotation + 360) % 360;
                    break;
                }
                throw new IllegalArgumentException("Bad rotation: " + rotation);
        }
        Log.i(TAG, "Display at: " + rotation);
        int orientation = openCamera.getOrientation();
        Log.i(TAG, "Camera at: " + orientation);
        if (openCamera.getFacing() == CameraFacing.FRONT) {
            orientation = (360 - orientation) % 360;
            Log.i(TAG, "Front camera overriden to: " + orientation);
        }
        this.cwRotationFromDisplayToCamera = ((orientation + 360) - rotation) % 360;
        Log.i(TAG, "Final display orientation: " + this.cwRotationFromDisplayToCamera);
        if (openCamera.getFacing() == CameraFacing.FRONT) {
            Log.i(TAG, "Compensating rotation for front camera");
            this.cwNeededRotation = (360 - this.cwRotationFromDisplayToCamera) % 360;
        } else {
            this.cwNeededRotation = this.cwRotationFromDisplayToCamera;
        }
        Log.i(TAG, "Clockwise rotation from display to camera: " + this.cwNeededRotation);
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.screenResolution = point;
        Log.i(TAG, "Screen resolution in current orientation: " + this.screenResolution);
        this.cameraResolution = CameraConfigurationUtils.findBestPreviewSizeValue(parameters, this.screenResolution);
        Log.i(TAG, "Camera resolution: " + this.cameraResolution);
        this.bestPreviewSize = CameraConfigurationUtils.findBestPreviewSizeValue(parameters, this.screenResolution);
        Log.i(TAG, "Best available preview size: " + this.bestPreviewSize);
        Object obj2 = this.screenResolution.x < this.screenResolution.y ? 1 : null;
        if (this.bestPreviewSize.x >= this.bestPreviewSize.y) {
            obj = null;
        }
        if (obj2 == obj) {
            this.previewSizeOnScreen = this.bestPreviewSize;
        } else {
            this.previewSizeOnScreen = new Point(this.bestPreviewSize.y, this.bestPreviewSize.x);
        }
        Log.i(TAG, "Preview size on screen: " + this.previewSizeOnScreen);
    }

    void setDesiredCameraParameters(OpenCamera openCamera, boolean z) {
        Camera camera = openCamera.getCamera();
        int i = this.context.getApplicationContext().getResources().getConfiguration().orientation;
        int rotation = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (i == 1) {
            if (rotation == 0 || rotation == 1) {
                camera.setDisplayOrientation(90);
            } else {
                camera.setDisplayOrientation(270);
            }
        } else if (rotation == 2 || rotation == 3) {
            camera.setDisplayOrientation(180);
        }
        Parameters parameters = camera.getParameters();
        if (parameters == null) {
            Log.w(TAG, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        Log.i(TAG, "Initial camera parameters: " + parameters.flatten());
        if (z) {
            Log.w(TAG, "In camera config safe mode -- most settings will not be honored");
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        initializeTorch(parameters, defaultSharedPreferences, z);
        CameraConfigurationUtils.setFocus(parameters, defaultSharedPreferences.getBoolean(PreferencesActivity.KEY_AUTO_FOCUS, true), defaultSharedPreferences.getBoolean(PreferencesActivity.KEY_DISABLE_CONTINUOUS_FOCUS, true), z);
        if (!z) {
            if (defaultSharedPreferences.getBoolean(PreferencesActivity.KEY_INVERT_SCAN, false)) {
                CameraConfigurationUtils.setInvertColor(parameters);
            }
            if (!defaultSharedPreferences.getBoolean(PreferencesActivity.KEY_DISABLE_BARCODE_SCENE_MODE, true)) {
                CameraConfigurationUtils.setBarcodeSceneMode(parameters);
            }
            if (!defaultSharedPreferences.getBoolean(PreferencesActivity.KEY_DISABLE_METERING, true)) {
                CameraConfigurationUtils.setVideoStabilization(parameters);
                CameraConfigurationUtils.setFocusArea(parameters);
                CameraConfigurationUtils.setMetering(parameters);
            }
        }
        parameters.setPreviewSize(this.bestPreviewSize.x, this.bestPreviewSize.y);
        camera.setParameters(parameters);
        camera.setDisplayOrientation(this.cwRotationFromDisplayToCamera);
        Size previewSize = camera.getParameters().getPreviewSize();
        if (previewSize == null) {
            return;
        }
        if (this.bestPreviewSize.x != previewSize.width || this.bestPreviewSize.y != previewSize.height) {
            Log.w(TAG, "Camera said it supported preview size " + this.bestPreviewSize.x + 'x' + this.bestPreviewSize.y + ", but after setting it, preview size is " + previewSize.width + 'x' + previewSize.height);
            this.bestPreviewSize.x = previewSize.width;
            this.bestPreviewSize.y = previewSize.height;
        }
    }

    Point getBestPreviewSize() {
        return this.bestPreviewSize;
    }

    Point getPreviewSizeOnScreen() {
        return this.previewSizeOnScreen;
    }

    Point getCameraResolution() {
        return this.cameraResolution;
    }

    Point getScreenResolution() {
        return this.screenResolution;
    }

    int getCWNeededRotation() {
        return this.cwNeededRotation;
    }

    boolean getTorchState(Camera camera) {
        if (camera == null) {
            return false;
        }
        Parameters parameters = camera.getParameters();
        if (parameters == null) {
            return false;
        }
        String flashMode = parameters.getFlashMode();
        if (flashMode == null) {
            return false;
        }
        if ("on".equals(flashMode) || "torch".equals(flashMode)) {
            return true;
        }
        return false;
    }

    void setTorch(Camera camera, boolean z) {
        Parameters parameters = camera.getParameters();
        doSetTorch(parameters, z, false);
        camera.setParameters(parameters);
    }

    private void initializeTorch(Parameters parameters, SharedPreferences sharedPreferences, boolean z) {
        doSetTorch(parameters, FrontLightMode.readPref(sharedPreferences) == FrontLightMode.ON, z);
    }

    private void doSetTorch(Parameters parameters, boolean z, boolean z2) {
        CameraConfigurationUtils.setTorch(parameters, z);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        if (!z2 && !defaultSharedPreferences.getBoolean(PreferencesActivity.KEY_DISABLE_EXPOSURE, true)) {
            CameraConfigurationUtils.setBestExposure(parameters, z);
        }
    }
}
