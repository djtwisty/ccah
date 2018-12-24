package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public final class zzpm implements Result {
    private final Status zzazz;
    private final int zzbno;
    private final zzpn zzboe;
    private final zzqj zzbof;

    public zzpm(Status status, int i) {
        this(status, i, null, null);
    }

    public zzpm(Status status, int i, zzpn zzpn, zzqj zzqj) {
        this.zzazz = status;
        this.zzbno = i;
        this.zzboe = zzpn;
        this.zzbof = zzqj;
    }

    public final zzpn zzrz() {
        return this.zzboe;
    }

    public final zzqj zzsa() {
        return this.zzbof;
    }

    public final Status getStatus() {
        return this.zzazz;
    }

    public final int getSource() {
        return this.zzbno;
    }

    public final String zzsb() {
        if (this.zzbno == 0) {
            return "Network";
        }
        if (this.zzbno == 1) {
            return "Saved file on disk";
        }
        if (this.zzbno == 2) {
            return "Default resource";
        }
        throw new IllegalStateException("Resource source is unknown.");
    }
}
