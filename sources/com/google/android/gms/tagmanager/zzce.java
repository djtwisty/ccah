package com.google.android.gms.tagmanager;

import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzr;
import com.google.android.gms.internal.measurement.zzs;

public abstract class zzce extends zzr implements zzcd {
    public zzce() {
        super("com.google.android.gms.tagmanager.ICustomEvaluatorProxy");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                zzb(parcel.readString(), zzs.zzb(parcel));
                parcel2.writeNoException();
                break;
            case 2:
                String zzc = zzc(parcel.readString(), zzs.zzb(parcel));
                parcel2.writeNoException();
                parcel2.writeString(zzc);
                break;
            default:
                return false;
        }
        return true;
    }
}
