package com.google.android.gms.internal.config;

import com.google.android.gms.common.api.Status;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class zzu implements zzk {
    private final Status mStatus;
    private final Map<String, TreeMap<String, byte[]>> zzr;
    private final long zzs;
    private final List<byte[]> zzt;

    public zzu(Status status, Map<String, TreeMap<String, byte[]>> map) {
        this(status, (Map) map, -1);
    }

    private zzu(Status status, Map<String, TreeMap<String, byte[]>> map, long j) {
        this(status, map, -1, null);
    }

    public zzu(Status status, Map<String, TreeMap<String, byte[]>> map, List<byte[]> list) {
        this(status, map, -1, list);
    }

    public zzu(Status status, Map<String, TreeMap<String, byte[]>> map, long j, List<byte[]> list) {
        this.mStatus = status;
        this.zzr = map;
        this.zzs = j;
        this.zzt = list;
    }

    public final long getThrottleEndTimeMillis() {
        return this.zzs;
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    public final byte[] zza(String str, byte[] bArr, String str2) {
        Object obj = (this.zzr == null || this.zzr.get(str2) == null) ? null : ((TreeMap) this.zzr.get(str2)).get(str) != null ? 1 : null;
        if (obj != null) {
            return (byte[]) ((TreeMap) this.zzr.get(str2)).get(str);
        }
        return null;
    }

    public final Map<String, Set<String>> zzi() {
        Map<String, Set<String>> hashMap = new HashMap();
        if (this.zzr != null) {
            for (String str : this.zzr.keySet()) {
                Map map = (Map) this.zzr.get(str);
                if (map != null) {
                    hashMap.put(str, map.keySet());
                }
            }
        }
        return hashMap;
    }

    public final List<byte[]> zzh() {
        return this.zzt;
    }
}
