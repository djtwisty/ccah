package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

@VisibleForTesting
public abstract class zzi<T extends zzi> {
    public abstract void zzb(T t);

    public static String zza(Map map) {
        return zza(map, 1);
    }

    public static String zza(Object obj) {
        return zza(obj, 0);
    }

    private static String zza(Object obj, int i) {
        if (i > 10) {
            return "ERROR: Recursive toString calls";
        }
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            if (TextUtils.isEmpty((String) obj)) {
                return "";
            }
            return obj.toString();
        } else if (obj instanceof Integer) {
            if (((Integer) obj).intValue() == 0) {
                return "";
            }
            return obj.toString();
        } else if (obj instanceof Long) {
            if (((Long) obj).longValue() == 0) {
                return "";
            }
            return obj.toString();
        } else if (obj instanceof Double) {
            if (((Double) obj).doubleValue() == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return "";
            }
            return obj.toString();
        } else if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                return obj.toString();
            }
            return "";
        } else if (obj instanceof List) {
            StringBuilder stringBuilder = new StringBuilder();
            if (i > 0) {
                stringBuilder.append("[");
            }
            List list = (List) obj;
            r1 = stringBuilder.length();
            for (Object next : list) {
                if (stringBuilder.length() > r1) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(zza(next, i + 1));
            }
            if (i > 0) {
                stringBuilder.append("]");
            }
            return stringBuilder.toString();
        } else if (!(obj instanceof Map)) {
            return obj.toString();
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            r1 = 0;
            Object obj2 = null;
            for (Entry entry : new TreeMap((Map) obj).entrySet()) {
                Object zza = zza(entry.getValue(), i + 1);
                if (!TextUtils.isEmpty(zza)) {
                    if (i > 0 && obj2 == null) {
                        stringBuilder2.append("{");
                        obj2 = 1;
                        r1 = stringBuilder2.length();
                    }
                    if (stringBuilder2.length() > r1) {
                        stringBuilder2.append(", ");
                    }
                    stringBuilder2.append((String) entry.getKey());
                    stringBuilder2.append('=');
                    stringBuilder2.append(zza);
                }
            }
            if (obj2 != null) {
                stringBuilder2.append("}");
            }
            return stringBuilder2.toString();
        }
    }
}
