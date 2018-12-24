package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzjt extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkNotNull(zzqpArr);
        Preconditions.checkArgument(zzqpArr.length == 2);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzqw);
        Preconditions.checkArgument(zzqpArr[1] instanceof zzqu);
        zzqw zzqw = (zzqw) zzqpArr[0];
        zzqu zzqu = (zzqu) zzqpArr[1];
        List list = (List) zzqw.value();
        int size = list.size();
        List arrayList = new ArrayList();
        int i = 0;
        while (i < size && i < ((List) zzqw.value()).size()) {
            if (zzqw.zzaf(i)) {
                if (zzjp.zza(((zzjo) zzqu.value()).zzb(zzia, (zzqp) list.get(i), new zzqt(Double.valueOf((double) i)), zzqw))) {
                    arrayList.add((zzqp) list.get(i));
                }
            }
            i++;
        }
        return new zzqw(arrayList);
    }
}
