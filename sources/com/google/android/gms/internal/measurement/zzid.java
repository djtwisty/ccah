package com.google.android.gms.internal.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;

@ShowFirstParty
@VisibleForTesting
final class zzid extends zzic {
    private static final Object zzbfx = new Object();
    private static zzid zzbku;
    private boolean connected = true;
    private Context zzbfy;
    private int zzbgb = 1800000;
    private boolean zzbgc = true;
    private boolean zzbgd = false;
    private boolean zzbge = true;
    private boolean zzbgh = false;
    private zzhc zzbju = new zzie(this);
    private zzhb zzbkp;
    private volatile zzgy zzbkq;
    private boolean zzbkr = false;
    private zzig zzbks;
    private zzhm zzbkt;

    public static zzid zzrj() {
        if (zzbku == null) {
            zzbku = new zzid();
        }
        return zzbku;
    }

    private zzid() {
    }

    final synchronized void zza(Context context, zzgy zzgy) {
        if (this.zzbfy == null) {
            this.zzbfy = context.getApplicationContext();
            if (this.zzbkq == null) {
                this.zzbkq = zzgy;
            }
        }
    }

    final synchronized zzhb zzrk() {
        if (this.zzbkp == null) {
            if (this.zzbfy == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.zzbkp = new zzhn(this.zzbju, this.zzbfy);
        }
        if (this.zzbks == null) {
            this.zzbks = new zzih();
            if (this.zzbgb > 0) {
                this.zzbks.zzh((long) this.zzbgb);
            }
        }
        this.zzbgd = true;
        if (this.zzbgc) {
            dispatch();
            this.zzbgc = false;
        }
        if (this.zzbkt == null && this.zzbge) {
            this.zzbkt = new zzhm(this);
            BroadcastReceiver broadcastReceiver = this.zzbkt;
            Context context = this.zzbfy;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(broadcastReceiver, intentFilter);
            intentFilter = new IntentFilter();
            intentFilter.addAction("com.google.analytics.RADIO_POWERED");
            intentFilter.addCategory(context.getPackageName());
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
        return this.zzbkp;
    }

    public final synchronized void dispatch() {
        if (!this.zzbgd) {
            zzhk.m1082v("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.zzbgc = true;
        } else if (!this.zzbkr) {
            this.zzbkr = true;
            this.zzbkq.zzh(new zzif(this));
        }
    }

    @VisibleForTesting
    final synchronized void zzb(boolean z, boolean z2) {
        boolean isPowerSaveMode = isPowerSaveMode();
        this.zzbgh = z;
        this.connected = z2;
        if (isPowerSaveMode() != isPowerSaveMode) {
            if (isPowerSaveMode()) {
                this.zzbks.cancel();
                zzhk.m1082v("PowerSaveMode initiated.");
            } else {
                this.zzbks.zzh((long) this.zzbgb);
                zzhk.m1082v("PowerSaveMode terminated.");
            }
        }
    }

    public final synchronized void zzp(boolean z) {
        zzb(this.zzbgh, z);
    }

    public final synchronized void zzqd() {
        if (!isPowerSaveMode()) {
            this.zzbks.zzqh();
        }
    }

    private final boolean isPowerSaveMode() {
        return this.zzbgh || !this.connected || this.zzbgb <= 0;
    }
}
