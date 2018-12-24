package com.google.zxing.client.android.history;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.google.zxing.client.android.Intents.Scan;
import com.google.zxing.client.android.PreferencesActivity;
import com.google.zxing.client.android.result.ResultHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.http.protocol.HTTP;

public final class HistoryManager {
    private static final String[] COLUMNS = new String[]{"text", "display", "format", Param.TIMESTAMP, "details"};
    private static final String[] COUNT_COLUMN = new String[]{"COUNT(1)"};
    private static final String[] ID_COL_PROJECTION = new String[]{"id"};
    private static final String[] ID_DETAIL_COL_PROJECTION = new String[]{"id", "details"};
    private static final int MAX_ITEMS = 2000;
    private static final String TAG = HistoryManager.class.getSimpleName();
    private final Activity activity;
    private final boolean enableHistory;

    public HistoryManager(Activity activity) {
        this.activity = activity;
        this.enableHistory = PreferenceManager.getDefaultSharedPreferences(activity).getBoolean(PreferencesActivity.KEY_ENABLE_HISTORY, true);
    }

    public boolean hasHistoryItems() {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        Cursor query;
        try {
            SQLiteDatabase readableDatabase = new DBHelper(this.activity).getReadableDatabase();
            try {
                query = readableDatabase.query("history", COUNT_COLUMN, null, null, null, null, null);
                try {
                    query.moveToFirst();
                    boolean z = query.getInt(0) > 0;
                    close(query, readableDatabase);
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase = readableDatabase;
                    close(query, sQLiteDatabase);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                query = null;
                sQLiteDatabase = readableDatabase;
                close(query, sQLiteDatabase);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            sQLiteDatabase = null;
            close(query, sQLiteDatabase);
            throw th;
        }
    }

    public List<HistoryItem> buildHistoryItems() {
        Throwable th;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor2 = null;
        SQLiteOpenHelper dBHelper = new DBHelper(this.activity);
        List<HistoryItem> arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = dBHelper.getReadableDatabase();
            try {
                cursor2 = readableDatabase.query("history", COLUMNS, null, null, null, null, "timestamp DESC");
                while (cursor2.moveToNext()) {
                    try {
                        String string = cursor2.getString(0);
                        String string2 = cursor2.getString(1);
                        String string3 = cursor2.getString(2);
                        long j = cursor2.getLong(3);
                        arrayList.add(new HistoryItem(new Result(string, null, null, BarcodeFormat.valueOf(string3), j), string2, cursor2.getString(4)));
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursor2;
                        sQLiteDatabase = readableDatabase;
                    }
                }
                close(cursor2, readableDatabase);
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
                cursor = cursor2;
                sQLiteDatabase = readableDatabase;
                close(cursor, sQLiteDatabase);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            cursor = cursor2;
            Object obj = cursor2;
            close(cursor, sQLiteDatabase);
            throw th;
        }
    }

    public HistoryItem buildHistoryItem(int i) {
        Throwable th;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor2 = null;
        try {
            SQLiteDatabase readableDatabase = new DBHelper(this.activity).getReadableDatabase();
            try {
                cursor2 = readableDatabase.query("history", COLUMNS, null, null, null, null, "timestamp DESC");
                try {
                    cursor2.move(i + 1);
                    String string = cursor2.getString(0);
                    String string2 = cursor2.getString(1);
                    String string3 = cursor2.getString(2);
                    long j = cursor2.getLong(3);
                    HistoryItem historyItem = new HistoryItem(new Result(string, null, null, BarcodeFormat.valueOf(string3), j), string2, cursor2.getString(4));
                    close(cursor2, readableDatabase);
                    return historyItem;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursor2;
                    sQLiteDatabase = readableDatabase;
                    close(cursor, sQLiteDatabase);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = cursor2;
                sQLiteDatabase = readableDatabase;
                close(cursor, sQLiteDatabase);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            cursor = cursor2;
            sQLiteDatabase = cursor2;
            close(cursor, sQLiteDatabase);
            throw th;
        }
    }

    public void deleteHistoryItem(int i) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        Cursor query;
        try {
            SQLiteDatabase writableDatabase = new DBHelper(this.activity).getWritableDatabase();
            try {
                query = writableDatabase.query("history", ID_COL_PROJECTION, null, null, null, null, "timestamp DESC");
                try {
                    query.move(i + 1);
                    writableDatabase.delete("history", "id=" + query.getString(0), null);
                    close(query, writableDatabase);
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase = writableDatabase;
                    close(query, sQLiteDatabase);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                query = null;
                sQLiteDatabase = writableDatabase;
                close(query, sQLiteDatabase);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            sQLiteDatabase = null;
            close(query, sQLiteDatabase);
            throw th;
        }
    }

    public void addHistoryItem(Result result, ResultHandler resultHandler) {
        SQLiteDatabase writableDatabase;
        Throwable th;
        if (this.activity.getIntent().getBooleanExtra(Scan.SAVE_HISTORY, true) && !resultHandler.areContentsSecure() && this.enableHistory) {
            if (!PreferenceManager.getDefaultSharedPreferences(this.activity).getBoolean(PreferencesActivity.KEY_REMEMBER_DUPLICATES, false)) {
                deletePrevious(result.getText());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("text", result.getText());
            contentValues.put("format", result.getBarcodeFormat().toString());
            contentValues.put("display", resultHandler.getDisplayContents().toString());
            contentValues.put(Param.TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
            try {
                writableDatabase = new DBHelper(this.activity).getWritableDatabase();
                try {
                    writableDatabase.insert("history", Param.TIMESTAMP, contentValues);
                    close(null, writableDatabase);
                } catch (Throwable th2) {
                    th = th2;
                    close(null, writableDatabase);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                writableDatabase = null;
                close(null, writableDatabase);
                throw th;
            }
        }
    }

    public void addHistoryItemDetails(String str, String str2) {
        Cursor query;
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        try {
            SQLiteDatabase writableDatabase = new DBHelper(this.activity).getWritableDatabase();
            try {
                query = writableDatabase.query("history", ID_DETAIL_COL_PROJECTION, "text=?", new String[]{str}, null, null, "timestamp DESC", "1");
                try {
                    String string;
                    String string2;
                    if (query.moveToNext()) {
                        string = query.getString(0);
                        string2 = query.getString(1);
                    } else {
                        string2 = null;
                        string = null;
                    }
                    if (string != null) {
                        if (string2 != null) {
                            if (string2.contains(str2)) {
                                str2 = null;
                            } else {
                                str2 = string2 + " : " + str2;
                            }
                        }
                        if (str2 != null) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("details", str2);
                            writableDatabase.update("history", contentValues, "id=?", new String[]{string});
                        }
                    }
                    close(query, writableDatabase);
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase = writableDatabase;
                    close(query, sQLiteDatabase);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                query = null;
                sQLiteDatabase = writableDatabase;
                close(query, sQLiteDatabase);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            sQLiteDatabase = null;
            close(query, sQLiteDatabase);
            throw th;
        }
    }

    private void deletePrevious(String str) {
        Throwable th;
        SQLiteDatabase writableDatabase;
        try {
            writableDatabase = new DBHelper(this.activity).getWritableDatabase();
            try {
                writableDatabase.delete("history", "text=?", new String[]{str});
                close(null, writableDatabase);
            } catch (Throwable th2) {
                th = th2;
                close(null, writableDatabase);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            writableDatabase = null;
            close(null, writableDatabase);
            throw th;
        }
    }

    public void trimHistory() {
        Cursor query;
        Throwable e;
        SQLiteDatabase sQLiteDatabase;
        try {
            SQLiteDatabase writableDatabase = new DBHelper(this.activity).getWritableDatabase();
            try {
                query = writableDatabase.query("history", ID_COL_PROJECTION, null, null, null, null, "timestamp DESC");
                try {
                    query.move(MAX_ITEMS);
                    while (query.moveToNext()) {
                        String string = query.getString(0);
                        Log.i(TAG, "Deleting scan history ID " + string);
                        writableDatabase.delete("history", "id=" + string, null);
                    }
                    close(query, writableDatabase);
                } catch (SQLiteException e2) {
                    e = e2;
                    sQLiteDatabase = writableDatabase;
                    try {
                        Log.w(TAG, e);
                        close(query, sQLiteDatabase);
                    } catch (Throwable th) {
                        e = th;
                        close(query, sQLiteDatabase);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    sQLiteDatabase = writableDatabase;
                    close(query, sQLiteDatabase);
                    throw e;
                }
            } catch (SQLiteException e3) {
                e = e3;
                query = null;
                sQLiteDatabase = writableDatabase;
                Log.w(TAG, e);
                close(query, sQLiteDatabase);
            } catch (Throwable th3) {
                e = th3;
                query = null;
                sQLiteDatabase = writableDatabase;
                close(query, sQLiteDatabase);
                throw e;
            }
        } catch (Throwable th4) {
            e = th4;
            query = null;
            sQLiteDatabase = null;
            Log.w(TAG, e);
            close(query, sQLiteDatabase);
        } catch (Throwable th42) {
            e = th42;
            query = null;
            sQLiteDatabase = null;
            close(query, sQLiteDatabase);
            throw e;
        }
    }

    CharSequence buildHistory() {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        Cursor query;
        try {
            SQLiteDatabase writableDatabase = new DBHelper(this.activity).getWritableDatabase();
            try {
                query = writableDatabase.query("history", COLUMNS, null, null, null, null, "timestamp DESC");
                try {
                    DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(2, 2);
                    CharSequence stringBuilder = new StringBuilder(1000);
                    while (query.moveToNext()) {
                        stringBuilder.append('\"').append(massageHistoryField(query.getString(0))).append("\",");
                        stringBuilder.append('\"').append(massageHistoryField(query.getString(1))).append("\",");
                        stringBuilder.append('\"').append(massageHistoryField(query.getString(2))).append("\",");
                        stringBuilder.append('\"').append(massageHistoryField(query.getString(3))).append("\",");
                        stringBuilder.append('\"').append(massageHistoryField(dateTimeInstance.format(new Date(query.getLong(3))))).append("\",");
                        stringBuilder.append('\"').append(massageHistoryField(query.getString(4))).append("\"\r\n");
                    }
                    close(query, writableDatabase);
                    return stringBuilder;
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase = writableDatabase;
                    close(query, sQLiteDatabase);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                query = null;
                sQLiteDatabase = writableDatabase;
                close(query, sQLiteDatabase);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            sQLiteDatabase = null;
            close(query, sQLiteDatabase);
            throw th;
        }
    }

    void clearHistory() {
        Throwable th;
        SQLiteDatabase writableDatabase;
        try {
            writableDatabase = new DBHelper(this.activity).getWritableDatabase();
            try {
                writableDatabase.delete("history", null, null);
                close(null, writableDatabase);
            } catch (Throwable th2) {
                th = th2;
                close(null, writableDatabase);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            writableDatabase = null;
            close(null, writableDatabase);
            throw th;
        }
    }

    static Uri saveHistory(String str) {
        OutputStreamWriter outputStreamWriter;
        Object e;
        Throwable th;
        Uri uri = null;
        File file = new File(new File(Environment.getExternalStorageDirectory(), "BarcodeScanner"), "History");
        if (file.exists() || file.mkdirs()) {
            File file2 = new File(file, "history-" + System.currentTimeMillis() + ".csv");
            try {
                outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file2), Charset.forName(HTTP.UTF_8));
                try {
                    outputStreamWriter.write(str);
                    uri = Uri.parse("file://" + file2.getAbsolutePath());
                    if (outputStreamWriter != null) {
                        try {
                            outputStreamWriter.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        Log.w(TAG, "Couldn't access file " + file2 + " due to " + e);
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (IOException e4) {
                            }
                        }
                        return uri;
                    } catch (Throwable th2) {
                        th = th2;
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (IOException e5) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                outputStreamWriter = uri;
                Log.w(TAG, "Couldn't access file " + file2 + " due to " + e);
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                return uri;
            } catch (Throwable th3) {
                th = th3;
                outputStreamWriter = uri;
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                throw th;
            }
        }
        Log.w(TAG, "Couldn't make dir " + file);
        return uri;
    }

    private static String massageHistoryField(String str) {
        return str == null ? "" : str.replace("\"", "\"\"");
    }

    private static void close(Cursor cursor, SQLiteDatabase sQLiteDatabase) {
        if (cursor != null) {
            cursor.close();
        }
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
    }
}
