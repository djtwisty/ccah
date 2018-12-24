package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v4.p017e.C0238a;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzfj;
import com.google.android.gms.internal.measurement.zzfm;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzxz;
import com.google.android.gms.internal.measurement.zzya;
import com.google.android.gms.internal.measurement.zzyi;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzt extends zzfn {
    private static final String[] zzagz = new String[]{"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;"};
    private static final String[] zzaha = new String[]{Param.ORIGIN, "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzahb = new String[]{"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;"};
    private static final String[] zzahc = new String[]{"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzahd = new String[]{"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzahe = new String[]{"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzw zzahf = new zzw(this, getContext(), "google_app_measurement.db");
    private final zzfj zzahg = new zzfj(zzbx());

    zzt(zzfo zzfo) {
        super(zzfo);
    }

    protected final boolean zzgy() {
        return false;
    }

    public final void beginTransaction() {
        zzcl();
        getWritableDatabase().beginTransaction();
    }

    public final void setTransactionSuccessful() {
        zzcl();
        getWritableDatabase().setTransactionSuccessful();
    }

    public final void endTransaction() {
        zzcl();
        getWritableDatabase().endTransaction();
    }

    private final long zza(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzgt().zzjg().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private final long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzgt().zzjg().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @VisibleForTesting
    final SQLiteDatabase getWritableDatabase() {
        zzaf();
        try {
            return this.zzahf.getWritableDatabase();
        } catch (SQLiteException e) {
            zzgt().zzjj().zzg("Error opening database", e);
            throw e;
        }
    }

    public final zzac zzg(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzaf();
        zzcl();
        Cursor query;
        try {
            query = getWritableDatabase().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    long j = query.getLong(0);
                    long j2 = query.getLong(1);
                    long j3 = query.getLong(2);
                    long j4 = query.isNull(3) ? 0 : query.getLong(3);
                    Long valueOf = query.isNull(4) ? null : Long.valueOf(query.getLong(4));
                    Long valueOf2 = query.isNull(5) ? null : Long.valueOf(query.getLong(5));
                    Long valueOf3 = query.isNull(6) ? null : Long.valueOf(query.getLong(6));
                    Boolean bool = null;
                    if (!query.isNull(7)) {
                        bool = Boolean.valueOf(query.getLong(7) == 1);
                    }
                    zzac zzac = new zzac(str, str2, j, j2, j3, j4, valueOf, valueOf2, valueOf3, bool);
                    if (query.moveToNext()) {
                        zzgt().zzjg().zzg("Got multiple records for event aggregates, expected one. appId", zzas.zzbw(str));
                    }
                    if (query == null) {
                        return zzac;
                    }
                    query.close();
                    return zzac;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    zzgt().zzjg().zzd("Error querying events. appId", zzas.zzbw(str), zzgq().zzbt(str2), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    query = cursor;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzgt().zzjg().zzd("Error querying events. appId", zzas.zzbw(str), zzgq().zzbt(str2), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final void zza(zzac zzac) {
        Long l = null;
        Preconditions.checkNotNull(zzac);
        zzaf();
        zzcl();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzac.zztt);
        contentValues.put("name", zzac.name);
        contentValues.put("lifetime_count", Long.valueOf(zzac.zzahv));
        contentValues.put("current_bundle_count", Long.valueOf(zzac.zzahw));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzac.zzahx));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzac.zzahy));
        contentValues.put("last_bundled_day", zzac.zzahz);
        contentValues.put("last_sampled_complex_event_id", zzac.zzaia);
        contentValues.put("last_sampling_rate", zzac.zzaib);
        if (zzac.zzaic != null && zzac.zzaic.booleanValue()) {
            l = Long.valueOf(1);
        }
        contentValues.put("last_exempt_from_sampling", l);
        try {
            if (getWritableDatabase().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzgt().zzjg().zzg("Failed to insert/update event aggregates (got -1). appId", zzas.zzbw(zzac.zztt));
            }
        } catch (SQLiteException e) {
            zzgt().zzjg().zze("Error storing event aggregates. appId", zzas.zzbw(zzac.zztt), e);
        }
    }

    public final void zzh(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzaf();
        zzcl();
        try {
            zzgt().zzjo().zzg("Deleted user attribute rows", Integer.valueOf(getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            zzgt().zzjg().zzd("Error deleting user attribute. appId", zzas.zzbw(str), zzgq().zzbv(str2), e);
        }
    }

    public final boolean zza(zzfx zzfx) {
        Preconditions.checkNotNull(zzfx);
        zzaf();
        zzcl();
        if (zzi(zzfx.zztt, zzfx.name) == null) {
            if (zzfy.zzct(zzfx.name)) {
                if (zza("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzfx.zztt}) >= 25) {
                    return false;
                }
            }
            if (zza("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzfx.zztt, zzfx.origin}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzfx.zztt);
        contentValues.put(Param.ORIGIN, zzfx.origin);
        contentValues.put("name", zzfx.name);
        contentValues.put("set_timestamp", Long.valueOf(zzfx.zzauk));
        zza(contentValues, Param.VALUE, zzfx.value);
        try {
            if (getWritableDatabase().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzgt().zzjg().zzg("Failed to insert/update user property (got -1). appId", zzas.zzbw(zzfx.zztt));
            }
        } catch (SQLiteException e) {
            zzgt().zzjg().zze("Error storing user property. appId", zzas.zzbw(zzfx.zztt), e);
        }
        return true;
    }

    public final zzfx zzi(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzaf();
        zzcl();
        try {
            Cursor query = getWritableDatabase().query("user_attributes", new String[]{"set_timestamp", Param.VALUE, Param.ORIGIN}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    String str3 = str;
                    zzfx zzfx = new zzfx(str3, query.getString(2), str2, query.getLong(0), zza(query, 1));
                    if (query.moveToNext()) {
                        zzgt().zzjg().zzg("Got multiple records for user property, expected one. appId", zzas.zzbw(str));
                    }
                    if (query == null) {
                        return zzfx;
                    }
                    query.close();
                    return zzfx;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    zzgt().zzjg().zzd("Error querying user property. appId", zzas.zzbw(str), zzgq().zzbv(str2), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzgt().zzjg().zzd("Error querying user property. appId", zzas.zzbw(str), zzgq().zzbv(str2), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final List<zzfx> zzbl(String str) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        Preconditions.checkNotEmpty(str);
        zzaf();
        zzcl();
        List<zzfx> arrayList = new ArrayList();
        try {
            Cursor query = getWritableDatabase().query("user_attributes", new String[]{"name", Param.ORIGIN, "set_timestamp", Param.VALUE}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        if (string2 == null) {
                            string2 = "";
                        }
                        long j = query.getLong(2);
                        Object zza = zza(query, 3);
                        if (zza == null) {
                            zzgt().zzjg().zzg("Read invalid user property value, ignoring it. appId", zzas.zzbw(str));
                        } else {
                            arrayList.add(new zzfx(str, string2, string, j, zza));
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = query;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            try {
                zzgt().zzjg().zze("Error querying user properties. appId", zzas.zzbw(str), e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final List<zzfx> zzb(String str, String str2, String str3) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        Preconditions.checkNotEmpty(str);
        zzaf();
        zzcl();
        List<zzfx> arrayList = new ArrayList();
        try {
            List arrayList2 = new ArrayList(3);
            arrayList2.add(str);
            StringBuilder stringBuilder = new StringBuilder("app_id=?");
            if (!TextUtils.isEmpty(str2)) {
                arrayList2.add(str2);
                stringBuilder.append(" and origin=?");
            }
            if (!TextUtils.isEmpty(str3)) {
                arrayList2.add(String.valueOf(str3).concat("*"));
                stringBuilder.append(" and name glob ?");
            }
            String[] strArr = new String[]{"name", "set_timestamp", Param.VALUE, Param.ORIGIN};
            Cursor query = getWritableDatabase().query("user_attributes", strArr, stringBuilder.toString(), (String[]) arrayList2.toArray(new String[arrayList2.size()]), null, null, "rowid", "1001");
            try {
                if (query.moveToFirst()) {
                    while (arrayList.size() < 1000) {
                        String string = query.getString(0);
                        long j = query.getLong(1);
                        Object zza = zza(query, 2);
                        String string2 = query.getString(3);
                        if (zza == null) {
                            try {
                                zzgt().zzjg().zzd("(2)Read invalid user property value, ignoring it", zzas.zzbw(str), string2, str3);
                            } catch (SQLiteException e2) {
                                e = e2;
                                cursor = query;
                                str2 = string2;
                            } catch (Throwable th2) {
                                th = th2;
                                cursor2 = query;
                            }
                        } else {
                            arrayList.add(new zzfx(str, string2, string, j, zza));
                        }
                        if (!query.moveToNext()) {
                            break;
                        }
                        str2 = string2;
                    }
                    zzgt().zzjg().zzg("Read more than the max allowed user properties, ignoring excess", Integer.valueOf(1000));
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
            } catch (Throwable th22) {
                th = th22;
                cursor2 = query;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            try {
                zzgt().zzjg().zzd("(2)Error querying user properties", zzas.zzbw(str), str2, e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final boolean zza(zzo zzo) {
        Preconditions.checkNotNull(zzo);
        zzaf();
        zzcl();
        if (zzi(zzo.packageName, zzo.zzags.name) == null) {
            if (zza("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzo.packageName}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzo.packageName);
        contentValues.put(Param.ORIGIN, zzo.origin);
        contentValues.put("name", zzo.zzags.name);
        zza(contentValues, Param.VALUE, zzo.zzags.getValue());
        contentValues.put("active", Boolean.valueOf(zzo.active));
        contentValues.put("trigger_event_name", zzo.triggerEventName);
        contentValues.put("trigger_timeout", Long.valueOf(zzo.triggerTimeout));
        zzgr();
        contentValues.put("timed_out_event", zzfy.zza(zzo.zzagt));
        contentValues.put("creation_timestamp", Long.valueOf(zzo.creationTimestamp));
        zzgr();
        contentValues.put("triggered_event", zzfy.zza(zzo.zzagu));
        contentValues.put("triggered_timestamp", Long.valueOf(zzo.zzags.zzauk));
        contentValues.put("time_to_live", Long.valueOf(zzo.timeToLive));
        zzgr();
        contentValues.put("expired_event", zzfy.zza(zzo.zzagv));
        try {
            if (getWritableDatabase().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzgt().zzjg().zzg("Failed to insert/update conditional user property (got -1)", zzas.zzbw(zzo.packageName));
            }
        } catch (SQLiteException e) {
            zzgt().zzjg().zze("Error storing conditional user property", zzas.zzbw(zzo.packageName), e);
        }
        return true;
    }

    public final zzo zzj(String str, String str2) {
        Cursor query;
        Object e;
        Cursor cursor;
        Throwable th;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzaf();
        zzcl();
        try {
            query = getWritableDatabase().query("conditional_properties", new String[]{Param.ORIGIN, Param.VALUE, "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    String string = query.getString(0);
                    Object zza = zza(query, 1);
                    boolean z = query.getInt(2) != 0;
                    String string2 = query.getString(3);
                    long j = query.getLong(4);
                    zzag zzag = (zzag) zzjr().zza(query.getBlob(5), zzag.CREATOR);
                    long j2 = query.getLong(6);
                    zzag zzag2 = (zzag) zzjr().zza(query.getBlob(7), zzag.CREATOR);
                    long j3 = query.getLong(8);
                    zzo zzo = new zzo(str, string, new zzfv(str2, j3, zza, string), j2, z, string2, zzag, j, zzag2, query.getLong(9), (zzag) zzjr().zza(query.getBlob(10), zzag.CREATOR));
                    if (query.moveToNext()) {
                        zzgt().zzjg().zze("Got multiple records for conditional property, expected one", zzas.zzbw(str), zzgq().zzbv(str2));
                    }
                    if (query == null) {
                        return zzo;
                    }
                    query.close();
                    return zzo;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    zzgt().zzjg().zzd("Error querying conditional property", zzas.zzbw(str), zzgq().zzbv(str2), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    query = cursor;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzgt().zzjg().zzd("Error querying conditional property", zzas.zzbw(str), zzgq().zzbv(str2), e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final int zzk(String str, String str2) {
        int i = 0;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzaf();
        zzcl();
        try {
            i = getWritableDatabase().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzgt().zzjg().zzd("Error deleting conditional property", zzas.zzbw(str), zzgq().zzbv(str2), e);
        }
        return i;
    }

    public final List<zzo> zzc(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzaf();
        zzcl();
        List arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder stringBuilder = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            stringBuilder.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            stringBuilder.append(" and name glob ?");
        }
        return zzb(stringBuilder.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final List<zzo> zzb(String str, String[] strArr) {
        Object e;
        Cursor cursor;
        Throwable th;
        zzaf();
        zzcl();
        List<zzo> arrayList = new ArrayList();
        Cursor query;
        try {
            query = getWritableDatabase().query("conditional_properties", new String[]{"app_id", Param.ORIGIN, "name", Param.VALUE, "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, null, null, "rowid", "1001");
            try {
                if (query.moveToFirst()) {
                    do {
                        if (arrayList.size() >= 1000) {
                            zzgt().zzjg().zzg("Read more than the max allowed conditional properties, ignoring extra", Integer.valueOf(1000));
                            break;
                        }
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        String string3 = query.getString(2);
                        Object zza = zza(query, 3);
                        boolean z = query.getInt(4) != 0;
                        String string4 = query.getString(5);
                        long j = query.getLong(6);
                        zzag zzag = (zzag) zzjr().zza(query.getBlob(7), zzag.CREATOR);
                        long j2 = query.getLong(8);
                        zzag zzag2 = (zzag) zzjr().zza(query.getBlob(9), zzag.CREATOR);
                        long j3 = query.getLong(10);
                        List<zzo> list = arrayList;
                        list.add(new zzo(string, string2, new zzfv(string3, j3, zza, string2), j2, z, string4, zzag, j, zzag2, query.getLong(11), (zzag) zzjr().zza(query.getBlob(12), zzag.CREATOR)));
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            try {
                zzgt().zzjg().zzg("Error querying conditional user property value", e);
                List<zzo> emptyList = Collections.emptyList();
                if (cursor == null) {
                    return emptyList;
                }
                cursor.close();
                return emptyList;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final zzg zzbm(String str) {
        Cursor query;
        Object e;
        Throwable th;
        Preconditions.checkNotEmpty(str);
        zzaf();
        zzcl();
        try {
            query = getWritableDatabase().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "ssaid_reporting_enabled", "admob_app_id"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    zzg zzg = new zzg(this.zzamv.zzmh(), str);
                    zzg.zzaj(query.getString(0));
                    zzg.zzak(query.getString(1));
                    zzg.zzam(query.getString(2));
                    zzg.zzt(query.getLong(3));
                    zzg.zzo(query.getLong(4));
                    zzg.zzp(query.getLong(5));
                    zzg.setAppVersion(query.getString(6));
                    zzg.zzao(query.getString(7));
                    zzg.zzr(query.getLong(8));
                    zzg.zzs(query.getLong(9));
                    boolean z = query.isNull(10) || query.getInt(10) != 0;
                    zzg.setMeasurementEnabled(z);
                    zzg.zzw(query.getLong(11));
                    zzg.zzx(query.getLong(12));
                    zzg.zzy(query.getLong(13));
                    zzg.zzz(query.getLong(14));
                    zzg.zzu(query.getLong(15));
                    zzg.zzv(query.getLong(16));
                    zzg.zzq(query.isNull(17) ? -2147483648L : (long) query.getInt(17));
                    zzg.zzan(query.getString(18));
                    zzg.zzab(query.getLong(19));
                    zzg.zzaa(query.getLong(20));
                    zzg.zzap(query.getString(21));
                    zzg.zzac(query.isNull(22) ? 0 : query.getLong(22));
                    if (query.isNull(23) || query.getInt(23) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zzg.zze(z);
                    if (query.isNull(24) || query.getInt(24) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zzg.zzf(z);
                    zzg.zzal(query.getString(25));
                    zzg.zzha();
                    if (query.moveToNext()) {
                        zzgt().zzjg().zzg("Got multiple records for app, expected one. appId", zzas.zzbw(str));
                    }
                    if (query == null) {
                        return zzg;
                    }
                    query.close();
                    return zzg;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzgt().zzjg().zze("Error querying app. appId", zzas.zzbw(str), e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            zzgt().zzjg().zze("Error querying app. appId", zzas.zzbw(str), e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final void zza(zzg zzg) {
        Preconditions.checkNotNull(zzg);
        zzaf();
        zzcl();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzg.zzal());
        contentValues.put("app_instance_id", zzg.getAppInstanceId());
        contentValues.put("gmp_app_id", zzg.getGmpAppId());
        contentValues.put("resettable_device_id_hash", zzg.zzhc());
        contentValues.put("last_bundle_index", Long.valueOf(zzg.zzhj()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzg.zzhd()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzg.zzhe()));
        contentValues.put("app_version", zzg.zzak());
        contentValues.put("app_store", zzg.zzhg());
        contentValues.put("gmp_version", Long.valueOf(zzg.zzhh()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzg.zzhi()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzg.isMeasurementEnabled()));
        contentValues.put("day", Long.valueOf(zzg.zzhn()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzg.zzho()));
        contentValues.put("daily_events_count", Long.valueOf(zzg.zzhp()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzg.zzhq()));
        contentValues.put("config_fetched_time", Long.valueOf(zzg.zzhk()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzg.zzhl()));
        contentValues.put("app_version_int", Long.valueOf(zzg.zzhf()));
        contentValues.put("firebase_instance_id", zzg.getFirebaseInstanceId());
        contentValues.put("daily_error_events_count", Long.valueOf(zzg.zzhs()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzg.zzhr()));
        contentValues.put("health_monitor_sample", zzg.zzht());
        contentValues.put("android_id", Long.valueOf(zzg.zzhv()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzg.zzhw()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(zzg.zzhx()));
        contentValues.put("admob_app_id", zzg.zzhb());
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (((long) writableDatabase.update("apps", contentValues, "app_id = ?", new String[]{zzg.zzal()})) == 0 && writableDatabase.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzgt().zzjg().zzg("Failed to insert/update app (got -1). appId", zzas.zzbw(zzg.zzal()));
            }
        } catch (SQLiteException e) {
            zzgt().zzjg().zze("Error storing app. appId", zzas.zzbw(zzg.zzal()), e);
        }
    }

    public final long zzbn(String str) {
        Preconditions.checkNotEmpty(str);
        zzaf();
        zzcl();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            String valueOf = String.valueOf(Math.max(0, Math.min(1000000, zzgv().zzb(str, zzai.zzajj))));
            return (long) writableDatabase.delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, valueOf});
        } catch (SQLiteException e) {
            zzgt().zzjg().zze("Error deleting over the limit events. appId", zzas.zzbw(str), e);
            return 0;
        }
    }

    public final zzu zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Object e;
        Throwable th;
        Preconditions.checkNotEmpty(str);
        zzaf();
        zzcl();
        String[] strArr = new String[]{str};
        zzu zzu = new zzu();
        Cursor query;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            query = writableDatabase.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    if (query.getLong(0) == j) {
                        zzu.zzahi = query.getLong(1);
                        zzu.zzahh = query.getLong(2);
                        zzu.zzahj = query.getLong(3);
                        zzu.zzahk = query.getLong(4);
                        zzu.zzahl = query.getLong(5);
                    }
                    if (z) {
                        zzu.zzahi++;
                    }
                    if (z2) {
                        zzu.zzahh++;
                    }
                    if (z3) {
                        zzu.zzahj++;
                    }
                    if (z4) {
                        zzu.zzahk++;
                    }
                    if (z5) {
                        zzu.zzahl++;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(zzu.zzahh));
                    contentValues.put("daily_events_count", Long.valueOf(zzu.zzahi));
                    contentValues.put("daily_conversions_count", Long.valueOf(zzu.zzahj));
                    contentValues.put("daily_error_events_count", Long.valueOf(zzu.zzahk));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(zzu.zzahl));
                    writableDatabase.update("apps", contentValues, "app_id=?", strArr);
                    if (query != null) {
                        query.close();
                    }
                    return zzu;
                }
                zzgt().zzjj().zzg("Not updating daily counts, app is not known. appId", zzas.zzbw(str));
                if (query != null) {
                    query.close();
                }
                return zzu;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzgt().zzjg().zze("Error updating daily counts. appId", zzas.zzbw(str), e);
                    if (query != null) {
                        query.close();
                    }
                    return zzu;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            zzgt().zzjg().zze("Error updating daily counts. appId", zzas.zzbw(str), e);
            if (query != null) {
                query.close();
            }
            return zzu;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final byte[] zzbo(String str) {
        Cursor query;
        Object e;
        Throwable th;
        Preconditions.checkNotEmpty(str);
        zzaf();
        zzcl();
        try {
            query = getWritableDatabase().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    byte[] blob = query.getBlob(0);
                    if (query.moveToNext()) {
                        zzgt().zzjg().zzg("Got multiple records for app config, expected one. appId", zzas.zzbw(str));
                    }
                    if (query == null) {
                        return blob;
                    }
                    query.close();
                    return blob;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzgt().zzjg().zze("Error querying remote config. appId", zzas.zzbw(str), e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            zzgt().zzjg().zze("Error querying remote config. appId", zzas.zzbw(str), e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public final boolean zza(zzfw zzfw, boolean z) {
        zzaf();
        zzcl();
        Preconditions.checkNotNull(zzfw);
        Preconditions.checkNotEmpty(zzfw.zztt);
        Preconditions.checkNotNull(zzfw.zzaxm);
        zzij();
        long currentTimeMillis = zzbx().currentTimeMillis();
        if (zzfw.zzaxm.longValue() < currentTimeMillis - zzq.zzib() || zzfw.zzaxm.longValue() > zzq.zzib() + currentTimeMillis) {
            zzgt().zzjj().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzas.zzbw(zzfw.zztt), Long.valueOf(currentTimeMillis), zzfw.zzaxm);
        }
        try {
            int i;
            byte[] bArr = new byte[zzfw.zzvx()];
            zzya zzk = zzya.zzk(bArr, 0, bArr.length);
            zzfw.zza(zzk);
            zzk.zzza();
            bArr = zzjr().zzb(bArr);
            zzgt().zzjo().zzg("Saving bundle, size", Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzfw.zztt);
            contentValues.put("bundle_end_timestamp", zzfw.zzaxm);
            contentValues.put("data", bArr);
            String str = "has_realtime";
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            contentValues.put(str, Integer.valueOf(i));
            if (zzfw.zzayj != null) {
                contentValues.put("retry_count", zzfw.zzayj);
            }
            try {
                if (getWritableDatabase().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzgt().zzjg().zzg("Failed to insert bundle (got -1). appId", zzas.zzbw(zzfw.zztt));
                return false;
            } catch (SQLiteException e) {
                zzgt().zzjg().zze("Error storing bundle. appId", zzas.zzbw(zzfw.zztt), e);
                return false;
            }
        } catch (IOException e2) {
            zzgt().zzjg().zze("Data loss. Failed to serialize bundle. appId", zzas.zzbw(zzfw.zztt), e2);
            return false;
        }
    }

    public final String zzih() {
        Cursor rawQuery;
        Object e;
        Throwable th;
        String str = null;
        try {
            rawQuery = getWritableDatabase().rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzgt().zzjg().zzg("Database error getting next bundle app id", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = null;
            zzgt().zzjg().zzg("Database error getting next bundle app id", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = null;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    public final boolean zzii() {
        return zza("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    public final List<Pair<zzfw, Long>> zzb(String str, int i, int i2) {
        Cursor query;
        List<Pair<zzfw, Long>> arrayList;
        Object e;
        Cursor cursor;
        Throwable th;
        boolean z = true;
        zzaf();
        zzcl();
        Preconditions.checkArgument(i > 0);
        if (i2 <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        Preconditions.checkNotEmpty(str);
        try {
            query = getWritableDatabase().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            try {
                if (query.moveToFirst()) {
                    arrayList = new ArrayList();
                    int i3 = 0;
                    while (true) {
                        long j = query.getLong(0);
                        int length;
                        try {
                            byte[] zza = zzjr().zza(query.getBlob(1));
                            if (!arrayList.isEmpty() && zza.length + i3 > i2) {
                                break;
                            }
                            zzxz zzj = zzxz.zzj(zza, 0, zza.length);
                            zzyi zzfw = new zzfw();
                            try {
                                zzfw.zza(zzj);
                                if (!query.isNull(2)) {
                                    zzfw.zzayj = Integer.valueOf(query.getInt(2));
                                }
                                length = zza.length + i3;
                                arrayList.add(Pair.create(zzfw, Long.valueOf(j)));
                            } catch (IOException e2) {
                                zzgt().zzjg().zze("Failed to merge queued bundle. appId", zzas.zzbw(str), e2);
                                length = i3;
                            }
                            if (!query.moveToNext() || length > i2) {
                                break;
                            }
                            i3 = length;
                        } catch (IOException e22) {
                            zzgt().zzjg().zze("Failed to unzip queued bundle. appId", zzas.zzbw(str), e22);
                            length = i3;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                } else {
                    arrayList = Collections.emptyList();
                    if (query != null) {
                        query.close();
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            try {
                zzgt().zzjg().zze("Error querying bundles. appId", zzas.zzbw(str), e);
                arrayList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    final void zzij() {
        zzaf();
        zzcl();
        if (zzip()) {
            long j = zzgu().zzand.get();
            long elapsedRealtime = zzbx().elapsedRealtime();
            if (Math.abs(elapsedRealtime - j) > ((Long) zzai.zzajs.get()).longValue()) {
                zzgu().zzand.set(elapsedRealtime);
                zzaf();
                zzcl();
                if (zzip()) {
                    int delete = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzbx().currentTimeMillis()), String.valueOf(zzq.zzib())});
                    if (delete > 0) {
                        zzgt().zzjo().zzg("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    @VisibleForTesting
    final void zzc(List<Long> list) {
        zzaf();
        zzcl();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzip()) {
            String join = TextUtils.join(",", list);
            join = new StringBuilder(String.valueOf(join).length() + 2).append("(").append(join).append(")").toString();
            if (zza(new StringBuilder(String.valueOf(join).length() + 80).append("SELECT COUNT(1) FROM queue WHERE rowid IN ").append(join).append(" AND retry_count =  2147483647 LIMIT 1").toString(), null) > 0) {
                zzgt().zzjj().zzby("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                getWritableDatabase().execSQL(new StringBuilder(String.valueOf(join).length() + 127).append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ").append(join).append(" AND (retry_count IS NULL OR retry_count < 2147483647)").toString());
            } catch (SQLiteException e) {
                zzgt().zzjg().zzg("Error incrementing retry count. error", e);
            }
        }
    }

    final void zza(String str, zzfi[] zzfiArr) {
        int i = 0;
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzfiArr);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            int i2;
            zzcl();
            zzaf();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase writableDatabase2 = getWritableDatabase();
            writableDatabase2.delete("property_filters", "app_id=?", new String[]{str});
            writableDatabase2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzfi zzfi : zzfiArr) {
                zzcl();
                zzaf();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzfi);
                Preconditions.checkNotNull(zzfi.zzavg);
                Preconditions.checkNotNull(zzfi.zzavf);
                if (zzfi.zzave == null) {
                    zzgt().zzjj().zzg("Audience with no ID. appId", zzas.zzbw(str));
                } else {
                    int intValue = zzfi.zzave.intValue();
                    for (zzfj zzfj : zzfi.zzavg) {
                        if (zzfj.zzavk == null) {
                            zzgt().zzjj().zze("Event filter with no ID. Audience definition ignored. appId, audienceId", zzas.zzbw(str), zzfi.zzave);
                            break;
                        }
                    }
                    for (zzfm zzfm : zzfi.zzavf) {
                        if (zzfm.zzavk == null) {
                            zzgt().zzjj().zze("Property filter with no ID. Audience definition ignored. appId, audienceId", zzas.zzbw(str), zzfi.zzave);
                            break;
                        }
                    }
                    for (zzfj zzfj2 : zzfi.zzavg) {
                        if (!zza(str, intValue, zzfj2)) {
                            i2 = 0;
                            break;
                        }
                    }
                    i2 = 1;
                    if (i2 != 0) {
                        for (zzfm zzfm2 : zzfi.zzavf) {
                            if (!zza(str, intValue, zzfm2)) {
                                i2 = 0;
                                break;
                            }
                        }
                    }
                    if (i2 == 0) {
                        zzcl();
                        zzaf();
                        Preconditions.checkNotEmpty(str);
                        SQLiteDatabase writableDatabase3 = getWritableDatabase();
                        writableDatabase3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                        writableDatabase3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                    }
                }
            }
            List arrayList = new ArrayList();
            i2 = zzfiArr.length;
            while (i < i2) {
                arrayList.add(zzfiArr[i].zzave);
                i++;
            }
            zza(str, arrayList);
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    private final boolean zza(String str, int i, zzfj zzfj) {
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzfj);
        if (TextUtils.isEmpty(zzfj.zzavl)) {
            zzgt().zzjj().zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzas.zzbw(str), Integer.valueOf(i), String.valueOf(zzfj.zzavk));
            return false;
        }
        try {
            byte[] bArr = new byte[zzfj.zzvx()];
            zzya zzk = zzya.zzk(bArr, 0, bArr.length);
            zzfj.zza(zzk);
            zzk.zzza();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzfj.zzavk);
            contentValues.put("event_name", zzfj.zzavl);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                    zzgt().zzjg().zzg("Failed to insert event filter (got -1). appId", zzas.zzbw(str));
                }
                return true;
            } catch (SQLiteException e) {
                zzgt().zzjg().zze("Error storing event filter. appId", zzas.zzbw(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzgt().zzjg().zze("Configuration loss. Failed to serialize event filter. appId", zzas.zzbw(str), e2);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzfm zzfm) {
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzfm);
        if (TextUtils.isEmpty(zzfm.zzawa)) {
            zzgt().zzjj().zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzas.zzbw(str), Integer.valueOf(i), String.valueOf(zzfm.zzavk));
            return false;
        }
        try {
            byte[] bArr = new byte[zzfm.zzvx()];
            zzya zzk = zzya.zzk(bArr, 0, bArr.length);
            zzfm.zza(zzk);
            zzk.zzza();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzfm.zzavk);
            contentValues.put("property_name", zzfm.zzawa);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                zzgt().zzjg().zzg("Failed to insert property filter (got -1). appId", zzas.zzbw(str));
                return false;
            } catch (SQLiteException e) {
                zzgt().zzjg().zze("Error storing property filter. appId", zzas.zzbw(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzgt().zzjg().zze("Configuration loss. Failed to serialize property filter. appId", zzas.zzbw(str), e2);
            return false;
        }
    }

    final Map<Integer, List<zzfj>> zzl(String str, String str2) {
        Cursor query;
        Object e;
        Throwable th;
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Map<Integer, List<zzfj>> c0238a = new C0238a();
        try {
            query = getWritableDatabase().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
            if (query.moveToFirst()) {
                do {
                    try {
                        byte[] blob = query.getBlob(1);
                        zzxz zzj = zzxz.zzj(blob, 0, blob.length);
                        zzyi zzfj = new zzfj();
                        try {
                            zzfj.zza(zzj);
                            int i = query.getInt(0);
                            List list = (List) c0238a.get(Integer.valueOf(i));
                            if (list == null) {
                                list = new ArrayList();
                                c0238a.put(Integer.valueOf(i), list);
                            }
                            list.add(zzfj);
                        } catch (IOException e2) {
                            zzgt().zzjg().zze("Failed to merge filter. appId", zzas.zzbw(str), e2);
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return c0238a;
            }
            Map<Integer, List<zzfj>> emptyMap = Collections.emptyMap();
            if (query == null) {
                return emptyMap;
            }
            query.close();
            return emptyMap;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                zzgt().zzjg().zze("Database error querying filters. appId", zzas.zzbw(str), e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    final Map<Integer, List<zzfm>> zzm(String str, String str2) {
        Object e;
        Throwable th;
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Map<Integer, List<zzfm>> c0238a = new C0238a();
        Cursor query;
        try {
            query = getWritableDatabase().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
            if (query.moveToFirst()) {
                do {
                    try {
                        byte[] blob = query.getBlob(1);
                        zzxz zzj = zzxz.zzj(blob, 0, blob.length);
                        zzyi zzfm = new zzfm();
                        try {
                            zzfm.zza(zzj);
                            int i = query.getInt(0);
                            List list = (List) c0238a.get(Integer.valueOf(i));
                            if (list == null) {
                                list = new ArrayList();
                                c0238a.put(Integer.valueOf(i), list);
                            }
                            list.add(zzfm);
                        } catch (IOException e2) {
                            zzgt().zzjg().zze("Failed to merge filter", zzas.zzbw(str), e2);
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return c0238a;
            }
            Map<Integer, List<zzfm>> emptyMap = Collections.emptyMap();
            if (query == null) {
                return emptyMap;
            }
            query.close();
            return emptyMap;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                zzgt().zzjg().zze("Database error querying filters. appId", zzas.zzbw(str), e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private final boolean zza(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzcl();
        zzaf();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            if (zza("select count(1) from audience_filter_values where app_id=?", new String[]{str}) <= ((long) Math.max(0, Math.min(2000, zzgv().zzb(str, zzai.zzajz))))) {
                return false;
            }
            Iterable arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = (Integer) list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            join = new StringBuilder(String.valueOf(join).length() + 2).append("(").append(join).append(")").toString();
            if (writableDatabase.delete("audience_filter_values", new StringBuilder(String.valueOf(join).length() + 140).append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ").append(join).append(" order by rowid desc limit -1 offset ?)").toString(), new String[]{str, Integer.toString(r5)}) > 0) {
                return true;
            }
            return false;
        } catch (SQLiteException e) {
            zzgt().zzjg().zze("Database error querying filters. appId", zzas.zzbw(str), e);
            return false;
        }
    }

    final Map<Integer, zzfx> zzbp(String str) {
        Object e;
        Throwable th;
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        Cursor query;
        try {
            query = getWritableDatabase().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
            if (query.moveToFirst()) {
                Map<Integer, zzfx> c0238a = new C0238a();
                do {
                    int i = query.getInt(0);
                    byte[] blob = query.getBlob(1);
                    zzxz zzj = zzxz.zzj(blob, 0, blob.length);
                    zzyi zzfx = new zzfx();
                    try {
                        zzfx.zza(zzj);
                        try {
                            c0238a.put(Integer.valueOf(i), zzfx);
                        } catch (SQLiteException e2) {
                            e = e2;
                        }
                    } catch (IOException e3) {
                        zzgt().zzjg().zzd("Failed to merge filter results. appId, audienceId, error", zzas.zzbw(str), Integer.valueOf(i), e3);
                    }
                } while (query.moveToNext());
                if (query == null) {
                    return c0238a;
                }
                query.close();
                return c0238a;
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                zzgt().zzjg().zze("Database error querying filter results. appId", zzas.zzbw(str), e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    @VisibleForTesting
    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        switch (type) {
            case 0:
                zzgt().zzjg().zzby("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Double.valueOf(cursor.getDouble(i));
            case 3:
                return cursor.getString(i);
            case 4:
                zzgt().zzjg().zzby("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                zzgt().zzjg().zzg("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
        }
    }

    public final long zzik() {
        return zza("select max(bundle_end_timestamp) from queue", null, 0);
    }

    @VisibleForTesting
    protected final long zzn(String str, String str2) {
        Object e;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzaf();
        zzcl();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        long zza;
        try {
            zza = zza(new StringBuilder(String.valueOf(str2).length() + 32).append("select ").append(str2).append(" from app2 where app_id=?").toString(), new String[]{str}, -1);
            if (zza == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", Integer.valueOf(0));
                contentValues.put("previous_install_count", Integer.valueOf(0));
                if (writableDatabase.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                    zzgt().zzjg().zze("Failed to insert column (got -1). appId", zzas.zzbw(str), str2);
                    writableDatabase.endTransaction();
                    return -1;
                }
                zza = 0;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put(str2, Long.valueOf(1 + zza));
                if (((long) writableDatabase.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                    zzgt().zzjg().zze("Failed to update column (got 0). appId", zzas.zzbw(str), str2);
                    writableDatabase.endTransaction();
                    return -1;
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return zza;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzgt().zzjg().zzd("Error inserting column. appId", zzas.zzbw(str), str2, e);
                    return zza;
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            zza = 0;
            zzgt().zzjg().zzd("Error inserting column. appId", zzas.zzbw(str), str2, e);
            return zza;
        }
    }

    public final long zzil() {
        return zza("select max(timestamp) from raw_events", null, 0);
    }

    public final long zza(zzfw zzfw) {
        zzaf();
        zzcl();
        Preconditions.checkNotNull(zzfw);
        Preconditions.checkNotEmpty(zzfw.zztt);
        try {
            long j;
            Object obj = new byte[zzfw.zzvx()];
            zzya zzk = zzya.zzk(obj, 0, obj.length);
            zzfw.zza(zzk);
            zzk.zzza();
            zzcr zzjr = zzjr();
            Preconditions.checkNotNull(obj);
            zzjr.zzgr().zzaf();
            MessageDigest messageDigest = zzfy.getMessageDigest();
            if (messageDigest == null) {
                zzjr.zzgt().zzjg().zzby("Failed to get MD5");
                j = 0;
            } else {
                j = zzfy.zzc(messageDigest.digest(obj));
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzfw.zztt);
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("metadata", obj);
            try {
                getWritableDatabase().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return j;
            } catch (SQLiteException e) {
                zzgt().zzjg().zze("Error storing raw event metadata. appId", zzas.zzbw(zzfw.zztt), e);
                throw e;
            }
        } catch (IOException e2) {
            zzgt().zzjg().zze("Data loss. Failed to serialize event metadata. appId", zzas.zzbw(zzfw.zztt), e2);
            throw e2;
        }
    }

    public final boolean zzim() {
        return zza("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean zzin() {
        return zza("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final long zzbq(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    public final String zzad(long j) {
        Cursor rawQuery;
        Object e;
        Throwable th;
        String str = null;
        zzaf();
        zzcl();
        try {
            rawQuery = getWritableDatabase().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j)});
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else {
                    zzgt().zzjo().zzby("No expired configs for apps with pending events");
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzgt().zzjg().zzg("Error selecting expired configs", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = str;
            zzgt().zzjg().zzg("Error selecting expired configs", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = str;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    public final long zzio() {
        long j = -1;
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
        } catch (SQLiteException e) {
            zzgt().zzjg().zzg("Error querying raw events", e);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return j;
    }

    public final Pair<zzft, Long> zza(String str, Long l) {
        Object e;
        Throwable th;
        Pair<zzft, Long> pair = null;
        zzaf();
        zzcl();
        Cursor rawQuery;
        try {
            rawQuery = getWritableDatabase().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, String.valueOf(l)});
            try {
                if (rawQuery.moveToFirst()) {
                    byte[] blob = rawQuery.getBlob(0);
                    Long valueOf = Long.valueOf(rawQuery.getLong(1));
                    zzxz zzj = zzxz.zzj(blob, 0, blob.length);
                    zzyi zzft = new zzft();
                    try {
                        zzft.zza(zzj);
                        pair = Pair.create(zzft, valueOf);
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                    } catch (IOException e2) {
                        zzgt().zzjg().zzd("Failed to merge main event. appId, eventId", zzas.zzbw(str), l, e2);
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                    }
                } else {
                    zzgt().zzjo().zzby("Main event not found");
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                try {
                    zzgt().zzjg().zzg("Error selecting main event", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return pair;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            rawQuery = pair;
            zzgt().zzjg().zzg("Error selecting main event", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return pair;
        } catch (Throwable th3) {
            th = th3;
            rawQuery = pair;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return pair;
    }

    public final boolean zza(String str, Long l, long j, zzft zzft) {
        zzaf();
        zzcl();
        Preconditions.checkNotNull(zzft);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        try {
            byte[] bArr = new byte[zzft.zzvx()];
            zzya zzk = zzya.zzk(bArr, 0, bArr.length);
            zzft.zza(zzk);
            zzk.zzza();
            zzgt().zzjo().zze("Saving complex main event, appId, data size", zzgq().zzbt(str), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("event_id", l);
            contentValues.put("children_to_process", Long.valueOf(j));
            contentValues.put("main_event", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                    return true;
                }
                zzgt().zzjg().zzg("Failed to insert complex main event (got -1). appId", zzas.zzbw(str));
                return false;
            } catch (SQLiteException e) {
                zzgt().zzjg().zze("Error storing complex main event. appId", zzas.zzbw(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzgt().zzjg().zzd("Data loss. Failed to serialize event params/data. appId, eventId", zzas.zzbw(str), l, e2);
            return false;
        }
    }

    public final boolean zza(zzab zzab, long j, boolean z) {
        zzaf();
        zzcl();
        Preconditions.checkNotNull(zzab);
        Preconditions.checkNotEmpty(zzab.zztt);
        zzyi zzft = new zzft();
        zzft.zzaxc = Long.valueOf(zzab.zzaht);
        zzft.zzaxa = new zzfu[zzab.zzahu.size()];
        Iterator it = zzab.zzahu.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            zzfu zzfu = new zzfu();
            int i2 = i + 1;
            zzft.zzaxa[i] = zzfu;
            zzfu.name = str;
            zzjr().zza(zzfu, zzab.zzahu.get(str));
            i = i2;
        }
        try {
            byte[] bArr = new byte[zzft.zzvx()];
            zzya zzk = zzya.zzk(bArr, 0, bArr.length);
            zzft.zza(zzk);
            zzk.zzza();
            zzgt().zzjo().zze("Saving event, name, data size", zzgq().zzbt(zzab.name), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzab.zztt);
            contentValues.put("name", zzab.name);
            contentValues.put(AppMeasurement.Param.TIMESTAMP, Long.valueOf(zzab.timestamp));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
            try {
                if (getWritableDatabase().insert("raw_events", null, contentValues) != -1) {
                    return true;
                }
                zzgt().zzjg().zzg("Failed to insert raw event (got -1). appId", zzas.zzbw(zzab.zztt));
                return false;
            } catch (SQLiteException e) {
                zzgt().zzjg().zze("Error storing raw event. appId", zzas.zzbw(zzab.zztt), e);
                return false;
            }
        } catch (IOException e2) {
            zzgt().zzjg().zze("Data loss. Failed to serialize event params/data. appId", zzas.zzbw(zzab.zztt), e2);
            return false;
        }
    }

    private final boolean zzip() {
        return getContext().getDatabasePath("google_app_measurement.db").exists();
    }
}
