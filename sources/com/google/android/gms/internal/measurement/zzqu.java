package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzqu extends zzqp<zzjo> {
    private static final Map<String, zzjo> zzbpl;
    private zzjo zzbpn;

    public zzqu(zzjo zzjo) {
        this.zzbpn = zzjo;
    }

    public final Iterator<zzqp<?>> zzst() {
        return zzsu();
    }

    public final boolean zzff(String str) {
        return zzbpl.containsKey(str);
    }

    public final zzjo zzfg(String str) {
        if (zzff(str)) {
            return (zzjo) zzbpl.get(str);
        }
        throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 60).append("Native Method ").append(str).append(" is not defined for type InstructionReference.").toString());
    }

    public final String toString() {
        return this.zzbpn.toString();
    }

    public final /* synthetic */ Object value() {
        return this.zzbpn;
    }

    static {
        Map hashMap = new HashMap();
        hashMap.put("hasOwnProperty", zzlp.zzbmp);
        zzbpl = Collections.unmodifiableMap(hashMap);
    }
}
