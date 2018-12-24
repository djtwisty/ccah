package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

public final class zzlt extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z = true;
        Preconditions.checkArgument(true);
        if (zzqpArr.length > 1) {
            z = false;
        }
        Preconditions.checkArgument(z);
        return new zzqv(zzqpArr.length <= 0 ? zzqv.zzbpr : zzqpArr[0]);
    }
}
