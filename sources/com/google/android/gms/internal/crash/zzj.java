package com.google.android.gms.internal.crash;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crash.FirebaseCrash.zza;

public final class zzj extends zzc {
    private final String zzl;

    public zzj(Context context, zza zza, String str) {
        super(context, zza);
        this.zzl = str;
    }

    protected final String getErrorMessage() {
        String str = "Failed to set InstanceId to ";
        String valueOf = String.valueOf(this.zzl);
        return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }

    protected final void zzd(zzm zzm) {
        zzm.zzb(this.zzl);
    }

    public final /* bridge */ /* synthetic */ void run() {
        super.run();
    }

    public final /* bridge */ /* synthetic */ Task getTask() {
        return super.getTask();
    }
}
