package com.google.android.gms.internal.measurement;

public final class zzfx extends zzyc<zzfx> {
    public long[] zzayn;
    public long[] zzayo;
    public zzfs[] zzayp;
    public zzfy[] zzayq;

    public zzfx() {
        this.zzayn = zzyl.zzcfi;
        this.zzayo = zzyl.zzcfi;
        this.zzayp = zzfs.zzmy();
        this.zzayq = zzfy.zznc();
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfx)) {
            return false;
        }
        zzfx zzfx = (zzfx) obj;
        if (!zzyg.equals(this.zzayn, zzfx.zzayn)) {
            return false;
        }
        if (!zzyg.equals(this.zzayo, zzfx.zzayo)) {
            return false;
        }
        if (!zzyg.equals(this.zzayp, zzfx.zzayp)) {
            return false;
        }
        if (!zzyg.equals(this.zzayq, zzfx.zzayq)) {
            return false;
        }
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            return this.zzcet.equals(zzfx.zzcet);
        }
        if (zzfx.zzcet == null || zzfx.zzcet.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + zzyg.hashCode(this.zzayn)) * 31) + zzyg.hashCode(this.zzayo)) * 31) + zzyg.hashCode(this.zzayp)) * 31) + zzyg.hashCode(this.zzayq)) * 31;
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            i = 0;
        } else {
            i = this.zzcet.hashCode();
        }
        return i + hashCode;
    }

    public final void zza(zzya zzya) {
        int i = 0;
        if (this.zzayn != null && this.zzayn.length > 0) {
            for (long zza : this.zzayn) {
                zzya.zza(1, zza);
            }
        }
        if (this.zzayo != null && this.zzayo.length > 0) {
            for (long zza2 : this.zzayo) {
                zzya.zza(2, zza2);
            }
        }
        if (this.zzayp != null && this.zzayp.length > 0) {
            for (zzyi zzyi : this.zzayp) {
                if (zzyi != null) {
                    zzya.zza(3, zzyi);
                }
            }
        }
        if (this.zzayq != null && this.zzayq.length > 0) {
            while (i < this.zzayq.length) {
                zzyi zzyi2 = this.zzayq[i];
                if (zzyi2 != null) {
                    zzya.zza(4, zzyi2);
                }
                i++;
            }
        }
        super.zza(zzya);
    }

    protected final int zzf() {
        int i;
        int i2;
        int i3 = 0;
        int zzf = super.zzf();
        if (this.zzayn == null || this.zzayn.length <= 0) {
            i = zzf;
        } else {
            i2 = 0;
            for (long zzbg : this.zzayn) {
                i2 += zzya.zzbg(zzbg);
            }
            i = (zzf + i2) + (this.zzayn.length * 1);
        }
        if (this.zzayo != null && this.zzayo.length > 0) {
            zzf = 0;
            for (long zzbg2 : this.zzayo) {
                zzf += zzya.zzbg(zzbg2);
            }
            i = (i + zzf) + (this.zzayo.length * 1);
        }
        if (this.zzayp != null && this.zzayp.length > 0) {
            zzf = i;
            for (zzyi zzyi : this.zzayp) {
                if (zzyi != null) {
                    zzf += zzya.zzb(3, zzyi);
                }
            }
            i = zzf;
        }
        if (this.zzayq != null && this.zzayq.length > 0) {
            while (i3 < this.zzayq.length) {
                zzyi zzyi2 = this.zzayq[i3];
                if (zzyi2 != null) {
                    i += zzya.zzb(4, zzyi2);
                }
                i3++;
            }
        }
        return i;
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) {
        while (true) {
            int zzuj = zzxz.zzuj();
            int zzb;
            Object obj;
            int zzas;
            Object obj2;
            switch (zzuj) {
                case 0:
                    break;
                case 8:
                    zzb = zzyl.zzb(zzxz, 8);
                    if (this.zzayn == null) {
                        zzuj = 0;
                    } else {
                        zzuj = this.zzayn.length;
                    }
                    obj = new long[(zzb + zzuj)];
                    if (zzuj != 0) {
                        System.arraycopy(this.zzayn, 0, obj, 0, zzuj);
                    }
                    while (zzuj < obj.length - 1) {
                        obj[zzuj] = zzxz.zzvc();
                        zzxz.zzuj();
                        zzuj++;
                    }
                    obj[zzuj] = zzxz.zzvc();
                    this.zzayn = obj;
                    continue;
                case 10:
                    zzas = zzxz.zzas(zzxz.zzvb());
                    zzb = zzxz.getPosition();
                    zzuj = 0;
                    while (zzxz.zzyy() > 0) {
                        zzxz.zzvc();
                        zzuj++;
                    }
                    zzxz.zzcb(zzb);
                    zzb = this.zzayn == null ? 0 : this.zzayn.length;
                    obj2 = new long[(zzuj + zzb)];
                    if (zzb != 0) {
                        System.arraycopy(this.zzayn, 0, obj2, 0, zzb);
                    }
                    while (zzb < obj2.length) {
                        obj2[zzb] = zzxz.zzvc();
                        zzb++;
                    }
                    this.zzayn = obj2;
                    zzxz.zzat(zzas);
                    continue;
                case 16:
                    zzb = zzyl.zzb(zzxz, 16);
                    if (this.zzayo == null) {
                        zzuj = 0;
                    } else {
                        zzuj = this.zzayo.length;
                    }
                    obj = new long[(zzb + zzuj)];
                    if (zzuj != 0) {
                        System.arraycopy(this.zzayo, 0, obj, 0, zzuj);
                    }
                    while (zzuj < obj.length - 1) {
                        obj[zzuj] = zzxz.zzvc();
                        zzxz.zzuj();
                        zzuj++;
                    }
                    obj[zzuj] = zzxz.zzvc();
                    this.zzayo = obj;
                    continue;
                case 18:
                    zzas = zzxz.zzas(zzxz.zzvb());
                    zzb = zzxz.getPosition();
                    zzuj = 0;
                    while (zzxz.zzyy() > 0) {
                        zzxz.zzvc();
                        zzuj++;
                    }
                    zzxz.zzcb(zzb);
                    zzb = this.zzayo == null ? 0 : this.zzayo.length;
                    obj2 = new long[(zzuj + zzb)];
                    if (zzb != 0) {
                        System.arraycopy(this.zzayo, 0, obj2, 0, zzb);
                    }
                    while (zzb < obj2.length) {
                        obj2[zzb] = zzxz.zzvc();
                        zzb++;
                    }
                    this.zzayo = obj2;
                    zzxz.zzat(zzas);
                    continue;
                case 26:
                    zzb = zzyl.zzb(zzxz, 26);
                    zzuj = this.zzayp == null ? 0 : this.zzayp.length;
                    obj = new zzfs[(zzb + zzuj)];
                    if (zzuj != 0) {
                        System.arraycopy(this.zzayp, 0, obj, 0, zzuj);
                    }
                    while (zzuj < obj.length - 1) {
                        obj[zzuj] = new zzfs();
                        zzxz.zza(obj[zzuj]);
                        zzxz.zzuj();
                        zzuj++;
                    }
                    obj[zzuj] = new zzfs();
                    zzxz.zza(obj[zzuj]);
                    this.zzayp = obj;
                    continue;
                case 34:
                    zzb = zzyl.zzb(zzxz, 34);
                    zzuj = this.zzayq == null ? 0 : this.zzayq.length;
                    obj = new zzfy[(zzb + zzuj)];
                    if (zzuj != 0) {
                        System.arraycopy(this.zzayq, 0, obj, 0, zzuj);
                    }
                    while (zzuj < obj.length - 1) {
                        obj[zzuj] = new zzfy();
                        zzxz.zza(obj[zzuj]);
                        zzxz.zzuj();
                        zzuj++;
                    }
                    obj[zzuj] = new zzfy();
                    zzxz.zza(obj[zzuj]);
                    this.zzayq = obj;
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
