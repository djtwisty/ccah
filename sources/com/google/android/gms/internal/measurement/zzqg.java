package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

public final class zzqg {
    private final List<zzqd> zzboz;
    private final List<zzqd> zzbpa;
    private final List<zzqd> zzbpb;
    private final List<zzqd> zzbpc;

    private zzqg(List<zzqd> list, List<zzqd> list2, List<zzqd> list3, List<zzqd> list4) {
        this.zzboz = Collections.unmodifiableList(list);
        this.zzbpa = Collections.unmodifiableList(list2);
        this.zzbpb = Collections.unmodifiableList(list3);
        this.zzbpc = Collections.unmodifiableList(list4);
    }

    public final List<zzqd> zzsk() {
        return this.zzboz;
    }

    public final List<zzqd> zzsl() {
        return this.zzbpa;
    }

    public final List<zzqd> zzsm() {
        return this.zzbpb;
    }

    public final List<zzqd> zzsn() {
        return this.zzbpc;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzboz);
        String valueOf2 = String.valueOf(this.zzbpa);
        String valueOf3 = String.valueOf(this.zzbpb);
        String valueOf4 = String.valueOf(this.zzbpc);
        return new StringBuilder((((String.valueOf(valueOf).length() + 71) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()).append("Positive predicates: ").append(valueOf).append("  Negative predicates: ").append(valueOf2).append("  Add tags: ").append(valueOf3).append("  Remove tags: ").append(valueOf4).toString();
    }
}
