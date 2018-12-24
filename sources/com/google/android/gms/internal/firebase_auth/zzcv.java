package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzj.zzg;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Class(creator = "GetAccountInfoUserListCreator")
@Reserved({1})
public final class zzcv extends AbstractSafeParcelable {
    public static final Creator<zzcv> CREATOR = new zzcw();
    @Field(getter = "getUsers", id = 2)
    private List<zzct> zzpe;

    public zzcv() {
        this.zzpe = new ArrayList();
    }

    public final List<zzct> zzdt() {
        return this.zzpe;
    }

    @Constructor
    zzcv(@Param(id = 2) List<zzct> list) {
        List emptyList;
        if (list == null) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = Collections.unmodifiableList(list);
        }
        this.zzpe = emptyList;
    }

    public static zzcv zza(zzcv zzcv) {
        Preconditions.checkNotNull(zzcv);
        Collection collection = zzcv.zzpe;
        zzcv zzcv2 = new zzcv();
        if (!(collection == null || collection.isEmpty())) {
            zzcv2.zzpe.addAll(collection);
        }
        return zzcv2;
    }

    public static zzcv zza(zzg zzg) {
        ArrayList arrayList = new ArrayList(zzg.zzx());
        for (int i = 0; i < zzg.zzx(); i++) {
            zzr zza = zzg.zza(i);
            arrayList.add(new zzct(Strings.emptyToNull(zza.getLocalId()), Strings.emptyToNull(zza.getEmail()), zza.zzan(), Strings.emptyToNull(zza.getDisplayName()), Strings.emptyToNull(zza.zzal()), zzdd.zzc(zza.zzak()), Strings.emptyToNull(zza.zzbm()), Strings.emptyToNull(zza.getPhoneNumber()), zza.zzbl(), zza.zzbk(), false, null));
        }
        return new zzcv(arrayList);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzpe, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
