package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

public final class zzoz {
    private final String zzazo;
    private final String zzbes;
    private final String zzbic;
    private final String zzbnl;
    private final boolean zzbnm;
    private final String zzbnn;

    public zzoz(String str, String str2, String str3, boolean z, String str4) {
        this(str, str2, str3, z, str4, "");
    }

    private zzoz(String str, String str2, String str3, boolean z, String str4, String str5) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str5);
        this.zzazo = str;
        this.zzbic = str2;
        this.zzbnl = str3;
        this.zzbnm = z;
        this.zzbnn = str4;
        this.zzbes = str5;
    }

    public final String getContainerId() {
        return this.zzazo;
    }

    public final String zzrr() {
        return this.zzbic;
    }

    public final String zzrs() {
        return this.zzbnl;
    }

    public final String zzrt() {
        if (this.zzbnl == null) {
            return this.zzazo;
        }
        String str = this.zzbnl;
        String str2 = this.zzazo;
        return new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(str2).length()).append(str).append("_").append(str2).toString();
    }

    public final boolean zzru() {
        return this.zzbnm;
    }

    public final String zzrv() {
        return this.zzbnn;
    }

    public final String zzrw() {
        return this.zzbes;
    }
}
