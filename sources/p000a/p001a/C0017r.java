package p000a.p001a;

import java.util.Iterator;

/* renamed from: a.a.r */
public abstract class C0017r implements Iterator<Integer> {
    /* renamed from: b */
    public abstract int mo1b();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* synthetic */ Object next() {
        return m6a();
    }

    /* renamed from: a */
    public final Integer m6a() {
        return Integer.valueOf(mo1b());
    }
}
