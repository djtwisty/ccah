package com.google.android.gms.internal.measurement;

import org.apache.http.protocol.HTTP;

public final class zzfi extends zzyc<zzfi> {
    private static volatile zzfi[] zzavd;
    public Integer zzave;
    public zzfm[] zzavf;
    public zzfj[] zzavg;
    private Boolean zzavh;
    private Boolean zzavi;

    public static zzfi[] zzmr() {
        if (zzavd == null) {
            synchronized (zzyg.zzcfc) {
                if (zzavd == null) {
                    zzavd = new zzfi[0];
                }
            }
        }
        return zzavd;
    }

    public zzfi() {
        this.zzave = null;
        this.zzavf = zzfm.zzmu();
        this.zzavg = zzfj.zzms();
        this.zzavh = null;
        this.zzavi = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfi)) {
            return false;
        }
        zzfi zzfi = (zzfi) obj;
        if (this.zzave == null) {
            if (zzfi.zzave != null) {
                return false;
            }
        } else if (!this.zzave.equals(zzfi.zzave)) {
            return false;
        }
        if (!zzyg.equals(this.zzavf, zzfi.zzavf)) {
            return false;
        }
        if (!zzyg.equals(this.zzavg, zzfi.zzavg)) {
            return false;
        }
        if (this.zzavh == null) {
            if (zzfi.zzavh != null) {
                return false;
            }
        } else if (!this.zzavh.equals(zzfi.zzavh)) {
            return false;
        }
        if (this.zzavi == null) {
            if (zzfi.zzavi != null) {
                return false;
            }
        } else if (!this.zzavi.equals(zzfi.zzavi)) {
            return false;
        }
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            return this.zzcet.equals(zzfi.zzcet);
        }
        if (zzfi.zzcet == null || zzfi.zzcet.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.zzavi == null ? 0 : this.zzavi.hashCode()) + (((this.zzavh == null ? 0 : this.zzavh.hashCode()) + (((((((this.zzave == null ? 0 : this.zzave.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzyg.hashCode(this.zzavf)) * 31) + zzyg.hashCode(this.zzavg)) * 31)) * 31)) * 31;
        if (!(this.zzcet == null || this.zzcet.isEmpty())) {
            i = this.zzcet.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzya zzya) {
        int i = 0;
        if (this.zzave != null) {
            zzya.zzd(1, this.zzave.intValue());
        }
        if (this.zzavf != null && this.zzavf.length > 0) {
            for (zzyi zzyi : this.zzavf) {
                if (zzyi != null) {
                    zzya.zza(2, zzyi);
                }
            }
        }
        if (this.zzavg != null && this.zzavg.length > 0) {
            while (i < this.zzavg.length) {
                zzyi zzyi2 = this.zzavg[i];
                if (zzyi2 != null) {
                    zzya.zza(3, zzyi2);
                }
                i++;
            }
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
        int i = 0;
        int zzf = super.zzf();
        if (this.zzave != null) {
            zzf += zzya.zzh(1, this.zzave.intValue());
        }
        if (this.zzavf != null && this.zzavf.length > 0) {
            int i2 = zzf;
            for (zzyi zzyi : this.zzavf) {
                if (zzyi != null) {
                    i2 += zzya.zzb(2, zzyi);
                }
            }
            zzf = i2;
        }
        if (this.zzavg != null && this.zzavg.length > 0) {
            while (i < this.zzavg.length) {
                zzyi zzyi2 = this.zzavg[i];
                if (zzyi2 != null) {
                    zzf += zzya.zzb(3, zzyi2);
                }
                i++;
            }
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
            int zzb;
            Object obj;
            switch (zzuj) {
                case 0:
                    break;
                case 8:
                    this.zzave = Integer.valueOf(zzxz.zzvb());
                    continue;
                case 18:
                    zzb = zzyl.zzb(zzxz, 18);
                    zzuj = this.zzavf == null ? 0 : this.zzavf.length;
                    obj = new zzfm[(zzb + zzuj)];
                    if (zzuj != 0) {
                        System.arraycopy(this.zzavf, 0, obj, 0, zzuj);
                    }
                    while (zzuj < obj.length - 1) {
                        obj[zzuj] = new zzfm();
                        zzxz.zza(obj[zzuj]);
                        zzxz.zzuj();
                        zzuj++;
                    }
                    obj[zzuj] = new zzfm();
                    zzxz.zza(obj[zzuj]);
                    this.zzavf = obj;
                    continue;
                case 26:
                    zzb = zzyl.zzb(zzxz, 26);
                    zzuj = this.zzavg == null ? 0 : this.zzavg.length;
                    obj = new zzfj[(zzb + zzuj)];
                    if (zzuj != 0) {
                        System.arraycopy(this.zzavg, 0, obj, 0, zzuj);
                    }
                    while (zzuj < obj.length - 1) {
                        obj[zzuj] = new zzfj();
                        zzxz.zza(obj[zzuj]);
                        zzxz.zzuj();
                        zzuj++;
                    }
                    obj[zzuj] = new zzfj();
                    zzxz.zza(obj[zzuj]);
                    this.zzavg = obj;
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
