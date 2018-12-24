package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft.zzc;
import java.util.Map.Entry;

final class zzfi extends zzfh<Object> {
    zzfi() {
    }

    final boolean zzf(zzhc zzhc) {
        return zzhc instanceof zzc;
    }

    final zzfk<Object> zzd(Object obj) {
        return ((zzc) obj).zzxe;
    }

    final zzfk<Object> zze(Object obj) {
        zzc zzc = (zzc) obj;
        if (zzc.zzxe.isImmutable()) {
            zzc.zzxe = (zzfk) zzc.zzxe.clone();
        }
        return zzc.zzxe;
    }

    final void zzf(Object obj) {
        zzd(obj).zzev();
    }

    final <UT, UB> UB zza(zzhr zzhr, Object obj, zzfg zzfg, zzfk<Object> zzfk, UB ub, zziq<UT, UB> zziq) {
        throw new NoSuchMethodError();
    }

    final int zza(Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    final void zza(zzjl zzjl, Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    final Object zza(zzfg zzfg, zzhc zzhc, int i) {
        return zzfg.zza(zzhc, i);
    }

    final void zza(zzhr zzhr, Object obj, zzfg zzfg, zzfk<Object> zzfk) {
        throw new NoSuchMethodError();
    }

    final void zza(zzeh zzeh, Object obj, zzfg zzfg, zzfk<Object> zzfk) {
        throw new NoSuchMethodError();
    }
}
