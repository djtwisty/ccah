package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

final class BitMatrixParser {
    private final BitMatrix mappingBitMatrix;
    private final BitMatrix readMappingMatrix;
    private final Version version;

    BitMatrixParser(BitMatrix bitMatrix) {
        int height = bitMatrix.getHeight();
        if (height < 8 || height > 144 || (height & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        this.version = readVersion(bitMatrix);
        this.mappingBitMatrix = extractDataRegion(bitMatrix);
        this.readMappingMatrix = new BitMatrix(this.mappingBitMatrix.getWidth(), this.mappingBitMatrix.getHeight());
    }

    Version getVersion() {
        return this.version;
    }

    private static Version readVersion(BitMatrix bitMatrix) {
        return Version.getVersionForDimensions(bitMatrix.getHeight(), bitMatrix.getWidth());
    }

    byte[] readCodewords() {
        int i;
        byte[] bArr = new byte[this.version.getTotalCodewords()];
        int height = this.mappingBitMatrix.getHeight();
        int width = this.mappingBitMatrix.getWidth();
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        int i2 = 0;
        int i3 = 4;
        int i4 = 0;
        while (true) {
            int i5;
            if (i3 == height && i2 == 0 && r4 == null) {
                i = i4 + 1;
                bArr[i4] = (byte) readCorner1(height, width);
                i5 = i3 - 2;
                i2 += 2;
                obj4 = 1;
            } else if (i3 == height - 2 && i2 == 0 && (width & 3) != 0 && r3 == null) {
                i = i4 + 1;
                bArr[i4] = (byte) readCorner2(height, width);
                i5 = i3 - 2;
                i2 += 2;
                int i6 = 1;
            } else if (i3 == height + 4 && i2 == 2 && (width & 7) == 0 && r2 == null) {
                i = i4 + 1;
                bArr[i4] = (byte) readCorner3(height, width);
                i5 = i3 - 2;
                i2 += 2;
                int i7 = 1;
            } else if (i3 == height - 2 && i2 == 0 && (width & 7) == 4 && r0 == null) {
                i = i4 + 1;
                bArr[i4] = (byte) readCorner4(height, width);
                i5 = i3 - 2;
                i2 += 2;
                int i8 = 1;
            } else {
                i = i2;
                int i9 = i3;
                i5 = i4;
                while (true) {
                    if (i9 >= height || i < 0 || this.readMappingMatrix.get(i, i9)) {
                        i2 = i5;
                    } else {
                        i2 = i5 + 1;
                        bArr[i5] = (byte) readUtah(i9, i, height, width);
                    }
                    i9 -= 2;
                    i3 = i + 2;
                    if (i9 < 0 || i3 >= width) {
                        i5 = i3 + 3;
                        i9++;
                    } else {
                        i = i3;
                        i5 = i2;
                    }
                }
                i5 = i3 + 3;
                i9++;
                while (true) {
                    if (i9 < 0 || i5 >= width || this.readMappingMatrix.get(i5, i9)) {
                        i = i2;
                    } else {
                        i = i2 + 1;
                        bArr[i2] = (byte) readUtah(i9, i5, height, width);
                    }
                    i9 += 2;
                    i3 = i5 - 2;
                    if (i9 >= height || i3 < 0) {
                        i5 = i9 + 3;
                        i2 = i3 + 1;
                    } else {
                        i5 = i3;
                        i2 = i;
                    }
                }
                i5 = i9 + 3;
                i2 = i3 + 1;
            }
            if (i5 >= height && r5 >= width) {
                break;
            }
            i3 = i5;
            i4 = i;
        }
        if (i == this.version.getTotalCodewords()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    private boolean readModule(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (i < 0) {
            i5 = i + i3;
            i6 = (4 - ((i3 + 4) & 7)) + i2;
        } else {
            i6 = i2;
            i5 = i;
        }
        if (i6 < 0) {
            i6 += i4;
            i5 += 4 - ((i4 + 4) & 7);
        }
        this.readMappingMatrix.set(i6, i5);
        return this.mappingBitMatrix.get(i6, i5);
    }

    private int readUtah(int i, int i2, int i3, int i4) {
        int i5 = 0;
        if (readModule(i - 2, i2 - 2, i3, i4)) {
            i5 = 1;
        }
        i5 <<= 1;
        if (readModule(i - 2, i2 - 1, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (readModule(i - 1, i2 - 2, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (readModule(i - 1, i2 - 1, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (readModule(i - 1, i2, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (readModule(i, i2 - 2, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (readModule(i, i2 - 1, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (readModule(i, i2, i3, i4)) {
            return i5 | 1;
        }
        return i5;
    }

    private int readCorner1(int i, int i2) {
        int i3;
        if (readModule(i - 1, 0, i, i2)) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        i3 <<= 1;
        if (readModule(i - 1, 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(i - 1, 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(1, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(2, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(3, i2 - 1, i, i2)) {
            return i3 | 1;
        }
        return i3;
    }

    private int readCorner2(int i, int i2) {
        int i3;
        if (readModule(i - 3, 0, i, i2)) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        i3 <<= 1;
        if (readModule(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(i - 1, 0, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 4, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 3, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(1, i2 - 1, i, i2)) {
            return i3 | 1;
        }
        return i3;
    }

    private int readCorner3(int i, int i2) {
        int i3;
        if (readModule(i - 1, 0, i, i2)) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        i3 <<= 1;
        if (readModule(i - 1, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 3, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(1, i2 - 3, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(1, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(1, i2 - 1, i, i2)) {
            return i3 | 1;
        }
        return i3;
    }

    private int readCorner4(int i, int i2) {
        int i3;
        if (readModule(i - 3, 0, i, i2)) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        i3 <<= 1;
        if (readModule(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(i - 1, 0, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(0, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(1, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(2, i2 - 1, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (readModule(3, i2 - 1, i, i2)) {
            return i3 | 1;
        }
        return i3;
    }

    private BitMatrix extractDataRegion(BitMatrix bitMatrix) {
        int symbolSizeRows = this.version.getSymbolSizeRows();
        int symbolSizeColumns = this.version.getSymbolSizeColumns();
        if (bitMatrix.getHeight() != symbolSizeRows) {
            throw new IllegalArgumentException("Dimension of bitMarix must match the version size");
        }
        int dataRegionSizeRows = this.version.getDataRegionSizeRows();
        int dataRegionSizeColumns = this.version.getDataRegionSizeColumns();
        int i = symbolSizeRows / dataRegionSizeRows;
        int i2 = symbolSizeColumns / dataRegionSizeColumns;
        BitMatrix bitMatrix2 = new BitMatrix(i2 * dataRegionSizeColumns, i * dataRegionSizeRows);
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i3 * dataRegionSizeRows;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = i5 * dataRegionSizeColumns;
                for (symbolSizeColumns = 0; symbolSizeColumns < dataRegionSizeRows; symbolSizeColumns++) {
                    int i7 = (((dataRegionSizeRows + 2) * i3) + 1) + symbolSizeColumns;
                    int i8 = i4 + symbolSizeColumns;
                    for (symbolSizeRows = 0; symbolSizeRows < dataRegionSizeColumns; symbolSizeRows++) {
                        if (bitMatrix.get((((dataRegionSizeColumns + 2) * i5) + 1) + symbolSizeRows, i7)) {
                            bitMatrix2.set(i6 + symbolSizeRows, i8);
                        }
                    }
                }
            }
        }
        return bitMatrix2;
    }
}
