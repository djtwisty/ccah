package org.apache.cordova;

import android.util.Log;

public class LOG {
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static int LOGLEVEL = 6;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    public static void setLogLevel(int i) {
        LOGLEVEL = i;
        Log.i("CordovaLog", "Changing log level to " + i);
    }

    public static void setLogLevel(String str) {
        if ("VERBOSE".equals(str)) {
            LOGLEVEL = 2;
        } else if ("DEBUG".equals(str)) {
            LOGLEVEL = 3;
        } else if ("INFO".equals(str)) {
            LOGLEVEL = 4;
        } else if ("WARN".equals(str)) {
            LOGLEVEL = 5;
        } else if ("ERROR".equals(str)) {
            LOGLEVEL = 6;
        }
        Log.i("CordovaLog", "Changing log level to " + str + "(" + LOGLEVEL + ")");
    }

    public static boolean isLoggable(int i) {
        return i >= LOGLEVEL;
    }

    /* renamed from: v */
    public static void m1354v(String str, String str2) {
        if (2 >= LOGLEVEL) {
            Log.v(str, str2);
        }
    }

    /* renamed from: d */
    public static void m1345d(String str, String str2) {
        if (3 >= LOGLEVEL) {
            Log.d(str, str2);
        }
    }

    /* renamed from: i */
    public static void m1351i(String str, String str2) {
        if (4 >= LOGLEVEL) {
            Log.i(str, str2);
        }
    }

    /* renamed from: w */
    public static void m1357w(String str, String str2) {
        if (5 >= LOGLEVEL) {
            Log.w(str, str2);
        }
    }

    /* renamed from: e */
    public static void m1348e(String str, String str2) {
        if (6 >= LOGLEVEL) {
            Log.e(str, str2);
        }
    }

    /* renamed from: v */
    public static void m1355v(String str, String str2, Throwable th) {
        if (2 >= LOGLEVEL) {
            Log.v(str, str2, th);
        }
    }

    /* renamed from: d */
    public static void m1346d(String str, String str2, Throwable th) {
        if (3 >= LOGLEVEL) {
            Log.d(str, str2, th);
        }
    }

    /* renamed from: i */
    public static void m1352i(String str, String str2, Throwable th) {
        if (4 >= LOGLEVEL) {
            Log.i(str, str2, th);
        }
    }

    /* renamed from: w */
    public static void m1360w(String str, Throwable th) {
        if (5 >= LOGLEVEL) {
            Log.w(str, th);
        }
    }

    /* renamed from: w */
    public static void m1358w(String str, String str2, Throwable th) {
        if (5 >= LOGLEVEL) {
            Log.w(str, str2, th);
        }
    }

    /* renamed from: e */
    public static void m1349e(String str, String str2, Throwable th) {
        if (6 >= LOGLEVEL) {
            Log.e(str, str2, th);
        }
    }

    /* renamed from: v */
    public static void m1356v(String str, String str2, Object... objArr) {
        if (2 >= LOGLEVEL) {
            Log.v(str, String.format(str2, objArr));
        }
    }

    /* renamed from: d */
    public static void m1347d(String str, String str2, Object... objArr) {
        if (3 >= LOGLEVEL) {
            Log.d(str, String.format(str2, objArr));
        }
    }

    /* renamed from: i */
    public static void m1353i(String str, String str2, Object... objArr) {
        if (4 >= LOGLEVEL) {
            Log.i(str, String.format(str2, objArr));
        }
    }

    /* renamed from: w */
    public static void m1359w(String str, String str2, Object... objArr) {
        if (5 >= LOGLEVEL) {
            Log.w(str, String.format(str2, objArr));
        }
    }

    /* renamed from: e */
    public static void m1350e(String str, String str2, Object... objArr) {
        if (6 >= LOGLEVEL) {
            Log.e(str, String.format(str2, objArr));
        }
    }
}
