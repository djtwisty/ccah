package com.google.zxing.qrcode.decoder;

import com.google.zxing.qrcode.decoder.Version.ECB;
import com.google.zxing.qrcode.decoder.Version.ECBlocks;

final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i, byte[] bArr) {
        this.numDataCodewords = i;
        this.codewords = bArr;
    }

    static DataBlock[] getDataBlocks(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length != version.getTotalCodewords()) {
            throw new IllegalArgumentException();
        }
        int i;
        int i2;
        int i3;
        ECBlocks eCBlocksForLevel = version.getECBlocksForLevel(errorCorrectionLevel);
        ECB[] eCBlocks = eCBlocksForLevel.getECBlocks();
        int i4 = 0;
        for (ECB count : eCBlocks) {
            i4 += count.getCount();
        }
        DataBlock[] dataBlockArr = new DataBlock[i4];
        i4 = 0;
        for (ECB ecb : eCBlocks) {
            i = 0;
            while (i < ecb.getCount()) {
                int dataCodewords = ecb.getDataCodewords();
                i3 = i4 + 1;
                dataBlockArr[i4] = new DataBlock(dataCodewords, new byte[(eCBlocksForLevel.getECCodewordsPerBlock() + dataCodewords)]);
                i++;
                i4 = i3;
            }
        }
        i3 = dataBlockArr[0].codewords.length;
        i = dataBlockArr.length - 1;
        while (i >= 0 && dataBlockArr[i].codewords.length != i3) {
            i--;
        }
        int i5 = i + 1;
        i3 -= eCBlocksForLevel.getECCodewordsPerBlock();
        int i6 = 0;
        i = 0;
        while (i6 < i3) {
            i2 = 0;
            int i7 = i;
            while (i2 < i4) {
                int i8 = i7 + 1;
                dataBlockArr[i2].codewords[i6] = bArr[i7];
                i2++;
                i7 = i8;
            }
            i6++;
            i = i7;
        }
        i2 = i5;
        while (i2 < i4) {
            i7 = i + 1;
            dataBlockArr[i2].codewords[i3] = bArr[i];
            i2++;
            i = i7;
        }
        i6 = dataBlockArr[0].codewords.length;
        while (i3 < i6) {
            i2 = 0;
            i7 = i;
            while (i2 < i4) {
                i8 = i7 + 1;
                dataBlockArr[i2].codewords[i2 < i5 ? i3 : i3 + 1] = bArr[i7];
                i2++;
                i7 = i8;
            }
            i3++;
            i = i7;
        }
        return dataBlockArr;
    }

    int getNumDataCodewords() {
        return this.numDataCodewords;
    }

    byte[] getCodewords() {
        return this.codewords;
    }
}
