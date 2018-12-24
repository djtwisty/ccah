package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzqz extends zzqp<Map<String, zzqp<?>>> {
    private static final Map<String, zzjo> zzbpl;
    private boolean zzbpy = false;

    public zzqz(Map<String, zzqp<?>> map) {
        this.zzbpi = (Map) Preconditions.checkNotNull(map);
    }

    public final Iterator<zzqp<?>> zzst() {
        return zzsu();
    }

    public final zzqp<?> zzfe(String str) {
        zzqp<?> zzfe = super.zzfe(str);
        if (zzfe == null) {
            return zzqv.zzbpr;
        }
        return zzfe;
    }

    public final boolean zzff(String str) {
        return zzbpl.containsKey(str);
    }

    public final zzjo zzfg(String str) {
        if (zzff(str)) {
            return (zzjo) zzbpl.get(str);
        }
        throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 51).append("Native Method ").append(str).append(" is not defined for type ListWrapper.").toString());
    }

    public final void zzsw() {
        this.zzbpy = true;
    }

    public final boolean isImmutable() {
        return this.zzbpy;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzqz) {
            return this.zzbpi.entrySet().equals(((Map) ((zzqz) obj).value()).entrySet());
        }
        return false;
    }

    public final String toString() {
        return this.zzbpi.toString();
    }

    public final /* synthetic */ Object value() {
        return this.zzbpi;
    }

    static {
        Map hashMap = new HashMap();
        hashMap.put("hasOwnProperty", zzlp.zzbmp);
        zzbpl = Collections.unmodifiableMap(hashMap);
    }
}
