package com.google.android.gms.internal.measurement;

import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@ShowFirstParty
public final class zzz extends zzi<zzz> {
    private Map<Integer, String> zzud = new HashMap(4);

    public final String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.zzud.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            hashMap.put(new StringBuilder(String.valueOf(valueOf).length() + 9).append("dimension").append(valueOf).toString(), entry.getValue());
        }
        return zzi.zza((Object) hashMap);
    }

    public final Map<Integer, String> zzau() {
        return Collections.unmodifiableMap(this.zzud);
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        ((zzz) zzi).zzud.putAll(this.zzud);
    }
}
