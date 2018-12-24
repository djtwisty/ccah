package com.google.zxing.datamatrix.decoder;

final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i, byte[] bArr) {
        this.numDataCodewords = i;
        this.codewords = bArr;
    }

    static DataBlock[] getDataBlocks(byte[] bArr, Version version) {
        int i;
        int i2;
        int i3;
        int i4;
        ECBlocks eCBlocks = version.getECBlocks();
        ECB[] eCBlocks2 = eCBlocks.getECBlocks();
        int i5 = 0;
        for (ECB count : eCBlocks2) {
            i5 += count.getCount();
        }
        DataBlock[] dataBlockArr = new DataBlock[i5];
        i5 = 0;
        for (ECB ecb : eCBlocks2) {
            i = 0;
            while (i < ecb.getCount()) {
                int dataCodewords = ecb.getDataCodewords();
                i3 = i5 + 1;
                dataBlockArr[i5] = new DataBlock(dataCodewords, new byte[(eCBlocks.getECCodewords() + dataCodewords)]);
                i++;
                i5 = i3;
            }
        }
        i3 = dataBlockArr[0].codewords.length - eCBlocks.getECCodewords();
        int i6 = i3 - 1;
        int i7 = 0;
        for (i4 = 0; i4 < i6; i4++) {
            i = 0;
            while (i < i5) {
                i2 = i7 + 1;
                dataBlockArr[i].codewords[i4] = bArr[i7];
                i++;
                i7 = i2;
            }
        }
        if (version.getVersionNumber() == 24) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        if (i6 != 0) {
            i = 8;
        } else {
            i = i5;
        }
        i2 = 0;
        while (i2 < i) {
            i4 = i7 + 1;
            dataBlockArr[i2].codewords[i3 - 1] = bArr[i7];
            i2++;
            i7 = i4;
        }
        int length = dataBlockArr[0].codewords.length;
        i = i7;
        while (i3 < length) {
            i4 = 0;
            i7 = i;
            while (i4 < i5) {
                if (i6 != 0) {
                    i2 = (i4 + 8) % i5;
                } else {
                    i2 = i4;
                }
                if (i6 == 0 || i2 <= 7) {
                    i = i3;
                } else {
                    i = i3 - 1;
                }
                byte[] bArr2 = dataBlockArr[i2].codewords;
                i2 = i7 + 1;
                bArr2[i] = bArr[i7];
                i4++;
                i7 = i2;
            }
            i3++;
            i = i7;
        }
        if (i == bArr.length) {
            return dataBlockArr;
        }
        throw new IllegalArgumentException();
    }

    int getNumDataCodewords() {
        return this.numDataCodewords;
    }

    byte[] getCodewords() {
        return this.codewords;
    }
}
