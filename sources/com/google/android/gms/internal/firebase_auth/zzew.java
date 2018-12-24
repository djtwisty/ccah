package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

final class zzew extends zzet {
    private final byte[] buffer;
    private int pos;
    private int zztd;
    private int zztf;
    private int zztg;
    private final InputStream zzth;
    private int zzti;
    private int zztj;
    private zzex zztk;

    private zzew(InputStream inputStream, int i) {
        super();
        this.zztg = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zztk = null;
        zzfv.zza((Object) inputStream, "input");
        this.zzth = inputStream;
        this.buffer = new byte[i];
        this.zzti = 0;
        this.pos = 0;
        this.zztj = 0;
    }

    public final int zzfi() {
        if (zzfy()) {
            this.zztf = 0;
            return 0;
        }
        this.zztf = zzga();
        if ((this.zztf >>> 3) != 0) {
            return this.zztf;
        }
        throw zzgc.zzht();
    }

    public final void zzn(int i) {
        if (this.zztf != i) {
            throw zzgc.zzhu();
        }
    }

    public final boolean zzo(int i) {
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.zzti - this.pos >= 10) {
                    while (i2 < 10) {
                        byte[] bArr = this.buffer;
                        int i3 = this.pos;
                        this.pos = i3 + 1;
                        if (bArr[i3] >= (byte) 0) {
                            return true;
                        }
                        i2++;
                    }
                    throw zzgc.zzhs();
                }
                while (i2 < 10) {
                    if (zzgf() >= (byte) 0) {
                        return true;
                    }
                    i2++;
                }
                throw zzgc.zzhs();
            case 1:
                zzs(8);
                return true;
            case 2:
                zzs(zzga());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzs(4);
                return true;
            default:
                throw zzgc.zzhv();
        }
        do {
            i2 = zzfi();
            if (i2 != 0) {
            }
            zzn(((i >>> 3) << 3) | 4);
            return true;
        } while (zzo(i2));
        zzn(((i >>> 3) << 3) | 4);
        return true;
    }

    public final double readDouble() {
        return Double.longBitsToDouble(zzgd());
    }

    public final float readFloat() {
        return Float.intBitsToFloat(zzgc());
    }

    public final long zzfj() {
        return zzgb();
    }

    public final long zzfk() {
        return zzgb();
    }

    public final int zzfl() {
        return zzga();
    }

    public final long zzfm() {
        return zzgd();
    }

    public final int zzfn() {
        return zzgc();
    }

    public final boolean zzfo() {
        return zzgb() != 0;
    }

    public final String readString() {
        int zzga = zzga();
        String str;
        if (zzga > 0 && zzga <= this.zzti - this.pos) {
            str = new String(this.buffer, this.pos, zzga, zzfv.UTF_8);
            this.pos = zzga + this.pos;
            return str;
        } else if (zzga == 0) {
            return "";
        } else {
            if (zzga > this.zzti) {
                return new String(zzv(zzga), zzfv.UTF_8);
            }
            zzt(zzga);
            str = new String(this.buffer, this.pos, zzga, zzfv.UTF_8);
            this.pos = zzga + this.pos;
            return str;
        }
    }

    public final String zzfp() {
        byte[] bArr;
        int zzga = zzga();
        int i = this.pos;
        if (zzga <= this.zzti - i && zzga > 0) {
            byte[] bArr2 = this.buffer;
            this.pos = i + zzga;
            bArr = bArr2;
        } else if (zzga == 0) {
            return "";
        } else {
            if (zzga <= this.zzti) {
                zzt(zzga);
                bArr = this.buffer;
                this.pos = zzga;
                i = 0;
            } else {
                bArr = zzv(zzga);
                i = 0;
            }
        }
        return zziy.zzg(bArr, i, zzga);
    }

    public final zzeh zzfq() {
        int zzga = zzga();
        if (zzga <= this.zzti - this.pos && zzga > 0) {
            zzeh zzb = zzeh.zzb(this.buffer, this.pos, zzga);
            this.pos = zzga + this.pos;
            return zzb;
        } else if (zzga == 0) {
            return zzeh.zzso;
        } else {
            byte[] zzw = zzw(zzga);
            if (zzw != null) {
                return zzeh.zza(zzw);
            }
            int i = this.pos;
            int i2 = this.zzti - this.pos;
            this.zztj += this.zzti;
            this.pos = 0;
            this.zzti = 0;
            List<byte[]> zzx = zzx(zzga - i2);
            Iterable arrayList = new ArrayList(zzx.size() + 1);
            arrayList.add(zzeh.zzb(this.buffer, i, i2));
            for (byte[] zzw2 : zzx) {
                arrayList.add(zzeh.zza(zzw2));
            }
            return zzeh.zze(arrayList);
        }
    }

    public final int zzfr() {
        return zzga();
    }

    public final int zzfs() {
        return zzga();
    }

    public final int zzft() {
        return zzgc();
    }

    public final long zzfu() {
        return zzgd();
    }

    public final int zzfv() {
        return zzet.zzr(zzga());
    }

    public final long zzfw() {
        return zzet.zza(zzgb());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzga() {
        /*
        r5 = this;
        r0 = r5.pos;
        r1 = r5.zzti;
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
        r1 = r5.zzti;
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
        r0 = r5.zzfx();
        r0 = (int) r0;
        goto L_0x0010;
    L_0x0072:
        r1 = r2;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzew.zzga():int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzgb() {
        /*
        r10 = this;
        r8 = 0;
        r0 = r10.pos;
        r1 = r10.zzti;
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
        r2 = r10.zzti;
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
        r0 = r10.zzfx();
        goto L_0x0013;
    L_0x00ba:
        r2 = r3;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzew.zzgb():long");
    }

    final long zzfx() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzgf = zzgf();
            j |= ((long) (zzgf & 127)) << i;
            if ((zzgf & 128) == 0) {
                return j;
            }
        }
        throw zzgc.zzhs();
    }

    private final int zzgc() {
        int i = this.pos;
        if (this.zzti - i < 4) {
            zzt(4);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16));
    }

    private final long zzgd() {
        int i = this.pos;
        if (this.zzti - i < 8) {
            zzt(8);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((((((((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8)) | ((((long) bArr[i + 2]) & 255) << 16)) | ((((long) bArr[i + 3]) & 255) << 24)) | ((((long) bArr[i + 4]) & 255) << 32)) | ((((long) bArr[i + 5]) & 255) << 40)) | ((((long) bArr[i + 6]) & 255) << 48));
    }

    public final int zzp(int i) {
        if (i < 0) {
            throw zzgc.zzhr();
        }
        int i2 = (this.zztj + this.pos) + i;
        int i3 = this.zztg;
        if (i2 > i3) {
            throw zzgc.zzhq();
        }
        this.zztg = i2;
        zzge();
        return i3;
    }

    private final void zzge() {
        this.zzti += this.zztd;
        int i = this.zztj + this.zzti;
        if (i > this.zztg) {
            this.zztd = i - this.zztg;
            this.zzti -= this.zztd;
            return;
        }
        this.zztd = 0;
    }

    public final void zzq(int i) {
        this.zztg = i;
        zzge();
    }

    public final boolean zzfy() {
        return this.pos == this.zzti && !zzu(1);
    }

    public final int zzfz() {
        return this.zztj + this.pos;
    }

    private final void zzt(int i) {
        if (!zzu(i)) {
            if (i > (this.zzsz - this.zztj) - this.pos) {
                throw zzgc.zzhw();
            }
            throw zzgc.zzhq();
        }
    }

    private final boolean zzu(int i) {
        while (this.pos + i > this.zzti) {
            if (i > (this.zzsz - this.zztj) - this.pos || (this.zztj + this.pos) + i > this.zztg) {
                return false;
            }
            int i2 = this.pos;
            if (i2 > 0) {
                if (this.zzti > i2) {
                    System.arraycopy(this.buffer, i2, this.buffer, 0, this.zzti - i2);
                }
                this.zztj += i2;
                this.zzti -= i2;
                this.pos = 0;
            }
            i2 = this.zzth.read(this.buffer, this.zzti, Math.min(this.buffer.length - this.zzti, (this.zzsz - this.zztj) - this.zzti));
            if (i2 == 0 || i2 < -1 || i2 > this.buffer.length) {
                String valueOf = String.valueOf(this.zzth.getClass());
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 91).append(valueOf).append("#read(byte[]) returned invalid result: ").append(i2).append("\nThe InputStream implementation is buggy.").toString());
            } else if (i2 <= 0) {
                return false;
            } else {
                this.zzti = i2 + this.zzti;
                zzge();
                if (this.zzti >= i) {
                    return true;
                }
            }
        }
        throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
    }

    private final byte zzgf() {
        if (this.pos == this.zzti) {
            zzt(1);
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    private final byte[] zzv(int i) {
        byte[] zzw = zzw(i);
        if (zzw != null) {
            return zzw;
        }
        int i2 = this.pos;
        int i3 = this.zzti - this.pos;
        this.zztj += this.zzti;
        this.pos = 0;
        this.zzti = 0;
        List<byte[]> zzx = zzx(i - i3);
        Object obj = new byte[i];
        System.arraycopy(this.buffer, i2, obj, 0, i3);
        i2 = i3;
        for (byte[] zzw2 : zzx) {
            System.arraycopy(zzw2, 0, obj, i2, zzw2.length);
            i2 = zzw2.length + i2;
        }
        return obj;
    }

    private final byte[] zzw(int i) {
        if (i == 0) {
            return zzfv.EMPTY_BYTE_ARRAY;
        }
        if (i < 0) {
            throw zzgc.zzhr();
        }
        int i2 = (this.zztj + this.pos) + i;
        if (i2 - this.zzsz > 0) {
            throw zzgc.zzhw();
        } else if (i2 > this.zztg) {
            zzs((this.zztg - this.zztj) - this.pos);
            throw zzgc.zzhq();
        } else {
            i2 = this.zzti - this.pos;
            int i3 = i - i2;
            if (i3 >= 4096 && i3 > this.zzth.available()) {
                return null;
            }
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.pos, obj, 0, i2);
            this.zztj += this.zzti;
            this.pos = 0;
            this.zzti = 0;
            while (i2 < obj.length) {
                int read = this.zzth.read(obj, i2, i - i2);
                if (read == -1) {
                    throw zzgc.zzhq();
                }
                this.zztj += read;
                i2 += read;
            }
            return obj;
        }
    }

    private final List<byte[]> zzx(int i) {
        List<byte[]> arrayList = new ArrayList();
        while (i > 0) {
            Object obj = new byte[Math.min(i, 4096)];
            int i2 = 0;
            while (i2 < obj.length) {
                int read = this.zzth.read(obj, i2, obj.length - i2);
                if (read == -1) {
                    throw zzgc.zzhq();
                }
                this.zztj += read;
                i2 += read;
            }
            i -= obj.length;
            arrayList.add(obj);
        }
        return arrayList;
    }

    private final void zzs(int i) {
        if (i <= this.zzti - this.pos && i >= 0) {
            this.pos += i;
        } else if (i < 0) {
            throw zzgc.zzhr();
        } else if ((this.zztj + this.pos) + i > this.zztg) {
            zzs((this.zztg - this.zztj) - this.pos);
            throw zzgc.zzhq();
        } else {
            this.zztj += this.pos;
            int i2 = this.zzti - this.pos;
            this.zzti = 0;
            this.pos = 0;
            int i3 = i2;
            while (i3 < i) {
                i2 = i - i3;
                try {
                    long skip = this.zzth.skip((long) i2);
                    if (skip < 0 || skip > ((long) i2)) {
                        String valueOf = String.valueOf(this.zzth.getClass());
                        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 92).append(valueOf).append("#skip returned invalid result: ").append(skip).append("\nThe InputStream implementation is buggy.").toString());
                    }
                    i3 = ((int) skip) + i3;
                } catch (Throwable th) {
                    this.zztj = i3 + this.zztj;
                    zzge();
                }
            }
            this.zztj += i3;
            zzge();
        }
    }
}
