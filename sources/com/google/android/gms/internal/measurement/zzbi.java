package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.zza;
import com.google.android.gms.analytics.zzg;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.analytics.zzj;
import com.google.android.gms.analytics.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class zzbi extends zzau {
    private boolean started;
    private final zzbf zzxl;
    private final zzcr zzxm;
    private final zzcq zzxn;
    private final zzba zzxo;
    private long zzxp = Long.MIN_VALUE;
    private final zzbz zzxq;
    private final zzbz zzxr;
    private final zzdc zzxs;
    private long zzxt;
    private boolean zzxu;

    protected zzbi(zzaw zzaw, zzay zzay) {
        super(zzaw);
        Preconditions.checkNotNull(zzay);
        this.zzxn = new zzcq(zzaw);
        this.zzxl = new zzbf(zzaw);
        this.zzxm = new zzcr(zzaw);
        this.zzxo = new zzba(zzaw);
        this.zzxs = new zzdc(zzbx());
        this.zzxq = new zzbj(this, zzaw);
        this.zzxr = new zzbk(this, zzaw);
    }

    protected final void zzag() {
        this.zzxl.zzq();
        this.zzxm.zzq();
        this.zzxo.zzq();
    }

    final void start() {
        zzcl();
        Preconditions.checkState(!this.started, "Analytics backend already started");
        this.started = true;
        zzca().zza(new zzbl(this));
    }

    private final boolean zzx(String str) {
        return Wrappers.packageManager(getContext()).checkCallingOrSelfPermission(str) == 0;
    }

    protected final void zzdg() {
        zzcl();
        zzk.zzaf();
        Context context = zzbw().getContext();
        if (!zzcw.zza(context)) {
            zzt("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!zzcx.zze(context)) {
            zzu("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.zza(context)) {
            zzt("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        zzcf().zzff();
        if (!zzx("android.permission.ACCESS_NETWORK_STATE")) {
            zzu("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzdq();
        }
        if (!zzx("android.permission.INTERNET")) {
            zzu("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzdq();
        }
        if (zzcx.zze(getContext())) {
            zzq("AnalyticsService registered in the app manifest and enabled");
        } else {
            zzt("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!(this.zzxu || this.zzxl.isEmpty())) {
            zzdj();
        }
        zzdm();
    }

    private final void zzdh() {
        zzb(new zzbm(this));
    }

    final void zzbv() {
        zzk.zzaf();
        this.zzxt = zzbx().currentTimeMillis();
    }

    protected final void onServiceConnected() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/587003819.run(Unknown Source)
*/
        /*
        r6 = this;
        com.google.android.gms.analytics.zzk.zzaf();
        com.google.android.gms.analytics.zzk.zzaf();
        r6.zzcl();
        r0 = com.google.android.gms.internal.measurement.zzbx.zzdx();
        if (r0 != 0) goto L_0x0014;
    L_0x000f:
        r0 = "Service client disabled. Can't dispatch local hits to device AnalyticsService";
        r6.zzt(r0);
    L_0x0014:
        r0 = r6.zzxo;
        r0 = r0.isConnected();
        if (r0 != 0) goto L_0x0022;
    L_0x001c:
        r0 = "Service not connected";
        r6.zzq(r0);
    L_0x0021:
        return;
    L_0x0022:
        r0 = r6.zzxl;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x0021;
    L_0x002a:
        r0 = "Dispatching local hits to device AnalyticsService";
        r6.zzq(r0);
    L_0x002f:
        r0 = r6.zzxl;	 Catch:{ SQLiteException -> 0x0044 }
        r1 = com.google.android.gms.internal.measurement.zzbx.zzeb();	 Catch:{ SQLiteException -> 0x0044 }
        r2 = (long) r1;	 Catch:{ SQLiteException -> 0x0044 }
        r1 = r0.zzd(r2);	 Catch:{ SQLiteException -> 0x0044 }
        r0 = r1.isEmpty();	 Catch:{ SQLiteException -> 0x0044 }
        if (r0 == 0) goto L_0x005a;	 Catch:{ SQLiteException -> 0x0044 }
    L_0x0040:
        r6.zzdm();	 Catch:{ SQLiteException -> 0x0044 }
        goto L_0x0021;
    L_0x0044:
        r0 = move-exception;
        r1 = "Failed to read hits from store";
        r6.zze(r1, r0);
        r6.zzdo();
        goto L_0x0021;
    L_0x004e:
        r1.remove(r0);
        r2 = r6.zzxl;	 Catch:{ SQLiteException -> 0x0073 }
        r4 = r0.zzeq();	 Catch:{ SQLiteException -> 0x0073 }
        r2.zze(r4);	 Catch:{ SQLiteException -> 0x0073 }
    L_0x005a:
        r0 = r1.isEmpty();
        if (r0 != 0) goto L_0x002f;
    L_0x0060:
        r0 = 0;
        r0 = r1.get(r0);
        r0 = (com.google.android.gms.internal.measurement.zzck) r0;
        r2 = r6.zzxo;
        r2 = r2.zzb(r0);
        if (r2 != 0) goto L_0x004e;
    L_0x006f:
        r6.zzdm();
        goto L_0x0021;
    L_0x0073:
        r0 = move-exception;
        r1 = "Failed to remove hit that was send for delivery";
        r6.zze(r1, r0);
        r6.zzdo();
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbi.onServiceConnected():void");
    }

    private final void zzdi() {
        try {
            this.zzxl.zzdb();
            zzdm();
        } catch (SQLiteException e) {
            zzd("Failed to delete stale hits", e);
        }
        this.zzxr.zzh(86400000);
    }

    protected final void zzb(zzaz zzaz) {
        zzk.zzaf();
        zzb("Sending first hit to property", zzaz.zzct());
        if (!zzcf().zzfg().zzj(zzbx.zzeh())) {
            String zzfj = zzcf().zzfj();
            if (!TextUtils.isEmpty(zzfj)) {
                zzy zza = zzdg.zza(zzby(), zzfj);
                zzb("Found relevant installation campaign", zza);
                zza(zzaz, zza);
            }
        }
    }

    public final void zzg(long j) {
        zzk.zzaf();
        zzcl();
        if (j < 0) {
            j = 0;
        }
        this.zzxp = j;
        zzdm();
    }

    private final void zzdj() {
        if (!this.zzxu && zzbx.zzdx() && !this.zzxo.isConnected()) {
            if (this.zzxs.zzj(((Long) zzcf.zzaaj.get()).longValue())) {
                this.zzxs.start();
                zzq("Connecting to service");
                if (this.zzxo.connect()) {
                    zzq("Connected to service");
                    this.zzxs.clear();
                    onServiceConnected();
                }
            }
        }
    }

    public final long zza(zzaz zzaz, boolean z) {
        Preconditions.checkNotNull(zzaz);
        zzcl();
        zzk.zzaf();
        try {
            String str;
            this.zzxl.beginTransaction();
            zzat zzat = this.zzxl;
            long zzcs = zzaz.zzcs();
            Preconditions.checkNotEmpty(zzaz.zzbd());
            zzat.zzcl();
            zzk.zzaf();
            int delete = zzat.getWritableDatabase().delete("properties", "app_uid=? AND cid<>?", new String[]{String.valueOf(zzcs), str});
            if (delete > 0) {
                zzat.zza("Deleted property records", Integer.valueOf(delete));
            }
            zzcs = this.zzxl.zza(zzaz.zzcs(), zzaz.zzbd(), zzaz.zzct());
            zzaz.zzb(1 + zzcs);
            zzat zzat2 = this.zzxl;
            Preconditions.checkNotNull(zzaz);
            zzat2.zzcl();
            zzk.zzaf();
            SQLiteDatabase writableDatabase = zzat2.getWritableDatabase();
            Map zzcw = zzaz.zzcw();
            Preconditions.checkNotNull(zzcw);
            Builder builder = new Builder();
            for (Entry entry : zzcw.entrySet()) {
                builder.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
            }
            String encodedQuery = builder.build().getEncodedQuery();
            if (encodedQuery == null) {
                str = "";
            } else {
                str = encodedQuery;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_uid", Long.valueOf(zzaz.zzcs()));
            contentValues.put("cid", zzaz.zzbd());
            contentValues.put("tid", zzaz.zzct());
            contentValues.put("adid", Integer.valueOf(zzaz.zzcu() ? 1 : 0));
            contentValues.put("hits_count", Long.valueOf(zzaz.zzcv()));
            contentValues.put("params", str);
            try {
                if (writableDatabase.insertWithOnConflict("properties", null, contentValues, 5) == -1) {
                    zzat2.zzu("Failed to insert/update a property (got -1)");
                }
            } catch (SQLiteException e) {
                zzat2.zze("Error storing a property", e);
            }
            this.zzxl.setTransactionSuccessful();
            try {
                this.zzxl.endTransaction();
            } catch (SQLiteException e2) {
                zze("Failed to end transaction", e2);
            }
            return zzcs;
        } catch (SQLiteException e22) {
            zze("Failed to update Analytics property", e22);
            try {
                this.zzxl.endTransaction();
            } catch (SQLiteException e222) {
                zze("Failed to end transaction", e222);
            }
            return -1;
        } catch (Throwable th) {
            try {
                this.zzxl.endTransaction();
            } catch (SQLiteException e3) {
                zze("Failed to end transaction", e3);
            }
            throw th;
        }
    }

    public final void zza(zzck zzck) {
        Preconditions.checkNotNull(zzck);
        zzk.zzaf();
        zzcl();
        if (this.zzxu) {
            zzr("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            zza("Delivering hit", zzck);
        }
        if (TextUtils.isEmpty(zzck.zzev())) {
            Pair zzfm = zzcf().zzfk().zzfm();
            if (zzfm != null) {
                Long l = (Long) zzfm.second;
                String str = (String) zzfm.first;
                String valueOf = String.valueOf(l);
                valueOf = new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()).append(valueOf).append(":").append(str).toString();
                Map hashMap = new HashMap(zzck.zzcw());
                hashMap.put("_m", valueOf);
                zzck = new zzck(this, hashMap, zzck.zzer(), zzck.zzet(), zzck.zzeq(), zzck.zzep(), zzck.zzes());
            }
        }
        zzdj();
        if (this.zzxo.zzb(zzck)) {
            zzr("Hit sent to the device AnalyticsService for delivery");
            return;
        }
        try {
            this.zzxl.zzc(zzck);
            zzdm();
        } catch (SQLiteException e) {
            zze("Delivery failed to save hit to a database", e);
            zzby().zza(zzck, "deliver: failed to insert hit to database");
        }
    }

    public final void zzbr() {
        zzk.zzaf();
        zzcl();
        zzq("Delete all hits from local store");
        try {
            zzau zzau = this.zzxl;
            zzk.zzaf();
            zzau.zzcl();
            zzau.getWritableDatabase().delete("hits2", null, null);
            zzau = this.zzxl;
            zzk.zzaf();
            zzau.zzcl();
            zzau.getWritableDatabase().delete("properties", null, null);
            zzdm();
        } catch (SQLiteException e) {
            zzd("Failed to delete hits from store", e);
        }
        zzdj();
        if (this.zzxo.zzcx()) {
            zzq("Device service unavailable. Can't clear hits stored on the device service.");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzdk() {
        /*
        r12 = this;
        r1 = 1;
        r2 = 0;
        com.google.android.gms.analytics.zzk.zzaf();
        r12.zzcl();
        r0 = "Dispatching a batch of local hits";
        r12.zzq(r0);
        r0 = r12.zzxo;
        r0 = r0.isConnected();
        if (r0 != 0) goto L_0x0028;
    L_0x0015:
        r0 = r1;
    L_0x0016:
        r3 = r12.zzxm;
        r3 = r3.zzfb();
        if (r3 != 0) goto L_0x002a;
    L_0x001e:
        if (r0 == 0) goto L_0x002c;
    L_0x0020:
        if (r1 == 0) goto L_0x002c;
    L_0x0022:
        r0 = "No network or service available. Will retry later";
        r12.zzq(r0);
    L_0x0027:
        return r2;
    L_0x0028:
        r0 = r2;
        goto L_0x0016;
    L_0x002a:
        r1 = r2;
        goto L_0x001e;
    L_0x002c:
        r0 = com.google.android.gms.internal.measurement.zzbx.zzeb();
        r1 = com.google.android.gms.internal.measurement.zzbx.zzec();
        r0 = java.lang.Math.max(r0, r1);
        r6 = (long) r0;
        r3 = new java.util.ArrayList;
        r3.<init>();
        r4 = 0;
    L_0x0040:
        r0 = r12.zzxl;	 Catch:{ all -> 0x01cf }
        r0.beginTransaction();	 Catch:{ all -> 0x01cf }
        r3.clear();	 Catch:{ all -> 0x01cf }
        r0 = r12.zzxl;	 Catch:{ SQLiteException -> 0x00c1 }
        r8 = r0.zzd(r6);	 Catch:{ SQLiteException -> 0x00c1 }
        r0 = r8.isEmpty();	 Catch:{ SQLiteException -> 0x00c1 }
        if (r0 == 0) goto L_0x0071;
    L_0x0054:
        r0 = "Store is empty, nothing to dispatch";
        r12.zzq(r0);	 Catch:{ SQLiteException -> 0x00c1 }
        r12.zzdo();	 Catch:{ SQLiteException -> 0x00c1 }
        r0 = r12.zzxl;	 Catch:{ SQLiteException -> 0x0067 }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x0067 }
        r0 = r12.zzxl;	 Catch:{ SQLiteException -> 0x0067 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x0067 }
        goto L_0x0027;
    L_0x0067:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.zzdo();
        goto L_0x0027;
    L_0x0071:
        r0 = "Hits loaded from store. count";
        r1 = r8.size();	 Catch:{ SQLiteException -> 0x00c1 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x00c1 }
        r12.zza(r0, r1);	 Catch:{ SQLiteException -> 0x00c1 }
        r1 = r8.iterator();	 Catch:{ all -> 0x01cf }
    L_0x0082:
        r0 = r1.hasNext();	 Catch:{ all -> 0x01cf }
        if (r0 == 0) goto L_0x00e1;
    L_0x0088:
        r0 = r1.next();	 Catch:{ all -> 0x01cf }
        r0 = (com.google.android.gms.internal.measurement.zzck) r0;	 Catch:{ all -> 0x01cf }
        r10 = r0.zzeq();	 Catch:{ all -> 0x01cf }
        r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x0082;
    L_0x0096:
        r0 = "Database contains successfully uploaded hit";
        r1 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x01cf }
        r3 = r8.size();	 Catch:{ all -> 0x01cf }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x01cf }
        r12.zzd(r0, r1, r3);	 Catch:{ all -> 0x01cf }
        r12.zzdo();	 Catch:{ all -> 0x01cf }
        r0 = r12.zzxl;	 Catch:{ SQLiteException -> 0x00b6 }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x00b6 }
        r0 = r12.zzxl;	 Catch:{ SQLiteException -> 0x00b6 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x00b6 }
        goto L_0x0027;
    L_0x00b6:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.zzdo();
        goto L_0x0027;
    L_0x00c1:
        r0 = move-exception;
        r1 = "Failed to read hits from persisted store";
        r12.zzd(r1, r0);	 Catch:{ all -> 0x01cf }
        r12.zzdo();	 Catch:{ all -> 0x01cf }
        r0 = r12.zzxl;	 Catch:{ SQLiteException -> 0x00d6 }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x00d6 }
        r0 = r12.zzxl;	 Catch:{ SQLiteException -> 0x00d6 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x00d6 }
        goto L_0x0027;
    L_0x00d6:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.zzdo();
        goto L_0x0027;
    L_0x00e1:
        r0 = r12.zzxo;	 Catch:{ all -> 0x01cf }
        r0 = r0.isConnected();	 Catch:{ all -> 0x01cf }
        if (r0 == 0) goto L_0x0148;
    L_0x00e9:
        r0 = "Service connected, sending hits to the service";
        r12.zzq(r0);	 Catch:{ all -> 0x01cf }
    L_0x00ee:
        r0 = r8.isEmpty();	 Catch:{ all -> 0x01cf }
        if (r0 != 0) goto L_0x0148;
    L_0x00f4:
        r0 = 0;
        r0 = r8.get(r0);	 Catch:{ all -> 0x01cf }
        r0 = (com.google.android.gms.internal.measurement.zzck) r0;	 Catch:{ all -> 0x01cf }
        r1 = r12.zzxo;	 Catch:{ all -> 0x01cf }
        r1 = r1.zzb(r0);	 Catch:{ all -> 0x01cf }
        if (r1 == 0) goto L_0x0148;
    L_0x0103:
        r10 = r0.zzeq();	 Catch:{ all -> 0x01cf }
        r4 = java.lang.Math.max(r4, r10);	 Catch:{ all -> 0x01cf }
        r8.remove(r0);	 Catch:{ all -> 0x01cf }
        r1 = "Hit sent do device AnalyticsService for delivery";
        r12.zzb(r1, r0);	 Catch:{ all -> 0x01cf }
        r1 = r12.zzxl;	 Catch:{ SQLiteException -> 0x0128 }
        r10 = r0.zzeq();	 Catch:{ SQLiteException -> 0x0128 }
        r1.zze(r10);	 Catch:{ SQLiteException -> 0x0128 }
        r0 = r0.zzeq();	 Catch:{ SQLiteException -> 0x0128 }
        r0 = java.lang.Long.valueOf(r0);	 Catch:{ SQLiteException -> 0x0128 }
        r3.add(r0);	 Catch:{ SQLiteException -> 0x0128 }
        goto L_0x00ee;
    L_0x0128:
        r0 = move-exception;
        r1 = "Failed to remove hit that was send for delivery";
        r12.zze(r1, r0);	 Catch:{ all -> 0x01cf }
        r12.zzdo();	 Catch:{ all -> 0x01cf }
        r0 = r12.zzxl;	 Catch:{ SQLiteException -> 0x013d }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x013d }
        r0 = r12.zzxl;	 Catch:{ SQLiteException -> 0x013d }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x013d }
        goto L_0x0027;
    L_0x013d:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.zzdo();
        goto L_0x0027;
    L_0x0148:
        r0 = r4;
        r4 = r12.zzxm;	 Catch:{ all -> 0x01cf }
        r4 = r4.zzfb();	 Catch:{ all -> 0x01cf }
        if (r4 == 0) goto L_0x017a;
    L_0x0151:
        r4 = r12.zzxm;	 Catch:{ all -> 0x01cf }
        r8 = r4.zzb(r8);	 Catch:{ all -> 0x01cf }
        r9 = r8.iterator();	 Catch:{ all -> 0x01cf }
        r4 = r0;
    L_0x015c:
        r0 = r9.hasNext();	 Catch:{ all -> 0x01cf }
        if (r0 == 0) goto L_0x0171;
    L_0x0162:
        r0 = r9.next();	 Catch:{ all -> 0x01cf }
        r0 = (java.lang.Long) r0;	 Catch:{ all -> 0x01cf }
        r0 = r0.longValue();	 Catch:{ all -> 0x01cf }
        r4 = java.lang.Math.max(r4, r0);	 Catch:{ all -> 0x01cf }
        goto L_0x015c;
    L_0x0171:
        r0 = r12.zzxl;	 Catch:{ SQLiteException -> 0x0197 }
        r0.zza(r8);	 Catch:{ SQLiteException -> 0x0197 }
        r3.addAll(r8);	 Catch:{ SQLiteException -> 0x0197 }
        r0 = r4;
    L_0x017a:
        r4 = r3.isEmpty();	 Catch:{ all -> 0x01cf }
        if (r4 == 0) goto L_0x01b7;
    L_0x0180:
        r0 = r12.zzxl;	 Catch:{ SQLiteException -> 0x018c }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x018c }
        r0 = r12.zzxl;	 Catch:{ SQLiteException -> 0x018c }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x018c }
        goto L_0x0027;
    L_0x018c:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.zzdo();
        goto L_0x0027;
    L_0x0197:
        r0 = move-exception;
        r1 = "Failed to remove successfully uploaded hits";
        r12.zze(r1, r0);	 Catch:{ all -> 0x01cf }
        r12.zzdo();	 Catch:{ all -> 0x01cf }
        r0 = r12.zzxl;	 Catch:{ SQLiteException -> 0x01ac }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01ac }
        r0 = r12.zzxl;	 Catch:{ SQLiteException -> 0x01ac }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x01ac }
        goto L_0x0027;
    L_0x01ac:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.zzdo();
        goto L_0x0027;
    L_0x01b7:
        r4 = r12.zzxl;	 Catch:{ SQLiteException -> 0x01c4 }
        r4.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01c4 }
        r4 = r12.zzxl;	 Catch:{ SQLiteException -> 0x01c4 }
        r4.endTransaction();	 Catch:{ SQLiteException -> 0x01c4 }
        r4 = r0;
        goto L_0x0040;
    L_0x01c4:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.zzdo();
        goto L_0x0027;
    L_0x01cf:
        r0 = move-exception;
        r1 = r12.zzxl;	 Catch:{ SQLiteException -> 0x01db }
        r1.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01db }
        r1 = r12.zzxl;	 Catch:{ SQLiteException -> 0x01db }
        r1.endTransaction();	 Catch:{ SQLiteException -> 0x01db }
        throw r0;
    L_0x01db:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.zzdo();
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbi.zzdk():boolean");
    }

    public final void zzb(zzcd zzcd) {
        long j = this.zzxt;
        zzk.zzaf();
        zzcl();
        long j2 = -1;
        long zzfh = zzcf().zzfh();
        if (zzfh != 0) {
            j2 = Math.abs(zzbx().currentTimeMillis() - zzfh);
        }
        zzb("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(j2));
        zzdj();
        try {
            zzdk();
            zzcf().zzfi();
            zzdm();
            if (zzcd != null) {
                zzcd.zza(null);
            }
            if (this.zzxt != j) {
                this.zzxn.zzfa();
            }
        } catch (Throwable e) {
            zze("Local dispatch failed", e);
            zzcf().zzfi();
            zzdm();
            if (zzcd != null) {
                zzcd.zza(e);
            }
        }
    }

    public final void zzdl() {
        zzk.zzaf();
        zzcl();
        zzr("Sync dispatching local hits");
        long j = this.zzxt;
        zzdj();
        try {
            zzdk();
            zzcf().zzfi();
            zzdm();
            if (this.zzxt != j) {
                this.zzxn.zzfa();
            }
        } catch (Exception e) {
            zze("Sync local dispatch failed", e);
            zzdm();
        }
    }

    private final long zzdc() {
        zzk.zzaf();
        zzcl();
        try {
            return this.zzxl.zzdc();
        } catch (SQLiteException e) {
            zze("Failed to get min/max hit times from local store", e);
            return 0;
        }
    }

    public final void zzdm() {
        zzk.zzaf();
        zzcl();
        Object obj = (this.zzxu || zzdp() <= 0) ? null : 1;
        if (obj == null) {
            this.zzxn.unregister();
            zzdo();
        } else if (this.zzxl.isEmpty()) {
            this.zzxn.unregister();
            zzdo();
        } else {
            boolean z;
            if (((Boolean) zzcf.zzaae.get()).booleanValue()) {
                z = true;
            } else {
                this.zzxn.zzey();
                z = this.zzxn.isConnected();
            }
            if (z) {
                zzdn();
                long zzdp = zzdp();
                long zzfh = zzcf().zzfh();
                if (zzfh != 0) {
                    zzfh = zzdp - Math.abs(zzbx().currentTimeMillis() - zzfh);
                    if (zzfh <= 0) {
                        zzfh = Math.min(zzbx.zzdz(), zzdp);
                    }
                } else {
                    zzfh = Math.min(zzbx.zzdz(), zzdp);
                }
                zza("Dispatch scheduled (ms)", Long.valueOf(zzfh));
                if (this.zzxq.zzej()) {
                    this.zzxq.zzi(Math.max(1, zzfh + this.zzxq.zzei()));
                    return;
                } else {
                    this.zzxq.zzh(zzfh);
                    return;
                }
            }
            zzdo();
            zzdn();
        }
    }

    private final void zzdn() {
        zzcc zzcd = zzcd();
        if (zzcd.zzem() && !zzcd.zzej()) {
            long zzdc = zzdc();
            if (zzdc != 0 && Math.abs(zzbx().currentTimeMillis() - zzdc) <= ((Long) zzcf.zzzi.get()).longValue()) {
                zza("Dispatch alarm scheduled (ms)", Long.valueOf(zzbx.zzea()));
                zzcd.zzen();
            }
        }
    }

    private final void zzdo() {
        if (this.zzxq.zzej()) {
            zzq("All hits dispatched or no network/service. Going to power save mode");
        }
        this.zzxq.cancel();
        zzcc zzcd = zzcd();
        if (zzcd.zzej()) {
            zzcd.cancel();
        }
    }

    private final long zzdp() {
        if (this.zzxp != Long.MIN_VALUE) {
            return this.zzxp;
        }
        long longValue = ((Long) zzcf.zzzd.get()).longValue();
        zzau zzce = zzce();
        zzce.zzcl();
        if (!zzce.zzacr) {
            return longValue;
        }
        zzau zzce2 = zzce();
        zzce2.zzcl();
        return ((long) zzce2.zzaat) * 1000;
    }

    public final void zzy(String str) {
        Preconditions.checkNotEmpty(str);
        zzk.zzaf();
        zzy zza = zzdg.zza(zzby(), str);
        if (zza == null) {
            zzd("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        CharSequence zzfj = zzcf().zzfj();
        if (str.equals(zzfj)) {
            zzt("Ignoring duplicate install campaign");
        } else if (TextUtils.isEmpty(zzfj)) {
            zzcf().zzac(str);
            if (zzcf().zzfg().zzj(zzbx.zzeh())) {
                zzd("Campaign received too late, ignoring", zza);
                return;
            }
            zzb("Received installation campaign", zza);
            for (zzaz zza2 : this.zzxl.zzf(0)) {
                zza(zza2, zza);
            }
        } else {
            zzd("Ignoring multiple install campaigns. original, new", zzfj, str);
        }
    }

    private final void zza(zzaz zzaz, zzy zzy) {
        Preconditions.checkNotNull(zzaz);
        Preconditions.checkNotNull(zzy);
        zzj zza = new zza(zzbw());
        zza.zza(zzaz.zzct());
        zza.enableAdvertisingIdCollection(zzaz.zzcu());
        zzg zzm = zza.zzm();
        zzag zzag = (zzag) zzm.zzb(zzag.class);
        zzag.zzl("data");
        zzag.zzb(true);
        zzm.zza((zzi) zzy);
        zzab zzab = (zzab) zzm.zzb(zzab.class);
        zzx zzx = (zzx) zzm.zzb(zzx.class);
        for (Entry entry : zzaz.zzcw().entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if ("an".equals(str)) {
                zzx.setAppName(str2);
            } else if ("av".equals(str)) {
                zzx.setAppVersion(str2);
            } else if ("aid".equals(str)) {
                zzx.setAppId(str2);
            } else if ("aiid".equals(str)) {
                zzx.setAppInstallerId(str2);
            } else if ("uid".equals(str)) {
                zzag.setUserId(str2);
            } else {
                zzab.set(str, str2);
            }
        }
        zzb("Sending installation campaign to", zzaz.zzct(), zzy);
        zzm.zza(zzcf().zzff());
        zzm.zzw();
    }

    private final void zzdq() {
        zzcl();
        zzk.zzaf();
        this.zzxu = true;
        this.zzxo.disconnect();
        zzdm();
    }
}
