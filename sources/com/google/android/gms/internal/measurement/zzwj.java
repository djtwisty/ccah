package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo.zze;

final class zzwj implements zzvt {
    private final int flags;
    private final String info;
    private final Object[] zzcar;
    private final zzvv zzcau;

    zzwj(zzvv zzvv, String str, Object[] objArr) {
        this.zzcau = zzvv;
        this.info = str;
        this.zzcar = objArr;
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

    final String zzxv() {
        return this.info;
    }

    final Object[] zzxw() {
        return this.zzcar;
    }

    public final zzvv zzxo() {
        return this.zzcau;
    }

    public final int zzxm() {
        return (this.flags & 1) == 1 ? zze.zzbys : zze.zzbyt;
    }

    public final boolean zzxn() {
        return (this.flags & 2) == 2;
    }
}
