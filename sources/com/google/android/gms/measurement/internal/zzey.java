package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;

public final class zzey<T extends Context & zzfc> {
    private final T zzaby;

    public zzey(T t) {
        Preconditions.checkNotNull(t);
        this.zzaby = t;
    }

    public final void onCreate() {
        zzbw zza = zzbw.zza(this.zzaby, null);
        zzas zzgt = zza.zzgt();
        zza.zzgw();
        zzgt.zzjo().zzby("Local AppMeasurementService is starting up");
    }

    public final void onDestroy() {
        zzbw zza = zzbw.zza(this.zzaby, null);
        zzas zzgt = zza.zzgt();
        zza.zzgw();
        zzgt.zzjo().zzby("Local AppMeasurementService is shutting down");
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        zzbw zza = zzbw.zza(this.zzaby, null);
        zzas zzgt = zza.zzgt();
        if (intent == null) {
            zzgt.zzjj().zzby("AppMeasurementService started with null intent");
        } else {
            String action = intent.getAction();
            zza.zzgw();
            zzgt.zzjo().zze("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
                zzb(new zzez(this, i2, zzgt, intent));
            }
        }
        return 2;
    }

    private final void zzb(Runnable runnable) {
        zzfo zzn = zzfo.zzn(this.zzaby);
        zzn.zzgs().zzc(new zzfb(this, zzn, runnable));
    }

    public final IBinder onBind(Intent intent) {
        if (intent == null) {
            zzgt().zzjg().zzby("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzby(zzfo.zzn(this.zzaby));
        }
        zzgt().zzjj().zzg("onBind received unknown action", action);
        return null;
    }

    public final boolean onUnbind(Intent intent) {
        if (intent == null) {
            zzgt().zzjg().zzby("onUnbind called with null intent");
        } else {
            zzgt().zzjo().zzg("onUnbind called for intent. action", intent.getAction());
        }
        return true;
    }

    @TargetApi(24)
    public final boolean onStartJob(JobParameters jobParameters) {
        zzbw zza = zzbw.zza(this.zzaby, null);
        zzas zzgt = zza.zzgt();
        String string = jobParameters.getExtras().getString("action");
        zza.zzgw();
        zzgt.zzjo().zzg("Local AppMeasurementJobService called. action", string);
        if ("com.google.android.gms.measurement.UPLOAD".equals(string)) {
            zzb(new zzfa(this, zzgt, jobParameters));
        }
        return true;
    }

    public final void onRebind(Intent intent) {
        if (intent == null) {
            zzgt().zzjg().zzby("onRebind called with null intent");
            return;
        }
        zzgt().zzjo().zzg("onRebind called. action", intent.getAction());
    }

    private final zzas zzgt() {
        return zzbw.zza(this.zzaby, null).zzgt();
    }

    final /* synthetic */ void zza(zzas zzas, JobParameters jobParameters) {
        zzas.zzjo().zzby("AppMeasurementJobService processed last upload request.");
        ((zzfc) this.zzaby).zza(jobParameters, false);
    }

    final /* synthetic */ void zza(int i, zzas zzas, Intent intent) {
        if (((zzfc) this.zzaby).callServiceStopSelfResult(i)) {
            zzas.zzjo().zzg("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzgt().zzjo().zzby("Completed wakeful intent.");
            ((zzfc) this.zzaby).zza(intent);
        }
    }
}
