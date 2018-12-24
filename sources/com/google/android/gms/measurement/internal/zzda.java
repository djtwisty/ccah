package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p017e.C0238a;
import android.text.TextUtils;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;
import com.google.android.gms.measurement.AppMeasurement.Event;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public final class zzda extends zzf {
    @VisibleForTesting
    protected zzdu zzaqx;
    private zzcx zzaqy;
    private final Set<zzcy> zzaqz = new CopyOnWriteArraySet();
    private boolean zzara;
    private final AtomicReference<String> zzarb = new AtomicReference();
    @VisibleForTesting
    protected boolean zzarc = true;

    protected zzda(zzbw zzbw) {
        super(zzbw);
    }

    protected final boolean zzgy() {
        return false;
    }

    public final void zzkw() {
        if (getContext().getApplicationContext() instanceof Application) {
            ((Application) getContext().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zzaqx);
        }
    }

    public final Boolean zzkx() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzgs().zza(atomicReference, 15000, "boolean test flag value", new zzdb(this, atomicReference));
    }

    public final String zzky() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzgs().zza(atomicReference, 15000, "String test flag value", new zzdl(this, atomicReference));
    }

    public final Long zzkz() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzgs().zza(atomicReference, 15000, "long test flag value", new zzdn(this, atomicReference));
    }

    public final Integer zzla() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzgs().zza(atomicReference, 15000, "int test flag value", new zzdo(this, atomicReference));
    }

    public final Double zzlb() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzgs().zza(atomicReference, 15000, "double test flag value", new zzdp(this, atomicReference));
    }

    public final void setMeasurementEnabled(boolean z) {
        zzcl();
        zzgg();
        zzgs().zzc(new zzdq(this, z));
    }

    public final void zzd(boolean z) {
        zzcl();
        zzgg();
        zzgs().zzc(new zzdr(this, z));
    }

    private final void zzj(boolean z) {
        zzaf();
        zzgg();
        zzcl();
        zzgt().zzjn().zzg("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzgu().setMeasurementEnabled(z);
        zzlc();
    }

    private final void zzlc() {
        if (zzgv().zzba(zzgk().zzal()) && this.zzada.isEnabled() && this.zzarc) {
            zzgt().zzjn().zzby("Recording app launch after enabling measurement for the first time (FE)");
            zzld();
            return;
        }
        zzgt().zzjn().zzby("Updating Scion state (FE)");
        zzgl().zzlg();
    }

    public final void setMinimumSessionDuration(long j) {
        zzgg();
        zzgs().zzc(new zzds(this, j));
    }

    public final void setSessionTimeoutDuration(long j) {
        zzgg();
        zzgs().zzc(new zzdt(this, j));
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        logEvent(str, str2, bundle, false, true, zzbx().currentTimeMillis());
    }

    public final void logEvent(String str, String str2, Bundle bundle) {
        logEvent(str, str2, bundle, true, true, zzbx().currentTimeMillis());
    }

    final void zza(String str, String str2, Bundle bundle) {
        zzgg();
        zzaf();
        zza(str, str2, zzbx().currentTimeMillis(), bundle);
    }

    final void zza(String str, String str2, long j, Bundle bundle) {
        zzgg();
        zzaf();
        boolean z = this.zzaqy == null || zzfy.zzcy(str2);
        zza(str, str2, j, bundle, true, z, false, null);
    }

    private final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Preconditions.checkNotEmpty(str);
        if (!zzgv().zze(str3, zzai.zzalg)) {
            Preconditions.checkNotEmpty(str2);
        }
        Preconditions.checkNotNull(bundle);
        zzaf();
        zzcl();
        if (this.zzada.isEnabled()) {
            if (!this.zzara) {
                this.zzara = true;
                try {
                    try {
                        Class.forName("com.google.android.gms.tagmanager.TagManagerService").getDeclaredMethod("initialize", new Class[]{Context.class}).invoke(null, new Object[]{getContext()});
                    } catch (Exception e) {
                        zzgt().zzjj().zzg("Failed to invoke Tag Manager's initialize() method", e);
                    }
                } catch (ClassNotFoundException e2) {
                    zzgt().zzjm().zzby("Tag Manager is not found and thus will not be used");
                }
            }
            if (z3) {
                zzgw();
                if (!"_iap".equals(str2)) {
                    int i;
                    zzfy zzgr = this.zzada.zzgr();
                    if (!zzgr.zzs("event", str2)) {
                        i = 2;
                    } else if (!zzgr.zza("event", zzcu.zzaqq, str2)) {
                        i = 13;
                    } else if (zzgr.zza("event", 40, str2)) {
                        i = 0;
                    } else {
                        i = 2;
                    }
                    if (i != 0) {
                        zzgt().zzji().zzg("Invalid public event name. Event will not be logged (FE)", zzgq().zzbt(str2));
                        this.zzada.zzgr();
                        this.zzada.zzgr().zza(i, "_ev", zzfy.zza(str2, 40, true), str2 != null ? str2.length() : 0);
                        return;
                    }
                }
            }
            zzgw();
            zzdx zzle = zzgm().zzle();
            if (zzle != null) {
                if (!bundle.containsKey("_sc")) {
                    zzle.zzarp = true;
                }
            }
            boolean z4 = z && z3;
            zzdy.zza(zzle, bundle, z4);
            boolean equals = "am".equals(str);
            z4 = zzfy.zzcy(str2);
            if (z && this.zzaqy != null && !z4 && !equals) {
                zzgt().zzjn().zze("Passing event to registered event handler (FE)", zzgq().zzbt(str2), zzgq().zzd(bundle));
                this.zzaqy.interceptEvent(str, str2, bundle, j);
                return;
            } else if (this.zzada.zzkv()) {
                int zzcu = zzgr().zzcu(str2);
                if (zzcu != 0) {
                    zzgt().zzji().zzg("Invalid event name. Event will not be logged (FE)", zzgq().zzbt(str2));
                    zzgr();
                    this.zzada.zzgr().zza(str3, zzcu, "_ev", zzfy.zza(str2, 40, true), str2 != null ? str2.length() : 0);
                    return;
                }
                zzdx zzdx;
                zzdx zzdx2;
                Bundle zza;
                List listOf = CollectionUtils.listOf("_o", "_sn", "_sc", "_si");
                Bundle zza2 = zzgr().zza(str3, str2, bundle, listOf, z3, true);
                if (zza2 != null && zza2.containsKey("_sc") && zza2.containsKey("_si")) {
                    zzdx = new zzdx(zza2.getString("_sn"), zza2.getString("_sc"), Long.valueOf(zza2.getLong("_si")).longValue());
                } else {
                    zzdx = null;
                }
                if (zzdx == null) {
                    zzdx2 = zzle;
                } else {
                    zzdx2 = zzdx;
                }
                if (zzgv().zzbk(str3)) {
                    zzgw();
                    if (zzgm().zzle() != null && Event.APP_EXCEPTION.equals(str2)) {
                        long zzlp = zzgo().zzlp();
                        if (zzlp > 0) {
                            zzgr().zza(zza2, zzlp);
                        }
                    }
                }
                List arrayList = new ArrayList();
                arrayList.add(zza2);
                long nextLong = zzgr().zzmk().nextLong();
                if (zzgv().zzbj(zzgk().zzal()) && zza2.getLong("extend_session", 0) == 1) {
                    zzgt().zzjo().zzby("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                    this.zzada.zzgo().zza(j, true);
                }
                int i2 = 0;
                String[] strArr = (String[]) zza2.keySet().toArray(new String[bundle.size()]);
                Arrays.sort(strArr);
                int length = strArr.length;
                int i3 = 0;
                while (i3 < length) {
                    int length2;
                    String str4 = strArr[i3];
                    Object obj = zza2.get(str4);
                    zzgr();
                    Bundle[] zzf = zzfy.zzf(obj);
                    if (zzf != null) {
                        zza2.putInt(str4, zzf.length);
                        for (int i4 = 0; i4 < zzf.length; i4++) {
                            Bundle bundle2 = zzf[i4];
                            zzdy.zza(zzdx2, bundle2, true);
                            zza = zzgr().zza(str3, "_ep", bundle2, listOf, z3, false);
                            zza.putString("_en", str2);
                            zza.putLong("_eid", nextLong);
                            zza.putString("_gn", str4);
                            zza.putInt("_ll", zzf.length);
                            zza.putInt("_i", i4);
                            arrayList.add(zza);
                        }
                        length2 = zzf.length + i2;
                    } else {
                        length2 = i2;
                    }
                    i3++;
                    i2 = length2;
                }
                if (i2 != 0) {
                    zza2.putLong("_eid", nextLong);
                    zza2.putInt("_epc", i2);
                }
                int i5 = 0;
                while (i5 < arrayList.size()) {
                    String str5;
                    Bundle zze;
                    zza = (Bundle) arrayList.get(i5);
                    if ((i5 != 0 ? 1 : null) != null) {
                        str5 = "_ep";
                    } else {
                        str5 = str2;
                    }
                    zza.putString("_o", str);
                    if (z2) {
                        zze = zzgr().zze(zza);
                    } else {
                        zze = zza;
                    }
                    zzgt().zzjn().zze("Logging event (FE)", zzgq().zzbt(str2), zzgq().zzd(zze));
                    zzgl().zzc(new zzag(str5, new zzad(zze), str, j), str3);
                    if (!equals) {
                        for (zzcy onEvent : this.zzaqz) {
                            onEvent.onEvent(str, str2, new Bundle(zze), j);
                        }
                    }
                    i5++;
                }
                zzgw();
                if (zzgm().zzle() != null && Event.APP_EXCEPTION.equals(str2)) {
                    zzgo().zza(true, true);
                    return;
                }
                return;
            } else {
                return;
            }
        }
        zzgt().zzjn().zzby("Event not sent since app measurement is disabled");
    }

    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        String str3;
        Bundle bundle2;
        zzgg();
        if (str == null) {
            str3 = "app";
        } else {
            str3 = str;
        }
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = bundle;
        }
        boolean z3 = !z2 || this.zzaqy == null || zzfy.zzcy(str2);
        zzb(str3, str2, j, bundle2, z2, z3, !z, null);
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzgs().zzc(new zzdc(this, str, str2, j, zzfy.zzf(bundle), z, z2, z3, str3));
    }

    public final void zzb(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, z, zzbx().currentTimeMillis());
    }

    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        String str3;
        int i = 6;
        int i2 = 0;
        if (str == null) {
            str3 = "app";
        } else {
            str3 = str;
        }
        if (z) {
            i = zzgr().zzcv(str2);
        } else {
            zzfy zzgr = zzgr();
            if (zzgr.zzs("user property", str2)) {
                if (!zzgr.zza("user property", zzcw.zzaqu, str2)) {
                    i = 15;
                } else if (zzgr.zza("user property", 24, str2)) {
                    i = 0;
                }
            }
        }
        if (i != 0) {
            zzgr();
            str3 = zzfy.zza(str2, 24, true);
            if (str2 != null) {
                i2 = str2.length();
            }
            this.zzada.zzgr().zza(i, "_ev", str3, i2);
        } else if (obj != null) {
            i = zzgr().zzi(str2, obj);
            if (i != 0) {
                zzgr();
                str3 = zzfy.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i2 = String.valueOf(obj).length();
                }
                this.zzada.zzgr().zza(i, "_ev", str3, i2);
                return;
            }
            Object zzj = zzgr().zzj(str2, obj);
            if (zzj != null) {
                zza(str3, str2, j, zzj);
            }
        } else {
            zza(str3, str2, j, null);
        }
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzgs().zzc(new zzdd(this, str, str2, obj, j));
    }

    final void zza(String str, String str2, Object obj, long j) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzaf();
        zzgg();
        zzcl();
        if (!this.zzada.isEnabled()) {
            zzgt().zzjn().zzby("User property not set since app measurement is disabled");
        } else if (this.zzada.zzkv()) {
            zzgt().zzjn().zze("Setting user property (FE)", zzgq().zzbt(str2), obj);
            zzgl().zzb(new zzfv(str2, j, obj, str));
        }
    }

    public final List<zzfv> zzk(boolean z) {
        zzgg();
        zzcl();
        zzgt().zzjn().zzby("Fetching user attributes (FE)");
        if (zzgs().zzkf()) {
            zzgt().zzjg().zzby("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (zzn.isMainThread()) {
            zzgt().zzjg().zzby("Cannot get all user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                this.zzada.zzgs().zzc(new zzde(this, atomicReference, z));
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e) {
                    zzgt().zzjj().zzg("Interrupted waiting for get user properties", e);
                }
            }
            List<zzfv> list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            zzgt().zzjj().zzby("Timed out waiting for get user properties");
            return Collections.emptyList();
        }
    }

    public final String zzgc() {
        zzgg();
        return (String) this.zzarb.get();
    }

    public final String zzag(long j) {
        if (zzgs().zzkf()) {
            zzgt().zzjg().zzby("Cannot retrieve app instance id from analytics worker thread");
            return null;
        } else if (zzn.isMainThread()) {
            zzgt().zzjg().zzby("Cannot retrieve app instance id from main thread");
            return null;
        } else {
            long elapsedRealtime = zzbx().elapsedRealtime();
            String zzah = zzah(120000);
            elapsedRealtime = zzbx().elapsedRealtime() - elapsedRealtime;
            if (zzah != null || elapsedRealtime >= 120000) {
                return zzah;
            }
            return zzah(120000 - elapsedRealtime);
        }
    }

    final void zzcp(String str) {
        this.zzarb.set(str);
    }

    private final String zzah(long j) {
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            zzgs().zzc(new zzdf(this, atomicReference));
            try {
                atomicReference.wait(j);
            } catch (InterruptedException e) {
                zzgt().zzjj().zzby("Interrupted waiting for app instance id");
                return null;
            }
        }
        return (String) atomicReference.get();
    }

    public final void resetAnalyticsData(long j) {
        if (zzgv().zza(zzai.zzalb)) {
            zzcp(null);
        }
        zzgs().zzc(new zzdg(this, j));
    }

    public final void zzld() {
        zzaf();
        zzgg();
        zzcl();
        if (this.zzada.zzkv()) {
            zzgl().zzld();
            this.zzarc = false;
            String zzka = zzgu().zzka();
            if (!TextUtils.isEmpty(zzka)) {
                zzgp().zzcl();
                if (!zzka.equals(VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzka);
                    logEvent("auto", "_ou", bundle);
                }
            }
        }
    }

    public final void zza(zzcx zzcx) {
        zzaf();
        zzgg();
        zzcl();
        if (!(zzcx == null || zzcx == this.zzaqy)) {
            Preconditions.checkState(this.zzaqy == null, "EventInterceptor already set.");
        }
        this.zzaqy = zzcx;
    }

    public final void zza(zzcy zzcy) {
        zzgg();
        zzcl();
        Preconditions.checkNotNull(zzcy);
        if (!this.zzaqz.add(zzcy)) {
            zzgt().zzjj().zzby("OnEventListener already registered");
        }
    }

    public final void zzb(zzcy zzcy) {
        zzgg();
        zzcl();
        Preconditions.checkNotNull(zzcy);
        if (!this.zzaqz.remove(zzcy)) {
            zzgt().zzjj().zzby("OnEventListener had not been registered");
        }
    }

    public final void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        zzgg();
        ConditionalUserProperty conditionalUserProperty2 = new ConditionalUserProperty(conditionalUserProperty);
        if (!TextUtils.isEmpty(conditionalUserProperty2.mAppId)) {
            zzgt().zzjj().zzby("Package name should be null when calling setConditionalUserProperty");
        }
        conditionalUserProperty2.mAppId = null;
        zza(conditionalUserProperty2);
    }

    public final void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mAppId);
        zzgf();
        zza(new ConditionalUserProperty(conditionalUserProperty));
    }

    private final void zza(ConditionalUserProperty conditionalUserProperty) {
        long currentTimeMillis = zzbx().currentTimeMillis();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mName);
        Preconditions.checkNotEmpty(conditionalUserProperty.mOrigin);
        Preconditions.checkNotNull(conditionalUserProperty.mValue);
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        String str = conditionalUserProperty.mName;
        Object obj = conditionalUserProperty.mValue;
        if (zzgr().zzcv(str) != 0) {
            zzgt().zzjg().zzg("Invalid conditional user property name", zzgq().zzbv(str));
        } else if (zzgr().zzi(str, obj) != 0) {
            zzgt().zzjg().zze("Invalid conditional user property value", zzgq().zzbv(str), obj);
        } else {
            Object zzj = zzgr().zzj(str, obj);
            if (zzj == null) {
                zzgt().zzjg().zze("Unable to normalize conditional user property value", zzgq().zzbv(str), obj);
                return;
            }
            conditionalUserProperty.mValue = zzj;
            long j = conditionalUserProperty.mTriggerTimeout;
            if (TextUtils.isEmpty(conditionalUserProperty.mTriggerEventName) || (j <= 15552000000L && j >= 1)) {
                j = conditionalUserProperty.mTimeToLive;
                if (j > 15552000000L || j < 1) {
                    zzgt().zzjg().zze("Invalid conditional user property time to live", zzgq().zzbv(str), Long.valueOf(j));
                    return;
                } else {
                    zzgs().zzc(new zzdi(this, conditionalUserProperty));
                    return;
                }
            }
            zzgt().zzjg().zze("Invalid conditional user property timeout", zzgq().zzbv(str), Long.valueOf(j));
        }
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zzgg();
        zza(null, str, str2, bundle);
    }

    public final void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zzgf();
        zza(str, str2, str3, bundle);
    }

    private final void zza(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzbx().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
        conditionalUserProperty.mAppId = str;
        conditionalUserProperty.mName = str2;
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        if (str3 != null) {
            conditionalUserProperty.mExpiredEventName = str3;
            conditionalUserProperty.mExpiredEventParams = bundle;
        }
        zzgs().zzc(new zzdj(this, conditionalUserProperty));
    }

    private final void zzb(ConditionalUserProperty conditionalUserProperty) {
        zzaf();
        zzcl();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mName);
        Preconditions.checkNotEmpty(conditionalUserProperty.mOrigin);
        Preconditions.checkNotNull(conditionalUserProperty.mValue);
        if (this.zzada.isEnabled()) {
            zzfv zzfv = new zzfv(conditionalUserProperty.mName, conditionalUserProperty.mTriggeredTimestamp, conditionalUserProperty.mValue, conditionalUserProperty.mOrigin);
            try {
                zzag zza = zzgr().zza(conditionalUserProperty.mAppId, conditionalUserProperty.mTriggeredEventName, conditionalUserProperty.mTriggeredEventParams, conditionalUserProperty.mOrigin, 0, true, false);
                zzgl().zzd(new zzo(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, zzfv, conditionalUserProperty.mCreationTimestamp, false, conditionalUserProperty.mTriggerEventName, zzgr().zza(conditionalUserProperty.mAppId, conditionalUserProperty.mTimedOutEventName, conditionalUserProperty.mTimedOutEventParams, conditionalUserProperty.mOrigin, 0, true, false), conditionalUserProperty.mTriggerTimeout, zza, conditionalUserProperty.mTimeToLive, zzgr().zza(conditionalUserProperty.mAppId, conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, 0, true, false)));
                return;
            } catch (IllegalArgumentException e) {
                return;
            }
        }
        zzgt().zzjn().zzby("Conditional property not sent since collection is disabled");
    }

    private final void zzc(ConditionalUserProperty conditionalUserProperty) {
        zzaf();
        zzcl();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mName);
        if (this.zzada.isEnabled()) {
            zzfv zzfv = new zzfv(conditionalUserProperty.mName, 0, null, null);
            try {
                zzgl().zzd(new zzo(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, zzfv, conditionalUserProperty.mCreationTimestamp, conditionalUserProperty.mActive, conditionalUserProperty.mTriggerEventName, null, conditionalUserProperty.mTriggerTimeout, null, conditionalUserProperty.mTimeToLive, zzgr().zza(conditionalUserProperty.mAppId, conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, conditionalUserProperty.mCreationTimestamp, true, false)));
                return;
            } catch (IllegalArgumentException e) {
                return;
            }
        }
        zzgt().zzjn().zzby("Conditional property not cleared since collection is disabled");
    }

    public final List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        zzgg();
        return zzf(null, str, str2);
    }

    public final List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzgf();
        return zzf(str, str2, str3);
    }

    @VisibleForTesting
    private final List<ConditionalUserProperty> zzf(String str, String str2, String str3) {
        if (zzgs().zzkf()) {
            zzgt().zzjg().zzby("Cannot get conditional user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (zzn.isMainThread()) {
            zzgt().zzjg().zzby("Cannot get conditional user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                this.zzada.zzgs().zzc(new zzdk(this, atomicReference, str, str2, str3));
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e) {
                    zzgt().zzjj().zze("Interrupted waiting for get conditional user properties", str, e);
                }
            }
            List<zzo> list = (List) atomicReference.get();
            if (list == null) {
                zzgt().zzjj().zzg("Timed out waiting for get conditional user properties", str);
                return Collections.emptyList();
            }
            List<ConditionalUserProperty> arrayList = new ArrayList(list.size());
            for (zzo zzo : list) {
                ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
                conditionalUserProperty.mAppId = zzo.packageName;
                conditionalUserProperty.mOrigin = zzo.origin;
                conditionalUserProperty.mCreationTimestamp = zzo.creationTimestamp;
                conditionalUserProperty.mName = zzo.zzags.name;
                conditionalUserProperty.mValue = zzo.zzags.getValue();
                conditionalUserProperty.mActive = zzo.active;
                conditionalUserProperty.mTriggerEventName = zzo.triggerEventName;
                if (zzo.zzagt != null) {
                    conditionalUserProperty.mTimedOutEventName = zzo.zzagt.name;
                    if (zzo.zzagt.zzahu != null) {
                        conditionalUserProperty.mTimedOutEventParams = zzo.zzagt.zzahu.zziy();
                    }
                }
                conditionalUserProperty.mTriggerTimeout = zzo.triggerTimeout;
                if (zzo.zzagu != null) {
                    conditionalUserProperty.mTriggeredEventName = zzo.zzagu.name;
                    if (zzo.zzagu.zzahu != null) {
                        conditionalUserProperty.mTriggeredEventParams = zzo.zzagu.zzahu.zziy();
                    }
                }
                conditionalUserProperty.mTriggeredTimestamp = zzo.zzags.zzauk;
                conditionalUserProperty.mTimeToLive = zzo.timeToLive;
                if (zzo.zzagv != null) {
                    conditionalUserProperty.mExpiredEventName = zzo.zzagv.name;
                    if (zzo.zzagv.zzahu != null) {
                        conditionalUserProperty.mExpiredEventParams = zzo.zzagv.zzahu.zziy();
                    }
                }
                arrayList.add(conditionalUserProperty);
            }
            return arrayList;
        }
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        zzgg();
        return zzb(null, str, str2, z);
    }

    public final Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zzgf();
        return zzb(str, str2, str3, z);
    }

    @VisibleForTesting
    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        if (zzgs().zzkf()) {
            zzgt().zzjg().zzby("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        } else if (zzn.isMainThread()) {
            zzgt().zzjg().zzby("Cannot get user properties from main thread");
            return Collections.emptyMap();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                this.zzada.zzgs().zzc(new zzdm(this, atomicReference, str, str2, str3, z));
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e) {
                    zzgt().zzjj().zzg("Interrupted waiting for get user properties", e);
                }
            }
            List<zzfv> list = (List) atomicReference.get();
            if (list == null) {
                zzgt().zzjj().zzby("Timed out waiting for get user properties");
                return Collections.emptyMap();
            }
            Map<String, Object> c0238a = new C0238a(list.size());
            for (zzfv zzfv : list) {
                c0238a.put(zzfv.name, zzfv.getValue());
            }
            return c0238a;
        }
    }

    public final String getCurrentScreenName() {
        zzdx zzlf = this.zzada.zzgm().zzlf();
        if (zzlf != null) {
            return zzlf.zzuw;
        }
        return null;
    }

    public final String getCurrentScreenClass() {
        zzdx zzlf = this.zzada.zzgm().zzlf();
        if (zzlf != null) {
            return zzlf.zzarn;
        }
        return null;
    }

    public final String getGmpAppId() {
        if (this.zzada.zzko() != null) {
            return this.zzada.zzko();
        }
        try {
            return GoogleServices.getGoogleAppId();
        } catch (IllegalStateException e) {
            this.zzada.zzgt().zzjg().zzg("getGoogleAppId failed with exception", e);
            return null;
        }
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
