package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzld extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzqpArr.length == 3);
        Preconditions.checkArgument(zzqpArr[1] instanceof zzrb);
        Preconditions.checkArgument(zzqpArr[2] instanceof zzqw);
        zzqp zzqp = zzqpArr[0];
        String str = (String) ((zzrb) zzqpArr[1]).value();
        List list = (List) ((zzqw) zzqpArr[2]).value();
        if (zzqp.zzfd(str)) {
            zzqp zzfe = zzqp.zzfe(str);
            if (zzfe instanceof zzqu) {
                return ((zzjo) ((zzqu) zzfe).value()).zzb(zzia, (zzqp[]) list.toArray(new zzqp[list.size()]));
            }
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 35).append("Apply TypeError: ").append(str).append(" is not a function").toString());
        } else if (zzqp.zzff(str)) {
            zzjo zzfg = zzqp.zzfg(str);
            list.add(0, zzqp);
            return zzfg.zzb(zzia, (zzqp[]) list.toArray(new zzqp[list.size()]));
        } else {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 40).append("Apply TypeError: object has no ").append(str).append(" property").toString());
        }
    }
}
