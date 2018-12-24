package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class zzck {
    private final List<zzbr> zzaav;
    private final long zzaaw;
    private final long zzaax;
    private final int zzaay;
    private final boolean zzaaz;
    private final String zzaba;
    private final Map<String, String> zzsy;

    public zzck(zzat zzat, Map<String, String> map, long j, boolean z) {
        this(zzat, map, j, z, 0, 0, null);
    }

    public zzck(zzat zzat, Map<String, String> map, long j, boolean z, long j2, int i) {
        this(zzat, map, j, z, j2, i, null);
    }

    public zzck(zzat zzat, Map<String, String> map, long j, boolean z, long j2, int i, List<zzbr> list) {
        CharSequence value;
        String str = null;
        Preconditions.checkNotNull(zzat);
        Preconditions.checkNotNull(map);
        this.zzaax = j;
        this.zzaaz = z;
        this.zzaaw = j2;
        this.zzaay = i;
        this.zzaav = list != null ? list : Collections.emptyList();
        if (list != null) {
            for (zzbr zzbr : list) {
                if ("appendVersion".equals(zzbr.getId())) {
                    value = zzbr.getValue();
                    break;
                }
            }
        }
        value = null;
        if (!TextUtils.isEmpty(value)) {
            CharSequence charSequence = value;
        }
        this.zzaba = str;
        Map hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            String zza;
            if (zzc(entry.getKey())) {
                zza = zza(zzat, entry.getKey());
                if (zza != null) {
                    hashMap.put(zza, zzb(zzat, entry.getValue()));
                }
            }
        }
        for (Entry entry2 : map.entrySet()) {
            if (!zzc(entry2.getKey())) {
                zza = zza(zzat, entry2.getKey());
                if (zza != null) {
                    hashMap.put(zza, zzb(zzat, entry2.getValue()));
                }
            }
        }
        if (!TextUtils.isEmpty(this.zzaba)) {
            zzdg.zzb(hashMap, "_v", this.zzaba);
            if (this.zzaba.equals("ma4.0.0") || this.zzaba.equals("ma4.0.1")) {
                hashMap.remove("adid");
            }
        }
        this.zzsy = Collections.unmodifiableMap(hashMap);
    }

    private static boolean zzc(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.toString().startsWith("&");
    }

    private static String zza(zzat zzat, Object obj) {
        if (obj == null) {
            return null;
        }
        String obj2 = obj.toString();
        if (obj2.startsWith("&")) {
            obj2 = obj2.substring(1);
        }
        int length = obj2.length();
        if (length > 256) {
            obj2 = obj2.substring(0, 256);
            zzat.zzc("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj2);
        }
        if (TextUtils.isEmpty(obj2)) {
            return null;
        }
        return obj2;
    }

    private static String zzb(zzat zzat, Object obj) {
        String str;
        if (obj == null) {
            str = "";
        } else {
            str = obj.toString();
        }
        int length = str.length();
        if (length <= 8192) {
            return str;
        }
        str = str.substring(0, 8192);
        zzat.zzc("Hit param value is too long and will be trimmed", Integer.valueOf(length), str);
        return str;
    }

    public final int zzep() {
        return this.zzaay;
    }

    public final Map<String, String> zzcw() {
        return this.zzsy;
    }

    public final long zzeq() {
        return this.zzaaw;
    }

    public final long zzer() {
        return this.zzaax;
    }

    public final List<zzbr> zzes() {
        return this.zzaav;
    }

    public final boolean zzet() {
        return this.zzaaz;
    }

    public final long zzeu() {
        return zzdg.zzaf(zzd("_s", "0"));
    }

    public final String zzev() {
        return zzd("_m", "");
    }

    private final String zzd(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(!str.startsWith("&"), "Short param name required");
        String str3 = (String) this.zzsy.get(str);
        if (str3 != null) {
            return str3;
        }
        return str2;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ht=").append(this.zzaax);
        if (this.zzaaw != 0) {
            stringBuilder.append(", dbId=").append(this.zzaaw);
        }
        if (this.zzaay != 0) {
            stringBuilder.append(", appUID=").append(this.zzaay);
        }
        List arrayList = new ArrayList(this.zzsy.keySet());
        Collections.sort(arrayList);
        ArrayList arrayList2 = (ArrayList) arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            String str = (String) obj;
            stringBuilder.append(", ");
            stringBuilder.append(str);
            stringBuilder.append("=");
            stringBuilder.append((String) this.zzsy.get(str));
        }
        return stringBuilder.toString();
    }
}
