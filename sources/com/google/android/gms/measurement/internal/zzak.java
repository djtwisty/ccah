package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.measurement.zzr;
import com.google.android.gms.internal.measurement.zzs;
import java.util.List;

public abstract class zzak extends zzr implements zzaj {
    public zzak() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        List zza;
        switch (i) {
            case 1:
                zza((zzag) zzs.zza(parcel, zzag.CREATOR), (zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                break;
            case 2:
                zza((zzfv) zzs.zza(parcel, zzfv.CREATOR), (zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                break;
            case 4:
                zza((zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                break;
            case 5:
                zza((zzag) zzs.zza(parcel, zzag.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            case 6:
                zzb((zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                break;
            case 7:
                zza = zza((zzk) zzs.zza(parcel, zzk.CREATOR), zzs.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                break;
            case 9:
                byte[] zza2 = zza((zzag) zzs.zza(parcel, zzag.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(zza2);
                break;
            case 10:
                zza(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                break;
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                String zzc = zzc((zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(zzc);
                break;
            case 12:
                zza((zzo) zzs.zza(parcel, zzo.CREATOR), (zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                break;
            case 13:
                zzb((zzo) zzs.zza(parcel, zzo.CREATOR));
                parcel2.writeNoException();
                break;
            case 14:
                zza = zza(parcel.readString(), parcel.readString(), zzs.zza(parcel), (zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                break;
            case 15:
                zza = zza(parcel.readString(), parcel.readString(), parcel.readString(), zzs.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                break;
            case 16:
                zza = zza(parcel.readString(), parcel.readString(), (zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                break;
            case 17:
                zza = zze(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                break;
            case 18:
                zzd((zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                break;
            default:
                return false;
        }
        return true;
    }
}
