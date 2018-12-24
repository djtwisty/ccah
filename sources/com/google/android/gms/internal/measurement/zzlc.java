package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

public final class zzlc extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z;
        boolean z2 = true;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzqpArr.length == 1);
        if (zzqpArr[0] instanceof zzra) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (zzrd.zzm(zzqpArr[0])) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        zzqp<?> zzqp = zzqpArr[0];
        String str = "object";
        if (zzqp == zzqv.zzbpr) {
            str = "undefined";
        } else if (zzqp instanceof zzqs) {
            str = "boolean";
        } else if (zzqp instanceof zzqt) {
            str = "number";
        } else if (zzqp instanceof zzrb) {
            str = "string";
        } else if (zzqp instanceof zzqu) {
            str = "function";
        }
        return new zzrb(str);
    }
}
