package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzlq extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkArgument(true);
        boolean z = zzqpArr.length == 2 || zzqpArr.length == 3;
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzqpArr[1] instanceof zzqw);
        if (zzqpArr.length == 3) {
            Preconditions.checkArgument(zzqpArr[2] instanceof zzqw);
        }
        List arrayList = new ArrayList();
        if (zzjp.zza(zzqpArr[0])) {
            arrayList = (List) ((zzqw) zzqpArr[1]).value();
        } else if (zzqpArr.length > 2) {
            arrayList = (List) ((zzqw) zzqpArr[2]).value();
        }
        zzqp<?> zza = zzrd.zza(zzia, arrayList);
        return ((zza instanceof zzqv) && zzrd.zzm(zza)) ? zza : zzqv.zzbpr;
    }
}
