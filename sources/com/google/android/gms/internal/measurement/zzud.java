package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo.zzc;
import java.util.Map.Entry;

final class zzud extends zzuc<Object> {
    zzud() {
    }

    final boolean zze(zzvv zzvv) {
        return zzvv instanceof zzc;
    }

    final zzuf<Object> zzw(Object obj) {
        return ((zzc) obj).zzbyj;
    }

    final zzuf<Object> zzx(Object obj) {
        zzc zzc = (zzc) obj;
        if (zzc.zzbyj.isImmutable()) {
            zzc.zzbyj = (zzuf) zzc.zzbyj.clone();
        }
        return zzc.zzbyj;
    }

    final void zzy(Object obj) {
        zzw(obj).zzsw();
    }

    final <UT, UB> UB zza(zzwk zzwk, Object obj, zzub zzub, zzuf<Object> zzuf, UB ub, zzxd<UT, UB> zzxd) {
        throw new NoSuchMethodError();
    }

    final int zzb(Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    final void zza(zzxy zzxy, Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    final Object zza(zzub zzub, zzvv zzvv, int i) {
        return zzub.zza(zzvv, i);
    }

    final void zza(zzwk zzwk, Object obj, zzub zzub, zzuf<Object> zzuf) {
        throw new NoSuchMethodError();
    }

    final void zza(zzte zzte, Object obj, zzub zzub, zzuf<Object> zzuf) {
        throw new NoSuchMethodError();
    }
}
