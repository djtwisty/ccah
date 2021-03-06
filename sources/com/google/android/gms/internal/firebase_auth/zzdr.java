package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.internal.firebase_auth.zzft.zza;
import com.google.android.gms.internal.firebase_auth.zzj.zzp;
import com.google.firebase.auth.api.internal.zzff;

@Class(creator = "VerifyAssertionRequestCreator")
@Reserved({1})
public final class zzdr extends AbstractSafeParcelable implements zzff<zzp> {
    public static final Creator<zzdr> CREATOR = new zzds();
    @Field(getter = "getProviderId", id = 6)
    private String zzgb;
    @Field(getter = "getIdToken", id = 4)
    private String zzgc;
    @Field(getter = "getAccessToken", id = 5)
    private String zzgd;
    @Field(getter = "getPendingToken", id = 17)
    private String zzgf;
    @Field(getter = "getEmail", id = 7)
    private String zzgh;
    @Field(getter = "getTenantId", id = 15)
    private String zzgw;
    @Field(getter = "getAutoCreate", id = 11)
    private boolean zzhr;
    @Field(getter = "getReturnSecureToken", id = 10)
    private boolean zzpt;
    @Field(getter = "getRequestUri", id = 2)
    private String zzpx;
    @Field(getter = "getCurrentIdToken", id = 3)
    private String zzpy;
    @Field(getter = "getPostBody", id = 8)
    private String zzpz;
    @Field(getter = "getOauthTokenSecret", id = 9)
    private String zzqa;
    @Field(getter = "getAuthCode", id = 12)
    private String zzqb;
    @Field(getter = "getSessionId", id = 13)
    private String zzqc;
    @Field(getter = "getIdpResponseUrl", id = 14)
    private String zzqd;
    @Field(getter = "getReturnIdpCredential", id = 16)
    private boolean zzqe;

    public zzdr() {
        this.zzpt = true;
        this.zzhr = true;
    }

    @Constructor
    zzdr(@Param(id = 2) String str, @Param(id = 3) String str2, @Param(id = 4) String str3, @Param(id = 5) String str4, @Param(id = 6) String str5, @Param(id = 7) String str6, @Param(id = 8) String str7, @Param(id = 9) String str8, @Param(id = 10) boolean z, @Param(id = 11) boolean z2, @Param(id = 12) String str9, @Param(id = 13) String str10, @Param(id = 14) String str11, @Param(id = 15) String str12, @Param(id = 16) boolean z3, @Param(id = 17) String str13) {
        this.zzpx = str;
        this.zzpy = str2;
        this.zzgc = str3;
        this.zzgd = str4;
        this.zzgb = str5;
        this.zzgh = str6;
        this.zzpz = str7;
        this.zzqa = str8;
        this.zzpt = z;
        this.zzhr = z2;
        this.zzqb = str9;
        this.zzqc = str10;
        this.zzqd = str11;
        this.zzgw = str12;
        this.zzqe = z3;
        this.zzgf = str13;
    }

    public zzdr(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.zzpx = "http://localhost";
        this.zzgc = str;
        this.zzgd = str2;
        this.zzqa = str5;
        this.zzqb = str6;
        this.zzgw = str7;
        this.zzgf = str8;
        this.zzpt = true;
        if (TextUtils.isEmpty(this.zzgc) && TextUtils.isEmpty(this.zzgd) && TextUtils.isEmpty(this.zzqb)) {
            throw new IllegalArgumentException("idToken, accessToken and authCode cannot all be null");
        }
        this.zzgb = Preconditions.checkNotEmpty(str3);
        this.zzgh = null;
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.zzgc)) {
            stringBuilder.append("id_token=").append(this.zzgc).append("&");
        }
        if (!TextUtils.isEmpty(this.zzgd)) {
            stringBuilder.append("access_token=").append(this.zzgd).append("&");
        }
        if (!TextUtils.isEmpty(this.zzgh)) {
            stringBuilder.append("identifier=").append(this.zzgh).append("&");
        }
        if (!TextUtils.isEmpty(this.zzqa)) {
            stringBuilder.append("oauth_token_secret=").append(this.zzqa).append("&");
        }
        if (!TextUtils.isEmpty(this.zzqb)) {
            stringBuilder.append("code=").append(this.zzqb).append("&");
        }
        stringBuilder.append("providerId=").append(this.zzgb);
        this.zzpz = stringBuilder.toString();
        this.zzhr = true;
    }

    public final zzdr zzcq(String str) {
        this.zzpy = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzdr zzp(boolean z) {
        this.zzhr = false;
        return this;
    }

    public final zzdr zzcr(String str) {
        this.zzgw = str;
        return this;
    }

    public final zzdr zzq(boolean z) {
        this.zzqe = z;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzpx, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzpy, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzgc, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzgd, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzgb, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzgh, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzpz, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzqa, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzpt);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzhr);
        SafeParcelWriter.writeString(parcel, 12, this.zzqb, false);
        SafeParcelWriter.writeString(parcel, 13, this.zzqc, false);
        SafeParcelWriter.writeString(parcel, 14, this.zzqd, false);
        SafeParcelWriter.writeString(parcel, 15, this.zzgw, false);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzqe);
        SafeParcelWriter.writeString(parcel, 17, this.zzgf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final /* synthetic */ zzhc zzds() {
        zza zzk = zzp.zzas().zzi(this.zzpt).zzk(this.zzhr);
        if (this.zzpy != null) {
            zzk.zzbe(this.zzpy);
        }
        if (this.zzpx != null) {
            zzk.zzbb(this.zzpx);
        }
        if (this.zzpz != null) {
            zzk.zzbc(this.zzpz);
        }
        if (this.zzgw != null) {
            zzk.zzbf(this.zzgw);
        }
        if (this.zzgf != null) {
            zzk.zzbg(this.zzgf);
        }
        if (!TextUtils.isEmpty(this.zzqc)) {
            zzk.zzbd(this.zzqc);
        }
        if (!TextUtils.isEmpty(this.zzqd)) {
            zzk.zzbb(this.zzqd);
        }
        zzk.zzj(this.zzqe);
        return (zzp) ((zzft) zzk.zzhn());
    }
}
