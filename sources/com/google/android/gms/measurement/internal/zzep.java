package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzep implements Runnable {
    private final /* synthetic */ String zzads;
    private final /* synthetic */ String zzadz;
    private final /* synthetic */ boolean zzaeg;
    private final /* synthetic */ String zzagj;
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzeb zzasi;
    private final /* synthetic */ AtomicReference zzasj;

    zzep(zzeb zzeb, AtomicReference atomicReference, String str, String str2, String str3, boolean z, zzk zzk) {
        this.zzasi = zzeb;
        this.zzasj = atomicReference;
        this.zzagj = str;
        this.zzads = str2;
        this.zzadz = str3;
        this.zzaeg = z;
        this.zzaqk = zzk;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r7 = this;
        r1 = r7.zzasj;
        monitor-enter(r1);
        r0 = r7.zzasi;	 Catch:{ RemoteException -> 0x006e }
        r0 = r0.zzasc;	 Catch:{ RemoteException -> 0x006e }
        if (r0 != 0) goto L_0x0034;
    L_0x000b:
        r0 = r7.zzasi;	 Catch:{ RemoteException -> 0x006e }
        r0 = r0.zzgt();	 Catch:{ RemoteException -> 0x006e }
        r0 = r0.zzjg();	 Catch:{ RemoteException -> 0x006e }
        r2 = "Failed to get user properties";
        r3 = r7.zzagj;	 Catch:{ RemoteException -> 0x006e }
        r3 = com.google.android.gms.measurement.internal.zzas.zzbw(r3);	 Catch:{ RemoteException -> 0x006e }
        r4 = r7.zzads;	 Catch:{ RemoteException -> 0x006e }
        r5 = r7.zzadz;	 Catch:{ RemoteException -> 0x006e }
        r0.zzd(r2, r3, r4, r5);	 Catch:{ RemoteException -> 0x006e }
        r0 = r7.zzasj;	 Catch:{ RemoteException -> 0x006e }
        r2 = java.util.Collections.emptyList();	 Catch:{ RemoteException -> 0x006e }
        r0.set(r2);	 Catch:{ RemoteException -> 0x006e }
        r0 = r7.zzasj;	 Catch:{ all -> 0x0059 }
        r0.notify();	 Catch:{ all -> 0x0059 }
        monitor-exit(r1);	 Catch:{ all -> 0x0059 }
    L_0x0033:
        return;
    L_0x0034:
        r2 = r7.zzagj;	 Catch:{ RemoteException -> 0x006e }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ RemoteException -> 0x006e }
        if (r2 == 0) goto L_0x005c;
    L_0x003c:
        r2 = r7.zzasj;	 Catch:{ RemoteException -> 0x006e }
        r3 = r7.zzads;	 Catch:{ RemoteException -> 0x006e }
        r4 = r7.zzadz;	 Catch:{ RemoteException -> 0x006e }
        r5 = r7.zzaeg;	 Catch:{ RemoteException -> 0x006e }
        r6 = r7.zzaqk;	 Catch:{ RemoteException -> 0x006e }
        r0 = r0.zza(r3, r4, r5, r6);	 Catch:{ RemoteException -> 0x006e }
        r2.set(r0);	 Catch:{ RemoteException -> 0x006e }
    L_0x004d:
        r0 = r7.zzasi;	 Catch:{ RemoteException -> 0x006e }
        r0.zzcy();	 Catch:{ RemoteException -> 0x006e }
        r0 = r7.zzasj;	 Catch:{ all -> 0x0059 }
        r0.notify();	 Catch:{ all -> 0x0059 }
    L_0x0057:
        monitor-exit(r1);	 Catch:{ all -> 0x0059 }
        goto L_0x0033;
    L_0x0059:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0059 }
        throw r0;
    L_0x005c:
        r2 = r7.zzasj;	 Catch:{ RemoteException -> 0x006e }
        r3 = r7.zzagj;	 Catch:{ RemoteException -> 0x006e }
        r4 = r7.zzads;	 Catch:{ RemoteException -> 0x006e }
        r5 = r7.zzadz;	 Catch:{ RemoteException -> 0x006e }
        r6 = r7.zzaeg;	 Catch:{ RemoteException -> 0x006e }
        r0 = r0.zza(r3, r4, r5, r6);	 Catch:{ RemoteException -> 0x006e }
        r2.set(r0);	 Catch:{ RemoteException -> 0x006e }
        goto L_0x004d;
    L_0x006e:
        r0 = move-exception;
        r2 = r7.zzasi;	 Catch:{ all -> 0x0095 }
        r2 = r2.zzgt();	 Catch:{ all -> 0x0095 }
        r2 = r2.zzjg();	 Catch:{ all -> 0x0095 }
        r3 = "Failed to get user properties";
        r4 = r7.zzagj;	 Catch:{ all -> 0x0095 }
        r4 = com.google.android.gms.measurement.internal.zzas.zzbw(r4);	 Catch:{ all -> 0x0095 }
        r5 = r7.zzads;	 Catch:{ all -> 0x0095 }
        r2.zzd(r3, r4, r5, r0);	 Catch:{ all -> 0x0095 }
        r0 = r7.zzasj;	 Catch:{ all -> 0x0095 }
        r2 = java.util.Collections.emptyList();	 Catch:{ all -> 0x0095 }
        r0.set(r2);	 Catch:{ all -> 0x0095 }
        r0 = r7.zzasj;	 Catch:{ all -> 0x0059 }
        r0.notify();	 Catch:{ all -> 0x0059 }
        goto L_0x0057;
    L_0x0095:
        r0 = move-exception;
        r2 = r7.zzasj;	 Catch:{ all -> 0x0059 }
        r2.notify();	 Catch:{ all -> 0x0059 }
        throw r0;	 Catch:{ all -> 0x0059 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzep.run():void");
    }
}
