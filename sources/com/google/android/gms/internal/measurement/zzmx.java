package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.io.UnsupportedEncodingException;

public final class zzmx extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkArgument(true);
        try {
            return new zzrb(zzmw.encode(zzjp.zzd(zzqpArr.length > 0 ? (zzqp) Preconditions.checkNotNull(zzqpArr[0]) : zzqv.zzbpr), "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_.!~*'()"));
        } catch (UnsupportedEncodingException e) {
            return zzqv.zzbpr;
        }
    }
}
