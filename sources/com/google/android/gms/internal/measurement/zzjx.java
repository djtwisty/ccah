package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzjx extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        int i;
        Preconditions.checkNotNull(zzqpArr);
        boolean z = zzqpArr.length > 0 && zzqpArr.length <= 3;
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzqw);
        zzqw zzqw = (zzqw) zzqpArr[0];
        if (zzqpArr.length < 2) {
            zzqp zzqp = zzqv.zzbpr;
        } else {
            zzqp<?> zzqp2 = zzqpArr[1];
        }
        List list = (List) zzqw.value();
        int size = list.size();
        int i2 = size - 1;
        if (zzqpArr.length == 3) {
            i2 = (int) zzjp.zzc(zzqpArr[2]);
            if (i2 < 0) {
                i2 = size - Math.abs(i2);
            } else {
                i2 = Math.min(i2, size - 1);
            }
        }
        size = i2;
        while (size >= 0) {
            if (zzqw.zzaf(size) && zzjp.zzd(r3, (zzqp) list.get(size))) {
                i = size;
                break;
            }
            size--;
        }
        i = -1;
        return new zzqt(Double.valueOf((double) i));
    }
}
