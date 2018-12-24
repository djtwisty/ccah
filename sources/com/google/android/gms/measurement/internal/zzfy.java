package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzdq;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

public final class zzfy extends zzcs {
    private static final String[] zzauo = new String[]{"firebase_", "google_", "ga_"};
    private int zzado;
    private SecureRandom zzaup;
    private final AtomicLong zzauq = new AtomicLong(0);
    private Integer zzaur = null;

    zzfy(zzbw zzbw) {
        super(zzbw);
    }

    protected final boolean zzgy() {
        return true;
    }

    protected final void zzgz() {
        zzaf();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                zzgt().zzjj().zzby("Utils falling back to Random for random id");
            }
        }
        this.zzauq.set(nextLong);
    }

    public final long zzmj() {
        long nextLong;
        if (this.zzauq.get() == 0) {
            synchronized (this.zzauq) {
                nextLong = new Random(System.nanoTime() ^ zzbx().currentTimeMillis()).nextLong();
                int i = this.zzado + 1;
                this.zzado = i;
                nextLong += (long) i;
            }
        } else {
            synchronized (this.zzauq) {
                this.zzauq.compareAndSet(-1, 1);
                nextLong = this.zzauq.getAndIncrement();
            }
        }
        return nextLong;
    }

    final SecureRandom zzmk() {
        zzaf();
        if (this.zzaup == null) {
            this.zzaup = new SecureRandom();
        }
        return this.zzaup;
    }

    static boolean zzct(String str) {
        Preconditions.checkNotEmpty(str);
        if (str.charAt(0) != '_' || str.equals("_ep")) {
            return true;
        }
        return false;
    }

    final Bundle zza(Uri uri) {
        Bundle bundle = null;
        if (uri != null) {
            try {
                Object queryParameter;
                Object queryParameter2;
                Object queryParameter3;
                Object queryParameter4;
                if (uri.isHierarchical()) {
                    queryParameter = uri.getQueryParameter("utm_campaign");
                    queryParameter2 = uri.getQueryParameter("utm_source");
                    queryParameter3 = uri.getQueryParameter("utm_medium");
                    queryParameter4 = uri.getQueryParameter("gclid");
                } else {
                    queryParameter4 = null;
                    queryParameter3 = null;
                    queryParameter2 = null;
                    queryParameter = null;
                }
                if (!(TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4))) {
                    bundle = new Bundle();
                    if (!TextUtils.isEmpty(queryParameter)) {
                        bundle.putString(Param.CAMPAIGN, queryParameter);
                    }
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        bundle.putString(Param.SOURCE, queryParameter2);
                    }
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        bundle.putString(Param.MEDIUM, queryParameter3);
                    }
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("gclid", queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter("utm_term");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString(Param.TERM, queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter("utm_content");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString(Param.CONTENT, queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter(Param.ACLID);
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString(Param.ACLID, queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter(Param.CP1);
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString(Param.CP1, queryParameter4);
                    }
                    queryParameter4 = uri.getQueryParameter("anid");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("anid", queryParameter4);
                    }
                }
            } catch (UnsupportedOperationException e) {
                zzgt().zzjj().zzg("Install referrer url isn't a hierarchical URI", e);
            }
        }
        return bundle;
    }

    static boolean zzc(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    final boolean zzs(String str, String str2) {
        if (str2 == null) {
            zzgt().zzjg().zzg("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzgt().zzjg().zzg("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt)) {
                int length = str2.length();
                codePointAt = Character.charCount(codePointAt);
                while (codePointAt < length) {
                    int codePointAt2 = str2.codePointAt(codePointAt);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        codePointAt += Character.charCount(codePointAt2);
                    } else {
                        zzgt().zzjg().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzgt().zzjg().zze("Name must start with a letter. Type, name", str, str2);
            return false;
        }
    }

    private final boolean zzt(String str, String str2) {
        if (str2 == null) {
            zzgt().zzjg().zzg("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzgt().zzjg().zzg("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                codePointAt = Character.charCount(codePointAt);
                while (codePointAt < length) {
                    int codePointAt2 = str2.codePointAt(codePointAt);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        codePointAt += Character.charCount(codePointAt2);
                    } else {
                        zzgt().zzjg().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzgt().zzjg().zze("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    final boolean zza(String str, String[] strArr, String str2) {
        if (str2 == null) {
            zzgt().zzjg().zzg("Name is required and can't be null. Type", str);
            return false;
        }
        boolean z;
        Preconditions.checkNotNull(str2);
        for (String startsWith : zzauo) {
            if (str2.startsWith(startsWith)) {
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            zzgt().zzjg().zze("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr != null) {
            Preconditions.checkNotNull(strArr);
            for (String zzv : strArr) {
                if (zzv(str2, zzv)) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                zzgt().zzjg().zze("Name is reserved. Type, name", str, str2);
                return false;
            }
        }
        return true;
    }

    final boolean zza(String str, int i, String str2) {
        if (str2 == null) {
            zzgt().zzjg().zzg("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            zzgt().zzjg().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    final int zzcu(String str) {
        if (!zzt("event", str)) {
            return 2;
        }
        if (!zza("event", zzcu.zzaqq, str)) {
            return 13;
        }
        if (zza("event", 40, str)) {
            return 0;
        }
        return 2;
    }

    final int zzcv(String str) {
        if (!zzt("user property", str)) {
            return 6;
        }
        if (!zza("user property", zzcw.zzaqu, str)) {
            return 15;
        }
        if (zza("user property", 24, str)) {
            return 0;
        }
        return 6;
    }

    private final boolean zza(String str, String str2, int i, Object obj, boolean z) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) <= i) {
                return true;
            }
            zzgt().zzjj().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
            return false;
        } else if ((obj instanceof Bundle) && z) {
            return true;
        } else {
            int length;
            int i2;
            Object obj2;
            if ((obj instanceof Parcelable[]) && z) {
                Parcelable[] parcelableArr = (Parcelable[]) obj;
                length = parcelableArr.length;
                i2 = 0;
                while (i2 < length) {
                    obj2 = parcelableArr[i2];
                    if (obj2 instanceof Bundle) {
                        i2++;
                    } else {
                        zzgt().zzjj().zze("All Parcelable[] elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                        return false;
                    }
                }
                return true;
            } else if (!(obj instanceof ArrayList) || !z) {
                return false;
            } else {
                ArrayList arrayList = (ArrayList) obj;
                length = arrayList.size();
                i2 = 0;
                while (i2 < length) {
                    obj2 = arrayList.get(i2);
                    i2++;
                    if (!(obj2 instanceof Bundle)) {
                        zzgt().zzjj().zze("All ArrayList elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                        return false;
                    }
                }
                return true;
            }
        }
    }

    final boolean zzu(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                if (!this.zzada.zzkn()) {
                    return false;
                }
                zzgt().zzjg().zzby("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
                return false;
            } else if (!zzcw(str2)) {
                zzgt().zzjg().zzg("Invalid admob_app_id. Analytics disabled.", zzas.zzbw(str2));
                return false;
            }
        } else if (!zzcw(str)) {
            if (!this.zzada.zzkn()) {
                return false;
            }
            zzgt().zzjg().zzg("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzas.zzbw(str));
            return false;
        }
        return true;
    }

    static boolean zza(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (isEmpty || isEmpty2) {
            if (isEmpty && isEmpty2) {
                if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                    if (TextUtils.isEmpty(str4)) {
                        return false;
                    }
                    return true;
                } else if (str3.equals(str4)) {
                    return false;
                } else {
                    return true;
                }
            } else if (isEmpty || !isEmpty2) {
                if (TextUtils.isEmpty(str3) || !str3.equals(str4)) {
                    return true;
                }
                return false;
            } else if (TextUtils.isEmpty(str4)) {
                return false;
            } else {
                if (TextUtils.isEmpty(str3) || !str3.equals(str4)) {
                    return true;
                }
                return false;
            }
        } else if (str.equals(str2)) {
            return false;
        } else {
            return true;
        }
    }

    @VisibleForTesting
    private static boolean zzcw(String str) {
        Preconditions.checkNotNull(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    private static Object zza(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            return ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) ? zza(String.valueOf(obj), i, z) : null;
        }
    }

    public static String zza(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) > i) {
            return z ? String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...") : null;
        } else {
            return str;
        }
    }

    final Object zzh(String str, Object obj) {
        int i = 256;
        if ("_ev".equals(str)) {
            return zza(256, obj, true);
        }
        if (!zzcy(str)) {
            i = 100;
        }
        return zza(i, obj, false);
    }

    static Bundle[] zzf(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        } else if (obj instanceof Parcelable[]) {
            return (Bundle[]) Arrays.copyOf((Parcelable[]) obj, ((Parcelable[]) obj).length, Bundle[].class);
        } else {
            if (!(obj instanceof ArrayList)) {
                return null;
            }
            ArrayList arrayList = (ArrayList) obj;
            return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    final Bundle zza(String str, String str2, Bundle bundle, List<String> list, boolean z, boolean z2) {
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int i = 0;
        for (String str3 : bundle.keySet()) {
            int i2 = 0;
            if (list == null || !list.contains(str3)) {
                if (z) {
                    if (!zzs("event param", str3)) {
                        i2 = 3;
                    } else if (!zza("event param", null, str3)) {
                        i2 = 14;
                    } else if (zza("event param", 40, str3)) {
                        i2 = 0;
                    } else {
                        i2 = 3;
                    }
                }
                if (i2 == 0) {
                    if (!zzt("event param", str3)) {
                        i2 = 3;
                    } else if (!zza("event param", null, str3)) {
                        i2 = 14;
                    } else if (zza("event param", 40, str3)) {
                        i2 = 0;
                    } else {
                        i2 = 3;
                    }
                }
            }
            if (i2 != 0) {
                if (zza(bundle2, i2)) {
                    bundle2.putString("_ev", zza(str3, 40, true));
                    if (i2 == 3) {
                        zza(bundle2, (Object) str3);
                    }
                }
                bundle2.remove(str3);
            } else {
                boolean zza;
                Object obj = bundle.get(str3);
                zzaf();
                if (z2) {
                    Object obj2;
                    String str4 = "param";
                    if (obj instanceof Parcelable[]) {
                        i2 = ((Parcelable[]) obj).length;
                    } else if (obj instanceof ArrayList) {
                        i2 = ((ArrayList) obj).size();
                    } else {
                        obj2 = 1;
                        if (obj2 == null) {
                            i2 = 17;
                            if (i2 != 0 || "_ev".equals(str3)) {
                                if (zzct(str3)) {
                                    i2 = i + 1;
                                    if (i2 > 25) {
                                        zzgt().zzjg().zze("Event can't contain more than 25 params", zzgq().zzbt(str2), zzgq().zzd(bundle));
                                        zza(bundle2, 5);
                                        bundle2.remove(str3);
                                        i = i2;
                                    }
                                } else {
                                    i2 = i;
                                }
                                i = i2;
                            } else {
                                if (zza(bundle2, i2)) {
                                    bundle2.putString("_ev", zza(str3, 40, true));
                                    zza(bundle2, bundle.get(str3));
                                }
                                bundle2.remove(str3);
                            }
                        }
                    }
                    if (i2 > 1000) {
                        zzgt().zzjj().zzd("Parameter array is too long; discarded. Value kind, name, array length", str4, str3, Integer.valueOf(i2));
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (obj2 == null) {
                        i2 = 17;
                        if (i2 != 0) {
                        }
                        if (zzct(str3)) {
                            i2 = i;
                        } else {
                            i2 = i + 1;
                            if (i2 > 25) {
                                zzgt().zzjg().zze("Event can't contain more than 25 params", zzgq().zzbt(str2), zzgq().zzd(bundle));
                                zza(bundle2, 5);
                                bundle2.remove(str3);
                                i = i2;
                            }
                        }
                        i = i2;
                    }
                }
                if ((zzgv().zzav(str) && zzcy(str2)) || zzcy(str3)) {
                    zza = zza("param", str3, 256, obj, z2);
                } else {
                    zza = zza("param", str3, 100, obj, z2);
                }
                i2 = zza ? 0 : 4;
                if (i2 != 0) {
                }
                if (zzct(str3)) {
                    i2 = i + 1;
                    if (i2 > 25) {
                        zzgt().zzjg().zze("Event can't contain more than 25 params", zzgq().zzbt(str2), zzgq().zzd(bundle));
                        zza(bundle2, 5);
                        bundle2.remove(str3);
                        i = i2;
                    }
                } else {
                    i2 = i;
                }
                i = i2;
            }
        }
        return bundle2;
    }

    private static boolean zza(Bundle bundle, int i) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    private static void zza(Bundle bundle, Object obj) {
        Preconditions.checkNotNull(bundle);
        if (obj == null) {
            return;
        }
        if ((obj instanceof String) || (obj instanceof CharSequence)) {
            bundle.putLong("_el", (long) String.valueOf(obj).length());
        }
    }

    private static int zzcx(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        if ("_id".equals(str)) {
            return 256;
        }
        return 36;
    }

    final int zzi(String str, Object obj) {
        boolean zza;
        if ("_ldl".equals(str)) {
            zza = zza("user property referrer", str, zzcx(str), obj, false);
        } else {
            zza = zza("user property", str, zzcx(str), obj, false);
        }
        if (zza) {
            return 0;
        }
        return 7;
    }

    final Object zzj(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return zza(zzcx(str), obj, true);
        }
        return zza(zzcx(str), obj, false);
    }

    final void zza(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (str != null) {
                zzgt().zzjl().zze("Not putting event parameter. Invalid value type. name, type", zzgq().zzbu(str), obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public final void zza(int i, String str, String str2, int i2) {
        zza(null, i, str, str2, i2);
    }

    final void zza(String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zza(bundle, i);
        if (zzgv().zze(str, zzai.zzalg)) {
            if (!(TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3))) {
                bundle.putString(str2, str3);
            }
        } else if (!TextUtils.isEmpty(str2)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        this.zzada.zzgw();
        this.zzada.zzgj().logEvent("auto", "_err", bundle);
    }

    static MessageDigest getMessageDigest() {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return null;
    }

    @VisibleForTesting
    static long zzc(byte[] bArr) {
        long j = null;
        Preconditions.checkNotNull(bArr);
        Preconditions.checkState(bArr.length > 0);
        long j2 = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j2 += (((long) bArr[length]) & 255) << j;
            j += 8;
            length--;
        }
        return j2;
    }

    static boolean zza(Context context, boolean z) {
        Preconditions.checkNotNull(context);
        if (VERSION.SDK_INT >= 24) {
            return zzc(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return zzc(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    private static boolean zzc(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0);
            if (serviceInfo == null || !serviceInfo.enabled) {
                return false;
            }
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    final boolean zzx(String str) {
        zzaf();
        if (Wrappers.packageManager(getContext()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzgt().zzjn().zzg("Permission not granted", str);
        return false;
    }

    static boolean zzcy(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    static boolean zzv(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    final boolean zzcz(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String zzid = zzgv().zzid();
        zzgw();
        return zzid.equals(str);
    }

    final Bundle zze(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zzh = zzh(str, bundle.get(str));
                if (zzh == null) {
                    zzgt().zzjj().zzg("Param value can't be null", zzgq().zzbu(str));
                } else {
                    zza(bundle2, str, zzh);
                }
            }
        }
        return bundle2;
    }

    final zzag zza(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zzcu(str2) != 0) {
            zzgt().zzjg().zzg("Invalid conditional property event name", zzgq().zzbv(str2));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str3);
        return new zzag(str2, new zzad(zze(zza(str, str2, bundle2, CollectionUtils.listOf((Object) "_o"), false, false))), str3, j);
    }

    final long zzd(Context context, String str) {
        zzaf();
        Preconditions.checkNotNull(context);
        Preconditions.checkNotEmpty(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest messageDigest = getMessageDigest();
        if (messageDigest == null) {
            zzgt().zzjg().zzby("Could not get MD5 instance");
            return -1;
        }
        if (packageManager != null) {
            try {
                if (!zze(context, str)) {
                    PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(getContext().getPackageName(), 64);
                    if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                        return zzc(messageDigest.digest(packageInfo.signatures[0].toByteArray()));
                    }
                    zzgt().zzjj().zzby("Could not get signatures");
                    return -1;
                }
            } catch (NameNotFoundException e) {
                zzgt().zzjg().zzg("Package name not found", e);
            }
        }
        return 0;
    }

    @VisibleForTesting
    private final boolean zze(Context context, String str) {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
            }
        } catch (CertificateException e) {
            zzgt().zzjg().zzg("Error obtaining certificate", e);
        } catch (NameNotFoundException e2) {
            zzgt().zzjg().zzg("Package name not found", e2);
        }
        return true;
    }

    static byte[] zza(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            return marshall;
        } finally {
            obtain.recycle();
        }
    }

    public static Bundle zzf(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else if (obj instanceof Parcelable[]) {
                Parcelable[] parcelableArr = (Parcelable[]) obj;
                for (r2 = 0; r2 < parcelableArr.length; r2++) {
                    if (parcelableArr[r2] instanceof Bundle) {
                        parcelableArr[r2] = new Bundle((Bundle) parcelableArr[r2]);
                    }
                }
            } else if (obj instanceof List) {
                List list = (List) obj;
                for (r2 = 0; r2 < list.size(); r2++) {
                    Object obj2 = list.get(r2);
                    if (obj2 instanceof Bundle) {
                        list.set(r2, new Bundle((Bundle) obj2));
                    }
                }
            }
        }
        return bundle2;
    }

    public final int zzml() {
        if (this.zzaur == null) {
            this.zzaur = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(getContext()) / 1000);
        }
        return this.zzaur.intValue();
    }

    public final int zzs(int i) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(getContext(), 12451000);
    }

    public static long zzc(long j, long j2) {
        return ((60000 * j2) + j) / 86400000;
    }

    final String zzmm() {
        zzmk().nextBytes(new byte[16]);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, r0)});
    }

    final void zza(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            zzgt().zzjj().zzg("Params already contained engagement", Long.valueOf(j2));
        }
        bundle.putLong("_et", j2 + j);
    }

    public final void zzb(zzdq zzdq, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzdq.zzb(bundle);
        } catch (RemoteException e) {
            this.zzada.zzgt().zzjj().zzg("Error returning string value to wrapper", e);
        }
    }

    public final void zza(zzdq zzdq, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            zzdq.zzb(bundle);
        } catch (RemoteException e) {
            this.zzada.zzgt().zzjj().zzg("Error returning long value to wrapper", e);
        }
    }

    public final void zza(zzdq zzdq, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            zzdq.zzb(bundle);
        } catch (RemoteException e) {
            this.zzada.zzgt().zzjj().zzg("Error returning int value to wrapper", e);
        }
    }

    public final void zza(zzdq zzdq, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzdq.zzb(bundle);
        } catch (RemoteException e) {
            this.zzada.zzgt().zzjj().zzg("Error returning byte array to wrapper", e);
        }
    }

    public final void zza(zzdq zzdq, Bundle bundle) {
        try {
            zzdq.zzb(bundle);
        } catch (RemoteException e) {
            this.zzada.zzgt().zzjj().zzg("Error returning bundle value to wrapper", e);
        }
    }

    public static Bundle zzd(List<zzfv> list) {
        Bundle bundle = new Bundle();
        if (list == null) {
            return bundle;
        }
        for (zzfv zzfv : list) {
            if (zzfv.zzaml != null) {
                bundle.putString(zzfv.name, zzfv.zzaml);
            } else if (zzfv.zzaul != null) {
                bundle.putLong(zzfv.name, zzfv.zzaul.longValue());
            } else if (zzfv.zzaun != null) {
                bundle.putDouble(zzfv.name, zzfv.zzaun.doubleValue());
            }
        }
        return bundle;
    }

    public final /* bridge */ /* synthetic */ void zzgf() {
        super.zzgf();
    }

    public final /* bridge */ /* synthetic */ void zzgg() {
        super.zzgg();
    }

    public final /* bridge */ /* synthetic */ void zzgh() {
        super.zzgh();
    }

    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    public final /* bridge */ /* synthetic */ zzaa zzgp() {
        return super.zzgp();
    }

    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final /* bridge */ /* synthetic */ zzaq zzgq() {
        return super.zzgq();
    }

    public final /* bridge */ /* synthetic */ zzfy zzgr() {
        return super.zzgr();
    }

    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    public final /* bridge */ /* synthetic */ zzas zzgt() {
        return super.zzgt();
    }

    public final /* bridge */ /* synthetic */ zzbd zzgu() {
        return super.zzgu();
    }

    public final /* bridge */ /* synthetic */ zzq zzgv() {
        return super.zzgv();
    }

    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }
}
