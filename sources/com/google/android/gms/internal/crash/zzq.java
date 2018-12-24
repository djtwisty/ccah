package com.google.android.gms.internal.crash;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.AppMeasurement.Event;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crash.FirebaseCrash.zza;
import java.util.concurrent.ExecutorService;

public final class zzq {
    private final AnalyticsConnector zzan;

    public zzq(AnalyticsConnector analyticsConnector) {
        this.zzan = analyticsConnector;
    }

    public final void zza(boolean z, long j) {
        Bundle bundle = new Bundle();
        bundle.putInt(Param.FATAL, z ? 1 : 0);
        bundle.putLong(Param.TIMESTAMP, j);
        this.zzan.logEvent(AppMeasurement.CRASH_ORIGIN, Event.APP_EXCEPTION, bundle);
    }

    public final void zza(Context context, ExecutorService executorService, zza zza) {
        this.zzan.registerAnalyticsConnectorListener(AppMeasurement.CRASH_ORIGIN, new zzr(context, executorService, zza));
    }
}
