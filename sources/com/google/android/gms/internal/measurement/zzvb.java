package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzvb<K> implements Iterator<Entry<K, Object>> {
    private Iterator<Entry<K, Object>> zzbzt;

    public zzvb(Iterator<Entry<K, Object>> it) {
        this.zzbzt = it;
    }

    public final boolean hasNext() {
        return this.zzbzt.hasNext();
    }

    public final void remove() {
        this.zzbzt.remove();
    }

    public final /* synthetic */ Object next() {
        Entry entry = (Entry) this.zzbzt.next();
        if (entry.getValue() instanceof zzuy) {
            return new zzva(entry);
        }
        return entry;
    }
}
