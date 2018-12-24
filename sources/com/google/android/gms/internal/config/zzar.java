package com.google.android.gms.internal.config;

public final class zzar extends zzbb<zzar> {
    public long timestamp;
    public zzau[] zzbe;
    public byte[][] zzbf;

    public zzar() {
        this.zzbe = zzau.zzw();
        this.timestamp = 0;
        this.zzbf = zzbk.zzdc;
        this.zzch = null;
        this.zzcq = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzar)) {
            return false;
        }
        zzar zzar = (zzar) obj;
        if (!zzbf.equals(this.zzbe, zzar.zzbe)) {
            return false;
        }
        if (this.timestamp != zzar.timestamp) {
            return false;
        }
        if (!zzbf.zza(this.zzbf, zzar.zzbf)) {
            return false;
        }
        if (this.zzch != null && !this.zzch.isEmpty()) {
            return this.zzch.equals(zzar.zzch);
        }
        if (zzar.zzch == null || zzar.zzch.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + zzbf.hashCode(this.zzbe)) * 31) + ((int) (this.timestamp ^ (this.timestamp >>> 32)))) * 31) + zzbf.zza(this.zzbf)) * 31;
        if (this.zzch == null || this.zzch.isEmpty()) {
            i = 0;
        } else {
            i = this.zzch.hashCode();
        }
        return i + hashCode;
    }

    public final void zza(zzaz zzaz) {
        int i = 0;
        if (this.zzbe != null && this.zzbe.length > 0) {
            for (zzbh zzbh : this.zzbe) {
                if (zzbh != null) {
                    zzaz.zza(1, zzbh);
                }
            }
        }
        if (this.timestamp != 0) {
            zzaz.zza(2, this.timestamp);
        }
        if (this.zzbf != null && this.zzbf.length > 0) {
            while (i < this.zzbf.length) {
                byte[] bArr = this.zzbf[i];
                if (bArr != null) {
                    zzaz.zza(3, bArr);
                }
                i++;
            }
        }
        super.zza(zzaz);
    }

    protected final int zzu() {
        int zzu = super.zzu();
        if (this.zzbe != null && this.zzbe.length > 0) {
            for (zzbh zzbh : this.zzbe) {
                if (zzbh != null) {
                    zzu += zzaz.zzb(1, zzbh);
                }
            }
        }
        if (this.timestamp != 0) {
            zzu += zzaz.zzl(2) + 8;
        }
        if (this.zzbf == null || this.zzbf.length <= 0) {
            return zzu;
        }
        int i = 0;
        int i2 = 0;
        for (byte[] bArr : this.zzbf) {
            if (bArr != null) {
                i2++;
                i += zzaz.zzb(bArr);
            }
        }
        return (zzu + i) + (i2 * 1);
    }

    public final /* synthetic */ zzbh zza(zzay zzay) {
        while (true) {
            int zzy = zzay.zzy();
            int zzb;
            Object obj;
            switch (zzy) {
                case 0:
                    break;
                case 10:
                    zzb = zzbk.zzb(zzay, 10);
                    zzy = this.zzbe == null ? 0 : this.zzbe.length;
                    obj = new zzau[(zzb + zzy)];
                    if (zzy != 0) {
                        System.arraycopy(this.zzbe, 0, obj, 0, zzy);
                    }
                    while (zzy < obj.length - 1) {
                        obj[zzy] = new zzau();
                        zzay.zza(obj[zzy]);
                        zzay.zzy();
                        zzy++;
                    }
                    obj[zzy] = new zzau();
                    zzay.zza(obj[zzy]);
                    this.zzbe = obj;
                    continue;
                case 17:
                    this.timestamp = zzay.zzaa();
                    continue;
                case 26:
                    zzb = zzbk.zzb(zzay, 26);
                    zzy = this.zzbf == null ? 0 : this.zzbf.length;
                    obj = new byte[(zzb + zzy)][];
                    if (zzy != 0) {
                        System.arraycopy(this.zzbf, 0, obj, 0, zzy);
                    }
                    while (zzy < obj.length - 1) {
                        obj[zzy] = zzay.readBytes();
                        zzay.zzy();
                        zzy++;
                    }
                    obj[zzy] = zzay.readBytes();
                    this.zzbf = obj;
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
