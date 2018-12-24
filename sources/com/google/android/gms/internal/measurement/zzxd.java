package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Api.BaseClientBuilder;

abstract class zzxd<T, B> {
    zzxd() {
    }

    abstract void zza(B b, int i, long j);

    abstract void zza(B b, int i, zzte zzte);

    abstract void zza(B b, int i, T t);

    abstract void zza(T t, zzxy zzxy);

    abstract boolean zza(zzwk zzwk);

    abstract T zzaf(B b);

    abstract int zzai(T t);

    abstract T zzal(Object obj);

    abstract B zzam(Object obj);

    abstract int zzan(T t);

    abstract void zzb(B b, int i, long j);

    abstract void zzc(B b, int i, int i2);

    abstract void zzc(T t, zzxy zzxy);

    abstract void zzf(Object obj, T t);

    abstract void zzg(Object obj, B b);

    abstract T zzh(T t, T t2);

    abstract void zzy(Object obj);

    abstract B zzyk();

    final boolean zza(B b, zzwk zzwk) {
        int tag = zzwk.getTag();
        int i = tag >>> 3;
        switch (tag & 7) {
            case 0:
                zza((Object) b, i, zzwk.zzul());
                return true;
            case 1:
                zzb(b, i, zzwk.zzun());
                return true;
            case 2:
                zza((Object) b, i, zzwk.zzur());
                return true;
            case 3:
                Object zzyk = zzyk();
                int i2 = (i << 3) | 4;
                while (zzwk.zzvh() != BaseClientBuilder.API_PRIORITY_OTHER) {
                    if (!zza(zzyk, zzwk)) {
                        if (i2 == zzwk.getTag()) {
                            throw zzuv.zzwt();
                        }
                        zza((Object) b, i, zzaf(zzyk));
                        return true;
                    }
                }
                if (i2 == zzwk.getTag()) {
                    zza((Object) b, i, zzaf(zzyk));
                    return true;
                }
                throw zzuv.zzwt();
            case 4:
                return false;
            case 5:
                zzc(b, i, zzwk.zzuo());
                return true;
            default:
                throw zzuv.zzwu();
        }
    }
}
