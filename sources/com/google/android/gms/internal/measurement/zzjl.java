package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.cordova.networkinformation.NetworkManager;

public final class zzjl {
    private static final Map<String, zzjm> zzbmh;

    @ShowFirstParty
    public static zzra zza(String str, Map<String, zzqp<?>> map, zzia zzia) {
        if (zzbmh.containsKey(str)) {
            zzjm zzjm = (zzjm) zzbmh.get(str);
            String[] zzrq = zzjm.zzrq();
            List arrayList = new ArrayList();
            for (int i = 0; i < zzrq.length; i++) {
                if (map.containsKey(zzrq[i])) {
                    arrayList.add((zzqp) map.get(zzrq[i]));
                } else {
                    arrayList.add(zzqv.zzbpr);
                }
            }
            List arrayList2 = new ArrayList();
            arrayList2.add(new zzrb("gtmUtils"));
            zzra zzra = new zzra("15", arrayList2);
            arrayList2 = new ArrayList();
            arrayList2.add(zzra);
            arrayList2.add(new zzrb(NetworkManager.MOBILE));
            zzra = new zzra("17", arrayList2);
            arrayList2 = new ArrayList();
            arrayList2.add(zzra);
            arrayList2.add(new zzrb(zzjm.zzrp()));
            arrayList2.add(new zzqw(arrayList));
            return new zzra("2", arrayList2);
        }
        throw new RuntimeException(new StringBuilder(String.valueOf(str).length() + 47).append("Fail to convert ").append(str).append(" to the internal representation").toString());
    }

    public static String zzes(String str) {
        if (zzbmh.containsKey(str)) {
            return ((zzjm) zzbmh.get(str)).zzrp();
        }
        return null;
    }

    public static String zza(zza zza) {
        return zzes(zza.toString());
    }

    static {
        Map hashMap = new HashMap();
        hashMap.put(zza.CONTAINS.toString(), new zzjm("contains"));
        hashMap.put(zza.ENDS_WITH.toString(), new zzjm("endsWith"));
        hashMap.put(zza.EQUALS.toString(), new zzjm("equals"));
        hashMap.put(zza.GREATER_EQUALS.toString(), new zzjm("greaterEquals"));
        hashMap.put(zza.GREATER_THAN.toString(), new zzjm("greaterThan"));
        hashMap.put(zza.LESS_EQUALS.toString(), new zzjm("lessEquals"));
        hashMap.put(zza.LESS_THAN.toString(), new zzjm("lessThan"));
        hashMap.put(zza.REGEX.toString(), new zzjm("regex", new String[]{zzb.ARG0.toString(), zzb.ARG1.toString(), zzb.IGNORE_CASE.toString()}));
        hashMap.put(zza.STARTS_WITH.toString(), new zzjm("startsWith"));
        zzbmh = hashMap;
    }
}
