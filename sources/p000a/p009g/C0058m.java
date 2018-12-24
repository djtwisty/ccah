package p000a.p009g;

import p000a.p003c.p005b.C0024c;

/* renamed from: a.g.m */
class C0058m extends C0057l {
    /* renamed from: a */
    public static /* bridge */ /* synthetic */ boolean m55a(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return C0058m.m54a(str, str2, z);
    }

    /* renamed from: a */
    public static final boolean m54a(String str, String str2, boolean z) {
        C0024c.m22b(str, "$receiver");
        C0024c.m22b(str2, "prefix");
        if (!z) {
            return str.startsWith(str2);
        }
        return C0058m.m53a(str, 0, str2, 0, str2.length(), z);
    }

    /* renamed from: b */
    public static /* bridge */ /* synthetic */ boolean m57b(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return C0058m.m56b(str, str2, z);
    }

    /* renamed from: b */
    public static final boolean m56b(String str, String str2, boolean z) {
        C0024c.m22b(str, "$receiver");
        C0024c.m22b(str2, "suffix");
        if (!z) {
            return str.endsWith(str2);
        }
        return C0058m.m53a(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    /* renamed from: a */
    public static final boolean m53a(String str, int i, String str2, int i2, int i3, boolean z) {
        C0024c.m22b(str, "$receiver");
        C0024c.m22b(str2, "other");
        if (z) {
            return str.regionMatches(z, i, str2, i2, i3);
        }
        return str.regionMatches(i, str2, i2, i3);
    }
}
