package com.google.android.gms.internal.crash;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crash.FirebaseCrash.zza;

public final class zzf extends zzc {
    private final String zzae;

    public zzf(Context context, zza zza, String str) {
        super(context, zza);
        this.zzae = str;
    }

    protected final String getErrorMessage() {
        return "Failed to log message";
    }

    protected final boolean zzk() {
        return true;
    }

    protected final void zzd(zzm zzm) {
        zzm.log(this.zzae);
    }

    public final /* bridge */ /* synthetic */ void run() {
        super.run();
    }

    public final /* bridge */ /* synthetic */ Task getTask() {
        return super.getTask();
    }
}
