package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.List;

public final class zzll extends zzjq {
    public final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkNotNull(zzqpArr);
        Preconditions.checkArgument(zzqpArr.length == 3);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzrb);
        String str = (String) ((zzrb) zzqpArr[0]).value();
        Preconditions.checkArgument(zzia.has(str));
        zzqp zzqp = zzqpArr[1];
        Preconditions.checkNotNull(zzqp);
        zzqp<?> zzqp2 = zzqpArr[2];
        Preconditions.checkArgument(zzqp2 instanceof zzqw);
        List list = (List) ((zzqw) zzqp2).value();
        Iterator zzst = zzqp.zzst();
        while (zzst.hasNext()) {
            zzia.zzb(str, (zzqp) zzst.next());
            zzqp = zzrd.zza(zzia, list);
            if (zzqp == zzqv.zzbpo) {
                return zzqv.zzbpr;
            }
            if (zzqp.zzsv()) {
                return zzqp;
            }
        }
        return zzqv.zzbpr;
    }
}
