package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public final class zzmc extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        int i = 1;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzqpArr.length == 2);
        double zzb = zzjp.zzb(zzqpArr[0]);
        double zzb2 = zzjp.zzb(zzqpArr[1]);
        if (Double.isNaN(zzb) || Double.isNaN(zzb2)) {
            return new zzqt(Double.valueOf(Double.NaN));
        }
        if ((Double.isInfinite(zzb) && zzb2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) || (zzb == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && Double.isInfinite(zzb2))) {
            return new zzqt(Double.valueOf(Double.NaN));
        }
        if (!Double.isInfinite(zzb) && !Double.isInfinite(zzb2)) {
            return new zzqt(Double.valueOf(zzb * zzb2));
        }
        int i2;
        if (((double) Double.compare(zzb, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (((double) Double.compare(zzb2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            i = 0;
        }
        return new zzqt(Double.valueOf((i2 ^ i) != 0 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY));
    }
}
