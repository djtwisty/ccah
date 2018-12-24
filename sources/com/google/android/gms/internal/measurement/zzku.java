package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

public final class zzku extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z = false;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzqpArr.length == 2);
        zzqp zzqp = zzqpArr[0];
        zzqp zzqp2 = zzqpArr[1];
        if ((zzqp instanceof zzqz) || (zzqp instanceof zzqw) || (zzqp instanceof zzqu)) {
            zzqp = new zzrb(zzjp.zzd(zzqp));
        }
        zzqp zzrb;
        if ((zzqp2 instanceof zzqz) || (zzqp2 instanceof zzqw) || (zzqp2 instanceof zzqu)) {
            zzrb = new zzrb(zzjp.zzd(zzqp2));
        } else {
            zzrb = zzqp2;
        }
        if ((((zzqp instanceof zzrb) && (r3 instanceof zzrb)) || !(Double.isNaN(zzjp.zzb(zzqp)) || Double.isNaN(zzjp.zzb(r3)))) && !zzjp.zzb(r3, zzqp)) {
            z = true;
        }
        return new zzqs(Boolean.valueOf(z));
    }
}
