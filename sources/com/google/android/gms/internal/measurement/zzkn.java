package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

public final class zzkn implements zzjo {
    public final zzqp<?> zzb(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z;
        Preconditions.checkArgument(zzqpArr != null);
        if (zzqpArr.length == 2) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        zzqp<?> zza = zzrd.zza(zzia, zzqpArr[0]);
        return !zzjp.zza(zza) ? zza : zzrd.zza(zzia, zzqpArr[1]);
    }
}
