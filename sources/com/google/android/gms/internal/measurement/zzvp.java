package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzvp<K, V> extends LinkedHashMap<K, V> {
    private static final zzvp zzcal;
    private boolean zzbtl = true;

    private zzvp() {
    }

    private zzvp(Map<K, V> map) {
        super(map);
    }

    public static <K, V> zzvp<K, V> zzxg() {
        return zzcal;
    }

    public final void zza(zzvp<K, V> zzvp) {
        zzxi();
        if (!zzvp.isEmpty()) {
            putAll(zzvp);
        }
    }

    public final Set<Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public final void clear() {
        zzxi();
        super.clear();
    }

    public final V put(K k, V v) {
        zzxi();
        zzuq.checkNotNull(k);
        zzuq.checkNotNull(v);
        return super.put(k, v);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        zzxi();
        for (Object next : map.keySet()) {
            zzuq.checkNotNull(next);
            zzuq.checkNotNull(map.get(next));
        }
        super.putAll(map);
    }

    public final V remove(Object obj) {
        zzxi();
        return super.remove(obj);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Map) {
            Object obj2;
            obj = (Map) obj;
            if (this != obj) {
                if (size() == obj.size()) {
                    for (Entry entry : entrySet()) {
                        if (!obj.containsKey(entry.getKey())) {
                            obj2 = null;
                            break;
                        }
                        boolean equals;
                        Object value = entry.getValue();
                        Object obj3 = obj.get(entry.getKey());
                        if ((value instanceof byte[]) && (obj3 instanceof byte[])) {
                            equals = Arrays.equals((byte[]) value, (byte[]) obj3);
                            continue;
                        } else {
                            equals = value.equals(obj3);
                            continue;
                        }
                        if (!equals) {
                            obj2 = null;
                            break;
                        }
                    }
                }
                obj2 = null;
                if (obj2 != null) {
                    return true;
                }
            }
            int i = 1;
            if (obj2 != null) {
                return true;
            }
        }
        return false;
    }

    private static int zzab(Object obj) {
        if (obj instanceof byte[]) {
            return zzuq.hashCode((byte[]) obj);
        }
        if (!(obj instanceof zzur)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public final int hashCode() {
        int i = 0;
        for (Entry entry : entrySet()) {
            i = (zzab(entry.getValue()) ^ zzab(entry.getKey())) + i;
        }
        return i;
    }

    public final zzvp<K, V> zzxh() {
        return isEmpty() ? new zzvp() : new zzvp(this);
    }

    public final void zzsw() {
        this.zzbtl = false;
    }

    public final boolean isMutable() {
        return this.zzbtl;
    }

    private final void zzxi() {
        if (!this.zzbtl) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        zzvp zzvp = new zzvp();
        zzcal = zzvp;
        zzvp.zzbtl = false;
    }
}
