package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.common.internal.Preconditions;

public final class zznq implements zzjo {
    private final Context zzri;

    public zznq(Context context) {
        this.zzri = context;
    }

    public final zzqp<?> zzb(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z = true;
        Preconditions.checkArgument(zzqpArr != null);
        if (zzqpArr.length != 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        String string = Secure.getString(this.zzri.getContentResolver(), "android_id");
        if (string == null) {
            string = "";
        }
        return new zzrb(string);
    }
}
