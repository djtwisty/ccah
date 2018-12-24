package com.google.android.gms.internal.measurement;

public final class zzfy extends zzyc<zzfy> {
    private static volatile zzfy[] zzayr;
    public Integer zzawx;
    public long[] zzays;

    public static zzfy[] zznc() {
        if (zzayr == null) {
            synchronized (zzyg.zzcfc) {
                if (zzayr == null) {
                    zzayr = new zzfy[0];
                }
            }
        }
        return zzayr;
    }

    public zzfy() {
        this.zzawx = null;
        this.zzays = zzyl.zzcfi;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfy)) {
            return false;
        }
        zzfy zzfy = (zzfy) obj;
        if (this.zzawx == null) {
            if (zzfy.zzawx != null) {
                return false;
            }
        } else if (!this.zzawx.equals(zzfy.zzawx)) {
            return false;
        }
        if (!zzyg.equals(this.zzays, zzfy.zzays)) {
            return false;
        }
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            return this.zzcet.equals(zzfy.zzcet);
        }
        if (zzfy.zzcet == null || zzfy.zzcet.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((this.zzawx == null ? 0 : this.zzawx.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzyg.hashCode(this.zzays)) * 31;
        if (!(this.zzcet == null || this.zzcet.isEmpty())) {
            i = this.zzcet.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzya zzya) {
        if (this.zzawx != null) {
            zzya.zzd(1, this.zzawx.intValue());
        }
        if (this.zzays != null && this.zzays.length > 0) {
            for (long zzi : this.zzays) {
                zzya.zzi(2, zzi);
            }
        }
        super.zza(zzya);
    }

    protected final int zzf() {
        int zzf = super.zzf();
        if (this.zzawx != null) {
            zzf += zzya.zzh(1, this.zzawx.intValue());
        }
        if (this.zzays == null || this.zzays.length <= 0) {
            return zzf;
        }
        int i = 0;
        int i2 = 0;
        while (i < this.zzays.length) {
            i++;
            i2 = zzya.zzbg(this.zzays[i]) + i2;
        }
        return (zzf + i2) + (this.zzays.length * 1);
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) {
        while (true) {
            int zzuj = zzxz.zzuj();
            int zzb;
            switch (zzuj) {
                case 0:
                    break;
                case 8:
                    this.zzawx = Integer.valueOf(zzxz.zzvb());
                    continue;
                case 16:
                    zzb = zzyl.zzb(zzxz, 16);
                    if (this.zzays == null) {
                        zzuj = 0;
                    } else {
                        zzuj = this.zzays.length;
                    }
                    Object obj = new long[(zzb + zzuj)];
                    if (zzuj != 0) {
                        System.arraycopy(this.zzays, 0, obj, 0, zzuj);
                    }
                    while (zzuj < obj.length - 1) {
                        obj[zzuj] = zzxz.zzvc();
                        zzxz.zzuj();
                        zzuj++;
                    }
                    obj[zzuj] = zzxz.zzvc();
                    this.zzays = obj;
                    continue;
                case 18:
                    int zzas = zzxz.zzas(zzxz.zzvb());
                    zzb = zzxz.getPosition();
                    zzuj = 0;
                    while (zzxz.zzyy() > 0) {
                        zzxz.zzvc();
                        zzuj++;
                    }
                    zzxz.zzcb(zzb);
                    zzb = this.zzays == null ? 0 : this.zzays.length;
                    Object obj2 = new long[(zzuj + zzb)];
                    if (zzb != 0) {
                        System.arraycopy(this.zzays, 0, obj2, 0, zzb);
                    }
                    while (zzb < obj2.length) {
                        obj2[zzb] = zzxz.zzvc();
                        zzb++;
                    }
                    this.zzays = obj2;
                    zzxz.zzat(zzas);
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
