package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft.zze;

final class zzhq implements zzha {
    private final int flags;
    private final String info;
    private final Object[] zzzm;
    private final zzhc zzzp;

    zzhq(zzhc zzhc, String str, Object[] objArr) {
        this.zzzp = zzhc;
        this.info = str;
        this.zzzm = objArr;
        int i = 1;
        char charAt = str.charAt(0);
        if (charAt < '?') {
            this.flags = charAt;
            return;
        }
        int i2 = charAt & 8191;
        int i3 = 13;
        while (true) {
            int i4 = i + 1;
            char charAt2 = str.charAt(i);
            if (charAt2 >= '?') {
                i2 |= (charAt2 & 8191) << i3;
                i3 += 13;
                i = i4;
            } else {
                this.flags = (charAt2 << i3) | i2;
                return;
            }
        }
    }

    final String zziw() {
        return this.info;
    }

    final Object[] zzix() {
        return this.zzzm;
    }

    public final zzhc zzip() {
        return this.zzzp;
    }

    public final int zzin() {
        return (this.flags & 1) == 1 ? zze.zzxn : zze.zzxo;
    }

    public final boolean zzio() {
        return (this.flags & 2) == 2;
    }
}
