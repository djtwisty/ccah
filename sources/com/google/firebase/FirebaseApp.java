package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.p013b.C0100a;
import android.support.v4.p017e.C0238a;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.C03361;
import com.google.firebase.components.zzf;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import com.google.firebase.internal.InternalTokenProvider;
import com.google.firebase.internal.InternalTokenResult;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@PublicApi
public class FirebaseApp {
    static final Map<String, FirebaseApp> zza = new C0238a();
    private static final List<String> zzb = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
    private static final List<String> zzc = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> zzd = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
    private static final List<String> zze = Arrays.asList(new String[0]);
    private static final Set<String> zzf = Collections.emptySet();
    private static final Object zzg = new Object();
    private static final Executor zzh = new zzb();
    private final Context zzi;
    private final String zzj;
    private final FirebaseOptions zzk;
    private final zzf zzl;
    private final SharedPreferences zzm;
    private final Publisher zzn;
    private final AtomicBoolean zzo = new AtomicBoolean(false);
    private final AtomicBoolean zzp = new AtomicBoolean();
    private final AtomicBoolean zzq;
    private final List<IdTokenListener> zzr = new CopyOnWriteArrayList();
    private final List<BackgroundStateChangeListener> zzs = new CopyOnWriteArrayList();
    private final List<FirebaseAppLifecycleListener> zzt = new CopyOnWriteArrayList();
    private InternalTokenProvider zzu;
    private IdTokenListenersCountChangedListener zzv;

