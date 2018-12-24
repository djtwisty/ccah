package com.google.firebase.auth.api.internal;

import android.os.IInterface;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzcg;
import com.google.android.gms.internal.firebase_auth.zzcj;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdg;
import com.google.firebase.auth.PhoneAuthCredential;

public interface zzdx extends IInterface {
    void onFailure(Status status);

    void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential);

    void zza(Status status, PhoneAuthCredential phoneAuthCredential);

    void zza(zzcg zzcg);

    void zza(zzcj zzcj);

    void zza(zzcz zzcz, zzct zzct);

    void zza(zzdg zzdg);

    void zzb(zzcz zzcz);

    void zzbs(String str);

    void zzbt(String str);

    void zzbu(String str);

    void zzde();

    void zzdf();

    void zzdg();
}
