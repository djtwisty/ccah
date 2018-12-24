package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzly implements zzjo {
    public final zzqp<?> zzb(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z;
        zzqp zza;
        Preconditions.checkArgument(zzqpArr != null);
        if (zzqpArr.length == 4) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        zzqp zza2 = zzrd.zza(zzia, zzqpArr[3]);
        Preconditions.checkArgument(zza2 instanceof zzqw);
        List list = (List) ((zzqw) zza2).value();
        zzqp<?> zzqp = zzqpArr[2];
        Preconditions.checkArgument(zzqp instanceof zzqs);
        if (((Boolean) ((zzqs) zzqp).value()).booleanValue()) {
            zza = zzrd.zza(zzia, list);
            if (zza == zzqv.zzbpo) {
                return zzqv.zzbpr;
            }
            if (zza.zzsv()) {
                return zza;
            }
        }
        while (zzjp.zza(zzrd.zza(zzia, zzqpArr[0]))) {
            zza = zzrd.zza(zzia, list);
            if (zza == zzqv.zzbpo) {
                return zzqv.zzbpr;
            }
            if (zza.zzsv()) {
                return zza;
            }
            zzrd.zza(zzia, zzqpArr[1]);
        }
        return zzqv.zzbpr;
    }
}
