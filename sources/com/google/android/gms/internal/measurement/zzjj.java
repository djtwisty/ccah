package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
public final class zzjj {
    private Tracker zzrh;
    private Context zzri;
    private GoogleAnalytics zzrk;

    public zzjj(Context context) {
        this.zzri = context;
    }

    public final Tracker zzec(String str) {
        zzed(str);
        return this.zzrh;
    }

    private final synchronized void zzed(String str) {
        if (this.zzrk == null) {
            this.zzrk = GoogleAnalytics.getInstance(this.zzri);
            this.zzrk.setLogger(new zzjk());
            this.zzrh = this.zzrk.newTracker(str);
        }
    }
}
