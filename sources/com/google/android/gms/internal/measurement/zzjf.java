package com.google.android.gms.internal.measurement;

import java.util.concurrent.ThreadFactory;

final class zzjf implements ThreadFactory {
    zzjf() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "google-tag-manager-background-thread");
    }
}
