package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

public abstract class zzjq implements zzjo {
    protected abstract zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr);

    public final zzqp<?> zzb(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z;
        boolean z2 = true;
        Preconditions.checkArgument(zzia != null);
        if (zzqpArr != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        zzqp[] zzqpArr2 = new zzqp[zzqpArr.length];
        for (int i = 0; i < zzqpArr.length; i++) {
            boolean z3;
            if (zzqpArr[i] != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
            if (zzqpArr[i] != zzqv.zzbpo) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
            if (zzqpArr[i] != zzqv.zzbpp) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
            zzqpArr2[i] = zzrd.zza(zzia, zzqpArr[i]);
            if (zzqpArr2[i] != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
            if (zzqpArr2[i] != zzqv.zzbpo) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
            if (zzqpArr2[i] != zzqv.zzbpp) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
        }
        zzqp<?> zza = zza(zzia, zzqpArr2);
        if (zza == null) {
            z2 = false;
        }
        Preconditions.checkState(z2);
        return zza;
    }
}
