package com.google.android.gms.internal.measurement;

public final class zzfs extends zzyc<zzfs> {
    private static volatile zzfs[] zzaww;
    public Integer zzawx;
    public Long zzawy;

    public static zzfs[] zzmy() {
        if (zzaww == null) {
            synchronized (zzyg.zzcfc) {
                if (zzaww == null) {
                    zzaww = new zzfs[0];
                }
            }
        }
        return zzaww;
    }

    public zzfs() {
        this.zzawx = null;
        this.zzawy = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfs)) {
            return false;
        }
        zzfs zzfs = (zzfs) obj;
        if (this.zzawx == null) {
            if (zzfs.zzawx != null) {
                return false;
            }
        } else if (!this.zzawx.equals(zzfs.zzawx)) {
            return false;
        }
        if (this.zzawy == null) {
            if (zzfs.zzawy != null) {
                return false;
            }
        } else if (!this.zzawy.equals(zzfs.zzawy)) {
            return false;
        }
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            return this.zzcet.equals(zzfs.zzcet);
        }
        if (zzfs.zzcet == null || zzfs.zzcet.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.zzawy == null ? 0 : this.zzawy.hashCode()) + (((this.zzawx == null ? 0 : this.zzawx.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
        if (!(this.zzcet == null || this.zzcet.isEmpty())) {
            i = this.zzcet.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzya zzya) {
        if (this.zzawx != null) {
            zzya.zzd(1, this.zzawx.intValue());
        }
        if (this.zzawy != null) {
            zzya.zzi(2, this.zzawy.longValue());
        }
        super.zza(zzya);
    }

    protected final int zzf() {
        int zzf = super.zzf();
        if (this.zzawx != null) {
            zzf += zzya.zzh(1, this.zzawx.intValue());
        }
        if (this.zzawy != null) {
            return zzf + zzya.zzd(2, this.zzawy.longValue());
        }
        return zzf;
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) {
        while (true) {
            int zzuj = zzxz.zzuj();
            switch (zzuj) {
                case 0:
                    break;
                case 8:
                    this.zzawx = Integer.valueOf(zzxz.zzvb());
                    continue;
                case 16:
                    this.zzawy = Long.valueOf(zzxz.zzvc());
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
