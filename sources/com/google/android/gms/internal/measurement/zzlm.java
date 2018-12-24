package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

public final class zzlm implements zzjo {
    public final zzqp<?> zzb(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z = true;
        Preconditions.checkArgument(zzqpArr != null);
        if (zzqpArr.length != 1) {
            z = false;
        }
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzrb);
        zzqp<?> zzeq = zzia.zzeq((String) ((zzrb) zzqpArr[0]).value());
        if (zzeq instanceof zzra) {
            throw new IllegalStateException("Illegal Statement type encountered in Get.");
        } else if (!(zzeq instanceof zzqv) || zzeq == zzqv.zzbpr || zzeq == zzqv.zzbpq) {
            return zzeq;
        } else {
            throw new IllegalStateException("Illegal InternalType encountered in Get.");
        }
    }
}
