package com.google.firebase.auth.internal;

import android.support.v4.p017e.C0238a;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzaf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

final class zzab {
    private static final Logger zzgg = new Logger("JSONParser", new String[0]);

    public static Map<String, Object> zzcw(String str) {
        Preconditions.checkNotEmpty(str);
        String[] split = str.split("\\.");
        if (split.length < 2) {
            Logger logger = zzgg;
            String str2 = "Invalid idToken ";
            String valueOf = String.valueOf(str);
            logger.m1072e(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), new Object[0]);
            return Collections.EMPTY_MAP;
        }
        try {
            Map<String, Object> zzcx = zzcx(new String(Base64Utils.decodeUrlSafeNoPadding(split[1]), HTTP.UTF_8));
            if (zzcx == null) {
                return Collections.EMPTY_MAP;
            }
            return zzcx;
        } catch (Throwable e) {
            zzgg.m1071e("Unable to decode token", e, new Object[0]);
            return Collections.EMPTY_MAP;
        }
    }

    public static Map<String, Object> zzcx(String str) {
        Map<String, Object> map = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != JSONObject.NULL) {
                    map = zzb(jSONObject);
                }
            } catch (Throwable e) {
                Log.d("JSONParser", "Failed to parse JSONObject into Map.");
                throw new zzaf(e);
            }
        }
        return map;
    }

    @VisibleForTesting
    private static Map<String, Object> zzb(JSONObject jSONObject) {
        Map<String, Object> c0238a = new C0238a();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (obj instanceof JSONArray) {
                obj = zza((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = zzb((JSONObject) obj);
            }
            c0238a.put(str, obj);
        }
        return c0238a;
    }

    @VisibleForTesting
    private static List<Object> zza(JSONArray jSONArray) {
        List<Object> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = zza((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = zzb((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }
}
