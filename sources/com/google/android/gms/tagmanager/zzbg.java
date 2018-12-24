package com.google.android.gms.tagmanager;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.Map;

final class zzbg extends zzcn {
    private final /* synthetic */ AppMeasurement zzbca;

    zzbg(AppMeasurement appMeasurement) {
        this.zzbca = appMeasurement;
    }

    public final void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) {
        this.zzbca.logEventInternalNoInterceptor(str, str2, bundle, j);
    }

    public final Map<String, Object> zzop() {
        return this.zzbca.getUserProperties(true);
    }

    public final void zza(zzcj zzcj) {
        this.zzbca.setEventInterceptor(new zzbh(this, zzcj));
    }

    public final void zza(zzcg zzcg) {
        this.zzbca.registerOnMeasurementEventListener(new zzbi(this, zzcg));
    }
}
