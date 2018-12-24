package com.google.zxing.client.android.camera;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.client.android.camera.open.OpenCamera;
import com.google.zxing.client.android.camera.open.OpenCameraInterface;
import java.io.IOException;

public final class CameraManager {
    private static final int MAX_FRAME_HEIGHT = 675;
    private static final int MAX_FRAME_WIDTH = 1200;
    private static final int MIN_FRAME_HEIGHT = 240;
    private static final int MIN_FRAME_WIDTH = 240;
    private static final String TAG = CameraManager.class.getSimpleName();
    private AutoFocusManager autoFocusManager;
    private OpenCamera camera;
    private final CameraConfigurationManager configManager;
    private final Context context;
    private Rect framingRect;
    private Rect framingRectInPreview;
    private boolean initialized;
    private final PreviewCallback previewCallback;
    private boolean previewing;
    private int requestedCameraId = -1;
    private int requestedFramingRectHeight;
    private int requestedFramingRectWidth;
    private boolean torchInitiallyOn;
    private WindowManager windowManager;

    public CameraManager(Context context) {
        this.context = context.getApplicationContext();
        this.configManager = new CameraConfigurationManager(context);
        this.previewCallback = new PreviewCallback(this.configManager);
        this.windowManager = (WindowManager) this.context.getSystemService("window");
    }

    public synchronized void openDriver(SurfaceHolder surfaceHolder) {
        OpenCamera openCamera = this.camera;
        if (openCamera == null) {
            openCamera = OpenCameraInterface.open(this.requestedCameraId);
            if (openCamera == null) {
                throw new IOException("Camera.open() failed to return object from driver");
            }
            this.camera = openCamera;
        }
        OpenCamera openCamera2 = openCamera;
        if (!this.initialized) {
            this.initialized = true;
            this.configManager.initFromCameraParameters(openCamera2);
            if (this.requestedFramingRectWidth > 0 && this.requestedFramingRectHeight > 0) {
                setManualFramingRect(this.requestedFramingRectWidth, this.requestedFramingRectHeight);
                this.requestedFramingRectWidth = 0;
                this.requestedFramingRectHeight = 0;
            }
        }
        Camera camera = openCamera2.getCamera();
        Parameters parameters = camera.getParameters();
        String flatten = parameters == null ? null : parameters.flatten();
        try {
            this.configManager.setDesiredCameraParameters(openCamera2, false);
        } catch (RuntimeException e) {
            Log.w(TAG, "Camera rejected parameters. Setting only minimal safe-mode parameters");
            Log.i(TAG, "Resetting to saved camera params: " + flatten);
            if (flatten != null) {
                Parameters parameters2 = camera.getParameters();
                parameters2.unflatten(flatten);
                try {
                    camera.setParameters(parameters2);
                    this.configManager.setDesiredCameraParameters(openCamera2, true);
                } catch (RuntimeException e2) {
                    Log.w(TAG, "Camera rejected even safe-mode parameters! No configuration");
                }
            }
        }
        camera.setPreviewDisplay(surfaceHolder);
        if (this.torchInitiallyOn) {
            setTorch(true);
        }
    }

    public synchronized boolean isOpen() {
        return this.camera != null;
    }

    public synchronized void closeDriver() {
        if (this.camera != null) {
            this.camera.getCamera().release();
            this.camera = null;
            this.framingRect = null;
            this.framingRectInPreview = null;
        }
    }

    public synchronized void startPreview() {
        OpenCamera openCamera = this.camera;
        if (!(openCamera == null || this.previewing)) {
            openCamera.getCamera().startPreview();
            this.previewing = true;
            this.autoFocusManager = new AutoFocusManager(this.context, openCamera.getCamera());
        }
    }

    public synchronized void stopPreview() {
        if (this.autoFocusManager != null) {
            this.autoFocusManager.stop();
            this.autoFocusManager = null;
        }
        if (this.camera != null && this.previewing) {
            this.camera.getCamera().stopPreview();
            this.previewCallback.setHandler(null, 0);
            this.previewing = false;
        }
    }

    public synchronized boolean isTorchOn() {
        boolean z;
        z = this.camera != null && this.configManager.getTorchState(this.camera.getCamera());
        return z;
    }

    public synchronized void setTorch(boolean z) {
        OpenCamera openCamera = this.camera;
        if (!(openCamera == null || z == this.configManager.getTorchState(openCamera.getCamera()))) {
            Object obj = this.autoFocusManager != null ? 1 : null;
            if (obj != null) {
                this.autoFocusManager.stop();
                this.autoFocusManager = null;
            }
            this.configManager.setTorch(openCamera.getCamera(), z);
            if (obj != null) {
                this.autoFocusManager = new AutoFocusManager(this.context, openCamera.getCamera());
                this.autoFocusManager.start();
            }
        }
    }

