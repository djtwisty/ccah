package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

public final class zzqm {
    private static final String zzbhc = new String("");
    private static final Integer zzbpe = Integer.valueOf(0);
    private final int type;
    private final Object value;
    private final List<Integer> zzbpf;
    private final boolean zzbpg;

    private zzqm(Integer num, Object obj, List<Integer> list, boolean z) {
        this.type = num.intValue();
        this.value = obj;
        this.zzbpf = Collections.unmodifiableList(list);
        this.zzbpg = z;
    }

    public final int getType() {
        return this.type;
    }

    public final Object getValue() {
        return this.value;
    }

    public final List<Integer> zzsr() {
        return this.zzbpf;
    }

    public final String toString() {
        if (this.value != null) {
            return this.value.toString();
        }
        zzhk.m1081e("Fail to convert a null object to string");
        return zzbhc;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzqm) && ((zzqm) obj).value.equals(this.value);
    }

    public final int hashCode() {
        return this.value.hashCode();
    }
}
