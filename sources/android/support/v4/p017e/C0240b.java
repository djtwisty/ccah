package android.support.v4.p017e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: android.support.v4.e.b */
public final class C0240b<E> implements Collection<E>, Set<E> {
    /* renamed from: a */
    static Object[] f469a;
    /* renamed from: b */
    static int f470b;
    /* renamed from: c */
    static Object[] f471c;
    /* renamed from: d */
    static int f472d;
    /* renamed from: j */
    private static final int[] f473j = new int[0];
    /* renamed from: k */
    private static final Object[] f474k = new Object[0];
    /* renamed from: e */
    final boolean f475e;
    /* renamed from: f */
    int[] f476f;
    /* renamed from: g */
    Object[] f477g;
    /* renamed from: h */
    int f478h;
    /* renamed from: i */
    C0235g<E, E> f479i;

    /* renamed from: android.support.v4.e.b$1 */
    class C02391 extends C0235g<E, E> {
        /* renamed from: a */
        final /* synthetic */ C0240b f468a;

        C02391(C0240b c0240b) {
            this.f468a = c0240b;
        }

        /* renamed from: a */
        protected int mo127a() {
            return this.f468a.f478h;
        }

        /* renamed from: a */
        protected Object mo129a(int i, int i2) {
            return this.f468a.f477g[i];
        }

        /* renamed from: a */
        protected int mo128a(Object obj) {
            return this.f468a.m741a(obj);
        }

        /* renamed from: b */
        protected int mo133b(Object obj) {
            return this.f468a.m741a(obj);
        }

        /* renamed from: b */
        protected Map<E, E> mo134b() {
            throw new UnsupportedOperationException("not a map");
        }

        /* renamed from: a */
        protected void mo132a(E e, E e2) {
            this.f468a.add(e);
        }

        /* renamed from: a */
        protected E mo130a(int i, E e) {
            throw new UnsupportedOperationException("not a map");
        }

        /* renamed from: a */
        protected void mo131a(int i) {
            this.f468a.m744c(i);
        }

        /* renamed from: c */
        protected void mo135c() {
            this.f468a.clear();
        }
    }

