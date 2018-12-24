package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.util.Arrays;

final class zzts extends zztq {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzbud;
    private int zzbue;
    private int zzbuf;
    private int zzbug;
    private int zzbuh;

    private zzts(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzbuh = BaseClientBuilder.API_PRIORITY_OTHER;
        this.buffer = bArr;
        this.limit = i + i2;
        this.pos = i;
        this.zzbuf = this.pos;
        this.zzbud = z;
    }

    public final int zzuj() {
        if (zzuz()) {
            this.zzbug = 0;
            return 0;
        }
        this.zzbug = zzvb();
        if ((this.zzbug >>> 3) != 0) {
            return this.zzbug;
        }
        throw new zzuv("Protocol message contained an invalid tag (zero).");
    }

    public final void zzap(int i) {
        if (this.zzbug != i) {
            throw zzuv.zzwt();
        }
    }

    public final boolean zzaq(int i) {
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.limit - this.pos >= 10) {
                    while (i2 < 10) {
                        byte[] bArr = this.buffer;
                        int i3 = this.pos;
                        this.pos = i3 + 1;
                        if (bArr[i3] >= (byte) 0) {
                            return true;
                        }
                        i2++;
                    }
                    throw zzuv.zzws();
                }
                while (i2 < 10) {
                    if (zzvg() >= (byte) 0) {
                        return true;
                    }
                    i2++;
                }
                throw zzuv.zzws();
            case 1:
                zzau(8);
                return true;
            case 2:
                zzau(zzvb());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzau(4);
                return true;
            default:
                throw zzuv.zzwu();
        }
        do {
            i2 = zzuj();
            if (i2 != 0) {
            }
            zzap(((i >>> 3) << 3) | 4);
            return true;
        } while (zzaq(i2));
        zzap(((i >>> 3) << 3) | 4);
        return true;
    }

    public final double readDouble() {
        return Double.longBitsToDouble(zzve());
    }

    public final float readFloat() {
        return Float.intBitsToFloat(zzvd());
    }

    public final long zzuk() {
        return zzvc();
    }

    public final long zzul() {
        return zzvc();
    }

    public final int zzum() {
        return zzvb();
    }

    public final long zzun() {
        return zzve();
    }

    public final int zzuo() {
        return zzvd();
    }

    public final boolean zzup() {
        return zzvc() != 0;
    }

    public final String readString() {
        int zzvb = zzvb();
        if (zzvb > 0 && zzvb <= this.limit - this.pos) {
            String str = new String(this.buffer, this.pos, zzvb, zzuq.UTF_8);
            this.pos = zzvb + this.pos;
            return str;
        } else if (zzvb == 0) {
            return "";
        } else {
            if (zzvb < 0) {
                throw zzuv.zzwr();
            }
            throw zzuv.zzwq();
        }
    }

    public final String zzuq() {
        int zzvb = zzvb();
        if (zzvb > 0 && zzvb <= this.limit - this.pos) {
            String zzh = zzxl.zzh(this.buffer, this.pos, zzvb);
            this.pos = zzvb + this.pos;
            return zzh;
        } else if (zzvb == 0) {
            return "";
        } else {
            if (zzvb <= 0) {
                throw zzuv.zzwr();
            }
            throw zzuv.zzwq();
        }
    }

    public final <T extends zzvv> T zza(zzwf<T> zzwf, zzub zzub) {
        int zzvb = zzvb();
        if (this.zzbty >= this.zzbtz) {
            throw zzuv.zzwv();
        }
        int zzas = zzas(zzvb);
        this.zzbty++;
        zzvv zzvv = (zzvv) zzwf.zza(this, zzub);
        zzap(0);
        this.zzbty--;
        zzat(zzas);
        return zzvv;
    }

    public final zzte zzur() {
        int zzvb = zzvb();
        if (zzvb > 0 && zzvb <= this.limit - this.pos) {
            zzte zzb = zzte.zzb(this.buffer, this.pos, zzvb);
            this.pos = zzvb + this.pos;
            return zzb;
        } else if (zzvb == 0) {
            return zzte.zzbtq;
        } else {
            byte[] copyOfRange;
            if (zzvb > 0 && zzvb <= this.limit - this.pos) {
                int i = this.pos;
                this.pos = zzvb + this.pos;
                copyOfRange = Arrays.copyOfRange(this.buffer, i, this.pos);
            } else if (zzvb > 0) {
                throw zzuv.zzwq();
            } else if (zzvb == 0) {
                copyOfRange = zzuq.zzbza;
            } else {
                throw zzuv.zzwr();
            }
            return zzte.zzi(copyOfRange);
        }
    }

    public final int zzus() {
        return zzvb();
    }

    public final int zzut() {
        return zzvb();
    }

    public final int zzuu() {
        return zzvd();
    }

    public final long zzuv() {
        return zzve();
    }

    public final int zzuw() {
        int zzvb = zzvb();
        return (-(zzvb & 1)) ^ (zzvb >>> 1);
    }

    public final long zzux() {
        long zzvc = zzvc();
        return (-(zzvc & 1)) ^ (zzvc >>> 1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzvb() {
        /*
        r5 = this;
        r0 = r5.pos;
        r1 = r5.limit;
        if (r1 == r0) goto L_0x006c;
    L_0x0006:
        r3 = r5.buffer;
        r2 = r0 + 1;
        r0 = r3[r0];
        if (r0 < 0) goto L_0x0011;
    L_0x000e:
        r5.pos = r2;
    L_0x0010:
        return r0;
    L_0x0011:
        r1 = r5.limit;
        r1 = r1 - r2;
        r4 = 9;
        if (r1 < r4) goto L_0x006c;
    L_0x0018:
        r1 = r2 + 1;
        r2 = r3[r2];
        r2 = r2 << 7;
        r0 = r0 ^ r2;
        if (r0 >= 0) goto L_0x0026;
    L_0x0021:
        r0 = r0 ^ -128;
    L_0x0023:
        r5.pos = r1;
        goto L_0x0010;
    L_0x0026:
        r2 = r1 + 1;
        r1 = r3[r1];
        r1 = r1 << 14;
        r0 = r0 ^ r1;
        if (r0 < 0) goto L_0x0033;
    L_0x002f:
        r0 = r0 ^ 16256;
        r1 = r2;
        goto L_0x0023;
    L_0x0033:
        r1 = r2 + 1;
        r2 = r3[r2];
        r2 = r2 << 21;
        r0 = r0 ^ r2;
        if (r0 >= 0) goto L_0x0041;
    L_0x003c:
        r2 = -2080896; // 0xffffffffffe03f80 float:NaN double:NaN;
        r0 = r0 ^ r2;
        goto L_0x0023;
    L_0x0041:
        r2 = r1 + 1;
        r1 = r3[r1];
        r4 = r1 << 28;
        r0 = r0 ^ r4;
        r4 = 266354560; // 0xfe03f80 float:2.2112565E-29 double:1.315966377E-315;
        r0 = r0 ^ r4;
        if (r1 >= 0) goto L_0x0072;
    L_0x004e:
        r1 = r2 + 1;
        r2 = r3[r2];
        if (r2 >= 0) goto L_0x0023;
    L_0x0054:
        r2 = r1 + 1;
        r1 = r3[r1];
        if (r1 >= 0) goto L_0x0072;
    L_0x005a:
        r1 = r2 + 1;
        r2 = r3[r2];
        if (r2 >= 0) goto L_0x0023;
    L_0x0060:
        r2 = r1 + 1;
        r1 = r3[r1];
        if (r1 >= 0) goto L_0x0072;
    L_0x0066:
        r1 = r2 + 1;
        r2 = r3[r2];
        if (r2 >= 0) goto L_0x0023;
    L_0x006c:
        r0 = r5.zzuy();
        r0 = (int) r0;
        goto L_0x0010;
    L_0x0072:
        r1 = r2;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzts.zzvb():int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzvc() {
        /*
        r10 = this;
        r8 = 0;
        r0 = r10.pos;
        r1 = r10.limit;
        if (r1 == r0) goto L_0x00b4;
    L_0x0008:
        r4 = r10.buffer;
        r1 = r0 + 1;
        r0 = r4[r0];
        if (r0 < 0) goto L_0x0014;
    L_0x0010:
        r10.pos = r1;
        r0 = (long) r0;
    L_0x0013:
        return r0;
    L_0x0014:
        r2 = r10.limit;
        r2 = r2 - r1;
        r3 = 9;
        if (r2 < r3) goto L_0x00b4;
    L_0x001b:
        r2 = r1 + 1;
        r1 = r4[r1];
        r1 = r1 << 7;
        r0 = r0 ^ r1;
        if (r0 >= 0) goto L_0x002a;
    L_0x0024:
        r0 = r0 ^ -128;
        r0 = (long) r0;
    L_0x0027:
        r10.pos = r2;
        goto L_0x0013;
    L_0x002a:
        r3 = r2 + 1;
        r1 = r4[r2];
        r1 = r1 << 14;
        r0 = r0 ^ r1;
        if (r0 < 0) goto L_0x0038;
    L_0x0033:
        r0 = r0 ^ 16256;
        r0 = (long) r0;
        r2 = r3;
        goto L_0x0027;
    L_0x0038:
        r2 = r3 + 1;
        r1 = r4[r3];
        r1 = r1 << 21;
        r0 = r0 ^ r1;
        if (r0 >= 0) goto L_0x0047;
    L_0x0041:
        r1 = -2080896; // 0xffffffffffe03f80 float:NaN double:NaN;
        r0 = r0 ^ r1;
        r0 = (long) r0;
        goto L_0x0027;
    L_0x0047:
        r0 = (long) r0;
        r3 = r2 + 1;
        r2 = r4[r2];
        r6 = (long) r2;
        r2 = 28;
        r6 = r6 << r2;
        r0 = r0 ^ r6;
        r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r2 < 0) goto L_0x005b;
    L_0x0055:
        r4 = 266354560; // 0xfe03f80 float:2.2112565E-29 double:1.315966377E-315;
        r0 = r0 ^ r4;
        r2 = r3;
        goto L_0x0027;
    L_0x005b:
        r2 = r3 + 1;
        r3 = r4[r3];
        r6 = (long) r3;
        r3 = 35;
        r6 = r6 << r3;
        r0 = r0 ^ r6;
        r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r3 >= 0) goto L_0x006f;
    L_0x0068:
        r4 = -34093383808; // 0xfffffff80fe03f80 float:2.2112565E-29 double:NaN;
        r0 = r0 ^ r4;
        goto L_0x0027;
    L_0x006f:
        r3 = r2 + 1;
        r2 = r4[r2];
        r6 = (long) r2;
        r2 = 42;
        r6 = r6 << r2;
        r0 = r0 ^ r6;
        r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r2 < 0) goto L_0x0084;
    L_0x007c:
        r4 = 4363953127296; // 0x3f80fe03f80 float:2.2112565E-29 double:2.1560793202584E-311;
        r0 = r0 ^ r4;
        r2 = r3;
        goto L_0x0027;
    L_0x0084:
        r2 = r3 + 1;
        r3 = r4[r3];
        r6 = (long) r3;
        r3 = 49;
        r6 = r6 << r3;
        r0 = r0 ^ r6;
        r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r3 >= 0) goto L_0x0098;
    L_0x0091:
        r4 = -558586000294016; // 0xfffe03f80fe03f80 float:2.2112565E-29 double:NaN;
        r0 = r0 ^ r4;
        goto L_0x0027;
    L_0x0098:
        r3 = r2 + 1;
        r2 = r4[r2];
        r6 = (long) r2;
        r2 = 56;
        r6 = r6 << r2;
        r0 = r0 ^ r6;
        r6 = 71499008037633920; // 0xfe03f80fe03f80 float:2.2112565E-29 double:6.838959413692434E-304;
        r0 = r0 ^ r6;
        r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r2 >= 0) goto L_0x00ba;
    L_0x00ab:
        r2 = r3 + 1;
        r3 = r4[r3];
        r4 = (long) r3;
        r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r3 >= 0) goto L_0x0027;
    L_0x00b4:
        r0 = r10.zzuy();
        goto L_0x0013;
    L_0x00ba:
        r2 = r3;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzts.zzvc():long");
    }

    final long zzuy() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzvg = zzvg();
            j |= ((long) (zzvg & 127)) << i;
            if ((zzvg & 128) == 0) {
                return j;
            }
        }
        throw zzuv.zzws();
    }

    private final int zzvd() {
        int i = this.pos;
        if (this.limit - i < 4) {
            throw zzuv.zzwq();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16));
    }

    private final long zzve() {
        int i = this.pos;
        if (this.limit - i < 8) {
            throw zzuv.zzwq();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((((((((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8)) | ((((long) bArr[i + 2]) & 255) << 16)) | ((((long) bArr[i + 3]) & 255) << 24)) | ((((long) bArr[i + 4]) & 255) << 32)) | ((((long) bArr[i + 5]) & 255) << 40)) | ((((long) bArr[i + 6]) & 255) << 48));
    }

    public final int zzas(int i) {
        if (i < 0) {
            throw zzuv.zzwr();
        }
        int zzva = zzva() + i;
        int i2 = this.zzbuh;
        if (zzva > i2) {
            throw zzuv.zzwq();
        }
        this.zzbuh = zzva;
        zzvf();
        return i2;
    }

    private final void zzvf() {
        this.limit += this.zzbue;
        int i = this.limit - this.zzbuf;
        if (i > this.zzbuh) {
            this.zzbue = i - this.zzbuh;
            this.limit -= this.zzbue;
            return;
        }
        this.zzbue = 0;
    }

    public final void zzat(int i) {
        this.zzbuh = i;
        zzvf();
    }

    public final boolean zzuz() {
        return this.pos == this.limit;
    }

    public final int zzva() {
        return this.pos - this.zzbuf;
    }

    private final byte zzvg() {
        if (this.pos == this.limit) {
            throw zzuv.zzwq();
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    public final void zzau(int i) {
        if (i >= 0 && i <= this.limit - this.pos) {
            this.pos += i;
        } else if (i < 0) {
            throw zzuv.zzwr();
        } else {
            throw zzuv.zzwq();
        }
    }
}
