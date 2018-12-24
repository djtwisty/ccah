package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

public final class zznn implements zzjo {
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
        if (zzia.has("gtm.globals.eventName")) {
            return zzia.zzeq("gtm.globals.eventName");
        }
        return zzqv.zzbpq;
    }
}
