package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

public final class WhiteRectangleDetector {
    private static final int CORR = 1;
    private static final int INIT_SIZE = 10;
    private final int downInit;
    private final int height;
    private final BitMatrix image;
    private final int leftInit;
    private final int rightInit;
    private final int upInit;
    private final int width;

    public WhiteRectangleDetector(BitMatrix bitMatrix) {
        this(bitMatrix, 10, bitMatrix.getWidth() / 2, bitMatrix.getHeight() / 2);
    }

    public WhiteRectangleDetector(BitMatrix bitMatrix, int i, int i2, int i3) {
        this.image = bitMatrix;
        this.height = bitMatrix.getHeight();
        this.width = bitMatrix.getWidth();
        int i4 = i / 2;
        this.leftInit = i2 - i4;
        this.rightInit = i2 + i4;
        this.upInit = i3 - i4;
        this.downInit = i4 + i3;
        if (this.upInit < 0 || this.leftInit < 0 || this.downInit >= this.height || this.rightInit >= this.width) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public ResultPoint[] detect() {
        int i;
        int i2;
        boolean z = false;
        int i3 = 1;
        int i4 = this.leftInit;
        int i5 = this.rightInit;
        int i6 = this.upInit;
        int i7 = this.downInit;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i8 = 1;
        while (i8 != 0) {
            boolean z7 = true;
            boolean z8 = false;
            while (true) {
                if ((z7 || !z5) && i5 < this.width) {
                    z7 = containsBlackPoint(i6, i7, i5, false);
                    if (z7) {
                        i5++;
                        z5 = true;
                        z8 = true;
                    } else if (!z5) {
                        i5++;
                    }
                }
            }
            if (i5 >= this.width) {
                z = true;
                i = i7;
                i2 = i6;
                break;
            }
            z7 = true;
            while (true) {
                if ((z7 || !z4) && i7 < this.height) {
                    z7 = containsBlackPoint(i4, i5, i7, true);
                    if (z7) {
                        i7++;
                        z4 = true;
                        z8 = true;
                    } else if (!z4) {
                        i7++;
                    }
                }
            }
            if (i7 >= this.height) {
                z = true;
                i = i7;
                i2 = i6;
                break;
            }
            z7 = true;
            while (true) {
                if ((z7 || !z3) && i4 >= 0) {
                    z7 = containsBlackPoint(i6, i7, i4, false);
                    if (z7) {
                        i4--;
                        z3 = true;
                        z8 = true;
                    } else if (!z3) {
                        i4--;
                    }
                }
            }
            if (i4 < 0) {
                z = true;
                i = i7;
                i2 = i6;
                break;
            }
            z7 = true;
            while (true) {
                if ((z7 || !z2) && i6 >= 0) {
                    z7 = containsBlackPoint(i4, i5, i6, true);
                    if (z7) {
                        i6--;
                        z2 = true;
                        i8 = 1;
                    } else if (!z2) {
                        i6--;
                    }
                }
            }
            if (i6 < 0) {
                z = true;
                i = i7;
                i2 = i6;
                break;
            } else if (i8 != 0) {
                z6 = true;
            }
        }
        i = i7;
        i2 = i6;
        if (z || !r0) {
            throw NotFoundException.getNotFoundInstance();
        }
        i8 = i5 - i4;
        int i9 = 1;
        ResultPoint resultPoint = null;
        while (resultPoint == null && i9 < i8) {
            i9++;
            resultPoint = getBlackPointOnSegment((float) i4, (float) (i - i9), (float) (i4 + i9), (float) i);
        }
        if (resultPoint == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        i9 = 1;
        ResultPoint resultPoint2 = null;
        while (resultPoint2 == null && i9 < i8) {
            i9++;
            resultPoint2 = getBlackPointOnSegment((float) i4, (float) (i2 + i9), (float) (i4 + i9), (float) i2);
        }
        if (resultPoint2 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        i9 = 1;
        ResultPoint resultPoint3 = null;
        while (resultPoint3 == null && i9 < i8) {
            resultPoint3 = getBlackPointOnSegment((float) i5, (float) (i2 + i9), (float) (i5 - i9), (float) i2);
            i9++;
        }
        if (resultPoint3 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint resultPoint4 = null;
        while (resultPoint4 == null && i3 < i8) {
            resultPoint4 = getBlackPointOnSegment((float) i5, (float) (i - i3), (float) (i5 - i3), (float) i);
            i3++;
        }
        if (resultPoint4 != null) {
            return centerEdges(resultPoint4, resultPoint, resultPoint3, resultPoint2);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private ResultPoint getBlackPointOnSegment(float f, float f2, float f3, float f4) {
        int round = MathUtils.round(MathUtils.distance(f, f2, f3, f4));
        float f5 = (f3 - f) / ((float) round);
        float f6 = (f4 - f2) / ((float) round);
        for (int i = 0; i < round; i++) {
            int round2 = MathUtils.round((((float) i) * f5) + f);
            int round3 = MathUtils.round((((float) i) * f6) + f2);
            if (this.image.get(round2, round3)) {
                return new ResultPoint((float) round2, (float) round3);
            }
        }
        return null;
    }

    private ResultPoint[] centerEdges(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        float x = resultPoint.getX();
        float y = resultPoint.getY();
        float x2 = resultPoint2.getX();
        float y2 = resultPoint2.getY();
        float x3 = resultPoint3.getX();
        float y3 = resultPoint3.getY();
        float x4 = resultPoint4.getX();
        float y4 = resultPoint4.getY();
        if (x < ((float) this.width) / 2.0f) {
            return new ResultPoint[]{new ResultPoint(x4 - 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 + 1.0f), new ResultPoint(x3 - 1.0f, y3 - 1.0f), new ResultPoint(x + 1.0f, y - 1.0f)};
        }
        return new ResultPoint[]{new ResultPoint(x4 + 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 - 1.0f), new ResultPoint(x3 - 1.0f, y3 + 1.0f), new ResultPoint(x - 1.0f, y - 1.0f)};
    }

    private boolean containsBlackPoint(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.image.get(i, i3)) {
                    return true;
                }
                i++;
            }
        } else {
            while (i <= i2) {
                if (this.image.get(i3, i)) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }
}
