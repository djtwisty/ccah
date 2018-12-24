package com.google.android.gms.internal.measurement;

import android.os.Build.VERSION;

final class zzgv {
    public static int version() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException e) {
            String str = "Invalid version number: ";
            String valueOf = String.valueOf(VERSION.SDK);
            zzhk.m1081e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            return 0;
        }
    }
}
