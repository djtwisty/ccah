package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzru {
    public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static final Uri zzbqn = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzbqo = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzbqp = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zzbqq = new AtomicBoolean();
    private static HashMap<String, String> zzbqr;
    private static final HashMap<String, Boolean> zzbqs = new HashMap();
    private static final HashMap<String, Integer> zzbqt = new HashMap();
    private static final HashMap<String, Long> zzbqu = new HashMap();
    private static final HashMap<String, Float> zzbqv = new HashMap();
    private static Object zzbqw;
    private static boolean zzbqx;
    private static String[] zzbqy = new String[0];

    private static void zza(ContentResolver contentResolver) {
        if (zzbqr == null) {
            zzbqq.set(false);
            zzbqr = new HashMap();
            zzbqw = new Object();
            zzbqx = false;
            contentResolver.registerContentObserver(CONTENT_URI, true, new zzrv(null));
        } else if (zzbqq.getAndSet(false)) {
            zzbqr.clear();
            zzbqs.clear();
            zzbqt.clear();
            zzbqu.clear();
            zzbqv.clear();
            zzbqw = new Object();
            zzbqx = false;
        }
    }

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        String str3 = null;
        synchronized (zzru.class) {
            zza(contentResolver);
            Object obj = zzbqw;
            String str4;
            if (zzbqr.containsKey(str)) {
                str4 = (String) zzbqr.get(str);
                if (str4 != null) {
                    str3 = str4;
                }
            } else {
                String[] strArr = zzbqy;
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    if (str.startsWith(strArr[i])) {
                        if (!zzbqx || zzbqr.isEmpty()) {
                            zzbqr.putAll(zza(contentResolver, zzbqy));
                            zzbqx = true;
                            if (zzbqr.containsKey(str)) {
                                str4 = (String) zzbqr.get(str);
                                if (str4 != null) {
                                    str3 = str4;
                                }
                            }
                        }
                    } else {
                        i++;
                    }
                }
                Cursor query = contentResolver.query(CONTENT_URI, null, null, new String[]{str}, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            str4 = query.getString(1);
                            if (str4 != null && str4.equals(null)) {
                                str4 = null;
                            }
                            zza(obj, str, str4);
                            if (str4 != null) {
                                str3 = str4;
                            }
                            if (query != null) {
                                query.close();
                            }
                        } else {
                            zza(obj, str, null);
                            if (query != null) {
                                query.close();
                            }
                        }
                    } catch (Throwable th) {
                        if (query != null) {
                            query.close();
                        }
                    }
                } else if (query != null) {
                    query.close();
                }
            }
        }
        return str3;
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzru.class) {
            if (obj == zzbqw) {
                zzbqr.put(str, str2);
            }
        }
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzbqn, null, null, strArr, null);
        Map<String, String> treeMap = new TreeMap();
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    treeMap.put(query.getString(0), query.getString(1));
                } finally {
                    query.close();
                }
            }
        }
        return treeMap;
    }
}
