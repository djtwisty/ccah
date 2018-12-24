package com.google.android.gms.internal.crash;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crash.FirebaseCrash.zza;

public final class zzg extends zzc {
    private final Throwable zzag;
    private final zzq zzk;

    public zzg(Context context, zza zza, Throwable th, zzq zzq) {
        super(context, zza);
        this.zzag = th;
        this.zzk = zzq;
    }

    protected final String getErrorMessage() {
        return "Failed to report uncaught exception";
    }

    protected final boolean zzk() {
        return true;
    }

    protected final void zzd(zzm zzm) {
        if (this.zzk != null) {
            this.zzk.zza(true, System.currentTimeMillis());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new IllegalStateException("Failed to wait for analytics event to be logged");
            }
        }
        zzm.zzb(ObjectWrapper.wrap(this.zzag));
    }

    public final /* bridge */ /* synthetic */ void run() {
        super.run();
    }

    public final /* bridge */ /* synthetic */ Task getTask() {
        return super.getTask();
    }
}
