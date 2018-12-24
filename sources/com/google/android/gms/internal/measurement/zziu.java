package com.google.android.gms.internal.measurement;

final class zziu implements Runnable {
    final /* synthetic */ zzin zzblk;

    zziu(zzin zzin) {
        this.zzblk = zzin;
    }

    public final void run() {
        this.zzblk.zzbif.execute(new zziv(this));
    }
}
