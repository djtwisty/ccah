package com.google.android.gms.internal.measurement;

final class zzps implements Runnable {
    private final /* synthetic */ String zzbok;
    private final /* synthetic */ zzpo zzbom;
    private final /* synthetic */ byte[] zzboo;

    zzps(zzpo zzpo, String str, byte[] bArr) {
        this.zzbom = zzpo;
        this.zzbok = str;
        this.zzboo = bArr;
    }

    public final void run() {
        this.zzbom.zzc(this.zzbok, this.zzboo);
    }
}
