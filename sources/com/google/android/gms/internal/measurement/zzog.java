package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public final class zzog extends zzjq {
    private static final zzqt zzbna = new zzqt(Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
    private static final zzqt zzbnb = new zzqt(Double.valueOf(2.147483647E9d));

    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        double doubleValue;
        Preconditions.checkArgument(true);
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        zzqp zzqp = zzqpArr.length > 0 ? zzqpArr[0] : zzbna;
        zzqp zzqp2 = zzqpArr.length > 1 ? zzqpArr[1] : zzbnb;
        if (zzg(zzqp) && zzg(zzqp2) && zzjp.zzb(zzqp, zzqp2)) {
            double doubleValue2 = ((Double) ((zzqt) zzqp).value()).doubleValue();
            doubleValue = ((Double) ((zzqt) zzqp2).value()).doubleValue();
            d = doubleValue2;
        } else {
            doubleValue = 2.147483647E9d;
        }
        return new zzqt(Double.valueOf((double) Math.round(((doubleValue - d) * Math.random()) + d)));
    }

    private static boolean zzg(zzqp<?> zzqp) {
        return (zzqp instanceof zzqt) && !Double.isNaN(((Double) ((zzqt) zzqp).value()).doubleValue());
    }
}
