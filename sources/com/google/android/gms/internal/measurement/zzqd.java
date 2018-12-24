package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Map;

public final class zzqd {
    private final Map<String, zzqm> zzbox;
    private final zzqm zzboy;

    private zzqd(Map<String, zzqm> map, zzqm zzqm) {
        this.zzbox = Collections.unmodifiableMap(map);
        this.zzboy = zzqm;
    }

    public final Map<String, zzqm> zzsi() {
        return this.zzbox;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzbox);
        String valueOf2 = String.valueOf(this.zzboy);
        return new StringBuilder((String.valueOf(valueOf).length() + 32) + String.valueOf(valueOf2).length()).append("Properties: ").append(valueOf).append(" pushAfterEvaluate: ").append(valueOf2).toString();
    }
}
