package android.support.v4.p012a;

import android.os.Build.VERSION;
import android.support.v4.p012a.C0131i.C0138c;
import android.support.v4.p012a.C0162o.C0123f;
import android.support.v4.p017e.C0243e;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* renamed from: android.support.v4.a.c */
final class C0124c extends C0122s implements C0123f {
    /* renamed from: a */
    static final boolean f126a = (VERSION.SDK_INT >= 21);
    /* renamed from: b */
    final C0162o f127b;
    /* renamed from: c */
    ArrayList<C0121a> f128c = new ArrayList();
    /* renamed from: d */
    int f129d;
    /* renamed from: e */
    int f130e;
    /* renamed from: f */
    int f131f;
    /* renamed from: g */
    int f132g;
    /* renamed from: h */
    int f133h;
    /* renamed from: i */
    int f134i;
    /* renamed from: j */
    boolean f135j;
    /* renamed from: k */
    boolean f136k = true;
    /* renamed from: l */
    String f137l;
    /* renamed from: m */
    boolean f138m;
    /* renamed from: n */
    int f139n = -1;
    /* renamed from: o */
    int f140o;
    /* renamed from: p */
    CharSequence f141p;
    /* renamed from: q */
    int f142q;
    /* renamed from: r */
    CharSequence f143r;
    /* renamed from: s */
    ArrayList<String> f144s;
    /* renamed from: t */
    ArrayList<String> f145t;
    /* renamed from: u */
    boolean f146u = false;
    /* renamed from: v */
    ArrayList<Runnable> f147v;

    /* renamed from: android.support.v4.a.c$a */
    static final class C0121a {
        /* renamed from: a */
        int f120a;
        /* renamed from: b */
        C0131i f121b;
        /* renamed from: c */
        int f122c;
        /* renamed from: d */
        int f123d;
        /* renamed from: e */
        int f124e;
        /* renamed from: f */
        int f125f;

        C0121a() {
        }