    public synchronized void requestPreviewFrame(Handler handler, int i) {
        OpenCamera openCamera = this.camera;
        if (openCamera != null && this.previewing) {
            this.previewCallback.setHandler(handler, i);
            openCamera.getCamera().setOneShotPreviewCallback(this.previewCallback);
        }
    }

    public synchronized Rect getFramingRect() {
        Rect rect = null;
        synchronized (this) {
            if (this.framingRect == null) {
                if (this.camera != null) {
                    Point screenResolution = this.configManager.getScreenResolution();
                    if (screenResolution != null) {
                        int findDesiredDimensionInRange = findDesiredDimensionInRange(screenResolution.x, 240, MAX_FRAME_WIDTH);
                        int findDesiredDimensionInRange2 = findDesiredDimensionInRange(screenResolution.y, 240, MAX_FRAME_HEIGHT);
                        int i = (screenResolution.x - findDesiredDimensionInRange) / 2;
                        int i2 = (screenResolution.y - findDesiredDimensionInRange2) / 2;
                        this.framingRect = new Rect(i, i2, findDesiredDimensionInRange + i, findDesiredDimensionInRange2 + i2);
                        Log.d(TAG, "Calculated framing rect: " + this.framingRect);
                    }
                }
            }
            rect = this.framingRect;
        }
        return rect;
    }

    private static int findDesiredDimensionInRange(int i, int i2, int i3) {
        int i4 = (i * 5) / 8;
        if (i4 < i2) {
            return i2;
        }
        if (i4 > i3) {
            return i3;
        }
        return i4;
    }

    public synchronized Rect getFramingRectInPreview() {
        Rect rect = null;
        synchronized (this) {
            if (this.framingRectInPreview == null) {
                Rect framingRect = getFramingRect();
                if (framingRect != null) {
                    Rect rect2 = new Rect(framingRect);
                    Point cameraResolution = this.configManager.getCameraResolution();
                    Point screenResolution = this.configManager.getScreenResolution();
                    if (!(cameraResolution == null || screenResolution == null)) {
                        if (this.context.getApplicationContext().getResources().getConfiguration().orientation == 1) {
                            rect2.left = (rect2.left * cameraResolution.y) / screenResolution.x;
                            rect2.right = (rect2.right * cameraResolution.y) / screenResolution.x;
                            rect2.top = (rect2.top * cameraResolution.x) / screenResolution.y;
                            rect2.bottom = (rect2.bottom * cameraResolution.x) / screenResolution.y;
                        } else {
                            rect2.left = (rect2.left * cameraResolution.x) / screenResolution.x;
                            rect2.right = (rect2.right * cameraResolution.x) / screenResolution.x;
                            rect2.top = (rect2.top * cameraResolution.y) / screenResolution.y;
                            rect2.bottom = (rect2.bottom * cameraResolution.y) / screenResolution.y;
                        }
                        this.framingRectInPreview = rect2;
                    }
                }
            }
            rect = this.framingRectInPreview;
        }
        return rect;
    }

    public synchronized void setManualCameraId(int i) {
        this.requestedCameraId = i;
    }

    public synchronized void setTorchInitiallyOn(boolean z) {
        this.torchInitiallyOn = z;
    }

    public synchronized void setManualFramingRect(int i, int i2) {
        if (this.initialized) {
            this.framingRect = getFramingRect();
            Log.d(TAG, "Calculated manual framing rect: " + this.framingRect);
            this.framingRectInPreview = null;
        } else {
            this.requestedFramingRectWidth = i;
            this.requestedFramingRectHeight = i2;
        }
    }

    public PlanarYUVLuminanceSource buildLuminanceSource(byte[] bArr, int i, int i2) {
        int i3;
        byte[] bArr2;
        int i4;
        byte[] bArr3 = new byte[bArr.length];
        int i5 = this.context.getApplicationContext().getResources().getConfiguration().orientation;
        if (i5 == 1) {
            for (i3 = 0; i3 < i2; i3++) {
                for (int i6 = 0; i6 < i; i6++) {
                    bArr3[(((i6 * i2) + i2) - i3) - 1] = bArr[(i3 * i) + i6];
                }
            }
            bArr2 = bArr3;
            i4 = i;
            i3 = i2;
        } else {
            bArr2 = null;
            i4 = i2;
            i3 = i;
        }
        Rect framingRectInPreview = getFramingRectInPreview();
        if (framingRectInPreview == null) {
            return null;
        }
        if (i5 != 1) {
            bArr2 = bArr;
        }
        return new PlanarYUVLuminanceSource(bArr2, i3, i4, framingRectInPreview.left, framingRectInPreview.top, framingRectInPreview.width(), framingRectInPreview.height(), false);
    }
}
