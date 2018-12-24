package p000a.p006d;

/* renamed from: a.d.g */
class C0036g extends C0035f {
    /* renamed from: a */
    public static final C0030a m38a(int i, int i2) {
        return C0030a.f5a.m25a(i, i2, -1);
    }

    /* renamed from: b */
    public static final C0033c m39b(int i, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return C0033c.f13b.m32a();
        }
        return new C0033c(i, i2 - 1);
    }

    /* renamed from: c */
    public static final int m40c(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    /* renamed from: d */
    public static final int m41d(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    /* renamed from: a */
    public static final int m37a(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
        } else if (i < i2) {
            return i2;
        } else {
            return i > i3 ? i3 : i;
        }
    }
}
