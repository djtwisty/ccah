package p000a.p003c.p005b;

/* renamed from: a.c.b.f */
public class C0027f {
    /* renamed from: a */
    public String m24a(C0025d c0025d) {
        String obj = c0025d.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring("kotlin.jvm.functions.".length()) : obj;
    }
}
