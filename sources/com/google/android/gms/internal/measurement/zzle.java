package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

public final class zzle extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzqpArr.length == 2);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzrb);
        String str = (String) ((zzrb) zzqpArr[0]).value();
        if (zzia.has(str)) {
            zzia.zzb(str, zzqpArr[1]);
            return zzqpArr[1];
        }
        String str2 = "Attempting to assign to undefined variable ";
        str = String.valueOf(str);
        throw new IllegalStateException(str.length() != 0 ? str2.concat(str) : new String(str2));
    }
}
