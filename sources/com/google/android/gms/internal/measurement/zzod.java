package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.common.internal.Preconditions;

public final class zzod implements zzjo {
    private final Context zzri;

    public zzod(Context context) {
        this.zzri = (Context) Preconditions.checkNotNull(context);
    }

    public final zzqp<?> zzb(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z = true;
        Preconditions.checkArgument(zzqpArr != null);
        if (zzqpArr.length != 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        String string = Secure.getString(this.zzri.getContentResolver(), "android_id");
        if (string != null) {
            return new zzrb(string);
        }
        return zzqv.zzbpr;
    }
}
