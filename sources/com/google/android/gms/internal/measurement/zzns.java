package com.google.android.gms.internal.measurement;

import android.os.Build;
import com.google.android.gms.common.internal.Preconditions;
import org.apache.cordova.networkinformation.NetworkManager;

public final class zzns implements zzjo {
    private final String zzbmw = Build.MANUFACTURER;
    private final String zzbmx = Build.MODEL;

    public final zzqp<?> zzb(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z = true;
        Preconditions.checkArgument(zzqpArr != null);
        if (zzqpArr.length != 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        String str = this.zzbmw;
        String str2 = this.zzbmx;
        if (!(str2.startsWith(str) || str.equals(NetworkManager.TYPE_UNKNOWN))) {
            str2 = new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(str2).length()).append(str).append(" ").append(str2).toString();
        }
        return new zzrb(str2);
    }
}
