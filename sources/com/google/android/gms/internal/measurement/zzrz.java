package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

final class zzrz extends ContentObserver {
    private final /* synthetic */ zzrx zzbri;

    zzrz(zzrx zzrx, Handler handler) {
        this.zzbri = zzrx;
        super(null);
    }

    public final void onChange(boolean z) {
        this.zzbri.zztl();
    }
}
