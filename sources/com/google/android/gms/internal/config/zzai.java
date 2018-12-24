package com.google.android.gms.internal.config;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

public final class zzai extends zza implements zzah {
    zzai(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.config.internal.IConfigService");
    }

    public final void zza(zzaf zzaf, zzab zzab) {
        Parcel zza = zza();
        zzc.zza(zza, (IInterface) zzaf);
        zzc.zza(zza, (Parcelable) zzab);
        zza(8, zza);
    }
}
