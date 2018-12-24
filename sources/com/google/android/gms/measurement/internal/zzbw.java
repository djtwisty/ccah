package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzsi;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class zzbw implements zzct {
    private static volatile zzbw zzapg;
    private final boolean zzadg;
    private final String zzadi;
    private final long zzago;
    private final zzn zzaih;
    private final String zzaph;
    private final String zzapi;
    private final zzq zzapj;
    private final zzbd zzapk;
    private final zzas zzapl;
    private final zzbr zzapm;
    private final zzfd zzapn;
    private final AppMeasurement zzapo;
    private final zzfy zzapp;
    private final zzaq zzapq;
    private final zzdy zzapr;
    private final zzda zzaps;
    private final zza zzapt;
    private zzao zzapu;
    private zzeb zzapv;
    private zzaa zzapw;
    private zzam zzapx;
    private zzbj zzapy;
    private Boolean zzapz;
    private long zzaqa;
    private volatile Boolean zzaqb;
    @VisibleForTesting
    private Boolean zzaqc;
    @VisibleForTesting
    private Boolean zzaqd;
    private int zzaqe;
    private AtomicInteger zzaqf = new AtomicInteger(0);
    private final Context zzri;
    private final Clock zzrz;
    private boolean zzvz = false;

    private zzbw(zzcz zzcz) {
        Preconditions.checkNotNull(zzcz);
        this.zzaih = new zzn(zzcz.zzri);
        zzai.zza(this.zzaih);
        this.zzri = zzcz.zzri;
        this.zzadi = zzcz.zzadi;
        this.zzaph = zzcz.zzaph;
        this.zzapi = zzcz.zzapi;
        this.zzadg = zzcz.zzadg;
        this.zzaqb = zzcz.zzaqb;
        zzan zzan = zzcz.zzaqw;
        if (!(zzan == null || zzan.zzadj == null)) {
            Object obj = zzan.zzadj.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zzaqc = (Boolean) obj;
            }
            obj = zzan.zzadj.get("measurementDeactivated");
            if (obj instanceof Boolean) {
                this.zzaqd = (Boolean) obj;
            }
        }
        zzsi.zzae(this.zzri);
        this.zzrz = DefaultClock.getInstance();
        this.zzago = this.zzrz.currentTimeMillis();
        this.zzapj = new zzq(this);
        zzcs zzbd = new zzbd(this);
        zzbd.zzq();
        this.zzapk = zzbd;
        zzbd = new zzas(this);
        zzbd.zzq();
        this.zzapl = zzbd;
        zzbd = new zzfy(this);
        zzbd.zzq();
        this.zzapp = zzbd;
        zzbd = new zzaq(this);
        zzbd.zzq();
        this.zzapq = zzbd;
        this.zzapt = new zza(this);
        zzf zzdy = new zzdy(this);
        zzdy.zzq();
        this.zzapr = zzdy;
        zzdy = new zzda(this);
        zzdy.zzq();
        this.zzaps = zzdy;
        this.zzapo = new AppMeasurement(this);
        zzdy = new zzfd(this);
        zzdy.zzq();
        this.zzapn = zzdy;
        zzbd = new zzbr(this);
        zzbd.zzq();
        this.zzapm = zzbd;
        zzn zzn = this.zzaih;
        if (this.zzri.getApplicationContext() instanceof Application) {
            zzcr zzgj = zzgj();
            if (zzgj.getContext().getApplicationContext() instanceof Application) {
                Application application = (Application) zzgj.getContext().getApplicationContext();
                if (zzgj.zzaqx == null) {
                    zzgj.zzaqx = new zzdu(zzgj);
                }
                application.unregisterActivityLifecycleCallbacks(zzgj.zzaqx);
                application.registerActivityLifecycleCallbacks(zzgj.zzaqx);
                zzgj.zzgt().zzjo().zzby("Registered activity lifecycle callback");
            }
        } else {
            zzgt().zzjj().zzby("Application context is not an Application");
        }
        this.zzapm.zzc(new zzbx(this, zzcz));
    }

    private final void zza(zzcz zzcz) {
        zzgs().zzaf();
        zzq.zzhy();
        zzcs zzaa = new zzaa(this);
        zzaa.zzq();
        this.zzapw = zzaa;
        zzf zzam = new zzam(this);
        zzam.zzq();
        this.zzapx = zzam;
        zzf zzao = new zzao(this);
        zzao.zzq();
        this.zzapu = zzao;
        zzao = new zzeb(this);
        zzao.zzq();
        this.zzapv = zzao;
        this.zzapp.zzgx();
        this.zzapk.zzgx();
        this.zzapy = new zzbj(this);
        this.zzapx.zzgx();
        zzgt().zzjm().zzg("App measurement is starting up, version", Long.valueOf(this.zzapj.zzhh()));
        zzn zzn = this.zzaih;
        zzgt().zzjm().zzby("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        zzn = this.zzaih;
        String zzal = zzam.zzal();
        if (TextUtils.isEmpty(this.zzadi)) {
            zzau zzjm;
            if (zzgr().zzcz(zzal)) {
                zzjm = zzgt().zzjm();
                zzal = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                zzjm = zzgt().zzjm();
                String str = "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ";
                zzal = String.valueOf(zzal);
                zzal = zzal.length() != 0 ? str.concat(zzal) : new String(str);
            }
            zzjm.zzby(zzal);
        }
        zzgt().zzjn().zzby("Debug-level message logging enabled");
        if (this.zzaqe != this.zzaqf.get()) {
            zzgt().zzjg().zze("Not all components initialized", Integer.valueOf(this.zzaqe), Integer.valueOf(this.zzaqf.get()));
        }
        this.zzvz = true;
    }

    protected final void start() {
        boolean z = false;
        zzgs().zzaf();
        if (zzgu().zzana.get() == 0) {
            zzgu().zzana.set(this.zzrz.currentTimeMillis());
        }
        if (Long.valueOf(zzgu().zzanf.get()).longValue() == 0) {
            zzgt().zzjo().zzg("Persisting first open", Long.valueOf(this.zzago));
            zzgu().zzanf.set(this.zzago);
        }
        zzn zzn;
        if (zzkv()) {
            zzn = this.zzaih;
            if (!(TextUtils.isEmpty(zzgk().getGmpAppId()) && TextUtils.isEmpty(zzgk().zzhb()))) {
                zzgr();
                if (zzfy.zza(zzgk().getGmpAppId(), zzgu().zzjv(), zzgk().zzhb(), zzgu().zzjw())) {
                    zzgt().zzjm().zzby("Rechecking which service to use due to a GMP App Id change");
                    zzgu().zzjy();
                    zzgn().resetAnalyticsData();
                    this.zzapv.disconnect();
                    this.zzapv.zzdj();
                    zzgu().zzanf.set(this.zzago);
                    zzgu().zzanh.zzcd(null);
                }
                zzgu().zzcb(zzgk().getGmpAppId());
                zzgu().zzcc(zzgk().zzhb());
                if (this.zzapj.zzbi(zzgk().zzal())) {
                    this.zzapn.zzaj(this.zzago);
                }
            }
            zzgj().zzcp(zzgu().zzanh.zzkd());
            zzn = this.zzaih;
            if (!TextUtils.isEmpty(zzgk().getGmpAppId()) || !TextUtils.isEmpty(zzgk().zzhb())) {
                boolean isEnabled = isEnabled();
                if (!(zzgu().zzkc() || this.zzapj.zzhz())) {
                    zzbd zzgu = zzgu();
                    if (!isEnabled) {
                        z = true;
                    }
                    zzgu.zzi(z);
                }
                if (!this.zzapj.zzba(zzgk().zzal()) || isEnabled) {
                    zzgj().zzld();
                }
                zzgl().zza(new AtomicReference());
            }
        } else if (isEnabled()) {
            if (!zzgr().zzx("android.permission.INTERNET")) {
                zzgt().zzjg().zzby("App is missing INTERNET permission");
            }
            if (!zzgr().zzx("android.permission.ACCESS_NETWORK_STATE")) {
                zzgt().zzjg().zzby("App is missing ACCESS_NETWORK_STATE permission");
            }
            zzn = this.zzaih;
            if (!(Wrappers.packageManager(this.zzri).isCallerInstantApp() || this.zzapj.zzif())) {
                if (!zzbm.zza(this.zzri)) {
                    zzgt().zzjg().zzby("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzfy.zza(this.zzri, false)) {
                    zzgt().zzjg().zzby("AppMeasurementService not registered/enabled");
                }
            }
            zzgt().zzjg().zzby("Uploading is not possible. App measurement disabled");
        }
    }

    public final zzn zzgw() {
        return this.zzaih;
    }

    public final zzq zzgv() {
        return this.zzapj;
    }

    public final zzbd zzgu() {
        zza(this.zzapk);
        return this.zzapk;
    }

    public final zzas zzgt() {
        zza(this.zzapl);
        return this.zzapl;
    }

    public final zzas zzkj() {
        return (this.zzapl == null || !this.zzapl.isInitialized()) ? null : this.zzapl;
    }

    public final zzbr zzgs() {
        zza(this.zzapm);
        return this.zzapm;
    }

    public final zzfd zzgo() {
        zza(this.zzapn);
        return this.zzapn;
    }

    public final zzbj zzkk() {
        return this.zzapy;
    }

    final zzbr zzkl() {
        return this.zzapm;
    }

    public final zzda zzgj() {
        zza(this.zzaps);
        return this.zzaps;
    }

    public final AppMeasurement zzkm() {
        return this.zzapo;
    }

    public final zzfy zzgr() {
        zza(this.zzapp);
        return this.zzapp;
    }

    public final zzaq zzgq() {
        zza(this.zzapq);
        return this.zzapq;
    }

    public final zzao zzgn() {
        zza(this.zzapu);
        return this.zzapu;
    }

    public final Context getContext() {
        return this.zzri;
    }

    public final boolean zzkn() {
        return TextUtils.isEmpty(this.zzadi);
    }

    public final String zzko() {
        return this.zzadi;
    }

    public final String zzkp() {
        return this.zzaph;
    }

    public final String zzkq() {
        return this.zzapi;
    }

    public final boolean zzkr() {
        return this.zzadg;
    }

    public final Clock zzbx() {
        return this.zzrz;
    }

    public final zzdy zzgm() {
        zza(this.zzapr);
        return this.zzapr;
    }

    public final zzeb zzgl() {
        zza(this.zzapv);
        return this.zzapv;
    }

    public final zzaa zzgp() {
        zza(this.zzapw);
        return this.zzapw;
    }

    public final zzam zzgk() {
        zza(this.zzapx);
        return this.zzapx;
    }

    public final zza zzgi() {
        if (this.zzapt != null) {
            return this.zzapt;
        }
        throw new IllegalStateException("Component not created");
    }

    public static zzbw zza(Context context, zzan zzan) {
        if (zzan != null && (zzan.origin == null || zzan.zzadi == null)) {
            zzan = new zzan(zzan.zzade, zzan.zzadf, zzan.zzadg, zzan.zzadh, null, null, zzan.zzadj);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzapg == null) {
            synchronized (zzbw.class) {
                if (zzapg == null) {
                    zzapg = new zzbw(new zzcz(context, zzan));
                }
            }
        } else if (!(zzan == null || zzan.zzadj == null || !zzan.zzadj.containsKey("dataCollectionDefaultEnabled"))) {
            zzapg.zzd(zzan.zzadj.getBoolean("dataCollectionDefaultEnabled"));
        }
        return zzapg;
    }

    private final void zzcl() {
        if (!this.zzvz) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    private static void zza(zzcs zzcs) {
        if (zzcs == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzcs.isInitialized()) {
            String valueOf = String.valueOf(zzcs.getClass());
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 27).append("Component not initialized: ").append(valueOf).toString());
        }
    }

    private static void zza(zzf zzf) {
        if (zzf == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzf.isInitialized()) {
            String valueOf = String.valueOf(zzf.getClass());
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 27).append("Component not initialized: ").append(valueOf).toString());
        }
    }

    private static void zza(zzcr zzcr) {
        if (zzcr == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    final void zzd(boolean z) {
        this.zzaqb = Boolean.valueOf(z);
    }

    public final boolean zzks() {
        return this.zzaqb != null && this.zzaqb.booleanValue();
    }

    public final boolean isEnabled() {
        boolean z = true;
        zzgs().zzaf();
        zzcl();
        Boolean zzjz;
        if (this.zzapj.zza(zzai.zzalc)) {
            if (this.zzapj.zzhz()) {
                return false;
            }
            if (this.zzaqd != null && this.zzaqd.booleanValue()) {
                return false;
            }
            zzjz = zzgu().zzjz();
            if (zzjz != null) {
                return zzjz.booleanValue();
            }
            zzjz = this.zzapj.zzia();
            if (zzjz != null) {
                return zzjz.booleanValue();
            }
            if (this.zzaqc != null) {
                return this.zzaqc.booleanValue();
            }
            if (GoogleServices.isMeasurementExplicitlyDisabled()) {
                return false;
            }
            return (!this.zzapj.zza(zzai.zzaky) || this.zzaqb == null) ? true : this.zzaqb.booleanValue();
        } else if (this.zzapj.zzhz()) {
            return false;
        } else {
            boolean booleanValue;
            zzjz = this.zzapj.zzia();
            if (zzjz != null) {
                booleanValue = zzjz.booleanValue();
            } else {
                if (GoogleServices.isMeasurementExplicitlyDisabled()) {
                    z = false;
                }
                if (z && this.zzaqb != null && ((Boolean) zzai.zzaky.get()).booleanValue()) {
                    booleanValue = this.zzaqb.booleanValue();
                } else {
                    booleanValue = z;
                }
            }
            return zzgu().zzh(booleanValue);
        }
    }

    final long zzkt() {
        Long valueOf = Long.valueOf(zzgu().zzanf.get());
        if (valueOf.longValue() == 0) {
            return this.zzago;
        }
        return Math.min(this.zzago, valueOf.longValue());
    }

    final void zzgg() {
        zzn zzn = this.zzaih;
    }

    final void zzgf() {
        zzn zzn = this.zzaih;
        throw new IllegalStateException("Unexpected call on client side");
    }

    final void zzb(zzcs zzcs) {
        this.zzaqe++;
    }

    final void zzb(zzf zzf) {
        this.zzaqe++;
    }

    final void zzku() {
        this.zzaqf.incrementAndGet();
    }

    protected final boolean zzkv() {
        boolean z = false;
        zzcl();
        zzgs().zzaf();
        if (this.zzapz == null || this.zzaqa == 0 || !(this.zzapz == null || this.zzapz.booleanValue() || Math.abs(this.zzrz.elapsedRealtime() - this.zzaqa) <= 1000)) {
            this.zzaqa = this.zzrz.elapsedRealtime();
            zzn zzn = this.zzaih;
            boolean z2 = zzgr().zzx("android.permission.INTERNET") && zzgr().zzx("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzri).isCallerInstantApp() || this.zzapj.zzif() || (zzbm.zza(this.zzri) && zzfy.zza(this.zzri, false)));
            this.zzapz = Boolean.valueOf(z2);
            if (this.zzapz.booleanValue()) {
                if (zzgr().zzu(zzgk().getGmpAppId(), zzgk().zzhb()) || !TextUtils.isEmpty(zzgk().zzhb())) {
                    z = true;
                }
                this.zzapz = Boolean.valueOf(z);
            }
        }
        return this.zzapz.booleanValue();
    }
}
