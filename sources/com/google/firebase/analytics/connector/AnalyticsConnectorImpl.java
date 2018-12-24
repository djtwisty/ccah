package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zzan;
import com.google.android.gms.measurement.internal.zzbw;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import com.google.firebase.analytics.connector.AnalyticsConnector.ConditionalUserProperty;
import com.google.firebase.analytics.connector.internal.zza;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zzd;
import com.google.firebase.analytics.connector.internal.zzf;
import com.google.firebase.events.Event;
import com.google.firebase.events.Subscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AnalyticsConnectorImpl implements AnalyticsConnector {
    private static volatile AnalyticsConnector zzbsp;
    @VisibleForTesting
    private final AppMeasurement zzbsq;
    @VisibleForTesting
    final Map<String, zza> zzbsr = new ConcurrentHashMap();

    private AnalyticsConnectorImpl(AppMeasurement appMeasurement) {
        Preconditions.checkNotNull(appMeasurement);
        this.zzbsq = appMeasurement;
    }

    @KeepForSdk
    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp, Context context, Subscriber subscriber) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(subscriber);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzbsp == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                if (zzbsp == null) {
                    Bundle bundle = new Bundle(1);
                    if (firebaseApp.isDefaultApp()) {
                        subscriber.subscribe(DataCollectionDefaultChange.class, zza.zzbss, zzb.zzbst);
                        bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.isDataCollectionDefaultEnabled());
                    }
                    zzbsp = new AnalyticsConnectorImpl(zzbw.zza(context, zzan.zzc(bundle)).zzkm());
                }
            }
        }
        return zzbsp;
    }

    @KeepForSdk
    public static AnalyticsConnector getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    @KeepForSdk
    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp) {
        return (AnalyticsConnector) firebaseApp.get(AnalyticsConnector.class);
    }

    @KeepForSdk
    public void logEvent(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (zzc.zzft(str) && zzc.zza(str2, bundle) && zzc.zzb(str, str2, bundle)) {
            this.zzbsq.logEventInternal(str, str2, bundle);
        }
    }

    @KeepForSdk
    public void setUserProperty(String str, String str2, Object obj) {
        if (zzc.zzft(str) && zzc.zzz(str, str2)) {
            this.zzbsq.setUserPropertyInternal(str, str2, obj);
        }
    }

    @KeepForSdk
    public Map<String, Object> getUserProperties(boolean z) {
        return this.zzbsq.getUserProperties(z);
    }

    @KeepForSdk
    public AnalyticsConnectorHandle registerAnalyticsConnectorListener(final String str, AnalyticsConnectorListener analyticsConnectorListener) {
        Preconditions.checkNotNull(analyticsConnectorListener);
        if (!zzc.zzft(str) || zzfs(str)) {
            return null;
        }
        AppMeasurement appMeasurement = this.zzbsq;
        Object zzd = AppMeasurement.FIAM_ORIGIN.equals(str) ? new zzd(appMeasurement, analyticsConnectorListener) : AppMeasurement.CRASH_ORIGIN.equals(str) ? new zzf(appMeasurement, analyticsConnectorListener) : null;
        if (zzd == null) {
            return null;
        }
        this.zzbsr.put(str, zzd);
        return new AnalyticsConnectorHandle(this) {
            private final /* synthetic */ AnalyticsConnectorImpl zzbsu;

            public void unregister() {
                if (this.zzbsu.zzfs(str)) {
                    AnalyticsConnectorListener zztv = ((zza) this.zzbsu.zzbsr.get(str)).zztv();
                    if (zztv != null) {
                        zztv.onMessageTriggered(0, null);
                    }
                    this.zzbsu.zzbsr.remove(str);
                }
            }

            @KeepForSdk
            public void registerEventNames(Set<String> set) {
                if (this.zzbsu.zzfs(str) && str.equals(AppMeasurement.FIAM_ORIGIN) && set != null && !set.isEmpty()) {
                    ((zza) this.zzbsu.zzbsr.get(str)).registerEventNames(set);
                }
            }

            @KeepForSdk
            public void unregisterEventNames() {
                if (this.zzbsu.zzfs(str) && str.equals(AppMeasurement.FIAM_ORIGIN)) {
                    ((zza) this.zzbsu.zzbsr.get(str)).unregisterEventNames();
                }
            }
        };
    }

    @KeepForSdk
    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        if (zzc.zza(conditionalUserProperty)) {
            this.zzbsq.setConditionalUserProperty(zzc.zzb(conditionalUserProperty));
        }
    }

    @KeepForSdk
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        if (str2 == null || zzc.zza(str2, bundle)) {
            this.zzbsq.clearConditionalUserProperty(str, str2, bundle);
        }
    }

    @KeepForSdk
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        List<ConditionalUserProperty> arrayList = new ArrayList();
        for (AppMeasurement.ConditionalUserProperty zzd : this.zzbsq.getConditionalUserProperties(str, str2)) {
            arrayList.add(zzc.zzd(zzd));
        }
        return arrayList;
    }

    @KeepForSdk
    public int getMaxUserProperties(String str) {
        return this.zzbsq.getMaxUserProperties(str);
    }

    private final boolean zzfs(String str) {
        return (str.isEmpty() || !this.zzbsr.containsKey(str) || this.zzbsr.get(str) == null) ? false : true;
    }

    static final /* synthetic */ void zza(Event event) {
        boolean z = ((DataCollectionDefaultChange) event.getPayload()).enabled;
        synchronized (AnalyticsConnectorImpl.class) {
            ((AnalyticsConnectorImpl) zzbsp).zzbsq.zzd(z);
        }
    }
}
