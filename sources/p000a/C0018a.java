package p000a;

import java.io.Serializable;

/* renamed from: a.a */
public final class C0018a<A, B> implements Serializable {
    /* renamed from: a */
    private final A f0a;
    /* renamed from: b */
    private final B f1b;

    /* renamed from: c */
    public final A m10c() {
        return this.f0a;
    }

    /* renamed from: d */
    public final B m11d() {
        return this.f1b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
        r2 = this;
        if (r2 == r3) goto L_0x001c;
    L_0x0002:
        r0 = r3 instanceof p000a.C0018a;
        if (r0 == 0) goto L_0x001e;
    L_0x0006:
        r3 = (p000a.C0018a) r3;
        r0 = r2.f0a;
        r1 = r3.f0a;
        r0 = p000a.p003c.p005b.C0024c.m21a(r0, r1);
        if (r0 == 0) goto L_0x001e;
    L_0x0012:
        r0 = r2.f1b;
        r1 = r3.f1b;
        r0 = p000a.p003c.p005b.C0024c.m21a(r0, r1);
        if (r0 == 0) goto L_0x001e;
    L_0x001c:
        r0 = 1;
    L_0x001d:
        return r0;
    L_0x001e:
        r0 = 0;
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        Object obj = this.f0a;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Object obj2 = this.f1b;
        if (obj2 != null) {
            i = obj2.hashCode();
        }
        return hashCode + i;
    }

    public C0018a(A a, B b) {
        this.f0a = a;
        this.f1b = b;
    }

    /* renamed from: a */
    public final A m8a() {
        return this.f0a;
    }

    /* renamed from: b */
    public final B m9b() {
        return this.f1b;
    }

    public String toString() {
        return '(' + this.f0a + ", " + this.f1b + ')';
    }
}
