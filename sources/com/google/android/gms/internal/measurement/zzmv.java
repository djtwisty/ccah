package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.io.UnsupportedEncodingException;

public final class zzmv extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkArgument(true);
        try {
            return new zzrb(zzmu.decode(zzjp.zzd(zzqpArr.length > 0 ? (zzqp) Preconditions.checkNotNull(zzqpArr[0]) : zzqv.zzbpr), ""));
        } catch (UnsupportedEncodingException e) {
            return zzqv.zzbpr;
        }
    }
}
