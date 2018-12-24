package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzqt extends zzqp<Double> {
    private static final Map<String, zzjo> zzbpl;
    private Double zzbpm;

    public zzqt(Double d) {
        Preconditions.checkNotNull(d);
        this.zzbpm = d;
    }

    public final boolean zzff(String str) {
        return zzbpl.containsKey(str);
    }

    public final zzjo zzfg(String str) {
        if (zzff(str)) {
            return (zzjo) zzbpl.get(str);
        }
        throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 53).append("Native Method ").append(str).append(" is not defined for type DoubleWrapper.").toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzqt) {
            return this.zzbpm.equals((Double) ((zzqt) obj).value());
        }
        return false;
    }

    public final String toString() {
        return this.zzbpm.toString();
    }

    public final /* synthetic */ Object value() {
        return this.zzbpm;
    }

    static {
        Map hashMap = new HashMap();
        hashMap.put("hasOwnProperty", zzlp.zzbmp);
        hashMap.put("toString", new zzmr());
        zzbpl = Collections.unmodifiableMap(hashMap);
    }
}
