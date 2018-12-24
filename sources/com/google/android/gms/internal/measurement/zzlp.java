package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzlp extends zzjq {
    public static final zzlp zzbmp = new zzlp();

    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzqpArr.length == 2);
        zzqp zzqp = zzqpArr[0];
        zzqp zzqp2 = zzqpArr[1];
        if (zzrd.zzm(zzqp)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (zzrd.zzm(zzqp2)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        String zzd = zzjp.zzd(zzqp2);
        double zzb;
        if (zzqp instanceof zzqw) {
            if ("length".equals(zzd)) {
                return new zzqs(Boolean.valueOf(true));
            }
            zzb = zzjp.zzb(zzqp2);
            if (zzb == Math.floor(zzb) && zzd.equals(Integer.toString((int) zzb))) {
                int i = (int) zzb;
                if (i >= 0 && i < ((List) ((zzqw) zzqp).value()).size()) {
                    return new zzqs(Boolean.valueOf(true));
                }
            }
        } else if (zzqp instanceof zzrb) {
            if ("length".equals(zzd)) {
                return new zzqs(Boolean.valueOf(true));
            }
            zzb = zzjp.zzb(zzqp2);
            if (zzb == Math.floor(zzb) && zzd.equals(Integer.toString((int) zzb))) {
                int i2 = (int) zzb;
                if (i2 >= 0 && i2 < ((String) ((zzrb) zzqp).value()).length()) {
                    return new zzqs(Boolean.valueOf(true));
                }
            }
            return new zzqs(Boolean.valueOf(false));
        }
        return new zzqs(Boolean.valueOf(zzqp.zzfd(zzd)));
    }
}
