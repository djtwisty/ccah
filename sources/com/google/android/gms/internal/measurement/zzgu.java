package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class zzgu extends ThreadPoolExecutor {
    private final Context zzri;

    public zzgu(Context context, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(1, 1, 0, timeUnit, blockingQueue, threadFactory);
        this.zzri = context;
    }

    protected final void afterExecute(Runnable runnable, Throwable th) {
        if (th != null) {
            zzgp.zza("Uncaught exception: ", th, this.zzri);
        }
    }
}
