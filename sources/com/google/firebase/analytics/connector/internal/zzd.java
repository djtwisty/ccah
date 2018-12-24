package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class zzd implements zza {
    private AppMeasurement zzbsq;
    Set<String> zzbtc;
    private AnalyticsConnectorListener zzbtd;
    private zze zzbte = new zze(this);

    public zzd(AppMeasurement appMeasurement, AnalyticsConnectorListener analyticsConnectorListener) {
        this.zzbtd = analyticsConnectorListener;
        this.zzbsq = appMeasurement;
        this.zzbsq.registerOnMeasurementEventListener(this.zzbte);
        this.zzbtc = new HashSet();
    }

    public final AnalyticsConnectorListener zztv() {
        return this.zzbtd;
    }

    public final void registerEventNames(Set<String> set) {
        this.zzbtc.clear();
        Set set2 = this.zzbtc;
        Collection hashSet = new HashSet();
        for (String str : set) {
            if (hashSet.size() >= 50) {
                break;
            } else if (zzc.zzfw(str) && zzc.zzfv(str)) {
                hashSet.add(zzc.zzfy(str));
            }
        }
        set2.addAll(hashSet);
    }

    public final void unregisterEventNames() {
        this.zzbtc.clear();
    }
}
