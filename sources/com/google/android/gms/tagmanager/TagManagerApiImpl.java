package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzhk;
import com.google.android.gms.internal.measurement.zzhq;
import com.google.android.gms.internal.measurement.zzin;

@DynamiteApi
public class TagManagerApiImpl extends zzcq {
    private zzin zzbgt;

    public void initialize(IObjectWrapper iObjectWrapper, zzcm zzcm, zzcd zzcd) {
        this.zzbgt = zzin.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzcm, zzcd);
        this.zzbgt.zzb(null);
    }

    @Deprecated
    public void preview(Intent intent, IObjectWrapper iObjectWrapper) {
        zzhk.zzab("Deprecated. Please use previewIntent instead.");
    }

    public void previewIntent(Intent intent, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, zzcm zzcm, zzcd zzcd) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        Context context2 = (Context) ObjectWrapper.unwrap(iObjectWrapper2);
        this.zzbgt = zzin.zza(context, zzcm, zzcd);
        new zzhq(intent, context, context2, this.zzbgt).zzre();
    }
}
