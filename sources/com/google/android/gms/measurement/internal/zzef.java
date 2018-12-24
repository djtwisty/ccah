package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzef implements Runnable {
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzeb zzasi;
    private final /* synthetic */ AtomicReference zzasj;

    zzef(zzeb zzeb, AtomicReference atomicReference, zzk zzk) {
        this.zzasi = zzeb;
        this.zzasj = atomicReference;
        this.zzaqk = zzk;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r4 = this;
        r1 = r4.zzasj;
        monitor-enter(r1);
        r0 = r4.zzasi;	 Catch:{ RemoteException -> 0x0059 }
        r0 = r0.zzasc;	 Catch:{ RemoteException -> 0x0059 }
        if (r0 != 0) goto L_0x0021;
    L_0x000b:
        r0 = r4.zzasi;	 Catch:{ RemoteException -> 0x0059 }
        r0 = r0.zzgt();	 Catch:{ RemoteException -> 0x0059 }
        r0 = r0.zzjg();	 Catch:{ RemoteException -> 0x0059 }
        r2 = "Failed to get app instance id";
        r0.zzby(r2);	 Catch:{ RemoteException -> 0x0059 }
        r0 = r4.zzasj;	 Catch:{ all -> 0x0056 }
        r0.notify();	 Catch:{ all -> 0x0056 }
        monitor-exit(r1);	 Catch:{ all -> 0x0056 }
    L_0x0020:
        return;
    L_0x0021:
        r2 = r4.zzasj;	 Catch:{ RemoteException -> 0x0059 }
        r3 = r4.zzaqk;	 Catch:{ RemoteException -> 0x0059 }
        r0 = r0.zzc(r3);	 Catch:{ RemoteException -> 0x0059 }
        r2.set(r0);	 Catch:{ RemoteException -> 0x0059 }
        r0 = r4.zzasj;	 Catch:{ RemoteException -> 0x0059 }
        r0 = r0.get();	 Catch:{ RemoteException -> 0x0059 }
        r0 = (java.lang.String) r0;	 Catch:{ RemoteException -> 0x0059 }
        if (r0 == 0) goto L_0x004a;
    L_0x0036:
        r2 = r4.zzasi;	 Catch:{ RemoteException -> 0x0059 }
        r2 = r2.zzgj();	 Catch:{ RemoteException -> 0x0059 }
        r2.zzcp(r0);	 Catch:{ RemoteException -> 0x0059 }
        r2 = r4.zzasi;	 Catch:{ RemoteException -> 0x0059 }
        r2 = r2.zzgu();	 Catch:{ RemoteException -> 0x0059 }
        r2 = r2.zzanh;	 Catch:{ RemoteException -> 0x0059 }
        r2.zzcd(r0);	 Catch:{ RemoteException -> 0x0059 }
    L_0x004a:
        r0 = r4.zzasi;	 Catch:{ RemoteException -> 0x0059 }
        r0.zzcy();	 Catch:{ RemoteException -> 0x0059 }
        r0 = r4.zzasj;	 Catch:{ all -> 0x0056 }
        r0.notify();	 Catch:{ all -> 0x0056 }
    L_0x0054:
        monitor-exit(r1);	 Catch:{ all -> 0x0056 }
        goto L_0x0020;
    L_0x0056:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0056 }
        throw r0;
    L_0x0059:
        r0 = move-exception;
        r2 = r4.zzasi;	 Catch:{ all -> 0x006f }
        r2 = r2.zzgt();	 Catch:{ all -> 0x006f }
        r2 = r2.zzjg();	 Catch:{ all -> 0x006f }
        r3 = "Failed to get app instance id";
        r2.zzg(r3, r0);	 Catch:{ all -> 0x006f }
        r0 = r4.zzasj;	 Catch:{ all -> 0x0056 }
        r0.notify();	 Catch:{ all -> 0x0056 }
        goto L_0x0054;
    L_0x006f:
        r0 = move-exception;
        r2 = r4.zzasj;	 Catch:{ all -> 0x0056 }
        r2.notify();	 Catch:{ all -> 0x0056 }
        throw r0;	 Catch:{ all -> 0x0056 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzef.run():void");
    }
}
