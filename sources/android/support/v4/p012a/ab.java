package android.support.v4.p012a;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.p012a.ae.C0109a;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v4.a.ab */
class ab {

    /* renamed from: android.support.v4.a.ab$a */
    public static class C0105a implements C0102x, C0103y {
        /* renamed from: a */
        private Builder f79a;
        /* renamed from: b */
        private Bundle f80b;
        /* renamed from: c */
        private RemoteViews f81c;
        /* renamed from: d */
        private RemoteViews f82d;
        /* renamed from: e */
        private RemoteViews f83e;
        /* renamed from: f */
        private int f84f;

        public C0105a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, String str, ArrayList<String> arrayList, Bundle bundle, int i5, int i6, Notification notification2, String str2, boolean z5, String str3, RemoteViews remoteViews2, RemoteViews remoteViews3, RemoteViews remoteViews4, int i7) {
            this.f79a = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i5).setVisibility(i6).setPublicVersion(notification2);
            this.f80b = new Bundle();
            if (bundle != null) {
                this.f80b.putAll(bundle);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f79a.addPerson((String) it.next());
            }
            this.f81c = remoteViews2;
            this.f82d = remoteViews3;
            this.f83e = remoteViews4;
            this.f84f = i7;
        }

        /* renamed from: a */
        public void mo46a(C0109a c0109a) {
            aa.m145a(this.f79a, c0109a);
        }

        /* renamed from: a */
        public Builder mo45a() {
            return this.f79a;
        }

        /* renamed from: b */
        public Notification mo47b() {
            this.f79a.setExtras(this.f80b);
            Notification build = this.f79a.build();
            if (this.f81c != null) {
                build.contentView = this.f81c;
            }
            if (this.f82d != null) {
                build.bigContentView = this.f82d;
            }
            if (this.f83e != null) {
                build.headsUpContentView = this.f83e;
            }
            if (this.f84f != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.f84f != 2)) {
                    m146a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f84f == 1) {
                    m146a(build);
                }
            }
            return build;
        }

        /* renamed from: a */
        private void m146a(Notification notification) {
            notification.sound = null;
            notification.vibrate = null;
            notification.defaults &= -2;
            notification.defaults &= -3;
        }
    }
}
