package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

public final class zzmf extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        int i = 1;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzqpArr.length > 0);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzrb);
        StringBuilder stringBuilder = new StringBuilder((String) ((zzrb) zzqpArr[0]).value());
        while (i < zzqpArr.length) {
            stringBuilder.append(zzjp.zzd(zzqpArr[i]));
            i++;
        }
        return new zzrb(stringBuilder.toString());
    }
}
