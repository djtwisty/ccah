package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class zzqb {
    private String version;
    private final List<zzqg> zzbov;
    private final Map<String, zzqd> zzbow;
    private int zzph = 0;

    public zzqb(List<zzqg> list, Map<String, zzqd> map, String str, int i) {
        this.zzbov = Collections.unmodifiableList(list);
        this.zzbow = Collections.unmodifiableMap(map);
        this.version = str;
    }

    public final List<zzqg> zzsg() {
        return this.zzbov;
    }

    public final zzqd zzfa(String str) {
        return (zzqd) this.zzbow.get(str);
    }

    public final String getVersion() {
        return this.version;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzbov);
        String valueOf2 = String.valueOf(this.zzbow);
        return new StringBuilder((String.valueOf(valueOf).length() + 18) + String.valueOf(valueOf2).length()).append("Rules: ").append(valueOf).append("\n  Macros: ").append(valueOf2).toString();
    }
}
