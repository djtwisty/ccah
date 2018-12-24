package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzqx implements Iterator<zzqp<?>> {
    private int currentIndex = 0;
    private final /* synthetic */ zzqw zzbpv;

    zzqx(zzqw zzqw) {
        this.zzbpv = zzqw;
    }

    public final boolean hasNext() {
        for (int i = this.currentIndex; i < this.zzbpv.zzbpu.size(); i++) {
            if (this.zzbpv.zzbpu.get(i) != null) {
                return true;
            }
        }
        return false;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        if (this.currentIndex >= this.zzbpv.zzbpu.size()) {
            throw new NoSuchElementException();
        }
        for (int i = this.currentIndex; i < this.zzbpv.zzbpu.size(); i++) {
            if (this.zzbpv.zzbpu.get(i) != null) {
                this.currentIndex = i;
                int i2 = this.currentIndex;
                this.currentIndex = i2 + 1;
                return new zzqt(Double.valueOf((double) i2));
            }
        }
        throw new NoSuchElementException();
    }
}
