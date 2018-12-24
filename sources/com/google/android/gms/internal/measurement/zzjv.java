package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzjv extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        int zzc;
        int i;
        int i2 = 0;
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
        if (zzqpArr.length < 3) {
            zzqp zzqp3 = zzqv.zzbpr;
        } else {
            zzqp<?> zzqp4 = zzqpArr[2];
        }
        List list = (List) zzqw.value();
        int size = list.size();
        if (zzqp3 != zzqv.zzbpr) {
            zzc = (int) zzjp.zzc(zzqp3);
            if (zzc < 0) {
                i2 = Math.max(size - Math.abs(zzc), 0);
            } else {
                i2 = zzc;
            }
        }
        zzc = i2;
        while (zzc < size) {
            if (zzqw.zzaf(zzc) && zzjp.zzd(r3, (zzqp) list.get(zzc))) {
                i = zzc;
                break;
            }
            zzc++;
        }
        i = -1;
        return new zzqt(Double.valueOf((double) i));
    }
}
