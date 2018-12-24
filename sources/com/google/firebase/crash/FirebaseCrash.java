package com.google.firebase.crash;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.util.Log;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.crash.zze;
import com.google.android.gms.internal.crash.zzf;
import com.google.android.gms.internal.crash.zzg;
import com.google.android.gms.internal.crash.zzh;
import com.google.android.gms.internal.crash.zzj;
import com.google.android.gms.internal.crash.zzm;
import com.google.android.gms.internal.crash.zzq;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Event;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.FirebaseInstanceId;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@UsedByReflection("FirebaseApp")
@Deprecated
public class FirebaseCrash {
    private static volatile FirebaseCrash zze;
    private final AtomicReference<zzd> zzd;
    private final Context zzf;
    private final ExecutorService zzg;
    private final FirebaseApp zzh;
    private final zzb zzi;
    private final CountDownLatch zzj;
    private zzq zzk;
    private String zzl;

    public interface zza {
        zzm zzh();
    }

    private static final class zzb implements zza {
        private final Object zzr;
        private zzm zzs;

        private zzb() {
            this.zzr = new Object();
        }

        public final zzm zzh() {
            zzm zzm;
            synchronized (this.zzr) {
                zzm = this.zzs;
            }
            return zzm;
        }

        private final void zzb(zzm zzm) {
            synchronized (this.zzr) {
                this.zzs = zzm;
            }
        }
    }

    @VisibleForTesting
    class zzc implements UncaughtExceptionHandler {
        private final /* synthetic */ FirebaseCrash zzq;
        private final UncaughtExceptionHandler zzt;

        public zzc(FirebaseCrash firebaseCrash, UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.zzq = firebaseCrash;
            this.zzt = uncaughtExceptionHandler;
        }

        public final void uncaughtException(Thread thread, Throwable th) {
            Log.e("UncaughtException", "", th);
            if (!this.zzq.zzc()) {
                try {
                    this.zzq.zzg();
                    Future zza = this.zzq.zza(th);
                    if (zza != null) {
                        zza.get(10000, TimeUnit.MILLISECONDS);
                    }
                } catch (Throwable e) {
                    Log.e("UncaughtException", "Ouch! My own exception handler threw an exception.", e);
                }
            }
            if (this.zzt != null) {
                this.zzt.uncaughtException(thread, th);
            }
        }
    }

    private enum zzd {
        UNSPECIFIED,
        ENABLED,
        DISABLED
    }

    public static FirebaseCrash zza() {
        if (zze == null) {
            zze = getInstance(FirebaseApp.getInstance());
        }
        return zze;
    }

    @Keep
    @UsedByReflection("FirebaseApp")
    public static FirebaseCrash getInstance(FirebaseApp firebaseApp) {
        return (FirebaseCrash) firebaseApp.get(FirebaseCrash.class);
    }

    @Keep
    public FirebaseCrash(FirebaseApp firebaseApp) {
        this.zzd = new AtomicReference(zzd.UNSPECIFIED);
        this.zzi = new zzb();
        this.zzj = new CountDownLatch(1);
        throw new IllegalStateException("This method shouldn't be invoked");
    }

    public FirebaseCrash(FirebaseApp firebaseApp, Subscriber subscriber) {
        this(firebaseApp, subscriber, null);
        zzf zzf = new zzf(firebaseApp);
        Thread.setDefaultUncaughtExceptionHandler(new zzc(this, Thread.getDefaultUncaughtExceptionHandler()));
        zzj zze = new zze(this);
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
        newFixedThreadPool.submit(new zzh(zzf, newFixedThreadPool.submit(new zzg(zzf)), 10000, zze));
        newFixedThreadPool.shutdown();
        this.zzg.execute(new zzd(this));
    }

    @VisibleForTesting
    private FirebaseCrash(FirebaseApp firebaseApp, Subscriber subscriber, ExecutorService executorService) {
        this.zzd = new AtomicReference(zzd.UNSPECIFIED);
        this.zzi = new zzb();
        this.zzj = new CountDownLatch(1);
        this.zzh = firebaseApp;
        this.zzf = firebaseApp.getApplicationContext();
        this.zzd.set(zze());
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zzg = threadPoolExecutor;
        subscriber.subscribe(DataCollectionDefaultChange.class, zza.zzm, new zzb(this));
    }

    final void zza(zzm zzm) {
        if (zzm == null) {
            this.zzg.shutdownNow();
        } else {
            zzq zzq;
            AnalyticsConnector analyticsConnector = (AnalyticsConnector) this.zzh.get(AnalyticsConnector.class);
            if (analyticsConnector == null) {
                Log.w("FirebaseCrashAnalytics", "Unable to log event, missing Google Analytics for Firebase library");
                zzq = null;
            } else {
                zzq = new zzq(analyticsConnector);
            }
            this.zzk = zzq;
            this.zzi.zzb(zzm);
            if (!(this.zzk == null || zzc())) {
                this.zzk.zza(this.zzf, this.zzg, this.zzi);
                Log.d("FirebaseCrash", "Firebase Analytics Listener for Firebase Crash is initialized");
            }
        }
        this.zzj.countDown();
        if (!FirebaseApp.getInstance().isDataCollectionDefaultEnabled()) {
            zza(false, false);
        }
    }

    private final void zzb() {
        try {
            this.zzj.await(20000, TimeUnit.MILLISECONDS);
        } catch (Throwable e) {
            Log.e("FirebaseCrash", "Failed waiting for crash api to load.", e);
        }
    }

    @VisibleForTesting
    public final boolean zzc() {
        return this.zzg.isShutdown();
    }

    public static void log(String str) {
        zza().zza(str);
    }

