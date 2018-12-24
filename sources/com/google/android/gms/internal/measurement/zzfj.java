package com.google.android.gms.internal.measurement;

import org.apache.http.protocol.HTTP;

public final class zzfj extends zzyc<zzfj> {
    private static volatile zzfj[] zzavj;
    public Boolean zzavh;
    public Boolean zzavi;
    public Integer zzavk;
    public String zzavl;
    public zzfk[] zzavm;
    private Boolean zzavn;
    public zzfl zzavo;

    public static zzfj[] zzms() {
        if (zzavj == null) {
            synchronized (zzyg.zzcfc) {
                if (zzavj == null) {
                    zzavj = new zzfj[0];
                }
            }
        }
        return zzavj;
    }

    public zzfj() {
        this.zzavk = null;
        this.zzavl = null;
        this.zzavm = zzfk.zzmt();
        this.zzavn = null;
        this.zzavo = null;
        this.zzavh = null;
        this.zzavi = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfj)) {
            return false;
        }
        zzfj zzfj = (zzfj) obj;
        if (this.zzavk == null) {
            if (zzfj.zzavk != null) {
                return false;
            }
        } else if (!this.zzavk.equals(zzfj.zzavk)) {
            return false;
        }
        if (this.zzavl == null) {
            if (zzfj.zzavl != null) {
                return false;
            }
        } else if (!this.zzavl.equals(zzfj.zzavl)) {
            return false;
        }
        if (!zzyg.equals(this.zzavm, zzfj.zzavm)) {
            return false;
        }
        if (this.zzavn == null) {
            if (zzfj.zzavn != null) {
                return false;
            }
        } else if (!this.zzavn.equals(zzfj.zzavn)) {
            return false;
        }
        if (this.zzavo == null) {
            if (zzfj.zzavo != null) {
                return false;
            }
        } else if (!this.zzavo.equals(zzfj.zzavo)) {
            return false;
        }
        if (this.zzavh == null) {
            if (zzfj.zzavh != null) {
                return false;
            }
        } else if (!this.zzavh.equals(zzfj.zzavh)) {
            return false;
        }
        if (this.zzavi == null) {
            if (zzfj.zzavi != null) {
                return false;
            }
        } else if (!this.zzavi.equals(zzfj.zzavi)) {
            return false;
        }
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            return this.zzcet.equals(zzfj.zzcet);
        }
        if (zzfj.zzcet == null || zzfj.zzcet.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (this.zzavn == null ? 0 : this.zzavn.hashCode()) + (((((this.zzavl == null ? 0 : this.zzavl.hashCode()) + (((this.zzavk == null ? 0 : this.zzavk.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + zzyg.hashCode(this.zzavm)) * 31);
        zzfl zzfl = this.zzavo;
        hashCode = ((this.zzavi == null ? 0 : this.zzavi.hashCode()) + (((this.zzavh == null ? 0 : this.zzavh.hashCode()) + (((zzfl == null ? 0 : zzfl.hashCode()) + (hashCode * 31)) * 31)) * 31)) * 31;
        if (!(this.zzcet == null || this.zzcet.isEmpty())) {
            i = this.zzcet.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzya zzya) {
        if (this.zzavk != null) {
            zzya.zzd(1, this.zzavk.intValue());
        }
        if (this.zzavl != null) {
            zzya.zzb(2, this.zzavl);
        }
        if (this.zzavm != null && this.zzavm.length > 0) {
            for (zzyi zzyi : this.zzavm) {
                if (zzyi != null) {
                    zzya.zza(3, zzyi);
                }
            }
        }
        if (this.zzavn != null) {
            zzya.zzb(4, this.zzavn.booleanValue());
        }
        if (this.zzavo != null) {
            zzya.zza(5, this.zzavo);
        }
        if (this.zzavh != null) {
            zzya.zzb(6, this.zzavh.booleanValue());
        }
        if (this.zzavi != null) {
            zzya.zzb(7, this.zzavi.booleanValue());
        }
        super.zza(zzya);
    }

    protected final int zzf() {
        int zzf = super.zzf();
        if (this.zzavk != null) {
            zzf += zzya.zzh(1, this.zzavk.intValue());
        }
        if (this.zzavl != null) {
            zzf += zzya.zzc(2, this.zzavl);
        }
        if (this.zzavm != null && this.zzavm.length > 0) {
            int i = zzf;
            for (zzyi zzyi : this.zzavm) {
                if (zzyi != null) {
                    i += zzya.zzb(3, zzyi);
                }
            }
            zzf = i;
        }
        if (this.zzavn != null) {
            this.zzavn.booleanValue();
            zzf += zzya.zzbd(4) + 1;
        }
        if (this.zzavo != null) {
            zzf += zzya.zzb(5, this.zzavo);
        }
        if (this.zzavh != null) {
            this.zzavh.booleanValue();
            zzf += zzya.zzbd(6) + 1;
        }
        if (this.zzavi == null) {
            return zzf;
        }
        this.zzavi.booleanValue();
        return zzf + (zzya.zzbd(7) + 1);
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
                    this.zzavl = zzxz.readString();
                    continue;
                case 26:
                    int zzb = zzyl.zzb(zzxz, 26);
                    zzuj = this.zzavm == null ? 0 : this.zzavm.length;
                    Object obj = new zzfk[(zzb + zzuj)];
                    if (zzuj != 0) {
                        System.arraycopy(this.zzavm, 0, obj, 0, zzuj);
                    }
                    while (zzuj < obj.length - 1) {
                        obj[zzuj] = new zzfk();
                        zzxz.zza(obj[zzuj]);
                        zzxz.zzuj();
                        zzuj++;
                    }
                    obj[zzuj] = new zzfk();
                    zzxz.zza(obj[zzuj]);
                    this.zzavm = obj;
                    continue;
                case HTTP.SP /*32*/:
                    this.zzavn = Boolean.valueOf(zzxz.zzup());
                    continue;
                case 42:
                    if (this.zzavo == null) {
                        this.zzavo = new zzfl();
                    }
                    zzxz.zza(this.zzavo);
                    continue;
                case 48:
                    this.zzavh = Boolean.valueOf(zzxz.zzup());
                    continue;
                case 56:
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
