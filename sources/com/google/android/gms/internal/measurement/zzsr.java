package com.google.android.gms.internal.measurement;

import java.io.PrintStream;

public final class zzsr {
    private static final zzss zzbsd;
    private static final int zzbse;

    static final class zza extends zzss {
        zza() {
        }

        public final void zza(Throwable th, PrintStream printStream) {
            th.printStackTrace(printStream);
        }
    }

    public static void zza(Throwable th, PrintStream printStream) {
        zzbsd.zza(th, printStream);
    }

    private static Integer zztu() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }

    static {
        Integer num = null;
        zzss zzsv;
        try {
            num = zztu();
            if (num == null || num.intValue() < 19) {
                if ((!Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? 1 : null) != null) {
                    zzsv = new zzsv();
                } else {
                    zzsv = new zza();
                }
                zzbsd = zzsv;
                zzbse = num != null ? 1 : num.intValue();
            }
            zzsv = new zzsw();
            zzbsd = zzsv;
            if (num != null) {
            }
            zzbse = num != null ? 1 : num.intValue();
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = zza.class.getName();
            printStream.println(new StringBuilder(String.valueOf(name).length() + 132).append("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ").append(name).append("will be used. The error is: ").toString());
            th.printStackTrace(System.err);
            zzsv = new zza();
        }
    }
}
