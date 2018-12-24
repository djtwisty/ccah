package com.google.firebase.auth.api.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zza;
import com.google.android.gms.internal.firebase_auth.zzc;
import com.google.android.gms.internal.firebase_auth.zzcg;
import com.google.android.gms.internal.firebase_auth.zzcj;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdg;
import com.google.firebase.auth.PhoneAuthCredential;

public final class zzdz extends zza implements zzdx {
    zzdz(IBinder iBinder) {
        super(iBinder, "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
    }

    public final void zzb(zzcz zzcz) {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzcz);
        zzb(1, zza);
    }

    public final void zza(zzcz zzcz, zzct zzct) {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzcz);
        zzc.zza(zza, (Parcelable) zzct);
        zzb(2, zza);
    }

    public final void zza(zzcj zzcj) {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzcj);
        zzb(3, zza);
    }

    public final void zza(zzdg zzdg) {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzdg);
        zzb(4, zza);
    }

    public final void onFailure(Status status) {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) status);
        zzb(5, zza);
    }

    public final void zzde() {
        zzb(6, zza());
    }

    public final void zzdf() {
        zzb(7, zza());
    }

    public final void zzbs(String str) {
        Parcel zza = zza();
        zza.writeString(str);
        zzb(8, zza);
    }

    public final void zzbt(String str) {
        Parcel zza = zza();
        zza.writeString(str);
        zzb(9, zza);
    }

    public final void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) phoneAuthCredential);
        zzb(10, zza);
    }

    public final void zzbu(String str) {
        Parcel zza = zza();
        zza.writeString(str);
        zzb(11, zza);
    }

    public final void zza(Status status, PhoneAuthCredential phoneAuthCredential) {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) status);
        zzc.zza(zza, (Parcelable) phoneAuthCredential);
        zzb(12, zza);
    }

    public final void zzdg() {
        zzb(13, zza());
    }

    public final void zza(zzcg zzcg) {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzcg);
        zzb(14, zza);
    }
}
