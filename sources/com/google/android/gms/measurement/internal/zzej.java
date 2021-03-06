package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzdq;

final class zzej implements Runnable {
    private final /* synthetic */ zzdq zzagg;
    private final /* synthetic */ zzag zzagi;
    private final /* synthetic */ String zzagj;
    private final /* synthetic */ zzeb zzasi;

    zzej(zzeb zzeb, zzag zzag, String str, zzdq zzdq) {
        this.zzasi = zzeb;
        this.zzagi = zzag;
        this.zzagj = str;
        this.zzagg = zzdq;
    }

    public final void run() {
        byte[] bArr = null;
        try {
            zzaj zzd = this.zzasi.zzasc;
            if (zzd == null) {
                this.zzasi.zzgt().zzjg().zzby("Discarding data. Failed to send event to service to bundle");
                return;
            }
            bArr = zzd.zza(this.zzagi, this.zzagj);
            this.zzasi.zzcy();
            this.zzasi.zzgr().zza(this.zzagg, bArr);
        } catch (RemoteException e) {
            this.zzasi.zzgt().zzjg().zzg("Failed to send event to the service to bundle", e);
        } finally {
            this.zzasi.zzgr().zza(this.zzagg, bArr);
        }
    }
}
