package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzj.zzb;
import com.google.firebase.auth.api.internal.zzdw;
import java.util.ArrayList;
import java.util.List;

@Class(creator = "CreateAuthUriResponseCreator")
@Reserved({1})
public final class zzcj extends AbstractSafeParcelable implements zzdw<zzcj, zzb> {
    public static final Creator<zzcj> CREATOR = new zzck();
    @Field(getter = "getProviderId", id = 4)
    private String zzgb;
    @Field(getter = "getAuthUri", id = 2)
    private String zzol;
    @Field(getter = "isRegistered", id = 3)
    private boolean zzom;
    @Field(getter = "isForExistingProvider", id = 5)
    private boolean zzon;
    @Field(getter = "getStringList", id = 6)
    private zzdp zzoo;
    @Field(getter = "getSignInMethods", id = 7)
    private List<String> zzop;

    public zzcj() {
        this.zzoo = zzdp.zzec();
    }

    @Constructor
    public zzcj(@Param(id = 2) String str, @Param(id = 3) boolean z, @Param(id = 4) String str2, @Param(id = 5) boolean z2, @Param(id = 6) zzdp zzdp, @Param(id = 7) List<String> list) {
        this.zzol = str;
        this.zzom = z;
        this.zzgb = str2;
        this.zzon = z2;
        this.zzoo = zzdp == null ? zzdp.zzec() : zzdp.zza(zzdp);
        this.zzop = list;
    }

    public final List<String> getAllProviders() {
        return this.zzoo.zzeb();
    }

    public final List<String> getSignInMethods() {
        return this.zzop;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzol, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzom);
        SafeParcelWriter.writeString(parcel, 4, this.zzgb, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzon);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzoo, i, false);
        SafeParcelWriter.writeStringList(parcel, 7, this.zzop, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzhm<zzb> zzdj() {
        return zzb.zzl();
    }

    public final /* synthetic */ zzdw zza(zzhc zzhc) {
        if (zzhc instanceof zzb) {
            zzdp zzec;
            zzb zzb = (zzb) zzhc;
            this.zzol = Strings.emptyToNull(zzb.zze());
            this.zzom = zzb.zzh();
            this.zzgb = Strings.emptyToNull(zzb.getProviderId());
            this.zzon = zzb.zzi();
            if (zzb.zzg() == 0) {
                zzec = zzdp.zzec();
            } else {
                zzec = new zzdp(1, new ArrayList(zzb.zzf()));
            }
            this.zzoo = zzec;
            this.zzop = zzb.zzk() == 0 ? new ArrayList(0) : zzb.zzj();
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of CreateAuthUriResponse.");
    }
}
