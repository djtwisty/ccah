package com.google.android.gms.internal.measurement;

final class zzjd implements Runnable {
    private final /* synthetic */ zzja zzbma;

    zzjd(zzja zzja) {
        this.zzbma = zzja;
    }

    public final void run() {
        if (this.zzbma.zzblx.isEmpty()) {
            zzhk.zzab("TagManagerBackend dispatch called without loaded container.");
            return;
        }
        for (zzgf dispatch : this.zzbma.zzblx.values()) {
            dispatch.dispatch();
        }
    }
}
