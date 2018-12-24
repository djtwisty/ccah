package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.support.v4.p017e.C0238a;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzrx implements zzsb {
    static final Map<Uri, zzrx> zzbrb = new C0238a();
    private static final String[] zzbrg = new String[]{"key", Param.VALUE};
    private final Uri uri;
    private final ContentResolver zzbrc;
    private final Object zzbrd = new Object();
    private volatile Map<String, String> zzbre;
    private final List<zzsa> zzbrf = new ArrayList();

    private zzrx(ContentResolver contentResolver, Uri uri) {
        this.zzbrc = contentResolver;
        this.uri = uri;
        this.zzbrc.registerContentObserver(uri, false, new zzrz(this, null));
    }

    public static zzrx zza(ContentResolver contentResolver, Uri uri) {
        zzrx zzrx;
        synchronized (zzrx.class) {
            zzrx = (zzrx) zzbrb.get(uri);
            if (zzrx == null) {
                try {
                    zzrx zzrx2 = new zzrx(contentResolver, uri);
                    try {
                        zzbrb.put(uri, zzrx2);
                        zzrx = zzrx2;
                    } catch (SecurityException e) {
                        zzrx = zzrx2;
                    }
                } catch (SecurityException e2) {
                }
            }
        }
        return zzrx;
    }

    public final Map<String, String> zztk() {
        Map<String, String> map = this.zzbre;
        if (map == null) {
            synchronized (this.zzbrd) {
                map = this.zzbre;
                if (map == null) {
                    map = zztm();
                    this.zzbre = map;
                }
            }
        }
        return map != null ? map : Collections.emptyMap();
    }

    public final void zztl() {
        synchronized (this.zzbrd) {
            this.zzbre = null;
            zzsi.zztq();
        }
        synchronized (this) {
            for (zzsa zztp : this.zzbrf) {
                zztp.zztp();
            }
        }
    }

    private final Map<String, String> zztm() {
        try {
            return (Map) zzsc.zza(new zzry(this));
        } catch (SecurityException e) {
        } catch (SQLiteException e2) {
        }
        Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
        return null;
    }

    public final /* synthetic */ Object zzfn(String str) {
        return (String) zztk().get(str);
    }

    final /* synthetic */ Map zztn() {
        Cursor query = this.zzbrc.query(this.uri, zzbrg, null, null, null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            Map emptyMap;
            if (count == 0) {
                emptyMap = Collections.emptyMap();
                return emptyMap;
            }
            if (count <= 256) {
                emptyMap = new C0238a(count);
            } else {
                emptyMap = new HashMap(count, 1.0f);
            }
            while (query.moveToNext()) {
                emptyMap.put(query.getString(0), query.getString(1));
            }
            query.close();
            return emptyMap;
        } finally {
            query.close();
        }
    }
}
