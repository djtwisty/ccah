package android.support.v4.p017e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: android.support.v4.e.g */
abstract class C0235g<K, V> {
    /* renamed from: b */
    C0246b f456b;
    /* renamed from: c */
    C0247c f457c;
    /* renamed from: d */
    C0249e f458d;

    /* renamed from: android.support.v4.e.g$a */
    final class C0245a<T> implements Iterator<T> {
        /* renamed from: a */
        final int f485a;
        /* renamed from: b */
        int f486b;
        /* renamed from: c */
        int f487c;
        /* renamed from: d */
        boolean f488d = false;
        /* renamed from: e */
        final /* synthetic */ C0235g f489e;

        C0245a(C0235g c0235g, int i) {
            this.f489e = c0235g;
            this.f485a = i;
            this.f486b = c0235g.mo127a();
        }

        public boolean hasNext() {
            return this.f487c < this.f486b;
        }

        public T next() {
            if (hasNext()) {
                T a = this.f489e.mo129a(this.f487c, this.f485a);
                this.f487c++;
                this.f488d = true;
                return a;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.f488d) {
                this.f487c--;
                this.f486b--;
                this.f488d = false;
                this.f489e.mo131a(this.f487c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: android.support.v4.e.g$b */
    final class C0246b implements Set<Entry<K, V>> {
        /* renamed from: a */
        final /* synthetic */ C0235g f490a;

        C0246b(C0235g c0235g) {
            this.f490a = c0235g;
        }

        public /* synthetic */ boolean add(Object obj) {
            return m751a((Entry) obj);
        }

        /* renamed from: a */
        public boolean m751a(Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int a = this.f490a.mo127a();
            for (Entry entry : collection) {
                this.f490a.mo132a(entry.getKey(), entry.getValue());
            }
            return a != this.f490a.mo127a();
        }

        public void clear() {
            this.f490a.mo135c();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int a = this.f490a.mo128a(entry.getKey());
            if (a >= 0) {
                return C0241c.m747a(this.f490a.mo129a(a, 1), entry.getValue());
            }
            return false;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return this.f490a.mo127a() == 0;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C0248d(this.f490a);
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return this.f490a.mo127a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public boolean equals(Object obj) {
            return C0235g.m687a((Set) this, obj);
        }

        public int hashCode() {
            int a = this.f490a.mo127a() - 1;
            int i = 0;
            while (a >= 0) {
                int i2;
                Object a2 = this.f490a.mo129a(a, 0);
                Object a3 = this.f490a.mo129a(a, 1);
                int hashCode = a2 == null ? 0 : a2.hashCode();
                if (a3 == null) {
                    i2 = 0;
                } else {
                    i2 = a3.hashCode();
                }
                a--;
                i += i2 ^ hashCode;
            }
            return i;
        }
    }

    /* renamed from: android.support.v4.e.g$c */
    final class C0247c implements Set<K> {
        /* renamed from: a */
        final /* synthetic */ C0235g f491a;

        C0247c(C0235g c0235g) {
            this.f491a = c0235g;
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f491a.mo135c();
        }

        public boolean contains(Object obj) {
            return this.f491a.mo128a(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return C0235g.m686a(this.f491a.mo134b(), (Collection) collection);
        }

        public boolean isEmpty() {
            return this.f491a.mo127a() == 0;
        }

        public Iterator<K> iterator() {
            return new C0245a(this.f491a, 0);
        }

        public boolean remove(Object obj) {
            int a = this.f491a.mo128a(obj);
            if (a < 0) {
                return false;
            }
            this.f491a.mo131a(a);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return C0235g.m688b(this.f491a.mo134b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return C0235g.m689c(this.f491a.mo134b(), collection);
        }

        public int size() {
            return this.f491a.mo127a();
        }

        public Object[] toArray() {
            return this.f491a.m699b(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f491a.m696a((Object[]) tArr, 0);
        }

        public boolean equals(Object obj) {
            return C0235g.m687a((Set) this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int a = this.f491a.mo127a() - 1; a >= 0; a--) {
                Object a2 = this.f491a.mo129a(a, 0);
                i += a2 == null ? 0 : a2.hashCode();
            }
            return i;
        }
    }

    /* renamed from: android.support.v4.e.g$d */
    final class C0248d implements Iterator<Entry<K, V>>, Entry<K, V> {
        /* renamed from: a */
        int f492a;
        /* renamed from: b */
        int f493b;
        /* renamed from: c */
        boolean f494c = false;
        /* renamed from: d */
        final /* synthetic */ C0235g f495d;

        public /* synthetic */ Object next() {
            return m752a();
        }

        C0248d(C0235g c0235g) {
            this.f495d = c0235g;
            this.f492a = c0235g.mo127a() - 1;
            this.f493b = -1;
        }

        public boolean hasNext() {
            return this.f493b < this.f492a;
        }

        /* renamed from: a */
        public Entry<K, V> m752a() {
            if (hasNext()) {
                this.f493b++;
                this.f494c = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.f494c) {
                this.f495d.mo131a(this.f493b);
                this.f493b--;
                this.f492a--;
                this.f494c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public K getKey() {
            if (this.f494c) {
                return this.f495d.mo129a(this.f493b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f494c) {
                return this.f495d.mo129a(this.f493b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V setValue(V v) {
            if (this.f494c) {
                return this.f495d.mo130a(this.f493b, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object obj) {
            boolean z = true;
            if (!this.f494c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                if (!(C0241c.m747a(entry.getKey(), this.f495d.mo129a(this.f493b, 0)) && C0241c.m747a(entry.getValue(), this.f495d.mo129a(this.f493b, 1)))) {
                    z = false;
                }
                return z;
            }
        }

        public final int hashCode() {
            int i = 0;
            if (this.f494c) {
                Object a = this.f495d.mo129a(this.f493b, 0);
                Object a2 = this.f495d.mo129a(this.f493b, 1);
                int hashCode = a == null ? 0 : a.hashCode();
                if (a2 != null) {
                    i = a2.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: android.support.v4.e.g$e */
    final class C0249e implements Collection<V> {
        /* renamed from: a */
        final /* synthetic */ C0235g f496a;

        C0249e(C0235g c0235g) {
            this.f496a = c0235g;
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f496a.mo135c();
        }

        public boolean contains(Object obj) {
            return this.f496a.mo133b(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return this.f496a.mo127a() == 0;
        }

        public Iterator<V> iterator() {
            return new C0245a(this.f496a, 1);
        }

        public boolean remove(Object obj) {
            int b = this.f496a.mo133b(obj);
            if (b < 0) {
                return false;
            }
            this.f496a.mo131a(b);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int a = this.f496a.mo127a();
            int i = 0;
            boolean z = false;
            while (i < a) {
                if (collection.contains(this.f496a.mo129a(i, 1))) {
                    this.f496a.mo131a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            int a = this.f496a.mo127a();
            int i = 0;
            boolean z = false;
            while (i < a) {
                if (!collection.contains(this.f496a.mo129a(i, 1))) {
                    this.f496a.mo131a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return this.f496a.mo127a();
        }

        public Object[] toArray() {
            return this.f496a.m699b(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f496a.m696a((Object[]) tArr, 1);
        }
    }

    /* renamed from: a */
    protected abstract int mo127a();

    /* renamed from: a */
    protected abstract int mo128a(Object obj);

    /* renamed from: a */
    protected abstract Object mo129a(int i, int i2);

    /* renamed from: a */
    protected abstract V mo130a(int i, V v);

    /* renamed from: a */
    protected abstract void mo131a(int i);

    /* renamed from: a */
    protected abstract void mo132a(K k, V v);

    /* renamed from: b */
    protected abstract int mo133b(Object obj);

    /* renamed from: b */
    protected abstract Map<K, V> mo134b();

    /* renamed from: c */
    protected abstract void mo135c();

    C0235g() {
    }

    /* renamed from: a */
    public static <K, V> boolean m686a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static <K, V> boolean m688b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    /* renamed from: c */
    public static <K, V> boolean m689c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* renamed from: b */
    public Object[] m699b(int i) {
        int a = mo127a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = mo129a(i2, i);
        }
        return objArr;
    }

    /* renamed from: a */
    public <T> T[] m696a(T[] tArr, int i) {
        T[] tArr2;
        int a = mo127a();
        if (tArr.length < a) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a);
        } else {
            tArr2 = tArr;
        }
        for (int i2 = 0; i2 < a; i2++) {
            tArr2[i2] = mo129a(i2, i);
        }
        if (tArr2.length > a) {
            tArr2[a] = null;
        }
        return tArr2;
    }

    /* renamed from: a */
    public static <T> boolean m687a(Set<T> set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    /* renamed from: d */
    public Set<Entry<K, V>> m701d() {
        if (this.f456b == null) {
            this.f456b = new C0246b(this);
        }
        return this.f456b;
    }

    /* renamed from: e */
    public Set<K> m702e() {
        if (this.f457c == null) {
            this.f457c = new C0247c(this);
        }
        return this.f457c;
    }

    /* renamed from: f */
    public Collection<V> m703f() {
        if (this.f458d == null) {
            this.f458d = new C0249e(this);
        }
        return this.f458d;
    }
}
