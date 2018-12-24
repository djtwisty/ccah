package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class zzqp<T> {
    protected Map<String, zzqp<?>> zzbpi;

    public abstract String toString();

    public abstract T value();

    public final void zzc(String str, zzqp<?> zzqp) {
        if (this.zzbpi == null) {
            this.zzbpi = new HashMap();
        }
        this.zzbpi.put(str, zzqp);
    }

    public final boolean zzfd(String str) {
        return this.zzbpi != null && this.zzbpi.containsKey(str);
    }

    public zzqp<?> zzfe(String str) {
        return this.zzbpi != null ? (zzqp) this.zzbpi.get(str) : zzqv.zzbpr;
    }

    public Iterator<zzqp<?>> zzst() {
        return new zzqr();
    }

    public boolean zzff(String str) {
        return false;
    }

    public zzjo zzfg(String str) {
        throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 56).append("Attempting to access Native Method ").append(str).append(" on unsupported type.").toString());
    }

    protected final Iterator<zzqp<?>> zzsu() {
        if (this.zzbpi == null) {
            return new zzqr();
        }
        return new zzqq(this, this.zzbpi.keySet().iterator());
    }
}
