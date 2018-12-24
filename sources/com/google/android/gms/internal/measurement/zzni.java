package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.internal.Preconditions;

public final class zzni implements zzjo {
    private Context zzri;

    public zzni(Context context) {
        this.zzri = context;
    }

    public final zzqp<?> zzb(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z = true;
        Preconditions.checkArgument(zzqpArr != null);
        if (zzqpArr.length != 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        try {
            PackageManager packageManager = this.zzri.getPackageManager();
            return new zzrb(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.zzri.getPackageName(), 0)).toString());
        } catch (NameNotFoundException e) {
            return new zzrb("");
        }
    }
}
