package org.apache.cordova.firebase;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p012a.C0203z.C0191b;
import android.support.v4.p012a.C0203z.C0192c;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Map;
import java.util.Random;

public class FirebasePluginMessagingService extends FirebaseMessagingService {
    private static final String TAG = "FirebasePlugin";

    public void onMessageReceived(RemoteMessage remoteMessage) {
        Object title;
        Object body;
        String num;
        if (remoteMessage.getNotification() != null) {
            title = remoteMessage.getNotification().getTitle();
            body = remoteMessage.getNotification().getBody();
            CharSequence messageId = remoteMessage.getMessageId();
        } else {
            String str = (String) remoteMessage.getData().get("id");
            String str2 = (String) remoteMessage.getData().get("text");
            String str3 = (String) remoteMessage.getData().get("title");
        }
        if (TextUtils.isEmpty(messageId)) {
            num = Integer.toString(new Random().nextInt(50) + 1);
        } else {
            CharSequence charSequence = messageId;
        }
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message id: " + num);
        Log.d(TAG, "Notification Message Title: " + title);
        Log.d(TAG, "Notification Message Body/Text: " + body);
        if (!TextUtils.isEmpty(body) || !TextUtils.isEmpty(title) || !remoteMessage.getData().isEmpty()) {
            boolean z = (FirebasePlugin.inBackground() || !FirebasePlugin.hasNotificationsCallback()) && !(TextUtils.isEmpty(body) && TextUtils.isEmpty(title));
            sendNotification(num, title, body, remoteMessage.getData(), z);
        }
    }

    private void sendNotification(String str, String str2, String str3, Map<String, String> map, boolean z) {
        Bundle bundle = new Bundle();
        for (String str4 : map.keySet()) {
            bundle.putString(str4, (String) map.get(str4));
        }
        if (z) {
            Intent intent = new Intent(this, OnNotificationOpenReceiver.class);
            intent.putExtras(bundle);
            C0192c a = new C0192c(this).m600a((CharSequence) str2).m605b((CharSequence) str3).m610d(1).m599a(new C0191b().m588a((CharSequence) str3)).m602a(true).m598a(RingtoneManager.getDefaultUri(2)).m597a(PendingIntent.getBroadcast(this, str.hashCode(), intent, 134217728));
            int identifier = getResources().getIdentifier("notification_icon", "drawable", getPackageName());
            if (identifier != 0) {
                a.m594a(identifier);
            } else {
                a.m594a(getApplicationInfo().icon);
            }
            if (VERSION.SDK_INT >= 23) {
                a.m608c(getResources().getColor(getResources().getIdentifier("accent", "color", getPackageName()), null));
            }
            Notification a2 = a.m593a();
            if (VERSION.SDK_INT >= 21) {
                int identifier2 = getResources().getIdentifier("notification_big", "drawable", getPackageName());
                if (a2.contentView != null) {
                    a2.contentView.setImageViewResource(16908294, identifier2);
                }
            }
            ((NotificationManager) getSystemService("notification")).notify(str.hashCode(), a2);
            return;
        }
        bundle.putBoolean("tap", false);
        bundle.putString("title", str2);
        bundle.putString("body", str3);
        FirebasePlugin.sendNotification(bundle);
    }
}
