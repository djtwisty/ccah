package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfe.zzb;
import com.google.android.gms.internal.measurement.zzfe.zzb.zza;
import com.google.zxing.pdf417.PDF417Common;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;

public final class zzfw extends zzyc<zzfw> {
    private static volatile zzfw[] zzaxg;
    public String zzafh;
    public String zzafi;
    public String zzafk;
    public String zzafp;
    public String zzagm;
    public String zzahr;
    public String zzawp;
    public Integer zzaxh;
    public zzft[] zzaxi;
    public zzfz[] zzaxj;
    public Long zzaxk;
    public Long zzaxl;
    public Long zzaxm;
    public Long zzaxn;
    public Long zzaxo;
    public String zzaxp;
    public String zzaxq;
    public String zzaxr;
    public Integer zzaxs;
    public Long zzaxt;
    public Long zzaxu;
    public String zzaxv;
    public Boolean zzaxw;
    public Long zzaxx;
    public Integer zzaxy;
    public Boolean zzaxz;
    public zzfr[] zzaya;
    public Integer zzayb;
    private Integer zzayc;
    private Integer zzayd;
    public String zzaye;
    public Long zzayf;
    public Long zzayg;
    public String zzayh;
    private String zzayi;
    public Integer zzayj;
    public zzb zzayk;
    public int[] zzayl;
    private Long zzaym;
    public String zzts;
    public String zztt;

    public static zzfw[] zznb() {
        if (zzaxg == null) {
            synchronized (zzyg.zzcfc) {
                if (zzaxg == null) {
                    zzaxg = new zzfw[0];
                }
            }
        }
        return zzaxg;
    }

