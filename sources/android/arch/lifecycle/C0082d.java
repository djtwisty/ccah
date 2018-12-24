package android.arch.lifecycle;

import android.arch.lifecycle.C0078b.C0076a;
import android.arch.lifecycle.C0078b.C0077b;
import android.arch.p010a.p011a.C0065a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: android.arch.lifecycle.d */
public class C0082d extends C0078b {
    /* renamed from: a */
    private C0065a<Object, C0081a> f59a = new C0065a();
    /* renamed from: b */
    private C0077b f60b;
    /* renamed from: c */
    private final C0079c f61c;
    /* renamed from: d */
    private int f62d = 0;
    /* renamed from: e */
    private boolean f63e = false;
    /* renamed from: f */
    private boolean f64f = false;
    /* renamed from: g */
    private ArrayList<C0077b> f65g = new ArrayList();

    /* renamed from: android.arch.lifecycle.d$a */
    static class C0081a {
        /* renamed from: a */
        C0077b f57a;
        /* renamed from: b */
        C0075a f58b;

        /* renamed from: a */
        void m98a(C0079c c0079c, C0076a c0076a) {
            C0077b b = C0082d.m101b(c0076a);
            this.f57a = C0082d.m99a(this.f57a, b);
            this.f58b.mo9a(c0079c, c0076a);
            this.f57a = b;
        }
    }

    public C0082d(C0079c c0079c) {
        this.f61c = c0079c;
        this.f60b = C0077b.INITIALIZED;
    }

    /* renamed from: a */
    public void m110a(C0077b c0077b) {
        this.f60b = c0077b;
    }

    /* renamed from: a */
    public void m109a(C0076a c0076a) {
        this.f60b = C0082d.m101b(c0076a);
        if (this.f63e || this.f62d != 0) {
            this.f64f = true;
            return;
        }
        this.f63e = true;
        m108e();
        this.f63e = false;
    }

    /* renamed from: a */
    private boolean m100a() {
        if (this.f59a.m78a() == 0) {
            return true;
        }
        C0077b c0077b = ((C0081a) this.f59a.m81d().getValue()).f57a;
        C0077b c0077b2 = ((C0081a) this.f59a.m82e().getValue()).f57a;
        boolean z = c0077b == c0077b2 && this.f60b == c0077b2;
        return z;
    }

    /* renamed from: b */
    private void m102b() {
        this.f65g.remove(this.f65g.size() - 1);
    }

    /* renamed from: b */
    private void m103b(C0077b c0077b) {
        this.f65g.add(c0077b);
    }

    /* renamed from: b */
    static C0077b m101b(C0076a c0076a) {
        switch (c0076a) {
            case ON_CREATE:
            case ON_STOP:
                return C0077b.CREATED;
            case ON_START:
            case ON_PAUSE:
                return C0077b.STARTED;
            case ON_RESUME:
                return C0077b.RESUMED;
            case ON_DESTROY:
                return C0077b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + c0076a);
        }
    }

    /* renamed from: c */
    private static C0076a m104c(C0077b c0077b) {
        switch (c0077b) {
            case INITIALIZED:
                throw new IllegalArgumentException();
            case CREATED:
                return C0076a.ON_DESTROY;
            case STARTED:
                return C0076a.ON_STOP;
            case RESUMED:
                return C0076a.ON_PAUSE;
            case DESTROYED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + c0077b);
        }
    }

    /* renamed from: d */
    private static C0076a m106d(C0077b c0077b) {
        switch (c0077b) {
            case INITIALIZED:
            case DESTROYED:
                return C0076a.ON_CREATE;
            case CREATED:
                return C0076a.ON_START;
            case STARTED:
                return C0076a.ON_RESUME;
            case RESUMED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + c0077b);
        }
    }

    /* renamed from: c */
    private void m105c() {
        Iterator c = this.f59a.m80c();
        while (c.hasNext() && !this.f64f) {
            Entry entry = (Entry) c.next();
            C0081a c0081a = (C0081a) entry.getValue();
            while (c0081a.f57a.compareTo(this.f60b) < 0 && !this.f64f && this.f59a.m83a(entry.getKey())) {
                m103b(c0081a.f57a);
                c0081a.m98a(this.f61c, C0082d.m106d(c0081a.f57a));
                m102b();
            }
        }
    }

    /* renamed from: d */
    private void m107d() {
        Iterator b = this.f59a.m79b();
        while (b.hasNext() && !this.f64f) {
            Entry entry = (Entry) b.next();
            C0081a c0081a = (C0081a) entry.getValue();
            while (c0081a.f57a.compareTo(this.f60b) > 0 && !this.f64f && this.f59a.m83a(entry.getKey())) {
                C0076a c = C0082d.m104c(c0081a.f57a);
                m103b(C0082d.m101b(c));
                c0081a.m98a(this.f61c, c);
                m102b();
            }
        }
    }

    /* renamed from: e */
    private void m108e() {
        while (!m100a()) {
            this.f64f = false;
            if (this.f60b.compareTo(((C0081a) this.f59a.m81d().getValue()).f57a) < 0) {
                m107d();
            }
            Entry e = this.f59a.m82e();
            if (!(this.f64f || e == null || this.f60b.compareTo(((C0081a) e.getValue()).f57a) <= 0)) {
                m105c();
            }
        }
        this.f64f = false;
    }

    /* renamed from: a */
    static C0077b m99a(C0077b c0077b, C0077b c0077b2) {
        return (c0077b2 == null || c0077b2.compareTo(c0077b) >= 0) ? c0077b : c0077b2;
    }
}
