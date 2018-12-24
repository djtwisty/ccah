package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzka extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        int i = 1;
        Preconditions.checkNotNull(zzqpArr);
        Preconditions.checkArgument(zzqpArr.length > 0);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzqw);
        zzqw zzqw = (zzqw) zzqpArr[0];
        int size = ((List) zzqw.value()).size();
        zzqw.setSize((zzqpArr.length + size) - 1);
        while (i < zzqpArr.length) {
            zzqw.zza(size, zzqpArr[i]);
            size++;
            i++;
        }
        return new zzqt(Double.valueOf((double) size));
    }
}
