package com.google.android.gms.internal.measurement;

public final class zzfp extends zzyc<zzfp> {
    public String zzafi;
    public Long zzawk;
    private Integer zzawl;
    public zzfq[] zzawm;
    public zzfo[] zzawn;
    public zzfi[] zzawo;
    private String zzawp;
    private Boolean zzawq;

    public zzfp() {
        this.zzawk = null;
        this.zzafi = null;
        this.zzawl = null;
        this.zzawm = zzfq.zzmw();
        this.zzawn = zzfo.zzmv();
        this.zzawo = zzfi.zzmr();
        this.zzawp = null;
        this.zzawq = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfp)) {
            return false;
        }
        zzfp zzfp = (zzfp) obj;
        if (this.zzawk == null) {
            if (zzfp.zzawk != null) {
                return false;
            }
        } else if (!this.zzawk.equals(zzfp.zzawk)) {
            return false;
        }
        if (this.zzafi == null) {
            if (zzfp.zzafi != null) {
                return false;
            }
        } else if (!this.zzafi.equals(zzfp.zzafi)) {
            return false;
        }
        if (this.zzawl == null) {
            if (zzfp.zzawl != null) {
                return false;
            }
        } else if (!this.zzawl.equals(zzfp.zzawl)) {
            return false;
        }
        if (!zzyg.equals(this.zzawm, zzfp.zzawm)) {
            return false;
        }
        if (!zzyg.equals(this.zzawn, zzfp.zzawn)) {
            return false;
        }
        if (!zzyg.equals(this.zzawo, zzfp.zzawo)) {
            return false;
        }
        if (this.zzawp == null) {
            if (zzfp.zzawp != null) {
                return false;
            }
        } else if (!this.zzawp.equals(zzfp.zzawp)) {
            return false;
        }
        if (this.zzawq == null) {
            if (zzfp.zzawq != null) {
                return false;
            }
        } else if (!this.zzawq.equals(zzfp.zzawq)) {
            return false;
        }
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            return this.zzcet.equals(zzfp.zzcet);
        }
        if (zzfp.zzcet == null || zzfp.zzcet.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.zzawq == null ? 0 : this.zzawq.hashCode()) + (((this.zzawp == null ? 0 : this.zzawp.hashCode()) + (((((((((this.zzawl == null ? 0 : this.zzawl.hashCode()) + (((this.zzafi == null ? 0 : this.zzafi.hashCode()) + (((this.zzawk == null ? 0 : this.zzawk.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31) + zzyg.hashCode(this.zzawm)) * 31) + zzyg.hashCode(this.zzawn)) * 31) + zzyg.hashCode(this.zzawo)) * 31)) * 31)) * 31;
        if (!(this.zzcet == null || this.zzcet.isEmpty())) {
            i = this.zzcet.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzya zzya) {
        int i = 0;
        if (this.zzawk != null) {
            zzya.zzi(1, this.zzawk.longValue());
        }
        if (this.zzafi != null) {
            zzya.zzb(2, this.zzafi);
        }
        if (this.zzawl != null) {
            zzya.zzd(3, this.zzawl.intValue());
        }
        if (this.zzawm != null && this.zzawm.length > 0) {
            for (zzyi zzyi : this.zzawm) {
                if (zzyi != null) {
                    zzya.zza(4, zzyi);
                }
            }
        }
        if (this.zzawn != null && this.zzawn.length > 0) {
            for (zzyi zzyi2 : this.zzawn) {
                if (zzyi2 != null) {
                    zzya.zza(5, zzyi2);
                }
            }
        }
        if (this.zzawo != null && this.zzawo.length > 0) {
            while (i < this.zzawo.length) {
                zzyi zzyi3 = this.zzawo[i];
                if (zzyi3 != null) {
                    zzya.zza(6, zzyi3);
                }
                i++;
            }
        }
        if (this.zzawp != null) {
            zzya.zzb(7, this.zzawp);
        }
        if (this.zzawq != null) {
            zzya.zzb(8, this.zzawq.booleanValue());
        }
        super.zza(zzya);
    }

    protected final int zzf() {
        int i;
        int i2 = 0;
        int zzf = super.zzf();
        if (this.zzawk != null) {
            zzf += zzya.zzd(1, this.zzawk.longValue());
        }
        if (this.zzafi != null) {
            zzf += zzya.zzc(2, this.zzafi);
        }
        if (this.zzawl != null) {
            zzf += zzya.zzh(3, this.zzawl.intValue());
        }
        if (this.zzawm != null && this.zzawm.length > 0) {
            i = zzf;
            for (zzyi zzyi : this.zzawm) {
                if (zzyi != null) {
                    i += zzya.zzb(4, zzyi);
                }
            }
            zzf = i;
        }
        if (this.zzawn != null && this.zzawn.length > 0) {
            i = zzf;
            for (zzyi zzyi2 : this.zzawn) {
                if (zzyi2 != null) {
                    i += zzya.zzb(5, zzyi2);
                }
            }
            zzf = i;
        }
        if (this.zzawo != null && this.zzawo.length > 0) {
            while (i2 < this.zzawo.length) {
                zzyi zzyi3 = this.zzawo[i2];
                if (zzyi3 != null) {
                    zzf += zzya.zzb(6, zzyi3);
                }
                i2++;
            }
        }
        if (this.zzawp != null) {
            zzf += zzya.zzc(7, this.zzawp);
        }
        if (this.zzawq == null) {
            return zzf;
        }
        this.zzawq.booleanValue();
        return zzf + (zzya.zzbd(8) + 1);
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
                    this.zzawk = Long.valueOf(zzxz.zzvc());
                    continue;
                case 18:
                    this.zzafi = zzxz.readString();
                    continue;
                case 24:
                    this.zzawl = Integer.valueOf(zzxz.zzvb());
                    continue;
                case 34:
                    zzb = zzyl.zzb(zzxz, 34);
                    zzuj = this.zzawm == null ? 0 : this.zzawm.length;
                    obj = new zzfq[(zzb + zzuj)];
                    if (zzuj != 0) {
                        System.arraycopy(this.zzawm, 0, obj, 0, zzuj);
                    }
                    while (zzuj < obj.length - 1) {
                        obj[zzuj] = new zzfq();
                        zzxz.zza(obj[zzuj]);
                        zzxz.zzuj();
                        zzuj++;
                    }
                    obj[zzuj] = new zzfq();
                    zzxz.zza(obj[zzuj]);
                    this.zzawm = obj;
                    continue;
                case 42:
                    zzb = zzyl.zzb(zzxz, 42);
                    zzuj = this.zzawn == null ? 0 : this.zzawn.length;
                    obj = new zzfo[(zzb + zzuj)];
                    if (zzuj != 0) {
                        System.arraycopy(this.zzawn, 0, obj, 0, zzuj);
                    }
                    while (zzuj < obj.length - 1) {
                        obj[zzuj] = new zzfo();
                        zzxz.zza(obj[zzuj]);
                        zzxz.zzuj();
                        zzuj++;
                    }
                    obj[zzuj] = new zzfo();
                    zzxz.zza(obj[zzuj]);
                    this.zzawn = obj;
                    continue;
                case 50:
                    zzb = zzyl.zzb(zzxz, 50);
                    zzuj = this.zzawo == null ? 0 : this.zzawo.length;
                    obj = new zzfi[(zzb + zzuj)];
                    if (zzuj != 0) {
                        System.arraycopy(this.zzawo, 0, obj, 0, zzuj);
                    }
                    while (zzuj < obj.length - 1) {
                        obj[zzuj] = new zzfi();
                        zzxz.zza(obj[zzuj]);
                        zzxz.zzuj();
                        zzuj++;
                    }
                    obj[zzuj] = new zzfi();
                    zzxz.zza(obj[zzuj]);
                    this.zzawo = obj;
                    continue;
                case 58:
                    this.zzawp = zzxz.readString();
                    continue;
                case 64:
                    this.zzawq = Boolean.valueOf(zzxz.zzup());
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
