package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

final class DecodedBitStreamParser {
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final Charset DEFAULT_ENCODING = Charset.forName("ISO-8859-1");
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final BigInteger[] EXP900 = new BigInteger[16];
    private static final int LL = 27;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final char[] MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;

    private enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        EXP900[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        EXP900[1] = valueOf;
        for (int i = 2; i < EXP900.length; i++) {
            EXP900[i] = EXP900[i - 1].multiply(valueOf);
        }
    }

    private DecodedBitStreamParser() {
    }

    static DecoderResult decode(int[] iArr, String str) {
        StringBuilder stringBuilder = new StringBuilder(iArr.length * 2);
        Charset charset = DEFAULT_ENCODING;
        int i = 2;
        int i2 = iArr[1];
        PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
        while (i < iArr[0]) {
            switch (i2) {
                case TEXT_COMPACTION_MODE_LATCH /*900*/:
                    i2 = textCompaction(iArr, i, stringBuilder);
                    break;
                case BYTE_COMPACTION_MODE_LATCH /*901*/:
                case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                    i2 = byteCompaction(i2, iArr, charset, i, stringBuilder);
                    break;
                case NUMERIC_COMPACTION_MODE_LATCH /*902*/:
                    i2 = numericCompaction(iArr, i, stringBuilder);
                    break;
                case MODE_SHIFT_TO_BYTE_COMPACTION_MODE /*913*/:
                    i2 = i + 1;
                    stringBuilder.append((char) iArr[i]);
                    break;
                case MACRO_PDF417_TERMINATOR /*922*/:
                case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                    throw FormatException.getFormatInstance();
                case ECI_USER_DEFINED /*925*/:
                    i2 = i + 1;
                    break;
                case ECI_GENERAL_PURPOSE /*926*/:
                    i2 = i + 2;
                    break;
                case ECI_CHARSET /*927*/:
                    i2 = i + 1;
                    charset = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(iArr[i]).name());
                    break;
                case 928:
                    i2 = decodeMacroBlock(iArr, i, pDF417ResultMetadata);
                    break;
                default:
                    i2 = textCompaction(iArr, i - 1, stringBuilder);
                    break;
            }
            if (i2 < iArr.length) {
                i = i2 + 1;
                i2 = iArr[i2];
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (stringBuilder.length() == 0) {
            throw FormatException.getFormatInstance();
        }
        DecoderResult decoderResult = new DecoderResult(null, stringBuilder.toString(), null, str);
        decoderResult.setOther(pDF417ResultMetadata);
        return decoderResult;
    }

    private static int decodeMacroBlock(int[] iArr, int i, PDF417ResultMetadata pDF417ResultMetadata) {
        if (i + 2 > iArr[0]) {
            throw FormatException.getFormatInstance();
        }
        int[] iArr2 = new int[2];
        int i2 = 0;
        while (i2 < 2) {
            iArr2[i2] = iArr[i];
            i2++;
            i++;
        }
        pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
        StringBuilder stringBuilder = new StringBuilder();
        int textCompaction = textCompaction(iArr, i, stringBuilder);
        pDF417ResultMetadata.setFileId(stringBuilder.toString());
        if (iArr[textCompaction] == BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
            textCompaction++;
            int[] iArr3 = new int[(iArr[0] - textCompaction)];
            i2 = 0;
            int i3 = 0;
            while (textCompaction < iArr[0] && r0 == 0) {
                int i4 = textCompaction + 1;
                textCompaction = iArr[textCompaction];
                if (textCompaction < TEXT_COMPACTION_MODE_LATCH) {
                    int i5 = i3 + 1;
                    iArr3[i3] = textCompaction;
                    i3 = i5;
                    textCompaction = i4;
                } else {
                    switch (textCompaction) {
                        case MACRO_PDF417_TERMINATOR /*922*/:
                            pDF417ResultMetadata.setLastSegment(true);
                            textCompaction = i4 + 1;
                            i2 = true;
                            break;
                        default:
                            throw FormatException.getFormatInstance();
                    }
                }
            }
            pDF417ResultMetadata.setOptionalData(Arrays.copyOf(iArr3, i3));
            return textCompaction;
        } else if (iArr[textCompaction] != MACRO_PDF417_TERMINATOR) {
            return textCompaction;
        } else {
            pDF417ResultMetadata.setLastSegment(true);
            return textCompaction + 1;
        }
    }

    private static int textCompaction(int[] iArr, int i, StringBuilder stringBuilder) {
        int[] iArr2 = new int[((iArr[0] - i) * 2)];
        int[] iArr3 = new int[((iArr[0] - i) * 2)];
        int i2 = 0;
        int i3 = 0;
        while (i < iArr[0] && r0 == 0) {
            int i4 = i + 1;
            int i5 = iArr[i];
            if (i5 >= TEXT_COMPACTION_MODE_LATCH) {
                switch (i5) {
                    case TEXT_COMPACTION_MODE_LATCH /*900*/:
                        i5 = i3 + 1;
                        iArr2[i3] = TEXT_COMPACTION_MODE_LATCH;
                        i3 = i5;
                        i = i4;
                        break;
                    case BYTE_COMPACTION_MODE_LATCH /*901*/:
                    case NUMERIC_COMPACTION_MODE_LATCH /*902*/:
                    case MACRO_PDF417_TERMINATOR /*922*/:
                    case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                    case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                    case 928:
                        i = i4 - 1;
                        i2 = 1;
                        break;
                    case MODE_SHIFT_TO_BYTE_COMPACTION_MODE /*913*/:
                        iArr2[i3] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
                        i = i4 + 1;
                        iArr3[i3] = iArr[i4];
                        i3++;
                        break;
                    default:
                        i = i4;
                        break;
                }
            }
            iArr2[i3] = i5 / 30;
            iArr2[i3 + 1] = i5 % 30;
            i3 += 2;
            i = i4;
        }
        decodeTextCompaction(iArr2, iArr3, i3, stringBuilder);
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void decodeTextCompaction(int[] r12, int[] r13, int r14, java.lang.StringBuilder r15) {
        /*
        r1 = 32;
        r11 = 913; // 0x391 float:1.28E-42 double:4.51E-321;
        r10 = 900; // 0x384 float:1.261E-42 double:4.447E-321;
        r9 = 29;
        r8 = 26;
        r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        r0 = 0;
        r6 = r0;
    L_0x0010:
        if (r6 >= r14) goto L_0x0150;
    L_0x0012:
        r2 = r12[r6];
        r0 = 0;
        r5 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.C04201.f634x45bba1d;
        r7 = r4.ordinal();
        r5 = r5[r7];
        switch(r5) {
            case 1: goto L_0x002d;
            case 2: goto L_0x0066;
            case 3: goto L_0x009f;
            case 4: goto L_0x00ec;
            case 5: goto L_0x0112;
            case 6: goto L_0x012a;
            default: goto L_0x0020;
        };
    L_0x0020:
        r2 = r3;
        r5 = r4;
    L_0x0022:
        if (r0 == 0) goto L_0x0027;
    L_0x0024:
        r15.append(r0);
    L_0x0027:
        r0 = r6 + 1;
        r6 = r0;
        r3 = r2;
        r4 = r5;
        goto L_0x0010;
    L_0x002d:
        if (r2 >= r8) goto L_0x0035;
    L_0x002f:
        r0 = r2 + 65;
        r0 = (char) r0;
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x0035:
        if (r2 != r8) goto L_0x003b;
    L_0x0037:
        r0 = r1;
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x003b:
        r5 = 27;
        if (r2 != r5) goto L_0x0044;
    L_0x003f:
        r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER;
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x0044:
        r5 = 28;
        if (r2 != r5) goto L_0x004d;
    L_0x0048:
        r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED;
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x004d:
        if (r2 != r9) goto L_0x0054;
    L_0x004f:
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT;
        r2 = r4;
        r5 = r3;
        goto L_0x0022;
    L_0x0054:
        if (r2 != r11) goto L_0x005f;
    L_0x0056:
        r2 = r13[r6];
        r2 = (char) r2;
        r15.append(r2);
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x005f:
        if (r2 != r10) goto L_0x0020;
    L_0x0061:
        r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x0066:
        if (r2 >= r8) goto L_0x006e;
    L_0x0068:
        r0 = r2 + 97;
        r0 = (char) r0;
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x006e:
        if (r2 != r8) goto L_0x0074;
    L_0x0070:
        r0 = r1;
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x0074:
        r5 = 27;
        if (r2 != r5) goto L_0x007d;
    L_0x0078:
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA_SHIFT;
        r2 = r4;
        r5 = r3;
        goto L_0x0022;
    L_0x007d:
        r5 = 28;
        if (r2 != r5) goto L_0x0086;
    L_0x0081:
        r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED;
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x0086:
        if (r2 != r9) goto L_0x008d;
    L_0x0088:
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT;
        r2 = r4;
        r5 = r3;
        goto L_0x0022;
    L_0x008d:
        if (r2 != r11) goto L_0x0098;
    L_0x008f:
        r2 = r13[r6];
        r2 = (char) r2;
        r15.append(r2);
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x0098:
        if (r2 != r10) goto L_0x0020;
    L_0x009a:
        r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x009f:
        r5 = 25;
        if (r2 >= r5) goto L_0x00ab;
    L_0x00a3:
        r0 = MIXED_CHARS;
        r0 = r0[r2];
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x00ab:
        r5 = 25;
        if (r2 != r5) goto L_0x00b5;
    L_0x00af:
        r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT;
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x00b5:
        if (r2 != r8) goto L_0x00bc;
    L_0x00b7:
        r0 = r1;
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x00bc:
        r5 = 27;
        if (r2 != r5) goto L_0x00c6;
    L_0x00c0:
        r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER;
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x00c6:
        r5 = 28;
        if (r2 != r5) goto L_0x00d0;
    L_0x00ca:
        r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x00d0:
        if (r2 != r9) goto L_0x00d8;
    L_0x00d2:
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT;
        r2 = r4;
        r5 = r3;
        goto L_0x0022;
    L_0x00d8:
        if (r2 != r11) goto L_0x00e4;
    L_0x00da:
        r2 = r13[r6];
        r2 = (char) r2;
        r15.append(r2);
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x00e4:
        if (r2 != r10) goto L_0x0020;
    L_0x00e6:
        r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x00ec:
        if (r2 >= r9) goto L_0x00f6;
    L_0x00ee:
        r0 = PUNCT_CHARS;
        r0 = r0[r2];
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x00f6:
        if (r2 != r9) goto L_0x00fe;
    L_0x00f8:
        r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x00fe:
        if (r2 != r11) goto L_0x010a;
    L_0x0100:
        r2 = r13[r6];
        r2 = (char) r2;
        r15.append(r2);
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x010a:
        if (r2 != r10) goto L_0x0020;
    L_0x010c:
        r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x0112:
        if (r2 >= r8) goto L_0x011b;
    L_0x0114:
        r0 = r2 + 65;
        r0 = (char) r0;
        r2 = r3;
        r5 = r3;
        goto L_0x0022;
    L_0x011b:
        if (r2 != r8) goto L_0x0122;
    L_0x011d:
        r0 = r1;
        r2 = r3;
        r5 = r3;
        goto L_0x0022;
    L_0x0122:
        if (r2 != r10) goto L_0x0151;
    L_0x0124:
        r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x012a:
        if (r2 >= r9) goto L_0x0134;
    L_0x012c:
        r0 = PUNCT_CHARS;
        r0 = r0[r2];
        r2 = r3;
        r5 = r3;
        goto L_0x0022;
    L_0x0134:
        if (r2 != r9) goto L_0x013c;
    L_0x0136:
        r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x013c:
        if (r2 != r11) goto L_0x0148;
    L_0x013e:
        r2 = r13[r6];
        r2 = (char) r2;
        r15.append(r2);
        r2 = r3;
        r5 = r3;
        goto L_0x0022;
    L_0x0148:
        if (r2 != r10) goto L_0x0151;
    L_0x014a:
        r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA;
        r2 = r3;
        r5 = r4;
        goto L_0x0022;
    L_0x0150:
        return;
    L_0x0151:
        r2 = r3;
        r5 = r3;
        goto L_0x0022;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decodeTextCompaction(int[], int[], int, java.lang.StringBuilder):void");
    }

    private static int byteCompaction(int i, int[] iArr, Charset charset, int i2, StringBuilder stringBuilder) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i3;
        long j;
        int i4;
        int i5;
        if (i == BYTE_COMPACTION_MODE_LATCH) {
            i3 = 0;
            j = 0;
            int[] iArr2 = new int[6];
            Object obj = null;
            i4 = i2 + 1;
            int i6 = iArr[i2];
            int i7 = i4;
            while (i7 < iArr[0] && r3 == null) {
                i4 = i3 + 1;
                iArr2[i3] = i6;
                j = (j * 900) + ((long) i6);
                int i8 = i7 + 1;
                i6 = iArr[i7];
                if (i6 == TEXT_COMPACTION_MODE_LATCH || i6 == BYTE_COMPACTION_MODE_LATCH || i6 == NUMERIC_COMPACTION_MODE_LATCH || i6 == BYTE_COMPACTION_MODE_LATCH_6 || i6 == 928 || i6 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i6 == MACRO_PDF417_TERMINATOR) {
                    i7 = i8 - 1;
                    obj = 1;
                    i3 = i4;
                } else if (i4 % 5 != 0 || i4 <= 0) {
                    i3 = i4;
                    i7 = i8;
                } else {
                    for (i3 = 0; i3 < 6; i3++) {
                        byteArrayOutputStream.write((byte) ((int) (j >> ((5 - i3) * 8))));
                    }
                    j = 0;
                    i3 = 0;
                    i7 = i8;
                }
            }
            if (i7 == iArr[0] && i6 < TEXT_COMPACTION_MODE_LATCH) {
                i5 = i3 + 1;
                iArr2[i3] = i6;
                i3 = i5;
            }
            for (i6 = 0; i6 < i3; i6++) {
                byteArrayOutputStream.write((byte) iArr2[i6]);
            }
            i2 = i7;
        } else if (i == BYTE_COMPACTION_MODE_LATCH_6) {
            i5 = 0;
            j = 0;
            Object obj2 = null;
            while (i2 < iArr[0] && r2 == null) {
                i3 = i2 + 1;
                i4 = iArr[i2];
                if (i4 < TEXT_COMPACTION_MODE_LATCH) {
                    i5++;
                    j = (j * 900) + ((long) i4);
                    i2 = i3;
                } else if (i4 == TEXT_COMPACTION_MODE_LATCH || i4 == BYTE_COMPACTION_MODE_LATCH || i4 == NUMERIC_COMPACTION_MODE_LATCH || i4 == BYTE_COMPACTION_MODE_LATCH_6 || i4 == 928 || i4 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i4 == MACRO_PDF417_TERMINATOR) {
                    i2 = i3 - 1;
                    obj2 = 1;
                } else {
                    i2 = i3;
                }
                if (i5 % 5 == 0 && i5 > 0) {
                    for (i5 = 0; i5 < 6; i5++) {
                        byteArrayOutputStream.write((byte) ((int) (j >> ((5 - i5) * 8))));
                    }
                    j = 0;
                    i5 = 0;
                }
            }
        }
        stringBuilder.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i2;
    }

    private static int numericCompaction(int[] iArr, int i, StringBuilder stringBuilder) {
        int[] iArr2 = new int[15];
        int i2 = 0;
        int i3 = 0;
        while (i < iArr[0] && r0 == 0) {
            int i4 = i + 1;
            int i5 = iArr[i];
            if (i4 == iArr[0]) {
                i2 = 1;
            }
            if (i5 < TEXT_COMPACTION_MODE_LATCH) {
                iArr2[i3] = i5;
                i3++;
                i = i4;
            } else if (i5 == TEXT_COMPACTION_MODE_LATCH || i5 == BYTE_COMPACTION_MODE_LATCH || i5 == BYTE_COMPACTION_MODE_LATCH_6 || i5 == 928 || i5 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i5 == MACRO_PDF417_TERMINATOR) {
                i = i4 - 1;
                i2 = 1;
            } else {
                i = i4;
            }
            if ((i3 % 15 == 0 || i5 == NUMERIC_COMPACTION_MODE_LATCH || r0 != 0) && i3 > 0) {
                stringBuilder.append(decodeBase900toBase10(iArr2, i3));
                i3 = 0;
            }
        }
        return i;
    }

    private static String decodeBase900toBase10(int[] iArr, int i) {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(EXP900[(i - i2) - 1].multiply(BigInteger.valueOf((long) iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }
}
