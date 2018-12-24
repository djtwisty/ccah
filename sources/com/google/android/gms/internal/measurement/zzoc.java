package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;

public final class zzoc extends zzjq {
    private final zzhy zzbms;
    private final Context zzri;

    public zzoc(Context context, zzhy zzhy) {
        this.zzri = context;
        this.zzbms = zzhy;
    }

    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzqpArr.length > 0);
        Object obj = this.zzbms.zzrh().zzop().get(zzjp.zzd(zzqpArr[0]));
        if (obj == null && zzqpArr.length > 1) {
            obj = zzqpArr[1];
        }
        return zzrd.zzr(obj);
    }
}
