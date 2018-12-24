package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.util.List;

final class zzey implements zzhr {
    private int tag;
    private final zzet zztl;
    private int zztm;
    private int zztn = 0;

    public static zzey zza(zzet zzet) {
        if (zzet.zzta != null) {
            return zzet.zzta;
        }
        return new zzey(zzet);
    }

    private zzey(zzet zzet) {
        this.zztl = (zzet) zzfv.zza((Object) zzet, "input");
        this.zztl.zzta = this;
    }

    public final int zzgg() {
        if (this.zztn != 0) {
            this.tag = this.zztn;
            this.zztn = 0;
        } else {
            this.tag = this.zztl.zzfi();
        }
        if (this.tag == 0 || this.tag == this.zztm) {
            return BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return this.tag >>> 3;
    }

    public final int getTag() {
        return this.tag;
    }

    public final boolean zzgh() {
        if (this.zztl.zzfy() || this.tag == this.zztm) {
            return false;
        }
        return this.zztl.zzo(this.tag);
    }

    private final void zzy(int i) {
        if ((this.tag & 7) != i) {
            throw zzgc.zzhv();
        }
    }

    public final double readDouble() {
        zzy(1);
        return this.zztl.readDouble();
    }

    public final float readFloat() {
        zzy(5);
        return this.zztl.readFloat();
    }

    public final long zzfj() {
        zzy(0);
        return this.zztl.zzfj();
    }

    public final long zzfk() {
        zzy(0);
        return this.zztl.zzfk();
    }

    public final int zzfl() {
        zzy(0);
        return this.zztl.zzfl();
    }

    public final long zzfm() {
        zzy(1);
        return this.zztl.zzfm();
    }

    public final int zzfn() {
        zzy(5);
        return this.zztl.zzfn();
    }

    public final boolean zzfo() {
        zzy(0);
        return this.zztl.zzfo();
    }

    public final String readString() {
        zzy(2);
        return this.zztl.readString();
    }

    public final String zzfp() {
        zzy(2);
        return this.zztl.zzfp();
    }

    public final <T> T zza(zzhw<T> zzhw, zzfg zzfg) {
        zzy(2);
        return zzc(zzhw, zzfg);
    }

    public final <T> T zzb(zzhw<T> zzhw, zzfg zzfg) {
        zzy(3);
        return zzd(zzhw, zzfg);
    }

    private final <T> T zzc(zzhw<T> zzhw, zzfg zzfg) {
        int zzfr = this.zztl.zzfr();
        if (this.zztl.zzsx >= this.zztl.zzsy) {
            throw new zzgc("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        zzfr = this.zztl.zzp(zzfr);
        T newInstance = zzhw.newInstance();
        zzet zzet = this.zztl;
        zzet.zzsx++;
        zzhw.zza(newInstance, this, zzfg);
        zzhw.zzf(newInstance);
        this.zztl.zzn(0);
        zzet = this.zztl;
        zzet.zzsx--;
        this.zztl.zzq(zzfr);
        return newInstance;
    }

    private final <T> T zzd(zzhw<T> zzhw, zzfg zzfg) {
        int i = this.zztm;
        this.zztm = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzhw.newInstance();
            zzhw.zza(newInstance, this, zzfg);
            zzhw.zzf(newInstance);
            if (this.tag == this.zztm) {
                return newInstance;
            }
            throw zzgc.zzhx();
        } finally {
            this.zztm = i;
        }
    }

    public final zzeh zzfq() {
        zzy(2);
        return this.zztl.zzfq();
    }

    public final int zzfr() {
        zzy(0);
        return this.zztl.zzfr();
    }

    public final int zzfs() {
        zzy(0);
        return this.zztl.zzfs();
    }

    public final int zzft() {
        zzy(5);
        return this.zztl.zzft();
    }

    public final long zzfu() {
        zzy(1);
        return this.zztl.zzfu();
    }

    public final int zzfv() {
        zzy(0);
        return this.zztl.zzfv();
    }

    public final long zzfw() {
        zzy(0);
        return this.zztl.zzfw();
    }

    public final void zzd(List<Double> list) {
        int zzfr;
        if (list instanceof zzfd) {
            zzfd zzfd = (zzfd) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    zzfr = this.zztl.zzfr();
                    zzz(zzfr);
                    zzfr += this.zztl.zzfz();
                    do {
                        zzfd.zzc(this.zztl.readDouble());
                    } while (this.zztl.zzfz() < zzfr);
                    return;
                default:
                    throw zzgc.zzhv();
            }
            do {
                zzfd.zzc(this.zztl.readDouble());
                if (!this.zztl.zzfy()) {
                    zzfr = this.zztl.zzfi();
                } else {
                    return;
                }
            } while (zzfr == this.tag);
            this.zztn = zzfr;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                zzfr = this.zztl.zzfr();
                zzz(zzfr);
                zzfr += this.zztl.zzfz();
                do {
                    list.add(Double.valueOf(this.zztl.readDouble()));
                } while (this.zztl.zzfz() < zzfr);
                return;
            default:
                throw zzgc.zzhv();
        }
        do {
            list.add(Double.valueOf(this.zztl.readDouble()));
            if (!this.zztl.zzfy()) {
                zzfr = this.zztl.zzfi();
            } else {
                return;
            }
        } while (zzfr == this.tag);
        this.zztn = zzfr;
    }

    public final void zze(List<Float> list) {
        int zzfr;
        if (list instanceof zzfq) {
            zzfq zzfq = (zzfq) list;
            switch (this.tag & 7) {
                case 2:
                    zzfr = this.zztl.zzfr();
                    zzaa(zzfr);
                    zzfr += this.zztl.zzfz();
                    do {
                        zzfq.zzc(this.zztl.readFloat());
                    } while (this.zztl.zzfz() < zzfr);
                    return;
                case 5:
                    break;
                default:
                    throw zzgc.zzhv();
            }
            do {
                zzfq.zzc(this.zztl.readFloat());
                if (!this.zztl.zzfy()) {
                    zzfr = this.zztl.zzfi();
                } else {
                    return;
                }
            } while (zzfr == this.tag);
            this.zztn = zzfr;
            return;
        }
        switch (this.tag & 7) {
            case 2:
                zzfr = this.zztl.zzfr();
                zzaa(zzfr);
                zzfr += this.zztl.zzfz();
                do {
                    list.add(Float.valueOf(this.zztl.readFloat()));
                } while (this.zztl.zzfz() < zzfr);
                return;
            case 5:
                break;
            default:
                throw zzgc.zzhv();
        }
        do {
            list.add(Float.valueOf(this.zztl.readFloat()));
            if (!this.zztl.zzfy()) {
                zzfr = this.zztl.zzfi();
            } else {
                return;
            }
        } while (zzfr == this.tag);
        this.zztn = zzfr;
    }

    public final void zzf(List<Long> list) {
        int zzfr;
        if (list instanceof zzgq) {
            zzgq zzgq = (zzgq) list;
            switch (this.tag & 7) {
                case 0:
                    break;
                case 2:
                    zzfr = this.zztl.zzfr() + this.zztl.zzfz();
                    do {
                        zzgq.zzl(this.zztl.zzfj());
                    } while (this.zztl.zzfz() < zzfr);
                    zzab(zzfr);
                    return;
                default:
                    throw zzgc.zzhv();
            }
            do {
                zzgq.zzl(this.zztl.zzfj());
                if (!this.zztl.zzfy()) {
                    zzfr = this.zztl.zzfi();
                } else {
                    return;
                }
            } while (zzfr == this.tag);
            this.zztn = zzfr;
            return;
        }
        switch (this.tag & 7) {
            case 0:
                break;
            case 2:
                zzfr = this.zztl.zzfr() + this.zztl.zzfz();
                do {
                    list.add(Long.valueOf(this.zztl.zzfj()));
                } while (this.zztl.zzfz() < zzfr);
                zzab(zzfr);
                return;
            default:
                throw zzgc.zzhv();
        }
        do {
            list.add(Long.valueOf(this.zztl.zzfj()));
            if (!this.zztl.zzfy()) {
                zzfr = this.zztl.zzfi();
            } else {
                return;
            }
        } while (zzfr == this.tag);
        this.zztn = zzfr;
    }

    public final void zzg(List<Long> list) {
        int zzfr;
        if (list instanceof zzgq) {
            zzgq zzgq = (zzgq) list;
            switch (this.tag & 7) {
                case 0:
                    break;
                case 2:
                    zzfr = this.zztl.zzfr() + this.zztl.zzfz();
                    do {
                        zzgq.zzl(this.zztl.zzfk());
                    } while (this.zztl.zzfz() < zzfr);
                    zzab(zzfr);
                    return;
                default:
                    throw zzgc.zzhv();
            }
            do {
                zzgq.zzl(this.zztl.zzfk());
                if (!this.zztl.zzfy()) {
                    zzfr = this.zztl.zzfi();
                } else {
                    return;
                }
            } while (zzfr == this.tag);
            this.zztn = zzfr;
            return;
        }
        switch (this.tag & 7) {
            case 0:
                break;
            case 2:
                zzfr = this.zztl.zzfr() + this.zztl.zzfz();
                do {
                    list.add(Long.valueOf(this.zztl.zzfk()));
                } while (this.zztl.zzfz() < zzfr);
                zzab(zzfr);
                return;
            default:
                throw zzgc.zzhv();
        }
        do {
            list.add(Long.valueOf(this.zztl.zzfk()));
            if (!this.zztl.zzfy()) {
                zzfr = this.zztl.zzfi();
            } else {
                return;
            }
        } while (zzfr == this.tag);
        this.zztn = zzfr;
    }

    public final void zzh(List<Integer> list) {
        int zzfr;
        if (list instanceof zzfu) {
            zzfu zzfu = (zzfu) list;
            switch (this.tag & 7) {
                case 0:
                    break;
                case 2:
                    zzfr = this.zztl.zzfr() + this.zztl.zzfz();
                    do {
                        zzfu.zzas(this.zztl.zzfl());
                    } while (this.zztl.zzfz() < zzfr);
                    zzab(zzfr);
                    return;
                default:
                    throw zzgc.zzhv();
            }
            do {
                zzfu.zzas(this.zztl.zzfl());
                if (!this.zztl.zzfy()) {
                    zzfr = this.zztl.zzfi();
                } else {
                    return;
                }
            } while (zzfr == this.tag);
            this.zztn = zzfr;
            return;
        }
        switch (this.tag & 7) {
            case 0:
                break;
            case 2:
                zzfr = this.zztl.zzfr() + this.zztl.zzfz();
                do {
                    list.add(Integer.valueOf(this.zztl.zzfl()));
                } while (this.zztl.zzfz() < zzfr);
                zzab(zzfr);
                return;
            default:
                throw zzgc.zzhv();
        }
        do {
            list.add(Integer.valueOf(this.zztl.zzfl()));
            if (!this.zztl.zzfy()) {
                zzfr = this.zztl.zzfi();
            } else {
                return;
            }
        } while (zzfr == this.tag);
        this.zztn = zzfr;
    }

    public final void zzi(List<Long> list) {
        int zzfr;
        if (list instanceof zzgq) {
            zzgq zzgq = (zzgq) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    zzfr = this.zztl.zzfr();
                    zzz(zzfr);
                    zzfr += this.zztl.zzfz();
                    do {
                        zzgq.zzl(this.zztl.zzfm());
                    } while (this.zztl.zzfz() < zzfr);
                    return;
                default:
                    throw zzgc.zzhv();
            }
            do {
                zzgq.zzl(this.zztl.zzfm());
                if (!this.zztl.zzfy()) {
                    zzfr = this.zztl.zzfi();
                } else {
                    return;
                }
            } while (zzfr == this.tag);
            this.zztn = zzfr;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                zzfr = this.zztl.zzfr();
                zzz(zzfr);
                zzfr += this.zztl.zzfz();
                do {
                    list.add(Long.valueOf(this.zztl.zzfm()));
                } while (this.zztl.zzfz() < zzfr);
                return;
            default:
                throw zzgc.zzhv();
        }
        do {
            list.add(Long.valueOf(this.zztl.zzfm()));
            if (!this.zztl.zzfy()) {
                zzfr = this.zztl.zzfi();
            } else {
                return;
            }
        } while (zzfr == this.tag);
        this.zztn = zzfr;
    }

