package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public final class zzma extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzqpArr.length == 2);
        double zzb = zzjp.zzb(zzqpArr[0]);
        double zzb2 = zzjp.zzb(zzqpArr[1]);
        if (Double.isNaN(zzb) || Double.isNaN(zzb2)) {
            return new zzqt(Double.valueOf(Double.NaN));
        }
        if (Double.isInfinite(zzb) && Double.isInfinite(zzb2)) {
            return new zzqt(Double.valueOf(Double.NaN));
        }
        int i = (((double) Double.compare(zzb, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : 0) ^ (((double) Double.compare(zzb2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : 0);
        if (Double.isInfinite(zzb) && !Double.isInfinite(zzb2)) {
            return new zzqt(Double.valueOf(i != 0 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY));
        } else if (!Double.isInfinite(zzb) && Double.isInfinite(zzb2)) {
            return new zzqt(Double.valueOf(i != 0 ? -0.0d : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        } else if (zzb == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            if (zzb2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return new zzqt(Double.valueOf(Double.NaN));
            }
            return new zzqt(Double.valueOf(i != 0 ? -0.0d : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        } else if (Double.isInfinite(zzb) || zzb == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || zzb2 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return new zzqt(Double.valueOf(zzb / zzb2));
        } else {
            return new zzqt(Double.valueOf(i != 0 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY));
        }
    }
}
