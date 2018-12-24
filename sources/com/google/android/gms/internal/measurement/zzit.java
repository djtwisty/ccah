package com.google.android.gms.internal.measurement;

final class zzit implements Runnable {
    private final /* synthetic */ zzin zzblk;
    private final /* synthetic */ String zzblp;
    private final /* synthetic */ String zzblq;
    private final /* synthetic */ String zzblr = null;

    zzit(zzin zzin, String str, String str2, String str3) {
        this.zzblk = zzin;
        this.zzblp = str;
        this.zzblq = str2;
    }

    public final void run() {
        String str = this.zzblp;
        zzhk.m1082v(new StringBuilder(String.valueOf(str).length() + 28).append("Starting to load container ").append(str).append(".").toString());
        if (this.zzblk.zzblg != 1) {
            zzgp.zzb("Unexpected state - container loading already initiated.", this.zzblk.zzri);
            return;
        }
        this.zzblk.zzblg = 2;
        this.zzblk.zzblb.zzb(this.zzblp, this.zzblq, this.zzblr, new zzb());
    }
}
