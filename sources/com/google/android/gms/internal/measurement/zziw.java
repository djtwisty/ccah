package com.google.android.gms.internal.measurement;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

final class zziw implements ComponentCallbacks2 {
    final /* synthetic */ zzin zzblk;

    zziw(zzin zzin) {
        this.zzblk = zzin;
    }

    public final void onTrimMemory(int i) {
        if (i == 20) {
            this.zzblk.zzbif.execute(new zzix(this));
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }
}
