package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;

public final class zzng extends zzjq {
    private final zzhy zzbms;
    private final Context zzri;

    public zzng(Context context, zzhy zzhy) {
        this.zzri = (Context) Preconditions.checkNotNull(context);
        this.zzbms = zzhy;
    }

    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        String str = null;
        Preconditions.checkArgument(true);
        if (zzqpArr.length == 0 || zzqpArr[0] == zzqv.zzbpr) {
            return new zzrb("");
        }
        Object obj = this.zzbms.zzrh().zzop().get("_ldl");
        if (obj == null) {
            return new zzrb("");
        }
        zzqp zzr = zzrd.zzr(obj);
        if (!(zzr instanceof zzrb)) {
            return new zzrb("");
        }
        String str2 = (String) ((zzrb) zzr).value();
        if (!zzhj.zzw(str2, "conv").equals(zzjp.zzd(zzqpArr[0]))) {
            return new zzrb("");
        }
        if (zzqpArr.length > 1 && zzqpArr[1] != zzqv.zzbpr) {
            str = zzjp.zzd(zzqpArr[1]);
        }
        str = zzhj.zzw(str2, str);
        return str != null ? new zzrb(str) : new zzrb("");
    }
}
