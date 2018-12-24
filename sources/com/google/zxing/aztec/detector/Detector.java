package com.google.zxing.aztec.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

public final class Detector {
    private static final int[] EXPECTED_CORNER_BITS = new int[]{3808, 476, 2107, 1799};
    private boolean compact;
    private final BitMatrix image;
    private int nbCenterLayers;
    private int nbDataBlocks;
    private int nbLayers;
    private int shift;

    static final class Point {
        /* renamed from: x */
        private final int f628x;
        /* renamed from: y */
        private final int f629y;

        ResultPoint toResultPoint() {
            return new ResultPoint((float) getX(), (float) getY());
        }

        Point(int i, int i2) {
            this.f628x = i;
            this.f629y = i2;
        }

        int getX() {
            return this.f628x;
        }

        int getY() {
            return this.f629y;
        }

        public String toString() {
            return "<" + this.f628x + ' ' + this.f629y + '>';
        }
    }

    public Detector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    public AztecDetectorResult detect() {
        return detect(false);
    }

    public AztecDetectorResult detect(boolean z) {
        ResultPoint[] bullsEyeCorners = getBullsEyeCorners(getMatrixCenter());
        if (z) {
            ResultPoint resultPoint = bullsEyeCorners[0];
            bullsEyeCorners[0] = bullsEyeCorners[2];
            bullsEyeCorners[2] = resultPoint;
        }
        extractParameters(bullsEyeCorners);
        return new AztecDetectorResult(sampleGrid(this.image, bullsEyeCorners[this.shift % 4], bullsEyeCorners[(this.shift + 1) % 4], bullsEyeCorners[(this.shift + 2) % 4], bullsEyeCorners[(this.shift + 3) % 4]), getMatrixCornerPoints(bullsEyeCorners), this.compact, this.nbDataBlocks, this.nbLayers);
    }

