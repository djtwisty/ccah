package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class zzkl extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkNotNull(zzqpArr);
        Preconditions.checkArgument(zzqpArr.length >= 3);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzqw);
        zzqw zzqw = (zzqw) zzqpArr[0];
        int zzc = (int) zzjp.zzc(zzqpArr[1]);
        if (zzc < 0) {
            zzc = Math.max(((List) zzqw.value()).size() + zzc, 0);
        } else {
            zzc = Math.min(zzc, ((List) zzqw.value()).size());
        }
        int min = zzc + Math.min(Math.max((int) zzjp.zzc(zzqpArr[2]), 0), ((List) zzqw.value()).size() - zzc);
        List arrayList = new ArrayList(((List) zzqw.value()).subList(zzc, min));
        ((List) zzqw.value()).subList(zzc, min).clear();
        Collection arrayList2 = new ArrayList();
        for (int i = 3; i < zzqpArr.length; i++) {
            arrayList2.add(zzqpArr[i]);
        }
        ((List) zzqw.value()).addAll(zzc, arrayList2);
        return new zzqw(arrayList);
    }
}
