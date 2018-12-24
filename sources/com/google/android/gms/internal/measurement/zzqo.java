package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzqo {
    private final Object value;
    private final List<Integer> zzbpf = new ArrayList();
    private final Integer zzbph;
    private boolean zzqs = false;

    public zzqo(int i, Object obj) {
        this.zzbph = Integer.valueOf(i);
        this.value = obj;
    }

    public final zzqo zzad(int i) {
        this.zzbpf.add(Integer.valueOf(i));
        return this;
    }

    public final zzqo zzr(boolean z) {
        this.zzqs = true;
        return this;
    }

    public final zzqm zzss() {
        Preconditions.checkNotNull(this.zzbph);
        Preconditions.checkNotNull(this.value);
        return new zzqm(this.zzbph, this.value, this.zzbpf, this.zzqs);
    }
}
