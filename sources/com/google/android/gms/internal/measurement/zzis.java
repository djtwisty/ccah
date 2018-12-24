package com.google.android.gms.internal.measurement;

import android.os.Bundle;

final class zzis implements Runnable {
    private final /* synthetic */ String val$name;
    private final /* synthetic */ String zzads;
    private final /* synthetic */ Bundle zzaep;
    private final /* synthetic */ long zzark;
    private boolean zzbll = false;
    private final /* synthetic */ String zzblm;
    private final /* synthetic */ zzir zzblo;

    zzis(zzir zzir, String str, Bundle bundle, String str2, long j, String str3) {
        this.zzblo = zzir;
        this.val$name = str;
        this.zzaep = bundle;
        this.zzblm = str2;
        this.zzark = j;
        this.zzads = str3;
    }

    public final void run() {
        if (this.zzblo.zzblk.zzblg == 3) {
            this.zzblo.zzblk.zzblb.zza(this.val$name, this.zzaep, this.zzblm, this.zzark, false);
        } else if (this.zzblo.zzblk.zzblg == 1 || this.zzblo.zzblk.zzblg == 2) {
            if (this.zzbll) {
                zzhk.zzab("Invalid state - not expecting to see a deferred event during container loading.");
                return;
            }
            zzhk.m1082v(String.format("Container not loaded yet: deferring event listener by enqueuing the event: name = %s, origin = %s, params = %s.", new Object[]{this.val$name, this.zzads, this.zzaep}));
            this.zzbll = true;
            this.zzblo.zzblk.zzblh.add(this);
        } else if (this.zzblo.zzblk.zzblg == 4) {
            zzhk.m1082v(String.format("Container failed to load: skipping event listener by ignoring the event: name = %s, origin = %s, params = %s.", new Object[]{this.val$name, this.zzads, this.zzaep}));
        } else {
            zzgp.zzb("Unexpected state:" + this.zzblo.zzblk.zzblg, this.zzblo.zzblk.zzri);
        }
    }
}
