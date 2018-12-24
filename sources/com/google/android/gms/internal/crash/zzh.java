package com.google.android.gms.internal.crash;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crash.FirebaseCrash.zza;

public final class zzh extends zzc {
    private final boolean zzah;

    public zzh(Context context, zza zza, boolean z) {
        super(context, zza);
        this.zzah = z;
    }

    protected final String getErrorMessage() {
        return "Failed to setAppState to " + this.zzah;
    }

    protected final void zzd(zzm zzm) {
        zzm.zza(this.zzah);
    }

    public final /* bridge */ /* synthetic */ void run() {
        super.run();
    }

    public final /* bridge */ /* synthetic */ Task getTask() {
        return super.getTask();
    }
}
