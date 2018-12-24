package com.google.zxing.common;

import com.google.zxing.NotFoundException;

public abstract class GridSampler {
    private static GridSampler gridSampler = new DefaultGridSampler();

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16);

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i, int i2, PerspectiveTransform perspectiveTransform);

    public static void setGridSampler(GridSampler gridSampler) {
        gridSampler = gridSampler;
    }

    public static GridSampler getInstance() {
        return gridSampler;
    }

    protected static void checkAndNudgePoints(BitMatrix bitMatrix, float[] fArr) {
        int i;
        int i2;
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        Object obj = 1;
        for (i = 0; i < fArr.length && r2 != null; i += 2) {
            i2 = (int) fArr[i];
            int i3 = (int) fArr[i + 1];
            if (i2 < -1 || i2 > width || i3 < -1 || i3 > height) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i2 == -1) {
                fArr[i] = 0.0f;
                obj = 1;
            } else if (i2 == width) {
                fArr[i] = (float) (width - 1);
                i2 = 1;
            } else {
                obj = null;
            }
            if (i3 == -1) {
                fArr[i + 1] = 0.0f;
                obj = 1;
            } else if (i3 == height) {
                fArr[i + 1] = (float) (height - 1);
                i2 = 1;
            }
        }
        i2 = fArr.length - 2;
        Object obj2 = 1;
        while (i2 >= 0 && r4 != null) {
            i = (int) fArr[i2];
            i3 = (int) fArr[i2 + 1];
            if (i < -1 || i > width || i3 < -1 || i3 > height) {
                throw NotFoundException.getNotFoundInstance();
            }
            Object obj3;
            if (i == -1) {
                fArr[i2] = 0.0f;
                obj3 = 1;
            } else if (i == width) {
                fArr[i2] = (float) (width - 1);
                i = 1;
            } else {
                obj3 = null;
            }
            if (i3 == -1) {
                fArr[i2 + 1] = 0.0f;
                obj3 = 1;
            } else if (i3 == height) {
                fArr[i2 + 1] = (float) (height - 1);
                i = 1;
            }
            i2 -= 2;
            obj2 = obj3;
        }
    }
}
