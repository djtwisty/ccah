package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@VisibleForTesting
final class zzhp extends SQLiteOpenHelper {
    private boolean zzbdw;
    private long zzbdx = 0;
    private final /* synthetic */ zzhn zzbjv;

    zzhp(zzhn zzhn, Context context, String str) {
        this.zzbjv = zzhn;
        super(context, str, null, 1);
    }

    private static boolean zza(String str, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
            try {
                boolean moveToFirst = query.moveToFirst();
                if (query == null) {
                    return moveToFirst;
                }
                query.close();
                return moveToFirst;
            } catch (SQLiteException e) {
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public final SQLiteDatabase getWritableDatabase() {
        if (!this.zzbdw || this.zzbdx + 3600000 <= this.zzbjv.zzrz.currentTimeMillis()) {
            SQLiteDatabase sQLiteDatabase = null;
            this.zzbdw = true;
            this.zzbdx = this.zzbjv.zzrz.currentTimeMillis();
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                this.zzbjv.zzri.getDatabasePath(this.zzbjv.zzbds).delete();
            }
            if (sQLiteDatabase == null) {
                sQLiteDatabase = super.getWritableDatabase();
            }
            this.zzbdw = false;
            return sQLiteDatabase;
        }
        throw new SQLiteException("Database creation failed");
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (VERSION.SDK_INT < 15) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
            try {
                rawQuery.moveToFirst();
            } finally {
                rawQuery.close();
            }
        }
        if (zza("gtm_hit_unique_ids", sQLiteDatabase)) {
            String str = "gtm_hit_unique_ids";
            zza(sQLiteDatabase, str, Arrays.asList(new String[]{"hit_unique_id"}));
        } else {
            sQLiteDatabase.execSQL(zzhn.zzbjp);
        }
        if (zza("gtm_hits", sQLiteDatabase)) {
            str = "gtm_hits";
            zza(sQLiteDatabase, str, Arrays.asList(new String[]{"hit_id", "hit_url", "hit_time", "hit_first_send_time", "hit_method", "hit_unique_id", "hit_headers", "hit_body"}));
        } else {
            sQLiteDatabase.execSQL(zzhn.zzxf);
        }
        sQLiteDatabase.execSQL(zzhn.zzbjq);
        sQLiteDatabase.execSQL(zzhn.zzbjr);
    }

    private static void zza(SQLiteDatabase sQLiteDatabase, String str, List<String> list) {
        Cursor rawQuery = sQLiteDatabase.rawQuery(new StringBuilder(String.valueOf(str).length() + 22).append("SELECT * FROM ").append(str).append(" WHERE 0").toString(), null);
        Set hashSet = new HashSet();
        try {
            String[] columnNames = rawQuery.getColumnNames();
            for (Object add : columnNames) {
                hashSet.add(add);
            }
            for (String remove : list) {
                if (!hashSet.remove(remove)) {
                    throw new SQLiteException(String.format("Database column %s missing in table %s.", new Object[]{(String) r2.next(), str}));
                }
            }
            if (!hashSet.isEmpty()) {
                throw new SQLiteException(String.format("Database has extra columns in table %s.", new Object[]{str}));
            }
        } finally {
            rawQuery.close();
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        String path = sQLiteDatabase.getPath();
        if (zzgv.version() >= 9) {
            File file = new File(path);
            file.setReadable(false, false);
            file.setWritable(false, false);
            file.setReadable(true, true);
            file.setWritable(true, true);
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
