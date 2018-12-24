package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tagmanager.zzcm;
import java.util.Map;

public final class zzow extends zzjq {
    private final zzhy zzbkl;
    private final zzcm zzbnf;

    public zzow(zzcm zzcm, zzhy zzhy) {
        this.zzbnf = zzcm;
        this.zzbkl = zzhy;
    }

    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z = true;
        Preconditions.checkArgument(true);
        boolean z2 = zzqpArr.length == 1 || zzqpArr.length == 2;
        Preconditions.checkArgument(z2);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzrb);
        zzqv zzqv = zzqpArr.length > 1 ? zzqpArr[1] : zzqv.zzbpr;
        if (!(zzqv == zzqv.zzbpr || (zzqv instanceof zzqz))) {
            z = false;
        }
        Preconditions.checkArgument(z);
        zzgt zzrh = this.zzbkl.zzrh();
        String str = (String) ((zzrb) zzqpArr[0]).value();
        Bundle bundle = null;
        if (zzqv != zzqv.zzbpr) {
            bundle = zzrd.zzl((Map) ((zzqz) zzqv).value());
        }
        try {
            this.zzbnf.logEventInternalNoInterceptor(zzrh.zzqv(), str, bundle, zzrh.currentTimeMillis());
        } catch (RemoteException e) {
            String str2 = "Error calling measurement proxy:";
            String valueOf = String.valueOf(e.getMessage());
            zzhk.m1081e(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        return zzqv.zzbpr;
    }
}
