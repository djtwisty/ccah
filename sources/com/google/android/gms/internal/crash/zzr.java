package com.google.android.gms.internal.crash;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import com.google.firebase.crash.FirebaseCrash.zza;
import java.util.concurrent.ExecutorService;

final class zzr implements AnalyticsConnectorListener {
    private final zza zzac;
    private final ExecutorService zzao;
    private final Context zzf;

    public zzr(Context context, ExecutorService executorService, zza zza) {
        this.zzf = context.getApplicationContext();
        this.zzao = executorService;
        this.zzac = zza;
    }

    public final void onMessageTriggered(int i, Bundle bundle) {
        if (i == 3 && this.zzac != null && bundle != null) {
            this.zzao.execute(new zzd(this.zzf, this.zzac, bundle.getString("name"), bundle.getLong("timestampInMillis"), bundle.getBundle("params")));
        }
    }
}
