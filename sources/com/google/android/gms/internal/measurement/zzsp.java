package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzsp implements zzsb {
    static final Map<String, zzsp> zzbrz = new HashMap();
    private final Object zzbrd = new Object();
    private volatile Map<String, ?> zzbre;
    private final List<zzsa> zzbrf = new ArrayList();
    private final SharedPreferences zzbsa;
    private final OnSharedPreferenceChangeListener zzbsb = new zzsq(this);

    static zzsp zzi(Context context, String str) {
        boolean z;
        if (!zzrw.zztj() || str.startsWith("direct_boot:")) {
            z = true;
        } else {
            z = zzrw.isUserUnlocked(context);
        }
        if (!z) {
            return null;
        }
        zzsp zzsp;
        synchronized (zzsp.class) {
            zzsp = (zzsp) zzbrz.get(str);
            if (zzsp == null) {
                SharedPreferences sharedPreferences;
                if (str.startsWith("direct_boot:")) {
                    if (zzrw.zztj()) {
                        context = context.createDeviceProtectedStorageContext();
                    }
                    sharedPreferences = context.getSharedPreferences(str.substring(12), 0);
                } else {
                    sharedPreferences = context.getSharedPreferences(str, 0);
                }
                zzsp = new zzsp(sharedPreferences);
                zzbrz.put(str, zzsp);
            }
        }
        return zzsp;
    }

    private zzsp(SharedPreferences sharedPreferences) {
        this.zzbsa = sharedPreferences;
        this.zzbsa.registerOnSharedPreferenceChangeListener(this.zzbsb);
    }

    public final Object zzfn(String str) {
        Map map = this.zzbre;
        if (map == null) {
            synchronized (this.zzbrd) {
                map = this.zzbre;
                if (map == null) {
                    map = this.zzbsa.getAll();
                    this.zzbre = map;
                }
            }
        }
        return map != null ? map.get(str) : null;
    }

    final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
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
}
