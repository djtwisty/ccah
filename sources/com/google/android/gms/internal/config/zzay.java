package com.google.android.gms.internal.config;

import com.google.android.gms.common.api.Api.BaseClientBuilder;

public final class zzay {
    private final byte[] buffer;
    private final int zzbw;
    private final int zzbx;
    private int zzby;
    private int zzbz;
    private int zzca;
    private int zzcb;
    private int zzcc = BaseClientBuilder.API_PRIORITY_OTHER;
    private int zzcd;
    private int zzce = 64;
    private int zzcf = 67108864;

    public static zzay zza(byte[] bArr, int i, int i2) {
        return new zzay(bArr, 0, i2);
    }

    public final int zzy() {
        if (this.zzca == this.zzby) {
            this.zzcb = 0;
            return 0;
        }
        this.zzcb = zzz();
        if (this.zzcb != 0) {
            return this.zzcb;
        }
        throw new zzbg("Protocol message contained an invalid tag (zero).");
    }

    private final void zzg(int i) {
        if (this.zzcb != i) {
            throw new zzbg("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean zzh(int i) {
        switch (i & 7) {
            case 0:
                zzz();
                return true;
            case 1:
                zzaa();
                return true;
            case 2:
                zzi(zzz());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzac();
                zzac();
                zzac();
                zzac();
                return true;
            default:
                throw new zzbg("Protocol message tag had invalid wire type.");
        }
        int zzy;
        do {
            zzy = zzy();
            if (zzy != 0) {
            }
            zzg(((i >>> 3) << 3) | 4);
            return true;
        } while (zzh(zzy));
        zzg(((i >>> 3) << 3) | 4);
        return true;
    }

    public final String readString() {
        int zzz = zzz();
        if (zzz < 0) {
            throw zzbg.zzah();
        } else if (zzz > this.zzby - this.zzca) {
            throw zzbg.zzag();
        } else {
            String str = new String(this.buffer, this.zzca, zzz, zzbf.UTF_8);
            this.zzca = zzz + this.zzca;
            return str;
        }
    }

    public final void zza(zzbh zzbh) {
        int zzz = zzz();
        if (this.zzcd >= this.zzce) {
            throw new zzbg("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        } else if (zzz < 0) {
            throw zzbg.zzah();
        } else {
            zzz += this.zzca;
            int i = this.zzcc;
            if (zzz > i) {
                throw zzbg.zzag();
            }
            this.zzcc = zzz;
            zzab();
            this.zzcd++;
            zzbh.zza(this);
            zzg(0);
            this.zzcd--;
            this.zzcc = i;
            zzab();
        }
    }

    public final byte[] readBytes() {
        int zzz = zzz();
        if (zzz < 0) {
            throw zzbg.zzah();
        } else if (zzz == 0) {
            return zzbk.zzdd;
        } else {
            if (zzz > this.zzby - this.zzca) {
                throw zzbg.zzag();
            }
            byte[] bArr = new byte[zzz];
            System.arraycopy(this.buffer, this.zzca, bArr, 0, zzz);
            this.zzca = zzz + this.zzca;
            return bArr;
        }
    }

    public final int zzz() {
        byte zzac = zzac();
        if (zzac >= (byte) 0) {
            return zzac;
        }
        int i = zzac & 127;
        byte zzac2 = zzac();
        if (zzac2 >= (byte) 0) {
            return i | (zzac2 << 7);
        }
        i |= (zzac2 & 127) << 7;
        zzac2 = zzac();
        if (zzac2 >= (byte) 0) {
            return i | (zzac2 << 14);
        }
        i |= (zzac2 & 127) << 14;
        zzac2 = zzac();
        if (zzac2 >= (byte) 0) {
            return i | (zzac2 << 21);
        }
        i |= (zzac2 & 127) << 21;
        zzac2 = zzac();
        i |= zzac2 << 28;
        if (zzac2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (zzac() >= (byte) 0) {
                return i;
            }
        }
        throw new zzbg("CodedInputStream encountered a malformed varint.");
    }

    public final long zzaa() {
        byte zzac = zzac();
        byte zzac2 = zzac();
        return ((((((((((long) zzac2) & 255) << 8) | (((long) zzac) & 255)) | ((((long) zzac()) & 255) << 16)) | ((((long) zzac()) & 255) << 24)) | ((((long) zzac()) & 255) << 32)) | ((((long) zzac()) & 255) << 40)) | ((((long) zzac()) & 255) << 48)) | ((((long) zzac()) & 255) << 56);
    }

    private zzay(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzbw = 0;
        int i3 = i2 + 0;
        this.zzby = i3;
        this.zzbx = i3;
        this.zzca = 0;
    }

    private final void zzab() {
        this.zzby += this.zzbz;
        int i = this.zzby;
        if (i > this.zzcc) {
            this.zzbz = i - this.zzcc;
            this.zzby -= this.zzbz;
            return;
        }
        this.zzbz = 0;
    }

    public final int getPosition() {
        return this.zzca - this.zzbw;
    }

    public final byte[] zza(int i, int i2) {
        if (i2 == 0) {
            return zzbk.zzdd;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzbw + i, bArr, 0, i2);
        return bArr;
    }

    final void zzb(int i, int i2) {
        if (i > this.zzca - this.zzbw) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.zzca - this.zzbw));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.zzca = this.zzbw + i;
            this.zzcb = i2;
        }
    }

    private final byte zzac() {
        if (this.zzca == this.zzby) {
            throw zzbg.zzag();
        }
        byte[] bArr = this.buffer;
        int i = this.zzca;
        this.zzca = i + 1;
        return bArr[i];
    }

    private final void zzi(int i) {
        if (i < 0) {
            throw zzbg.zzah();
        } else if (this.zzca + i > this.zzcc) {
            zzi(this.zzcc - this.zzca);
            throw zzbg.zzag();
        } else if (i <= this.zzby - this.zzca) {
            this.zzca += i;
        } else {
            throw zzbg.zzag();
        }
    }
}