    public final void zzj(List<Integer> list) {
        int zzfr;
        if (list instanceof zzfu) {
            zzfu zzfu = (zzfu) list;
            switch (this.tag & 7) {
                case 2:
                    zzfr = this.zztl.zzfr();
                    zzaa(zzfr);
                    zzfr += this.zztl.zzfz();
                    do {
                        zzfu.zzas(this.zztl.zzfn());
                    } while (this.zztl.zzfz() < zzfr);
                    return;
                case 5:
                    break;
                default:
                    throw zzgc.zzhv();
            }
            do {
                zzfu.zzas(this.zztl.zzfn());
                if (!this.zztl.zzfy()) {
                    zzfr = this.zztl.zzfi();
                } else {
                    return;
                }
            } while (zzfr == this.tag);
            this.zztn = zzfr;
            return;
        }
        switch (this.tag & 7) {
            case 2:
                zzfr = this.zztl.zzfr();
                zzaa(zzfr);
                zzfr += this.zztl.zzfz();
                do {
                    list.add(Integer.valueOf(this.zztl.zzfn()));
                } while (this.zztl.zzfz() < zzfr);
                return;
            case 5:
                break;
            default:
                throw zzgc.zzhv();
        }
        do {
            list.add(Integer.valueOf(this.zztl.zzfn()));
            if (!this.zztl.zzfy()) {
                zzfr = this.zztl.zzfi();
            } else {
                return;
            }
        } while (zzfr == this.tag);
        this.zztn = zzfr;
    }

