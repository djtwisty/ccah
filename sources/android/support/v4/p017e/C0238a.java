package android.support.v4.p017e;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: android.support.v4.e.a */
public class C0238a<K, V> extends C0237i<K, V> implements Map<K, V> {
    /* renamed from: a */
    C0235g<K, V> f467a;

    /* renamed from: android.support.v4.e.a$1 */
    class C02361 extends C0235g<K, V> {
        /* renamed from: a */
        final /* synthetic */ C0238a f459a;

        C02361(C0238a c0238a) {
            this.f459a = c0238a;
        }

        /* renamed from: a */
        protected int mo127a() {
            return this.f459a.h;
        }

        /* renamed from: a */
        protected Object mo129a(int i, int i2) {
            return this.f459a.g[(i << 1) + i2];
        }

        /* renamed from: a */
        protected int mo128a(Object obj) {
            return this.f459a.m717a(obj);
        }

        /* renamed from: b */
        protected int mo133b(Object obj) {
            return this.f459a.m721b(obj);
        }

        /* renamed from: b */
        protected Map<K, V> mo134b() {
            return this.f459a;
        }

        /* renamed from: a */
        protected void mo132a(K k, V v) {
            this.f459a.put(k, v);
        }

        /* renamed from: a */
        protected V mo130a(int i, V v) {
            return this.f459a.m719a(i, (Object) v);
        }

        /* renamed from: a */
        protected void mo131a(int i) {
            this.f459a.m724d(i);
        }

        /* renamed from: c */
        protected void mo135c() {
            this.f459a.clear();
        }
    }

    public C0238a(int i) {
        super(i);
    }

    /* renamed from: b */
    private C0235g<K, V> m725b() {
        if (this.f467a == null) {
            this.f467a = new C02361(this);
        }
        return this.f467a;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        m720a(this.h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /* renamed from: a */
    public boolean m726a(Collection<?> collection) {
        return C0235g.m689c(this, collection);
    }

    public Set<Entry<K, V>> entrySet() {
        return m725b().m701d();
    }

    public Set<K> keySet() {
        return m725b().m702e();
    }

    public Collection<V> values() {
        return m725b().m703f();
    }
}
