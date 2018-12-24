package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzeo implements Runnable {
    private final /* synthetic */ String zzads;
    private final /* synthetic */ String zzadz;
    private final /* synthetic */ String zzagj;
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzeb zzasi;
    private final /* synthetic */ AtomicReference zzasj;

    zzeo(zzeb zzeb, AtomicReference atomicReference, String str, String str2, String str3, zzk zzk) {
        this.zzasi = zzeb;
        this.zzasj = atomicReference;
        this.zzagj = str;
        this.zzads = str2;
        this.zzadz = str3;
        this.zzaqk = zzk;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r6 = this;
        r1 = r6.zzasj;
        monitor-enter(r1);
        r0 = r6.zzasi;	 Catch:{ RemoteException -> 0x006a }
        r0 = r0.zzasc;	 Catch:{ RemoteException -> 0x006a }
        if (r0 != 0) goto L_0x0034;
    L_0x000b:
        r0 = r6.zzasi;	 Catch:{ RemoteException -> 0x006a }
        r0 = r0.zzgt();	 Catch:{ RemoteException -> 0x006a }
        r0 = r0.zzjg();	 Catch:{ RemoteException -> 0x006a }
        r2 = "Failed to get conditional properties";
        r3 = r6.zzagj;	 Catch:{ RemoteException -> 0x006a }
        r3 = com.google.android.gms.measurement.internal.zzas.zzbw(r3);	 Catch:{ RemoteException -> 0x006a }
        r4 = r6.zzads;	 Catch:{ RemoteException -> 0x006a }
        r5 = r6.zzadz;	 Catch:{ RemoteException -> 0x006a }
        r0.zzd(r2, r3, r4, r5);	 Catch:{ RemoteException -> 0x006a }
        r0 = r6.zzasj;	 Catch:{ RemoteException -> 0x006a }
        r2 = java.util.Collections.emptyList();	 Catch:{ RemoteException -> 0x006a }
        r0.set(r2);	 Catch:{ RemoteException -> 0x006a }
        r0 = r6.zzasj;	 Catch:{ all -> 0x0057 }
        r0.notify();	 Catch:{ all -> 0x0057 }
        monitor-exit(r1);	 Catch:{ all -> 0x0057 }
    L_0x0033:
        return;
    L_0x0034:
        r2 = r6.zzagj;	 Catch:{ RemoteException -> 0x006a }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ RemoteException -> 0x006a }
        if (r2 == 0) goto L_0x005a;
    L_0x003c:
        r2 = r6.zzasj;	 Catch:{ RemoteException -> 0x006a }
        r3 = r6.zzads;	 Catch:{ RemoteException -> 0x006a }
        r4 = r6.zzadz;	 Catch:{ RemoteException -> 0x006a }
        r5 = r6.zzaqk;	 Catch:{ RemoteException -> 0x006a }
        r0 = r0.zza(r3, r4, r5);	 Catch:{ RemoteException -> 0x006a }
        r2.set(r0);	 Catch:{ RemoteException -> 0x006a }
    L_0x004b:
        r0 = r6.zzasi;	 Catch:{ RemoteException -> 0x006a }
        r0.zzcy();	 Catch:{ RemoteException -> 0x006a }
        r0 = r6.zzasj;	 Catch:{ all -> 0x0057 }
        r0.notify();	 Catch:{ all -> 0x0057 }
    L_0x0055:
        monitor-exit(r1);	 Catch:{ all -> 0x0057 }
        goto L_0x0033;
    L_0x0057:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0057 }
        throw r0;
    L_0x005a:
        r2 = r6.zzasj;	 Catch:{ RemoteException -> 0x006a }
        r3 = r6.zzagj;	 Catch:{ RemoteException -> 0x006a }
        r4 = r6.zzads;	 Catch:{ RemoteException -> 0x006a }
        r5 = r6.zzadz;	 Catch:{ RemoteException -> 0x006a }
        r0 = r0.zze(r3, r4, r5);	 Catch:{ RemoteException -> 0x006a }
        r2.set(r0);	 Catch:{ RemoteException -> 0x006a }
        goto L_0x004b;
    L_0x006a:
        r0 = move-exception;
        r2 = r6.zzasi;	 Catch:{ all -> 0x0091 }
        r2 = r2.zzgt();	 Catch:{ all -> 0x0091 }
        r2 = r2.zzjg();	 Catch:{ all -> 0x0091 }
        r3 = "Failed to get conditional properties";
        r4 = r6.zzagj;	 Catch:{ all -> 0x0091 }
        r4 = com.google.android.gms.measurement.internal.zzas.zzbw(r4);	 Catch:{ all -> 0x0091 }
        r5 = r6.zzads;	 Catch:{ all -> 0x0091 }
        r2.zzd(r3, r4, r5, r0);	 Catch:{ all -> 0x0091 }
        r0 = r6.zzasj;	 Catch:{ all -> 0x0091 }
        r2 = java.util.Collections.emptyList();	 Catch:{ all -> 0x0091 }
        r0.set(r2);	 Catch:{ all -> 0x0091 }
        r0 = r6.zzasj;	 Catch:{ all -> 0x0057 }
        r0.notify();	 Catch:{ all -> 0x0057 }
        goto L_0x0055;
    L_0x0091:
        r0 = move-exception;
        r2 = r6.zzasj;	 Catch:{ all -> 0x0057 }
        r2.notify();	 Catch:{ all -> 0x0057 }
        throw r0;	 Catch:{ all -> 0x0057 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzeo.run():void");
    }
}
