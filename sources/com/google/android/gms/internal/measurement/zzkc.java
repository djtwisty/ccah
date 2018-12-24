package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzkc extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        int i;
        zzqp<?> zzqp;
        Preconditions.checkNotNull(zzqpArr);
        boolean z = zzqpArr.length == 2 || zzqpArr.length == 3;
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzqw);
        Preconditions.checkArgument(zzqpArr[1] instanceof zzqu);
        zzqw zzqw = (zzqw) zzqpArr[0];
        zzqu zzqu = (zzqu) zzqpArr[1];
        int size = ((List) zzqw.value()).size();
        if (zzqpArr.length == 3) {
            i = size - 1;
            zzqp = zzqpArr[2];
        } else {
            boolean z2;
            Preconditions.checkState(size > 0);
            zzqp = zzqw.zzae(size - 1);
            int i2 = size - 2;
            i = size - 1;
            while (i >= 0) {
                if (zzqw.zzaf(i)) {
                    zzqp = zzqw.zzae(i);
                    i2 = i - 1;
                    break;
                }
                i--;
            }
            if (i >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkState(z2);
            i = i2;
        }
        size = i;
        zzqp<?> zzqp2 = zzqp;
        while (size >= 0) {
            zzqp<?> zzb;
            if (zzqw.zzaf(size)) {
                zzb = ((zzjo) zzqu.value()).zzb(zzia, zzqp2, (zzqp) r2.get(size), new zzqt(Double.valueOf((double) size)), zzqw);
            } else {
                zzb = zzqp2;
            }
            size--;
            zzqp2 = zzb;
        }
        return zzqp2;
    }
}
