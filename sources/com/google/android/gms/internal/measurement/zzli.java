package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzli extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkArgument(true);
        List arrayList = new ArrayList();
        for (zzqv zzqv : zzqpArr) {
            boolean z;
            if (!(zzqv instanceof zzqv) || zzqv == zzqv.zzbpr || zzqv == zzqv.zzbpq) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            arrayList.add(zzqv);
        }
        return new zzqw(arrayList);
    }
}
