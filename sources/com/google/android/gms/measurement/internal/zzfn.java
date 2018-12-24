package com.google.android.gms.measurement.internal;

abstract class zzfn extends zzfm {
    private boolean zzvz;

    zzfn(zzfo zzfo) {
        super(zzfo);
        this.zzamv.zzb(this);
    }

    protected abstract boolean zzgy();

    final boolean isInitialized() {
        return this.zzvz;
    }

    protected final void zzcl() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzq() {
        if (this.zzvz) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzgy();
        this.zzamv.zzmg();
        this.zzvz = true;
    }
}
