package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Map;

public final class zzqf {
    private final Map<String, zzqm> zzbox = new HashMap();
    private zzqm zzboy;

    public final zzqf zza(String str, zzqm zzqm) {
        this.zzbox.put(str, zzqm);
        return this;
    }

    public final zzqf zzb(zzqm zzqm) {
        this.zzboy = zzqm;
        return this;
    }

    public final zzqd zzsj() {
        return new zzqd(this.zzbox, this.zzboy);
    }
}
