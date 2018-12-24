package com.google.android.gms.internal.measurement;

final class zzua {
    private static final Class<?> zzbuz = zzvn();

    private static Class<?> zzvn() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static zzub zzvo() {
        if (zzbuz != null) {
            try {
                return zzge("getEmptyRegistry");
            } catch (Exception e) {
            }
        }
        return zzub.zzbvd;
    }

    static zzub zzvp() {
        zzub zzub = null;
        if (zzbuz != null) {
            try {
                zzub = zzge("loadGeneratedRegistry");
            } catch (Exception e) {
            }
        }
        if (zzub == null) {
            zzub = zzub.zzvp();
        }
        return zzub == null ? zzvo() : zzub;
    }

    private static final zzub zzge(String str) {
        return (zzub) zzbuz.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
    }
}
