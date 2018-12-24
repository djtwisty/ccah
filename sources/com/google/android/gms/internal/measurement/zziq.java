package com.google.android.gms.internal.measurement;

import android.os.Bundle;

final class zziq implements Runnable {
    private final /* synthetic */ String val$name;
    private final /* synthetic */ String zzads;
    private final /* synthetic */ Bundle zzaep;
    private final /* synthetic */ long zzark;
    private boolean zzbll = false;
    private final /* synthetic */ String zzblm;
    private final /* synthetic */ zzip zzbln;

    zziq(zzip zzip, String str, Bundle bundle, String str2, long j, String str3) {
        this.zzbln = zzip;
        this.val$name = str;
        this.zzaep = bundle;
        this.zzblm = str2;
        this.zzark = j;
        this.zzads = str3;
    }

    public final void run() {
        if (this.zzbln.zzblk.zzblg == 3) {
            this.zzbln.zzblk.zzblb.zza(this.val$name, this.zzaep, this.zzblm, this.zzark, true);
        } else if (this.zzbln.zzblk.zzblg == 4) {
            zzhk.m1082v(String.format("Container failed to load: skipping  event interceptor by logging event back to Firebase directly: name = %s, origin = %s, params = %s.", new Object[]{this.val$name, this.zzblm, this.zzaep}));
            try {
                this.zzbln.zzblk.zzbih.logEventInternalNoInterceptor(this.zzblm, this.val$name, this.zzaep, this.zzark);
            } catch (Throwable e) {
                zzgp.zza("Error logging event on measurement proxy: ", e, this.zzbln.zzblk.zzri);
            }
        } else if (this.zzbln.zzblk.zzblg != 1 && this.zzbln.zzblk.zzblg != 2) {
            zzgp.zzb("Unexpected state:" + this.zzbln.zzblk.zzblg, this.zzbln.zzblk.zzri);
        } else if (this.zzbll) {
            zzgp.zzb("Invalid state - not expecting to see a deferredevent during container loading.", this.zzbln.zzblk.zzri);
        } else {
            zzhk.m1082v(String.format("Container not loaded yet: deferring event interceptor by enqueuing the event: name = %s, origin = %s, params = %s.", new Object[]{this.val$name, this.zzads, this.zzaep}));
            this.zzbll = true;
            this.zzbln.zzblk.zzblh.add(this);
        }
    }
}
