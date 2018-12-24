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

@Class(creator = "PhoneAuthCredentialCreator")
public class PhoneAuthCredential extends AuthCredential implements Cloneable {
    public static final Creator<PhoneAuthCredential> CREATOR = new zzw();
    @Field(getter = "getSessionInfo", id = 1)
    private String zzhn;
    @Field(getter = "getSmsCode", id = 2)
    private String zzho;
    @Field(getter = "getHasVerificationProof", id = 3)
    private boolean zzhp;
    @Field(getter = "getPhoneNumber", id = 4)
    private String zzhq;
    @Field(getter = "getAutoCreate", id = 5)
    private boolean zzhr;
    @Field(getter = "getTemporaryProof", id = 6)
    private String zzhs;

    @Constructor
    PhoneAuthCredential(@Param(id = 1) String str, @Param(id = 2) String str2, @Param(id = 3) boolean z, @Param(id = 4) String str3, @Param(id = 5) boolean z2, @Param(id = 6) String str4) {
        boolean z3 = (z && !TextUtils.isEmpty(str3)) || !((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)));
        Preconditions.checkArgument(z3, "Cannot create PhoneAuthCredential without either verificationProof, sessionInfo, ortemprary proof.");
        this.zzhn = str;
        this.zzho = str2;
        this.zzhp = z;
        this.zzhq = str3;
        this.zzhr = z2;
        this.zzhs = str4;
    }

    public String getSmsCode() {
        return this.zzho;
    }

    public String getProvider() {
        return "phone";
    }

    public String getSignInMethod() {
        return "phone";
    }

    public final PhoneAuthCredential zzn(boolean z) {
        this.zzhr = false;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzhn, false);
        SafeParcelWriter.writeString(parcel, 2, getSmsCode(), false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzhp);
        SafeParcelWriter.writeString(parcel, 4, this.zzhq, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzhr);
        SafeParcelWriter.writeString(parcel, 6, this.zzhs, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public /* synthetic */ Object clone() {
        return new PhoneAuthCredential(this.zzhn, getSmsCode(), this.zzhp, this.zzhq, this.zzhr, this.zzhs);
    }
}
