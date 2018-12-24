package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

public final class zzmj extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkArgument(true);
        boolean z = zzqpArr.length > 0 && zzqpArr.length <= 3;
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzrb);
        String str = (String) ((zzrb) zzqpArr[0]).value();
        if (zzqpArr.length == 1) {
            return new zzrb(str);
        }
        String zzd = zzjp.zzd(zzqpArr[1]);
        zzqp zzqp = zzqpArr.length < 3 ? zzqv.zzbpr : zzqpArr[2];
        int indexOf = str.indexOf(zzd);
        if (indexOf == -1) {
            return new zzrb(str);
        }
        if (zzqp instanceof zzqu) {
            zzqp = ((zzjo) ((zzqu) zzqp).value()).zzb(zzia, new zzrb(zzd), new zzqt(Double.valueOf((double) indexOf)), new zzrb(str));
        }
        String zzd2 = zzjp.zzd(zzqp);
        String substring = str.substring(0, indexOf);
        str = str.substring(zzd.length() + indexOf);
        return new zzrb(new StringBuilder((String.valueOf(substring).length() + String.valueOf(zzd2).length()) + String.valueOf(str).length()).append(substring).append(zzd2).append(str).toString());
    }
}