    @KeepForSdk
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z);
    }

    @KeepForSdk
    @Deprecated
    public interface IdTokenListener {
        @KeepForSdk
        void onIdTokenChanged(InternalTokenResult internalTokenResult);
    }

    @KeepForSdk
    @Deprecated
    public interface IdTokenListenersCountChangedListener {
        @KeepForSdk
        void onListenerCountChanged(int i);
    }

    @TargetApi(14)
    static class zza implements com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener {
        private static AtomicReference<zza> zza = new AtomicReference();

        private zza() {
        }

        public final void onBackgroundStateChanged(boolean z) {
            synchronized (FirebaseApp.zzg) {
                Iterator it = new ArrayList(FirebaseApp.zza.values()).iterator();
                while (it.hasNext()) {
                    FirebaseApp firebaseApp = (FirebaseApp) it.next();
                    if (firebaseApp.zzo.get()) {
                        firebaseApp.zza(z);
                    }
                }
            }
        }

        static /* synthetic */ void zza(Context context) {
            if (PlatformVersion.isAtLeastIceCreamSandwich() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (zza.get() == null) {
                    com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener zza = new zza();
                    if (zza.compareAndSet(null, zza)) {
                        BackgroundDetector.initialize(application);
                        BackgroundDetector.getInstance().addListener(zza);
                    }
                }
            }
        }
    }

    static class zzb implements Executor {
        private static final Handler zza = new Handler(Looper.getMainLooper());

        private zzb() {
        }

        public final void execute(Runnable runnable) {
            zza.post(runnable);
        }
    }

    @TargetApi(24)
    static class zzc extends BroadcastReceiver {
        private static AtomicReference<zzc> zza = new AtomicReference();
        private final Context zzb;

        private zzc(Context context) {
            this.zzb = context;
        }

        public final void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.zzg) {
                for (FirebaseApp zza : FirebaseApp.zza.values()) {
                    zza.zze();
                }
            }
            this.zzb.unregisterReceiver(this);
        }

        static /* synthetic */ void zza(Context context) {
            if (zza.get() == null) {
                BroadcastReceiver zzc = new zzc(context);
                if (zza.compareAndSet(null, zzc)) {
                    context.registerReceiver(zzc, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }
    }

    @PublicApi
    public Context getApplicationContext() {
        zzc();
        return this.zzi;
    }

    @PublicApi
    public String getName() {
        zzc();
        return this.zzj;
    }

    @PublicApi
    public FirebaseOptions getOptions() {
        zzc();
        return this.zzk;
    }

    public boolean equals(Object obj) {
        if (obj instanceof FirebaseApp) {
            return this.zzj.equals(((FirebaseApp) obj).getName());
        }
        return false;
    }

    public int hashCode() {
        return this.zzj.hashCode();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", this.zzj).add("options", this.zzk).toString();
    }

    @PublicApi
    public static List<FirebaseApp> getApps(Context context) {
        List arrayList;
        synchronized (zzg) {
            arrayList = new ArrayList(zza.values());
        }
        return arrayList;
    }

    @PublicApi
    public static FirebaseApp getInstance() {
        FirebaseApp firebaseApp;
        synchronized (zzg) {
            firebaseApp = (FirebaseApp) zza.get("[DEFAULT]");
            if (firebaseApp == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.getMyProcessName() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return firebaseApp;
    }

    @PublicApi
    public static FirebaseApp getInstance(String str) {
        FirebaseApp firebaseApp;
        synchronized (zzg) {
            firebaseApp = (FirebaseApp) zza.get(str.trim());
            if (firebaseApp != null) {
            } else {
                String str2;
                Iterable zzd = zzd();
                if (zzd.isEmpty()) {
                    str2 = "";
                } else {
                    str2 = "Available app names: " + TextUtils.join(", ", zzd);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", new Object[]{str, str2}));
            }
        }
        return firebaseApp;
    }

    @PublicApi
    public static FirebaseApp initializeApp(Context context) {
        FirebaseApp instance;
        synchronized (zzg) {
            if (zza.containsKey("[DEFAULT]")) {
                instance = getInstance();
            } else {
                FirebaseOptions fromResource = FirebaseOptions.fromResource(context);
                if (fromResource == null) {
                    Log.d("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                    instance = null;
                } else {
                    instance = initializeApp(context, fromResource);
                }
            }
        }
        return instance;
    }

    @PublicApi
    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions) {
        return initializeApp(context, firebaseOptions, "[DEFAULT]");
    }

    @PublicApi
    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions, String str) {
        FirebaseApp firebaseApp;
        zza.zza(context);
        String trim = str.trim();
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (zzg) {
            Preconditions.checkState(!zza.containsKey(trim), "FirebaseApp name " + trim + " already exists!");
            Preconditions.checkNotNull(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, trim, firebaseOptions);
            zza.put(trim, firebaseApp);
        }
        firebaseApp.zze();
        return firebaseApp;
    }

    @KeepForSdk
    @Deprecated
    public void setTokenProvider(InternalTokenProvider internalTokenProvider) {
        this.zzu = (InternalTokenProvider) Preconditions.checkNotNull(internalTokenProvider);
    }

    @KeepForSdk
    @Deprecated
    public void setIdTokenListenersCountChangedListener(IdTokenListenersCountChangedListener idTokenListenersCountChangedListener) {
        this.zzv = (IdTokenListenersCountChangedListener) Preconditions.checkNotNull(idTokenListenersCountChangedListener);
        this.zzv.onListenerCountChanged(this.zzr.size());
    }

    @KeepForSdk
    @Deprecated
    public Task<GetTokenResult> getToken(boolean z) {
        zzc();
        if (this.zzu == null) {
            return Tasks.forException(new FirebaseApiNotAvailableException("firebase-auth is not linked, please fall back to unauthenticated mode."));
        }
        return this.zzu.getAccessToken(z);
    }

    @KeepForSdk
    @Deprecated
    public String getUid() {
        zzc();
        if (this.zzu != null) {
            return this.zzu.getUid();
        }
        throw new FirebaseApiNotAvailableException("firebase-auth is not linked, please fall back to unauthenticated mode.");
    }

    @PublicApi
    public void delete() {
        if (this.zzp.compareAndSet(false, true)) {
            synchronized (zzg) {
                zza.remove(this.zzj);
            }
            Iterator it = this.zzt.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @KeepForSdk
    public <T> T get(Class<T> cls) {
        zzc();
        return this.zzl.get(cls);
    }

    @PublicApi
    public void setAutomaticResourceManagementEnabled(boolean z) {
        zzc();
        if (this.zzo.compareAndSet(!z, z)) {
            boolean isInBackground = BackgroundDetector.getInstance().isInBackground();
            if (z && isInBackground) {
                zza(true);
            } else if (!z && isInBackground) {
                zza(false);
            }
        }
    }

    @KeepForSdk
    public boolean isDataCollectionDefaultEnabled() {
        zzc();
        return this.zzq.get();
    }

    @KeepForSdk
    public void setDataCollectionDefaultEnabled(boolean z) {
        zzc();
        if (this.zzq.compareAndSet(!z, z)) {
            this.zzm.edit().putBoolean("firebase_data_collection_default_enabled", z).commit();
            this.zzn.publish(new Event(DataCollectionDefaultChange.class, new DataCollectionDefaultChange(z)));
        }
    }

    private FirebaseApp(Context context, String str, FirebaseOptions firebaseOptions) {
        this.zzi = (Context) Preconditions.checkNotNull(context);
        this.zzj = Preconditions.checkNotEmpty(str);
        this.zzk = (FirebaseOptions) Preconditions.checkNotNull(firebaseOptions);
        this.zzv = new com.google.firebase.internal.zza();
        this.zzm = context.getSharedPreferences("com.google.firebase.common.prefs", 0);
        this.zzq = new AtomicBoolean(zzb());
        Iterable zza = C03361.zza(context).zza();
        this.zzl = new zzf(zzh, zza, Component.of(context, Context.class, new Class[0]), Component.of(this, FirebaseApp.class, new Class[0]), Component.of(firebaseOptions, FirebaseOptions.class, new Class[0]));
        this.zzn = (Publisher) this.zzl.get(Publisher.class);
    }

    private boolean zzb() {
        if (this.zzm.contains("firebase_data_collection_default_enabled")) {
            return this.zzm.getBoolean("firebase_data_collection_default_enabled", true);
        }
        try {
            PackageManager packageManager = this.zzi.getPackageManager();
            if (packageManager == null) {
                return true;
            }
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(this.zzi.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey("firebase_data_collection_default_enabled")) {
                return true;
            }
            return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
        } catch (NameNotFoundException e) {
            return true;
        }
    }

    private void zzc() {
        Preconditions.checkState(!this.zzp.get(), "FirebaseApp was deleted");
    }

    @KeepForSdk
    @Deprecated
    public List<IdTokenListener> getListeners() {
        zzc();
        return this.zzr;
    }

    @KeepForSdk
    public boolean isDefaultApp() {
        return "[DEFAULT]".equals(getName());
    }

    @KeepForSdk
    @Deprecated
    public void notifyIdTokenListeners(InternalTokenResult internalTokenResult) {
        Log.d("FirebaseApp", "Notifying auth state listeners.");
        int i = 0;
        for (IdTokenListener onIdTokenChanged : this.zzr) {
            onIdTokenChanged.onIdTokenChanged(internalTokenResult);
            i++;
        }
        Log.d("FirebaseApp", String.format("Notified %d auth state listeners.", new Object[]{Integer.valueOf(i)}));
    }

    private void zza(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (BackgroundStateChangeListener onBackgroundStateChanged : this.zzs) {
            onBackgroundStateChanged.onBackgroundStateChanged(z);
        }
    }

    @KeepForSdk
    @Deprecated
    public void addIdTokenListener(IdTokenListener idTokenListener) {
        zzc();
        Preconditions.checkNotNull(idTokenListener);
        this.zzr.add(idTokenListener);
        this.zzv.onListenerCountChanged(this.zzr.size());
    }

    @KeepForSdk
    @Deprecated
    public void removeIdTokenListener(IdTokenListener idTokenListener) {
        zzc();
        Preconditions.checkNotNull(idTokenListener);
        this.zzr.remove(idTokenListener);
        this.zzv.onListenerCountChanged(this.zzr.size());
    }

    @KeepForSdk
    public void addBackgroundStateChangeListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        zzc();
        if (this.zzo.get() && BackgroundDetector.getInstance().isInBackground()) {
            backgroundStateChangeListener.onBackgroundStateChanged(true);
        }
        this.zzs.add(backgroundStateChangeListener);
    }

    @KeepForSdk
    public void removeBackgroundStateChangeListener(BackgroundStateChangeListener backgroundStateChangeListener) {
        zzc();
        this.zzs.remove(backgroundStateChangeListener);
    }

    @KeepForSdk
    public String getPersistenceKey() {
        return Base64Utils.encodeUrlSafeNoPadding(getName().getBytes(Charset.defaultCharset())) + "+" + Base64Utils.encodeUrlSafeNoPadding(getOptions().getApplicationId().getBytes(Charset.defaultCharset()));
    }

    @KeepForSdk
    public void addLifecycleEventListener(FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        zzc();
        Preconditions.checkNotNull(firebaseAppLifecycleListener);
        this.zzt.add(firebaseAppLifecycleListener);
    }

    @KeepForSdk
    public void removeLifecycleEventListener(FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        zzc();
        Preconditions.checkNotNull(firebaseAppLifecycleListener);
        this.zzt.remove(firebaseAppLifecycleListener);
    }

    @KeepForSdk
    public static String getPersistenceKey(String str, FirebaseOptions firebaseOptions) {
        return Base64Utils.encodeUrlSafeNoPadding(str.getBytes(Charset.defaultCharset())) + "+" + Base64Utils.encodeUrlSafeNoPadding(firebaseOptions.getApplicationId().getBytes(Charset.defaultCharset()));
    }

    private static List<String> zzd() {
        List<String> arrayList = new ArrayList();
        synchronized (zzg) {
            for (FirebaseApp name : zza.values()) {
                arrayList.add(name.getName());
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private void zze() {
        boolean c = C0100a.m128c(this.zzi);
        if (c) {
            zzc.zza(this.zzi);
        } else {
            this.zzl.zza(isDefaultApp());
        }
        zza(FirebaseApp.class, this, zzb, c);
        if (isDefaultApp()) {
            zza(FirebaseApp.class, this, zzc, c);
            zza(Context.class, this.zzi, zzd, c);
        }
    }

    private static <T> void zza(Class<T> cls, T t, Iterable<String> iterable, boolean z) {
        for (String str : iterable) {
            if (z) {
                try {
                    if (!zze.contains(str)) {
                    }
                } catch (ClassNotFoundException e) {
                    if (zzf.contains(str)) {
                        throw new IllegalStateException(str + " is missing, but is required. Check if it has been removed by Proguard.");
                    }
                    Log.d("FirebaseApp", str + " is not linked. Skipping initialization.");
                } catch (NoSuchMethodException e2) {
                    throw new IllegalStateException(str + "#getInstance has been removed by Proguard. Add keep rule to prevent it.");
                } catch (Throwable e3) {
                    Log.wtf("FirebaseApp", "Firebase API initialization failure.", e3);
                } catch (Throwable e4) {
                    Log.wtf("FirebaseApp", "Failed to initialize " + str, e4);
                }
            }
            Method method = Class.forName(str).getMethod("getInstance", new Class[]{cls});
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                method.invoke(null, new Object[]{t});
            }
        }
    }
}
