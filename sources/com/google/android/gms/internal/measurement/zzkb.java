package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzkb extends zzjq {
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
            i = 0;
            zzqp = zzqpArr[2];
        } else {
            boolean z2;
            Preconditions.checkState(size > 0);
            zzqp = zzqw.zzae(0);
            int i2 = 1;
            i = 0;
            while (i < size) {
                if (zzqw.zzaf(i)) {
                    zzqp = zzqw.zzae(i);
                    i2 = i + 1;
                    break;
                }
                i++;
            }
            if (i < size) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkState(z2);
            i = i2;
        }
        int i3 = i;
        zzqp<?> zzqp2 = zzqp;
        while (i3 < size && i3 < ((List) zzqw.value()).size()) {
            zzqp<?> zzb;
            if (zzqw.zzaf(i3)) {
                zzb = ((zzjo) zzqu.value()).zzb(zzia, zzqp2, (zzqp) r2.get(i3), new zzqt(Double.valueOf((double) i3)), zzqw);
            } else {
                zzb = zzqp2;
            }
            i3++;
            zzqp2 = zzb;
        }
        return zzqp2;
    }
}
