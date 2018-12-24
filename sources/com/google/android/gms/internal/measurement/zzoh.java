package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public final class zzoh extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzqpArr.length >= 2);
        if (zzqpArr[0] == zzqv.zzbpr || zzqpArr[1] == zzqv.zzbpr) {
            return zzqv.zzbpr;
        }
        int i;
        CharSequence zzd = zzjp.zzd(zzqpArr[0]);
        String zzd2 = zzjp.zzd(zzqpArr[1]);
        int i2 = 64;
        if (zzqpArr.length > 2 && zzqpArr[2] != zzqv.zzbpr && zzjp.zza(zzqpArr[2])) {
            i2 = 66;
        }
        if (zzqpArr.length <= 3 || zzqpArr[3] == zzqv.zzbpr) {
            i = 1;
        } else if (!(zzqpArr[3] instanceof zzqt)) {
            return zzqv.zzbpr;
        } else {
            double zzc = zzjp.zzc(zzqpArr[3]);
            if (Double.isInfinite(zzc) || zzc < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return zzqv.zzbpr;
            }
            i = (int) zzc;
        }
        String str = null;
        try {
            Matcher matcher = Pattern.compile(zzd2, i2).matcher(zzd);
            if (matcher.find() && matcher.groupCount() >= i) {
                str = matcher.group(i);
            }
            return str == null ? zzqv.zzbpr : new zzrb(str);
        } catch (PatternSyntaxException e) {
            return zzqv.zzbpr;
        }
    }
}
