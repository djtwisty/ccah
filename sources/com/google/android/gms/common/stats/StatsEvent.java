package com.google.android.gms.common.stats;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {

    @KeepForSdk
    public interface Types {
        @KeepForSdk
        public static final int EVENT_TYPE_ACQUIRE_WAKE_LOCK = 7;
        @KeepForSdk
        public static final int EVENT_TYPE_RELEASE_WAKE_LOCK = 8;
    }

    public abstract int getEventType();

    public abstract long getTimeMillis();

    public abstract long zzv();

    public abstract String zzw();

    public String toString() {
        long timeMillis = getTimeMillis();
        int eventType = getEventType();
        long zzv = zzv();
        String zzw = zzw();
        return new StringBuilder(String.valueOf(zzw).length() + 53).append(timeMillis).append("\t").append(eventType).append("\t").append(zzv).append(zzw).toString();
    }
}
