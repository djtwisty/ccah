package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;

@VisibleForTesting
final class zzgw {
    private final long zzaax;
    private final long zzbcj;
    private final long zzbck;
    private String zzbcl;
    private String zzbjc;
    private Map<String, String> zzbjd;
    private String zzbje;

    final long zzov() {
        return this.zzbcj;
    }

    final long zzow() {
        return this.zzbck;
    }

    zzgw(long j, long j2, long j3) {
        this.zzbcj = j;
        this.zzaax = j2;
        this.zzbck = j3;
    }

    final String zzox() {
        return this.zzbcl;
    }

    final void zzds(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.zzbcl = str;
        }
    }

    final void zzej(String str) {
        this.zzbjc = str;
    }

    final void zzh(Map<String, String> map) {
        this.zzbjd = map;
    }

    final void zzek(String str) {
        this.zzbje = str;
    }

    final String zzqx() {
        return this.zzbjc;
    }

    final Map<String, String> zzqy() {
        return this.zzbjd;
    }

    final String zzqz() {
        return this.zzbje;
    }
}
