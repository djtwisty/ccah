package com.google.android.gms.internal.measurement;

import java.util.concurrent.ThreadFactory;

final class zzjh implements ThreadFactory {
    zzjh() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "google-tag-manager-scheduler-thread");
    }
}
