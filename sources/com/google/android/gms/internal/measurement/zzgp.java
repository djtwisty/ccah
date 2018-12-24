package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.util.CrashUtils;

final class zzgp {
    public static void zza(String str, Context context) {
        zzhk.m1081e(str);
        if (CrashUtils.addDynamiteErrorToDropBox(context, new RuntimeException(str))) {
            zzhk.m1082v("Crash reported successfully.");
        } else {
            zzhk.m1082v("Failed to report crash");
        }
    }

    public static void zzb(String str, Context context) {
        zzhk.zzab(str);
        if (CrashUtils.addDynamiteErrorToDropBox(context, new RuntimeException(str))) {
            zzhk.m1082v("Crash reported successfully.");
        } else {
            zzhk.m1082v("Failed to report crash");
        }
    }

    public static void zza(String str, Throwable th, Context context) {
        zzhk.zza(str, th);
        if (CrashUtils.addDynamiteErrorToDropBox(context, th)) {
            zzhk.m1082v("Crash reported successfully.");
        } else {
            zzhk.m1082v("Failed to report crash");
        }
    }
}
