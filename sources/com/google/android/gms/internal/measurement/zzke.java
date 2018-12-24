package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzke extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z = true;
        Preconditions.checkNotNull(zzqpArr);
        if (zzqpArr.length != 1) {
            z = false;
        }
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzqw);
        zzqp zzqp = zzqv.zzbpr;
        List list = (List) ((zzqw) zzqpArr[0]).value();
        if (list.isEmpty()) {
            return zzqp;
        }
        return (zzqp) list.remove(0);
    }
}
