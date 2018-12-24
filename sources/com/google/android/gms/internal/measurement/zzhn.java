package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONObject;

@VisibleForTesting
final class zzhn implements zzhb {
    private static final String zzbjp = String.format("CREATE TABLE IF NOT EXISTS %s ('%s' TEXT UNIQUE);", new Object[]{"gtm_hit_unique_ids", "hit_unique_id"});
    private static final String zzbjq = String.format("CREATE TRIGGER IF NOT EXISTS %s DELETE ON %s FOR EACH ROW WHEN OLD.%s NOTNULL BEGIN     INSERT OR IGNORE INTO %s (%s) VALUES (OLD.%s); END;", new Object[]{"save_unique_on_delete", "gtm_hits", "hit_unique_id", "gtm_hit_unique_ids", "hit_unique_id", "hit_unique_id"});
    private static final String zzbjr = String.format("CREATE TRIGGER IF NOT EXISTS %s BEFORE INSERT ON %s FOR EACH ROW WHEN NEW.%s NOT NULL BEGIN     SELECT RAISE(ABORT, 'Duplicate unique ID.')     WHERE EXISTS (SELECT 1 FROM %s WHERE %s = NEW.%s); END;", new Object[]{"check_unique_on_insert", "gtm_hits", "hit_unique_id", "gtm_hit_unique_ids", "hit_unique_id", "hit_unique_id"});
    private static final String zzxf = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT UNIQUE, '%s' TEXT, '%s' TEXT);", new Object[]{"gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time", "hit_method", "hit_unique_id", "hit_headers", "hit_body"});
    private final String zzbds;
    private long zzbdt;
    private final int zzbdu;
    private final zzhp zzbjs;
    private volatile zzgs zzbjt;
    private final zzhc zzbju;
    private final Context zzri;
    private Clock zzrz;

    zzhn(zzhc zzhc, Context context) {
        this(zzhc, context, "gtm_urls.db", 2000);
    }

    @VisibleForTesting
    private zzhn(zzhc zzhc, Context context, String str, int i) {
        this.zzri = context.getApplicationContext();
        this.zzbds = str;
        this.zzbju = zzhc;
        this.zzrz = DefaultClock.getInstance();
        this.zzbjs = new zzhp(this, this.zzri, this.zzbds);
        this.zzbjt = new zzij(this.zzri, new zzho(this));
        this.zzbdt = 0;
        this.zzbdu = 2000;
    }

    public final void zza(long j, String str, String str2, String str3, Map<String, String> map, String str4) {
        String str5;
        long currentTimeMillis = this.zzrz.currentTimeMillis();
        if (currentTimeMillis > this.zzbdt + 86400000) {
            this.zzbdt = currentTimeMillis;
            SQLiteDatabase zzdl = zzdl("Error opening database for deleteStaleHits.");
            if (zzdl != null) {
                zzhk.m1082v("Removed " + zzdl.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.zzrz.currentTimeMillis() - 2592000000L)}) + " stale hits.");
                this.zzbju.zzo(zzel("gtm_hits") == 0);
            }
        }
        int zzel = (zzel("gtm_hits") - this.zzbdu) + 1;
        if (zzel > 0) {
            List zzab = zzab(zzel);
            zzhk.m1082v("Store full, deleting " + zzab.size() + " hits to make room.");
            zza((String[]) zzab.toArray(new String[0]));
        }
        SQLiteDatabase zzdl2 = zzdl("Error opening database for putHit");
        if (zzdl2 != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_time", Long.valueOf(j));
            contentValues.put("hit_url", str);
            contentValues.put("hit_first_send_time", Integer.valueOf(0));
            String str6 = "hit_method";
            if (str2 == null) {
                str2 = HttpGet.METHOD_NAME;
            }
            contentValues.put(str6, str2);
            contentValues.put("hit_unique_id", str3);
            contentValues.put("hit_headers", map == null ? null : new JSONObject(map).toString());
            contentValues.put("hit_body", str4);
            try {
                zzdl2.insertOrThrow("gtm_hits", null, contentValues);
                zzhk.m1082v(new StringBuilder(String.valueOf(str).length() + 19).append("Hit stored (url = ").append(str).append(")").toString());
                this.zzbju.zzo(false);
            } catch (SQLiteConstraintException e) {
                str5 = "Hit has already been sent: ";
                str6 = String.valueOf(str);
                zzhk.m1082v(str6.length() != 0 ? str5.concat(str6) : new String(str5));
            } catch (SQLiteException e2) {
                str5 = "Error storing hit: ";
                str6 = String.valueOf(e2.getMessage());
                zzhk.zzab(str6.length() != 0 ? str5.concat(str6) : new String(str5));
            }
        }
        if (zzhs.zzrf().isPreview()) {
            zzhk.m1082v("Sending hits immediately under preview.");
            dispatch();
        }
    }

    private final List<String> zzab(int i) {
        SQLiteException e;
        String str;
        String valueOf;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            zzhk.zzab("Invalid maxHits specified. Skipping");
            return arrayList;
        }
        SQLiteDatabase zzdl = zzdl("Error opening database for peekHitIds.");
        if (zzdl == null) {
            return arrayList;
        }
        Cursor query;
        try {
            query = zzdl.query("gtm_hits", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Integer.toString(i));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    str = "Error in peekHits fetching hitIds: ";
                    valueOf = String.valueOf(e.getMessage());
                    zzhk.zzab(valueOf.length() == 0 ? str.concat(valueOf) : new String(str));
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
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
            str = "Error in peekHits fetching hitIds: ";
            valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() == 0) {
            }
            zzhk.zzab(valueOf.length() == 0 ? str.concat(valueOf) : new String(str));
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<com.google.android.gms.internal.measurement.zzgw> zzac(int r17) {
        /*
        r16 = this;
        r12 = new java.util.ArrayList;
        r12.<init>();
        r2 = "Error opening database for peekHits";
        r0 = r16;
        r2 = r0.zzdl(r2);
        if (r2 != 0) goto L_0x0011;
    L_0x000f:
        r11 = r12;
    L_0x0010:
        return r11;
    L_0x0011:
        r13 = 0;
        r3 = "gtm_hits";
        r4 = 3;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x0118, all -> 0x0204 }
        r5 = 0;
        r6 = "hit_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0118, all -> 0x0204 }
        r5 = 1;
        r6 = "hit_time";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0118, all -> 0x0204 }
        r5 = 2;
        r6 = "hit_first_send_time";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0118, all -> 0x0204 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = "%s ASC";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ SQLiteException -> 0x0118, all -> 0x0204 }
        r11 = 0;
        r14 = "hit_id";
        r10[r11] = r14;	 Catch:{ SQLiteException -> 0x0118, all -> 0x0204 }
        r9 = java.lang.String.format(r9, r10);	 Catch:{ SQLiteException -> 0x0118, all -> 0x0204 }
        r10 = 40;
        r10 = java.lang.Integer.toString(r10);	 Catch:{ SQLiteException -> 0x0118, all -> 0x0204 }
        r13 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x0118, all -> 0x0204 }
        r11 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x0207, all -> 0x0204 }
        r11.<init>();	 Catch:{ SQLiteException -> 0x0207, all -> 0x0204 }
        r3 = r13.moveToFirst();	 Catch:{ SQLiteException -> 0x020c, all -> 0x0204 }
        if (r3 == 0) goto L_0x006a;
    L_0x004d:
        r3 = new com.google.android.gms.internal.measurement.zzgw;	 Catch:{ SQLiteException -> 0x020c, all -> 0x0204 }
        r4 = 0;
        r4 = r13.getLong(r4);	 Catch:{ SQLiteException -> 0x020c, all -> 0x0204 }
        r6 = 1;
        r6 = r13.getLong(r6);	 Catch:{ SQLiteException -> 0x020c, all -> 0x0204 }
        r8 = 2;
        r8 = r13.getLong(r8);	 Catch:{ SQLiteException -> 0x020c, all -> 0x0204 }
        r3.<init>(r4, r6, r8);	 Catch:{ SQLiteException -> 0x020c, all -> 0x0204 }
        r11.add(r3);	 Catch:{ SQLiteException -> 0x020c, all -> 0x0204 }
        r3 = r13.moveToNext();	 Catch:{ SQLiteException -> 0x020c, all -> 0x0204 }
        if (r3 != 0) goto L_0x004d;
    L_0x006a:
        if (r13 == 0) goto L_0x006f;
    L_0x006c:
        r13.close();
    L_0x006f:
        r12 = 0;
        r3 = "gtm_hits";
        r4 = 5;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x0202 }
        r5 = 0;
        r6 = "hit_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0202 }
        r5 = 1;
        r6 = "hit_url";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0202 }
        r5 = 2;
        r6 = "hit_method";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0202 }
        r5 = 3;
        r6 = "hit_headers";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0202 }
        r5 = 4;
        r6 = "hit_body";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0202 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = "%s ASC";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ SQLiteException -> 0x0202 }
        r14 = 0;
        r15 = "hit_id";
        r10[r14] = r15;	 Catch:{ SQLiteException -> 0x0202 }
        r9 = java.lang.String.format(r9, r10);	 Catch:{ SQLiteException -> 0x0202 }
        r10 = 40;
        r10 = java.lang.Integer.toString(r10);	 Catch:{ SQLiteException -> 0x0202 }
        r3 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x0202 }
        r2 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        if (r2 == 0) goto L_0x0174;
    L_0x00b0:
        r5 = r12;
    L_0x00b1:
        r0 = r3;
        r0 = (android.database.sqlite.SQLiteCursor) r0;	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r2 = r0;
        r2 = r2.getWindow();	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r2 = r2.getNumRows();	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        if (r2 <= 0) goto L_0x0188;
    L_0x00bf:
        r2 = r11.get(r5);	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r2 = (com.google.android.gms.internal.measurement.zzgw) r2;	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r4 = 1;
        r4 = r3.getString(r4);	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r2.zzds(r4);	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r2 = r11.get(r5);	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r2 = (com.google.android.gms.internal.measurement.zzgw) r2;	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r4 = 2;
        r4 = r3.getString(r4);	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r2.zzej(r4);	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r2 = r11.get(r5);	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r2 = (com.google.android.gms.internal.measurement.zzgw) r2;	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r4 = 4;
        r4 = r3.getString(r4);	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r2.zzek(r4);	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r2 = 0;
        r4 = 3;
        r4 = r3.getString(r4);	 Catch:{ JSONException -> 0x0147 }
        if (r4 == 0) goto L_0x017b;
    L_0x00f1:
        r7 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0147 }
        r7.<init>(r4);	 Catch:{ JSONException -> 0x0147 }
        r8 = r7.names();	 Catch:{ JSONException -> 0x0147 }
        r4 = new java.util.HashMap;	 Catch:{ JSONException -> 0x0147 }
        r4.<init>();	 Catch:{ JSONException -> 0x0147 }
        r2 = 0;
        r6 = r2;
    L_0x0101:
        r2 = r8.length();	 Catch:{ JSONException -> 0x0147 }
        if (r6 >= r2) goto L_0x017c;
    L_0x0107:
        r9 = r8.getString(r6);	 Catch:{ JSONException -> 0x0147 }
        r2 = r7.opt(r9);	 Catch:{ JSONException -> 0x0147 }
        r2 = (java.lang.String) r2;	 Catch:{ JSONException -> 0x0147 }
        r4.put(r9, r2);	 Catch:{ JSONException -> 0x0147 }
        r2 = r6 + 1;
        r6 = r2;
        goto L_0x0101;
    L_0x0118:
        r2 = move-exception;
        r3 = r13;
        r11 = r12;
    L_0x011b:
        r4 = "Error in peekHits fetching hitIds: ";
        r2 = r2.getMessage();	 Catch:{ all -> 0x013f }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ all -> 0x013f }
        r5 = r2.length();	 Catch:{ all -> 0x013f }
        if (r5 == 0) goto L_0x0139;
    L_0x012b:
        r2 = r4.concat(r2);	 Catch:{ all -> 0x013f }
    L_0x012f:
        com.google.android.gms.internal.measurement.zzhk.zzab(r2);	 Catch:{ all -> 0x013f }
        if (r3 == 0) goto L_0x0010;
    L_0x0134:
        r3.close();
        goto L_0x0010;
    L_0x0139:
        r2 = new java.lang.String;	 Catch:{ all -> 0x013f }
        r2.<init>(r4);	 Catch:{ all -> 0x013f }
        goto L_0x012f;
    L_0x013f:
        r2 = move-exception;
        r13 = r3;
    L_0x0141:
        if (r13 == 0) goto L_0x0146;
    L_0x0143:
        r13.close();
    L_0x0146:
        throw r2;
    L_0x0147:
        r2 = move-exception;
        r4 = r2;
        r6 = "Failed to read headers for hitId %d: %s";
        r2 = 2;
        r7 = new java.lang.Object[r2];	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r8 = 0;
        r2 = r11.get(r5);	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r2 = (com.google.android.gms.internal.measurement.zzgw) r2;	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r12 = r2.zzov();	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r2 = java.lang.Long.valueOf(r12);	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r7[r8] = r2;	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r2 = 1;
        r4 = r4.getMessage();	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r7[r2] = r4;	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r2 = java.lang.String.format(r6, r7);	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        com.google.android.gms.internal.measurement.zzhk.zzab(r2);	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r2 = r5;
    L_0x016e:
        r4 = r3.moveToNext();	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        if (r4 != 0) goto L_0x0210;
    L_0x0174:
        if (r3 == 0) goto L_0x0010;
    L_0x0176:
        r3.close();
        goto L_0x0010;
    L_0x017b:
        r4 = r2;
    L_0x017c:
        r2 = r11.get(r5);	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r2 = (com.google.android.gms.internal.measurement.zzgw) r2;	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r2.zzh(r4);	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
    L_0x0185:
        r2 = r5 + 1;
        goto L_0x016e;
    L_0x0188:
        r4 = "HitString for hitId %d too large. Hit will be deleted.";
        r2 = 1;
        r6 = new java.lang.Object[r2];	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r7 = 0;
        r2 = r11.get(r5);	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r2 = (com.google.android.gms.internal.measurement.zzgw) r2;	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r8 = r2.zzov();	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r2 = java.lang.Long.valueOf(r8);	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r6[r7] = r2;	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        r2 = java.lang.String.format(r4, r6);	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        com.google.android.gms.internal.measurement.zzhk.zzab(r2);	 Catch:{ SQLiteException -> 0x01a6, all -> 0x0200 }
        goto L_0x0185;
    L_0x01a6:
        r2 = move-exception;
        r13 = r3;
    L_0x01a8:
        r3 = "Error in peekHits fetching hit url: ";
        r2 = r2.getMessage();	 Catch:{ all -> 0x01ea }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ all -> 0x01ea }
        r4 = r2.length();	 Catch:{ all -> 0x01ea }
        if (r4 == 0) goto L_0x01f2;
    L_0x01b8:
        r2 = r3.concat(r2);	 Catch:{ all -> 0x01ea }
    L_0x01bc:
        com.google.android.gms.internal.measurement.zzhk.zzab(r2);	 Catch:{ all -> 0x01ea }
        r4 = new java.util.ArrayList;	 Catch:{ all -> 0x01ea }
        r4.<init>();	 Catch:{ all -> 0x01ea }
        r5 = 0;
        r0 = r11;
        r0 = (java.util.ArrayList) r0;	 Catch:{ all -> 0x01ea }
        r2 = r0;
        r7 = r2.size();	 Catch:{ all -> 0x01ea }
        r3 = 0;
        r6 = r3;
    L_0x01cf:
        if (r6 >= r7) goto L_0x01f8;
    L_0x01d1:
        r3 = r2.get(r6);	 Catch:{ all -> 0x01ea }
        r6 = r6 + 1;
        r3 = (com.google.android.gms.internal.measurement.zzgw) r3;	 Catch:{ all -> 0x01ea }
        r8 = r3.zzox();	 Catch:{ all -> 0x01ea }
        r8 = android.text.TextUtils.isEmpty(r8);	 Catch:{ all -> 0x01ea }
        if (r8 == 0) goto L_0x01e6;
    L_0x01e3:
        if (r5 != 0) goto L_0x01f8;
    L_0x01e5:
        r5 = 1;
    L_0x01e6:
        r4.add(r3);	 Catch:{ all -> 0x01ea }
        goto L_0x01cf;
    L_0x01ea:
        r2 = move-exception;
        r3 = r13;
    L_0x01ec:
        if (r3 == 0) goto L_0x01f1;
    L_0x01ee:
        r3.close();
    L_0x01f1:
        throw r2;
    L_0x01f2:
        r2 = new java.lang.String;	 Catch:{ all -> 0x01ea }
        r2.<init>(r3);	 Catch:{ all -> 0x01ea }
        goto L_0x01bc;
    L_0x01f8:
        if (r13 == 0) goto L_0x01fd;
    L_0x01fa:
        r13.close();
    L_0x01fd:
        r11 = r4;
        goto L_0x0010;
    L_0x0200:
        r2 = move-exception;
        goto L_0x01ec;
    L_0x0202:
        r2 = move-exception;
        goto L_0x01a8;
    L_0x0204:
        r2 = move-exception;
        goto L_0x0141;
    L_0x0207:
        r2 = move-exception;
        r3 = r13;
        r11 = r12;
        goto L_0x011b;
    L_0x020c:
        r2 = move-exception;
        r3 = r13;
        goto L_0x011b;
    L_0x0210:
        r5 = r2;
        goto L_0x00b1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhn.zzac(int):java.util.List<com.google.android.gms.internal.measurement.zzgw>");
    }

    private final void zza(String[] strArr) {
        boolean z = true;
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase zzdl = zzdl("Error opening database for deleteHits.");
            if (zzdl != null) {
                try {
                    zzdl.delete("gtm_hits", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                    zzhc zzhc = this.zzbju;
                    if (zzel("gtm_hits") != 0) {
                        z = false;
                    }
                    zzhc.zzo(z);
                } catch (SQLiteException e) {
                    String str = "Error deleting hits: ";
                    String valueOf = String.valueOf(e.getMessage());
                    zzhk.zzab(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                }
            }
        }
    }

    private final void zze(long j) {
        zza(new String[]{String.valueOf(j)});
    }

    private final void zze(long j, long j2) {
        SQLiteDatabase zzdl = zzdl("Error opening database for getNumStoredHits.");
        if (zzdl != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_first_send_time", Long.valueOf(j2));
            try {
                zzdl.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
            } catch (SQLiteException e) {
                String message = e.getMessage();
                zzhk.zzab(new StringBuilder(String.valueOf(message).length() + 70).append("Error setting HIT_FIRST_DISPATCH_TIME for hitId ").append(j).append(": ").append(message).toString());
                zze(j);
            }
        }
    }

    private final int zzel(String str) {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase zzdl = zzdl("Error opening database for getNumRecords.");
        if (zzdl != null) {
            String valueOf;
            try {
                String str2 = "SELECT COUNT(*) from ";
                valueOf = String.valueOf(str);
                cursor = zzdl.rawQuery(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                String str3 = "Error getting numStoredRecords: ";
                valueOf = String.valueOf(e.getMessage());
                zzhk.zzab(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    private final int zzpk() {
        Cursor query;
        int count;
        SQLiteException e;
        String str;
        String valueOf;
        Throwable th;
        SQLiteDatabase zzdl = zzdl("Error opening database for getNumStoredHits.");
        if (zzdl == null) {
            return 0;
        }
        try {
            query = zzdl.query("gtm_hits", new String[]{"hit_id", "hit_first_send_time"}, "hit_first_send_time=0", null, null, null, null);
            try {
                count = query.getCount();
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    str = "Error getting num untried hits: ";
                    valueOf = String.valueOf(e.getMessage());
                    zzhk.zzab(valueOf.length() == 0 ? new String(str) : str.concat(valueOf));
                    if (query == null) {
                        count = 0;
                    } else {
                        query.close();
                        count = 0;
                    }
                    return count;
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
            str = "Error getting num untried hits: ";
            valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() == 0) {
            }
            zzhk.zzab(valueOf.length() == 0 ? new String(str) : str.concat(valueOf));
            if (query == null) {
                query.close();
                count = 0;
            } else {
                count = 0;
            }
            return count;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return count;
    }

    public final void dispatch() {
        zzhk.m1082v("GTM Dispatch running...");
        if (this.zzbjt.zzom()) {
            List zzac = zzac(40);
            if (zzac.isEmpty()) {
                zzhk.m1082v("...nothing to dispatch");
                this.zzbju.zzo(true);
                return;
            }
            this.zzbjt.zzf(zzac);
            if (zzpk() > 0) {
                zzid.zzrj().dispatch();
            }
        }
    }

    private final SQLiteDatabase zzdl(String str) {
        try {
            return this.zzbjs.getWritableDatabase();
        } catch (Throwable e) {
            Context context = this.zzri;
            zzhk.zzb(str, e);
            if (CrashUtils.addDynamiteErrorToDropBox(context, e)) {
                zzhk.m1082v("Crash reported successfully.");
            } else {
                zzhk.m1082v("Failed to report crash");
            }
            return null;
        }
    }
}
