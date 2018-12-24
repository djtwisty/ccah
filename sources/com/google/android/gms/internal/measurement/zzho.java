package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
final class zzho implements zzil {
    private final /* synthetic */ zzhn zzbjv;

    zzho(zzhn zzhn) {
        this.zzbjv = zzhn;
    }

    public final void zza(zzgw zzgw) {
        this.zzbjv.zze(zzgw.zzov());
    }

    public final void zzb(zzgw zzgw) {
        this.zzbjv.zze(zzgw.zzov());
        zzhk.m1082v("Permanent failure dispatching hitId: " + zzgw.zzov());
    }

    public final void zzc(zzgw zzgw) {
        long zzow = zzgw.zzow();
        if (zzow == 0) {
            this.zzbjv.zze(zzgw.zzov(), this.zzbjv.zzrz.currentTimeMillis());
        } else if (zzow + 14400000 < this.zzbjv.zzrz.currentTimeMillis()) {
            this.zzbjv.zze(zzgw.zzov());
            zzhk.m1082v("Giving up on failed hitId: " + zzgw.zzov());
        }
    }
}
