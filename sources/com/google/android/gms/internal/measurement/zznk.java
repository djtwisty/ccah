package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.internal.Preconditions;

public final class zznk implements zzjo {
    private final Context zzri;

    public zznk(Context context) {
        this.zzri = (Context) Preconditions.checkNotNull(context);
    }

    public final zzqp<?> zzb(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z = true;
        Preconditions.checkArgument(zzqpArr != null);
        if (zzqpArr.length != 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        try {
            return new zzrb(this.zzri.getPackageManager().getPackageInfo(this.zzri.getPackageName(), 0).versionName);
        } catch (NameNotFoundException e) {
            String packageName = this.zzri.getPackageName();
            String valueOf = String.valueOf(e);
            zzhk.m1081e(new StringBuilder((String.valueOf(packageName).length() + 25) + String.valueOf(valueOf).length()).append("Package name ").append(packageName).append(" not found. ").append(valueOf).toString());
            return zzqv.zzbpr;
        }
    }
}
