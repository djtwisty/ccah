package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

public final class zzlz extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z;
        Preconditions.checkArgument(true);
        if (zzqpArr.length == 2) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        zzqp zzqp = zzqpArr[0];
        zzqp zzqp2 = zzqpArr[1];
        if ((!(zzqp instanceof zzqv) || zzqp == zzqv.zzbpr || zzqp == zzqv.zzbpq) && (!(zzqp2 instanceof zzqv) || zzqp2 == zzqv.zzbpr || zzqp2 == zzqv.zzbpq)) {
            zzqp zzrb;
            if ((zzqp instanceof zzqz) || (zzqp instanceof zzqw) || (zzqp instanceof zzqu)) {
                zzqp = new zzrb(zzjp.zzd(zzqp));
            }
            if ((zzqp2 instanceof zzqz) || (zzqp2 instanceof zzqw) || (zzqp2 instanceof zzqu)) {
                zzrb = new zzrb(zzjp.zzd(zzqp2));
            } else {
                zzrb = zzqp2;
            }
            if (!(zzqp instanceof zzrb) && !(zzrb instanceof zzrb)) {
                return new zzqt(Double.valueOf(zzjp.zza(zzqp, zzrb)));
            }
            String valueOf = String.valueOf(zzjp.zzd(zzqp));
            String valueOf2 = String.valueOf(zzjp.zzd(zzrb));
            return new zzrb(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        }
        throw new IllegalArgumentException("Illegal InternalType passed to Add.");
    }
}
