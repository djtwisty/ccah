package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.qrcode.decoder.Version;
import java.util.Map;

public class Detector {
    private final BitMatrix image;
    private ResultPointCallback resultPointCallback;

    public Detector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    protected final BitMatrix getImage() {
        return this.image;
    }

    protected final ResultPointCallback getResultPointCallback() {
        return this.resultPointCallback;
    }

    public DetectorResult detect() {
        return detect(null);
    }

    public final DetectorResult detect(Map<DecodeHintType, ?> map) {
        ResultPointCallback resultPointCallback;
        if (map == null) {
            resultPointCallback = null;
        } else {
            resultPointCallback = (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        }
        this.resultPointCallback = resultPointCallback;
        return processFinderPatternInfo(new FinderPatternFinder(this.image, this.resultPointCallback).find(map));
    }

    protected final DetectorResult processFinderPatternInfo(FinderPatternInfo finderPatternInfo) {
        ResultPoint topLeft = finderPatternInfo.getTopLeft();
        ResultPoint topRight = finderPatternInfo.getTopRight();
        ResultPoint bottomLeft = finderPatternInfo.getBottomLeft();
        float calculateModuleSize = calculateModuleSize(topLeft, topRight, bottomLeft);
        if (calculateModuleSize < 1.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint[] resultPointArr;
        int computeDimension = computeDimension(topLeft, topRight, bottomLeft, calculateModuleSize);
        Version provisionalVersionForDimension = Version.getProvisionalVersionForDimension(computeDimension);
        int dimensionForVersion = provisionalVersionForDimension.getDimensionForVersion() - 7;
        ResultPoint resultPoint = null;
        if (provisionalVersionForDimension.getAlignmentPatternCenters().length > 0) {
            float x = (topRight.getX() - topLeft.getX()) + bottomLeft.getX();
            float y = (topRight.getY() - topLeft.getY()) + bottomLeft.getY();
            float f = 1.0f - (3.0f / ((float) dimensionForVersion));
            int x2 = (int) (((x - topLeft.getX()) * f) + topLeft.getX());
            dimensionForVersion = (int) (topLeft.getY() + (f * (y - topLeft.getY())));
            int i = 4;
            while (i <= 16) {
                try {
                    resultPoint = findAlignmentInRegion(calculateModuleSize, x2, dimensionForVersion, (float) i);
                    break;
                } catch (NotFoundException e) {
                    i <<= 1;
                }
            }
        }
        BitMatrix sampleGrid = sampleGrid(this.image, createTransform(topLeft, topRight, bottomLeft, resultPoint, computeDimension), computeDimension);
        if (resultPoint == null) {
            resultPointArr = new ResultPoint[]{bottomLeft, topLeft, topRight};
        } else {
            resultPointArr = new ResultPoint[]{bottomLeft, topLeft, topRight, resultPoint};
        }
        return new DetectorResult(sampleGrid, resultPointArr);
    }

    private static PerspectiveTransform createTransform(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i) {
        float x;
        float y;
        float f;
        float f2;
        float f3 = ((float) i) - 3.5f;
        if (resultPoint4 != null) {
            x = resultPoint4.getX();
            y = resultPoint4.getY();
            float f4 = f3 - 3.0f;
            f = f4;
            f2 = f4;
        } else {
            x = (resultPoint2.getX() - resultPoint.getX()) + resultPoint3.getX();
            y = (resultPoint2.getY() - resultPoint.getY()) + resultPoint3.getY();
            f = f3;
            f2 = f3;
        }
        return PerspectiveTransform.quadrilateralToQuadrilateral(3.5f, 3.5f, f3, 3.5f, f2, f, 3.5f, f3, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), x, y, resultPoint3.getX(), resultPoint3.getY());
    }

    private static BitMatrix sampleGrid(BitMatrix bitMatrix, PerspectiveTransform perspectiveTransform, int i) {
        return GridSampler.getInstance().sampleGrid(bitMatrix, i, i, perspectiveTransform);
    }

    private static int computeDimension(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, float f) {
        int round = ((MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2) / f) + MathUtils.round(ResultPoint.distance(resultPoint, resultPoint3) / f)) / 2) + 7;
        switch (round & 3) {
            case 0:
                return round + 1;
            case 2:
                return round - 1;
            case 3:
                throw NotFoundException.getNotFoundInstance();
            default:
                return round;
        }
    }

    protected final float calculateModuleSize(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        return (calculateModuleSizeOneWay(resultPoint, resultPoint2) + calculateModuleSizeOneWay(resultPoint, resultPoint3)) / 2.0f;
    }

    private float calculateModuleSizeOneWay(ResultPoint resultPoint, ResultPoint resultPoint2) {
        float sizeOfBlackWhiteBlackRunBothWays = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint.getX(), (int) resultPoint.getY(), (int) resultPoint2.getX(), (int) resultPoint2.getY());
        float sizeOfBlackWhiteBlackRunBothWays2 = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint2.getX(), (int) resultPoint2.getY(), (int) resultPoint.getX(), (int) resultPoint.getY());
        if (Float.isNaN(sizeOfBlackWhiteBlackRunBothWays)) {
            return sizeOfBlackWhiteBlackRunBothWays2 / 7.0f;
        }
        if (Float.isNaN(sizeOfBlackWhiteBlackRunBothWays2)) {
            return sizeOfBlackWhiteBlackRunBothWays / 7.0f;
        }
        return (sizeOfBlackWhiteBlackRunBothWays + sizeOfBlackWhiteBlackRunBothWays2) / 14.0f;
    }

    private float sizeOfBlackWhiteBlackRunBothWays(int i, int i2, int i3, int i4) {
        int i5;
        float f;
        int i6 = 0;
        float sizeOfBlackWhiteBlackRun = sizeOfBlackWhiteBlackRun(i, i2, i3, i4);
        int i7 = i - (i3 - i);
        if (i7 < 0) {
            i5 = 0;
            f = ((float) i) / ((float) (i - i7));
        } else if (i7 >= this.image.getWidth()) {
            f = ((float) ((this.image.getWidth() - 1) - i)) / ((float) (i7 - i));
            i5 = this.image.getWidth() - 1;
        } else {
            i5 = i7;
            f = 1.0f;
        }
        i7 = (int) (((float) i2) - (f * ((float) (i4 - i2))));
        if (i7 < 0) {
            f = ((float) i2) / ((float) (i2 - i7));
        } else if (i7 >= this.image.getHeight()) {
            i6 = this.image.getHeight() - 1;
            f = ((float) ((this.image.getHeight() - 1) - i2)) / ((float) (i7 - i2));
        } else {
            i6 = i7;
            f = 1.0f;
        }
        return (sizeOfBlackWhiteBlackRun(i, i2, (int) (((float) i) + (f * ((float) (i5 - i)))), i6) + sizeOfBlackWhiteBlackRun) - 1.0f;
    }

    private float sizeOfBlackWhiteBlackRun(int i, int i2, int i3, int i4) {
        Object obj;
        int i5;
        int i6;
        int i7;
        int i8;
        if (Math.abs(i4 - i2) > Math.abs(i3 - i)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            i5 = i3;
            i6 = i4;
            i7 = i;
            i8 = i2;
        } else {
            i5 = i4;
            i6 = i3;
            i7 = i2;
            i8 = i;
        }
        int abs = Math.abs(i6 - i8);
        int abs2 = Math.abs(i5 - i7);
        int i9 = (-abs) / 2;
        int i10 = i8 < i6 ? 1 : -1;
        int i11 = i7 < i5 ? 1 : -1;
        int i12 = 0;
        int i13 = i6 + i10;
        int i14 = i7;
        int i15 = i8;
        int i16 = i9;
        while (i15 != i13) {
            int i17;
            int i18;
            if (obj != null) {
                i17 = i14;
            } else {
                i17 = i15;
            }
            if (obj != null) {
                i9 = i15;
            } else {
                i9 = i14;
            }
            if ((i12 == 1) == this.image.get(i17, i9)) {
                if (i12 == 2) {
                    return MathUtils.distance(i15, i14, i8, i7);
                }
                i12++;
            }
            i9 = i16 + abs2;
            if (i9 <= 0) {
                i18 = i14;
            } else if (i14 == i5) {
                i11 = i12;
                break;
            } else {
                i18 = i14 + i11;
                i9 -= abs;
            }
            i15 += i10;
            i14 = i18;
            i16 = i9;
        }
        i11 = i12;
        if (i11 == 2) {
            return MathUtils.distance(i6 + i10, i5, i8, i7);
        }
        return Float.NaN;
    }

    protected final AlignmentPattern findAlignmentInRegion(float f, int i, int i2, float f2) {
        int i3 = (int) (f2 * f);
        int max = Math.max(0, i - i3);
        int min = Math.min(this.image.getWidth() - 1, i + i3);
        if (((float) (min - max)) < f * 3.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int max2 = Math.max(0, i2 - i3);
        int min2 = Math.min(this.image.getHeight() - 1, i3 + i2);
        if (((float) (min2 - max2)) < f * 3.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        return new AlignmentPatternFinder(this.image, max, max2, min - max, min2 - max2, f, this.resultPointCallback).find();
    }
}
