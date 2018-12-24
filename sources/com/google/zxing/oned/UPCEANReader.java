package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

public abstract class UPCEANReader extends OneDReader {
    static final int[] END_PATTERN = new int[]{1, 1, 1, 1, 1, 1};
    static final int[][] L_AND_G_PATTERNS = new int[20][];
    static final int[][] L_PATTERNS = new int[][]{new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
    private static final float MAX_AVG_VARIANCE = 0.48f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;
    static final int[] MIDDLE_PATTERN = new int[]{1, 1, 1, 1, 1};
    static final int[] START_END_PATTERN = new int[]{1, 1, 1};
    private final StringBuilder decodeRowStringBuffer = new StringBuilder(20);
    private final EANManufacturerOrgSupport eanManSupport = new EANManufacturerOrgSupport();
    private final UPCEANExtensionSupport extensionReader = new UPCEANExtensionSupport();

    protected abstract int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder stringBuilder);

    abstract BarcodeFormat getBarcodeFormat();

    static {
        System.arraycopy(L_PATTERNS, 0, L_AND_G_PATTERNS, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr = L_PATTERNS[i - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr2[i2] = iArr[(iArr.length - i2) - 1];
            }
            L_AND_G_PATTERNS[i] = iArr2;
        }
    }

    protected UPCEANReader() {
    }

