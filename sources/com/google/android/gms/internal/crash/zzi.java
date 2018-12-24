package com.google.android.gms.internal.crash;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crash.FirebaseCrash.zza;

public final class zzi extends zzc {
    private final boolean zzai;

    public zzi(Context context, zza zza, boolean z) {
        super(context, zza);
        this.zzai = z;
    }

    protected final String getErrorMessage() {
        return "Failed to set crash enabled to " + this.zzai;
    }

    protected final void zzd(zzm zzm) {
        zzm.zzb(this.zzai);
    }

    public final /* bridge */ /* synthetic */ void run() {
        super.run();
    }

    public final /* bridge */ /* synthetic */ Task getTask() {
        return super.getTask();
    }
}
