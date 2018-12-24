package com.google.android.gms.tagmanager;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.measurement.zzr;
import com.google.android.gms.internal.measurement.zzs;

public abstract class zzct extends zzr implements zzcs {
    public zzct() {
        super("com.google.android.gms.tagmanager.ITagManagerServiceProvider");
    }

    public static zzcs asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.tagmanager.ITagManagerServiceProvider");
        if (queryLocalInterface instanceof zzcs) {
            return (zzcs) queryLocalInterface;
        }
        return new zzcu(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzcd zzcd = null;
        if (i != 1) {
            return false;
        }
        zzcm zzcm;
        IInterface queryLocalInterface;
        IObjectWrapper asInterface = Stub.asInterface(parcel.readStrongBinder());
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            zzcm = null;
        } else {
            queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.tagmanager.IMeasurementProxy");
            if (queryLocalInterface instanceof zzcm) {
                zzcm = (zzcm) queryLocalInterface;
            } else {
                Object zzco = new zzco(readStrongBinder);
            }
        }
        IBinder readStrongBinder2 = parcel.readStrongBinder();
        if (readStrongBinder2 != null) {
            queryLocalInterface = readStrongBinder2.queryLocalInterface("com.google.android.gms.tagmanager.ICustomEvaluatorProxy");
            if (queryLocalInterface instanceof zzcd) {
                zzcd = (zzcd) queryLocalInterface;
            } else {
                zzcd = new zzcf(readStrongBinder2);
            }
        }
        queryLocalInterface = getService(asInterface, zzcm, zzcd);
        parcel2.writeNoException();
        zzs.zza(parcel2, queryLocalInterface);
        return true;
    }
}
