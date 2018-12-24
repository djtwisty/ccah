package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.measurement.zzq;
import com.google.android.gms.internal.measurement.zzs;
import java.util.List;

public final class zzal extends zzq implements zzaj {
    zzal(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final void zza(zzag zzag, zzk zzk) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, (Parcelable) zzag);
        zzs.zza(obtainAndWriteInterfaceToken, (Parcelable) zzk);
        zza(1, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzfv zzfv, zzk zzk) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, (Parcelable) zzfv);
        zzs.zza(obtainAndWriteInterfaceToken, (Parcelable) zzk);
        zza(2, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzk zzk) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, (Parcelable) zzk);
        zza(4, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzag zzag, String str, String str2) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, (Parcelable) zzag);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zza(5, obtainAndWriteInterfaceToken);
    }

    public final void zzb(zzk zzk) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, (Parcelable) zzk);
        zza(6, obtainAndWriteInterfaceToken);
    }

    public final List<zzfv> zza(zzk zzk, boolean z) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, (Parcelable) zzk);
        zzs.writeBoolean(obtainAndWriteInterfaceToken, z);
        obtainAndWriteInterfaceToken = transactAndReadException(7, obtainAndWriteInterfaceToken);
        List createTypedArrayList = obtainAndWriteInterfaceToken.createTypedArrayList(zzfv.CREATOR);
        obtainAndWriteInterfaceToken.recycle();
        return createTypedArrayList;
    }

    public final byte[] zza(zzag zzag, String str) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, (Parcelable) zzag);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken = transactAndReadException(9, obtainAndWriteInterfaceToken);
        byte[] createByteArray = obtainAndWriteInterfaceToken.createByteArray();
        obtainAndWriteInterfaceToken.recycle();
        return createByteArray;
    }

    public final void zza(long j, String str, String str2, String str3) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeLong(j);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeString(str3);
        zza(10, obtainAndWriteInterfaceToken);
    }

    public final String zzc(zzk zzk) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, (Parcelable) zzk);
        obtainAndWriteInterfaceToken = transactAndReadException(11, obtainAndWriteInterfaceToken);
        String readString = obtainAndWriteInterfaceToken.readString();
        obtainAndWriteInterfaceToken.recycle();
        return readString;
    }

    public final void zza(zzo zzo, zzk zzk) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, (Parcelable) zzo);
        zzs.zza(obtainAndWriteInterfaceToken, (Parcelable) zzk);
        zza(12, obtainAndWriteInterfaceToken);
    }

    public final void zzb(zzo zzo) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, (Parcelable) zzo);
        zza(13, obtainAndWriteInterfaceToken);
    }

    public final List<zzfv> zza(String str, String str2, boolean z, zzk zzk) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzs.writeBoolean(obtainAndWriteInterfaceToken, z);
        zzs.zza(obtainAndWriteInterfaceToken, (Parcelable) zzk);
        obtainAndWriteInterfaceToken = transactAndReadException(14, obtainAndWriteInterfaceToken);
        List createTypedArrayList = obtainAndWriteInterfaceToken.createTypedArrayList(zzfv.CREATOR);
        obtainAndWriteInterfaceToken.recycle();
        return createTypedArrayList;
    }

    public final List<zzfv> zza(String str, String str2, String str3, boolean z) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeString(str3);
        zzs.writeBoolean(obtainAndWriteInterfaceToken, z);
        obtainAndWriteInterfaceToken = transactAndReadException(15, obtainAndWriteInterfaceToken);
        List createTypedArrayList = obtainAndWriteInterfaceToken.createTypedArrayList(zzfv.CREATOR);
        obtainAndWriteInterfaceToken.recycle();
        return createTypedArrayList;
    }

    public final List<zzo> zza(String str, String str2, zzk zzk) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzs.zza(obtainAndWriteInterfaceToken, (Parcelable) zzk);
        obtainAndWriteInterfaceToken = transactAndReadException(16, obtainAndWriteInterfaceToken);
        List createTypedArrayList = obtainAndWriteInterfaceToken.createTypedArrayList(zzo.CREATOR);
        obtainAndWriteInterfaceToken.recycle();
        return createTypedArrayList;
    }

    public final List<zzo> zze(String str, String str2, String str3) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeString(str3);
        obtainAndWriteInterfaceToken = transactAndReadException(17, obtainAndWriteInterfaceToken);
        List createTypedArrayList = obtainAndWriteInterfaceToken.createTypedArrayList(zzo.CREATOR);
        obtainAndWriteInterfaceToken.recycle();
        return createTypedArrayList;
    }

    public final void zzd(zzk zzk) {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, (Parcelable) zzk);
        zza(18, obtainAndWriteInterfaceToken);
    }
}
