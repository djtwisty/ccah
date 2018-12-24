package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzbq;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzb;

@VisibleForTesting
final class zzbo extends zzeo<Void, zza> {
    private final zzbq zzkv;

    public zzbo(AuthCredential authCredential, String str) {
        super(2);
        Preconditions.checkNotNull(authCredential, "credential cannot be null");
        this.zzkv = new zzbq(zzb.zza(authCredential, str).zzp(false));
    }

    public final String zzda() {
        return "reauthenticateWithCredential";
    }

    public final TaskApiCall<zzdq, Void> zzdb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures(this.zznr ? null : new Feature[]{zze.zzf}).run(new zzbp(this)).build();
    }

    public final void zzdd() {
        FirebaseUser zza = zzao.zza(this.zzgm, this.zznl);
        if (this.zznd.getUid().equalsIgnoreCase(zza.getUid())) {
            ((zza) this.zzne).zza(this.zznk, zza);
            zzc(null);
            return;
        }
        zzc(new Status(FirebaseError.ERROR_USER_MISMATCH));
    }

    final /* synthetic */ void zzk(zzdq zzdq, TaskCompletionSource taskCompletionSource) {
        this.zzng = new zzew(this, taskCompletionSource);
        if (this.zznr) {
            zzdq.zzdh().zza(this.zzkv.zzco(), this.zznc);
        } else {
            zzdq.zzdh().zza(this.zzkv, this.zznc);
        }
    }
}
