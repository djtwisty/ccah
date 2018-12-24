package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzjr extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        int i = 1;
        Preconditions.checkNotNull(zzqpArr);
        Preconditions.checkArgument(zzqpArr.length > 0);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzqw);
        zzqw zzqw = (zzqw) zzqpArr[0];
        List arrayList = new ArrayList();
        for (zzqp add : (List) zzqw.value()) {
            arrayList.add(add);
        }
        while (i < zzqpArr.length) {
            if (zzqpArr[i] instanceof zzqw) {
                for (zzqp add2 : (List) ((zzqw) zzqpArr[i]).value()) {
                    arrayList.add(add2);
                }
            } else {
                arrayList.add(zzqpArr[i]);
            }
            i++;
        }
        return new zzqw(arrayList);
    }
}
