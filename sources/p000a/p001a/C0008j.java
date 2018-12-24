package p000a.p001a;

import java.util.Collection;
import p000a.p003c.p005b.C0024c;

/* renamed from: a.a.j */
class C0008j extends C0007i {
    /* renamed from: a */
    public static final <T> int m3a(Iterable<? extends T> iterable, int i) {
        C0024c.m22b(iterable, "$receiver");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }
}