    public final void zzk(List<Boolean> list) {
        int zzfr;
        if (list instanceof zzef) {
            zzef zzef = (zzef) list;
            switch (this.tag & 7) {
                case 0:
                    break;
                case 2:
                    zzfr = this.zztl.zzfr() + this.zztl.zzfz();
                    do {
                        zzef.addBoolean(this.zztl.zzfo());
                    } while (this.zztl.zzfz() < zzfr);
                    zzab(zzfr);
                    return;
                default:
                    throw zzgc.zzhv();
            }
            do {
                zzef.addBoolean(this.zztl.zzfo());
                if (!this.zztl.zzfy()) {
                    zzfr = this.zztl.zzfi();
                } else {
                    return;
                }
            } while (zzfr == this.tag);
            this.zztn = zzfr;
            return;
        }
        switch (this.tag & 7) {
            case 0:
                break;
            case 2:
                zzfr = this.zztl.zzfr() + this.zztl.zzfz();
                do {
                    list.add(Boolean.valueOf(this.zztl.zzfo()));
                } while (this.zztl.zzfz() < zzfr);
                zzab(zzfr);
                return;
            default:
                throw zzgc.zzhv();
        }
        do {
            list.add(Boolean.valueOf(this.zztl.zzfo()));
            if (!this.zztl.zzfy()) {
                zzfr = this.zztl.zzfi();
            } else {
                return;
            }
        } while (zzfr == this.tag);
        this.zztn = zzfr;
    }

