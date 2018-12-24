package com.google.android.gms.internal.measurement;

public final class zzfv extends zzyc<zzfv> {
    public zzfw[] zzaxf;

    public zzfv() {
        this.zzaxf = zzfw.zznb();
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfv)) {
            return false;
        }
        zzfv zzfv = (zzfv) obj;
        if (!zzyg.equals(this.zzaxf, zzfv.zzaxf)) {
            return false;
        }
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            return this.zzcet.equals(zzfv.zzcet);
        }
        if (zzfv.zzcet == null || zzfv.zzcet.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = (((getClass().getName().hashCode() + 527) * 31) + zzyg.hashCode(this.zzaxf)) * 31;
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            i = 0;
        } else {
            i = this.zzcet.hashCode();
        }
        return i + hashCode;
    }

    public final void zza(zzya zzya) {
        if (this.zzaxf != null && this.zzaxf.length > 0) {
            for (zzyi zzyi : this.zzaxf) {
                if (zzyi != null) {
                    zzya.zza(1, zzyi);
                }
            }
        }
        super.zza(zzya);
    }

    protected final int zzf() {
        int zzf = super.zzf();
        if (this.zzaxf != null && this.zzaxf.length > 0) {
            for (zzyi zzyi : this.zzaxf) {
                if (zzyi != null) {
                    zzf += zzya.zzb(1, zzyi);
                }
            }
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
                    zzuj = this.zzaxf == null ? 0 : this.zzaxf.length;
                    Object obj = new zzfw[(zzb + zzuj)];
                    if (zzuj != 0) {
                        System.arraycopy(this.zzaxf, 0, obj, 0, zzuj);
                    }
                    while (zzuj < obj.length - 1) {
                        obj[zzuj] = new zzfw();
                        zzxz.zza(obj[zzuj]);
                        zzxz.zzuj();
                        zzuj++;
                    }
                    obj[zzuj] = new zzfw();
                    zzxz.zza(obj[zzuj]);
                    this.zzaxf = obj;
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
