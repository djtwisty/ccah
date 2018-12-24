package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.p017e.C0244f;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.internal.base.zak;
import com.google.android.gms.internal.base.zal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static final Object zamg = new Object();
    private static HashSet<Uri> zamh = new HashSet();
    private static ImageManager zami;
    private final Context mContext;
    private final Handler mHandler = new zal(Looper.getMainLooper());
    private final ExecutorService zamj = Executors.newFixedThreadPool(4);
    private final zaa zamk = null;
    private final zak zaml = new zak();
    private final Map<zaa, ImageReceiver> zamm = new HashMap();
    private final Map<Uri, ImageReceiver> zamn = new HashMap();
    private final Map<Uri, Long> zamo = new HashMap();

    @KeepName
    private final class ImageReceiver extends ResultReceiver {
        private final Uri mUri;
        private final ArrayList<zaa> zamp = new ArrayList();
        private final /* synthetic */ ImageManager zamq;

        ImageReceiver(ImageManager imageManager, Uri uri) {
            this.zamq = imageManager;
            super(new zal(Looper.getMainLooper()));
            this.mUri = uri;
        }

        public final void zab(zaa zaa) {
            Asserts.checkMainThread("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zamp.add(zaa);
        }

        public final void zac(zaa zaa) {
            Asserts.checkMainThread("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zamp.remove(zaa);
        }

        public final void zace() {
            Intent intent = new Intent(Constants.ACTION_LOAD_IMAGE);
            intent.putExtra(Constants.EXTRA_URI, this.mUri);
            intent.putExtra(Constants.EXTRA_RESULT_RECEIVER, this);
            intent.putExtra(Constants.EXTRA_PRIORITY, 3);
            this.zamq.mContext.sendBroadcast(intent);
        }

        public final void onReceiveResult(int i, Bundle bundle) {
            this.zamq.zamj.execute(new zab(this.zamq, this.mUri, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    private static final class zaa extends C0244f<zab, Bitmap> {
        protected final /* synthetic */ int sizeOf(Object obj, Object obj2) {
            Bitmap bitmap = (Bitmap) obj2;
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        protected final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
            super.entryRemoved(z, (zab) obj, (Bitmap) obj2, (Bitmap) obj3);
        }
    }

    private final class zab implements Runnable {
        private final Uri mUri;
        private final /* synthetic */ ImageManager zamq;
        private final ParcelFileDescriptor zamr;

        public zab(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.zamq = imageManager;
            this.mUri = uri;
            this.zamr = parcelFileDescriptor;
        }

        public final void run() {
            Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.zamr != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.zamr.getFileDescriptor());
                } catch (Throwable e) {
                    String valueOf = String.valueOf(this.mUri);
                    Log.e("ImageManager", new StringBuilder(String.valueOf(valueOf).length() + 34).append("OOM while loading bitmap for uri: ").append(valueOf).toString(), e);
                    z = true;
                }
                try {
                    this.zamr.close();
                } catch (Throwable e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.zamq.mHandler.post(new zad(this.zamq, this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                String valueOf2 = String.valueOf(this.mUri);
                Log.w("ImageManager", new StringBuilder(String.valueOf(valueOf2).length() + 32).append("Latch interrupted while posting ").append(valueOf2).toString());
            }
        }
    }

    private final class zac implements Runnable {
        private final /* synthetic */ ImageManager zamq;
        private final zaa zams;

        public zac(ImageManager imageManager, zaa zaa) {
            this.zamq = imageManager;
            this.zams = zaa;
        }

        public final void run() {
            Asserts.checkMainThread("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) this.zamq.zamm.get(this.zams);
            if (imageReceiver != null) {
                this.zamq.zamm.remove(this.zams);
                imageReceiver.zac(this.zams);
            }
            zab zab = this.zams.zamu;
            if (zab.uri == null) {
                this.zams.zaa(this.zamq.mContext, this.zamq.zaml, true);
                return;
            }
            Bitmap zaa = this.zamq.zaa(zab);
            if (zaa != null) {
                this.zams.zaa(this.zamq.mContext, zaa, true);
                return;
            }
            Long l = (Long) this.zamq.zamo.get(zab.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.zams.zaa(this.zamq.mContext, this.zamq.zaml, true);
                    return;
                }
                this.zamq.zamo.remove(zab.uri);
            }
            this.zams.zaa(this.zamq.mContext, this.zamq.zaml);
            imageReceiver = (ImageReceiver) this.zamq.zamn.get(zab.uri);
            if (imageReceiver == null) {
                imageReceiver = new ImageReceiver(this.zamq, zab.uri);
                this.zamq.zamn.put(zab.uri, imageReceiver);
            }
            imageReceiver.zab(this.zams);
            if (!(this.zams instanceof zad)) {
                this.zamq.zamm.put(this.zams, imageReceiver);
            }
            synchronized (ImageManager.zamg) {
                if (!ImageManager.zamh.contains(zab.uri)) {
                    ImageManager.zamh.add(zab.uri);
                    imageReceiver.zace();
                }
            }
        }
    }

    private final class zad implements Runnable {
        private final Bitmap mBitmap;
        private final Uri mUri;
        private final CountDownLatch zadq;
        private final /* synthetic */ ImageManager zamq;
        private boolean zamt;

        public zad(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.zamq = imageManager;
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.zamt = z;
            this.zadq = countDownLatch;
        }

        public final void run() {
            Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (this.zamq.zamk != null) {
                if (this.zamt) {
                    this.zamq.zamk.evictAll();
                    System.gc();
                    this.zamt = false;
                    this.zamq.mHandler.post(this);
                    return;
                } else if (z) {
                    this.zamq.zamk.put(new zab(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.zamq.zamn.remove(this.mUri);
            if (imageReceiver != null) {
                ArrayList zaa = imageReceiver.zamp;
                int size = zaa.size();
                for (int i = 0; i < size; i++) {
                    zaa zaa2 = (zaa) zaa.get(i);
                    if (z) {
                        zaa2.zaa(this.zamq.mContext, this.mBitmap, false);
                    } else {
                        this.zamq.zamo.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                        zaa2.zaa(this.zamq.mContext, this.zamq.zaml, false);
                    }
                    if (!(zaa2 instanceof zad)) {
                        this.zamq.zamm.remove(zaa2);
                    }
                }
            }
            this.zadq.countDown();
            synchronized (ImageManager.zamg) {
                ImageManager.zamh.remove(this.mUri);
            }
        }
    }

    public static ImageManager create(Context context) {
        if (zami == null) {
            zami = new ImageManager(context, false);
        }
        return zami;
    }

    private ImageManager(Context context, boolean z) {
        this.mContext = context.getApplicationContext();
    }

    public final void loadImage(ImageView imageView, Uri uri) {
        zaa(new zac(imageView, uri));
    }

    public final void loadImage(ImageView imageView, int i) {
        zaa(new zac(imageView, i));
    }

    public final void loadImage(ImageView imageView, Uri uri, int i) {
        zaa zac = new zac(imageView, uri);
        zac.zamw = i;
        zaa(zac);
    }

    public final void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        zaa(new zad(onImageLoadedListener, uri));
    }

    public final void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        zaa zad = new zad(onImageLoadedListener, uri);
        zad.zamw = i;
        zaa(zad);
    }

    private final void zaa(zaa zaa) {
        Asserts.checkMainThread("ImageManager.loadImage() must be called in the main thread");
        new zac(this, zaa).run();
    }

    private final Bitmap zaa(zab zab) {
        if (this.zamk == null) {
            return null;
        }
        return (Bitmap) this.zamk.get(zab);
    }
}
