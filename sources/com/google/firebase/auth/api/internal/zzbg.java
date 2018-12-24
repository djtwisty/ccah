package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzay;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzf;

@VisibleForTesting
final class zzbg extends zzeo<AuthResult, zza> {
    private final EmailAuthCredential zzij;

    public zzbg(EmailAuthCredential emailAuthCredential) {
        super(2);
        this.zzij = (EmailAuthCredential) Preconditions.checkNotNull(emailAuthCredential, "credential cannot be null");
        Preconditions.checkNotEmpty(emailAuthCredential.getEmail(), "email cannot be null");
        Preconditions.checkNotEmpty(emailAuthCredential.getPassword(), "password cannot be null");
    }

    public final String zzda() {
        return "linkEmailAuthCredential";
    }

    public final TaskApiCall<zzdq, AuthResult> zzdb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures(this.zznr ? null : new Feature[]{zze.zzf}).run(new zzbh(this)).build();
    }

    public final void zzdd() {
        FirebaseUser zza = zzao.zza(this.zzgm, this.zznl);
        ((zza) this.zzne).zza(this.zznk, zza);
        zzc(new zzf(zza));
    }

    final /* synthetic */ void zzg(zzdq zzdq, TaskCompletionSource taskCompletionSource) {
        this.zzng = new zzew(this, taskCompletionSource);
        if (this.zznr) {
            zzdq.zzdh().zza(this.zzij.getEmail(), this.zzij.getPassword(), this.zznd.zzch(), this.zznc);
        } else {
            zzdq.zzdh().zza(new zzay(this.zzij.getEmail(), this.zzij.getPassword(), this.zznd.zzch()), this.zznc);
        }
    }
}
