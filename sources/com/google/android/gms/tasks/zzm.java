package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzm<TResult> implements zzq<TResult> {
    private final Object mLock = new Object();
    private final Executor zzd;
    private OnSuccessListener<? super TResult> zzp;

    public zzm(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.zzd = executor;
        this.zzp = onSuccessListener;
    }

    public final void onComplete(Task<TResult> task) {
        if (task.isSuccessful()) {
            synchronized (this.mLock) {
                if (this.zzp == null) {
                    return;
                }
                this.zzd.execute(new zzn(this, task));
            }
        }
    }

    public final void cancel() {
        synchronized (this.mLock) {
            this.zzp = null;
        }
    }
}
