package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzed implements Runnable {
    private final /* synthetic */ boolean zzaeg;
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzeb zzasi;
    private final /* synthetic */ AtomicReference zzasj;

    zzed(zzeb zzeb, AtomicReference atomicReference, zzk zzk, boolean z) {
        this.zzasi = zzeb;
        this.zzasj = atomicReference;
        this.zzaqk = zzk;
        this.zzaeg = z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r5 = this;
        r1 = r5.zzasj;
        monitor-enter(r1);
        r0 = r5.zzasi;	 Catch:{ RemoteException -> 0x003d }
        r0 = r0.zzasc;	 Catch:{ RemoteException -> 0x003d }
        if (r0 != 0) goto L_0x0021;
    L_0x000b:
        r0 = r5.zzasi;	 Catch:{ RemoteException -> 0x003d }
        r0 = r0.zzgt();	 Catch:{ RemoteException -> 0x003d }
        r0 = r0.zzjg();	 Catch:{ RemoteException -> 0x003d }
        r2 = "Failed to get user properties";
        r0.zzby(r2);	 Catch:{ RemoteException -> 0x003d }
        r0 = r5.zzasj;	 Catch:{ all -> 0x003a }
        r0.notify();	 Catch:{ all -> 0x003a }
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
    L_0x0020:
        return;
    L_0x0021:
        r2 = r5.zzasj;	 Catch:{ RemoteException -> 0x003d }
        r3 = r5.zzaqk;	 Catch:{ RemoteException -> 0x003d }
        r4 = r5.zzaeg;	 Catch:{ RemoteException -> 0x003d }
        r0 = r0.zza(r3, r4);	 Catch:{ RemoteException -> 0x003d }
        r2.set(r0);	 Catch:{ RemoteException -> 0x003d }
        r0 = r5.zzasi;	 Catch:{ RemoteException -> 0x003d }
        r0.zzcy();	 Catch:{ RemoteException -> 0x003d }
        r0 = r5.zzasj;	 Catch:{ all -> 0x003a }
        r0.notify();	 Catch:{ all -> 0x003a }
    L_0x0038:
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        goto L_0x0020;
    L_0x003a:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
    L_0x003d:
        r0 = move-exception;
        r2 = r5.zzasi;	 Catch:{ all -> 0x0053 }
        r2 = r2.zzgt();	 Catch:{ all -> 0x0053 }
        r2 = r2.zzjg();	 Catch:{ all -> 0x0053 }
        r3 = "Failed to get user properties";
        r2.zzg(r3, r0);	 Catch:{ all -> 0x0053 }
        r0 = r5.zzasj;	 Catch:{ all -> 0x003a }
        r0.notify();	 Catch:{ all -> 0x003a }
        goto L_0x0038;
    L_0x0053:
        r0 = move-exception;
        r2 = r5.zzasj;	 Catch:{ all -> 0x003a }
        r2.notify();	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzed.run():void");
    }
}
