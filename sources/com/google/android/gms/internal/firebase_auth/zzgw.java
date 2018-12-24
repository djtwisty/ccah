package com.google.android.gms.internal.firebase_auth;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzgw<K, V> extends LinkedHashMap<K, V> {
    private static final zzgw zzzg;
    private boolean zzsh = true;

    private zzgw() {
    }

    private zzgw(Map<K, V> map) {
        super(map);
    }

    public static <K, V> zzgw<K, V> zzih() {
        return zzzg;
    }

    public final void zza(zzgw<K, V> zzgw) {
        zzij();
        if (!zzgw.isEmpty()) {
            putAll(zzgw);
        }
    }

    public final Set<Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public final void clear() {
        zzij();
        super.clear();
    }

    public final V put(K k, V v) {
        zzij();
        zzfv.checkNotNull(k);
        zzfv.checkNotNull(v);
        return super.put(k, v);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        zzij();
        for (Object next : map.keySet()) {
            zzfv.checkNotNull(next);
            zzfv.checkNotNull(map.get(next));
        }
        super.putAll(map);
    }

    public final V remove(Object obj) {
        zzij();
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

    private static int zzi(Object obj) {
        if (obj instanceof byte[]) {
            return zzfv.hashCode((byte[]) obj);
        }
        if (!(obj instanceof zzfw)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public final int hashCode() {
        int i = 0;
        for (Entry entry : entrySet()) {
            i = (zzi(entry.getValue()) ^ zzi(entry.getKey())) + i;
        }
        return i;
    }

    public final zzgw<K, V> zzii() {
        return isEmpty() ? new zzgw() : new zzgw(this);
    }

    public final void zzev() {
        this.zzsh = false;
    }

    public final boolean isMutable() {
        return this.zzsh;
    }

    private final void zzij() {
        if (!this.zzsh) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        zzgw zzgw = new zzgw();
        zzzg = zzgw;
        zzgw.zzsh = false;
    }
}
