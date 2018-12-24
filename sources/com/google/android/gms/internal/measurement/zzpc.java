package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;

public abstract class zzpc {
    private int zzbno;
    protected final zzpl zzbnp;
    private final zzph zzbnq;
    private final Clock zzbnr;
    protected final zzgo zzbns;

    public zzpc(int i, zzpl zzpl, zzph zzph, zzgo zzgo) {
        this(i, zzpl, zzph, zzgo, DefaultClock.getInstance());
    }

    protected abstract void zza(zzpm zzpm);

    @VisibleForTesting
    private zzpc(int i, zzpl zzpl, zzph zzph, zzgo zzgo, Clock clock) {
        this.zzbnp = (zzpl) Preconditions.checkNotNull(zzpl);
        Preconditions.checkNotNull(zzpl.zzry());
        this.zzbno = i;
        this.zzbnq = (zzph) Preconditions.checkNotNull(zzph);
        this.zzbnr = (Clock) Preconditions.checkNotNull(clock);
        this.zzbns = zzgo;
    }

    public final void zzf(byte[] bArr) {
        zzpm zzpm;
        zzpm zzg = zzg(bArr);
        if (this.zzbns != null && this.zzbno == 0) {
            this.zzbns.zzoc();
        }
        if (zzg == null || zzg.getStatus() != Status.RESULT_SUCCESS) {
            zzpm = new zzpm(Status.RESULT_INTERNAL_ERROR, this.zzbno);
        } else {
            zzqb zzse = zzg.zzrz().zzse();
            zzpm = new zzpm(Status.RESULT_SUCCESS, this.zzbno, new zzpn(this.zzbnp.zzry(), bArr, zzse, this.zzbnr.currentTimeMillis()), zzg.zzsa());
        }
        zza(zzpm);
    }

    public final void zza(int i, int i2) {
        String str;
        if (this.zzbns != null && i2 == 0 && i == 3) {
            this.zzbns.zzob();
        }
        String containerId = this.zzbnp.zzry().getContainerId();
        switch (i) {
            case 0:
                str = "Resource not available";
                break;
            case 1:
                str = "IOError";
                break;
            case 2:
                str = "Server error";
                break;
            default:
                str = "Unknown reason";
                break;
        }
        zzhk.m1082v(new StringBuilder((String.valueOf(containerId).length() + 61) + String.valueOf(str).length()).append("Failed to fetch the container resource for the container \"").append(containerId).append("\": ").append(str).toString());
        zza(new zzpm(Status.RESULT_INTERNAL_ERROR, i2));
    }

    private final zzpm zzg(byte[] bArr) {
        zzpm zzpm = null;
        try {
            zzpm = this.zzbnq.zzh(bArr);
            if (zzpm == null) {
                zzhk.zzdm("Parsed resource from is null");
            }
        } catch (zzpa e) {
            zzhk.zzdm("Resource data is corrupted");
        }
        return zzpm;
    }
}
