package com.google.android.gms.internal.firebase_auth;

final class zzff {
    private static final Class<?> zztt = zzgm();

    private static Class<?> zzgm() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static zzfg zzgn() {
        if (zztt != null) {
            try {
                return zzdc("getEmptyRegistry");
            } catch (Exception e) {
            }
        }
        return zzfg.zztx;
    }

    static zzfg zzgo() {
        zzfg zzfg = null;
        if (zztt != null) {
            try {
                zzfg = zzdc("loadGeneratedRegistry");
            } catch (Exception e) {
            }
        }
        if (zzfg == null) {
            zzfg = zzfg.zzgo();
        }
        return zzfg == null ? zzgn() : zzfg;
    }

    private static final zzfg zzdc(String str) {
        return (zzfg) zztt.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
    }
}
