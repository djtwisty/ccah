package com.google.android.gms.internal.config;

public final class zzaw extends zzbb<zzaw> {
    private static volatile zzaw[] zzbu;
    public int resourceId;
    public String zzbn;
    public long zzbv;

    public static zzaw[] zzx() {
        if (zzbu == null) {
            synchronized (zzbf.zzcp) {
                if (zzbu == null) {
                    zzbu = new zzaw[0];
                }
            }
        }
        return zzbu;
    }

    public zzaw() {
        this.resourceId = 0;
        this.zzbv = 0;
        this.zzbn = "";
        this.zzch = null;
        this.zzcq = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaw)) {
            return false;
        }
        zzaw zzaw = (zzaw) obj;
        if (this.resourceId != zzaw.resourceId) {
            return false;
        }
        if (this.zzbv != zzaw.zzbv) {
            return false;
        }
        if (this.zzbn == null) {
            if (zzaw.zzbn != null) {
                return false;
            }
        } else if (!this.zzbn.equals(zzaw.zzbn)) {
            return false;
        }
        if (this.zzch != null && !this.zzch.isEmpty()) {
            return this.zzch.equals(zzaw.zzch);
        }
        if (zzaw.zzch == null || zzaw.zzch.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.zzbn == null ? 0 : this.zzbn.hashCode()) + ((((((getClass().getName().hashCode() + 527) * 31) + this.resourceId) * 31) + ((int) (this.zzbv ^ (this.zzbv >>> 32)))) * 31)) * 31;
        if (!(this.zzch == null || this.zzch.isEmpty())) {
            i = this.zzch.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzaz zzaz) {
        if (this.resourceId != 0) {
            zzaz.zzc(1, this.resourceId);
        }
        if (this.zzbv != 0) {
            zzaz.zza(2, this.zzbv);
        }
        if (!(this.zzbn == null || this.zzbn.equals(""))) {
            zzaz.zza(3, this.zzbn);
        }
        super.zza(zzaz);
    }

    protected final int zzu() {
        int zzu = super.zzu();
        if (this.resourceId != 0) {
            zzu += zzaz.zzd(1, this.resourceId);
        }
        if (this.zzbv != 0) {
            zzu += zzaz.zzl(2) + 8;
        }
        if (this.zzbn == null || this.zzbn.equals("")) {
            return zzu;
        }
        return zzu + zzaz.zzb(3, this.zzbn);
    }

    public final /* synthetic */ zzbh zza(zzay zzay) {
        while (true) {
            int zzy = zzay.zzy();
            switch (zzy) {
                case 0:
                    break;
                case 8:
                    this.resourceId = zzay.zzz();
                    continue;
                case 17:
                    this.zzbv = zzay.zzaa();
                    continue;
                case 26:
                    this.zzbn = zzay.readString();
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
