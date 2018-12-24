package com.google.android.gms.flags;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.flags.zza;
import com.google.android.gms.internal.flags.zzc;

public final class zze extends zza implements zzc {
    zze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.flags.IFlagProvider");
    }

    public final void init(IObjectWrapper iObjectWrapper) {
        Parcel zza = zza();
        zzc.zza(zza, iObjectWrapper);
        zzb(1, zza);
    }

    public final boolean getBooleanFlagValue(String str, boolean z, int i) {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.writeBoolean(zza, z);
        zza.writeInt(i);
        zza = zza(2, zza);
        boolean zza2 = zzc.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final int getIntFlagValue(String str, int i, int i2) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeInt(i2);
        zza = zza(3, zza);
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final long getLongFlagValue(String str, long j, int i) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeLong(j);
        zza.writeInt(i);
        zza = zza(4, zza);
        long readLong = zza.readLong();
        zza.recycle();
        return readLong;
    }

    public final String getStringFlagValue(String str, String str2, int i) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeInt(i);
        zza = zza(5, zza);
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }
}
