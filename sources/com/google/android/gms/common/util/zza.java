package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;
import com.google.firebase.analytics.FirebaseAnalytics.Param;

public final class zza {
    private static final IntentFilter filter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static long zzgu;
    private static float zzgv = Float.NaN;

    @TargetApi(20)
    public static int zzg(Context context) {
        int i = 1;
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        int i2;
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, filter);
        if (((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        boolean isInteractive;
        int i3;
        if (PlatformVersion.isAtLeastKitKatWatch()) {
            isInteractive = powerManager.isInteractive();
        } else {
            isInteractive = powerManager.isScreenOn();
        }
        if (isInteractive) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        if (i2 == 0) {
            i = 0;
        }
        return i3 | i;
    }

    public static synchronized float zzh(Context context) {
        float f;
        synchronized (zza.class) {
            if (SystemClock.elapsedRealtime() - zzgu >= 60000 || Float.isNaN(zzgv)) {
                Intent registerReceiver = context.getApplicationContext().registerReceiver(null, filter);
                if (registerReceiver != null) {
                    zzgv = ((float) registerReceiver.getIntExtra(Param.LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                }
                zzgu = SystemClock.elapsedRealtime();
                f = zzgv;
            } else {
                f = zzgv;
            }
        }
        return f;
    }
}
