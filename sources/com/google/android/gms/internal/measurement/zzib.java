package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

final class zzib implements zzht {
    private final long zzabb;
    private final int zzabc;
    private double zzabd;
    private final Object zzabf;
    private long zzbfw;
    private Clock zzrz;

    private zzib(int i, long j) {
        this.zzabf = new Object();
        this.zzabc = 60;
        this.zzabd = (double) this.zzabc;
        this.zzabb = 2000;
        this.zzrz = DefaultClock.getInstance();
    }

    public zzib() {
        this(60, 2000);
    }

    public final boolean zzew() {
        boolean z;
        synchronized (this.zzabf) {
            long currentTimeMillis = this.zzrz.currentTimeMillis();
            if (this.zzabd < ((double) this.zzabc)) {
                double d = ((double) (currentTimeMillis - this.zzbfw)) / ((double) this.zzabb);
                if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    this.zzabd = Math.min((double) this.zzabc, d + this.zzabd);
                }
            }
            this.zzbfw = currentTimeMillis;
            if (this.zzabd >= 1.0d) {
                this.zzabd -= 1.0d;
                z = true;
            } else {
                zzhk.zzab("No more tokens available.");
                z = false;
            }
        }
        return z;
    }
}
