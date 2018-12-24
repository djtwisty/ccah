package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzk<TResult> implements zzq<TResult> {
    private final Object mLock = new Object();
    private final Executor zzd;
    private OnFailureListener zzn;

    public zzk(Executor executor, OnFailureListener onFailureListener) {
        this.zzd = executor;
        this.zzn = onFailureListener;
    }

    public final void onComplete(Task<TResult> task) {
        if (!task.isSuccessful() && !task.isCanceled()) {
            synchronized (this.mLock) {
                if (this.zzn == null) {
                    return;
                }
                this.zzd.execute(new zzl(this, task));
            }
        }
    }

    public final void cancel() {
        synchronized (this.mLock) {
            this.zzn = null;
        }
    }
}
