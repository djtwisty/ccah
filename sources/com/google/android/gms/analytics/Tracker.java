package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzau;
import com.google.android.gms.internal.measurement.zzaw;
import com.google.android.gms.internal.measurement.zzcn;
import com.google.android.gms.internal.measurement.zzdf;
import com.google.android.gms.internal.measurement.zzdg;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

@VisibleForTesting
public class Tracker extends zzau {
    private boolean zzsx;
    private final Map<String, String> zzsy = new HashMap();
    private final Map<String, String> zzsz = new HashMap();
    private final zzcn zzta;
    private final zza zztb;
    private ExceptionReporter zztc;
    private zzdf zztd;

    class zza extends zzau implements zza {
        private final /* synthetic */ Tracker zztl;
        private boolean zztm;
        private int zztn;
        private long zzto = -1;
        private boolean zztp;
        private long zztq;

        protected zza(Tracker tracker, zzaw zzaw) {
            this.zztl = tracker;
            super(zzaw);
        }

        protected final void zzag() {
        }

        public final void setSessionTimeout(long j) {
            this.zzto = j;
            zzai();
        }

        public final void enableAutoActivityTracking(boolean z) {
            this.zztm = z;
            zzai();
        }

        public final synchronized boolean zzah() {
            boolean z;
            z = this.zztp;
            this.zztp = false;
            return z;
        }

        private final void zzai() {
            if (this.zzto >= 0 || this.zztm) {
                zzcb().zza(this.zztl.zztb);
            } else {
                zzcb().zzb(this.zztl.zztb);
            }
        }

        public final void zzc(Activity activity) {
            if (this.zztn == 0) {
                if (zzbx().elapsedRealtime() >= this.zztq + Math.max(1000, this.zzto)) {
                    this.zztp = true;
                }
            }
            this.zztn++;
            if (this.zztm) {
                String str;
                Intent intent = activity.getIntent();
                if (intent != null) {
                    this.zztl.setCampaignParamsOnNextHit(intent.getData());
                }
                Map hashMap = new HashMap();
                hashMap.put("&t", "screenview");
                Tracker tracker = this.zztl;
                String str2 = "&cd";
                if (this.zztl.zztd != null) {
                    zzdf zzk = this.zztl.zztd;
                    String canonicalName = activity.getClass().getCanonicalName();
                    str = (String) zzk.zzaco.get(canonicalName);
                    if (str == null) {
                        str = canonicalName;
                    }
                } else {
                    str = activity.getClass().getCanonicalName();
                }
                tracker.set(str2, str);
                if (TextUtils.isEmpty((CharSequence) hashMap.get("&dr"))) {
                    CharSequence charSequence;
                    Preconditions.checkNotNull(activity);
                    intent = activity.getIntent();
                    if (intent == null) {
                        charSequence = null;
                    } else {
                        charSequence = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                        if (TextUtils.isEmpty(charSequence)) {
                            charSequence = null;
                        }
                    }
                    if (!TextUtils.isEmpty(charSequence)) {
                        hashMap.put("&dr", charSequence);
                    }
                }
                this.zztl.send(hashMap);
            }
        }

        public final void zzd(Activity activity) {
            this.zztn--;
            this.zztn = Math.max(0, this.zztn);
            if (this.zztn == 0) {
                this.zztq = zzbx().elapsedRealtime();
            }
        }
    }

    Tracker(zzaw zzaw, String str, zzcn zzcn) {
        super(zzaw);
        if (str != null) {
            this.zzsy.put("&tid", str);
        }
        this.zzsy.put("useSecure", "1");
        this.zzsy.put("&a", Integer.toString(new Random().nextInt(BaseClientBuilder.API_PRIORITY_OTHER) + 1));
        this.zzta = new zzcn("tracking", zzbx());
        this.zztb = new zza(this, zzaw);
    }

    protected final void zzag() {
        this.zztb.zzq();
        String zzaj = zzce().zzaj();
        if (zzaj != null) {
            set("&an", zzaj);
        }
        zzaj = zzce().zzak();
        if (zzaj != null) {
            set("&av", zzaj);
        }
    }

