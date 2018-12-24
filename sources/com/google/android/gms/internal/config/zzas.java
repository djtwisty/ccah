package com.google.android.gms.internal.config;

import java.util.Arrays;

public final class zzas extends zzbb<zzas> {
    private static volatile zzas[] zzbg;
    public String zzbh;
    public byte[] zzbi;

    public static zzas[] zzv() {
        if (zzbg == null) {
            synchronized (zzbf.zzcp) {
                if (zzbg == null) {
                    zzbg = new zzas[0];
                }
            }
        }
        return zzbg;
    }

    public zzas() {
        this.zzbh = "";
        this.zzbi = zzbk.zzdd;
        this.zzch = null;
        this.zzcq = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzas)) {
            return false;
        }
        zzas zzas = (zzas) obj;
        if (this.zzbh == null) {
            if (zzas.zzbh != null) {
                return false;
            }
        } else if (!this.zzbh.equals(zzas.zzbh)) {
            return false;
        }
        if (!Arrays.equals(this.zzbi, zzas.zzbi)) {
            return false;
        }
        if (this.zzch != null && !this.zzch.isEmpty()) {
            return this.zzch.equals(zzas.zzch);
        }
        if (zzas.zzch == null || zzas.zzch.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((this.zzbh == null ? 0 : this.zzbh.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + Arrays.hashCode(this.zzbi)) * 31;
        if (!(this.zzch == null || this.zzch.isEmpty())) {
            i = this.zzch.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzaz zzaz) {
        if (!(this.zzbh == null || this.zzbh.equals(""))) {
            zzaz.zza(1, this.zzbh);
        }
        if (!Arrays.equals(this.zzbi, zzbk.zzdd)) {
            zzaz.zza(2, this.zzbi);
        }
        super.zza(zzaz);
    }

    protected final int zzu() {
        int zzu = super.zzu();
        if (!(this.zzbh == null || this.zzbh.equals(""))) {
            zzu += zzaz.zzb(1, this.zzbh);
        }
        if (Arrays.equals(this.zzbi, zzbk.zzdd)) {
            return zzu;
        }
        byte[] bArr = this.zzbi;
        return zzu + (zzaz.zzb(bArr) + zzaz.zzl(2));
    }

    public final /* synthetic */ zzbh zza(zzay zzay) {
        while (true) {
            int zzy = zzay.zzy();
            switch (zzy) {
                case 0:
                    break;
                case 10:
                    this.zzbh = zzay.readString();
                    continue;
                case 18:
                    this.zzbi = zzay.readBytes();
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
