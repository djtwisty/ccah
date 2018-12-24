package com.google.android.gms.internal.crash;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crash.FirebaseCrash.zza;

public final class zze extends zzc {
    private final Throwable zzag;
    private final zzq zzk;

    public zze(Context context, zza zza, Throwable th, zzq zzq) {
        super(context, zza);
        this.zzag = th;
        this.zzk = zzq;
    }

    protected final String getErrorMessage() {
        return "Failed to report caught exception";
    }

    protected final boolean zzk() {
        return true;
    }

    protected final void zzd(zzm zzm) {
        if (this.zzk != null) {
            this.zzk.zza(false, System.currentTimeMillis());
        }
        zzm.zza(ObjectWrapper.wrap(this.zzag));
    }

    public final /* bridge */ /* synthetic */ void run() {
        super.run();
    }

    public final /* bridge */ /* synthetic */ Task getTask() {
        return super.getTask();
    }
}
