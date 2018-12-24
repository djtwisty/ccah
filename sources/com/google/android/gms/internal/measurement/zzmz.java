package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class zzmz extends zzjq {
    private final zzna zzbmq;

    public zzmz(zzna zzna) {
        this.zzbmq = zzna;
    }

    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkNotNull(zzqpArr);
        Preconditions.checkArgument(zzqpArr.length > 0);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzrb);
        String str = (String) ((zzrb) zzqpArr[0]).value();
        Map hashMap = new HashMap();
        if (zzqpArr.length >= 2 && zzqpArr[1] != zzqv.zzbpr) {
            Preconditions.checkArgument(zzqpArr[1] instanceof zzqz);
            for (Entry entry : ((Map) ((zzqz) zzqpArr[1]).value()).entrySet()) {
                boolean z;
                if (entry.getValue() instanceof zzra) {
                    z = false;
                } else {
                    z = true;
                }
                Preconditions.checkState(z);
                if (zzrd.zzm((zzqp) entry.getValue())) {
                    z = false;
                } else {
                    z = true;
                }
                Preconditions.checkState(z);
                hashMap.put((String) entry.getKey(), ((zzqp) entry.getValue()).value());
            }
        }
        return zzrd.zzr(this.zzbmq.zza(str, hashMap));
    }
}
