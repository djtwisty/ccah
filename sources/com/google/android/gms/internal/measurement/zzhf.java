package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.Parcel;

public final class zzhf extends zzq implements zzhd {
    zzhf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.tagmanager.internal.ITagManagerLoadContainerCallback");
    }

    public final void zza(boolean z, String str) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.writeBoolean(obtainAndWriteInterfaceToken, z);
        obtainAndWriteInterfaceToken.writeString(str);
        zzb(1, obtainAndWriteInterfaceToken);
    }
}
