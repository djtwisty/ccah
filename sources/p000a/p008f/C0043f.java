package p000a.p008f;

import java.util.Iterator;
import p000a.p003c.p005b.C0024c;

/* renamed from: a.f.f */
class C0043f extends C0042e {

    /* renamed from: a.f.f$a */
    public static final class C0045a implements Iterable<T> {
        /* renamed from: a */
        final /* synthetic */ C0039a f15a;

        public C0045a(C0039a c0039a) {
            this.f15a = c0039a;
        }

        public Iterator<T> iterator() {
            return this.f15a.mo6a();
        }
    }

    /* renamed from: a */
    public static final <T> Iterable<T> m43a(C0039a<? extends T> c0039a) {
        C0024c.m22b(c0039a, "$receiver");
        return new C0045a(c0039a);
    }
}
