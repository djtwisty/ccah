package com.google.android.gms.internal.measurement;

final class zziv implements Runnable {
    private final /* synthetic */ zziu zzbls;

    zziv(zziu zziu) {
        this.zzbls = zziu;
    }

    public final void run() {
        if (this.zzbls.zzblk.zzblg == 1 || this.zzbls.zzblk.zzblg == 2) {
            this.zzbls.zzblk.zzblg = 4;
            zzhk.m1081e("Container load timed out after 5000ms.");
            while (!this.zzbls.zzblk.zzblh.isEmpty()) {
                this.zzbls.zzblk.zzbif.execute((Runnable) this.zzbls.zzblk.zzblh.remove());
            }
        }
    }
}
