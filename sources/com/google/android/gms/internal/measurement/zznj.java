package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.internal.Preconditions;

public final class zznj implements zzjo {
    private final Context zzri;

    public zznj(Context context) {
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
            return new zzqt(Double.valueOf((double) this.zzri.getPackageManager().getPackageInfo(this.zzri.getPackageName(), 0).versionCode));
        } catch (NameNotFoundException e) {
            String packageName = this.zzri.getPackageName();
            String message = e.getMessage();
            zzhk.m1081e(new StringBuilder((String.valueOf(packageName).length() + 25) + String.valueOf(message).length()).append("Package name ").append(packageName).append(" not found. ").append(message).toString());
            return zzqv.zzbpr;
        }
    }
}
