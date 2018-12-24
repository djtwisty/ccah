package com.google.android.gms.internal.measurement;

public final class zzfl extends zzyc<zzfl> {
    public Integer zzavu;
    public Boolean zzavv;
    public String zzavw;
    public String zzavx;
    public String zzavy;

    public zzfl() {
        this.zzavu = null;
        this.zzavv = null;
        this.zzavw = null;
        this.zzavx = null;
        this.zzavy = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfl)) {
            return false;
        }
        zzfl zzfl = (zzfl) obj;
        if (this.zzavu == null) {
            if (zzfl.zzavu != null) {
                return false;
            }
        } else if (!this.zzavu.equals(zzfl.zzavu)) {
            return false;
        }
        if (this.zzavv == null) {
            if (zzfl.zzavv != null) {
                return false;
            }
        } else if (!this.zzavv.equals(zzfl.zzavv)) {
            return false;
        }
        if (this.zzavw == null) {
            if (zzfl.zzavw != null) {
                return false;
            }
        } else if (!this.zzavw.equals(zzfl.zzavw)) {
            return false;
        }
        if (this.zzavx == null) {
            if (zzfl.zzavx != null) {
                return false;
            }
        } else if (!this.zzavx.equals(zzfl.zzavx)) {
            return false;
        }
        if (this.zzavy == null) {
            if (zzfl.zzavy != null) {
                return false;
            }
        } else if (!this.zzavy.equals(zzfl.zzavy)) {
            return false;
        }
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            return this.zzcet.equals(zzfl.zzcet);
        }
        if (zzfl.zzcet == null || zzfl.zzcet.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.zzavy == null ? 0 : this.zzavy.hashCode()) + (((this.zzavx == null ? 0 : this.zzavx.hashCode()) + (((this.zzavw == null ? 0 : this.zzavw.hashCode()) + (((this.zzavv == null ? 0 : this.zzavv.hashCode()) + (((this.zzavu == null ? 0 : this.zzavu.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!(this.zzcet == null || this.zzcet.isEmpty())) {
            i = this.zzcet.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzya zzya) {
        if (this.zzavu != null) {
            zzya.zzd(1, this.zzavu.intValue());
        }
        if (this.zzavv != null) {
            zzya.zzb(2, this.zzavv.booleanValue());
        }
        if (this.zzavw != null) {
            zzya.zzb(3, this.zzavw);
        }
        if (this.zzavx != null) {
            zzya.zzb(4, this.zzavx);
        }
        if (this.zzavy != null) {
            zzya.zzb(5, this.zzavy);
        }
        super.zza(zzya);
    }

    protected final int zzf() {
        int zzf = super.zzf();
        if (this.zzavu != null) {
            zzf += zzya.zzh(1, this.zzavu.intValue());
        }
        if (this.zzavv != null) {
            this.zzavv.booleanValue();
            zzf += zzya.zzbd(2) + 1;
        }
        if (this.zzavw != null) {
            zzf += zzya.zzc(3, this.zzavw);
        }
        if (this.zzavx != null) {
            zzf += zzya.zzc(4, this.zzavx);
        }
        if (this.zzavy != null) {
            return zzf + zzya.zzc(5, this.zzavy);
        }
        return zzf;
    }

    private final zzfl zzc(zzxz zzxz) {
        while (true) {
            int zzuj = zzxz.zzuj();
            switch (zzuj) {
                case 0:
                    break;
                case 8:
                    int position = zzxz.getPosition();
                    try {
                        int zzvb = zzxz.zzvb();
                        if (zzvb < 0 || zzvb > 4) {
                            throw new IllegalArgumentException(zzvb + " is not a valid enum ComparisonType");
                        }
                        this.zzavu = Integer.valueOf(zzvb);
                        continue;
                    } catch (IllegalArgumentException e) {
                        zzxz.zzcb(position);
                        zza(zzxz, zzuj);
                        break;
                    }
                case 16:
                    this.zzavv = Boolean.valueOf(zzxz.zzup());
                    continue;
                case 26:
                    this.zzavw = zzxz.readString();
                    continue;
                case 34:
                    this.zzavx = zzxz.readString();
                    continue;
                case 42:
                    this.zzavy = zzxz.readString();
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
        return zzc(zzxz);
    }
}
