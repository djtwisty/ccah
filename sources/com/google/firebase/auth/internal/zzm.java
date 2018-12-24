package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.firebase.auth.zzd;
import java.util.List;

public final class zzm implements Creator<zzl> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzl[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z = false;
        zzd zzd = null;
        zzn zzn = null;
        Boolean bool = null;
        String str = null;
        List list = null;
        List list2 = null;
        String str2 = null;
        String str3 = null;
        zzh zzh = null;
        zzcz zzcz = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    zzcz = (zzcz) SafeParcelReader.createParcelable(parcel, readHeader, zzcz.CREATOR);
                    break;
                case 2:
                    zzh = (zzh) SafeParcelReader.createParcelable(parcel, readHeader, zzh.CREATOR);
                    break;
                case 3:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    list2 = SafeParcelReader.createTypedList(parcel, readHeader, zzh.CREATOR);
                    break;
                case 6:
                    list = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 7:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 8:
                    bool = SafeParcelReader.readBooleanObject(parcel, readHeader);
                    break;
                case 9:
                    zzn = (zzn) SafeParcelReader.createParcelable(parcel, readHeader, zzn.CREATOR);
                    break;
                case 10:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    zzd = (zzd) SafeParcelReader.createParcelable(parcel, readHeader, zzd.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzl(zzcz, zzh, str3, str2, list2, list, str, bool, zzn, z, zzd);
    }
}
