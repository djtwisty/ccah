package android.support.v4.p018f;

import android.os.Build.VERSION;
import android.view.View;
import java.util.WeakHashMap;

/* renamed from: android.support.v4.f.b */
public class C0265b {
    /* renamed from: a */
    static final C0255j f510a;

    /* renamed from: android.support.v4.f.b$j */
    static class C0255j {
        /* renamed from: b */
        static boolean f507b = false;
        /* renamed from: c */
        private static WeakHashMap<View, String> f508c;
        /* renamed from: a */
        WeakHashMap<View, Object> f509a = null;

        C0255j() {
        }

        /* renamed from: a */
        public boolean mo137a(View view) {
            return true;
        }

        /* renamed from: c */
        public String mo139c(View view) {
            if (f508c == null) {
                return null;
            }
            return (String) f508c.get(view);
        }

        /* renamed from: b */
        public boolean mo138b(View view) {
            return view.getWindowToken() != null;
        }
    }

    /* renamed from: android.support.v4.f.b$a */
    static class C0256a extends C0255j {
        C0256a() {
        }
    }

    /* renamed from: android.support.v4.f.b$b */
    static class C0257b extends C0256a {
        C0257b() {
        }

        /* renamed from: a */
        public boolean mo137a(View view) {
            return view.hasOverlappingRendering();
        }
    }

    /* renamed from: android.support.v4.f.b$c */
    static class C0258c extends C0257b {
        C0258c() {
        }
    }

    /* renamed from: android.support.v4.f.b$d */
    static class C0259d extends C0258c {
        C0259d() {
        }
    }

    /* renamed from: android.support.v4.f.b$e */
    static class C0260e extends C0259d {
        C0260e() {
        }

        /* renamed from: b */
        public boolean mo138b(View view) {
            return view.isAttachedToWindow();
        }
    }

    /* renamed from: android.support.v4.f.b$f */
    static class C0261f extends C0260e {
        C0261f() {
        }

        /* renamed from: c */
        public String mo139c(View view) {
            return view.getTransitionName();
        }
    }

    /* renamed from: android.support.v4.f.b$g */
    static class C0262g extends C0261f {
        C0262g() {
        }
    }

    /* renamed from: android.support.v4.f.b$h */
    static class C0263h extends C0262g {
        C0263h() {
        }
    }

    /* renamed from: android.support.v4.f.b$i */
    static class C0264i extends C0263h {
        C0264i() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            f510a = new C0264i();
        } else if (VERSION.SDK_INT >= 24) {
            f510a = new C0263h();
        } else if (VERSION.SDK_INT >= 23) {
            f510a = new C0262g();
        } else if (VERSION.SDK_INT >= 21) {
            f510a = new C0261f();
        } else if (VERSION.SDK_INT >= 19) {
            f510a = new C0260e();
        } else if (VERSION.SDK_INT >= 18) {
            f510a = new C0259d();
        } else if (VERSION.SDK_INT >= 17) {
            f510a = new C0258c();
        } else if (VERSION.SDK_INT >= 16) {
            f510a = new C0257b();
        } else if (VERSION.SDK_INT >= 15) {
            f510a = new C0256a();
        } else {
            f510a = new C0255j();
        }
    }

    /* renamed from: a */
    public static String m776a(View view) {
        return f510a.mo139c(view);
    }

    /* renamed from: b */
    public static boolean m777b(View view) {
        return f510a.mo137a(view);
    }

    /* renamed from: c */
    public static boolean m778c(View view) {
        return f510a.mo138b(view);
    }
}
