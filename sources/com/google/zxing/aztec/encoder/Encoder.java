package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

public final class Encoder {
    public static final int DEFAULT_AZTEC_LAYERS = 0;
    public static final int DEFAULT_EC_PERCENT = 33;
    private static final int MAX_NB_BITS = 32;
    private static final int MAX_NB_BITS_COMPACT = 4;
    private static final int[] WORD_SIZE = new int[]{4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private Encoder() {
    }

    public static AztecCode encode(byte[] bArr) {
        return encode(bArr, 33, 0);
    }

    public static AztecCode encode(byte[] bArr, int i, int i2) {
        int totalBitsInLayer;
        BitArray bitArray;
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        BitArray encode = new HighLevelEncoder(bArr).encode();
        int size = ((encode.getSize() * i) / 100) + 11;
        int size2 = encode.getSize() + size;
        int i7;
        int i8;
        if (i2 != 0) {
            boolean z2 = i2 < 0;
            size2 = Math.abs(i2);
            if (size2 > (z2 ? 4 : 32)) {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", new Object[]{Integer.valueOf(i2)}));
            }
            totalBitsInLayer = totalBitsInLayer(size2, z2);
            i7 = WORD_SIZE[size2];
            i8 = totalBitsInLayer - (totalBitsInLayer % i7);
            BitArray stuffBits = stuffBits(encode, i7);
            if (stuffBits.getSize() + size > i8) {
                throw new IllegalArgumentException("Data to large for user specified layer");
            } else if (!z2 || stuffBits.getSize() <= i7 * 64) {
                bitArray = stuffBits;
                i3 = i7;
                z = z2;
            } else {
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
        }
        i4 = 0;
        BitArray bitArray2 = null;
        i8 = 0;
        while (i8 <= 32) {
            z = i8 <= 3;
            if (z) {
                i7 = i8 + 1;
            } else {
                i7 = i8;
            }
            totalBitsInLayer = totalBitsInLayer(i7, z);
            if (size2 <= totalBitsInLayer) {
                if (i4 != WORD_SIZE[i7]) {
                    i4 = WORD_SIZE[i7];
                    bitArray2 = stuffBits(encode, i4);
                }
                i5 = totalBitsInLayer - (totalBitsInLayer % i4);
                if ((!z || bitArray2.getSize() <= i4 * 64) && bitArray2.getSize() + size <= i5) {
                    bitArray = bitArray2;
                    i3 = i4;
                    size2 = i7;
                }
            }
            i8++;
        }
        throw new IllegalArgumentException("Data too large for an Aztec code");
        BitArray generateCheckWords = generateCheckWords(bitArray, totalBitsInLayer, i3);
        i5 = bitArray.getSize() / i3;
        BitArray generateModeMessage = generateModeMessage(z, size2, i5);
        i4 = (size2 * 4) + (z ? 11 : 14);
        int[] iArr = new int[i4];
        if (z) {
            for (i6 = 0; i6 < iArr.length; i6++) {
                iArr[i6] = i6;
            }
            i6 = i4;
        } else {
            i6 = (i4 + 1) + ((((i4 / 2) - 1) / 15) * 2);
            i8 = i4 / 2;
            i3 = i6 / 2;
            for (i7 = 0; i7 < i8; i7++) {
                totalBitsInLayer = (i7 / 15) + i7;
                iArr[(i8 - i7) - 1] = (i3 - totalBitsInLayer) - 1;
                iArr[i8 + i7] = (totalBitsInLayer + i3) + 1;
            }
        }
        BitMatrix bitMatrix = new BitMatrix(i6);
        i3 = 0;
        for (totalBitsInLayer = 0; totalBitsInLayer < size2; totalBitsInLayer++) {
            int i9 = ((size2 - totalBitsInLayer) * 4) + (z ? 9 : 12);
            for (i8 = 0; i8 < i9; i8++) {
                int i10 = i8 * 2;
                for (i7 = 0; i7 < 2; i7++) {
                    if (generateCheckWords.get((i3 + i10) + i7)) {
                        bitMatrix.set(iArr[(totalBitsInLayer * 2) + i7], iArr[(totalBitsInLayer * 2) + i8]);
                    }
                    if (generateCheckWords.get((((i9 * 2) + i3) + i10) + i7)) {
                        bitMatrix.set(iArr[(totalBitsInLayer * 2) + i8], iArr[((i4 - 1) - (totalBitsInLayer * 2)) - i7]);
                    }
                    if (generateCheckWords.get((((i9 * 4) + i3) + i10) + i7)) {
                        bitMatrix.set(iArr[((i4 - 1) - (totalBitsInLayer * 2)) - i7], iArr[((i4 - 1) - (totalBitsInLayer * 2)) - i8]);
                    }
                    if (generateCheckWords.get((((i9 * 6) + i3) + i10) + i7)) {
                        bitMatrix.set(iArr[((i4 - 1) - (totalBitsInLayer * 2)) - i8], iArr[(totalBitsInLayer * 2) + i7]);
                    }
                }
            }
            i3 = (i9 * 8) + i3;
        }
        drawModeMessage(bitMatrix, z, i6, generateModeMessage);
        if (z) {
            drawBullsEye(bitMatrix, i6 / 2, 5);
        } else {
            drawBullsEye(bitMatrix, i6 / 2, 7);
            i8 = 0;
            i7 = 0;
            while (i8 < (i4 / 2) - 1) {
                for (i3 = (i6 / 2) & 1; i3 < i6; i3 += 2) {
                    bitMatrix.set((i6 / 2) - i7, i3);
                    bitMatrix.set((i6 / 2) + i7, i3);
                    bitMatrix.set(i3, (i6 / 2) - i7);
                    bitMatrix.set(i3, (i6 / 2) + i7);
                }
                i8 += 15;
                i7 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.setCompact(z);
        aztecCode.setSize(i6);
        aztecCode.setLayers(size2);
        aztecCode.setCodeWords(i5);
        aztecCode.setMatrix(bitMatrix);
        return aztecCode;
    }

    private static void drawBullsEye(BitMatrix bitMatrix, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            for (int i4 = i - i3; i4 <= i + i3; i4++) {
                bitMatrix.set(i4, i - i3);
                bitMatrix.set(i4, i + i3);
                bitMatrix.set(i - i3, i4);
                bitMatrix.set(i + i3, i4);
            }
        }
        bitMatrix.set(i - i2, i - i2);
        bitMatrix.set((i - i2) + 1, i - i2);
        bitMatrix.set(i - i2, (i - i2) + 1);
        bitMatrix.set(i + i2, i - i2);
        bitMatrix.set(i + i2, (i - i2) + 1);
        bitMatrix.set(i + i2, (i + i2) - 1);
    }

    static BitArray generateModeMessage(boolean z, int i, int i2) {
        BitArray bitArray = new BitArray();
        if (z) {
            bitArray.appendBits(i - 1, 2);
            bitArray.appendBits(i2 - 1, 6);
            return generateCheckWords(bitArray, 28, 4);
        }
        bitArray.appendBits(i - 1, 5);
        bitArray.appendBits(i2 - 1, 11);
        return generateCheckWords(bitArray, 40, 4);
    }

    private static void drawModeMessage(BitMatrix bitMatrix, boolean z, int i, BitArray bitArray) {
        int i2 = 0;
        int i3 = i / 2;
        int i4;
        if (z) {
            while (i2 < 7) {
                i4 = (i3 - 3) + i2;
                if (bitArray.get(i2)) {
                    bitMatrix.set(i4, i3 - 5);
                }
                if (bitArray.get(i2 + 7)) {
                    bitMatrix.set(i3 + 5, i4);
                }
                if (bitArray.get(20 - i2)) {
                    bitMatrix.set(i4, i3 + 5);
                }
                if (bitArray.get(27 - i2)) {
                    bitMatrix.set(i3 - 5, i4);
                }
                i2++;
            }
            return;
        }
        while (i2 < 10) {
            i4 = ((i3 - 5) + i2) + (i2 / 5);
            if (bitArray.get(i2)) {
                bitMatrix.set(i4, i3 - 7);
            }
            if (bitArray.get(i2 + 10)) {
                bitMatrix.set(i3 + 7, i4);
            }
            if (bitArray.get(29 - i2)) {
                bitMatrix.set(i4, i3 + 7);
            }
            if (bitArray.get(39 - i2)) {
                bitMatrix.set(i3 - 7, i4);
            }
            i2++;
        }
    }

    private static BitArray generateCheckWords(BitArray bitArray, int i, int i2) {
        int i3 = 0;
        int size = bitArray.getSize() / i2;
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(i2));
        int i4 = i / i2;
        int[] bitsToWords = bitsToWords(bitArray, i2, i4);
        reedSolomonEncoder.encode(bitsToWords, i4 - size);
        size = i % i2;
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(0, size);
        size = bitsToWords.length;
        while (i3 < size) {
            bitArray2.appendBits(bitsToWords[i3], i2);
            i3++;
        }
        return bitArray2;
    }

    private static int[] bitsToWords(BitArray bitArray, int i, int i2) {
        int[] iArr = new int[i2];
        int size = bitArray.getSize() / i;
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6;
                if (bitArray.get((i3 * i) + i5)) {
                    i6 = 1 << ((i - i5) - 1);
                } else {
                    i6 = 0;
                }
                i4 |= i6;
            }
            iArr[i3] = i4;
        }
        return iArr;
    }

