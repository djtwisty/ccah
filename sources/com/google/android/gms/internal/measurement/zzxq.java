package com.google.android.gms.internal.measurement;

final class zzxq extends zzxn {
    zzxq() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final int zzb(int r9, byte[] r10, int r11, int r12) {
        /*
        r8 = this;
        r0 = r11 | r12;
        r1 = r10.length;
        r1 = r1 - r12;
        r0 = r0 | r1;
        if (r0 >= 0) goto L_0x002c;
    L_0x0007:
        r0 = new java.lang.ArrayIndexOutOfBoundsException;
        r1 = "Array length=%d, index=%d, limit=%d";
        r2 = 3;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r10.length;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = java.lang.Integer.valueOf(r11);
        r2[r3] = r4;
        r3 = 2;
        r4 = java.lang.Integer.valueOf(r12);
        r2[r3] = r4;
        r1 = java.lang.String.format(r1, r2);
        r0.<init>(r1);
        throw r0;
    L_0x002c:
        r4 = (long) r11;
        r0 = (long) r12;
        r0 = r0 - r4;
        r1 = (int) r0;
        r0 = 16;
        if (r1 >= r0) goto L_0x004a;
    L_0x0034:
        r0 = 0;
    L_0x0035:
        r1 = r1 - r0;
        r2 = (long) r0;
        r2 = r2 + r4;
        r0 = r1;
    L_0x0039:
        r1 = 0;
        r4 = r2;
    L_0x003b:
        if (r0 <= 0) goto L_0x005e;
    L_0x003d:
        r2 = 1;
        r2 = r2 + r4;
        r1 = com.google.android.gms.internal.measurement.zzxj.zza(r10, r4);
        if (r1 < 0) goto L_0x005d;
    L_0x0046:
        r0 = r0 + -1;
        r4 = r2;
        goto L_0x003b;
    L_0x004a:
        r0 = 0;
        r2 = r4;
    L_0x004c:
        if (r0 >= r1) goto L_0x005b;
    L_0x004e:
        r6 = 1;
        r6 = r6 + r2;
        r2 = com.google.android.gms.internal.measurement.zzxj.zza(r10, r2);
        if (r2 < 0) goto L_0x0035;
    L_0x0057:
        r0 = r0 + 1;
        r2 = r6;
        goto L_0x004c;
    L_0x005b:
        r0 = r1;
        goto L_0x0035;
    L_0x005d:
        r4 = r2;
    L_0x005e:
        if (r0 != 0) goto L_0x0062;
    L_0x0060:
        r0 = 0;
    L_0x0061:
        return r0;
    L_0x0062:
        r0 = r0 + -1;
        r2 = -32;
        if (r1 >= r2) goto L_0x007f;
    L_0x0068:
        if (r0 != 0) goto L_0x006c;
    L_0x006a:
        r0 = r1;
        goto L_0x0061;
    L_0x006c:
        r0 = r0 + -1;
        r2 = -62;
        if (r1 < r2) goto L_0x007d;
    L_0x0072:
        r2 = 1;
        r2 = r2 + r4;
        r1 = com.google.android.gms.internal.measurement.zzxj.zza(r10, r4);
        r4 = -65;
        if (r1 <= r4) goto L_0x0039;
    L_0x007d:
        r0 = -1;
        goto L_0x0061;
    L_0x007f:
        r2 = -16;
        if (r1 >= r2) goto L_0x00b6;
    L_0x0083:
        r2 = 2;
        if (r0 >= r2) goto L_0x008b;
    L_0x0086:
        r0 = zza(r10, r1, r4, r0);
        goto L_0x0061;
    L_0x008b:
        r0 = r0 + -2;
        r2 = 1;
        r6 = r4 + r2;
        r2 = com.google.android.gms.internal.measurement.zzxj.zza(r10, r4);
        r3 = -65;
        if (r2 > r3) goto L_0x00b4;
    L_0x0099:
        r3 = -32;
        if (r1 != r3) goto L_0x00a1;
    L_0x009d:
        r3 = -96;
        if (r2 < r3) goto L_0x00b4;
    L_0x00a1:
        r3 = -19;
        if (r1 != r3) goto L_0x00a9;
    L_0x00a5:
        r1 = -96;
        if (r2 >= r1) goto L_0x00b4;
    L_0x00a9:
        r2 = 1;
        r2 = r2 + r6;
        r1 = com.google.android.gms.internal.measurement.zzxj.zza(r10, r6);
        r4 = -65;
        if (r1 <= r4) goto L_0x0039;
    L_0x00b4:
        r0 = -1;
        goto L_0x0061;
    L_0x00b6:
        r2 = 3;
        if (r0 >= r2) goto L_0x00be;
    L_0x00b9:
        r0 = zza(r10, r1, r4, r0);
        goto L_0x0061;
    L_0x00be:
        r0 = r0 + -3;
        r2 = 1;
        r2 = r2 + r4;
        r4 = com.google.android.gms.internal.measurement.zzxj.zza(r10, r4);
        r5 = -65;
        if (r4 > r5) goto L_0x00ea;
    L_0x00cb:
        r1 = r1 << 28;
        r4 = r4 + 112;
        r1 = r1 + r4;
        r1 = r1 >> 30;
        if (r1 != 0) goto L_0x00ea;
    L_0x00d4:
        r4 = 1;
        r4 = r4 + r2;
        r1 = com.google.android.gms.internal.measurement.zzxj.zza(r10, r2);
        r2 = -65;
        if (r1 > r2) goto L_0x00ea;
    L_0x00df:
        r2 = 1;
        r2 = r2 + r4;
        r1 = com.google.android.gms.internal.measurement.zzxj.zza(r10, r4);
        r4 = -65;
        if (r1 <= r4) goto L_0x0039;
    L_0x00ea:
        r0 = -1;
        goto L_0x0061;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzxq.zzb(int, byte[], int, int):int");
    }

    final String zzh(byte[] bArr, int i, int i2) {
        if (((i | i2) | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        int i5 = i;
        while (i5 < i3) {
            byte zza = zzxj.zza(bArr, (long) i5);
            if (!zzxm.zzd(zza)) {
                break;
            }
            i5++;
            int i6 = i4 + 1;
            zzxm.zza(zza, cArr, i4);
            i4 = i6;
        }
        int i7 = i5;
        while (i7 < i3) {
            i5 = i7 + 1;
            byte zza2 = zzxj.zza(bArr, (long) i7);
            if (zzxm.zzd(zza2)) {
                i7 = i4 + 1;
                zzxm.zza(zza2, cArr, i4);
                i6 = i7;
                while (i5 < i3) {
                    byte zza3 = zzxj.zza(bArr, (long) i5);
                    if (!zzxm.zzd(zza3)) {
                        break;
                    }
                    i5++;
                    i7 = i6 + 1;
                    zzxm.zza(zza3, cArr, i6);
                    i6 = i7;
                }
            } else if (zzxm.zze(zza2)) {
                if (i5 >= i3) {
                    throw zzuv.zzwx();
                }
                i7 = i5 + 1;
                i5 = i4 + 1;
                zzxm.zza(zza2, zzxj.zza(bArr, (long) i5), cArr, i4);
                i4 = i5;
            } else if (zzxm.zzf(zza2)) {
                if (i5 >= i3 - 1) {
                    throw zzuv.zzwx();
                }
                r3 = i5 + 1;
                i7 = r3 + 1;
                i5 = i4 + 1;
                zzxm.zza(zza2, zzxj.zza(bArr, (long) i5), zzxj.zza(bArr, (long) r3), cArr, i4);
                i4 = i5;
            } else if (i5 >= i3 - 2) {
                throw zzuv.zzwx();
            } else {
                i7 = i5 + 1;
                r3 = i7 + 1;
                int i8 = r3 + 1;
                int i9 = i4 + 1;
                zzxm.zza(zza2, zzxj.zza(bArr, (long) i5), zzxj.zza(bArr, (long) i7), zzxj.zza(bArr, (long) r3), cArr, i4);
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
            zzxj.zza(bArr, j, (byte) charAt);
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
                zzxj.zza(bArr, j3, (byte) charAt);
            } else if (charAt < 'ࠀ' && j3 <= j2 - 2) {
                r12 = j3 + 1;
                zzxj.zza(bArr, j3, (byte) ((charAt >>> 6) | 960));
                j = 1 + r12;
                zzxj.zza(bArr, r12, (byte) ((charAt & 63) | 128));
            } else if ((charAt < '?' || '?' < charAt) && j3 <= j2 - 3) {
                j = 1 + j3;
                zzxj.zza(bArr, j3, (byte) ((charAt >>> 12) | 480));
                j3 = 1 + j;
                zzxj.zza(bArr, j, (byte) (((charAt >>> 6) & 63) | 128));
                j = 1 + j3;
                zzxj.zza(bArr, j3, (byte) ((charAt & 63) | 128));
            } else if (j3 <= j2 - 4) {
                if (i3 + 1 != length) {
                    i3++;
                    char charAt2 = charSequence.charAt(i3);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int toCodePoint = Character.toCodePoint(charAt, charAt2);
                        j = 1 + j3;
                        zzxj.zza(bArr, j3, (byte) ((toCodePoint >>> 18) | 240));
                        j3 = 1 + j;
                        zzxj.zza(bArr, j, (byte) (((toCodePoint >>> 12) & 63) | 128));
                        r12 = j3 + 1;
                        zzxj.zza(bArr, j3, (byte) (((toCodePoint >>> 6) & 63) | 128));
                        j = 1 + r12;
                        zzxj.zza(bArr, r12, (byte) ((toCodePoint & 63) | 128));
                    }
                }
                throw new zzxp(i3 - 1, length);
            } else if ('?' > charAt || charAt > '?' || (i3 + 1 != length && Character.isSurrogatePair(charAt, charSequence.charAt(i3 + 1)))) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt + " at index " + j3);
            } else {
                throw new zzxp(i3, length);
            }
            i3++;
            j3 = j;
        }
        return (int) j3;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void zzb(java.lang.CharSequence r17, java.nio.ByteBuffer r18) {
        /*
        r16 = this;
        r8 = com.google.android.gms.internal.measurement.zzxj.zzb(r18);
        r2 = r18.position();
        r2 = (long) r2;
        r4 = r8 + r2;
        r2 = r18.limit();
        r2 = (long) r2;
        r10 = r8 + r2;
        r3 = r17.length();
        r6 = (long) r3;
        r12 = r10 - r4;
        r2 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1));
        if (r2 <= 0) goto L_0x004e;
    L_0x001d:
        r2 = new java.lang.ArrayIndexOutOfBoundsException;
        r3 = r3 + -1;
        r0 = r17;
        r3 = r0.charAt(r3);
        r4 = r18.limit();
        r5 = 37;
        r6 = new java.lang.StringBuilder;
        r6.<init>(r5);
        r5 = "Failed writing ";
        r5 = r6.append(r5);
        r3 = r5.append(r3);
        r5 = " at index ";
        r3 = r3.append(r5);
        r3 = r3.append(r4);
        r3 = r3.toString();
        r2.<init>(r3);
        throw r2;
    L_0x004e:
        r2 = 0;
    L_0x004f:
        if (r2 >= r3) goto L_0x0066;
    L_0x0051:
        r0 = r17;
        r12 = r0.charAt(r2);
        r6 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r12 >= r6) goto L_0x0066;
    L_0x005b:
        r6 = 1;
        r6 = r6 + r4;
        r12 = (byte) r12;
        com.google.android.gms.internal.measurement.zzxj.zza(r4, r12);
        r2 = r2 + 1;
        r4 = r6;
        goto L_0x004f;
    L_0x0066:
        if (r2 != r3) goto L_0x0190;
    L_0x0068:
        r2 = r4 - r8;
        r2 = (int) r2;
        r0 = r18;
        r0.position(r2);
    L_0x0070:
        return;
    L_0x0071:
        if (r2 >= r3) goto L_0x0186;
    L_0x0073:
        r0 = r17;
        r12 = r0.charAt(r2);
        r4 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r12 >= r4) goto L_0x008c;
    L_0x007d:
        r4 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r4 >= 0) goto L_0x008c;
    L_0x0081:
        r4 = 1;
        r4 = r4 + r6;
        r12 = (byte) r12;
        com.google.android.gms.internal.measurement.zzxj.zza(r6, r12);
    L_0x0088:
        r2 = r2 + 1;
        r6 = r4;
        goto L_0x0071;
    L_0x008c:
        r4 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        if (r12 >= r4) goto L_0x00b0;
    L_0x0090:
        r4 = 2;
        r4 = r10 - r4;
        r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r4 > 0) goto L_0x00b0;
    L_0x0098:
        r4 = 1;
        r14 = r6 + r4;
        r4 = r12 >>> 6;
        r4 = r4 | 960;
        r4 = (byte) r4;
        com.google.android.gms.internal.measurement.zzxj.zza(r6, r4);
        r4 = 1;
        r4 = r4 + r14;
        r6 = r12 & 63;
        r6 = r6 | 128;
        r6 = (byte) r6;
        com.google.android.gms.internal.measurement.zzxj.zza(r14, r6);
        goto L_0x0088;
    L_0x00b0:
        r4 = 55296; // 0xd800 float:7.7486E-41 double:2.732E-319;
        if (r12 < r4) goto L_0x00ba;
    L_0x00b5:
        r4 = 57343; // 0xdfff float:8.0355E-41 double:2.8331E-319;
        if (r4 >= r12) goto L_0x00e6;
    L_0x00ba:
        r4 = 3;
        r4 = r10 - r4;
        r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r4 > 0) goto L_0x00e6;
    L_0x00c2:
        r4 = 1;
        r4 = r4 + r6;
        r13 = r12 >>> 12;
        r13 = r13 | 480;
        r13 = (byte) r13;
        com.google.android.gms.internal.measurement.zzxj.zza(r6, r13);
        r6 = 1;
        r6 = r6 + r4;
        r13 = r12 >>> 6;
        r13 = r13 & 63;
        r13 = r13 | 128;
        r13 = (byte) r13;
        com.google.android.gms.internal.measurement.zzxj.zza(r4, r13);
        r4 = 1;
        r4 = r4 + r6;
        r12 = r12 & 63;
        r12 = r12 | 128;
        r12 = (byte) r12;
        com.google.android.gms.internal.measurement.zzxj.zza(r6, r12);
        goto L_0x0088;
    L_0x00e6:
        r4 = 4;
        r4 = r10 - r4;
        r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r4 > 0) goto L_0x013f;
    L_0x00ee:
        r4 = r2 + 1;
        if (r4 == r3) goto L_0x0100;
    L_0x00f2:
        r2 = r2 + 1;
        r0 = r17;
        r4 = r0.charAt(r2);
        r5 = java.lang.Character.isSurrogatePair(r12, r4);
        if (r5 != 0) goto L_0x0108;
    L_0x0100:
        r4 = new com.google.android.gms.internal.measurement.zzxp;
        r2 = r2 + -1;
        r4.<init>(r2, r3);
        throw r4;
    L_0x0108:
        r12 = java.lang.Character.toCodePoint(r12, r4);
        r4 = 1;
        r4 = r4 + r6;
        r13 = r12 >>> 18;
        r13 = r13 | 240;
        r13 = (byte) r13;
        com.google.android.gms.internal.measurement.zzxj.zza(r6, r13);
        r6 = 1;
        r6 = r6 + r4;
        r13 = r12 >>> 12;
        r13 = r13 & 63;
        r13 = r13 | 128;
        r13 = (byte) r13;
        com.google.android.gms.internal.measurement.zzxj.zza(r4, r13);
        r4 = 1;
        r14 = r6 + r4;
        r4 = r12 >>> 6;
        r4 = r4 & 63;
        r4 = r4 | 128;
        r4 = (byte) r4;
        com.google.android.gms.internal.measurement.zzxj.zza(r6, r4);
        r4 = 1;
        r4 = r4 + r14;
        r6 = r12 & 63;
        r6 = r6 | 128;
        r6 = (byte) r6;
        com.google.android.gms.internal.measurement.zzxj.zza(r14, r6);
        goto L_0x0088;
    L_0x013f:
        r4 = 55296; // 0xd800 float:7.7486E-41 double:2.732E-319;
        if (r4 > r12) goto L_0x0161;
    L_0x0144:
        r4 = 57343; // 0xdfff float:8.0355E-41 double:2.8331E-319;
        if (r12 > r4) goto L_0x0161;
    L_0x0149:
        r4 = r2 + 1;
        if (r4 == r3) goto L_0x015b;
    L_0x014d:
        r4 = r2 + 1;
        r0 = r17;
        r4 = r0.charAt(r4);
        r4 = java.lang.Character.isSurrogatePair(r12, r4);
        if (r4 != 0) goto L_0x0161;
    L_0x015b:
        r4 = new com.google.android.gms.internal.measurement.zzxp;
        r4.<init>(r2, r3);
        throw r4;
    L_0x0161:
        r2 = new java.lang.ArrayIndexOutOfBoundsException;
        r3 = 46;
        r4 = new java.lang.StringBuilder;
        r4.<init>(r3);
        r3 = "Failed writing ";
        r3 = r4.append(r3);
        r3 = r3.append(r12);
        r4 = " at index ";
        r3 = r3.append(r4);
        r3 = r3.append(r6);
        r3 = r3.toString();
        r2.<init>(r3);
        throw r2;
    L_0x0186:
        r2 = r6 - r8;
        r2 = (int) r2;
        r0 = r18;
        r0.position(r2);
        goto L_0x0070;
    L_0x0190:
        r6 = r4;
        goto L_0x0071;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzxq.zzb(java.lang.CharSequence, java.nio.ByteBuffer):void");
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        switch (i2) {
            case 0:
                return zzxl.zzbz(i);
            case 1:
                return zzxl.zzq(i, zzxj.zza(bArr, j));
            case 2:
                return zzxl.zzc(i, zzxj.zza(bArr, j), zzxj.zza(bArr, 1 + j));
            default:
                throw new AssertionError();
        }
    }
}
