package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzbc;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zza;

@VisibleForTesting
final class zzdg extends zzeo<Void, zza> {
    private final PhoneAuthCredential zzif;

    public zzdg(PhoneAuthCredential phoneAuthCredential) {
        super(2);
        this.zzif = (PhoneAuthCredential) Preconditions.checkNotNull(phoneAuthCredential);
    }

    public final String zzda() {
        return "updatePhoneNumber";
    }

    public final TaskApiCall<zzdq, Void> zzdb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures(this.zznr ? null : new Feature[]{zze.zzf}).run(new zzdh(this)).build();
    }

    public final void zzdd() {
        ((zza) this.zzne).zza(this.zznk, zzao.zza(this.zzgm, this.zznl));
        zzc(null);
    }

    final /* synthetic */ void zzae(zzdq zzdq, TaskCompletionSource taskCompletionSource) {
        this.zzng = new zzew(this, taskCompletionSource);
        if (this.zznr) {
            zzdq.zzdh().zza(this.zznd.zzch(), this.zzif, this.zznc);
        } else {
            zzdq.zzdh().zza(new zzbc(this.zznd.zzch(), this.zzif), this.zznc);
        }
    }
}
