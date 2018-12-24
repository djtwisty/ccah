package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzqc {
    private String version = "";
    private final List<zzqg> zzbov = new ArrayList();
    private final Map<String, zzqd> zzbow = new HashMap();
    private int zzph = 0;

    public final zzqc zza(zzqg zzqg) {
        this.zzbov.add(zzqg);
        return this;
    }

    public final zzqc zzb(zzqd zzqd) {
        this.zzbow.put(((zzqm) zzqd.zzsi().get("instance_name")).toString(), zzqd);
        return this;
    }

    public final zzqc zzfb(String str) {
        this.version = str;
        return this;
    }

    public final zzqb zzsh() {
        return new zzqb(this.zzbov, this.zzbow, this.version, 0);
    }
}
