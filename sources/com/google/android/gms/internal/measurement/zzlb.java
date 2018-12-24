package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

public final class zzlb implements zzjo {
    public final zzqp<?> zzb(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z;
        zzqp<?> zza;
        Preconditions.checkArgument(zzqpArr != null);
        if (zzqpArr.length == 3) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (zzjp.zza(zzrd.zza(zzia, zzqpArr[0]))) {
            zza = zzrd.zza(zzia, zzqpArr[1]);
        } else {
            zza = zzrd.zza(zzia, zzqpArr[2]);
        }
        if (!(zza instanceof zzqv) || zza == zzqv.zzbpr || zza == zzqv.zzbpq) {
            return zza;
        }
        throw new IllegalArgumentException("Illegal InternalType passed to Ternary.");
    }
}
