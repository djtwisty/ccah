package com.google.android.gms.internal.measurement;

import android.os.Build.VERSION;
import com.google.android.gms.common.internal.Preconditions;

public final class zzoi implements zzjo {
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
        return new zzrb("5.06-" + VERSION.SDK_INT);
    }
}
