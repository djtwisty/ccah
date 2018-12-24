package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.zzd;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Class(creator = "DefaultFirebaseUserCreator")
public class zzl extends FirebaseUser {
    public static final Creator<zzl> CREATOR = new zzm();
    @Field(getter = "getDefaultOAuthCredential", id = 11)
    private zzd zzin;
    @Field(getter = "isNewUser", id = 10)
    private boolean zzor;
    @Field(getter = "getCachedTokenState", id = 1)
    private zzcz zzqr;
    @Field(getter = "getDefaultAuthUserInfo", id = 2)
    private zzh zzqs;
    @Field(getter = "getFirebaseAppName", id = 3)
    private String zzqt;
    @Field(getter = "getUserType", id = 4)
    private String zzqu;
    @Field(getter = "getUserInfos", id = 5)
    private List<zzh> zzqv;
    @Field(getter = "getProviders", id = 6)
    private List<String> zzqw;
    @Field(getter = "getCurrentVersion", id = 7)
    private String zzqx;
    @Field(getter = "isAnonymous", id = 8)
    private Boolean zzqy;
    @Field(getter = "getMetadata", id = 9)
    private zzn zzqz;

    @Constructor
    zzl(@Param(id = 1) zzcz zzcz, @Param(id = 2) zzh zzh, @Param(id = 3) String str, @Param(id = 4) String str2, @Param(id = 5) List<zzh> list, @Param(id = 6) List<String> list2, @Param(id = 7) String str3, @Param(id = 8) Boolean bool, @Param(id = 9) zzn zzn, @Param(id = 10) boolean z, @Param(id = 11) zzd zzd) {
        this.zzqr = zzcz;
        this.zzqs = zzh;
        this.zzqt = str;
        this.zzqu = str2;
        this.zzqv = list;
        this.zzqw = list2;
        this.zzqx = str3;
        this.zzqy = bool;
        this.zzqz = zzn;
        this.zzor = z;
        this.zzin = zzd;
    }

    public zzl(FirebaseApp firebaseApp, List<? extends UserInfo> list) {
        Preconditions.checkNotNull(firebaseApp);
        this.zzqt = firebaseApp.getName();
        this.zzqu = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.zzqx = "2";
        zza((List) list);
    }

    public String getDisplayName() {
        return this.zzqs.getDisplayName();
    }

    public Uri getPhotoUrl() {
        return this.zzqs.getPhotoUrl();
    }

    public String getEmail() {
        return this.zzqs.getEmail();
    }

    public String getPhoneNumber() {
        return this.zzqs.getPhoneNumber();
    }

    public final String zzcf() {
        if (this.zzqr == null || this.zzqr.zzdw() == null) {
            return null;
        }
        String str;
        Map map = (Map) zzaa.zzcv(this.zzqr.zzdw()).getClaims().get(FirebaseAuthProvider.PROVIDER_ID);
        if (map != null) {
            str = (String) map.get("tenant");
        } else {
            str = null;
        }
        return str;
    }

    public final zzl zzct(String str) {
        this.zzqx = str;
        return this;
    }

    public String getProviderId() {
        return this.zzqs.getProviderId();
    }

    public final FirebaseApp zzcc() {
        return FirebaseApp.getInstance(this.zzqt);
    }

    public final List<zzh> zzef() {
        return this.zzqv;
    }

    public String getUid() {
        return this.zzqs.getUid();
    }

    public boolean isAnonymous() {
        if (this.zzqy == null || this.zzqy.booleanValue()) {
            String str = "";
            if (this.zzqr != null) {
                GetTokenResult zzcv = zzaa.zzcv(this.zzqr.zzdw());
                str = zzcv != null ? zzcv.getSignInProvider() : "";
            }
            boolean z = getProviderData().size() <= 1 && (str == null || !str.equals("custom"));
            this.zzqy = Boolean.valueOf(z);
        }
        return this.zzqy.booleanValue();
    }

    public final List<String> getProviders() {
        return this.zzqw;
    }

    public final FirebaseUser zza(List<? extends UserInfo> list) {
        Preconditions.checkNotNull(list);
        this.zzqv = new ArrayList(list.size());
        this.zzqw = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            UserInfo userInfo = (UserInfo) list.get(i);
            if (userInfo.getProviderId().equals(FirebaseAuthProvider.PROVIDER_ID)) {
                this.zzqs = (zzh) userInfo;
            } else {
                this.zzqw.add(userInfo.getProviderId());
            }
            this.zzqv.add((zzh) userInfo);
        }
        if (this.zzqs == null) {
            this.zzqs = (zzh) this.zzqv.get(0);
        }
        return this;
    }

    public List<? extends UserInfo> getProviderData() {
        return this.zzqv;
    }

    public final zzcz zzcg() {
        return this.zzqr;
    }

    public final String zzci() {
        return zzcg().zzdw();
    }

    public final String zzch() {
        return this.zzqr.zzdz();
    }

    public final void zza(zzcz zzcz) {
        this.zzqr = (zzcz) Preconditions.checkNotNull(zzcz);
    }

    public boolean isEmailVerified() {
        return this.zzqs.isEmailVerified();
    }

    public final void zza(zzn zzn) {
        this.zzqz = zzn;
    }

    public FirebaseUserMetadata getMetadata() {
        return this.zzqz;
    }

    public final void zzr(boolean z) {
        this.zzor = z;
    }

    public final boolean isNewUser() {
        return this.zzor;
    }

    public final void zzb(zzd zzd) {
        this.zzin = zzd;
    }

    public final zzd zzcv() {
        return this.zzin;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, zzcg(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzqs, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzqt, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzqu, false);
        SafeParcelWriter.writeTypedList(parcel, 5, this.zzqv, false);
        SafeParcelWriter.writeStringList(parcel, 6, getProviders(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzqx, false);
        SafeParcelWriter.writeBooleanObject(parcel, 8, Boolean.valueOf(isAnonymous()), false);
        SafeParcelWriter.writeParcelable(parcel, 9, getMetadata(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzor);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzin, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public static FirebaseUser zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser) {
        FirebaseUser zzl = new zzl(firebaseApp, firebaseUser.getProviderData());
        if (firebaseUser instanceof zzl) {
            zzl zzl2 = (zzl) firebaseUser;
            zzl.zzqx = zzl2.zzqx;
            zzl.zzqu = zzl2.zzqu;
            zzl.zzqz = (zzn) zzl2.getMetadata();
        } else {
            zzl.zzqz = null;
        }
        if (firebaseUser.zzcg() != null) {
            zzl.zza(firebaseUser.zzcg());
        }
        if (!firebaseUser.isAnonymous()) {
            zzl.zzce();
        }
        return zzl;
    }

    public final /* synthetic */ FirebaseUser zzce() {
        this.zzqy = Boolean.valueOf(false);
        return this;
    }
}
