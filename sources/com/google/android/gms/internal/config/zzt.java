package com.google.android.gms.internal.config;

import com.google.android.gms.common.api.Status;

final class zzt extends zzq {
    private final /* synthetic */ zzs zzq;

    zzt(zzs zzs) {
        this.zzq = zzs;
    }

    public final void zza(Status status, zzad zzad) {
        if (zzad.getStatusCode() == 6502 || zzad.getStatusCode() == 6507) {
            this.zzq.setResult(new zzu(zzo.zzd(zzad.getStatusCode()), zzo.zza(zzad), zzad.getThrottleEndTimeMillis(), zzo.zzb(zzad)));
        } else {
            this.zzq.setResult(new zzu(zzo.zzd(zzad.getStatusCode()), zzo.zza(zzad), zzo.zzb(zzad)));
        }
    }
}
