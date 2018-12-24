package com.google.android.gms.internal.measurement;

final class zzpr implements Runnable {
    private final /* synthetic */ String zzbok;
    private final /* synthetic */ zzpc zzbol;
    private final /* synthetic */ zzpo zzbom;
    private final /* synthetic */ String zzbon;

    zzpr(zzpo zzpo, String str, String str2, zzpc zzpc) {
        this.zzbom = zzpo;
        this.zzbok = str;
        this.zzbon = str2;
        this.zzbol = zzpc;
    }

    public final void run() {
        this.zzbom.zzb(this.zzbok, this.zzbon, this.zzbol);
    }
}
