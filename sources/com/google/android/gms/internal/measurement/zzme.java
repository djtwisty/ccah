package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

public final class zzme extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        int zzc;
        Preconditions.checkArgument(true);
        boolean z = zzqpArr.length == 1 || zzqpArr.length == 2;
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzrb);
        String str = (String) ((zzrb) zzqpArr[0]).value();
        if (zzqpArr.length == 2) {
            zzc = (int) zzjp.zzc(zzqpArr[1]);
        } else {
            zzc = 0;
        }
        if (zzc < 0 || zzc >= str.length()) {
            return new zzrb("");
        }
        return new zzrb(String.valueOf(str.charAt(zzc)));
    }
}
