package android.support.v4.p017e;

/* renamed from: android.support.v4.e.c */
class C0241c {
    /* renamed from: a */
    static final int[] f480a = new int[0];
    /* renamed from: b */
    static final long[] f481b = new long[0];
    /* renamed from: c */
    static final Object[] f482c = new Object[0];

    /* renamed from: a */
    public static int m745a(int i) {
        return C0241c.m748b(i * 4) / 4;
    }

    /* renamed from: b */
    public static int m748b(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    /* renamed from: a */
    public static boolean m747a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    static int m746a(int[] iArr, int i, int i2) {
        int i3 = 0;
        int i4 = i - 1;
        while (i3 <= i4) {
            int i5 = (i3 + i4) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i3 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return i3 ^ -1;
    }
}
