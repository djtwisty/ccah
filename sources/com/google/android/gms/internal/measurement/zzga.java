package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzga {
    private static Object zzazc = new Object();
    private static zzga zzbhz;
    private volatile boolean closed;
    private volatile long zzayv;
    private volatile long zzayw;
    private volatile long zzayx;
    private volatile long zzayy;
    private final Thread zzayz;
    private final Object zzaza;
    private volatile boolean zzbhx;
    private zzgd zzbhy;
    private final Context zzri;
    private final Clock zzrz;
    private volatile Info zzvl;

    public static zzga zzx(Context context) {
        if (zzbhz == null) {
            synchronized (zzazc) {
                if (zzbhz == null) {
                    zzga zzga = new zzga(context);
                    zzbhz = zzga;
                    zzga.zzayz.start();
                }
            }
        }
        return zzbhz;
    }

    private zzga(Context context) {
        this(context, null, DefaultClock.getInstance());
    }

    @VisibleForTesting
    private zzga(Context context, zzgd zzgd, Clock clock) {
        this.zzayv = 900000;
        this.zzayw = 30000;
        this.zzbhx = true;
        this.closed = false;
        this.zzaza = new Object();
        this.zzbhy = new zzgb(this);
        this.zzrz = clock;
        if (context != null) {
            this.zzri = context.getApplicationContext();
        } else {
            this.zzri = context;
        }
        this.zzayx = this.zzrz.currentTimeMillis();
        this.zzayz = new Thread(new zzgc(this));
    }

    public final String zzne() {
        if (this.zzvl == null) {
            zznf();
        } else {
            zzng();
        }
        zznh();
        return this.zzvl == null ? null : this.zzvl.getId();
    }

    public final boolean isLimitAdTrackingEnabled() {
        if (this.zzvl == null) {
            zznf();
        } else {
            zzng();
        }
        zznh();
        return this.zzvl == null ? true : this.zzvl.isLimitAdTrackingEnabled();
    }

    private final void zznf() {
        synchronized (this) {
            try {
                zzng();
                wait(500);
            } catch (InterruptedException e) {
            }
        }
    }

    private final void zzng() {
        if (this.zzrz.currentTimeMillis() - this.zzayx > this.zzayw) {
            synchronized (this.zzaza) {
                this.zzaza.notify();
            }
            this.zzayx = this.zzrz.currentTimeMillis();
        }
    }

    private final void zznh() {
        if (this.zzrz.currentTimeMillis() - this.zzayy > 3600000) {
            this.zzvl = null;
        }
    }

    private final void zzni() {
        Process.setThreadPriority(10);
        while (true) {
            boolean z = this.closed;
            Info info = null;
            if (this.zzbhx) {
                info = this.zzbhy.zznj();
            }
            if (info != null) {
                this.zzvl = info;
                this.zzayy = this.zzrz.currentTimeMillis();
                zzhk.zzdm("Obtained fresh AdvertisingId info from GmsCore.");
            }
            synchronized (this) {
                notifyAll();
            }
            try {
                synchronized (this.zzaza) {
                    this.zzaza.wait(this.zzayv);
                }
            } catch (InterruptedException e) {
                zzhk.zzdm("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }
}
