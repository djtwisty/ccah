package com.google.android.gms.internal.measurement;

public final class zzfn extends zzyc<zzfn> {
    public Integer zzawc;
    public String zzawd;
    public Boolean zzawe;
    public String[] zzawf;

    public zzfn() {
        this.zzawc = null;
        this.zzawd = null;
        this.zzawe = null;
        this.zzawf = zzyl.zzcfm;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfn)) {
            return false;
        }
        zzfn zzfn = (zzfn) obj;
        if (this.zzawc == null) {
            if (zzfn.zzawc != null) {
                return false;
            }
        } else if (!this.zzawc.equals(zzfn.zzawc)) {
            return false;
        }
        if (this.zzawd == null) {
            if (zzfn.zzawd != null) {
                return false;
            }
        } else if (!this.zzawd.equals(zzfn.zzawd)) {
            return false;
        }
        if (this.zzawe == null) {
            if (zzfn.zzawe != null) {
                return false;
            }
        } else if (!this.zzawe.equals(zzfn.zzawe)) {
            return false;
        }
        if (!zzyg.equals(this.zzawf, zzfn.zzawf)) {
            return false;
        }
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            return this.zzcet.equals(zzfn.zzcet);
        }
        if (zzfn.zzcet == null || zzfn.zzcet.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((this.zzawe == null ? 0 : this.zzawe.hashCode()) + (((this.zzawd == null ? 0 : this.zzawd.hashCode()) + (((this.zzawc == null ? 0 : this.zzawc.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31) + zzyg.hashCode(this.zzawf)) * 31;
        if (!(this.zzcet == null || this.zzcet.isEmpty())) {
            i = this.zzcet.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzya zzya) {
        if (this.zzawc != null) {
            zzya.zzd(1, this.zzawc.intValue());
        }
        if (this.zzawd != null) {
            zzya.zzb(2, this.zzawd);
        }
        if (this.zzawe != null) {
            zzya.zzb(3, this.zzawe.booleanValue());
        }
        if (this.zzawf != null && this.zzawf.length > 0) {
            for (String str : this.zzawf) {
                if (str != null) {
                    zzya.zzb(4, str);
                }
            }
        }
        super.zza(zzya);
    }

    protected final int zzf() {
        int zzf = super.zzf();
        if (this.zzawc != null) {
            zzf += zzya.zzh(1, this.zzawc.intValue());
        }
        if (this.zzawd != null) {
            zzf += zzya.zzc(2, this.zzawd);
        }
        if (this.zzawe != null) {
            this.zzawe.booleanValue();
            zzf += zzya.zzbd(3) + 1;
        }
        if (this.zzawf == null || this.zzawf.length <= 0) {
            return zzf;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < this.zzawf.length) {
            int zzgc;
            String str = this.zzawf[i];
            if (str != null) {
                i3++;
                zzgc = zzya.zzgc(str) + i2;
            } else {
                zzgc = i2;
            }
            i++;
            i2 = zzgc;
        }
        return (zzf + i2) + (i3 * 1);
    }

    private final zzfn zzd(zzxz zzxz) {
        int position;
        while (true) {
            int zzuj = zzxz.zzuj();
            switch (zzuj) {
                case 0:
                    break;
                case 8:
                    position = zzxz.getPosition();
                    try {
                        int zzvb = zzxz.zzvb();
                        if (zzvb < 0 || zzvb > 6) {
                            throw new IllegalArgumentException(zzvb + " is not a valid enum MatchType");
                        }
                        this.zzawc = Integer.valueOf(zzvb);
                        continue;
                    } catch (IllegalArgumentException e) {
                        zzxz.zzcb(position);
                        zza(zzxz, zzuj);
                        break;
                    }
                case 18:
                    this.zzawd = zzxz.readString();
                    continue;
                case 24:
                    this.zzawe = Boolean.valueOf(zzxz.zzup());
                    continue;
                case 34:
                    position = zzyl.zzb(zzxz, 34);
                    zzuj = this.zzawf == null ? 0 : this.zzawf.length;
                    Object obj = new String[(position + zzuj)];
                    if (zzuj != 0) {
                        System.arraycopy(this.zzawf, 0, obj, 0, zzuj);
                    }
                    while (zzuj < obj.length - 1) {
                        obj[zzuj] = zzxz.readString();
                        zzxz.zzuj();
                        zzuj++;
                    }
                    obj[zzuj] = zzxz.readString();
                    this.zzawf = obj;
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

    public final /* synthetic */ zzyi zza(zzxz zzxz) {
        return zzd(zzxz);
    }
}
