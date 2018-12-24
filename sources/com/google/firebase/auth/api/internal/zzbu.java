package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzbw;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzf;

@VisibleForTesting
final class zzbu extends zzeo<AuthResult, zza> {
    private final zzbw zzky;

    public zzbu(EmailAuthCredential emailAuthCredential) {
        super(2);
        Preconditions.checkNotNull(emailAuthCredential, "credential cannot be null or empty");
        this.zzky = new zzbw(emailAuthCredential);
    }

    public final String zzda() {
        return "reauthenticateWithEmailLinkWithData";
    }

    public final TaskApiCall<zzdq, AuthResult> zzdb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures(this.zznr ? null : new Feature[]{zze.zzf}).run(new zzbv(this)).build();
    }

    public final void zzdd() {
        FirebaseUser zza = zzao.zza(this.zzgm, this.zznl);
        if (this.zznd.getUid().equalsIgnoreCase(zza.getUid())) {
            ((zza) this.zzne).zza(this.zznk, zza);
            zzc(new zzf(zza));
            return;
        }
        zzc(new Status(FirebaseError.ERROR_USER_MISMATCH));
    }

    final /* synthetic */ void zzn(zzdq zzdq, TaskCompletionSource taskCompletionSource) {
        this.zzng = new zzew(this, taskCompletionSource);
        if (this.zznr) {
            zzdq.zzdh().zza(this.zzky.zzct(), this.zznc);
        } else {
            zzdq.zzdh().zza(this.zzky, this.zznc);
        }
    }
}
