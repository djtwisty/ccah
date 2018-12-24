package com.google.android.gms.internal.measurement;

final class zzgg implements Runnable {
    private final /* synthetic */ zzgf zzbim;

    zzgg(zzgf zzgf) {
        this.zzbim = zzgf;
    }

    public final void run() {
        if (this.zzbim.state == 2) {
            this.zzbim.zzbij.dispatch();
        }
    }
}
