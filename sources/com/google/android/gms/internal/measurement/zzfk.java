package com.google.android.gms.internal.measurement;

public final class zzfk extends zzyc<zzfk> {
    private static volatile zzfk[] zzavp;
    public zzfn zzavq;
    public zzfl zzavr;
    public Boolean zzavs;
    public String zzavt;

    public static zzfk[] zzmt() {
        if (zzavp == null) {
            synchronized (zzyg.zzcfc) {
                if (zzavp == null) {
                    zzavp = new zzfk[0];
                }
            }
        }
        return zzavp;
    }

    public zzfk() {
        this.zzavq = null;
        this.zzavr = null;
        this.zzavs = null;
        this.zzavt = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfk)) {
            return false;
        }
        zzfk zzfk = (zzfk) obj;
        if (this.zzavq == null) {
            if (zzfk.zzavq != null) {
                return false;
            }
        } else if (!this.zzavq.equals(zzfk.zzavq)) {
            return false;
        }
        if (this.zzavr == null) {
            if (zzfk.zzavr != null) {
                return false;
            }
        } else if (!this.zzavr.equals(zzfk.zzavr)) {
            return false;
        }
        if (this.zzavs == null) {
            if (zzfk.zzavs != null) {
                return false;
            }
        } else if (!this.zzavs.equals(zzfk.zzavs)) {
            return false;
        }
        if (this.zzavt == null) {
            if (zzfk.zzavt != null) {
                return false;
            }
        } else if (!this.zzavt.equals(zzfk.zzavt)) {
            return false;
        }
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            return this.zzcet.equals(zzfk.zzcet);
        }
        if (zzfk.zzcet == null || zzfk.zzcet.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = getClass().getName().hashCode() + 527;
        zzfn zzfn = this.zzavq;
        hashCode = (zzfn == null ? 0 : zzfn.hashCode()) + (hashCode * 31);
        zzfl zzfl = this.zzavr;
        hashCode = ((this.zzavt == null ? 0 : this.zzavt.hashCode()) + (((this.zzavs == null ? 0 : this.zzavs.hashCode()) + (((zzfl == null ? 0 : zzfl.hashCode()) + (hashCode * 31)) * 31)) * 31)) * 31;
        if (!(this.zzcet == null || this.zzcet.isEmpty())) {
            i = this.zzcet.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzya zzya) {
        if (this.zzavq != null) {
            zzya.zza(1, this.zzavq);
        }
        if (this.zzavr != null) {
            zzya.zza(2, this.zzavr);
        }
        if (this.zzavs != null) {
            zzya.zzb(3, this.zzavs.booleanValue());
        }
        if (this.zzavt != null) {
            zzya.zzb(4, this.zzavt);
        }
        super.zza(zzya);
    }

    protected final int zzf() {
        int zzf = super.zzf();
        if (this.zzavq != null) {
            zzf += zzya.zzb(1, this.zzavq);
        }
        if (this.zzavr != null) {
            zzf += zzya.zzb(2, this.zzavr);
        }
        if (this.zzavs != null) {
            this.zzavs.booleanValue();
            zzf += zzya.zzbd(3) + 1;
        }
        if (this.zzavt != null) {
            return zzf + zzya.zzc(4, this.zzavt);
        }
        return zzf;
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) {
        while (true) {
            int zzuj = zzxz.zzuj();
            switch (zzuj) {
                case 0:
                    break;
                case 10:
                    if (this.zzavq == null) {
                        this.zzavq = new zzfn();
                    }
                    zzxz.zza(this.zzavq);
                    continue;
                case 18:
                    if (this.zzavr == null) {
                        this.zzavr = new zzfl();
                    }
                    zzxz.zza(this.zzavr);
                    continue;
                case 24:
                    this.zzavs = Boolean.valueOf(zzxz.zzup());
                    continue;
                case 34:
                    this.zzavt = zzxz.readString();
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
