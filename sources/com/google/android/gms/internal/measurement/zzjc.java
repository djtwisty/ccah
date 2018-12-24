package com.google.android.gms.internal.measurement;

final class zzjc implements Runnable {
    private final /* synthetic */ zzja zzbma;
    private final /* synthetic */ zzgt zzbmb;

    zzjc(zzja zzja, zzgt zzgt) {
        this.zzbma = zzja;
        this.zzbmb = zzgt;
    }

    public final void run() {
        if (this.zzbma.zzblx.isEmpty()) {
            zzhk.m1081e("TagManagerBackend emit called without loaded container.");
            return;
        }
        for (zzgf zza : this.zzbma.zzblx.values()) {
            zza.zza(this.zzbmb);
        }
    }
}
