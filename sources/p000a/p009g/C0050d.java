package p000a.p009g;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p000a.C0018a;
import p000a.C0028c;
import p000a.p003c.p004a.C0021a;
import p000a.p003c.p005b.C0024c;
import p000a.p006d.C0033c;
import p000a.p006d.C0036g;
import p000a.p008f.C0039a;

/* renamed from: a.g.d */
final class C0050d implements C0039a<C0033c> {
    /* renamed from: a */
    private final CharSequence f22a;
    /* renamed from: b */
    private final int f23b;
    /* renamed from: c */
    private final int f24c;
    /* renamed from: d */
    private final C0021a<CharSequence, Integer, C0018a<Integer, Integer>> f25d;

    /* renamed from: a.g.d$a */
    public static final class C0049a implements Iterator<C0033c> {
        /* renamed from: a */
        final /* synthetic */ C0050d f16a;
        /* renamed from: b */
        private int f17b = -1;
        /* renamed from: c */
        private int f18c;
        /* renamed from: d */
        private int f19d;
        /* renamed from: e */
        private C0033c f20e;
        /* renamed from: f */
        private int f21f;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        C0049a(C0050d c0050d) {
            this.f16a = c0050d;
            this.f18c = C0036g.m37a(c0050d.f23b, 0, c0050d.f22a.length());
            this.f19d = this.f18c;
        }

        public /* synthetic */ Object next() {
            return m47a();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: b */
        private final void m46b() {
            /*
            r6 = this;
            r2 = 1;
            r3 = 0;
            r5 = -1;
            r0 = r6.f19d;
            if (r0 >= 0) goto L_0x000f;
        L_0x0007:
            r6.f17b = r3;
            r0 = 0;
            r0 = (p000a.p006d.C0033c) r0;
            r6.f20e = r0;
        L_0x000e:
            return;
        L_0x000f:
            r0 = r6.f16a;
            r0 = r0.f24c;
            if (r0 <= 0) goto L_0x0027;
        L_0x0017:
            r0 = r6.f21f;
            r0 = r0 + 1;
            r6.f21f = r0;
            r0 = r6.f21f;
            r1 = r6.f16a;
            r1 = r1.f24c;
            if (r0 >= r1) goto L_0x0035;
        L_0x0027:
            r0 = r6.f19d;
            r1 = r6.f16a;
            r1 = r1.f22a;
            r1 = r1.length();
            if (r0 <= r1) goto L_0x004d;
        L_0x0035:
            r0 = r6.f18c;
            r1 = new a.d.c;
            r3 = r6.f16a;
            r3 = r3.f22a;
            r3 = p000a.p009g.C0059n.m71b(r3);
            r1.<init>(r0, r3);
            r6.f20e = r1;
            r6.f19d = r5;
        L_0x004a:
            r6.f17b = r2;
            goto L_0x000e;
        L_0x004d:
            r0 = r6.f16a;
            r0 = r0.f25d;
            r1 = r6.f16a;
            r1 = r1.f22a;
            r4 = r6.f19d;
            r4 = java.lang.Integer.valueOf(r4);
            r0 = r0.mo7a(r1, r4);
            r0 = (p000a.C0018a) r0;
            if (r0 != 0) goto L_0x007d;
        L_0x0067:
            r0 = r6.f18c;
            r1 = new a.d.c;
            r3 = r6.f16a;
            r3 = r3.f22a;
            r3 = p000a.p009g.C0059n.m71b(r3);
            r1.<init>(r0, r3);
            r6.f20e = r1;
            r6.f19d = r5;
            goto L_0x004a;
        L_0x007d:
            r1 = r0.m10c();
            r1 = (java.lang.Number) r1;
            r1 = r1.intValue();
            r0 = r0.m11d();
            r0 = (java.lang.Number) r0;
            r0 = r0.intValue();
            r4 = r6.f18c;
            r4 = p000a.p006d.C0036g.m39b(r4, r1);
            r6.f20e = r4;
            r1 = r1 + r0;
            r6.f18c = r1;
            r1 = r6.f18c;
            if (r0 != 0) goto L_0x00a5;
        L_0x00a0:
            r0 = r2;
        L_0x00a1:
            r0 = r0 + r1;
            r6.f19d = r0;
            goto L_0x004a;
        L_0x00a5:
            r0 = r3;
            goto L_0x00a1;
            */
            throw new UnsupportedOperationException("Method not decompiled: a.g.d.a.b():void");
        }

        /* renamed from: a */
        public C0033c m47a() {
            if (this.f17b == -1) {
                m46b();
            }
            if (this.f17b == 0) {
                throw new NoSuchElementException();
            }
            C0033c c0033c = this.f20e;
            if (c0033c == null) {
                throw new C0028c("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.f20e = (C0033c) null;
            this.f17b = -1;
            return c0033c;
        }

        public boolean hasNext() {
            if (this.f17b == -1) {
                m46b();
            }
            if (this.f17b == 1) {
                return true;
            }
            return false;
        }
    }

    public C0050d(CharSequence charSequence, int i, int i2, C0021a<? super CharSequence, ? super Integer, C0018a<Integer, Integer>> c0021a) {
        C0024c.m22b(charSequence, "input");
        C0024c.m22b(c0021a, "getNextMatch");
        this.f22a = charSequence;
        this.f23b = i;
        this.f24c = i2;
        this.f25d = c0021a;
    }

    /* renamed from: a */
    public Iterator<C0033c> mo6a() {
        return new C0049a(this);
    }
}
