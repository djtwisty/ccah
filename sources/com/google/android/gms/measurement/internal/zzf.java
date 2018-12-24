package com.google.android.gms.measurement.internal;

abstract class zzf extends zze {
    private boolean zzvz;

    zzf(zzbw zzbw) {
        super(zzbw);
        this.zzada.zzb(this);
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
        } else if (!zzgy()) {
            this.zzada.zzku();
            this.zzvz = true;
        }
    }

    public final void zzgx() {
        if (this.zzvz) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzgz();
        this.zzada.zzku();
        this.zzvz = true;
    }

    protected void zzgz() {
    }
}