        C0121a(int i, C0131i c0131i) {
            this.f120a = i;
            this.f121b = c0131i;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f139n >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f139n);
        }
        if (this.f137l != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f137l);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public void m219a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        m220a(str, printWriter, true);
    }

    /* renamed from: a */
    public void m220a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f137l);
            printWriter.print(" mIndex=");
            printWriter.print(this.f139n);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f138m);
            if (this.f133h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f133h));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f134i));
            }
            if (!(this.f129d == 0 && this.f130e == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f129d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f130e));
            }
            if (!(this.f131f == 0 && this.f132g == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f131f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f132g));
            }
            if (!(this.f140o == 0 && this.f141p == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f140o));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f141p);
            }
            if (!(this.f142q == 0 && this.f143r == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f142q));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f143r);
            }
        }
        if (!this.f128c.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            str + "    ";
            int size = this.f128c.size();
            for (int i = 0; i < size; i++) {
                String str2;
                C0121a c0121a = (C0121a) this.f128c.get(i);
                switch (c0121a.f120a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    default:
                        str2 = "cmd=" + c0121a.f120a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(c0121a.f121b);
                if (z) {
                    if (!(c0121a.f122c == 0 && c0121a.f123d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(c0121a.f122c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(c0121a.f123d));
                    }
                    if (c0121a.f124e != 0 || c0121a.f125f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(c0121a.f124e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(c0121a.f125f));
                    }
                }
            }
        }
    }

    public C0124c(C0162o c0162o) {
        this.f127b = c0162o;
    }

    /* renamed from: a */
    void m217a(C0121a c0121a) {
        this.f128c.add(c0121a);
        c0121a.f122c = this.f129d;
        c0121a.f123d = this.f130e;
        c0121a.f124e = this.f131f;
        c0121a.f125f = this.f132g;
    }

    /* renamed from: a */
    public C0122s mo56a(C0131i c0131i, String str) {
        m209a(0, c0131i, str, 1);
        return this;
    }

    /* renamed from: a */
    private void m209a(int i, C0131i c0131i, String str, int i2) {
        Class cls = c0131i.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from" + " instance state.");
        }
        c0131i.mFragmentManager = this.f127b;
        if (str != null) {
            if (c0131i.mTag == null || str.equals(c0131i.mTag)) {
                c0131i.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + c0131i + ": was " + c0131i.mTag + " now " + str);
            }
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + c0131i + " with tag " + str + " to container view with no id");
            } else if (c0131i.mFragmentId == 0 || c0131i.mFragmentId == i) {
                c0131i.mFragmentId = i;
                c0131i.mContainerId = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + c0131i + ": was " + c0131i.mFragmentId + " now " + i);
            }
        }
        m217a(new C0121a(i2, c0131i));
    }

    /* renamed from: a */
    public C0122s mo55a(C0131i c0131i) {
        m217a(new C0121a(3, c0131i));
        return this;
    }

    /* renamed from: a */
    void m216a(int i) {
        if (this.f135j) {
            if (C0162o.f229a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.f128c.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0121a c0121a = (C0121a) this.f128c.get(i2);
                if (c0121a.f121b != null) {
                    C0131i c0131i = c0121a.f121b;
                    c0131i.mBackStackNesting += i;
                    if (C0162o.f229a) {
                        Log.v("FragmentManager", "Bump nesting of " + c0121a.f121b + " to " + c0121a.f121b.mBackStackNesting);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void m215a() {
        if (this.f147v != null) {
            int size = this.f147v.size();
            for (int i = 0; i < size; i++) {
                ((Runnable) this.f147v.get(i)).run();
            }
            this.f147v = null;
        }
    }

    /* renamed from: b */
    public int mo58b() {
        return m211a(false);
    }

    /* renamed from: c */
    public int mo59c() {
        return m211a(true);
    }

    /* renamed from: a */
    int m211a(boolean z) {
        if (this.f138m) {
            throw new IllegalStateException("commit already called");
        }
        if (C0162o.f229a) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new C0243e("FragmentManager"));
            m219a("  ", null, printWriter, null);
            printWriter.close();
        }
        this.f138m = true;
        if (this.f135j) {
            this.f139n = this.f127b.m404a(this);
        } else {
            this.f139n = -1;
        }
        this.f127b.m422a((C0123f) this, z);
        return this.f139n;
    }

    /* renamed from: a */
    public boolean mo57a(ArrayList<C0124c> arrayList, ArrayList<Boolean> arrayList2) {
        if (C0162o.f229a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.valueOf(false));
        if (this.f135j) {
            this.f127b.m432b(this);
        }
        return true;
    }

    /* renamed from: b */
    boolean m226b(int i) {
        int size = this.f128c.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0121a c0121a = (C0121a) this.f128c.get(i2);
            int i3 = c0121a.f121b != null ? c0121a.f121b.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    boolean m221a(ArrayList<C0124c> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f128c.size();
        int i3 = -1;
        int i4 = 0;
        while (i4 < size) {
            int i5;
            C0121a c0121a = (C0121a) this.f128c.get(i4);
            int i6 = c0121a.f121b != null ? c0121a.f121b.mContainerId : 0;
            if (i6 == 0 || i6 == i3) {
                i5 = i3;
            } else {
                for (int i7 = i; i7 < i2; i7++) {
                    C0124c c0124c = (C0124c) arrayList.get(i7);
                    int size2 = c0124c.f128c.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        C0121a c0121a2 = (C0121a) c0124c.f128c.get(i8);
                        if (c0121a2.f121b != null) {
                            i3 = c0121a2.f121b.mContainerId;
                        } else {
                            i3 = 0;
                        }
                        if (i3 == i6) {
                            return true;
                        }
                    }
                }
                i5 = i6;
            }
            i4++;
            i3 = i5;
        }
        return false;
    }

    /* renamed from: d */
    void m228d() {
        int size = this.f128c.size();
        for (int i = 0; i < size; i++) {
            C0121a c0121a = (C0121a) this.f128c.get(i);
            C0131i c0131i = c0121a.f121b;
            if (c0131i != null) {
                c0131i.setNextTransition(this.f133h, this.f134i);
            }
            switch (c0121a.f120a) {
                case 1:
                    c0131i.setNextAnim(c0121a.f122c);
                    this.f127b.m420a(c0131i, false);
                    break;
                case 3:
                    c0131i.setNextAnim(c0121a.f123d);
                    this.f127b.m460h(c0131i);
                    break;
                case 4:
                    c0131i.setNextAnim(c0121a.f123d);
                    this.f127b.m463i(c0131i);
                    break;
                case 5:
                    c0131i.setNextAnim(c0121a.f122c);
                    this.f127b.m465j(c0131i);
                    break;
                case 6:
                    c0131i.setNextAnim(c0121a.f123d);
                    this.f127b.m467k(c0131i);
                    break;
                case 7:
                    c0131i.setNextAnim(c0121a.f122c);
                    this.f127b.m469l(c0131i);
                    break;
                case 8:
                    this.f127b.m475o(c0131i);
                    break;
                case 9:
                    this.f127b.m475o(null);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0121a.f120a);
            }
            if (!(this.f146u || c0121a.f120a == 1 || c0131i == null)) {
                this.f127b.m451e(c0131i);
            }
        }
        if (!this.f146u) {
            this.f127b.m411a(this.f127b.f246l, true);
        }
    }

    /* renamed from: b */
    void m225b(boolean z) {
        for (int size = this.f128c.size() - 1; size >= 0; size--) {
            C0121a c0121a = (C0121a) this.f128c.get(size);
            C0131i c0131i = c0121a.f121b;
            if (c0131i != null) {
                c0131i.setNextTransition(C0162o.m399d(this.f133h), this.f134i);
            }
            switch (c0121a.f120a) {
                case 1:
                    c0131i.setNextAnim(c0121a.f125f);
                    this.f127b.m460h(c0131i);
                    break;
                case 3:
                    c0131i.setNextAnim(c0121a.f124e);
                    this.f127b.m420a(c0131i, false);
                    break;
                case 4:
                    c0131i.setNextAnim(c0121a.f124e);
                    this.f127b.m465j(c0131i);
                    break;
                case 5:
                    c0131i.setNextAnim(c0121a.f125f);
                    this.f127b.m463i(c0131i);
                    break;
                case 6:
                    c0131i.setNextAnim(c0121a.f124e);
                    this.f127b.m469l(c0131i);
                    break;
                case 7:
                    c0131i.setNextAnim(c0121a.f125f);
                    this.f127b.m467k(c0131i);
                    break;
                case 8:
                    this.f127b.m475o(null);
                    break;
                case 9:
                    this.f127b.m475o(c0131i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0121a.f120a);
            }
            if (!(this.f146u || c0121a.f120a == 3 || c0131i == null)) {
                this.f127b.m451e(c0131i);
            }
        }
        if (!this.f146u && z) {
            this.f127b.m411a(this.f127b.f246l, true);
        }
    }

    /* renamed from: a */
    C0131i m212a(ArrayList<C0131i> arrayList, C0131i c0131i) {
        int i = 0;
        while (i < this.f128c.size()) {
            C0121a c0121a = (C0121a) this.f128c.get(i);
            switch (c0121a.f120a) {
                case 1:
                case 7:
                    arrayList.add(c0121a.f121b);
                    break;
                case 2:
                    C0131i c0131i2 = c0121a.f121b;
                    int i2 = c0131i2.mContainerId;
                    Object obj = null;
                    int size = arrayList.size() - 1;
                    int i3 = i;
                    C0131i c0131i3 = c0131i;
                    while (size >= 0) {
                        Object obj2;
                        C0131i c0131i4 = (C0131i) arrayList.get(size);
                        if (c0131i4.mContainerId != i2) {
                            obj2 = obj;
                        } else if (c0131i4 == c0131i2) {
                            obj2 = 1;
                        } else {
                            if (c0131i4 == c0131i3) {
                                this.f128c.add(i3, new C0121a(9, c0131i4));
                                i3++;
                                c0131i3 = null;
                            }
                            C0121a c0121a2 = new C0121a(3, c0131i4);
                            c0121a2.f122c = c0121a.f122c;
                            c0121a2.f124e = c0121a.f124e;
                            c0121a2.f123d = c0121a.f123d;
                            c0121a2.f125f = c0121a.f125f;
                            this.f128c.add(i3, c0121a2);
                            arrayList.remove(c0131i4);
                            i3++;
                            obj2 = obj;
                        }
                        size--;
                        obj = obj2;
                    }
                    if (obj != null) {
                        this.f128c.remove(i3);
                        i3--;
                    } else {
                        c0121a.f120a = 1;
                        arrayList.add(c0131i2);
                    }
                    i = i3;
                    c0131i = c0131i3;
                    break;
                case 3:
                case 6:
                    arrayList.remove(c0121a.f121b);
                    if (c0121a.f121b != c0131i) {
                        break;
                    }
                    this.f128c.add(i, new C0121a(9, c0121a.f121b));
                    i++;
                    c0131i = null;
                    break;
                case 8:
                    this.f128c.add(i, new C0121a(9, c0131i));
                    i++;
                    c0131i = c0121a.f121b;
                    break;
                default:
                    break;
            }
            i++;
        }
        return c0131i;
    }

    /* renamed from: b */
    C0131i m224b(ArrayList<C0131i> arrayList, C0131i c0131i) {
        for (int i = 0; i < this.f128c.size(); i++) {
            C0121a c0121a = (C0121a) this.f128c.get(i);
            switch (c0121a.f120a) {
                case 1:
                case 7:
                    arrayList.remove(c0121a.f121b);
                    break;
                case 3:
                case 6:
                    arrayList.add(c0121a.f121b);
                    break;
                case 8:
                    c0131i = null;
                    break;
                case 9:
                    c0131i = c0121a.f121b;
                    break;
                default:
                    break;
            }
        }
        return c0131i;
    }

    /* renamed from: e */
    boolean m229e() {
        for (int i = 0; i < this.f128c.size(); i++) {
            if (C0124c.m210b((C0121a) this.f128c.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    void m218a(C0138c c0138c) {
        for (int i = 0; i < this.f128c.size(); i++) {
            C0121a c0121a = (C0121a) this.f128c.get(i);
            if (C0124c.m210b(c0121a)) {
                c0121a.f121b.setOnStartEnterTransitionListener(c0138c);
            }
        }
    }

    /* renamed from: b */
    private static boolean m210b(C0121a c0121a) {
        C0131i c0131i = c0121a.f121b;
        return (c0131i == null || !c0131i.mAdded || c0131i.mView == null || c0131i.mDetached || c0131i.mHidden || !c0131i.isPostponed()) ? false : true;
    }

    /* renamed from: f */
    public String m230f() {
        return this.f137l;
    }
}
