package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzqs extends zzqp<Boolean> {
    private static final Map<String, zzjo> zzbpl;
    private final Boolean zzbpk;

    public zzqs(Boolean bool) {
        Preconditions.checkNotNull(bool);
        this.zzbpk = bool;
    }

    public final boolean zzff(String str) {
        return zzbpl.containsKey(str);
    }

    public final zzjo zzfg(String str) {
        if (zzff(str)) {
            return (zzjo) zzbpl.get(str);
        }
        throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 54).append("Native Method ").append(str).append(" is not defined for type BooleanWrapper.").toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzqs)) {
            return false;
        }
        return ((Boolean) ((zzqs) obj).value()) == this.zzbpk;
    }

    public final String toString() {
        return this.zzbpk.toString();
    }

    public final /* synthetic */ Object value() {
        return this.zzbpk;
    }

    static {
        Map hashMap = new HashMap();
        hashMap.put("hasOwnProperty", zzlp.zzbmp);
        hashMap.put("toString", new zzmr());
        zzbpl = Collections.unmodifiableMap(hashMap);
    }
}
