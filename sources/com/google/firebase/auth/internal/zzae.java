package com.google.firebase.auth.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseApp.IdTokenListenersCountChangedListener;

public final class zzae implements IdTokenListenersCountChangedListener {
    private volatile int zzry;
    private volatile int zzrz;
    private final zzs zzsa;
    private volatile boolean zzsb;

    public zzae(FirebaseApp firebaseApp) {
        this(firebaseApp.getApplicationContext(), new zzs(firebaseApp));
    }

    @VisibleForTesting
    private zzae(Context context, zzs zzs) {
        this.zzsb = false;
        this.zzry = 0;
        this.zzrz = 0;
        this.zzsa = zzs;
        BackgroundDetector.initialize((Application) context.getApplicationContext());
        BackgroundDetector.getInstance().addListener(new zzaf(this));
    }

    public final void onListenerCountChanged(int i) {
        if (i > 0 && this.zzry == 0 && this.zzrz == 0) {
            this.zzry = i;
            if (zzep()) {
                this.zzsa.zzeh();
            }
        } else if (i == 0 && this.zzry != 0 && this.zzrz == 0) {
            this.zzsa.cancel();
        }
        this.zzry = i;
    }

    public final void zzf(int i) {
        if (i > 0 && this.zzrz == 0 && this.zzry == 0) {
            this.zzrz = i;
            if (zzep()) {
                this.zzsa.zzeh();
            }
        } else if (i == 0 && this.zzrz != 0 && this.zzry == 0) {
            this.zzsa.cancel();
        }
        this.zzrz = i;
    }

    public final void zzc(zzcz zzcz) {
        if (zzcz != null) {
            long zzs = zzcz.zzs();
            if (zzs <= 0) {
                zzs = 3600;
            }
            zzs = (zzs * 1000) + zzcz.zzdy();
            zzs zzs2 = this.zzsa;
            zzs2.zzrc = zzs;
            zzs2.zzrd = -1;
            if (zzep()) {
                this.zzsa.zzeh();
            }
        }
    }

    public final void cancel() {
        this.zzsa.cancel();
    }

    private final boolean zzep() {
        return this.zzry + this.zzrz > 0 && !this.zzsb;
    }
}
