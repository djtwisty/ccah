package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
final class zzap extends SQLiteOpenHelper {
    private final /* synthetic */ zzao zzalo;

    zzap(zzao zzao, Context context, String str) {
        this.zzalo = zzao;
        super(context, str, null, 1);
    }

    public final SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException e) {
            throw e;
        } catch (SQLiteException e2) {
            this.zzalo.zzgt().zzjg().zzby("Opening the local database failed, dropping and recreating it");
            String str = "google_app_measurement_local.db";
            if (!this.zzalo.getContext().getDatabasePath(str).delete()) {
                this.zzalo.zzgt().zzjg().zzg("Failed to delete corrupted local db file", str);
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e3) {
                this.zzalo.zzgt().zzjg().zzg("Failed to open local database. Events will bypass local storage", e3);
                return null;
            }
        }
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        Cursor cursor = null;
        if (VERSION.SDK_INT < 15) {
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = rawQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        zzx.zza(this.zzalo.zzgt(), sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzx.zza(this.zzalo.zzgt(), sQLiteDatabase);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
