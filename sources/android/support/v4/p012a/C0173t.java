package android.support.v4.p012a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.p012a.C0124c.C0121a;
import android.support.v4.p017e.C0238a;
import android.support.v4.p018f.C0265b;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* renamed from: android.support.v4.a.t */
class C0173t {
    /* renamed from: a */
    private static final int[] f310a = new int[]{0, 3, 0, 1, 5, 4, 7, 6, 9, 8};

    /* renamed from: android.support.v4.a.t$a */
    static class C0172a {
        /* renamed from: a */
        public C0131i f304a;
        /* renamed from: b */
        public boolean f305b;
        /* renamed from: c */
        public C0124c f306c;
        /* renamed from: d */
        public C0131i f307d;
        /* renamed from: e */
        public boolean f308e;
        /* renamed from: f */
        public C0124c f309f;

        C0172a() {
        }
    }

    /* renamed from: a */
    static void m506a(C0162o c0162o, ArrayList<C0124c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (c0162o.f246l >= 1 && VERSION.SDK_INT >= 21) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                C0124c c0124c = (C0124c) arrayList.get(i3);
                if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                    C0173t.m518b(c0124c, sparseArray, z);
                } else {
                    C0173t.m503a(c0124c, sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(c0162o.f247m.m282i());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    C0238a a = C0173t.m493a(keyAt, (ArrayList) arrayList, (ArrayList) arrayList2, i, i2);
                    C0172a c0172a = (C0172a) sparseArray.valueAt(i4);
                    if (z) {
                        C0173t.m505a(c0162o, keyAt, c0172a, view, a);
                    } else {
                        C0173t.m520b(c0162o, keyAt, c0172a, view, a);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static C0238a<String, String> m493a(int i, ArrayList<C0124c> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        C0238a<String, String> c0238a = new C0238a();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            C0124c c0124c = (C0124c) arrayList.get(i4);
            if (c0124c.m226b(i)) {
                boolean booleanValue = ((Boolean) arrayList2.get(i4)).booleanValue();
                if (c0124c.f144s != null) {
                    ArrayList arrayList3;
                    ArrayList arrayList4;
                    int size = c0124c.f144s.size();
                    if (booleanValue) {
                        arrayList3 = c0124c.f144s;
                        arrayList4 = c0124c.f145t;
                    } else {
                        ArrayList arrayList5 = c0124c.f144s;
                        arrayList3 = c0124c.f145t;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = (String) arrayList4.get(i5);
                        String str2 = (String) arrayList3.get(i5);
                        String str3 = (String) c0238a.remove(str2);
                        if (str3 != null) {
                            c0238a.put(str, str3);
                        } else {
                            c0238a.put(str, str2);
                        }
                    }
                }
            }
        }
        return c0238a;
    }

    /* renamed from: a */
    private static void m505a(C0162o c0162o, int i, C0172a c0172a, View view, C0238a<String, String> c0238a) {
        ViewGroup viewGroup = null;
        if (c0162o.f248n.mo71a()) {
            viewGroup = (ViewGroup) c0162o.f248n.mo70a(i);
        }
        if (viewGroup != null) {
            C0131i c0131i = c0172a.f304a;
            C0131i c0131i2 = c0172a.f307d;
            boolean z = c0172a.f305b;
            boolean z2 = c0172a.f308e;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object a = C0173t.m497a(c0131i, z);
            Object b = C0173t.m515b(c0131i2, z2);
            Object a2 = C0173t.m498a(viewGroup, view, (C0238a) c0238a, c0172a, arrayList2, arrayList, a, b);
            if (a != null || a2 != null || b != null) {
                ArrayList b2 = C0173t.m517b(b, c0131i2, arrayList2, view);
                ArrayList b3 = C0173t.m517b(a, c0131i, arrayList, view);
                C0173t.m521b(b3, 4);
                Object a3 = C0173t.m499a(a, b, a2, c0131i, z);
                if (a3 != null) {
                    C0173t.m509a(b, c0131i2, b2);
                    ArrayList a4 = C0181u.m526a(arrayList);
                    C0181u.m535a(a3, a, b3, b, b2, a2, arrayList);
                    C0181u.m530a(viewGroup, a3);
                    C0181u.m528a(viewGroup, arrayList2, arrayList, a4, c0238a);
                    C0173t.m521b(b3, 0);
                    C0181u.m537a(a2, arrayList2, arrayList);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m509a(Object obj, C0131i c0131i, final ArrayList<View> arrayList) {
        if (c0131i != null && obj != null && c0131i.mAdded && c0131i.mHidden && c0131i.mHiddenChanged) {
            c0131i.setHideReplaced(true);
            C0181u.m548b(obj, c0131i.getView(), (ArrayList) arrayList);
            ai.m177a(c0131i.mContainer, new Runnable() {
                public void run() {
                    C0173t.m521b(arrayList, 4);
                }
            });
        }
    }

    /* renamed from: b */
    private static void m520b(C0162o c0162o, int i, C0172a c0172a, View view, C0238a<String, String> c0238a) {
        ViewGroup viewGroup = null;
        if (c0162o.f248n.mo71a()) {
            viewGroup = (ViewGroup) c0162o.f248n.mo70a(i);
        }
        if (viewGroup != null) {
            C0131i c0131i = c0172a.f304a;
            C0131i c0131i2 = c0172a.f307d;
            boolean z = c0172a.f305b;
            boolean z2 = c0172a.f308e;
            Object a = C0173t.m497a(c0131i, z);
            Object b = C0173t.m515b(c0131i2, z2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object b2 = C0173t.m516b(viewGroup, view, c0238a, c0172a, arrayList, arrayList2, a, b);
            if (a != null || b2 != null || b != null) {
                Object obj;
                ArrayList b3 = C0173t.m517b(b, c0131i2, arrayList, view);
                if (b3 == null || b3.isEmpty()) {
                    obj = null;
                } else {
                    obj = b;
                }
                C0181u.m547b(a, view);
                b = C0173t.m499a(a, obj, b2, c0131i, c0172a.f305b);
                if (b != null) {
                    ArrayList arrayList3 = new ArrayList();
                    C0181u.m535a(b, a, arrayList3, obj, b3, b2, arrayList2);
                    C0173t.m508a(viewGroup, c0131i, view, arrayList2, a, arrayList3, obj, b3);
                    C0181u.m529a((View) viewGroup, arrayList2, (Map) c0238a);
                    C0181u.m530a(viewGroup, b);
                    C0181u.m531a(viewGroup, arrayList2, (Map) c0238a);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m508a(ViewGroup viewGroup, C0131i c0131i, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        final Object obj3 = obj;
        final View view2 = view;
        final C0131i c0131i2 = c0131i;
        final ArrayList<View> arrayList4 = arrayList;
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<View> arrayList6 = arrayList3;
        final Object obj4 = obj2;
        ai.m177a(viewGroup, new Runnable() {
            public void run() {
                if (obj3 != null) {
                    C0181u.m550c(obj3, view2);
                    arrayList5.addAll(C0173t.m517b(obj3, c0131i2, arrayList4, view2));
                }
                if (arrayList6 != null) {
                    if (obj4 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(view2);
                        C0181u.m549b(obj4, arrayList6, arrayList);
                    }
                    arrayList6.clear();
                    arrayList6.add(view2);
                }
            }
        });
    }

    /* renamed from: a */
    private static Object m496a(C0131i c0131i, C0131i c0131i2, boolean z) {
        if (c0131i == null || c0131i2 == null) {
            return null;
        }
        Object sharedElementReturnTransition;
        if (z) {
            sharedElementReturnTransition = c0131i2.getSharedElementReturnTransition();
        } else {
            sharedElementReturnTransition = c0131i.getSharedElementEnterTransition();
        }
        return C0181u.m544b(C0181u.m523a(sharedElementReturnTransition));
    }

    /* renamed from: a */
    private static Object m497a(C0131i c0131i, boolean z) {
        if (c0131i == null) {
            return null;
        }
        Object reenterTransition;
        if (z) {
            reenterTransition = c0131i.getReenterTransition();
        } else {
            reenterTransition = c0131i.getEnterTransition();
        }
        return C0181u.m523a(reenterTransition);
    }

    /* renamed from: b */
    private static Object m515b(C0131i c0131i, boolean z) {
        if (c0131i == null) {
            return null;
        }
        Object returnTransition;
        if (z) {
            returnTransition = c0131i.getReturnTransition();
        } else {
            returnTransition = c0131i.getExitTransition();
        }
        return C0181u.m523a(returnTransition);
    }

    /* renamed from: a */
    private static Object m498a(ViewGroup viewGroup, View view, C0238a<String, String> c0238a, C0172a c0172a, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        final C0131i c0131i = c0172a.f304a;
        final C0131i c0131i2 = c0172a.f307d;
        if (c0131i != null) {
            c0131i.getView().setVisibility(0);
        }
        if (c0131i == null || c0131i2 == null) {
            return null;
        }
        Object obj3;
        Object obj4;
        final boolean z = c0172a.f305b;
        if (c0238a.isEmpty()) {
            obj3 = null;
        } else {
            obj3 = C0173t.m496a(c0131i, c0131i2, z);
        }
        C0238a b = C0173t.m513b((C0238a) c0238a, obj3, c0172a);
        final C0238a c = C0173t.m522c(c0238a, obj3, c0172a);
        if (c0238a.isEmpty()) {
            obj4 = null;
            if (b != null) {
                b.clear();
            }
            if (c != null) {
                c.clear();
            }
        } else {
            C0173t.m512a((ArrayList) arrayList, b, c0238a.keySet());
            C0173t.m512a((ArrayList) arrayList2, c, c0238a.values());
            obj4 = obj3;
        }
        if (obj == null && obj2 == null && obj4 == null) {
            return null;
        }
        Rect rect;
        View b2;
        C0173t.m519b(c0131i, c0131i2, z, b, true);
        if (obj4 != null) {
            arrayList2.add(view);
            C0181u.m534a(obj4, view, (ArrayList) arrayList);
            C0173t.m510a(obj4, obj2, b, c0172a.f308e, c0172a.f309f);
            rect = new Rect();
            b2 = C0173t.m514b(c, c0172a, obj, z);
            if (b2 != null) {
                C0181u.m532a(obj, rect);
            }
        } else {
            rect = null;
            b2 = null;
        }
        ai.m177a(viewGroup, new Runnable() {
            public void run() {
                C0173t.m519b(c0131i, c0131i2, z, c, false);
                if (b2 != null) {
                    C0181u.m527a(b2, rect);
                }
            }
        });
        return obj4;
    }

    /* renamed from: a */
    private static void m512a(ArrayList<View> arrayList, C0238a<String, View> c0238a, Collection<String> collection) {
        for (int size = c0238a.size() - 1; size >= 0; size--) {
            View view = (View) c0238a.m723c(size);
            if (collection.contains(C0265b.m776a(view))) {
                arrayList.add(view);
            }
        }
    }

    /* renamed from: b */
    private static Object m516b(ViewGroup viewGroup, View view, C0238a<String, String> c0238a, C0172a c0172a, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        final C0131i c0131i = c0172a.f304a;
        final C0131i c0131i2 = c0172a.f307d;
        if (c0131i == null || c0131i2 == null) {
            return null;
        }
        Object obj3;
        Object obj4;
        final boolean z = c0172a.f305b;
        if (c0238a.isEmpty()) {
            obj3 = null;
        } else {
            obj3 = C0173t.m496a(c0131i, c0131i2, z);
        }
        C0238a b = C0173t.m513b((C0238a) c0238a, obj3, c0172a);
        if (c0238a.isEmpty()) {
            obj4 = null;
        } else {
            arrayList.addAll(b.values());
            obj4 = obj3;
        }
        if (obj == null && obj2 == null && obj4 == null) {
            return null;
        }
        Rect rect;
        C0173t.m519b(c0131i, c0131i2, z, b, true);
        if (obj4 != null) {
            rect = new Rect();
            C0181u.m534a(obj4, view, (ArrayList) arrayList);
            C0173t.m510a(obj4, obj2, b, c0172a.f308e, c0172a.f309f);
            if (obj != null) {
                C0181u.m532a(obj, rect);
            }
        } else {
            rect = null;
        }
        final C0238a<String, String> c0238a2 = c0238a;
        final C0172a c0172a2 = c0172a;
        final ArrayList<View> arrayList3 = arrayList2;
        final View view2 = view;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj5 = obj;
        ai.m177a(viewGroup, new Runnable() {
            public void run() {
                C0238a a = C0173t.m522c(c0238a2, obj4, c0172a2);
                if (a != null) {
                    arrayList3.addAll(a.values());
                    arrayList3.add(view2);
                }
                C0173t.m519b(c0131i, c0131i2, z, a, false);
                if (obj4 != null) {
                    C0181u.m537a(obj4, arrayList4, arrayList3);
                    View a2 = C0173t.m514b(a, c0172a2, obj5, z);
                    if (a2 != null) {
                        C0181u.m527a(a2, rect);
                    }
                }
            }
        });
        return obj4;
    }

    /* renamed from: b */
    private static C0238a<String, View> m513b(C0238a<String, String> c0238a, Object obj, C0172a c0172a) {
        if (c0238a.isEmpty() || obj == null) {
            c0238a.clear();
            return null;
        }
        an enterTransitionCallback;
        List list;
        C0131i c0131i = c0172a.f307d;
        Map c0238a2 = new C0238a();
        C0181u.m540a(c0238a2, c0131i.getView());
        C0124c c0124c = c0172a.f309f;
        if (c0172a.f308e) {
            enterTransitionCallback = c0131i.getEnterTransitionCallback();
            list = c0124c.f145t;
        } else {
            enterTransitionCallback = c0131i.getExitTransitionCallback();
            Object obj2 = c0124c.f144s;
        }
        c0238a2.m726a(list);
        if (enterTransitionCallback != null) {
            enterTransitionCallback.m200a(list, c0238a2);
            for (int size = list.size() - 1; size >= 0; size--) {
                String str = (String) list.get(size);
                View view = (View) c0238a2.get(str);
                if (view == null) {
                    c0238a.remove(str);
                } else if (!str.equals(C0265b.m776a(view))) {
                    c0238a.put(C0265b.m776a(view), (String) c0238a.remove(str));
                }
            }
        } else {
            c0238a.m726a(c0238a2.keySet());
        }
        return c0238a2;
    }

    /* renamed from: c */
    private static C0238a<String, View> m522c(C0238a<String, String> c0238a, Object obj, C0172a c0172a) {
        C0131i c0131i = c0172a.f304a;
        View view = c0131i.getView();
        if (c0238a.isEmpty() || obj == null || view == null) {
            c0238a.clear();
            return null;
        }
        an exitTransitionCallback;
        C0238a<String, View> c0238a2 = new C0238a();
        C0181u.m540a((Map) c0238a2, view);
        C0124c c0124c = c0172a.f306c;
        if (c0172a.f305b) {
            exitTransitionCallback = c0131i.getExitTransitionCallback();
            List list = c0124c.f144s;
        } else {
            exitTransitionCallback = c0131i.getEnterTransitionCallback();
            Object obj2 = c0124c.f145t;
        }
        if (list != null) {
            c0238a2.m726a(list);
        }
        if (exitTransitionCallback != null) {
            exitTransitionCallback.m200a(list, (Map) c0238a2);
            for (int size = list.size() - 1; size >= 0; size--) {
                String str = (String) list.get(size);
                view = (View) c0238a2.get(str);
                if (view == null) {
                    str = C0173t.m500a((C0238a) c0238a, str);
                    if (str != null) {
                        c0238a.remove(str);
                    }
                } else if (!str.equals(C0265b.m776a(view))) {
                    str = C0173t.m500a((C0238a) c0238a, str);
                    if (str != null) {
                        c0238a.put(str, C0265b.m776a(view));
                    }
                }
            }
        } else {
            C0173t.m507a((C0238a) c0238a, (C0238a) c0238a2);
        }
        return c0238a2;
    }

    /* renamed from: a */
    private static String m500a(C0238a<String, String> c0238a, String str) {
        int size = c0238a.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(c0238a.m723c(i))) {
                return (String) c0238a.m722b(i);
            }
        }
        return null;
    }

    /* renamed from: b */
    private static View m514b(C0238a<String, View> c0238a, C0172a c0172a, Object obj, boolean z) {
        C0124c c0124c = c0172a.f306c;
        if (obj == null || c0238a == null || c0124c.f144s == null || c0124c.f144s.isEmpty()) {
            return null;
        }
        Object obj2;
        if (z) {
            obj2 = (String) c0124c.f144s.get(0);
        } else {
            String str = (String) c0124c.f145t.get(0);
        }
        return (View) c0238a.get(obj2);
    }

    /* renamed from: a */
    private static void m510a(Object obj, Object obj2, C0238a<String, View> c0238a, boolean z, C0124c c0124c) {
        if (c0124c.f144s != null && !c0124c.f144s.isEmpty()) {
            Object obj3;
            if (z) {
                obj3 = (String) c0124c.f145t.get(0);
            } else {
                String str = (String) c0124c.f144s.get(0);
            }
            View view = (View) c0238a.get(obj3);
            C0181u.m533a(obj, view);
            if (obj2 != null) {
                C0181u.m533a(obj2, view);
            }
        }
    }

    /* renamed from: a */
    private static void m507a(C0238a<String, String> c0238a, C0238a<String, View> c0238a2) {
        for (int size = c0238a.size() - 1; size >= 0; size--) {
            if (!c0238a2.containsKey((String) c0238a.m723c(size))) {
                c0238a.m724d(size);
            }
        }
    }

    /* renamed from: b */
    private static void m519b(C0131i c0131i, C0131i c0131i2, boolean z, C0238a<String, View> c0238a, boolean z2) {
        an enterTransitionCallback;
        int i = 0;
        if (z) {
            enterTransitionCallback = c0131i2.getEnterTransitionCallback();
        } else {
            enterTransitionCallback = c0131i.getEnterTransitionCallback();
        }
        if (enterTransitionCallback != null) {
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            int size = c0238a == null ? 0 : c0238a.size();
            while (i < size) {
                arrayList2.add(c0238a.m722b(i));
                arrayList.add(c0238a.m723c(i));
                i++;
            }
            if (z2) {
                enterTransitionCallback.m199a(arrayList2, arrayList, null);
            } else {
                enterTransitionCallback.m201b(arrayList2, arrayList, null);
            }
        }
    }

    /* renamed from: b */
    private static ArrayList<View> m517b(Object obj, C0131i c0131i, ArrayList<View> arrayList, View view) {
        ArrayList<View> arrayList2 = null;
        if (obj != null) {
            arrayList2 = new ArrayList();
            View view2 = c0131i.getView();
            if (view2 != null) {
                C0181u.m538a((ArrayList) arrayList2, view2);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (!arrayList2.isEmpty()) {
                arrayList2.add(view);
                C0181u.m536a(obj, (ArrayList) arrayList2);
            }
        }
        return arrayList2;
    }

    /* renamed from: b */
    private static void m521b(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((View) arrayList.get(size)).setVisibility(i);
            }
        }
    }

    /* renamed from: a */
    private static Object m499a(Object obj, Object obj2, Object obj3, C0131i c0131i, boolean z) {
        boolean z2 = true;
        if (!(obj == null || obj2 == null || c0131i == null)) {
            z2 = z ? c0131i.getAllowReturnTransitionOverlap() : c0131i.getAllowEnterTransitionOverlap();
        }
        if (z2) {
            return C0181u.m524a(obj2, obj, obj3);
        }
        return C0181u.m545b(obj2, obj, obj3);
    }

    /* renamed from: a */
    public static void m503a(C0124c c0124c, SparseArray<C0172a> sparseArray, boolean z) {
        int size = c0124c.f128c.size();
        for (int i = 0; i < size; i++) {
            C0173t.m502a(c0124c, (C0121a) c0124c.f128c.get(i), (SparseArray) sparseArray, false, z);
        }
    }

    /* renamed from: b */
    public static void m518b(C0124c c0124c, SparseArray<C0172a> sparseArray, boolean z) {
        if (c0124c.f127b.f248n.mo71a()) {
            for (int size = c0124c.f128c.size() - 1; size >= 0; size--) {
                C0173t.m502a(c0124c, (C0121a) c0124c.f128c.get(size), (SparseArray) sparseArray, true, z);
            }
        }
    }

    /* renamed from: a */
    private static void m502a(C0124c c0124c, C0121a c0121a, SparseArray<C0172a> sparseArray, boolean z, boolean z2) {
        C0131i c0131i = c0121a.f121b;
        if (c0131i != null) {
            int i = c0131i.mContainerId;
            if (i != 0) {
                int i2;
                int i3;
                C0172a a;
                boolean z3;
                int i4;
                int i5;
                boolean z4;
                int i6;
                switch (z ? f310a[c0121a.f120a] : c0121a.f120a) {
                    case 1:
                    case 7:
                        z3 = z2 ? c0131i.mIsNewlyAdded : (c0131i.mAdded || c0131i.mHidden) ? false : true;
                        i4 = 1;
                        i2 = 0;
                        i5 = 0;
                        z4 = z3;
                        break;
                    case 3:
                    case 6:
                        i6 = z2 ? (c0131i.mAdded || c0131i.mView == null || c0131i.mView.getVisibility() != 0 || c0131i.mPostponedAlpha < 0.0f) ? 0 : 1 : (!c0131i.mAdded || c0131i.mHidden) ? 0 : 1;
                        i4 = 0;
                        i2 = i6;
                        i5 = 1;
                        i3 = 0;
                        break;
                    case 4:
                        i6 = z2 ? (c0131i.mHiddenChanged && c0131i.mAdded && c0131i.mHidden) ? 1 : 0 : (!c0131i.mAdded || c0131i.mHidden) ? 0 : 1;
                        i4 = 0;
                        i2 = i6;
                        i5 = 1;
                        i3 = 0;
                        break;
                    case 5:
                        z3 = z2 ? c0131i.mHiddenChanged && !c0131i.mHidden && c0131i.mAdded : c0131i.mHidden;
                        i4 = 1;
                        i2 = 0;
                        i5 = 0;
                        z4 = z3;
                        break;
                    default:
                        i4 = 0;
                        i2 = 0;
                        i5 = 0;
                        i3 = 0;
                        break;
                }
                C0172a c0172a = (C0172a) sparseArray.get(i);
                if (i3 != 0) {
                    a = C0173t.m492a(c0172a, (SparseArray) sparseArray, i);
                    a.f304a = c0131i;
                    a.f305b = z;
                    a.f306c = c0124c;
                } else {
                    a = c0172a;
                }
                if (!(z2 || r4 == 0)) {
                    if (a != null && a.f307d == c0131i) {
                        a.f307d = null;
                    }
                    C0162o c0162o = c0124c.f127b;
                    if (c0131i.mState < 1 && c0162o.f246l >= 1 && !c0124c.f146u) {
                        c0162o.m453f(c0131i);
                        c0162o.m416a(c0131i, 1, 0, 0, false);
                    }
                }
                if (i2 == 0 || !(a == null || a.f307d == null)) {
                    c0172a = a;
                } else {
                    c0172a = C0173t.m492a(a, (SparseArray) sparseArray, i);
                    c0172a.f307d = c0131i;
                    c0172a.f308e = z;
                    c0172a.f309f = c0124c;
                }
                if (!z2 && r7 != 0 && c0172a != null && c0172a.f304a == c0131i) {
                    c0172a.f304a = null;
                }
            }
        }
    }

    /* renamed from: a */
    private static C0172a m492a(C0172a c0172a, SparseArray<C0172a> sparseArray, int i) {
        if (c0172a != null) {
            return c0172a;
        }
        c0172a = new C0172a();
        sparseArray.put(i, c0172a);
        return c0172a;
    }
}
