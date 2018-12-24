package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzi<TResult> implements zzq<TResult> {
    private final Object mLock = new Object();
    private final Executor zzd;
    private OnCompleteListener<TResult> zzl;

    public zzi(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.zzd = executor;
        this.zzl = onCompleteListener;
    }

    public final void onComplete(Task<TResult> task) {
        synchronized (this.mLock) {
            if (this.zzl == null) {
                return;
            }
            this.zzd.execute(new zzj(this, task));
        }
    }

    public final void cancel() {
        synchronized (this.mLock) {
            this.zzl = null;
        }
    }
}
