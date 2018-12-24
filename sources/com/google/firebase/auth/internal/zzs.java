package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzf;
import com.google.firebase.FirebaseApp;

public final class zzs {
    private static Logger zzgg = new Logger("TokenRefresher", "FirebaseAuth:");
    @VisibleForTesting
    private Handler handler;
    private final FirebaseApp zzgm;
    @VisibleForTesting
    volatile long zzrc;
    @VisibleForTesting
    volatile long zzrd;
    @VisibleForTesting
    private long zzre;
    @VisibleForTesting
    private HandlerThread zzrf = new HandlerThread("TokenRefresher", 10);
    @VisibleForTesting
    private Runnable zzrg;

    public zzs(FirebaseApp firebaseApp) {
        zzgg.m1074v("Initializing TokenRefresher", new Object[0]);
        this.zzgm = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.zzrf.start();
        this.handler = new zzf(this.zzrf.getLooper());
        this.zzrg = new zzt(this, this.zzgm.getName());
        this.zzre = 300000;
    }

    public final void zzeh() {
        zzgg.m1074v("Scheduling refresh for " + (this.zzrc - this.zzre), new Object[0]);
        cancel();
        this.zzrd = Math.max((this.zzrc - DefaultClock.getInstance().currentTimeMillis()) - this.zzre, 0) / 1000;
        this.handler.postDelayed(this.zzrg, this.zzrd * 1000);
    }

    final void zzei() {
        long j;
        switch ((int) this.zzrd) {
            case 30:
            case 60:
            case 120:
            case 240:
            case 480:
                j = 2 * this.zzrd;
                break;
            case 960:
                j = 960;
                break;
            default:
                j = 30;
                break;
        }
        this.zzrd = j;
        this.zzrc = DefaultClock.getInstance().currentTimeMillis() + (this.zzrd * 1000);
        zzgg.m1074v("Scheduling refresh for " + this.zzrc, new Object[0]);
        this.handler.postDelayed(this.zzrg, this.zzrd * 1000);
    }

    public final void cancel() {
        this.handler.removeCallbacks(this.zzrg);
    }
}
