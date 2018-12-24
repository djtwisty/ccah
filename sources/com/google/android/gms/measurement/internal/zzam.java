package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.InstantApps;
import org.apache.cordova.networkinformation.NetworkManager;

public final class zzam extends zzf {
    private String zzafi;
    private String zzafp;
    private long zzafs;
    private String zzafv;
    private int zzagp;
    private int zzalk;
    private long zzall;
    private String zztr;
    private String zzts;
    private String zztt;

    zzam(zzbw zzbw) {
        super(zzbw);
    }

    protected final boolean zzgy() {
        return true;
    }

    protected final void zzgz() {
        int i;
        CharSequence googleAppId;
        CharSequence charSequence;
        String str;
        int i2 = 1;
        String str2 = NetworkManager.TYPE_UNKNOWN;
        String str3 = "Unknown";
        int i3 = Integer.MIN_VALUE;
        String str4 = "Unknown";
        String packageName = getContext().getPackageName();
        PackageManager packageManager = getContext().getPackageManager();
        if (packageManager == null) {
            zzgt().zzjg().zzg("PackageManager is null, app identity information might be inaccurate. appId", zzas.zzbw(packageName));
        } else {
            try {
                str2 = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException e) {
                zzgt().zzjg().zzg("Error retrieving app installer package name. appId", zzas.zzbw(packageName));
            }
            if (str2 == null) {
                str2 = "manual_install";
            } else if ("com.android.vending".equals(str2)) {
                str2 = "";
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(getContext().getPackageName(), 0);
                if (packageInfo != null) {
                    CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                    if (!TextUtils.isEmpty(applicationLabel)) {
                        str4 = applicationLabel.toString();
                    }
                    str3 = packageInfo.versionName;
                    i3 = packageInfo.versionCode;
                }
            } catch (NameNotFoundException e2) {
                zzgt().zzjg().zze("Error retrieving package info. appId, appName", zzas.zzbw(packageName), str4);
            }
        }
        this.zztt = packageName;
        this.zzafp = str2;
        this.zzts = str3;
        this.zzalk = i3;
        this.zztr = str4;
        this.zzall = 0;
        zzgw();
        Status initialize = GoogleServices.initialize(getContext());
        if (initialize == null || !initialize.isSuccess()) {
            i = 0;
        } else {
            i = 1;
        }
        if (TextUtils.isEmpty(this.zzada.zzko()) || !"am".equals(this.zzada.zzkp())) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        i |= i3;
        if (i == 0) {
            if (initialize == null) {
                zzgt().zzjg().zzby("GoogleService failed to initialize (no status)");
            } else {
                zzgt().zzjg().zze("GoogleService failed to initialize, status", Integer.valueOf(initialize.getStatusCode()), initialize.getStatusMessage());
            }
        }
        if (i != 0) {
            Boolean zzia = zzgv().zzia();
            if (zzgv().zzhz()) {
                if (this.zzada.zzkn()) {
                    zzgt().zzjm().zzby("Collection disabled with firebase_analytics_collection_deactivated=1");
                    i = 0;
                    this.zzafi = "";
                    this.zzafv = "";
                    this.zzafs = 0;
                    zzgw();
                    if (!TextUtils.isEmpty(this.zzada.zzko()) && "am".equals(this.zzada.zzkp())) {
                        this.zzafv = this.zzada.zzko();
                    }
                    googleAppId = GoogleServices.getGoogleAppId();
                    if (TextUtils.isEmpty(googleAppId)) {
                        charSequence = googleAppId;
                    } else {
                        str = "";
                    }
                    this.zzafi = str;
                    if (!TextUtils.isEmpty(googleAppId)) {
                        this.zzafv = new StringResourceValueReader(getContext()).getString("admob_app_id");
                    }
                    if (i != 0) {
                        zzgt().zzjo().zze("App package, google app id", this.zztt, this.zzafi);
                    }
                    if (VERSION.SDK_INT < 16) {
                        if (!InstantApps.isInstantApp(getContext())) {
                            i2 = 0;
                        }
                        this.zzagp = i2;
                    }
                    this.zzagp = 0;
                    return;
                }
            } else if (zzia == null || zzia.booleanValue()) {
                if (zzia == null && GoogleServices.isMeasurementExplicitlyDisabled()) {
                    zzgt().zzjm().zzby("Collection disabled with google_app_measurement_enable=0");
                    i = 0;
                } else {
                    zzgt().zzjo().zzby("Collection enabled");
                    i = 1;
                }
                this.zzafi = "";
                this.zzafv = "";
                this.zzafs = 0;
                zzgw();
                this.zzafv = this.zzada.zzko();
                googleAppId = GoogleServices.getGoogleAppId();
                if (TextUtils.isEmpty(googleAppId)) {
                    charSequence = googleAppId;
                } else {
                    str = "";
                }
                this.zzafi = str;
                if (TextUtils.isEmpty(googleAppId)) {
                    this.zzafv = new StringResourceValueReader(getContext()).getString("admob_app_id");
                }
                if (i != 0) {
                    zzgt().zzjo().zze("App package, google app id", this.zztt, this.zzafi);
                }
                if (VERSION.SDK_INT < 16) {
                    this.zzagp = 0;
                    return;
                }
                if (InstantApps.isInstantApp(getContext())) {
                    i2 = 0;
                }
                this.zzagp = i2;
            } else if (this.zzada.zzkn()) {
                zzgt().zzjm().zzby("Collection disabled with firebase_analytics_collection_enabled=0");
                i = 0;
                this.zzafi = "";
                this.zzafv = "";
                this.zzafs = 0;
                zzgw();
                this.zzafv = this.zzada.zzko();
                googleAppId = GoogleServices.getGoogleAppId();
                if (TextUtils.isEmpty(googleAppId)) {
                    str = "";
                } else {
                    charSequence = googleAppId;
                }
                this.zzafi = str;
                if (TextUtils.isEmpty(googleAppId)) {
                    this.zzafv = new StringResourceValueReader(getContext()).getString("admob_app_id");
                }
                if (i != 0) {
                    zzgt().zzjo().zze("App package, google app id", this.zztt, this.zzafi);
                }
                if (VERSION.SDK_INT < 16) {
                    if (InstantApps.isInstantApp(getContext())) {
                        i2 = 0;
                    }
                    this.zzagp = i2;
                }
                this.zzagp = 0;
                return;
            }
        }
        i = 0;
        this.zzafi = "";
        this.zzafv = "";
        this.zzafs = 0;
        zzgw();
        this.zzafv = this.zzada.zzko();
        try {
            googleAppId = GoogleServices.getGoogleAppId();
            if (TextUtils.isEmpty(googleAppId)) {
                charSequence = googleAppId;
            } else {
                str = "";
            }
            this.zzafi = str;
            if (TextUtils.isEmpty(googleAppId)) {
                this.zzafv = new StringResourceValueReader(getContext()).getString("admob_app_id");
            }
            if (i != 0) {
                zzgt().zzjo().zze("App package, google app id", this.zztt, this.zzafi);
            }
        } catch (IllegalStateException e3) {
            zzgt().zzjg().zze("getGoogleAppId or isMeasurementEnabled failed with exception. appId", zzas.zzbw(packageName), e3);
        }
        if (VERSION.SDK_INT < 16) {
            this.zzagp = 0;
            return;
        }
        if (InstantApps.isInstantApp(getContext())) {
            i2 = 0;
        }
        this.zzagp = i2;
    }

