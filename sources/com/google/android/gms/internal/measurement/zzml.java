package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public final class zzml extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        int max;
        int max2;
        Preconditions.checkArgument(true);
        boolean z = zzqpArr.length > 0 && zzqpArr.length <= 3;
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzrb);
        String str = (String) ((zzrb) zzqpArr[0]).value();
        double zzc = zzqpArr.length < 2 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : zzjp.zzc(zzqpArr[1]);
        double length = (double) str.length();
        if (zzqpArr.length == 3 && zzqpArr[2] != zzqv.zzbpr) {
            length = zzjp.zzc(zzqpArr[2]);
        }
        if (zzc < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            max = (int) Math.max(zzc + ((double) str.length()), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        } else {
            max = (int) Math.min(zzc, (double) str.length());
        }
        if (length < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            max2 = (int) Math.max(((double) str.length()) + length, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        } else {
            max2 = (int) Math.min(length, (double) str.length());
        }
        return new zzrb(str.substring(max, Math.max(0, max2 - max) + max));
    }
}
