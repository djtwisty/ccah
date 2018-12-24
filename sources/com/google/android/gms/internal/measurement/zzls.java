package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzls implements zzjo {
    public final zzqp<?> zzb(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z;
        int i = 0;
        if (zzqpArr != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        List arrayList = new ArrayList(zzqpArr.length);
        int length = zzqpArr.length;
        while (i < length) {
            arrayList.add(zzqpArr[i]);
            i++;
        }
        return new zzqw(arrayList);
    }
}
