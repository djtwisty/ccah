package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzhg;
import com.google.android.gms.internal.measurement.zzja;

@DynamiteApi
public class TagManagerServiceProviderImpl extends zzct {
    private static volatile zzja zzbgu;

    public zzhg getService(IObjectWrapper iObjectWrapper, zzcm zzcm, zzcd zzcd) {
        zzhg zzhg = zzbgu;
        if (zzhg == null) {
            synchronized (TagManagerServiceProviderImpl.class) {
                zzhg = zzbgu;
                if (zzhg == null) {
                    zzja zzja = new zzja((Context) ObjectWrapper.unwrap(iObjectWrapper), zzcm, zzcd);
                    zzbgu = zzja;
                    zzhg = zzja;
                }
            }
        }
        return zzhg;
    }
}
