package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

public final class zzkx extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z;
        boolean z2 = true;
        Preconditions.checkArgument(true);
        if (zzqpArr.length == 2) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (zzjp.zzc(zzqpArr[1], zzqpArr[0])) {
            z2 = false;
        }
        return new zzqs(Boolean.valueOf(z2));
    }
}