    private void extractParameters(ResultPoint[] resultPointArr) {
        if (isValid(resultPointArr[0]) && isValid(resultPointArr[1]) && isValid(resultPointArr[2]) && isValid(resultPointArr[3])) {
            int i;
            int[] iArr = new int[]{sampleLine(resultPointArr[0], resultPointArr[1], r1), sampleLine(resultPointArr[1], resultPointArr[2], r1), sampleLine(resultPointArr[2], resultPointArr[3], r1), sampleLine(resultPointArr[3], resultPointArr[0], this.nbCenterLayers * 2)};
            this.shift = getRotation(iArr, this.nbCenterLayers * 2);
            long j = 0;
            int i2 = 0;
            while (i2 < 4) {
                long j2;
                i = iArr[(this.shift + i2) % 4];
                if (this.compact) {
                    j2 = ((long) ((i >> 1) & 127)) + (j << 7);
                } else {
                    j2 = ((long) (((i >> 1) & 31) + ((i >> 2) & 992))) + (j << 10);
                }
                i2++;
                j = j2;
            }
            i = getCorrectedParameterData(j, this.compact);
            if (this.compact) {
                this.nbLayers = (i >> 6) + 1;
                this.nbDataBlocks = (i & 63) + 1;
                return;
            }
            this.nbLayers = (i >> 11) + 1;
            this.nbDataBlocks = (i & 2047) + 1;
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int getRotation(int[] iArr, int i) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += (i4 & 1) + ((i4 >> (i - 2)) << 1);
        }
        int i5 = ((i3 & 1) << 11) + (i3 >> 1);
        while (i2 < 4) {
            if (Integer.bitCount(EXPECTED_CORNER_BITS[i2] ^ i5) <= 2) {
                return i2;
            }
            i2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int getCorrectedParameterData(long j, boolean z) {
        int i;
        int i2;
        if (z) {
            i = 7;
            i2 = 2;
        } else {
            i = 10;
            i2 = 4;
        }
        int i3 = i - i2;
        int[] iArr = new int[i];
        for (i--; i >= 0; i--) {
            iArr[i] = ((int) j) & 15;
            j >>= 4;
        }
        try {
            new ReedSolomonDecoder(GenericGF.AZTEC_PARAM).decode(iArr, i3);
            int i4 = 0;
            i = 0;
            while (i4 < i2) {
                i4++;
                i = iArr[i4] + (i << 4);
            }
            return i;
        } catch (ReedSolomonException e) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private ResultPoint[] getBullsEyeCorners(Point point) {
        boolean z = true;
        this.nbCenterLayers = 1;
        Point point2 = point;
        Point point3 = point;
        Point point4 = point;
        Point point5 = point;
        while (this.nbCenterLayers < 9) {
            Point firstDifferent = getFirstDifferent(point5, z, 1, -1);
            Point firstDifferent2 = getFirstDifferent(point4, z, 1, 1);
            Point firstDifferent3 = getFirstDifferent(point3, z, -1, 1);
            point = getFirstDifferent(point2, z, -1, -1);
            if (this.nbCenterLayers > 2) {
                float distance = (distance(point, firstDifferent) * ((float) this.nbCenterLayers)) / (distance(point2, point5) * ((float) (this.nbCenterLayers + 2)));
                if (((double) distance) >= 0.75d) {
                    if (((double) distance) <= 1.25d) {
                        if (!isWhiteOrBlackRectangle(firstDifferent, firstDifferent2, firstDifferent3, point)) {
                            break;
                        }
                    }
                    break;
                }
                break;
            }
            if (z) {
                z = false;
            } else {
                z = true;
            }
            this.nbCenterLayers++;
            point2 = point;
            point3 = firstDifferent3;
            point4 = firstDifferent2;
            point5 = firstDifferent;
        }
        if (this.nbCenterLayers == 5 || this.nbCenterLayers == 7) {
            this.compact = this.nbCenterLayers == 5;
            ResultPoint resultPoint = new ResultPoint(((float) point5.getX()) + 0.5f, ((float) point5.getY()) - 0.5f);
            ResultPoint resultPoint2 = new ResultPoint(((float) point4.getX()) + 0.5f, ((float) point4.getY()) + 0.5f);
            ResultPoint resultPoint3 = new ResultPoint(((float) point3.getX()) - 0.5f, ((float) point3.getY()) + 0.5f);
            ResultPoint resultPoint4 = new ResultPoint(((float) point2.getX()) - 0.5f, ((float) point2.getY()) - 0.5f);
            return expandSquare(new ResultPoint[]{resultPoint, resultPoint2, resultPoint3, resultPoint4}, (float) ((this.nbCenterLayers * 2) - 3), (float) (this.nbCenterLayers * 2));
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private Point getMatrixCenter() {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        ResultPoint resultPoint4;
        int width;
        int height;
        try {
            ResultPoint[] detect = new WhiteRectangleDetector(this.image).detect();
            resultPoint = detect[0];
            resultPoint2 = detect[1];
            resultPoint3 = detect[2];
            resultPoint4 = detect[3];
        } catch (NotFoundException e) {
            width = this.image.getWidth() / 2;
            height = this.image.getHeight() / 2;
            resultPoint = getFirstDifferent(new Point(width + 7, height - 7), false, 1, -1).toResultPoint();
            resultPoint2 = getFirstDifferent(new Point(width + 7, height + 7), false, 1, 1).toResultPoint();
            resultPoint3 = getFirstDifferent(new Point(width - 7, height + 7), false, -1, 1).toResultPoint();
            resultPoint4 = getFirstDifferent(new Point(width - 7, height - 7), false, -1, -1).toResultPoint();
        }
        height = MathUtils.round((((resultPoint.getX() + resultPoint4.getX()) + resultPoint2.getX()) + resultPoint3.getX()) / 4.0f);
        width = MathUtils.round((((resultPoint4.getY() + resultPoint.getY()) + resultPoint2.getY()) + resultPoint3.getY()) / 4.0f);
        try {
            ResultPoint[] detect2 = new WhiteRectangleDetector(this.image, 15, height, width).detect();
            resultPoint = detect2[0];
            resultPoint2 = detect2[1];
            resultPoint3 = detect2[2];
            resultPoint4 = detect2[3];
        } catch (NotFoundException e2) {
            resultPoint = getFirstDifferent(new Point(height + 7, width - 7), false, 1, -1).toResultPoint();
            resultPoint2 = getFirstDifferent(new Point(height + 7, width + 7), false, 1, 1).toResultPoint();
            resultPoint3 = getFirstDifferent(new Point(height - 7, width + 7), false, -1, 1).toResultPoint();
            resultPoint4 = getFirstDifferent(new Point(height - 7, width - 7), false, -1, -1).toResultPoint();
        }
        return new Point(MathUtils.round((((resultPoint.getX() + resultPoint4.getX()) + resultPoint2.getX()) + resultPoint3.getX()) / 4.0f), MathUtils.round((((resultPoint4.getY() + resultPoint.getY()) + resultPoint2.getY()) + resultPoint3.getY()) / 4.0f));
    }

    private ResultPoint[] getMatrixCornerPoints(ResultPoint[] resultPointArr) {
        return expandSquare(resultPointArr, (float) (this.nbCenterLayers * 2), (float) getDimension());
    }

    private BitMatrix sampleGrid(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        GridSampler instance = GridSampler.getInstance();
        int dimension = getDimension();
        float f = (((float) dimension) / 2.0f) - ((float) this.nbCenterLayers);
        float f2 = (((float) dimension) / 2.0f) + ((float) this.nbCenterLayers);
        return instance.sampleGrid(bitMatrix, dimension, dimension, f, f, f2, f, f2, f2, f, f2, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint4.getX(), resultPoint4.getY());
    }

    private int sampleLine(ResultPoint resultPoint, ResultPoint resultPoint2, int i) {
        float distance = distance(resultPoint, resultPoint2);
        float f = distance / ((float) i);
        float x = resultPoint.getX();
        float y = resultPoint.getY();
        float x2 = ((resultPoint2.getX() - resultPoint.getX()) * f) / distance;
        float y2 = (f * (resultPoint2.getY() - resultPoint.getY())) / distance;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (this.image.get(MathUtils.round((((float) i3) * x2) + x), MathUtils.round((((float) i3) * y2) + y))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }

    private boolean isWhiteOrBlackRectangle(Point point, Point point2, Point point3, Point point4) {
        Point point5 = new Point(point.getX() - 3, point.getY() + 3);
        Point point6 = new Point(point2.getX() - 3, point2.getY() - 3);
        Point point7 = new Point(point3.getX() + 3, point3.getY() - 3);
        Point point8 = new Point(point4.getX() + 3, 3 + point4.getY());
        int color = getColor(point8, point5);
        if (color != 0 && getColor(point5, point6) == color && getColor(point6, point7) == color && getColor(point7, point8) == color) {
            return true;
        }
        return false;
    }

    private int getColor(Point point, Point point2) {
        float distance = distance(point, point2);
        float x = ((float) (point2.getX() - point.getX())) / distance;
        float y = ((float) (point2.getY() - point.getY())) / distance;
        int i = 0;
        float x2 = (float) point.getX();
        float y2 = (float) point.getY();
        boolean z = this.image.get(point.getX(), point.getY());
        int ceil = (int) Math.ceil((double) distance);
        for (int i2 = 0; i2 < ceil; i2++) {
            x2 += x;
            y2 += y;
            if (this.image.get(MathUtils.round(x2), MathUtils.round(y2)) != z) {
                i++;
            }
        }
        float f = ((float) i) / distance;
        if (f > 0.1f && f < 0.9f) {
            return 0;
        }
        return ((f > 0.1f ? 1 : (f == 0.1f ? 0 : -1)) <= 0) == z ? 1 : -1;
    }

    private Point getFirstDifferent(Point point, boolean z, int i, int i2) {
        int x = point.getX() + i;
        int y = point.getY() + i2;
        while (isValid(x, y) && this.image.get(x, y) == z) {
            x += i;
            y += i2;
        }
        int i3 = y - i2;
        y = x - i;
        while (isValid(y, i3) && this.image.get(y, i3) == z) {
            y += i;
        }
        x = y - i;
        y = i3;
        while (isValid(x, y) && this.image.get(x, y) == z) {
            y += i2;
        }
        return new Point(x, y - i2);
    }

    private static ResultPoint[] expandSquare(ResultPoint[] resultPointArr, float f, float f2) {
        float f3 = f2 / (2.0f * f);
        float x = resultPointArr[0].getX() - resultPointArr[2].getX();
        float y = resultPointArr[0].getY() - resultPointArr[2].getY();
        float x2 = (resultPointArr[0].getX() + resultPointArr[2].getX()) / 2.0f;
        float y2 = (resultPointArr[0].getY() + resultPointArr[2].getY()) / 2.0f;
        ResultPoint resultPoint = new ResultPoint((f3 * x) + x2, (f3 * y) + y2);
        ResultPoint resultPoint2 = new ResultPoint(x2 - (x * f3), y2 - (y * f3));
        x = resultPointArr[1].getX() - resultPointArr[3].getX();
        y = resultPointArr[1].getY() - resultPointArr[3].getY();
        x2 = (resultPointArr[1].getX() + resultPointArr[3].getX()) / 2.0f;
        y2 = (resultPointArr[1].getY() + resultPointArr[3].getY()) / 2.0f;
        ResultPoint resultPoint3 = new ResultPoint((f3 * x) + x2, (f3 * y) + y2);
        ResultPoint resultPoint4 = new ResultPoint(x2 - (x * f3), y2 - (f3 * y));
        return new ResultPoint[]{resultPoint, resultPoint3, resultPoint2, resultPoint4};
    }

    private boolean isValid(int i, int i2) {
        return i >= 0 && i < this.image.getWidth() && i2 > 0 && i2 < this.image.getHeight();
    }

    private boolean isValid(ResultPoint resultPoint) {
        return isValid(MathUtils.round(resultPoint.getX()), MathUtils.round(resultPoint.getY()));
    }

    private static float distance(Point point, Point point2) {
        return MathUtils.distance(point.getX(), point.getY(), point2.getX(), point2.getY());
    }

    private static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.distance(resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    private int getDimension() {
        if (this.compact) {
            return (this.nbLayers * 4) + 11;
        }
        if (this.nbLayers <= 4) {
            return (this.nbLayers * 4) + 15;
        }
        return ((this.nbLayers * 4) + ((((this.nbLayers - 4) / 8) + 1) * 2)) + 15;
    }
}