    public static void logcat(int i, String str, String str2) {
        FirebaseCrash zza = zza();
        if (str2 != null) {
            if (str == null) {
                str = "";
            }
            Log.println(i, str, str2);
            zza.zza(str2);
        }
    }

    public static void report(Throwable th) {
        FirebaseCrash zza = zza();
        if (th != null && !zza.zzc()) {
            zza.zzg();
            zza.zzg.submit(new zze(zza.zzf, zza.zzi, th, zza.zzk));
        }
    }

    public static void setCrashCollectionEnabled(boolean z) {
        zza().zza(z, true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zza(boolean r4, boolean r5) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.zzc();	 Catch:{ all -> 0x0030 }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r3);
        return;
    L_0x0009:
        if (r5 != 0) goto L_0x0015;
    L_0x000b:
        r0 = r3.zzd;	 Catch:{ all -> 0x0030 }
        r0 = r0.get();	 Catch:{ all -> 0x0030 }
        r1 = com.google.firebase.crash.FirebaseCrash.zzd.UNSPECIFIED;	 Catch:{ all -> 0x0030 }
        if (r0 != r1) goto L_0x0007;
    L_0x0015:
        r0 = new com.google.android.gms.internal.crash.zzi;	 Catch:{ all -> 0x0030 }
        r1 = r3.zzf;	 Catch:{ all -> 0x0030 }
        r2 = r3.zzi;	 Catch:{ all -> 0x0030 }
        r0.<init>(r1, r2, r4);	 Catch:{ all -> 0x0030 }
        r1 = r0.getTask();	 Catch:{ all -> 0x0030 }
        r2 = new com.google.firebase.crash.zzc;	 Catch:{ all -> 0x0030 }
        r2.<init>(r3, r5, r4);	 Catch:{ all -> 0x0030 }
        r1.addOnSuccessListener(r2);	 Catch:{ all -> 0x0030 }
        r1 = r3.zzg;	 Catch:{ all -> 0x0030 }
        r1.execute(r0);	 Catch:{ all -> 0x0030 }
        goto L_0x0007;
    L_0x0030:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crash.FirebaseCrash.zza(boolean, boolean):void");
    }

    public static boolean isCrashCollectionEnabled() {
        return zza().zzd();
    }

    @VisibleForTesting
    private final boolean zzd() {
        if (zzc()) {
            return false;
        }
        zzb();
        zzd zzd = (zzd) this.zzd.get();
        return this.zzi.zzh() != null && (zzd == zzd.UNSPECIFIED ? FirebaseApp.getInstance().isDataCollectionDefaultEnabled() : zzd == zzd.ENABLED);
    }

    private final zzd zze() {
        SharedPreferences sharedPreferences = this.zzf.getSharedPreferences("FirebaseCrashSharedPrefs", 0);
        try {
            if (sharedPreferences.contains("firebase_crash_collection_enabled")) {
                if (sharedPreferences.getBoolean("firebase_crash_collection_enabled", false)) {
                    return zzd.ENABLED;
                }
                return zzd.DISABLED;
            }
        } catch (ClassCastException e) {
            String str = "FirebaseCrash";
            String str2 = "Unable to access enable value: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        Boolean zzf = zzf();
        if (zzf == null) {
            return zzd.UNSPECIFIED;
        }
        return zzf.booleanValue() ? zzd.ENABLED : zzd.DISABLED;
    }

    private final Boolean zzf() {
        Exception e;
        String str;
        String str2;
        String valueOf;
        try {
            Bundle bundle = this.zzf.getPackageManager().getApplicationInfo(this.zzf.getPackageName(), 128).metaData;
            if (bundle.containsKey("firebase_crash_collection_enabled")) {
                return Boolean.valueOf(bundle.getBoolean("firebase_crash_collection_enabled", false));
            }
        } catch (NameNotFoundException e2) {
            e = e2;
            str = "FirebaseCrash";
            str2 = "No crash enable meta data found: ";
            valueOf = String.valueOf(e.getMessage());
            Log.e(str, valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
            return null;
        } catch (NullPointerException e3) {
            e = e3;
            str = "FirebaseCrash";
            str2 = "No crash enable meta data found: ";
            valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() == 0) {
            }
            Log.e(str, valueOf.length() == 0 ? str2.concat(valueOf) : new String(str2));
            return null;
        }
        return null;
    }

    private final void zza(String str) {
        if (str != null && !zzc()) {
            this.zzg.submit(new zzf(this.zzf, this.zzi, str));
        }
    }

    final Future<?> zza(Throwable th) {
        if (th == null || zzc()) {
            return null;
        }
        return this.zzg.submit(new zzg(this.zzf, this.zzi, th, this.zzk));
    }

    final void zza(boolean z) {
        if (!zzc()) {
            this.zzg.submit(new zzh(this.zzf, this.zzi, z));
        }
    }

    final void zzg() {
        if (this.zzl == null && !zzc() && zzd()) {
            this.zzl = FirebaseInstanceId.getInstance().getId();
            this.zzg.execute(new zzj(this.zzf, this.zzi, this.zzl));
        }
    }

    final /* synthetic */ void zza(boolean z, boolean z2, Void voidR) {
        if (z) {
            this.zzd.set(z2 ? zzd.ENABLED : zzd.DISABLED);
            this.zzf.getSharedPreferences("FirebaseCrashSharedPrefs", 0).edit().putBoolean("firebase_crash_collection_enabled", z2).apply();
        }
    }

    final /* synthetic */ void zza(Event event) {
        zza(((DataCollectionDefaultChange) event.getPayload()).enabled, false);
    }
}
