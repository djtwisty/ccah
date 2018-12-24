package com.google.android.gms.internal.measurement;

final class zzgh implements Runnable {
    private final /* synthetic */ zzgf zzbim;

    zzgh(zzgf zzgf) {
        this.zzbim = zzgf;
    }

    public final void run() {
        this.zzbim.zzbif.execute(new zzgl(this.zzbim, null));
    }
}
