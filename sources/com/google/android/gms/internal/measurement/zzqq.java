package com.google.android.gms.internal.measurement;

import java.util.Iterator;

final class zzqq implements Iterator<zzqp<?>> {
    private final /* synthetic */ Iterator zzbpj;

    zzqq(zzqp zzqp, Iterator it) {
        this.zzbpj = it;
    }

    public final boolean hasNext() {
        return this.zzbpj.hasNext();
    }

    public final void remove() {
        this.zzbpj.remove();
    }

    public final /* synthetic */ Object next() {
        return new zzrb((String) this.zzbpj.next());
    }
}
