package com.google.android.gms.internal.measurement;

import org.apache.http.util.LangUtils;

public final class zzfu extends zzyc<zzfu> {
    private static volatile zzfu[] zzaxd;
    public String name;
    public String zzaml;
    private Float zzaum;
    public Double zzaun;
    public Long zzaxe;

    public static zzfu[] zzna() {
        if (zzaxd == null) {
            synchronized (zzyg.zzcfc) {
                if (zzaxd == null) {
                    zzaxd = new zzfu[0];
                }
            }
        }
        return zzaxd;
    }

    public zzfu() {
        this.name = null;
        this.zzaml = null;
        this.zzaxe = null;
        this.zzaum = null;
        this.zzaun = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfu)) {
            return false;
        }
        zzfu zzfu = (zzfu) obj;
        if (this.name == null) {
            if (zzfu.name != null) {
                return false;
            }
        } else if (!this.name.equals(zzfu.name)) {
            return false;
        }
        if (this.zzaml == null) {
            if (zzfu.zzaml != null) {
                return false;
            }
        } else if (!this.zzaml.equals(zzfu.zzaml)) {
            return false;
        }
        if (this.zzaxe == null) {
            if (zzfu.zzaxe != null) {
                return false;
            }
        } else if (!this.zzaxe.equals(zzfu.zzaxe)) {
            return false;
        }
        if (this.zzaum == null) {
            if (zzfu.zzaum != null) {
                return false;
            }
        } else if (!this.zzaum.equals(zzfu.zzaum)) {
            return false;
        }
        if (this.zzaun == null) {
            if (zzfu.zzaun != null) {
                return false;
            }
        } else if (!this.zzaun.equals(zzfu.zzaun)) {
            return false;
        }
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            return this.zzcet.equals(zzfu.zzcet);
        }
        if (zzfu.zzcet == null || zzfu.zzcet.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.zzaun == null ? 0 : this.zzaun.hashCode()) + (((this.zzaum == null ? 0 : this.zzaum.hashCode()) + (((this.zzaxe == null ? 0 : this.zzaxe.hashCode()) + (((this.zzaml == null ? 0 : this.zzaml.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!(this.zzcet == null || this.zzcet.isEmpty())) {
            i = this.zzcet.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzya zzya) {
        if (this.name != null) {
            zzya.zzb(1, this.name);
        }
        if (this.zzaml != null) {
            zzya.zzb(2, this.zzaml);
        }
        if (this.zzaxe != null) {
            zzya.zzi(3, this.zzaxe.longValue());
        }
        if (this.zzaum != null) {
            zzya.zza(4, this.zzaum.floatValue());
        }
        if (this.zzaun != null) {
            zzya.zza(5, this.zzaun.doubleValue());
        }
        super.zza(zzya);
    }

    protected final int zzf() {
        int zzf = super.zzf();
        if (this.name != null) {
            zzf += zzya.zzc(1, this.name);
        }
        if (this.zzaml != null) {
            zzf += zzya.zzc(2, this.zzaml);
        }
        if (this.zzaxe != null) {
            zzf += zzya.zzd(3, this.zzaxe.longValue());
        }
        if (this.zzaum != null) {
            this.zzaum.floatValue();
            zzf += zzya.zzbd(4) + 4;
        }
        if (this.zzaun == null) {
            return zzf;
        }
        this.zzaun.doubleValue();
        return zzf + (zzya.zzbd(5) + 8);
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) {
        while (true) {
            int zzuj = zzxz.zzuj();
            switch (zzuj) {
                case 0:
                    break;
                case 10:
                    this.name = zzxz.readString();
                    continue;
                case 18:
                    this.zzaml = zzxz.readString();
                    continue;
                case 24:
                    this.zzaxe = Long.valueOf(zzxz.zzvc());
                    continue;
                case LangUtils.HASH_OFFSET /*37*/:
                    this.zzaum = Float.valueOf(Float.intBitsToFloat(zzxz.zzvd()));
                    continue;
                case 41:
                    this.zzaun = Double.valueOf(Double.longBitsToDouble(zzxz.zzve()));
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
