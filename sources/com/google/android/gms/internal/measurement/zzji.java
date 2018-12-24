package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzji implements ServiceConnection {
    private volatile boolean connected;
    private final ConnectionTracker zzbme;
    private volatile boolean zzbmf;
    private zzhg zzbmg;
    private final Context zzri;

    public zzji(Context context) {
        this(context, ConnectionTracker.getInstance());
    }

    @VisibleForTesting
    private zzji(Context context, ConnectionTracker connectionTracker) {
        this.connected = false;
        this.zzbmf = false;
        this.zzri = context;
        this.zzbme = connectionTracker;
    }

    private final boolean zzrn() {
        if (this.connected) {
            return true;
        }
        synchronized (this) {
            if (this.connected) {
                return true;
            }
            if (!this.zzbmf) {
                Intent intent = new Intent("ignored");
                intent.setAction(null);
                intent.setClassName(this.zzri.getPackageName(), "com.google.android.gms.tagmanager.TagManagerService");
                if (this.zzbme.bindService(this.zzri, intent, this, 1)) {
                    this.zzbmf = true;
                } else {
                    return false;
                }
            }
            while (this.zzbmf) {
                try {
                    wait();
                    this.zzbmf = false;
                } catch (Throwable e) {
                    zzhk.zzb("Error connecting to TagManagerService", e);
                    this.zzbmf = false;
                }
            }
            boolean z = this.connected;
            return z;
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this) {
            zzhg zzhg;
            if (iBinder == null) {
                zzhg = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.tagmanager.internal.ITagManagerService");
                if (queryLocalInterface instanceof zzhg) {
                    zzhg = (zzhg) queryLocalInterface;
                } else {
                    zzhg = new zzhi(iBinder);
                }
            }
            this.zzbmg = zzhg;
            this.connected = true;
            this.zzbmf = false;
            notifyAll();
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this) {
            this.zzbmg = null;
            this.connected = false;
            this.zzbmf = false;
        }
    }

    public final void zzb(String str, String str2, String str3, zzhd zzhd) {
        if (zzrn()) {
            try {
                this.zzbmg.zza(str, str2, str3, zzhd);
                return;
            } catch (Throwable e) {
                zzhk.zzb("Error calling service to load container", e);
            }
        }
        if (zzhd != null) {
            try {
                zzhd.zza(false, str);
            } catch (Throwable e2) {
                zzhk.zza("Error - local callback should not throw RemoteException", e2);
            }
        }
    }

    public final boolean zzro() {
        if (zzrn()) {
            try {
                this.zzbmg.zzra();
                return true;
            } catch (Throwable e) {
                zzhk.zzb("Error in resetting service", e);
            }
        }
        return false;
    }

    public final void zza(String str, Bundle bundle, String str2, long j, boolean z) {
        if (zzrn()) {
            try {
                this.zzbmg.zza(str, bundle, str2, j, z);
            } catch (Throwable e) {
                zzhk.zzb("Error calling service to emit event", e);
            }
        }
    }

    public final void dispatch() {
        if (zzrn()) {
            try {
                this.zzbmg.dispatch();
            } catch (Throwable e) {
                zzhk.zzb("Error calling service to dispatch pending events", e);
            }
        }
    }
}
