package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Locale;

public final class zzoa implements zzjo {
    public final zzqp<?> zzb(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z = true;
        Preconditions.checkArgument(zzqpArr != null);
        if (zzqpArr.length != 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return new zzrb("");
        }
        String language = locale.getLanguage();
        if (language == null) {
            return new zzrb("");
        }
        return new zzrb(language.toLowerCase());
    }
}
