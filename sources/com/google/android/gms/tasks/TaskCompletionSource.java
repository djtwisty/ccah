package com.google.android.gms.tasks;

public class TaskCompletionSource<TResult> {
    private final zzu<TResult> zza = new zzu();

    public TaskCompletionSource(CancellationToken cancellationToken) {
        cancellationToken.onCanceledRequested(new zzs(this));
    }

    public void setResult(TResult tResult) {
        this.zza.setResult(tResult);
    }

    public boolean trySetResult(TResult tResult) {
        return this.zza.trySetResult(tResult);
    }

    public void setException(Exception exception) {
        this.zza.setException(exception);
    }

    public boolean trySetException(Exception exception) {
        return this.zza.trySetException(exception);
    }

    public Task<TResult> getTask() {
        return this.zza;
    }
}
