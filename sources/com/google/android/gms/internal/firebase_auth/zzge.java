package com.google.android.gms.internal.firebase_auth;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public enum zzge {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, Integer.valueOf(0)),
    LONG(Long.TYPE, Long.class, Long.valueOf(0)),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.valueOf(false)),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzeh.class, zzeh.class, zzeh.zzso),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    
    private final Class<?> zzyi;
    private final Class<?> zzyj;
    private final Object zzyk;

    private zzge(Class<?> cls, Class<?> cls2, Object obj) {
        this.zzyi = cls;
        this.zzyj = cls2;
        this.zzyk = obj;
    }

    public final Class<?> zzhz() {
        return this.zzyj;
    }
}
