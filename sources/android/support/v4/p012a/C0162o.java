package android.support.v4.p012a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.p012a.C0131i.C0138c;
import android.support.v4.p012a.C0149n.C0147a;
import android.support.v4.p012a.C0149n.C0148b;
import android.support.v4.p017e.C0240b;
import android.support.v4.p017e.C0242d;
import android.support.v4.p017e.C0243e;
import android.support.v4.p017e.C0250h;
import android.support.v4.p018f.C0265b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: android.support.v4.a.o */
final class C0162o extends C0149n implements Factory2 {
    /* renamed from: E */
    static final Interpolator f225E = new DecelerateInterpolator(2.5f);
    /* renamed from: F */
    static final Interpolator f226F = new DecelerateInterpolator(1.5f);
    /* renamed from: G */
    static final Interpolator f227G = new AccelerateInterpolator(2.5f);
    /* renamed from: H */
    static final Interpolator f228H = new AccelerateInterpolator(1.5f);
    /* renamed from: a */
    static boolean f229a = false;
    /* renamed from: q */
    static Field f230q = null;
    /* renamed from: A */
    SparseArray<Parcelable> f231A = null;
    /* renamed from: B */
    ArrayList<C0161h> f232B;
    /* renamed from: C */
    C0163p f233C;
    /* renamed from: D */
    Runnable f234D = new C01501(this);
    /* renamed from: I */
    private final CopyOnWriteArrayList<C0250h<C0147a, Boolean>> f235I = new CopyOnWriteArrayList();
    /* renamed from: b */
    ArrayList<C0123f> f236b;
    /* renamed from: c */
    boolean f237c;
    /* renamed from: d */
    int f238d = 0;
    /* renamed from: e */
    final ArrayList<C0131i> f239e = new ArrayList();
    /* renamed from: f */
    SparseArray<C0131i> f240f;
    /* renamed from: g */
    ArrayList<C0124c> f241g;
    /* renamed from: h */
    ArrayList<C0131i> f242h;
    /* renamed from: i */
    ArrayList<C0124c> f243i;
    /* renamed from: j */
    ArrayList<Integer> f244j;
    /* renamed from: k */
    ArrayList<C0148b> f245k;
    /* renamed from: l */
    int f246l = 0;
    /* renamed from: m */
    C0142m f247m;
    /* renamed from: n */
    C0134k f248n;
    /* renamed from: o */
    C0131i f249o;
    /* renamed from: p */
    C0131i f250p;
    /* renamed from: r */
    boolean f251r;
    /* renamed from: s */
    boolean f252s;
    /* renamed from: t */
    boolean f253t;
    /* renamed from: u */
    String f254u;
    /* renamed from: v */
    boolean f255v;
    /* renamed from: w */
    ArrayList<C0124c> f256w;
    /* renamed from: x */
    ArrayList<Boolean> f257x;
    /* renamed from: y */
    ArrayList<C0131i> f258y;
    /* renamed from: z */
    Bundle f259z = null;

    /* renamed from: android.support.v4.a.o$f */
    interface C0123f {
        /* renamed from: a */
        boolean mo57a(ArrayList<C0124c> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* renamed from: android.support.v4.a.o$1 */
    class C01501 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C0162o f200a;

        C01501(C0162o c0162o) {
            this.f200a = c0162o;
        }

        public void run() {
            this.f200a.m455f();
        }
    }

    /* renamed from: android.support.v4.a.o$b */
    private static class C0151b implements AnimationListener {
        /* renamed from: a */
        private final AnimationListener f201a;

        private C0151b(AnimationListener animationListener) {
            this.f201a = animationListener;
        }

        public void onAnimationStart(Animation animation) {
            if (this.f201a != null) {
                this.f201a.onAnimationStart(animation);
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f201a != null) {
                this.f201a.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.f201a != null) {
                this.f201a.onAnimationRepeat(animation);
            }
        }
    }

    /* renamed from: android.support.v4.a.o$a */
    private static class C0156a extends C0151b {
        /* renamed from: a */
        View f213a;

        /* renamed from: android.support.v4.a.o$a$1 */
        class C01551 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C0156a f212a;

            C01551(C0156a c0156a) {
                this.f212a = c0156a;
            }

            public void run() {
                this.f212a.f213a.setLayerType(0, null);
            }
        }

        C0156a(View view, AnimationListener animationListener) {
            super(animationListener);
            this.f213a = view;
        }

        public void onAnimationEnd(Animation animation) {
            if (C0265b.m778c(this.f213a) || VERSION.SDK_INT >= 24) {
                this.f213a.post(new C01551(this));
            } else {
                this.f213a.setLayerType(0, null);
            }
            super.onAnimationEnd(animation);
        }
    }

    /* renamed from: android.support.v4.a.o$c */
    private static class C0157c {
        /* renamed from: a */
        public final Animation f214a;
        /* renamed from: b */
        public final Animator f215b;

