package com.google.zxing.qrcode.decoder;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

final class DecodedBitStreamParser {
    private static final char[] ALPHANUMERIC_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();
    private static final int GB2312_SUBSET = 1;

    private DecodedBitStreamParser() {
    }

    static DecoderResult decode(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel, Map<DecodeHintType, ?> map) {
        int i;
        String str;
        BitSource bitSource = new BitSource(bArr);
        StringBuilder stringBuilder = new StringBuilder(50);
        List arrayList = new ArrayList(1);
        int i2 = -1;
        CharacterSetECI characterSetECI = null;
        boolean z = false;
        int i3 = -1;
        while (true) {
            try {
                Mode mode;
                boolean z2;
                if (bitSource.available() < 4) {
                    mode = Mode.TERMINATOR;
                } else {
                    mode = Mode.forBits(bitSource.readBits(4));
                }
                if (mode == Mode.TERMINATOR) {
                    z2 = z;
                    i = i3;
                } else if (mode == Mode.FNC1_FIRST_POSITION || mode == Mode.FNC1_SECOND_POSITION) {
                    z2 = true;
                    i = i3;
                } else if (mode == Mode.STRUCTURED_APPEND) {
                    if (bitSource.available() < 16) {
                        throw FormatException.getFormatInstance();
                    }
                    i3 = bitSource.readBits(8);
                    i2 = bitSource.readBits(8);
                    z2 = z;
                    i = i3;
                } else if (mode == Mode.ECI) {
                    characterSetECI = CharacterSetECI.getCharacterSetECIByValue(parseECIValue(bitSource));
                    if (characterSetECI == null) {
                        throw FormatException.getFormatInstance();
                    }
                    z2 = z;
                    i = i3;
                } else if (mode == Mode.HANZI) {
                    r2 = bitSource.readBits(4);
                    i = bitSource.readBits(mode.getCharacterCountBits(version));
                    if (r2 == 1) {
                        decodeHanziSegment(bitSource, stringBuilder, i);
                    }
                    z2 = z;
                    i = i3;
                } else {
                    r2 = bitSource.readBits(mode.getCharacterCountBits(version));
                    if (mode == Mode.NUMERIC) {
                        decodeNumericSegment(bitSource, stringBuilder, r2);
                        z2 = z;
                        i = i3;
                    } else if (mode == Mode.ALPHANUMERIC) {
                        decodeAlphanumericSegment(bitSource, stringBuilder, r2, z);
                        z2 = z;
                        i = i3;
                    } else if (mode == Mode.BYTE) {
                        decodeByteSegment(bitSource, stringBuilder, r2, characterSetECI, arrayList, map);
                        z2 = z;
                        i = i3;
                    } else if (mode == Mode.KANJI) {
                        decodeKanjiSegment(bitSource, stringBuilder, r2);
                        z2 = z;
                        i = i3;
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
                if (mode == Mode.TERMINATOR) {
                    break;
                }
                z = z2;
                i3 = i;
            } catch (IllegalArgumentException e) {
                throw FormatException.getFormatInstance();
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        List list = arrayList.isEmpty() ? null : arrayList;
        if (errorCorrectionLevel == null) {
            str = null;
        } else {
            str = errorCorrectionLevel.toString();
        }
        return new DecoderResult(bArr, stringBuilder2, list, str, i, i2);
    }

    private static void decodeHanziSegment(BitSource bitSource, StringBuilder stringBuilder, int i) {
        if (i * 13 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[(i * 2)];
        int i2 = 0;
        while (i > 0) {
            int readBits = bitSource.readBits(13);
            readBits = (readBits % 96) | ((readBits / 96) << 8);
            if (readBits < 959) {
                readBits += 41377;
            } else {
                readBits += 42657;
            }
            bArr[i2] = (byte) ((readBits >> 8) & 255);
            bArr[i2 + 1] = (byte) (readBits & 255);
            i--;
            i2 += 2;
        }
        try {
            stringBuilder.append(new String(bArr, StringUtils.GB2312));
        } catch (UnsupportedEncodingException e) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeKanjiSegment(BitSource bitSource, StringBuilder stringBuilder, int i) {
        if (i * 13 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[(i * 2)];
        int i2 = 0;
        while (i > 0) {
            int readBits = bitSource.readBits(13);
            readBits = (readBits % 192) | ((readBits / 192) << 8);
            if (readBits < 7936) {
                readBits += 33088;
            } else {
                readBits += 49472;
            }
            bArr[i2] = (byte) (readBits >> 8);
            bArr[i2 + 1] = (byte) readBits;
            i--;
            i2 += 2;
        }
        try {
            stringBuilder.append(new String(bArr, StringUtils.SHIFT_JIS));
        } catch (UnsupportedEncodingException e) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeByteSegment(BitSource bitSource, StringBuilder stringBuilder, int i, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) {
        if (i * 8 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        String guessEncoding;
        Object obj = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            obj[i2] = (byte) bitSource.readBits(8);
        }
        if (characterSetECI == null) {
            guessEncoding = StringUtils.guessEncoding(obj, map);
        } else {
            guessEncoding = characterSetECI.name();
        }
        try {
            stringBuilder.append(new String(obj, guessEncoding));
            collection.add(obj);
        } catch (UnsupportedEncodingException e) {
            throw FormatException.getFormatInstance();
        }
    }

    private static char toAlphaNumericChar(int i) {
        if (i < ALPHANUMERIC_CHARS.length) {
            return ALPHANUMERIC_CHARS[i];
        }
        throw FormatException.getFormatInstance();
    }

    private static void decodeAlphanumericSegment(BitSource bitSource, StringBuilder stringBuilder, int i, boolean z) {
        int length = stringBuilder.length();
        while (i > 1) {
            if (bitSource.available() < 11) {
                throw FormatException.getFormatInstance();
            }
            int readBits = bitSource.readBits(11);
            stringBuilder.append(toAlphaNumericChar(readBits / 45));
            stringBuilder.append(toAlphaNumericChar(readBits % 45));
            i -= 2;
        }
        if (i == 1) {
            if (bitSource.available() < 6) {
                throw FormatException.getFormatInstance();
            }
            stringBuilder.append(toAlphaNumericChar(bitSource.readBits(6)));
        }
        if (z) {
            while (length < stringBuilder.length()) {
                if (stringBuilder.charAt(length) == '%') {
                    if (length >= stringBuilder.length() - 1 || stringBuilder.charAt(length + 1) != '%') {
                        stringBuilder.setCharAt(length, '\u001d');
                    } else {
                        stringBuilder.deleteCharAt(length + 1);
                    }
                }
                length++;
            }
        }
    }

    private static void decodeNumericSegment(BitSource bitSource, StringBuilder stringBuilder, int i) {
        while (i >= 3) {
            if (bitSource.available() < 10) {
                throw FormatException.getFormatInstance();
            }
            int readBits = bitSource.readBits(10);
            if (readBits >= 1000) {
                throw FormatException.getFormatInstance();
            }
            stringBuilder.append(toAlphaNumericChar(readBits / 100));
            stringBuilder.append(toAlphaNumericChar((readBits / 10) % 10));
            stringBuilder.append(toAlphaNumericChar(readBits % 10));
            i -= 3;
        }
        if (i == 2) {
            if (bitSource.available() < 7) {
                throw FormatException.getFormatInstance();
            }
            readBits = bitSource.readBits(7);
            if (readBits >= 100) {
                throw FormatException.getFormatInstance();
            }
            stringBuilder.append(toAlphaNumericChar(readBits / 10));
            stringBuilder.append(toAlphaNumericChar(readBits % 10));
        } else if (i != 1) {
        } else {
            if (bitSource.available() < 4) {
                throw FormatException.getFormatInstance();
            }
            readBits = bitSource.readBits(4);
            if (readBits >= 10) {
                throw FormatException.getFormatInstance();
            }
            stringBuilder.append(toAlphaNumericChar(readBits));
        }
    }

    private static int parseECIValue(BitSource bitSource) {
        int readBits = bitSource.readBits(8);
        if ((readBits & 128) == 0) {
            return readBits & 127;
        }
        if ((readBits & 192) == 128) {
            return ((readBits & 63) << 8) | bitSource.readBits(8);
        } else if ((readBits & 224) == 192) {
            return ((readBits & 31) << 16) | bitSource.readBits(16);
        } else {
            throw FormatException.getFormatInstance();
        }
    }
}
