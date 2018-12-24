package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzdg implements Runnable {
    private final /* synthetic */ zzda zzare;
    private final /* synthetic */ long zzark;

    zzdg(zzda zzda, long j) {
        this.zzare = zzda;
        this.zzark = j;
    }

    public final void run() {
        boolean z = true;
        zzcr zzcr = this.zzare;
        long j = this.zzark;
        zzcr.zzaf();
        zzcr.zzgg();
        zzcr.zzcl();
        zzcr.zzgt().zzjn().zzby("Resetting analytics data (FE)");
        zzcr.zzgo().zzln();
        if (zzcr.zzgv().zzbc(zzcr.zzgk().zzal())) {
            zzcr.zzgu().zzanf.set(j);
        }
        boolean isEnabled = zzcr.zzada.isEnabled();
        if (!zzcr.zzgv().zzhz()) {
            zzcr.zzgu().zzi(!isEnabled);
        }
        zzcr.zzgl().resetAnalyticsData();
        if (isEnabled) {
            z = false;
        }
        zzcr.zzarc = z;
        if (this.zzare.zzgv().zza(zzai.zzalb)) {
            this.zzare.zzgl().zza(new AtomicReference());
        }
    }
}
