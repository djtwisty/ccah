package android.support.v4.p012a;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.v4.p017e.C0237i;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.a.l */
public class C0146l {
    /* renamed from: a */
    private final C0142m<?> f199a;

    /* renamed from: a */
    public static final C0146l m306a(C0142m<?> c0142m) {
        return new C0146l(c0142m);
    }

    private C0146l(C0142m<?> c0142m) {
        this.f199a = c0142m;
    }

    /* renamed from: a */
    public C0149n m308a() {
        return this.f199a.m284k();
    }

    /* renamed from: b */
    public C0183v m319b() {
        return this.f199a.m285l();
    }

    /* renamed from: a */
    public C0131i m307a(String str) {
        return this.f199a.f188d.m431b(str);
    }

    /* renamed from: a */
    public void m312a(C0131i c0131i) {
        this.f199a.f188d.m421a(this.f199a, this.f199a, c0131i);
    }

    /* renamed from: a */
    public View m309a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f199a.f188d.onCreateView(view, str, context, attributeSet);
    }

    /* renamed from: c */
    public void m323c() {
        this.f199a.f188d.m468l();
    }

    /* renamed from: d */
    public Parcelable m325d() {
        return this.f199a.f188d.m466k();
    }

    /* renamed from: a */
    public void m311a(Parcelable parcelable, C0163p c0163p) {
        this.f199a.f188d.m414a(parcelable, c0163p);
    }

    /* renamed from: e */
    public C0163p m326e() {
        return this.f199a.f188d.m462i();
    }

    /* renamed from: f */
    public void m327f() {
        this.f199a.f188d.m470m();
    }

    /* renamed from: g */
    public void m328g() {
        this.f199a.f188d.m473n();
    }

    /* renamed from: h */
    public void m329h() {
        this.f199a.f188d.m474o();
    }

    /* renamed from: i */
    public void m330i() {
        this.f199a.f188d.m476p();
    }

    /* renamed from: j */
    public void m331j() {
        this.f199a.f188d.m477q();
    }

    /* renamed from: k */
    public void m332k() {
        this.f199a.f188d.m478r();
    }

    /* renamed from: l */
    public void m333l() {
        this.f199a.f188d.m479s();
    }

    /* renamed from: m */
    public void m334m() {
        this.f199a.f188d.m481u();
    }

    /* renamed from: a */
    public void m315a(boolean z) {
        this.f199a.f188d.m424a(z);
    }

    /* renamed from: b */
    public void m321b(boolean z) {
        this.f199a.f188d.m438b(z);
    }

    /* renamed from: a */
    public void m310a(Configuration configuration) {
        this.f199a.f188d.m412a(configuration);
    }

    /* renamed from: n */
    public void m335n() {
        this.f199a.f188d.m482v();
    }

    /* renamed from: a */
    public boolean m317a(Menu menu, MenuInflater menuInflater) {
        return this.f199a.f188d.m427a(menu, menuInflater);
    }

    /* renamed from: a */
    public boolean m316a(Menu menu) {
        return this.f199a.f188d.m426a(menu);
    }

    /* renamed from: a */
    public boolean m318a(MenuItem menuItem) {
        return this.f199a.f188d.m428a(menuItem);
    }

    /* renamed from: b */
    public boolean m322b(MenuItem menuItem) {
        return this.f199a.f188d.m440b(menuItem);
    }

    /* renamed from: b */
    public void m320b(Menu menu) {
        this.f199a.f188d.m437b(menu);
    }

    /* renamed from: o */
    public boolean m336o() {
        return this.f199a.f188d.m455f();
    }

    /* renamed from: p */
    public void m337p() {
        this.f199a.m287n();
    }

    /* renamed from: c */
    public void m324c(boolean z) {
        this.f199a.m269a(z);
    }

    /* renamed from: q */
    public void m338q() {
        this.f199a.m288o();
    }

    /* renamed from: r */
    public void m339r() {
        this.f199a.m289p();
    }

    /* renamed from: s */
    public C0237i<String, C0183v> m340s() {
        return this.f199a.m290q();
    }

    /* renamed from: a */
    public void m313a(C0237i<String, C0183v> c0237i) {
        this.f199a.m267a((C0237i) c0237i);
    }

    /* renamed from: a */
    public void m314a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f199a.m276b(str, fileDescriptor, printWriter, strArr);
    }
}
