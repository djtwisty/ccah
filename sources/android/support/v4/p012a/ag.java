package android.support.v4.p012a;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.p012a.ae.C0109a;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.a.ag */
class ag {

    /* renamed from: android.support.v4.a.ag$a */
    public static class C0111a implements C0102x, C0103y {
        /* renamed from: a */
        private Builder f97a;
        /* renamed from: b */
        private Bundle f98b;
        /* renamed from: c */
        private List<Bundle> f99c = new ArrayList();
        /* renamed from: d */
        private RemoteViews f100d;
        /* renamed from: e */
        private RemoteViews f101e;

        public C0111a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            this.f97a = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z);
            this.f98b = new Bundle();
            if (bundle != null) {
                this.f98b.putAll(bundle);
            }
            if (!(arrayList == null || arrayList.isEmpty())) {
                this.f98b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            if (z4) {
                this.f98b.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.f98b.putString("android.support.groupKey", str);
                if (z5) {
                    this.f98b.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.f98b.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str2 != null) {
                this.f98b.putString("android.support.sortKey", str2);
            }
            this.f100d = remoteViews2;
            this.f101e = remoteViews3;
        }

        /* renamed from: a */
        public void mo46a(C0109a c0109a) {
            this.f99c.add(af.m168a(this.f97a, c0109a));
        }

        /* renamed from: a */
        public Builder mo45a() {
            return this.f97a;
        }

        /* renamed from: b */
        public Notification mo47b() {
            SparseArray a = af.m170a(this.f99c);
            if (a != null) {
                this.f98b.putSparseParcelableArray("android.support.actionExtras", a);
            }
            this.f97a.setExtras(this.f98b);
            Notification build = this.f97a.build();
            if (this.f100d != null) {
                build.contentView = this.f100d;
            }
            if (this.f101e != null) {
                build.bigContentView = this.f101e;
            }
            return build;
        }
    }
}
