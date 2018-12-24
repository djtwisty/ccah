package com.google.android.gms.internal.measurement;

final class zzpq implements Runnable {
    private final /* synthetic */ String zzbok;
    private final /* synthetic */ zzpc zzbol;
    private final /* synthetic */ zzpo zzbom;

    zzpq(zzpo zzpo, String str, zzpc zzpc) {
        this.zzbom = zzpo;
        this.zzbok = str;
        this.zzbol = zzpc;
    }

    public final void run() {
        this.zzbom.zzb(this.zzbok, this.zzbol);
    }
}