    static int[] findStartGuardPattern(BitArray bitArray) {
        int[] iArr = null;
        int[] iArr2 = new int[START_END_PATTERN.length];
        int i = 0;
        boolean z = false;
        while (!z) {
            Arrays.fill(iArr2, 0, START_END_PATTERN.length, 0);
            iArr = findGuardPattern(bitArray, i, false, START_END_PATTERN, iArr2);
            int i2 = iArr[0];
            i = iArr[1];
            int i3 = i2 - (i - i2);
            if (i3 >= 0) {
                z = bitArray.isRange(i3, i2, false);
            }
        }
        return iArr;
    }

    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) {
        return decodeRow(i, bitArray, findStartGuardPattern(bitArray), map);
    }

    public Result decodeRow(int i, BitArray bitArray, int[] iArr, Map<DecodeHintType, ?> map) {
        ResultPointCallback resultPointCallback;
        if (map == null) {
            resultPointCallback = null;
        } else {
            resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        }
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new ResultPoint(((float) (iArr[0] + iArr[1])) / 2.0f, (float) i));
        }
        StringBuilder stringBuilder = this.decodeRowStringBuffer;
        stringBuilder.setLength(0);
        int decodeMiddle = decodeMiddle(bitArray, iArr, stringBuilder);
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new ResultPoint((float) decodeMiddle, (float) i));
        }
        int[] decodeEnd = decodeEnd(bitArray, decodeMiddle);
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new ResultPoint(((float) (decodeEnd[0] + decodeEnd[1])) / 2.0f, (float) i));
        }
        int i2 = decodeEnd[1];
        int i3 = (i2 - decodeEnd[0]) + i2;
        if (i3 >= bitArray.getSize() || !bitArray.isRange(i2, i3, false)) {
            throw NotFoundException.getNotFoundInstance();
        }
        String stringBuilder2 = stringBuilder.toString();
        if (stringBuilder2.length() < 8) {
            throw FormatException.getFormatInstance();
        } else if (checkChecksum(stringBuilder2)) {
            float f = ((float) (iArr[1] + iArr[0])) / 2.0f;
            float f2 = ((float) (decodeEnd[1] + decodeEnd[0])) / 2.0f;
            BarcodeFormat barcodeFormat = getBarcodeFormat();
            Result result = new Result(stringBuilder2, null, new ResultPoint[]{new ResultPoint(f, (float) i), new ResultPoint(f2, (float) i)}, barcodeFormat);
            i2 = 0;
            try {
                Result decodeRow = this.extensionReader.decodeRow(i, bitArray, decodeEnd[1]);
                result.putMetadata(ResultMetadataType.UPC_EAN_EXTENSION, decodeRow.getText());
                result.putAllMetadata(decodeRow.getResultMetadata());
                result.addResultPoints(decodeRow.getResultPoints());
                i3 = decodeRow.getText().length();
            } catch (ReaderException e) {
                i3 = i2;
            }
            if (map == null) {
                decodeEnd = null;
            } else {
                decodeEnd = (int[]) map.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS);
            }
            if (decodeEnd != null) {
                Object obj = null;
                for (int i4 : decodeEnd) {
                    if (i3 == i4) {
                        obj = 1;
                        break;
                    }
                }
                if (obj == null) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            if (barcodeFormat == BarcodeFormat.EAN_13 || barcodeFormat == BarcodeFormat.UPC_A) {
                String lookupCountryIdentifier = this.eanManSupport.lookupCountryIdentifier(stringBuilder2);
                if (lookupCountryIdentifier != null) {
                    result.putMetadata(ResultMetadataType.POSSIBLE_COUNTRY, lookupCountryIdentifier);
                }
            }
            return result;
        } else {
            throw ChecksumException.getChecksumInstance();
        }
    }

    boolean checkChecksum(String str) {
        return checkStandardUPCEANChecksum(str);
    }

    static boolean checkStandardUPCEANChecksum(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i;
        int i2 = 0;
        for (i = length - 2; i >= 0; i -= 2) {
            int charAt = charSequence.charAt(i) - 48;
            if (charAt < 0 || charAt > 9) {
                throw FormatException.getFormatInstance();
            }
            i2 += charAt;
        }
        i2 *= 3;
        for (i = length - 1; i >= 0; i -= 2) {
            length = charSequence.charAt(i) - 48;
            if (length < 0 || length > 9) {
                throw FormatException.getFormatInstance();
            }
            i2 += length;
        }
        if (i2 % 10 == 0) {
            return true;
        }
        return false;
    }

    int[] decodeEnd(BitArray bitArray, int i) {
        return findGuardPattern(bitArray, i, false, START_END_PATTERN);
    }

    static int[] findGuardPattern(BitArray bitArray, int i, boolean z, int[] iArr) {
        return findGuardPattern(bitArray, i, z, iArr, new int[iArr.length]);
    }

    private static int[] findGuardPattern(BitArray bitArray, int i, boolean z, int[] iArr, int[] iArr2) {
        int size = bitArray.getSize();
        int nextUnset = z ? bitArray.getNextUnset(i) : bitArray.getNextSet(i);
        int length = iArr.length;
        int i2 = nextUnset;
        int i3 = z;
        int i4 = nextUnset;
        int i5 = 0;
        while (i2 < size) {
            if ((bitArray.get(i2) ^ i3) != 0) {
                iArr2[i5] = iArr2[i5] + 1;
                nextUnset = i4;
            } else {
                if (i5 != length - 1) {
                    i5++;
                    nextUnset = i4;
                } else if (OneDReader.patternMatchVariance(iArr2, iArr, MAX_INDIVIDUAL_VARIANCE) < MAX_AVG_VARIANCE) {
                    return new int[]{i4, i2};
                } else {
                    nextUnset = (iArr2[0] + iArr2[1]) + i4;
                    System.arraycopy(iArr2, 2, iArr2, 0, length - 2);
                    iArr2[length - 2] = 0;
                    iArr2[length - 1] = 0;
                    i5--;
                }
                iArr2[i5] = 1;
                if (i3 == 0) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                i3 = i4;
            }
            i2++;
            i4 = nextUnset;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    static int decodeDigit(BitArray bitArray, int[] iArr, int i, int[][] iArr2) {
        OneDReader.recordPattern(bitArray, i, iArr);
        float f = MAX_AVG_VARIANCE;
        int i2 = -1;
        int length = iArr2.length;
        int i3 = 0;
        while (i3 < length) {
            float patternMatchVariance = OneDReader.patternMatchVariance(iArr, iArr2[i3], MAX_INDIVIDUAL_VARIANCE);
            if (patternMatchVariance < f) {
                i2 = i3;
            } else {
                patternMatchVariance = f;
            }
            i3++;
            f = patternMatchVariance;
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
