package android.arch.lifecycle;

import android.arch.lifecycle.C0078b.C0076a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class ReflectiveGenericLifecycleObserver implements C0075a {
    /* renamed from: a */
    static final Map<Class, C0073a> f46a = new HashMap();
    /* renamed from: b */
    private final Object f47b;
    /* renamed from: c */
    private final C0073a f48c = m91a(this.f47b.getClass());

    /* renamed from: android.arch.lifecycle.ReflectiveGenericLifecycleObserver$a */
    static class C0073a {
        /* renamed from: a */
        final Map<C0076a, List<C0074b>> f42a = new HashMap();
        /* renamed from: b */
        final Map<C0074b, C0076a> f43b;

        C0073a(Map<C0074b, C0076a> map) {
            this.f43b = map;
            for (Entry entry : map.entrySet()) {
                C0076a c0076a = (C0076a) entry.getValue();
                List list = (List) this.f42a.get(c0076a);
                if (list == null) {
                    list = new ArrayList();
                    this.f42a.put(c0076a, list);
                }
                list.add(entry.getKey());
            }
        }
    }

    /* renamed from: android.arch.lifecycle.ReflectiveGenericLifecycleObserver$b */
    static class C0074b {
        /* renamed from: a */
        final int f44a;
        /* renamed from: b */
        final Method f45b;

        C0074b(int i, Method method) {
            this.f44a = i;
            this.f45b = method;
            this.f45b.setAccessible(true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0074b c0074b = (C0074b) obj;
            if (this.f44a == c0074b.f44a && this.f45b.getName().equals(c0074b.f45b.getName())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f44a * 31) + this.f45b.getName().hashCode();
        }
    }

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f47b = obj;
    }

    /* renamed from: a */
    public void mo9a(C0079c c0079c, C0076a c0076a) {
        m92a(this.f48c, c0079c, c0076a);
    }

    /* renamed from: a */
    private void m94a(List<C0074b> list, C0079c c0079c, C0076a c0076a) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                m93a((C0074b) list.get(size), c0079c, c0076a);
            }
        }
    }

    /* renamed from: a */
    private void m92a(C0073a c0073a, C0079c c0079c, C0076a c0076a) {
        m94a((List) c0073a.f42a.get(c0076a), c0079c, c0076a);
        m94a((List) c0073a.f42a.get(C0076a.ON_ANY), c0079c, c0076a);
    }

    /* renamed from: a */
    private void m93a(C0074b c0074b, C0079c c0079c, C0076a c0076a) {
        try {
            switch (c0074b.f44a) {
                case 0:
                    c0074b.f45b.invoke(this.f47b, new Object[0]);
                    return;
                case 1:
                    c0074b.f45b.invoke(this.f47b, new Object[]{c0079c});
                    return;
                case 2:
                    c0074b.f45b.invoke(this.f47b, new Object[]{c0079c, c0076a});
                    return;
                default:
                    return;
            }
        } catch (InvocationTargetException e) {
            throw new RuntimeException("Failed to call observer method", e.getCause());
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: a */
    private static C0073a m91a(Class cls) {
        C0073a c0073a = (C0073a) f46a.get(cls);
        if (c0073a != null) {
            return c0073a;
        }
        return m96b(cls);
    }

    /* renamed from: a */
    private static void m95a(Map<C0074b, C0076a> map, C0074b c0074b, C0076a c0076a, Class cls) {
        C0076a c0076a2 = (C0076a) map.get(c0074b);
        if (c0076a2 != null && c0076a != c0076a2) {
            throw new IllegalArgumentException("Method " + c0074b.f45b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous" + " value " + c0076a2 + ", new value " + c0076a);
        } else if (c0076a2 == null) {
            map.put(c0074b, c0076a);
        }
    }

    /* renamed from: b */
    private static C0073a m96b(Class cls) {
        C0073a a;
        Class superclass = cls.getSuperclass();
        Map hashMap = new HashMap();
        if (superclass != null) {
            a = m91a(superclass);
            if (a != null) {
                hashMap.putAll(a.f43b);
            }
        }
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Class a2 : cls.getInterfaces()) {
            for (Entry entry : m91a(a2).f43b.entrySet()) {
                m95a(hashMap, (C0074b) entry.getKey(), (C0076a) entry.getValue(), cls);
            }
        }
        for (Method method : declaredMethods) {
            C0084f c0084f = (C0084f) method.getAnnotation(C0084f.class);
            if (c0084f != null) {
                int i;
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (parameterTypes[0].isAssignableFrom(C0079c.class)) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                C0076a a3 = c0084f.m112a();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(C0076a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (a3 != C0076a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    } else {
                        i = 2;
                    }
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                m95a(hashMap, new C0074b(i, method), a3, cls);
            }
        }
        a = new C0073a(hashMap);
        f46a.put(cls, a);
        return a;
    }
}
