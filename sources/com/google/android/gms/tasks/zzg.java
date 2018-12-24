package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzg<TResult> implements zzq<TResult> {
    private final Object mLock = new Object();
    private final Executor zzd;
    private OnCanceledListener zzj;

    public zzg(Executor executor, OnCanceledListener onCanceledListener) {
        this.zzd = executor;
        this.zzj = onCanceledListener;
    }

    public final void onComplete(Task task) {
        if (task.isCanceled()) {
            synchronized (this.mLock) {
                if (this.zzj == null) {
                    return;
                }
                this.zzd.execute(new zzh(this));
            }
        }
    }

    public final void cancel() {
        synchronized (this.mLock) {
            this.zzj = null;
        }
    }
}
