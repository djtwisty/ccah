package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzlv extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzqpArr.length == 3);
        Preconditions.checkArgument(zzqpArr[1] instanceof zzqw);
        Preconditions.checkArgument(zzqpArr[2] instanceof zzqw);
        zzqp zzqp = zzqpArr[0];
        List list = (List) ((zzqw) zzqpArr[1]).value();
        List list2 = (List) ((zzqw) zzqpArr[2]).value();
        if (list2.size() <= list.size() + 1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        int i = 0;
        boolean z2 = false;
        while (i < list.size()) {
            if (z2 || zzjp.zzd(zzqp, zzrd.zza(zzia, (zzqp) list.get(i)))) {
                zzqp<?> zza = zzrd.zza(zzia, (zzqp) list2.get(i));
                if (!(zza instanceof zzqv)) {
                    z = true;
                    i++;
                    z2 = z;
                } else if (zza == zzqv.zzbpp || ((zzqv) zza).zzsv()) {
                    return zza;
                } else {
                    if (zza == zzqv.zzbpo) {
                        return zzqv.zzbpr;
                    }
                }
            }
            z = z2;
            i++;
            z2 = z;
        }
        if (list.size() < list2.size()) {
            zzqp<?> zza2 = zzrd.zza(zzia, (zzqp) list2.get(list2.size() - 1));
            if ((zza2 instanceof zzqv) && (zza2 == zzqv.zzbpp || ((zzqv) zza2).zzsv())) {
                return zza2;
            }
        }
        return zzqv.zzbpr;
    }
}
