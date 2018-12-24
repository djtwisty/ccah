package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;

public final class zzny implements zzjo {
    private Context zzri;

    public zzny(Context context) {
        this.zzri = (Context) Preconditions.checkNotNull(context);
    }

    public final zzqp<?> zzb(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkArgument(zzqpArr != null);
        String str = null;
        if (zzqpArr.length > 0 && zzqpArr[0] != zzqv.zzbpr) {
            str = zzjp.zzd(zzrd.zza(zzia, zzqpArr[0]));
        }
        String zzg = zzhj.zzg(this.zzri, str);
        if (zzg != null) {
            return new zzrb(zzg);
        }
        return zzqv.zzbpr;
    }
}
