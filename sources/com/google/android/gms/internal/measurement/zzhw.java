package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import java.util.Map;

final class zzhw implements zzna {
    private final /* synthetic */ zzhu zzbkm;

    private zzhw(zzhu zzhu) {
        this.zzbkm = zzhu;
    }

    public final Object zza(String str, Map<String, Object> map) {
        try {
            this.zzbkm.zzbir.zzb(str, map);
        } catch (RemoteException e) {
            String str2 = "Error calling customEvaluator proxy:";
            String valueOf = String.valueOf(e.getMessage());
            zzhk.m1081e(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        return null;
    }
}
