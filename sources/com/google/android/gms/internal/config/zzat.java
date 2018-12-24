package com.google.android.gms.internal.config;

public final class zzat extends zzbb<zzat> {
    public int zzbj;
    public boolean zzbk;
    private long zzbl;

    public zzat() {
        this.zzbj = 0;
        this.zzbk = false;
        this.zzbl = 0;
        this.zzch = null;
        this.zzcq = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzat)) {
            return false;
        }
        zzat zzat = (zzat) obj;
        if (this.zzbj != zzat.zzbj) {
            return false;
        }
        if (this.zzbk != zzat.zzbk) {
            return false;
        }
        if (this.zzbl != zzat.zzbl) {
            return false;
        }
        if (this.zzch != null && !this.zzch.isEmpty()) {
            return this.zzch.equals(zzat.zzch);
        }
        if (zzat.zzch == null || zzat.zzch.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = ((((this.zzbk ? 1231 : 1237) + ((((getClass().getName().hashCode() + 527) * 31) + this.zzbj) * 31)) * 31) + ((int) (this.zzbl ^ (this.zzbl >>> 32)))) * 31;
        if (this.zzch == null || this.zzch.isEmpty()) {
            i = 0;
        } else {
            i = this.zzch.hashCode();
        }
        return i + hashCode;
    }

    public final void zza(zzaz zzaz) {
        int i = 1;
        if (this.zzbj != 0) {
            zzaz.zzc(1, this.zzbj);
        }
        if (this.zzbk) {
            boolean z = this.zzbk;
            zzaz.zze(2, 0);
            if (!z) {
                i = 0;
            }
            zzaz.zza((byte) i);
        }
        if (this.zzbl != 0) {
            zzaz.zza(3, this.zzbl);
        }
        super.zza(zzaz);
    }

    protected final int zzu() {
        int zzu = super.zzu();
        if (this.zzbj != 0) {
            zzu += zzaz.zzd(1, this.zzbj);
        }
        if (this.zzbk) {
            zzu += zzaz.zzl(2) + 1;
        }
        if (this.zzbl != 0) {
            return zzu + (zzaz.zzl(3) + 8);
        }
        return zzu;
    }

    public final /* synthetic */ zzbh zza(zzay zzay) {
        while (true) {
            int zzy = zzay.zzy();
            switch (zzy) {
                case 0:
                    break;
                case 8:
                    this.zzbj = zzay.zzz();
                    continue;
                case 16:
                    this.zzbk = zzay.zzz() != 0;
                    continue;
                case 25:
                    this.zzbl = zzay.zzaa();
                    continue;
                default:
                    if (!super.zza(zzay, zzy)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }
}
