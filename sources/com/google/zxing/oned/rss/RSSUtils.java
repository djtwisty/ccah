package com.google.zxing.oned.rss;

public final class RSSUtils {
    private RSSUtils() {
    }

    public static int getRSSvalue(int[] iArr, int i, boolean z) {
        int combins;
        int i2 = 0;
        for (int combins2 : iArr) {
            i2 += combins2;
        }
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = i2;
        while (i3 < length - 1) {
            i4 |= 1 << i3;
            i2 = 1;
            while (i2 < iArr[i3]) {
                combins2 = combins((i6 - i2) - 1, (length - i3) - 2);
                if (z && i4 == 0 && (i6 - i2) - ((length - i3) - 1) >= (length - i3) - 1) {
                    combins2 -= combins((i6 - i2) - (length - i3), (length - i3) - 2);
                }
                if ((length - i3) - 1 > 1) {
                    int i7 = 0;
                    for (int i8 = (i6 - i2) - ((length - i3) - 2); i8 > i; i8--) {
                        i7 += combins(((i6 - i2) - i8) - 1, (length - i3) - 3);
                    }
                    combins2 -= ((length - 1) - i3) * i7;
                } else if (i6 - i2 > i) {
                    combins2--;
                }
                i5 += combins2;
                i2++;
                i4 &= (1 << i3) ^ -1;
            }
            i3++;
            i6 -= i2;
        }
        return i5;
    }

    private static int combins(int i, int i2) {
        int i3;
        int i4;
        if (i - i2 > i2) {
            i3 = i - i2;
            i4 = i2;
        } else {
            i4 = i - i2;
            i3 = i2;
        }
        int i5 = 1;
        int i6 = 1;
        while (i > i3) {
            i6 *= i;
            if (i5 <= i4) {
                i6 /= i5;
                i5++;
            }
            i--;
        }
        i3 = i6;
        while (i5 <= i4) {
            i3 /= i5;
            i5++;
        }
        return i3;
    }
}