    public final void readStringList(List<String> list) {
        zza((List) list, false);
    }

    public final void zzl(List<String> list) {
        zza((List) list, true);
    }

    private final void zza(List<String> list, boolean z) {
        if ((this.tag & 7) != 2) {
            throw zzgc.zzhv();
        } else if (!(list instanceof zzgl) || z) {
            do {
                list.add(z ? zzfp() : readString());
                if (!this.zztl.zzfy()) {
                    r0 = this.zztl.zzfi();
                } else {
                    return;
                }
            } while (r0 == this.tag);
            this.zztn = r0;
        } else {
            zzgl zzgl = (zzgl) list;
            do {
                zzgl.zzc(zzfq());
                if (!this.zztl.zzfy()) {
                    r0 = this.zztl.zzfi();
                } else {
                    return;
                }
            } while (r0 == this.tag);
            this.zztn = r0;
        }
    }

    public final <T> void zza(List<T> list, zzhw<T> zzhw, zzfg zzfg) {
        if ((this.tag & 7) != 2) {
            throw zzgc.zzhv();
        }
        int zzfi;
        int i = this.tag;
        do {
            list.add(zzc(zzhw, zzfg));
            if (!this.zztl.zzfy() && this.zztn == 0) {
                zzfi = this.zztl.zzfi();
            } else {
                return;
            }
        } while (zzfi == i);
        this.zztn = zzfi;
    }

