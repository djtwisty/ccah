package com.google.android.gms.internal.measurement;

import java.util.Iterator;

final class zzqy implements Iterator<zzqp<?>> {
    private final /* synthetic */ Iterator zzbpw;
    private final /* synthetic */ Iterator zzbpx;

    zzqy(zzqw zzqw, Iterator it, Iterator it2) {
        this.zzbpw = it;
        this.zzbpx = it2;
    }

    public final boolean hasNext() {
        return this.zzbpw.hasNext() || this.zzbpx.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        if (this.zzbpw.hasNext()) {
            return (zzqp) this.zzbpw.next();
        }
        return (zzqp) this.zzbpx.next();
    }
}
