package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import org.apache.http.HttpStatus;

public final class zzhi extends zzq implements zzhg {
    zzhi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.tagmanager.internal.ITagManagerService");
    }

    public final void zzh(String str, String str2, String str3) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeString(str3);
        zza(1, obtainAndWriteInterfaceToken);
    }

    public final void zza(String str, String str2, String str3, zzhd zzhd) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeString(str3);
        zzs.zza(obtainAndWriteInterfaceToken, (IInterface) zzhd);
        zza(2, obtainAndWriteInterfaceToken);
    }

    public final void zzra() {
        zza(3, obtainAndWriteInterfaceToken());
    }

    public final void zza(String str, Bundle bundle, String str2, long j, boolean z) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzs.zza(obtainAndWriteInterfaceToken, (Parcelable) bundle);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeLong(j);
        zzs.writeBoolean(obtainAndWriteInterfaceToken, z);
        zza(HttpStatus.SC_SWITCHING_PROTOCOLS, obtainAndWriteInterfaceToken);
    }

    public final void dispatch() {
        zza(HttpStatus.SC_PROCESSING, obtainAndWriteInterfaceToken());
    }
}
