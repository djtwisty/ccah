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
import java.util.Iterator;

/* renamed from: android.support.v4.a.ac */
class ac {

    /* renamed from: android.support.v4.a.ac$a */
    public static class C0106a implements C0102x, C0103y {
        /* renamed from: a */
        private Builder f85a;
        /* renamed from: b */
        private int f86b;

        public C0106a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, String str, ArrayList<String> arrayList, Bundle bundle, int i5, int i6, Notification notification2, String str2, boolean z5, String str3, CharSequence[] charSequenceArr, RemoteViews remoteViews2, RemoteViews remoteViews3, RemoteViews remoteViews4, int i7) {
            this.f85a = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setExtras(bundle).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i5).setVisibility(i6).setPublicVersion(notification2).setRemoteInputHistory(charSequenceArr);
            if (remoteViews2 != null) {
                this.f85a.setCustomContentView(remoteViews2);
            }
            if (remoteViews3 != null) {
                this.f85a.setCustomBigContentView(remoteViews3);
            }
            if (remoteViews4 != null) {
                this.f85a.setCustomHeadsUpContentView(remoteViews4);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f85a.addPerson((String) it.next());
            }
            this.f86b = i7;
        }

        /* renamed from: a */
        public void mo46a(C0109a c0109a) {
            ac.m154a(this.f85a, c0109a);
        }

        /* renamed from: a */
        public Builder mo45a() {
            return this.f85a;
        }

        /* renamed from: b */
        public Notification mo47b() {
            Notification build = this.f85a.build();
            if (this.f86b != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.f86b != 2)) {
                    m150a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f86b == 1) {
                    m150a(build);
                }
            }
            return build;
        }

        /* renamed from: a */
        private void m150a(Notification notification) {
            notification.sound = null;
            notification.vibrate = null;
            notification.defaults &= -2;
            notification.defaults &= -3;
        }
    }

    /* renamed from: a */
    public static void m154a(Builder builder, C0109a c0109a) {
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
        builder2.setAllowGeneratedReplies(c0109a.mo109e());
        builder2.addExtras(bundle);
        builder.addAction(builder2.build());
    }
}
