package com.google.android.gms.tagmanager;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement.EventInterceptor;

final class zzbh implements EventInterceptor {
    private final /* synthetic */ zzcj zzbcb;

    zzbh(zzbg zzbg, zzcj zzcj) {
        this.zzbcb = zzcj;
    }

    public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
        try {
            this.zzbcb.interceptEvent(str, str2, bundle, j);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
