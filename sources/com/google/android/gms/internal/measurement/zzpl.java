package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

public final class zzpl {
    private zzoz zzbod;

    public final zzpl zza(zzoz zzoz) {
        Preconditions.checkNotNull(zzoz);
        this.zzbod = zzoz;
        return this;
    }

    public final zzoz zzry() {
        return this.zzbod;
    }

    public final String getId() {
        return this.zzbod == null ? "" : this.zzbod.getContainerId();
    }
}
