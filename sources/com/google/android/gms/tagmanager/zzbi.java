package com.google.android.gms.tagmanager;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement.OnEventListener;

final class zzbi implements OnEventListener {
    private final /* synthetic */ zzcg zzbcc;

    zzbi(zzbg zzbg, zzcg zzcg) {
        this.zzbcc = zzcg;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        try {
            this.zzbcc.onEvent(str, str2, bundle, j);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
