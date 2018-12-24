package com.google.android.gms.internal.measurement;

import org.apache.http.protocol.HTTP;

public final class zzfm extends zzyc<zzfm> {
    private static volatile zzfm[] zzavz;
    public Boolean zzavh;
    public Boolean zzavi;
    public Integer zzavk;
    public String zzawa;
    public zzfk zzawb;

    public static zzfm[] zzmu() {
        if (zzavz == null) {
            synchronized (zzyg.zzcfc) {
                if (zzavz == null) {
                    zzavz = new zzfm[0];
                }
            }
        }
        return zzavz;
    }

    public zzfm() {
        this.zzavk = null;
        this.zzawa = null;
        this.zzawb = null;
        this.zzavh = null;
        this.zzavi = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfm)) {
            return false;
        }
        zzfm zzfm = (zzfm) obj;
        if (this.zzavk == null) {
            if (zzfm.zzavk != null) {
                return false;
            }
        } else if (!this.zzavk.equals(zzfm.zzavk)) {
            return false;
        }
        if (this.zzawa == null) {
            if (zzfm.zzawa != null) {
                return false;
            }
        } else if (!this.zzawa.equals(zzfm.zzawa)) {
            return false;
        }
        if (this.zzawb == null) {
            if (zzfm.zzawb != null) {
                return false;
            }
        } else if (!this.zzawb.equals(zzfm.zzawb)) {
            return false;
        }
        if (this.zzavh == null) {
            if (zzfm.zzavh != null) {
                return false;
            }
        } else if (!this.zzavh.equals(zzfm.zzavh)) {
            return false;
        }
        if (this.zzavi == null) {
            if (zzfm.zzavi != null) {
                return false;
            }
        } else if (!this.zzavi.equals(zzfm.zzavi)) {
            return false;
        }
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            return this.zzcet.equals(zzfm.zzcet);
        }
        if (zzfm.zzcet == null || zzfm.zzcet.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (this.zzawa == null ? 0 : this.zzawa.hashCode()) + (((this.zzavk == null ? 0 : this.zzavk.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31);
        zzfk zzfk = this.zzawb;
        hashCode = ((this.zzavi == null ? 0 : this.zzavi.hashCode()) + (((this.zzavh == null ? 0 : this.zzavh.hashCode()) + (((zzfk == null ? 0 : zzfk.hashCode()) + (hashCode * 31)) * 31)) * 31)) * 31;
        if (!(this.zzcet == null || this.zzcet.isEmpty())) {
            i = this.zzcet.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzya zzya) {
        if (this.zzavk != null) {
            zzya.zzd(1, this.zzavk.intValue());
        }
        if (this.zzawa != null) {
            zzya.zzb(2, this.zzawa);
        }
        if (this.zzawb != null) {
            zzya.zza(3, this.zzawb);
        }
        if (this.zzavh != null) {
            zzya.zzb(4, this.zzavh.booleanValue());
        }
        if (this.zzavi != null) {
            zzya.zzb(5, this.zzavi.booleanValue());
        }
        super.zza(zzya);
    }

    protected final int zzf() {
        int zzf = super.zzf();
        if (this.zzavk != null) {
            zzf += zzya.zzh(1, this.zzavk.intValue());
        }
        if (this.zzawa != null) {
            zzf += zzya.zzc(2, this.zzawa);
        }
        if (this.zzawb != null) {
            zzf += zzya.zzb(3, this.zzawb);
        }
        if (this.zzavh != null) {
            this.zzavh.booleanValue();
            zzf += zzya.zzbd(4) + 1;
        }
        if (this.zzavi == null) {
            return zzf;
        }
        this.zzavi.booleanValue();
        return zzf + (zzya.zzbd(5) + 1);
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) {
        while (true) {
            int zzuj = zzxz.zzuj();
            switch (zzuj) {
                case 0:
                    break;
                case 8:
                    this.zzavk = Integer.valueOf(zzxz.zzvb());
                    continue;
                case 18:
                    this.zzawa = zzxz.readString();
                    continue;
                case 26:
                    if (this.zzawb == null) {
                        this.zzawb = new zzfk();
                    }
                    zzxz.zza(this.zzawb);
                    continue;
                case HTTP.SP /*32*/:
                    this.zzavh = Boolean.valueOf(zzxz.zzup());
                    continue;
                case 40:
                    this.zzavi = Boolean.valueOf(zzxz.zzup());
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
