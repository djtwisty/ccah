package com.google.android.gms.internal.measurement;

final class zzgk implements Runnable {
    private final /* synthetic */ zzgf zzbim;
    private final zzgt zzbin;

    public zzgk(zzgf zzgf, zzgt zzgt) {
        this.zzbim = zzgf;
        this.zzbin = zzgt;
    }

    public final void run() {
        String str;
        String valueOf;
        if (this.zzbim.state == 2) {
            str = "Evaluating tags for event ";
            valueOf = String.valueOf(this.zzbin.zzqt());
            zzhk.m1082v(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            this.zzbim.zzbij.zzb(this.zzbin);
        } else if (this.zzbim.state == 1) {
            this.zzbim.zzbik.add(this.zzbin);
            valueOf = this.zzbin.zzqt();
            zzhk.m1082v(new StringBuilder(String.valueOf(valueOf).length() + 30).append("Added event ").append(valueOf).append(" to pending queue.").toString());
        } else if (this.zzbim.state == 3) {
            valueOf = this.zzbin.zzqt();
            zzhk.m1082v(new StringBuilder(String.valueOf(valueOf).length() + 61).append("Failed to evaluate tags for event ").append(valueOf).append(" (container failed to load)").toString());
            if (this.zzbin.zzqw()) {
                try {
                    this.zzbim.zzbih.logEventInternalNoInterceptor("app", this.zzbin.zzqt(), this.zzbin.zzqu(), this.zzbin.currentTimeMillis());
                    valueOf = this.zzbin.zzqt();
                    zzhk.m1082v(new StringBuilder(String.valueOf(valueOf).length() + 38).append("Logged passthrough event ").append(valueOf).append(" to Firebase.").toString());
                    return;
                } catch (Throwable e) {
                    zzgp.zza("Error logging event with measurement proxy:", e, this.zzbim.zzri);
                    return;
                }
            }
            str = "Discarded non-passthrough event ";
            valueOf = String.valueOf(this.zzbin.zzqt());
            zzhk.m1082v(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }
}
