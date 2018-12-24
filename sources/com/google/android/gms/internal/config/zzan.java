package com.google.android.gms.internal.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public final class zzan {
    private Map<String, Map<String, byte[]>> zzav;
    private long zzaw;
    private List<byte[]> zzt;

    public zzan(Map<String, Map<String, byte[]>> map, long j, List<byte[]> list) {
        this.zzav = map;
        this.zzaw = j;
        this.zzt = list;
    }

    public final Map<String, Map<String, byte[]>> zzq() {
        return this.zzav;
    }

    public final List<byte[]> zzh() {
        return this.zzt;
    }

    public final boolean zzr() {
        return (this.zzav == null || this.zzav.isEmpty()) ? false : true;
    }

    public final boolean zzb(String str) {
        if (str == null) {
            return false;
        }
        return (!zzr() || this.zzav.get(str) == null || ((Map) this.zzav.get(str)).isEmpty()) ? false : true;
    }

    public final boolean zzb(String str, String str2) {
        return zzr() && zzb(str2) && zzc(str, str2) != null;
    }

    public final byte[] zzc(String str, String str2) {
        if (str == null || !zzb(str2)) {
            return null;
        }
        return (byte[]) ((Map) this.zzav.get(str2)).get(str);
    }

    public final void zza(Map<String, byte[]> map, String str) {
        if (this.zzav == null) {
            this.zzav = new HashMap();
        }
        this.zzav.put(str, map);
    }

    public final Map<String, byte[]> zzc(String str) {
        if (this.zzav == null) {
            return null;
        }
        return (Map) this.zzav.get(str);
    }

    public final long getTimestamp() {
        return this.zzaw;
    }

    public final void setTimestamp(long j) {
        this.zzaw = j;
    }

    public final Set<String> zzd(String str, String str2) {
        Set<String> treeSet = new TreeSet();
        if (!zzb(str2)) {
            return treeSet;
        }
        if (str == null || str.isEmpty()) {
            return ((Map) this.zzav.get(str2)).keySet();
        }
        for (String str3 : ((Map) this.zzav.get(str2)).keySet()) {
            if (str3.startsWith(str)) {
                treeSet.add(str3);
            }
        }
        return treeSet;
    }
}
