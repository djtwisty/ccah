package p000a.p009g;

/* renamed from: a.g.c */
class C0047c extends C0046b {
    /* renamed from: a */
    public static final boolean m45a(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        if (Character.toUpperCase(c) == Character.toUpperCase(c2) || Character.toLowerCase(c) == Character.toLowerCase(c2)) {
            return true;
        }
        return false;
    }
}
