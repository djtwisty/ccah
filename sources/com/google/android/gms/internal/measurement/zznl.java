package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.gms.common.internal.Preconditions;

public final class zznl implements zzjo {
    private final Context zzri;

    public zznl(Context context) {
        this.zzri = (Context) Preconditions.checkNotNull(context);
    }

    public final zzqp<?> zzb(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z = true;
        Preconditions.checkArgument(zzqpArr != null);
        if (zzqpArr.length != 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        TelephonyManager telephonyManager = (TelephonyManager) this.zzri.getSystemService("phone");
        zzqp zzqp = zzqv.zzbpr;
        if (telephonyManager != null) {
            String networkOperatorName = telephonyManager.getNetworkOperatorName();
            if (networkOperatorName != null) {
                return new zzrb(networkOperatorName);
            }
        }
        return zzqp;
    }
}
