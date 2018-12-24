package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tagmanager.zzcm;
import java.util.Date;
import java.util.Map;

public final class zzgt implements Clock {
    private final String zzavl;
    private final zzcm zzbih;
    private final Bundle zzbix;
    private final Date zzbiy;
    private final String zzbiz;
    private Map<String, Object> zzbja;
    private boolean zzbjb;

    @VisibleForTesting
    public zzgt(String str, Bundle bundle, String str2, Date date, boolean z, zzcm zzcm) {
        this.zzavl = str;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzbix = bundle;
        this.zzbiy = date;
        this.zzbiz = str2;
        this.zzbjb = z;
        this.zzbih = zzcm;
    }

    public final String zzqt() {
        return this.zzavl;
    }

    public final Bundle zzqu() {
        return this.zzbix;
    }

    public final String zzqv() {
        return this.zzbiz;
    }

    public final long currentTimeMillis() {
        return this.zzbiy.getTime();
    }

    public final long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public final long nanoTime() {
        return System.nanoTime();
    }

    public final long currentThreadTimeMillis() {
        return SystemClock.currentThreadTimeMillis();
    }

    public final Map<String, Object> zzop() {
        if (this.zzbja == null) {
            try {
                this.zzbja = this.zzbih.zzop();
            } catch (RemoteException e) {
                String str = "Error calling measurement proxy:";
                String valueOf = String.valueOf(e.getMessage());
                zzhk.m1081e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        }
        return this.zzbja;
    }

    public final boolean zzqw() {
        return this.zzbjb;
    }

    public final void zzq(boolean z) {
        this.zzbjb = false;
    }
}
