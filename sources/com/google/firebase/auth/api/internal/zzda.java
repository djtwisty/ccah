package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzcc;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzf;

@VisibleForTesting
final class zzda extends zzeo<AuthResult, zza> {
    private String zzik;

    public zzda(String str) {
        super(2);
        this.zzik = Preconditions.checkNotEmpty(str, "provider cannot be null or empty");
    }

    public final String zzda() {
        return "unlinkFederatedCredential";
    }

    public final TaskApiCall<zzdq, AuthResult> zzdb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures(this.zznr ? null : new Feature[]{zze.zzf}).run(new zzdb(this)).build();
    }

    public final void zzdd() {
        FirebaseUser zza = zzao.zza(this.zzgm, this.zznl);
        ((zza) this.zzne).zza(this.zznk, zza);
        zzc(new zzf(zza));
    }

    final /* synthetic */ void zzab(zzdq zzdq, TaskCompletionSource taskCompletionSource) {
        this.zzng = new zzew(this, taskCompletionSource);
        if (this.zznr) {
            zzdq.zzdh().zze(this.zzik, this.zznd.zzch(), this.zznc);
        } else {
            zzdq.zzdh().zza(new zzcc(this.zzik, this.zznd.zzch()), this.zznc);
        }
    }
}
