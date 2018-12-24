package com.google.android.gms.tagmanager;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.measurement.zzr;
import com.google.android.gms.internal.measurement.zzs;
import java.util.Map;

public abstract class zzcn extends zzr implements zzcm {
    public zzcn() {
        super("com.google.android.gms.tagmanager.IMeasurementProxy");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzcg zzcg = null;
        IBinder readStrongBinder;
        IInterface queryLocalInterface;
        switch (i) {
            case 2:
                logEventInternalNoInterceptor(parcel.readString(), parcel.readString(), (Bundle) zzs.zza(parcel, Bundle.CREATOR), parcel.readLong());
                parcel2.writeNoException();
                break;
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                Map zzop = zzop();
                parcel2.writeNoException();
                parcel2.writeMap(zzop);
                break;
            case 21:
                zzcj zzcj;
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.tagmanager.IMeasurementInterceptor");
                    if (queryLocalInterface instanceof zzcj) {
                        zzcj = (zzcj) queryLocalInterface;
                    } else {
                        zzcj = new zzcl(readStrongBinder);
                    }
                }
                zza(zzcj);
                parcel2.writeNoException();
                break;
            case 22:
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.tagmanager.IMeasurementEventListener");
                    zzcg = queryLocalInterface instanceof zzcg ? (zzcg) queryLocalInterface : new zzci(readStrongBinder);
                }
                zza(zzcg);
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
