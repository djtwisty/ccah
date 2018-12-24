package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzkf extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkNotNull(zzqpArr);
        boolean z = zzqpArr.length == 2 || zzqpArr.length == 3;
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzqw);
        zzqw zzqw = (zzqw) zzqpArr[0];
        int zzc = (int) zzjp.zzc(zzqpArr[1]);
        if (zzc < 0) {
            zzc = Math.max(((List) zzqw.value()).size() + zzc, 0);
        } else {
            zzc = Math.min(zzc, ((List) zzqw.value()).size());
        }
        int size = ((List) zzqw.value()).size();
        if (zzqpArr.length == 3) {
            int zzc2 = (int) zzjp.zzc(zzqpArr[2]);
            if (zzc2 < 0) {
                size = Math.max(((List) zzqw.value()).size() + zzc2, 0);
            } else {
                size = Math.min(zzc2, ((List) zzqw.value()).size());
            }
        }
        return new zzqw(new ArrayList(((List) zzqw.value()).subList(zzc, Math.max(zzc, size))));
    }
}
