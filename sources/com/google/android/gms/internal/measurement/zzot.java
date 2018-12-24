package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public final class zzot extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z;
        int i;
        Preconditions.checkArgument(true);
        boolean z2 = zzqpArr.length == 2 || zzqpArr.length == 3;
        Preconditions.checkArgument(z2);
        CharSequence zzd = zzjp.zzd(zzqpArr[0]);
        String zzd2 = zzjp.zzd(zzqpArr[1]);
        if (zzqpArr.length < 3) {
            z = false;
        } else {
            z = "true".equalsIgnoreCase(zzjp.zzd(zzqpArr[2]));
        }
        if (z) {
            i = 66;
        } else {
            i = 64;
        }
        try {
            return new zzqs(Boolean.valueOf(Pattern.compile(zzd2, i).matcher(zzd).find()));
        } catch (PatternSyntaxException e) {
            return new zzqs(Boolean.valueOf(false));
        }
    }
}
