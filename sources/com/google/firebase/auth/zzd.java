package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.internal.firebase_auth.zzdr;

@Class(creator = "DefaultOAuthCredentialCreator")
public class zzd extends zzv {
    public static final Creator<zzd> CREATOR = new zze();
    @Field(getter = "getProvider", id = 1)
    private final String zzgb;
    @Field(getter = "getIdToken", id = 2)
    private final String zzgc;
    @Field(getter = "getAccessToken", id = 3)
    private final String zzgd;
    @Field(getter = "getWebSignInCredential", id = 4)
    private final zzdr zzge;
    @Field(getter = "getPendingToken", id = 5)
    private final String zzgf;

    @Constructor
    zzd(@Param(id = 1) String str, @Param(id = 2) String str2, @Param(id = 3) String str3, @Param(id = 4) zzdr zzdr, @Param(id = 5) String str4) {
        this.zzgb = str;
        this.zzgc = str2;
        this.zzgd = str3;
        this.zzge = zzdr;
        this.zzgf = str4;
    }

    public static zzd zza(String str, String str2, String str3) {
        return zzb(str, str2, str3, null);
    }

    public static zzd zza(String str, String str2, String str3, String str4) {
        return zzb(str, str2, str3, str4);
    }

    private static zzd zzb(String str, String str2, String str3, String str4) {
        Preconditions.checkNotEmpty(str, "Must specify a non-empty providerId");
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            return new zzd(str, str2, str3, null, str4);
        }
        throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
    }

    public static zzd zza(zzdr zzdr) {
        Preconditions.checkNotNull(zzdr, "Must specify a non-null webSignInCredential");
        return new zzd(null, null, null, zzdr, null);
    }

    public String getProvider() {
        return this.zzgb;
    }

    public String getSignInMethod() {
        return this.zzgb;
    }

    public final String zzay() {
        return this.zzgf;
    }

    public static zzdr zza(zzd zzd, String str) {
        Preconditions.checkNotNull(zzd);
        if (zzd.zzge != null) {
            return zzd.zzge;
        }
        return new zzdr(zzd.zzgc, zzd.zzgd, zzd.getProvider(), null, null, null, str, zzd.zzgf);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getProvider(), false);
        SafeParcelWriter.writeString(parcel, 2, this.zzgc, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzgd, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzge, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzgf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
