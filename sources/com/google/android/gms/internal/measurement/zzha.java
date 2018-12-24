package com.google.android.gms.internal.measurement;

import java.util.Map;

final class zzha implements Runnable {
    private final /* synthetic */ long zzbcr;
    private final /* synthetic */ String zzbcs;
    private final /* synthetic */ zzgy zzbjh;
    private final /* synthetic */ String zzbji;
    private final /* synthetic */ String zzbjj;
    private final /* synthetic */ Map zzbjk;
    private final /* synthetic */ String zzbjl;
    private final /* synthetic */ zzgz zzbjm;

    zzha(zzgz zzgz, zzgy zzgy, long j, String str, String str2, String str3, Map map, String str4) {
        this.zzbjm = zzgz;
        this.zzbjh = zzgy;
        this.zzbcr = j;
        this.zzbcs = str;
        this.zzbji = str2;
        this.zzbjj = str3;
        this.zzbjk = map;
        this.zzbjl = str4;
    }

    public final void run() {
        if (this.zzbjm.zzbjg == null) {
            zzid zzrj = zzid.zzrj();
            zzrj.zza(this.zzbjm.zzri, this.zzbjh);
            this.zzbjm.zzbjg = zzrj.zzrk();
        }
        this.zzbjm.zzbjg.zza(this.zzbcr, this.zzbcs, this.zzbji, this.zzbjj, this.zzbjk, this.zzbjl);
    }
}
