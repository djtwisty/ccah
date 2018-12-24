package android.support.v4.p012a;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p012a.al.C0118a;
import android.support.v4.p012a.al.C0118a.C0112a;
import java.util.Set;

/* renamed from: android.support.v4.a.aj */
public final class aj extends C0118a {
    /* renamed from: a */
    public static final C0112a f110a = new C01131();
    /* renamed from: h */
    private static final C0114a f111h;
    /* renamed from: b */
    private final String f112b;
    /* renamed from: c */
    private final CharSequence f113c;
    /* renamed from: d */
    private final CharSequence[] f114d;
    /* renamed from: e */
    private final boolean f115e;
    /* renamed from: f */
    private final Bundle f116f;
    /* renamed from: g */
    private final Set<String> f117g;

    /* renamed from: android.support.v4.a.aj$1 */
    static class C01131 implements C0112a {
        C01131() {
        }
    }

    /* renamed from: android.support.v4.a.aj$a */
    interface C0114a {
    }

    /* renamed from: android.support.v4.a.aj$b */
    static class C0115b implements C0114a {
        C0115b() {
        }
    }

    /* renamed from: android.support.v4.a.aj$c */
    static class C0116c implements C0114a {
        C0116c() {
        }
    }

    /* renamed from: android.support.v4.a.aj$d */
    static class C0117d implements C0114a {
        C0117d() {
        }
    }

    /* renamed from: a */
    public String mo48a() {
        return this.f112b;
    }

    /* renamed from: b */
    public CharSequence mo49b() {
        return this.f113c;
    }

    /* renamed from: c */
    public CharSequence[] mo50c() {
        return this.f114d;
    }

    /* renamed from: d */
    public Set<String> mo51d() {
        return this.f117g;
    }

    /* renamed from: e */
    public boolean mo52e() {
        return this.f115e;
    }

    /* renamed from: f */
    public Bundle mo53f() {
        return this.f116f;
    }

    static {
        if (VERSION.SDK_INT >= 20) {
            f111h = new C0115b();
        } else if (VERSION.SDK_INT >= 16) {
            f111h = new C0117d();
        } else {
            f111h = new C0116c();
        }
    }
}
