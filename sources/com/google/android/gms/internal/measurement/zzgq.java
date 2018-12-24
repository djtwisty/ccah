package com.google.android.gms.internal.measurement;

import android.util.Log;

public final class zzgq implements zzhl {
    private boolean zzbis = true;
    private int zzyn = 5;

    /* renamed from: e */
    public final void mo913e(String str) {
        if (isLoggable(6)) {
            Log.e("GoogleTagManager", str);
        }
    }

    public final void zza(String str, Throwable th) {
        if (isLoggable(6)) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    public final void zzab(String str) {
        if (isLoggable(5)) {
            Log.w("GoogleTagManager", str);
        }
    }

    public final void zzb(String str, Throwable th) {
        if (isLoggable(5)) {
            Log.w("GoogleTagManager", str, th);
        }
    }

    public final void zzdm(String str) {
        if (isLoggable(4)) {
            Log.i("GoogleTagManager", str);
        }
    }

    /* renamed from: v */
    public final void mo914v(String str) {
        if (isLoggable(2)) {
            Log.v("GoogleTagManager", str);
        }
    }

    private final boolean isLoggable(int i) {
        return (this.zzbis && Log.isLoggable("GoogleTagManager", i)) || (!this.zzbis && this.zzyn <= i);
    }
}
