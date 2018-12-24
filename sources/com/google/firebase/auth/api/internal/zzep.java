package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzcg;
import com.google.android.gms.internal.firebase_auth.zzcj;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdg;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;

@VisibleForTesting
final class zzep extends zzdy {
    final /* synthetic */ zzeo zznx;

    zzep(zzeo zzeo) {
        this.zznx = zzeo;
    }

    public final void zzb(zzcz zzcz) {
        boolean z = true;
        if (this.zznx.zznb != 1) {
            z = false;
        }
        Preconditions.checkState(z, "Unexpected response type: " + this.zznx.zznb);
        this.zznx.zznk = zzcz;
        this.zznx.zzdp();
    }

    public final void zza(zzcz zzcz, zzct zzct) {
        Preconditions.checkState(this.zznx.zznb == 2, "Unexpected response type: " + this.zznx.zznb);
        this.zznx.zznk = zzcz;
        this.zznx.zznl = zzct;
        this.zznx.zzdp();
    }

    public final void zza(zzcj zzcj) {
        Preconditions.checkState(this.zznx.zznb == 3, "Unexpected response type " + this.zznx.zznb);
        this.zznx.zznm = zzcj;
        this.zznx.zzdp();
    }

    public final void zza(zzdg zzdg) {
        Preconditions.checkState(this.zznx.zznb == 4, "Unexpected response type " + this.zznx.zznb);
        this.zznx.zznn = zzdg;
        this.zznx.zzdp();
    }

    public final void zzde() {
        Preconditions.checkState(this.zznx.zznb == 5, "Unexpected response type " + this.zznx.zznb);
        this.zznx.zzdp();
    }

    public final void zzdf() {
        Preconditions.checkState(this.zznx.zznb == 6, "Unexpected response type " + this.zznx.zznb);
        this.zznx.zzdp();
    }

    public final void zzbs(String str) {
        Preconditions.checkState(this.zznx.zznb == 7, "Unexpected response type " + this.zznx.zznb);
        this.zznx.zzno = str;
        this.zznx.zzdp();
    }

    public final void zzbt(String str) {
        Preconditions.checkState(this.zznx.zznb == 8, "Unexpected response type " + this.zznx.zznb);
        this.zznx.zzhn = str;
        zza(new zzeq(this, str));
    }

    public final void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
        Preconditions.checkState(this.zznx.zznb == 8, "Unexpected response type " + this.zznx.zznb);
        this.zznx.zzns = true;
        this.zznx.zznt = true;
        zza(new zzer(this, phoneAuthCredential));
    }

    public final void zzbu(String str) {
        Preconditions.checkState(this.zznx.zznb == 8, "Unexpected response type " + this.zznx.zznb);
        this.zznx.zzhn = str;
        this.zznx.zzns = true;
        this.zznx.zznt = true;
        zza(new zzes(this, str));
    }

    public final void onFailure(Status status) {
        if (this.zznx.zznb == 8) {
            this.zznx.zzns = true;
            this.zznx.zznt = false;
            zza(new zzet(this, status));
            return;
        }
        this.zznx.zzd(status);
        this.zznx.zzc(status);
    }

    public final void zza(Status status, PhoneAuthCredential phoneAuthCredential) {
        Preconditions.checkState(this.zznx.zznb == 2, "Unexpected response type " + this.zznx.zznb);
        zzb(status, phoneAuthCredential, null);
    }

    public final void zza(zzcg zzcg) {
        zzb(zzcg.getStatus(), zzcg.zzcv(), zzcg.getEmail());
    }

    private final void zzb(Status status, AuthCredential authCredential, String str) {
        this.zznx.zzd(status);
        this.zznx.zznp = authCredential;
        this.zznx.zznq = str;
        if (this.zznx.zznf != null) {
            this.zznx.zznf.zza(status);
        }
        this.zznx.zzc(status);
    }

    public final void zzdg() {
        Preconditions.checkState(this.zznx.zznb == 9, "Unexpected response type " + this.zznx.zznb);
        this.zznx.zzdp();
    }

    private final void zza(zzev zzev) {
        this.zznx.zznj.execute(new zzeu(this, zzev));
    }
}
