package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzaw;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ProviderQueryResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzp;

@VisibleForTesting
final class zzba extends zzeo<ProviderQueryResult, zza> {
    private final zzaw zzkl;

    public zzba(String str, String str2) {
        super(3);
        Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        this.zzkl = new zzaw(str, str2);
    }

    public final String zzda() {
        return "fetchProvidersForEmail";
    }

    public final TaskApiCall<zzdq, ProviderQueryResult> zzdb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures(this.zznr ? null : new Feature[]{zze.zzf}).run(new zzbb(this)).build();
    }

    public final void zzdd() {
        zzc(new zzp(this.zznm));
    }

    final /* synthetic */ void zzd(zzdq zzdq, TaskCompletionSource taskCompletionSource) {
        this.zzng = new zzew(this, taskCompletionSource);
        if (this.zznr) {
            zzdq.zzdh().zzc(this.zzkl.getEmail(), this.zznc);
        } else {
            zzdq.zzdh().zza(this.zzkl, this.zznc);
        }
    }
}
