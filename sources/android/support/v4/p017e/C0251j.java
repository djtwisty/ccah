package android.support.v4.p017e;

/* renamed from: android.support.v4.e.j */
public class C0251j<E> implements Cloneable {
    /* renamed from: a */
    private static final Object f499a = new Object();
    /* renamed from: b */
    private boolean f500b;
    /* renamed from: c */
    private int[] f501c;
    /* renamed from: d */
    private Object[] f502d;
    /* renamed from: e */
    private int f503e;

    public /* synthetic */ Object clone() {
        return m755a();
    }

    public C0251j() {
        this(10);
    }

    public C0251j(int i) {
        this.f500b = false;
        if (i == 0) {
            this.f501c = C0241c.f480a;
            this.f502d = C0241c.f482c;
        } else {
            int a = C0241c.m745a(i);
            this.f501c = new int[a];
            this.f502d = new Object[a];
        }
        this.f503e = 0;
    }

    /* renamed from: a */
    public C0251j<E> m755a() {
        try {
            C0251j<E> c0251j = (C0251j) super.clone();
            try {
                c0251j.f501c = (int[]) this.f501c.clone();
                c0251j.f502d = (Object[]) this.f502d.clone();
                return c0251j;
            } catch (CloneNotSupportedException e) {
                return c0251j;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    /* renamed from: a */
    public E m756a(int i) {
        return m757a(i, null);
    }

    /* renamed from: a */
    public E m757a(int i, E e) {
        int a = C0241c.m746a(this.f501c, this.f503e, i);
        return (a < 0 || this.f502d[a] == f499a) ? e : this.f502d[a];
    }

    /* renamed from: b */
    public void m759b(int i) {
        int a = C0241c.m746a(this.f501c, this.f503e, i);
        if (a >= 0 && this.f502d[a] != f499a) {
            this.f502d[a] = f499a;
            this.f500b = true;
        }
    }

    /* renamed from: c */
    public void m762c(int i) {
        m759b(i);
    }

    /* renamed from: d */
    private void m754d() {
        int i = this.f503e;
        int[] iArr = this.f501c;
        Object[] objArr = this.f502d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f499a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f500b = false;
        this.f503e = i2;
    }

    /* renamed from: b */
    public void m760b(int i, E e) {
        int a = C0241c.m746a(this.f501c, this.f503e, i);
        if (a >= 0) {
            this.f502d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f503e || this.f502d[a] != f499a) {
            if (this.f500b && this.f503e >= this.f501c.length) {
                m754d();
                a = C0241c.m746a(this.f501c, this.f503e, i) ^ -1;
            }
            if (this.f503e >= this.f501c.length) {
                int a2 = C0241c.m745a(this.f503e + 1);
                Object obj = new int[a2];
                Object obj2 = new Object[a2];
                System.arraycopy(this.f501c, 0, obj, 0, this.f501c.length);
                System.arraycopy(this.f502d, 0, obj2, 0, this.f502d.length);
                this.f501c = obj;
                this.f502d = obj2;
            }
            if (this.f503e - a != 0) {
                System.arraycopy(this.f501c, a, this.f501c, a + 1, this.f503e - a);
                System.arraycopy(this.f502d, a, this.f502d, a + 1, this.f503e - a);
            }
            this.f501c[a] = i;
            this.f502d[a] = e;
            this.f503e++;
            return;
        }
        this.f501c[a] = i;
        this.f502d[a] = e;
    }

    /* renamed from: b */
    public int m758b() {
        if (this.f500b) {
            m754d();
        }
        return this.f503e;
    }

    /* renamed from: d */
    public int m763d(int i) {
        if (this.f500b) {
            m754d();
        }
        return this.f501c[i];
    }

    /* renamed from: e */
    public E m764e(int i) {
        if (this.f500b) {
            m754d();
        }
        return this.f502d[i];
    }

    /* renamed from: f */
    public int m765f(int i) {
        if (this.f500b) {
            m754d();
        }
        return C0241c.m746a(this.f501c, this.f503e, i);
    }

    /* renamed from: c */
    public void m761c() {
        int i = this.f503e;
        Object[] objArr = this.f502d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f503e = 0;
        this.f500b = false;
    }

    public String toString() {
        if (m758b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f503e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f503e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m763d(i));
            stringBuilder.append('=');
            C0251j e = m764e(i);
            if (e != this) {
                stringBuilder.append(e);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
