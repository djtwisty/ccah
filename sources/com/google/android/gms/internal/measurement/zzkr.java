package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

public final class zzkr extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z;
        Preconditions.checkArgument(true);
        if (zzqpArr.length == 2) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        return new zzqs(Boolean.valueOf(zzjp.zzd(zzqpArr[1], zzqpArr[0])));
    }
}
