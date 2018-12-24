package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.internal.zzai.zza;
import java.lang.reflect.InvocationTargetException;

public final class zzq extends zzcr {
    private Boolean zzagw;
    private zzs zzagx = zzr.zzagy;
    private Boolean zzyk;

    zzq(zzbw zzbw) {
        super(zzbw);
        zzai.zza(zzbw);
    }

    final void zza(zzs zzs) {
        this.zzagx = zzs;
    }

    static String zzhy() {
        return (String) zzai.zzaiu.get();
    }

    public final int zzaq(String str) {
        return zzb(str, zzai.zzaji);
    }

    public final long zzhh() {
        zzgw();
        return 14710;
    }

    public final boolean zzdw() {
        if (this.zzyk == null) {
            synchronized (this) {
                if (this.zzyk == null) {
                    ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(myProcessName);
                        this.zzyk = Boolean.valueOf(z);
                    }
                    if (this.zzyk == null) {
                        this.zzyk = Boolean.TRUE;
                        zzgt().zzjg().zzby("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzyk.booleanValue();
    }

    public final long zza(String str, zza<Long> zza) {
        if (str == null) {
            return ((Long) zza.get()).longValue();
        }
        Object zzf = this.zzagx.zzf(str, zza.getKey());
        if (TextUtils.isEmpty(zzf)) {
            return ((Long) zza.get()).longValue();
        }
        try {
            return ((Long) zza.get(Long.valueOf(Long.parseLong(zzf)))).longValue();
        } catch (NumberFormatException e) {
            return ((Long) zza.get()).longValue();
        }
    }

    public final int zzb(String str, zza<Integer> zza) {
        if (str == null) {
            return ((Integer) zza.get()).intValue();
        }
        Object zzf = this.zzagx.zzf(str, zza.getKey());
        if (TextUtils.isEmpty(zzf)) {
            return ((Integer) zza.get()).intValue();
        }
        try {
            return ((Integer) zza.get(Integer.valueOf(Integer.parseInt(zzf)))).intValue();
        } catch (NumberFormatException e) {
            return ((Integer) zza.get()).intValue();
        }
    }

    public final double zzc(String str, zza<Double> zza) {
        if (str == null) {
            return ((Double) zza.get()).doubleValue();
        }
        Object zzf = this.zzagx.zzf(str, zza.getKey());
        if (TextUtils.isEmpty(zzf)) {
            return ((Double) zza.get()).doubleValue();
        }
        try {
            return ((Double) zza.get(Double.valueOf(Double.parseDouble(zzf)))).doubleValue();
        } catch (NumberFormatException e) {
            return ((Double) zza.get()).doubleValue();
        }
    }

    public final boolean zzd(String str, zza<Boolean> zza) {
        if (str == null) {
            return ((Boolean) zza.get()).booleanValue();
        }
        Object zzf = this.zzagx.zzf(str, zza.getKey());
        if (TextUtils.isEmpty(zzf)) {
            return ((Boolean) zza.get()).booleanValue();
        }
        return ((Boolean) zza.get(Boolean.valueOf(Boolean.parseBoolean(zzf)))).booleanValue();
    }

    public final boolean zze(String str, zza<Boolean> zza) {
        return zzd(str, zza);
    }

    public final boolean zza(zza<Boolean> zza) {
        return zzd(null, zza);
    }

    @VisibleForTesting
    final Boolean zzar(String str) {
        Boolean bool = null;
        Preconditions.checkNotEmpty(str);
        try {
            if (getContext().getPackageManager() == null) {
                zzgt().zzjg().zzby("Failed to load metadata: PackageManager is null");
            } else {
                ApplicationInfo applicationInfo = Wrappers.packageManager(getContext()).getApplicationInfo(getContext().getPackageName(), 128);
                if (applicationInfo == null) {
                    zzgt().zzjg().zzby("Failed to load metadata: ApplicationInfo is null");
                } else if (applicationInfo.metaData == null) {
                    zzgt().zzjg().zzby("Failed to load metadata: Metadata bundle is null");
                } else if (applicationInfo.metaData.containsKey(str)) {
                    bool = Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
                }
            }
        } catch (NameNotFoundException e) {
            zzgt().zzjg().zzg("Failed to load metadata: Package name not found", e);
        }
        return bool;
    }

    public final boolean zzhz() {
        zzgw();
        Boolean zzar = zzar("firebase_analytics_collection_deactivated");
        return zzar != null && zzar.booleanValue();
    }

    public final Boolean zzia() {
        zzgw();
        return zzar("firebase_analytics_collection_enabled");
    }

    public static long zzib() {
        return ((Long) zzai.zzajx.get()).longValue();
    }

    public static long zzic() {
        return ((Long) zzai.zzaix.get()).longValue();
    }

    public final String zzid() {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{"debug.firebase.analytics.app", ""});
        } catch (ClassNotFoundException e) {
            zzgt().zzjg().zzg("Could not find SystemProperties class", e);
        } catch (NoSuchMethodException e2) {
            zzgt().zzjg().zzg("Could not find SystemProperties.get() method", e2);
        } catch (IllegalAccessException e3) {
            zzgt().zzjg().zzg("Could not access SystemProperties.get()", e3);
        } catch (InvocationTargetException e4) {
            zzgt().zzjg().zzg("SystemProperties.get() threw an exception", e4);
        }
        return "";
    }

    public static boolean zzie() {
        return ((Boolean) zzai.zzait.get()).booleanValue();
    }

    public final boolean zzas(String str) {
        return "1".equals(this.zzagx.zzf(str, "gaia_collection_enabled"));
    }

    public final boolean zzat(String str) {
        return "1".equals(this.zzagx.zzf(str, "measurement.event_sampling_enabled"));
    }

    final boolean zzau(String str) {
        return zzd(str, zzai.zzakh);
    }

    final boolean zzav(String str) {
        return zzd(str, zzai.zzakj);
    }

    final boolean zzaw(String str) {
        return zzd(str, zzai.zzakk);
    }

    final boolean zzax(String str) {
        return zzd(str, zzai.zzakb);
    }

    final String zzay(String str) {
        zza zza = zzai.zzakc;
        if (str == null) {
            return (String) zza.get();
        }
        return (String) zza.get(this.zzagx.zzf(str, zza.getKey()));
    }

    final boolean zzaz(String str) {
        return zzd(str, zzai.zzakl);
    }

    final boolean zzba(String str) {
        return zzd(str, zzai.zzakm);
    }

    final boolean zzbb(String str) {
        return zzd(str, zzai.zzako);
    }

    final boolean zzbc(String str) {
        return zzd(str, zzai.zzakp);
    }

    final boolean zzbd(String str) {
        return zzd(str, zzai.zzakq);
    }

    final boolean zzbe(String str) {
        return zzd(str, zzai.zzaks);
    }

    final boolean zzif() {
        if (this.zzagw == null) {
            this.zzagw = zzar("app_measurement_lite");
            if (this.zzagw == null) {
                this.zzagw = Boolean.valueOf(false);
            }
        }
        if (this.zzagw.booleanValue() || !this.zzada.zzkr()) {
            return true;
        }
        return false;
    }

    final boolean zzbf(String str) {
        return zzd(str, zzai.zzakr);
    }

    static boolean zzig() {
        return ((Boolean) zzai.zzakt.get()).booleanValue();
    }

    final boolean zzbg(String str) {
        return zzd(str, zzai.zzaku);
    }

    final boolean zzbh(String str) {
        return zzd(str, zzai.zzakv);
    }

    final boolean zzbi(String str) {
        return zzd(str, zzai.zzakw);
    }

    final boolean zzbj(String str) {
        return zzd(str, zzai.zzakx);
    }

    final boolean zzbk(String str) {
        return zzd(str, zzai.zzakz);
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
