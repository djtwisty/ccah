package com.google.android.gms.internal.measurement;

final class zziz implements Runnable {
    private final /* synthetic */ String zzblp;
    private final /* synthetic */ boolean zzblv;
    private final /* synthetic */ zzb zzblw;

    zziz(zzb zzb, boolean z, String str) {
        this.zzblw = zzb;
        this.zzblv = z;
        this.zzblp = str;
    }

    public final void run() {
        if (this.zzblw.zzblk.zzblg == 2) {
            String str;
            if (this.zzblv) {
                this.zzblw.zzblk.zzblg = 3;
                str = this.zzblp;
                zzhk.m1082v(new StringBuilder(String.valueOf(str).length() + 18).append("Container ").append(str).append(" loaded.").toString());
            } else {
                this.zzblw.zzblk.zzblg = 4;
                String str2 = "Error loading container:";
                str = String.valueOf(this.zzblp);
                zzhk.m1081e(str.length() != 0 ? str2.concat(str) : new String(str2));
            }
            while (!this.zzblw.zzblk.zzblh.isEmpty()) {
                this.zzblw.zzblk.zzbif.execute((Runnable) this.zzblw.zzblk.zzblh.remove());
            }
            return;
        }
        zzhk.zzab("Container load callback completed after timeout");
    }
}
