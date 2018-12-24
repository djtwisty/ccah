package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public final class zzlu extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z;
        boolean z2 = true;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzqpArr.length == 3);
        zzqp zzqp = zzqpArr[0];
        zzqp zzqp2 = zzqpArr[1];
        zzqp<?> zzqp3 = zzqpArr[2];
        if (zzqp != zzqv.zzbpq) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (zzqp != zzqv.zzbpr) {
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
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (zzrd.zzm(zzqp3)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (zzrd.zzl(zzqp)) {
            return zzqp3;
        }
        String zzd = zzjp.zzd(zzqp2);
        if (zzqp instanceof zzqz) {
            zzqz zzqz = (zzqz) zzqp;
            if (!zzqz.isImmutable()) {
                zzqz.zzc(zzd, zzqp3);
            }
            return zzqp3;
        }
        if (zzqp instanceof zzqw) {
            zzqw zzqw = (zzqw) zzqp;
            if ("length".equals(zzd)) {
                double zzb = zzjp.zzb(zzqp3);
                if (Double.isInfinite(zzb) || zzb != Math.floor(zzb)) {
                    z2 = false;
                }
                Preconditions.checkArgument(z2);
                zzqw.setSize((int) zzb);
                return zzqp3;
            }
            double zzb2 = zzjp.zzb(zzqp2);
            if (!Double.isInfinite(zzb2) && zzb2 >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && zzd.equals(Integer.toString((int) zzb2))) {
                zzqw.zza((int) zzb2, zzqp3);
                return zzqp3;
            }
        }
        zzqp.zzc(zzd, zzqp3);
        return zzqp3;
    }
}
