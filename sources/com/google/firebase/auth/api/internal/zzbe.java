package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzau;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzaa;

@VisibleForTesting
final class zzbe extends zzeo<GetTokenResult, zza> {
    private final zzau zzko;

    public zzbe(String str) {
        super(1);
        Preconditions.checkNotEmpty(str, "refresh token cannot be null");
        this.zzko = new zzau(str);
    }

    public final String zzda() {
        return "getAccessToken";
    }

    public final TaskApiCall<zzdq, GetTokenResult> zzdb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures(this.zznr ? null : new Feature[]{zze.zzf}).run(new zzbf(this)).build();
    }

    public final void zzdd() {
        if (TextUtils.isEmpty(this.zznk.zzr())) {
            this.zznk.zzce(this.zzko.zzr());
        }
        ((zza) this.zzne).zza(this.zznk, this.zznd);
        zzc(zzaa.zzcv(this.zznk.zzdw()));
    }

    final /* synthetic */ void zzf(zzdq zzdq, TaskCompletionSource taskCompletionSource) {
        this.zzng = new zzew(this, taskCompletionSource);
        if (this.zznr) {
            zzdq.zzdh().zza(this.zzko.zzr(), this.zznc);
        } else {
            zzdq.zzdh().zza(this.zzko, this.zznc);
        }
    }
}
