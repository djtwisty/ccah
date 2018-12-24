package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzmm extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        int i = 1;
        Preconditions.checkArgument(true);
        boolean z = zzqpArr.length == 1 || zzqpArr.length == 2;
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzrb);
        List arrayList = new ArrayList();
        if (zzqpArr.length == 1) {
            arrayList.add(zzqpArr[0]);
        } else {
            int i2;
            String str = (String) ((zzrb) zzqpArr[0]).value();
            String zzd = zzjp.zzd(zzqpArr[1]);
            boolean equals = zzd.equals("");
            String[] split = str.split(zzd, equals ? 0 : -1);
            if (equals && split.length > 0 && split[0].equals("")) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 == 0) {
                i = 0;
            }
            while (i < split.length) {
                arrayList.add(new zzrb(split[i]));
                i++;
            }
        }
        return new zzqw(arrayList);
    }
}
