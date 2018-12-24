package com.google.zxing.oned;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public final class Code128Reader extends OneDReader {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    static final int[][] CODE_PATTERNS = new int[][]{new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};
    private static final int CODE_SHIFT = 98;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final float MAX_AVG_VARIANCE = 0.25f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;

    private static int[] findStartPattern(BitArray bitArray) {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        Object obj = new int[6];
        int length = obj.length;
        int i = nextSet;
        int i2 = 0;
        int i3 = nextSet;
        int i4 = 0;
        while (i < size) {
            int i5;
            int i6;
            if ((bitArray.get(i) ^ i2) != 0) {
                obj[i4] = obj[i4] + 1;
                i5 = i2;
                i6 = i4;
            } else {
                if (i4 == length - 1) {
                    float f = MAX_AVG_VARIANCE;
                    nextSet = -1;
                    i6 = CODE_START_A;
                    while (i6 <= CODE_START_C) {
                        float patternMatchVariance = OneDReader.patternMatchVariance(obj, CODE_PATTERNS[i6], MAX_INDIVIDUAL_VARIANCE);
                        if (patternMatchVariance < f) {
                            nextSet = i6;
                        } else {
                            patternMatchVariance = f;
                        }
                        i6++;
                        f = patternMatchVariance;
                    }
                    if (nextSet < 0 || !bitArray.isRange(Math.max(0, i3 - ((i - i3) / 2)), i3, false)) {
                        nextSet = (obj[0] + obj[1]) + i3;
                        System.arraycopy(obj, 2, obj, 0, length - 2);
                        obj[length - 2] = null;
                        obj[length - 1] = null;
                        i6 = i4 - 1;
                    } else {
                        return new int[]{i3, i, nextSet};
                    }
                }
                i6 = i4 + 1;
                nextSet = i3;
                obj[i6] = 1;
                if (i2 == 0) {
                    i5 = 1;
                } else {
                    boolean z = false;
                }
                i3 = nextSet;
            }
            i++;
            i2 = i5;
            i4 = i6;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int decodeCode(BitArray bitArray, int[] iArr, int i) {
        OneDReader.recordPattern(bitArray, i, iArr);
        float f = MAX_AVG_VARIANCE;
        int i2 = -1;
        for (int i3 = 0; i3 < CODE_PATTERNS.length; i3++) {
            float patternMatchVariance = OneDReader.patternMatchVariance(iArr, CODE_PATTERNS[i3], MAX_INDIVIDUAL_VARIANCE);
            if (patternMatchVariance < f) {
                i2 = i3;
                f = patternMatchVariance;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.Result decodeRow(int r25, com.google.zxing.common.BitArray r26, java.util.Map<com.google.zxing.DecodeHintType, ?> r27) {
        /*
        r24 = this;
        if (r27 == 0) goto L_0x002f;
    L_0x0002:
        r2 = com.google.zxing.DecodeHintType.ASSUME_GS1;
        r0 = r27;
        r2 = r0.containsKey(r2);
        if (r2 == 0) goto L_0x002f;
    L_0x000c:
        r2 = 1;
    L_0x000d:
        r20 = findStartPattern(r26);
        r3 = 2;
        r5 = r20[r3];
        r21 = new java.util.ArrayList;
        r3 = 20;
        r0 = r21;
        r0.<init>(r3);
        r3 = (byte) r5;
        r3 = java.lang.Byte.valueOf(r3);
        r0 = r21;
        r0.add(r3);
        switch(r5) {
            case 103: goto L_0x0031;
            case 104: goto L_0x0094;
            case 105: goto L_0x0097;
            default: goto L_0x002a;
        };
    L_0x002a:
        r2 = com.google.zxing.FormatException.getFormatInstance();
        throw r2;
    L_0x002f:
        r2 = 0;
        goto L_0x000d;
    L_0x0031:
        r3 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
    L_0x0033:
        r9 = 0;
        r16 = 0;
        r22 = new java.lang.StringBuilder;
        r4 = 20;
        r0 = r22;
        r0.<init>(r4);
        r4 = 0;
        r13 = r20[r4];
        r4 = 1;
        r14 = r20[r4];
        r4 = 6;
        r0 = new int[r4];
        r23 = r0;
        r12 = 0;
        r8 = 0;
        r4 = 0;
        r11 = 1;
        r7 = 0;
        r6 = 0;
        r15 = r8;
        r17 = r12;
        r18 = r13;
        r19 = r16;
        r10 = r3;
    L_0x0058:
        if (r9 != 0) goto L_0x0200;
    L_0x005a:
        r8 = 0;
        r0 = r26;
        r1 = r23;
        r16 = decodeCode(r0, r1, r14);
        r0 = r16;
        r3 = (byte) r0;
        r3 = java.lang.Byte.valueOf(r3);
        r0 = r21;
        r0.add(r3);
        r3 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        r0 = r16;
        if (r0 == r3) goto L_0x0076;
    L_0x0075:
        r11 = 1;
    L_0x0076:
        r3 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        r0 = r16;
        if (r0 == r3) goto L_0x02b3;
    L_0x007c:
        r3 = r4 + 1;
        r4 = r3 * r16;
        r4 = r4 + r5;
        r5 = r4;
    L_0x0082:
        r0 = r23;
        r0 = r0.length;
        r17 = r0;
        r4 = 0;
        r13 = r14;
    L_0x0089:
        r0 = r17;
        if (r4 >= r0) goto L_0x009a;
    L_0x008d:
        r12 = r23[r4];
        r12 = r12 + r13;
        r4 = r4 + 1;
        r13 = r12;
        goto L_0x0089;
    L_0x0094:
        r3 = 100;
        goto L_0x0033;
    L_0x0097:
        r3 = 99;
        goto L_0x0033;
    L_0x009a:
        switch(r16) {
            case 103: goto L_0x00b6;
            case 104: goto L_0x00b6;
            case 105: goto L_0x00b6;
            default: goto L_0x009d;
        };
    L_0x009d:
        switch(r10) {
            case 99: goto L_0x01a2;
            case 100: goto L_0x0141;
            case 101: goto L_0x00bb;
            default: goto L_0x00a0;
        };
    L_0x00a0:
        r12 = r8;
    L_0x00a1:
        if (r19 == 0) goto L_0x02aa;
    L_0x00a3:
        r4 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r10 != r4) goto L_0x01fc;
    L_0x00a7:
        r4 = 100;
    L_0x00a9:
        r8 = r4;
    L_0x00aa:
        r4 = r3;
        r17 = r15;
        r18 = r14;
        r19 = r12;
        r10 = r8;
        r14 = r13;
        r15 = r16;
        goto L_0x0058;
    L_0x00b6:
        r2 = com.google.zxing.FormatException.getFormatInstance();
        throw r2;
    L_0x00bb:
        r4 = 64;
        r0 = r16;
        if (r0 >= r4) goto L_0x00d9;
    L_0x00c1:
        if (r6 != r7) goto L_0x00ce;
    L_0x00c3:
        r4 = r16 + 32;
        r4 = (char) r4;
        r0 = r22;
        r0.append(r4);
    L_0x00cb:
        r6 = 0;
        r12 = r8;
        goto L_0x00a1;
    L_0x00ce:
        r4 = r16 + 32;
        r4 = r4 + 128;
        r4 = (char) r4;
        r0 = r22;
        r0.append(r4);
        goto L_0x00cb;
    L_0x00d9:
        r4 = 96;
        r0 = r16;
        if (r0 >= r4) goto L_0x00f5;
    L_0x00df:
        if (r6 != r7) goto L_0x00ec;
    L_0x00e1:
        r4 = r16 + -64;
        r4 = (char) r4;
        r0 = r22;
        r0.append(r4);
    L_0x00e9:
        r6 = 0;
        r12 = r8;
        goto L_0x00a1;
    L_0x00ec:
        r4 = r16 + 64;
        r4 = (char) r4;
        r0 = r22;
        r0.append(r4);
        goto L_0x00e9;
    L_0x00f5:
        r4 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        r0 = r16;
        if (r0 == r4) goto L_0x00fc;
    L_0x00fb:
        r11 = 0;
    L_0x00fc:
        switch(r16) {
            case 96: goto L_0x011d;
            case 97: goto L_0x011d;
            case 98: goto L_0x0131;
            case 99: goto L_0x013a;
            case 100: goto L_0x0136;
            case 101: goto L_0x011f;
            case 102: goto L_0x0103;
            case 103: goto L_0x00ff;
            case 104: goto L_0x00ff;
            case 105: goto L_0x00ff;
            case 106: goto L_0x013e;
            default: goto L_0x00ff;
        };
    L_0x00ff:
        r4 = r6;
    L_0x0100:
        r6 = r4;
        r12 = r8;
        goto L_0x00a1;
    L_0x0103:
        if (r2 == 0) goto L_0x00ff;
    L_0x0105:
        r4 = r22.length();
        if (r4 != 0) goto L_0x0114;
    L_0x010b:
        r4 = "]C1";
        r0 = r22;
        r0.append(r4);
        r4 = r6;
        goto L_0x0100;
    L_0x0114:
        r4 = 29;
        r0 = r22;
        r0.append(r4);
        r4 = r6;
        goto L_0x0100;
    L_0x011d:
        r4 = r6;
        goto L_0x0100;
    L_0x011f:
        if (r7 != 0) goto L_0x0127;
    L_0x0121:
        if (r6 == 0) goto L_0x0127;
    L_0x0123:
        r6 = 1;
        r4 = 0;
        r7 = r6;
        goto L_0x0100;
    L_0x0127:
        if (r7 == 0) goto L_0x012f;
    L_0x0129:
        if (r6 == 0) goto L_0x012f;
    L_0x012b:
        r6 = 0;
        r4 = 0;
        r7 = r6;
        goto L_0x0100;
    L_0x012f:
        r4 = 1;
        goto L_0x0100;
    L_0x0131:
        r8 = 1;
        r10 = 100;
        r4 = r6;
        goto L_0x0100;
    L_0x0136:
        r10 = 100;
        r4 = r6;
        goto L_0x0100;
    L_0x013a:
        r10 = 99;
        r4 = r6;
        goto L_0x0100;
    L_0x013e:
        r9 = 1;
        r4 = r6;
        goto L_0x0100;
    L_0x0141:
        r4 = 96;
        r0 = r16;
        if (r0 >= r4) goto L_0x0160;
    L_0x0147:
        if (r6 != r7) goto L_0x0155;
    L_0x0149:
        r4 = r16 + 32;
        r4 = (char) r4;
        r0 = r22;
        r0.append(r4);
    L_0x0151:
        r6 = 0;
        r12 = r8;
        goto L_0x00a1;
    L_0x0155:
        r4 = r16 + 32;
        r4 = r4 + 128;
        r4 = (char) r4;
        r0 = r22;
        r0.append(r4);
        goto L_0x0151;
    L_0x0160:
        r4 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        r0 = r16;
        if (r0 == r4) goto L_0x02b0;
    L_0x0166:
        r4 = 0;
    L_0x0167:
        switch(r16) {
            case 96: goto L_0x016a;
            case 97: goto L_0x016a;
            case 98: goto L_0x0196;
            case 99: goto L_0x019d;
            case 100: goto L_0x0186;
            case 101: goto L_0x019a;
            case 102: goto L_0x016e;
            case 103: goto L_0x016a;
            case 104: goto L_0x016a;
            case 105: goto L_0x016a;
            case 106: goto L_0x01a0;
            default: goto L_0x016a;
        };
    L_0x016a:
        r11 = r4;
        r12 = r8;
        goto L_0x00a1;
    L_0x016e:
        if (r2 == 0) goto L_0x016a;
    L_0x0170:
        r11 = r22.length();
        if (r11 != 0) goto L_0x017e;
    L_0x0176:
        r11 = "]C1";
        r0 = r22;
        r0.append(r11);
        goto L_0x016a;
    L_0x017e:
        r11 = 29;
        r0 = r22;
        r0.append(r11);
        goto L_0x016a;
    L_0x0186:
        if (r7 != 0) goto L_0x018d;
    L_0x0188:
        if (r6 == 0) goto L_0x018d;
    L_0x018a:
        r7 = 1;
        r6 = 0;
        goto L_0x016a;
    L_0x018d:
        if (r7 == 0) goto L_0x0194;
    L_0x018f:
        if (r6 == 0) goto L_0x0194;
    L_0x0191:
        r7 = 0;
        r6 = 0;
        goto L_0x016a;
    L_0x0194:
        r6 = 1;
        goto L_0x016a;
    L_0x0196:
        r8 = 1;
        r10 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        goto L_0x016a;
    L_0x019a:
        r10 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        goto L_0x016a;
    L_0x019d:
        r10 = 99;
        goto L_0x016a;
    L_0x01a0:
        r9 = 1;
        goto L_0x016a;
    L_0x01a2:
        r4 = 100;
        r0 = r16;
        if (r0 >= r4) goto L_0x01bf;
    L_0x01a8:
        r4 = 10;
        r0 = r16;
        if (r0 >= r4) goto L_0x01b5;
    L_0x01ae:
        r4 = 48;
        r0 = r22;
        r0.append(r4);
    L_0x01b5:
        r0 = r22;
        r1 = r16;
        r0.append(r1);
        r12 = r8;
        goto L_0x00a1;
    L_0x01bf:
        r4 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        r0 = r16;
        if (r0 == r4) goto L_0x02ad;
    L_0x01c5:
        r4 = 0;
    L_0x01c6:
        switch(r16) {
            case 100: goto L_0x01f1;
            case 101: goto L_0x01eb;
            case 102: goto L_0x01cd;
            case 103: goto L_0x01c9;
            case 104: goto L_0x01c9;
            case 105: goto L_0x01c9;
            case 106: goto L_0x01f7;
            default: goto L_0x01c9;
        };
    L_0x01c9:
        r11 = r4;
        r12 = r8;
        goto L_0x00a1;
    L_0x01cd:
        if (r2 == 0) goto L_0x01c9;
    L_0x01cf:
        r11 = r22.length();
        if (r11 != 0) goto L_0x01e0;
    L_0x01d5:
        r11 = "]C1";
        r0 = r22;
        r0.append(r11);
        r11 = r4;
        r12 = r8;
        goto L_0x00a1;
    L_0x01e0:
        r11 = 29;
        r0 = r22;
        r0.append(r11);
        r11 = r4;
        r12 = r8;
        goto L_0x00a1;
    L_0x01eb:
        r10 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r11 = r4;
        r12 = r8;
        goto L_0x00a1;
    L_0x01f1:
        r10 = 100;
        r11 = r4;
        r12 = r8;
        goto L_0x00a1;
    L_0x01f7:
        r9 = 1;
        r11 = r4;
        r12 = r8;
        goto L_0x00a1;
    L_0x01fc:
        r4 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        goto L_0x00a9;
    L_0x0200:
        r2 = r14 - r18;
        r0 = r26;
        r3 = r0.getNextUnset(r14);
        r6 = r26.getSize();
        r7 = r3 - r18;
        r7 = r7 / 2;
        r7 = r7 + r3;
        r6 = java.lang.Math.min(r6, r7);
        r7 = 0;
        r0 = r26;
        r3 = r0.isRange(r3, r6, r7);
        if (r3 != 0) goto L_0x0223;
    L_0x021e:
        r2 = com.google.zxing.NotFoundException.getNotFoundInstance();
        throw r2;
    L_0x0223:
        r3 = r4 * r17;
        r3 = r5 - r3;
        r3 = r3 % 103;
        r0 = r17;
        if (r3 == r0) goto L_0x0232;
    L_0x022d:
        r2 = com.google.zxing.ChecksumException.getChecksumInstance();
        throw r2;
    L_0x0232:
        r3 = r22.length();
        if (r3 != 0) goto L_0x023d;
    L_0x0238:
        r2 = com.google.zxing.NotFoundException.getNotFoundInstance();
        throw r2;
    L_0x023d:
        if (r3 <= 0) goto L_0x024c;
    L_0x023f:
        if (r11 == 0) goto L_0x024c;
    L_0x0241:
        r4 = 99;
        if (r10 != r4) goto L_0x027d;
    L_0x0245:
        r4 = r3 + -2;
        r0 = r22;
        r0.delete(r4, r3);
    L_0x024c:
        r3 = 1;
        r3 = r20[r3];
        r4 = 0;
        r4 = r20[r4];
        r3 = r3 + r4;
        r3 = (float) r3;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r4 = r3 / r4;
        r0 = r18;
        r3 = (float) r0;
        r2 = (float) r2;
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 / r5;
        r5 = r3 + r2;
        r6 = r21.size();
        r7 = new byte[r6];
        r2 = 0;
        r3 = r2;
    L_0x0269:
        if (r3 >= r6) goto L_0x0285;
    L_0x026b:
        r0 = r21;
        r2 = r0.get(r3);
        r2 = (java.lang.Byte) r2;
        r2 = r2.byteValue();
        r7[r3] = r2;
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x0269;
    L_0x027d:
        r4 = r3 + -1;
        r0 = r22;
        r0.delete(r4, r3);
        goto L_0x024c;
    L_0x0285:
        r2 = new com.google.zxing.Result;
        r3 = r22.toString();
        r6 = 2;
        r6 = new com.google.zxing.ResultPoint[r6];
        r8 = 0;
        r9 = new com.google.zxing.ResultPoint;
        r0 = r25;
        r10 = (float) r0;
        r9.<init>(r4, r10);
        r6[r8] = r9;
        r4 = 1;
        r8 = new com.google.zxing.ResultPoint;
        r0 = r25;
        r9 = (float) r0;
        r8.<init>(r5, r9);
        r6[r4] = r8;
        r4 = com.google.zxing.BarcodeFormat.CODE_128;
        r2.<init>(r3, r7, r6, r4);
        return r2;
    L_0x02aa:
        r8 = r10;
        goto L_0x00aa;
    L_0x02ad:
        r4 = r11;
        goto L_0x01c6;
    L_0x02b0:
        r4 = r11;
        goto L_0x0167;
    L_0x02b3:
        r3 = r4;
        goto L_0x0082;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Reader.decodeRow(int, com.google.zxing.common.BitArray, java.util.Map):com.google.zxing.Result");
    }
}
