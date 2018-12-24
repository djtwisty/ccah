package p000a.p006d;

import java.util.NoSuchElementException;
import p000a.p001a.C0017r;

/* renamed from: a.d.b */
public final class C0031b extends C0017r {
    /* renamed from: a */
    private final int f9a;
    /* renamed from: b */
    private boolean f10b;
    /* renamed from: c */
    private int f11c;
    /* renamed from: d */
    private final int f12d;

    public C0031b(int i, int i2, int i3) {
        boolean z = true;
        this.f12d = i3;
        this.f9a = i2;
        if (this.f12d > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.f10b = z;
        if (!this.f10b) {
            i = this.f9a;
        }
        this.f11c = i;
    }

    public boolean hasNext() {
        return this.f10b;
    }

    /* renamed from: b */
    public int mo1b() {
        int i = this.f11c;
        if (i != this.f9a) {
            this.f11c += this.f12d;
        } else if (this.f10b) {
            this.f10b = false;
        } else {
            throw new NoSuchElementException();
        }
        return i;
    }
}
