package com.google.android.gms.internal.firebase_auth;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public enum zzjk {
    INT(Integer.valueOf(0)),
    LONG(Long.valueOf(0)),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.valueOf(false)),
    STRING(""),
    BYTE_STRING(zzeh.zzso),
    ENUM(null),
    MESSAGE(null);
    
    private final Object zzyk;

    private zzjk(Object obj) {
        this.zzyk = obj;
    }
}
