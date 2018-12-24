package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import java.util.Set;

public final class zzf implements zza {
    private AppMeasurement zzbsq;
    private AnalyticsConnectorListener zzbtd;
    private zzg zzbtg = new zzg(this);

    public zzf(AppMeasurement appMeasurement, AnalyticsConnectorListener analyticsConnectorListener) {
        this.zzbtd = analyticsConnectorListener;
        this.zzbsq = appMeasurement;
        this.zzbsq.registerOnMeasurementEventListener(this.zzbtg);
    }

    public final AnalyticsConnectorListener zztv() {
        return this.zzbtd;
    }

    public final void registerEventNames(Set<String> set) {
    }

    public final void unregisterEventNames() {
    }
}
