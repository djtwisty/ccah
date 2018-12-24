package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzbi;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.internal.zza;

@VisibleForTesting
final class zzci extends zzeo<Void, zza> {
    private final zzbi zzlk;
    private final String zzll;

    public zzci(String str, ActionCodeSettings actionCodeSettings, String str2, String str3) {
        super(4);
        Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        this.zzlk = new zzbi(str, actionCodeSettings, str2);
        this.zzll = str3;
    }

    public final String zzda() {
        return this.zzll;
    }

    public final TaskApiCall<zzdq, Void> zzdb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures(this.zznr ? null : new Feature[]{zze.zzf}).run(new zzcj(this)).build();
    }

    public final void zzdd() {
        zzc(null);
    }

    final /* synthetic */ void zzt(zzdq zzdq, TaskCompletionSource taskCompletionSource) {
        this.zzng = new zzew(this, taskCompletionSource);
        if (this.zznr) {
            zzdq.zzdh().zzc(this.zzlk.getEmail(), this.zzlk.zzcq(), this.zznc);
        } else {
            zzdq.zzdh().zza(this.zzlk, this.zznc);
        }
    }
}
