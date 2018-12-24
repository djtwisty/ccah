package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.List;

public final class zzkh extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        zzqu zzqu;
        Preconditions.checkNotNull(zzqpArr);
        boolean z = zzqpArr.length == 1 || zzqpArr.length == 2;
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzqw);
        zzqw zzqw = (zzqw) zzqpArr[0];
        if (zzqpArr.length == 2) {
            Preconditions.checkArgument(zzqpArr[1] instanceof zzqu);
            zzqu = (zzqu) zzqpArr[1];
        } else {
            zzqu = new zzqu(new zzkk());
        }
        Collections.sort((List) zzqw.value(), new zzkj(this, zzqu, zzia));
        return zzqpArr[0];
    }
}
