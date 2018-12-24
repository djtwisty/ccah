package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.support.v4.p017e.C0238a;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfz;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.http.HttpStatus;

public class zzfo implements zzct {
    private static volatile zzfo zzatg;
    private final zzbw zzada;
    private zzbq zzath;
    private zzaw zzati;
    private zzt zzatj;
    private zzbb zzatk;
    private zzfk zzatl;
    private zzm zzatm;
    private final zzfu zzatn;
    private zzdv zzato;
    private boolean zzatp;
    private boolean zzatq;
    @VisibleForTesting
    private long zzatr;
    private List<Runnable> zzats;
    private int zzatt;
    private int zzatu;
    private boolean zzatv;
    private boolean zzatw;
    private boolean zzatx;
    private FileLock zzaty;
    private FileChannel zzatz;
    private List<Long> zzaua;
    private List<Long> zzaub;
    private long zzauc;
    private boolean zzvz;

    class zza implements zzv {
        private final /* synthetic */ zzfo zzaue;
        zzfw zzaug;
        List<Long> zzauh;
        List<zzft> zzaui;
        private long zzauj;

        private zza(zzfo zzfo) {
            this.zzaue = zzfo;
        }

        public final void zzb(zzfw zzfw) {
            Preconditions.checkNotNull(zzfw);
            this.zzaug = zzfw;
        }

        public final boolean zza(long j, zzft zzft) {
            Preconditions.checkNotNull(zzft);
            if (this.zzaui == null) {
                this.zzaui = new ArrayList();
            }
            if (this.zzauh == null) {
                this.zzauh = new ArrayList();
            }
            if (this.zzaui.size() > 0 && zza((zzft) this.zzaui.get(0)) != zza(zzft)) {
                return false;
            }
            long zzvx = this.zzauj + ((long) zzft.zzvx());
            if (zzvx >= ((long) Math.max(0, ((Integer) zzai.zzajc.get()).intValue()))) {
                return false;
            }
            this.zzauj = zzvx;
            this.zzaui.add(zzft);
            this.zzauh.add(Long.valueOf(j));
            if (this.zzaui.size() >= Math.max(1, ((Integer) zzai.zzajd.get()).intValue())) {
                return false;
            }
            return true;
        }

        private static long zza(zzft zzft) {
            return ((zzft.zzaxb.longValue() / 1000) / 60) / 60;
        }
    }

