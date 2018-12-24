package com.google.android.gms.internal.firebase_auth;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzhz<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int zzaay;
    private List<zzig> zzaaz;
    private Map<K, V> zzaba;
    private volatile zzii zzabb;
    private Map<K, V> zzabc;
    private volatile zzic zzabd;
    private boolean zzuc;

    static <FieldDescriptorType extends zzfm<FieldDescriptorType>> zzhz<FieldDescriptorType, Object> zzbb(int i) {
        return new zzia(i);
    }

    private zzhz(int i) {
        this.zzaay = i;
        this.zzaaz = Collections.emptyList();
        this.zzaba = Collections.emptyMap();
        this.zzabc = Collections.emptyMap();
    }

    public void zzev() {
        if (!this.zzuc) {
            Map emptyMap;
            if (this.zzaba.isEmpty()) {
                emptyMap = Collections.emptyMap();
            } else {
                emptyMap = Collections.unmodifiableMap(this.zzaba);
            }
            this.zzaba = emptyMap;
            if (this.zzabc.isEmpty()) {
                emptyMap = Collections.emptyMap();
            } else {
                emptyMap = Collections.unmodifiableMap(this.zzabc);
            }
            this.zzabc = emptyMap;
            this.zzuc = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzuc;
    }

    public final int zzjf() {
        return this.zzaaz.size();
    }

    public final Entry<K, V> zzbc(int i) {
        return (Entry) this.zzaaz.get(i);
    }

    public final Iterable<Entry<K, V>> zzjg() {
        if (this.zzaba.isEmpty()) {
            return zzid.zzjl();
        }
        return this.zzaba.entrySet();
    }

    public int size() {
        return this.zzaaz.size() + this.zzaba.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzaba.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return ((zzig) this.zzaaz.get(zza)).getValue();
        }
        return this.zzaba.get(comparable);
    }

    public final V zza(K k, V v) {
        zzji();
        int zza = zza((Comparable) k);
        if (zza >= 0) {
            return ((zzig) this.zzaaz.get(zza)).setValue(v);
        }
        zzji();
        if (this.zzaaz.isEmpty() && !(this.zzaaz instanceof ArrayList)) {
            this.zzaaz = new ArrayList(this.zzaay);
        }
        int i = -(zza + 1);
        if (i >= this.zzaay) {
            return zzjj().put(k, v);
        }
        if (this.zzaaz.size() == this.zzaay) {
            zzig zzig = (zzig) this.zzaaz.remove(this.zzaay - 1);
            zzjj().put((Comparable) zzig.getKey(), zzig.getValue());
        }
        this.zzaaz.add(i, new zzig(this, k, v));
        return null;
    }

    public void clear() {
        zzji();
        if (!this.zzaaz.isEmpty()) {
            this.zzaaz.clear();
        }
        if (!this.zzaba.isEmpty()) {
            this.zzaba.clear();
        }
    }

    public V remove(Object obj) {
        zzji();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return zzbd(zza);
        }
        if (this.zzaba.isEmpty()) {
            return null;
        }
        return this.zzaba.remove(comparable);
    }

    private final V zzbd(int i) {
        zzji();
        V value = ((zzig) this.zzaaz.remove(i)).getValue();
        if (!this.zzaba.isEmpty()) {
            Iterator it = zzjj().entrySet().iterator();
            this.zzaaz.add(new zzig(this, (Entry) it.next()));
            it.remove();
        }
        return value;
    }

    private final int zza(K k) {
        int compareTo;
        int i = 0;
        int size = this.zzaaz.size() - 1;
        if (size >= 0) {
            compareTo = k.compareTo((Comparable) ((zzig) this.zzaaz.get(size)).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i2 = size;
        while (i <= i2) {
            size = (i + i2) / 2;
            compareTo = k.compareTo((Comparable) ((zzig) this.zzaaz.get(size)).getKey());
            if (compareTo < 0) {
                i2 = size - 1;
            } else if (compareTo <= 0) {
                return size;
            } else {
                i = size + 1;
            }
        }
        return -(i + 1);
    }

    public Set<Entry<K, V>> entrySet() {
        if (this.zzabb == null) {
            this.zzabb = new zzii();
        }
        return this.zzabb;
    }

    final Set<Entry<K, V>> zzjh() {
        if (this.zzabd == null) {
            this.zzabd = new zzic();
        }
        return this.zzabd;
    }

    private final void zzji() {
        if (this.zzuc) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzjj() {
        zzji();
        if (this.zzaba.isEmpty() && !(this.zzaba instanceof TreeMap)) {
            this.zzaba = new TreeMap();
            this.zzabc = ((TreeMap) this.zzaba).descendingMap();
        }
        return (SortedMap) this.zzaba;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhz)) {
            return super.equals(obj);
        }
        zzhz zzhz = (zzhz) obj;
        int size = size();
        if (size != zzhz.size()) {
            return false;
        }
        int zzjf = zzjf();
        if (zzjf != zzhz.zzjf()) {
            return entrySet().equals(zzhz.entrySet());
        }
        for (int i = 0; i < zzjf; i++) {
            if (!zzbc(i).equals(zzhz.zzbc(i))) {
                return false;
            }
        }
        if (zzjf != size) {
            return this.zzaba.equals(zzhz.zzaba);
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < zzjf(); i2++) {
            i += ((zzig) this.zzaaz.get(i2)).hashCode();
        }
        if (this.zzaba.size() > 0) {
            return this.zzaba.hashCode() + i;
        }
        return i;
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return zza((Comparable) obj, obj2);
    }
}
