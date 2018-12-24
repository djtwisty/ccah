package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

@VisibleForTesting
public final class zzcn {
    private final long zzabb;
    private final int zzabc;
    private double zzabd;
    private long zzabe;
    private final Object zzabf;
    private final Clock zzrz;
    private final String zzul;

    private zzcn(int i, long j, String str, Clock clock) {
        this.zzabf = new Object();
        this.zzabc = 60;
        this.zzabd = (double) this.zzabc;
        this.zzabb = 2000;
        this.zzul = str;
        this.zzrz = clock;
    }

    public zzcn(String str, Clock clock) {
        this(60, 2000, str, clock);
    }

    public final boolean zzew() {
        boolean z;
        synchronized (this.zzabf) {
            long currentTimeMillis = this.zzrz.currentTimeMillis();
            if (this.zzabd < ((double) this.zzabc)) {
                double d = ((double) (currentTimeMillis - this.zzabe)) / ((double) this.zzabb);
                if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    this.zzabd = Math.min((double) this.zzabc, d + this.zzabd);
                }
            }
            this.zzabe = currentTimeMillis;
            if (this.zzabd >= 1.0d) {
                this.zzabd -= 1.0d;
                z = true;
            } else {
                String str = this.zzul;
                zzco.zzab(new StringBuilder(String.valueOf(str).length() + 34).append("Excessive ").append(str).append(" detected; call ignored.").toString());
                z = false;
            }
        }
        return z;
    }
}
