package com.google.android.gms.internal.config;

import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Collections;
import java.util.Map;

@ShowFirstParty
public final class zzi {
    private final long zzg;
    private final Map<String, String> zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final String zzl;

    private zzi(zzj zzj) {
        this.zzg = zzj.zzg;
        this.zzh = zzj.zzh;
        this.zzi = zzj.zzi;
        this.zzj = zzj.zzj;
        this.zzk = zzj.zzk;
        this.zzl = zzj.zzl;
    }

    public final long zzb() {
        return this.zzg;
    }

    public final Map<String, String> zzc() {
        if (this.zzh == null) {
            return Collections.emptyMap();
        }
        return this.zzh;
    }

    public final int zzd() {
        return this.zzi;
    }

    public final String getGmpAppId() {
        return this.zzl;
    }

    public final int zze() {
        return this.zzk;
    }

    public final int zzf() {
        return this.zzj;
    }
}
