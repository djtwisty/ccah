package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

public final class zzlx implements zzjo {
    public final zzqp<?> zzb(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z = true;
        int i = 0;
        Preconditions.checkArgument(zzqpArr != null);
        if (zzqpArr.length <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        int length = zzqpArr.length;
        while (i < length) {
            Object obj = zzqpArr[i];
            Preconditions.checkNotNull(obj);
            Preconditions.checkArgument(obj instanceof zzrb);
            zzia.zza((String) ((zzrb) obj).value(), zzqv.zzbpr);
            i++;
        }
        return zzqv.zzbpr;
    }
}