    public zzfw() {
        this.zzaxh = null;
        this.zzaxi = zzft.zzmz();
        this.zzaxj = zzfz.zznd();
        this.zzaxk = null;
        this.zzaxl = null;
        this.zzaxm = null;
        this.zzaxn = null;
        this.zzaxo = null;
        this.zzaxp = null;
        this.zzaxq = null;
        this.zzaxr = null;
        this.zzahr = null;
        this.zzaxs = null;
        this.zzafp = null;
        this.zztt = null;
        this.zzts = null;
        this.zzaxt = null;
        this.zzaxu = null;
        this.zzaxv = null;
        this.zzaxw = null;
        this.zzafh = null;
        this.zzaxx = null;
        this.zzaxy = null;
        this.zzagm = null;
        this.zzafi = null;
        this.zzaxz = null;
        this.zzaya = zzfr.zzmx();
        this.zzafk = null;
        this.zzayb = null;
        this.zzayc = null;
        this.zzayd = null;
        this.zzaye = null;
        this.zzayf = null;
        this.zzayg = null;
        this.zzayh = null;
        this.zzayi = null;
        this.zzayj = null;
        this.zzawp = null;
        this.zzayk = null;
        this.zzayl = zzyl.zzcao;
        this.zzaym = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfw)) {
            return false;
        }
        zzfw zzfw = (zzfw) obj;
        if (this.zzaxh == null) {
            if (zzfw.zzaxh != null) {
                return false;
            }
        } else if (!this.zzaxh.equals(zzfw.zzaxh)) {
            return false;
        }
        if (!zzyg.equals(this.zzaxi, zzfw.zzaxi)) {
            return false;
        }
        if (!zzyg.equals(this.zzaxj, zzfw.zzaxj)) {
            return false;
        }
        if (this.zzaxk == null) {
            if (zzfw.zzaxk != null) {
                return false;
            }
        } else if (!this.zzaxk.equals(zzfw.zzaxk)) {
            return false;
        }
        if (this.zzaxl == null) {
            if (zzfw.zzaxl != null) {
                return false;
            }
        } else if (!this.zzaxl.equals(zzfw.zzaxl)) {
            return false;
        }
        if (this.zzaxm == null) {
            if (zzfw.zzaxm != null) {
                return false;
            }
        } else if (!this.zzaxm.equals(zzfw.zzaxm)) {
            return false;
        }
        if (this.zzaxn == null) {
            if (zzfw.zzaxn != null) {
                return false;
            }
        } else if (!this.zzaxn.equals(zzfw.zzaxn)) {
            return false;
        }
        if (this.zzaxo == null) {
            if (zzfw.zzaxo != null) {
                return false;
            }
        } else if (!this.zzaxo.equals(zzfw.zzaxo)) {
            return false;
        }
        if (this.zzaxp == null) {
            if (zzfw.zzaxp != null) {
                return false;
            }
        } else if (!this.zzaxp.equals(zzfw.zzaxp)) {
            return false;
        }
        if (this.zzaxq == null) {
            if (zzfw.zzaxq != null) {
                return false;
            }
        } else if (!this.zzaxq.equals(zzfw.zzaxq)) {
            return false;
        }
        if (this.zzaxr == null) {
            if (zzfw.zzaxr != null) {
                return false;
            }
        } else if (!this.zzaxr.equals(zzfw.zzaxr)) {
            return false;
        }
        if (this.zzahr == null) {
            if (zzfw.zzahr != null) {
                return false;
            }
        } else if (!this.zzahr.equals(zzfw.zzahr)) {
            return false;
        }
        if (this.zzaxs == null) {
            if (zzfw.zzaxs != null) {
                return false;
            }
        } else if (!this.zzaxs.equals(zzfw.zzaxs)) {
            return false;
        }
        if (this.zzafp == null) {
            if (zzfw.zzafp != null) {
                return false;
            }
        } else if (!this.zzafp.equals(zzfw.zzafp)) {
            return false;
        }
        if (this.zztt == null) {
            if (zzfw.zztt != null) {
                return false;
            }
        } else if (!this.zztt.equals(zzfw.zztt)) {
            return false;
        }
        if (this.zzts == null) {
            if (zzfw.zzts != null) {
                return false;
            }
        } else if (!this.zzts.equals(zzfw.zzts)) {
            return false;
        }
        if (this.zzaxt == null) {
            if (zzfw.zzaxt != null) {
                return false;
            }
        } else if (!this.zzaxt.equals(zzfw.zzaxt)) {
            return false;
        }
        if (this.zzaxu == null) {
            if (zzfw.zzaxu != null) {
                return false;
            }
        } else if (!this.zzaxu.equals(zzfw.zzaxu)) {
            return false;
        }
        if (this.zzaxv == null) {
            if (zzfw.zzaxv != null) {
                return false;
            }
        } else if (!this.zzaxv.equals(zzfw.zzaxv)) {
            return false;
        }
        if (this.zzaxw == null) {
            if (zzfw.zzaxw != null) {
                return false;
            }
        } else if (!this.zzaxw.equals(zzfw.zzaxw)) {
            return false;
        }
        if (this.zzafh == null) {
            if (zzfw.zzafh != null) {
                return false;
            }
        } else if (!this.zzafh.equals(zzfw.zzafh)) {
            return false;
        }
        if (this.zzaxx == null) {
            if (zzfw.zzaxx != null) {
                return false;
            }
        } else if (!this.zzaxx.equals(zzfw.zzaxx)) {
            return false;
        }
        if (this.zzaxy == null) {
            if (zzfw.zzaxy != null) {
                return false;
            }
        } else if (!this.zzaxy.equals(zzfw.zzaxy)) {
            return false;
        }
        if (this.zzagm == null) {
            if (zzfw.zzagm != null) {
                return false;
            }
        } else if (!this.zzagm.equals(zzfw.zzagm)) {
            return false;
        }
        if (this.zzafi == null) {
            if (zzfw.zzafi != null) {
                return false;
            }
        } else if (!this.zzafi.equals(zzfw.zzafi)) {
            return false;
        }
        if (this.zzaxz == null) {
            if (zzfw.zzaxz != null) {
                return false;
            }
        } else if (!this.zzaxz.equals(zzfw.zzaxz)) {
            return false;
        }
        if (!zzyg.equals(this.zzaya, zzfw.zzaya)) {
            return false;
        }
        if (this.zzafk == null) {
            if (zzfw.zzafk != null) {
                return false;
            }
        } else if (!this.zzafk.equals(zzfw.zzafk)) {
            return false;
        }
        if (this.zzayb == null) {
            if (zzfw.zzayb != null) {
                return false;
            }
        } else if (!this.zzayb.equals(zzfw.zzayb)) {
            return false;
        }
        if (this.zzayc == null) {
            if (zzfw.zzayc != null) {
                return false;
            }
        } else if (!this.zzayc.equals(zzfw.zzayc)) {
            return false;
        }
        if (this.zzayd == null) {
            if (zzfw.zzayd != null) {
                return false;
            }
        } else if (!this.zzayd.equals(zzfw.zzayd)) {
            return false;
        }
        if (this.zzaye == null) {
            if (zzfw.zzaye != null) {
                return false;
            }
        } else if (!this.zzaye.equals(zzfw.zzaye)) {
            return false;
        }
        if (this.zzayf == null) {
            if (zzfw.zzayf != null) {
                return false;
            }
        } else if (!this.zzayf.equals(zzfw.zzayf)) {
            return false;
        }
        if (this.zzayg == null) {
            if (zzfw.zzayg != null) {
                return false;
            }
        } else if (!this.zzayg.equals(zzfw.zzayg)) {
            return false;
        }
        if (this.zzayh == null) {
            if (zzfw.zzayh != null) {
                return false;
            }
        } else if (!this.zzayh.equals(zzfw.zzayh)) {
            return false;
        }
        if (this.zzayi == null) {
            if (zzfw.zzayi != null) {
                return false;
            }
        } else if (!this.zzayi.equals(zzfw.zzayi)) {
            return false;
        }
        if (this.zzayj == null) {
            if (zzfw.zzayj != null) {
                return false;
            }
        } else if (!this.zzayj.equals(zzfw.zzayj)) {
            return false;
        }
        if (this.zzawp == null) {
            if (zzfw.zzawp != null) {
                return false;
            }
        } else if (!this.zzawp.equals(zzfw.zzawp)) {
            return false;
        }
        if (this.zzayk == null) {
            if (zzfw.zzayk != null) {
                return false;
            }
        } else if (!this.zzayk.equals(zzfw.zzayk)) {
            return false;
        }
        if (!zzyg.equals(this.zzayl, zzfw.zzayl)) {
            return false;
        }
        if (this.zzaym == null) {
            if (zzfw.zzaym != null) {
                return false;
            }
        } else if (!this.zzaym.equals(zzfw.zzaym)) {
            return false;
        }
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            return this.zzcet.equals(zzfw.zzcet);
        }
        if (zzfw.zzcet == null || zzfw.zzcet.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (this.zzawp == null ? 0 : this.zzawp.hashCode()) + (((this.zzayj == null ? 0 : this.zzayj.hashCode()) + (((this.zzayi == null ? 0 : this.zzayi.hashCode()) + (((this.zzayh == null ? 0 : this.zzayh.hashCode()) + (((this.zzayg == null ? 0 : this.zzayg.hashCode()) + (((this.zzayf == null ? 0 : this.zzayf.hashCode()) + (((this.zzaye == null ? 0 : this.zzaye.hashCode()) + (((this.zzayd == null ? 0 : this.zzayd.hashCode()) + (((this.zzayc == null ? 0 : this.zzayc.hashCode()) + (((this.zzayb == null ? 0 : this.zzayb.hashCode()) + (((this.zzafk == null ? 0 : this.zzafk.hashCode()) + (((((this.zzaxz == null ? 0 : this.zzaxz.hashCode()) + (((this.zzafi == null ? 0 : this.zzafi.hashCode()) + (((this.zzagm == null ? 0 : this.zzagm.hashCode()) + (((this.zzaxy == null ? 0 : this.zzaxy.hashCode()) + (((this.zzaxx == null ? 0 : this.zzaxx.hashCode()) + (((this.zzafh == null ? 0 : this.zzafh.hashCode()) + (((this.zzaxw == null ? 0 : this.zzaxw.hashCode()) + (((this.zzaxv == null ? 0 : this.zzaxv.hashCode()) + (((this.zzaxu == null ? 0 : this.zzaxu.hashCode()) + (((this.zzaxt == null ? 0 : this.zzaxt.hashCode()) + (((this.zzts == null ? 0 : this.zzts.hashCode()) + (((this.zztt == null ? 0 : this.zztt.hashCode()) + (((this.zzafp == null ? 0 : this.zzafp.hashCode()) + (((this.zzaxs == null ? 0 : this.zzaxs.hashCode()) + (((this.zzahr == null ? 0 : this.zzahr.hashCode()) + (((this.zzaxr == null ? 0 : this.zzaxr.hashCode()) + (((this.zzaxq == null ? 0 : this.zzaxq.hashCode()) + (((this.zzaxp == null ? 0 : this.zzaxp.hashCode()) + (((this.zzaxo == null ? 0 : this.zzaxo.hashCode()) + (((this.zzaxn == null ? 0 : this.zzaxn.hashCode()) + (((this.zzaxm == null ? 0 : this.zzaxm.hashCode()) + (((this.zzaxl == null ? 0 : this.zzaxl.hashCode()) + (((this.zzaxk == null ? 0 : this.zzaxk.hashCode()) + (((((((this.zzaxh == null ? 0 : this.zzaxh.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzyg.hashCode(this.zzaxi)) * 31) + zzyg.hashCode(this.zzaxj)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + zzyg.hashCode(this.zzaya)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
        zzuo zzuo = this.zzayk;
        hashCode = ((this.zzaym == null ? 0 : this.zzaym.hashCode()) + (((((zzuo == null ? 0 : zzuo.hashCode()) + (hashCode * 31)) * 31) + zzyg.hashCode(this.zzayl)) * 31)) * 31;
        if (!(this.zzcet == null || this.zzcet.isEmpty())) {
            i = this.zzcet.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzya zzya) {
        if (this.zzaxh != null) {
            zzya.zzd(1, this.zzaxh.intValue());
        }
        if (this.zzaxi != null && this.zzaxi.length > 0) {
            for (zzyi zzyi : this.zzaxi) {
                if (zzyi != null) {
                    zzya.zza(2, zzyi);
                }
            }
        }
        if (this.zzaxj != null && this.zzaxj.length > 0) {
            for (zzyi zzyi2 : this.zzaxj) {
                if (zzyi2 != null) {
                    zzya.zza(3, zzyi2);
                }
            }
        }
        if (this.zzaxk != null) {
            zzya.zzi(4, this.zzaxk.longValue());
        }
        if (this.zzaxl != null) {
            zzya.zzi(5, this.zzaxl.longValue());
        }
        if (this.zzaxm != null) {
            zzya.zzi(6, this.zzaxm.longValue());
        }
        if (this.zzaxo != null) {
            zzya.zzi(7, this.zzaxo.longValue());
        }
        if (this.zzaxp != null) {
            zzya.zzb(8, this.zzaxp);
        }
        if (this.zzaxq != null) {
            zzya.zzb(9, this.zzaxq);
        }
        if (this.zzaxr != null) {
            zzya.zzb(10, this.zzaxr);
        }
        if (this.zzahr != null) {
            zzya.zzb(11, this.zzahr);
        }
        if (this.zzaxs != null) {
            zzya.zzd(12, this.zzaxs.intValue());
        }
        if (this.zzafp != null) {
            zzya.zzb(13, this.zzafp);
        }
        if (this.zztt != null) {
            zzya.zzb(14, this.zztt);
        }
        if (this.zzts != null) {
            zzya.zzb(16, this.zzts);
        }
        if (this.zzaxt != null) {
            zzya.zzi(17, this.zzaxt.longValue());
        }
        if (this.zzaxu != null) {
            zzya.zzi(18, this.zzaxu.longValue());
        }
        if (this.zzaxv != null) {
            zzya.zzb(19, this.zzaxv);
        }
        if (this.zzaxw != null) {
            zzya.zzb(20, this.zzaxw.booleanValue());
        }
        if (this.zzafh != null) {
            zzya.zzb(21, this.zzafh);
        }
        if (this.zzaxx != null) {
            zzya.zzi(22, this.zzaxx.longValue());
        }
        if (this.zzaxy != null) {
            zzya.zzd(23, this.zzaxy.intValue());
        }
        if (this.zzagm != null) {
            zzya.zzb(24, this.zzagm);
        }
        if (this.zzafi != null) {
            zzya.zzb(25, this.zzafi);
        }
        if (this.zzaxn != null) {
            zzya.zzi(26, this.zzaxn.longValue());
        }
        if (this.zzaxz != null) {
            zzya.zzb(28, this.zzaxz.booleanValue());
        }
        if (this.zzaya != null && this.zzaya.length > 0) {
            for (zzyi zzyi22 : this.zzaya) {
                if (zzyi22 != null) {
                    zzya.zza(29, zzyi22);
                }
            }
        }
        if (this.zzafk != null) {
            zzya.zzb(30, this.zzafk);
        }
        if (this.zzayb != null) {
            zzya.zzd(31, this.zzayb.intValue());
        }
        if (this.zzayc != null) {
            zzya.zzd(32, this.zzayc.intValue());
        }
        if (this.zzayd != null) {
            zzya.zzd(33, this.zzayd.intValue());
        }
        if (this.zzaye != null) {
            zzya.zzb(34, this.zzaye);
        }
        if (this.zzayf != null) {
            zzya.zzi(35, this.zzayf.longValue());
        }
        if (this.zzayg != null) {
            zzya.zzi(36, this.zzayg.longValue());
        }
        if (this.zzayh != null) {
            zzya.zzb(37, this.zzayh);
        }
        if (this.zzayi != null) {
            zzya.zzb(38, this.zzayi);
        }
        if (this.zzayj != null) {
            zzya.zzd(39, this.zzayj.intValue());
        }
        if (this.zzawp != null) {
            zzya.zzb(41, this.zzawp);
        }
        if (this.zzayk != null) {
            zzya.zze(44, this.zzayk);
        }
        if (this.zzayl != null && this.zzayl.length > 0) {
            for (int i : this.zzayl) {
                zzya.zzc(45, 0);
                zzya.zzcd(i);
            }
        }
        if (this.zzaym != null) {
            zzya.zzi(46, this.zzaym.longValue());
        }
        super.zza(zzya);
    }

    protected final int zzf() {
        int i;
        int zzf = super.zzf();
        if (this.zzaxh != null) {
            zzf += zzya.zzh(1, this.zzaxh.intValue());
        }
        if (this.zzaxi != null && this.zzaxi.length > 0) {
            i = zzf;
            for (zzyi zzyi : this.zzaxi) {
                if (zzyi != null) {
                    i += zzya.zzb(2, zzyi);
                }
            }
            zzf = i;
        }
        if (this.zzaxj != null && this.zzaxj.length > 0) {
            i = zzf;
            for (zzyi zzyi2 : this.zzaxj) {
                if (zzyi2 != null) {
                    i += zzya.zzb(3, zzyi2);
                }
            }
            zzf = i;
        }
        if (this.zzaxk != null) {
            zzf += zzya.zzd(4, this.zzaxk.longValue());
        }
        if (this.zzaxl != null) {
            zzf += zzya.zzd(5, this.zzaxl.longValue());
        }
        if (this.zzaxm != null) {
            zzf += zzya.zzd(6, this.zzaxm.longValue());
        }
        if (this.zzaxo != null) {
            zzf += zzya.zzd(7, this.zzaxo.longValue());
        }
        if (this.zzaxp != null) {
            zzf += zzya.zzc(8, this.zzaxp);
        }
        if (this.zzaxq != null) {
            zzf += zzya.zzc(9, this.zzaxq);
        }
        if (this.zzaxr != null) {
            zzf += zzya.zzc(10, this.zzaxr);
        }
        if (this.zzahr != null) {
            zzf += zzya.zzc(11, this.zzahr);
        }
        if (this.zzaxs != null) {
            zzf += zzya.zzh(12, this.zzaxs.intValue());
        }
        if (this.zzafp != null) {
            zzf += zzya.zzc(13, this.zzafp);
        }
        if (this.zztt != null) {
            zzf += zzya.zzc(14, this.zztt);
        }
        if (this.zzts != null) {
            zzf += zzya.zzc(16, this.zzts);
        }
        if (this.zzaxt != null) {
            zzf += zzya.zzd(17, this.zzaxt.longValue());
        }
        if (this.zzaxu != null) {
            zzf += zzya.zzd(18, this.zzaxu.longValue());
        }
        if (this.zzaxv != null) {
            zzf += zzya.zzc(19, this.zzaxv);
        }
        if (this.zzaxw != null) {
            this.zzaxw.booleanValue();
            zzf += zzya.zzbd(20) + 1;
        }
        if (this.zzafh != null) {
            zzf += zzya.zzc(21, this.zzafh);
        }
        if (this.zzaxx != null) {
            zzf += zzya.zzd(22, this.zzaxx.longValue());
        }
        if (this.zzaxy != null) {
            zzf += zzya.zzh(23, this.zzaxy.intValue());
        }
        if (this.zzagm != null) {
            zzf += zzya.zzc(24, this.zzagm);
        }
        if (this.zzafi != null) {
            zzf += zzya.zzc(25, this.zzafi);
        }
        if (this.zzaxn != null) {
            zzf += zzya.zzd(26, this.zzaxn.longValue());
        }
        if (this.zzaxz != null) {
            this.zzaxz.booleanValue();
            zzf += zzya.zzbd(28) + 1;
        }
        if (this.zzaya != null && this.zzaya.length > 0) {
            i = zzf;
            for (zzyi zzyi22 : this.zzaya) {
                if (zzyi22 != null) {
                    i += zzya.zzb(29, zzyi22);
                }
            }
            zzf = i;
        }
        if (this.zzafk != null) {
            zzf += zzya.zzc(30, this.zzafk);
        }
        if (this.zzayb != null) {
            zzf += zzya.zzh(31, this.zzayb.intValue());
        }
        if (this.zzayc != null) {
            zzf += zzya.zzh(32, this.zzayc.intValue());
        }
        if (this.zzayd != null) {
            zzf += zzya.zzh(33, this.zzayd.intValue());
        }
        if (this.zzaye != null) {
            zzf += zzya.zzc(34, this.zzaye);
        }
        if (this.zzayf != null) {
            zzf += zzya.zzd(35, this.zzayf.longValue());
        }
        if (this.zzayg != null) {
            zzf += zzya.zzd(36, this.zzayg.longValue());
        }
        if (this.zzayh != null) {
            zzf += zzya.zzc(37, this.zzayh);
        }
        if (this.zzayi != null) {
            zzf += zzya.zzc(38, this.zzayi);
        }
        if (this.zzayj != null) {
            zzf += zzya.zzh(39, this.zzayj.intValue());
        }
        if (this.zzawp != null) {
            zzf += zzya.zzc(41, this.zzawp);
        }
        if (this.zzayk != null) {
            zzf += zztv.zzc(44, this.zzayk);
        }
        if (this.zzayl != null && this.zzayl.length > 0) {
            i = 0;
            for (int zzbl : this.zzayl) {
                i += zzya.zzbl(zzbl);
            }
            zzf = (zzf + i) + (this.zzayl.length * 2);
        }
        if (this.zzaym != null) {
            return zzf + zzya.zzd(46, this.zzaym.longValue());
        }
        return zzf;
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
                    this.zzaxh = Integer.valueOf(zzxz.zzvb());
                    continue;
                case 18:
                    zzb = zzyl.zzb(zzxz, 18);
                    zzuj = this.zzaxi == null ? 0 : this.zzaxi.length;
                    obj = new zzft[(zzb + zzuj)];
                    if (zzuj != 0) {
                        System.arraycopy(this.zzaxi, 0, obj, 0, zzuj);
                    }
                    while (zzuj < obj.length - 1) {
                        obj[zzuj] = new zzft();
                        zzxz.zza(obj[zzuj]);
                        zzxz.zzuj();
                        zzuj++;
                    }
                    obj[zzuj] = new zzft();
                    zzxz.zza(obj[zzuj]);
                    this.zzaxi = obj;
                    continue;
                case 26:
                    zzb = zzyl.zzb(zzxz, 26);
                    zzuj = this.zzaxj == null ? 0 : this.zzaxj.length;
                    obj = new zzfz[(zzb + zzuj)];
                    if (zzuj != 0) {
                        System.arraycopy(this.zzaxj, 0, obj, 0, zzuj);
                    }
                    while (zzuj < obj.length - 1) {
                        obj[zzuj] = new zzfz();
                        zzxz.zza(obj[zzuj]);
                        zzxz.zzuj();
                        zzuj++;
                    }
                    obj[zzuj] = new zzfz();
                    zzxz.zza(obj[zzuj]);
                    this.zzaxj = obj;
                    continue;
                case HTTP.SP /*32*/:
                    this.zzaxk = Long.valueOf(zzxz.zzvc());
                    continue;
                case 40:
                    this.zzaxl = Long.valueOf(zzxz.zzvc());
                    continue;
                case 48:
                    this.zzaxm = Long.valueOf(zzxz.zzvc());
                    continue;
                case 56:
                    this.zzaxo = Long.valueOf(zzxz.zzvc());
                    continue;
                case 66:
                    this.zzaxp = zzxz.readString();
                    continue;
                case 74:
                    this.zzaxq = zzxz.readString();
                    continue;
                case 82:
                    this.zzaxr = zzxz.readString();
                    continue;
                case PDF417Common.MAX_ROWS_IN_BARCODE /*90*/:
                    this.zzahr = zzxz.readString();
                    continue;
                case 96:
                    this.zzaxs = Integer.valueOf(zzxz.zzvb());
                    continue;
                case 106:
                    this.zzafp = zzxz.readString();
                    continue;
                case 114:
                    this.zztt = zzxz.readString();
                    continue;
                case 130:
                    this.zzts = zzxz.readString();
                    continue;
                case 136:
                    this.zzaxt = Long.valueOf(zzxz.zzvc());
                    continue;
                case 144:
                    this.zzaxu = Long.valueOf(zzxz.zzvc());
                    continue;
                case 154:
                    this.zzaxv = zzxz.readString();
                    continue;
                case 160:
                    this.zzaxw = Boolean.valueOf(zzxz.zzup());
                    continue;
                case 170:
                    this.zzafh = zzxz.readString();
                    continue;
                case 176:
                    this.zzaxx = Long.valueOf(zzxz.zzvc());
                    continue;
                case 184:
                    this.zzaxy = Integer.valueOf(zzxz.zzvb());
                    continue;
                case 194:
                    this.zzagm = zzxz.readString();
                    continue;
                case HttpStatus.SC_ACCEPTED /*202*/:
                    this.zzafi = zzxz.readString();
                    continue;
                case 208:
                    this.zzaxn = Long.valueOf(zzxz.zzvc());
                    continue;
                case 224:
                    this.zzaxz = Boolean.valueOf(zzxz.zzup());
                    continue;
                case 234:
                    zzb = zzyl.zzb(zzxz, 234);
                    zzuj = this.zzaya == null ? 0 : this.zzaya.length;
                    obj = new zzfr[(zzb + zzuj)];
                    if (zzuj != 0) {
                        System.arraycopy(this.zzaya, 0, obj, 0, zzuj);
                    }
                    while (zzuj < obj.length - 1) {
                        obj[zzuj] = new zzfr();
                        zzxz.zza(obj[zzuj]);
                        zzxz.zzuj();
                        zzuj++;
                    }
                    obj[zzuj] = new zzfr();
                    zzxz.zza(obj[zzuj]);
                    this.zzaya = obj;
                    continue;
                case 242:
                    this.zzafk = zzxz.readString();
                    continue;
                case 248:
                    this.zzayb = Integer.valueOf(zzxz.zzvb());
                    continue;
                case 256:
                    this.zzayc = Integer.valueOf(zzxz.zzvb());
                    continue;
                case 264:
                    this.zzayd = Integer.valueOf(zzxz.zzvb());
                    continue;
                case 274:
                    this.zzaye = zzxz.readString();
                    continue;
                case 280:
                    this.zzayf = Long.valueOf(zzxz.zzvc());
                    continue;
                case 288:
                    this.zzayg = Long.valueOf(zzxz.zzvc());
                    continue;
                case 298:
                    this.zzayh = zzxz.readString();
                    continue;
                case 306:
                    this.zzayi = zzxz.readString();
                    continue;
                case 312:
                    this.zzayj = Integer.valueOf(zzxz.zzvb());
                    continue;
                case 330:
                    this.zzawp = zzxz.readString();
                    continue;
                case 354:
                    zzb zzb2;
                    zzuo zzuo = (zzb) zzxz.zza(zzb.zza());
                    if (this.zzayk != null) {
                        zzb2 = (zzb) ((zzuo) ((zza) ((zza) this.zzayk.zzwf()).zza(zzuo)).zzwo());
                    }
                    this.zzayk = zzb2;
                    continue;
                case 360:
                    zzb = zzyl.zzb(zzxz, 360);
                    if (this.zzayl == null) {
                        zzuj = 0;
                    } else {
                        zzuj = this.zzayl.length;
                    }
                    obj = new int[(zzb + zzuj)];
                    if (zzuj != 0) {
                        System.arraycopy(this.zzayl, 0, obj, 0, zzuj);
                    }
                    while (zzuj < obj.length - 1) {
                        obj[zzuj] = zzxz.zzvb();
                        zzxz.zzuj();
                        zzuj++;
                    }
                    obj[zzuj] = zzxz.zzvb();
                    this.zzayl = obj;
                    continue;
                case 362:
                    int zzas = zzxz.zzas(zzxz.zzvb());
                    zzb = zzxz.getPosition();
                    zzuj = 0;
                    while (zzxz.zzyy() > 0) {
                        zzxz.zzvb();
                        zzuj++;
                    }
                    zzxz.zzcb(zzb);
                    zzb = this.zzayl == null ? 0 : this.zzayl.length;
                    Object obj2 = new int[(zzuj + zzb)];
                    if (zzb != 0) {
                        System.arraycopy(this.zzayl, 0, obj2, 0, zzb);
                    }
                    while (zzb < obj2.length) {
                        obj2[zzb] = zzxz.zzvb();
                        zzb++;
                    }
                    this.zzayl = obj2;
                    zzxz.zzat(zzas);
                    continue;
                case 368:
                    this.zzaym = Long.valueOf(zzxz.zzvc());
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
