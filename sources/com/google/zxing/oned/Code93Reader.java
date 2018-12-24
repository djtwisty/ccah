package com.google.zxing.oned;

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

public final class Code93Reader extends OneDReader {
    private static final char[] ALPHABET = ALPHABET_STRING.toCharArray();
    static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
    private static final int ASTERISK_ENCODING = CHARACTER_ENCODINGS[47];
    static final int[] CHARACTER_ENCODINGS = new int[]{276, 328, 324, 322, 296, 292, 290, 336, 274, 266, HttpStatus.SC_FAILED_DEPENDENCY, HttpStatus.SC_METHOD_FAILURE, 418, HttpStatus.SC_NOT_FOUND, HttpStatus.SC_PAYMENT_REQUIRED, 394, 360, 356, 354, 308, 282, 344, 332, 326, HttpStatus.SC_MULTIPLE_CHOICES, 278, 436, 434, 428, HttpStatus.SC_UNPROCESSABLE_ENTITY, HttpStatus.SC_NOT_ACCEPTABLE, HttpStatus.SC_GONE, 364, 358, 310, 314, HttpStatus.SC_MOVED_TEMPORARILY, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
    private final int[] counters = new int[6];
    private final StringBuilder decodeRowResult = new StringBuilder(20);

    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) {
        int nextSet = bitArray.getNextSet(findAsteriskPattern(bitArray)[1]);
        int size = bitArray.getSize();
        int[] iArr = this.counters;
        Arrays.fill(iArr, 0);
        CharSequence charSequence = this.decodeRowResult;
        charSequence.setLength(0);
        while (true) {
            OneDReader.recordPattern(bitArray, nextSet, iArr);
            int toPattern = toPattern(iArr);
            if (toPattern < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            char patternToChar = patternToChar(toPattern);
            charSequence.append(patternToChar);
            int i2 = nextSet;
            for (int i3 : iArr) {
                i2 += i3;
            }
            toPattern = bitArray.getNextSet(i2);
            if (patternToChar == '*') {
                break;
            }
            nextSet = toPattern;
        }
        charSequence.deleteCharAt(charSequence.length() - 1);
        int i4 = 0;
        for (int i32 : iArr) {
            i4 += i32;
        }
        if (toPattern == size || !bitArray.get(toPattern)) {
            throw NotFoundException.getNotFoundInstance();
        } else if (charSequence.length() < 2) {
            throw NotFoundException.getNotFoundInstance();
        } else {
            checkChecksums(charSequence);
            charSequence.setLength(charSequence.length() - 2);
            float f = ((float) nextSet) + (((float) i4) / 2.0f);
            return new Result(decodeExtended(charSequence), null, new ResultPoint[]{new ResultPoint(((float) (r4[1] + r4[0])) / 2.0f, (float) i), new ResultPoint(f, (float) i)}, BarcodeFormat.CODE_93);
        }
    }

    private int[] findAsteriskPattern(BitArray bitArray) {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        Arrays.fill(this.counters, 0);
        Object obj = this.counters;
        int length = obj.length;
        int i = 0;
        int i2 = 0;
        int i3 = nextSet;
        for (int i4 = nextSet; i4 < size; i4++) {
            if ((bitArray.get(i4) ^ i2) != 0) {
                obj[i] = obj[i] + 1;
            } else {
                if (i != length - 1) {
                    i++;
                } else if (toPattern(obj) == ASTERISK_ENCODING) {
                    return new int[]{i3, i4};
                } else {
                    i3 += obj[0] + obj[1];
                    System.arraycopy(obj, 2, obj, 0, length - 2);
                    obj[length - 2] = null;
                    obj[length - 1] = null;
                    i--;
                }
                obj[i] = 1;
                if (i2 == 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int toPattern(int[] iArr) {
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            i++;
            i2 = iArr[i] + i2;
        }
        int length = iArr.length;
        i = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int round = Math.round((((float) iArr[i3]) * 9.0f) / ((float) i2));
            if (round < 1 || round > 4) {
                return -1;
            }
            if ((i3 & 1) == 0) {
                for (int i4 = 0; i4 < round; i4++) {
                    i = (i << 1) | 1;
                }
            } else {
                i <<= round;
            }
        }
        return i;
    }

    private static char patternToChar(int i) {
        for (int i2 = 0; i2 < CHARACTER_ENCODINGS.length; i2++) {
            if (CHARACTER_ENCODINGS[i2] == i) {
                return ALPHABET[i2];
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
            if (charAt < 'a' || charAt > 'd') {
                stringBuilder.append(charAt);
                i2 = i;
            } else if (i >= length - 1) {
                throw FormatException.getFormatInstance();
            } else {
                char charAt2 = charSequence.charAt(i + 1);
                switch (charAt) {
                    case 'a':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            charAt = (char) (charAt2 - 64);
                            break;
                        }
                        throw FormatException.getFormatInstance();
                        break;
                    case 'b':
                        if (charAt2 < 'A' || charAt2 > 'E') {
                            if (charAt2 < 'F' || charAt2 > 'J') {
                                if (charAt2 < 'K' || charAt2 > 'O') {
                                    if (charAt2 < 'P' || charAt2 > 'S') {
                                        if (charAt2 >= 'T' && charAt2 <= 'Z') {
                                            charAt = '';
                                            break;
                                        }
                                        throw FormatException.getFormatInstance();
                                    }
                                    charAt = (char) (charAt2 + 43);
                                    break;
                                }
                                charAt = (char) (charAt2 + 16);
                                break;
                            }
                            charAt = (char) (charAt2 - 11);
                            break;
                        }
                        charAt = (char) (charAt2 - 38);
                        break;
                        break;
                    case 'c':
                        if (charAt2 >= 'A' && charAt2 <= 'O') {
                            charAt = (char) (charAt2 - 32);
                            break;
                        } else if (charAt2 == 'Z') {
                            charAt = ':';
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    case HttpStatus.SC_CONTINUE /*100*/:
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            charAt = (char) (charAt2 + 32);
                            break;
                        }
                        throw FormatException.getFormatInstance();
                        break;
                    default:
                        charAt = '\u0000';
                        break;
                }
                stringBuilder.append(charAt);
                i2 = i + 1;
            }
            i = i2 + 1;
        }
        return stringBuilder.toString();
    }

    private static void checkChecksums(CharSequence charSequence) {
        int length = charSequence.length();
        checkOneChecksum(charSequence, length - 2, 20);
        checkOneChecksum(charSequence, length - 1, 15);
    }

    private static void checkOneChecksum(CharSequence charSequence, int i, int i2) {
        int i3 = 0;
        int i4 = i - 1;
        int i5 = 1;
        while (i4 >= 0) {
            i3 += ALPHABET_STRING.indexOf(charSequence.charAt(i4)) * i5;
            int i6 = i5 + 1;
            if (i6 > i2) {
                i6 = 1;
            }
            i4--;
            i5 = i6;
        }
        if (charSequence.charAt(i) != ALPHABET[i3 % 47]) {
            throw ChecksumException.getChecksumInstance();
        }
    }
}
