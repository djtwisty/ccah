package com.yourvoice.ccApp.androidcomponent;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Calendar;

public class CheckConnectivityReciever extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (!intent.getBooleanExtra("noConnectivity", false) && !C0492j.m1272b(context, "username", "").equals("") && !C0492j.m1272b(context, "password", "").equals("")) {
            Calendar instance = Calendar.getInstance();
            ((AlarmManager) context.getSystemService("alarm")).setRepeating(0, instance.getTimeInMillis(), 600000, PendingIntent.getService(context, 0, new Intent(context, YVService.class), 0));
        }
    }
}
