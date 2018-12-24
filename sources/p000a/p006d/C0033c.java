package p000a.p006d;

/* renamed from: a.d.c */
public final class C0033c extends C0030a {
    /* renamed from: b */
    public static final C0032a f13b = new C0032a();
    /* renamed from: c */
    private static final C0033c f14c = new C0033c(1, 0);

    /* renamed from: a.d.c$a */
    public static final class C0032a {
        private C0032a() {
        }

        /* renamed from: a */
        public final C0033c m32a() {
            return C0033c.f14c;
        }
    }

    public C0033c(int i, int i2) {
        super(i, i2, 1);
    }

    /* renamed from: f */
    public Integer m35f() {
        return Integer.valueOf(m26a());
    }

    /* renamed from: g */
    public Integer m36g() {
        return Integer.valueOf(m27b());
    }

    /* renamed from: e */
    public boolean mo2e() {
        return m26a() > m27b();
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0033c) && ((mo2e() && ((C0033c) obj).mo2e()) || (m26a() == ((C0033c) obj).m26a() && m27b() == ((C0033c) obj).m27b()));
    }

    public int hashCode() {
        return mo2e() ? -1 : (m26a() * 31) + m27b();
    }

    public String toString() {
        return m26a() + ".." + m27b();
    }
}
