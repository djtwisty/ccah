package com.google.android.gms.tagmanager;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.measurement.zzq;
import com.google.android.gms.internal.measurement.zzs;

public final class zzcr extends zzq implements zzcp {
    zzcr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.tagmanager.ITagManagerApi");
    }

    public final void initialize(IObjectWrapper iObjectWrapper, zzcm zzcm, zzcd zzcd) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzs.zza(obtainAndWriteInterfaceToken, (IInterface) zzcm);
        zzs.zza(obtainAndWriteInterfaceToken, (IInterface) zzcd);
        zza(1, obtainAndWriteInterfaceToken);
    }

    public final void preview(Intent intent, IObjectWrapper iObjectWrapper) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, (Parcelable) intent);
        zzs.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zza(2, obtainAndWriteInterfaceToken);
    }

    public final void previewIntent(Intent intent, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, zzcm zzcm, zzcd zzcd) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, (Parcelable) intent);
        zzs.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzs.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper2);
        zzs.zza(obtainAndWriteInterfaceToken, (IInterface) zzcm);
        zzs.zza(obtainAndWriteInterfaceToken, (IInterface) zzcd);
        zza(3, obtainAndWriteInterfaceToken);
    }
}
