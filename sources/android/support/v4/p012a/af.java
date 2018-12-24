package android.support.v4.p012a;

import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.p012a.ae.C0109a;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.a.af */
class af {
    /* renamed from: a */
    private static final Object f93a = new Object();
    /* renamed from: b */
    private static Field f94b;
    /* renamed from: c */
    private static boolean f95c;
    /* renamed from: d */
    private static final Object f96d = new Object();

    /* renamed from: android.support.v4.a.af$a */
    public static class C0110a implements C0102x, C0103y {
        /* renamed from: a */
        private Builder f88a;
        /* renamed from: b */
        private final Bundle f89b;
        /* renamed from: c */
        private List<Bundle> f90c = new ArrayList();
        /* renamed from: d */
        private RemoteViews f91d;
        /* renamed from: e */
        private RemoteViews f92e;

        public C0110a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            this.f88a = new Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
            this.f89b = new Bundle();
            if (bundle != null) {
                this.f89b.putAll(bundle);
            }
            if (z3) {
                this.f89b.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.f89b.putString("android.support.groupKey", str);
                if (z4) {
                    this.f89b.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.f89b.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str2 != null) {
                this.f89b.putString("android.support.sortKey", str2);
            }
            this.f91d = remoteViews2;
            this.f92e = remoteViews3;
        }

        /* renamed from: a */
        public void mo46a(C0109a c0109a) {
            this.f90c.add(af.m168a(this.f88a, c0109a));
        }

        /* renamed from: a */
        public Builder mo45a() {
            return this.f88a;
        }

        /* renamed from: b */
        public Notification mo47b() {
            Notification build = this.f88a.build();
            Bundle a = af.m169a(build);
            Bundle bundle = new Bundle(this.f89b);
            for (String str : this.f89b.keySet()) {
                if (a.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a.putAll(bundle);
            SparseArray a2 = af.m170a(this.f90c);
            if (a2 != null) {
                af.m169a(build).putSparseParcelableArray("android.support.actionExtras", a2);
            }
            if (this.f91d != null) {
                build.contentView = this.f91d;
            }
            if (this.f92e != null) {
                build.bigContentView = this.f92e;
            }
            return build;
        }
    }

    /* renamed from: a */
    public static void m171a(C0103y c0103y, CharSequence charSequence, boolean z, CharSequence charSequence2, CharSequence charSequence3) {
        BigTextStyle bigText = new BigTextStyle(c0103y.mo45a()).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z) {
            bigText.setSummaryText(charSequence2);
        }
    }

    /* renamed from: a */
    public static SparseArray<Bundle> m170a(List<Bundle> list) {
        SparseArray<Bundle> sparseArray = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    /* renamed from: a */
    public static Bundle m169a(Notification notification) {
        synchronized (f93a) {
            if (f95c) {
                return null;
            }
            try {
                if (f94b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (Bundle.class.isAssignableFrom(declaredField.getType())) {
                        declaredField.setAccessible(true);
                        f94b = declaredField;
                    } else {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f95c = true;
                        return null;
                    }
                }
                Bundle bundle = (Bundle) f94b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f94b.set(notification, bundle);
                }
                return bundle;
            } catch (Throwable e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                f95c = true;
                return null;
            } catch (Throwable e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f95c = true;
                return null;
            }
        }
    }

    /* renamed from: a */
    public static Bundle m168a(Builder builder, C0109a c0109a) {
        builder.addAction(c0109a.mo105a(), c0109a.mo106b(), c0109a.mo107c());
        Bundle bundle = new Bundle(c0109a.mo108d());
        if (c0109a.mo111i() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", am.m193a(c0109a.mo111i()));
        }
        if (c0109a.mo110h() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", am.m193a(c0109a.mo110h()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", c0109a.mo109e());
        return bundle;
    }
}
