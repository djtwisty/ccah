package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AccountType;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

@Class(creator = "GoogleSignInAccountCreator")
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<GoogleSignInAccount> CREATOR = new zab();
    @VisibleForTesting
    private static Clock zae = DefaultClock.getInstance();
    @Field(getter = "getId", id = 2)
    private String mId;
    @VersionField(id = 1)
    private final int versionCode;
    @Field(getter = "getIdToken", id = 3)
    private String zaf;
    @Field(getter = "getEmail", id = 4)
    private String zag;
    @Field(getter = "getDisplayName", id = 5)
    private String zah;
    @Field(getter = "getPhotoUrl", id = 6)
    private Uri zai;
    @Field(getter = "getServerAuthCode", id = 7)
    private String zaj;
    @Field(getter = "getExpirationTimeSecs", id = 8)
    private long zak;
    @Field(getter = "getObfuscatedIdentifier", id = 9)
    private String zal;
    @Field(id = 10)
    private List<Scope> zam;
    @Field(getter = "getGivenName", id = 11)
    private String zan;
    @Field(getter = "getFamilyName", id = 12)
    private String zao;
    private Set<Scope> zap = new HashSet();

    public static GoogleSignInAccount zaa(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri uri;
        JSONObject jSONObject = new JSONObject(str);
        Object optString = jSONObject.optString("photoUrl", null);
        if (TextUtils.isEmpty(optString)) {
            uri = null;
        } else {
            uri = Uri.parse(optString);
        }
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        Set hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        GoogleSignInAccount zaa = zaa(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString(Scopes.EMAIL, null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), uri, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        zaa.zaj = jSONObject.optString("serverAuthCode", null);
        return zaa;
    }

    private static GoogleSignInAccount zaa(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set<Scope> set) {
        if (l == null) {
            l = Long.valueOf(zae.currentTimeMillis() / 1000);
        }
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l.longValue(), Preconditions.checkNotEmpty(str7), new ArrayList((Collection) Preconditions.checkNotNull(set)), str5, str6);
    }

    @KeepForSdk
    public static GoogleSignInAccount createDefault() {
        Account account = new Account("<<default account>>", AccountType.GOOGLE);
        Set hashSet = new HashSet();
        return zaa(null, null, account.name, null, null, null, null, Long.valueOf(0), account.name, hashSet);
    }

    @Constructor
    GoogleSignInAccount(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) String str2, @Param(id = 4) String str3, @Param(id = 5) String str4, @Param(id = 6) Uri uri, @Param(id = 7) String str5, @Param(id = 8) long j, @Param(id = 9) String str6, @Param(id = 10) List<Scope> list, @Param(id = 11) String str7, @Param(id = 12) String str8) {
        this.versionCode = i;
        this.mId = str;
        this.zaf = str2;
        this.zag = str3;
        this.zah = str4;
        this.zai = uri;
        this.zaj = str5;
        this.zak = j;
        this.zal = str6;
        this.zam = list;
        this.zan = str7;
        this.zao = str8;
    }

    public String getId() {
        return this.mId;
    }

    public String getIdToken() {
        return this.zaf;
    }

    public String getEmail() {
        return this.zag;
    }

    public Account getAccount() {
        return this.zag == null ? null : new Account(this.zag, AccountType.GOOGLE);
    }

    public String getDisplayName() {
        return this.zah;
    }

    public String getGivenName() {
        return this.zan;
    }

    public String getFamilyName() {
        return this.zao;
    }

    public Uri getPhotoUrl() {
        return this.zai;
    }

    @KeepForSdk
    public GoogleSignInAccount requestExtraScopes(Scope... scopeArr) {
        if (scopeArr != null) {
            Collections.addAll(this.zap, scopeArr);
        }
        return this;
    }

    public String getServerAuthCode() {
        return this.zaj;
    }

    @KeepForSdk
    public boolean isExpired() {
        return zae.currentTimeMillis() / 1000 >= this.zak - 300;
    }

    public final String zab() {
        return this.zal;
    }

    public Set<Scope> getGrantedScopes() {
        return new HashSet(this.zam);
    }

    @KeepForSdk
    public Set<Scope> getRequestedScopes() {
        Set<Scope> hashSet = new HashSet(this.zam);
        hashSet.addAll(this.zap);
        return hashSet;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, getId(), false);
        SafeParcelWriter.writeString(parcel, 3, getIdToken(), false);
        SafeParcelWriter.writeString(parcel, 4, getEmail(), false);
        SafeParcelWriter.writeString(parcel, 5, getDisplayName(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, getPhotoUrl(), i, false);
        SafeParcelWriter.writeString(parcel, 7, getServerAuthCode(), false);
        SafeParcelWriter.writeLong(parcel, 8, this.zak);
        SafeParcelWriter.writeString(parcel, 9, this.zal, false);
        SafeParcelWriter.writeTypedList(parcel, 10, this.zam, false);
        SafeParcelWriter.writeString(parcel, 11, getGivenName(), false);
        SafeParcelWriter.writeString(parcel, 12, getFamilyName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public int hashCode() {
        return ((this.zal.hashCode() + 527) * 31) + getRequestedScopes().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (googleSignInAccount.zal.equals(this.zal) && googleSignInAccount.getRequestedScopes().equals(getRequestedScopes())) {
            return true;
        }
        return false;
    }

    public final String zac() {
        JSONObject zad = zad();
        zad.remove("serverAuthCode");
        return zad.toString();
    }

    private final JSONObject zad() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (getId() != null) {
                jSONObject.put("id", getId());
            }
            if (getIdToken() != null) {
                jSONObject.put("tokenId", getIdToken());
            }
            if (getEmail() != null) {
                jSONObject.put(Scopes.EMAIL, getEmail());
            }
            if (getDisplayName() != null) {
                jSONObject.put("displayName", getDisplayName());
            }
            if (getGivenName() != null) {
                jSONObject.put("givenName", getGivenName());
            }
            if (getFamilyName() != null) {
                jSONObject.put("familyName", getFamilyName());
            }
            if (getPhotoUrl() != null) {
                jSONObject.put("photoUrl", getPhotoUrl().toString());
            }
            if (getServerAuthCode() != null) {
                jSONObject.put("serverAuthCode", getServerAuthCode());
            }
            jSONObject.put("expirationTime", this.zak);
            jSONObject.put("obfuscatedIdentifier", this.zal);
            JSONArray jSONArray = new JSONArray();
            Scope[] scopeArr = (Scope[]) this.zam.toArray(new Scope[this.zam.size()]);
            Arrays.sort(scopeArr, zaa.zaq);
            for (Scope scopeUri : scopeArr) {
                jSONArray.put(scopeUri.getScopeUri());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
