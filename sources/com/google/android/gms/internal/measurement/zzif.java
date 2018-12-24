package com.google.android.gms.internal.measurement;

final class zzif implements Runnable {
    private final /* synthetic */ zzid zzbkv;

    zzif(zzid zzid) {
        this.zzbkv = zzid;
    }

    public final void run() {
        this.zzbkv.zzbkr = false;
        this.zzbkv.zzbkp.dispatch();
    }
}
