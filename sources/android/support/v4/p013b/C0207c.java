package android.support.v4.p013b;

import android.support.v4.p017e.C0242d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.b.c */
public class C0207c<D> {
    /* renamed from: a */
    int f413a;
    /* renamed from: b */
    C0185b<D> f414b;
    /* renamed from: c */
    C0184a<D> f415c;
    /* renamed from: d */
    boolean f416d;
    /* renamed from: e */
    boolean f417e;
    /* renamed from: f */
    boolean f418f;
    /* renamed from: g */
    boolean f419g;
    /* renamed from: h */
    boolean f420h;

    /* renamed from: android.support.v4.b.c$a */
    public interface C0184a<D> {
    }

    /* renamed from: android.support.v4.b.c$b */
    public interface C0185b<D> {
    }

    /* renamed from: a */
    public void m638a(int i, C0185b<D> c0185b) {
        if (this.f414b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f414b = c0185b;
        this.f413a = i;
    }

    /* renamed from: a */
    public void m640a(C0185b<D> c0185b) {
        if (this.f414b == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f414b != c0185b) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f414b = null;
        }
    }

    /* renamed from: a */
    public void m639a(C0184a<D> c0184a) {
        if (this.f415c != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f415c = c0184a;
    }

    /* renamed from: b */
    public void m643b(C0184a<D> c0184a) {
        if (this.f415c == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f415c != c0184a) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f415c = null;
        }
    }

    /* renamed from: a */
    public final void m637a() {
        this.f416d = true;
        this.f418f = false;
        this.f417e = false;
        m642b();
    }

    /* renamed from: b */
    protected void m642b() {
    }

    /* renamed from: c */
    public void m644c() {
        this.f416d = false;
        m645d();
    }

    /* renamed from: d */
    protected void m645d() {
    }

    /* renamed from: e */
    public void m646e() {
        m647f();
        this.f418f = true;
        this.f416d = false;
        this.f417e = false;
        this.f419g = false;
        this.f420h = false;
    }

    /* renamed from: f */
    protected void m647f() {
    }

    /* renamed from: a */
    public String m636a(D d) {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0242d.m749a(d, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0242d.m749a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.f413a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public void m641a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f413a);
        printWriter.print(" mListener=");
        printWriter.println(this.f414b);
        if (this.f416d || this.f419g || this.f420h) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f416d);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f419g);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f420h);
        }
        if (this.f417e || this.f418f) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f417e);
            printWriter.print(" mReset=");
            printWriter.println(this.f418f);
        }
    }
}
