package com.google.zxing.client.android;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import barcodescanner.xservices.nl.barcodescanner.C0306R;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.ReaderException;
import com.google.zxing.common.HybridBinarizer;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Map;
import org.apache.http.HttpStatus;

final class DecodeHandler extends Handler {
    private static final String TAG = DecodeHandler.class.getSimpleName();
    private final CaptureActivity activity;
    private int frameCount;
    private final MultiFormatReader multiFormatReader = new MultiFormatReader();
    private boolean running = true;

    DecodeHandler(CaptureActivity captureActivity, Map<DecodeHintType, Object> map) {
        this.multiFormatReader.setHints(map);
        this.activity = captureActivity;
    }

    public void handleMessage(Message message) {
        if (!this.running) {
            return;
        }
        if (message.what == C0306R.id.decode) {
            decode((byte[]) message.obj, message.arg1, message.arg2);
        } else if (message.what == C0306R.id.quit) {
            this.running = false;
            Looper.myLooper().quit();
        }
    }

    private void decode(byte[] bArr, int i, int i2) {
        Object decodeWithState;
        Handler handler;
        int i3 = 0;
        long currentTimeMillis = System.currentTimeMillis();
        MultiFormatReader multiFormatReader = null;
        if (this.frameCount == 3) {
            this.frameCount = 0;
            int[] iArr = new int[(i * i2)];
            YUV_NV21_TO_RGB(iArr, bArr, i, i2);
            while (i3 < iArr.length) {
                iArr[i3] = 16777215 - iArr[i3];
                i3++;
            }
            encodeYUV420SP(bArr, iArr, i, i2);
        }
        this.frameCount++;
        LuminanceSource buildLuminanceSource = this.activity.getCameraManager().buildLuminanceSource(bArr, i, i2);
        if (buildLuminanceSource != null) {
            try {
                decodeWithState = this.multiFormatReader.decodeWithState(new BinaryBitmap(new HybridBinarizer(buildLuminanceSource)));
            } catch (ReaderException e) {
                MultiFormatReader multiFormatReader2 = multiFormatReader;
                handler = this.activity.getHandler();
                if (decodeWithState != null) {
                    Log.d(TAG, "Found barcode in " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    if (handler != null) {
                        Message obtain = Message.obtain(handler, C0306R.id.decode_succeeded, decodeWithState);
                        Bundle bundle = new Bundle();
                        bundleThumbnail(buildLuminanceSource, bundle);
                        obtain.setData(bundle);
                        obtain.sendToTarget();
                    }
                } else if (handler != null) {
                    Message.obtain(handler, C0306R.id.decode_failed).sendToTarget();
                }
            } finally {
                multiFormatReader = this.multiFormatReader;
                multiFormatReader.reset();
            }
        } else {
            decodeWithState = null;
        }
        handler = this.activity.getHandler();
        if (decodeWithState != null) {
            Log.d(TAG, "Found barcode in " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            if (handler != null) {
                Message obtain2 = Message.obtain(handler, C0306R.id.decode_succeeded, decodeWithState);
                Bundle bundle2 = new Bundle();
                bundleThumbnail(buildLuminanceSource, bundle2);
                obtain2.setData(bundle2);
                obtain2.sendToTarget();
            }
        } else if (handler != null) {
            Message.obtain(handler, C0306R.id.decode_failed).sendToTarget();
        }
    }

    private static void bundleThumbnail(PlanarYUVLuminanceSource planarYUVLuminanceSource, Bundle bundle) {
        int[] renderThumbnail = planarYUVLuminanceSource.renderThumbnail();
        int thumbnailWidth = planarYUVLuminanceSource.getThumbnailWidth();
        Bitmap createBitmap = Bitmap.createBitmap(renderThumbnail, 0, thumbnailWidth, thumbnailWidth, planarYUVLuminanceSource.getThumbnailHeight(), Config.ARGB_8888);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(CompressFormat.JPEG, 50, byteArrayOutputStream);
        bundle.putByteArray(DecodeThread.BARCODE_BITMAP, byteArrayOutputStream.toByteArray());
        bundle.putFloat(DecodeThread.BARCODE_SCALED_FACTOR, ((float) thumbnailWidth) / ((float) planarYUVLuminanceSource.getWidth()));
    }

    private static void YUV_NV21_TO_RGB(int[] iArr, byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i6 < i2) {
            int i7 = 0;
            int i8 = 0;
            int i9 = i4;
            while (i8 < i) {
                int i10 = bArr[(i5 * i) + i7] & 255;
                int i11 = bArr[((((i5 >> 1) * i) + i3) + (i7 & -2)) + 0] & 255;
                i4 = bArr[((((i5 >> 1) * i) + i3) + (i7 & -2)) + 1] & 255;
                if (i10 < 16) {
                    i10 = 16;
                }
                i10 = (i10 - 16) * 1192;
                int i12 = (i4 - 128) * 2066;
                i4 = (i10 + ((i11 - 128) * 1634)) >> 10;
                i11 = ((i10 - ((i11 - 128) * 832)) - ((i4 - 128) * HttpStatus.SC_BAD_REQUEST)) >> 10;
                i10 = (i10 + i12) >> 10;
                if (i4 < 0) {
                    i4 = 0;
                } else if (i4 > 255) {
                    i4 = 255;
                }
                if (i11 < 0) {
                    i11 = 0;
                } else if (i11 > 255) {
                    i11 = 255;
                }
                if (i10 < 0) {
                    i10 = 0;
                } else if (i10 > 255) {
                    i10 = 255;
                }
                int i13 = i9 + 1;
                iArr[i9] = i10 | ((i11 << 8) | ((i4 << 16) | 0));
                i7++;
                i8++;
                i9 = i13;
            }
            i5++;
            i6++;
            i4 = i9;
        }
    }

    void encodeYUV420SP(byte[] bArr, int[] iArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = 0;
        int length = i3 + ((bArr.length - i3) / 2);
        System.out.println(bArr.length + " " + i3);
        int i5 = 0;
        int i6 = 0;
        while (i6 < i2) {
            int i7 = 0;
            int i8 = i5;
            int i9 = i4;
            while (i7 < i) {
                int i10 = (iArr[i8] & -16777216) >> 24;
                i4 = (iArr[i8] & 16711680) >> 16;
                int i11 = (iArr[i8] & 65280) >> 8;
                int i12 = (iArr[i8] & 255) >> 0;
                i10 = (((((i4 * 66) + (i11 * 129)) + (i12 * 25)) + 128) >> 8) + 16;
                i5 = (((((i4 * -38) - (i11 * 74)) + (i12 * 112)) + 128) >> 8) + 128;
                i4 = (((((i4 * 112) - (i11 * 94)) - (i12 * 18)) + 128) >> 8) + 128;
                i12 = i9 + 1;
                if (i10 < 0) {
                    i10 = 0;
                } else if (i10 > 255) {
                    i10 = 255;
                }
                bArr[i9] = (byte) i10;
                if (i6 % 2 == 0 && i8 % 2 == 0) {
                    i11 = i3 + 1;
                    i10 = i5 < 0 ? 0 : i5 > 255 ? 255 : i5;
                    bArr[i3] = (byte) i10;
                    i5 = length + 1;
                    i10 = i4 < 0 ? 0 : i4 > 255 ? 255 : i4;
                    bArr[length] = (byte) i10;
                    i10 = i5;
                    i4 = i11;
                } else {
                    i10 = length;
                    i4 = i3;
                }
                i7++;
                i8++;
                length = i10;
                i3 = i4;
                i9 = i12;
            }
            i6++;
            i5 = i8;
            i4 = i9;
        }
    }
}
