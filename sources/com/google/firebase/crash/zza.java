package com.google.firebase.crash;

import java.util.concurrent.Executor;

final /* synthetic */ class zza implements Executor {
    static final Executor zzm = new zza();

    private zza() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
