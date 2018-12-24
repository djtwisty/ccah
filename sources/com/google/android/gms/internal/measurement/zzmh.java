package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public final class zzmh extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkArgument(true);
        boolean z = zzqpArr.length == 2 || zzqpArr.length == 3;
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzrb);
        String str = (String) ((zzrb) zzqpArr[0]).value();
        String zzd = zzjp.zzd(zzqpArr[1]);
        double d = Double.POSITIVE_INFINITY;
        if (zzqpArr.length == 3 && !Double.isNaN(zzjp.zzb(zzqpArr[2]))) {
            d = zzjp.zzc(zzqpArr[2]);
        }
        return new zzqt(Double.valueOf((double) str.lastIndexOf(zzd, (int) Math.min(Math.max(d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), (double) str.length()))));
    }
}
