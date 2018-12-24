package com.google.android.gms.internal.config;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public final class zzao implements FirebaseRemoteConfigInfo {
    private long zzax;
    private int zzay;
    private FirebaseRemoteConfigSettings zzaz;

    public final void zzb(long j) {
        this.zzax = j;
    }

    public final void zzf(int i) {
        this.zzay = i;
    }

    public final void setConfigSettings(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.zzaz = firebaseRemoteConfigSettings;
    }

    public final long getFetchTimeMillis() {
        return this.zzax;
    }

    public final int getLastFetchStatus() {
        return this.zzay;
    }

    public final FirebaseRemoteConfigSettings getConfigSettings() {
        return this.zzaz;
    }
}
