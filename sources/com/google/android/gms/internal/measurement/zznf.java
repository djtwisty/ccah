package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zznf implements zzjo {
    private final zzga zzbmr;

    public zznf(Context context) {
        this(zzga.zzx(context));
    }

    @VisibleForTesting
    private zznf(zzga zzga) {
        this.zzbmr = zzga;
    }

    public final zzqp<?> zzb(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z;
        boolean z2 = true;
        if (zzqpArr != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (zzqpArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (this.zzbmr.isLimitAdTrackingEnabled()) {
            z2 = false;
        }
        return new zzqs(Boolean.valueOf(z2));
    }
}
