package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

public final class zzql {
    private String version;
    private List<zzjn> zzbpd = new ArrayList();

    public final zzql zza(zzjn zzjn) {
        this.zzbpd.add(zzjn);
        return this;
    }

    public final zzql zzfc(String str) {
        this.version = str;
        return this;
    }

    public final zzqj zzsq() {
        return new zzqj(this.version, this.zzbpd);
    }
}
