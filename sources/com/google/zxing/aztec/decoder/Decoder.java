package com.google.zxing.aztec.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import java.util.Arrays;

public final class Decoder {
    private static final String[] DIGIT_TABLE = new String[]{"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};
    private static final String[] LOWER_TABLE = new String[]{"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] MIXED_TABLE = new String[]{"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] PUNCT_TABLE = new String[]{"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    private static final String[] UPPER_TABLE = new String[]{"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private AztecDetectorResult ddata;

    private enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    public DecoderResult decode(AztecDetectorResult aztecDetectorResult) {
        this.ddata = aztecDetectorResult;
        boolean[] correctBits = correctBits(extractBits(aztecDetectorResult.getBits()));
        DecoderResult decoderResult = new DecoderResult(convertBoolArrayToByteArray(correctBits), getEncodedData(correctBits), null, null);
        decoderResult.setNumBits(correctBits.length);
        return decoderResult;
    }

    public static String highLevelDecode(boolean[] zArr) {
        return getEncodedData(zArr);
    }

    private static String getEncodedData(boolean[] zArr) {
        int length = zArr.length;
        Table table = Table.UPPER;
        Table table2 = Table.UPPER;
        StringBuilder stringBuilder = new StringBuilder(20);
        int i = 0;
        while (i < length) {
            int i2;
            if (table2 != Table.BINARY) {
                i2 = table2 == Table.DIGIT ? 4 : 5;
                if (length - i < i2) {
                    break;
                }
                Table table3;
                Table table4;
                int i3 = i + i2;
                String character = getCharacter(table2, readCode(zArr, i, i2));
                if (character.startsWith("CTRL_")) {
                    Table table5 = getTable(character.charAt(5));
                    if (character.charAt(6) == 'L') {
                        table3 = table5;
                        table4 = table5;
                    } else {
                        table3 = table5;
                        table4 = table2;
                    }
                } else {
                    stringBuilder.append(character);
                    table3 = table;
                    table4 = table;
                }
                i = i3;
                table2 = table3;
                table = table4;
            } else if (length - i < 5) {
                break;
            } else {
                i2 = readCode(zArr, i, 5);
                i += 5;
                if (i2 == 0) {
                    if (length - i < 11) {
                        break;
                    }
                    i2 = readCode(zArr, i, 11) + 31;
                    i += 11;
                }
                for (int i4 = 0; i4 < i2; i4++) {
                    if (length - i < 8) {
                        i2 = length;
                        break;
                    }
                    stringBuilder.append((char) readCode(zArr, i, 8));
                    i += 8;
                }
                i2 = i;
                i = i2;
                table2 = table;
            }
        }
        return stringBuilder.toString();
    }

    private static Table getTable(char c) {
        switch (c) {
            case 'B':
                return Table.BINARY;
            case 'D':
                return Table.DIGIT;
            case 'L':
                return Table.LOWER;
            case 'M':
                return Table.MIXED;
            case 'P':
                return Table.PUNCT;
            default:
                return Table.UPPER;
        }
    }

    private static String getCharacter(Table table, int i) {
        switch (table) {
            case UPPER:
                return UPPER_TABLE[i];
            case LOWER:
                return LOWER_TABLE[i];
            case MIXED:
                return MIXED_TABLE[i];
            case PUNCT:
                return PUNCT_TABLE[i];
            case DIGIT:
                return DIGIT_TABLE[i];
            default:
                throw new IllegalStateException("Bad table");
        }
    }

    private boolean[] correctBits(boolean[] zArr) {
        GenericGF genericGF;
        int i = 8;
        if (this.ddata.getNbLayers() <= 2) {
            i = 6;
            genericGF = GenericGF.AZTEC_DATA_6;
        } else if (this.ddata.getNbLayers() <= 8) {
            genericGF = GenericGF.AZTEC_DATA_8;
        } else if (this.ddata.getNbLayers() <= 22) {
            i = 10;
            genericGF = GenericGF.AZTEC_DATA_10;
        } else {
            i = 12;
            genericGF = GenericGF.AZTEC_DATA_12;
        }
        int nbDatablocks = this.ddata.getNbDatablocks();
        int length = zArr.length / i;
        if (length < nbDatablocks) {
            throw FormatException.getFormatInstance();
        }
        int length2 = zArr.length % i;
        int[] iArr = new int[length];
        int i2 = 0;
        while (i2 < length) {
            iArr[i2] = readCode(zArr, length2, i);
            i2++;
            length2 += i;
        }
        try {
            new ReedSolomonDecoder(genericGF).decode(iArr, length - nbDatablocks);
            int i3 = (1 << i) - 1;
            int i4 = 0;
            for (i2 = 0; i2 < nbDatablocks; i2++) {
                length2 = iArr[i2];
                if (length2 == 0 || length2 == i3) {
                    throw FormatException.getFormatInstance();
                }
                if (length2 == 1 || length2 == i3 - 1) {
                    i4++;
                }
            }
            boolean[] zArr2 = new boolean[((nbDatablocks * i) - i4)];
            int i5 = 0;
            i2 = 0;
            while (i5 < nbDatablocks) {
                int i6 = iArr[i5];
                boolean z;
                if (i6 == 1 || i6 == i3 - 1) {
                    length2 = (i2 + i) - 1;
                    if (i6 > 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Arrays.fill(zArr2, i2, length2, z);
                    i4 = (i - 1) + i2;
                } else {
                    length2 = i - 1;
                    while (length2 >= 0) {
                        length = i2 + 1;
                        if (((1 << length2) & i6) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zArr2[i2] = z;
                        length2--;
                        i2 = length;
                    }
                    i4 = i2;
                }
                i5++;
                i2 = i4;
            }
            return zArr2;
        } catch (Throwable e) {
            throw FormatException.getFormatInstance(e);
        }
    }

    private boolean[] extractBits(BitMatrix bitMatrix) {
        int i;
        int i2;
        int i3;
        boolean isCompact = this.ddata.isCompact();
        int nbLayers = this.ddata.getNbLayers();
        int i4 = (isCompact ? 11 : 14) + (nbLayers * 4);
        int[] iArr = new int[i4];
        boolean[] zArr = new boolean[totalBitsInLayer(nbLayers, isCompact)];
        if (isCompact) {
            for (i = 0; i < iArr.length; i++) {
                iArr[i] = i;
            }
        } else {
            i2 = i4 / 2;
            i3 = ((i4 + 1) + ((((i4 / 2) - 1) / 15) * 2)) / 2;
            for (i = 0; i < i2; i++) {
                int i5 = (i / 15) + i;
                iArr[(i2 - i) - 1] = (i3 - i5) - 1;
                iArr[i2 + i] = (i5 + i3) + 1;
            }
        }
        i3 = 0;
        for (i5 = 0; i5 < nbLayers; i5++) {
            int i6 = ((nbLayers - i5) * 4) + (isCompact ? 9 : 12);
            int i7 = i5 * 2;
            int i8 = (i4 - 1) - i7;
            for (i2 = 0; i2 < i6; i2++) {
                int i9 = i2 * 2;
                for (i = 0; i < 2; i++) {
                    zArr[(i3 + i9) + i] = bitMatrix.get(iArr[i7 + i], iArr[i7 + i2]);
                    zArr[(((i6 * 2) + i3) + i9) + i] = bitMatrix.get(iArr[i7 + i2], iArr[i8 - i]);
                    zArr[(((i6 * 4) + i3) + i9) + i] = bitMatrix.get(iArr[i8 - i], iArr[i8 - i2]);
                    zArr[(((i6 * 6) + i3) + i9) + i] = bitMatrix.get(iArr[i8 - i2], iArr[i7 + i]);
                }
            }
            i3 = (i6 * 8) + i3;
        }
        return zArr;
    }

    private static int readCode(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    private static byte readByte(boolean[] zArr, int i) {
        int length = zArr.length - i;
        if (length >= 8) {
            return (byte) readCode(zArr, i, 8);
        }
        return (byte) (readCode(zArr, i, length) << (8 - length));
    }

    static byte[] convertBoolArrayToByteArray(boolean[] zArr) {
        byte[] bArr = new byte[((zArr.length + 7) / 8)];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = readByte(zArr, i * 8);
        }
        return bArr;
    }

    private static int totalBitsInLayer(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }
}
