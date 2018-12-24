package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public abstract class OneDimensionalCodeWriter implements Writer {
    public abstract boolean[] encode(String str);

    public final BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2) {
        return encode(str, barcodeFormat, i, i2, null);
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i + 'x' + i2);
        } else {
            int defaultMargin = getDefaultMargin();
            if (map != null && map.containsKey(EncodeHintType.MARGIN)) {
                defaultMargin = Integer.parseInt(map.get(EncodeHintType.MARGIN).toString());
            }
            return renderResult(encode(str), i, i2, defaultMargin);
        }
    }

    private static BitMatrix renderResult(boolean[] zArr, int i, int i2, int i3) {
        int length = zArr.length;
        int i4 = length + i3;
        int max = Math.max(i, i4);
        int max2 = Math.max(1, i2);
        int i5 = max / i4;
        i4 = (max - (length * i5)) / 2;
        BitMatrix bitMatrix = new BitMatrix(max, max2);
        max = 0;
        while (max < length) {
            if (zArr[max]) {
                bitMatrix.setRegion(i4, 0, i5, max2);
            }
            max++;
            i4 += i5;
        }
        return bitMatrix;
    }

    protected static int appendPattern(boolean[] zArr, int i, int[] iArr, boolean z) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = i;
        while (i2 < length) {
            int i5 = iArr[i2];
            int i6 = 0;
            while (i6 < i5) {
                int i7 = i4 + 1;
                zArr[i4] = z;
                i6++;
                i4 = i7;
            }
            i3 += i5;
            i2++;
            z = !z;
        }
        return i3;
    }

    public int getDefaultMargin() {
        return 10;
    }
}
