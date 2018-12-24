package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.util.List;

final class zztt implements zzwk {
    private int tag;
    private final zztq zzbui;
    private int zzbuj;
    private int zzbuk = 0;

    public static zztt zza(zztq zztq) {
        if (zztq.zzbub != null) {
            return zztq.zzbub;
        }
        return new zztt(zztq);
    }

    private zztt(zztq zztq) {
        this.zzbui = (zztq) zzuq.zza(zztq, "input");
        this.zzbui.zzbub = this;
    }

    public final int zzvh() {
        if (this.zzbuk != 0) {
            this.tag = this.zzbuk;
            this.zzbuk = 0;
        } else {
            this.tag = this.zzbui.zzuj();
        }
        if (this.tag == 0 || this.tag == this.zzbuj) {
            return BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return this.tag >>> 3;
    }

    public final int getTag() {
        return this.tag;
    }

    public final boolean zzvi() {
        if (this.zzbui.zzuz() || this.tag == this.zzbuj) {
            return false;
        }
        return this.zzbui.zzaq(this.tag);
    }

    private final void zzav(int i) {
        if ((this.tag & 7) != i) {
            throw zzuv.zzwu();
        }
    }

    public final double readDouble() {
        zzav(1);
        return this.zzbui.readDouble();
    }

    public final float readFloat() {
        zzav(5);
        return this.zzbui.readFloat();
    }

    public final long zzuk() {
        zzav(0);
        return this.zzbui.zzuk();
    }

    public final long zzul() {
        zzav(0);
        return this.zzbui.zzul();
    }

    public final int zzum() {
        zzav(0);
        return this.zzbui.zzum();
    }

    public final long zzun() {
        zzav(1);
        return this.zzbui.zzun();
    }

    public final int zzuo() {
        zzav(5);
        return this.zzbui.zzuo();
    }

    public final boolean zzup() {
        zzav(0);
        return this.zzbui.zzup();
    }

    public final String readString() {
        zzav(2);
        return this.zzbui.readString();
    }

    public final String zzuq() {
        zzav(2);
        return this.zzbui.zzuq();
    }

    public final <T> T zza(zzwl<T> zzwl, zzub zzub) {
        zzav(2);
        return zzc(zzwl, zzub);
    }

    public final <T> T zzb(zzwl<T> zzwl, zzub zzub) {
        zzav(3);
        return zzd(zzwl, zzub);
    }

    private final <T> T zzc(zzwl<T> zzwl, zzub zzub) {
        int zzus = this.zzbui.zzus();
        if (this.zzbui.zzbty >= this.zzbui.zzbtz) {
            throw zzuv.zzwv();
        }
        zzus = this.zzbui.zzas(zzus);
        T newInstance = zzwl.newInstance();
        zztq zztq = this.zzbui;
        zztq.zzbty++;
        zzwl.zza(newInstance, this, zzub);
        zzwl.zzy(newInstance);
        this.zzbui.zzap(0);
        zztq = this.zzbui;
        zztq.zzbty--;
        this.zzbui.zzat(zzus);
        return newInstance;
    }

    private final <T> T zzd(zzwl<T> zzwl, zzub zzub) {
        int i = this.zzbuj;
        this.zzbuj = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzwl.newInstance();
            zzwl.zza(newInstance, this, zzub);
            zzwl.zzy(newInstance);
            if (this.tag == this.zzbuj) {
                return newInstance;
            }
            throw zzuv.zzww();
        } finally {
            this.zzbuj = i;
        }
    }

    public final zzte zzur() {
        zzav(2);
        return this.zzbui.zzur();
    }

    public final int zzus() {
        zzav(0);
        return this.zzbui.zzus();
    }

    public final int zzut() {
        zzav(0);
        return this.zzbui.zzut();
    }

    public final int zzuu() {
        zzav(5);
        return this.zzbui.zzuu();
    }

    public final long zzuv() {
        zzav(1);
        return this.zzbui.zzuv();
    }

    public final int zzuw() {
        zzav(0);
        return this.zzbui.zzuw();
    }

    public final long zzux() {
        zzav(0);
        return this.zzbui.zzux();
    }

