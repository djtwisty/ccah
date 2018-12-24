package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

public final class zzmd extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z;
        Preconditions.checkArgument(true);
        if (zzqpArr.length == 2) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        return new zzqt(Double.valueOf(zzjp.zza(zzqpArr[0], new zzqt(Double.valueOf(-1.0d * zzjp.zzb(zzqpArr[1]))))));
    }
}
