package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;

final class zzxl {
    private static final zzxn zzcdg;

    public static boolean zzl(byte[] bArr) {
        return zzcdg.zzf(bArr, 0, bArr.length);
    }

    public static boolean zzf(byte[] bArr, int i, int i2) {
        return zzcdg.zzf(bArr, i, i2);
    }

    private static int zzbz(int i) {
        return i > -12 ? -1 : i;
    }

    private static int zzq(int i, int i2) {
        return (i > -12 || i2 > -65) ? -1 : (i2 << 8) ^ i;
    }

    private static int zzc(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return ((i2 << 8) ^ i) ^ (i3 << 16);
    }

    private static int zzg(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        switch (i2 - i) {
            case 0:
                return zzbz(b);
            case 1:
                return zzq(b, bArr[i]);
            case 2:
                return zzc(b, bArr[i], bArr[i + 1]);
            default:
                throw new AssertionError();
        }
    }

    static int zza(CharSequence charSequence) {
        int i = 0;
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < '') {
            i2++;
        }
        int i3 = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt < 'ࠀ') {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 'ࠀ') {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if ('?' <= charAt2 && charAt2 <= '?') {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                throw new zzxp(i2, length2);
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i2 = i3 + i;
                if (i2 < length) {
                    return i2;
                }
                throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i2) + 4294967296L));
            }
        }
        i2 = i3;
        if (i2 < length) {
            return i2;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i2) + 4294967296L));
    }

    static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return zzcdg.zzb(charSequence, bArr, i, i2);
    }

    static String zzh(byte[] bArr, int i, int i2) {
        return zzcdg.zzh(bArr, i, i2);
    }

    static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        zzxn zzxn = zzcdg;
        if (byteBuffer.hasArray()) {
            int arrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(zza(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
        } else if (byteBuffer.isDirect()) {
            zzxn.zzb(charSequence, byteBuffer);
        } else {
            zzxn.zzc(charSequence, byteBuffer);
        }
    }

    static {
        zzxn zzxo;
        Object obj = (zzxj.zzyo() && zzxj.zzyp()) ? 1 : null;
        if (obj == null || zztb.zzub()) {
            zzxo = new zzxo();
        } else {
            zzxo = new zzxq();
        }
        zzcdg = zzxo;
    }
}
