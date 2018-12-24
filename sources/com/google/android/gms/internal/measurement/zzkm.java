package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class zzkm extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        int i = 1;
        Preconditions.checkNotNull(zzqpArr);
        Preconditions.checkArgument(zzqpArr.length > 0);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzqw);
        zzqw zzqw = (zzqw) zzqpArr[0];
        Collection arrayList = new ArrayList();
        while (i < zzqpArr.length) {
            arrayList.add(zzqpArr[i]);
            i++;
        }
        ((List) zzqw.value()).addAll(0, arrayList);
        return new zzqt(Double.valueOf((double) ((List) zzqw.value()).size()));
    }
}
