package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class zzfs implements Callable<String> {
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzfo zzaue;

    zzfs(zzfo zzfo, zzk zzk) {
        this.zzaue = zzfo;
        this.zzaqk = zzk;
    }

    public final /* synthetic */ Object call() {
        zzg zza;
        if (this.zzaue.zzgv().zzba(this.zzaqk.packageName)) {
            zza = this.zzaue.zzg(this.zzaqk);
        } else {
            zza = this.zzaue.zzjt().zzbm(this.zzaqk.packageName);
        }
        if (zza != null) {
            return zza.getAppInstanceId();
        }
        this.zzaue.zzgt().zzjj().zzby("App info was null when attempting to get app instance id");
        return null;
    }
}
