package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import org.apache.http.HttpStatus;

public abstract class zzhh extends zzr implements zzhg {
    public zzhh() {
        super("com.google.android.gms.tagmanager.internal.ITagManagerService");
    }

    public static zzhg zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.tagmanager.internal.ITagManagerService");
        if (queryLocalInterface instanceof zzhg) {
            return (zzhg) queryLocalInterface;
        }
        return new zzhi(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                zzh(parcel.readString(), parcel.readString(), parcel.readString());
                break;
            case 2:
                zzhd zzhd;
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzhd = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.tagmanager.internal.ITagManagerLoadContainerCallback");
                    if (queryLocalInterface instanceof zzhd) {
                        zzhd = (zzhd) queryLocalInterface;
                    } else {
                        zzhd = new zzhf(readStrongBinder);
                    }
                }
                zza(readString, readString2, readString3, zzhd);
                break;
            case 3:
                zzra();
                break;
            case HttpStatus.SC_SWITCHING_PROTOCOLS /*101*/:
                zza(parcel.readString(), (Bundle) zzs.zza(parcel, Bundle.CREATOR), parcel.readString(), parcel.readLong(), zzs.zza(parcel));
                break;
            case HttpStatus.SC_PROCESSING /*102*/:
                dispatch();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
