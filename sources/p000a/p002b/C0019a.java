package p000a.p002b;

/* renamed from: a.b.a */
public final class C0019a {
    /* renamed from: a */
    private static final int m12a(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    /* renamed from: b */
    private static final int m14b(int i, int i2, int i3) {
        return C0019a.m12a(C0019a.m12a(i, i3) - C0019a.m12a(i2, i3), i3);
    }

    /* renamed from: a */
    public static final int m13a(int i, int i2, int i3) {
        if (i3 > 0) {
            return i >= i2 ? i2 : i2 - C0019a.m14b(i2, i, i3);
        } else {
            if (i3 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            } else if (i > i2) {
                return i2 + C0019a.m14b(i, i2, -i3);
            } else {
                return i2;
            }
        }
    }
}
