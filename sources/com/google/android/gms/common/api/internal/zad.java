package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager.zaa;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zad<T> extends zac {
    protected final TaskCompletionSource<T> zacm;

    public zad(int i, TaskCompletionSource<T> taskCompletionSource) {
        super(i);
        this.zacm = taskCompletionSource;
    }

    protected abstract void zad(zaa<?> zaa);

    public void zaa(Status status) {
        this.zacm.trySetException(new ApiException(status));
    }

    public void zaa(RuntimeException runtimeException) {
        this.zacm.trySetException(runtimeException);
    }

    public void zaa(zaab zaab, boolean z) {
    }

    public final void zaa(zaa<?> zaa) {
        try {
            zad(zaa);
        } catch (RemoteException e) {
            zaa(zab.zaa(e));
            throw e;
        } catch (RemoteException e2) {
            zaa(zab.zaa(e2));
        } catch (RuntimeException e3) {
            zaa(e3);
        }
    }
}
