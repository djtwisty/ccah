package android.support.v4.p017e;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* renamed from: android.support.v4.e.i */
public class C0237i<K, V> {
    /* renamed from: b */
    static Object[] f460b;
    /* renamed from: c */
    static int f461c;
    /* renamed from: d */
    static Object[] f462d;
    /* renamed from: e */
    static int f463e;
    /* renamed from: f */
    int[] f464f;
    /* renamed from: g */
    Object[] f465g;
    /* renamed from: h */
    int f466h;

    /* renamed from: a */
    private static int m713a(int[] iArr, int i, int i2) {
        try {
            return C0241c.m746a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ConcurrentModificationException();
        }
    }

    /* renamed from: a */
    int m718a(Object obj, int i) {
        int i2 = this.f466h;
        if (i2 == 0) {
            return -1;
        }
        int a = C0237i.m713a(this.f464f, i2, i);
        if (a < 0 || obj.equals(this.f465g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f464f[i3] == i) {
            if (obj.equals(this.f465g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f464f[a] == i) {
            if (obj.equals(this.f465g[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    /* renamed from: a */
    int m716a() {
        int i = this.f466h;
        if (i == 0) {
            return -1;
        }
        int a = C0237i.m713a(this.f464f, i, 0);
        if (a < 0 || this.f465g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f464f[i2] == 0) {
            if (this.f465g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f464f[a] == 0) {
            if (this.f465g[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    /* renamed from: e */
    private void m715e(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (C0238a.class) {
                if (f462d != null) {
                    objArr = f462d;
                    this.f465g = objArr;
                    f462d = (Object[]) objArr[0];
                    this.f464f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f463e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0238a.class) {
                if (f460b != null) {
                    objArr = f460b;
                    this.f465g = objArr;
                    f460b = (Object[]) objArr[0];
                    this.f464f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f461c--;
                    return;
                }
            }
        }
        this.f464f = new int[i];
        this.f465g = new Object[(i << 1)];
    }

    /* renamed from: a */
    private static void m714a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (C0238a.class) {
                if (f463e < 10) {
                    objArr[0] = f462d;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f462d = objArr;
                    f463e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0238a.class) {
                if (f461c < 10) {
                    objArr[0] = f460b;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f460b = objArr;
                    f461c++;
                }
            }
        }
    }

    public C0237i() {
        this.f464f = C0241c.f480a;
        this.f465g = C0241c.f482c;
        this.f466h = 0;
    }

    public C0237i(int i) {
        if (i == 0) {
            this.f464f = C0241c.f480a;
            this.f465g = C0241c.f482c;
        } else {
            m715e(i);
        }
        this.f466h = 0;
    }

    public void clear() {
        if (this.f466h > 0) {
            int[] iArr = this.f464f;
            Object[] objArr = this.f465g;
            int i = this.f466h;
            this.f464f = C0241c.f480a;
            this.f465g = C0241c.f482c;
            this.f466h = 0;
            C0237i.m714a(iArr, objArr, i);
        }
        if (this.f466h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    /* renamed from: a */
    public void m720a(int i) {
        int i2 = this.f466h;
        if (this.f464f.length < i) {
            int[] iArr = this.f464f;
            Object[] objArr = this.f465g;
            m715e(i);
            if (this.f466h > 0) {
                System.arraycopy(iArr, 0, this.f464f, 0, i2);
                System.arraycopy(objArr, 0, this.f465g, 0, i2 << 1);
            }
            C0237i.m714a(iArr, objArr, i2);
        }
        if (this.f466h != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return m717a(obj) >= 0;
    }

    /* renamed from: a */
    public int m717a(Object obj) {
        return obj == null ? m716a() : m718a(obj, obj.hashCode());
    }

    /* renamed from: b */
    int m721b(Object obj) {
        int i = 1;
        int i2 = this.f466h * 2;
        Object[] objArr = this.f465g;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return m721b(obj) >= 0;
    }

    public V get(Object obj) {
        int a = m717a(obj);
        return a >= 0 ? this.f465g[(a << 1) + 1] : null;
    }

    /* renamed from: b */
    public K m722b(int i) {
        return this.f465g[i << 1];
    }

    /* renamed from: c */
    public V m723c(int i) {
        return this.f465g[(i << 1) + 1];
    }

    /* renamed from: a */
    public V m719a(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.f465g[i2];
        this.f465g[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.f466h <= 0;
    }

    public V put(K k, V v) {
        int a;
        int i;
        int i2 = 8;
        int i3 = this.f466h;
        if (k == null) {
            a = m716a();
            i = 0;
        } else {
            i = k.hashCode();
            a = m718a((Object) k, i);
        }
        if (a >= 0) {
            int i4 = (a << 1) + 1;
            V v2 = this.f465g[i4];
            this.f465g[i4] = v;
            return v2;
        }
        a ^= -1;
        if (i3 >= this.f464f.length) {
            if (i3 >= 8) {
                i2 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i2 = 4;
            }
            int[] iArr = this.f464f;
            Object[] objArr = this.f465g;
            m715e(i2);
            if (i3 != this.f466h) {
                throw new ConcurrentModificationException();
            }
            if (this.f464f.length > 0) {
                System.arraycopy(iArr, 0, this.f464f, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f465g, 0, objArr.length);
            }
            C0237i.m714a(iArr, objArr, i3);
        }
        if (a < i3) {
            System.arraycopy(this.f464f, a, this.f464f, a + 1, i3 - a);
            System.arraycopy(this.f465g, a << 1, this.f465g, (a + 1) << 1, (this.f466h - a) << 1);
        }
        if (i3 != this.f466h || a >= this.f464f.length) {
            throw new ConcurrentModificationException();
        }
        this.f464f[a] = i;
        this.f465g[a << 1] = k;
        this.f465g[(a << 1) + 1] = v;
        this.f466h++;
        return null;
    }

    public V remove(Object obj) {
        int a = m717a(obj);
        if (a >= 0) {
            return m724d(a);
        }
        return null;
    }

    /* renamed from: d */
    public V m724d(int i) {
        int i2 = 8;
        V v = this.f465g[(i << 1) + 1];
        int i3 = this.f466h;
        if (i3 <= 1) {
            C0237i.m714a(this.f464f, this.f465g, i3);
            this.f464f = C0241c.f480a;
            this.f465g = C0241c.f482c;
            i2 = 0;
        } else {
            int i4 = i3 - 1;
            if (this.f464f.length <= 8 || this.f466h >= this.f464f.length / 3) {
                if (i < i4) {
                    System.arraycopy(this.f464f, i + 1, this.f464f, i, i4 - i);
                    System.arraycopy(this.f465g, (i + 1) << 1, this.f465g, i << 1, (i4 - i) << 1);
                }
                this.f465g[i4 << 1] = null;
                this.f465g[(i4 << 1) + 1] = null;
                i2 = i4;
            } else {
                if (i3 > 8) {
                    i2 = (i3 >> 1) + i3;
                }
                Object obj = this.f464f;
                Object obj2 = this.f465g;
                m715e(i2);
                if (i3 != this.f466h) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(obj, 0, this.f464f, 0, i);
                    System.arraycopy(obj2, 0, this.f465g, 0, i << 1);
                }
                if (i < i4) {
                    System.arraycopy(obj, i + 1, this.f464f, i, i4 - i);
                    System.arraycopy(obj2, (i + 1) << 1, this.f465g, i << 1, (i4 - i) << 1);
                }
                i2 = i4;
            }
        }
        if (i3 != this.f466h) {
            throw new ConcurrentModificationException();
        }
        this.f466h = i2;
        return v;
    }

    public int size() {
        return this.f466h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        int i;
        Object b;
        Object c;
        Object obj2;
        if (obj instanceof C0237i) {
            C0237i c0237i = (C0237i) obj;
            if (size() != c0237i.size()) {
                return false;
            }
            i = 0;
            while (i < this.f466h) {
                try {
                    b = m722b(i);
                    c = m723c(i);
                    obj2 = c0237i.get(b);
                    if (c == null) {
                        if (obj2 != null || !c0237i.containsKey(b)) {
                            return false;
                        }
                    } else if (!c.equals(obj2)) {
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
        } else if (!(obj instanceof Map)) {
            return false;
        } else {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            i = 0;
            while (i < this.f466h) {
                try {
                    b = m722b(i);
                    c = m723c(i);
                    obj2 = map.get(b);
                    if (c == null) {
                        if (obj2 != null || !map.containsKey(b)) {
                            return false;
                        }
                    } else if (!c.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (NullPointerException e3) {
                    return false;
                } catch (ClassCastException e4) {
                    return false;
                }
            }
            return true;
        }
    }

    public int hashCode() {
        int[] iArr = this.f464f;
        Object[] objArr = this.f465g;
        int i = this.f466h;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f466h * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f466h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            C0237i b = m722b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            b = m723c(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
