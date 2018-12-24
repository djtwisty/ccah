package com.google.android.gms.internal.firebase_messaging;

import java.io.PrintStream;

public final class zzc {
    private static final zzd zzb;
    private static final int zzc;

    static final class zza extends zzd {
        zza() {
        }

        public final void zza(Throwable th, Throwable th2) {
        }
    }

    public static void zza(Throwable th, Throwable th2) {
        zzb.zza(th, th2);
    }

    private static Integer zza() {
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
        zzd zzg;
        try {
            num = zza();
            if (num == null || num.intValue() < 19) {
                if ((!Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? 1 : null) != null) {
                    zzg = new zzg();
                } else {
                    zzg = new zza();
                }
                zzb = zzg;
                zzc = num != null ? 1 : num.intValue();
            }
            zzg = new zzh();
            zzb = zzg;
            if (num != null) {
            }
            zzc = num != null ? 1 : num.intValue();
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = zza.class.getName();
            printStream.println(new StringBuilder(String.valueOf(name).length() + 132).append("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ").append(name).append("will be used. The error is: ").toString());
            th.printStackTrace(System.err);
            zzg = new zza();
        }
    }
}
