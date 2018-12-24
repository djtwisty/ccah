package com.google.zxing.oned;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;
import org.apache.http.HttpStatus;
import org.apache.http.util.LangUtils;

public final class Code39Reader extends OneDReader {
    static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%";
    static final int ASTERISK_ENCODING = CHARACTER_ENCODINGS[39];
    static final int[] CHARACTER_ENCODINGS = new int[]{52, 289, 97, 352, 49, HttpStatus.SC_NOT_MODIFIED, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, HttpStatus.SC_BAD_REQUEST, 208, 133, 388, 196, 148, 168, 162, 138, 42};
    private static final String CHECK_DIGIT_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";
    private final int[] counters;
    private final StringBuilder decodeRowResult;
    private final boolean extendedMode;
    private final boolean usingCheckDigit;

    public Code39Reader() {
        this(false);
    }

    public Code39Reader(boolean z) {
        this(z, false);
    }

    public Code39Reader(boolean z, boolean z2) {
        this.usingCheckDigit = z;
        this.extendedMode = z2;
        this.decodeRowResult = new StringBuilder(20);
        this.counters = new int[9];
    }

    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) {
        int toNarrowWidePattern;
        int i2;
        int[] iArr = this.counters;
        Arrays.fill(iArr, 0);
        Object obj = this.decodeRowResult;
        obj.setLength(0);
        int nextSet = bitArray.getNextSet(findAsteriskPattern(bitArray, iArr)[1]);
        int size = bitArray.getSize();
        while (true) {
            OneDReader.recordPattern(bitArray, nextSet, iArr);
            toNarrowWidePattern = toNarrowWidePattern(iArr);
            if (toNarrowWidePattern < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            char patternToChar = patternToChar(toNarrowWidePattern);
            obj.append(patternToChar);
            i2 = nextSet;
            for (int i3 : iArr) {
                i2 += i3;
            }
            toNarrowWidePattern = bitArray.getNextSet(i2);
            if (patternToChar == '*') {
                break;
            }
            nextSet = toNarrowWidePattern;
        }
        obj.setLength(obj.length() - 1);
        int i4 = 0;
        for (int i32 : iArr) {
            i4 += i32;
        }
        i2 = (toNarrowWidePattern - nextSet) - i4;
        if (toNarrowWidePattern == size || i2 * 2 >= i4) {
            if (this.usingCheckDigit) {
                int length = obj.length() - 1;
                i2 = 0;
                for (toNarrowWidePattern = 0; toNarrowWidePattern < length; toNarrowWidePattern++) {
                    i2 += CHECK_DIGIT_STRING.indexOf(this.decodeRowResult.charAt(toNarrowWidePattern));
                }
                if (obj.charAt(length) != CHECK_DIGIT_STRING.charAt(i2 % 43)) {
                    throw ChecksumException.getChecksumInstance();
                }
                obj.setLength(length);
            }
            if (obj.length() == 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            String decodeExtended;
            if (this.extendedMode) {
                decodeExtended = decodeExtended(obj);
            } else {
                decodeExtended = obj.toString();
            }
            float f = ((float) nextSet) + (((float) i4) / 2.0f);
            return new Result(decodeExtended, null, new ResultPoint[]{new ResultPoint(((float) (r6[1] + r6[0])) / 2.0f, (float) i), new ResultPoint(f, (float) i)}, BarcodeFormat.CODE_39);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int[] findAsteriskPattern(BitArray bitArray, int[] iArr) {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int length = iArr.length;
        int i = nextSet;
        int i2 = 0;
        int i3 = nextSet;
        int i4 = 0;
        while (i < size) {
            if ((bitArray.get(i) ^ i2) != 0) {
                iArr[i4] = iArr[i4] + 1;
            } else {
                if (i4 != length - 1) {
                    i4++;
                } else if (toNarrowWidePattern(iArr) == ASTERISK_ENCODING && bitArray.isRange(Math.max(0, i3 - ((i - i3) / 2)), i3, false)) {
                    return new int[]{i3, i};
                } else {
                    i3 += iArr[0] + iArr[1];
                    System.arraycopy(iArr, 2, iArr, 0, length - 2);
                    iArr[length - 2] = 0;
                    iArr[length - 1] = 0;
                    i4--;
                }
                iArr[i4] = 1;
                if (i2 == 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int toNarrowWidePattern(int[] iArr) {
        int i;
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = BaseClientBuilder.API_PRIORITY_OTHER;
            for (int i4 : iArr) {
                if (i4 < i3 && i4 > r0) {
                    i3 = i4;
                }
            }
            i2 = 0;
            int i42 = 0;
            int i5 = 0;
            for (i = 0; i < length; i++) {
                int i6 = iArr[i];
                if (i6 > i3) {
                    i2 |= 1 << ((length - 1) - i);
                    i5++;
                    i42 += i6;
                }
            }
            if (i5 == 3) {
                break;
            } else if (i5 <= 3) {
                return -1;
            } else {
                i2 = i3;
            }
        }
        i = 0;
        while (i < length && i5 > 0) {
            int i7;
            i6 = iArr[i];
            if (i6 > i3) {
                i7 = i5 - 1;
                if (i6 * 2 >= i42) {
                    return -1;
                }
            } else {
                i7 = i5;
            }
            i++;
            i5 = i7;
        }
        return i2;
    }

    private static char patternToChar(int i) {
        for (int i2 = 0; i2 < CHARACTER_ENCODINGS.length; i2++) {
            if (CHARACTER_ENCODINGS[i2] == i) {
                return ALPHABET_STRING.charAt(i2);
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static String decodeExtended(CharSequence charSequence) {
        int length = charSequence.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            int i2;
            char charAt = charSequence.charAt(i);
            if (charAt == '+' || charAt == '$' || charAt == '%' || charAt == '/') {
                char charAt2 = charSequence.charAt(i + 1);
                switch (charAt) {
                    case '$':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            charAt = (char) (charAt2 - 64);
                            break;
                        }
                        throw FormatException.getFormatInstance();
                        break;
                    case LangUtils.HASH_OFFSET /*37*/:
                        if (charAt2 < 'A' || charAt2 > 'E') {
                            if (charAt2 >= 'F' && charAt2 <= 'W') {
                                charAt = (char) (charAt2 - 11);
                                break;
                            }
                            throw FormatException.getFormatInstance();
                        }
                        charAt = (char) (charAt2 - 38);
                        break;
                        break;
                    case '+':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            charAt = (char) (charAt2 + 32);
                            break;
                        }
                        throw FormatException.getFormatInstance();
                        break;
                    case '/':
                        if (charAt2 >= 'A' && charAt2 <= 'O') {
                            charAt = (char) (charAt2 - 32);
                            break;
                        } else if (charAt2 == 'Z') {
                            charAt = ':';
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    default:
                        charAt = '\u0000';
                        break;
                }
                stringBuilder.append(charAt);
                i2 = i + 1;
            } else {
                stringBuilder.append(charAt);
                i2 = i;
            }
            i = i2 + 1;
        }
        return stringBuilder.toString();
    }
}