    /* renamed from: a */
    private int m737a(Object obj, int i) {
        int i2 = this.f478h;
        if (i2 == 0) {
            return -1;
        }
        int a = C0241c.m746a(this.f476f, i2, i);
        if (a < 0 || obj.equals(this.f477g[a])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f476f[i3] == i) {
            if (obj.equals(this.f477g[i3])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f476f[a] == i) {
            if (obj.equals(this.f477g[a])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    /* renamed from: a */
    private int m736a() {
        int i = this.f478h;
        if (i == 0) {
            return -1;
        }
        int a = C0241c.m746a(this.f476f, i, 0);
        if (a < 0 || this.f477g[a] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f476f[i2] == 0) {
            if (this.f477g[i2] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f476f[a] == 0) {
            if (this.f477g[a] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    /* renamed from: d */
    private void m740d(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (C0240b.class) {
                if (f471c != null) {
                    objArr = f471c;
                    this.f477g = objArr;
                    f471c = (Object[]) objArr[0];
                    this.f476f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f472d--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0240b.class) {
                if (f469a != null) {
                    objArr = f469a;
                    this.f477g = objArr;
                    f469a = (Object[]) objArr[0];
                    this.f476f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f470b--;
                    return;
                }
            }
        }
        this.f476f = new int[i];
        this.f477g = new Object[i];
    }

    /* renamed from: a */
    private static void m738a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (C0240b.class) {
                if (f472d < 10) {
                    objArr[0] = f471c;
                    objArr[1] = iArr;
                    for (i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f471c = objArr;
                    f472d++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0240b.class) {
                if (f470b < 10) {
                    objArr[0] = f469a;
                    objArr[1] = iArr;
                    for (i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f469a = objArr;
                    f470b++;
                }
            }
        }
    }

    public C0240b() {
        this(0, false);
    }

    public C0240b(int i) {
        this(i, false);
    }

    public C0240b(int i, boolean z) {
        this.f475e = z;
        if (i == 0) {
            this.f476f = f473j;
            this.f477g = f474k;
        } else {
            m740d(i);
        }
        this.f478h = 0;
    }

    public void clear() {
        if (this.f478h != 0) {
            C0240b.m738a(this.f476f, this.f477g, this.f478h);
            this.f476f = f473j;
            this.f477g = f474k;
            this.f478h = 0;
        }
    }

    /* renamed from: a */
    public void m742a(int i) {
        if (this.f476f.length < i) {
            Object obj = this.f476f;
            Object obj2 = this.f477g;
            m740d(i);
            if (this.f478h > 0) {
                System.arraycopy(obj, 0, this.f476f, 0, this.f478h);
                System.arraycopy(obj2, 0, this.f477g, 0, this.f478h);
            }
            C0240b.m738a(obj, obj2, this.f478h);
        }
    }

    public boolean contains(Object obj) {
        return m741a(obj) >= 0;
    }

    /* renamed from: a */
    public int m741a(Object obj) {
        if (obj == null) {
            return m736a();
        }
        return m737a(obj, this.f475e ? System.identityHashCode(obj) : obj.hashCode());
    }

    /* renamed from: b */
    public E m743b(int i) {
        return this.f477g[i];
    }

    public boolean isEmpty() {
        return this.f478h <= 0;
    }

    public boolean add(E e) {
        int a;
        int i;
        if (e == null) {
            a = m736a();
            i = 0;
        } else {
            int identityHashCode = this.f475e ? System.identityHashCode(e) : e.hashCode();
            a = m737a(e, identityHashCode);
            i = identityHashCode;
        }
        if (a >= 0) {
            return false;
        }
        a ^= -1;
        if (this.f478h >= this.f476f.length) {
            identityHashCode = this.f478h >= 8 ? this.f478h + (this.f478h >> 1) : this.f478h >= 4 ? 8 : 4;
            Object obj = this.f476f;
            Object obj2 = this.f477g;
            m740d(identityHashCode);
            if (this.f476f.length > 0) {
                System.arraycopy(obj, 0, this.f476f, 0, obj.length);
                System.arraycopy(obj2, 0, this.f477g, 0, obj2.length);
            }
            C0240b.m738a(obj, obj2, this.f478h);
        }
        if (a < this.f478h) {
            System.arraycopy(this.f476f, a, this.f476f, a + 1, this.f478h - a);
            System.arraycopy(this.f477g, a, this.f477g, a + 1, this.f478h - a);
        }
        this.f476f[a] = i;
        this.f477g[a] = e;
        this.f478h++;
        return true;
    }

    public boolean remove(Object obj) {
        int a = m741a(obj);
        if (a < 0) {
            return false;
        }
        m744c(a);
        return true;
    }

    /* renamed from: c */
    public E m744c(int i) {
        int i2 = 8;
        E e = this.f477g[i];
        if (this.f478h <= 1) {
            C0240b.m738a(this.f476f, this.f477g, this.f478h);
            this.f476f = f473j;
            this.f477g = f474k;
            this.f478h = 0;
        } else if (this.f476f.length <= 8 || this.f478h >= this.f476f.length / 3) {
            this.f478h--;
            if (i < this.f478h) {
                System.arraycopy(this.f476f, i + 1, this.f476f, i, this.f478h - i);
                System.arraycopy(this.f477g, i + 1, this.f477g, i, this.f478h - i);
            }
            this.f477g[this.f478h] = null;
        } else {
            if (this.f478h > 8) {
                i2 = this.f478h + (this.f478h >> 1);
            }
            Object obj = this.f476f;
            Object obj2 = this.f477g;
            m740d(i2);
            this.f478h--;
            if (i > 0) {
                System.arraycopy(obj, 0, this.f476f, 0, i);
                System.arraycopy(obj2, 0, this.f477g, 0, i);
            }
            if (i < this.f478h) {
                System.arraycopy(obj, i + 1, this.f476f, i, this.f478h - i);
                System.arraycopy(obj2, i + 1, this.f477g, i, this.f478h - i);
            }
        }
        return e;
    }

    public int size() {
        return this.f478h;
    }

    public Object[] toArray() {
        Object obj = new Object[this.f478h];
        System.arraycopy(this.f477g, 0, obj, 0, this.f478h);
        return obj;
    }

    public <T> T[] toArray(T[] tArr) {
        Object obj;
        if (tArr.length < this.f478h) {
            obj = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f478h);
        } else {
            obj = tArr;
        }
        System.arraycopy(this.f477g, 0, obj, 0, this.f478h);
        if (obj.length > this.f478h) {
            obj[this.f478h] = null;
        }
        return obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        int i = 0;
        while (i < this.f478h) {
            try {
                if (!set.contains(m743b(i))) {
                    return false;
                }
                i++;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int[] iArr = this.f476f;
        int i = 0;
        int i2 = 0;
        while (i < this.f478h) {
            i++;
            i2 = iArr[i] + i2;
        }
        return i2;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f478h * 14);
        stringBuilder.append('{');
        for (int i = 0; i < this.f478h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            C0240b b = m743b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Set)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    /* renamed from: b */
    private C0235g<E, E> m739b() {
        if (this.f479i == null) {
            this.f479i = new C02391(this);
        }
        return this.f479i;
    }

    public Iterator<E> iterator() {
        return m739b().m702e().iterator();
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        m742a(this.f478h + collection.size());
        boolean z = false;
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.f478h - 1; i >= 0; i--) {
            if (!collection.contains(this.f477g[i])) {
                m744c(i);
                z = true;
            }
        }
        return z;
    }
}
