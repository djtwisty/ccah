package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzne implements zzjo {
    private final zzga zzbmr;

    public zzne(Context context) {
        this(zzga.zzx(context));
    }

    @VisibleForTesting
    private zzne(zzga zzga) {
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
        if (zzqpArr.length != 0) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        String zzne = this.zzbmr.zzne();
        return zzne == null ? zzqv.zzbpr : new zzrb(zzne);
    }
}
