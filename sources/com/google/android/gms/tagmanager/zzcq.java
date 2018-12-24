package com.google.android.gms.tagmanager;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.measurement.zzr;
import com.google.android.gms.internal.measurement.zzs;

public abstract class zzcq extends zzr implements zzcp {
    public zzcq() {
        super("com.google.android.gms.tagmanager.ITagManagerApi");
    }

    public static zzcp asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.tagmanager.ITagManagerApi");
        if (queryLocalInterface instanceof zzcp) {
            return (zzcp) queryLocalInterface;
        }
        return new zzcr(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzcd zzcd = null;
        IObjectWrapper asInterface;
        IInterface queryLocalInterface;
        switch (i) {
            case 1:
                zzcm zzcm;
                asInterface = Stub.asInterface(parcel.readStrongBinder());
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
                initialize(asInterface, zzcm, zzcd);
                break;
            case 2:
                preview((Intent) zzs.zza(parcel, Intent.CREATOR), Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 3:
                zzcm zzcm2;
                Intent intent = (Intent) zzs.zza(parcel, Intent.CREATOR);
                asInterface = Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface2 = Stub.asInterface(parcel.readStrongBinder());
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 == null) {
                    zzcm2 = null;
                } else {
                    queryLocalInterface = readStrongBinder3.queryLocalInterface("com.google.android.gms.tagmanager.IMeasurementProxy");
                    if (queryLocalInterface instanceof zzcm) {
                        zzcm2 = (zzcm) queryLocalInterface;
                    } else {
                        zzcm2 = new zzco(readStrongBinder3);
                    }
                }
                readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    queryLocalInterface = readStrongBinder3.queryLocalInterface("com.google.android.gms.tagmanager.ICustomEvaluatorProxy");
                    zzcd = queryLocalInterface instanceof zzcd ? (zzcd) queryLocalInterface : new zzcf(readStrongBinder3);
                }
                previewIntent(intent, asInterface, asInterface2, zzcm2, zzcd);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
