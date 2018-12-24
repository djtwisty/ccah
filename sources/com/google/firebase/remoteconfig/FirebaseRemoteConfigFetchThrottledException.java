package com.google.firebase.remoteconfig;

public class FirebaseRemoteConfigFetchThrottledException extends FirebaseRemoteConfigFetchException {
    private final long zzs;

    public FirebaseRemoteConfigFetchThrottledException(long j) {
        this.zzs = j;
    }

    public long getThrottleEndTimeMillis() {
        return this.zzs;
    }
}
