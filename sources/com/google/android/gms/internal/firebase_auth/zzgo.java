package com.google.android.gms.internal.firebase_auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

final class zzgo extends zzgm {
    private static final Class<?> zzyw = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzgo() {
        super();
    }

    final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    final void zzb(Object obj, long j) {
        Object zzid;
        List list = (List) zziw.zzp(obj, j);
        if (list instanceof zzgl) {
            zzid = ((zzgl) list).zzid();
        } else if (!zzyw.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzhn) || !(list instanceof zzgb)) {
                zzid = Collections.unmodifiableList(list);
            } else if (((zzgb) list).zzeu()) {
                ((zzgb) list).zzev();
                return;
            } else {
                return;
            }
        } else {
            return;
        }
        zziw.zza(obj, j, zzid);
    }

    private static <L> List<L> zza(Object obj, long j, int i) {
        List<L> zzc = zzc(obj, j);
        Object zzgk;
        if (zzc.isEmpty()) {
            if (zzc instanceof zzgl) {
                zzgk = new zzgk(i);
            } else if ((zzc instanceof zzhn) && (zzc instanceof zzgb)) {
                zzgk = ((zzgb) zzc).zzj(i);
            } else {
                zzgk = new ArrayList(i);
            }
            zziw.zza(obj, j, zzgk);
            return zzgk;
        } else if (zzyw.isAssignableFrom(zzc.getClass())) {
            r1 = new ArrayList(zzc.size() + i);
            r1.addAll(zzc);
            zziw.zza(obj, j, (Object) r1);
            return r1;
        } else if (zzc instanceof zzit) {
            r1 = new zzgk(zzc.size() + i);
            r1.addAll((zzit) zzc);
            zziw.zza(obj, j, (Object) r1);
            return r1;
        } else if (!(zzc instanceof zzhn) || !(zzc instanceof zzgb) || ((zzgb) zzc).zzeu()) {
            return zzc;
        } else {
            zzgk = ((zzgb) zzc).zzj(zzc.size() + i);
            zziw.zza(obj, j, zzgk);
            return zzgk;
        }
    }

    final <E> void zza(Object obj, Object obj2, long j) {
        Collection zzc = zzc(obj2, j);
        Object zza = zza(obj, j, zzc.size());
        int size = zza.size();
        int size2 = zzc.size();
        if (size > 0 && size2 > 0) {
            zza.addAll(zzc);
        }
        if (size <= 0) {
            Collection collection = zzc;
        }
        zziw.zza(obj, j, zza);
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zziw.zzp(obj, j);
    }
}
