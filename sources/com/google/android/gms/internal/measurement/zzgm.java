package com.google.android.gms.internal.measurement;

final class zzgm implements Runnable {
    private final /* synthetic */ zzgf zzbim;
    private final zzpm zzbio;

    zzgm(zzgf zzgf, zzpm zzpm) {
        this.zzbim = zzgf;
        this.zzbio = zzpm;
    }

    public final void run() {
        String valueOf;
        zzqb zzse = this.zzbio.zzrz().zzse();
        zzqj zzsa = this.zzbio.zzsa();
        Object obj = this.zzbim.zzbij == null ? 1 : null;
        this.zzbim.zzbij = this.zzbim.zzbid.zza(zzse, zzsa);
        this.zzbim.state = 2;
        String zzd = this.zzbim.zzazo;
        zzhk.m1082v(new StringBuilder(String.valueOf(zzd).length() + 48).append("Container ").append(zzd).append(" loaded during runtime initialization.").toString());
        if (this.zzbim.zzbik != null) {
            for (zzgt zzgt : this.zzbim.zzbik) {
                String str = "Evaluating tags for pending event ";
                valueOf = String.valueOf(zzgt.zzqt());
                zzhk.m1082v(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                this.zzbim.zzbij.zzb(zzgt);
            }
            this.zzbim.zzbik = null;
        }
        this.zzbim.zzbij.dispatch();
        valueOf = "Runtime initialized successfully for container ";
        zzd = String.valueOf(this.zzbim.zzazo);
        zzhk.m1082v(zzd.length() != 0 ? valueOf.concat(zzd) : new String(valueOf));
        long zzsf = this.zzbio.zzrz().zzsf() + this.zzbim.zzbii.zznz();
        if (obj == null || !this.zzbim.zzbil || this.zzbio.getSource() != 1 || zzsf >= this.zzbim.zzrz.currentTimeMillis()) {
            this.zzbim.zzar(Math.max(900000, zzsf - this.zzbim.zzrz.currentTimeMillis()));
        } else {
            this.zzbim.zzar(this.zzbim.zzbii.zzqr());
        }
    }
}
