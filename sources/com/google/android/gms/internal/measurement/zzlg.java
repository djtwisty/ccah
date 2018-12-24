package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzlg extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z = true;
        Preconditions.checkArgument(true);
        if (zzqpArr.length != 1) {
            z = false;
        }
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzqw);
        for (zzqp zza : (List) ((zzqw) zzqpArr[0]).value()) {
            zzqp<?> zza2 = zzrd.zza(zzia, zza);
            if ((zza2 instanceof zzqv) && (zza2 == zzqv.zzbpo || zza2 == zzqv.zzbpp || ((zzqv) zza2).zzsv())) {
                return zza2;
            }
        }
        return zzqv.zzbpr;
    }
}
