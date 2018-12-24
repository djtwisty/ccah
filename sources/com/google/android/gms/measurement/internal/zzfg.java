package com.google.android.gms.measurement.internal;

final class zzfg extends zzy {
    private final /* synthetic */ zzfd zzatd;

    zzfg(zzfd zzfd, zzct zzct) {
        this.zzatd = zzfd;
        super(zzct);
    }

    public final void run() {
        zzcr zzcr = this.zzatd;
        zzcr.zzaf();
        zzcr.zzgt().zzjo().zzby("Current session is expired, remove the session number and Id");
        if (zzcr.zzgv().zzbg(zzcr.zzgk().zzal())) {
            zzcr.zzgj().zza("auto", "_sid", null, zzcr.zzbx().currentTimeMillis());
        }
        if (zzcr.zzgv().zzbh(zzcr.zzgk().zzal())) {
            zzcr.zzgj().zza("auto", "_sno", null, zzcr.zzbx().currentTimeMillis());
        }
    }
}
