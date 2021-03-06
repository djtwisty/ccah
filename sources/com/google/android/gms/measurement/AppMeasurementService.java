package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.p013b.C0213f;
import com.google.android.gms.measurement.internal.zzey;
import com.google.android.gms.measurement.internal.zzfc;

public final class AppMeasurementService extends Service implements zzfc {
    private zzey<AppMeasurementService> zzadc;

    private final zzey<AppMeasurementService> zzfz() {
        if (this.zzadc == null) {
            this.zzadc = new zzey(this);
        }
        return this.zzadc;
    }

    public final void onCreate() {
        super.onCreate();
        zzfz().onCreate();
    }

    public final void onDestroy() {
        zzfz().onDestroy();
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        return zzfz().onStartCommand(intent, i, i2);
    }

    public final IBinder onBind(Intent intent) {
        return zzfz().onBind(intent);
    }

    public final boolean onUnbind(Intent intent) {
        return zzfz().onUnbind(intent);
    }

    public final void onRebind(Intent intent) {
        zzfz().onRebind(intent);
    }

    public final boolean callServiceStopSelfResult(int i) {
        return stopSelfResult(i);
    }

    public final void zza(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    public final void zza(Intent intent) {
        C0213f.completeWakefulIntent(intent);
    }
}
