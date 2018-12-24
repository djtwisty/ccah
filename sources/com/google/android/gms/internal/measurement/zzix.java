package com.google.android.gms.internal.measurement;

final class zzix implements Runnable {
    private final /* synthetic */ zziw zzblt;

    zzix(zziw zziw) {
        this.zzblt = zziw;
    }

    public final void run() {
        zzhk.m1082v("App's UI deactivated. Dispatching hits.");
        this.zzblt.zzblk.zzblb.dispatch();
    }
}
