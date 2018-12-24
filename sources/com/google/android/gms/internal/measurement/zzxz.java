package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.io.IOException;

public final class zzxz {
    private final byte[] buffer;
    private int zzbty;
    private int zzbtz = 64;
    private int zzbua = 67108864;
    private int zzbue;
    private int zzbug;
    private int zzbuh = BaseClientBuilder.API_PRIORITY_OTHER;
    private final int zzcem;
    private final int zzcen;
    private int zzceo;
    private int zzcep;
    private zztq zzceq;

    public static zzxz zzn(byte[] bArr) {
        return zzj(bArr, 0, bArr.length);
    }

    public static zzxz zzj(byte[] bArr, int i, int i2) {
        return new zzxz(bArr, 0, i2);
    }

    public final int zzuj() {
        if (this.zzcep == this.zzceo) {
            this.zzbug = 0;
            return 0;
        }
        this.zzbug = zzvb();
        if (this.zzbug != 0) {
            return this.zzbug;
        }
        throw new zzyh("Protocol message contained an invalid tag (zero).");
    }

    public final void zzap(int i) {
        if (this.zzbug != i) {
            throw new zzyh("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean zzaq(int i) {
        switch (i & 7) {
            case 0:
                zzvb();
                return true;
            case 1:
                zzve();
                return true;
            case 2:
                zzau(zzvb());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzvd();
                return true;
            default:
                throw new zzyh("Protocol message tag had invalid wire type.");
        }
        int zzuj;
        do {
            zzuj = zzuj();
            if (zzuj != 0) {
            }
            zzap(((i >>> 3) << 3) | 4);
            return true;
        } while (zzaq(zzuj));
        zzap(((i >>> 3) << 3) | 4);
        return true;
    }

    public final boolean zzup() {
        return zzvb() != 0;
    }

    public final String readString() {
        int zzvb = zzvb();
        if (zzvb < 0) {
            throw zzyh.zzze();
        } else if (zzvb > this.zzceo - this.zzcep) {
            throw zzyh.zzzd();
        } else {
            String str = new String(this.buffer, this.zzcep, zzvb, zzyg.UTF_8);
            this.zzcep = zzvb + this.zzcep;
            return str;
        }
    }

    public final void zza(zzyi zzyi, int i) {
        if (this.zzbty >= this.zzbtz) {
            throw zzyh.zzzg();
        }
        this.zzbty++;
        zzyi.zza(this);
        zzap((i << 3) | 4);
        this.zzbty--;
    }

    public final void zza(zzyi zzyi) {
        int zzvb = zzvb();
        if (this.zzbty >= this.zzbtz) {
            throw zzyh.zzzg();
        }
        zzvb = zzas(zzvb);
        this.zzbty++;
        zzyi.zza(this);
        zzap(0);
        this.zzbty--;
        zzat(zzvb);
    }

    public final int zzvb() {
        byte zzvg = zzvg();
        if (zzvg >= (byte) 0) {
            return zzvg;
        }
        int i = zzvg & 127;
        byte zzvg2 = zzvg();
        if (zzvg2 >= (byte) 0) {
            return i | (zzvg2 << 7);
        }
        i |= (zzvg2 & 127) << 7;
        zzvg2 = zzvg();
        if (zzvg2 >= (byte) 0) {
            return i | (zzvg2 << 14);
        }
        i |= (zzvg2 & 127) << 14;
        zzvg2 = zzvg();
        if (zzvg2 >= (byte) 0) {
            return i | (zzvg2 << 21);
        }
        i |= (zzvg2 & 127) << 21;
        zzvg2 = zzvg();
        i |= zzvg2 << 28;
        if (zzvg2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (zzvg() >= (byte) 0) {
                return i;
            }
        }
        throw zzyh.zzzf();
    }

    public final long zzvc() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzvg = zzvg();
            j |= ((long) (zzvg & 127)) << i;
            if ((zzvg & 128) == 0) {
                return j;
            }
        }
        throw zzyh.zzzf();
    }

