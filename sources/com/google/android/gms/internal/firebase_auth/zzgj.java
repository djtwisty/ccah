package com.google.android.gms.internal.firebase_auth;

public class zzgj {
    private static final zzfg zzsj = zzfg.zzgq();
    private zzeh zzyo;
    private volatile zzhc zzyp;
    private volatile zzeh zzyq;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgj)) {
            return false;
        }
        zzgj zzgj = (zzgj) obj;
        zzhc zzhc = this.zzyp;
        zzhc zzhc2 = zzgj.zzyp;
        if (zzhc == null && zzhc2 == null) {
            return zzer().equals(zzgj.zzer());
        }
        if (zzhc != null && zzhc2 != null) {
            return zzhc.equals(zzhc2);
        }
        if (zzhc != null) {
            return zzhc.equals(zzgj.zzi(zzhc.zzhi()));
        }
        return zzi(zzhc2.zzhi()).equals(zzhc2);
    }

    public int hashCode() {
        return 1;
    }

    private final zzhc zzi(zzhc zzhc) {
        if (this.zzyp == null) {
            synchronized (this) {
                if (this.zzyp != null) {
                } else {
                    try {
                        this.zzyp = zzhc;
                        this.zzyq = zzeh.zzso;
                    } catch (zzgc e) {
                        this.zzyp = zzhc;
                        this.zzyq = zzeh.zzso;
                    }
                }
            }
        }
        return this.zzyp;
    }

    public final zzhc zzj(zzhc zzhc) {
        zzhc zzhc2 = this.zzyp;
        this.zzyo = null;
        this.zzyq = null;
        this.zzyp = zzhc;
        return zzhc2;
    }

    public final int zzgw() {
        if (this.zzyq != null) {
            return this.zzyq.size();
        }
        if (this.zzyp != null) {
            return this.zzyp.zzgw();
        }
        return 0;
    }

    public final zzeh zzer() {
        if (this.zzyq != null) {
            return this.zzyq;
        }
        synchronized (this) {
            if (this.zzyq != null) {
                zzeh zzeh = this.zzyq;
                return zzeh;
            }
            if (this.zzyp == null) {
                this.zzyq = zzeh.zzso;
            } else {
                this.zzyq = this.zzyp.zzer();
            }
            zzeh = this.zzyq;
            return zzeh;
        }
    }
}
