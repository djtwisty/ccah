package android.support.v4.p014c.p015a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.c.a.a */
public final class C0219a {
    /* renamed from: a */
    static final C0214e f435a;

    /* renamed from: android.support.v4.c.a.a$e */
    static class C0214e {
        C0214e() {
        }

        /* renamed from: a */
        public void mo117a(Drawable drawable, ColorStateList colorStateList) {
            if (drawable instanceof C0222e) {
                ((C0222e) drawable).setTintList(colorStateList);
            }
        }

        /* renamed from: a */
        public void mo118a(Drawable drawable, Mode mode) {
            if (drawable instanceof C0222e) {
                ((C0222e) drawable).setTintMode(mode);
            }
        }

        /* renamed from: a */
        public Drawable mo116a(Drawable drawable) {
            if (drawable instanceof C0222e) {
                return drawable;
            }
            return new C0223b(drawable);
        }
    }

    /* renamed from: android.support.v4.c.a.a$a */
    static class C0215a extends C0214e {
        C0215a() {
        }
    }

    /* renamed from: android.support.v4.c.a.a$b */
    static class C0216b extends C0215a {
        C0216b() {
        }

        /* renamed from: a */
        public Drawable mo116a(Drawable drawable) {
            if (drawable instanceof C0222e) {
                return drawable;
            }
            return new C0225c(drawable);
        }
    }

    /* renamed from: android.support.v4.c.a.a$c */
    static class C0217c extends C0216b {
        C0217c() {
        }

        /* renamed from: a */
        public void mo117a(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        /* renamed from: a */
        public void mo118a(Drawable drawable, Mode mode) {
            drawable.setTintMode(mode);
        }

        /* renamed from: a */
        public Drawable mo116a(Drawable drawable) {
            if (drawable instanceof C0222e) {
                return drawable;
            }
            return new C0227d(drawable);
        }
    }

    /* renamed from: android.support.v4.c.a.a$d */
    static class C0218d extends C0217c {
        C0218d() {
        }

        /* renamed from: a */
        public Drawable mo116a(Drawable drawable) {
            return drawable;
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            f435a = new C0218d();
        } else if (VERSION.SDK_INT >= 21) {
            f435a = new C0217c();
        } else if (VERSION.SDK_INT >= 19) {
            f435a = new C0216b();
        } else if (VERSION.SDK_INT >= 17) {
            f435a = new C0215a();
        } else {
            f435a = new C0214e();
        }
    }

    /* renamed from: a */
    public static void m666a(Drawable drawable, ColorStateList colorStateList) {
        f435a.mo117a(drawable, colorStateList);
    }

    /* renamed from: a */
    public static void m667a(Drawable drawable, Mode mode) {
        f435a.mo118a(drawable, mode);
    }

    /* renamed from: a */
    public static Drawable m665a(Drawable drawable) {
        return f435a.mo116a(drawable);
    }
}
