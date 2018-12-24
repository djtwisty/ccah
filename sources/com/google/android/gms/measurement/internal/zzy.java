package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdl;

abstract class zzy {
    private static volatile Handler handler;
    private final zzct zzahn;
    private final Runnable zzyo;
    private volatile long zzyp;

    zzy(zzct zzct) {
        Preconditions.checkNotNull(zzct);
        this.zzahn = zzct;
        this.zzyo = new zzz(this, zzct);
    }

    public abstract void run();

    public final void zzh(long j) {
        cancel();
        if (j >= 0) {
            this.zzyp = this.zzahn.zzbx().currentTimeMillis();
            if (!getHandler().postDelayed(this.zzyo, j)) {
                this.zzahn.zzgt().zzjg().zzg("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public final boolean zzej() {
        return this.zzyp != 0;
    }

    final void cancel() {
        this.zzyp = 0;
        getHandler().removeCallbacks(this.zzyo);
    }

    private final Handler getHandler() {
        if (handler != null) {
            return handler;
        }
        Handler handler;
        synchronized (zzy.class) {
            if (handler == null) {
                handler = new zzdl(this.zzahn.getContext().getMainLooper());
            }
            handler = handler;
        }
        return handler;
    }
}
