package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzrc implements Iterator<zzqp<?>> {
    private int currentIndex = 0;
    private final /* synthetic */ zzrb zzbqb;

    zzrc(zzrb zzrb) {
        this.zzbqb = zzrb;
    }

    public final boolean hasNext() {
        return this.currentIndex < this.zzbqb.value.length();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        if (this.currentIndex >= this.zzbqb.value.length()) {
            throw new NoSuchElementException();
        }
        int i = this.currentIndex;
        this.currentIndex = i + 1;
        return new zzqt(Double.valueOf((double) i));
    }
}
