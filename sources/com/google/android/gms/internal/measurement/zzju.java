package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzju extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkNotNull(zzqpArr);
        Preconditions.checkArgument(zzqpArr.length == 2);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzqw);
        Preconditions.checkArgument(zzqpArr[1] instanceof zzqu);
        zzqw zzqw = (zzqw) zzqpArr[0];
        zzqu zzqu = (zzqu) zzqpArr[1];
        int size = ((List) zzqw.value()).size();
        int i = 0;
        while (i < size && i < ((List) zzqw.value()).size()) {
            if (zzqw.zzaf(i)) {
                ((zzjo) zzqu.value()).zzb(zzia, (zzqp) r2.get(i), new zzqt(Double.valueOf((double) i)), zzqw);
            }
            i++;
        }
        return zzqv.zzbpr;
    }
}
