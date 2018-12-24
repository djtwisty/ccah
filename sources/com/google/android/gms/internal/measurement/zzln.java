package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

public final class zzln implements zzjo {
    private static zzhu zzbij;

    public zzln(zzhu zzhu) {
        zzbij = zzhu;
    }

    public final zzqp<?> zzb(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z;
        boolean z2 = true;
        if (zzqpArr != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (zzqpArr.length != 1) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzrb);
        return zzbij.zzen((String) ((zzrb) zzqpArr[0]).value());
    }
}
