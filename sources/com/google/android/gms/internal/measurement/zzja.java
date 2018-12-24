package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tagmanager.zzcd;
import com.google.android.gms.tagmanager.zzcm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public final class zzja extends zzhh {
    private final ExecutorService zzbif;
    private final zzcm zzbih;
    private final Map<String, zzgf> zzblx;
    private final zzgn zzbly;
    private final Context zzri;

    public zzja(Context context, zzcm zzcm, zzcd zzcd) {
        this(context, zzcm, new zzgn(context, zzcm, zzcd), zza.zzaa(context));
    }

    @VisibleForTesting
    private zzja(Context context, zzcm zzcm, zzgn zzgn, ExecutorService executorService) {
        this.zzblx = new HashMap(1);
        Preconditions.checkNotNull(zzcm);
        this.zzbih = zzcm;
        this.zzbly = zzgn;
        this.zzbif = executorService;
        this.zzri = context;
    }

    public final void zzh(String str, String str2, String str3) {
        zza(str, str2, str3, null);
    }

    public final void zza(String str, String str2, String str3, zzhd zzhd) {
        this.zzbif.execute(new zzjb(this, str, str2, str3, zzhd));
    }

    public final void zzra() {
        this.zzblx.clear();
    }

    public final void zza(String str, Bundle bundle, String str2, long j, boolean z) {
        this.zzbif.execute(new zzjc(this, new zzgt(str, bundle, str2, new Date(j), z, this.zzbih)));
    }

    public final void dispatch() {
        this.zzbif.execute(new zzjd(this));
    }
}
