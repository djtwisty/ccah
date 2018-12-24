package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.GoogleApiManager.zaa;

public final class zae<A extends ApiMethodImpl<? extends Result, AnyClient>> extends zab {
    private final A zacn;

    public zae(int i, A a) {
        super(i);
        this.zacn = a;
    }

    public final void zaa(zaa<?> zaa) {
        try {
            this.zacn.run(zaa.zaab());
        } catch (RuntimeException e) {
            zaa(e);
        }
    }

    public final void zaa(Status status) {
        this.zacn.setFailedResult(status);
    }

    public final void zaa(RuntimeException runtimeException) {
        String simpleName = runtimeException.getClass().getSimpleName();
        String localizedMessage = runtimeException.getLocalizedMessage();
        this.zacn.setFailedResult(new Status(10, new StringBuilder((String.valueOf(simpleName).length() + 2) + String.valueOf(localizedMessage).length()).append(simpleName).append(": ").append(localizedMessage).toString()));
    }

    public final void zaa(zaab zaab, boolean z) {
        zaab.zaa(this.zacn, z);
    }
}
