package com.google.android.gms.internal.firebase_auth;

final class zziy {
    private static final zzja zzacq;

    public static boolean zzd(byte[] bArr) {
        return zzacq.zze(bArr, 0, bArr.length);
    }

    public static boolean zze(byte[] bArr, int i, int i2) {
        return zzacq.zze(bArr, i, i2);
    }

    public static int zzb(int i, byte[] bArr, int i2, int i3) {
        return zzacq.zzb(i, bArr, i2, i3);
    }

    private static int zzbe(int i) {
        return i > -12 ? -1 : i;
    }

    private static int zzt(int i, int i2) {
        return (i > -12 || i2 > -65) ? -1 : (i2 << 8) ^ i;
    }

    private static int zze(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return ((i2 << 8) ^ i) ^ (i3 << 16);
    }

    private static int zzf(byte[] bArr, int i, int i2) {
        int i3 = bArr[i - 1];
        switch (i2 - i) {
            case 0:
                return zzbe(i3);
            case 1:
                return zzt(i3, bArr[i]);
            case 2:
                return zze(i3, bArr[i], bArr[i + 1]);
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
                                throw new zzjc(i2, length2);
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
        return zzacq.zzb(charSequence, bArr, i, i2);
    }

    static String zzg(byte[] bArr, int i, int i2) {
        return zzacq.zzg(bArr, i, i2);
    }

    static {
        zzja zzjb;
        Object obj = (zziw.zzjs() && zziw.zzjt()) ? 1 : null;
        if (obj == null || zzee.zzex()) {
            zzjb = new zzjb();
        } else {
            zzjb = new zzjd();
        }
        zzacq = zzjb;
    }
}
