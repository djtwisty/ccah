package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzce;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zza;

@VisibleForTesting
final class zzdi extends zzeo<Void, zza> {
    private final UserProfileChangeRequest zzil;

    public zzdi(UserProfileChangeRequest userProfileChangeRequest) {
        super(2);
        this.zzil = (UserProfileChangeRequest) Preconditions.checkNotNull(userProfileChangeRequest, "request cannot be null");
    }

    public final String zzda() {
        return "updateProfile";
    }

    public final TaskApiCall<zzdq, Void> zzdb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures(this.zznr ? null : new Feature[]{zze.zzf}).run(new zzdj(this)).build();
    }

    public final void zzdd() {
        ((zza) this.zzne).zza(this.zznk, zzao.zza(this.zzgm, this.zznl));
        zzc(null);
    }

    final /* synthetic */ void zzaf(zzdq zzdq, TaskCompletionSource taskCompletionSource) {
        this.zzng = new zzew(this, taskCompletionSource);
        if (this.zznr) {
            zzdq.zzdh().zza(this.zznd.zzch(), this.zzil, this.zznc);
        } else {
            zzdq.zzdh().zza(new zzce(this.zzil, this.zznd.zzch()), this.zznc);
        }
    }
}
