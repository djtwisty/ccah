package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.support.v4.p013b.C0212e;
import android.util.Log;

final class zzse implements zzsb {
    static zzse zzbrj;
    private final Context zzri;

    static zzse zzad(Context context) {
        zzse zzse;
        synchronized (zzse.class) {
            if (zzbrj == null) {
                zzbrj = (C0212e.m654a(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? 1 : null) != null ? new zzse(context) : new zzse();
            }
            zzse = zzbrj;
        }
        return zzse;
    }

    private zzse(Context context) {
        this.zzri = context;
        this.zzri.getContentResolver().registerContentObserver(zzru.CONTENT_URI, true, new zzsg(this, null));
    }

    private zzse() {
        this.zzri = null;
    }

    private final String zzfo(String str) {
        if (this.zzri == null) {
            return null;
        }
        try {
            return (String) zzsc.zza(new zzsf(this, str));
        } catch (Throwable e) {
            Throwable th = e;
            String str2 = "GservicesLoader";
            String str3 = "Unable to read GServices for: ";
            String valueOf = String.valueOf(str);
            Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), th);
            return null;
        }
    }

    public final /* synthetic */ Object zzfn(String str) {
        return zzfo(str);
    }

    final /* synthetic */ String zzfp(String str) {
        return zzru.zza(this.zzri.getContentResolver(), str, null);
    }
}
