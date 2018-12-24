package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.zza;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
public class WakeLockTracker {
    private static WakeLockTracker zzgb = new WakeLockTracker();
    private static Boolean zzgc;
    @VisibleForTesting
    private static boolean zzgd = false;

    @KeepForSdk
    public static WakeLockTracker getInstance() {
        return zzgb;
    }

    @KeepForSdk
    public void registerAcquireEvent(Context context, Intent intent, String str, String str2, String str3, int i, String str4) {
        List asList = Arrays.asList(new String[]{str4});
        registerEvent(context, intent.getStringExtra(LoggingConstants.EXTRA_WAKE_LOCK_KEY), 7, str, str2, str3, i, asList);
    }

    @KeepForSdk
    public void registerReleaseEvent(Context context, Intent intent) {
        registerEvent(context, intent.getStringExtra(LoggingConstants.EXTRA_WAKE_LOCK_KEY), 8, null, null, null, 0, null);
    }

    @KeepForSdk
    public void registerEvent(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list) {
        registerEvent(context, str, i, str2, str3, str4, i2, list, 0);
    }

    @KeepForSdk
    public void registerEvent(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list, long j) {
        if (zzgc == null) {
            zzgc = Boolean.valueOf(false);
        }
        if (!zzgc.booleanValue()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            String str5 = "WakeLockTracker";
            String str6 = "missing wakeLock key. ";
            String valueOf = String.valueOf(str);
            Log.e(str5, valueOf.length() != 0 ? str6.concat(valueOf) : new String(str6));
        } else if (7 == i || 8 == i || 10 == i || 11 == i) {
            List list2;
            long currentTimeMillis = System.currentTimeMillis();
            if (list == null || list.size() != 1) {
                List<String> list3 = list;
            } else {
                if ("com.google.android.gms".equals(list.get(0))) {
                    list = null;
                }
                list2 = list;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int zzg = zza.zzg(context);
            String packageName = context.getPackageName();
            if ("com.google.android.gms".equals(packageName)) {
                packageName = null;
            }
            try {
                context.startService(new Intent().setComponent(LoggingConstants.zzfg).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", new WakeLockEvent(currentTimeMillis, i, str2, i2, list2, str, elapsedRealtime, zzg, str3, packageName, zza.zzh(context), j, str4)));
            } catch (Throwable e) {
                Log.wtf("WakeLockTracker", e);
            }
        }
    }
}
