package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tagmanager.zzcd;
import com.google.android.gms.tagmanager.zzcm;
import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzin {
    private static final Pattern zzbkz = Pattern.compile("(gtm-[a-z0-9]{1,10})\\.json", 2);
    private static volatile zzin zzbla;
    private static zzc zzblj = new zzio();
    private String zzazo;
    private final ExecutorService zzbif;
    private final ScheduledExecutorService zzbig;
    private final zzcm zzbih;
    private final zzcd zzbir;
    private final zzji zzblb;
    private final zzhs zzblc;
    private final zza zzbld;
    private final Object zzble = new Object();
    private String zzblf;
    private int zzblg = 1;
    private final Queue<Runnable> zzblh = new LinkedList();
    private volatile boolean zzbli = false;
    private final Context zzri;
    private volatile boolean zzrm = false;

    @VisibleForTesting
    public static class zza {
        private final Context zzri;

        public zza(Context context) {
            this.zzri = context;
        }

        public final String[] zzer(String str) {
            return this.zzri.getAssets().list(str);
        }

        public final String[] zzrl() {
            return this.zzri.getAssets().list("");
        }
    }

    class zzb extends zzhe {
        final /* synthetic */ zzin zzblk;

        private zzb(zzin zzin) {
            this.zzblk = zzin;
        }

        public final void zza(boolean z, String str) {
            this.zzblk.zzbif.execute(new zziz(this, z, str));
        }
    }

    @VisibleForTesting
    public interface zzc {
        zzin zzb(Context context, zzcm zzcm, zzcd zzcd);
    }

    public static zzin zza(Context context, zzcm zzcm, zzcd zzcd) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context);
        zzin zzin = zzbla;
        if (zzin == null) {
            synchronized (zzin.class) {
                zzin = zzbla;
                if (zzin == null) {
                    zzin = zzblj.zzb(context, zzcm, zzcd);
                    zzbla = zzin;
                }
            }
        }
        return zzin;
    }

    @VisibleForTesting
    zzin(Context context, zzcm zzcm, zzcd zzcd, zzji zzji, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, zzhs zzhs, zza zza) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(zzcm);
        this.zzri = context;
        this.zzbih = zzcm;
        this.zzbir = zzcd;
        this.zzblb = zzji;
        this.zzbif = executorService;
        this.zzbig = scheduledExecutorService;
        this.zzblc = zzhs;
        this.zzbld = zza;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzq() {
        /*
        r8 = this;
        r0 = "Initializing Tag Manager.";
        com.google.android.gms.internal.measurement.zzhk.m1082v(r0);
        r4 = java.lang.System.currentTimeMillis();
        r3 = r8.zzble;
        monitor-enter(r3);
        r0 = r8.zzrm;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x0012;
    L_0x0010:
        monitor-exit(r3);	 Catch:{ all -> 0x0026 }
    L_0x0011:
        return;
    L_0x0012:
        r0 = r8.zzri;	 Catch:{ all -> 0x00c4 }
        r1 = "com.google.android.gms.tagmanager.TagManagerService";
        r0 = zzc(r0, r1);	 Catch:{ all -> 0x00c4 }
        if (r0 != 0) goto L_0x0029;
    L_0x001c:
        r0 = "Tag Manager fails to initialize (TagManagerService not enabled in the manifest)";
        com.google.android.gms.internal.measurement.zzhk.zzab(r0);	 Catch:{ all -> 0x00c4 }
        r0 = 1;
        r8.zzrm = r0;	 Catch:{ all -> 0x0026 }
        monitor-exit(r3);	 Catch:{ all -> 0x0026 }
        goto L_0x0011;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0026 }
        throw r0;
    L_0x0029:
        r0 = 0;
        r1 = r8.zzc(r0);	 Catch:{ all -> 0x00c4 }
        r0 = r1.first;	 Catch:{ all -> 0x00c4 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x00c4 }
        r1 = r1.second;	 Catch:{ all -> 0x00c4 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x00c4 }
        if (r0 == 0) goto L_0x00db;
    L_0x0038:
        if (r1 == 0) goto L_0x00db;
    L_0x003a:
        r6 = "Loading container ";
        r2 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x00c4 }
        r7 = r2.length();	 Catch:{ all -> 0x00c4 }
        if (r7 == 0) goto L_0x00be;
    L_0x0046:
        r2 = r6.concat(r2);	 Catch:{ all -> 0x00c4 }
    L_0x004a:
        com.google.android.gms.internal.measurement.zzhk.zzdm(r2);	 Catch:{ all -> 0x00c4 }
        r2 = r8.zzbif;	 Catch:{ all -> 0x00c4 }
        r6 = new com.google.android.gms.internal.measurement.zzit;	 Catch:{ all -> 0x00c4 }
        r7 = 0;
        r6.<init>(r8, r0, r1, r7);	 Catch:{ all -> 0x00c4 }
        r2.execute(r6);	 Catch:{ all -> 0x00c4 }
        r0 = r8.zzbig;	 Catch:{ all -> 0x00c4 }
        r1 = new com.google.android.gms.internal.measurement.zziu;	 Catch:{ all -> 0x00c4 }
        r1.<init>(r8);	 Catch:{ all -> 0x00c4 }
        r6 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ all -> 0x00c4 }
        r0.schedule(r1, r6, r2);	 Catch:{ all -> 0x00c4 }
        r0 = r8.zzbli;	 Catch:{ all -> 0x00c4 }
        if (r0 != 0) goto L_0x0095;
    L_0x006a:
        r0 = "Installing Tag Manager event handler.";
        com.google.android.gms.internal.measurement.zzhk.zzdm(r0);	 Catch:{ all -> 0x00c4 }
        r0 = 1;
        r8.zzbli = r0;	 Catch:{ all -> 0x00c4 }
        r0 = r8.zzbih;	 Catch:{ RemoteException -> 0x00c9 }
        r1 = new com.google.android.gms.internal.measurement.zzip;	 Catch:{ RemoteException -> 0x00c9 }
        r1.<init>(r8);	 Catch:{ RemoteException -> 0x00c9 }
        r0.zza(r1);	 Catch:{ RemoteException -> 0x00c9 }
    L_0x007c:
        r0 = r8.zzbih;	 Catch:{ RemoteException -> 0x00d2 }
        r1 = new com.google.android.gms.internal.measurement.zzir;	 Catch:{ RemoteException -> 0x00d2 }
        r1.<init>(r8);	 Catch:{ RemoteException -> 0x00d2 }
        r0.zza(r1);	 Catch:{ RemoteException -> 0x00d2 }
    L_0x0086:
        r0 = r8.zzri;	 Catch:{ all -> 0x00c4 }
        r1 = new com.google.android.gms.internal.measurement.zziw;	 Catch:{ all -> 0x00c4 }
        r1.<init>(r8);	 Catch:{ all -> 0x00c4 }
        r0.registerComponentCallbacks(r1);	 Catch:{ all -> 0x00c4 }
        r0 = "Tag Manager event handler installed.";
        com.google.android.gms.internal.measurement.zzhk.zzdm(r0);	 Catch:{ all -> 0x00c4 }
    L_0x0095:
        r0 = 1;
        r8.zzrm = r0;	 Catch:{ all -> 0x0026 }
        monitor-exit(r3);	 Catch:{ all -> 0x0026 }
        r0 = java.lang.System.currentTimeMillis();
        r0 = r0 - r4;
        r2 = 53;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Tag Manager initilization took ";
        r2 = r3.append(r2);
        r0 = r2.append(r0);
        r1 = "ms";
        r0 = r0.append(r1);
        r0 = r0.toString();
        com.google.android.gms.internal.measurement.zzhk.zzdm(r0);
        goto L_0x0011;
    L_0x00be:
        r2 = new java.lang.String;	 Catch:{ all -> 0x00c4 }
        r2.<init>(r6);	 Catch:{ all -> 0x00c4 }
        goto L_0x004a;
    L_0x00c4:
        r0 = move-exception;
        r1 = 1;
        r8.zzrm = r1;	 Catch:{ all -> 0x0026 }
        throw r0;	 Catch:{ all -> 0x0026 }
    L_0x00c9:
        r0 = move-exception;
        r1 = "Error communicating with measurement proxy: ";
        r2 = r8.zzri;	 Catch:{ all -> 0x00c4 }
        com.google.android.gms.internal.measurement.zzgp.zza(r1, r0, r2);	 Catch:{ all -> 0x00c4 }
        goto L_0x007c;
    L_0x00d2:
        r0 = move-exception;
        r1 = "Error communicating with measurement proxy: ";
        r2 = r8.zzri;	 Catch:{ all -> 0x00c4 }
        com.google.android.gms.internal.measurement.zzgp.zza(r1, r0, r2);	 Catch:{ all -> 0x00c4 }
        goto L_0x0086;
    L_0x00db:
        r0 = "Tag Manager's event handler WILL NOT be installed (no container loaded)";
        com.google.android.gms.internal.measurement.zzhk.zzab(r0);	 Catch:{ all -> 0x00c4 }
        goto L_0x0095;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzin.zzq():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.google.android.gms.common.util.VisibleForTesting
    public final void zzb(java.lang.String[] r9) {
        /*
        r8 = this;
        r0 = "Initializing Tag Manager.";
        com.google.android.gms.internal.measurement.zzhk.m1082v(r0);
        r4 = java.lang.System.currentTimeMillis();
        r3 = r8.zzble;
        monitor-enter(r3);
        r0 = r8.zzrm;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x0012;
    L_0x0010:
        monitor-exit(r3);	 Catch:{ all -> 0x0026 }
    L_0x0011:
        return;
    L_0x0012:
        r0 = r8.zzri;	 Catch:{ all -> 0x00c4 }
        r1 = "com.google.android.gms.tagmanager.TagManagerService";
        r0 = zzc(r0, r1);	 Catch:{ all -> 0x00c4 }
        if (r0 != 0) goto L_0x0029;
    L_0x001c:
        r0 = "Tag Manager fails to initialize (TagManagerService not enabled in the manifest)";
        com.google.android.gms.internal.measurement.zzhk.zzab(r0);	 Catch:{ all -> 0x00c4 }
        r0 = 1;
        r8.zzrm = r0;	 Catch:{ all -> 0x0026 }
        monitor-exit(r3);	 Catch:{ all -> 0x0026 }
        goto L_0x0011;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0026 }
        throw r0;
    L_0x0029:
        r0 = 0;
        r1 = r8.zzc(r0);	 Catch:{ all -> 0x00c4 }
        r0 = r1.first;	 Catch:{ all -> 0x00c4 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x00c4 }
        r1 = r1.second;	 Catch:{ all -> 0x00c4 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x00c4 }
        if (r0 == 0) goto L_0x00db;
    L_0x0038:
        if (r1 == 0) goto L_0x00db;
    L_0x003a:
        r6 = "Loading container ";
        r2 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x00c4 }
        r7 = r2.length();	 Catch:{ all -> 0x00c4 }
        if (r7 == 0) goto L_0x00be;
    L_0x0046:
        r2 = r6.concat(r2);	 Catch:{ all -> 0x00c4 }
    L_0x004a:
        com.google.android.gms.internal.measurement.zzhk.zzdm(r2);	 Catch:{ all -> 0x00c4 }
        r2 = r8.zzbif;	 Catch:{ all -> 0x00c4 }
        r6 = new com.google.android.gms.internal.measurement.zzit;	 Catch:{ all -> 0x00c4 }
        r7 = 0;
        r6.<init>(r8, r0, r1, r7);	 Catch:{ all -> 0x00c4 }
        r2.execute(r6);	 Catch:{ all -> 0x00c4 }
        r0 = r8.zzbig;	 Catch:{ all -> 0x00c4 }
        r1 = new com.google.android.gms.internal.measurement.zziu;	 Catch:{ all -> 0x00c4 }
        r1.<init>(r8);	 Catch:{ all -> 0x00c4 }
        r6 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ all -> 0x00c4 }
        r0.schedule(r1, r6, r2);	 Catch:{ all -> 0x00c4 }
        r0 = r8.zzbli;	 Catch:{ all -> 0x00c4 }
        if (r0 != 0) goto L_0x0095;
    L_0x006a:
        r0 = "Installing Tag Manager event handler.";
        com.google.android.gms.internal.measurement.zzhk.zzdm(r0);	 Catch:{ all -> 0x00c4 }
        r0 = 1;
        r8.zzbli = r0;	 Catch:{ all -> 0x00c4 }
        r0 = r8.zzbih;	 Catch:{ RemoteException -> 0x00c9 }
        r1 = new com.google.android.gms.internal.measurement.zzip;	 Catch:{ RemoteException -> 0x00c9 }
        r1.<init>(r8);	 Catch:{ RemoteException -> 0x00c9 }
        r0.zza(r1);	 Catch:{ RemoteException -> 0x00c9 }
    L_0x007c:
        r0 = r8.zzbih;	 Catch:{ RemoteException -> 0x00d2 }
        r1 = new com.google.android.gms.internal.measurement.zzir;	 Catch:{ RemoteException -> 0x00d2 }
        r1.<init>(r8);	 Catch:{ RemoteException -> 0x00d2 }
        r0.zza(r1);	 Catch:{ RemoteException -> 0x00d2 }
    L_0x0086:
        r0 = r8.zzri;	 Catch:{ all -> 0x00c4 }
        r1 = new com.google.android.gms.internal.measurement.zziw;	 Catch:{ all -> 0x00c4 }
        r1.<init>(r8);	 Catch:{ all -> 0x00c4 }
        r0.registerComponentCallbacks(r1);	 Catch:{ all -> 0x00c4 }
        r0 = "Tag Manager event handler installed.";
        com.google.android.gms.internal.measurement.zzhk.zzdm(r0);	 Catch:{ all -> 0x00c4 }
    L_0x0095:
        r0 = 1;
        r8.zzrm = r0;	 Catch:{ all -> 0x0026 }
        monitor-exit(r3);	 Catch:{ all -> 0x0026 }
        r0 = java.lang.System.currentTimeMillis();
        r0 = r0 - r4;
        r2 = 53;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Tag Manager initilization took ";
        r2 = r3.append(r2);
        r0 = r2.append(r0);
        r1 = "ms";
        r0 = r0.append(r1);
        r0 = r0.toString();
        com.google.android.gms.internal.measurement.zzhk.zzdm(r0);
        goto L_0x0011;
    L_0x00be:
        r2 = new java.lang.String;	 Catch:{ all -> 0x00c4 }
        r2.<init>(r6);	 Catch:{ all -> 0x00c4 }
        goto L_0x004a;
    L_0x00c4:
        r0 = move-exception;
        r1 = 1;
        r8.zzrm = r1;	 Catch:{ all -> 0x0026 }
        throw r0;	 Catch:{ all -> 0x0026 }
    L_0x00c9:
        r0 = move-exception;
        r1 = "Error communicating with measurement proxy: ";
        r2 = r8.zzri;	 Catch:{ all -> 0x00c4 }
        com.google.android.gms.internal.measurement.zzgp.zza(r1, r0, r2);	 Catch:{ all -> 0x00c4 }
        goto L_0x007c;
    L_0x00d2:
        r0 = move-exception;
        r1 = "Error communicating with measurement proxy: ";
        r2 = r8.zzri;	 Catch:{ all -> 0x00c4 }
        com.google.android.gms.internal.measurement.zzgp.zza(r1, r0, r2);	 Catch:{ all -> 0x00c4 }
        goto L_0x0086;
    L_0x00db:
        r0 = "Tag Manager's event handler WILL NOT be installed (no container loaded)";
        com.google.android.gms.internal.measurement.zzhk.zzab(r0);	 Catch:{ all -> 0x00c4 }
        goto L_0x0095;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzin.zzb(java.lang.String[]):void");
    }

    private final Pair<String, String> zzc(String[] strArr) {
        int i = 0;
        zzhk.m1082v("Looking up container asset.");
        if (this.zzazo != null && this.zzblf != null) {
            return Pair.create(this.zzazo, this.zzblf);
        }
        try {
            String str;
            String[] zzer = this.zzbld.zzer("containers");
            int i2 = 0;
            for (int i3 = 0; i3 < zzer.length; i3++) {
                Matcher matcher = zzbkz.matcher(zzer[i3]);
                if (!matcher.matches()) {
                    zzhk.zzab(String.format("Ignoring container asset %s (does not match %s)", new Object[]{zzer[i3], zzbkz.pattern()}));
                } else if (i2 == 0) {
                    this.zzazo = matcher.group(1);
                    str = File.separator;
                    r3 = zzer[i3];
                    this.zzblf = new StringBuilder((String.valueOf(str).length() + 10) + String.valueOf(r3).length()).append("containers").append(str).append(r3).toString();
                    r3 = "Asset found for container ";
                    str = String.valueOf(this.zzazo);
                    zzhk.m1082v(str.length() != 0 ? r3.concat(str) : new String(r3));
                    i2 = 1;
                } else {
                    String str2 = "Extra container asset found, will not be loaded: ";
                    r3 = String.valueOf(zzer[i3]);
                    zzhk.zzab(r3.length() != 0 ? str2.concat(r3) : new String(str2));
                }
            }
            if (i2 == 0) {
                zzhk.zzab("No container asset found in /assets/containers. Checking top level /assets directory for container assets.");
                try {
                    String[] zzrl = this.zzbld.zzrl();
                    while (i < zzrl.length) {
                        Matcher matcher2 = zzbkz.matcher(zzrl[i]);
                        if (matcher2.matches()) {
                            String valueOf;
                            if (i2 == 0) {
                                this.zzazo = matcher2.group(1);
                                this.zzblf = zzrl[i];
                                str = "Asset found for container ";
                                valueOf = String.valueOf(this.zzazo);
                                zzhk.m1082v(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                                zzhk.zzab("Loading container assets from top level /assets directory. Please move the container asset to /assets/containers");
                                i2 = 1;
                            } else {
                                String str3 = "Extra container asset found, will not be loaded: ";
                                valueOf = String.valueOf(zzrl[i]);
                                zzhk.zzab(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                            }
                        }
                        i++;
                    }
                } catch (Throwable e) {
                    zzhk.zza("Failed to enumerate assets.", e);
                    return Pair.create(null, null);
                }
            }
            return Pair.create(this.zzazo, this.zzblf);
        } catch (Throwable e2) {
            zzhk.zza(String.format("Failed to enumerate assets in folder %s", new Object[]{"containers"}), e2);
            return Pair.create(null, null);
        }
    }

    private static boolean zzc(Context context, String str) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), str), 0);
            if (serviceInfo == null || !serviceInfo.enabled) {
                return false;
            }
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    final void zzc(Uri uri) {
        this.zzbif.execute(new zziy(this, uri));
    }
}
