package com.google.zxing.pdf417.decoder;

import com.google.zxing.ResultPoint;

final class DetectionResultRowIndicatorColumn extends DetectionResultColumn {
    private final boolean isLeft;

    DetectionResultRowIndicatorColumn(BoundingBox boundingBox, boolean z) {
        super(boundingBox);
        this.isLeft = z;
    }

    private void setRowNumbers() {
        for (Codeword codeword : getCodewords()) {
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
            }
        }
    }

    void adjustCompleteIndicatorColumnRowNumbers(BarcodeMetadata barcodeMetadata) {
        Codeword[] codewords = getCodewords();
        setRowNumbers();
        removeIncorrectCodewords(codewords, barcodeMetadata);
        BoundingBox boundingBox = getBoundingBox();
        ResultPoint topLeft = this.isLeft ? boundingBox.getTopLeft() : boundingBox.getTopRight();
        ResultPoint bottomLeft = this.isLeft ? boundingBox.getBottomLeft() : boundingBox.getBottomRight();
        int imageRowToCodewordIndex = imageRowToCodewordIndex((int) topLeft.getY());
        int imageRowToCodewordIndex2 = imageRowToCodewordIndex((int) bottomLeft.getY());
        int i = -1;
        int i2 = imageRowToCodewordIndex;
        int i3 = 0;
        int i4 = 1;
        while (i2 < imageRowToCodewordIndex2) {
            if (codewords[i2] == null) {
                imageRowToCodewordIndex = i3;
            } else {
                Codeword codeword = codewords[i2];
                imageRowToCodewordIndex = codeword.getRowNumber() - i;
                if (imageRowToCodewordIndex == 0) {
                    imageRowToCodewordIndex = i3 + 1;
                } else if (imageRowToCodewordIndex == 1) {
                    i3 = Math.max(i4, i3);
                    i = codeword.getRowNumber();
                    imageRowToCodewordIndex = 1;
                    i4 = i3;
                } else if (imageRowToCodewordIndex < 0 || codeword.getRowNumber() >= barcodeMetadata.getRowCount() || imageRowToCodewordIndex > i2) {
                    codewords[i2] = null;
                    imageRowToCodewordIndex = i3;
                } else {
                    int i5;
                    Object obj;
                    if (i4 > 2) {
                        i5 = imageRowToCodewordIndex * (i4 - 2);
                    } else {
                        i5 = imageRowToCodewordIndex;
                    }
                    if (i5 >= i2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    for (int i6 = 1; i6 <= i5 && obj == null; i6++) {
                        if (codewords[i2 - i6] != null) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                    }
                    if (obj != null) {
                        codewords[i2] = null;
                        imageRowToCodewordIndex = i3;
                    } else {
                        imageRowToCodewordIndex = 1;
                        i = codeword.getRowNumber();
                    }
                }
            }
            i2++;
            i3 = imageRowToCodewordIndex;
        }
    }

    int[] getRowHeights() {
        BarcodeMetadata barcodeMetadata = getBarcodeMetadata();
        if (barcodeMetadata == null) {
            return null;
        }
        adjustIncompleteIndicatorColumnRowNumbers(barcodeMetadata);
        int[] iArr = new int[barcodeMetadata.getRowCount()];
        for (Codeword codeword : getCodewords()) {
            if (codeword != null) {
                int rowNumber = codeword.getRowNumber();
                if (rowNumber < iArr.length) {
                    iArr[rowNumber] = iArr[rowNumber] + 1;
                }
            }
        }
        return iArr;
    }

    private void adjustIncompleteIndicatorColumnRowNumbers(BarcodeMetadata barcodeMetadata) {
        BoundingBox boundingBox = getBoundingBox();
        ResultPoint topLeft = this.isLeft ? boundingBox.getTopLeft() : boundingBox.getTopRight();
        ResultPoint bottomLeft = this.isLeft ? boundingBox.getBottomLeft() : boundingBox.getBottomRight();
        int imageRowToCodewordIndex = imageRowToCodewordIndex((int) bottomLeft.getY());
        Codeword[] codewords = getCodewords();
        int i = -1;
        int i2 = 0;
        int i3 = 1;
        for (int imageRowToCodewordIndex2 = imageRowToCodewordIndex((int) topLeft.getY()); imageRowToCodewordIndex2 < imageRowToCodewordIndex; imageRowToCodewordIndex2++) {
            if (codewords[imageRowToCodewordIndex2] != null) {
                Codeword codeword = codewords[imageRowToCodewordIndex2];
                codeword.setRowNumberAsRowIndicatorColumn();
                int rowNumber = codeword.getRowNumber() - i;
                if (rowNumber == 0) {
                    i2++;
                } else if (rowNumber == 1) {
                    i3 = Math.max(i3, i2);
                    i = codeword.getRowNumber();
                    i2 = 1;
                } else if (codeword.getRowNumber() >= barcodeMetadata.getRowCount()) {
                    codewords[imageRowToCodewordIndex2] = null;
                } else {
                    i = codeword.getRowNumber();
                    i2 = 1;
                }
            }
        }
    }

    BarcodeMetadata getBarcodeMetadata() {
        Codeword[] codewords = getCodewords();
        BarcodeValue barcodeValue = new BarcodeValue();
        BarcodeValue barcodeValue2 = new BarcodeValue();
        BarcodeValue barcodeValue3 = new BarcodeValue();
        BarcodeValue barcodeValue4 = new BarcodeValue();
        for (Codeword codeword : codewords) {
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
                int value = codeword.getValue() % 30;
                int rowNumber = codeword.getRowNumber();
                if (!this.isLeft) {
                    rowNumber += 2;
                }
                switch (rowNumber % 3) {
                    case 0:
                        barcodeValue2.setValue((value * 3) + 1);
                        break;
                    case 1:
                        barcodeValue4.setValue(value / 3);
                        barcodeValue3.setValue(value % 3);
                        break;
                    case 2:
                        barcodeValue.setValue(value + 1);
                        break;
                    default:
                        break;
                }
            }
        }
        if (barcodeValue.getValue().length == 0 || barcodeValue2.getValue().length == 0 || barcodeValue3.getValue().length == 0 || barcodeValue4.getValue().length == 0 || barcodeValue.getValue()[0] < 1 || barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] < 3 || barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] > 90) {
            return null;
        }
        BarcodeMetadata barcodeMetadata = new BarcodeMetadata(barcodeValue.getValue()[0], barcodeValue2.getValue()[0], barcodeValue3.getValue()[0], barcodeValue4.getValue()[0]);
        removeIncorrectCodewords(codewords, barcodeMetadata);
        return barcodeMetadata;
    }

    private void removeIncorrectCodewords(Codeword[] codewordArr, BarcodeMetadata barcodeMetadata) {
        for (int i = 0; i < codewordArr.length; i++) {
            Codeword codeword = codewordArr[i];
            if (codewordArr[i] != null) {
                int value = codeword.getValue() % 30;
                int rowNumber = codeword.getRowNumber();
                if (rowNumber <= barcodeMetadata.getRowCount()) {
                    if (!this.isLeft) {
                        rowNumber += 2;
                    }
                    switch (rowNumber % 3) {
                        case 0:
                            if ((value * 3) + 1 == barcodeMetadata.getRowCountUpperPart()) {
                                break;
                            }
                            codewordArr[i] = null;
                            break;
                        case 1:
                            if (value / 3 != barcodeMetadata.getErrorCorrectionLevel() || value % 3 != barcodeMetadata.getRowCountLowerPart()) {
                                codewordArr[i] = null;
                                break;
                            }
                            break;
                            break;
                        case 2:
                            if (value + 1 == barcodeMetadata.getColumnCount()) {
                                break;
                            }
                            codewordArr[i] = null;
                            break;
                        default:
                            break;
                    }
                }
                codewordArr[i] = null;
            }
        }
    }

    boolean isLeft() {
        return this.isLeft;
    }

    public String toString() {
        return "IsLeft: " + this.isLeft + '\n' + super.toString();
    }
}
