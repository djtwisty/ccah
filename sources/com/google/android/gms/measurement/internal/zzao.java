package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.ArrayList;
import java.util.List;

public final class zzao extends zzf {
    private final zzap zzalm = new zzap(this, getContext(), "google_app_measurement_local.db");
    private boolean zzaln;

    zzao(zzbw zzbw) {
        super(zzbw);
    }

    protected final boolean zzgy() {
        return false;
    }

    public final void resetAnalyticsData() {
        zzgg();
        zzaf();
        try {
            int delete = getWritableDatabase().delete("messages", null, null) + 0;
            if (delete > 0) {
                zzgt().zzjo().zzg("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzgt().zzjg().zzg("Error resetting local analytics data. error", e);
        }
    }

    private final boolean zza(int i, byte[] bArr) {
        zzgg();
        zzaf();
        if (this.zzaln) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(Param.TYPE, Integer.valueOf(i));
        contentValues.put("entry", bArr);
        int i2 = 5;
        int i3 = 0;
        while (i3 < 5) {
            SQLiteDatabase sQLiteDatabase = null;
            Cursor cursor = null;
            try {
                sQLiteDatabase = getWritableDatabase();
                if (sQLiteDatabase == null) {
                    this.zzaln = true;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return false;
                }
                sQLiteDatabase.beginTransaction();
                long j = 0;
                cursor = sQLiteDatabase.rawQuery("select count(1) from messages", null);
                if (cursor != null && cursor.moveToFirst()) {
                    j = cursor.getLong(0);
                }
                if (j >= 100000) {
                    zzgt().zzjg().zzby("Data loss, local db full");
                    j = (100000 - j) + 1;
                    long delete = (long) sQLiteDatabase.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", new String[]{Long.toString(j)});
                    if (delete != j) {
                        zzgt().zzjg().zzd("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j), Long.valueOf(delete), Long.valueOf(j - delete));
                    }
                }
                sQLiteDatabase.insertOrThrow("messages", null, contentValues);
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                return true;
            } catch (SQLiteFullException e) {
                zzgt().zzjg().zzg("Error writing entry to local database", e);
                this.zzaln = true;
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                i3++;
            } catch (SQLiteDatabaseLockedException e2) {
                SystemClock.sleep((long) i2);
                i2 += 20;
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                i3++;
            } catch (SQLiteException e3) {
                if (sQLiteDatabase != null) {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                }
                zzgt().zzjg().zzg("Error writing entry to local database", e3);
                this.zzaln = true;
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                i3++;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            }
        }
        zzgt().zzjj().zzby("Failed to write entry to local database");
        return false;
    }

    public final boolean zza(zzag zzag) {
        Parcel obtain = Parcel.obtain();
        zzag.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(0, marshall);
        }
        zzgt().zzjj().zzby("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzfv zzfv) {
        Parcel obtain = Parcel.obtain();
        zzfv.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(1, marshall);
        }
        zzgt().zzjj().zzby("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zzc(zzo zzo) {
        zzgr();
        byte[] zza = zzfy.zza((Parcelable) zzo);
        if (zza.length <= 131072) {
            return zza(2, zza);
        }
        zzgt().zzjj().zzby("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final List<AbstractSafeParcelable> zzr(int i) {
        Object e;
        int i2;
        Throwable th;
        zzaf();
        zzgg();
        if (this.zzaln) {
            return null;
        }
        List<AbstractSafeParcelable> arrayList = new ArrayList();
        if (!getContext().getDatabasePath("google_app_measurement_local.db").exists()) {
            return arrayList;
        }
        int i3 = 5;
        int i4 = 0;
        while (i4 < 5) {
            Cursor cursor;
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase == null) {
                    try {
                        this.zzaln = true;
                        if (writableDatabase != null) {
                            writableDatabase.close();
                        }
                        return null;
                    } catch (SQLiteFullException e2) {
                        e = e2;
                        cursor = null;
                        sQLiteDatabase = writableDatabase;
                    } catch (SQLiteDatabaseLockedException e3) {
                        cursor = null;
                        sQLiteDatabase = writableDatabase;
                        try {
                            SystemClock.sleep((long) i3);
                            i2 = i3 + 20;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            i4++;
                            i3 = i2;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (SQLiteException e4) {
                        e = e4;
                        cursor = null;
                        sQLiteDatabase = writableDatabase;
                        if (sQLiteDatabase != null) {
                            if (sQLiteDatabase.inTransaction()) {
                                sQLiteDatabase.endTransaction();
                            }
                        }
                        zzgt().zzjg().zzg("Error reading entries from local database", e);
                        this.zzaln = true;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                            i2 = i3;
                            i4++;
                            i3 = i2;
                        }
                        i2 = i3;
                        i4++;
                        i3 = i2;
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = null;
                        sQLiteDatabase = writableDatabase;
                    }
                } else {
                    writableDatabase.beginTransaction();
                    cursor = writableDatabase.query("messages", new String[]{"rowid", Param.TYPE, "entry"}, null, null, null, null, "rowid asc", Integer.toString(100));
                    long j = -1;
                    while (cursor.moveToNext()) {
                        try {
                            j = cursor.getLong(0);
                            int i5 = cursor.getInt(1);
                            byte[] blob = cursor.getBlob(2);
                            if (i5 == 0) {
                                Parcel obtain = Parcel.obtain();
                                try {
                                    obtain.unmarshall(blob, 0, blob.length);
                                    obtain.setDataPosition(0);
                                    zzag zzag = (zzag) zzag.CREATOR.createFromParcel(obtain);
                                    obtain.recycle();
                                    if (zzag != null) {
                                        arrayList.add(zzag);
                                    }
                                } catch (ParseException e5) {
                                    zzgt().zzjg().zzby("Failed to load event from local database");
                                    obtain.recycle();
                                } catch (Throwable th4) {
                                    obtain.recycle();
                                    throw th4;
                                }
                            } else if (i5 == 1) {
                                r7 = Parcel.obtain();
                                try {
                                    r7.unmarshall(blob, 0, blob.length);
                                    r7.setDataPosition(0);
                                    e = (zzfv) zzfv.CREATOR.createFromParcel(r7);
                                    r7.recycle();
                                } catch (ParseException e6) {
                                    zzgt().zzjg().zzby("Failed to load user property from local database");
                                    r7.recycle();
                                    e = null;
                                } catch (Throwable th42) {
                                    r7.recycle();
                                    throw th42;
                                }
                                if (e != null) {
                                    arrayList.add(e);
                                }
                            } else if (i5 == 2) {
                                r7 = Parcel.obtain();
                                try {
                                    r7.unmarshall(blob, 0, blob.length);
                                    r7.setDataPosition(0);
                                    e = (zzo) zzo.CREATOR.createFromParcel(r7);
                                    r7.recycle();
                                } catch (ParseException e7) {
                                    zzgt().zzjg().zzby("Failed to load user property from local database");
                                    r7.recycle();
                                    e = null;
                                } catch (Throwable th422) {
                                    r7.recycle();
                                    throw th422;
                                }
                                if (e != null) {
                                    arrayList.add(e);
                                }
                            } else {
                                zzgt().zzjg().zzby("Unknown record type in local database");
                            }
                        } catch (SQLiteFullException e8) {
                            e = e8;
                            sQLiteDatabase = writableDatabase;
                        } catch (SQLiteDatabaseLockedException e9) {
                            sQLiteDatabase = writableDatabase;
                        } catch (SQLiteException e10) {
                            e = e10;
                            sQLiteDatabase = writableDatabase;
                        } catch (Throwable th5) {
                            th422 = th5;
                            sQLiteDatabase = writableDatabase;
                        }
                    }
                    if (writableDatabase.delete("messages", "rowid <= ?", new String[]{Long.toString(j)}) < arrayList.size()) {
                        zzgt().zzjg().zzby("Fewer entries removed from local database than expected");
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (writableDatabase != null) {
                        writableDatabase.close();
                    }
                    return arrayList;
                }
            } catch (SQLiteFullException e11) {
                SQLiteFullException sQLiteFullException = e11;
                cursor = null;
                zzgt().zzjg().zzg("Error reading entries from local database", e);
                this.zzaln = true;
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                    i2 = i3;
                    i4++;
                    i3 = i2;
                }
                i2 = i3;
                i4++;
                i3 = i2;
            } catch (SQLiteDatabaseLockedException e12) {
                cursor = null;
                SystemClock.sleep((long) i3);
                i2 = i3 + 20;
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                i4++;
                i3 = i2;
            } catch (SQLiteException e13) {
                SQLiteException sQLiteException = e13;
                cursor = null;
                if (sQLiteDatabase != null) {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                }
                zzgt().zzjg().zzg("Error reading entries from local database", e);
                this.zzaln = true;
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                    i2 = i3;
                    i4++;
                    i3 = i2;
                }
                i2 = i3;
                i4++;
                i3 = i2;
            } catch (Throwable th22) {
                th422 = th22;
                cursor = null;
            }
        }
        zzgt().zzjj().zzby("Failed to read events from database in reasonable time");
        return null;
        if (cursor != null) {
            cursor.close();
        }
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
        throw th422;
    }

    @VisibleForTesting
    private final SQLiteDatabase getWritableDatabase() {
        if (this.zzaln) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zzalm.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzaln = true;
        return null;
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
