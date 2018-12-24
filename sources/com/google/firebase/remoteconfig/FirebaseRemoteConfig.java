package com.google.firebase.remoteconfig;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.XmlResourceParser;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.config.zzal;
import com.google.android.gms.internal.config.zzam;
import com.google.android.gms.internal.config.zzan;
import com.google.android.gms.internal.config.zzao;
import com.google.android.gms.internal.config.zzap;
import com.google.android.gms.internal.config.zzaq;
import com.google.android.gms.internal.config.zzar;
import com.google.android.gms.internal.config.zzas;
import com.google.android.gms.internal.config.zzat;
import com.google.android.gms.internal.config.zzau;
import com.google.android.gms.internal.config.zzav;
import com.google.android.gms.internal.config.zzaw;
import com.google.android.gms.internal.config.zzay;
import com.google.android.gms.internal.config.zzbh;
import com.google.android.gms.internal.config.zze;
import com.google.android.gms.internal.config.zzj;
import com.google.android.gms.internal.config.zzk;
import com.google.android.gms.internal.config.zzv;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings.Builder;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FirebaseRemoteConfig {
    public static final boolean DEFAULT_VALUE_FOR_BOOLEAN = false;
    public static final byte[] DEFAULT_VALUE_FOR_BYTE_ARRAY = new byte[0];
    public static final double DEFAULT_VALUE_FOR_DOUBLE = 0.0d;
    public static final long DEFAULT_VALUE_FOR_LONG = 0;
    public static final String DEFAULT_VALUE_FOR_STRING = "";
    public static final int LAST_FETCH_STATUS_FAILURE = 1;
    public static final int LAST_FETCH_STATUS_NO_FETCH_YET = 0;
    public static final int LAST_FETCH_STATUS_SUCCESS = -1;
    public static final int LAST_FETCH_STATUS_THROTTLED = 2;
    public static final int VALUE_SOURCE_DEFAULT = 1;
    public static final int VALUE_SOURCE_REMOTE = 2;
    public static final int VALUE_SOURCE_STATIC = 0;
    private static FirebaseRemoteConfig zzag;
    private final Context mContext;
    private zzan zzah;
    private zzan zzai;
    private zzan zzaj;
    private zzaq zzak;
    private final FirebaseApp zzal;
    private final ReadWriteLock zzam = new ReentrantReadWriteLock(true);

    private FirebaseRemoteConfig(Context context, zzan zzan, zzan zzan2, zzan zzan3, zzaq zzaq) {
        this.mContext = context;
        if (zzaq == null) {
            zzaq = new zzaq();
        }
        this.zzak = zzaq;
        this.zzak.zzc(zzd(this.mContext));
        this.zzah = zzan;
        this.zzai = zzan2;
        this.zzaj = zzan3;
        this.zzal = FirebaseApp.initializeApp(this.mContext);
    }

    public static FirebaseRemoteConfig getInstance() {
        return zzc(FirebaseApp.getInstance().getApplicationContext());
    }

    @ShowFirstParty
    private static FirebaseRemoteConfig zzc(Context context) {
        synchronized (FirebaseRemoteConfig.class) {
            if (zzag == null) {
                zzan zza;
                zzan zza2;
                zzan zza3;
                zzaq zzaq;
                zzav zze = zze(context);
                if (zze != null) {
                    if (Log.isLoggable("FirebaseRemoteConfig", 3)) {
                        Log.d("FirebaseRemoteConfig", "Initializing from persisted config.");
                    }
                    zza = zza(zze.zzbp);
                    zza2 = zza(zze.zzbq);
                    zza3 = zza(zze.zzbr);
                    zzat zzat = zze.zzbs;
                    if (zzat == null) {
                        zzaq = null;
                    } else {
                        zzaq = new zzaq();
                        zzaq.zzf(zzat.zzbj);
                        zzaq.zza(zzat.zzbk);
                    }
                    if (zzaq != null) {
                        zzaw[] zzawArr = zze.zzbt;
                        Map hashMap = new HashMap();
                        if (zzawArr != null) {
                            for (zzaw zzaw : zzawArr) {
                                hashMap.put(zzaw.zzbn, new zzal(zzaw.resourceId, zzaw.zzbv));
                            }
                        }
                        zzaq.zza(hashMap);
                    }
                } else if (Log.isLoggable("FirebaseRemoteConfig", 3)) {
                    Log.d("FirebaseRemoteConfig", "No persisted config was found. Initializing from scratch.");
                    zzaq = null;
                    zza3 = null;
                    zza2 = null;
                    zza = null;
                } else {
                    zzaq = null;
                    zza3 = null;
                    zza2 = null;
                    zza = null;
                }
                zzag = new FirebaseRemoteConfig(context, zza, zza2, zza3, zzaq);
            }
        }
        return zzag;
    }

    private final long zzd(Context context) {
        long j = 0;
        try {
            return Wrappers.packageManager(this.mContext).getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
        } catch (NameNotFoundException e) {
            String packageName = context.getPackageName();
            Log.e("FirebaseRemoteConfig", new StringBuilder(String.valueOf(packageName).length() + 25).append("Package [").append(packageName).append("] was not found!").toString());
            return j;
        }
    }

    private static zzav zze(Context context) {
        Throwable e;
        if (context == null) {
            return null;
        }
        FileInputStream openFileInput;
        try {
            openFileInput = context.openFileInput("persisted_config");
            try {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = openFileInput.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                zzay zza = zzay.zza(toByteArray, 0, toByteArray.length);
                zzbh zzav = new zzav();
                zzav.zza(zza);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (Throwable e2) {
                        Log.e("FirebaseRemoteConfig", "Failed to close persisted config file.", e2);
                    }
                }
                return zzav;
            } catch (FileNotFoundException e3) {
                e = e3;
                try {
                    if (Log.isLoggable("FirebaseRemoteConfig", 3)) {
                        Log.d("FirebaseRemoteConfig", "Persisted config file was not found.", e);
                    }
                    if (openFileInput != null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (Throwable e4) {
                        Log.e("FirebaseRemoteConfig", "Failed to close persisted config file.", e4);
                        return null;
                    }
                } catch (Throwable e22) {
                    e4 = e22;
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (Throwable e222) {
                            Log.e("FirebaseRemoteConfig", "Failed to close persisted config file.", e222);
                        }
                    }
                    throw e4;
                }
            } catch (IOException e5) {
                e4 = e5;
                Log.e("FirebaseRemoteConfig", "Cannot initialize from persisted config.", e4);
                if (openFileInput != null) {
                    return null;
                }
                try {
                    openFileInput.close();
                    return null;
                } catch (Throwable e42) {
                    Log.e("FirebaseRemoteConfig", "Failed to close persisted config file.", e42);
                    return null;
                }
            }
        } catch (FileNotFoundException e6) {
            e42 = e6;
            openFileInput = null;
            if (Log.isLoggable("FirebaseRemoteConfig", 3)) {
                Log.d("FirebaseRemoteConfig", "Persisted config file was not found.", e42);
            }
            if (openFileInput != null) {
                return null;
            }
            openFileInput.close();
            return null;
        } catch (IOException e7) {
            e42 = e7;
            openFileInput = null;
            Log.e("FirebaseRemoteConfig", "Cannot initialize from persisted config.", e42);
            if (openFileInput != null) {
                return null;
            }
            openFileInput.close();
            return null;
        } catch (Throwable th) {
            e42 = th;
            openFileInput = null;
            if (openFileInput != null) {
                openFileInput.close();
            }
            throw e42;
        }
    }

    private static zzan zza(zzar zzar) {
        int i = 0;
        if (zzar == null) {
            return null;
        }
        Map hashMap = new HashMap();
        for (zzau zzau : zzar.zzbe) {
            String str = zzau.zzbn;
            Map hashMap2 = new HashMap();
            for (zzas zzas : zzau.zzbo) {
                hashMap2.put(zzas.zzbh, zzas.zzbi);
            }
            hashMap.put(str, hashMap2);
        }
        byte[][] bArr = zzar.zzbf;
        List arrayList = new ArrayList();
        int length = bArr.length;
        while (i < length) {
            arrayList.add(bArr[i]);
            i++;
        }
        return new zzan(hashMap, zzar.timestamp, arrayList);
    }

    public boolean activateFetched() {
        this.zzam.writeLock().lock();
        try {
            if (this.zzah == null) {
                return false;
            }
            if (this.zzai == null || this.zzah.getTimestamp() > this.zzai.getTimestamp()) {
                long timestamp = this.zzah.getTimestamp();
                this.zzai = this.zzah;
                this.zzai.setTimestamp(System.currentTimeMillis());
                this.zzah = new zzan(null, timestamp, null);
                zzo();
                this.zzam.writeLock().unlock();
                return true;
            }
            this.zzam.writeLock().unlock();
            return false;
        } finally {
            this.zzam.writeLock().unlock();
        }
    }

    @KeepForSdk
    public boolean activateFetched(String str) {
        this.zzam.writeLock().lock();
        try {
            if (this.zzah == null) {
                return false;
            }
            if (this.zzai == null || this.zzah.getTimestamp() > this.zzai.getTimestamp()) {
                if (this.zzai == null) {
                    this.zzai = new zzan(null, 0, null);
                }
                Map zzc = this.zzah.zzc(str);
                if (zzc == null) {
                    this.zzam.writeLock().unlock();
                    return false;
                }
                this.zzai.zza(zzc, str);
                zzo();
                this.zzam.writeLock().unlock();
                return true;
            }
            this.zzam.writeLock().unlock();
            return false;
        } finally {
            this.zzam.writeLock().unlock();
        }
    }

    public void setDefaults(int i) {
        setDefaults(i, "configns:firebase");
    }

    public void setDefaults(int i, String str) {
        if (str != null) {
            this.zzam.readLock().lock();
            try {
                if (!(this.zzak == null || this.zzak.zzs() == null || this.zzak.zzs().get(str) == null)) {
                    zzal zzal = (zzal) this.zzak.zzs().get(str);
                    if (i == zzal.getResourceId() && this.zzak.zzt() == zzal.zzp()) {
                        if (Log.isLoggable("FirebaseRemoteConfig", 3)) {
                            Log.d("FirebaseRemoteConfig", "Skipped setting defaults from resource file as this resource file was already applied.");
                        }
                        this.zzam.readLock().unlock();
                        return;
                    }
                }
                this.zzam.readLock().unlock();
                Map hashMap = new HashMap();
                try {
                    XmlResourceParser xml = this.mContext.getResources().getXml(i);
                    Object obj = null;
                    Object obj2 = null;
                    Object obj3 = null;
                    for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                        if (eventType == 2) {
                            obj3 = xml.getName();
                        } else if (eventType == 3) {
                            if (!(!"entry".equals(xml.getName()) || obj2 == null || obj == null)) {
                                hashMap.put(obj2, obj);
                                obj = null;
                                obj2 = null;
                            }
                            obj3 = null;
                        } else if (eventType == 4) {
                            if ("key".equals(obj3)) {
                                obj2 = xml.getText();
                            } else if (Param.VALUE.equals(obj3)) {
                                obj = xml.getText();
                            }
                        }
                    }
                    this.zzak.zza(str, new zzal(i, this.zzak.zzt()));
                    zza(hashMap, str, false);
                } catch (Throwable e) {
                    Log.e("FirebaseRemoteConfig", "Caught exception while parsing XML resource. Skipping setDefaults.", e);
                }
            } catch (Throwable th) {
                this.zzam.readLock().unlock();
            }
        } else if (Log.isLoggable("FirebaseRemoteConfig", 3)) {
            Log.d("FirebaseRemoteConfig", "namespace cannot be null for setDefaults.");
        }
    }

    public void setDefaults(Map<String, Object> map) {
        setDefaults((Map) map, "configns:firebase");
    }

    public void setDefaults(Map<String, Object> map, String str) {
        zza(map, str, true);
    }

    private final void zza(Map<String, Object> map, String str, boolean z) {
        if (str != null) {
            Object obj = (map == null || map.isEmpty()) ? 1 : null;
            Map hashMap = new HashMap();
            if (obj == null) {
                for (String str2 : map.keySet()) {
                    Object obj2 = map.get(str2);
                    if (obj2 instanceof String) {
                        hashMap.put(str2, ((String) obj2).getBytes(zzap.UTF_8));
                    } else if (obj2 instanceof Long) {
                        hashMap.put(str2, ((Long) obj2).toString().getBytes(zzap.UTF_8));
                    } else if (obj2 instanceof Integer) {
                        hashMap.put(str2, ((Integer) obj2).toString().getBytes(zzap.UTF_8));
                    } else if (obj2 instanceof Double) {
                        hashMap.put(str2, ((Double) obj2).toString().getBytes(zzap.UTF_8));
                    } else if (obj2 instanceof Float) {
                        hashMap.put(str2, ((Float) obj2).toString().getBytes(zzap.UTF_8));
                    } else if (obj2 instanceof byte[]) {
                        hashMap.put(str2, (byte[]) obj2);
                    } else if (obj2 instanceof Boolean) {
                        hashMap.put(str2, ((Boolean) obj2).toString().getBytes(zzap.UTF_8));
                    } else {
                        throw new IllegalArgumentException("The type of a default value needs to beone of String, Long, Double, Boolean, or byte[].");
                    }
                }
            }
            this.zzam.writeLock().lock();
            if (obj != null) {
                try {
                    if (this.zzaj == null || !this.zzaj.zzb(str)) {
                        this.zzam.writeLock().unlock();
                        return;
                    } else {
                        this.zzaj.zza(null, str);
                        this.zzaj.setTimestamp(System.currentTimeMillis());
                    }
                } catch (Throwable th) {
                    this.zzam.writeLock().unlock();
                }
            } else {
                if (this.zzaj == null) {
                    this.zzaj = new zzan(new HashMap(), System.currentTimeMillis(), null);
                }
                this.zzaj.zza(hashMap, str);
                this.zzaj.setTimestamp(System.currentTimeMillis());
            }
            if (z) {
                this.zzak.zzd(str);
            }
            zzo();
            this.zzam.writeLock().unlock();
        }
    }

    public void setConfigSettings(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.zzam.writeLock().lock();
        try {
            boolean isDeveloperModeEnabled = this.zzak.isDeveloperModeEnabled();
            boolean isDeveloperModeEnabled2 = firebaseRemoteConfigSettings == null ? false : firebaseRemoteConfigSettings.isDeveloperModeEnabled();
            this.zzak.zza(isDeveloperModeEnabled2);
            if (isDeveloperModeEnabled != isDeveloperModeEnabled2) {
                zzo();
            }
            this.zzam.writeLock().unlock();
        } catch (Throwable th) {
            this.zzam.writeLock().unlock();
        }
    }

    public long getLong(String str) {
        return getLong(str, "configns:firebase");
    }

    public long getLong(String str, String str2) {
        long j = 0;
        if (str2 != null) {
            this.zzam.readLock().lock();
            try {
                if (this.zzai != null && this.zzai.zzb(str, str2)) {
                    try {
                        j = Long.valueOf(new String(this.zzai.zzc(str, str2), zzap.UTF_8)).longValue();
                    } catch (NumberFormatException e) {
                    }
                }
                if (this.zzaj != null && this.zzaj.zzb(str, str2)) {
                    try {
                        j = Long.valueOf(new String(this.zzaj.zzc(str, str2), zzap.UTF_8)).longValue();
                        this.zzam.readLock().unlock();
                    } catch (NumberFormatException e2) {
                    }
                }
                this.zzam.readLock().unlock();
            } finally {
                this.zzam.readLock().unlock();
            }
        }
        return j;
    }

    public byte[] getByteArray(String str) {
        return getByteArray(str, "configns:firebase");
    }

    public byte[] getByteArray(String str, String str2) {
        if (str2 == null) {
            return DEFAULT_VALUE_FOR_BYTE_ARRAY;
        }
        this.zzam.readLock().lock();
        byte[] bArr;
        if (this.zzai == null || !this.zzai.zzb(str, str2)) {
            try {
                if (this.zzaj == null || !this.zzaj.zzb(str, str2)) {
                    bArr = DEFAULT_VALUE_FOR_BYTE_ARRAY;
                    this.zzam.readLock().unlock();
                    return bArr;
                }
                bArr = this.zzaj.zzc(str, str2);
                this.zzam.readLock().unlock();
                return bArr;
            } finally {
                this.zzam.readLock().unlock();
            }
        } else {
            bArr = this.zzai.zzc(str, str2);
            return bArr;
        }
    }

    public String getString(String str) {
        return getString(str, "configns:firebase");
    }

    public String getString(String str, String str2) {
        if (str2 == null) {
            return "";
        }
        this.zzam.readLock().lock();
        String str3;
        if (this.zzai == null || !this.zzai.zzb(str, str2)) {
            try {
                if (this.zzaj == null || !this.zzaj.zzb(str, str2)) {
                    str3 = "";
                    this.zzam.readLock().unlock();
                    return str3;
                }
                str3 = new String(this.zzaj.zzc(str, str2), zzap.UTF_8);
                this.zzam.readLock().unlock();
                return str3;
            } finally {
                this.zzam.readLock().unlock();
            }
        } else {
            str3 = new String(this.zzai.zzc(str, str2), zzap.UTF_8);
            return str3;
        }
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, "configns:firebase");
    }

    public boolean getBoolean(String str, String str2) {
        Lock lock = true;
        if (str2 == null) {
            return false;
        }
        this.zzam.readLock().lock();
        try {
            CharSequence str3;
            if (this.zzai != null && this.zzai.zzb(str, str2)) {
                str3 = new String(this.zzai.zzc(str, str2), zzap.UTF_8);
                if (zzap.zzm.matcher(str3).matches()) {
                    return lock;
                }
                if (zzap.zzn.matcher(str3).matches()) {
                    this.zzam.readLock().unlock();
                    return false;
                }
            }
            if (this.zzaj != null && this.zzaj.zzb(str, str2)) {
                str3 = new String(this.zzaj.zzc(str, str2), zzap.UTF_8);
                if (zzap.zzm.matcher(str3).matches()) {
                    this.zzam.readLock().unlock();
                    return true;
                } else if (zzap.zzn.matcher(str3).matches()) {
                    this.zzam.readLock().unlock();
                    return false;
                }
            }
            this.zzam.readLock().unlock();
            return false;
        } finally {
            lock = this.zzam.readLock();
            lock.unlock();
        }
    }

    public double getDouble(String str) {
        return getDouble(str, "configns:firebase");
    }

    public double getDouble(String str, String str2) {
        double d = DEFAULT_VALUE_FOR_DOUBLE;
        if (str2 != null) {
            this.zzam.readLock().lock();
            try {
                if (this.zzai != null && this.zzai.zzb(str, str2)) {
                    try {
                        d = Double.valueOf(new String(this.zzai.zzc(str, str2), zzap.UTF_8)).doubleValue();
                    } catch (NumberFormatException e) {
                    }
                }
                if (this.zzaj != null && this.zzaj.zzb(str, str2)) {
                    try {
                        d = Double.valueOf(new String(this.zzaj.zzc(str, str2), zzap.UTF_8)).doubleValue();
                        this.zzam.readLock().unlock();
                    } catch (NumberFormatException e2) {
                    }
                }
                this.zzam.readLock().unlock();
            } finally {
                this.zzam.readLock().unlock();
            }
        }
        return d;
    }

    public FirebaseRemoteConfigValue getValue(String str) {
        return getValue(str, "configns:firebase");
    }

    public FirebaseRemoteConfigValue getValue(String str, String str2) {
        if (str2 == null) {
            return new zzap(DEFAULT_VALUE_FOR_BYTE_ARRAY, 0);
        }
        this.zzam.readLock().lock();
        FirebaseRemoteConfigValue zzap;
        if (this.zzai == null || !this.zzai.zzb(str, str2)) {
            try {
                if (this.zzaj == null || !this.zzaj.zzb(str, str2)) {
                    zzap = new zzap(DEFAULT_VALUE_FOR_BYTE_ARRAY, 0);
                    this.zzam.readLock().unlock();
                    return zzap;
                }
                zzap = new zzap(this.zzaj.zzc(str, str2), 1);
                this.zzam.readLock().unlock();
                return zzap;
            } finally {
                this.zzam.readLock().unlock();
            }
        } else {
            zzap = new zzap(this.zzai.zzc(str, str2), 2);
            return zzap;
        }
    }

    public FirebaseRemoteConfigInfo getInfo() {
        FirebaseRemoteConfigInfo zzao = new zzao();
        this.zzam.readLock().lock();
        try {
            zzao.zzb(this.zzah == null ? -1 : this.zzah.getTimestamp());
            zzao.zzf(this.zzak.getLastFetchStatus());
            zzao.setConfigSettings(new Builder().setDeveloperModeEnabled(this.zzak.isDeveloperModeEnabled()).build());
            return zzao;
        } finally {
            this.zzam.readLock().unlock();
        }
    }

    public Set<String> getKeysByPrefix(String str) {
        return getKeysByPrefix(str, "configns:firebase");
    }

    public Set<String> getKeysByPrefix(String str, String str2) {
        this.zzam.readLock().lock();
        try {
            Set<String> treeSet = new TreeSet();
            if (this.zzai != null) {
                treeSet.addAll(this.zzai.zzd(str, str2));
            }
            if (this.zzaj != null) {
                treeSet.addAll(this.zzaj.zzd(str, str2));
            }
            this.zzam.readLock().unlock();
            return treeSet;
        } catch (Throwable th) {
            this.zzam.readLock().unlock();
        }
    }

    private final void zzo() {
        this.zzam.readLock().lock();
        try {
            AsyncTask.SERIAL_EXECUTOR.execute(new zzam(this.mContext, this.zzah, this.zzai, this.zzaj, this.zzak));
        } finally {
            this.zzam.readLock().unlock();
        }
    }

    public Task<Void> fetch() {
        return fetch(43200);
    }

    public Task<Void> fetch(long j) {
        return zza(j, new zzv(this.mContext));
    }

    private final Task<Void> zza(long j, zzv zzv) {
        int i = BaseClientBuilder.API_PRIORITY_OTHER;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zzam.readLock().lock();
        try {
            long convert;
            zzj zzj = new zzj();
            zzj.zza(j);
            if (this.zzal != null) {
                zzj.zza(this.zzal.getOptions().getApplicationId());
            }
            if (this.zzak.isDeveloperModeEnabled()) {
                zzj.zza("_rcn_developer", "true");
            }
            zzj.zza(10300);
            if (!(this.zzai == null || this.zzai.getTimestamp() == -1)) {
                convert = TimeUnit.SECONDS.convert(System.currentTimeMillis() - this.zzai.getTimestamp(), TimeUnit.MILLISECONDS);
                zzj.zzc(convert < 2147483647L ? (int) convert : BaseClientBuilder.API_PRIORITY_OTHER);
            }
            if (!(this.zzah == null || this.zzah.getTimestamp() == -1)) {
                convert = TimeUnit.SECONDS.convert(System.currentTimeMillis() - this.zzah.getTimestamp(), TimeUnit.MILLISECONDS);
                if (convert < 2147483647L) {
                    i = (int) convert;
                }
                zzj.zzb(i);
            }
            zze.zzf.zza(zzv.asGoogleApiClient(), zzj.zzg()).setResultCallback(new zza(this, taskCompletionSource));
            return taskCompletionSource.getTask();
        } finally {
            this.zzam.readLock().unlock();
        }
    }

    final void zza(TaskCompletionSource<Void> taskCompletionSource, zzk zzk) {
        if (zzk == null || zzk.getStatus() == null) {
            zza((TaskCompletionSource) taskCompletionSource, null);
            return;
        }
        int statusCode = zzk.getStatus().getStatusCode();
        this.zzam.writeLock().lock();
        Map zzi;
        Map hashMap;
        Map hashMap2;
        switch (statusCode) {
            case -6508:
            case -6506:
                this.zzak.zzf(-1);
                if (!(this.zzah == null || this.zzah.zzr())) {
                    zzi = zzk.zzi();
                    hashMap = new HashMap();
                    for (String str : zzi.keySet()) {
                        hashMap2 = new HashMap();
                        for (String str2 : (Set) zzi.get(str)) {
                            hashMap2.put(str2, zzk.zza(str2, null, str));
                        }
                        hashMap.put(str, hashMap2);
                    }
                    this.zzah = new zzan(hashMap, this.zzah.getTimestamp(), zzk.zzh());
                }
                taskCompletionSource.setResult(null);
                zzo();
                break;
            case -6505:
                zzi = zzk.zzi();
                hashMap = new HashMap();
                for (String str3 : zzi.keySet()) {
                    hashMap2 = new HashMap();
                    for (String str22 : (Set) zzi.get(str3)) {
                        hashMap2.put(str22, zzk.zza(str22, null, str3));
                    }
                    hashMap.put(str3, hashMap2);
                }
                this.zzah = new zzan(hashMap, System.currentTimeMillis(), zzk.zzh());
                this.zzak.zzf(-1);
                taskCompletionSource.setResult(null);
                zzo();
                break;
            case 6500:
            case 6501:
            case 6503:
            case 6504:
                zza((TaskCompletionSource) taskCompletionSource, zzk.getStatus());
                break;
            case 6502:
            case 6507:
                this.zzak.zzf(2);
                taskCompletionSource.setException(new FirebaseRemoteConfigFetchThrottledException(zzk.getThrottleEndTimeMillis()));
                zzo();
                break;
            default:
                try {
                    if (zzk.getStatus().isSuccess()) {
                        Log.w("FirebaseRemoteConfig", "Unknown (successful) status code: " + statusCode);
                    }
                    zza((TaskCompletionSource) taskCompletionSource, zzk.getStatus());
                    break;
                } catch (Throwable th) {
                    this.zzam.writeLock().unlock();
                }
        }
        this.zzam.writeLock().unlock();
    }

    private final void zza(TaskCompletionSource<Void> taskCompletionSource, Status status) {
        if (status == null) {
            Log.w("FirebaseRemoteConfig", "Received null IPC status for failure.");
        } else {
            int statusCode = status.getStatusCode();
            String statusMessage = status.getStatusMessage();
            Log.w("FirebaseRemoteConfig", new StringBuilder(String.valueOf(statusMessage).length() + 25).append("IPC failure: ").append(statusCode).append(":").append(statusMessage).toString());
        }
        this.zzam.writeLock().lock();
        try {
            this.zzak.zzf(1);
            taskCompletionSource.setException(new FirebaseRemoteConfigFetchException());
            zzo();
        } finally {
            this.zzam.writeLock().unlock();
        }
    }
}