    final void zza(zzdf zzdf) {
        boolean z;
        boolean z2 = true;
        zzq("Loading Tracker config values");
        this.zztd = zzdf;
        if (this.zztd.zzaci != null) {
            String str = this.zztd.zzaci;
            set("&tid", str);
            zza("trackingId loaded", str);
        }
        if (this.zztd.zzacj >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            str = Double.toString(this.zztd.zzacj);
            set("&sf", str);
            zza("Sample frequency loaded", str);
        }
        if (this.zztd.zzack >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int i = this.zztd.zzack;
            setSessionTimeout((long) i);
            zza("Session timeout loaded", Integer.valueOf(i));
        }
        if (this.zztd.zzacl != -1) {
            if (this.zztd.zzacl == 1) {
                z = true;
            } else {
                z = false;
            }
            enableAutoActivityTracking(z);
            zza("Auto activity tracking loaded", Boolean.valueOf(z));
        }
        if (this.zztd.zzacm != -1) {
            if (this.zztd.zzacm == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                set("&aip", "1");
            }
            zza("Anonymize ip loaded", Boolean.valueOf(z));
        }
        if (this.zztd.zzacn != 1) {
            z2 = false;
        }
        enableExceptionReporting(z2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void enableExceptionReporting(boolean r4) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.zztc;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x000a;
    L_0x0005:
        r0 = 1;
    L_0x0006:
        if (r0 != r4) goto L_0x000c;
    L_0x0008:
        monitor-exit(r3);	 Catch:{ all -> 0x0029 }
    L_0x0009:
        return;
    L_0x000a:
        r0 = 0;
        goto L_0x0006;
    L_0x000c:
        if (r4 == 0) goto L_0x002c;
    L_0x000e:
        r0 = r3.getContext();	 Catch:{ all -> 0x0029 }
        r1 = java.lang.Thread.getDefaultUncaughtExceptionHandler();	 Catch:{ all -> 0x0029 }
        r2 = new com.google.android.gms.analytics.ExceptionReporter;	 Catch:{ all -> 0x0029 }
        r2.<init>(r3, r1, r0);	 Catch:{ all -> 0x0029 }
        r3.zztc = r2;	 Catch:{ all -> 0x0029 }
        r0 = r3.zztc;	 Catch:{ all -> 0x0029 }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(r0);	 Catch:{ all -> 0x0029 }
        r0 = "Uncaught exceptions will be reported to Google Analytics";
        r3.zzq(r0);	 Catch:{ all -> 0x0029 }
    L_0x0027:
        monitor-exit(r3);	 Catch:{ all -> 0x0029 }
        goto L_0x0009;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0029 }
        throw r0;
    L_0x002c:
        r0 = r3.zztc;	 Catch:{ all -> 0x0029 }
        r0 = r0.zzp();	 Catch:{ all -> 0x0029 }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(r0);	 Catch:{ all -> 0x0029 }
        r0 = "Uncaught exceptions will not be reported to Google Analytics";
        r3.zzq(r0);	 Catch:{ all -> 0x0029 }
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.Tracker.enableExceptionReporting(boolean):void");
    }

    public void setSessionTimeout(long j) {
        this.zztb.setSessionTimeout(1000 * j);
    }

    public void enableAutoActivityTracking(boolean z) {
        this.zztb.enableAutoActivityTracking(z);
    }

