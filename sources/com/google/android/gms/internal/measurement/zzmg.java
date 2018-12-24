package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public final class zzmg extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkArgument(true);
        boolean z = zzqpArr.length == 2 || zzqpArr.length == 3;
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzrb);
        String str = (String) ((zzrb) zzqpArr[0]).value();
        return new zzqt(Double.valueOf((double) str.indexOf(zzjp.zzd(zzqpArr[1]), (int) Math.min(Math.max(zzqpArr.length < 3 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : zzjp.zzc(zzqpArr[2]), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), (double) str.length()))));
    }
}