    public static zzfo zzn(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzatg == null) {
            synchronized (zzfo.class) {
                if (zzatg == null) {
                    zzatg = new zzfo(new zzft(context));
                }
            }
        }
        return zzatg;
    }

    private zzfo(zzft zzft) {
        this(zzft, null);
    }

    private zzfo(zzft zzft, zzbw zzbw) {
        this.zzvz = false;
        Preconditions.checkNotNull(zzft);
        this.zzada = zzbw.zza(zzft.zzri, null);
        this.zzauc = -1;
        zzfn zzfu = new zzfu(this);
        zzfu.zzq();
        this.zzatn = zzfu;
        zzfu = new zzaw(this);
        zzfu.zzq();
        this.zzati = zzfu;
        zzfu = new zzbq(this);
        zzfu.zzq();
        this.zzath = zzfu;
        this.zzada.zzgs().zzc(new zzfp(this, zzft));
    }

    private final void zza(zzft zzft) {
        this.zzada.zzgs().zzaf();
        zzfn zzt = new zzt(this);
        zzt.zzq();
        this.zzatj = zzt;
        this.zzada.zzgv().zza(this.zzath);
        zzt = new zzm(this);
        zzt.zzq();
        this.zzatm = zzt;
        zzt = new zzdv(this);
        zzt.zzq();
        this.zzato = zzt;
        zzt = new zzfk(this);
        zzt.zzq();
        this.zzatl = zzt;
        this.zzatk = new zzbb(this);
        if (this.zzatt != this.zzatu) {
            this.zzada.zzgt().zzjg().zze("Not all upload components initialized", Integer.valueOf(this.zzatt), Integer.valueOf(this.zzatu));
        }
        this.zzvz = true;
    }

    protected final void start() {
        this.zzada.zzgs().zzaf();
        zzjt().zzij();
        if (this.zzada.zzgu().zzana.get() == 0) {
            this.zzada.zzgu().zzana.set(this.zzada.zzbx().currentTimeMillis());
        }
        zzmb();
    }

    public final zzn zzgw() {
        return this.zzada.zzgw();
    }

    public final zzq zzgv() {
        return this.zzada.zzgv();
    }

    public final zzas zzgt() {
        return this.zzada.zzgt();
    }

    public final zzbr zzgs() {
        return this.zzada.zzgs();
    }

    private final zzbq zzls() {
        zza(this.zzath);
        return this.zzath;
    }

    public final zzaw zzlt() {
        zza(this.zzati);
        return this.zzati;
    }

    public final zzt zzjt() {
        zza(this.zzatj);
        return this.zzatj;
    }

    private final zzbb zzlu() {
        if (this.zzatk != null) {
            return this.zzatk;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzfk zzlv() {
        zza(this.zzatl);
        return this.zzatl;
    }

    public final zzm zzjs() {
        zza(this.zzatm);
        return this.zzatm;
    }

    public final zzdv zzlw() {
        zza(this.zzato);
        return this.zzato;
    }

    public final zzfu zzjr() {
        zza(this.zzatn);
        return this.zzatn;
    }

    public final zzaq zzgq() {
        return this.zzada.zzgq();
    }

    public final Context getContext() {
        return this.zzada.getContext();
    }

    public final Clock zzbx() {
        return this.zzada.zzbx();
    }

    public final zzfy zzgr() {
        return this.zzada.zzgr();
    }

    private final void zzaf() {
        this.zzada.zzgs().zzaf();
    }

    final void zzlx() {
        if (!this.zzvz) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    private static void zza(zzfn zzfn) {
        if (zzfn == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!zzfn.isInitialized()) {
            String valueOf = String.valueOf(zzfn.getClass());
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 27).append("Component not initialized: ").append(valueOf).toString());
        }
    }

    final void zze(zzk zzk) {
        zzaf();
        zzlx();
        Preconditions.checkNotEmpty(zzk.packageName);
        zzg(zzk);
    }

    private final long zzly() {
        long currentTimeMillis = this.zzada.zzbx().currentTimeMillis();
        zzcr zzgu = this.zzada.zzgu();
        zzgu.zzcl();
        zzgu.zzaf();
        long j = zzgu.zzane.get();
        if (j == 0) {
            j = 1 + ((long) zzgu.zzgr().zzmk().nextInt(86400000));
            zzgu.zzane.set(j);
        }
        return ((((j + currentTimeMillis) / 1000) / 60) / 60) / 24;
    }

    final void zzd(zzag zzag, String str) {
        zzg zzbm = zzjt().zzbm(str);
        if (zzbm == null || TextUtils.isEmpty(zzbm.zzak())) {
            this.zzada.zzgt().zzjn().zzg("No app data available; dropping event", str);
            return;
        }
        Boolean zzc = zzc(zzbm);
        if (zzc == null) {
            if (!"_ui".equals(zzag.name)) {
                this.zzada.zzgt().zzjj().zzg("Could not find package. appId", zzas.zzbw(str));
            }
        } else if (!zzc.booleanValue()) {
            this.zzada.zzgt().zzjg().zzg("App version does not match; dropping event. appId", zzas.zzbw(str));
            return;
        }
        zzag zzag2 = zzag;
        zzc(zzag2, new zzk(str, zzbm.getGmpAppId(), zzbm.zzak(), zzbm.zzhf(), zzbm.zzhg(), zzbm.zzhh(), zzbm.zzhi(), null, zzbm.isMeasurementEnabled(), false, zzbm.getFirebaseInstanceId(), zzbm.zzhv(), 0, 0, zzbm.zzhw(), zzbm.zzhx(), false, zzbm.zzhb()));
    }

    final void zzc(zzag zzag, zzk zzk) {
        Preconditions.checkNotNull(zzk);
        Preconditions.checkNotEmpty(zzk.packageName);
        zzaf();
        zzlx();
        String str = zzk.packageName;
        long j = zzag.zzaig;
        if (!zzjr().zze(zzag, zzk)) {
            return;
        }
        if (zzk.zzafr) {
            zzjt().beginTransaction();
            try {
                List emptyList;
                Object obj;
                zzcr zzjt = zzjt();
                Preconditions.checkNotEmpty(str);
                zzjt.zzaf();
                zzjt.zzcl();
                if (j < 0) {
                    zzjt.zzgt().zzjj().zze("Invalid time querying timed out conditional properties", zzas.zzbw(str), Long.valueOf(j));
                    emptyList = Collections.emptyList();
                } else {
                    emptyList = zzjt.zzb("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzo zzo : r2) {
                    if (zzo != null) {
                        this.zzada.zzgt().zzjn().zzd("User property timed out", zzo.packageName, this.zzada.zzgq().zzbv(zzo.zzags.name), zzo.zzags.getValue());
                        if (zzo.zzagt != null) {
                            zzd(new zzag(zzo.zzagt, j), zzk);
                        }
                        zzjt().zzk(str, zzo.zzags.name);
                    }
                }
                zzjt = zzjt();
                Preconditions.checkNotEmpty(str);
                zzjt.zzaf();
                zzjt.zzcl();
                if (j < 0) {
                    zzjt.zzgt().zzjj().zze("Invalid time querying expired conditional properties", zzas.zzbw(str), Long.valueOf(j));
                    emptyList = Collections.emptyList();
                } else {
                    emptyList = zzjt.zzb("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                List arrayList = new ArrayList(r2.size());
                for (zzo zzo2 : r2) {
                    if (zzo2 != null) {
                        this.zzada.zzgt().zzjn().zzd("User property expired", zzo2.packageName, this.zzada.zzgq().zzbv(zzo2.zzags.name), zzo2.zzags.getValue());
                        zzjt().zzh(str, zzo2.zzags.name);
                        if (zzo2.zzagv != null) {
                            arrayList.add(zzo2.zzagv);
                        }
                        zzjt().zzk(str, zzo2.zzags.name);
                    }
                }
                ArrayList arrayList2 = (ArrayList) arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    obj = arrayList2.get(i);
                    i++;
                    zzd(new zzag((zzag) obj, j), zzk);
                }
                zzjt = zzjt();
                String str2 = zzag.name;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zzjt.zzaf();
                zzjt.zzcl();
                if (j < 0) {
                    zzjt.zzgt().zzjj().zzd("Invalid time querying triggered conditional properties", zzas.zzbw(str), zzjt.zzgq().zzbt(str2), Long.valueOf(j));
                    emptyList = Collections.emptyList();
                } else {
                    emptyList = zzjt.zzb("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                List arrayList3 = new ArrayList(r2.size());
                for (zzo zzo3 : r2) {
                    if (zzo3 != null) {
                        zzfv zzfv = zzo3.zzags;
                        zzfx zzfx = new zzfx(zzo3.packageName, zzo3.origin, zzfv.name, j, zzfv.getValue());
                        if (zzjt().zza(zzfx)) {
                            this.zzada.zzgt().zzjn().zzd("User property triggered", zzo3.packageName, this.zzada.zzgq().zzbv(zzfx.name), zzfx.value);
                        } else {
                            this.zzada.zzgt().zzjg().zzd("Too many active user properties, ignoring", zzas.zzbw(zzo3.packageName), this.zzada.zzgq().zzbv(zzfx.name), zzfx.value);
                        }
                        if (zzo3.zzagu != null) {
                            arrayList3.add(zzo3.zzagu);
                        }
                        zzo3.zzags = new zzfv(zzfx);
                        zzo3.active = true;
                        zzjt().zza(zzo3);
                    }
                }
                zzd(zzag, zzk);
                arrayList2 = (ArrayList) arrayList3;
                int size2 = arrayList2.size();
                i = 0;
                while (i < size2) {
                    obj = arrayList2.get(i);
                    i++;
                    zzd(new zzag((zzag) obj, j), zzk);
                }
                zzjt().setTransactionSuccessful();
            } finally {
                zzjt().endTransaction();
            }
        } else {
            zzg(zzk);
        }
    }

    private final void zzd(zzag zzag, zzk zzk) {
        Preconditions.checkNotNull(zzk);
        Preconditions.checkNotEmpty(zzk.packageName);
        long nanoTime = System.nanoTime();
        zzaf();
        zzlx();
        String str = zzk.packageName;
        if (!zzjr().zze(zzag, zzk)) {
            return;
        }
        if (!zzk.zzafr) {
            zzg(zzk);
        } else if (zzls().zzo(str, zzag.name)) {
            Object obj;
            this.zzada.zzgt().zzjj().zze("Dropping blacklisted event. appId", zzas.zzbw(str), this.zzada.zzgq().zzbt(zzag.name));
            if (zzls().zzcl(str) || zzls().zzcm(str)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null && !"_err".equals(zzag.name)) {
                this.zzada.zzgr().zza(str, 11, "_ev", zzag.name, 0);
            }
            if (obj != null) {
                zzg zzbm = zzjt().zzbm(str);
                if (zzbm != null) {
                    if (Math.abs(this.zzada.zzbx().currentTimeMillis() - Math.max(zzbm.zzhl(), zzbm.zzhk())) > ((Long) zzai.zzajt.get()).longValue()) {
                        this.zzada.zzgt().zzjn().zzby("Fetching config for blacklisted app");
                        zzb(zzbm);
                    }
                }
            }
        } else {
            String toUpperCase;
            zzfx zzi;
            if (this.zzada.zzgt().isLoggable(2)) {
                this.zzada.zzgt().zzjo().zzg("Logging event", this.zzada.zzgq().zzb(zzag));
            }
            zzjt().beginTransaction();
            zzcr zzjt;
            try {
                zzg(zzk);
                if ("_iap".equals(zzag.name) || Event.ECOMMERCE_PURCHASE.equals(zzag.name)) {
                    long round;
                    Object string = zzag.zzahu.getString(Param.CURRENCY);
                    if (Event.ECOMMERCE_PURCHASE.equals(zzag.name)) {
                        double doubleValue = zzag.zzahu.zzbr(Param.VALUE).doubleValue() * 1000000.0d;
                        if (doubleValue == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                            doubleValue = ((double) zzag.zzahu.getLong(Param.VALUE).longValue()) * 1000000.0d;
                        }
                        if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d) {
                            this.zzada.zzgt().zzjj().zze("Data lost. Currency value is too big. appId", zzas.zzbw(str), Double.valueOf(doubleValue));
                            string = null;
                            if (string == null) {
                                zzjt().setTransactionSuccessful();
                                zzjt().endTransaction();
                                return;
                            }
                        }
                        round = Math.round(doubleValue);
                    } else {
                        round = zzag.zzahu.getLong(Param.VALUE).longValue();
                    }
                    if (!TextUtils.isEmpty(string)) {
                        toUpperCase = string.toUpperCase(Locale.US);
                        if (toUpperCase.matches("[A-Z]{3}")) {
                            String concat;
                            String valueOf = String.valueOf("_ltv_");
                            toUpperCase = String.valueOf(toUpperCase);
                            if (toUpperCase.length() != 0) {
                                concat = valueOf.concat(toUpperCase);
                            } else {
                                concat = new String(valueOf);
                            }
                            zzi = zzjt().zzi(str, concat);
                            if (zzi == null || !(zzi.value instanceof Long)) {
                                zzjt = zzjt();
                                int zzb = this.zzada.zzgv().zzb(str, zzai.zzajy) - 1;
                                Preconditions.checkNotEmpty(str);
                                zzjt.zzaf();
                                zzjt.zzcl();
                                zzjt.getWritableDatabase().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(zzb)});
                                zzi = new zzfx(str, zzag.origin, concat, this.zzada.zzbx().currentTimeMillis(), Long.valueOf(round));
                            } else {
                                zzi = new zzfx(str, zzag.origin, concat, this.zzada.zzbx().currentTimeMillis(), Long.valueOf(round + ((Long) zzi.value).longValue()));
                            }
                            if (!zzjt().zza(zzi)) {
                                this.zzada.zzgt().zzjg().zzd("Too many unique user properties are set. Ignoring user property. appId", zzas.zzbw(str), this.zzada.zzgq().zzbv(zzi.name), zzi.value);
                                this.zzada.zzgr().zza(str, 9, null, null, 0);
                            }
                        }
                    }
                    string = 1;
                    if (string == null) {
                        zzjt().setTransactionSuccessful();
                        zzjt().endTransaction();
                        return;
                    }
                }
            } catch (SQLiteException e) {
                zzjt.zzgt().zzjg().zze("Error pruning currencies. appId", zzas.zzbw(str), e);
            } catch (Throwable th) {
                zzjt().endTransaction();
            }
            boolean zzct = zzfy.zzct(zzag.name);
            boolean equals = "_err".equals(zzag.name);
            zzu zza = zzjt().zza(zzly(), str, true, zzct, false, equals, false);
            long intValue = zza.zzahi - ((long) ((Integer) zzai.zzaje.get()).intValue());
            if (intValue > 0) {
                if (intValue % 1000 == 1) {
                    this.zzada.zzgt().zzjg().zze("Data loss. Too many events logged. appId, count", zzas.zzbw(str), Long.valueOf(zza.zzahi));
                }
                zzjt().setTransactionSuccessful();
                zzjt().endTransaction();
                return;
            }
            zzac zzae;
            zzab zzab;
            Long l;
            if (zzct) {
                intValue = zza.zzahh - ((long) ((Integer) zzai.zzajg.get()).intValue());
                if (intValue > 0) {
                    if (intValue % 1000 == 1) {
                        this.zzada.zzgt().zzjg().zze("Data loss. Too many public events logged. appId, count", zzas.zzbw(str), Long.valueOf(zza.zzahh));
                    }
                    this.zzada.zzgr().zza(str, 16, "_ev", zzag.name, 0);
                    zzjt().setTransactionSuccessful();
                    zzjt().endTransaction();
                    return;
                }
            }
            if (equals) {
                intValue = zza.zzahk - ((long) Math.max(0, Math.min(1000000, this.zzada.zzgv().zzb(zzk.packageName, zzai.zzajf))));
                if (intValue > 0) {
                    if (intValue == 1) {
                        this.zzada.zzgt().zzjg().zze("Too many error events logged. appId, count", zzas.zzbw(str), Long.valueOf(zza.zzahk));
                    }
                    zzjt().setTransactionSuccessful();
                    zzjt().endTransaction();
                    return;
                }
            }
            Bundle zziy = zzag.zzahu.zziy();
            this.zzada.zzgr().zza(zziy, "_o", zzag.origin);
            if (this.zzada.zzgr().zzcz(str)) {
                this.zzada.zzgr().zza(zziy, "_dbg", Long.valueOf(1));
                this.zzada.zzgr().zza(zziy, "_r", Long.valueOf(1));
            }
            if (this.zzada.zzgv().zzbh(zzk.packageName) && "_s".equals(zzag.name)) {
                zzi = zzjt().zzi(zzk.packageName, "_sno");
                if (zzi != null && (zzi.value instanceof Long)) {
                    this.zzada.zzgr().zza(zziy, "_sno", zzi.value);
                }
            }
            long zzbn = zzjt().zzbn(str);
            if (zzbn > 0) {
                this.zzada.zzgt().zzjj().zze("Data lost. Too many events stored on disk, deleted. appId", zzas.zzbw(str), Long.valueOf(zzbn));
            }
            zzab zzab2 = new zzab(this.zzada, zzag.origin, str, zzag.name, zzag.zzaig, 0, zziy);
            zzac zzg = zzjt().zzg(str, zzab2.name);
            if (zzg != null) {
                zzab2 = zzab2.zza(this.zzada, zzg.zzahx);
                zzae = zzg.zzae(zzab2.timestamp);
                zzab = zzab2;
            } else if (zzjt().zzbq(str) < 500 || !zzct) {
                zzae = new zzac(str, zzab2.name, 0, 0, zzab2.timestamp, 0, null, null, null, null);
                zzab = zzab2;
            } else {
                this.zzada.zzgt().zzjg().zzd("Too many event names used, ignoring event. appId, name, supported count", zzas.zzbw(str), this.zzada.zzgq().zzbt(zzab2.name), Integer.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR));
                this.zzada.zzgr().zza(str, 8, null, null, 0);
                zzjt().endTransaction();
                return;
            }
            zzjt().zza(zzae);
            zzaf();
            zzlx();
            Preconditions.checkNotNull(zzab);
            Preconditions.checkNotNull(zzk);
            Preconditions.checkNotEmpty(zzab.zztt);
            Preconditions.checkArgument(zzab.zztt.equals(zzk.packageName));
            zzfw zzfw = new zzfw();
            zzfw.zzaxh = Integer.valueOf(1);
            zzfw.zzaxp = "android";
            zzfw.zztt = zzk.packageName;
            zzfw.zzafp = zzk.zzafp;
            zzfw.zzts = zzk.zzts;
            zzfw.zzayb = zzk.zzafo == -2147483648L ? null : Integer.valueOf((int) zzk.zzafo);
            zzfw.zzaxt = Long.valueOf(zzk.zzade);
            zzfw.zzafi = zzk.zzafi;
            zzfw.zzawp = zzk.zzafv;
            if (zzk.zzafq == 0) {
                l = null;
            } else {
                l = Long.valueOf(zzk.zzafq);
            }
            zzfw.zzaxx = l;
            if (this.zzada.zzgv().zze(zzk.packageName, zzai.zzale)) {
                zzfw.zzayl = zzjr().zzmi();
            }
            Pair zzbz = this.zzada.zzgu().zzbz(zzk.packageName);
            if (zzbz == null || TextUtils.isEmpty((CharSequence) zzbz.first)) {
                if (!this.zzada.zzgp().zzl(this.zzada.getContext()) && zzk.zzafu) {
                    toUpperCase = Secure.getString(this.zzada.getContext().getContentResolver(), "android_id");
                    if (toUpperCase == null) {
                        this.zzada.zzgt().zzjj().zzg("null secure ID. appId", zzas.zzbw(zzfw.zztt));
                        toUpperCase = "null";
                    } else if (toUpperCase.isEmpty()) {
                        this.zzada.zzgt().zzjj().zzg("empty secure ID. appId", zzas.zzbw(zzfw.zztt));
                    }
                    zzfw.zzaye = toUpperCase;
                }
            } else if (zzk.zzaft) {
                zzfw.zzaxv = (String) zzbz.first;
                zzfw.zzaxw = (Boolean) zzbz.second;
            }
            this.zzada.zzgp().zzcl();
            zzfw.zzaxr = Build.MODEL;
            this.zzada.zzgp().zzcl();
            zzfw.zzaxq = VERSION.RELEASE;
            zzfw.zzaxs = Integer.valueOf((int) this.zzada.zzgp().zziw());
            zzfw.zzahr = this.zzada.zzgp().zzix();
            zzfw.zzaxu = null;
            zzfw.zzaxk = null;
            zzfw.zzaxl = null;
            zzfw.zzaxm = null;
            zzfw.zzayg = Long.valueOf(zzk.zzafs);
            if (this.zzada.isEnabled() && zzq.zzie()) {
                zzfw.zzayh = null;
            }
            zzg zzbm2 = zzjt().zzbm(zzk.packageName);
            if (zzbm2 == null) {
                zzbm2 = new zzg(this.zzada, zzk.packageName);
                zzbm2.zzaj(this.zzada.zzgr().zzmm());
                zzbm2.zzan(zzk.zzafk);
                zzbm2.zzak(zzk.zzafi);
                zzbm2.zzam(this.zzada.zzgu().zzca(zzk.packageName));
                zzbm2.zzt(0);
                zzbm2.zzo(0);
                zzbm2.zzp(0);
                zzbm2.setAppVersion(zzk.zzts);
                zzbm2.zzq(zzk.zzafo);
                zzbm2.zzao(zzk.zzafp);
                zzbm2.zzr(zzk.zzade);
                zzbm2.zzs(zzk.zzafq);
                zzbm2.setMeasurementEnabled(zzk.zzafr);
                zzbm2.zzac(zzk.zzafs);
                zzjt().zza(zzbm2);
            }
            zzfw.zzafh = zzbm2.getAppInstanceId();
            zzfw.zzafk = zzbm2.getFirebaseInstanceId();
            List zzbl = zzjt().zzbl(zzk.packageName);
            zzfw.zzaxj = new zzfz[zzbl.size()];
            for (int i = 0; i < zzbl.size(); i++) {
                zzfz zzfz = new zzfz();
                zzfw.zzaxj[i] = zzfz;
                zzfz.name = ((zzfx) zzbl.get(i)).name;
                zzfz.zzayu = Long.valueOf(((zzfx) zzbl.get(i)).zzauk);
                zzjr().zza(zzfz, ((zzfx) zzbl.get(i)).value);
            }
            try {
                boolean z;
                long zza2 = zzjt().zza(zzfw);
                zzt zzjt2 = zzjt();
                if (zzab.zzahu != null) {
                    Iterator it = zzab.zzahu.iterator();
                    while (it.hasNext()) {
                        if ("_r".equals((String) it.next())) {
                            z = true;
                            break;
                        }
                    }
                    z = zzls().zzp(zzab.zztt, zzab.name);
                    zzu zza3 = zzjt().zza(zzly(), zzab.zztt, false, false, false, false, false);
                    if (z && zza3.zzahl < ((long) this.zzada.zzgv().zzaq(zzab.zztt))) {
                        z = true;
                        if (zzjt2.zza(zzab, zza2, z)) {
                            this.zzatr = 0;
                        }
                        zzjt().setTransactionSuccessful();
                        if (this.zzada.zzgt().isLoggable(2)) {
                            this.zzada.zzgt().zzjo().zzg("Event recorded", this.zzada.zzgq().zza(zzab));
                        }
                        zzjt().endTransaction();
                        zzmb();
                        this.zzada.zzgt().zzjo().zzg("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                    }
                }
                z = false;
                if (zzjt2.zza(zzab, zza2, z)) {
                    this.zzatr = 0;
                }
            } catch (IOException e2) {
                this.zzada.zzgt().zzjg().zze("Data loss. Failed to insert raw event metadata. appId", zzas.zzbw(zzfw.zztt), e2);
            }
            zzjt().setTransactionSuccessful();
            if (this.zzada.zzgt().isLoggable(2)) {
                this.zzada.zzgt().zzjo().zzg("Event recorded", this.zzada.zzgq().zza(zzab));
            }
            zzjt().endTransaction();
            zzmb();
            this.zzada.zzgt().zzjo().zzg("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
        }
    }

    final void zzlz() {
        zzaf();
        zzlx();
        this.zzatx = true;
        String zzih;
        String str;
        try {
            this.zzada.zzgw();
            Boolean zzli = this.zzada.zzgl().zzli();
            if (zzli == null) {
                this.zzada.zzgt().zzjj().zzby("Upload data called on the client side before use of service was decided");
                this.zzatx = false;
                zzmc();
            } else if (zzli.booleanValue()) {
                this.zzada.zzgt().zzjg().zzby("Upload called in the client side when service should be used");
                this.zzatx = false;
                zzmc();
            } else if (this.zzatr > 0) {
                zzmb();
                this.zzatx = false;
                zzmc();
            } else {
                zzaf();
                if ((this.zzaua != null ? 1 : null) != null) {
                    this.zzada.zzgt().zzjo().zzby("Uploading requested multiple times");
                    this.zzatx = false;
                    zzmc();
                } else if (zzlt().zzfb()) {
                    long currentTimeMillis = this.zzada.zzbx().currentTimeMillis();
                    zzd(null, currentTimeMillis - zzq.zzic());
                    long j = this.zzada.zzgu().zzana.get();
                    if (j != 0) {
                        this.zzada.zzgt().zzjn().zzg("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - j)));
                    }
                    zzih = zzjt().zzih();
                    Object zzad;
                    if (TextUtils.isEmpty(zzih)) {
                        this.zzauc = -1;
                        zzad = zzjt().zzad(currentTimeMillis - zzq.zzic());
                        if (!TextUtils.isEmpty(zzad)) {
                            zzg zzbm = zzjt().zzbm(zzad);
                            if (zzbm != null) {
                                zzb(zzbm);
                            }
                        }
                    } else {
                        if (this.zzauc == -1) {
                            this.zzauc = zzjt().zzio();
                        }
                        List<Pair> zzb = zzjt().zzb(zzih, this.zzada.zzgv().zzb(zzih, zzai.zzaja), Math.max(0, this.zzada.zzgv().zzb(zzih, zzai.zzajb)));
                        if (!zzb.isEmpty()) {
                            zzfw zzfw;
                            Object obj;
                            int i;
                            List subList;
                            Object obj2;
                            for (Pair pair : zzb) {
                                zzfw = (zzfw) pair.first;
                                if (!TextUtils.isEmpty(zzfw.zzaxv)) {
                                    obj = zzfw.zzaxv;
                                    break;
                                }
                            }
                            obj = null;
                            if (obj != null) {
                                for (i = 0; i < zzb.size(); i++) {
                                    zzfw = (zzfw) ((Pair) zzb.get(i)).first;
                                    if (!TextUtils.isEmpty(zzfw.zzaxv) && !zzfw.zzaxv.equals(obj)) {
                                        subList = zzb.subList(0, i);
                                        break;
                                    }
                                }
                            }
                            subList = zzb;
                            zzfv zzfv = new zzfv();
                            zzfv.zzaxf = new zzfw[subList.size()];
                            Collection arrayList = new ArrayList(subList.size());
                            if (zzq.zzie() && this.zzada.zzgv().zzas(zzih)) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            for (i = 0; i < zzfv.zzaxf.length; i++) {
                                zzfv.zzaxf[i] = (zzfw) ((Pair) subList.get(i)).first;
                                arrayList.add((Long) ((Pair) subList.get(i)).second);
                                zzfv.zzaxf[i].zzaxu = Long.valueOf(this.zzada.zzgv().zzhh());
                                zzfv.zzaxf[i].zzaxk = Long.valueOf(currentTimeMillis);
                                zzfw = zzfv.zzaxf[i];
                                this.zzada.zzgw();
                                zzfw.zzaxz = Boolean.valueOf(false);
                                if (obj2 == null) {
                                    zzfv.zzaxf[i].zzayh = null;
                                }
                            }
                            if (this.zzada.zzgt().isLoggable(2)) {
                                obj2 = zzjr().zzb(zzfv);
                            } else {
                                obj2 = null;
                            }
                            obj = zzjr().zza(zzfv);
                            str = (String) zzai.zzajk.get();
                            URL url = new URL(str);
                            Preconditions.checkArgument(!arrayList.isEmpty());
                            if (this.zzaua != null) {
                                this.zzada.zzgt().zzjg().zzby("Set uploading progress before finishing the previous upload");
                            } else {
                                this.zzaua = new ArrayList(arrayList);
                            }
                            this.zzada.zzgu().zzanb.set(currentTimeMillis);
                            zzad = "?";
                            if (zzfv.zzaxf.length > 0) {
                                zzad = zzfv.zzaxf[0].zztt;
                            }
                            this.zzada.zzgt().zzjo().zzd("Uploading data. app, uncompressed size, data", zzad, Integer.valueOf(obj.length), obj2);
                            this.zzatw = true;
                            zzcr zzlt = zzlt();
                            zzay zzfq = new zzfq(this, zzih);
                            zzlt.zzaf();
                            zzlt.zzcl();
                            Preconditions.checkNotNull(url);
                            Preconditions.checkNotNull(obj);
                            Preconditions.checkNotNull(zzfq);
                            zzlt.zzgs().zzd(new zzba(zzlt, zzih, url, obj, null, zzfq));
                        }
                    }
                    this.zzatx = false;
                    zzmc();
                } else {
                    this.zzada.zzgt().zzjo().zzby("Network not connected, ignoring upload request");
                    zzmb();
                    this.zzatx = false;
                    zzmc();
                }
            }
        } catch (MalformedURLException e) {
            this.zzada.zzgt().zzjg().zze("Failed to parse upload URL. Not uploading. appId", zzas.zzbw(zzih), str);
        } catch (Throwable th) {
            this.zzatx = false;
            zzmc();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzd(java.lang.String r35, long r36) {
        /*
        r34 = this;
        r2 = r34.zzjt();
        r2.beginTransaction();
        r22 = new com.google.android.gms.measurement.internal.zzfo$zza;	 Catch:{ all -> 0x01e4 }
        r2 = 0;
        r0 = r22;
        r1 = r34;
        r0.<init>();	 Catch:{ all -> 0x01e4 }
        r14 = r34.zzjt();	 Catch:{ all -> 0x01e4 }
        r4 = 0;
        r0 = r34;
        r0 = r0.zzauc;	 Catch:{ all -> 0x01e4 }
        r16 = r0;
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r22);	 Catch:{ all -> 0x01e4 }
        r14.zzaf();	 Catch:{ all -> 0x01e4 }
        r14.zzcl();	 Catch:{ all -> 0x01e4 }
        r3 = 0;
        r2 = r14.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0ea1 }
        r5 = 0;
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ SQLiteException -> 0x0ea1 }
        if (r5 == 0) goto L_0x01ed;
    L_0x0031:
        r6 = -1;
        r5 = (r16 > r6 ? 1 : (r16 == r6 ? 0 : -1));
        if (r5 == 0) goto L_0x0186;
    L_0x0037:
        r5 = 2;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0ea1 }
        r6 = 0;
        r7 = java.lang.String.valueOf(r16);	 Catch:{ SQLiteException -> 0x0ea1 }
        r5[r6] = r7;	 Catch:{ SQLiteException -> 0x0ea1 }
        r6 = 1;
        r7 = java.lang.String.valueOf(r36);	 Catch:{ SQLiteException -> 0x0ea1 }
        r5[r6] = r7;	 Catch:{ SQLiteException -> 0x0ea1 }
        r6 = r5;
    L_0x0049:
        r8 = -1;
        r5 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1));
        if (r5 == 0) goto L_0x0193;
    L_0x004f:
        r5 = "rowid <= ? and ";
    L_0x0051:
        r7 = java.lang.String.valueOf(r5);	 Catch:{ SQLiteException -> 0x0ea1 }
        r7 = r7.length();	 Catch:{ SQLiteException -> 0x0ea1 }
        r7 = r7 + 148;
        r8 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0ea1 }
        r8.<init>(r7);	 Catch:{ SQLiteException -> 0x0ea1 }
        r7 = "select app_id, metadata_fingerprint from raw_events where ";
        r7 = r8.append(r7);	 Catch:{ SQLiteException -> 0x0ea1 }
        r5 = r7.append(r5);	 Catch:{ SQLiteException -> 0x0ea1 }
        r7 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;";
        r5 = r5.append(r7);	 Catch:{ SQLiteException -> 0x0ea1 }
        r5 = r5.toString();	 Catch:{ SQLiteException -> 0x0ea1 }
        r3 = r2.rawQuery(r5, r6);	 Catch:{ SQLiteException -> 0x0ea1 }
        r5 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x0ea1 }
        if (r5 != 0) goto L_0x0197;
    L_0x007e:
        if (r3 == 0) goto L_0x0083;
    L_0x0080:
        r3.close();	 Catch:{ all -> 0x01e4 }
    L_0x0083:
        r0 = r22;
        r2 = r0.zzaui;	 Catch:{ all -> 0x01e4 }
        if (r2 == 0) goto L_0x0093;
    L_0x0089:
        r0 = r22;
        r2 = r0.zzaui;	 Catch:{ all -> 0x01e4 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x01e4 }
        if (r2 == 0) goto L_0x0380;
    L_0x0093:
        r2 = 1;
    L_0x0094:
        if (r2 != 0) goto L_0x0e8d;
    L_0x0096:
        r18 = 0;
        r0 = r22;
        r0 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r23 = r0;
        r0 = r22;
        r2 = r0.zzaui;	 Catch:{ all -> 0x01e4 }
        r2 = r2.size();	 Catch:{ all -> 0x01e4 }
        r2 = new com.google.android.gms.internal.measurement.zzft[r2];	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r0.zzaxi = r2;	 Catch:{ all -> 0x01e4 }
        r15 = 0;
        r16 = 0;
        r0 = r34;
        r2 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzgv();	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r3 = r0.zztt;	 Catch:{ all -> 0x01e4 }
        r20 = r2.zzau(r3);	 Catch:{ all -> 0x01e4 }
        r0 = r34;
        r2 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzgv();	 Catch:{ all -> 0x01e4 }
        r0 = r22;
        r3 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r3 = r3.zztt;	 Catch:{ all -> 0x01e4 }
        r4 = com.google.android.gms.measurement.internal.zzai.zzala;	 Catch:{ all -> 0x01e4 }
        r21 = r2.zze(r3, r4);	 Catch:{ all -> 0x01e4 }
        r14 = 0;
        r13 = 0;
        r2 = 0;
        r19 = r2;
    L_0x00d8:
        r0 = r22;
        r2 = r0.zzaui;	 Catch:{ all -> 0x01e4 }
        r2 = r2.size();	 Catch:{ all -> 0x01e4 }
        r0 = r19;
        if (r0 >= r2) goto L_0x079a;
    L_0x00e4:
        r0 = r22;
        r2 = r0.zzaui;	 Catch:{ all -> 0x01e4 }
        r0 = r19;
        r2 = r2.get(r0);	 Catch:{ all -> 0x01e4 }
        r0 = r2;
        r0 = (com.google.android.gms.internal.measurement.zzft) r0;	 Catch:{ all -> 0x01e4 }
        r12 = r0;
        r2 = r34.zzls();	 Catch:{ all -> 0x01e4 }
        r0 = r22;
        r3 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r3 = r3.zztt;	 Catch:{ all -> 0x01e4 }
        r4 = r12.name;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzo(r3, r4);	 Catch:{ all -> 0x01e4 }
        if (r2 == 0) goto L_0x0386;
    L_0x0104:
        r0 = r34;
        r2 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzgt();	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzjj();	 Catch:{ all -> 0x01e4 }
        r3 = "Dropping blacklisted raw event. appId";
        r0 = r22;
        r4 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r4 = r4.zztt;	 Catch:{ all -> 0x01e4 }
        r4 = com.google.android.gms.measurement.internal.zzas.zzbw(r4);	 Catch:{ all -> 0x01e4 }
        r0 = r34;
        r5 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r5 = r5.zzgq();	 Catch:{ all -> 0x01e4 }
        r6 = r12.name;	 Catch:{ all -> 0x01e4 }
        r5 = r5.zzbt(r6);	 Catch:{ all -> 0x01e4 }
        r2.zze(r3, r4, r5);	 Catch:{ all -> 0x01e4 }
        r2 = r34.zzls();	 Catch:{ all -> 0x01e4 }
        r0 = r22;
        r3 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r3 = r3.zztt;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzcl(r3);	 Catch:{ all -> 0x01e4 }
        if (r2 != 0) goto L_0x014d;
    L_0x013d:
        r2 = r34.zzls();	 Catch:{ all -> 0x01e4 }
        r0 = r22;
        r3 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r3 = r3.zztt;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzcm(r3);	 Catch:{ all -> 0x01e4 }
        if (r2 == 0) goto L_0x0383;
    L_0x014d:
        r2 = 1;
    L_0x014e:
        if (r2 != 0) goto L_0x0ecc;
    L_0x0150:
        r2 = "_err";
        r3 = r12.name;	 Catch:{ all -> 0x01e4 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x01e4 }
        if (r2 != 0) goto L_0x0ecc;
    L_0x015a:
        r0 = r34;
        r2 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzgr();	 Catch:{ all -> 0x01e4 }
        r0 = r22;
        r3 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r3 = r3.zztt;	 Catch:{ all -> 0x01e4 }
        r4 = 11;
        r5 = "_ev";
        r6 = r12.name;	 Catch:{ all -> 0x01e4 }
        r7 = 0;
        r2.zza(r3, r4, r5, r6, r7);	 Catch:{ all -> 0x01e4 }
        r2 = r13;
        r4 = r14;
        r6 = r16;
        r5 = r15;
        r8 = r18;
    L_0x0179:
        r3 = r19 + 1;
        r19 = r3;
        r13 = r2;
        r14 = r4;
        r16 = r6;
        r15 = r5;
        r18 = r8;
        goto L_0x00d8;
    L_0x0186:
        r5 = 1;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0ea1 }
        r6 = 0;
        r7 = java.lang.String.valueOf(r36);	 Catch:{ SQLiteException -> 0x0ea1 }
        r5[r6] = r7;	 Catch:{ SQLiteException -> 0x0ea1 }
        r6 = r5;
        goto L_0x0049;
    L_0x0193:
        r5 = "";
        goto L_0x0051;
    L_0x0197:
        r5 = 0;
        r4 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x0ea1 }
        r5 = 1;
        r5 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x0ea1 }
        r3.close();	 Catch:{ SQLiteException -> 0x0ea1 }
        r13 = r5;
        r11 = r3;
        r12 = r4;
    L_0x01a7:
        r3 = "raw_events_metadata";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r5 = 0;
        r6 = "metadata";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r5 = "app_id = ? and metadata_fingerprint = ?";
        r6 = 2;
        r6 = new java.lang.String[r6];	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r7 = 0;
        r6[r7] = r12;	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r7 = 1;
        r6[r7] = r13;	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r7 = 0;
        r8 = 0;
        r9 = "rowid";
        r10 = "2";
        r11 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r3 = r11.moveToFirst();	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        if (r3 != 0) goto L_0x0257;
    L_0x01cc:
        r2 = r14.zzgt();	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r2 = r2.zzjg();	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r3 = "Raw event metadata record is missing. appId";
        r4 = com.google.android.gms.measurement.internal.zzas.zzbw(r12);	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r2.zzg(r3, r4);	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        if (r11 == 0) goto L_0x0083;
    L_0x01df:
        r11.close();	 Catch:{ all -> 0x01e4 }
        goto L_0x0083;
    L_0x01e4:
        r2 = move-exception;
        r3 = r34.zzjt();
        r3.endTransaction();
        throw r2;
    L_0x01ed:
        r6 = -1;
        r5 = (r16 > r6 ? 1 : (r16 == r6 ? 0 : -1));
        if (r5 == 0) goto L_0x023e;
    L_0x01f3:
        r5 = 2;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0ea1 }
        r6 = 0;
        r7 = 0;
        r5[r6] = r7;	 Catch:{ SQLiteException -> 0x0ea1 }
        r6 = 1;
        r7 = java.lang.String.valueOf(r16);	 Catch:{ SQLiteException -> 0x0ea1 }
        r5[r6] = r7;	 Catch:{ SQLiteException -> 0x0ea1 }
        r6 = r5;
    L_0x0202:
        r8 = -1;
        r5 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1));
        if (r5 == 0) goto L_0x0247;
    L_0x0208:
        r5 = " and rowid <= ?";
    L_0x020a:
        r7 = java.lang.String.valueOf(r5);	 Catch:{ SQLiteException -> 0x0ea1 }
        r7 = r7.length();	 Catch:{ SQLiteException -> 0x0ea1 }
        r7 = r7 + 84;
        r8 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0ea1 }
        r8.<init>(r7);	 Catch:{ SQLiteException -> 0x0ea1 }
        r7 = "select metadata_fingerprint from raw_events where app_id = ?";
        r7 = r8.append(r7);	 Catch:{ SQLiteException -> 0x0ea1 }
        r5 = r7.append(r5);	 Catch:{ SQLiteException -> 0x0ea1 }
        r7 = " order by rowid limit 1;";
        r5 = r5.append(r7);	 Catch:{ SQLiteException -> 0x0ea1 }
        r5 = r5.toString();	 Catch:{ SQLiteException -> 0x0ea1 }
        r3 = r2.rawQuery(r5, r6);	 Catch:{ SQLiteException -> 0x0ea1 }
        r5 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x0ea1 }
        if (r5 != 0) goto L_0x024a;
    L_0x0237:
        if (r3 == 0) goto L_0x0083;
    L_0x0239:
        r3.close();	 Catch:{ all -> 0x01e4 }
        goto L_0x0083;
    L_0x023e:
        r5 = 1;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0ea1 }
        r6 = 0;
        r7 = 0;
        r5[r6] = r7;	 Catch:{ SQLiteException -> 0x0ea1 }
        r6 = r5;
        goto L_0x0202;
    L_0x0247:
        r5 = "";
        goto L_0x020a;
    L_0x024a:
        r5 = 0;
        r5 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x0ea1 }
        r3.close();	 Catch:{ SQLiteException -> 0x0ea1 }
        r13 = r5;
        r11 = r3;
        r12 = r4;
        goto L_0x01a7;
    L_0x0257:
        r3 = 0;
        r3 = r11.getBlob(r3);	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r4 = 0;
        r5 = r3.length;	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r3 = com.google.android.gms.internal.measurement.zzxz.zzj(r3, r4, r5);	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r4 = new com.google.android.gms.internal.measurement.zzfw;	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r4.<init>();	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r4.zza(r3);	 Catch:{ IOException -> 0x02e1 }
        r3 = r11.moveToNext();	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        if (r3 == 0) goto L_0x0281;
    L_0x0270:
        r3 = r14.zzgt();	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r3 = r3.zzjj();	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r5 = "Get multiple raw event metadata records, expected one. appId";
        r6 = com.google.android.gms.measurement.internal.zzas.zzbw(r12);	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r3.zzg(r5, r6);	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
    L_0x0281:
        r11.close();	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r0 = r22;
        r0.zzb(r4);	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r4 = -1;
        r3 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1));
        if (r3 == 0) goto L_0x02fa;
    L_0x028f:
        r5 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
        r3 = 3;
        r6 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r3 = 0;
        r6[r3] = r12;	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r3 = 1;
        r6[r3] = r13;	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r3 = 2;
        r4 = java.lang.String.valueOf(r16);	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r6[r3] = r4;	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
    L_0x02a1:
        r3 = "raw_events";
        r4 = 4;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r7 = 0;
        r8 = "rowid";
        r4[r7] = r8;	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r7 = 1;
        r8 = "name";
        r4[r7] = r8;	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r7 = 2;
        r8 = "timestamp";
        r4[r7] = r8;	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r7 = 3;
        r8 = "data";
        r4[r7] = r8;	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r7 = 0;
        r8 = 0;
        r9 = "rowid";
        r10 = 0;
        r3 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r2 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x0ea4 }
        if (r2 != 0) goto L_0x0321;
    L_0x02c9:
        r2 = r14.zzgt();	 Catch:{ SQLiteException -> 0x0ea4 }
        r2 = r2.zzjj();	 Catch:{ SQLiteException -> 0x0ea4 }
        r4 = "Raw event data disappeared while in transaction. appId";
        r5 = com.google.android.gms.measurement.internal.zzas.zzbw(r12);	 Catch:{ SQLiteException -> 0x0ea4 }
        r2.zzg(r4, r5);	 Catch:{ SQLiteException -> 0x0ea4 }
        if (r3 == 0) goto L_0x0083;
    L_0x02dc:
        r3.close();	 Catch:{ all -> 0x01e4 }
        goto L_0x0083;
    L_0x02e1:
        r2 = move-exception;
        r3 = r14.zzgt();	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r3 = r3.zzjg();	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r4 = "Data loss. Failed to merge raw event metadata. appId";
        r5 = com.google.android.gms.measurement.internal.zzas.zzbw(r12);	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r3.zze(r4, r5, r2);	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        if (r11 == 0) goto L_0x0083;
    L_0x02f5:
        r11.close();	 Catch:{ all -> 0x01e4 }
        goto L_0x0083;
    L_0x02fa:
        r5 = "app_id = ? and metadata_fingerprint = ?";
        r3 = 2;
        r6 = new java.lang.String[r3];	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r3 = 0;
        r6[r3] = r12;	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        r3 = 1;
        r6[r3] = r13;	 Catch:{ SQLiteException -> 0x0306, all -> 0x0e9d }
        goto L_0x02a1;
    L_0x0306:
        r2 = move-exception;
        r3 = r11;
        r4 = r12;
    L_0x0309:
        r5 = r14.zzgt();	 Catch:{ all -> 0x0379 }
        r5 = r5.zzjg();	 Catch:{ all -> 0x0379 }
        r6 = "Data loss. Error selecting raw event. appId";
        r4 = com.google.android.gms.measurement.internal.zzas.zzbw(r4);	 Catch:{ all -> 0x0379 }
        r5.zze(r6, r4, r2);	 Catch:{ all -> 0x0379 }
        if (r3 == 0) goto L_0x0083;
    L_0x031c:
        r3.close();	 Catch:{ all -> 0x01e4 }
        goto L_0x0083;
    L_0x0321:
        r2 = 0;
        r4 = r3.getLong(r2);	 Catch:{ SQLiteException -> 0x0ea4 }
        r2 = 3;
        r2 = r3.getBlob(r2);	 Catch:{ SQLiteException -> 0x0ea4 }
        r6 = 0;
        r7 = r2.length;	 Catch:{ SQLiteException -> 0x0ea4 }
        r2 = com.google.android.gms.internal.measurement.zzxz.zzj(r2, r6, r7);	 Catch:{ SQLiteException -> 0x0ea4 }
        r6 = new com.google.android.gms.internal.measurement.zzft;	 Catch:{ SQLiteException -> 0x0ea4 }
        r6.<init>();	 Catch:{ SQLiteException -> 0x0ea4 }
        r6.zza(r2);	 Catch:{ IOException -> 0x035a }
        r2 = 1;
        r2 = r3.getString(r2);	 Catch:{ SQLiteException -> 0x0ea4 }
        r6.name = r2;	 Catch:{ SQLiteException -> 0x0ea4 }
        r2 = 2;
        r8 = r3.getLong(r2);	 Catch:{ SQLiteException -> 0x0ea4 }
        r2 = java.lang.Long.valueOf(r8);	 Catch:{ SQLiteException -> 0x0ea4 }
        r6.zzaxb = r2;	 Catch:{ SQLiteException -> 0x0ea4 }
        r0 = r22;
        r2 = r0.zza(r4, r6);	 Catch:{ SQLiteException -> 0x0ea4 }
        if (r2 != 0) goto L_0x036c;
    L_0x0353:
        if (r3 == 0) goto L_0x0083;
    L_0x0355:
        r3.close();	 Catch:{ all -> 0x01e4 }
        goto L_0x0083;
    L_0x035a:
        r2 = move-exception;
        r4 = r14.zzgt();	 Catch:{ SQLiteException -> 0x0ea4 }
        r4 = r4.zzjg();	 Catch:{ SQLiteException -> 0x0ea4 }
        r5 = "Data loss. Failed to merge raw event. appId";
        r6 = com.google.android.gms.measurement.internal.zzas.zzbw(r12);	 Catch:{ SQLiteException -> 0x0ea4 }
        r4.zze(r5, r6, r2);	 Catch:{ SQLiteException -> 0x0ea4 }
    L_0x036c:
        r2 = r3.moveToNext();	 Catch:{ SQLiteException -> 0x0ea4 }
        if (r2 != 0) goto L_0x0321;
    L_0x0372:
        if (r3 == 0) goto L_0x0083;
    L_0x0374:
        r3.close();	 Catch:{ all -> 0x01e4 }
        goto L_0x0083;
    L_0x0379:
        r2 = move-exception;
    L_0x037a:
        if (r3 == 0) goto L_0x037f;
    L_0x037c:
        r3.close();	 Catch:{ all -> 0x01e4 }
    L_0x037f:
        throw r2;	 Catch:{ all -> 0x01e4 }
    L_0x0380:
        r2 = 0;
        goto L_0x0094;
    L_0x0383:
        r2 = 0;
        goto L_0x014e;
    L_0x0386:
        r2 = r34.zzls();	 Catch:{ all -> 0x01e4 }
        r0 = r22;
        r3 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r3 = r3.zztt;	 Catch:{ all -> 0x01e4 }
        r4 = r12.name;	 Catch:{ all -> 0x01e4 }
        r24 = r2.zzp(r3, r4);	 Catch:{ all -> 0x01e4 }
        if (r24 != 0) goto L_0x03ae;
    L_0x0398:
        r34.zzjr();	 Catch:{ all -> 0x01e4 }
        r3 = r12.name;	 Catch:{ all -> 0x01e4 }
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3);	 Catch:{ all -> 0x01e4 }
        r2 = -1;
        r4 = r3.hashCode();	 Catch:{ all -> 0x01e4 }
        switch(r4) {
            case 94660: goto L_0x03da;
            case 95025: goto L_0x03ee;
            case 95027: goto L_0x03e4;
            default: goto L_0x03a8;
        };	 Catch:{ all -> 0x01e4 }
    L_0x03a8:
        switch(r2) {
            case 0: goto L_0x03f8;
            case 1: goto L_0x03f8;
            case 2: goto L_0x03f8;
            default: goto L_0x03ab;
        };	 Catch:{ all -> 0x01e4 }
    L_0x03ab:
        r2 = 0;
    L_0x03ac:
        if (r2 == 0) goto L_0x05f0;
    L_0x03ae:
        r4 = 0;
        r3 = 0;
        r2 = r12.zzaxa;	 Catch:{ all -> 0x01e4 }
        if (r2 != 0) goto L_0x03b9;
    L_0x03b4:
        r2 = 0;
        r2 = new com.google.android.gms.internal.measurement.zzfu[r2];	 Catch:{ all -> 0x01e4 }
        r12.zzaxa = r2;	 Catch:{ all -> 0x01e4 }
    L_0x03b9:
        r6 = r12.zzaxa;	 Catch:{ all -> 0x01e4 }
        r7 = r6.length;	 Catch:{ all -> 0x01e4 }
        r2 = 0;
        r5 = r2;
    L_0x03be:
        if (r5 >= r7) goto L_0x040e;
    L_0x03c0:
        r2 = r6[r5];	 Catch:{ all -> 0x01e4 }
        r8 = "_c";
        r9 = r2.name;	 Catch:{ all -> 0x01e4 }
        r8 = r8.equals(r9);	 Catch:{ all -> 0x01e4 }
        if (r8 == 0) goto L_0x03fa;
    L_0x03cc:
        r8 = 1;
        r4 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x01e4 }
        r2.zzaxe = r4;	 Catch:{ all -> 0x01e4 }
        r4 = 1;
        r2 = r3;
    L_0x03d6:
        r5 = r5 + 1;
        r3 = r2;
        goto L_0x03be;
    L_0x03da:
        r4 = "_in";
        r3 = r3.equals(r4);	 Catch:{ all -> 0x01e4 }
        if (r3 == 0) goto L_0x03a8;
    L_0x03e2:
        r2 = 0;
        goto L_0x03a8;
    L_0x03e4:
        r4 = "_ui";
        r3 = r3.equals(r4);	 Catch:{ all -> 0x01e4 }
        if (r3 == 0) goto L_0x03a8;
    L_0x03ec:
        r2 = 1;
        goto L_0x03a8;
    L_0x03ee:
        r4 = "_ug";
        r3 = r3.equals(r4);	 Catch:{ all -> 0x01e4 }
        if (r3 == 0) goto L_0x03a8;
    L_0x03f6:
        r2 = 2;
        goto L_0x03a8;
    L_0x03f8:
        r2 = 1;
        goto L_0x03ac;
    L_0x03fa:
        r8 = "_r";
        r9 = r2.name;	 Catch:{ all -> 0x01e4 }
        r8 = r8.equals(r9);	 Catch:{ all -> 0x01e4 }
        if (r8 == 0) goto L_0x0ec9;
    L_0x0404:
        r8 = 1;
        r3 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x01e4 }
        r2.zzaxe = r3;	 Catch:{ all -> 0x01e4 }
        r2 = 1;
        goto L_0x03d6;
    L_0x040e:
        if (r4 != 0) goto L_0x0456;
    L_0x0410:
        if (r24 == 0) goto L_0x0456;
    L_0x0412:
        r0 = r34;
        r2 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzgt();	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzjo();	 Catch:{ all -> 0x01e4 }
        r4 = "Marking event as conversion";
        r0 = r34;
        r5 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r5 = r5.zzgq();	 Catch:{ all -> 0x01e4 }
        r6 = r12.name;	 Catch:{ all -> 0x01e4 }
        r5 = r5.zzbt(r6);	 Catch:{ all -> 0x01e4 }
        r2.zzg(r4, r5);	 Catch:{ all -> 0x01e4 }
        r2 = r12.zzaxa;	 Catch:{ all -> 0x01e4 }
        r4 = r12.zzaxa;	 Catch:{ all -> 0x01e4 }
        r4 = r4.length;	 Catch:{ all -> 0x01e4 }
        r4 = r4 + 1;
        r2 = java.util.Arrays.copyOf(r2, r4);	 Catch:{ all -> 0x01e4 }
        r2 = (com.google.android.gms.internal.measurement.zzfu[]) r2;	 Catch:{ all -> 0x01e4 }
        r4 = new com.google.android.gms.internal.measurement.zzfu;	 Catch:{ all -> 0x01e4 }
        r4.<init>();	 Catch:{ all -> 0x01e4 }
        r5 = "_c";
        r4.name = r5;	 Catch:{ all -> 0x01e4 }
        r6 = 1;
        r5 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x01e4 }
        r4.zzaxe = r5;	 Catch:{ all -> 0x01e4 }
        r5 = r2.length;	 Catch:{ all -> 0x01e4 }
        r5 = r5 + -1;
        r2[r5] = r4;	 Catch:{ all -> 0x01e4 }
        r12.zzaxa = r2;	 Catch:{ all -> 0x01e4 }
    L_0x0456:
        if (r3 != 0) goto L_0x049c;
    L_0x0458:
        r0 = r34;
        r2 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzgt();	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzjo();	 Catch:{ all -> 0x01e4 }
        r3 = "Marking event as real-time";
        r0 = r34;
        r4 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r4 = r4.zzgq();	 Catch:{ all -> 0x01e4 }
        r5 = r12.name;	 Catch:{ all -> 0x01e4 }
        r4 = r4.zzbt(r5);	 Catch:{ all -> 0x01e4 }
        r2.zzg(r3, r4);	 Catch:{ all -> 0x01e4 }
        r2 = r12.zzaxa;	 Catch:{ all -> 0x01e4 }
        r3 = r12.zzaxa;	 Catch:{ all -> 0x01e4 }
        r3 = r3.length;	 Catch:{ all -> 0x01e4 }
        r3 = r3 + 1;
        r2 = java.util.Arrays.copyOf(r2, r3);	 Catch:{ all -> 0x01e4 }
        r2 = (com.google.android.gms.internal.measurement.zzfu[]) r2;	 Catch:{ all -> 0x01e4 }
        r3 = new com.google.android.gms.internal.measurement.zzfu;	 Catch:{ all -> 0x01e4 }
        r3.<init>();	 Catch:{ all -> 0x01e4 }
        r4 = "_r";
        r3.name = r4;	 Catch:{ all -> 0x01e4 }
        r4 = 1;
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x01e4 }
        r3.zzaxe = r4;	 Catch:{ all -> 0x01e4 }
        r4 = r2.length;	 Catch:{ all -> 0x01e4 }
        r4 = r4 + -1;
        r2[r4] = r3;	 Catch:{ all -> 0x01e4 }
        r12.zzaxa = r2;	 Catch:{ all -> 0x01e4 }
    L_0x049c:
        r2 = 1;
        r3 = r34.zzjt();	 Catch:{ all -> 0x01e4 }
        r4 = r34.zzly();	 Catch:{ all -> 0x01e4 }
        r0 = r22;
        r6 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r6 = r6.zztt;	 Catch:{ all -> 0x01e4 }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r11 = 1;
        r3 = r3.zza(r4, r6, r7, r8, r9, r10, r11);	 Catch:{ all -> 0x01e4 }
        r4 = r3.zzahl;	 Catch:{ all -> 0x01e4 }
        r0 = r34;
        r3 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r3 = r3.zzgv();	 Catch:{ all -> 0x01e4 }
        r0 = r22;
        r6 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r6 = r6.zztt;	 Catch:{ all -> 0x01e4 }
        r3 = r3.zzaq(r6);	 Catch:{ all -> 0x01e4 }
        r6 = (long) r3;	 Catch:{ all -> 0x01e4 }
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 <= 0) goto L_0x0ec5;
    L_0x04cd:
        r2 = 0;
    L_0x04ce:
        r3 = r12.zzaxa;	 Catch:{ all -> 0x01e4 }
        r3 = r3.length;	 Catch:{ all -> 0x01e4 }
        if (r2 >= r3) goto L_0x04ff;
    L_0x04d3:
        r3 = "_r";
        r4 = r12.zzaxa;	 Catch:{ all -> 0x01e4 }
        r4 = r4[r2];	 Catch:{ all -> 0x01e4 }
        r4 = r4.name;	 Catch:{ all -> 0x01e4 }
        r3 = r3.equals(r4);	 Catch:{ all -> 0x01e4 }
        if (r3 == 0) goto L_0x056f;
    L_0x04e1:
        r3 = r12.zzaxa;	 Catch:{ all -> 0x01e4 }
        r3 = r3.length;	 Catch:{ all -> 0x01e4 }
        r3 = r3 + -1;
        r3 = new com.google.android.gms.internal.measurement.zzfu[r3];	 Catch:{ all -> 0x01e4 }
        if (r2 <= 0) goto L_0x04f1;
    L_0x04ea:
        r4 = r12.zzaxa;	 Catch:{ all -> 0x01e4 }
        r5 = 0;
        r6 = 0;
        java.lang.System.arraycopy(r4, r5, r3, r6, r2);	 Catch:{ all -> 0x01e4 }
    L_0x04f1:
        r4 = r3.length;	 Catch:{ all -> 0x01e4 }
        if (r2 >= r4) goto L_0x04fd;
    L_0x04f4:
        r4 = r12.zzaxa;	 Catch:{ all -> 0x01e4 }
        r5 = r2 + 1;
        r6 = r3.length;	 Catch:{ all -> 0x01e4 }
        r6 = r6 - r2;
        java.lang.System.arraycopy(r4, r5, r3, r2, r6);	 Catch:{ all -> 0x01e4 }
    L_0x04fd:
        r12.zzaxa = r3;	 Catch:{ all -> 0x01e4 }
    L_0x04ff:
        r2 = r12.name;	 Catch:{ all -> 0x01e4 }
        r2 = com.google.android.gms.measurement.internal.zzfy.zzct(r2);	 Catch:{ all -> 0x01e4 }
        if (r2 == 0) goto L_0x05f0;
    L_0x0507:
        if (r24 == 0) goto L_0x05f0;
    L_0x0509:
        r3 = r34.zzjt();	 Catch:{ all -> 0x01e4 }
        r4 = r34.zzly();	 Catch:{ all -> 0x01e4 }
        r0 = r22;
        r2 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r6 = r2.zztt;	 Catch:{ all -> 0x01e4 }
        r7 = 0;
        r8 = 0;
        r9 = 1;
        r10 = 0;
        r11 = 0;
        r2 = r3.zza(r4, r6, r7, r8, r9, r10, r11);	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzahj;	 Catch:{ all -> 0x01e4 }
        r0 = r34;
        r4 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r4 = r4.zzgv();	 Catch:{ all -> 0x01e4 }
        r0 = r22;
        r5 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r5 = r5.zztt;	 Catch:{ all -> 0x01e4 }
        r6 = com.google.android.gms.measurement.internal.zzai.zzajh;	 Catch:{ all -> 0x01e4 }
        r4 = r4.zzb(r5, r6);	 Catch:{ all -> 0x01e4 }
        r4 = (long) r4;	 Catch:{ all -> 0x01e4 }
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x05f0;
    L_0x053b:
        r0 = r34;
        r2 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzgt();	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzjj();	 Catch:{ all -> 0x01e4 }
        r3 = "Too many conversions. Not logging as conversion. appId";
        r0 = r22;
        r4 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r4 = r4.zztt;	 Catch:{ all -> 0x01e4 }
        r4 = com.google.android.gms.measurement.internal.zzas.zzbw(r4);	 Catch:{ all -> 0x01e4 }
        r2.zzg(r3, r4);	 Catch:{ all -> 0x01e4 }
        r4 = 0;
        r3 = 0;
        r6 = r12.zzaxa;	 Catch:{ all -> 0x01e4 }
        r7 = r6.length;	 Catch:{ all -> 0x01e4 }
        r2 = 0;
        r5 = r2;
    L_0x055d:
        if (r5 >= r7) goto L_0x0580;
    L_0x055f:
        r2 = r6[r5];	 Catch:{ all -> 0x01e4 }
        r8 = "_c";
        r9 = r2.name;	 Catch:{ all -> 0x01e4 }
        r8 = r8.equals(r9);	 Catch:{ all -> 0x01e4 }
        if (r8 == 0) goto L_0x0573;
    L_0x056b:
        r5 = r5 + 1;
        r3 = r2;
        goto L_0x055d;
    L_0x056f:
        r2 = r2 + 1;
        goto L_0x04ce;
    L_0x0573:
        r8 = "_err";
        r2 = r2.name;	 Catch:{ all -> 0x01e4 }
        r2 = r8.equals(r2);	 Catch:{ all -> 0x01e4 }
        if (r2 == 0) goto L_0x0ec2;
    L_0x057d:
        r4 = 1;
        r2 = r3;
        goto L_0x056b;
    L_0x0580:
        if (r4 == 0) goto L_0x05c4;
    L_0x0582:
        if (r3 == 0) goto L_0x05c4;
    L_0x0584:
        r2 = r12.zzaxa;	 Catch:{ all -> 0x01e4 }
        r4 = 1;
        r4 = new com.google.android.gms.internal.measurement.zzfu[r4];	 Catch:{ all -> 0x01e4 }
        r5 = 0;
        r4[r5] = r3;	 Catch:{ all -> 0x01e4 }
        r2 = com.google.android.gms.common.util.ArrayUtils.removeAll(r2, r4);	 Catch:{ all -> 0x01e4 }
        r2 = (com.google.android.gms.internal.measurement.zzfu[]) r2;	 Catch:{ all -> 0x01e4 }
        r12.zzaxa = r2;	 Catch:{ all -> 0x01e4 }
        r8 = r18;
    L_0x0596:
        r0 = r34;
        r2 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzgv();	 Catch:{ all -> 0x01e4 }
        r0 = r22;
        r3 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r3 = r3.zztt;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzbd(r3);	 Catch:{ all -> 0x01e4 }
        if (r2 == 0) goto L_0x0635;
    L_0x05aa:
        if (r24 == 0) goto L_0x0635;
    L_0x05ac:
        r5 = r12.zzaxa;	 Catch:{ all -> 0x01e4 }
        r4 = -1;
        r2 = -1;
        r3 = 0;
    L_0x05b1:
        r6 = r5.length;	 Catch:{ all -> 0x01e4 }
        if (r3 >= r6) goto L_0x0601;
    L_0x05b4:
        r6 = "value";
        r7 = r5[r3];	 Catch:{ all -> 0x01e4 }
        r7 = r7.name;	 Catch:{ all -> 0x01e4 }
        r6 = r6.equals(r7);	 Catch:{ all -> 0x01e4 }
        if (r6 == 0) goto L_0x05f3;
    L_0x05c0:
        r4 = r3;
    L_0x05c1:
        r3 = r3 + 1;
        goto L_0x05b1;
    L_0x05c4:
        if (r3 == 0) goto L_0x05d5;
    L_0x05c6:
        r2 = "_err";
        r3.name = r2;	 Catch:{ all -> 0x01e4 }
        r4 = 10;
        r2 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x01e4 }
        r3.zzaxe = r2;	 Catch:{ all -> 0x01e4 }
        r8 = r18;
        goto L_0x0596;
    L_0x05d5:
        r0 = r34;
        r2 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzgt();	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzjg();	 Catch:{ all -> 0x01e4 }
        r3 = "Did not find conversion parameter. appId";
        r0 = r22;
        r4 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r4 = r4.zztt;	 Catch:{ all -> 0x01e4 }
        r4 = com.google.android.gms.measurement.internal.zzas.zzbw(r4);	 Catch:{ all -> 0x01e4 }
        r2.zzg(r3, r4);	 Catch:{ all -> 0x01e4 }
    L_0x05f0:
        r8 = r18;
        goto L_0x0596;
    L_0x05f3:
        r6 = "currency";
        r7 = r5[r3];	 Catch:{ all -> 0x01e4 }
        r7 = r7.name;	 Catch:{ all -> 0x01e4 }
        r6 = r6.equals(r7);	 Catch:{ all -> 0x01e4 }
        if (r6 == 0) goto L_0x05c1;
    L_0x05ff:
        r2 = r3;
        goto L_0x05c1;
    L_0x0601:
        r3 = -1;
        if (r4 == r3) goto L_0x0ebc;
    L_0x0604:
        r3 = r5[r4];	 Catch:{ all -> 0x01e4 }
        r3 = r3.zzaxe;	 Catch:{ all -> 0x01e4 }
        if (r3 != 0) goto L_0x06c4;
    L_0x060a:
        r3 = r5[r4];	 Catch:{ all -> 0x01e4 }
        r3 = r3.zzaun;	 Catch:{ all -> 0x01e4 }
        if (r3 != 0) goto L_0x06c4;
    L_0x0610:
        r0 = r34;
        r2 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzgt();	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzjl();	 Catch:{ all -> 0x01e4 }
        r3 = "Value must be specified with a numeric type.";
        r2.zzby(r3);	 Catch:{ all -> 0x01e4 }
        r2 = zza(r5, r4);	 Catch:{ all -> 0x01e4 }
        r3 = "_c";
        r2 = zza(r2, r3);	 Catch:{ all -> 0x01e4 }
        r3 = 18;
        r4 = "value";
        r2 = zza(r2, r3, r4);	 Catch:{ all -> 0x01e4 }
    L_0x0633:
        r12.zzaxa = r2;	 Catch:{ all -> 0x01e4 }
    L_0x0635:
        r0 = r34;
        r2 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzgv();	 Catch:{ all -> 0x01e4 }
        r0 = r22;
        r3 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r3 = r3.zztt;	 Catch:{ all -> 0x01e4 }
        r4 = com.google.android.gms.measurement.internal.zzai.zzakz;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zze(r3, r4);	 Catch:{ all -> 0x01e4 }
        if (r2 == 0) goto L_0x0eb8;
    L_0x064b:
        r2 = "_e";
        r3 = r12.name;	 Catch:{ all -> 0x01e4 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x01e4 }
        if (r2 == 0) goto L_0x0720;
    L_0x0655:
        r34.zzjr();	 Catch:{ all -> 0x01e4 }
        r2 = "_fr";
        r2 = com.google.android.gms.measurement.internal.zzfu.zza(r12, r2);	 Catch:{ all -> 0x01e4 }
        if (r2 != 0) goto L_0x0eb8;
    L_0x0660:
        if (r13 == 0) goto L_0x071c;
    L_0x0662:
        r2 = r13.zzaxb;	 Catch:{ all -> 0x01e4 }
        r2 = r2.longValue();	 Catch:{ all -> 0x01e4 }
        r4 = r12.zzaxb;	 Catch:{ all -> 0x01e4 }
        r4 = r4.longValue();	 Catch:{ all -> 0x01e4 }
        r2 = r2 - r4;
        r2 = java.lang.Math.abs(r2);	 Catch:{ all -> 0x01e4 }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 > 0) goto L_0x071c;
    L_0x0679:
        r0 = r34;
        r2 = r0.zza(r12, r13);	 Catch:{ all -> 0x01e4 }
        if (r2 == 0) goto L_0x0718;
    L_0x0681:
        r14 = 0;
        r13 = 0;
        r3 = r13;
        r4 = r14;
    L_0x0685:
        if (r20 == 0) goto L_0x0ed5;
    L_0x0687:
        if (r21 != 0) goto L_0x0ed5;
    L_0x0689:
        r2 = "_e";
        r5 = r12.name;	 Catch:{ all -> 0x01e4 }
        r2 = r2.equals(r5);	 Catch:{ all -> 0x01e4 }
        if (r2 == 0) goto L_0x0ed5;
    L_0x0693:
        r2 = r12.zzaxa;	 Catch:{ all -> 0x01e4 }
        if (r2 == 0) goto L_0x069c;
    L_0x0697:
        r2 = r12.zzaxa;	 Catch:{ all -> 0x01e4 }
        r2 = r2.length;	 Catch:{ all -> 0x01e4 }
        if (r2 != 0) goto L_0x0764;
    L_0x069c:
        r0 = r34;
        r2 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzgt();	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzjj();	 Catch:{ all -> 0x01e4 }
        r5 = "Engagement event does not contain any parameters. appId";
        r0 = r22;
        r6 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r6 = r6.zztt;	 Catch:{ all -> 0x01e4 }
        r6 = com.google.android.gms.measurement.internal.zzas.zzbw(r6);	 Catch:{ all -> 0x01e4 }
        r2.zzg(r5, r6);	 Catch:{ all -> 0x01e4 }
        r6 = r16;
    L_0x06b9:
        r0 = r23;
        r2 = r0.zzaxi;	 Catch:{ all -> 0x01e4 }
        r5 = r15 + 1;
        r2[r15] = r12;	 Catch:{ all -> 0x01e4 }
        r2 = r3;
        goto L_0x0179;
    L_0x06c4:
        r3 = 0;
        r6 = -1;
        if (r2 != r6) goto L_0x06f0;
    L_0x06c8:
        r2 = 1;
    L_0x06c9:
        if (r2 == 0) goto L_0x0ebc;
    L_0x06cb:
        r0 = r34;
        r2 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzgt();	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzjl();	 Catch:{ all -> 0x01e4 }
        r3 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.";
        r2.zzby(r3);	 Catch:{ all -> 0x01e4 }
        r2 = zza(r5, r4);	 Catch:{ all -> 0x01e4 }
        r3 = "_c";
        r2 = zza(r2, r3);	 Catch:{ all -> 0x01e4 }
        r3 = 19;
        r4 = "currency";
        r2 = zza(r2, r3, r4);	 Catch:{ all -> 0x01e4 }
        goto L_0x0633;
    L_0x06f0:
        r2 = r5[r2];	 Catch:{ all -> 0x01e4 }
        r6 = r2.zzaml;	 Catch:{ all -> 0x01e4 }
        if (r6 == 0) goto L_0x06fd;
    L_0x06f6:
        r2 = r6.length();	 Catch:{ all -> 0x01e4 }
        r7 = 3;
        if (r2 == r7) goto L_0x06ff;
    L_0x06fd:
        r2 = 1;
        goto L_0x06c9;
    L_0x06ff:
        r2 = 0;
    L_0x0700:
        r7 = r6.length();	 Catch:{ all -> 0x01e4 }
        if (r2 >= r7) goto L_0x0ebf;
    L_0x0706:
        r7 = r6.codePointAt(r2);	 Catch:{ all -> 0x01e4 }
        r9 = java.lang.Character.isLetter(r7);	 Catch:{ all -> 0x01e4 }
        if (r9 != 0) goto L_0x0712;
    L_0x0710:
        r2 = 1;
        goto L_0x06c9;
    L_0x0712:
        r7 = java.lang.Character.charCount(r7);	 Catch:{ all -> 0x01e4 }
        r2 = r2 + r7;
        goto L_0x0700;
    L_0x0718:
        r3 = r13;
        r4 = r12;
        goto L_0x0685;
    L_0x071c:
        r3 = r13;
        r4 = r12;
        goto L_0x0685;
    L_0x0720:
        r2 = "_vs";
        r3 = r12.name;	 Catch:{ all -> 0x01e4 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x01e4 }
        if (r2 == 0) goto L_0x0eb8;
    L_0x072a:
        r34.zzjr();	 Catch:{ all -> 0x01e4 }
        r2 = "_et";
        r2 = com.google.android.gms.measurement.internal.zzfu.zza(r12, r2);	 Catch:{ all -> 0x01e4 }
        if (r2 != 0) goto L_0x0eb8;
    L_0x0735:
        if (r14 == 0) goto L_0x0760;
    L_0x0737:
        r2 = r14.zzaxb;	 Catch:{ all -> 0x01e4 }
        r2 = r2.longValue();	 Catch:{ all -> 0x01e4 }
        r4 = r12.zzaxb;	 Catch:{ all -> 0x01e4 }
        r4 = r4.longValue();	 Catch:{ all -> 0x01e4 }
        r2 = r2 - r4;
        r2 = java.lang.Math.abs(r2);	 Catch:{ all -> 0x01e4 }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 > 0) goto L_0x0760;
    L_0x074e:
        r0 = r34;
        r2 = r0.zza(r14, r12);	 Catch:{ all -> 0x01e4 }
        if (r2 == 0) goto L_0x075c;
    L_0x0756:
        r14 = 0;
        r13 = 0;
        r3 = r13;
        r4 = r14;
        goto L_0x0685;
    L_0x075c:
        r3 = r12;
        r4 = r14;
        goto L_0x0685;
    L_0x0760:
        r3 = r12;
        r4 = r14;
        goto L_0x0685;
    L_0x0764:
        r34.zzjr();	 Catch:{ all -> 0x01e4 }
        r2 = "_et";
        r2 = com.google.android.gms.measurement.internal.zzfu.zzb(r12, r2);	 Catch:{ all -> 0x01e4 }
        r2 = (java.lang.Long) r2;	 Catch:{ all -> 0x01e4 }
        if (r2 != 0) goto L_0x0790;
    L_0x0771:
        r0 = r34;
        r2 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzgt();	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzjj();	 Catch:{ all -> 0x01e4 }
        r5 = "Engagement event does not include duration. appId";
        r0 = r22;
        r6 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r6 = r6.zztt;	 Catch:{ all -> 0x01e4 }
        r6 = com.google.android.gms.measurement.internal.zzas.zzbw(r6);	 Catch:{ all -> 0x01e4 }
        r2.zzg(r5, r6);	 Catch:{ all -> 0x01e4 }
        r6 = r16;
        goto L_0x06b9;
    L_0x0790:
        r6 = r2.longValue();	 Catch:{ all -> 0x01e4 }
        r16 = r16 + r6;
        r6 = r16;
        goto L_0x06b9;
    L_0x079a:
        if (r21 == 0) goto L_0x0eb5;
    L_0x079c:
        r2 = 0;
        r4 = r16;
        r3 = r15;
    L_0x07a0:
        if (r2 >= r3) goto L_0x07f6;
    L_0x07a2:
        r0 = r23;
        r6 = r0.zzaxi;	 Catch:{ all -> 0x01e4 }
        r6 = r6[r2];	 Catch:{ all -> 0x01e4 }
        r7 = "_e";
        r8 = r6.name;	 Catch:{ all -> 0x01e4 }
        r7 = r7.equals(r8);	 Catch:{ all -> 0x01e4 }
        if (r7 == 0) goto L_0x07d5;
    L_0x07b2:
        r34.zzjr();	 Catch:{ all -> 0x01e4 }
        r7 = "_fr";
        r7 = com.google.android.gms.measurement.internal.zzfu.zza(r6, r7);	 Catch:{ all -> 0x01e4 }
        if (r7 == 0) goto L_0x07d5;
    L_0x07bd:
        r0 = r23;
        r6 = r0.zzaxi;	 Catch:{ all -> 0x01e4 }
        r7 = r2 + 1;
        r0 = r23;
        r8 = r0.zzaxi;	 Catch:{ all -> 0x01e4 }
        r9 = r3 - r2;
        r9 = r9 + -1;
        java.lang.System.arraycopy(r6, r7, r8, r2, r9);	 Catch:{ all -> 0x01e4 }
        r3 = r3 + -1;
        r2 = r2 + -1;
    L_0x07d2:
        r2 = r2 + 1;
        goto L_0x07a0;
    L_0x07d5:
        if (r20 == 0) goto L_0x07d2;
    L_0x07d7:
        r34.zzjr();	 Catch:{ all -> 0x01e4 }
        r7 = "_et";
        r6 = com.google.android.gms.measurement.internal.zzfu.zza(r6, r7);	 Catch:{ all -> 0x01e4 }
        if (r6 == 0) goto L_0x07d2;
    L_0x07e2:
        r6 = r6.zzaxe;	 Catch:{ all -> 0x01e4 }
        if (r6 == 0) goto L_0x07d2;
    L_0x07e6:
        r8 = r6.longValue();	 Catch:{ all -> 0x01e4 }
        r10 = 0;
        r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r7 <= 0) goto L_0x07d2;
    L_0x07f0:
        r6 = r6.longValue();	 Catch:{ all -> 0x01e4 }
        r4 = r4 + r6;
        goto L_0x07d2;
    L_0x07f6:
        r16 = r4;
    L_0x07f8:
        r0 = r22;
        r2 = r0.zzaui;	 Catch:{ all -> 0x01e4 }
        r2 = r2.size();	 Catch:{ all -> 0x01e4 }
        if (r3 >= r2) goto L_0x0810;
    L_0x0802:
        r0 = r23;
        r2 = r0.zzaxi;	 Catch:{ all -> 0x01e4 }
        r2 = java.util.Arrays.copyOf(r2, r3);	 Catch:{ all -> 0x01e4 }
        r2 = (com.google.android.gms.internal.measurement.zzft[]) r2;	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r0.zzaxi = r2;	 Catch:{ all -> 0x01e4 }
    L_0x0810:
        if (r20 == 0) goto L_0x08cb;
    L_0x0812:
        r2 = r34.zzjt();	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r3 = r0.zztt;	 Catch:{ all -> 0x01e4 }
        r4 = "_lte";
        r8 = r2.zzi(r3, r4);	 Catch:{ all -> 0x01e4 }
        if (r8 == 0) goto L_0x0826;
    L_0x0822:
        r2 = r8.value;	 Catch:{ all -> 0x01e4 }
        if (r2 != 0) goto L_0x09b4;
    L_0x0826:
        r2 = new com.google.android.gms.measurement.internal.zzfx;	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r3 = r0.zztt;	 Catch:{ all -> 0x01e4 }
        r4 = "auto";
        r5 = "_lte";
        r0 = r34;
        r6 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r6 = r6.zzbx();	 Catch:{ all -> 0x01e4 }
        r6 = r6.currentTimeMillis();	 Catch:{ all -> 0x01e4 }
        r8 = java.lang.Long.valueOf(r16);	 Catch:{ all -> 0x01e4 }
        r2.<init>(r3, r4, r5, r6, r8);	 Catch:{ all -> 0x01e4 }
        r4 = r2;
    L_0x0844:
        r5 = new com.google.android.gms.internal.measurement.zzfz;	 Catch:{ all -> 0x01e4 }
        r5.<init>();	 Catch:{ all -> 0x01e4 }
        r2 = "_lte";
        r5.name = r2;	 Catch:{ all -> 0x01e4 }
        r0 = r34;
        r2 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzbx();	 Catch:{ all -> 0x01e4 }
        r2 = r2.currentTimeMillis();	 Catch:{ all -> 0x01e4 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x01e4 }
        r5.zzayu = r2;	 Catch:{ all -> 0x01e4 }
        r2 = r4.value;	 Catch:{ all -> 0x01e4 }
        r2 = (java.lang.Long) r2;	 Catch:{ all -> 0x01e4 }
        r5.zzaxe = r2;	 Catch:{ all -> 0x01e4 }
        r2 = 0;
        r3 = 0;
    L_0x0867:
        r0 = r23;
        r6 = r0.zzaxj;	 Catch:{ all -> 0x01e4 }
        r6 = r6.length;	 Catch:{ all -> 0x01e4 }
        if (r3 >= r6) goto L_0x0885;
    L_0x086e:
        r6 = "_lte";
        r0 = r23;
        r7 = r0.zzaxj;	 Catch:{ all -> 0x01e4 }
        r7 = r7[r3];	 Catch:{ all -> 0x01e4 }
        r7 = r7.name;	 Catch:{ all -> 0x01e4 }
        r6 = r6.equals(r7);	 Catch:{ all -> 0x01e4 }
        if (r6 == 0) goto L_0x09de;
    L_0x087e:
        r0 = r23;
        r2 = r0.zzaxj;	 Catch:{ all -> 0x01e4 }
        r2[r3] = r5;	 Catch:{ all -> 0x01e4 }
        r2 = 1;
    L_0x0885:
        if (r2 != 0) goto L_0x08ab;
    L_0x0887:
        r0 = r23;
        r2 = r0.zzaxj;	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r3 = r0.zzaxj;	 Catch:{ all -> 0x01e4 }
        r3 = r3.length;	 Catch:{ all -> 0x01e4 }
        r3 = r3 + 1;
        r2 = java.util.Arrays.copyOf(r2, r3);	 Catch:{ all -> 0x01e4 }
        r2 = (com.google.android.gms.internal.measurement.zzfz[]) r2;	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r0.zzaxj = r2;	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r2 = r0.zzaxj;	 Catch:{ all -> 0x01e4 }
        r0 = r22;
        r3 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r3 = r3.zzaxj;	 Catch:{ all -> 0x01e4 }
        r3 = r3.length;	 Catch:{ all -> 0x01e4 }
        r3 = r3 + -1;
        r2[r3] = r5;	 Catch:{ all -> 0x01e4 }
    L_0x08ab:
        r2 = 0;
        r2 = (r16 > r2 ? 1 : (r16 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x08cb;
    L_0x08b1:
        r2 = r34.zzjt();	 Catch:{ all -> 0x01e4 }
        r2.zza(r4);	 Catch:{ all -> 0x01e4 }
        r0 = r34;
        r2 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzgt();	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzjn();	 Catch:{ all -> 0x01e4 }
        r3 = "Updated lifetime engagement user property with value. Value";
        r4 = r4.value;	 Catch:{ all -> 0x01e4 }
        r2.zzg(r3, r4);	 Catch:{ all -> 0x01e4 }
    L_0x08cb:
        r0 = r23;
        r2 = r0.zztt;	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r3 = r0.zzaxj;	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r4 = r0.zzaxi;	 Catch:{ all -> 0x01e4 }
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2);	 Catch:{ all -> 0x01e4 }
        r5 = r34.zzjs();	 Catch:{ all -> 0x01e4 }
        r2 = r5.zza(r2, r4, r3);	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r0.zzaya = r2;	 Catch:{ all -> 0x01e4 }
        r0 = r34;
        r2 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzgv();	 Catch:{ all -> 0x01e4 }
        r0 = r22;
        r3 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r3 = r3.zztt;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzat(r3);	 Catch:{ all -> 0x01e4 }
        if (r2 == 0) goto L_0x0c92;
    L_0x08fa:
        r24 = new java.util.HashMap;	 Catch:{ all -> 0x01e4 }
        r24.<init>();	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r2 = r0.zzaxi;	 Catch:{ all -> 0x01e4 }
        r2 = r2.length;	 Catch:{ all -> 0x01e4 }
        r0 = new com.google.android.gms.internal.measurement.zzft[r2];	 Catch:{ all -> 0x01e4 }
        r25 = r0;
        r19 = 0;
        r0 = r34;
        r2 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzgr();	 Catch:{ all -> 0x01e4 }
        r26 = r2.zzmk();	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r0 = r0.zzaxi;	 Catch:{ all -> 0x01e4 }
        r27 = r0;
        r0 = r27;
        r0 = r0.length;	 Catch:{ all -> 0x01e4 }
        r28 = r0;
        r2 = 0;
        r20 = r2;
    L_0x0924:
        r0 = r20;
        r1 = r28;
        if (r0 >= r1) goto L_0x0c59;
    L_0x092a:
        r29 = r27[r20];	 Catch:{ all -> 0x01e4 }
        r0 = r29;
        r2 = r0.name;	 Catch:{ all -> 0x01e4 }
        r3 = "_ep";
        r2 = r2.equals(r3);	 Catch:{ all -> 0x01e4 }
        if (r2 == 0) goto L_0x09e2;
    L_0x0938:
        r34.zzjr();	 Catch:{ all -> 0x01e4 }
        r2 = "_en";
        r0 = r29;
        r2 = com.google.android.gms.measurement.internal.zzfu.zzb(r0, r2);	 Catch:{ all -> 0x01e4 }
        r2 = (java.lang.String) r2;	 Catch:{ all -> 0x01e4 }
        r0 = r24;
        r3 = r0.get(r2);	 Catch:{ all -> 0x01e4 }
        r3 = (com.google.android.gms.measurement.internal.zzac) r3;	 Catch:{ all -> 0x01e4 }
        if (r3 != 0) goto L_0x0962;
    L_0x094f:
        r3 = r34.zzjt();	 Catch:{ all -> 0x01e4 }
        r0 = r22;
        r4 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r4 = r4.zztt;	 Catch:{ all -> 0x01e4 }
        r3 = r3.zzg(r4, r2);	 Catch:{ all -> 0x01e4 }
        r0 = r24;
        r0.put(r2, r3);	 Catch:{ all -> 0x01e4 }
    L_0x0962:
        r2 = r3.zzaia;	 Catch:{ all -> 0x01e4 }
        if (r2 != 0) goto L_0x0c55;
    L_0x0966:
        r2 = r3.zzaib;	 Catch:{ all -> 0x01e4 }
        r4 = r2.longValue();	 Catch:{ all -> 0x01e4 }
        r6 = 1;
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x0985;
    L_0x0972:
        r34.zzjr();	 Catch:{ all -> 0x01e4 }
        r0 = r29;
        r2 = r0.zzaxa;	 Catch:{ all -> 0x01e4 }
        r4 = "_sr";
        r5 = r3.zzaib;	 Catch:{ all -> 0x01e4 }
        r2 = com.google.android.gms.measurement.internal.zzfu.zza(r2, r4, r5);	 Catch:{ all -> 0x01e4 }
        r0 = r29;
        r0.zzaxa = r2;	 Catch:{ all -> 0x01e4 }
    L_0x0985:
        r2 = r3.zzaic;	 Catch:{ all -> 0x01e4 }
        if (r2 == 0) goto L_0x09a8;
    L_0x0989:
        r2 = r3.zzaic;	 Catch:{ all -> 0x01e4 }
        r2 = r2.booleanValue();	 Catch:{ all -> 0x01e4 }
        if (r2 == 0) goto L_0x09a8;
    L_0x0991:
        r34.zzjr();	 Catch:{ all -> 0x01e4 }
        r0 = r29;
        r2 = r0.zzaxa;	 Catch:{ all -> 0x01e4 }
        r3 = "_efs";
        r4 = 1;
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x01e4 }
        r2 = com.google.android.gms.measurement.internal.zzfu.zza(r2, r3, r4);	 Catch:{ all -> 0x01e4 }
        r0 = r29;
        r0.zzaxa = r2;	 Catch:{ all -> 0x01e4 }
    L_0x09a8:
        r2 = r19 + 1;
        r25[r19] = r29;	 Catch:{ all -> 0x01e4 }
    L_0x09ac:
        r3 = r20 + 1;
        r20 = r3;
        r19 = r2;
        goto L_0x0924;
    L_0x09b4:
        r2 = new com.google.android.gms.measurement.internal.zzfx;	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r3 = r0.zztt;	 Catch:{ all -> 0x01e4 }
        r4 = "auto";
        r5 = "_lte";
        r0 = r34;
        r6 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r6 = r6.zzbx();	 Catch:{ all -> 0x01e4 }
        r6 = r6.currentTimeMillis();	 Catch:{ all -> 0x01e4 }
        r8 = r8.value;	 Catch:{ all -> 0x01e4 }
        r8 = (java.lang.Long) r8;	 Catch:{ all -> 0x01e4 }
        r8 = r8.longValue();	 Catch:{ all -> 0x01e4 }
        r8 = r8 + r16;
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x01e4 }
        r2.<init>(r3, r4, r5, r6, r8);	 Catch:{ all -> 0x01e4 }
        r4 = r2;
        goto L_0x0844;
    L_0x09de:
        r3 = r3 + 1;
        goto L_0x0867;
    L_0x09e2:
        r2 = r34.zzls();	 Catch:{ all -> 0x01e4 }
        r0 = r22;
        r3 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r3 = r3.zztt;	 Catch:{ all -> 0x01e4 }
        r30 = r2.zzck(r3);	 Catch:{ all -> 0x01e4 }
        r0 = r34;
        r2 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r2.zzgr();	 Catch:{ all -> 0x01e4 }
        r0 = r29;
        r2 = r0.zzaxb;	 Catch:{ all -> 0x01e4 }
        r2 = r2.longValue();	 Catch:{ all -> 0x01e4 }
        r0 = r30;
        r32 = com.google.android.gms.measurement.internal.zzfy.zzc(r2, r0);	 Catch:{ all -> 0x01e4 }
        r2 = 1;
        r4 = "_dbg";
        r6 = 1;
        r5 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x01e4 }
        r3 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x01e4 }
        if (r3 != 0) goto L_0x0a16;
    L_0x0a14:
        if (r5 != 0) goto L_0x0a4e;
    L_0x0a16:
        r3 = 0;
    L_0x0a17:
        if (r3 != 0) goto L_0x0eb1;
    L_0x0a19:
        r2 = r34.zzls();	 Catch:{ all -> 0x01e4 }
        r0 = r22;
        r3 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r3 = r3.zztt;	 Catch:{ all -> 0x01e4 }
        r0 = r29;
        r4 = r0.name;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzq(r3, r4);	 Catch:{ all -> 0x01e4 }
        r21 = r2;
    L_0x0a2d:
        if (r21 > 0) goto L_0x0a8d;
    L_0x0a2f:
        r0 = r34;
        r2 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzgt();	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzjj();	 Catch:{ all -> 0x01e4 }
        r3 = "Sample rate must be positive. event, rate";
        r0 = r29;
        r4 = r0.name;	 Catch:{ all -> 0x01e4 }
        r5 = java.lang.Integer.valueOf(r21);	 Catch:{ all -> 0x01e4 }
        r2.zze(r3, r4, r5);	 Catch:{ all -> 0x01e4 }
        r2 = r19 + 1;
        r25[r19] = r29;	 Catch:{ all -> 0x01e4 }
        goto L_0x09ac;
    L_0x0a4e:
        r0 = r29;
        r6 = r0.zzaxa;	 Catch:{ all -> 0x01e4 }
        r7 = r6.length;	 Catch:{ all -> 0x01e4 }
        r3 = 0;
    L_0x0a54:
        if (r3 >= r7) goto L_0x0a8b;
    L_0x0a56:
        r8 = r6[r3];	 Catch:{ all -> 0x01e4 }
        r9 = r8.name;	 Catch:{ all -> 0x01e4 }
        r9 = r4.equals(r9);	 Catch:{ all -> 0x01e4 }
        if (r9 == 0) goto L_0x0a88;
    L_0x0a60:
        r3 = r5 instanceof java.lang.Long;	 Catch:{ all -> 0x01e4 }
        if (r3 == 0) goto L_0x0a6c;
    L_0x0a64:
        r3 = r8.zzaxe;	 Catch:{ all -> 0x01e4 }
        r3 = r5.equals(r3);	 Catch:{ all -> 0x01e4 }
        if (r3 != 0) goto L_0x0a84;
    L_0x0a6c:
        r3 = r5 instanceof java.lang.String;	 Catch:{ all -> 0x01e4 }
        if (r3 == 0) goto L_0x0a78;
    L_0x0a70:
        r3 = r8.zzaml;	 Catch:{ all -> 0x01e4 }
        r3 = r5.equals(r3);	 Catch:{ all -> 0x01e4 }
        if (r3 != 0) goto L_0x0a84;
    L_0x0a78:
        r3 = r5 instanceof java.lang.Double;	 Catch:{ all -> 0x01e4 }
        if (r3 == 0) goto L_0x0a86;
    L_0x0a7c:
        r3 = r8.zzaun;	 Catch:{ all -> 0x01e4 }
        r3 = r5.equals(r3);	 Catch:{ all -> 0x01e4 }
        if (r3 == 0) goto L_0x0a86;
    L_0x0a84:
        r3 = 1;
        goto L_0x0a17;
    L_0x0a86:
        r3 = 0;
        goto L_0x0a17;
    L_0x0a88:
        r3 = r3 + 1;
        goto L_0x0a54;
    L_0x0a8b:
        r3 = 0;
        goto L_0x0a17;
    L_0x0a8d:
        r0 = r29;
        r2 = r0.name;	 Catch:{ all -> 0x01e4 }
        r0 = r24;
        r2 = r0.get(r2);	 Catch:{ all -> 0x01e4 }
        r2 = (com.google.android.gms.measurement.internal.zzac) r2;	 Catch:{ all -> 0x01e4 }
        if (r2 != 0) goto L_0x0eae;
    L_0x0a9b:
        r2 = r34.zzjt();	 Catch:{ all -> 0x01e4 }
        r0 = r22;
        r3 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r3 = r3.zztt;	 Catch:{ all -> 0x01e4 }
        r0 = r29;
        r4 = r0.name;	 Catch:{ all -> 0x01e4 }
        r4 = r2.zzg(r3, r4);	 Catch:{ all -> 0x01e4 }
        if (r4 != 0) goto L_0x0aee;
    L_0x0aaf:
        r0 = r34;
        r2 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzgt();	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzjj();	 Catch:{ all -> 0x01e4 }
        r3 = "Event being bundled has no eventAggregate. appId, eventName";
        r0 = r22;
        r4 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r4 = r4.zztt;	 Catch:{ all -> 0x01e4 }
        r0 = r29;
        r5 = r0.name;	 Catch:{ all -> 0x01e4 }
        r2.zze(r3, r4, r5);	 Catch:{ all -> 0x01e4 }
        r3 = new com.google.android.gms.measurement.internal.zzac;	 Catch:{ all -> 0x01e4 }
        r0 = r22;
        r2 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r4 = r2.zztt;	 Catch:{ all -> 0x01e4 }
        r0 = r29;
        r5 = r0.name;	 Catch:{ all -> 0x01e4 }
        r6 = 1;
        r8 = 1;
        r0 = r29;
        r2 = r0.zzaxb;	 Catch:{ all -> 0x01e4 }
        r10 = r2.longValue();	 Catch:{ all -> 0x01e4 }
        r12 = 0;
        r14 = 0;
        r15 = 0;
        r16 = 0;
        r17 = 0;
        r3.<init>(r4, r5, r6, r8, r10, r12, r14, r15, r16, r17);	 Catch:{ all -> 0x01e4 }
        r4 = r3;
    L_0x0aee:
        r34.zzjr();	 Catch:{ all -> 0x01e4 }
        r2 = "_eid";
        r0 = r29;
        r2 = com.google.android.gms.measurement.internal.zzfu.zzb(r0, r2);	 Catch:{ all -> 0x01e4 }
        r2 = (java.lang.Long) r2;	 Catch:{ all -> 0x01e4 }
        if (r2 == 0) goto L_0x0b2f;
    L_0x0afd:
        r3 = 1;
    L_0x0afe:
        r5 = java.lang.Boolean.valueOf(r3);	 Catch:{ all -> 0x01e4 }
        r3 = 1;
        r0 = r21;
        if (r0 != r3) goto L_0x0b31;
    L_0x0b07:
        r2 = r19 + 1;
        r25[r19] = r29;	 Catch:{ all -> 0x01e4 }
        r3 = r5.booleanValue();	 Catch:{ all -> 0x01e4 }
        if (r3 == 0) goto L_0x09ac;
    L_0x0b11:
        r3 = r4.zzaia;	 Catch:{ all -> 0x01e4 }
        if (r3 != 0) goto L_0x0b1d;
    L_0x0b15:
        r3 = r4.zzaib;	 Catch:{ all -> 0x01e4 }
        if (r3 != 0) goto L_0x0b1d;
    L_0x0b19:
        r3 = r4.zzaic;	 Catch:{ all -> 0x01e4 }
        if (r3 == 0) goto L_0x09ac;
    L_0x0b1d:
        r3 = 0;
        r5 = 0;
        r6 = 0;
        r3 = r4.zza(r3, r5, r6);	 Catch:{ all -> 0x01e4 }
        r0 = r29;
        r4 = r0.name;	 Catch:{ all -> 0x01e4 }
        r0 = r24;
        r0.put(r4, r3);	 Catch:{ all -> 0x01e4 }
        goto L_0x09ac;
    L_0x0b2f:
        r3 = 0;
        goto L_0x0afe;
    L_0x0b31:
        r0 = r26;
        r1 = r21;
        r3 = r0.nextInt(r1);	 Catch:{ all -> 0x01e4 }
        if (r3 != 0) goto L_0x0b83;
    L_0x0b3b:
        r34.zzjr();	 Catch:{ all -> 0x01e4 }
        r0 = r29;
        r2 = r0.zzaxa;	 Catch:{ all -> 0x01e4 }
        r3 = "_sr";
        r0 = r21;
        r6 = (long) r0;	 Catch:{ all -> 0x01e4 }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x01e4 }
        r2 = com.google.android.gms.measurement.internal.zzfu.zza(r2, r3, r6);	 Catch:{ all -> 0x01e4 }
        r0 = r29;
        r0.zzaxa = r2;	 Catch:{ all -> 0x01e4 }
        r2 = r19 + 1;
        r25[r19] = r29;	 Catch:{ all -> 0x01e4 }
        r3 = r5.booleanValue();	 Catch:{ all -> 0x01e4 }
        if (r3 == 0) goto L_0x0b6a;
    L_0x0b5d:
        r3 = 0;
        r0 = r21;
        r6 = (long) r0;	 Catch:{ all -> 0x01e4 }
        r5 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x01e4 }
        r6 = 0;
        r4 = r4.zza(r3, r5, r6);	 Catch:{ all -> 0x01e4 }
    L_0x0b6a:
        r0 = r29;
        r3 = r0.name;	 Catch:{ all -> 0x01e4 }
        r0 = r29;
        r5 = r0.zzaxb;	 Catch:{ all -> 0x01e4 }
        r6 = r5.longValue();	 Catch:{ all -> 0x01e4 }
        r0 = r32;
        r4 = r4.zza(r6, r0);	 Catch:{ all -> 0x01e4 }
        r0 = r24;
        r0.put(r3, r4);	 Catch:{ all -> 0x01e4 }
        goto L_0x09ac;
    L_0x0b83:
        r0 = r34;
        r3 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r3 = r3.zzgv();	 Catch:{ all -> 0x01e4 }
        r0 = r22;
        r6 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r6 = r6.zztt;	 Catch:{ all -> 0x01e4 }
        r3 = r3.zzbf(r6);	 Catch:{ all -> 0x01e4 }
        if (r3 == 0) goto L_0x0c23;
    L_0x0b97:
        r3 = r4.zzahz;	 Catch:{ all -> 0x01e4 }
        if (r3 == 0) goto L_0x0c0b;
    L_0x0b9b:
        r3 = r4.zzahz;	 Catch:{ all -> 0x01e4 }
        r6 = r3.longValue();	 Catch:{ all -> 0x01e4 }
    L_0x0ba1:
        r3 = (r6 > r32 ? 1 : (r6 == r32 ? 0 : -1));
        if (r3 == 0) goto L_0x0c21;
    L_0x0ba5:
        r3 = 1;
    L_0x0ba6:
        if (r3 == 0) goto L_0x0c40;
    L_0x0ba8:
        r34.zzjr();	 Catch:{ all -> 0x01e4 }
        r0 = r29;
        r2 = r0.zzaxa;	 Catch:{ all -> 0x01e4 }
        r3 = "_efs";
        r6 = 1;
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x01e4 }
        r2 = com.google.android.gms.measurement.internal.zzfu.zza(r2, r3, r6);	 Catch:{ all -> 0x01e4 }
        r0 = r29;
        r0.zzaxa = r2;	 Catch:{ all -> 0x01e4 }
        r34.zzjr();	 Catch:{ all -> 0x01e4 }
        r0 = r29;
        r2 = r0.zzaxa;	 Catch:{ all -> 0x01e4 }
        r3 = "_sr";
        r0 = r21;
        r6 = (long) r0;	 Catch:{ all -> 0x01e4 }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x01e4 }
        r2 = com.google.android.gms.measurement.internal.zzfu.zza(r2, r3, r6);	 Catch:{ all -> 0x01e4 }
        r0 = r29;
        r0.zzaxa = r2;	 Catch:{ all -> 0x01e4 }
        r2 = r19 + 1;
        r25[r19] = r29;	 Catch:{ all -> 0x01e4 }
        r3 = r5.booleanValue();	 Catch:{ all -> 0x01e4 }
        if (r3 == 0) goto L_0x0eab;
    L_0x0be1:
        r3 = 0;
        r0 = r21;
        r6 = (long) r0;	 Catch:{ all -> 0x01e4 }
        r5 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x01e4 }
        r6 = 1;
        r6 = java.lang.Boolean.valueOf(r6);	 Catch:{ all -> 0x01e4 }
        r3 = r4.zza(r3, r5, r6);	 Catch:{ all -> 0x01e4 }
    L_0x0bf2:
        r0 = r29;
        r4 = r0.name;	 Catch:{ all -> 0x01e4 }
        r0 = r29;
        r5 = r0.zzaxb;	 Catch:{ all -> 0x01e4 }
        r6 = r5.longValue();	 Catch:{ all -> 0x01e4 }
        r0 = r32;
        r3 = r3.zza(r6, r0);	 Catch:{ all -> 0x01e4 }
        r0 = r24;
        r0.put(r4, r3);	 Catch:{ all -> 0x01e4 }
        goto L_0x09ac;
    L_0x0c0b:
        r0 = r34;
        r3 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r3.zzgr();	 Catch:{ all -> 0x01e4 }
        r0 = r29;
        r3 = r0.zzaxc;	 Catch:{ all -> 0x01e4 }
        r6 = r3.longValue();	 Catch:{ all -> 0x01e4 }
        r0 = r30;
        r6 = com.google.android.gms.measurement.internal.zzfy.zzc(r6, r0);	 Catch:{ all -> 0x01e4 }
        goto L_0x0ba1;
    L_0x0c21:
        r3 = 0;
        goto L_0x0ba6;
    L_0x0c23:
        r6 = r4.zzahy;	 Catch:{ all -> 0x01e4 }
        r0 = r29;
        r3 = r0.zzaxb;	 Catch:{ all -> 0x01e4 }
        r8 = r3.longValue();	 Catch:{ all -> 0x01e4 }
        r6 = r8 - r6;
        r6 = java.lang.Math.abs(r6);	 Catch:{ all -> 0x01e4 }
        r8 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r3 < 0) goto L_0x0c3d;
    L_0x0c3a:
        r3 = 1;
        goto L_0x0ba6;
    L_0x0c3d:
        r3 = 0;
        goto L_0x0ba6;
    L_0x0c40:
        r3 = r5.booleanValue();	 Catch:{ all -> 0x01e4 }
        if (r3 == 0) goto L_0x0c55;
    L_0x0c46:
        r0 = r29;
        r3 = r0.name;	 Catch:{ all -> 0x01e4 }
        r5 = 0;
        r6 = 0;
        r2 = r4.zza(r2, r5, r6);	 Catch:{ all -> 0x01e4 }
        r0 = r24;
        r0.put(r3, r2);	 Catch:{ all -> 0x01e4 }
    L_0x0c55:
        r2 = r19;
        goto L_0x09ac;
    L_0x0c59:
        r0 = r23;
        r2 = r0.zzaxi;	 Catch:{ all -> 0x01e4 }
        r2 = r2.length;	 Catch:{ all -> 0x01e4 }
        r0 = r19;
        if (r0 >= r2) goto L_0x0c70;
    L_0x0c62:
        r0 = r25;
        r1 = r19;
        r2 = java.util.Arrays.copyOf(r0, r1);	 Catch:{ all -> 0x01e4 }
        r2 = (com.google.android.gms.internal.measurement.zzft[]) r2;	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r0.zzaxi = r2;	 Catch:{ all -> 0x01e4 }
    L_0x0c70:
        r2 = r24.entrySet();	 Catch:{ all -> 0x01e4 }
        r3 = r2.iterator();	 Catch:{ all -> 0x01e4 }
    L_0x0c78:
        r2 = r3.hasNext();	 Catch:{ all -> 0x01e4 }
        if (r2 == 0) goto L_0x0c92;
    L_0x0c7e:
        r2 = r3.next();	 Catch:{ all -> 0x01e4 }
        r2 = (java.util.Map.Entry) r2;	 Catch:{ all -> 0x01e4 }
        r4 = r34.zzjt();	 Catch:{ all -> 0x01e4 }
        r2 = r2.getValue();	 Catch:{ all -> 0x01e4 }
        r2 = (com.google.android.gms.measurement.internal.zzac) r2;	 Catch:{ all -> 0x01e4 }
        r4.zza(r2);	 Catch:{ all -> 0x01e4 }
        goto L_0x0c78;
    L_0x0c92:
        r2 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r0.zzaxl = r2;	 Catch:{ all -> 0x01e4 }
        r2 = -9223372036854775808;
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r0.zzaxm = r2;	 Catch:{ all -> 0x01e4 }
        r2 = 0;
    L_0x0caa:
        r0 = r23;
        r3 = r0.zzaxi;	 Catch:{ all -> 0x01e4 }
        r3 = r3.length;	 Catch:{ all -> 0x01e4 }
        if (r2 >= r3) goto L_0x0cea;
    L_0x0cb1:
        r0 = r23;
        r3 = r0.zzaxi;	 Catch:{ all -> 0x01e4 }
        r3 = r3[r2];	 Catch:{ all -> 0x01e4 }
        r4 = r3.zzaxb;	 Catch:{ all -> 0x01e4 }
        r4 = r4.longValue();	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r6 = r0.zzaxl;	 Catch:{ all -> 0x01e4 }
        r6 = r6.longValue();	 Catch:{ all -> 0x01e4 }
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 >= 0) goto L_0x0ccf;
    L_0x0cc9:
        r4 = r3.zzaxb;	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r0.zzaxl = r4;	 Catch:{ all -> 0x01e4 }
    L_0x0ccf:
        r4 = r3.zzaxb;	 Catch:{ all -> 0x01e4 }
        r4 = r4.longValue();	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r6 = r0.zzaxm;	 Catch:{ all -> 0x01e4 }
        r6 = r6.longValue();	 Catch:{ all -> 0x01e4 }
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 <= 0) goto L_0x0ce7;
    L_0x0ce1:
        r3 = r3.zzaxb;	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r0.zzaxm = r3;	 Catch:{ all -> 0x01e4 }
    L_0x0ce7:
        r2 = r2 + 1;
        goto L_0x0caa;
    L_0x0cea:
        r0 = r22;
        r2 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r6 = r2.zztt;	 Catch:{ all -> 0x01e4 }
        r2 = r34.zzjt();	 Catch:{ all -> 0x01e4 }
        r7 = r2.zzbm(r6);	 Catch:{ all -> 0x01e4 }
        if (r7 != 0) goto L_0x0d90;
    L_0x0cfa:
        r0 = r34;
        r2 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzgt();	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzjg();	 Catch:{ all -> 0x01e4 }
        r3 = "Bundling raw events w/o app info. appId";
        r0 = r22;
        r4 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r4 = r4.zztt;	 Catch:{ all -> 0x01e4 }
        r4 = com.google.android.gms.measurement.internal.zzas.zzbw(r4);	 Catch:{ all -> 0x01e4 }
        r2.zzg(r3, r4);	 Catch:{ all -> 0x01e4 }
    L_0x0d15:
        r0 = r23;
        r2 = r0.zzaxi;	 Catch:{ all -> 0x01e4 }
        r2 = r2.length;	 Catch:{ all -> 0x01e4 }
        if (r2 <= 0) goto L_0x0d58;
    L_0x0d1c:
        r0 = r34;
        r2 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r2.zzgw();	 Catch:{ all -> 0x01e4 }
        r2 = r34.zzls();	 Catch:{ all -> 0x01e4 }
        r0 = r22;
        r3 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r3 = r3.zztt;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzcg(r3);	 Catch:{ all -> 0x01e4 }
        if (r2 == 0) goto L_0x0d37;
    L_0x0d33:
        r3 = r2.zzawk;	 Catch:{ all -> 0x01e4 }
        if (r3 != 0) goto L_0x0e19;
    L_0x0d37:
        r0 = r22;
        r2 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzafi;	 Catch:{ all -> 0x01e4 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x01e4 }
        if (r2 == 0) goto L_0x0dfc;
    L_0x0d43:
        r2 = -1;
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r0.zzayf = r2;	 Catch:{ all -> 0x01e4 }
    L_0x0d4d:
        r2 = r34.zzjt();	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r1 = r18;
        r2.zza(r0, r1);	 Catch:{ all -> 0x01e4 }
    L_0x0d58:
        r4 = r34.zzjt();	 Catch:{ all -> 0x01e4 }
        r0 = r22;
        r5 = r0.zzauh;	 Catch:{ all -> 0x01e4 }
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r5);	 Catch:{ all -> 0x01e4 }
        r4.zzaf();	 Catch:{ all -> 0x01e4 }
        r4.zzcl();	 Catch:{ all -> 0x01e4 }
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01e4 }
        r2 = "rowid in (";
        r7.<init>(r2);	 Catch:{ all -> 0x01e4 }
        r2 = 0;
        r3 = r2;
    L_0x0d72:
        r2 = r5.size();	 Catch:{ all -> 0x01e4 }
        if (r3 >= r2) goto L_0x0e21;
    L_0x0d78:
        if (r3 == 0) goto L_0x0d7f;
    L_0x0d7a:
        r2 = ",";
        r7.append(r2);	 Catch:{ all -> 0x01e4 }
    L_0x0d7f:
        r2 = r5.get(r3);	 Catch:{ all -> 0x01e4 }
        r2 = (java.lang.Long) r2;	 Catch:{ all -> 0x01e4 }
        r8 = r2.longValue();	 Catch:{ all -> 0x01e4 }
        r7.append(r8);	 Catch:{ all -> 0x01e4 }
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x0d72;
    L_0x0d90:
        r0 = r23;
        r2 = r0.zzaxi;	 Catch:{ all -> 0x01e4 }
        r2 = r2.length;	 Catch:{ all -> 0x01e4 }
        if (r2 <= 0) goto L_0x0d15;
    L_0x0d97:
        r2 = r7.zzhe();	 Catch:{ all -> 0x01e4 }
        r4 = 0;
        r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r4 == 0) goto L_0x0df8;
    L_0x0da1:
        r4 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x01e4 }
    L_0x0da5:
        r0 = r23;
        r0.zzaxo = r4;	 Catch:{ all -> 0x01e4 }
        r4 = r7.zzhd();	 Catch:{ all -> 0x01e4 }
        r8 = 0;
        r8 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r8 != 0) goto L_0x0ea8;
    L_0x0db3:
        r4 = 0;
        r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r4 == 0) goto L_0x0dfa;
    L_0x0db9:
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x01e4 }
    L_0x0dbd:
        r0 = r23;
        r0.zzaxn = r2;	 Catch:{ all -> 0x01e4 }
        r7.zzhm();	 Catch:{ all -> 0x01e4 }
        r2 = r7.zzhj();	 Catch:{ all -> 0x01e4 }
        r2 = (int) r2;	 Catch:{ all -> 0x01e4 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r0.zzaxy = r2;	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r2 = r0.zzaxl;	 Catch:{ all -> 0x01e4 }
        r2 = r2.longValue();	 Catch:{ all -> 0x01e4 }
        r7.zzo(r2);	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r2 = r0.zzaxm;	 Catch:{ all -> 0x01e4 }
        r2 = r2.longValue();	 Catch:{ all -> 0x01e4 }
        r7.zzp(r2);	 Catch:{ all -> 0x01e4 }
        r2 = r7.zzhu();	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r0.zzagm = r2;	 Catch:{ all -> 0x01e4 }
        r2 = r34.zzjt();	 Catch:{ all -> 0x01e4 }
        r2.zza(r7);	 Catch:{ all -> 0x01e4 }
        goto L_0x0d15;
    L_0x0df8:
        r4 = 0;
        goto L_0x0da5;
    L_0x0dfa:
        r2 = 0;
        goto L_0x0dbd;
    L_0x0dfc:
        r0 = r34;
        r2 = r0.zzada;	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzgt();	 Catch:{ all -> 0x01e4 }
        r2 = r2.zzjj();	 Catch:{ all -> 0x01e4 }
        r3 = "Did not find measurement config or missing version info. appId";
        r0 = r22;
        r4 = r0.zzaug;	 Catch:{ all -> 0x01e4 }
        r4 = r4.zztt;	 Catch:{ all -> 0x01e4 }
        r4 = com.google.android.gms.measurement.internal.zzas.zzbw(r4);	 Catch:{ all -> 0x01e4 }
        r2.zzg(r3, r4);	 Catch:{ all -> 0x01e4 }
        goto L_0x0d4d;
    L_0x0e19:
        r2 = r2.zzawk;	 Catch:{ all -> 0x01e4 }
        r0 = r23;
        r0.zzayf = r2;	 Catch:{ all -> 0x01e4 }
        goto L_0x0d4d;
    L_0x0e21:
        r2 = ")";
        r7.append(r2);	 Catch:{ all -> 0x01e4 }
        r2 = r4.getWritableDatabase();	 Catch:{ all -> 0x01e4 }
        r3 = "raw_events";
        r7 = r7.toString();	 Catch:{ all -> 0x01e4 }
        r8 = 0;
        r2 = r2.delete(r3, r7, r8);	 Catch:{ all -> 0x01e4 }
        r3 = r5.size();	 Catch:{ all -> 0x01e4 }
        if (r2 == r3) goto L_0x0e54;
    L_0x0e3b:
        r3 = r4.zzgt();	 Catch:{ all -> 0x01e4 }
        r3 = r3.zzjg();	 Catch:{ all -> 0x01e4 }
        r4 = "Deleted fewer rows from raw events table than expected";
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x01e4 }
        r5 = r5.size();	 Catch:{ all -> 0x01e4 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x01e4 }
        r3.zze(r4, r2, r5);	 Catch:{ all -> 0x01e4 }
    L_0x0e54:
        r3 = r34.zzjt();	 Catch:{ all -> 0x01e4 }
        r2 = r3.getWritableDatabase();	 Catch:{ all -> 0x01e4 }
        r4 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)";
        r5 = 2;
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0e7a }
        r7 = 0;
        r5[r7] = r6;	 Catch:{ SQLiteException -> 0x0e7a }
        r7 = 1;
        r5[r7] = r6;	 Catch:{ SQLiteException -> 0x0e7a }
        r2.execSQL(r4, r5);	 Catch:{ SQLiteException -> 0x0e7a }
    L_0x0e6a:
        r2 = r34.zzjt();	 Catch:{ all -> 0x01e4 }
        r2.setTransactionSuccessful();	 Catch:{ all -> 0x01e4 }
        r2 = r34.zzjt();
        r2.endTransaction();
        r2 = 1;
    L_0x0e79:
        return r2;
    L_0x0e7a:
        r2 = move-exception;
        r3 = r3.zzgt();	 Catch:{ all -> 0x01e4 }
        r3 = r3.zzjg();	 Catch:{ all -> 0x01e4 }
        r4 = "Failed to remove unused event metadata. appId";
        r5 = com.google.android.gms.measurement.internal.zzas.zzbw(r6);	 Catch:{ all -> 0x01e4 }
        r3.zze(r4, r5, r2);	 Catch:{ all -> 0x01e4 }
        goto L_0x0e6a;
    L_0x0e8d:
        r2 = r34.zzjt();	 Catch:{ all -> 0x01e4 }
        r2.setTransactionSuccessful();	 Catch:{ all -> 0x01e4 }
        r2 = r34.zzjt();
        r2.endTransaction();
        r2 = 0;
        goto L_0x0e79;
    L_0x0e9d:
        r2 = move-exception;
        r3 = r11;
        goto L_0x037a;
    L_0x0ea1:
        r2 = move-exception;
        goto L_0x0309;
    L_0x0ea4:
        r2 = move-exception;
        r4 = r12;
        goto L_0x0309;
    L_0x0ea8:
        r2 = r4;
        goto L_0x0db3;
    L_0x0eab:
        r3 = r4;
        goto L_0x0bf2;
    L_0x0eae:
        r4 = r2;
        goto L_0x0aee;
    L_0x0eb1:
        r21 = r2;
        goto L_0x0a2d;
    L_0x0eb5:
        r3 = r15;
        goto L_0x07f8;
    L_0x0eb8:
        r3 = r13;
        r4 = r14;
        goto L_0x0685;
    L_0x0ebc:
        r2 = r5;
        goto L_0x0633;
    L_0x0ebf:
        r2 = r3;
        goto L_0x06c9;
    L_0x0ec2:
        r2 = r3;
        goto L_0x056b;
    L_0x0ec5:
        r18 = r2;
        goto L_0x04ff;
    L_0x0ec9:
        r2 = r3;
        goto L_0x03d6;
    L_0x0ecc:
        r2 = r13;
        r4 = r14;
        r6 = r16;
        r5 = r15;
        r8 = r18;
        goto L_0x0179;
    L_0x0ed5:
        r6 = r16;
        goto L_0x06b9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfo.zzd(java.lang.String, long):boolean");
    }

    private final boolean zza(zzft zzft, zzft zzft2) {
        String str = null;
        Preconditions.checkArgument("_e".equals(zzft.name));
        zzjr();
        zzfu zza = zzfu.zza(zzft, "_sc");
        Object obj = zza == null ? null : zza.zzaml;
        zzjr();
        zzfu zza2 = zzfu.zza(zzft2, "_pc");
        if (zza2 != null) {
            str = zza2.zzaml;
        }
        if (str == null || !str.equals(obj)) {
            return false;
        }
        zzjr();
        zza = zzfu.zza(zzft, "_et");
        if (zza.zzaxe == null || zza.zzaxe.longValue() <= 0) {
            return true;
        }
        long longValue = zza.zzaxe.longValue();
        zzjr();
        zza2 = zzfu.zza(zzft2, "_et");
        if (!(zza2 == null || zza2.zzaxe == null || zza2.zzaxe.longValue() <= 0)) {
            longValue += zza2.zzaxe.longValue();
        }
        zzjr();
        zzft2.zzaxa = zzfu.zza(zzft2.zzaxa, "_et", Long.valueOf(longValue));
        zzjr();
        zzft.zzaxa = zzfu.zza(zzft.zzaxa, "_fr", Long.valueOf(1));
        return true;
    }

    @VisibleForTesting
    private static zzfu[] zza(zzfu[] zzfuArr, String str) {
        int i = 0;
        while (i < zzfuArr.length) {
            if (str.equals(zzfuArr[i].name)) {
                break;
            }
            i++;
        }
        i = -1;
        return i < 0 ? zzfuArr : zza(zzfuArr, i);
    }

    @VisibleForTesting
    private static zzfu[] zza(zzfu[] zzfuArr, int i) {
        Object obj = new zzfu[(zzfuArr.length - 1)];
        if (i > 0) {
            System.arraycopy(zzfuArr, 0, obj, 0, i);
        }
        if (i < obj.length) {
            System.arraycopy(zzfuArr, i + 1, obj, i, obj.length - i);
        }
        return obj;
    }

    @VisibleForTesting
    private static zzfu[] zza(zzfu[] zzfuArr, int i, String str) {
        for (zzfu zzfu : zzfuArr) {
            if ("_err".equals(zzfu.name)) {
                return zzfuArr;
            }
        }
        Object obj = new zzfu[(zzfuArr.length + 2)];
        System.arraycopy(zzfuArr, 0, obj, 0, zzfuArr.length);
        zzfu zzfu2 = new zzfu();
        zzfu2.name = "_err";
        zzfu2.zzaxe = Long.valueOf((long) i);
        zzfu zzfu3 = new zzfu();
        zzfu3.name = "_ev";
        zzfu3.zzaml = str;
        obj[obj.length - 2] = zzfu2;
        obj[obj.length - 1] = zzfu3;
        return obj;
    }

    @VisibleForTesting
    final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzcr zzjt;
        zzaf();
        zzlx();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzatw = false;
                zzmc();
            }
        }
        List<Long> list = this.zzaua;
        this.zzaua = null;
        if ((i == HttpStatus.SC_OK || i == HttpStatus.SC_NO_CONTENT) && th == null) {
            try {
                this.zzada.zzgu().zzana.set(this.zzada.zzbx().currentTimeMillis());
                this.zzada.zzgu().zzanb.set(0);
                zzmb();
                this.zzada.zzgt().zzjo().zze("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzjt().beginTransaction();
                try {
                    for (Long l : list) {
                        try {
                            zzjt = zzjt();
                            long longValue = l.longValue();
                            zzjt.zzaf();
                            zzjt.zzcl();
                            if (zzjt.getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zzjt.zzgt().zzjg().zzg("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            if (this.zzaub == null || !this.zzaub.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    zzjt().setTransactionSuccessful();
                    this.zzaub = null;
                    if (zzlt().zzfb() && zzma()) {
                        zzlz();
                    } else {
                        this.zzauc = -1;
                        zzmb();
                    }
                    this.zzatr = 0;
                } finally {
                    zzjt().endTransaction();
                }
            } catch (SQLiteException e3) {
                this.zzada.zzgt().zzjg().zzg("Database error while trying to delete uploaded bundles", e3);
                this.zzatr = this.zzada.zzbx().elapsedRealtime();
                this.zzada.zzgt().zzjo().zzg("Disable upload, time", Long.valueOf(this.zzatr));
            }
        } else {
            this.zzada.zzgt().zzjo().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzada.zzgu().zzanb.set(this.zzada.zzbx().currentTimeMillis());
            boolean z = i == HttpStatus.SC_SERVICE_UNAVAILABLE || i == 429;
            if (z) {
                this.zzada.zzgu().zzanc.set(this.zzada.zzbx().currentTimeMillis());
            }
            if (this.zzada.zzgv().zzaw(str)) {
                zzjt().zzc(list);
            }
            zzmb();
        }
        this.zzatw = false;
        zzmc();
    }

    private final boolean zzma() {
        zzaf();
        zzlx();
        return zzjt().zzim() || !TextUtils.isEmpty(zzjt().zzih());
    }

    private final void zzb(zzg zzg) {
        zzaf();
        if (!TextUtils.isEmpty(zzg.getGmpAppId()) || (zzq.zzig() && !TextUtils.isEmpty(zzg.zzhb()))) {
            Object zzhb;
            CharSequence charSequence;
            zzq zzgv = this.zzada.zzgv();
            Builder builder = new Builder();
            CharSequence gmpAppId = zzg.getGmpAppId();
            if (TextUtils.isEmpty(gmpAppId) && zzq.zzig()) {
                zzhb = zzg.zzhb();
            } else {
                charSequence = gmpAppId;
            }
            Builder encodedAuthority = builder.scheme((String) zzai.zzaiy.get()).encodedAuthority((String) zzai.zzaiz.get());
            String str = "config/app/";
            String valueOf = String.valueOf(zzhb);
            encodedAuthority.path(valueOf.length() != 0 ? str.concat(valueOf) : new String(str)).appendQueryParameter("app_instance_id", zzg.getAppInstanceId()).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(zzgv.zzhh()));
            String uri = builder.build().toString();
            try {
                Map map;
                URL url = new URL(uri);
                this.zzada.zzgt().zzjo().zzg("Fetching remote configuration", zzg.zzal());
                zzfp zzcg = zzls().zzcg(zzg.zzal());
                charSequence = zzls().zzch(zzg.zzal());
                if (zzcg == null || TextUtils.isEmpty(charSequence)) {
                    map = null;
                } else {
                    Map c0238a = new C0238a();
                    c0238a.put("If-Modified-Since", charSequence);
                    map = c0238a;
                }
                this.zzatv = true;
                zzcr zzlt = zzlt();
                String zzal = zzg.zzal();
                zzay zzfr = new zzfr(this);
                zzlt.zzaf();
                zzlt.zzcl();
                Preconditions.checkNotNull(url);
                Preconditions.checkNotNull(zzfr);
                zzlt.zzgs().zzd(new zzba(zzlt, zzal, url, null, map, zzfr));
                return;
            } catch (MalformedURLException e) {
                this.zzada.zzgt().zzjg().zze("Failed to parse config URL. Not fetching. appId", zzas.zzbw(zzg.zzal()), uri);
                return;
            }
        }
        zzb(zzg.zzal(), HttpStatus.SC_NO_CONTENT, null, null, null);
    }

    @VisibleForTesting
    final void zzb(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        boolean z = true;
        zzaf();
        zzlx();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzatv = false;
                zzmc();
            }
        }
        this.zzada.zzgt().zzjo().zzg("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        zzjt().beginTransaction();
        zzg zzbm = zzjt().zzbm(str);
        boolean z2 = (i == HttpStatus.SC_OK || i == HttpStatus.SC_NO_CONTENT || i == HttpStatus.SC_NOT_MODIFIED) && th == null;
        if (zzbm == null) {
            this.zzada.zzgt().zzjj().zzg("App does not exist in onConfigFetched. appId", zzas.zzbw(str));
        } else if (z2 || i == HttpStatus.SC_NOT_FOUND) {
            String str2;
            List list = map != null ? (List) map.get("Last-Modified") : null;
            if (list == null || list.size() <= 0) {
                str2 = null;
            } else {
                str2 = (String) list.get(0);
            }
            if (i == HttpStatus.SC_NOT_FOUND || i == HttpStatus.SC_NOT_MODIFIED) {
                if (zzls().zzcg(str) == null && !zzls().zza(str, null, null)) {
                    zzjt().endTransaction();
                    this.zzatv = false;
                    zzmc();
                    return;
                }
            } else if (!zzls().zza(str, bArr, str2)) {
                zzjt().endTransaction();
                this.zzatv = false;
                zzmc();
                return;
            }
            zzbm.zzu(this.zzada.zzbx().currentTimeMillis());
            zzjt().zza(zzbm);
            if (i == HttpStatus.SC_NOT_FOUND) {
                this.zzada.zzgt().zzjl().zzg("Config not found. Using empty config. appId", str);
            } else {
                this.zzada.zzgt().zzjo().zze("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            }
            if (zzlt().zzfb() && zzma()) {
                zzlz();
            } else {
                zzmb();
            }
        } else {
            zzbm.zzv(this.zzada.zzbx().currentTimeMillis());
            zzjt().zza(zzbm);
            this.zzada.zzgt().zzjo().zze("Fetching config failed. code, error", Integer.valueOf(i), th);
            zzls().zzci(str);
            this.zzada.zzgu().zzanb.set(this.zzada.zzbx().currentTimeMillis());
            if (!(i == HttpStatus.SC_SERVICE_UNAVAILABLE || i == 429)) {
                z = false;
            }
            if (z) {
                this.zzada.zzgu().zzanc.set(this.zzada.zzbx().currentTimeMillis());
            }
            zzmb();
        }
        zzjt().setTransactionSuccessful();
        zzjt().endTransaction();
        this.zzatv = false;
        zzmc();
    }

    private final void zzmb() {
        zzaf();
        zzlx();
        if (zzmf() || this.zzada.zzgv().zza(zzai.zzald)) {
            long abs;
            if (this.zzatr > 0) {
                abs = 3600000 - Math.abs(this.zzada.zzbx().elapsedRealtime() - this.zzatr);
                if (abs > 0) {
                    this.zzada.zzgt().zzjo().zzg("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                    zzlu().unregister();
                    zzlv().cancel();
                    return;
                }
                this.zzatr = 0;
            }
            if (this.zzada.zzkv() && zzma()) {
                long currentTimeMillis = this.zzada.zzbx().currentTimeMillis();
                long max = Math.max(0, ((Long) zzai.zzaju.get()).longValue());
                Object obj = (zzjt().zzin() || zzjt().zzii()) ? 1 : null;
                if (obj != null) {
                    CharSequence zzid = this.zzada.zzgv().zzid();
                    if (TextUtils.isEmpty(zzid) || ".none.".equals(zzid)) {
                        abs = Math.max(0, ((Long) zzai.zzajo.get()).longValue());
                    } else {
                        abs = Math.max(0, ((Long) zzai.zzajp.get()).longValue());
                    }
                } else {
                    abs = Math.max(0, ((Long) zzai.zzajn.get()).longValue());
                }
                long j = this.zzada.zzgu().zzana.get();
                long j2 = this.zzada.zzgu().zzanb.get();
                long max2 = Math.max(zzjt().zzik(), zzjt().zzil());
                if (max2 == 0) {
                    currentTimeMillis = 0;
                } else {
                    max2 = currentTimeMillis - Math.abs(max2 - currentTimeMillis);
                    j2 = currentTimeMillis - Math.abs(j2 - currentTimeMillis);
                    j = Math.max(currentTimeMillis - Math.abs(j - currentTimeMillis), j2);
                    currentTimeMillis = max2 + max;
                    if (obj != null && j > 0) {
                        currentTimeMillis = Math.min(max2, j) + abs;
                    }
                    if (!zzjr().zzb(j, abs)) {
                        currentTimeMillis = j + abs;
                    }
                    if (j2 != 0 && j2 >= max2) {
                        for (int i = 0; i < Math.min(20, Math.max(0, ((Integer) zzai.zzajw.get()).intValue())); i++) {
                            currentTimeMillis += (1 << i) * Math.max(0, ((Long) zzai.zzajv.get()).longValue());
                            if (currentTimeMillis > j2) {
                                break;
                            }
                        }
                        currentTimeMillis = 0;
                    }
                }
                if (currentTimeMillis == 0) {
                    this.zzada.zzgt().zzjo().zzby("Next upload time is 0");
                    zzlu().unregister();
                    zzlv().cancel();
                    return;
                } else if (zzlt().zzfb()) {
                    long j3 = this.zzada.zzgu().zzanc.get();
                    abs = Math.max(0, ((Long) zzai.zzajl.get()).longValue());
                    if (zzjr().zzb(j3, abs)) {
                        abs = currentTimeMillis;
                    } else {
                        abs = Math.max(currentTimeMillis, abs + j3);
                    }
                    zzlu().unregister();
                    abs -= this.zzada.zzbx().currentTimeMillis();
                    if (abs <= 0) {
                        abs = Math.max(0, ((Long) zzai.zzajq.get()).longValue());
                        this.zzada.zzgu().zzana.set(this.zzada.zzbx().currentTimeMillis());
                    }
                    this.zzada.zzgt().zzjo().zzg("Upload scheduled in approximately ms", Long.valueOf(abs));
                    zzlv().zzh(abs);
                    return;
                } else {
                    this.zzada.zzgt().zzjo().zzby("No network");
                    zzlu().zzey();
                    zzlv().cancel();
                    return;
                }
            }
            this.zzada.zzgt().zzjo().zzby("Nothing to upload or uploading impossible");
            zzlu().unregister();
            zzlv().cancel();
        }
    }

    final void zzg(Runnable runnable) {
        zzaf();
        if (this.zzats == null) {
            this.zzats = new ArrayList();
        }
        this.zzats.add(runnable);
    }

    private final void zzmc() {
        zzaf();
        if (this.zzatv || this.zzatw || this.zzatx) {
            this.zzada.zzgt().zzjo().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzatv), Boolean.valueOf(this.zzatw), Boolean.valueOf(this.zzatx));
            return;
        }
        this.zzada.zzgt().zzjo().zzby("Stopping uploading service(s)");
        if (this.zzats != null) {
            for (Runnable run : this.zzats) {
                run.run();
            }
            this.zzats.clear();
        }
    }

    private final Boolean zzc(zzg zzg) {
        try {
            if (zzg.zzhf() != -2147483648L) {
                if (zzg.zzhf() == ((long) Wrappers.packageManager(this.zzada.getContext()).getPackageInfo(zzg.zzal(), 0).versionCode)) {
                    return Boolean.valueOf(true);
                }
            }
            String str = Wrappers.packageManager(this.zzada.getContext()).getPackageInfo(zzg.zzal(), 0).versionName;
            if (zzg.zzak() != null && zzg.zzak().equals(str)) {
                return Boolean.valueOf(true);
            }
            return Boolean.valueOf(false);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    @VisibleForTesting
    private final boolean zzmd() {
        zzaf();
        try {
            this.zzatz = new RandomAccessFile(new File(this.zzada.getContext().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zzaty = this.zzatz.tryLock();
            if (this.zzaty != null) {
                this.zzada.zzgt().zzjo().zzby("Storage concurrent access okay");
                return true;
            }
            this.zzada.zzgt().zzjg().zzby("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            this.zzada.zzgt().zzjg().zzg("Failed to acquire storage lock", e);
        } catch (IOException e2) {
            this.zzada.zzgt().zzjg().zzg("Failed to access storage lock file", e2);
        }
    }

    @VisibleForTesting
    private final int zza(FileChannel fileChannel) {
        int i = 0;
        zzaf();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzada.zzgt().zzjg().zzby("Bad channel to read from");
        } else {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            try {
                fileChannel.position(0);
                int read = fileChannel.read(allocate);
                if (read == 4) {
                    allocate.flip();
                    i = allocate.getInt();
                } else if (read != -1) {
                    this.zzada.zzgt().zzjj().zzg("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
            } catch (IOException e) {
                this.zzada.zzgt().zzjg().zzg("Failed to read from channel", e);
            }
        }
        return i;
    }

    @VisibleForTesting
    private final boolean zza(int i, FileChannel fileChannel) {
        zzaf();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzada.zzgt().zzjg().zzby("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() == 4) {
                return true;
            }
            this.zzada.zzgt().zzjg().zzg("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            return true;
        } catch (IOException e) {
            this.zzada.zzgt().zzjg().zzg("Failed to write to channel", e);
            return false;
        }
    }

    final void zzme() {
        zzaf();
        zzlx();
        if (!this.zzatq) {
            this.zzatq = true;
            zzaf();
            zzlx();
            if ((this.zzada.zzgv().zza(zzai.zzald) || zzmf()) && zzmd()) {
                int zza = zza(this.zzatz);
                int zzjd = this.zzada.zzgk().zzjd();
                zzaf();
                if (zza > zzjd) {
                    this.zzada.zzgt().zzjg().zze("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza), Integer.valueOf(zzjd));
                } else if (zza < zzjd) {
                    if (zza(zzjd, this.zzatz)) {
                        this.zzada.zzgt().zzjo().zze("Storage version upgraded. Previous, current version", Integer.valueOf(zza), Integer.valueOf(zzjd));
                    } else {
                        this.zzada.zzgt().zzjg().zze("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza), Integer.valueOf(zzjd));
                    }
                }
            }
        }
        if (!this.zzatp && !this.zzada.zzgv().zza(zzai.zzald)) {
            this.zzada.zzgt().zzjm().zzby("This instance being marked as an uploader");
            this.zzatp = true;
            zzmb();
        }
    }

    private final boolean zzmf() {
        zzaf();
        zzlx();
        return this.zzatp;
    }

    @VisibleForTesting
    final void zzd(zzk zzk) {
        if (this.zzaua != null) {
            this.zzaub = new ArrayList();
            this.zzaub.addAll(this.zzaua);
        }
        zzcr zzjt = zzjt();
        String str = zzk.packageName;
        Preconditions.checkNotEmpty(str);
        zzjt.zzaf();
        zzjt.zzcl();
        try {
            SQLiteDatabase writableDatabase = zzjt.getWritableDatabase();
            String[] strArr = new String[]{str};
            int delete = writableDatabase.delete("main_event_params", "app_id=?", strArr) + ((((((((writableDatabase.delete("apps", "app_id=?", strArr) + 0) + writableDatabase.delete("events", "app_id=?", strArr)) + writableDatabase.delete("user_attributes", "app_id=?", strArr)) + writableDatabase.delete("conditional_properties", "app_id=?", strArr)) + writableDatabase.delete("raw_events", "app_id=?", strArr)) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr)) + writableDatabase.delete("queue", "app_id=?", strArr)) + writableDatabase.delete("audience_filter_values", "app_id=?", strArr));
            if (delete > 0) {
                zzjt.zzgt().zzjo().zze("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzjt.zzgt().zzjg().zze("Error resetting analytics data. appId, error", zzas.zzbw(str), e);
        }
        zzk zza = zza(this.zzada.getContext(), zzk.packageName, zzk.zzafi, zzk.zzafr, zzk.zzaft, zzk.zzafu, zzk.zzago, zzk.zzafv);
        if (!this.zzada.zzgv().zzba(zzk.packageName) || zzk.zzafr) {
            zzf(zza);
        }
    }

    private final zzk zza(Context context, String str, String str2, boolean z, boolean z2, boolean z3, long j, String str3) {
        Object charSequence;
        String str4 = "Unknown";
        String str5 = "Unknown";
        int i = Integer.MIN_VALUE;
        String str6 = "Unknown";
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            this.zzada.zzgt().zzjg().zzby("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            str4 = packageManager.getInstallerPackageName(str);
        } catch (IllegalArgumentException e) {
            this.zzada.zzgt().zzjg().zzg("Error retrieving installer package name. appId", zzas.zzbw(str));
        }
        if (str4 == null) {
            str4 = "manual_install";
        } else if ("com.android.vending".equals(str4)) {
            str4 = "";
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = Wrappers.packageManager(context).getApplicationLabel(str);
                if (TextUtils.isEmpty(applicationLabel)) {
                    String str7 = str6;
                } else {
                    charSequence = applicationLabel.toString();
                }
                try {
                    str5 = packageInfo.versionName;
                    i = packageInfo.versionCode;
                } catch (NameNotFoundException e2) {
                    this.zzada.zzgt().zzjg().zze("Error retrieving newly installed package info. appId, appName", zzas.zzbw(str), charSequence);
                    return null;
                }
            }
            this.zzada.zzgw();
            long j2 = 0;
            if (this.zzada.zzgv().zzbc(str)) {
                j2 = j;
            }
            return new zzk(str, str2, str5, (long) i, str4, this.zzada.zzgv().zzhh(), this.zzada.zzgr().zzd(context, str), null, z, false, "", 0, j2, 0, z2, z3, false, str3);
        } catch (NameNotFoundException e3) {
            charSequence = str6;
            this.zzada.zzgt().zzjg().zze("Error retrieving newly installed package info. appId, appName", zzas.zzbw(str), charSequence);
            return null;
        }
    }

    final void zzb(zzfv zzfv, zzk zzk) {
        int i = 0;
        zzaf();
        zzlx();
        if (!TextUtils.isEmpty(zzk.zzafi) || !TextUtils.isEmpty(zzk.zzafv)) {
            if (zzk.zzafr) {
                int zzcv = this.zzada.zzgr().zzcv(zzfv.name);
                String zza;
                if (zzcv != 0) {
                    this.zzada.zzgr();
                    zza = zzfy.zza(zzfv.name, 24, true);
                    if (zzfv.name != null) {
                        i = zzfv.name.length();
                    }
                    this.zzada.zzgr().zza(zzk.packageName, zzcv, "_ev", zza, i);
                    return;
                }
                zzcv = this.zzada.zzgr().zzi(zzfv.name, zzfv.getValue());
                if (zzcv != 0) {
                    this.zzada.zzgr();
                    zza = zzfy.zza(zzfv.name, 24, true);
                    Object value = zzfv.getValue();
                    if (value != null && ((value instanceof String) || (value instanceof CharSequence))) {
                        i = String.valueOf(value).length();
                    }
                    this.zzada.zzgr().zza(zzk.packageName, zzcv, "_ev", zza, i);
                    return;
                }
                Object zzj = this.zzada.zzgr().zzj(zzfv.name, zzfv.getValue());
                if (zzj != null) {
                    if (this.zzada.zzgv().zzbh(zzk.packageName) && "_sno".equals(zzfv.name)) {
                        long j = 0;
                        zzfx zzi = zzjt().zzi(zzk.packageName, "_sno");
                        if (zzi == null || !(zzi.value instanceof Long)) {
                            zzac zzg = zzjt().zzg(zzk.packageName, "_s");
                            if (zzg != null) {
                                j = zzg.zzahv;
                                this.zzada.zzgt().zzjo().zzg("Backfill the session number. Last used session number", Long.valueOf(j));
                            }
                        } else {
                            j = ((Long) zzi.value).longValue();
                        }
                        zzj = Long.valueOf(j + 1);
                    }
                    zzfx zzfx = new zzfx(zzk.packageName, zzfv.origin, zzfv.name, zzfv.zzauk, zzj);
                    this.zzada.zzgt().zzjn().zze("Setting user property", this.zzada.zzgq().zzbv(zzfx.name), zzj);
                    zzjt().beginTransaction();
                    try {
                        zzg(zzk);
                        boolean zza2 = zzjt().zza(zzfx);
                        zzjt().setTransactionSuccessful();
                        if (zza2) {
                            this.zzada.zzgt().zzjn().zze("User property set", this.zzada.zzgq().zzbv(zzfx.name), zzfx.value);
                        } else {
                            this.zzada.zzgt().zzjg().zze("Too many unique user properties are set. Ignoring user property", this.zzada.zzgq().zzbv(zzfx.name), zzfx.value);
                            this.zzada.zzgr().zza(zzk.packageName, 9, null, null, 0);
                        }
                        zzjt().endTransaction();
                        return;
                    } catch (Throwable th) {
                        zzjt().endTransaction();
                    }
                } else {
                    return;
                }
            }
            zzg(zzk);
        }
    }

    final void zzc(zzfv zzfv, zzk zzk) {
        zzaf();
        zzlx();
        if (!TextUtils.isEmpty(zzk.zzafi) || !TextUtils.isEmpty(zzk.zzafv)) {
            if (zzk.zzafr) {
                this.zzada.zzgt().zzjn().zzg("Removing user property", this.zzada.zzgq().zzbv(zzfv.name));
                zzjt().beginTransaction();
                try {
                    zzg(zzk);
                    zzjt().zzh(zzk.packageName, zzfv.name);
                    zzjt().setTransactionSuccessful();
                    this.zzada.zzgt().zzjn().zzg("User property removed", this.zzada.zzgq().zzbv(zzfv.name));
                } finally {
                    zzjt().endTransaction();
                }
            } else {
                zzg(zzk);
            }
        }
    }

    final void zzb(zzfn zzfn) {
        this.zzatt++;
    }

    final void zzmg() {
        this.zzatu++;
    }

    final zzbw zzmh() {
        return this.zzada;
    }

    final void zzf(zzk zzk) {
        zzaf();
        zzlx();
        Preconditions.checkNotNull(zzk);
        Preconditions.checkNotEmpty(zzk.packageName);
        if (!TextUtils.isEmpty(zzk.zzafi) || !TextUtils.isEmpty(zzk.zzafv)) {
            zzg zzbm = zzjt().zzbm(zzk.packageName);
            if (!(zzbm == null || !TextUtils.isEmpty(zzbm.getGmpAppId()) || TextUtils.isEmpty(zzk.zzafi))) {
                zzbm.zzu(0);
                zzjt().zza(zzbm);
                zzls().zzcj(zzk.packageName);
            }
            if (zzk.zzafr) {
                int i;
                Bundle bundle;
                long j = zzk.zzago;
                if (j == 0) {
                    j = this.zzada.zzbx().currentTimeMillis();
                }
                int i2 = zzk.zzagp;
                if (i2 == 0 || i2 == 1) {
                    i = i2;
                } else {
                    this.zzada.zzgt().zzjj().zze("Incorrect app type, assuming installed app. appId, appType", zzas.zzbw(zzk.packageName), Integer.valueOf(i2));
                    i = 0;
                }
                zzjt().beginTransaction();
                zzcr zzjt;
                String zzal;
                try {
                    zzbm = zzjt().zzbm(zzk.packageName);
                    if (zzbm != null) {
                        this.zzada.zzgr();
                        if (zzfy.zza(zzk.zzafi, zzbm.getGmpAppId(), zzk.zzafv, zzbm.zzhb())) {
                            this.zzada.zzgt().zzjj().zzg("New GMP App Id passed in. Removing cached database data. appId", zzas.zzbw(zzbm.zzal()));
                            zzjt = zzjt();
                            zzal = zzbm.zzal();
                            zzjt.zzcl();
                            zzjt.zzaf();
                            Preconditions.checkNotEmpty(zzal);
                            SQLiteDatabase writableDatabase = zzjt.getWritableDatabase();
                            String[] strArr = new String[]{zzal};
                            i2 = writableDatabase.delete("audience_filter_values", "app_id=?", strArr) + ((((((((writableDatabase.delete("events", "app_id=?", strArr) + 0) + writableDatabase.delete("user_attributes", "app_id=?", strArr)) + writableDatabase.delete("conditional_properties", "app_id=?", strArr)) + writableDatabase.delete("apps", "app_id=?", strArr)) + writableDatabase.delete("raw_events", "app_id=?", strArr)) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr)) + writableDatabase.delete("event_filters", "app_id=?", strArr)) + writableDatabase.delete("property_filters", "app_id=?", strArr));
                            if (i2 > 0) {
                                zzjt.zzgt().zzjo().zze("Deleted application data. app, records", zzal, Integer.valueOf(i2));
                            }
                            zzbm = null;
                        }
                    }
                } catch (SQLiteException e) {
                    zzjt.zzgt().zzjg().zze("Error deleting application data. appId, error", zzas.zzbw(zzal), e);
                } catch (Throwable th) {
                    zzjt().endTransaction();
                }
                if (zzbm != null) {
                    if (zzbm.zzhf() != -2147483648L) {
                        if (zzbm.zzhf() != zzk.zzafo) {
                            bundle = new Bundle();
                            bundle.putString("_pv", zzbm.zzak());
                            zzc(new zzag("_au", new zzad(bundle), "auto", j), zzk);
                        }
                    } else if (!(zzbm.zzak() == null || zzbm.zzak().equals(zzk.zzts))) {
                        bundle = new Bundle();
                        bundle.putString("_pv", zzbm.zzak());
                        zzc(new zzag("_au", new zzad(bundle), "auto", j), zzk);
                    }
                }
                zzg(zzk);
                zzac zzac = null;
                if (i == 0) {
                    zzac = zzjt().zzg(zzk.packageName, "_f");
                } else if (i == 1) {
                    zzac = zzjt().zzg(zzk.packageName, "_v");
                }
                if (zzac == null) {
                    long j2 = (1 + (j / 3600000)) * 3600000;
                    if (i == 0) {
                        zzb(new zzfv("_fot", j, Long.valueOf(j2), "auto"), zzk);
                        if (this.zzada.zzgv().zzbe(zzk.zzafi)) {
                            zzaf();
                            this.zzada.zzkk().zzce(zzk.packageName);
                        }
                        zzaf();
                        zzlx();
                        Bundle bundle2 = new Bundle();
                        bundle2.putLong("_c", 1);
                        bundle2.putLong("_r", 1);
                        bundle2.putLong("_uwa", 0);
                        bundle2.putLong("_pfo", 0);
                        bundle2.putLong("_sys", 0);
                        bundle2.putLong("_sysu", 0);
                        if (this.zzada.zzgv().zzbk(zzk.packageName)) {
                            bundle2.putLong("_et", 1);
                        }
                        if (this.zzada.zzgv().zzba(zzk.packageName) && zzk.zzagq) {
                            bundle2.putLong("_dac", 1);
                        }
                        if (this.zzada.getContext().getPackageManager() == null) {
                            this.zzada.zzgt().zzjg().zzg("PackageManager is null, first open report might be inaccurate. appId", zzas.zzbw(zzk.packageName));
                        } else {
                            ApplicationInfo applicationInfo;
                            PackageInfo packageInfo = null;
                            try {
                                packageInfo = Wrappers.packageManager(this.zzada.getContext()).getPackageInfo(zzk.packageName, 0);
                            } catch (NameNotFoundException e2) {
                                this.zzada.zzgt().zzjg().zze("Package info is null, first open report might be inaccurate. appId", zzas.zzbw(zzk.packageName), e2);
                            }
                            if (packageInfo != null) {
                                if (packageInfo.firstInstallTime != 0) {
                                    Object obj = null;
                                    if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                        bundle2.putLong("_uwa", 1);
                                    } else {
                                        obj = 1;
                                    }
                                    zzb(new zzfv("_fi", j, Long.valueOf(obj != null ? 1 : 0), "auto"), zzk);
                                }
                            }
                            try {
                                applicationInfo = Wrappers.packageManager(this.zzada.getContext()).getApplicationInfo(zzk.packageName, 0);
                            } catch (NameNotFoundException e22) {
                                this.zzada.zzgt().zzjg().zze("Application info is null, first open report might be inaccurate. appId", zzas.zzbw(zzk.packageName), e22);
                                applicationInfo = null;
                            }
                            if (applicationInfo != null) {
                                if ((applicationInfo.flags & 1) != 0) {
                                    bundle2.putLong("_sys", 1);
                                }
                                if ((applicationInfo.flags & 128) != 0) {
                                    bundle2.putLong("_sysu", 1);
                                }
                            }
                        }
                        zzcr zzjt2 = zzjt();
                        String str = zzk.packageName;
                        Preconditions.checkNotEmpty(str);
                        zzjt2.zzaf();
                        zzjt2.zzcl();
                        j2 = zzjt2.zzn(str, "first_open_count");
                        if (j2 >= 0) {
                            bundle2.putLong("_pfo", j2);
                        }
                        zzc(new zzag("_f", new zzad(bundle2), "auto", j), zzk);
                    } else if (i == 1) {
                        zzb(new zzfv("_fvt", j, Long.valueOf(j2), "auto"), zzk);
                        zzaf();
                        zzlx();
                        bundle = new Bundle();
                        bundle.putLong("_c", 1);
                        bundle.putLong("_r", 1);
                        if (this.zzada.zzgv().zzbk(zzk.packageName)) {
                            bundle.putLong("_et", 1);
                        }
                        if (this.zzada.zzgv().zzba(zzk.packageName) && zzk.zzagq) {
                            bundle.putLong("_dac", 1);
                        }
                        zzc(new zzag("_v", new zzad(bundle), "auto", j), zzk);
                    }
                    if (!this.zzada.zzgv().zze(zzk.packageName, zzai.zzala)) {
                        bundle = new Bundle();
                        bundle.putLong("_et", 1);
                        if (this.zzada.zzgv().zzbk(zzk.packageName)) {
                            bundle.putLong("_fr", 1);
                        }
                        zzc(new zzag("_e", new zzad(bundle), "auto", j), zzk);
                    }
                } else if (zzk.zzagn) {
                    zzc(new zzag("_cd", new zzad(new Bundle()), "auto", j), zzk);
                }
                zzjt().setTransactionSuccessful();
                zzjt().endTransaction();
                return;
            }
            zzg(zzk);
        }
    }

    private final zzk zzcr(String str) {
        zzg zzbm = zzjt().zzbm(str);
        if (zzbm == null || TextUtils.isEmpty(zzbm.zzak())) {
            this.zzada.zzgt().zzjn().zzg("No app data available; dropping", str);
            return null;
        }
        Boolean zzc = zzc(zzbm);
        if (zzc == null || zzc.booleanValue()) {
            return new zzk(str, zzbm.getGmpAppId(), zzbm.zzak(), zzbm.zzhf(), zzbm.zzhg(), zzbm.zzhh(), zzbm.zzhi(), null, zzbm.isMeasurementEnabled(), false, zzbm.getFirebaseInstanceId(), zzbm.zzhv(), 0, 0, zzbm.zzhw(), zzbm.zzhx(), false, zzbm.zzhb());
        }
        this.zzada.zzgt().zzjg().zzg("App version does not match; dropping. appId", zzas.zzbw(str));
        return null;
    }

    final void zze(zzo zzo) {
        zzk zzcr = zzcr(zzo.packageName);
        if (zzcr != null) {
            zzb(zzo, zzcr);
        }
    }

    final void zzb(zzo zzo, zzk zzk) {
        boolean z = true;
        Preconditions.checkNotNull(zzo);
        Preconditions.checkNotEmpty(zzo.packageName);
        Preconditions.checkNotNull(zzo.origin);
        Preconditions.checkNotNull(zzo.zzags);
        Preconditions.checkNotEmpty(zzo.zzags.name);
        zzaf();
        zzlx();
        if (!TextUtils.isEmpty(zzk.zzafi) || !TextUtils.isEmpty(zzk.zzafv)) {
            if (zzk.zzafr) {
                zzo zzo2 = new zzo(zzo);
                zzo2.active = false;
                zzjt().beginTransaction();
                try {
                    zzo zzj = zzjt().zzj(zzo2.packageName, zzo2.zzags.name);
                    if (!(zzj == null || zzj.origin.equals(zzo2.origin))) {
                        this.zzada.zzgt().zzjj().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzada.zzgq().zzbv(zzo2.zzags.name), zzo2.origin, zzj.origin);
                    }
                    if (zzj != null && zzj.active) {
                        zzo2.origin = zzj.origin;
                        zzo2.creationTimestamp = zzj.creationTimestamp;
                        zzo2.triggerTimeout = zzj.triggerTimeout;
                        zzo2.triggerEventName = zzj.triggerEventName;
                        zzo2.zzagu = zzj.zzagu;
                        zzo2.active = zzj.active;
                        zzo2.zzags = new zzfv(zzo2.zzags.name, zzj.zzags.zzauk, zzo2.zzags.getValue(), zzj.zzags.origin);
                        z = false;
                    } else if (TextUtils.isEmpty(zzo2.triggerEventName)) {
                        zzo2.zzags = new zzfv(zzo2.zzags.name, zzo2.creationTimestamp, zzo2.zzags.getValue(), zzo2.zzags.origin);
                        zzo2.active = true;
                    } else {
                        z = false;
                    }
                    if (zzo2.active) {
                        zzfv zzfv = zzo2.zzags;
                        zzfx zzfx = new zzfx(zzo2.packageName, zzo2.origin, zzfv.name, zzfv.zzauk, zzfv.getValue());
                        if (zzjt().zza(zzfx)) {
                            this.zzada.zzgt().zzjn().zzd("User property updated immediately", zzo2.packageName, this.zzada.zzgq().zzbv(zzfx.name), zzfx.value);
                        } else {
                            this.zzada.zzgt().zzjg().zzd("(2)Too many active user properties, ignoring", zzas.zzbw(zzo2.packageName), this.zzada.zzgq().zzbv(zzfx.name), zzfx.value);
                        }
                        if (z && zzo2.zzagu != null) {
                            zzd(new zzag(zzo2.zzagu, zzo2.creationTimestamp), zzk);
                        }
                    }
                    if (zzjt().zza(zzo2)) {
                        this.zzada.zzgt().zzjn().zzd("Conditional property added", zzo2.packageName, this.zzada.zzgq().zzbv(zzo2.zzags.name), zzo2.zzags.getValue());
                    } else {
                        this.zzada.zzgt().zzjg().zzd("Too many conditional properties, ignoring", zzas.zzbw(zzo2.packageName), this.zzada.zzgq().zzbv(zzo2.zzags.name), zzo2.zzags.getValue());
                    }
                    zzjt().setTransactionSuccessful();
                } finally {
                    zzjt().endTransaction();
                }
            } else {
                zzg(zzk);
            }
        }
    }

    final void zzf(zzo zzo) {
        zzk zzcr = zzcr(zzo.packageName);
        if (zzcr != null) {
            zzc(zzo, zzcr);
        }
    }

    final void zzc(zzo zzo, zzk zzk) {
        Preconditions.checkNotNull(zzo);
        Preconditions.checkNotEmpty(zzo.packageName);
        Preconditions.checkNotNull(zzo.zzags);
        Preconditions.checkNotEmpty(zzo.zzags.name);
        zzaf();
        zzlx();
        if (!TextUtils.isEmpty(zzk.zzafi) || !TextUtils.isEmpty(zzk.zzafv)) {
            if (zzk.zzafr) {
                zzjt().beginTransaction();
                try {
                    zzg(zzk);
                    zzo zzj = zzjt().zzj(zzo.packageName, zzo.zzags.name);
                    if (zzj != null) {
                        this.zzada.zzgt().zzjn().zze("Removing conditional user property", zzo.packageName, this.zzada.zzgq().zzbv(zzo.zzags.name));
                        zzjt().zzk(zzo.packageName, zzo.zzags.name);
                        if (zzj.active) {
                            zzjt().zzh(zzo.packageName, zzo.zzags.name);
                        }
                        if (zzo.zzagv != null) {
                            Bundle bundle = null;
                            if (zzo.zzagv.zzahu != null) {
                                bundle = zzo.zzagv.zzahu.zziy();
                            }
                            zzd(this.zzada.zzgr().zza(zzo.packageName, zzo.zzagv.name, bundle, zzj.origin, zzo.zzagv.zzaig, true, false), zzk);
                        }
                    } else {
                        this.zzada.zzgt().zzjj().zze("Conditional user property doesn't exist", zzas.zzbw(zzo.packageName), this.zzada.zzgq().zzbv(zzo.zzags.name));
                    }
                    zzjt().setTransactionSuccessful();
                } finally {
                    zzjt().endTransaction();
                }
            } else {
                zzg(zzk);
            }
        }
    }

    private final zzg zzg(zzk zzk) {
        Object obj = 1;
        zzaf();
        zzlx();
        Preconditions.checkNotNull(zzk);
        Preconditions.checkNotEmpty(zzk.packageName);
        zzg zzbm = zzjt().zzbm(zzk.packageName);
        String zzca = this.zzada.zzgu().zzca(zzk.packageName);
        Object obj2 = null;
        if (zzbm == null) {
            zzbm = new zzg(this.zzada, zzk.packageName);
            zzbm.zzaj(this.zzada.zzgr().zzmm());
            zzbm.zzam(zzca);
            obj2 = 1;
        } else if (!zzca.equals(zzbm.zzhc())) {
            zzbm.zzam(zzca);
            zzbm.zzaj(this.zzada.zzgr().zzmm());
            int i = 1;
        }
        if (!TextUtils.equals(zzk.zzafi, zzbm.getGmpAppId())) {
            zzbm.zzak(zzk.zzafi);
            obj2 = 1;
        }
        if (!TextUtils.equals(zzk.zzafv, zzbm.zzhb())) {
            zzbm.zzal(zzk.zzafv);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(zzk.zzafk) || zzk.zzafk.equals(zzbm.getFirebaseInstanceId()))) {
            zzbm.zzan(zzk.zzafk);
            obj2 = 1;
        }
        if (!(zzk.zzade == 0 || zzk.zzade == zzbm.zzhh())) {
            zzbm.zzr(zzk.zzade);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(zzk.zzts) || zzk.zzts.equals(zzbm.zzak()))) {
            zzbm.setAppVersion(zzk.zzts);
            obj2 = 1;
        }
        if (zzk.zzafo != zzbm.zzhf()) {
            zzbm.zzq(zzk.zzafo);
            obj2 = 1;
        }
        if (!(zzk.zzafp == null || zzk.zzafp.equals(zzbm.zzhg()))) {
            zzbm.zzao(zzk.zzafp);
            obj2 = 1;
        }
        if (zzk.zzafq != zzbm.zzhi()) {
            zzbm.zzs(zzk.zzafq);
            obj2 = 1;
        }
        if (zzk.zzafr != zzbm.isMeasurementEnabled()) {
            zzbm.setMeasurementEnabled(zzk.zzafr);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(zzk.zzagm) || zzk.zzagm.equals(zzbm.zzht()))) {
            zzbm.zzap(zzk.zzagm);
            obj2 = 1;
        }
        if (zzk.zzafs != zzbm.zzhv()) {
            zzbm.zzac(zzk.zzafs);
            obj2 = 1;
        }
        if (zzk.zzaft != zzbm.zzhw()) {
            zzbm.zze(zzk.zzaft);
            obj2 = 1;
        }
        if (zzk.zzafu != zzbm.zzhx()) {
            zzbm.zzf(zzk.zzafu);
        } else {
            obj = obj2;
        }
        if (obj != null) {
            zzjt().zza(zzbm);
        }
        return zzbm;
    }

    final String zzh(zzk zzk) {
        Object e;
        try {
            return (String) this.zzada.zzgs().zzb(new zzfs(this, zzk)).get(30000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e2) {
            e = e2;
        } catch (InterruptedException e3) {
            e = e3;
        } catch (ExecutionException e4) {
            e = e4;
        }
        this.zzada.zzgt().zzjg().zze("Failed to get app instance id. appId", zzas.zzbw(zzk.packageName), e);
        return null;
    }

    final void zzm(boolean z) {
        zzmb();
    }
}
