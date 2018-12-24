package com.google.android.gms.tagmanager;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.measurement.zzhg;
import com.google.android.gms.internal.measurement.zzhh;
import com.google.android.gms.internal.measurement.zzq;
import com.google.android.gms.internal.measurement.zzs;

public final class zzcu extends zzq implements zzcs {
    zzcu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.tagmanager.ITagManagerServiceProvider");
    }

    public final zzhg getService(IObjectWrapper iObjectWrapper, zzcm zzcm, zzcd zzcd) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzs.zza(obtainAndWriteInterfaceToken, (IInterface) zzcm);
        zzs.zza(obtainAndWriteInterfaceToken, (IInterface) zzcd);
        obtainAndWriteInterfaceToken = transactAndReadException(1, obtainAndWriteInterfaceToken);
        zzhg zzb = zzhh.zzb(obtainAndWriteInterfaceToken.readStrongBinder());
        obtainAndWriteInterfaceToken.recycle();
        return zzb;
    }
}
