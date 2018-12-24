package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tagmanager.zzcd;
import com.google.android.gms.tagmanager.zzcm;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

@VisibleForTesting
public final class zzgn {
    private final zzpd zzbie;
    private final zzcm zzbih;
    private final ExecutorService zzbip;
    private final ScheduledExecutorService zzbiq;
    private final zzcd zzbir;
    private final Context zzri;

    public zzgn(Context context, zzcm zzcm, zzcd zzcd) {
        this(context, zzcm, zzcd, new zzpd(context), zza.zzaa(context), zzjg.zzbmd);
    }

    private zzgn(Context context, zzcm zzcm, zzcd zzcd, zzpd zzpd, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.zzri = ((Context) Preconditions.checkNotNull(context)).getApplicationContext();
        this.zzbih = (zzcm) Preconditions.checkNotNull(zzcm);
        this.zzbir = (zzcd) Preconditions.checkNotNull(zzcd);
        this.zzbie = (zzpd) Preconditions.checkNotNull(zzpd);
        this.zzbip = (ExecutorService) Preconditions.checkNotNull(executorService);
        this.zzbiq = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService);
    }

    public final zzgf zzg(String str, String str2, String str3) {
        return new zzgf(this.zzri, str, str2, str3, new zzhz(this.zzri, this.zzbih, this.zzbir, str), this.zzbie, this.zzbip, this.zzbiq, this.zzbih, DefaultClock.getInstance(), new zzgo(this.zzri, str));
    }
}
