package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

public final class zzqi {
    private final List<zzqd> zzboz = new ArrayList();
    private final List<zzqd> zzbpa = new ArrayList();
    private final List<zzqd> zzbpb = new ArrayList();
    private final List<zzqd> zzbpc = new ArrayList();

    public final zzqi zzc(zzqd zzqd) {
        this.zzboz.add(zzqd);
        return this;
    }

    public final zzqi zzd(zzqd zzqd) {
        this.zzbpa.add(zzqd);
        return this;
    }

    public final zzqi zze(zzqd zzqd) {
        this.zzbpb.add(zzqd);
        return this;
    }

    public final zzqi zzf(zzqd zzqd) {
        this.zzbpc.add(zzqd);
        return this;
    }

    public final zzqg zzso() {
        return new zzqg(this.zzboz, this.zzbpa, this.zzbpb, this.zzbpc);
    }
}