    public final <T> void zzb(List<T> list, zzhw<T> zzhw, zzfg zzfg) {
        if ((this.tag & 7) != 3) {
            throw zzgc.zzhv();
        }
        int zzfi;
        int i = this.tag;
        do {
            list.add(zzd(zzhw, zzfg));
            if (!this.zztl.zzfy() && this.zztn == 0) {
                zzfi = this.zztl.zzfi();
            } else {
                return;
            }
        } while (zzfi == i);
        this.zztn = zzfi;
    }

    public final void zzm(List<zzeh> list) {
        if ((this.tag & 7) != 2) {
            throw zzgc.zzhv();
        }
        int zzfi;
        do {
            list.add(zzfq());
            if (!this.zztl.zzfy()) {
                zzfi = this.zztl.zzfi();
            } else {
                return;
            }
        } while (zzfi == this.tag);
        this.zztn = zzfi;
    }

    public final void zzn(List<Integer> list) {
        int zzfr;
        if (list instanceof zzfu) {
            zzfu zzfu = (zzfu) list;
            switch (this.tag & 7) {
                case 0:
                    break;
                case 2:
                    zzfr = this.zztl.zzfr() + this.zztl.zzfz();
                    do {
                        zzfu.zzas(this.zztl.zzfr());
                    } while (this.zztl.zzfz() < zzfr);
                    zzab(zzfr);
                    return;
                default:
                    throw zzgc.zzhv();
            }
            do {
                zzfu.zzas(this.zztl.zzfr());
                if (!this.zztl.zzfy()) {
                    zzfr = this.zztl.zzfi();
                } else {
                    return;
                }
            } while (zzfr == this.tag);
            this.zztn = zzfr;
            return;
        }
        switch (this.tag & 7) {
            case 0:
                break;
            case 2:
                zzfr = this.zztl.zzfr() + this.zztl.zzfz();
                do {
                    list.add(Integer.valueOf(this.zztl.zzfr()));
                } while (this.zztl.zzfz() < zzfr);
                zzab(zzfr);
                return;
            default:
                throw zzgc.zzhv();
        }
        do {
            list.add(Integer.valueOf(this.zztl.zzfr()));
            if (!this.zztl.zzfy()) {
                zzfr = this.zztl.zzfi();
            } else {
                return;
            }
        } while (zzfr == this.tag);
        this.zztn = zzfr;
    }

