package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.google.android.gms.analytics.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzbc implements ServiceConnection {
    final /* synthetic */ zzba zzxa;
    private volatile zzcl zzxb;
    private volatile boolean zzxc;

    protected zzbc(zzba zzba) {
        this.zzxa = zzba;
    }

    public final zzcl zzda() {
        zzcl zzcl = null;
        zzk.zzaf();
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
        Context context = this.zzxa.getContext();
        intent.putExtra("app_package_name", context.getPackageName());
        ConnectionTracker instance = ConnectionTracker.getInstance();
        synchronized (this) {
            this.zzxb = null;
            this.zzxc = true;
            boolean bindService = instance.bindService(context, intent, this.zzxa.zzww, 129);
            this.zzxa.zza("Bind to service requested", Boolean.valueOf(bindService));
            if (bindService) {
                try {
                    wait(((Long) zzcf.zzaag.get()).longValue());
                } catch (InterruptedException e) {
                    this.zzxa.zzt("Wait for service connect was interrupted");
                }
                this.zzxc = false;
                zzcl = this.zzxb;
                this.zzxb = null;
                if (zzcl == null) {
                    this.zzxa.zzu("Successfully bound to service but never got onServiceConnected callback");
                }
            } else {
                this.zzxc = false;
            }
        }
        return zzcl;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(android.content.ComponentName r5, android.os.IBinder r6) {
        /*
        r4 = this;
        r1 = 0;
        r0 = "AnalyticsServiceConnection.onServiceConnected";
        com.google.android.gms.common.internal.Preconditions.checkMainThread(r0);
        monitor-enter(r4);
        if (r6 != 0) goto L_0x0015;
    L_0x0009:
        r0 = r4.zzxa;	 Catch:{ all -> 0x0065 }
        r1 = "Service connected with null binder";
        r0.zzu(r1);	 Catch:{ all -> 0x0065 }
        r4.notifyAll();	 Catch:{ all -> 0x0045 }
        monitor-exit(r4);	 Catch:{ all -> 0x0045 }
    L_0x0014:
        return;
    L_0x0015:
        r0 = r6.getInterfaceDescriptor();	 Catch:{ RemoteException -> 0x005b }
        r2 = "com.google.android.gms.analytics.internal.IAnalyticsService";
        r2 = r2.equals(r0);	 Catch:{ RemoteException -> 0x005b }
        if (r2 == 0) goto L_0x006a;
    L_0x0021:
        if (r6 != 0) goto L_0x0048;
    L_0x0023:
        r0 = r1;
    L_0x0024:
        r1 = r4.zzxa;	 Catch:{ RemoteException -> 0x0092 }
        r2 = "Bound to IAnalyticsService interface";
        r1.zzq(r2);	 Catch:{ RemoteException -> 0x0092 }
    L_0x002b:
        if (r0 != 0) goto L_0x0073;
    L_0x002d:
        r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance();	 Catch:{ IllegalArgumentException -> 0x0090 }
        r1 = r4.zzxa;	 Catch:{ IllegalArgumentException -> 0x0090 }
        r1 = r1.getContext();	 Catch:{ IllegalArgumentException -> 0x0090 }
        r2 = r4.zzxa;	 Catch:{ IllegalArgumentException -> 0x0090 }
        r2 = r2.zzww;	 Catch:{ IllegalArgumentException -> 0x0090 }
        r0.unbindService(r1, r2);	 Catch:{ IllegalArgumentException -> 0x0090 }
    L_0x0040:
        r4.notifyAll();	 Catch:{ all -> 0x0045 }
        monitor-exit(r4);	 Catch:{ all -> 0x0045 }
        goto L_0x0014;
    L_0x0045:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0045 }
        throw r0;
    L_0x0048:
        r0 = "com.google.android.gms.analytics.internal.IAnalyticsService";
        r0 = r6.queryLocalInterface(r0);	 Catch:{ RemoteException -> 0x005b }
        r2 = r0 instanceof com.google.android.gms.internal.measurement.zzcl;	 Catch:{ RemoteException -> 0x005b }
        if (r2 == 0) goto L_0x0055;
    L_0x0052:
        r0 = (com.google.android.gms.internal.measurement.zzcl) r0;	 Catch:{ RemoteException -> 0x005b }
        goto L_0x0024;
    L_0x0055:
        r0 = new com.google.android.gms.internal.measurement.zzcm;	 Catch:{ RemoteException -> 0x005b }
        r0.<init>(r6);	 Catch:{ RemoteException -> 0x005b }
        goto L_0x0024;
    L_0x005b:
        r0 = move-exception;
        r0 = r1;
    L_0x005d:
        r1 = r4.zzxa;	 Catch:{ all -> 0x0065 }
        r2 = "Service connect failed to get IAnalyticsService";
        r1.zzu(r2);	 Catch:{ all -> 0x0065 }
        goto L_0x002b;
    L_0x0065:
        r0 = move-exception;
        r4.notifyAll();	 Catch:{ all -> 0x0045 }
        throw r0;	 Catch:{ all -> 0x0045 }
    L_0x006a:
        r2 = r4.zzxa;	 Catch:{ RemoteException -> 0x005b }
        r3 = "Got binder with a wrong descriptor";
        r2.zze(r3, r0);	 Catch:{ RemoteException -> 0x005b }
        r0 = r1;
        goto L_0x002b;
    L_0x0073:
        r1 = r4.zzxc;	 Catch:{ all -> 0x0065 }
        if (r1 != 0) goto L_0x008d;
    L_0x0077:
        r1 = r4.zzxa;	 Catch:{ all -> 0x0065 }
        r2 = "onServiceConnected received after the timeout limit";
        r1.zzt(r2);	 Catch:{ all -> 0x0065 }
        r1 = r4.zzxa;	 Catch:{ all -> 0x0065 }
        r1 = r1.zzca();	 Catch:{ all -> 0x0065 }
        r2 = new com.google.android.gms.internal.measurement.zzbd;	 Catch:{ all -> 0x0065 }
        r2.<init>(r4, r0);	 Catch:{ all -> 0x0065 }
        r1.zza(r2);	 Catch:{ all -> 0x0065 }
        goto L_0x0040;
    L_0x008d:
        r4.zzxb = r0;	 Catch:{ all -> 0x0065 }
        goto L_0x0040;
    L_0x0090:
        r0 = move-exception;
        goto L_0x0040;
    L_0x0092:
        r1 = move-exception;
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbc.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("AnalyticsServiceConnection.onServiceDisconnected");
        this.zzxa.zzca().zza(new zzbe(this, componentName));
    }
}
