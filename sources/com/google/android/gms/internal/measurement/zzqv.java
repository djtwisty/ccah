package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

public final class zzqv extends zzqp<zzqp<?>> {
    public static final zzqv zzbpo = new zzqv("BREAK");
    public static final zzqv zzbpp = new zzqv("CONTINUE");
    public static final zzqv zzbpq = new zzqv("NULL");
    public static final zzqv zzbpr = new zzqv("UNDEFINED");
    private final String name;
    private final boolean zzbps;
    private final zzqp<?> zzbpt;

    private zzqv(String str) {
        this.name = str;
        this.zzbps = false;
        this.zzbpt = null;
    }

    public zzqv(zzqp<?> zzqp) {
        Preconditions.checkNotNull(zzqp);
        this.name = "RETURN";
        this.zzbps = true;
        this.zzbpt = zzqp;
    }

    public final boolean zzsv() {
        return this.zzbps;
    }

    public final String toString() {
        return this.name;
    }

    public final /* synthetic */ Object value() {
        return this.zzbpt;
    }
}
