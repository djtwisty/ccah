package android.support.v4.p012a;

import android.os.Bundle;
import android.support.v4.p012a.C0183v.C0182a;
import android.support.v4.p013b.C0207c;
import android.support.v4.p013b.C0207c.C0184a;
import android.support.v4.p013b.C0207c.C0185b;
import android.support.v4.p017e.C0242d;
import android.support.v4.p017e.C0251j;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* renamed from: android.support.v4.a.w */
class C0187w extends C0183v {
    /* renamed from: a */
    static boolean f345a = false;
    /* renamed from: b */
    final C0251j<C0186a> f346b = new C0251j();
    /* renamed from: c */
    final C0251j<C0186a> f347c = new C0251j();
    /* renamed from: d */
    final String f348d;
    /* renamed from: e */
    boolean f349e;
    /* renamed from: f */
    boolean f350f;
    /* renamed from: g */
    C0142m f351g;

    /* renamed from: android.support.v4.a.w$a */
    final class C0186a implements C0184a<Object>, C0185b<Object> {
        /* renamed from: a */
        final int f330a;
        /* renamed from: b */
        final Bundle f331b;
        /* renamed from: c */
        C0182a<Object> f332c;
        /* renamed from: d */
        C0207c<Object> f333d;
        /* renamed from: e */
        boolean f334e;
        /* renamed from: f */
        boolean f335f;
        /* renamed from: g */
        Object f336g;
        /* renamed from: h */
        boolean f337h;
        /* renamed from: i */
        boolean f338i;
        /* renamed from: j */
        boolean f339j;
        /* renamed from: k */
        boolean f340k;
        /* renamed from: l */
        boolean f341l;
        /* renamed from: m */
        boolean f342m;
        /* renamed from: n */
        C0186a f343n;
        /* renamed from: o */
        final /* synthetic */ C0187w f344o;

