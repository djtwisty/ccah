package com.google.android.gms.internal.measurement;

import android.os.Parcel;

public abstract class zzhe extends zzr implements zzhd {
    public zzhe() {
        super("com.google.android.gms.tagmanager.internal.ITagManagerLoadContainerCallback");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        zza(zzs.zza(parcel), parcel.readString());
        return true;
    }
}