        private C0157c(Animation animation) {
            this.f214a = animation;
            this.f215b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        private C0157c(Animator animator) {
            this.f214a = null;
            this.f215b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* renamed from: android.support.v4.a.o$d */
    private static class C0158d extends AnimatorListenerAdapter {
        /* renamed from: a */
        View f216a;

        C0158d(View view) {
            this.f216a = view;
        }

        public void onAnimationStart(Animator animator) {
            this.f216a.setLayerType(2, null);
        }

        public void onAnimationEnd(Animator animator) {
            this.f216a.setLayerType(0, null);
            animator.removeListener(this);
        }
    }

    /* renamed from: android.support.v4.a.o$e */
    static class C0159e {
        /* renamed from: a */
        public static final int[] f217a = new int[]{16842755, 16842960, 16842961};
    }

    /* renamed from: android.support.v4.a.o$g */
    private class C0160g implements C0123f {
        /* renamed from: a */
        final String f218a;
        /* renamed from: b */
        final int f219b;
        /* renamed from: c */
        final int f220c;
        /* renamed from: d */
        final /* synthetic */ C0162o f221d;

        C0160g(C0162o c0162o, String str, int i, int i2) {
            this.f221d = c0162o;
            this.f218a = str;
            this.f219b = i;
            this.f220c = i2;
        }

        /* renamed from: a */
        public boolean mo57a(ArrayList<C0124c> arrayList, ArrayList<Boolean> arrayList2) {
            if (this.f221d.f250p != null && this.f219b < 0 && this.f218a == null) {
                C0149n peekChildFragmentManager = this.f221d.f250p.peekChildFragmentManager();
                if (peekChildFragmentManager != null && peekChildFragmentManager.mo101b()) {
                    return false;
                }
            }
            return this.f221d.m429a((ArrayList) arrayList, (ArrayList) arrayList2, this.f218a, this.f219b, this.f220c);
        }
    }

    /* renamed from: android.support.v4.a.o$h */
    static class C0161h implements C0138c {
        /* renamed from: a */
        private final boolean f222a;
        /* renamed from: b */
        private final C0124c f223b;
        /* renamed from: c */
        private int f224c;

        C0161h(C0124c c0124c, boolean z) {
            this.f222a = z;
            this.f223b = c0124c;
        }

        /* renamed from: a */
        public void mo95a() {
            this.f224c--;
            if (this.f224c == 0) {
                this.f223b.f127b.m403z();
            }
        }

        /* renamed from: b */
        public void mo96b() {
            this.f224c++;
        }

        /* renamed from: c */
        public boolean m368c() {
            return this.f224c == 0;
        }

        /* renamed from: d */
        public void m369d() {
            boolean z;
            boolean z2 = false;
            if (this.f224c > 0) {
                z = true;
            } else {
                z = false;
            }
            C0162o c0162o = this.f223b.f127b;
            int size = c0162o.f239e.size();
            for (int i = 0; i < size; i++) {
                C0131i c0131i = (C0131i) c0162o.f239e.get(i);
                c0131i.setOnStartEnterTransitionListener(null);
                if (z && c0131i.isPostponed()) {
                    c0131i.startPostponedEnterTransition();
                }
            }
            C0162o c0162o2 = this.f223b.f127b;
            C0124c c0124c = this.f223b;
            boolean z3 = this.f222a;
            if (!z) {
                z2 = true;
            }
            c0162o2.m379a(c0124c, z3, z2, true);
        }

        /* renamed from: e */
        public void m370e() {
            this.f223b.f127b.m379a(this.f223b, this.f222a, false, false);
        }
    }

    C0162o() {
    }

    /* renamed from: a */
    static boolean m389a(C0157c c0157c) {
        if (c0157c.f214a instanceof AlphaAnimation) {
            return true;
        }
        if (!(c0157c.f214a instanceof AnimationSet)) {
            return C0162o.m388a(c0157c.f215b);
        }
        List animations = ((AnimationSet) c0157c.f214a).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    static boolean m388a(Animator animator) {
        if (animator == null) {
            return false;
        }
        if (animator instanceof ValueAnimator) {
            PropertyValuesHolder[] values = ((ValueAnimator) animator).getValues();
            for (PropertyValuesHolder propertyName : values) {
                if ("alpha".equals(propertyName.getPropertyName())) {
                    return true;
                }
            }
            return false;
        } else if (!(animator instanceof AnimatorSet)) {
            return false;
        } else {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            for (int i = 0; i < childAnimations.size(); i++) {
                if (C0162o.m388a((Animator) childAnimations.get(i))) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: a */
    static boolean m390a(View view, C0157c c0157c) {
        if (view == null || c0157c == null || VERSION.SDK_INT < 19 || view.getLayerType() != 0 || !C0265b.m777b(view) || !C0162o.m389a(c0157c)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private void m385a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0243e("FragmentManager"));
        if (this.f247m != null) {
            try {
                this.f247m.mo75a("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                mo100a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    /* renamed from: a */
    public C0122s mo98a() {
        return new C0124c(this);
    }

    /* renamed from: b */
    public boolean mo101b() {
        m402y();
        return m391a(null, -1, 0);
    }

    /* renamed from: a */
    public void mo99a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        m422a(new C0160g(this, null, i, i2), false);
    }

    /* renamed from: a */
    private boolean m391a(String str, int i, int i2) {
        m455f();
        m397c(true);
        if (this.f250p != null && i < 0 && str == null) {
            C0149n peekChildFragmentManager = this.f250p.peekChildFragmentManager();
            if (peekChildFragmentManager != null && peekChildFragmentManager.mo101b()) {
                return true;
            }
        }
        boolean a = m429a(this.f256w, this.f257x, str, i, i2);
        if (a) {
            this.f237c = true;
            try {
                m395b(this.f256w, this.f257x);
            } finally {
                m371A();
            }
        }
        m456g();
        m374D();
        return a;
    }

    /* renamed from: a */
    public void m413a(Bundle bundle, String str, C0131i c0131i) {
        if (c0131i.mIndex < 0) {
            m385a(new IllegalStateException("Fragment " + c0131i + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, c0131i.mIndex);
    }

    /* renamed from: a */
    public C0131i m405a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        C0131i c0131i = (C0131i) this.f240f.get(i);
        if (c0131i != null) {
            return c0131i;
        }
        m385a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return c0131i;
    }

    /* renamed from: c */
    public List<C0131i> mo102c() {
        if (this.f239e.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<C0131i> list;
        synchronized (this.f239e) {
            list = (List) this.f239e.clone();
        }
        return list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.f249o != null) {
            C0242d.m749a(this.f249o, stringBuilder);
        } else {
            C0242d.m749a(this.f247m, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public void mo100a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f240f != null) {
            size = this.f240f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    C0131i c0131i;
                    c0131i = (C0131i) this.f240f.valueAt(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0131i);
                    if (c0131i != null) {
                        c0131i.dump(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        size = this.f239e.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (i = 0; i < size; i++) {
                c0131i = (C0131i) this.f239e.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(c0131i.toString());
            }
        }
        if (this.f242h != null) {
            size = this.f242h.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    c0131i = (C0131i) this.f242h.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0131i.toString());
                }
            }
        }
        if (this.f241g != null) {
            size = this.f241g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    C0124c c0124c = (C0124c) this.f241g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0124c.toString());
                    c0124c.m219a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.f243i != null) {
                int size2 = this.f243i.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        c0124c = (C0124c) this.f243i.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(c0124c);
                    }
                }
            }
            if (this.f244j != null && this.f244j.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f244j.toArray()));
            }
        }
        if (this.f236b != null) {
            i = this.f236b.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    C0123f c0123f = (C0123f) this.f236b.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(c0123f);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f247m);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f248n);
        if (this.f249o != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f249o);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f246l);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f252s);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f253t);
        if (this.f251r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f251r);
        }
        if (this.f254u != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f254u);
        }
    }

    /* renamed from: a */
    static C0157c m377a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f225E);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(f226F);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return new C0157c(animationSet);
    }

    /* renamed from: a */
    static C0157c m376a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f226F);
        alphaAnimation.setDuration(220);
        return new C0157c(alphaAnimation);
    }

    /* renamed from: a */
    C0157c m407a(C0131i c0131i, int i, boolean z, int i2) {
        int nextAnim = c0131i.getNextAnim();
        Animation onCreateAnimation = c0131i.onCreateAnimation(i, z, nextAnim);
        if (onCreateAnimation != null) {
            return new C0157c(onCreateAnimation);
        }
        Animator onCreateAnimator = c0131i.onCreateAnimator(i, z, nextAnim);
        if (onCreateAnimator != null) {
            return new C0157c(onCreateAnimator);
        }
        if (nextAnim != 0) {
            Object obj;
            boolean equals = "anim".equals(this.f247m.m282i().getResources().getResourceTypeName(nextAnim));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.f247m.m282i(), nextAnim);
                    if (loadAnimation != null) {
                        return new C0157c(loadAnimation);
                    }
                    obj = 1;
                } catch (NotFoundException e) {
                    throw e;
                } catch (RuntimeException e2) {
                    obj = null;
                }
            } else {
                obj = null;
            }
            if (obj == null) {
                try {
                    onCreateAnimator = AnimatorInflater.loadAnimator(this.f247m.m282i(), nextAnim);
                    if (onCreateAnimator != null) {
                        return new C0157c(onCreateAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (equals) {
                        throw e3;
                    }
                    onCreateAnimation = AnimationUtils.loadAnimation(this.f247m.m282i(), nextAnim);
                    if (onCreateAnimation != null) {
                        return new C0157c(onCreateAnimation);
                    }
                }
            }
        }
        if (i == 0) {
            return null;
        }
        int b = C0162o.m392b(i, z);
        if (b < 0) {
            return null;
        }
        switch (b) {
            case 1:
                return C0162o.m377a(this.f247m.m282i(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return C0162o.m377a(this.f247m.m282i(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return C0162o.m377a(this.f247m.m282i(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return C0162o.m377a(this.f247m.m282i(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return C0162o.m376a(this.f247m.m282i(), 0.0f, 1.0f);
            case 6:
                return C0162o.m376a(this.f247m.m282i(), 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f247m.mo81e()) {
                    i2 = this.f247m.mo82f();
                }
                if (i2 == 0) {
                    return null;
                }
                return null;
        }
    }

    /* renamed from: a */
    public void m415a(C0131i c0131i) {
        if (!c0131i.mDeferStart) {
            return;
        }
        if (this.f237c) {
            this.f255v = true;
            return;
        }
        c0131i.mDeferStart = false;
        m416a(c0131i, this.f246l, 0, 0, false);
    }

    /* renamed from: b */
    private static void m394b(View view, C0157c c0157c) {
        if (view != null && c0157c != null && C0162o.m390a(view, c0157c)) {
            if (c0157c.f215b != null) {
                c0157c.f215b.addListener(new C0158d(view));
                return;
            }
            AnimationListener a = C0162o.m378a(c0157c.f214a);
            view.setLayerType(2, null);
            c0157c.f214a.setAnimationListener(new C0156a(view, a));
        }
    }

    /* renamed from: a */
    private static AnimationListener m378a(Animation animation) {
        try {
            if (f230q == null) {
                f230q = Animation.class.getDeclaredField("mListener");
                f230q.setAccessible(true);
            }
            return (AnimationListener) f230q.get(animation);
        } catch (Throwable e) {
            Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e);
            return null;
        } catch (Throwable e2) {
            Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
            return null;
        }
    }

    /* renamed from: a */
    boolean m425a(int i) {
        return this.f246l >= i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    void m416a(android.support.v4.p012a.C0131i r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r9 = 4;
        r6 = 3;
        r5 = 1;
        r7 = 0;
        r3 = 0;
        r0 = r11.mAdded;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r11.mDetached;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r12 <= r5) goto L_0x0010;
    L_0x000f:
        r12 = r5;
    L_0x0010:
        r0 = r11.mRemoving;
        if (r0 == 0) goto L_0x0023;
    L_0x0014:
        r0 = r11.mState;
        if (r12 <= r0) goto L_0x0023;
    L_0x0018:
        r0 = r11.mState;
        if (r0 != 0) goto L_0x003b;
    L_0x001c:
        r0 = r11.isInBackStack();
        if (r0 == 0) goto L_0x003b;
    L_0x0022:
        r12 = r5;
    L_0x0023:
        r0 = r11.mDeferStart;
        if (r0 == 0) goto L_0x002e;
    L_0x0027:
        r0 = r11.mState;
        if (r0 >= r9) goto L_0x002e;
    L_0x002b:
        if (r12 <= r6) goto L_0x002e;
    L_0x002d:
        r12 = r6;
    L_0x002e:
        r0 = r11.mState;
        if (r0 > r12) goto L_0x032e;
    L_0x0032:
        r0 = r11.mFromLayout;
        if (r0 == 0) goto L_0x003e;
    L_0x0036:
        r0 = r11.mInLayout;
        if (r0 != 0) goto L_0x003e;
    L_0x003a:
        return;
    L_0x003b:
        r12 = r11.mState;
        goto L_0x0023;
    L_0x003e:
        r0 = r11.getAnimatingAway();
        if (r0 != 0) goto L_0x004a;
    L_0x0044:
        r0 = r11.getAnimator();
        if (r0 == 0) goto L_0x005a;
    L_0x004a:
        r11.setAnimatingAway(r7);
        r11.setAnimator(r7);
        r2 = r11.getStateAfterAnimating();
        r0 = r10;
        r1 = r11;
        r4 = r3;
        r0.m416a(r1, r2, r3, r4, r5);
    L_0x005a:
        r0 = r11.mState;
        switch(r0) {
            case 0: goto L_0x009a;
            case 1: goto L_0x01c2;
            case 2: goto L_0x02c0;
            case 3: goto L_0x02c5;
            case 4: goto L_0x02e9;
            default: goto L_0x005f;
        };
    L_0x005f:
        r0 = r11.mState;
        if (r0 == r12) goto L_0x003a;
    L_0x0063:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveToState: Fragment state for ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " not updated inline; ";
        r1 = r1.append(r2);
        r2 = "expected state ";
        r1 = r1.append(r2);
        r1 = r1.append(r12);
        r2 = " found ";
        r1 = r1.append(r2);
        r2 = r11.mState;
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        r11.mState = r12;
        goto L_0x003a;
    L_0x009a:
        if (r12 <= 0) goto L_0x01c2;
    L_0x009c:
        r0 = f229a;
        if (r0 == 0) goto L_0x00b8;
    L_0x00a0:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x00b8:
        r0 = r11.mSavedFragmentState;
        if (r0 == 0) goto L_0x0100;
    L_0x00bc:
        r0 = r11.mSavedFragmentState;
        r1 = r10.f247m;
        r1 = r1.m282i();
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r11.mSavedFragmentState;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.mSavedViewState = r0;
        r0 = r11.mSavedFragmentState;
        r1 = "android:target_state";
        r0 = r10.m405a(r0, r1);
        r11.mTarget = r0;
        r0 = r11.mTarget;
        if (r0 == 0) goto L_0x00ed;
    L_0x00e3:
        r0 = r11.mSavedFragmentState;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r11.mTargetRequestCode = r0;
    L_0x00ed:
        r0 = r11.mSavedFragmentState;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r11.mUserVisibleHint = r0;
        r0 = r11.mUserVisibleHint;
        if (r0 != 0) goto L_0x0100;
    L_0x00fb:
        r11.mDeferStart = r5;
        if (r12 <= r6) goto L_0x0100;
    L_0x00ff:
        r12 = r6;
    L_0x0100:
        r0 = r10.f247m;
        r11.mHost = r0;
        r0 = r10.f249o;
        r11.mParentFragment = r0;
        r0 = r10.f249o;
        if (r0 == 0) goto L_0x014f;
    L_0x010c:
        r0 = r10.f249o;
        r0 = r0.mChildFragmentManager;
    L_0x0110:
        r11.mFragmentManager = r0;
        r0 = r11.mTarget;
        if (r0 == 0) goto L_0x0164;
    L_0x0116:
        r0 = r10.f240f;
        r1 = r11.mTarget;
        r1 = r1.mIndex;
        r0 = r0.get(r1);
        r1 = r11.mTarget;
        if (r0 == r1) goto L_0x0156;
    L_0x0124:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " declared target fragment ";
        r1 = r1.append(r2);
        r2 = r11.mTarget;
        r1 = r1.append(r2);
        r2 = " that does not belong to this FragmentManager!";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x014f:
        r0 = r10.f247m;
        r0 = r0.m284k();
        goto L_0x0110;
    L_0x0156:
        r0 = r11.mTarget;
        r0 = r0.mState;
        if (r0 >= r5) goto L_0x0164;
    L_0x015c:
        r1 = r11.mTarget;
        r0 = r10;
        r2 = r5;
        r4 = r3;
        r0.m416a(r1, r2, r3, r4, r5);
    L_0x0164:
        r0 = r10.f247m;
        r0 = r0.m282i();
        r10.m417a(r11, r0, r3);
        r11.mCalled = r3;
        r0 = r10.f247m;
        r0 = r0.m282i();
        r11.onAttach(r0);
        r0 = r11.mCalled;
        if (r0 != 0) goto L_0x019b;
    L_0x017c:
        r0 = new android.support.v4.a.ao;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x019b:
        r0 = r11.mParentFragment;
        if (r0 != 0) goto L_0x0313;
    L_0x019f:
        r0 = r10.f247m;
        r0.mo79b(r11);
    L_0x01a4:
        r0 = r10.f247m;
        r0 = r0.m282i();
        r10.m434b(r11, r0, r3);
        r0 = r11.mIsCreated;
        if (r0 != 0) goto L_0x031a;
    L_0x01b1:
        r0 = r11.mSavedFragmentState;
        r10.m418a(r11, r0, r3);
        r0 = r11.mSavedFragmentState;
        r11.performCreate(r0);
        r0 = r11.mSavedFragmentState;
        r10.m435b(r11, r0, r3);
    L_0x01c0:
        r11.mRetaining = r3;
    L_0x01c2:
        r10.m443c(r11);
        if (r12 <= r5) goto L_0x02c0;
    L_0x01c7:
        r0 = f229a;
        if (r0 == 0) goto L_0x01e3;
    L_0x01cb:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x01e3:
        r0 = r11.mFromLayout;
        if (r0 != 0) goto L_0x02ab;
    L_0x01e7:
        r0 = r11.mContainerId;
        if (r0 == 0) goto L_0x04a1;
    L_0x01eb:
        r0 = r11.mContainerId;
        r1 = -1;
        if (r0 != r1) goto L_0x0211;
    L_0x01f0:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Cannot create fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " for a container view with no id";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        r10.m385a(r0);
    L_0x0211:
        r0 = r10.f248n;
        r1 = r11.mContainerId;
        r0 = r0.mo70a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x0260;
    L_0x021d:
        r1 = r11.mRestored;
        if (r1 != 0) goto L_0x0260;
    L_0x0221:
        r1 = r11.getResources();	 Catch:{ NotFoundException -> 0x0323 }
        r2 = r11.mContainerId;	 Catch:{ NotFoundException -> 0x0323 }
        r1 = r1.getResourceName(r2);	 Catch:{ NotFoundException -> 0x0323 }
    L_0x022b:
        r2 = new java.lang.IllegalArgumentException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r8 = "No view found for id 0x";
        r4 = r4.append(r8);
        r8 = r11.mContainerId;
        r8 = java.lang.Integer.toHexString(r8);
        r4 = r4.append(r8);
        r8 = " (";
        r4 = r4.append(r8);
        r1 = r4.append(r1);
        r4 = ") for fragment ";
        r1 = r1.append(r4);
        r1 = r1.append(r11);
        r1 = r1.toString();
        r2.<init>(r1);
        r10.m385a(r2);
    L_0x0260:
        r11.mContainer = r0;
        r1 = r11.mSavedFragmentState;
        r1 = r11.performGetLayoutInflater(r1);
        r2 = r11.mSavedFragmentState;
        r1 = r11.performCreateView(r1, r0, r2);
        r11.mView = r1;
        r1 = r11.mView;
        if (r1 == 0) goto L_0x032a;
    L_0x0274:
        r1 = r11.mView;
        r11.mInnerView = r1;
        r1 = r11.mView;
        r1.setSaveFromParentEnabled(r3);
        if (r0 == 0) goto L_0x0284;
    L_0x027f:
        r1 = r11.mView;
        r0.addView(r1);
    L_0x0284:
        r0 = r11.mHidden;
        if (r0 == 0) goto L_0x028f;
    L_0x0288:
        r0 = r11.mView;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x028f:
        r0 = r11.mView;
        r1 = r11.mSavedFragmentState;
        r11.onViewCreated(r0, r1);
        r0 = r11.mView;
        r1 = r11.mSavedFragmentState;
        r10.m419a(r11, r0, r1, r3);
        r0 = r11.mView;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x0328;
    L_0x02a5:
        r0 = r11.mContainer;
        if (r0 == 0) goto L_0x0328;
    L_0x02a9:
        r11.mIsNewlyAdded = r5;
    L_0x02ab:
        r0 = r11.mSavedFragmentState;
        r11.performActivityCreated(r0);
        r0 = r11.mSavedFragmentState;
        r10.m444c(r11, r0, r3);
        r0 = r11.mView;
        if (r0 == 0) goto L_0x02be;
    L_0x02b9:
        r0 = r11.mSavedFragmentState;
        r11.restoreViewState(r0);
    L_0x02be:
        r11.mSavedFragmentState = r7;
    L_0x02c0:
        r0 = 2;
        if (r12 <= r0) goto L_0x02c5;
    L_0x02c3:
        r11.mState = r6;
    L_0x02c5:
        if (r12 <= r6) goto L_0x02e9;
    L_0x02c7:
        r0 = f229a;
        if (r0 == 0) goto L_0x02e3;
    L_0x02cb:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02e3:
        r11.performStart();
        r10.m436b(r11, r3);
    L_0x02e9:
        if (r12 <= r9) goto L_0x005f;
    L_0x02eb:
        r0 = f229a;
        if (r0 == 0) goto L_0x0307;
    L_0x02ef:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0307:
        r11.performResume();
        r10.m445c(r11, r3);
        r11.mSavedFragmentState = r7;
        r11.mSavedViewState = r7;
        goto L_0x005f;
    L_0x0313:
        r0 = r11.mParentFragment;
        r0.onAttachFragment(r11);
        goto L_0x01a4;
    L_0x031a:
        r0 = r11.mSavedFragmentState;
        r11.restoreChildFragmentState(r0);
        r11.mState = r5;
        goto L_0x01c0;
    L_0x0323:
        r1 = move-exception;
        r1 = "unknown";
        goto L_0x022b;
    L_0x0328:
        r5 = r3;
        goto L_0x02a9;
    L_0x032a:
        r11.mInnerView = r7;
        goto L_0x02ab;
    L_0x032e:
        r0 = r11.mState;
        if (r0 <= r12) goto L_0x005f;
    L_0x0332:
        r0 = r11.mState;
        switch(r0) {
            case 1: goto L_0x0339;
            case 2: goto L_0x03cb;
            case 3: goto L_0x03aa;
            case 4: goto L_0x0386;
            case 5: goto L_0x0361;
            default: goto L_0x0337;
        };
    L_0x0337:
        goto L_0x005f;
    L_0x0339:
        if (r12 >= r5) goto L_0x005f;
    L_0x033b:
        r0 = r10.f253t;
        if (r0 == 0) goto L_0x034f;
    L_0x033f:
        r0 = r11.getAnimatingAway();
        if (r0 == 0) goto L_0x044b;
    L_0x0345:
        r0 = r11.getAnimatingAway();
        r11.setAnimatingAway(r7);
        r0.clearAnimation();
    L_0x034f:
        r0 = r11.getAnimatingAway();
        if (r0 != 0) goto L_0x035b;
    L_0x0355:
        r0 = r11.getAnimator();
        if (r0 == 0) goto L_0x045d;
    L_0x035b:
        r11.setStateAfterAnimating(r12);
        r12 = r5;
        goto L_0x005f;
    L_0x0361:
        r0 = 5;
        if (r12 >= r0) goto L_0x0386;
    L_0x0364:
        r0 = f229a;
        if (r0 == 0) goto L_0x0380;
    L_0x0368:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0380:
        r11.performPause();
        r10.m448d(r11, r3);
    L_0x0386:
        if (r12 >= r9) goto L_0x03aa;
    L_0x0388:
        r0 = f229a;
        if (r0 == 0) goto L_0x03a4;
    L_0x038c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03a4:
        r11.performStop();
        r10.m452e(r11, r3);
    L_0x03aa:
        if (r12 >= r6) goto L_0x03cb;
    L_0x03ac:
        r0 = f229a;
        if (r0 == 0) goto L_0x03c8;
    L_0x03b0:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03c8:
        r11.performReallyStop();
    L_0x03cb:
        r0 = 2;
        if (r12 >= r0) goto L_0x0339;
    L_0x03ce:
        r0 = f229a;
        if (r0 == 0) goto L_0x03ea;
    L_0x03d2:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03ea:
        r0 = r11.mView;
        if (r0 == 0) goto L_0x03fd;
    L_0x03ee:
        r0 = r10.f247m;
        r0 = r0.mo76a(r11);
        if (r0 == 0) goto L_0x03fd;
    L_0x03f6:
        r0 = r11.mSavedViewState;
        if (r0 != 0) goto L_0x03fd;
    L_0x03fa:
        r10.m471m(r11);
    L_0x03fd:
        r11.performDestroyView();
        r10.m454f(r11, r3);
        r0 = r11.mView;
        if (r0 == 0) goto L_0x0441;
    L_0x0407:
        r0 = r11.mContainer;
        if (r0 == 0) goto L_0x0441;
    L_0x040b:
        r0 = r11.mView;
        r0.clearAnimation();
        r0 = r11.mContainer;
        r1 = r11.mView;
        r0.endViewTransition(r1);
        r0 = r10.f246l;
        if (r0 <= 0) goto L_0x049f;
    L_0x041b:
        r0 = r10.f253t;
        if (r0 != 0) goto L_0x049f;
    L_0x041f:
        r0 = r11.mView;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x049f;
    L_0x0427:
        r0 = r11.mPostponedAlpha;
        r1 = 0;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 < 0) goto L_0x049f;
    L_0x042e:
        r0 = r10.m407a(r11, r13, r3, r14);
    L_0x0432:
        r1 = 0;
        r11.mPostponedAlpha = r1;
        if (r0 == 0) goto L_0x043a;
    L_0x0437:
        r10.m380a(r11, r0, r12);
    L_0x043a:
        r0 = r11.mContainer;
        r1 = r11.mView;
        r0.removeView(r1);
    L_0x0441:
        r11.mContainer = r7;
        r11.mView = r7;
        r11.mInnerView = r7;
        r11.mInLayout = r3;
        goto L_0x0339;
    L_0x044b:
        r0 = r11.getAnimator();
        if (r0 == 0) goto L_0x034f;
    L_0x0451:
        r0 = r11.getAnimator();
        r11.setAnimator(r7);
        r0.cancel();
        goto L_0x034f;
    L_0x045d:
        r0 = f229a;
        if (r0 == 0) goto L_0x0479;
    L_0x0461:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0479:
        r0 = r11.mRetaining;
        if (r0 != 0) goto L_0x0494;
    L_0x047d:
        r11.performDestroy();
        r10.m458g(r11, r3);
    L_0x0483:
        r11.performDetach();
        r10.m461h(r11, r3);
        if (r15 != 0) goto L_0x005f;
    L_0x048b:
        r0 = r11.mRetaining;
        if (r0 != 0) goto L_0x0497;
    L_0x048f:
        r10.m457g(r11);
        goto L_0x005f;
    L_0x0494:
        r11.mState = r3;
        goto L_0x0483;
    L_0x0497:
        r11.mHost = r7;
        r11.mParentFragment = r7;
        r11.mFragmentManager = r7;
        goto L_0x005f;
    L_0x049f:
        r0 = r7;
        goto L_0x0432;
    L_0x04a1:
        r0 = r7;
        goto L_0x0260;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.o.a(android.support.v4.a.i, int, int, int, boolean):void");
    }

    /* renamed from: a */
    private void m380a(final C0131i c0131i, C0157c c0157c, int i) {
        final View view = c0131i.mView;
        c0131i.setStateAfterAnimating(i);
        if (c0157c.f214a != null) {
            Animation animation = c0157c.f214a;
            c0131i.setAnimatingAway(c0131i.mView);
            animation.setAnimationListener(new C0151b(this, C0162o.m378a(animation)) {
                /* renamed from: b */
                final /* synthetic */ C0162o f203b;

                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    if (c0131i.getAnimatingAway() != null) {
                        c0131i.setAnimatingAway(null);
                        this.f203b.m416a(c0131i, c0131i.getStateAfterAnimating(), 0, 0, false);
                    }
                }
            });
            C0162o.m394b(view, c0157c);
            c0131i.mView.startAnimation(animation);
            return;
        }
        Animator animator = c0157c.f215b;
        c0131i.setAnimator(c0157c.f215b);
        final ViewGroup viewGroup = c0131i.mContainer;
        if (viewGroup != null) {
            viewGroup.startViewTransition(view);
        }
        animator.addListener(new AnimatorListenerAdapter(this) {
            /* renamed from: d */
            final /* synthetic */ C0162o f207d;

            public void onAnimationEnd(Animator animator) {
                if (viewGroup != null) {
                    viewGroup.endViewTransition(view);
                }
                if (c0131i.getAnimator() != null) {
                    c0131i.setAnimator(null);
                    this.f207d.m416a(c0131i, c0131i.getStateAfterAnimating(), 0, 0, false);
                }
            }
        });
        animator.setTarget(c0131i.mView);
        C0162o.m394b(c0131i.mView, c0157c);
        animator.start();
    }

    /* renamed from: b */
    void m433b(C0131i c0131i) {
        m416a(c0131i, this.f246l, 0, 0, false);
    }

    /* renamed from: c */
    void m443c(C0131i c0131i) {
        if (c0131i.mFromLayout && !c0131i.mPerformedCreateView) {
            c0131i.mView = c0131i.performCreateView(c0131i.performGetLayoutInflater(c0131i.mSavedFragmentState), null, c0131i.mSavedFragmentState);
            if (c0131i.mView != null) {
                c0131i.mInnerView = c0131i.mView;
                c0131i.mView.setSaveFromParentEnabled(false);
                if (c0131i.mHidden) {
                    c0131i.mView.setVisibility(8);
                }
                c0131i.onViewCreated(c0131i.mView, c0131i.mSavedFragmentState);
                m419a(c0131i, c0131i.mView, c0131i.mSavedFragmentState, false);
                return;
            }
            c0131i.mInnerView = null;
        }
    }

    /* renamed from: d */
    void m446d(final C0131i c0131i) {
        if (c0131i.mView != null) {
            C0157c a = m407a(c0131i, c0131i.getNextTransition(), !c0131i.mHidden, c0131i.getNextTransitionStyle());
            if (a == null || a.f215b == null) {
                if (a != null) {
                    C0162o.m394b(c0131i.mView, a);
                    c0131i.mView.startAnimation(a.f214a);
                    a.f214a.start();
                }
                int i = (!c0131i.mHidden || c0131i.isHideReplaced()) ? 0 : 8;
                c0131i.mView.setVisibility(i);
                if (c0131i.isHideReplaced()) {
                    c0131i.setHideReplaced(false);
                }
            } else {
                a.f215b.setTarget(c0131i.mView);
                if (!c0131i.mHidden) {
                    c0131i.mView.setVisibility(0);
                } else if (c0131i.isHideReplaced()) {
                    c0131i.setHideReplaced(false);
                } else {
                    final ViewGroup viewGroup = c0131i.mContainer;
                    final View view = c0131i.mView;
                    viewGroup.startViewTransition(view);
                    a.f215b.addListener(new AnimatorListenerAdapter(this) {
                        /* renamed from: d */
                        final /* synthetic */ C0162o f211d;

                        public void onAnimationEnd(Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            if (c0131i.mView != null) {
                                c0131i.mView.setVisibility(8);
                            }
                        }
                    });
                }
                C0162o.m394b(c0131i.mView, a);
                a.f215b.start();
            }
        }
        if (c0131i.mAdded && c0131i.mHasMenu && c0131i.mMenuVisible) {
            this.f251r = true;
        }
        c0131i.mHiddenChanged = false;
        c0131i.onHiddenChanged(c0131i.mHidden);
    }

    /* renamed from: e */
    void m451e(C0131i c0131i) {
        if (c0131i != null) {
            int i = this.f246l;
            if (c0131i.mRemoving) {
                if (c0131i.isInBackStack()) {
                    i = Math.min(i, 1);
                } else {
                    i = Math.min(i, 0);
                }
            }
            m416a(c0131i, i, c0131i.getNextTransition(), c0131i.getNextTransitionStyle(), false);
            if (c0131i.mView != null) {
                C0131i p = m401p(c0131i);
                if (p != null) {
                    View view = p.mView;
                    ViewGroup viewGroup = c0131i.mContainer;
                    int indexOfChild = viewGroup.indexOfChild(view);
                    i = viewGroup.indexOfChild(c0131i.mView);
                    if (i < indexOfChild) {
                        viewGroup.removeViewAt(i);
                        viewGroup.addView(c0131i.mView, indexOfChild);
                    }
                }
                if (c0131i.mIsNewlyAdded && c0131i.mContainer != null) {
                    if (c0131i.mPostponedAlpha > 0.0f) {
                        c0131i.mView.setAlpha(c0131i.mPostponedAlpha);
                    }
                    c0131i.mPostponedAlpha = 0.0f;
                    c0131i.mIsNewlyAdded = false;
                    C0157c a = m407a(c0131i, c0131i.getNextTransition(), true, c0131i.getNextTransitionStyle());
                    if (a != null) {
                        C0162o.m394b(c0131i.mView, a);
                        if (a.f214a != null) {
                            c0131i.mView.startAnimation(a.f214a);
                        } else {
                            a.f215b.setTarget(c0131i.mView);
                            a.f215b.start();
                        }
                    }
                }
            }
            if (c0131i.mHiddenChanged) {
                m446d(c0131i);
            }
        }
    }

    /* renamed from: a */
    void m411a(int i, boolean z) {
        if (this.f247m == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || i != this.f246l) {
            this.f246l = i;
            if (this.f240f != null) {
                C0131i c0131i;
                int a;
                int size = this.f239e.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    c0131i = (C0131i) this.f239e.get(i2);
                    m451e(c0131i);
                    if (c0131i.mLoaderManager != null) {
                        a = c0131i.mLoaderManager.mo104a() | i3;
                    } else {
                        a = i3;
                    }
                    i2++;
                    i3 = a;
                }
                size = this.f240f.size();
                i2 = 0;
                while (i2 < size) {
                    c0131i = (C0131i) this.f240f.valueAt(i2);
                    if (c0131i != null && ((c0131i.mRemoving || c0131i.mDetached) && !c0131i.mIsNewlyAdded)) {
                        m451e(c0131i);
                        if (c0131i.mLoaderManager != null) {
                            a = c0131i.mLoaderManager.mo104a() | i3;
                            i2++;
                            i3 = a;
                        }
                    }
                    a = i3;
                    i2++;
                    i3 = a;
                }
                if (i3 == 0) {
                    m450e();
                }
                if (this.f251r && this.f247m != null && this.f246l == 5) {
                    this.f247m.mo80d();
                    this.f251r = false;
                }
            }
        }
    }

    /* renamed from: e */
    void m450e() {
        if (this.f240f != null) {
            for (int i = 0; i < this.f240f.size(); i++) {
                C0131i c0131i = (C0131i) this.f240f.valueAt(i);
                if (c0131i != null) {
                    m415a(c0131i);
                }
            }
        }
    }

    /* renamed from: f */
    void m453f(C0131i c0131i) {
        if (c0131i.mIndex < 0) {
            int i = this.f238d;
            this.f238d = i + 1;
            c0131i.setIndex(i, this.f249o);
            if (this.f240f == null) {
                this.f240f = new SparseArray();
            }
            this.f240f.put(c0131i.mIndex, c0131i);
            if (f229a) {
                Log.v("FragmentManager", "Allocated fragment index " + c0131i);
            }
        }
    }

    /* renamed from: g */
    void m457g(C0131i c0131i) {
        if (c0131i.mIndex >= 0) {
            if (f229a) {
                Log.v("FragmentManager", "Freeing fragment index " + c0131i);
            }
            this.f240f.put(c0131i.mIndex, null);
            this.f247m.m275b(c0131i.mWho);
            c0131i.initState();
        }
    }

    /* renamed from: a */
    public void m420a(C0131i c0131i, boolean z) {
        if (f229a) {
            Log.v("FragmentManager", "add: " + c0131i);
        }
        m453f(c0131i);
        if (!c0131i.mDetached) {
            if (this.f239e.contains(c0131i)) {
                throw new IllegalStateException("Fragment already added: " + c0131i);
            }
            synchronized (this.f239e) {
                this.f239e.add(c0131i);
            }
            c0131i.mAdded = true;
            c0131i.mRemoving = false;
            if (c0131i.mView == null) {
                c0131i.mHiddenChanged = false;
            }
            if (c0131i.mHasMenu && c0131i.mMenuVisible) {
                this.f251r = true;
            }
            if (z) {
                m433b(c0131i);
            }
        }
    }

    /* renamed from: h */
    public void m460h(C0131i c0131i) {
        if (f229a) {
            Log.v("FragmentManager", "remove: " + c0131i + " nesting=" + c0131i.mBackStackNesting);
        }
        boolean z = !c0131i.isInBackStack();
        if (!c0131i.mDetached || z) {
            synchronized (this.f239e) {
                this.f239e.remove(c0131i);
            }
            if (c0131i.mHasMenu && c0131i.mMenuVisible) {
                this.f251r = true;
            }
            c0131i.mAdded = false;
            c0131i.mRemoving = true;
        }
    }

    /* renamed from: i */
    public void m463i(C0131i c0131i) {
        boolean z = true;
        if (f229a) {
            Log.v("FragmentManager", "hide: " + c0131i);
        }
        if (!c0131i.mHidden) {
            c0131i.mHidden = true;
            if (c0131i.mHiddenChanged) {
                z = false;
            }
            c0131i.mHiddenChanged = z;
        }
    }

    /* renamed from: j */
    public void m465j(C0131i c0131i) {
        boolean z = false;
        if (f229a) {
            Log.v("FragmentManager", "show: " + c0131i);
        }
        if (c0131i.mHidden) {
            c0131i.mHidden = false;
            if (!c0131i.mHiddenChanged) {
                z = true;
            }
            c0131i.mHiddenChanged = z;
        }
    }

    /* renamed from: k */
    public void m467k(C0131i c0131i) {
        if (f229a) {
            Log.v("FragmentManager", "detach: " + c0131i);
        }
        if (!c0131i.mDetached) {
            c0131i.mDetached = true;
            if (c0131i.mAdded) {
                if (f229a) {
                    Log.v("FragmentManager", "remove from detach: " + c0131i);
                }
                synchronized (this.f239e) {
                    this.f239e.remove(c0131i);
                }
                if (c0131i.mHasMenu && c0131i.mMenuVisible) {
                    this.f251r = true;
                }
                c0131i.mAdded = false;
            }
        }
    }

    /* renamed from: l */
    public void m469l(C0131i c0131i) {
        if (f229a) {
            Log.v("FragmentManager", "attach: " + c0131i);
        }
        if (c0131i.mDetached) {
            c0131i.mDetached = false;
            if (!c0131i.mAdded) {
                if (this.f239e.contains(c0131i)) {
                    throw new IllegalStateException("Fragment already added: " + c0131i);
                }
                if (f229a) {
                    Log.v("FragmentManager", "add from attach: " + c0131i);
                }
                synchronized (this.f239e) {
                    this.f239e.add(c0131i);
                }
                c0131i.mAdded = true;
                if (c0131i.mHasMenu && c0131i.mMenuVisible) {
                    this.f251r = true;
                }
            }
        }
    }

    /* renamed from: b */
    public C0131i m430b(int i) {
        int size;
        for (size = this.f239e.size() - 1; size >= 0; size--) {
            C0131i c0131i = (C0131i) this.f239e.get(size);
            if (c0131i != null && c0131i.mFragmentId == i) {
                return c0131i;
            }
        }
        if (this.f240f != null) {
            for (size = this.f240f.size() - 1; size >= 0; size--) {
                c0131i = (C0131i) this.f240f.valueAt(size);
                if (c0131i != null && c0131i.mFragmentId == i) {
                    return c0131i;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public C0131i mo97a(String str) {
        int size;
        C0131i c0131i;
        if (str != null) {
            for (size = this.f239e.size() - 1; size >= 0; size--) {
                c0131i = (C0131i) this.f239e.get(size);
                if (c0131i != null && str.equals(c0131i.mTag)) {
                    return c0131i;
                }
            }
        }
        if (!(this.f240f == null || str == null)) {
            for (size = this.f240f.size() - 1; size >= 0; size--) {
                c0131i = (C0131i) this.f240f.valueAt(size);
                if (c0131i != null && str.equals(c0131i.mTag)) {
                    return c0131i;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public C0131i m431b(String str) {
        if (!(this.f240f == null || str == null)) {
            for (int size = this.f240f.size() - 1; size >= 0; size--) {
                C0131i c0131i = (C0131i) this.f240f.valueAt(size);
                if (c0131i != null) {
                    c0131i = c0131i.findFragmentByWho(str);
                    if (c0131i != null) {
                        return c0131i;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: y */
    private void m402y() {
        if (this.f252s) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f254u != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f254u);
        }
    }

    /* renamed from: d */
    public boolean mo103d() {
        return this.f252s;
    }

    /* renamed from: a */
    public void m422a(C0123f c0123f, boolean z) {
        if (!z) {
            m402y();
        }
        synchronized (this) {
            if (!this.f253t && this.f247m != null) {
                if (this.f236b == null) {
                    this.f236b = new ArrayList();
                }
                this.f236b.add(c0123f);
                m403z();
            } else if (z) {
            } else {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    /* renamed from: z */
    private void m403z() {
        Object obj = 1;
        synchronized (this) {
            Object obj2 = (this.f232B == null || this.f232B.isEmpty()) ? null : 1;
            if (this.f236b == null || this.f236b.size() != 1) {
                obj = null;
            }
            if (!(obj2 == null && r0 == null)) {
                this.f247m.m283j().removeCallbacks(this.f234D);
                this.f247m.m283j().post(this.f234D);
            }
        }
    }

    /* renamed from: a */
    public int m404a(C0124c c0124c) {
        int size;
        synchronized (this) {
            if (this.f244j == null || this.f244j.size() <= 0) {
                if (this.f243i == null) {
                    this.f243i = new ArrayList();
                }
                size = this.f243i.size();
                if (f229a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + c0124c);
                }
                this.f243i.add(c0124c);
            } else {
                size = ((Integer) this.f244j.remove(this.f244j.size() - 1)).intValue();
                if (f229a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + c0124c);
                }
                this.f243i.set(size, c0124c);
            }
        }
        return size;
    }

    /* renamed from: a */
    public void m410a(int i, C0124c c0124c) {
        synchronized (this) {
            if (this.f243i == null) {
                this.f243i = new ArrayList();
            }
            int size = this.f243i.size();
            if (i < size) {
                if (f229a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + c0124c);
                }
                this.f243i.set(i, c0124c);
            } else {
                while (size < i) {
                    this.f243i.add(null);
                    if (this.f244j == null) {
                        this.f244j = new ArrayList();
                    }
                    if (f229a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f244j.add(Integer.valueOf(size));
                    size++;
                }
                if (f229a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + c0124c);
                }
                this.f243i.add(c0124c);
            }
        }
    }

    /* renamed from: c */
    public void m442c(int i) {
        synchronized (this) {
            this.f243i.set(i, null);
            if (this.f244j == null) {
                this.f244j = new ArrayList();
            }
            if (f229a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f244j.add(Integer.valueOf(i));
        }
    }

    /* renamed from: c */
    private void m397c(boolean z) {
        if (this.f237c) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (Looper.myLooper() != this.f247m.m283j().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else {
            if (!z) {
                m402y();
            }
            if (this.f256w == null) {
                this.f256w = new ArrayList();
                this.f257x = new ArrayList();
            }
            this.f237c = true;
            try {
                m386a(null, null);
            } finally {
                this.f237c = false;
            }
        }
    }

    /* renamed from: A */
    private void m371A() {
        this.f237c = false;
        this.f257x.clear();
        this.f256w.clear();
    }

    /* renamed from: f */
    public boolean m455f() {
        m397c(true);
        boolean z = false;
        while (m398c(this.f256w, this.f257x)) {
            this.f237c = true;
            try {
                m395b(this.f256w, this.f257x);
                m371A();
                z = true;
            } catch (Throwable th) {
                m371A();
                throw th;
            }
        }
        m456g();
        m374D();
        return z;
    }

    /* renamed from: a */
    private void m386a(ArrayList<C0124c> arrayList, ArrayList<Boolean> arrayList2) {
        int i = 0;
        int size = this.f232B == null ? 0 : this.f232B.size();
        while (i < size) {
            int indexOf;
            int i2;
            C0161h c0161h = (C0161h) this.f232B.get(i);
            if (!(arrayList == null || c0161h.f222a)) {
                indexOf = arrayList.indexOf(c0161h.f223b);
                if (indexOf != -1 && ((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                    c0161h.m370e();
                    i2 = i;
                    indexOf = size;
                    i = i2 + 1;
                    size = indexOf;
                }
            }
            if (c0161h.m368c() || (arrayList != null && c0161h.f223b.m221a((ArrayList) arrayList, 0, arrayList.size()))) {
                this.f232B.remove(i);
                i--;
                size--;
                if (!(arrayList == null || c0161h.f222a)) {
                    indexOf = arrayList.indexOf(c0161h.f223b);
                    if (indexOf != -1 && ((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                        c0161h.m370e();
                        i2 = i;
                        indexOf = size;
                        i = i2 + 1;
                        size = indexOf;
                    }
                }
                c0161h.m369d();
            }
            i2 = i;
            indexOf = size;
            i = i2 + 1;
            size = indexOf;
        }
    }

    /* renamed from: b */
    private void m395b(ArrayList<C0124c> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            m386a((ArrayList) arrayList, (ArrayList) arrayList2);
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                int i3;
                int i4;
                if (((C0124c) arrayList.get(i)).f146u) {
                    i3 = i;
                    i4 = i2;
                } else {
                    if (i2 != i) {
                        m387a((ArrayList) arrayList, (ArrayList) arrayList2, i2, i);
                    }
                    i3 = i + 1;
                    if (((Boolean) arrayList2.get(i)).booleanValue()) {
                        while (i3 < size && ((Boolean) arrayList2.get(i3)).booleanValue() && !((C0124c) arrayList.get(i3)).f146u) {
                            i3++;
                        }
                    }
                    i4 = i3;
                    m387a((ArrayList) arrayList, (ArrayList) arrayList2, i, i4);
                    i3 = i4 - 1;
                }
                i = i3 + 1;
                i2 = i4;
            }
            if (i2 != size) {
                m387a((ArrayList) arrayList, (ArrayList) arrayList2, i2, size);
            }
        }
    }

    /* renamed from: a */
    private void m387a(ArrayList<C0124c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int a;
        boolean z = ((C0124c) arrayList.get(i)).f146u;
        if (this.f258y == null) {
            this.f258y = new ArrayList();
        } else {
            this.f258y.clear();
        }
        this.f258y.addAll(this.f239e);
        int i3 = i;
        C0131i w = m483w();
        boolean z2 = false;
        while (i3 < i2) {
            C0131i b;
            boolean z3;
            C0124c c0124c = (C0124c) arrayList.get(i3);
            if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                b = c0124c.m224b(this.f258y, w);
            } else {
                b = c0124c.m212a(this.f258y, w);
            }
            if (z2 || c0124c.f135j) {
                z3 = true;
            } else {
                z3 = false;
            }
            i3++;
            w = b;
            z2 = z3;
        }
        this.f258y.clear();
        if (!z) {
            C0173t.m506a(this, arrayList, arrayList2, i, i2, false);
        }
        C0162o.m396b(arrayList, arrayList2, i, i2);
        if (z) {
            C0240b c0240b = new C0240b();
            m393b(c0240b);
            a = m375a((ArrayList) arrayList, (ArrayList) arrayList2, i, i2, c0240b);
            m384a(c0240b);
        } else {
            a = i2;
        }
        if (a != i && z) {
            C0173t.m506a(this, arrayList, arrayList2, i, a, true);
            m411a(this.f246l, true);
        }
        while (i < i2) {
            c0124c = (C0124c) arrayList.get(i);
            if (((Boolean) arrayList2.get(i)).booleanValue() && c0124c.f139n >= 0) {
                m442c(c0124c.f139n);
                c0124c.f139n = -1;
            }
            c0124c.m215a();
            i++;
        }
        if (z2) {
            m459h();
        }
    }

    /* renamed from: a */
    private void m384a(C0240b<C0131i> c0240b) {
        int size = c0240b.size();
        for (int i = 0; i < size; i++) {
            C0131i c0131i = (C0131i) c0240b.m743b(i);
            if (!c0131i.mAdded) {
                View view = c0131i.getView();
                c0131i.mPostponedAlpha = view.getAlpha();
                view.setAlpha(0.0f);
            }
        }
    }

    /* renamed from: a */
    private int m375a(ArrayList<C0124c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, C0240b<C0131i> c0240b) {
        int i3 = i2 - 1;
        int i4 = i2;
        while (i3 >= i) {
            boolean z;
            int i5;
            C0124c c0124c = (C0124c) arrayList.get(i3);
            boolean booleanValue = ((Boolean) arrayList2.get(i3)).booleanValue();
            if (!c0124c.m229e() || c0124c.m221a((ArrayList) arrayList, i3 + 1, i2)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                if (this.f232B == null) {
                    this.f232B = new ArrayList();
                }
                C0138c c0161h = new C0161h(c0124c, booleanValue);
                this.f232B.add(c0161h);
                c0124c.m218a(c0161h);
                if (booleanValue) {
                    c0124c.m228d();
                } else {
                    c0124c.m225b(false);
                }
                int i6 = i4 - 1;
                if (i3 != i6) {
                    arrayList.remove(i3);
                    arrayList.add(i6, c0124c);
                }
                m393b((C0240b) c0240b);
                i5 = i6;
            } else {
                i5 = i4;
            }
            i3--;
            i4 = i5;
        }
        return i4;
    }

    /* renamed from: a */
    private void m379a(C0124c c0124c, boolean z, boolean z2, boolean z3) {
        if (z) {
            c0124c.m225b(z3);
        } else {
            c0124c.m228d();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(c0124c);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            C0173t.m506a(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z3) {
            m411a(this.f246l, true);
        }
        if (this.f240f != null) {
            int size = this.f240f.size();
            for (int i = 0; i < size; i++) {
                C0131i c0131i = (C0131i) this.f240f.valueAt(i);
                if (c0131i != null && c0131i.mView != null && c0131i.mIsNewlyAdded && c0124c.m226b(c0131i.mContainerId)) {
                    if (c0131i.mPostponedAlpha > 0.0f) {
                        c0131i.mView.setAlpha(c0131i.mPostponedAlpha);
                    }
                    if (z3) {
                        c0131i.mPostponedAlpha = 0.0f;
                    } else {
                        c0131i.mPostponedAlpha = -1.0f;
                        c0131i.mIsNewlyAdded = false;
                    }
                }
            }
        }
    }

    /* renamed from: p */
    private C0131i m401p(C0131i c0131i) {
        ViewGroup viewGroup = c0131i.mContainer;
        View view = c0131i.mView;
        if (viewGroup == null || view == null) {
            return null;
        }
        for (int indexOf = this.f239e.indexOf(c0131i) - 1; indexOf >= 0; indexOf--) {
            C0131i c0131i2 = (C0131i) this.f239e.get(indexOf);
            if (c0131i2.mContainer == viewGroup && c0131i2.mView != null) {
                return c0131i2;
            }
        }
        return null;
    }

    /* renamed from: b */
    private static void m396b(ArrayList<C0124c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            C0124c c0124c = (C0124c) arrayList.get(i);
            if (((Boolean) arrayList2.get(i)).booleanValue()) {
                c0124c.m216a(-1);
                c0124c.m225b(i == i2 + -1);
            } else {
                c0124c.m216a(1);
                c0124c.m228d();
            }
            i++;
        }
    }

    /* renamed from: b */
    private void m393b(C0240b<C0131i> c0240b) {
        if (this.f246l >= 1) {
            int min = Math.min(this.f246l, 4);
            int size = this.f239e.size();
            for (int i = 0; i < size; i++) {
                C0131i c0131i = (C0131i) this.f239e.get(i);
                if (c0131i.mState < min) {
                    m416a(c0131i, min, c0131i.getNextAnim(), c0131i.getNextTransition(), false);
                    if (!(c0131i.mView == null || c0131i.mHidden || !c0131i.mIsNewlyAdded)) {
                        c0240b.add(c0131i);
                    }
                }
            }
        }
    }

    /* renamed from: B */
    private void m372B() {
        if (this.f232B != null) {
            while (!this.f232B.isEmpty()) {
                ((C0161h) this.f232B.remove(0)).m369d();
            }
        }
    }

    /* renamed from: C */
    private void m373C() {
        int i;
        if (this.f240f == null) {
            i = 0;
        } else {
            i = this.f240f.size();
        }
        for (int i2 = 0; i2 < i; i2++) {
            C0131i c0131i = (C0131i) this.f240f.valueAt(i2);
            if (c0131i != null) {
                if (c0131i.getAnimatingAway() != null) {
                    int stateAfterAnimating = c0131i.getStateAfterAnimating();
                    View animatingAway = c0131i.getAnimatingAway();
                    c0131i.setAnimatingAway(null);
                    Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    m416a(c0131i, stateAfterAnimating, 0, 0, false);
                } else if (c0131i.getAnimator() != null) {
                    c0131i.getAnimator().end();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    private boolean m398c(java.util.ArrayList<android.support.v4.p012a.C0124c> r5, java.util.ArrayList<java.lang.Boolean> r6) {
        /*
        r4 = this;
        r0 = 0;
        monitor-enter(r4);
        r1 = r4.f236b;	 Catch:{ all -> 0x003e }
        if (r1 == 0) goto L_0x000e;
    L_0x0006:
        r1 = r4.f236b;	 Catch:{ all -> 0x003e }
        r1 = r1.size();	 Catch:{ all -> 0x003e }
        if (r1 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
    L_0x000f:
        return r0;
    L_0x0010:
        r1 = r4.f236b;	 Catch:{ all -> 0x003e }
        r3 = r1.size();	 Catch:{ all -> 0x003e }
        r2 = r0;
        r1 = r0;
    L_0x0018:
        if (r2 >= r3) goto L_0x002b;
    L_0x001a:
        r0 = r4.f236b;	 Catch:{ all -> 0x003e }
        r0 = r0.get(r2);	 Catch:{ all -> 0x003e }
        r0 = (android.support.v4.p012a.C0162o.C0123f) r0;	 Catch:{ all -> 0x003e }
        r0 = r0.mo57a(r5, r6);	 Catch:{ all -> 0x003e }
        r1 = r1 | r0;
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x0018;
    L_0x002b:
        r0 = r4.f236b;	 Catch:{ all -> 0x003e }
        r0.clear();	 Catch:{ all -> 0x003e }
        r0 = r4.f247m;	 Catch:{ all -> 0x003e }
        r0 = r0.m283j();	 Catch:{ all -> 0x003e }
        r2 = r4.f234D;	 Catch:{ all -> 0x003e }
        r0.removeCallbacks(r2);	 Catch:{ all -> 0x003e }
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
        r0 = r1;
        goto L_0x000f;
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x003e }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.o.c(java.util.ArrayList, java.util.ArrayList):boolean");
    }

    /* renamed from: g */
    void m456g() {
        if (this.f255v) {
            int i = 0;
            for (int i2 = 0; i2 < this.f240f.size(); i2++) {
                C0131i c0131i = (C0131i) this.f240f.valueAt(i2);
                if (!(c0131i == null || c0131i.mLoaderManager == null)) {
                    i |= c0131i.mLoaderManager.mo104a();
                }
            }
            if (i == 0) {
                this.f255v = false;
                m450e();
            }
        }
    }

    /* renamed from: h */
    void m459h() {
        if (this.f245k != null) {
            for (int i = 0; i < this.f245k.size(); i++) {
                ((C0148b) this.f245k.get(i)).m355a();
            }
        }
    }

    /* renamed from: b */
    void m432b(C0124c c0124c) {
        if (this.f241g == null) {
            this.f241g = new ArrayList();
        }
        this.f241g.add(c0124c);
    }

    /* renamed from: a */
    boolean m429a(ArrayList<C0124c> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        if (this.f241g == null) {
            return false;
        }
        int size;
        if (str == null && i < 0 && (i2 & 1) == 0) {
            size = this.f241g.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f241g.remove(size));
            arrayList2.add(Boolean.valueOf(true));
        } else {
            int size2;
            size = -1;
            if (str != null || i >= 0) {
                C0124c c0124c;
                size2 = this.f241g.size() - 1;
                while (size2 >= 0) {
                    c0124c = (C0124c) this.f241g.get(size2);
                    if ((str != null && str.equals(c0124c.m230f())) || (i >= 0 && i == c0124c.f139n)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        c0124c = (C0124c) this.f241g.get(size2);
                        if ((str == null || !str.equals(c0124c.m230f())) && (i < 0 || i != c0124c.f139n)) {
                            break;
                        }
                        size2--;
                    }
                }
                size = size2;
            }
            if (size == this.f241g.size() - 1) {
                return false;
            }
            for (size2 = this.f241g.size() - 1; size2 > size; size2--) {
                arrayList.add(this.f241g.remove(size2));
                arrayList2.add(Boolean.valueOf(true));
            }
        }
        return true;
    }

    /* renamed from: i */
    C0163p m462i() {
        C0162o.m383a(this.f233C);
        return this.f233C;
    }

    /* renamed from: a */
    private static void m383a(C0163p c0163p) {
        if (c0163p != null) {
            List<C0131i> a = c0163p.m485a();
            if (a != null) {
                for (C0131i c0131i : a) {
                    c0131i.mRetaining = true;
                }
            }
            List<C0163p> b = c0163p.m486b();
            if (b != null) {
                for (C0163p a2 : b) {
                    C0162o.m383a(a2);
                }
            }
        }
    }

    /* renamed from: j */
    void m464j() {
        List list;
        List list2;
        if (this.f240f != null) {
            int i = 0;
            list = null;
            list2 = null;
            while (i < this.f240f.size()) {
                ArrayList arrayList;
                C0131i c0131i = (C0131i) this.f240f.valueAt(i);
                if (c0131i != null) {
                    Object obj;
                    if (c0131i.mRetainInstance) {
                        if (list2 == null) {
                            list2 = new ArrayList();
                        }
                        list2.add(c0131i);
                        c0131i.mTargetIndex = c0131i.mTarget != null ? c0131i.mTarget.mIndex : -1;
                        if (f229a) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + c0131i);
                        }
                    }
                    if (c0131i.mChildFragmentManager != null) {
                        c0131i.mChildFragmentManager.m464j();
                        obj = c0131i.mChildFragmentManager.f233C;
                    } else {
                        C0163p c0163p = c0131i.mChildNonConfig;
                    }
                    if (list == null && obj != null) {
                        list = new ArrayList(this.f240f.size());
                        for (int i2 = 0; i2 < i; i2++) {
                            list.add(null);
                        }
                    }
                    arrayList = list;
                    if (arrayList != null) {
                        arrayList.add(obj);
                    }
                } else {
                    List list3 = list;
                }
                i++;
                Object obj2 = arrayList;
            }
        } else {
            list = null;
            list2 = null;
        }
        if (list2 == null && list == null) {
            this.f233C = null;
        } else {
            this.f233C = new C0163p(list2, list);
        }
    }

    /* renamed from: m */
    void m471m(C0131i c0131i) {
        if (c0131i.mInnerView != null) {
            if (this.f231A == null) {
                this.f231A = new SparseArray();
            } else {
                this.f231A.clear();
            }
            c0131i.mInnerView.saveHierarchyState(this.f231A);
            if (this.f231A.size() > 0) {
                c0131i.mSavedViewState = this.f231A;
                this.f231A = null;
            }
        }
    }

    /* renamed from: n */
    Bundle m472n(C0131i c0131i) {
        Bundle bundle;
        if (this.f259z == null) {
            this.f259z = new Bundle();
        }
        c0131i.performSaveInstanceState(this.f259z);
        m447d(c0131i, this.f259z, false);
        if (this.f259z.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f259z;
            this.f259z = null;
        }
        if (c0131i.mView != null) {
            m471m(c0131i);
        }
        if (c0131i.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", c0131i.mSavedViewState);
        }
        if (!c0131i.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", c0131i.mUserVisibleHint);
        }
        return bundle;
    }

    /* renamed from: k */
    Parcelable m466k() {
        C0126d[] c0126dArr = null;
        m372B();
        m373C();
        m455f();
        this.f252s = true;
        this.f233C = null;
        if (this.f240f == null || this.f240f.size() <= 0) {
            return null;
        }
        int size = this.f240f.size();
        C0167r[] c0167rArr = new C0167r[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            C0131i c0131i = (C0131i) this.f240f.valueAt(i);
            if (c0131i != null) {
                if (c0131i.mIndex < 0) {
                    m385a(new IllegalStateException("Failure saving state: active " + c0131i + " has cleared index: " + c0131i.mIndex));
                }
                C0167r c0167r = new C0167r(c0131i);
                c0167rArr[i] = c0167r;
                if (c0131i.mState <= 0 || c0167r.f277k != null) {
                    c0167r.f277k = c0131i.mSavedFragmentState;
                } else {
                    c0167r.f277k = m472n(c0131i);
                    if (c0131i.mTarget != null) {
                        if (c0131i.mTarget.mIndex < 0) {
                            m385a(new IllegalStateException("Failure saving state: " + c0131i + " has target not in fragment manager: " + c0131i.mTarget));
                        }
                        if (c0167r.f277k == null) {
                            c0167r.f277k = new Bundle();
                        }
                        m413a(c0167r.f277k, "android:target_state", c0131i.mTarget);
                        if (c0131i.mTargetRequestCode != 0) {
                            c0167r.f277k.putInt("android:target_req_state", c0131i.mTargetRequestCode);
                        }
                    }
                }
                if (f229a) {
                    Log.v("FragmentManager", "Saved state of " + c0131i + ": " + c0167r.f277k);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            i = this.f239e.size();
            if (i > 0) {
                iArr = new int[i];
                for (i2 = 0; i2 < i; i2++) {
                    iArr[i2] = ((C0131i) this.f239e.get(i2)).mIndex;
                    if (iArr[i2] < 0) {
                        m385a(new IllegalStateException("Failure saving state: active " + this.f239e.get(i2) + " has cleared index: " + iArr[i2]));
                    }
                    if (f229a) {
                        Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f239e.get(i2));
                    }
                }
            } else {
                iArr = null;
            }
            if (this.f241g != null) {
                i = this.f241g.size();
                if (i > 0) {
                    c0126dArr = new C0126d[i];
                    for (i2 = 0; i2 < i; i2++) {
                        c0126dArr[i2] = new C0126d((C0124c) this.f241g.get(i2));
                        if (f229a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f241g.get(i2));
                        }
                    }
                }
            }
            C0165q c0165q = new C0165q();
            c0165q.f262a = c0167rArr;
            c0165q.f263b = iArr;
            c0165q.f264c = c0126dArr;
            if (this.f250p != null) {
                c0165q.f265d = this.f250p.mIndex;
            }
            c0165q.f266e = this.f238d;
            m464j();
            return c0165q;
        } else if (!f229a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    /* renamed from: a */
    void m414a(Parcelable parcelable, C0163p c0163p) {
        if (parcelable != null) {
            C0165q c0165q = (C0165q) parcelable;
            if (c0165q.f262a != null) {
                int size;
                C0131i c0131i;
                int i;
                List list;
                if (c0163p != null) {
                    List a = c0163p.m485a();
                    List b = c0163p.m486b();
                    if (a != null) {
                        size = a.size();
                    } else {
                        boolean z = false;
                    }
                    for (int i2 = 0; i2 < size; i2++) {
                        c0131i = (C0131i) a.get(i2);
                        if (f229a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + c0131i);
                        }
                        i = 0;
                        while (i < c0165q.f262a.length && c0165q.f262a[i].f268b != c0131i.mIndex) {
                            i++;
                        }
                        if (i == c0165q.f262a.length) {
                            m385a(new IllegalStateException("Could not find active fragment with index " + c0131i.mIndex));
                        }
                        C0167r c0167r = c0165q.f262a[i];
                        c0167r.f278l = c0131i;
                        c0131i.mSavedViewState = null;
                        c0131i.mBackStackNesting = 0;
                        c0131i.mInLayout = false;
                        c0131i.mAdded = false;
                        c0131i.mTarget = null;
                        if (c0167r.f277k != null) {
                            c0167r.f277k.setClassLoader(this.f247m.m282i().getClassLoader());
                            c0131i.mSavedViewState = c0167r.f277k.getSparseParcelableArray("android:view_state");
                            c0131i.mSavedFragmentState = c0167r.f277k;
                        }
                    }
                    list = b;
                } else {
                    list = null;
                }
                this.f240f = new SparseArray(c0165q.f262a.length);
                i = 0;
                while (i < c0165q.f262a.length) {
                    C0167r c0167r2 = c0165q.f262a[i];
                    if (c0167r2 != null) {
                        C0163p c0163p2;
                        if (list == null || i >= list.size()) {
                            c0163p2 = null;
                        } else {
                            c0163p2 = (C0163p) list.get(i);
                        }
                        c0131i = c0167r2.m491a(this.f247m, this.f248n, this.f249o, c0163p2);
                        if (f229a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i + ": " + c0131i);
                        }
                        this.f240f.put(c0131i.mIndex, c0131i);
                        c0167r2.f278l = null;
                    }
                    i++;
                }
                if (c0163p != null) {
                    List a2 = c0163p.m485a();
                    if (a2 != null) {
                        i = a2.size();
                    } else {
                        boolean z2 = false;
                    }
                    for (int i3 = 0; i3 < i; i3++) {
                        c0131i = (C0131i) a2.get(i3);
                        if (c0131i.mTargetIndex >= 0) {
                            c0131i.mTarget = (C0131i) this.f240f.get(c0131i.mTargetIndex);
                            if (c0131i.mTarget == null) {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + c0131i + " target no longer exists: " + c0131i.mTargetIndex);
                            }
                        }
                    }
                }
                this.f239e.clear();
                if (c0165q.f263b != null) {
                    for (size = 0; size < c0165q.f263b.length; size++) {
                        c0131i = (C0131i) this.f240f.get(c0165q.f263b[size]);
                        if (c0131i == null) {
                            m385a(new IllegalStateException("No instantiated fragment for index #" + c0165q.f263b[size]));
                        }
                        c0131i.mAdded = true;
                        if (f229a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + size + ": " + c0131i);
                        }
                        if (this.f239e.contains(c0131i)) {
                            throw new IllegalStateException("Already added!");
                        }
                        synchronized (this.f239e) {
                            this.f239e.add(c0131i);
                        }
                    }
                }
                if (c0165q.f264c != null) {
                    this.f241g = new ArrayList(c0165q.f264c.length);
                    for (int i4 = 0; i4 < c0165q.f264c.length; i4++) {
                        C0124c a3 = c0165q.f264c[i4].m233a(this);
                        if (f229a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i4 + " (index " + a3.f139n + "): " + a3);
                            PrintWriter printWriter = new PrintWriter(new C0243e("FragmentManager"));
                            a3.m220a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f241g.add(a3);
                        if (a3.f139n >= 0) {
                            m410a(a3.f139n, a3);
                        }
                    }
                } else {
                    this.f241g = null;
                }
                if (c0165q.f265d >= 0) {
                    this.f250p = (C0131i) this.f240f.get(c0165q.f265d);
                }
                this.f238d = c0165q.f266e;
            }
        }
    }

    /* renamed from: D */
    private void m374D() {
        if (this.f240f != null) {
            for (int size = this.f240f.size() - 1; size >= 0; size--) {
                if (this.f240f.valueAt(size) == null) {
                    this.f240f.delete(this.f240f.keyAt(size));
                }
            }
        }
    }

    /* renamed from: a */
    public void m421a(C0142m c0142m, C0134k c0134k, C0131i c0131i) {
        if (this.f247m != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f247m = c0142m;
        this.f248n = c0134k;
        this.f249o = c0131i;
    }

    /* renamed from: l */
    public void m468l() {
        this.f233C = null;
        this.f252s = false;
        int size = this.f239e.size();
        for (int i = 0; i < size; i++) {
            C0131i c0131i = (C0131i) this.f239e.get(i);
            if (c0131i != null) {
                c0131i.noteStateNotSaved();
            }
        }
    }

    /* renamed from: m */
    public void m470m() {
        this.f252s = false;
        m400e(1);
    }

    /* renamed from: n */
    public void m473n() {
        this.f252s = false;
        m400e(2);
    }

    /* renamed from: o */
    public void m474o() {
        this.f252s = false;
        m400e(4);
    }

    /* renamed from: p */
    public void m476p() {
        this.f252s = false;
        m400e(5);
    }

    /* renamed from: q */
    public void m477q() {
        m400e(4);
    }

    /* renamed from: r */
    public void m478r() {
        this.f252s = true;
        m400e(3);
    }

    /* renamed from: s */
    public void m479s() {
        m400e(2);
    }

    /* renamed from: t */
    public void m480t() {
        m400e(1);
    }

    /* renamed from: u */
    public void m481u() {
        this.f253t = true;
        m455f();
        m400e(0);
        this.f247m = null;
        this.f248n = null;
        this.f249o = null;
    }

    /* renamed from: e */
    private void m400e(int i) {
        try {
            this.f237c = true;
            m411a(i, false);
            m455f();
        } finally {
            this.f237c = false;
        }
    }

    /* renamed from: a */
    public void m424a(boolean z) {
        for (int size = this.f239e.size() - 1; size >= 0; size--) {
            C0131i c0131i = (C0131i) this.f239e.get(size);
            if (c0131i != null) {
                c0131i.performMultiWindowModeChanged(z);
            }
        }
    }

    /* renamed from: b */
    public void m438b(boolean z) {
        for (int size = this.f239e.size() - 1; size >= 0; size--) {
            C0131i c0131i = (C0131i) this.f239e.get(size);
            if (c0131i != null) {
                c0131i.performPictureInPictureModeChanged(z);
            }
        }
    }

    /* renamed from: a */
    public void m412a(Configuration configuration) {
        for (int i = 0; i < this.f239e.size(); i++) {
            C0131i c0131i = (C0131i) this.f239e.get(i);
            if (c0131i != null) {
                c0131i.performConfigurationChanged(configuration);
            }
        }
    }

    /* renamed from: v */
    public void m482v() {
        for (int i = 0; i < this.f239e.size(); i++) {
            C0131i c0131i = (C0131i) this.f239e.get(i);
            if (c0131i != null) {
                c0131i.performLowMemory();
            }
        }
    }

    /* renamed from: a */
    public boolean m427a(Menu menu, MenuInflater menuInflater) {
        int i = 0;
        ArrayList arrayList = null;
        int i2 = 0;
        boolean z = false;
        while (i2 < this.f239e.size()) {
            C0131i c0131i = (C0131i) this.f239e.get(i2);
            if (c0131i != null && c0131i.performCreateOptionsMenu(menu, menuInflater)) {
                z = true;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(c0131i);
            }
            i2++;
            z = z;
        }
        if (this.f242h != null) {
            while (i < this.f242h.size()) {
                c0131i = (C0131i) this.f242h.get(i);
                if (arrayList == null || !arrayList.contains(c0131i)) {
                    c0131i.onDestroyOptionsMenu();
                }
                i++;
            }
        }
        this.f242h = arrayList;
        return z;
    }

    /* renamed from: a */
    public boolean m426a(Menu menu) {
        boolean z = false;
        for (int i = 0; i < this.f239e.size(); i++) {
            C0131i c0131i = (C0131i) this.f239e.get(i);
            if (c0131i != null && c0131i.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    public boolean m428a(MenuItem menuItem) {
        for (int i = 0; i < this.f239e.size(); i++) {
            C0131i c0131i = (C0131i) this.f239e.get(i);
            if (c0131i != null && c0131i.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public boolean m440b(MenuItem menuItem) {
        for (int i = 0; i < this.f239e.size(); i++) {
            C0131i c0131i = (C0131i) this.f239e.get(i);
            if (c0131i != null && c0131i.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public void m437b(Menu menu) {
        for (int i = 0; i < this.f239e.size(); i++) {
            C0131i c0131i = (C0131i) this.f239e.get(i);
            if (c0131i != null) {
                c0131i.performOptionsMenuClosed(menu);
            }
        }
    }

    /* renamed from: o */
    public void m475o(C0131i c0131i) {
        if (c0131i == null || (this.f240f.get(c0131i.mIndex) == c0131i && (c0131i.mHost == null || c0131i.getFragmentManager() == this))) {
            this.f250p = c0131i;
            return;
        }
        throw new IllegalArgumentException("Fragment " + c0131i + " is not an active fragment of FragmentManager " + this);
    }

    /* renamed from: w */
    public C0131i m483w() {
        return this.f250p;
    }

    /* renamed from: a */
    void m417a(C0131i c0131i, Context context, boolean z) {
        if (this.f249o != null) {
            C0149n fragmentManager = this.f249o.getFragmentManager();
            if (fragmentManager instanceof C0162o) {
                ((C0162o) fragmentManager).m417a(c0131i, context, true);
            }
        }
        Iterator it = this.f235I.iterator();
        while (it.hasNext()) {
            C0250h c0250h = (C0250h) it.next();
            if (!z || ((Boolean) c0250h.f498b).booleanValue()) {
                ((C0147a) c0250h.f497a).m342a((C0149n) this, c0131i, context);
            }
        }
    }

    /* renamed from: b */
    void m434b(C0131i c0131i, Context context, boolean z) {
        if (this.f249o != null) {
            C0149n fragmentManager = this.f249o.getFragmentManager();
            if (fragmentManager instanceof C0162o) {
                ((C0162o) fragmentManager).m434b(c0131i, context, true);
            }
        }
        Iterator it = this.f235I.iterator();
        while (it.hasNext()) {
            C0250h c0250h = (C0250h) it.next();
            if (!z || ((Boolean) c0250h.f498b).booleanValue()) {
                ((C0147a) c0250h.f497a).m346b((C0149n) this, c0131i, context);
            }
        }
    }

    /* renamed from: a */
    void m418a(C0131i c0131i, Bundle bundle, boolean z) {
        if (this.f249o != null) {
            C0149n fragmentManager = this.f249o.getFragmentManager();
            if (fragmentManager instanceof C0162o) {
                ((C0162o) fragmentManager).m418a(c0131i, bundle, true);
            }
        }
        Iterator it = this.f235I.iterator();
        while (it.hasNext()) {
            C0250h c0250h = (C0250h) it.next();
            if (!z || ((Boolean) c0250h.f498b).booleanValue()) {
                ((C0147a) c0250h.f497a).m343a((C0149n) this, c0131i, bundle);
            }
        }
    }

    /* renamed from: b */
    void m435b(C0131i c0131i, Bundle bundle, boolean z) {
        if (this.f249o != null) {
            C0149n fragmentManager = this.f249o.getFragmentManager();
            if (fragmentManager instanceof C0162o) {
                ((C0162o) fragmentManager).m435b(c0131i, bundle, true);
            }
        }
        Iterator it = this.f235I.iterator();
        while (it.hasNext()) {
            C0250h c0250h = (C0250h) it.next();
            if (!z || ((Boolean) c0250h.f498b).booleanValue()) {
                ((C0147a) c0250h.f497a).m347b((C0149n) this, c0131i, bundle);
            }
        }
    }

    /* renamed from: c */
    void m444c(C0131i c0131i, Bundle bundle, boolean z) {
        if (this.f249o != null) {
            C0149n fragmentManager = this.f249o.getFragmentManager();
            if (fragmentManager instanceof C0162o) {
                ((C0162o) fragmentManager).m444c(c0131i, bundle, true);
            }
        }
        Iterator it = this.f235I.iterator();
        while (it.hasNext()) {
            C0250h c0250h = (C0250h) it.next();
            if (!z || ((Boolean) c0250h.f498b).booleanValue()) {
                ((C0147a) c0250h.f497a).m349c(this, c0131i, bundle);
            }
        }
    }

    /* renamed from: a */
    void m419a(C0131i c0131i, View view, Bundle bundle, boolean z) {
        if (this.f249o != null) {
            C0149n fragmentManager = this.f249o.getFragmentManager();
            if (fragmentManager instanceof C0162o) {
                ((C0162o) fragmentManager).m419a(c0131i, view, bundle, true);
            }
        }
        Iterator it = this.f235I.iterator();
        while (it.hasNext()) {
            C0250h c0250h = (C0250h) it.next();
            if (!z || ((Boolean) c0250h.f498b).booleanValue()) {
                ((C0147a) c0250h.f497a).m344a(this, c0131i, view, bundle);
            }
        }
    }

    /* renamed from: b */
    void m436b(C0131i c0131i, boolean z) {
        if (this.f249o != null) {
            C0149n fragmentManager = this.f249o.getFragmentManager();
            if (fragmentManager instanceof C0162o) {
                ((C0162o) fragmentManager).m436b(c0131i, true);
            }
        }
        Iterator it = this.f235I.iterator();
        while (it.hasNext()) {
            C0250h c0250h = (C0250h) it.next();
            if (!z || ((Boolean) c0250h.f498b).booleanValue()) {
                ((C0147a) c0250h.f497a).m341a(this, c0131i);
            }
        }
    }

    /* renamed from: c */
    void m445c(C0131i c0131i, boolean z) {
        if (this.f249o != null) {
            C0149n fragmentManager = this.f249o.getFragmentManager();
            if (fragmentManager instanceof C0162o) {
                ((C0162o) fragmentManager).m445c(c0131i, true);
            }
        }
        Iterator it = this.f235I.iterator();
        while (it.hasNext()) {
            C0250h c0250h = (C0250h) it.next();
            if (!z || ((Boolean) c0250h.f498b).booleanValue()) {
                ((C0147a) c0250h.f497a).m345b(this, c0131i);
            }
        }
    }

    /* renamed from: d */
    void m448d(C0131i c0131i, boolean z) {
        if (this.f249o != null) {
            C0149n fragmentManager = this.f249o.getFragmentManager();
            if (fragmentManager instanceof C0162o) {
                ((C0162o) fragmentManager).m448d(c0131i, true);
            }
        }
        Iterator it = this.f235I.iterator();
        while (it.hasNext()) {
            C0250h c0250h = (C0250h) it.next();
            if (!z || ((Boolean) c0250h.f498b).booleanValue()) {
                ((C0147a) c0250h.f497a).m348c(this, c0131i);
            }
        }
    }

    /* renamed from: e */
    void m452e(C0131i c0131i, boolean z) {
        if (this.f249o != null) {
            C0149n fragmentManager = this.f249o.getFragmentManager();
            if (fragmentManager instanceof C0162o) {
                ((C0162o) fragmentManager).m452e(c0131i, true);
            }
        }
        Iterator it = this.f235I.iterator();
        while (it.hasNext()) {
            C0250h c0250h = (C0250h) it.next();
            if (!z || ((Boolean) c0250h.f498b).booleanValue()) {
                ((C0147a) c0250h.f497a).m350d(this, c0131i);
            }
        }
    }

    /* renamed from: d */
    void m447d(C0131i c0131i, Bundle bundle, boolean z) {
        if (this.f249o != null) {
            C0149n fragmentManager = this.f249o.getFragmentManager();
            if (fragmentManager instanceof C0162o) {
                ((C0162o) fragmentManager).m447d(c0131i, bundle, true);
            }
        }
        Iterator it = this.f235I.iterator();
        while (it.hasNext()) {
            C0250h c0250h = (C0250h) it.next();
            if (!z || ((Boolean) c0250h.f498b).booleanValue()) {
                ((C0147a) c0250h.f497a).m351d(this, c0131i, bundle);
            }
        }
    }

    /* renamed from: f */
    void m454f(C0131i c0131i, boolean z) {
        if (this.f249o != null) {
            C0149n fragmentManager = this.f249o.getFragmentManager();
            if (fragmentManager instanceof C0162o) {
                ((C0162o) fragmentManager).m454f(c0131i, true);
            }
        }
        Iterator it = this.f235I.iterator();
        while (it.hasNext()) {
            C0250h c0250h = (C0250h) it.next();
            if (!z || ((Boolean) c0250h.f498b).booleanValue()) {
                ((C0147a) c0250h.f497a).m352e(this, c0131i);
            }
        }
    }

    /* renamed from: g */
    void m458g(C0131i c0131i, boolean z) {
        if (this.f249o != null) {
            C0149n fragmentManager = this.f249o.getFragmentManager();
            if (fragmentManager instanceof C0162o) {
                ((C0162o) fragmentManager).m458g(c0131i, true);
            }
        }
        Iterator it = this.f235I.iterator();
        while (it.hasNext()) {
            C0250h c0250h = (C0250h) it.next();
            if (!z || ((Boolean) c0250h.f498b).booleanValue()) {
                ((C0147a) c0250h.f497a).m353f(this, c0131i);
            }
        }
    }

    /* renamed from: h */
    void m461h(C0131i c0131i, boolean z) {
        if (this.f249o != null) {
            C0149n fragmentManager = this.f249o.getFragmentManager();
            if (fragmentManager instanceof C0162o) {
                ((C0162o) fragmentManager).m461h(c0131i, true);
            }
        }
        Iterator it = this.f235I.iterator();
        while (it.hasNext()) {
            C0250h c0250h = (C0250h) it.next();
            if (!z || ((Boolean) c0250h.f498b).booleanValue()) {
                ((C0147a) c0250h.f497a).m354g(this, c0131i);
            }
        }
    }

    /* renamed from: d */
    public static int m399d(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    /* renamed from: b */
    public static int m392b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String string;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0159e.f217a);
        if (attributeValue == null) {
            string = obtainStyledAttributes.getString(0);
        } else {
            string = attributeValue;
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!C0131i.isSupportFragmentClass(this.f247m.m282i(), string)) {
            return null;
        }
        int id;
        if (view != null) {
            id = view.getId();
        } else {
            id = 0;
        }
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        C0131i c0131i;
        C0131i b = resourceId != -1 ? m430b(resourceId) : null;
        if (b == null && string2 != null) {
            b = mo97a(string2);
        }
        if (b == null && id != -1) {
            b = m430b(id);
        }
        if (f229a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + b);
        }
        if (b == null) {
            C0131i a = this.f248n.mo69a(context, string, null);
            a.mFromLayout = true;
            a.mFragmentId = resourceId != 0 ? resourceId : id;
            a.mContainerId = id;
            a.mTag = string2;
            a.mInLayout = true;
            a.mFragmentManager = this;
            a.mHost = this.f247m;
            a.onInflate(this.f247m.m282i(), attributeSet, a.mSavedFragmentState);
            m420a(a, true);
            c0131i = a;
        } else if (b.mInLayout) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            b.mInLayout = true;
            b.mHost = this.f247m;
            if (!b.mRetaining) {
                b.onInflate(this.f247m.m282i(), attributeSet, b.mSavedFragmentState);
            }
            c0131i = b;
        }
        if (this.f246l >= 1 || !c0131i.mFromLayout) {
            m433b(c0131i);
        } else {
            m416a(c0131i, 1, 0, 0, false);
        }
        if (c0131i.mView == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            c0131i.mView.setId(resourceId);
        }
        if (c0131i.mView.getTag() == null) {
            c0131i.mView.setTag(string2);
        }
        return c0131i.mView;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* renamed from: x */
    Factory2 m484x() {
        return this;
    }
}
