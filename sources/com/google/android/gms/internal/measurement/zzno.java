package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

public final class zzno implements zzjo {
    private Clock zzrz = DefaultClock.getInstance();

    public final zzqp<?> zzb(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z;
        boolean z2 = true;
        if (zzqpArr != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (zzqpArr.length != 0) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        return new zzqt(Double.valueOf((double) this.zzrz.currentTimeMillis()));
    }

    public final void zza(Clock clock) {
        this.zzrz = (Clock) Preconditions.checkNotNull(clock);
    }
}
