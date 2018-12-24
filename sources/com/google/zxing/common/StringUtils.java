package com.google.zxing.common;

import com.google.zxing.DecodeHintType;
import java.nio.charset.Charset;
import java.util.Map;

public final class StringUtils {
    private static final boolean ASSUME_SHIFT_JIS;
    private static final String EUC_JP = "EUC_JP";
    public static final String GB2312 = "GB2312";
    private static final String ISO88591 = "ISO8859_1";
    private static final String PLATFORM_DEFAULT_ENCODING = Charset.defaultCharset().name();
    public static final String SHIFT_JIS = "SJIS";
    private static final String UTF8 = "UTF8";

    static {
        boolean z = SHIFT_JIS.equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING) || EUC_JP.equalsIgnoreCase(PLATFORM_DEFAULT_ENCODING);
        ASSUME_SHIFT_JIS = z;
    }

    private StringUtils() {
    }

    public static String guessEncoding(byte[] bArr, Map<DecodeHintType, ?> map) {
        Object obj;
        if (map != null) {
            if (map.containsKey(DecodeHintType.CHARACTER_SET)) {
                return map.get(DecodeHintType.CHARACTER_SET).toString();
            }
        }
        int length = bArr.length;
        Object obj2 = 1;
        Object obj3 = 1;
        Object obj4 = 1;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        Object obj5 = (bArr.length > 3 && bArr[0] == (byte) -17 && bArr[1] == (byte) -69 && bArr[2] == (byte) -65) ? 1 : null;
        int i12 = 0;
        while (i12 < length && (obj2 != null || obj3 != null || obj4 != null)) {
            int i13;
            int i14 = bArr[i12] & 255;
            if (obj4 != null) {
                if (i > 0) {
                    if ((i14 & 128) == 0) {
                        obj4 = null;
                    } else {
                        i--;
                    }
                } else if ((i14 & 128) != 0) {
                    if ((i14 & 64) == 0) {
                        obj4 = null;
                    } else {
                        i++;
                        if ((i14 & 32) == 0) {
                            i2++;
                        } else {
                            i++;
                            if ((i14 & 16) == 0) {
                                i3++;
                            } else {
                                i++;
                                if ((i14 & 8) == 0) {
                                    i4++;
                                } else {
                                    obj4 = null;
                                }
                            }
                        }
                    }
                }
            }
            if (obj2 != null) {
                if (i14 > 127 && i14 < 160) {
                    obj2 = null;
                } else if (i14 > 159 && (i14 < 192 || i14 == 215 || i14 == 247)) {
                    i11++;
                }
            }
            if (obj3 != null) {
                if (i5 > 0) {
                    if (i14 < 64 || i14 == 127 || i14 > 252) {
                        obj3 = null;
                        i13 = i8;
                    } else {
                        i5--;
                        i13 = i8;
                    }
                } else if (i14 == 128 || i14 == 160 || i14 > 239) {
                    obj3 = null;
                    i13 = i8;
                } else if (i14 > 160 && i14 < 224) {
                    i6++;
                    i13 = 0;
                    i8 = i7 + 1;
                    if (i8 > i9) {
                        i9 = i8;
                        i7 = i8;
                    } else {
                        i7 = i8;
                    }
                } else if (i14 > 127) {
                    i5++;
                    i7 = 0;
                    i8++;
                    if (i8 > i10) {
                        i10 = i8;
                        i13 = i8;
                    }
                } else {
                    i7 = 0;
                    i13 = 0;
                }
                i12++;
                i8 = i13;
            }
            i13 = i8;
            i12++;
            i8 = i13;
        }
        if (obj4 == null || i <= 0) {
            obj = obj4;
        } else {
            obj = null;
        }
        if (obj3 != null && i5 > 0) {
            obj3 = null;
        }
        if (obj != null && (obj5 != null || (i2 + i3) + i4 > 0)) {
            return UTF8;
        }
        if (obj3 != null && (ASSUME_SHIFT_JIS || i9 >= 3 || i10 >= 3)) {
            return SHIFT_JIS;
        }
        if (obj2 != null && obj3 != null) {
            return (!(i9 == 2 && i6 == 2) && i11 * 10 < length) ? ISO88591 : SHIFT_JIS;
        } else {
            if (obj2 != null) {
                return ISO88591;
            }
            if (obj3 != null) {
                return SHIFT_JIS;
            }
            if (obj != null) {
                return UTF8;
            }
            return PLATFORM_DEFAULT_ENCODING;
        }
    }
}
