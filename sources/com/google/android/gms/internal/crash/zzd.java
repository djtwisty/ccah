package com.google.android.gms.internal.crash;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crash.FirebaseCrash.zza;

public final class zzd extends zzc {
    private final long timestamp;
    private final String zzae;
    private final Bundle zzaf;

    public zzd(Context context, zza zza, String str, long j, Bundle bundle) {
        super(context, zza);
        this.zzae = str;
        this.timestamp = j;
        this.zzaf = bundle;
    }

    protected final String getErrorMessage() {
        return "Failed to log analytics event";
    }

    protected final boolean zzk() {
        return true;
    }

    protected final void zzd(zzm zzm) {
        zzm.zza(this.zzae, this.timestamp, this.zzaf);
    }

    public final /* bridge */ /* synthetic */ void run() {
        super.run();
    }

    public final /* bridge */ /* synthetic */ Task getTask() {
        return super.getTask();
    }
}
