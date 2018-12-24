package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzwr extends zzwx {
    private final /* synthetic */ zzwo zzcby;

    private zzwr(zzwo zzwo) {
        this.zzcby = zzwo;
        super(zzwo);
    }

    public final Iterator<Entry<K, V>> iterator() {
        return new zzwq(this.zzcby);
    }
}
