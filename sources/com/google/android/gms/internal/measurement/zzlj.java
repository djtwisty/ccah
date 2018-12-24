package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.Map;

public final class zzlj extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkArgument(true);
        Map hashMap = new HashMap();
        int i = 0;
        while (i < zzqpArr.length - 1) {
            String zzd = zzjp.zzd(zzqpArr[i]);
            zzqv zzqv = zzqpArr[i + 1];
            if (!(zzqv instanceof zzqv) || zzqv == zzqv.zzbpq || zzqv == zzqv.zzbpr) {
                hashMap.put(zzd, zzqv);
                i += 2;
            } else {
                throw new IllegalStateException("Illegal InternalType found in CreateObject.");
            }
        }
        return new zzqz(hashMap);
    }
}
