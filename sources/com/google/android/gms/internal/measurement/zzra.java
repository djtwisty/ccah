package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzra extends zzqp<String> {
    private final String zzbpz;
    private final List<zzqp<?>> zzbqa;

    public zzra(String str, List<zzqp<?>> list) {
        Preconditions.checkNotNull(str, "Instruction name must be a string.");
        Preconditions.checkNotNull(list);
        this.zzbpz = str;
        this.zzbqa = list;
    }

    public final String toString() {
        String str = this.zzbpz;
        String obj = this.zzbqa.toString();
        return new StringBuilder((String.valueOf(str).length() + 3) + String.valueOf(obj).length()).append("*").append(str).append(": ").append(obj).toString();
    }

    public final String zzsx() {
        return this.zzbpz;
    }

    public final List<zzqp<?>> zzsy() {
        return this.zzbqa;
    }

    public final /* synthetic */ Object value() {
        return toString();
    }
}
