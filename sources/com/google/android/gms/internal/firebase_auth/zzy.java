package com.google.android.gms.internal.firebase_auth;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public abstract class zzy<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zzfm = new Object[0];

    zzy() {
    }

    public abstract zzad<E> zzbo();

    public final Object[] toArray() {
        return toArray(zzfm);
    }

    public final <T> T[] toArray(T[] tArr) {
        zzv.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zzbp = zzbp();
            if (zzbp != null) {
                return Arrays.copyOfRange(zzbp, zzbq(), zzbr(), tArr.getClass());
            }
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }

    Object[] zzbp() {
        return null;
    }

    int zzbq() {
        throw new UnsupportedOperationException();
    }

    int zzbr() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    int zza(Object[] objArr, int i) {
        zzad zzad = (zzad) iterator();
        while (zzad.hasNext()) {
            int i2 = i + 1;
            objArr[i] = zzad.next();
            i = i2;
        }
        return i;
    }

    public /* synthetic */ Iterator iterator() {
        return zzbo();
    }
}
