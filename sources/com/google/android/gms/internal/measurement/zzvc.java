package com.google.android.gms.internal.measurement;

public class zzvc {
    private static final zzub zzbtk = zzub.zzvr();
    private zzte zzbzu;
    private volatile zzvv zzbzv;
    private volatile zzte zzbzw;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzvc)) {
            return false;
        }
        zzvc zzvc = (zzvc) obj;
        zzvv zzvv = this.zzbzv;
        zzvv zzvv2 = zzvc.zzbzv;
        if (zzvv == null && zzvv2 == null) {
            return zztw().equals(zzvc.zztw());
        }
        if (zzvv != null && zzvv2 != null) {
            return zzvv.equals(zzvv2);
        }
        if (zzvv != null) {
            return zzvv.equals(zzvc.zzh(zzvv.zzwj()));
        }
        return zzh(zzvv2.zzwj()).equals(zzvv2);
    }

    public int hashCode() {
        return 1;
    }

    private final zzvv zzh(zzvv zzvv) {
        if (this.zzbzv == null) {
            synchronized (this) {
                if (this.zzbzv != null) {
                } else {
                    try {
                        this.zzbzv = zzvv;
                        this.zzbzw = zzte.zzbtq;
                    } catch (zzuv e) {
                        this.zzbzv = zzvv;
                        this.zzbzw = zzte.zzbtq;
                    }
                }
            }
        }
        return this.zzbzv;
    }

    public final zzvv zzi(zzvv zzvv) {
        zzvv zzvv2 = this.zzbzv;
        this.zzbzu = null;
        this.zzbzw = null;
        this.zzbzv = zzvv;
        return zzvv2;
    }

    public final int zzvx() {
        if (this.zzbzw != null) {
            return this.zzbzw.size();
        }
        if (this.zzbzv != null) {
            return this.zzbzv.zzvx();
        }
        return 0;
    }

    public final zzte zztw() {
        if (this.zzbzw != null) {
            return this.zzbzw;
        }
        synchronized (this) {
            if (this.zzbzw != null) {
                zzte zzte = this.zzbzw;
                return zzte;
            }
            if (this.zzbzv == null) {
                this.zzbzw = zzte.zzbtq;
            } else {
                this.zzbzw = this.zzbzv.zztw();
            }
            zzte = this.zzbzw;
            return zzte;
        }
    }
}
