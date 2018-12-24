package com.google.android.gms.measurement;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.support.v4.p013b.C0213f;
import com.google.android.gms.measurement.internal.zzbm;
import com.google.android.gms.measurement.internal.zzbp;

public final class AppMeasurementReceiver extends C0213f implements zzbp {
    private zzbm zzadb;

    public final void onReceive(Context context, Intent intent) {
        if (this.zzadb == null) {
            this.zzadb = new zzbm(this);
        }
        this.zzadb.onReceive(context, intent);
    }

    public final void doStartService(Context context, Intent intent) {
        C0213f.startWakefulService(context, intent);
    }

    public final PendingResult doGoAsync() {
        return goAsync();
    }
}