    public final void zzi(List<Double> list) {
        int zzus;
        if (list instanceof zzty) {
            zzty zzty = (zzty) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    zzus = this.zzbui.zzus();
                    zzaw(zzus);
                    zzus += this.zzbui.zzva();
                    do {
                        zzty.zzd(this.zzbui.readDouble());
                    } while (this.zzbui.zzva() < zzus);
                    return;
                default:
                    throw zzuv.zzwu();
            }
            do {
                zzty.zzd(this.zzbui.readDouble());
                if (!this.zzbui.zzuz()) {
                    zzus = this.zzbui.zzuj();
                } else {
                    return;
                }
            } while (zzus == this.tag);
            this.zzbuk = zzus;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                zzus = this.zzbui.zzus();
                zzaw(zzus);
                zzus += this.zzbui.zzva();
                do {
                    list.add(Double.valueOf(this.zzbui.readDouble()));
                } while (this.zzbui.zzva() < zzus);
                return;
            default:
                throw zzuv.zzwu();
        }
        do {
            list.add(Double.valueOf(this.zzbui.readDouble()));
            if (!this.zzbui.zzuz()) {
                zzus = this.zzbui.zzuj();
            } else {
                return;
            }
        } while (zzus == this.tag);
        this.zzbuk = zzus;
    }

    public final void zzj(List<Float> list) {
        int zzus;
        if (list instanceof zzul) {
            zzul zzul = (zzul) list;
            switch (this.tag & 7) {
                case 2:
                    zzus = this.zzbui.zzus();
                    zzax(zzus);
                    zzus += this.zzbui.zzva();
                    do {
                        zzul.zzc(this.zzbui.readFloat());
                    } while (this.zzbui.zzva() < zzus);
                    return;
                case 5:
                    break;
                default:
                    throw zzuv.zzwu();
            }
            do {
                zzul.zzc(this.zzbui.readFloat());
                if (!this.zzbui.zzuz()) {
                    zzus = this.zzbui.zzuj();
                } else {
                    return;
                }
            } while (zzus == this.tag);
            this.zzbuk = zzus;
            return;
        }
        switch (this.tag & 7) {
            case 2:
                zzus = this.zzbui.zzus();
                zzax(zzus);
                zzus += this.zzbui.zzva();
                do {
                    list.add(Float.valueOf(this.zzbui.readFloat()));
                } while (this.zzbui.zzva() < zzus);
                return;
            case 5:
                break;
            default:
                throw zzuv.zzwu();
        }
        do {
            list.add(Float.valueOf(this.zzbui.readFloat()));
            if (!this.zzbui.zzuz()) {
                zzus = this.zzbui.zzuj();
            } else {
                return;
            }
        } while (zzus == this.tag);
        this.zzbuk = zzus;
    }

    public final void zzk(List<Long> list) {
        int zzus;
        if (list instanceof zzvj) {
            zzvj zzvj = (zzvj) list;
            switch (this.tag & 7) {
                case 0:
                    break;
                case 2:
                    zzus = this.zzbui.zzus() + this.zzbui.zzva();
                    do {
                        zzvj.zzbe(this.zzbui.zzuk());
                    } while (this.zzbui.zzva() < zzus);
                    zzay(zzus);
                    return;
                default:
                    throw zzuv.zzwu();
            }
            do {
                zzvj.zzbe(this.zzbui.zzuk());
                if (!this.zzbui.zzuz()) {
                    zzus = this.zzbui.zzuj();
                } else {
                    return;
                }
            } while (zzus == this.tag);
            this.zzbuk = zzus;
            return;
        }
        switch (this.tag & 7) {
            case 0:
                break;
            case 2:
                zzus = this.zzbui.zzus() + this.zzbui.zzva();
                do {
                    list.add(Long.valueOf(this.zzbui.zzuk()));
                } while (this.zzbui.zzva() < zzus);
                zzay(zzus);
                return;
            default:
                throw zzuv.zzwu();
        }
        do {
            list.add(Long.valueOf(this.zzbui.zzuk()));
            if (!this.zzbui.zzuz()) {
                zzus = this.zzbui.zzuj();
            } else {
                return;
            }
        } while (zzus == this.tag);
        this.zzbuk = zzus;
    }

    public final void zzl(List<Long> list) {
        int zzus;
        if (list instanceof zzvj) {
            zzvj zzvj = (zzvj) list;
            switch (this.tag & 7) {
                case 0:
                    break;
                case 2:
                    zzus = this.zzbui.zzus() + this.zzbui.zzva();
                    do {
                        zzvj.zzbe(this.zzbui.zzul());
                    } while (this.zzbui.zzva() < zzus);
                    zzay(zzus);
                    return;
                default:
                    throw zzuv.zzwu();
            }
            do {
                zzvj.zzbe(this.zzbui.zzul());
                if (!this.zzbui.zzuz()) {
                    zzus = this.zzbui.zzuj();
                } else {
                    return;
                }
            } while (zzus == this.tag);
            this.zzbuk = zzus;
            return;
        }
        switch (this.tag & 7) {
            case 0:
                break;
            case 2:
                zzus = this.zzbui.zzus() + this.zzbui.zzva();
                do {
                    list.add(Long.valueOf(this.zzbui.zzul()));
                } while (this.zzbui.zzva() < zzus);
                zzay(zzus);
                return;
            default:
                throw zzuv.zzwu();
        }
        do {
            list.add(Long.valueOf(this.zzbui.zzul()));
            if (!this.zzbui.zzuz()) {
                zzus = this.zzbui.zzuj();
            } else {
                return;
            }
        } while (zzus == this.tag);
        this.zzbuk = zzus;
    }

    public final void zzm(List<Integer> list) {
        int zzus;
        if (list instanceof zzup) {
            zzup zzup = (zzup) list;
            switch (this.tag & 7) {
                case 0:
                    break;
                case 2:
                    zzus = this.zzbui.zzus() + this.zzbui.zzva();
                    do {
                        zzup.zzbo(this.zzbui.zzum());
                    } while (this.zzbui.zzva() < zzus);
                    zzay(zzus);
                    return;
                default:
                    throw zzuv.zzwu();
            }
            do {
                zzup.zzbo(this.zzbui.zzum());
                if (!this.zzbui.zzuz()) {
                    zzus = this.zzbui.zzuj();
                } else {
                    return;
                }
            } while (zzus == this.tag);
            this.zzbuk = zzus;
            return;
        }
        switch (this.tag & 7) {
            case 0:
                break;
            case 2:
                zzus = this.zzbui.zzus() + this.zzbui.zzva();
                do {
                    list.add(Integer.valueOf(this.zzbui.zzum()));
                } while (this.zzbui.zzva() < zzus);
                zzay(zzus);
                return;
            default:
                throw zzuv.zzwu();
        }
        do {
            list.add(Integer.valueOf(this.zzbui.zzum()));
            if (!this.zzbui.zzuz()) {
                zzus = this.zzbui.zzuj();
            } else {
                return;
            }
        } while (zzus == this.tag);
        this.zzbuk = zzus;
    }

    public final void zzn(List<Long> list) {
        int zzus;
        if (list instanceof zzvj) {
            zzvj zzvj = (zzvj) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    zzus = this.zzbui.zzus();
                    zzaw(zzus);
                    zzus += this.zzbui.zzva();
                    do {
                        zzvj.zzbe(this.zzbui.zzun());
                    } while (this.zzbui.zzva() < zzus);
                    return;
                default:
                    throw zzuv.zzwu();
            }
            do {
                zzvj.zzbe(this.zzbui.zzun());
                if (!this.zzbui.zzuz()) {
                    zzus = this.zzbui.zzuj();
                } else {
                    return;
                }
            } while (zzus == this.tag);
            this.zzbuk = zzus;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                zzus = this.zzbui.zzus();
                zzaw(zzus);
                zzus += this.zzbui.zzva();
                do {
                    list.add(Long.valueOf(this.zzbui.zzun()));
                } while (this.zzbui.zzva() < zzus);
                return;
            default:
                throw zzuv.zzwu();
        }
        do {
            list.add(Long.valueOf(this.zzbui.zzun()));
            if (!this.zzbui.zzuz()) {
                zzus = this.zzbui.zzuj();
            } else {
                return;
            }
        } while (zzus == this.tag);
        this.zzbuk = zzus;
    }

    public final void zzo(List<Integer> list) {
        int zzus;
        if (list instanceof zzup) {
            zzup zzup = (zzup) list;
            switch (this.tag & 7) {
                case 2:
                    zzus = this.zzbui.zzus();
                    zzax(zzus);
                    zzus += this.zzbui.zzva();
                    do {
                        zzup.zzbo(this.zzbui.zzuo());
                    } while (this.zzbui.zzva() < zzus);
                    return;
                case 5:
                    break;
                default:
                    throw zzuv.zzwu();
            }
            do {
                zzup.zzbo(this.zzbui.zzuo());
                if (!this.zzbui.zzuz()) {
                    zzus = this.zzbui.zzuj();
                } else {
                    return;
                }
            } while (zzus == this.tag);
            this.zzbuk = zzus;
            return;
        }
        switch (this.tag & 7) {
            case 2:
                zzus = this.zzbui.zzus();
                zzax(zzus);
                zzus += this.zzbui.zzva();
                do {
                    list.add(Integer.valueOf(this.zzbui.zzuo()));
                } while (this.zzbui.zzva() < zzus);
                return;
            case 5:
                break;
            default:
                throw zzuv.zzwu();
        }
        do {
            list.add(Integer.valueOf(this.zzbui.zzuo()));
            if (!this.zzbui.zzuz()) {
                zzus = this.zzbui.zzuj();
            } else {
                return;
            }
        } while (zzus == this.tag);
        this.zzbuk = zzus;
    }

    public final void zzp(List<Boolean> list) {
        int zzus;
        if (list instanceof zztc) {
            zztc zztc = (zztc) list;
            switch (this.tag & 7) {
                case 0:
                    break;
                case 2:
                    zzus = this.zzbui.zzus() + this.zzbui.zzva();
                    do {
                        zztc.addBoolean(this.zzbui.zzup());
                    } while (this.zzbui.zzva() < zzus);
                    zzay(zzus);
                    return;
                default:
                    throw zzuv.zzwu();
            }
            do {
                zztc.addBoolean(this.zzbui.zzup());
                if (!this.zzbui.zzuz()) {
                    zzus = this.zzbui.zzuj();
                } else {
                    return;
                }
            } while (zzus == this.tag);
            this.zzbuk = zzus;
            return;
        }
        switch (this.tag & 7) {
            case 0:
                break;
            case 2:
                zzus = this.zzbui.zzus() + this.zzbui.zzva();
                do {
                    list.add(Boolean.valueOf(this.zzbui.zzup()));
                } while (this.zzbui.zzva() < zzus);
                zzay(zzus);
                return;
            default:
                throw zzuv.zzwu();
        }
        do {
            list.add(Boolean.valueOf(this.zzbui.zzup()));
            if (!this.zzbui.zzuz()) {
                zzus = this.zzbui.zzuj();
            } else {
                return;
            }
        } while (zzus == this.tag);
        this.zzbuk = zzus;
    }

    public final void readStringList(List<String> list) {
        zza((List) list, false);
    }

    public final void zzq(List<String> list) {
        zza((List) list, true);
    }

    private final void zza(List<String> list, boolean z) {
        if ((this.tag & 7) != 2) {
            throw zzuv.zzwu();
        } else if (!(list instanceof zzve) || z) {
            do {
                list.add(z ? zzuq() : readString());
                if (!this.zzbui.zzuz()) {
                    r0 = this.zzbui.zzuj();
                } else {
                    return;
                }
            } while (r0 == this.tag);
            this.zzbuk = r0;
        } else {
            zzve zzve = (zzve) list;
            do {
                zzve.zzc(zzur());
                if (!this.zzbui.zzuz()) {
                    r0 = this.zzbui.zzuj();
                } else {
                    return;
                }
            } while (r0 == this.tag);
            this.zzbuk = r0;
        }
    }

    public final <T> void zza(List<T> list, zzwl<T> zzwl, zzub zzub) {
        if ((this.tag & 7) != 2) {
            throw zzuv.zzwu();
        }
        int zzuj;
        int i = this.tag;
        do {
            list.add(zzc(zzwl, zzub));
            if (!this.zzbui.zzuz() && this.zzbuk == 0) {
                zzuj = this.zzbui.zzuj();
            } else {
                return;
            }
        } while (zzuj == i);
        this.zzbuk = zzuj;
    }

    public final <T> void zzb(List<T> list, zzwl<T> zzwl, zzub zzub) {
        if ((this.tag & 7) != 3) {
            throw zzuv.zzwu();
        }
        int zzuj;
        int i = this.tag;
        do {
            list.add(zzd(zzwl, zzub));
            if (!this.zzbui.zzuz() && this.zzbuk == 0) {
                zzuj = this.zzbui.zzuj();
            } else {
                return;
            }
        } while (zzuj == i);
        this.zzbuk = zzuj;
    }

    public final void zzr(List<zzte> list) {
        if ((this.tag & 7) != 2) {
            throw zzuv.zzwu();
        }
        int zzuj;
        do {
            list.add(zzur());
            if (!this.zzbui.zzuz()) {
                zzuj = this.zzbui.zzuj();
            } else {
                return;
            }
        } while (zzuj == this.tag);
        this.zzbuk = zzuj;
    }

    public final void zzs(List<Integer> list) {
        int zzus;
        if (list instanceof zzup) {
            zzup zzup = (zzup) list;
            switch (this.tag & 7) {
                case 0:
                    break;
                case 2:
                    zzus = this.zzbui.zzus() + this.zzbui.zzva();
                    do {
                        zzup.zzbo(this.zzbui.zzus());
                    } while (this.zzbui.zzva() < zzus);
                    zzay(zzus);
                    return;
                default:
                    throw zzuv.zzwu();
            }
            do {
                zzup.zzbo(this.zzbui.zzus());
                if (!this.zzbui.zzuz()) {
                    zzus = this.zzbui.zzuj();
                } else {
                    return;
                }
            } while (zzus == this.tag);
            this.zzbuk = zzus;
            return;
        }
        switch (this.tag & 7) {
            case 0:
                break;
            case 2:
                zzus = this.zzbui.zzus() + this.zzbui.zzva();
                do {
                    list.add(Integer.valueOf(this.zzbui.zzus()));
                } while (this.zzbui.zzva() < zzus);
                zzay(zzus);
                return;
            default:
                throw zzuv.zzwu();
        }
        do {
            list.add(Integer.valueOf(this.zzbui.zzus()));
            if (!this.zzbui.zzuz()) {
                zzus = this.zzbui.zzuj();
            } else {
                return;
            }
        } while (zzus == this.tag);
        this.zzbuk = zzus;
    }

    public final void zzt(List<Integer> list) {
        int zzus;
        if (list instanceof zzup) {
            zzup zzup = (zzup) list;
            switch (this.tag & 7) {
                case 0:
                    break;
                case 2:
                    zzus = this.zzbui.zzus() + this.zzbui.zzva();
                    do {
                        zzup.zzbo(this.zzbui.zzut());
                    } while (this.zzbui.zzva() < zzus);
                    zzay(zzus);
                    return;
                default:
                    throw zzuv.zzwu();
            }
            do {
                zzup.zzbo(this.zzbui.zzut());
                if (!this.zzbui.zzuz()) {
                    zzus = this.zzbui.zzuj();
                } else {
                    return;
                }
            } while (zzus == this.tag);
            this.zzbuk = zzus;
            return;
        }
        switch (this.tag & 7) {
            case 0:
                break;
            case 2:
                zzus = this.zzbui.zzus() + this.zzbui.zzva();
                do {
                    list.add(Integer.valueOf(this.zzbui.zzut()));
                } while (this.zzbui.zzva() < zzus);
                zzay(zzus);
                return;
            default:
                throw zzuv.zzwu();
        }
        do {
            list.add(Integer.valueOf(this.zzbui.zzut()));
            if (!this.zzbui.zzuz()) {
                zzus = this.zzbui.zzuj();
            } else {
                return;
            }
        } while (zzus == this.tag);
        this.zzbuk = zzus;
    }

    public final void zzu(List<Integer> list) {
        int zzus;
        if (list instanceof zzup) {
            zzup zzup = (zzup) list;
            switch (this.tag & 7) {
                case 2:
                    zzus = this.zzbui.zzus();
                    zzax(zzus);
                    zzus += this.zzbui.zzva();
                    do {
                        zzup.zzbo(this.zzbui.zzuu());
                    } while (this.zzbui.zzva() < zzus);
                    return;
                case 5:
                    break;
                default:
                    throw zzuv.zzwu();
            }
            do {
                zzup.zzbo(this.zzbui.zzuu());
                if (!this.zzbui.zzuz()) {
                    zzus = this.zzbui.zzuj();
                } else {
                    return;
                }
            } while (zzus == this.tag);
            this.zzbuk = zzus;
            return;
        }
        switch (this.tag & 7) {
            case 2:
                zzus = this.zzbui.zzus();
                zzax(zzus);
                zzus += this.zzbui.zzva();
                do {
                    list.add(Integer.valueOf(this.zzbui.zzuu()));
                } while (this.zzbui.zzva() < zzus);
                return;
            case 5:
                break;
            default:
                throw zzuv.zzwu();
        }
        do {
            list.add(Integer.valueOf(this.zzbui.zzuu()));
            if (!this.zzbui.zzuz()) {
                zzus = this.zzbui.zzuj();
            } else {
                return;
            }
        } while (zzus == this.tag);
        this.zzbuk = zzus;
    }

    public final void zzv(List<Long> list) {
        int zzus;
        if (list instanceof zzvj) {
            zzvj zzvj = (zzvj) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    zzus = this.zzbui.zzus();
                    zzaw(zzus);
                    zzus += this.zzbui.zzva();
                    do {
                        zzvj.zzbe(this.zzbui.zzuv());
                    } while (this.zzbui.zzva() < zzus);
                    return;
                default:
                    throw zzuv.zzwu();
            }
            do {
                zzvj.zzbe(this.zzbui.zzuv());
                if (!this.zzbui.zzuz()) {
                    zzus = this.zzbui.zzuj();
                } else {
                    return;
                }
            } while (zzus == this.tag);
            this.zzbuk = zzus;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                zzus = this.zzbui.zzus();
                zzaw(zzus);
                zzus += this.zzbui.zzva();
                do {
                    list.add(Long.valueOf(this.zzbui.zzuv()));
                } while (this.zzbui.zzva() < zzus);
                return;
            default:
                throw zzuv.zzwu();
        }
        do {
            list.add(Long.valueOf(this.zzbui.zzuv()));
            if (!this.zzbui.zzuz()) {
                zzus = this.zzbui.zzuj();
            } else {
                return;
            }
        } while (zzus == this.tag);
        this.zzbuk = zzus;
    }

    public final void zzw(List<Integer> list) {
        int zzus;
        if (list instanceof zzup) {
            zzup zzup = (zzup) list;
            switch (this.tag & 7) {
                case 0:
                    break;
                case 2:
                    zzus = this.zzbui.zzus() + this.zzbui.zzva();
                    do {
                        zzup.zzbo(this.zzbui.zzuw());
                    } while (this.zzbui.zzva() < zzus);
                    zzay(zzus);
                    return;
                default:
                    throw zzuv.zzwu();
            }
            do {
                zzup.zzbo(this.zzbui.zzuw());
                if (!this.zzbui.zzuz()) {
                    zzus = this.zzbui.zzuj();
                } else {
                    return;
                }
            } while (zzus == this.tag);
            this.zzbuk = zzus;
            return;
        }
        switch (this.tag & 7) {
            case 0:
                break;
            case 2:
                zzus = this.zzbui.zzus() + this.zzbui.zzva();
                do {
                    list.add(Integer.valueOf(this.zzbui.zzuw()));
                } while (this.zzbui.zzva() < zzus);
                zzay(zzus);
                return;
            default:
                throw zzuv.zzwu();
        }
        do {
            list.add(Integer.valueOf(this.zzbui.zzuw()));
            if (!this.zzbui.zzuz()) {
                zzus = this.zzbui.zzuj();
            } else {
                return;
            }
        } while (zzus == this.tag);
        this.zzbuk = zzus;
    }

    public final void zzx(List<Long> list) {
        int zzus;
        if (list instanceof zzvj) {
            zzvj zzvj = (zzvj) list;
            switch (this.tag & 7) {
                case 0:
                    break;
                case 2:
                    zzus = this.zzbui.zzus() + this.zzbui.zzva();
                    do {
                        zzvj.zzbe(this.zzbui.zzux());
                    } while (this.zzbui.zzva() < zzus);
                    zzay(zzus);
                    return;
                default:
                    throw zzuv.zzwu();
            }
            do {
                zzvj.zzbe(this.zzbui.zzux());
                if (!this.zzbui.zzuz()) {
                    zzus = this.zzbui.zzuj();
                } else {
                    return;
                }
            } while (zzus == this.tag);
            this.zzbuk = zzus;
            return;
        }
        switch (this.tag & 7) {
            case 0:
                break;
            case 2:
                zzus = this.zzbui.zzus() + this.zzbui.zzva();
                do {
                    list.add(Long.valueOf(this.zzbui.zzux()));
                } while (this.zzbui.zzva() < zzus);
                zzay(zzus);
                return;
            default:
                throw zzuv.zzwu();
        }
        do {
            list.add(Long.valueOf(this.zzbui.zzux()));
            if (!this.zzbui.zzuz()) {
                zzus = this.zzbui.zzuj();
            } else {
                return;
            }
        } while (zzus == this.tag);
        this.zzbuk = zzus;
    }

    private static void zzaw(int i) {
        if ((i & 7) != 0) {
            throw zzuv.zzww();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void zza(java.util.Map<K, V> r7, com.google.android.gms.internal.measurement.zzvo<K, V> r8, com.google.android.gms.internal.measurement.zzub r9) {
        /*
        r6 = this;
        r0 = 2;
        r6.zzav(r0);
        r0 = r6.zzbui;
        r0 = r0.zzus();
        r1 = r6.zzbui;
        r2 = r1.zzas(r0);
        r1 = r8.zzcaj;
        r0 = r8.zzbrp;
    L_0x0014:
        r3 = r6.zzvh();	 Catch:{ all -> 0x0045 }
        r4 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        if (r3 == r4) goto L_0x0062;
    L_0x001d:
        r4 = r6.zzbui;	 Catch:{ all -> 0x0045 }
        r4 = r4.zzuz();	 Catch:{ all -> 0x0045 }
        if (r4 != 0) goto L_0x0062;
    L_0x0025:
        switch(r3) {
            case 1: goto L_0x004c;
            case 2: goto L_0x0055;
            default: goto L_0x0028;
        };
    L_0x0028:
        r3 = r6.zzvi();	 Catch:{ zzuw -> 0x0036 }
        if (r3 != 0) goto L_0x0014;
    L_0x002e:
        r3 = new com.google.android.gms.internal.measurement.zzuv;	 Catch:{ zzuw -> 0x0036 }
        r4 = "Unable to parse map entry.";
        r3.<init>(r4);	 Catch:{ zzuw -> 0x0036 }
        throw r3;	 Catch:{ zzuw -> 0x0036 }
    L_0x0036:
        r3 = move-exception;
        r3 = r6.zzvi();	 Catch:{ all -> 0x0045 }
        if (r3 != 0) goto L_0x0014;
    L_0x003d:
        r0 = new com.google.android.gms.internal.measurement.zzuv;	 Catch:{ all -> 0x0045 }
        r1 = "Unable to parse map entry.";
        r0.<init>(r1);	 Catch:{ all -> 0x0045 }
        throw r0;	 Catch:{ all -> 0x0045 }
    L_0x0045:
        r0 = move-exception;
        r1 = r6.zzbui;
        r1.zzat(r2);
        throw r0;
    L_0x004c:
        r3 = r8.zzcai;	 Catch:{ zzuw -> 0x0036 }
        r4 = 0;
        r5 = 0;
        r1 = r6.zza(r3, r4, r5);	 Catch:{ zzuw -> 0x0036 }
        goto L_0x0014;
    L_0x0055:
        r3 = r8.zzcak;	 Catch:{ zzuw -> 0x0036 }
        r4 = r8.zzbrp;	 Catch:{ zzuw -> 0x0036 }
        r4 = r4.getClass();	 Catch:{ zzuw -> 0x0036 }
        r0 = r6.zza(r3, r4, r9);	 Catch:{ zzuw -> 0x0036 }
        goto L_0x0014;
    L_0x0062:
        r7.put(r1, r0);	 Catch:{ all -> 0x0045 }
        r0 = r6.zzbui;
        r0.zzat(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zztt.zza(java.util.Map, com.google.android.gms.internal.measurement.zzvo, com.google.android.gms.internal.measurement.zzub):void");
    }

    private final Object zza(zzxs zzxs, Class<?> cls, zzub zzub) {
        switch (zztu.zzbul[zzxs.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzup());
            case 2:
                return zzur();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzut());
            case 5:
                return Integer.valueOf(zzuo());
            case 6:
                return Long.valueOf(zzun());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzum());
            case 9:
                return Long.valueOf(zzul());
            case 10:
                zzav(2);
                return zzc(zzwh.zzxt().zzi(cls), zzub);
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                return Integer.valueOf(zzuu());
            case 12:
                return Long.valueOf(zzuv());
            case 13:
                return Integer.valueOf(zzuw());
            case 14:
                return Long.valueOf(zzux());
            case 15:
                return zzuq();
            case 16:
                return Integer.valueOf(zzus());
            case 17:
                return Long.valueOf(zzuk());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void zzax(int i) {
        if ((i & 3) != 0) {
            throw zzuv.zzww();
        }
    }

    private final void zzay(int i) {
        if (this.zzbui.zzva() != i) {
            throw zzuv.zzwq();
        }
    }
}
