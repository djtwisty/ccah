package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Locale;

public final class zzms extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z = true;
        Preconditions.checkArgument(true);
        if (zzqpArr.length != 1) {
            z = false;
        }
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzrb);
        return new zzrb(((String) ((zzrb) zzqpArr[0]).value()).toUpperCase(Locale.ENGLISH));
    }
}