    private static GenericGF getGF(int i) {
        switch (i) {
            case 4:
                return GenericGF.AZTEC_PARAM;
            case 6:
                return GenericGF.AZTEC_DATA_6;
            case 8:
                return GenericGF.AZTEC_DATA_8;
            case 10:
                return GenericGF.AZTEC_DATA_10;
            case 12:
                return GenericGF.AZTEC_DATA_12;
            default:
                throw new IllegalArgumentException("Unsupported word size " + i);
        }
    }

    static BitArray stuffBits(BitArray bitArray, int i) {
        BitArray bitArray2 = new BitArray();
        int size = bitArray.getSize();
        int i2 = (1 << i) - 2;
        int i3 = 0;
        while (i3 < size) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < i) {
                if (i3 + i4 >= size || bitArray.get(i3 + i4)) {
                    i5 |= 1 << ((i - 1) - i4);
                }
                i4++;
            }
            if ((i5 & i2) == i2) {
                bitArray2.appendBits(i5 & i2, i);
                i5 = i3 - 1;
            } else if ((i5 & i2) == 0) {
                bitArray2.appendBits(i5 | 1, i);
                i5 = i3 - 1;
            } else {
                bitArray2.appendBits(i5, i);
                i5 = i3;
            }
            i3 = i5 + i;
        }
        return bitArray2;
    }

    private static int totalBitsInLayer(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }
}
