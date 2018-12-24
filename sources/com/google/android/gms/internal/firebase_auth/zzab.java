package com.google.android.gms.internal.firebase_auth;

import java.util.List;

final class zzab extends zzz<E> {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ zzz zzfp;

    zzab(zzz zzz, int i, int i2) {
        this.zzfp = zzz;
        this.offset = i;
        this.length = i2;
    }

    public final int size() {
        return this.length;
    }

    final Object[] zzbp() {
        return this.zzfp.zzbp();
    }

    final int zzbq() {
        return this.zzfp.zzbq() + this.offset;
    }

    final int zzbr() {
        return (this.zzfp.zzbq() + this.offset) + this.length;
    }

    public final E get(int i) {
        zzv.zza(i, this.length);
        return this.zzfp.get(this.offset + i);
    }

    public final zzz<E> zzc(int i, int i2) {
        zzv.zza(i, i2, this.length);
        return (zzz) this.zzfp.subList(this.offset + i, this.offset + i2);
    }

    public final /* synthetic */ List subList(int i, int i2) {
        return zzc(i, i2);
    }
}
