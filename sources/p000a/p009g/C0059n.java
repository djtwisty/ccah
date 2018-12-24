package p000a.p009g;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C0018a;
import p000a.C0020b;
import p000a.p001a.C0002d;
import p000a.p001a.C0006h;
import p000a.p001a.C0008j;
import p000a.p003c.p004a.C0021a;
import p000a.p003c.p005b.C0024c;
import p000a.p003c.p005b.C0025d;
import p000a.p006d.C0033c;
import p000a.p006d.C0036g;
import p000a.p008f.C0039a;
import p000a.p008f.C0043f;

/* renamed from: a.g.n */
class C0059n extends C0058m {

    /* renamed from: a.g.n$a */
    static final class C0063a extends C0025d implements C0021a<CharSequence, Integer, C0018a<? extends Integer, ? extends Integer>> {
        /* renamed from: a */
        final /* synthetic */ List f26a;
        /* renamed from: b */
        final /* synthetic */ boolean f27b;

        C0063a(List list, boolean z) {
            this.f26a = list;
            this.f27b = z;
            super(2);
        }

        /* renamed from: a */
        public /* synthetic */ Object mo7a(Object obj, Object obj2) {
            return m75a((CharSequence) obj, ((Number) obj2).intValue());
        }

        /* renamed from: a */
        public final C0018a<Integer, Integer> m75a(CharSequence charSequence, int i) {
            C0024c.m22b(charSequence, "$receiver");
            C0018a a = C0059n.m74b(charSequence, this.f26a, i, this.f27b, false);
            return a != null ? C0020b.m15a(a.m8a(), Integer.valueOf(((String) a.m9b()).length())) : null;
        }
    }

    /* renamed from: b */
    public static final int m71b(CharSequence charSequence) {
        C0024c.m22b(charSequence, "$receiver");
        return charSequence.length() - 1;
    }

    /* renamed from: a */
    public static final String m66a(CharSequence charSequence, C0033c c0033c) {
        C0024c.m22b(charSequence, "$receiver");
        C0024c.m22b(c0033c, "range");
        return charSequence.subSequence(c0033c.m35f().intValue(), c0033c.m36g().intValue() + 1).toString();
    }

