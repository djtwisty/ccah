package com.google.android.gms.internal.firebase_auth;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzz<E> extends zzy<E> implements List<E>, RandomAccess {
    private static final zzae<Object> zzfn = new zzaa(zzac.zzfq, 0);

    public static <E> zzz<E> zza(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        int i = 0;
        Object[] objArr = new Object[]{e, e2, e3, e4, e5, e6, e7, e8};
        while (i < 8) {
            if (objArr[i] == null) {
                throw new NullPointerException("at index " + i);
            }
            i++;
        }
        return new zzac(objArr, 8);
    }

    zzz() {
    }

    public final zzad<E> zzbo() {
        return (zzae) listIterator();
    }

    public int indexOf(@NullableDecl Object obj) {
        int i = 0;
        if (obj == null) {
            return -1;
        }
        if (this instanceof RandomAccess) {
            int size = size();
            if (obj == null) {
                while (i < size) {
                    if (get(i) == null) {
                        return i;
                    }
                    i++;
                }
                return -1;
            }
            while (i < size) {
                if (obj.equals(get(i))) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        ListIterator listIterator = listIterator();
        while (listIterator.hasNext()) {
            if (zzu.equal(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        if (!(this instanceof RandomAccess)) {
            ListIterator listIterator = listIterator(size());
            while (listIterator.hasPrevious()) {
                if (zzu.equal(obj, listIterator.previous())) {
                    return listIterator.nextIndex();
                }
            }
            return -1;
        } else if (obj == null) {
            for (r1 = size() - 1; r1 >= 0; r1--) {
                if (get(r1) == null) {
                    return r1;
                }
            }
            return -1;
        } else {
            for (r1 = size() - 1; r1 >= 0; r1--) {
                if (obj.equals(get(r1))) {
                    return r1;
                }
            }
            return -1;
        }
    }

    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    public zzz<E> zzc(int i, int i2) {
        zzv.zza(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return zzac.zzfq;
        }
        return new zzab(this, i, i2 - i);
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == zzv.checkNotNull(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                int i;
                if ((this instanceof RandomAccess) && (list instanceof RandomAccess)) {
                    i = 0;
                    while (i < size) {
                        if (zzu.equal(get(i), list.get(i))) {
                            i++;
                        }
                    }
                    return true;
                }
                this = this;
                size = size();
                Iterator it = list.iterator();
                i = 0;
                while (i < size) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object obj2 = get(i);
                    i++;
                    if (!zzu.equal(obj2, it.next())) {
                        break;
                    }
                }
                if (!it.hasNext()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < size(); i2++) {
            i = (((i * 31) + get(i2).hashCode()) ^ -1) ^ -1;
        }
        return i;
    }

    public /* synthetic */ Iterator iterator() {
        return zzbo();
    }

    public /* synthetic */ List subList(int i, int i2) {
        return zzc(i, i2);
    }

    public /* synthetic */ ListIterator listIterator(int i) {
        zzv.zzb(i, size());
        if (isEmpty()) {
            return zzfn;
        }
        return new zzaa(this, i);
    }

    public /* synthetic */ ListIterator listIterator() {
        return (zzae) listIterator(0);
    }
}