        /* renamed from: a */
        void m555a() {
            if (this.f338i && this.f339j) {
                this.f337h = true;
            } else if (!this.f337h) {
                this.f337h = true;
                if (C0187w.f345a) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.f333d == null && this.f332c != null) {
                    this.f333d = this.f332c.m551a(this.f330a, this.f331b);
                }
                if (this.f333d == null) {
                    return;
                }
                if (!this.f333d.getClass().isMemberClass() || Modifier.isStatic(this.f333d.getClass().getModifiers())) {
                    if (!this.f342m) {
                        this.f333d.m638a(this.f330a, this);
                        this.f333d.m639a((C0184a) this);
                        this.f342m = true;
                    }
                    this.f333d.m637a();
                    return;
                }
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f333d);
            }
        }

        /* renamed from: b */
        void m558b() {
            if (C0187w.f345a) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.f338i = true;
            this.f339j = this.f337h;
            this.f337h = false;
            this.f332c = null;
        }

        /* renamed from: c */
        void m559c() {
            if (this.f338i) {
                if (C0187w.f345a) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.f338i = false;
                if (!(this.f337h == this.f339j || this.f337h)) {
                    m561e();
                }
            }
            if (this.f337h && this.f334e && !this.f340k) {
                m556a(this.f333d, this.f336g);
            }
        }

        /* renamed from: d */
        void m560d() {
            if (this.f337h && this.f340k) {
                this.f340k = false;
                if (this.f334e && !this.f338i) {
                    m556a(this.f333d, this.f336g);
                }
            }
        }

        /* renamed from: e */
        void m561e() {
            if (C0187w.f345a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f337h = false;
            if (!this.f338i && this.f333d != null && this.f342m) {
                this.f342m = false;
                this.f333d.m640a((C0185b) this);
                this.f333d.m643b(this);
                this.f333d.m644c();
            }
        }

        /* renamed from: f */
        void m562f() {
            String str;
            C0182a c0182a = null;
            if (C0187w.f345a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f341l = true;
            boolean z = this.f335f;
            this.f335f = false;
            if (this.f332c != null && this.f333d != null && this.f334e && z) {
                if (C0187w.f345a) {
                    Log.v("LoaderManager", "  Resetting: " + this);
                }
                if (this.f344o.f351g != null) {
                    String str2 = this.f344o.f351g.f188d.f254u;
                    this.f344o.f351g.f188d.f254u = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.f332c.m552a(this.f333d);
                } finally {
                    c0182a = this.f344o.f351g;
                    if (c0182a != null) {
                        c0182a = this.f344o.f351g.f188d;
                        c0182a.f254u = str;
                    }
                }
            }
            this.f332c = c0182a;
            this.f336g = c0182a;
            this.f334e = false;
            if (this.f333d != null) {
                if (this.f342m) {
                    this.f342m = false;
                    this.f333d.m640a((C0185b) this);
                    this.f333d.m643b(this);
                }
                this.f333d.m646e();
            }
            if (this.f343n != null) {
                this.f343n.m562f();
            }
        }

        /* renamed from: a */
        void m556a(C0207c<Object> c0207c, Object obj) {
            String str;
            if (this.f332c != null) {
                if (this.f344o.f351g != null) {
                    String str2 = this.f344o.f351g.f188d.f254u;
                    this.f344o.f351g.f188d.f254u = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (C0187w.f345a) {
                        Log.v("LoaderManager", "  onLoadFinished in " + c0207c + ": " + c0207c.m636a(obj));
                    }
                    this.f332c.m553a((C0207c) c0207c, obj);
                    this.f335f = true;
                } finally {
                    if (this.f344o.f351g != null) {
                        this.f344o.f351g.f188d.f254u = str;
                    }
                }
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.f330a);
            stringBuilder.append(" : ");
            C0242d.m749a(this.f333d, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }

        /* renamed from: a */
        public void m557a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f330a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f331b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.f332c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f333d);
            if (this.f333d != null) {
                this.f333d.m641a(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.f334e || this.f335f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.f334e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f335f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.f336g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f337h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.f340k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.f341l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.f338i);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.f339j);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.f342m);
            if (this.f343n != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.f343n);
                printWriter.println(":");
                this.f343n.m557a(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    C0187w(String str, C0142m c0142m, boolean z) {
        this.f348d = str;
        this.f351g = c0142m;
        this.f349e = z;
    }

    /* renamed from: a */
    void m563a(C0142m c0142m) {
        this.f351g = c0142m;
    }

    /* renamed from: b */
    void m566b() {
        if (f345a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f349e) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f349e = true;
        for (int b = this.f346b.m758b() - 1; b >= 0; b--) {
            ((C0186a) this.f346b.m764e(b)).m555a();
        }
    }

    /* renamed from: c */
    void m567c() {
        if (f345a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.f349e) {
            for (int b = this.f346b.m758b() - 1; b >= 0; b--) {
                ((C0186a) this.f346b.m764e(b)).m561e();
            }
            this.f349e = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    /* renamed from: d */
    void m568d() {
        if (f345a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.f349e) {
            this.f350f = true;
            this.f349e = false;
            for (int b = this.f346b.m758b() - 1; b >= 0; b--) {
                ((C0186a) this.f346b.m764e(b)).m558b();
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    /* renamed from: e */
    void m569e() {
        if (this.f350f) {
            if (f345a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f350f = false;
            for (int b = this.f346b.m758b() - 1; b >= 0; b--) {
                ((C0186a) this.f346b.m764e(b)).m559c();
            }
        }
    }

    /* renamed from: f */
    void m570f() {
        for (int b = this.f346b.m758b() - 1; b >= 0; b--) {
            ((C0186a) this.f346b.m764e(b)).f340k = true;
        }
    }

    /* renamed from: g */
    void m571g() {
        for (int b = this.f346b.m758b() - 1; b >= 0; b--) {
            ((C0186a) this.f346b.m764e(b)).m560d();
        }
    }

    /* renamed from: h */
    void m572h() {
        int b;
        if (!this.f350f) {
            if (f345a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (b = this.f346b.m758b() - 1; b >= 0; b--) {
                ((C0186a) this.f346b.m764e(b)).m562f();
            }
            this.f346b.m761c();
        }
        if (f345a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (b = this.f347c.m758b() - 1; b >= 0; b--) {
            ((C0186a) this.f347c.m764e(b)).m562f();
        }
        this.f347c.m761c();
        this.f351g = null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        C0242d.m749a(this.f351g, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public void m564a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.f346b.m758b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f346b.m758b(); i2++) {
                C0186a c0186a = (C0186a) this.f346b.m764e(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f346b.m763d(i2));
                printWriter.print(": ");
                printWriter.println(c0186a.toString());
                c0186a.m557a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f347c.m758b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.f347c.m758b()) {
                c0186a = (C0186a) this.f347c.m764e(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f347c.m763d(i));
                printWriter.print(": ");
                printWriter.println(c0186a.toString());
                c0186a.m557a(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    /* renamed from: a */
    public boolean mo104a() {
        int b = this.f346b.m758b();
        boolean z = false;
        for (int i = 0; i < b; i++) {
            int i2;
            C0186a c0186a = (C0186a) this.f346b.m764e(i);
            if (!c0186a.f337h || c0186a.f335f) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            z |= i2;
        }
        return z;
    }
}
