package com.google.android.gms.internal.measurement;

import android.net.Uri;

final class zziy implements Runnable {
    private final /* synthetic */ zzin zzblk;
    private final /* synthetic */ Uri zzblu;

    zziy(zzin zzin, Uri uri) {
        this.zzblk = zzin;
        this.zzblu = uri;
    }

    public final void run() {
        String valueOf = String.valueOf(this.zzblu);
        zzhk.m1082v(new StringBuilder(String.valueOf(valueOf).length() + 25).append("Preview requested to uri ").append(valueOf).toString());
        synchronized (this.zzblk.zzble) {
            if (this.zzblk.zzblg == 2) {
                zzhk.m1082v("Still initializing. Defer preview container loading.");
                this.zzblk.zzblh.add(this);
                return;
            }
            valueOf = (String) this.zzblk.zzc(null).first;
            if (valueOf == null) {
                zzhk.zzab("Preview failed (no container found)");
            } else if (!this.zzblk.zzblc.zza(valueOf, this.zzblu)) {
                valueOf = String.valueOf(this.zzblu);
                zzhk.zzab(new StringBuilder(String.valueOf(valueOf).length() + 73).append("Cannot preview the app with the uri: ").append(valueOf).append(". Launching current version instead.").toString());
            } else if (this.zzblk.zzrm) {
                valueOf = String.valueOf(this.zzblu);
                zzhk.zzdm(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Starting to load preview container: ").append(valueOf).toString());
                if (this.zzblk.zzblb.zzro()) {
                    this.zzblk.zzrm = false;
                    this.zzblk.zzblg = 1;
                    this.zzblk.zzq();
                    return;
                }
                zzhk.zzab("Failed to reset TagManager service for preview");
            } else {
                valueOf = String.valueOf(this.zzblu);
                zzhk.m1082v(new StringBuilder(String.valueOf(valueOf).length() + 84).append("Deferring container loading for preview uri: ").append(valueOf).append("(Tag Manager has not been initialized).").toString());
            }
        }
    }
}
