package android.support.v4.p012a;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.p012a.ae.C0109a;
import android.widget.RemoteViews;
import java.util.ArrayList;

/* renamed from: android.support.v4.a.aa */
class aa {

    /* renamed from: android.support.v4.a.aa$a */
    public static class C0104a implements C0102x, C0103y {
        /* renamed from: a */
        private Builder f74a;
        /* renamed from: b */
        private Bundle f75b;
        /* renamed from: c */
        private RemoteViews f76c;
        /* renamed from: d */
        private RemoteViews f77d;
        /* renamed from: e */
        private int f78e;

        public C0104a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3, int i5) {
            this.f74a = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str).setGroupSummary(z5).setSortKey(str2);
            this.f75b = new Bundle();
            if (bundle != null) {
                this.f75b.putAll(bundle);
            }
            if (!(arrayList == null || arrayList.isEmpty())) {
                this.f75b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            this.f76c = remoteViews2;
            this.f77d = remoteViews3;
            this.f78e = i5;
        }

        /* renamed from: a */
        public void mo46a(C0109a c0109a) {
            aa.m145a(this.f74a, c0109a);
        }

        /* renamed from: a */
        public Builder mo45a() {
            return this.f74a;
        }

        /* renamed from: b */
        public Notification mo47b() {
            this.f74a.setExtras(this.f75b);
            Notification build = this.f74a.build();
            if (this.f76c != null) {
                build.contentView = this.f76c;
            }
            if (this.f77d != null) {
                build.bigContentView = this.f77d;
            }
            if (this.f78e != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.f78e != 2)) {
                    m141a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f78e == 1) {
                    m141a(build);
                }
            }
            return build;
        }

        /* renamed from: a */
        private void m141a(Notification notification) {
            notification.sound = null;
            notification.vibrate = null;
            notification.defaults &= -2;
            notification.defaults &= -3;
        }
    }

    /* renamed from: a */
    public static void m145a(Builder builder, C0109a c0109a) {
        Bundle bundle;
        Action.Builder builder2 = new Action.Builder(c0109a.mo105a(), c0109a.mo106b(), c0109a.mo107c());
        if (c0109a.mo111i() != null) {
            for (RemoteInput addRemoteInput : ak.m191a(c0109a.mo111i())) {
                builder2.addRemoteInput(addRemoteInput);
            }
        }
        if (c0109a.mo108d() != null) {
            bundle = new Bundle(c0109a.mo108d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", c0109a.mo109e());
        builder2.addExtras(bundle);
        builder.addAction(builder2.build());
    }
}
