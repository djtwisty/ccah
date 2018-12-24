package com.google.firebase.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.logging.Logger;

@Class(creator = "EmailAuthCredentialCreator")
public class EmailAuthCredential extends AuthCredential {
    public static final Creator<EmailAuthCredential> CREATOR = new zzf();
    private static final Logger zzgg = new Logger("EmailAuthCredential", new String[0]);
    @Field(getter = "getEmail", id = 1)
    private String zzgh;
    @Field(getter = "getPassword", id = 2)
    private String zzgi;
    @Field(getter = "getSignInLink", id = 3)
    private final String zzgj;
    @Field(getter = "getCachedState", id = 4)
    private String zzgk;
    @Field(getter = "isForLinking", id = 5)
    private boolean zzgl;

    @Constructor
    EmailAuthCredential(@Param(id = 1) String str, @Param(id = 2) String str2, @Param(id = 3) String str3, @Param(id = 4) String str4, @Param(id = 5) boolean z) {
        this.zzgh = Preconditions.checkNotEmpty(str);
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
        }
        this.zzgi = str2;
        this.zzgj = str3;
        this.zzgk = str4;
        this.zzgl = z;
    }

    EmailAuthCredential(String str, String str2) {
        this(str, str2, null, null, false);
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final String getPassword() {
        return this.zzgi;
    }

    public final String zzbw() {
        return this.zzgj;
    }

    public final String zzbx() {
        return this.zzgk;
    }

    public final boolean zzby() {
        return this.zzgl;
    }

    public final EmailAuthCredential zza(FirebaseUser firebaseUser) {
        this.zzgk = firebaseUser.zzch();
        this.zzgl = true;
        return this;
    }

    public String getProvider() {
        return "password";
    }

    public String getSignInMethod() {
        if (TextUtils.isEmpty(this.zzgi)) {
            return EmailAuthProvider.EMAIL_LINK_SIGN_IN_METHOD;
        }
        return "password";
    }

    public final boolean zzbz() {
        return !TextUtils.isEmpty(this.zzgj);
    }

    public static boolean isSignInWithEmailLink(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (zzbn(str)) {
                return true;
            }
            return zzbn(Uri.parse(str).getQueryParameter("link"));
        } catch (UnsupportedOperationException e) {
            Logger logger = zzgg;
            String str2 = "EmailAuthCredential";
            Object[] objArr = new Object[1];
            String str3 = "isSignInWithEmailLink returned an UnsupportedOperationException: ";
            String valueOf = String.valueOf(e.getMessage());
            objArr[0] = valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3);
            logger.m1074v(str2, objArr);
            return false;
        }
    }

    private static boolean zzbn(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        CharSequence queryParameter = parse.getQueryParameter("oobCode");
        Object queryParameter2 = parse.getQueryParameter("mode");
        if (TextUtils.isEmpty(queryParameter) || TextUtils.isEmpty(queryParameter2) || !queryParameter2.equals("signIn")) {
            return false;
        }
        return true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgh, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzgi, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzgj, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzgk, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzgl);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
