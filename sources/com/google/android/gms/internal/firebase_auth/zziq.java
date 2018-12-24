package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.api.Api.BaseClientBuilder;

abstract class zziq<T, B> {
    zziq() {
    }

    abstract void zza(B b, int i, long j);

    abstract void zza(B b, int i, zzeh zzeh);

    abstract void zza(B b, int i, T t);

    abstract void zza(T t, zzjl zzjl);

    abstract boolean zza(zzhr zzhr);

    abstract void zzb(B b, int i, long j);

    abstract void zzc(B b, int i, int i2);

    abstract void zzc(T t, zzjl zzjl);

    abstract void zze(Object obj, T t);

    abstract void zzf(Object obj);

    abstract void zzf(Object obj, B b);

    abstract T zzg(T t, T t2);

    abstract B zzjo();

    abstract T zzm(B b);

    abstract int zzp(T t);

    abstract T zzs(Object obj);

    abstract B zzt(Object obj);

    abstract int zzu(T t);

    final boolean zza(B b, zzhr zzhr) {
        int tag = zzhr.getTag();
        int i = tag >>> 3;
        switch (tag & 7) {
            case 0:
                zza((Object) b, i, zzhr.zzfk());
                return true;
            case 1:
                zzb(b, i, zzhr.zzfm());
                return true;
            case 2:
                zza((Object) b, i, zzhr.zzfq());
                return true;
            case 3:
                Object zzjo = zzjo();
                int i2 = (i << 3) | 4;
                while (zzhr.zzgg() != BaseClientBuilder.API_PRIORITY_OTHER) {
                    if (!zza(zzjo, zzhr)) {
                        if (i2 == zzhr.getTag()) {
                            throw zzgc.zzhu();
                        }
                        zza((Object) b, i, zzm(zzjo));
                        return true;
                    }
                }
                if (i2 == zzhr.getTag()) {
                    zza((Object) b, i, zzm(zzjo));
                    return true;
                }
                throw zzgc.zzhu();
            case 4:
                return false;
            case 5:
                zzc(b, i, zzhr.zzfn());
                return true;
            default:
                throw zzgc.zzhv();
        }
    }
}
