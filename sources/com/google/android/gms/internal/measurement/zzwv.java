package com.google.android.gms.internal.measurement;

import java.util.Map.Entry;

final class zzwv implements Comparable<zzwv>, Entry<K, V> {
    private V value;
    private final /* synthetic */ zzwo zzcby;
    private final K zzccb;

    zzwv(zzwo zzwo, Entry<K, V> entry) {
        this(zzwo, (Comparable) entry.getKey(), entry.getValue());
    }

    zzwv(zzwo zzwo, K k, V v) {
        this.zzcby = zzwo;
        this.zzccb = k;
        this.value = v;
    }

    public final V getValue() {
        return this.value;
    }

    public final V setValue(V v) {
        this.zzcby.zzyf();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        if (equals(this.zzccb, entry.getKey()) && equals(this.value, entry.getValue())) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = this.zzccb == null ? 0 : this.zzccb.hashCode();
        if (this.value != null) {
            i = this.value.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzccb);
        String valueOf2 = String.valueOf(this.value);
        return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append("=").append(valueOf2).toString();
    }

    private static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else {
            return obj.equals(obj2);
        }
    }

    public final /* synthetic */ Object getKey() {
        return this.zzccb;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzwv) obj).getKey());
    }
}
