package com.google.android.gms.internal.config;

public final class zzav extends zzbb<zzav> {
    public zzar zzbp;
    public zzar zzbq;
    public zzar zzbr;
    public zzat zzbs;
    public zzaw[] zzbt;

    public zzav() {
        this.zzbp = null;
        this.zzbq = null;
        this.zzbr = null;
        this.zzbs = null;
        this.zzbt = zzaw.zzx();
        this.zzch = null;
        this.zzcq = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzav)) {
            return false;
        }
        zzav zzav = (zzav) obj;
        if (this.zzbp == null) {
            if (zzav.zzbp != null) {
                return false;
            }
        } else if (!this.zzbp.equals(zzav.zzbp)) {
            return false;
        }
        if (this.zzbq == null) {
            if (zzav.zzbq != null) {
                return false;
            }
        } else if (!this.zzbq.equals(zzav.zzbq)) {
            return false;
        }
        if (this.zzbr == null) {
            if (zzav.zzbr != null) {
                return false;
            }
        } else if (!this.zzbr.equals(zzav.zzbr)) {
            return false;
        }
        if (this.zzbs == null) {
            if (zzav.zzbs != null) {
                return false;
            }
        } else if (!this.zzbs.equals(zzav.zzbs)) {
            return false;
        }
        if (!zzbf.equals(this.zzbt, zzav.zzbt)) {
            return false;
        }
        if (this.zzch != null && !this.zzch.isEmpty()) {
            return this.zzch.equals(zzav.zzch);
        }
        if (zzav.zzch == null || zzav.zzch.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = getClass().getName().hashCode() + 527;
        zzar zzar = this.zzbp;
        hashCode = (zzar == null ? 0 : zzar.hashCode()) + (hashCode * 31);
        zzar = this.zzbq;
        hashCode = (zzar == null ? 0 : zzar.hashCode()) + (hashCode * 31);
        zzar = this.zzbr;
        hashCode = (zzar == null ? 0 : zzar.hashCode()) + (hashCode * 31);
        zzat zzat = this.zzbs;
        hashCode = ((((zzat == null ? 0 : zzat.hashCode()) + (hashCode * 31)) * 31) + zzbf.hashCode(this.zzbt)) * 31;
        if (!(this.zzch == null || this.zzch.isEmpty())) {
            i = this.zzch.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzaz zzaz) {
        if (this.zzbp != null) {
            zzaz.zza(1, this.zzbp);
        }
        if (this.zzbq != null) {
            zzaz.zza(2, this.zzbq);
        }
        if (this.zzbr != null) {
            zzaz.zza(3, this.zzbr);
        }
        if (this.zzbs != null) {
            zzaz.zza(4, this.zzbs);
        }
        if (this.zzbt != null && this.zzbt.length > 0) {
            for (zzbh zzbh : this.zzbt) {
                if (zzbh != null) {
                    zzaz.zza(5, zzbh);
                }
            }
        }
        super.zza(zzaz);
    }

    protected final int zzu() {
        int zzu = super.zzu();
        if (this.zzbp != null) {
            zzu += zzaz.zzb(1, this.zzbp);
        }
        if (this.zzbq != null) {
            zzu += zzaz.zzb(2, this.zzbq);
        }
        if (this.zzbr != null) {
            zzu += zzaz.zzb(3, this.zzbr);
        }
        if (this.zzbs != null) {
            zzu += zzaz.zzb(4, this.zzbs);
        }
        if (this.zzbt == null || this.zzbt.length <= 0) {
            return zzu;
        }
        int i = zzu;
        for (zzbh zzbh : this.zzbt) {
            if (zzbh != null) {
                i += zzaz.zzb(5, zzbh);
            }
        }
        return i;
    }

    public final /* synthetic */ zzbh zza(zzay zzay) {
        while (true) {
            int zzy = zzay.zzy();
            switch (zzy) {
                case 0:
                    break;
                case 10:
                    if (this.zzbp == null) {
                        this.zzbp = new zzar();
                    }
                    zzay.zza(this.zzbp);
                    continue;
                case 18:
                    if (this.zzbq == null) {
                        this.zzbq = new zzar();
                    }
                    zzay.zza(this.zzbq);
                    continue;
                case 26:
                    if (this.zzbr == null) {
                        this.zzbr = new zzar();
                    }
                    zzay.zza(this.zzbr);
                    continue;
                case 34:
                    if (this.zzbs == null) {
                        this.zzbs = new zzat();
                    }
                    zzay.zza(this.zzbs);
                    continue;
                case 42:
                    int zzb = zzbk.zzb(zzay, 42);
                    zzy = this.zzbt == null ? 0 : this.zzbt.length;
                    Object obj = new zzaw[(zzb + zzy)];
                    if (zzy != 0) {
                        System.arraycopy(this.zzbt, 0, obj, 0, zzy);
                    }
                    while (zzy < obj.length - 1) {
                        obj[zzy] = new zzaw();
                        zzay.zza(obj[zzy]);
                        zzay.zzy();
                        zzy++;
                    }
                    obj[zzy] = new zzaw();
                    zzay.zza(obj[zzy]);
                    this.zzbt = obj;
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
