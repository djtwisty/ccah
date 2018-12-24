package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzic extends zzii {
    private final /* synthetic */ zzhz zzabf;

    private zzic(zzhz zzhz) {
        this.zzabf = zzhz;
        super(zzhz);
    }

    public final Iterator<Entry<K, V>> iterator() {
        return new zzib(this.zzabf, null);
    }
}
