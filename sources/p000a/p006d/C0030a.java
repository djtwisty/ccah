package p000a.p006d;

import java.util.Iterator;
import p000a.p001a.C0017r;
import p000a.p002b.C0019a;

/* renamed from: a.d.a */
public class C0030a implements Iterable<Integer> {
    /* renamed from: a */
    public static final C0029a f5a = new C0029a();
    /* renamed from: b */
    private final int f6b;
    /* renamed from: c */
    private final int f7c;
    /* renamed from: d */
    private final int f8d;

    /* renamed from: a.d.a$a */
    public static final class C0029a {
        private C0029a() {
        }

        /* renamed from: a */
        public final C0030a m25a(int i, int i2, int i3) {
            return new C0030a(i, i2, i3);
        }
    }

    public /* synthetic */ Iterator iterator() {
        return m29d();
    }

    public C0030a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.f6b = i;
        this.f7c = C0019a.m13a(i, i2, i3);
        this.f8d = i3;
    }

    /* renamed from: a */
    public final int m26a() {
        return this.f6b;
    }

    /* renamed from: b */
    public final int m27b() {
        return this.f7c;
    }

    /* renamed from: c */
    public final int m28c() {
        return this.f8d;
    }

    /* renamed from: d */
    public C0017r m29d() {
        return new C0031b(this.f6b, this.f7c, this.f8d);
    }

    /* renamed from: e */
    public boolean mo2e() {
        return this.f8d > 0 ? this.f6b > this.f7c : this.f6b < this.f7c;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0030a) && ((mo2e() && ((C0030a) obj).mo2e()) || (this.f6b == ((C0030a) obj).f6b && this.f7c == ((C0030a) obj).f7c && this.f8d == ((C0030a) obj).f8d));
    }

    public int hashCode() {
        return mo2e() ? -1 : (((this.f6b * 31) + this.f7c) * 31) + this.f8d;
    }

    public String toString() {
        return this.f8d > 0 ? this.f6b + ".." + this.f7c + " step " + this.f8d : this.f6b + " downTo " + this.f7c + " step " + (-this.f8d);
    }
}
