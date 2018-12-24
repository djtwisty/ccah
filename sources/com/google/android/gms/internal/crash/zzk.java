package com.google.android.gms.internal.crash;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "FirebaseCrashOptionsCreator")
@Reserved({1})
public final class zzk extends AbstractSafeParcelable {
    public static final Creator<zzk> CREATOR = new zzl();
    @Field(getter = "getAppID", id = 2)
    private String zzak;
    @Field(getter = "getApiKey", id = 3)
    private String zzal;

    @Constructor
    public zzk(@Param(id = 2) String str, @Param(id = 3) String str2) {
        this.zzak = str;
        this.zzal = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzak, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzal, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
