package org.apache.cordova.firebase;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class OnNotificationOpenReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        launchIntentForPackage.addFlags(335544320);
        Bundle extras = intent.getExtras();
        extras.putBoolean("tap", true);
        FirebasePlugin.sendNotification(extras);
        launchIntentForPackage.putExtras(extras);
        context.startActivity(launchIntentForPackage);
    }
}