    final zzk zzbs(String str) {
        String zzjc;
        zzaf();
        zzgg();
        String zzal = zzal();
        String gmpAppId = getGmpAppId();
        zzcl();
        String str2 = this.zzts;
        long zzjd = (long) zzjd();
        zzcl();
        String str3 = this.zzafp;
        long zzhh = zzgv().zzhh();
        zzcl();
        zzaf();
        if (this.zzall == 0) {
            this.zzall = this.zzada.zzgr().zzd(getContext(), getContext().getPackageName());
        }
        long j = this.zzall;
        boolean isEnabled = this.zzada.isEnabled();
        boolean z = !zzgu().zzanq;
        zzaf();
        zzgg();
        if (!zzgv().zzaz(this.zztt) || this.zzada.isEnabled()) {
            zzjc = zzjc();
        } else {
            zzjc = null;
        }
        zzcl();
        long j2 = this.zzafs;
        long zzkt = this.zzada.zzkt();
        int zzje = zzje();
        zzcr zzgv = zzgv();
        zzgv.zzgg();
        Boolean zzar = zzgv.zzar("google_analytics_adid_collection_enabled");
        boolean z2 = zzar == null || zzar.booleanValue();
        boolean booleanValue = Boolean.valueOf(z2).booleanValue();
        zzgv = zzgv();
        zzgv.zzgg();
        zzar = zzgv.zzar("google_analytics_ssaid_collection_enabled");
        z2 = zzar == null || zzar.booleanValue();
        return new zzk(zzal, gmpAppId, str2, zzjd, str3, zzhh, j, str, isEnabled, z, zzjc, j2, zzkt, zzje, booleanValue, Boolean.valueOf(z2).booleanValue(), zzgu().zzkb(), zzhb());
    }

    @VisibleForTesting
    private final String zzjc() {
        try {
            Class loadClass = getContext().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (loadClass == null) {
                return null;
            }
            try {
                Object invoke = loadClass.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{getContext()});
                if (invoke == null) {
                    return null;
                }
                try {
                    return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                } catch (Exception e) {
                    zzgt().zzjl().zzby("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception e2) {
                zzgt().zzjk().zzby("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException e3) {
            return null;
        }
    }

    final String zzal() {
        zzcl();
        return this.zztt;
    }

    final String getGmpAppId() {
        zzcl();
        return this.zzafi;
    }

    final String zzhb() {
        zzcl();
        return this.zzafv;
    }

    final int zzjd() {
        zzcl();
        return this.zzalk;
    }

    final int zzje() {
        zzcl();
        return this.zzagp;
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

    public final /* bridge */ /* synthetic */ zza zzgi() {
        return super.zzgi();
    }

    public final /* bridge */ /* synthetic */ zzda zzgj() {
        return super.zzgj();
    }

    public final /* bridge */ /* synthetic */ zzam zzgk() {
        return super.zzgk();
    }

    public final /* bridge */ /* synthetic */ zzeb zzgl() {
        return super.zzgl();
    }

    public final /* bridge */ /* synthetic */ zzdy zzgm() {
        return super.zzgm();
    }

    public final /* bridge */ /* synthetic */ zzao zzgn() {
        return super.zzgn();
    }

    public final /* bridge */ /* synthetic */ zzfd zzgo() {
        return super.zzgo();
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
