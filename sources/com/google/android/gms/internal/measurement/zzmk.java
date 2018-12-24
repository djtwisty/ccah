package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzmk extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkArgument(true);
        boolean z = zzqpArr.length == 1 || zzqpArr.length == 2;
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzrb);
        Matcher matcher = Pattern.compile(zzqpArr.length < 2 ? "" : zzjp.zzd(zzqpArr[1])).matcher((String) ((zzrb) zzqpArr[0]).value());
        if (matcher.find()) {
            return new zzqt(Double.valueOf((double) matcher.start()));
        }
        return new zzqt(Double.valueOf(-1.0d));
    }
}