    public final void zzo(List<Integer> list) {
        int zzfr;
        if (list instanceof zzfu) {
            zzfu zzfu = (zzfu) list;
            switch (this.tag & 7) {
                case 0:
                    break;
                case 2:
                    zzfr = this.zztl.zzfr() + this.zztl.zzfz();
                    do {
                        zzfu.zzas(this.zztl.zzfs());
                    } while (this.zztl.zzfz() < zzfr);
                    zzab(zzfr);
                    return;
                default:
                    throw zzgc.zzhv();
            }
            do {
                zzfu.zzas(this.zztl.zzfs());
                if (!this.zztl.zzfy()) {
                    zzfr = this.zztl.zzfi();
                } else {
                    return;
                }
            } while (zzfr == this.tag);
            this.zztn = zzfr;
            return;
        }
        switch (this.tag & 7) {
            case 0:
                break;
            case 2:
                zzfr = this.zztl.zzfr() + this.zztl.zzfz();
                do {
                    list.add(Integer.valueOf(this.zztl.zzfs()));
                } while (this.zztl.zzfz() < zzfr);
                zzab(zzfr);
                return;
            default:
                throw zzgc.zzhv();
        }
        do {
            list.add(Integer.valueOf(this.zztl.zzfs()));
            if (!this.zztl.zzfy()) {
                zzfr = this.zztl.zzfi();
            } else {
                return;
            }
        } while (zzfr == this.tag);
        this.zztn = zzfr;
    }

    public final void zzp(List<Integer> list) {
        int zzfr;
        if (list instanceof zzfu) {
            zzfu zzfu = (zzfu) list;
            switch (this.tag & 7) {
                case 2:
                    zzfr = this.zztl.zzfr();
                    zzaa(zzfr);
                    zzfr += this.zztl.zzfz();
                    do {
                        zzfu.zzas(this.zztl.zzft());
                    } while (this.zztl.zzfz() < zzfr);
                    return;
                case 5:
                    break;
                default:
                    throw zzgc.zzhv();
            }
            do {
                zzfu.zzas(this.zztl.zzft());
                if (!this.zztl.zzfy()) {
                    zzfr = this.zztl.zzfi();
                } else {
                    return;
                }
            } while (zzfr == this.tag);
            this.zztn = zzfr;
            return;
        }
        switch (this.tag & 7) {
            case 2:
                zzfr = this.zztl.zzfr();
                zzaa(zzfr);
                zzfr += this.zztl.zzfz();
                do {
                    list.add(Integer.valueOf(this.zztl.zzft()));
                } while (this.zztl.zzfz() < zzfr);
                return;
            case 5:
                break;
            default:
                throw zzgc.zzhv();
        }
        do {
            list.add(Integer.valueOf(this.zztl.zzft()));
            if (!this.zztl.zzfy()) {
                zzfr = this.zztl.zzfi();
            } else {
                return;
            }
        } while (zzfr == this.tag);
        this.zztn = zzfr;
    }

