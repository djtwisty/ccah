package com.google.android.gms.tagmanager;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.measurement.zzq;
import com.google.android.gms.internal.measurement.zzs;
import java.util.Map;

public final class zzco extends zzq implements zzcm {
    zzco(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.tagmanager.IMeasurementProxy");
    }

    public final void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzs.zza(obtainAndWriteInterfaceToken, (Parcelable) bundle);
        obtainAndWriteInterfaceToken.writeLong(j);
        zza(2, obtainAndWriteInterfaceToken);
    }

    public final Map zzop() {
        Parcel transactAndReadException = transactAndReadException(11, obtainAndWriteInterfaceToken());
        Map zzb = zzs.zzb(transactAndReadException);
        transactAndReadException.recycle();
        return zzb;
    }

    public final void zza(zzcj zzcj) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, (IInterface) zzcj);
        zza(21, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzcg zzcg) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, (IInterface) zzcg);
        zza(22, obtainAndWriteInterfaceToken);
    }
}
