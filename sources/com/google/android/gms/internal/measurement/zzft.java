package com.google.android.gms.internal.measurement;

import org.apache.http.protocol.HTTP;

public final class zzft extends zzyc<zzft> {
    private static volatile zzft[] zzawz;
    public Integer count;
    public String name;
    public zzfu[] zzaxa;
    public Long zzaxb;
    public Long zzaxc;

    public static zzft[] zzmz() {
        if (zzawz == null) {
            synchronized (zzyg.zzcfc) {
                if (zzawz == null) {
                    zzawz = new zzft[0];
                }
            }
        }
        return zzawz;
    }

    public zzft() {
        this.zzaxa = zzfu.zzna();
        this.name = null;
        this.zzaxb = null;
        this.zzaxc = null;
        this.count = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzft)) {
            return false;
        }
        zzft zzft = (zzft) obj;
        if (!zzyg.equals(this.zzaxa, zzft.zzaxa)) {
            return false;
        }
        if (this.name == null) {
            if (zzft.name != null) {
                return false;
            }
        } else if (!this.name.equals(zzft.name)) {
            return false;
        }
        if (this.zzaxb == null) {
            if (zzft.zzaxb != null) {
                return false;
            }
        } else if (!this.zzaxb.equals(zzft.zzaxb)) {
            return false;
        }
        if (this.zzaxc == null) {
            if (zzft.zzaxc != null) {
                return false;
            }
        } else if (!this.zzaxc.equals(zzft.zzaxc)) {
            return false;
        }
        if (this.count == null) {
            if (zzft.count != null) {
                return false;
            }
        } else if (!this.count.equals(zzft.count)) {
            return false;
        }
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            return this.zzcet.equals(zzft.zzcet);
        }
        if (zzft.zzcet == null || zzft.zzcet.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.count == null ? 0 : this.count.hashCode()) + (((this.zzaxc == null ? 0 : this.zzaxc.hashCode()) + (((this.zzaxb == null ? 0 : this.zzaxb.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzyg.hashCode(this.zzaxa)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!(this.zzcet == null || this.zzcet.isEmpty())) {
            i = this.zzcet.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzya zzya) {
        if (this.zzaxa != null && this.zzaxa.length > 0) {
            for (zzyi zzyi : this.zzaxa) {
                if (zzyi != null) {
                    zzya.zza(1, zzyi);
                }
            }
        }
        if (this.name != null) {
            zzya.zzb(2, this.name);
        }
        if (this.zzaxb != null) {
            zzya.zzi(3, this.zzaxb.longValue());
        }
        if (this.zzaxc != null) {
            zzya.zzi(4, this.zzaxc.longValue());
        }
        if (this.count != null) {
            zzya.zzd(5, this.count.intValue());
        }
        super.zza(zzya);
    }

    protected final int zzf() {
        int zzf = super.zzf();
        if (this.zzaxa != null && this.zzaxa.length > 0) {
            for (zzyi zzyi : this.zzaxa) {
                if (zzyi != null) {
                    zzf += zzya.zzb(1, zzyi);
                }
            }
        }
        if (this.name != null) {
            zzf += zzya.zzc(2, this.name);
        }
        if (this.zzaxb != null) {
            zzf += zzya.zzd(3, this.zzaxb.longValue());
        }
        if (this.zzaxc != null) {
            zzf += zzya.zzd(4, this.zzaxc.longValue());
        }
        if (this.count != null) {
            return zzf + zzya.zzh(5, this.count.intValue());
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
                    int zzb = zzyl.zzb(zzxz, 10);
                    zzuj = this.zzaxa == null ? 0 : this.zzaxa.length;
                    Object obj = new zzfu[(zzb + zzuj)];
                    if (zzuj != 0) {
                        System.arraycopy(this.zzaxa, 0, obj, 0, zzuj);
                    }
                    while (zzuj < obj.length - 1) {
                        obj[zzuj] = new zzfu();
                        zzxz.zza(obj[zzuj]);
                        zzxz.zzuj();
                        zzuj++;
                    }
                    obj[zzuj] = new zzfu();
                    zzxz.zza(obj[zzuj]);
                    this.zzaxa = obj;
                    continue;
                case 18:
                    this.name = zzxz.readString();
                    continue;
                case 24:
                    this.zzaxb = Long.valueOf(zzxz.zzvc());
                    continue;
                case HTTP.SP /*32*/:
                    this.zzaxc = Long.valueOf(zzxz.zzvc());
                    continue;
                case 40:
                    this.count = Integer.valueOf(zzxz.zzvb());
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
