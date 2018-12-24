package com.google.android.gms.internal.crash;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crash.FirebaseCrash.zza;

abstract class zzc implements Runnable {
    private final zza zzac;
    private final TaskCompletionSource<Void> zzad = new TaskCompletionSource();
    private final Context zzf;

    zzc(Context context, zza zza) {
        this.zzac = zza;
        this.zzf = context.getApplicationContext();
    }

    protected abstract String getErrorMessage();

    protected abstract void zzd(zzm zzm);

    public Task<Void> getTask() {
        return this.zzad.getTask();
    }

    public void run() {
        Throwable e;
        try {
            zzm zzh = this.zzac.zzh();
            if (zzh == null) {
                throw new IllegalStateException("Firebase Crash api is not available");
            } else if (zzh.zzd() || !zzk()) {
                zzd(zzh);
                this.zzad.setResult(null);
            } else {
                throw new IllegalStateException("Firebase Crash reporting is not enabled");
            }
        } catch (RemoteException e2) {
            e = e2;
            CrashUtils.addDynamiteErrorToDropBox(this.zzf, e);
            Log.e("FirebaseCrash", getErrorMessage(), e);
            this.zzad.setException(e);
        } catch (RuntimeException e3) {
            e = e3;
            CrashUtils.addDynamiteErrorToDropBox(this.zzf, e);
            Log.e("FirebaseCrash", getErrorMessage(), e);
            this.zzad.setException(e);
        }
    }

    protected boolean zzk() {
        return false;
    }
}