    /* renamed from: a */
    public static final boolean m70a(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        C0024c.m22b(charSequence, "$receiver");
        C0024c.m22b(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!C0047c.m45a(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    static /* bridge */ /* synthetic */ int m59a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return C0059n.m58a(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static final int m58a(java.lang.CharSequence r8, java.lang.CharSequence r9, int r10, int r11, boolean r12, boolean r13) {
        /*
        r1 = 0;
        if (r13 != 0) goto L_0x0040;
    L_0x0003:
        r2 = p000a.p006d.C0036g.m40c(r10, r1);
        r0 = new a.d.c;
        r3 = r8.length();
        r3 = p000a.p006d.C0036g.m41d(r11, r3);
        r0.<init>(r2, r3);
        r0 = (p000a.p006d.C0030a) r0;
    L_0x0016:
        r2 = r8 instanceof java.lang.String;
        if (r2 == 0) goto L_0x0059;
    L_0x001a:
        r2 = r9 instanceof java.lang.String;
        if (r2 == 0) goto L_0x0059;
    L_0x001e:
        r3 = r0.m26a();
        r6 = r0.m27b();
        r7 = r0.m28c();
        if (r7 <= 0) goto L_0x0051;
    L_0x002c:
        if (r3 > r6) goto L_0x0053;
    L_0x002e:
        r0 = r9;
        r0 = (java.lang.String) r0;
        r2 = r8;
        r2 = (java.lang.String) r2;
        r4 = r9.length();
        r5 = r12;
        r0 = p000a.p009g.C0058m.m53a(r0, r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x0055;
    L_0x003f:
        return r3;
    L_0x0040:
        r0 = p000a.p009g.C0059n.m71b(r8);
        r0 = p000a.p006d.C0036g.m41d(r10, r0);
        r2 = p000a.p006d.C0036g.m40c(r11, r1);
        r0 = p000a.p006d.C0036g.m38a(r0, r2);
        goto L_0x0016;
    L_0x0051:
        if (r3 >= r6) goto L_0x002e;
    L_0x0053:
        r3 = -1;
        goto L_0x003f;
    L_0x0055:
        if (r3 == r6) goto L_0x0053;
    L_0x0057:
        r3 = r3 + r7;
        goto L_0x002e;
    L_0x0059:
        r3 = r0.m26a();
        r6 = r0.m27b();
        r7 = r0.m28c();
        if (r7 <= 0) goto L_0x007a;
    L_0x0067:
        if (r3 > r6) goto L_0x0053;
    L_0x0069:
        r4 = r9.length();
        r0 = r9;
        r2 = r8;
        r5 = r12;
        r0 = p000a.p009g.C0059n.m70a(r0, r1, r2, r3, r4, r5);
        if (r0 != 0) goto L_0x003f;
    L_0x0076:
        if (r3 == r6) goto L_0x0053;
    L_0x0078:
        r3 = r3 + r7;
        goto L_0x0069;
    L_0x007a:
        if (r3 < r6) goto L_0x0053;
    L_0x007c:
        goto L_0x0069;
        */
        throw new UnsupportedOperationException("Method not decompiled: a.g.n.a(java.lang.CharSequence, java.lang.CharSequence, int, int, boolean, boolean):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private static final p000a.C0018a<java.lang.Integer, java.lang.String> m74b(java.lang.CharSequence r10, java.util.Collection<java.lang.String> r11, int r12, boolean r13, boolean r14) {
        /*
        if (r13 != 0) goto L_0x0033;
    L_0x0002:
        r0 = r11.size();
        r1 = 1;
        if (r0 != r1) goto L_0x0033;
    L_0x0009:
        r11 = (java.lang.Iterable) r11;
        r1 = p000a.p001a.C0015q.m4a(r11);
        r1 = (java.lang.String) r1;
        if (r14 != 0) goto L_0x0020;
    L_0x0013:
        r3 = 0;
        r4 = 4;
        r5 = 0;
        r0 = r10;
        r2 = r12;
        r0 = p000a.p009g.C0059n.m61a(r0, r1, r2, r3, r4, r5);
    L_0x001c:
        if (r0 >= 0) goto L_0x002a;
    L_0x001e:
        r0 = 0;
    L_0x001f:
        return r0;
    L_0x0020:
        r3 = 0;
        r4 = 4;
        r5 = 0;
        r0 = r10;
        r2 = r12;
        r0 = p000a.p009g.C0059n.m73b(r0, r1, r2, r3, r4, r5);
        goto L_0x001c;
    L_0x002a:
        r0 = java.lang.Integer.valueOf(r0);
        r0 = p000a.C0020b.m15a(r0, r1);
        goto L_0x001f;
    L_0x0033:
        if (r14 != 0) goto L_0x008a;
    L_0x0035:
        r0 = 0;
        r1 = p000a.p006d.C0036g.m40c(r12, r0);
        r0 = new a.d.c;
        r2 = r10.length();
        r0.<init>(r1, r2);
        r0 = (p000a.p006d.C0030a) r0;
    L_0x0045:
        r1 = r10 instanceof java.lang.String;
        if (r1 == 0) goto L_0x00a2;
    L_0x0049:
        r3 = r0.m26a();
        r7 = r0.m27b();
        r8 = r0.m28c();
        if (r8 <= 0) goto L_0x0098;
    L_0x0057:
        if (r3 > r7) goto L_0x009a;
    L_0x0059:
        r0 = r11;
        r0 = (java.lang.Iterable) r0;
        r9 = r0.iterator();
    L_0x0060:
        r0 = r9.hasNext();
        if (r0 == 0) goto L_0x009c;
    L_0x0066:
        r6 = r9.next();
        r0 = r6;
        r0 = (java.lang.String) r0;
        r1 = 0;
        r2 = r10;
        r2 = (java.lang.String) r2;
        r4 = r0.length();
        r5 = r13;
        r0 = p000a.p009g.C0058m.m53a(r0, r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x0060;
    L_0x007c:
        r0 = r6;
    L_0x007d:
        r0 = (java.lang.String) r0;
        if (r0 == 0) goto L_0x009e;
    L_0x0081:
        r1 = java.lang.Integer.valueOf(r3);
        r0 = p000a.C0020b.m15a(r1, r0);
        goto L_0x001f;
    L_0x008a:
        r0 = p000a.p009g.C0059n.m71b(r10);
        r0 = p000a.p006d.C0036g.m41d(r12, r0);
        r1 = 0;
        r0 = p000a.p006d.C0036g.m38a(r0, r1);
        goto L_0x0045;
    L_0x0098:
        if (r3 >= r7) goto L_0x0059;
    L_0x009a:
        r0 = 0;
        goto L_0x001f;
    L_0x009c:
        r0 = 0;
        goto L_0x007d;
    L_0x009e:
        if (r3 == r7) goto L_0x009a;
    L_0x00a0:
        r3 = r3 + r8;
        goto L_0x0059;
    L_0x00a2:
        r3 = r0.m26a();
        r7 = r0.m27b();
        r8 = r0.m28c();
        if (r8 <= 0) goto L_0x00e5;
    L_0x00b0:
        if (r3 > r7) goto L_0x009a;
    L_0x00b2:
        r0 = r11;
        r0 = (java.lang.Iterable) r0;
        r9 = r0.iterator();
    L_0x00b9:
        r0 = r9.hasNext();
        if (r0 == 0) goto L_0x00e8;
    L_0x00bf:
        r6 = r9.next();
        r2 = r6;
        r2 = (java.lang.String) r2;
        r0 = r2;
        r0 = (java.lang.CharSequence) r0;
        r1 = 0;
        r4 = r2.length();
        r2 = r10;
        r5 = r13;
        r0 = p000a.p009g.C0059n.m70a(r0, r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x00b9;
    L_0x00d6:
        r0 = r6;
    L_0x00d7:
        r0 = (java.lang.String) r0;
        if (r0 == 0) goto L_0x00ea;
    L_0x00db:
        r1 = java.lang.Integer.valueOf(r3);
        r0 = p000a.C0020b.m15a(r1, r0);
        goto L_0x001f;
    L_0x00e5:
        if (r3 < r7) goto L_0x009a;
    L_0x00e7:
        goto L_0x00b2;
    L_0x00e8:
        r0 = 0;
        goto L_0x00d7;
    L_0x00ea:
        if (r3 == r7) goto L_0x009a;
    L_0x00ec:
        r3 = r3 + r8;
        goto L_0x00b2;
        */
        throw new UnsupportedOperationException("Method not decompiled: a.g.n.b(java.lang.CharSequence, java.util.Collection, int, boolean, boolean):a.a<java.lang.Integer, java.lang.String>");
    }

    /* renamed from: a */
    public static final int m60a(CharSequence charSequence, String str, int i, boolean z) {
        C0024c.m22b(charSequence, "$receiver");
        C0024c.m22b(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i);
        }
        return C0059n.m59a(charSequence, str, i, charSequence.length(), z, false, 16, null);
    }

    /* renamed from: b */
    public static /* bridge */ /* synthetic */ int m73b(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = C0059n.m71b(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return C0059n.m72b(charSequence, str, i, z);
    }

    /* renamed from: b */
    public static final int m72b(CharSequence charSequence, String str, int i, boolean z) {
        C0024c.m22b(charSequence, "$receiver");
        C0024c.m22b(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(str, i);
        }
        return C0059n.m58a(charSequence, (CharSequence) str, i, 0, z, true);
    }

    /* renamed from: a */
    static /* bridge */ /* synthetic */ C0039a m64a(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return C0059n.m63a(charSequence, strArr, i, z, i2);
    }

    /* renamed from: a */
    private static final C0039a<C0033c> m63a(CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        if ((i2 >= 0 ? 1 : null) != null) {
            return new C0050d(charSequence, i, i2, new C0063a(C0002d.m0a(strArr), z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    /* renamed from: a */
    public static final List<String> m68a(CharSequence charSequence, String[] strArr, boolean z, int i) {
        C0024c.m22b(charSequence, "$receiver");
        C0024c.m22b(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if ((((CharSequence) str).length() == 0 ? 1 : 0) == 0) {
                return C0059n.m67a(charSequence, str, z, i);
            }
        }
        Iterable<C0033c> a = C0043f.m43a(C0059n.m64a(charSequence, strArr, 0, z, i, 2, null));
        Collection arrayList = new ArrayList(C0008j.m3a(a, 10));
        for (C0033c a2 : a) {
            arrayList.add(C0059n.m66a(charSequence, a2));
        }
        return (List) arrayList;
    }

    /* renamed from: a */
    private static final List<String> m67a(CharSequence charSequence, String str, boolean z, int i) {
        int i2 = 10;
        if ((i >= 0 ? 1 : 0) == 0) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
        }
        int a = C0059n.m60a(charSequence, str, 0, z);
        if (a == -1 || i == 1) {
            return C0006h.m2a(charSequence.toString());
        }
        int i3 = i > 0 ? 1 : 0;
        if (i3 != 0) {
            i2 = C0036g.m41d(i, 10);
        }
        ArrayList arrayList = new ArrayList(i2);
        i2 = a;
        int i4 = 0;
        while (true) {
            arrayList.add(charSequence.subSequence(i4, i2).toString());
            a = i2 + str.length();
            if (i3 != 0 && arrayList.size() == i - 1) {
                break;
            }
            int a2 = C0059n.m60a(charSequence, str, a, z);
            if (a2 == -1) {
                break;
            }
            i2 = a2;
            i4 = a;
        }
        arrayList.add(charSequence.subSequence(a, charSequence.length()).toString());
        return arrayList;
    }

    /* renamed from: a */
    public static final CharSequence m65a(CharSequence charSequence) {
        C0024c.m22b(charSequence, "$receiver");
        int length = charSequence.length() - 1;
        Object obj = null;
        int i = 0;
        while (i <= length) {
            Object obj2;
            boolean a = C0046b.m44a(charSequence.charAt(obj == null ? i : length));
            if (obj == null) {
                if (a) {
                    i++;
                    obj2 = obj;
                } else {
                    obj2 = 1;
                }
            } else if (!a) {
                break;
            } else {
                length--;
                obj2 = obj;
            }
            obj = obj2;
        }
        return charSequence.subSequence(i, length + 1);
    }
}
