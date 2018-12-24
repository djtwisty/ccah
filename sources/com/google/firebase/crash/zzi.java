package com.google.firebase.crash;

import com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener;

final class zzi implements BackgroundStateChangeListener {
    zzi(zzh zzh) {
    }

    public final void onBackgroundStateChanged(boolean z) {
        FirebaseCrash.zza().zza(!z);
    }
}