    public final int zzvd() {
        return (((zzvg() & 255) | ((zzvg() & 255) << 8)) | ((zzvg() & 255) << 16)) | ((zzvg() & 255) << 24);
    }

    public final long zzve() {
        byte zzvg = zzvg();
        byte zzvg2 = zzvg();
        return ((((((((((long) zzvg2) & 255) << 8) | (((long) zzvg) & 255)) | ((((long) zzvg()) & 255) << 16)) | ((((long) zzvg()) & 255) << 24)) | ((((long) zzvg()) & 255) << 32)) | ((((long) zzvg()) & 255) << 40)) | ((((long) zzvg()) & 255) << 48)) | ((((long) zzvg()) & 255) << 56);
    }

    private zzxz(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzcem = i;
        int i3 = i + i2;
        this.zzceo = i3;
        this.zzcen = i3;
        this.zzcep = i;
    }

    private final zztq zzyx() {
        if (this.zzceq == null) {
            this.zzceq = zztq.zzd(this.buffer, this.zzcem, this.zzcen);
        }
        int zzva = this.zzceq.zzva();
        int i = this.zzcep - this.zzcem;
        if (zzva > i) {
            throw new IOException(String.format("CodedInputStream read ahead of CodedInputByteBufferNano: %s > %s", new Object[]{Integer.valueOf(zzva), Integer.valueOf(i)}));
        }
        this.zzceq.zzau(i - zzva);
        this.zzceq.zzar(this.zzbtz - this.zzbty);
        return this.zzceq;
    }

    public final <T extends zzuo<T, ?>> T zza(zzwf<T> zzwf) {
        try {
            zzuo zzuo = (zzuo) zzyx().zza(zzwf, zzub.zzvs());
            zzaq(this.zzbug);
            return zzuo;
        } catch (Exception e) {
            throw new zzyh("", e);
        }
    }

    public final int zzas(int i) {
        if (i < 0) {
            throw zzyh.zzze();
        }
        int i2 = this.zzcep + i;
        int i3 = this.zzbuh;
        if (i2 > i3) {
            throw zzyh.zzzd();
        }
        this.zzbuh = i2;
        zzvf();
        return i3;
    }

    private final void zzvf() {
        this.zzceo += this.zzbue;
        int i = this.zzceo;
        if (i > this.zzbuh) {
            this.zzbue = i - this.zzbuh;
            this.zzceo -= this.zzbue;
            return;
        }
        this.zzbue = 0;
    }

    public final void zzat(int i) {
        this.zzbuh = i;
        zzvf();
    }

    public final int zzyy() {
        if (this.zzbuh == BaseClientBuilder.API_PRIORITY_OTHER) {
            return -1;
        }
        return this.zzbuh - this.zzcep;
    }

    public final int getPosition() {
        return this.zzcep - this.zzcem;
    }

    public final byte[] zzs(int i, int i2) {
        if (i2 == 0) {
            return zzyl.zzcfo;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzcem + i, bArr, 0, i2);
        return bArr;
    }

    public final void zzcb(int i) {
        zzt(i, this.zzbug);
    }

    final void zzt(int i, int i2) {
        if (i > this.zzcep - this.zzcem) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.zzcep - this.zzcem));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.zzcep = this.zzcem + i;
            this.zzbug = i2;
        }
    }

    private final byte zzvg() {
        if (this.zzcep == this.zzceo) {
            throw zzyh.zzzd();
        }
        byte[] bArr = this.buffer;
        int i = this.zzcep;
        this.zzcep = i + 1;
        return bArr[i];
    }

    private final void zzau(int i) {
        if (i < 0) {
            throw zzyh.zzze();
        } else if (this.zzcep + i > this.zzbuh) {
            zzau(this.zzbuh - this.zzcep);
            throw zzyh.zzzd();
        } else if (i <= this.zzceo - this.zzcep) {
            this.zzcep += i;
        } else {
            throw zzyh.zzzd();
        }
    }
}
