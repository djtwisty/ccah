package android.support.v4.p017e;

/* renamed from: android.support.v4.e.h */
public class C0250h<F, S> {
    /* renamed from: a */
    public final F f497a;
    /* renamed from: b */
    public final S f498b;

    public boolean equals(Object obj) {
        if (!(obj instanceof C0250h)) {
            return false;
        }
        C0250h c0250h = (C0250h) obj;
        if (C0250h.m753a(c0250h.f497a, this.f497a) && C0250h.m753a(c0250h.f498b, this.f498b)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m753a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.f497a == null ? 0 : this.f497a.hashCode();
        if (this.f498b != null) {
            i = this.f498b.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f497a) + " " + String.valueOf(this.f498b) + "}";
    }
}
