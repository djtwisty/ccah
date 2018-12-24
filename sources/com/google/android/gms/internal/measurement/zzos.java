package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

public abstract class zzos extends zzjq {
    protected abstract boolean zza(double d, double d2);

    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z = true;
        Preconditions.checkArgument(true);
        if (zzqpArr.length != 2) {
            z = false;
        }
        Preconditions.checkArgument(z);
        try {
            double zzb = zzjp.zzb(zzqpArr[0]);
            double zzb2 = zzjp.zzb(zzqpArr[1]);
            if (Double.isNaN(zzb) || Double.isNaN(zzb2)) {
                return new zzqs(Boolean.valueOf(false));
            }
            return new zzqs(Boolean.valueOf(zza(zzb, zzb2)));
        } catch (IllegalArgumentException e) {
            return new zzqs(Boolean.valueOf(false));
        }
    }
}
