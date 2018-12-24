package p000a.p003c.p005b;

import java.util.Arrays;
import java.util.List;

/* renamed from: a.c.b.c */
public class C0024c {
    private C0024c() {
    }

    /* renamed from: a */
    public static void m19a(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) C0024c.m17a(new IllegalStateException(str + " must not be null")));
        }
    }

    /* renamed from: b */
    public static void m22b(Object obj, String str) {
        if (obj == null) {
            C0024c.m20a(str);
        }
    }

    /* renamed from: a */
    private static void m20a(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        throw ((IllegalArgumentException) C0024c.m17a(new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + stackTraceElement.getMethodName() + ", parameter " + str)));
    }

    /* renamed from: a */
    public static boolean m21a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else {
            return obj.equals(obj2);
        }
    }

    /* renamed from: a */
    private static <T extends Throwable> T m17a(T t) {
        return C0024c.m18a((Throwable) t, C0024c.class.getName());
    }

    /* renamed from: a */
    static <T extends Throwable> T m18a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        List subList = Arrays.asList(stackTrace).subList(i + 1, length);
        t.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        return t;
    }
}
