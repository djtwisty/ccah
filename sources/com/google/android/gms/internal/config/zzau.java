package com.google.android.gms.internal.config;

public final class zzau extends zzbb<zzau> {
    private static volatile zzau[] zzbm;
    public String zzbn;
    public zzas[] zzbo;

    public static zzau[] zzw() {
        if (zzbm == null) {
            synchronized (zzbf.zzcp) {
                if (zzbm == null) {
                    zzbm = new zzau[0];
                }
            }
        }
        return zzbm;
    }

    public zzau() {
        this.zzbn = "";
        this.zzbo = zzas.zzv();
        this.zzch = null;
        this.zzcq = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzau)) {
            return false;
        }
        zzau zzau = (zzau) obj;
        if (this.zzbn == null) {
            if (zzau.zzbn != null) {
                return false;
            }
        } else if (!this.zzbn.equals(zzau.zzbn)) {
            return false;
        }
        if (!zzbf.equals(this.zzbo, zzau.zzbo)) {
            return false;
        }
        if (this.zzch != null && !this.zzch.isEmpty()) {
            return this.zzch.equals(zzau.zzch);
        }
        if (zzau.zzch == null || zzau.zzch.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((this.zzbn == null ? 0 : this.zzbn.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzbf.hashCode(this.zzbo)) * 31;
        if (!(this.zzch == null || this.zzch.isEmpty())) {
            i = this.zzch.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzaz zzaz) {
        if (!(this.zzbn == null || this.zzbn.equals(""))) {
            zzaz.zza(1, this.zzbn);
        }
        if (this.zzbo != null && this.zzbo.length > 0) {
            for (zzbh zzbh : this.zzbo) {
                if (zzbh != null) {
                    zzaz.zza(2, zzbh);
                }
            }
        }
        super.zza(zzaz);
    }

    protected final int zzu() {
        int zzu = super.zzu();
        if (!(this.zzbn == null || this.zzbn.equals(""))) {
            zzu += zzaz.zzb(1, this.zzbn);
        }
        if (this.zzbo == null || this.zzbo.length <= 0) {
            return zzu;
        }
        int i = zzu;
        for (zzbh zzbh : this.zzbo) {
            if (zzbh != null) {
                i += zzaz.zzb(2, zzbh);
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
                    this.zzbn = zzay.readString();
                    continue;
                case 18:
                    int zzb = zzbk.zzb(zzay, 18);
                    zzy = this.zzbo == null ? 0 : this.zzbo.length;
                    Object obj = new zzas[(zzb + zzy)];
                    if (zzy != 0) {
                        System.arraycopy(this.zzbo, 0, obj, 0, zzy);
                    }
                    while (zzy < obj.length - 1) {
                        obj[zzy] = new zzas();
                        zzay.zza(obj[zzy]);
                        zzay.zzy();
                        zzy++;
                    }
                    obj[zzy] = new zzas();
                    zzay.zza(obj[zzy]);
                    this.zzbo = obj;
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
