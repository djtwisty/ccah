package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@Class(creator = "LinkEmailAuthCredentialAidlRequestCreator")
public final class zzay extends AbstractSafeParcelable {
    public static final Creator<zzay> CREATOR = new zzaz();
    @Field(getter = "getEmail", id = 1)
    private final String zzgh;
    @Field(getter = "getPassword", id = 2)
    private final String zzgi;
    @Field(getter = "getCachedState", id = 3)
    private final String zzgk;

    @Constructor
    public zzay(@Param(id = 1) String str, @Param(id = 2) String str2, @Param(id = 3) String str3) {
        this.zzgh = str;
        this.zzgi = str2;
        this.zzgk = str3;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final String getPassword() {
        return this.zzgi;
    }

    public final String zzbx() {
        return this.zzgk;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgh, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzgi, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzgk, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
