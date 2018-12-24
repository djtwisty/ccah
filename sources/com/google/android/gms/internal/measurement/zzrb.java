package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzrb extends zzqp<String> {
    private static final Map<String, zzjo> zzbpl;
    private final String value;

    public zzrb(String str) {
        Preconditions.checkNotNull(str);
        this.value = str;
    }

    public final zzqp<?> zzag(int i) {
        if (i < 0 || i >= this.value.length()) {
            return zzqv.zzbpr;
        }
        return new zzrb(String.valueOf(this.value.charAt(i)));
    }

    public final Iterator<zzqp<?>> zzst() {
        return new zzrc(this);
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

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzrb) {
            return this.value.equals((String) ((zzrb) obj).value());
        }
        return false;
    }

    public final String toString() {
        return this.value.toString();
    }

    public final /* synthetic */ Object value() {
        return this.value;
    }

    static {
        Map hashMap = new HashMap();
        hashMap.put("charAt", new zzme());
        hashMap.put("concat", new zzmf());
        hashMap.put("hasOwnProperty", zzlp.zzbmp);
        hashMap.put("indexOf", new zzmg());
        hashMap.put("lastIndexOf", new zzmh());
        hashMap.put("match", new zzmi());
        hashMap.put("replace", new zzmj());
        hashMap.put(Event.SEARCH, new zzmk());
        hashMap.put("slice", new zzml());
        hashMap.put("split", new zzmm());
        hashMap.put("substring", new zzmn());
        hashMap.put("toLocaleLowerCase", new zzmo());
        hashMap.put("toLocaleUpperCase", new zzmp());
        hashMap.put("toLowerCase", new zzmq());
        hashMap.put("toUpperCase", new zzms());
        hashMap.put("toString", new zzmr());
        hashMap.put("trim", new zzmt());
        zzbpl = Collections.unmodifiableMap(hashMap);
    }
}
