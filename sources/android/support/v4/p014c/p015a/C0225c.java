package android.support.v4.p014c.p015a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p014c.p015a.C0223b.C0220a;

/* renamed from: android.support.v4.c.a.c */
class C0225c extends C0223b {

    /* renamed from: android.support.v4.c.a.c$a */
    private static class C0224a extends C0220a {
        C0224a(C0220a c0220a, Resources resources) {
            super(c0220a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0225c(this, resources);
        }
    }

    C0225c(Drawable drawable) {
        super(drawable);
    }

    C0225c(C0220a c0220a, Resources resources) {
        super(c0220a, resources);
    }

    public void setAutoMirrored(boolean z) {
        this.c.setAutoMirrored(z);
    }

    public boolean isAutoMirrored() {
        return this.c.isAutoMirrored();
    }

    /* renamed from: a */
    C0220a mo122a() {
        return new C0224a(this.b, null);
    }
}
