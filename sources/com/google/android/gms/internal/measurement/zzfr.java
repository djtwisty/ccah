package com.google.android.gms.internal.measurement;

import org.apache.http.protocol.HTTP;

public final class zzfr extends zzyc<zzfr> {
    private static volatile zzfr[] zzaws;
    public Integer zzave;
    public zzfx zzawt;
    public zzfx zzawu;
    public Boolean zzawv;

    public static zzfr[] zzmx() {
        if (zzaws == null) {
            synchronized (zzyg.zzcfc) {
                if (zzaws == null) {
                    zzaws = new zzfr[0];
                }
            }
        }
        return zzaws;
    }

    public zzfr() {
        this.zzave = null;
        this.zzawt = null;
        this.zzawu = null;
        this.zzawv = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfr)) {
            return false;
        }
        zzfr zzfr = (zzfr) obj;
        if (this.zzave == null) {
            if (zzfr.zzave != null) {
                return false;
            }
        } else if (!this.zzave.equals(zzfr.zzave)) {
            return false;
        }
        if (this.zzawt == null) {
            if (zzfr.zzawt != null) {
                return false;
            }
        } else if (!this.zzawt.equals(zzfr.zzawt)) {
            return false;
        }
        if (this.zzawu == null) {
            if (zzfr.zzawu != null) {
                return false;
            }
        } else if (!this.zzawu.equals(zzfr.zzawu)) {
            return false;
        }
        if (this.zzawv == null) {
            if (zzfr.zzawv != null) {
                return false;
            }
        } else if (!this.zzawv.equals(zzfr.zzawv)) {
            return false;
        }
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            return this.zzcet.equals(zzfr.zzcet);
        }
        if (zzfr.zzcet == null || zzfr.zzcet.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (this.zzave == null ? 0 : this.zzave.hashCode()) + ((getClass().getName().hashCode() + 527) * 31);
        zzfx zzfx = this.zzawt;
        hashCode = (zzfx == null ? 0 : zzfx.hashCode()) + (hashCode * 31);
        zzfx = this.zzawu;
        hashCode = ((this.zzawv == null ? 0 : this.zzawv.hashCode()) + (((zzfx == null ? 0 : zzfx.hashCode()) + (hashCode * 31)) * 31)) * 31;
        if (!(this.zzcet == null || this.zzcet.isEmpty())) {
            i = this.zzcet.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzya zzya) {
        if (this.zzave != null) {
            zzya.zzd(1, this.zzave.intValue());
        }
        if (this.zzawt != null) {
            zzya.zza(2, this.zzawt);
        }
        if (this.zzawu != null) {
            zzya.zza(3, this.zzawu);
        }
        if (this.zzawv != null) {
            zzya.zzb(4, this.zzawv.booleanValue());
        }
        super.zza(zzya);
    }

    protected final int zzf() {
        int zzf = super.zzf();
        if (this.zzave != null) {
            zzf += zzya.zzh(1, this.zzave.intValue());
        }
        if (this.zzawt != null) {
            zzf += zzya.zzb(2, this.zzawt);
        }
        if (this.zzawu != null) {
            zzf += zzya.zzb(3, this.zzawu);
        }
        if (this.zzawv == null) {
            return zzf;
        }
        this.zzawv.booleanValue();
        return zzf + (zzya.zzbd(4) + 1);
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) {
        while (true) {
            int zzuj = zzxz.zzuj();
            switch (zzuj) {
                case 0:
                    break;
                case 8:
                    this.zzave = Integer.valueOf(zzxz.zzvb());
                    continue;
                case 18:
                    if (this.zzawt == null) {
                        this.zzawt = new zzfx();
                    }
                    zzxz.zza(this.zzawt);
                    continue;
                case 26:
                    if (this.zzawu == null) {
                        this.zzawu = new zzfx();
                    }
                    zzxz.zza(this.zzawu);
                    continue;
                case HTTP.SP /*32*/:
                    this.zzawv = Boolean.valueOf(zzxz.zzup());
                    continue;
                default:
                    if (!super.zza(zzxz, zzuj)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }
}
