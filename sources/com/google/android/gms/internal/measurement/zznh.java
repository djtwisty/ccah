package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;

public final class zznh implements zzjo {
    private final Context zzri;

    public zznh(Context context) {
        this.zzri = context;
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
        return new zzrb(this.zzri.getPackageName());
    }
}
