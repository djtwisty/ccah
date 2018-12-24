package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzdq;

final class zzeg implements Runnable {
    private final /* synthetic */ zzdq zzagg;
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzeb zzasi;

    zzeg(zzeb zzeb, zzk zzk, zzdq zzdq) {
        this.zzasi = zzeb;
        this.zzaqk = zzk;
        this.zzagg = zzdq;
    }

    public final void run() {
        try {
            zzaj zzd = this.zzasi.zzasc;
            if (zzd == null) {
                this.zzasi.zzgt().zzjg().zzby("Failed to get app instance id");
                return;
            }
            String zzc = zzd.zzc(this.zzaqk);
            if (zzc != null) {
                this.zzasi.zzgj().zzcp(zzc);
                this.zzasi.zzgu().zzanh.zzcd(zzc);
            }
            this.zzasi.zzcy();
            this.zzasi.zzgr().zzb(this.zzagg, zzc);
        } catch (RemoteException e) {
            this.zzasi.zzgt().zzjg().zzg("Failed to get app instance id", e);
        } finally {
            this.zzasi.zzgr().zzb(this.zzagg, null);
        }
    }
}