    private static String zza(Entry<String, String> entry) {
        int i;
        String str = (String) entry.getKey();
        if (!str.startsWith("&") || str.length() < 2) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            return null;
        }
        return ((String) entry.getKey()).substring(1);
    }

    private static void zza(Map<String, String> map, Map<String, String> map2) {
        Preconditions.checkNotNull(map2);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                String zza = zza(entry);
                if (zza != null) {
                    map2.put(zza, (String) entry.getValue());
                }
            }
        }
    }

    public void send(Map<String, String> map) {
        long currentTimeMillis = zzbx().currentTimeMillis();
        if (zzcb().getAppOptOut()) {
            zzr("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        boolean isDryRunEnabled = zzcb().isDryRunEnabled();
        Map hashMap = new HashMap();
        zza(this.zzsy, hashMap);
        zza(map, hashMap);
        boolean zzb = zzdg.zzb((String) this.zzsy.get("useSecure"), true);
        Map map2 = this.zzsz;
        Preconditions.checkNotNull(hashMap);
        if (map2 != null) {
            for (Entry entry : map2.entrySet()) {
                String zza = zza(entry);
                if (!(zza == null || hashMap.containsKey(zza))) {
                    hashMap.put(zza, (String) entry.getValue());
                }
            }
        }
        this.zzsz.clear();
        String str = (String) hashMap.get("t");
        if (TextUtils.isEmpty(str)) {
            zzby().zza(hashMap, "Missing hit type parameter");
            return;
        }
        String str2 = (String) hashMap.get("tid");
        if (TextUtils.isEmpty(str2)) {
            zzby().zza(hashMap, "Missing tracking id parameter");
            return;
        }
        boolean z = this.zzsx;
        synchronized (this) {
            if ("screenview".equalsIgnoreCase(str) || "pageview".equalsIgnoreCase(str) || "appview".equalsIgnoreCase(str) || TextUtils.isEmpty(str)) {
                int parseInt = Integer.parseInt((String) this.zzsy.get("&a")) + 1;
                if (parseInt >= BaseClientBuilder.API_PRIORITY_OTHER) {
                    parseInt = 1;
                }
                this.zzsy.put("&a", Integer.toString(parseInt));
            }
        }
        zzca().zza(new zzp(this, hashMap, z, str, currentTimeMillis, isDryRunEnabled, zzb, str2));
    }

    public String get(String str) {
        zzcl();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.zzsy.containsKey(str)) {
            return (String) this.zzsy.get(str);
        }
        if (str.equals("&ul")) {
            return zzdg.zza(Locale.getDefault());
        }
        if (str.equals("&cid")) {
            return zzcg().zzdr();
        }
        if (str.equals("&sr")) {
            return zzcj().zzel();
        }
        if (str.equals("&aid")) {
            return zzci().zzdf().zzal();
        }
        if (str.equals("&an")) {
            return zzci().zzdf().zzaj();
        }
        if (str.equals("&av")) {
            return zzci().zzdf().zzak();
        }
        if (str.equals("&aiid")) {
            return zzci().zzdf().zzam();
        }
        return null;
    }

    public void set(String str, String str2) {
        Preconditions.checkNotNull(str, "Key should be non-null");
        if (!TextUtils.isEmpty(str)) {
            this.zzsy.put(str, str2);
        }
    }

    public void setSampleRate(double d) {
        set("&sf", Double.toString(d));
    }

    public void setUseSecure(boolean z) {
        set("useSecure", zzdg.zzc(z));
    }

    public void setScreenName(String str) {
        set("&cd", str);
    }

    public void setLocation(String str) {
        set("&dl", str);
    }

    public void setReferrer(String str) {
        set("&dr", str);
    }

    public void setPage(String str) {
        set("&dp", str);
    }

    public void setHostname(String str) {
        set("&dh", str);
    }

    public void setTitle(String str) {
        set("&dt", str);
    }

    public void setLanguage(String str) {
        set("&ul", str);
    }

    public void setEncoding(String str) {
        set("&de", str);
    }

    public void setScreenColors(String str) {
        set("&sd", str);
    }

    public void setScreenResolution(int i, int i2) {
        if (i >= 0 || i2 >= 0) {
            set("&sr", i + "x" + i2);
        } else {
            zzt("Invalid width or height. The values should be non-negative.");
        }
    }

    public void setViewportSize(String str) {
        set("&vp", str);
    }

    public void setClientId(String str) {
        set("&cid", str);
    }

    public void setAppName(String str) {
        set("&an", str);
    }

    public void setAppId(String str) {
        set("&aid", str);
    }

    public void setAppInstallerId(String str) {
        set("&aiid", str);
    }

    public void setAppVersion(String str) {
        set("&av", str);
    }

    public void setAnonymizeIp(boolean z) {
        set("&aip", zzdg.zzc(z));
    }

    public void setCampaignParamsOnNextHit(Uri uri) {
        if (uri != null && !uri.isOpaque()) {
            CharSequence queryParameter = uri.getQueryParameter("referrer");
            if (!TextUtils.isEmpty(queryParameter)) {
                String str = "http://hostname/?";
                String valueOf = String.valueOf(queryParameter);
                Uri parse = Uri.parse(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                str = parse.getQueryParameter("utm_id");
                if (str != null) {
                    this.zzsz.put("&ci", str);
                }
                str = parse.getQueryParameter("anid");
                if (str != null) {
                    this.zzsz.put("&anid", str);
                }
                str = parse.getQueryParameter("utm_campaign");
                if (str != null) {
                    this.zzsz.put("&cn", str);
                }
                str = parse.getQueryParameter("utm_content");
                if (str != null) {
                    this.zzsz.put("&cc", str);
                }
                str = parse.getQueryParameter("utm_medium");
                if (str != null) {
                    this.zzsz.put("&cm", str);
                }
                str = parse.getQueryParameter("utm_source");
                if (str != null) {
                    this.zzsz.put("&cs", str);
                }
                str = parse.getQueryParameter("utm_term");
                if (str != null) {
                    this.zzsz.put("&ck", str);
                }
                str = parse.getQueryParameter("dclid");
                if (str != null) {
                    this.zzsz.put("&dclid", str);
                }
                str = parse.getQueryParameter("gclid");
                if (str != null) {
                    this.zzsz.put("&gclid", str);
                }
                valueOf = parse.getQueryParameter(Param.ACLID);
                if (valueOf != null) {
                    this.zzsz.put("&aclid", valueOf);
                }
            }
        }
    }

    public void enableAdvertisingIdCollection(boolean z) {
        this.zzsx = z;
    }
}
