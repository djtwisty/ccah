package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

public final class zzmn extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkArgument(true);
        boolean z = zzqpArr.length > 0 && zzqpArr.length <= 3;
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzrb);
        String str = (String) ((zzrb) zzqpArr[0]).value();
        int zzc = (int) zzjp.zzc(zzqpArr.length < 2 ? zzqv.zzbpr : zzqpArr[1]);
        int length = str.length();
        if (zzqpArr.length == 3 && zzqpArr[2] != zzqv.zzbpr) {
            length = (int) zzjp.zzc(zzrd.zza(zzia, zzqpArr[2]));
        }
        zzc = Math.min(Math.max(zzc, 0), str.length());
        length = Math.min(Math.max(length, 0), str.length());
        return new zzrb(str.substring(Math.min(zzc, length), Math.max(zzc, length)));
    }
}