    public final void zzq(List<Long> list) {
        int zzfr;
        if (list instanceof zzgq) {
            zzgq zzgq = (zzgq) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    zzfr = this.zztl.zzfr();
                    zzz(zzfr);
                    zzfr += this.zztl.zzfz();
                    do {
                        zzgq.zzl(this.zztl.zzfu());
                    } while (this.zztl.zzfz() < zzfr);
                    return;
                default:
                    throw zzgc.zzhv();
            }
            do {
                zzgq.zzl(this.zztl.zzfu());
                if (!this.zztl.zzfy()) {
                    zzfr = this.zztl.zzfi();
                } else {
                    return;
                }
            } while (zzfr == this.tag);
            this.zztn = zzfr;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                zzfr = this.zztl.zzfr();
                zzz(zzfr);
                zzfr += this.zztl.zzfz();
                do {
                    list.add(Long.valueOf(this.zztl.zzfu()));
                } while (this.zztl.zzfz() < zzfr);
                return;
            default:
                throw zzgc.zzhv();
        }
        do {
            list.add(Long.valueOf(this.zztl.zzfu()));
            if (!this.zztl.zzfy()) {
                zzfr = this.zztl.zzfi();
            } else {
                return;
            }
        } while (zzfr == this.tag);
        this.zztn = zzfr;
    }

    public final void zzr(List<Integer> list) {
        int zzfr;
        if (list instanceof zzfu) {
            zzfu zzfu = (zzfu) list;
            switch (this.tag & 7) {
                case 0:
                    break;
                case 2:
                    zzfr = this.zztl.zzfr() + this.zztl.zzfz();
                    do {
                        zzfu.zzas(this.zztl.zzfv());
                    } while (this.zztl.zzfz() < zzfr);
                    zzab(zzfr);
                    return;
                default:
                    throw zzgc.zzhv();
            }
            do {
                zzfu.zzas(this.zztl.zzfv());
                if (!this.zztl.zzfy()) {
                    zzfr = this.zztl.zzfi();
                } else {
                    return;
                }
            } while (zzfr == this.tag);
            this.zztn = zzfr;
            return;
        }
        switch (this.tag & 7) {
            case 0:
                break;
            case 2:
                zzfr = this.zztl.zzfr() + this.zztl.zzfz();
                do {
                    list.add(Integer.valueOf(this.zztl.zzfv()));
                } while (this.zztl.zzfz() < zzfr);
                zzab(zzfr);
                return;
            default:
                throw zzgc.zzhv();
        }
        do {
            list.add(Integer.valueOf(this.zztl.zzfv()));
            if (!this.zztl.zzfy()) {
                zzfr = this.zztl.zzfi();
            } else {
                return;
            }
        } while (zzfr == this.tag);
        this.zztn = zzfr;
    }

    public final void zzs(List<Long> list) {
        int zzfr;
        if (list instanceof zzgq) {
            zzgq zzgq = (zzgq) list;
            switch (this.tag & 7) {
                case 0:
                    break;
                case 2:
                    zzfr = this.zztl.zzfr() + this.zztl.zzfz();
                    do {
                        zzgq.zzl(this.zztl.zzfw());
                    } while (this.zztl.zzfz() < zzfr);
                    zzab(zzfr);
                    return;
                default:
                    throw zzgc.zzhv();
            }
            do {
                zzgq.zzl(this.zztl.zzfw());
                if (!this.zztl.zzfy()) {
                    zzfr = this.zztl.zzfi();
                } else {
                    return;
                }
            } while (zzfr == this.tag);
            this.zztn = zzfr;
            return;
        }
        switch (this.tag & 7) {
            case 0:
                break;
            case 2:
                zzfr = this.zztl.zzfr() + this.zztl.zzfz();
                do {
                    list.add(Long.valueOf(this.zztl.zzfw()));
                } while (this.zztl.zzfz() < zzfr);
                zzab(zzfr);
                return;
            default:
                throw zzgc.zzhv();
        }
        do {
            list.add(Long.valueOf(this.zztl.zzfw()));
            if (!this.zztl.zzfy()) {
                zzfr = this.zztl.zzfi();
            } else {
                return;
            }
        } while (zzfr == this.tag);
        this.zztn = zzfr;
    }

    private static void zzz(int i) {
        if ((i & 7) != 0) {
            throw zzgc.zzhx();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void zza(java.util.Map<K, V> r7, com.google.android.gms.internal.firebase_auth.zzgv<K, V> r8, com.google.android.gms.internal.firebase_auth.zzfg r9) {
        /*
        r6 = this;
        r0 = 2;
        r6.zzy(r0);
        r0 = r6.zztl;
        r0 = r0.zzfr();
        r1 = r6.zztl;
        r2 = r1.zzp(r0);
        r1 = r8.zzzd;
        r0 = r8.zzzf;
    L_0x0014:
        r3 = r6.zzgg();	 Catch:{ all -> 0x0045 }
        r4 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        if (r3 == r4) goto L_0x0062;
    L_0x001d:
        r4 = r6.zztl;	 Catch:{ all -> 0x0045 }
        r4 = r4.zzfy();	 Catch:{ all -> 0x0045 }
        if (r4 != 0) goto L_0x0062;
    L_0x0025:
        switch(r3) {
            case 1: goto L_0x004c;
            case 2: goto L_0x0055;
            default: goto L_0x0028;
        };
    L_0x0028:
        r3 = r6.zzgh();	 Catch:{ zzgd -> 0x0036 }
        if (r3 != 0) goto L_0x0014;
    L_0x002e:
        r3 = new com.google.android.gms.internal.firebase_auth.zzgc;	 Catch:{ zzgd -> 0x0036 }
        r4 = "Unable to parse map entry.";
        r3.<init>(r4);	 Catch:{ zzgd -> 0x0036 }
        throw r3;	 Catch:{ zzgd -> 0x0036 }
    L_0x0036:
        r3 = move-exception;
        r3 = r6.zzgh();	 Catch:{ all -> 0x0045 }
        if (r3 != 0) goto L_0x0014;
    L_0x003d:
        r0 = new com.google.android.gms.internal.firebase_auth.zzgc;	 Catch:{ all -> 0x0045 }
        r1 = "Unable to parse map entry.";
        r0.<init>(r1);	 Catch:{ all -> 0x0045 }
        throw r0;	 Catch:{ all -> 0x0045 }
    L_0x0045:
        r0 = move-exception;
        r1 = r6.zztl;
        r1.zzq(r2);
        throw r0;
    L_0x004c:
        r3 = r8.zzzc;	 Catch:{ zzgd -> 0x0036 }
        r4 = 0;
        r5 = 0;
        r1 = r6.zza(r3, r4, r5);	 Catch:{ zzgd -> 0x0036 }
        goto L_0x0014;
    L_0x0055:
        r3 = r8.zzze;	 Catch:{ zzgd -> 0x0036 }
        r4 = r8.zzzf;	 Catch:{ zzgd -> 0x0036 }
        r4 = r4.getClass();	 Catch:{ zzgd -> 0x0036 }
        r0 = r6.zza(r3, r4, r9);	 Catch:{ zzgd -> 0x0036 }
        goto L_0x0014;
    L_0x0062:
        r7.put(r1, r0);	 Catch:{ all -> 0x0045 }
        r0 = r6.zztl;
        r0.zzq(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzey.zza(java.util.Map, com.google.android.gms.internal.firebase_auth.zzgv, com.google.android.gms.internal.firebase_auth.zzfg):void");
    }

    private final Object zza(zzjf zzjf, Class<?> cls, zzfg zzfg) {
        switch (zzez.zzto[zzjf.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzfo());
            case 2:
                return zzfq();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzfs());
            case 5:
                return Integer.valueOf(zzfn());
            case 6:
                return Long.valueOf(zzfm());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzfl());
            case 9:
                return Long.valueOf(zzfk());
            case 10:
                zzy(2);
                return zzc(zzho.zziu().zzf(cls), zzfg);
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                return Integer.valueOf(zzft());
            case 12:
                return Long.valueOf(zzfu());
            case 13:
                return Integer.valueOf(zzfv());
            case 14:
                return Long.valueOf(zzfw());
            case 15:
                return zzfp();
            case 16:
                return Integer.valueOf(zzfr());
            case 17:
                return Long.valueOf(zzfj());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void zzaa(int i) {
        if ((i & 3) != 0) {
            throw zzgc.zzhx();
        }
    }

    private final void zzab(int i) {
        if (this.zztl.zzfz() != i) {
            throw zzgc.zzhq();
        }
    }
}
