package com.google.android.gms.internal.measurement;

final class zzjb implements Runnable {
    private final /* synthetic */ String zzblp;
    private final /* synthetic */ String zzblq;
    private final /* synthetic */ String zzblr;
    private final /* synthetic */ zzhd zzblz;
    private final /* synthetic */ zzja zzbma;

    zzjb(zzja zzja, String str, String str2, String str3, zzhd zzhd) {
        this.zzbma = zzja;
        this.zzblp = str;
        this.zzblq = str2;
        this.zzblr = str3;
        this.zzblz = zzhd;
    }

    public final void run() {
        boolean z = true;
        try {
            if (!this.zzbma.zzblx.containsKey(this.zzblp)) {
                this.zzbma.zzblx.put(this.zzblp, this.zzbma.zzbly.zzg(this.zzblp, this.zzblq, this.zzblr));
            }
        } catch (Throwable e) {
            zzgp.zza("Fail to load container: ", e, this.zzbma.zzri);
            z = false;
        }
        try {
            if (this.zzblz != null) {
                this.zzblz.zza(z, this.zzblp);
            }
        } catch (Throwable e2) {
            zzgp.zza("Error relaying callback: ", e2, this.zzbma.zzri);
        }
    }
}
