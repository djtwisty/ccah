package com.google.android.gms.tagmanager;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzr;
import com.google.android.gms.internal.measurement.zzs;

public abstract class zzch extends zzr implements zzcg {
    public zzch() {
        super("com.google.android.gms.tagmanager.IMeasurementEventListener");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        onEvent(parcel.readString(), parcel.readString(), (Bundle) zzs.zza(parcel, Bundle.CREATOR), parcel.readLong());
        parcel2.writeNoException();
        return true;
    }
}
