package android.arch.p010a.p011a;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

/* renamed from: android.arch.a.a.b */
public class C0064b<K, V> implements Iterable<Entry<K, V>> {
    /* renamed from: a */
    private C0070c<K, V> f28a;
    /* renamed from: b */
    private C0070c<K, V> f29b;
    /* renamed from: c */
    private WeakHashMap<Object<K, V>, Boolean> f30c = new WeakHashMap();
    /* renamed from: d */
    private int f31d = 0;

    /* renamed from: android.arch.a.a.b$e */
    private static abstract class C0067e<K, V> implements Iterator<Entry<K, V>> {
        /* renamed from: a */
        C0070c<K, V> f33a;
        /* renamed from: b */
        C0070c<K, V> f34b;

        /* renamed from: a */
        abstract C0070c<K, V> mo8a(C0070c<K, V> c0070c);

        public /* synthetic */ Object next() {
            return m86a();
        }

        C0067e(C0070c<K, V> c0070c, C0070c<K, V> c0070c2) {
            this.f33a = c0070c2;
            this.f34b = c0070c;
        }

        public boolean hasNext() {
            return this.f34b != null;
        }

        /* renamed from: b */
        private C0070c<K, V> m84b() {
            if (this.f34b == this.f33a || this.f33a == null) {
                return null;
            }
            return mo8a(this.f34b);
        }

        /* renamed from: a */
        public Entry<K, V> m86a() {
            Entry entry = this.f34b;
            this.f34b = m84b();
            return entry;
        }
    }

    /* renamed from: android.arch.a.a.b$a */
    static class C0068a<K, V> extends C0067e<K, V> {
        C0068a(C0070c<K, V> c0070c, C0070c<K, V> c0070c2) {
            super(c0070c, c0070c2);
        }

        /* renamed from: a */
        C0070c<K, V> mo8a(C0070c<K, V> c0070c) {
            return c0070c.f37c;
        }
    }

    /* renamed from: android.arch.a.a.b$b */
    private static class C0069b<K, V> extends C0067e<K, V> {
        C0069b(C0070c<K, V> c0070c, C0070c<K, V> c0070c2) {
            super(c0070c, c0070c2);
        }

        /* renamed from: a */
        C0070c<K, V> mo8a(C0070c<K, V> c0070c) {
            return c0070c.f38d;
        }
    }

    /* renamed from: android.arch.a.a.b$c */
    static class C0070c<K, V> implements Entry<K, V> {
        /* renamed from: a */
        final K f35a;
        /* renamed from: b */
        final V f36b;
        /* renamed from: c */
        C0070c<K, V> f37c;
        /* renamed from: d */
        C0070c<K, V> f38d;

        public K getKey() {
            return this.f35a;
        }

        public V getValue() {
            return this.f36b;
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f35a + "=" + this.f36b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0070c)) {
                return false;
            }
            C0070c c0070c = (C0070c) obj;
            if (this.f35a.equals(c0070c.f35a) && this.f36b.equals(c0070c.f36b)) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: android.arch.a.a.b$d */
    private class C0071d implements Iterator<Entry<K, V>> {
        /* renamed from: a */
        final /* synthetic */ C0064b f39a;
        /* renamed from: b */
        private C0070c<K, V> f40b;
        /* renamed from: c */
        private boolean f41c;

        private C0071d(C0064b c0064b) {
            this.f39a = c0064b;
            this.f41c = true;
        }

        public /* synthetic */ Object next() {
            return m89a();
        }

        public boolean hasNext() {
            if (this.f41c) {
                if (this.f39a.f28a != null) {
                    return true;
                }
                return false;
            } else if (this.f40b == null || this.f40b.f37c == null) {
                return false;
            } else {
                return true;
            }
        }

        /* renamed from: a */
        public Entry<K, V> m89a() {
            if (this.f41c) {
                this.f41c = false;
                this.f40b = this.f39a.f28a;
            } else {
                this.f40b = this.f40b != null ? this.f40b.f37c : null;
            }
            return this.f40b;
        }
    }

    /* renamed from: a */
    public int m78a() {
        return this.f31d;
    }

    public Iterator<Entry<K, V>> iterator() {
        Iterator c0068a = new C0068a(this.f28a, this.f29b);
        this.f30c.put(c0068a, Boolean.valueOf(false));
        return c0068a;
    }

    /* renamed from: b */
    public Iterator<Entry<K, V>> m79b() {
        Iterator c0069b = new C0069b(this.f29b, this.f28a);
        this.f30c.put(c0069b, Boolean.valueOf(false));
        return c0069b;
    }

    /* renamed from: c */
    public C0071d m80c() {
        C0071d c0071d = new C0071d();
        this.f30c.put(c0071d, Boolean.valueOf(false));
        return c0071d;
    }

    /* renamed from: d */
    public Entry<K, V> m81d() {
        return this.f28a;
    }

    /* renamed from: e */
    public Entry<K, V> m82e() {
        return this.f29b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0064b)) {
            return false;
        }
        C0064b c0064b = (C0064b) obj;
        if (m78a() != c0064b.m78a()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = c0064b.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Entry entry = (Entry) it.next();
            Object next = it2.next();
            if (entry == null && next != null) {
                return false;
            }
            if (entry != null && !entry.equals(next)) {
                return false;
            }
        }
        boolean z = (it.hasNext() || it2.hasNext()) ? false : true;
        return z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            stringBuilder.append(((Entry) it.next()).toString());
            if (it.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
