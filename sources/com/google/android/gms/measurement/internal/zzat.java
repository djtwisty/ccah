package com.google.android.gms.measurement.internal;

final class zzat implements Runnable {
    private final /* synthetic */ int zzamd;
    private final /* synthetic */ String zzame;
    private final /* synthetic */ Object zzamf;
    private final /* synthetic */ Object zzamg;
    private final /* synthetic */ Object zzamh;
    private final /* synthetic */ zzas zzami;

    zzat(zzas zzas, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzami = zzas;
        this.zzamd = i;
        this.zzame = str;
        this.zzamf = obj;
        this.zzamg = obj2;
        this.zzamh = obj3;
    }

    public final void run() {
        zzcs zzgu = this.zzami.zzada.zzgu();
        if (zzgu.isInitialized()) {
            if (this.zzami.zzals == '\u0000') {
                zzas zzas;
                if (this.zzami.zzgv().zzdw()) {
                    zzas = this.zzami;
                    this.zzami.zzgw();
                    zzas.zzals = 'C';
                } else {
                    zzas = this.zzami;
                    this.zzami.zzgw();
                    zzas.zzals = 'c';
                }
            }
            if (this.zzami.zzade < 0) {
                this.zzami.zzade = this.zzami.zzgv().zzhh();
            }
            char charAt = "01VDIWEA?".charAt(this.zzamd);
            char zza = this.zzami.zzals;
            long zzb = this.zzami.zzade;
            String zza2 = zzas.zza(true, this.zzame, this.zzamf, this.zzamg, this.zzamh);
            String stringBuilder = new StringBuilder(String.valueOf(zza2).length() + 24).append("2").append(charAt).append(zza).append(zzb).append(":").append(zza2).toString();
            if (stringBuilder.length() > 1024) {
                stringBuilder = this.zzame.substring(0, 1024);
            }
            zzgu.zzamz.zzc(stringBuilder, 1);
            return;
        }
        this.zzami.zza(6, "Persisted config not initialized. Not logging error/warn");
    }
}
