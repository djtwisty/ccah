package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzlo extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z;
        boolean z2 = true;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzqpArr.length == 2);
        zzqp zzqp = zzqpArr[0];
        zzqp zzqp2 = zzqpArr[1];
        if ((zzqp instanceof zzrb) || !zzrd.zzl(zzqp)) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (zzrd.zzm(zzqp)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (zzrd.zzm(zzqp2)) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        String zzd = zzjp.zzd(zzqp2);
        double zzb;
        if (zzqp instanceof zzqw) {
            zzqw zzqw = (zzqw) zzqp;
            if ("length".equals(zzd)) {
                return new zzqt(Double.valueOf((double) ((List) zzqw.value()).size()));
            }
            zzb = zzjp.zzb(zzqp2);
            if (zzb == Math.floor(zzb) && zzd.equals(Integer.toString((int) zzb))) {
                zzqp<?> zzae = zzqw.zzae((int) zzb);
                if (zzae != zzqv.zzbpr) {
                    return zzae;
                }
            }
        } else if (zzqp instanceof zzrb) {
            zzrb zzrb = (zzrb) zzqp;
            if ("length".equals(zzd)) {
                return new zzqt(Double.valueOf((double) ((String) zzrb.value()).length()));
            }
            zzb = zzjp.zzb(zzqp2);
            if (zzb == Math.floor(zzb) && zzd.equals(Integer.toString((int) zzb))) {
                return zzrb.zzag((int) zzb);
            }
            return zzqv.zzbpr;
        }
        return zzqp.zzfe(zzd);
    }
}
