package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzba;
import com.google.android.gms.internal.firebase_auth.zzdr;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzb;
import com.google.firebase.auth.internal.zzf;

@VisibleForTesting
final class zzbi extends zzeo<AuthResult, zza> {
    private final zzdr zzkr;

    public zzbi(AuthCredential authCredential) {
        super(2);
        Preconditions.checkNotNull(authCredential, "credential cannot be null");
        this.zzkr = zzb.zza(authCredential, null);
    }

    public final String zzda() {
        return "linkFederatedCredential";
    }

    public final TaskApiCall<zzdq, AuthResult> zzdb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures(this.zznr ? null : new Feature[]{zze.zzf}).run(new zzbj(this)).build();
    }

    public final void zzdd() {
        FirebaseUser zza = zzao.zza(this.zzgm, this.zznl);
        ((zza) this.zzne).zza(this.zznk, zza);
        zzc(new zzf(zza));
    }

    final /* synthetic */ void zzh(zzdq zzdq, TaskCompletionSource taskCompletionSource) {
        this.zzng = new zzew(this, taskCompletionSource);
        if (this.zznr) {
            zzdq.zzdh().zza(this.zznd.zzch(), this.zzkr, this.zznc);
        } else {
            zzdq.zzdh().zza(new zzba(this.zznd.zzch(), this.zzkr), this.zznc);
        }
    }
}
