package android.support.v4.p018f;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.f.a */
public final class C0254a {
    /* renamed from: a */
    static final C0252b f504a;
    /* renamed from: b */
    private static Field f505b;
    /* renamed from: c */
    private static boolean f506c;

    /* renamed from: android.support.v4.f.a$b */
    static class C0252b {
        C0252b() {
        }

        /* renamed from: a */
        public void mo136a(LayoutInflater layoutInflater, Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
            Factory factory = layoutInflater.getFactory();
            if (factory instanceof Factory2) {
                C0254a.m768a(layoutInflater, (Factory2) factory);
            } else {
                C0254a.m768a(layoutInflater, factory2);
            }
        }
    }

    /* renamed from: android.support.v4.f.a$a */
    static class C0253a extends C0252b {
        C0253a() {
        }

        /* renamed from: a */
        public void mo136a(LayoutInflater layoutInflater, Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
        }
    }

    /* renamed from: a */
    static void m768a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!f506c) {
            try {
                f505b = LayoutInflater.class.getDeclaredField("mFactory2");
                f505b.setAccessible(true);
            } catch (Throwable e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f506c = true;
        }
        if (f505b != null) {
            try {
                f505b.set(layoutInflater, factory2);
            } catch (Throwable e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f504a = new C0253a();
        } else {
            f504a = new C0252b();
        }
    }

    /* renamed from: b */
    public static void m769b(LayoutInflater layoutInflater, Factory2 factory2) {
        f504a.mo136a(layoutInflater, factory2);
    }
}
