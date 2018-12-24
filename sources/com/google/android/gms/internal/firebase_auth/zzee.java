package com.google.android.gms.internal.firebase_auth;

final class zzee {
    private static final Class<?> zzsk = zzcy("libcore.io.Memory");
    private static final boolean zzsl = (zzcy("org.robolectric.Robolectric") != null);

    static boolean zzex() {
        return (zzsk == null || zzsl) ? false : true;
    }

    static Class<?> zzey() {
        return zzsk;
    }

    private static <T> Class<T> zzcy(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable th) {
            return null;
        }
    }
}
