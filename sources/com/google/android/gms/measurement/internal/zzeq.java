package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzdq;

final class zzeq implements Runnable {
    private final /* synthetic */ String zzads;
    private final /* synthetic */ String zzadz;
    private final /* synthetic */ boolean zzaeg;
    private final /* synthetic */ zzdq zzagg;
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzeb zzasi;

    zzeq(zzeb zzeb, String str, String str2, boolean z, zzk zzk, zzdq zzdq) {
        this.zzasi = zzeb;
        this.zzads = str;
        this.zzadz = str2;
        this.zzaeg = z;
        this.zzaqk = zzk;
        this.zzagg = zzdq;
    }

    public final void run() {
        Bundle bundle = new Bundle();
        try {
            zzaj zzd = this.zzasi.zzasc;
            if (zzd == null) {
                this.zzasi.zzgt().zzjg().zze("Failed to get user properties", this.zzads, this.zzadz);
                return;
            }
            bundle = zzfy.zzd(zzd.zza(this.zzads, this.zzadz, this.zzaeg, this.zzaqk));
            this.zzasi.zzcy();
            this.zzasi.zzgr().zza(this.zzagg, bundle);
        } catch (RemoteException e) {
            this.zzasi.zzgt().zzjg().zze("Failed to get user properties", this.zzads, e);
        } finally {
            this.zzasi.zzgr().zza(this.zzagg, bundle);
        }
    }
}
