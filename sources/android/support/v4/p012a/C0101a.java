package android.support.v4.p012a;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.app.SharedElementCallback.OnSharedElementsReadyListener;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.p012a.an.C0097a;
import android.support.v4.p013b.C0100a;
import android.view.View;
import java.util.List;
import java.util.Map;

/* renamed from: android.support.v4.a.a */
public class C0101a extends C0100a {

    /* renamed from: android.support.v4.a.a$a */
    public interface C0094a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* renamed from: android.support.v4.a.a$b */
    public interface C0095b {
        void validateRequestPermissionsRequestCode(int i);
    }

    /* renamed from: android.support.v4.a.a$c */
    private static class C0096c extends SharedElementCallback {
        /* renamed from: a */
        protected an f70a;

        public C0096c(an anVar) {
            this.f70a = anVar;
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f70a.m199a((List) list, (List) list2, (List) list3);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f70a.m201b(list, list2, list3);
        }

        public void onRejectSharedElements(List<View> list) {
            this.f70a.m197a((List) list);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f70a.m200a((List) list, (Map) map);
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f70a.m195a(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f70a.m196a(context, parcelable);
        }
    }

    /* renamed from: android.support.v4.a.a$d */
    private static class C0099d extends C0096c {
        public C0099d(an anVar) {
            super(anVar);
        }

        public void onSharedElementsArrived(List<String> list, List<View> list2, final OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.a.m198a((List) list, (List) list2, new C0097a(this) {
                /* renamed from: b */
                final /* synthetic */ C0099d f72b;

                /* renamed from: a */
                public void mo44a() {
                    onSharedElementsReadyListener.onSharedElementsReady();
                }
            });
        }
    }

    /* renamed from: a */
    public static void m130a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    /* renamed from: a */
    public static void m131a(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
        }
    }

    /* renamed from: a */
    public static void m129a(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    /* renamed from: a */
    public static void m132a(Activity activity, an anVar) {
        SharedElementCallback sharedElementCallback = null;
        if (VERSION.SDK_INT >= 23) {
            if (anVar != null) {
                sharedElementCallback = new C0099d(anVar);
            }
            activity.setEnterSharedElementCallback(sharedElementCallback);
        } else if (VERSION.SDK_INT >= 21) {
            if (anVar != null) {
                sharedElementCallback = new C0096c(anVar);
            }
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }
    }

    /* renamed from: b */
    public static void m136b(Activity activity, an anVar) {
        SharedElementCallback sharedElementCallback = null;
        if (VERSION.SDK_INT >= 23) {
            if (anVar != null) {
                sharedElementCallback = new C0099d(anVar);
            }
            activity.setExitSharedElementCallback(sharedElementCallback);
        } else if (VERSION.SDK_INT >= 21) {
            if (anVar != null) {
                sharedElementCallback = new C0096c(anVar);
            }
            activity.setExitSharedElementCallback(sharedElementCallback);
        }
    }

    /* renamed from: b */
    public static void m135b(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    /* renamed from: c */
    public static void m137c(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }

    /* renamed from: a */
    public static void m133a(final Activity activity, final String[] strArr, final int i) {
        if (VERSION.SDK_INT >= 23) {
            if (activity instanceof C0095b) {
                ((C0095b) activity).validateRequestPermissionsRequestCode(i);
            }
            activity.requestPermissions(strArr, i);
        } else if (activity instanceof C0094a) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i = 0; i < length; i++) {
                        iArr[i] = packageManager.checkPermission(strArr[i], packageName);
                    }
                    ((C0094a) activity).onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }

    /* renamed from: a */
    public static boolean m134a(Activity activity, String str) {
        if (VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }
}
