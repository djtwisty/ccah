package android.support.v4.p012a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.p017e.C0237i;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.a.m */
public abstract class C0142m<E> extends C0134k {
    /* renamed from: a */
    private final Activity f185a;
    /* renamed from: b */
    final Context f186b;
    /* renamed from: c */
    final int f187c;
    /* renamed from: d */
    final C0162o f188d;
    /* renamed from: e */
    private final Handler f189e;
    /* renamed from: f */
    private C0237i<String, C0183v> f190f;
    /* renamed from: g */
    private boolean f191g;
    /* renamed from: h */
    private C0187w f192h;
    /* renamed from: i */
    private boolean f193i;
    /* renamed from: j */
    private boolean f194j;

    /* renamed from: g */
    public abstract E mo83g();

    C0142m(C0145j c0145j) {
        this(c0145j, c0145j, c0145j.mHandler, 0);
    }

    C0142m(Activity activity, Context context, Handler handler, int i) {
        this.f188d = new C0162o();
        this.f185a = activity;
        this.f186b = context;
        this.f189e = handler;
        this.f187c = i;
    }

    /* renamed from: a */
    public void mo75a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    /* renamed from: a */
    public boolean mo76a(C0131i c0131i) {
        return true;
    }

    /* renamed from: b */
    public LayoutInflater mo78b() {
        return (LayoutInflater) this.f186b.getSystemService("layout_inflater");
    }

    /* renamed from: d */
    public void mo80d() {
    }

    /* renamed from: a */
    public void mo72a(C0131i c0131i, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.f186b.startActivity(intent);
    }

    /* renamed from: a */
    public void mo73a(C0131i c0131i, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        C0101a.m131a(this.f185a, intentSender, i, intent, i2, i3, i4, bundle);
    }

    /* renamed from: a */
    public void mo74a(C0131i c0131i, String[] strArr, int i) {
    }

    /* renamed from: a */
    public boolean mo77a(String str) {
        return false;
    }

    /* renamed from: e */
    public boolean mo81e() {
        return true;
    }

    /* renamed from: f */
    public int mo82f() {
        return this.f187c;
    }

    /* renamed from: a */
    public View mo70a(int i) {
        return null;
    }

    /* renamed from: a */
    public boolean mo71a() {
        return true;
    }

    /* renamed from: h */
    Activity m281h() {
        return this.f185a;
    }

    /* renamed from: i */
    Context m282i() {
        return this.f186b;
    }

    /* renamed from: j */
    Handler m283j() {
        return this.f189e;
    }

    /* renamed from: k */
    C0162o m284k() {
        return this.f188d;
    }

    /* renamed from: l */
    C0187w m285l() {
        if (this.f192h != null) {
            return this.f192h;
        }
        this.f193i = true;
        this.f192h = m262a("(root)", this.f194j, true);
        return this.f192h;
    }

    /* renamed from: b */
    void m275b(String str) {
        if (this.f190f != null) {
            C0187w c0187w = (C0187w) this.f190f.get(str);
            if (c0187w != null && !c0187w.f350f) {
                c0187w.m572h();
                this.f190f.remove(str);
            }
        }
    }

    /* renamed from: b */
    void mo79b(C0131i c0131i) {
    }

    /* renamed from: m */
    boolean m286m() {
        return this.f191g;
    }

    /* renamed from: n */
    void m287n() {
        if (!this.f194j) {
            this.f194j = true;
            if (this.f192h != null) {
                this.f192h.m566b();
            } else if (!this.f193i) {
                this.f192h = m262a("(root)", this.f194j, false);
                if (!(this.f192h == null || this.f192h.f349e)) {
                    this.f192h.m566b();
                }
            }
            this.f193i = true;
        }
    }

    /* renamed from: a */
    void m269a(boolean z) {
        this.f191g = z;
        if (this.f192h != null && this.f194j) {
            this.f194j = false;
            if (z) {
                this.f192h.m568d();
            } else {
                this.f192h.m567c();
            }
        }
    }

    /* renamed from: o */
    void m288o() {
        if (this.f192h != null) {
            this.f192h.m572h();
        }
    }

    /* renamed from: p */
    void m289p() {
        if (this.f190f != null) {
            int size = this.f190f.size();
            C0187w[] c0187wArr = new C0187w[size];
            for (int i = size - 1; i >= 0; i--) {
                c0187wArr[i] = (C0187w) this.f190f.m723c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                C0187w c0187w = c0187wArr[i2];
                c0187w.m569e();
                c0187w.m571g();
            }
        }
    }

    /* renamed from: a */
    C0187w m262a(String str, boolean z, boolean z2) {
        if (this.f190f == null) {
            this.f190f = new C0237i();
        }
        C0187w c0187w = (C0187w) this.f190f.get(str);
        if (c0187w == null && z2) {
            c0187w = new C0187w(str, this, z);
            this.f190f.put(str, c0187w);
            return c0187w;
        } else if (!z || c0187w == null || c0187w.f349e) {
            return c0187w;
        } else {
            c0187w.m566b();
            return c0187w;
        }
    }

    /* renamed from: q */
    C0237i<String, C0183v> m290q() {
        Object obj;
        if (this.f190f != null) {
            int i;
            int size = this.f190f.size();
            C0187w[] c0187wArr = new C0187w[size];
            for (i = size - 1; i >= 0; i--) {
                c0187wArr[i] = (C0187w) this.f190f.m723c(i);
            }
            boolean m = m286m();
            obj = null;
            for (i = 0; i < size; i++) {
                C0187w c0187w = c0187wArr[i];
                if (!c0187w.f350f && m) {
                    if (!c0187w.f349e) {
                        c0187w.m566b();
                    }
                    c0187w.m568d();
                }
                if (c0187w.f350f) {
                    obj = 1;
                } else {
                    c0187w.m572h();
                    this.f190f.remove(c0187w.f348d);
                }
            }
        } else {
            obj = null;
        }
        if (obj != null) {
            return this.f190f;
        }
        return null;
    }

    /* renamed from: a */
    void m267a(C0237i<String, C0183v> c0237i) {
        if (c0237i != null) {
            int size = c0237i.size();
            for (int i = 0; i < size; i++) {
                ((C0187w) c0237i.m723c(i)).m563a(this);
            }
        }
        this.f190f = c0237i;
    }

    /* renamed from: b */
    void m276b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.f194j);
        if (this.f192h != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f192h)));
            printWriter.println(":");
            this.f192h.m564a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }
}
