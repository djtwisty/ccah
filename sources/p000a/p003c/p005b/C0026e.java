package p000a.p003c.p005b;

import p000a.p007e.C0038a;

/* renamed from: a.c.b.e */
public class C0026e {
    /* renamed from: a */
    private static final C0027f f3a;
    /* renamed from: b */
    private static final C0038a[] f4b = new C0038a[0];

    static {
        C0027f c0027f;
        try {
            c0027f = (C0027f) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException e) {
            c0027f = null;
        } catch (ClassNotFoundException e2) {
            c0027f = null;
        } catch (InstantiationException e3) {
            c0027f = null;
        } catch (IllegalAccessException e4) {
            c0027f = null;
        }
        if (c0027f == null) {
            c0027f = new C0027f();
        }
        f3a = c0027f;
    }

    /* renamed from: a */
    public static String m23a(C0025d c0025d) {
        return f3a.m24a(c0025d);
    }
}
