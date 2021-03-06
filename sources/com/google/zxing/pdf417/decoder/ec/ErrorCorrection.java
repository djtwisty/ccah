package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.ChecksumException;

public final class ErrorCorrection {
    private final ModulusGF field = ModulusGF.PDF417_GF;

    public int decode(int[] iArr, int i, int[] iArr2) {
        ModulusPoly modulusPoly = new ModulusPoly(this.field, iArr);
        int[] iArr3 = new int[i];
        int i2 = 0;
        for (int i3 = i; i3 > 0; i3--) {
            int evaluateAt = modulusPoly.evaluateAt(this.field.exp(i3));
            iArr3[i - i3] = evaluateAt;
            if (evaluateAt != 0) {
                i2 = 1;
            }
        }
        if (i2 == 0) {
            return 0;
        }
        ModulusPoly one = this.field.getOne();
        if (iArr2 != null) {
            for (int evaluateAt2 : iArr2) {
                evaluateAt2 = this.field.exp((iArr.length - 1) - evaluateAt2);
                one = one.multiply(new ModulusPoly(this.field, new int[]{this.field.subtract(0, evaluateAt2), 1}));
            }
        }
        ModulusPoly[] runEuclideanAlgorithm = runEuclideanAlgorithm(this.field.buildMonomial(i, 1), new ModulusPoly(this.field, iArr3), i);
        one = runEuclideanAlgorithm[0];
        ModulusPoly modulusPoly2 = runEuclideanAlgorithm[1];
        int[] findErrorLocations = findErrorLocations(one);
        int[] findErrorMagnitudes = findErrorMagnitudes(modulusPoly2, one, findErrorLocations);
        for (i2 = 0; i2 < findErrorLocations.length; i2++) {
            int length = (iArr.length - 1) - this.field.log(findErrorLocations[i2]);
            if (length < 0) {
                throw ChecksumException.getChecksumInstance();
            }
            iArr[length] = this.field.subtract(iArr[length], findErrorMagnitudes[i2]);
        }
        return findErrorLocations.length;
    }

    private ModulusPoly[] runEuclideanAlgorithm(ModulusPoly modulusPoly, ModulusPoly modulusPoly2, int i) {
        ModulusPoly modulusPoly3;
        ModulusPoly modulusPoly4;
        if (modulusPoly.getDegree() < modulusPoly2.getDegree()) {
            modulusPoly3 = modulusPoly;
            modulusPoly4 = modulusPoly2;
        } else {
            modulusPoly3 = modulusPoly2;
            modulusPoly4 = modulusPoly;
        }
        ModulusPoly zero = this.field.getZero();
        ModulusPoly one = this.field.getOne();
        ModulusPoly modulusPoly5 = modulusPoly3;
        ModulusPoly modulusPoly6 = modulusPoly4;
        while (modulusPoly5.getDegree() >= i / 2) {
            if (modulusPoly5.isZero()) {
                throw ChecksumException.getChecksumInstance();
            }
            modulusPoly3 = this.field.getZero();
            int inverse = this.field.inverse(modulusPoly5.getCoefficient(modulusPoly5.getDegree()));
            modulusPoly4 = modulusPoly6;
            while (modulusPoly4.getDegree() >= modulusPoly5.getDegree() && !modulusPoly4.isZero()) {
                int degree = modulusPoly4.getDegree() - modulusPoly5.getDegree();
                int multiply = this.field.multiply(modulusPoly4.getCoefficient(modulusPoly4.getDegree()), inverse);
                modulusPoly3 = modulusPoly3.add(this.field.buildMonomial(degree, multiply));
                modulusPoly4 = modulusPoly4.subtract(modulusPoly5.multiplyByMonomial(degree, multiply));
            }
            zero = one;
            modulusPoly6 = modulusPoly5;
            modulusPoly5 = modulusPoly4;
            one = modulusPoly3.multiply(one).subtract(zero).negative();
        }
        int coefficient = one.getCoefficient(0);
        if (coefficient == 0) {
            throw ChecksumException.getChecksumInstance();
        }
        coefficient = this.field.inverse(coefficient);
        modulusPoly4 = one.multiply(coefficient);
        modulusPoly3 = modulusPoly5.multiply(coefficient);
        return new ModulusPoly[]{modulusPoly4, modulusPoly3};
    }

    private int[] findErrorLocations(ModulusPoly modulusPoly) {
        int degree = modulusPoly.getDegree();
        int[] iArr = new int[degree];
        int i = 0;
        for (int i2 = 1; i2 < this.field.getSize() && i < degree; i2++) {
            if (modulusPoly.evaluateAt(i2) == 0) {
                iArr[i] = this.field.inverse(i2);
                i++;
            }
        }
        if (i == degree) {
            return iArr;
        }
        throw ChecksumException.getChecksumInstance();
    }

    private int[] findErrorMagnitudes(ModulusPoly modulusPoly, ModulusPoly modulusPoly2, int[] iArr) {
        int i;
        int degree = modulusPoly2.getDegree();
        int[] iArr2 = new int[degree];
        for (i = 1; i <= degree; i++) {
            iArr2[degree - i] = this.field.multiply(i, modulusPoly2.getCoefficient(i));
        }
        ModulusPoly modulusPoly3 = new ModulusPoly(this.field, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (i = 0; i < length; i++) {
            int inverse = this.field.inverse(iArr[i]);
            iArr3[i] = this.field.multiply(this.field.subtract(0, modulusPoly.evaluateAt(inverse)), this.field.inverse(modulusPoly3.evaluateAt(inverse)));
        }
        return iArr3;
    }
}
