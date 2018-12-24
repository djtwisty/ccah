package com.google.android.gms.internal.measurement;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zzpb {
    static zzqb zzet(String str) {
        Object obj = new JSONObject(str).get("resource");
        if (obj instanceof JSONObject) {
            int i;
            JSONObject jSONObject = (JSONObject) obj;
            zzqc zzqc = new zzqc();
            zzqc.zzfb(jSONObject.optString(ClientCookie.VERSION_ATTR));
            JSONArray jSONArray = jSONObject.getJSONArray("macros");
            List arrayList = new ArrayList();
            for (i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getJSONObject(i).getString("instance_name"));
            }
            List zza = zza(jSONObject.getJSONArray("tags"), arrayList);
            List zza2 = zza(jSONObject.getJSONArray("predicates"), arrayList);
            for (zzqd zzb : zza(jSONObject.getJSONArray("macros"), arrayList)) {
                zzqc.zzb(zzb);
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray("rules");
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONArray jSONArray3 = jSONArray2.getJSONArray(i2);
                zzqi zzqi = new zzqi();
                for (i = 0; i < jSONArray3.length(); i++) {
                    JSONArray jSONArray4 = jSONArray3.getJSONArray(i);
                    int i3;
                    if (jSONArray4.getString(0).equals("if")) {
                        for (i3 = 1; i3 < jSONArray4.length(); i3++) {
                            zzqi.zzc((zzqd) zza2.get(jSONArray4.getInt(i3)));
                        }
                    } else if (jSONArray4.getString(0).equals("unless")) {
                        for (i3 = 1; i3 < jSONArray4.length(); i3++) {
                            zzqi.zzd((zzqd) zza2.get(jSONArray4.getInt(i3)));
                        }
                    } else if (jSONArray4.getString(0).equals(ProductAction.ACTION_ADD)) {
                        for (i3 = 1; i3 < jSONArray4.length(); i3++) {
                            zzqi.zze((zzqd) zza.get(jSONArray4.getInt(i3)));
                        }
                    } else if (jSONArray4.getString(0).equals("block")) {
                        for (i3 = 1; i3 < jSONArray4.length(); i3++) {
                            zzqi.zzf((zzqd) zza.get(jSONArray4.getInt(i3)));
                        }
                    } else {
                        String str2 = "Unknown Rule property: ";
                        String valueOf = String.valueOf(jSONArray4.getString(0));
                        zzev(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    }
                }
                zzqc.zza(zzqi.zzso());
            }
            return zzqc.zzsh();
        }
        throw new zzpa("Resource map not found");
    }

    @VisibleForTesting
    private static List<zzqd> zza(JSONArray jSONArray, List<String> list) {
        List<zzqd> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            zzqf zzqf = new zzqf();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                zzqm zzss = zza(jSONObject.get(str), (List) list).zzss();
                if ("push_after_evaluate".equals(str)) {
                    zzqf.zzb(zzss);
                } else {
                    zzqf.zza(str, zzss);
                }
            }
            arrayList.add(zzqf.zzsj());
        }
        return arrayList;
    }

    @VisibleForTesting
    private static zzqo zza(Object obj, List<String> list) {
        int i = 2;
        String valueOf;
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            String string = jSONArray.getString(0);
            if (string.equals("escape")) {
                zzqo zza = zza(jSONArray.get(1), (List) list);
                while (i < jSONArray.length()) {
                    zza.zzad(jSONArray.getInt(i));
                    i++;
                }
                return zza;
            } else if (string.equals("list")) {
                List arrayList = new ArrayList();
                for (int i2 = 1; i2 < jSONArray.length(); i2++) {
                    arrayList.add(zza(jSONArray.get(i2), (List) list).zzss());
                }
                r0 = new zzqo(2, arrayList);
                r0.zzr(true);
                return r0;
            } else if (string.equals("map")) {
                Map hashMap = new HashMap();
                for (i = 1; i < jSONArray.length(); i += 2) {
                    hashMap.put(zza(jSONArray.get(i), (List) list).zzss(), zza(jSONArray.get(i + 1), (List) list).zzss());
                }
                r0 = new zzqo(3, hashMap);
                r0.zzr(true);
                return r0;
            } else if (string.equals("macro")) {
                zzqo zzqo = new zzqo(4, list.get(jSONArray.getInt(1)));
                zzqo.zzr(true);
                return zzqo;
            } else if (string.equals("template")) {
                List arrayList2 = new ArrayList();
                for (i = 1; i < jSONArray.length(); i++) {
                    arrayList2.add(zza(jSONArray.get(i), (List) list).zzss());
                }
                r0 = new zzqo(7, arrayList2);
                r0.zzr(true);
                return r0;
            } else {
                valueOf = String.valueOf(obj);
                zzev(new StringBuilder(String.valueOf(valueOf).length() + 20).append("Invalid value type: ").append(valueOf).toString());
                return null;
            }
        } else if (obj instanceof Boolean) {
            return new zzqo(8, obj);
        } else {
            if (obj instanceof Integer) {
                return new zzqo(6, obj);
            }
            if (obj instanceof String) {
                return new zzqo(1, obj);
            }
            valueOf = String.valueOf(obj);
            zzev(new StringBuilder(String.valueOf(valueOf).length() + 20).append("Invalid value type: ").append(valueOf).toString());
            return null;
        }
    }

    static zzqj zzeu(String str) {
        JSONObject jSONObject = new JSONObject(str);
        JSONArray optJSONArray = jSONObject.optJSONArray("runtime");
        if (optJSONArray == null) {
            return null;
        }
        zzql zzql = new zzql();
        Object obj = jSONObject.get("resource");
        if (obj instanceof JSONObject) {
            zzql.zzfc(((JSONObject) obj).optString(ClientCookie.VERSION_ATTR));
            for (int i = 0; i < optJSONArray.length(); i++) {
                Object obj2 = optJSONArray.get(i);
                if (!(obj2 instanceof JSONArray) || ((JSONArray) obj2).length() != 0) {
                    zzql.zza(zzp(obj2));
                }
            }
            return zzql.zzsq();
        }
        throw new zzpa("Resource map not found");
    }

    public static zzjn zzp(Object obj) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        String str;
        int i = 1;
        int i2 = 0;
        JSONArray jSONArray3;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            String string = jSONObject.getString("name");
            jSONArray3 = jSONObject.getJSONArray("params");
            jSONArray = jSONObject.getJSONArray("instructions");
            jSONArray2 = jSONArray3;
            str = string;
        } else if (obj instanceof JSONArray) {
            JSONArray jSONArray4 = (JSONArray) obj;
            Preconditions.checkArgument(jSONArray4.length() >= 3);
            str = jSONArray4.getString(1);
            jSONArray = jSONArray4.getJSONArray(2);
            JSONArray jSONArray5 = new JSONArray();
            while (i < jSONArray.length()) {
                Preconditions.checkArgument(jSONArray.get(i) instanceof String);
                jSONArray5.put(jSONArray.get(i));
                i++;
            }
            jSONArray3 = new JSONArray();
            for (int i3 = 3; i3 < jSONArray4.length(); i3++) {
                jSONArray3.put(jSONArray4.get(i3));
            }
            jSONArray = jSONArray3;
            jSONArray2 = jSONArray5;
        } else {
            throw new IllegalArgumentException("invalid JSON in runtime section");
        }
        List arrayList = new ArrayList();
        for (i = 0; i < jSONArray2.length(); i++) {
            arrayList.add(jSONArray2.getString(i));
        }
        List arrayList2 = new ArrayList();
        while (i2 < jSONArray.length()) {
            jSONArray2 = jSONArray.getJSONArray(i2);
            if (jSONArray2.length() != 0) {
                arrayList2.add(zza(jSONArray2));
            }
            i2++;
        }
        return new zzjn(null, str, arrayList, arrayList2);
    }

    private static zzra zza(JSONArray jSONArray) {
        int i = 1;
        Preconditions.checkArgument(jSONArray.length() > 0);
        String string = jSONArray.getString(0);
        List arrayList = new ArrayList();
        while (i < jSONArray.length()) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                JSONArray jSONArray2 = (JSONArray) obj;
                if (jSONArray2.length() != 0) {
                    arrayList.add(zza(jSONArray2));
                }
            } else if (obj == JSONObject.NULL) {
                arrayList.add(zzqv.zzbpq);
            } else {
                arrayList.add(zzrd.zzr(obj));
            }
            i++;
        }
        return new zzra(string, arrayList);
    }

    private static void zzev(String str) {
        zzhk.m1081e(str);
        throw new zzpa(str);
    }
}
