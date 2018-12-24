package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

final class zzje {

    static class zza {
        private static volatile ExecutorService zzbmc = null;

        private zza() {
        }

        public static ExecutorService zzaa(Context context) {
            if (zzbmc == null) {
                synchronized (zza.class) {
                    if (zzbmc == null) {
                        zzbmc = new zzgu(context, 1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new zzjf());
                    }
                }
            }
            return zzbmc;
        }
    }
}
