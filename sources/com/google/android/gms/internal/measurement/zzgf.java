package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tagmanager.zzcm;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
public final class zzgf {
    private volatile int state = 1;
    private final String zzazo;
    private ScheduledFuture<?> zzbev = null;
    private final String zzbib;
    private final String zzbic;
    private final zzhz zzbid;
    private final zzpd zzbie;
    private final ExecutorService zzbif;
    private final ScheduledExecutorService zzbig;
    private final zzcm zzbih;
    private final zzgo zzbii;
    private zzhu zzbij;
    private List<zzgt> zzbik = new ArrayList();
    private boolean zzbil = false;
    private final Context zzri;
    private final Clock zzrz;

    zzgf(Context context, String str, String str2, String str3, zzhz zzhz, zzpd zzpd, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, zzcm zzcm, Clock clock, zzgo zzgo) {
        this.zzri = context;
        this.zzazo = (String) Preconditions.checkNotNull(str);
        this.zzbid = (zzhz) Preconditions.checkNotNull(zzhz);
        this.zzbie = (zzpd) Preconditions.checkNotNull(zzpd);
        this.zzbif = (ExecutorService) Preconditions.checkNotNull(executorService);
        this.zzbig = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService);
        this.zzbih = (zzcm) Preconditions.checkNotNull(zzcm);
        this.zzrz = (Clock) Preconditions.checkNotNull(clock);
        this.zzbii = (zzgo) Preconditions.checkNotNull(zzgo);
        this.zzbib = str3;
        this.zzbic = str2;
        this.zzbik.add(new zzgt("gtm.load", new Bundle(), "gtm", new Date(), false, this.zzbih));
        String str4 = this.zzazo;
        zzhk.m1082v(new StringBuilder(String.valueOf(str4).length() + 35).append("Container ").append(str4).append("is scheduled for loading.").toString());
        this.zzbif.execute(new zzgj());
    }

    @VisibleForTesting
    public final void zza(zzgt zzgt) {
        this.zzbif.execute(new zzgk(this, zzgt));
    }

    public final void dispatch() {
        this.zzbif.execute(new zzgg(this));
    }

    private final void zzar(long j) {
        if (this.zzbev != null) {
            this.zzbev.cancel(false);
        }
        String str = this.zzazo;
        zzhk.m1082v(new StringBuilder(String.valueOf(str).length() + 45).append("Refresh container ").append(str).append(" in ").append(j).append("ms.").toString());
        this.zzbev = this.zzbig.schedule(new zzgh(this), j, TimeUnit.MILLISECONDS);
    }
}
