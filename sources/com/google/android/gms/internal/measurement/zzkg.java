package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzkg extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkNotNull(zzqpArr);
        Preconditions.checkArgument(zzqpArr.length == 2);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzqw);
        Preconditions.checkArgument(zzqpArr[1] instanceof zzqu);
        zzqw zzqw = (zzqw) zzqpArr[0];
        zzqu zzqu = (zzqu) zzqpArr[1];
        int size = ((List) zzqw.value()).size();
        boolean z = false;
        int i = 0;
        while (!z && i < size && i < ((List) zzqw.value()).size()) {
            boolean zza;
            if (zzqw.zzaf(i)) {
                zza = zzjp.zza(((zzjo) zzqu.value()).zzb(zzia, (zzqp) r2.get(i), new zzqt(Double.valueOf((double) i)), zzqw)) | z;
            } else {
                zza = z;
            }
            i++;
            z = zza;
        }
        return new zzqs(Boolean.valueOf(z));
    }
}
