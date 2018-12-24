package p000a.p001a;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import p000a.p003c.p005b.C0024c;

/* renamed from: a.a.q */
class C0015q extends C0014p {
    /* renamed from: a */
    public static final <T> T m4a(Iterable<? extends T> iterable) {
        C0024c.m22b(iterable, "$receiver");
        if (iterable instanceof List) {
            return C0015q.m5a((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (!it.hasNext()) {
                return next;
            }
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    /* renamed from: a */
    public static final <T> T m5a(List<? extends T> list) {
        C0024c.m22b(list, "$receiver");
        switch (list.size()) {
            case 0:
                throw new NoSuchElementException("List is empty.");
            case 1:
                return list.get(0);
            default:
                throw new IllegalArgumentException("List has more than one element.");
        }
    }
}
