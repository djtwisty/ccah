package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class zzpz {
    private boolean closed;
    private String zzbaw;
    private final ScheduledExecutorService zzbet;
    private ScheduledFuture<?> zzbev;

    public zzpz() {
        this(Executors.newSingleThreadScheduledExecutor());
    }

    @VisibleForTesting
    private zzpz(ScheduledExecutorService scheduledExecutorService) {
        this.zzbev = null;
        this.zzbaw = null;
        this.zzbet = scheduledExecutorService;
        this.closed = false;
    }

    public final void zza(Context context, zzpl zzpl, long j, zzpc zzpc) {
        synchronized (this) {
            if (this.zzbev != null) {
                this.zzbev.cancel(false);
            }
            this.zzbev = this.zzbet.schedule(new zzpy(context, zzpl, zzpc), 0, TimeUnit.MILLISECONDS);
        }
    }
}
