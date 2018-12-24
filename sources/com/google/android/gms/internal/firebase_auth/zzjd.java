package com.google.android.gms.internal.firebase_auth;

final class zzjd extends zzja {
    zzjd() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final int zzb(int r15, byte[] r16, int r17, int r18) {
        /*
        r14 = this;
        r2 = r17 | r18;
        r0 = r16;
        r3 = r0.length;
        r3 = r3 - r18;
        r2 = r2 | r3;
        if (r2 >= 0) goto L_0x0031;
    L_0x000a:
        r2 = new java.lang.ArrayIndexOutOfBoundsException;
        r3 = "Array length=%d, index=%d, limit=%d";
        r4 = 3;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r0 = r16;
        r6 = r0.length;
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 1;
        r6 = java.lang.Integer.valueOf(r17);
        r4[r5] = r6;
        r5 = 2;
        r6 = java.lang.Integer.valueOf(r18);
        r4[r5] = r6;
        r3 = java.lang.String.format(r3, r4);
        r2.<init>(r3);
        throw r2;
    L_0x0031:
        r0 = r17;
        r2 = (long) r0;
        r0 = r18;
        r12 = (long) r0;
        if (r15 == 0) goto L_0x00f3;
    L_0x0039:
        r4 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1));
        if (r4 < 0) goto L_0x003e;
    L_0x003d:
        return r15;
    L_0x003e:
        r11 = (byte) r15;
        r4 = -32;
        if (r11 >= r4) goto L_0x0057;
    L_0x0043:
        r4 = -62;
        if (r11 < r4) goto L_0x0055;
    L_0x0047:
        r4 = 1;
        r6 = r2 + r4;
        r0 = r16;
        r2 = com.google.android.gms.internal.firebase_auth.zziw.zza(r0, r2);
        r3 = -65;
        if (r2 <= r3) goto L_0x00f4;
    L_0x0055:
        r15 = -1;
        goto L_0x003d;
    L_0x0057:
        r4 = -16;
        if (r11 >= r4) goto L_0x009b;
    L_0x005b:
        r4 = r15 >> 8;
        r4 = r4 ^ -1;
        r4 = (byte) r4;
        if (r4 != 0) goto L_0x01d6;
    L_0x0062:
        r4 = 1;
        r6 = r2 + r4;
        r0 = r16;
        r2 = com.google.android.gms.internal.firebase_auth.zziw.zza(r0, r2);
        r3 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1));
        if (r3 < 0) goto L_0x0075;
    L_0x0070:
        r15 = com.google.android.gms.internal.firebase_auth.zziy.zzt(r11, r2);
        goto L_0x003d;
    L_0x0075:
        r4 = r2;
        r8 = r6;
    L_0x0077:
        r2 = -65;
        if (r4 > r2) goto L_0x0099;
    L_0x007b:
        r2 = -32;
        if (r11 != r2) goto L_0x0083;
    L_0x007f:
        r2 = -96;
        if (r4 < r2) goto L_0x0099;
    L_0x0083:
        r2 = -19;
        if (r11 != r2) goto L_0x008b;
    L_0x0087:
        r2 = -96;
        if (r4 >= r2) goto L_0x0099;
    L_0x008b:
        r2 = 1;
        r6 = r8 + r2;
        r0 = r16;
        r2 = com.google.android.gms.internal.firebase_auth.zziw.zza(r0, r8);
        r3 = -65;
        if (r2 <= r3) goto L_0x00f4;
    L_0x0099:
        r15 = -1;
        goto L_0x003d;
    L_0x009b:
        r4 = r15 >> 8;
        r4 = r4 ^ -1;
        r5 = (byte) r4;
        r4 = 0;
        if (r5 != 0) goto L_0x00b5;
    L_0x00a3:
        r6 = 1;
        r6 = r6 + r2;
        r0 = r16;
        r2 = com.google.android.gms.internal.firebase_auth.zziw.zza(r0, r2);
        r3 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1));
        if (r3 < 0) goto L_0x01d3;
    L_0x00b0:
        r15 = com.google.android.gms.internal.firebase_auth.zziy.zzt(r11, r2);
        goto L_0x003d;
    L_0x00b5:
        r4 = r15 >> 16;
        r4 = (byte) r4;
        r10 = r5;
        r6 = r2;
    L_0x00ba:
        if (r4 != 0) goto L_0x01cf;
    L_0x00bc:
        r2 = 1;
        r4 = r6 + r2;
        r0 = r16;
        r2 = com.google.android.gms.internal.firebase_auth.zziw.zza(r0, r6);
        r3 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1));
        if (r3 < 0) goto L_0x00d0;
    L_0x00ca:
        r15 = com.google.android.gms.internal.firebase_auth.zziy.zze(r11, r10, r2);
        goto L_0x003d;
    L_0x00d0:
        r8 = r4;
    L_0x00d1:
        r3 = -65;
        if (r10 > r3) goto L_0x00f0;
    L_0x00d5:
        r3 = r11 << 28;
        r4 = r10 + 112;
        r3 = r3 + r4;
        r3 = r3 >> 30;
        if (r3 != 0) goto L_0x00f0;
    L_0x00de:
        r3 = -65;
        if (r2 > r3) goto L_0x00f0;
    L_0x00e2:
        r2 = 1;
        r6 = r8 + r2;
        r0 = r16;
        r2 = com.google.android.gms.internal.firebase_auth.zziw.zza(r0, r8);
        r3 = -65;
        if (r2 <= r3) goto L_0x00f4;
    L_0x00f0:
        r15 = -1;
        goto L_0x003d;
    L_0x00f3:
        r6 = r2;
    L_0x00f4:
        r2 = r12 - r6;
        r3 = (int) r2;
        r2 = 16;
        if (r3 >= r2) goto L_0x0114;
    L_0x00fb:
        r2 = 0;
    L_0x00fc:
        r3 = r3 - r2;
        r4 = (long) r2;
        r4 = r4 + r6;
        r2 = r3;
    L_0x0100:
        r15 = 0;
        r8 = r2;
    L_0x0102:
        if (r8 <= 0) goto L_0x01cc;
    L_0x0104:
        r2 = 1;
        r2 = r2 + r4;
        r0 = r16;
        r15 = com.google.android.gms.internal.firebase_auth.zziw.zza(r0, r4);
        if (r15 < 0) goto L_0x0129;
    L_0x010f:
        r6 = r8 + -1;
        r8 = r6;
        r4 = r2;
        goto L_0x0102;
    L_0x0114:
        r2 = 0;
        r4 = r6;
    L_0x0116:
        if (r2 >= r3) goto L_0x0127;
    L_0x0118:
        r8 = 1;
        r8 = r8 + r4;
        r0 = r16;
        r4 = com.google.android.gms.internal.firebase_auth.zziw.zza(r0, r4);
        if (r4 < 0) goto L_0x00fc;
    L_0x0123:
        r2 = r2 + 1;
        r4 = r8;
        goto L_0x0116;
    L_0x0127:
        r2 = r3;
        goto L_0x00fc;
    L_0x0129:
        r6 = r2;
    L_0x012a:
        if (r8 != 0) goto L_0x012f;
    L_0x012c:
        r15 = 0;
        goto L_0x003d;
    L_0x012f:
        r2 = r8 + -1;
        r3 = -32;
        if (r15 >= r3) goto L_0x014d;
    L_0x0135:
        if (r2 == 0) goto L_0x003d;
    L_0x0137:
        r2 = r2 + -1;
        r3 = -62;
        if (r15 < r3) goto L_0x014a;
    L_0x013d:
        r4 = 1;
        r4 = r4 + r6;
        r0 = r16;
        r3 = com.google.android.gms.internal.firebase_auth.zziw.zza(r0, r6);
        r6 = -65;
        if (r3 <= r6) goto L_0x0100;
    L_0x014a:
        r15 = -1;
        goto L_0x003d;
    L_0x014d:
        r3 = -16;
        if (r15 >= r3) goto L_0x018c;
    L_0x0151:
        r3 = 2;
        if (r2 >= r3) goto L_0x015c;
    L_0x0154:
        r0 = r16;
        r15 = zza(r0, r15, r6, r2);
        goto L_0x003d;
    L_0x015c:
        r2 = r2 + -2;
        r4 = 1;
        r8 = r6 + r4;
        r0 = r16;
        r3 = com.google.android.gms.internal.firebase_auth.zziw.zza(r0, r6);
        r4 = -65;
        if (r3 > r4) goto L_0x0189;
    L_0x016c:
        r4 = -32;
        if (r15 != r4) goto L_0x0174;
    L_0x0170:
        r4 = -96;
        if (r3 < r4) goto L_0x0189;
    L_0x0174:
        r4 = -19;
        if (r15 != r4) goto L_0x017c;
    L_0x0178:
        r4 = -96;
        if (r3 >= r4) goto L_0x0189;
    L_0x017c:
        r4 = 1;
        r4 = r4 + r8;
        r0 = r16;
        r3 = com.google.android.gms.internal.firebase_auth.zziw.zza(r0, r8);
        r6 = -65;
        if (r3 <= r6) goto L_0x0100;
    L_0x0189:
        r15 = -1;
        goto L_0x003d;
    L_0x018c:
        r3 = 3;
        if (r2 >= r3) goto L_0x0197;
    L_0x018f:
        r0 = r16;
        r15 = zza(r0, r15, r6, r2);
        goto L_0x003d;
    L_0x0197:
        r2 = r2 + -3;
        r4 = 1;
        r4 = r4 + r6;
        r0 = r16;
        r3 = com.google.android.gms.internal.firebase_auth.zziw.zza(r0, r6);
        r6 = -65;
        if (r3 > r6) goto L_0x01c9;
    L_0x01a6:
        r6 = r15 << 28;
        r3 = r3 + 112;
        r3 = r3 + r6;
        r3 = r3 >> 30;
        if (r3 != 0) goto L_0x01c9;
    L_0x01af:
        r6 = 1;
        r6 = r6 + r4;
        r0 = r16;
        r3 = com.google.android.gms.internal.firebase_auth.zziw.zza(r0, r4);
        r4 = -65;
        if (r3 > r4) goto L_0x01c9;
    L_0x01bc:
        r4 = 1;
        r4 = r4 + r6;
        r0 = r16;
        r3 = com.google.android.gms.internal.firebase_auth.zziw.zza(r0, r6);
        r6 = -65;
        if (r3 <= r6) goto L_0x0100;
    L_0x01c9:
        r15 = -1;
        goto L_0x003d;
    L_0x01cc:
        r6 = r4;
        goto L_0x012a;
    L_0x01cf:
        r2 = r4;
        r8 = r6;
        goto L_0x00d1;
    L_0x01d3:
        r10 = r2;
        goto L_0x00ba;
    L_0x01d6:
        r8 = r2;
        goto L_0x0077;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzjd.zzb(int, byte[], int, int):int");
    }

    final String zzg(byte[] bArr, int i, int i2) {
        if (((i | i2) | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        int i5 = i;
        while (i5 < i3) {
            byte zza = zziw.zza(bArr, (long) i5);
            if (!zziz.zzd(zza)) {
                break;
            }
            i5++;
            int i6 = i4 + 1;
            zziz.zza(zza, cArr, i4);
            i4 = i6;
        }
        int i7 = i5;
        while (i7 < i3) {
            i5 = i7 + 1;
            byte zza2 = zziw.zza(bArr, (long) i7);
            if (zziz.zzd(zza2)) {
                i7 = i4 + 1;
                zziz.zza(zza2, cArr, i4);
                i6 = i7;
                while (i5 < i3) {
                    byte zza3 = zziw.zza(bArr, (long) i5);
                    if (!zziz.zzd(zza3)) {
                        break;
                    }
                    i5++;
                    i7 = i6 + 1;
                    zziz.zza(zza3, cArr, i6);
                    i6 = i7;
                }
            } else if (zziz.zze(zza2)) {
                if (i5 >= i3) {
                    throw zzgc.zzhy();
                }
                i7 = i5 + 1;
                i5 = i4 + 1;
                zziz.zza(zza2, zziw.zza(bArr, (long) i5), cArr, i4);
                i4 = i5;
            } else if (zziz.zzf(zza2)) {
                if (i5 >= i3 - 1) {
                    throw zzgc.zzhy();
                }
                r3 = i5 + 1;
                i7 = r3 + 1;
                i5 = i4 + 1;
                zziz.zza(zza2, zziw.zza(bArr, (long) i5), zziw.zza(bArr, (long) r3), cArr, i4);
                i4 = i5;
            } else if (i5 >= i3 - 2) {
                throw zzgc.zzhy();
            } else {
                i7 = i5 + 1;
                r3 = i7 + 1;
                int i8 = r3 + 1;
                int i9 = i4 + 1;
                zziz.zza(zza2, zziw.zza(bArr, (long) i5), zziw.zza(bArr, (long) i7), zziw.zza(bArr, (long) r3), cArr, i4);
                i6 = i9 + 1;
                i5 = i8;
            }
            i4 = i6;
            i7 = i5;
        }
        return new String(cArr, 0, i4);
    }

    final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j = (long) i;
        long j2 = j + ((long) i2);
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i + i2));
        }
        int i3 = 0;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt >= '') {
                break;
            }
            long j3 = 1 + j;
            zziw.zza(bArr, j, (byte) charAt);
            i3++;
            j = j3;
        }
        if (i3 == length) {
            return (int) j;
        }
        j3 = j;
        while (i3 < length) {
            charAt = charSequence.charAt(i3);
            if (charAt < '' && j3 < j2) {
                j = 1 + j3;
                zziw.zza(bArr, j3, (byte) charAt);
            } else if (charAt < 'ࠀ' && j3 <= j2 - 2) {
                r12 = j3 + 1;
                zziw.zza(bArr, j3, (byte) ((charAt >>> 6) | 960));
                j = 1 + r12;
                zziw.zza(bArr, r12, (byte) ((charAt & 63) | 128));
            } else if ((charAt < '?' || '?' < charAt) && j3 <= j2 - 3) {
                j = 1 + j3;
                zziw.zza(bArr, j3, (byte) ((charAt >>> 12) | 480));
                j3 = 1 + j;
                zziw.zza(bArr, j, (byte) (((charAt >>> 6) & 63) | 128));
                j = 1 + j3;
                zziw.zza(bArr, j3, (byte) ((charAt & 63) | 128));
            } else if (j3 <= j2 - 4) {
                if (i3 + 1 != length) {
                    i3++;
                    char charAt2 = charSequence.charAt(i3);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int toCodePoint = Character.toCodePoint(charAt, charAt2);
                        j = 1 + j3;
                        zziw.zza(bArr, j3, (byte) ((toCodePoint >>> 18) | 240));
                        j3 = 1 + j;
                        zziw.zza(bArr, j, (byte) (((toCodePoint >>> 12) & 63) | 128));
                        r12 = j3 + 1;
                        zziw.zza(bArr, j3, (byte) (((toCodePoint >>> 6) & 63) | 128));
                        j = 1 + r12;
                        zziw.zza(bArr, r12, (byte) ((toCodePoint & 63) | 128));
                    }
                }
                throw new zzjc(i3 - 1, length);
            } else if ('?' > charAt || charAt > '?' || (i3 + 1 != length && Character.isSurrogatePair(charAt, charSequence.charAt(i3 + 1)))) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt + " at index " + j3);
            } else {
                throw new zzjc(i3, length);
            }
            i3++;
            j3 = j;
        }
        return (int) j3;
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        switch (i2) {
            case 0:
                return zziy.zzbe(i);
            case 1:
                return zziy.zzt(i, zziw.zza(bArr, j));
            case 2:
                return zziy.zze(i, zziw.zza(bArr, j), zziw.zza(bArr, 1 + j));
            default:
                throw new AssertionError();
        }
    }
}
