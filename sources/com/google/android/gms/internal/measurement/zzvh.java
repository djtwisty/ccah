package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

final class zzvh extends zzvf {
    private static final Class<?> zzcac = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzvh() {
        super();
    }

    final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    final void zzb(Object obj, long j) {
        Object zzxc;
        List list = (List) zzxj.zzp(obj, j);
        if (list instanceof zzve) {
            zzxc = ((zzve) list).zzxc();
        } else if (!zzcac.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzwg) || !(list instanceof zzuu)) {
                zzxc = Collections.unmodifiableList(list);
            } else if (((zzuu) list).zztz()) {
                ((zzuu) list).zzsw();
                return;
            } else {
                return;
            }
        } else {
            return;
        }
        zzxj.zza(obj, j, zzxc);
    }

    private static <L> List<L> zza(Object obj, long j, int i) {
        List<L> zzc = zzc(obj, j);
        Object zzvd;
        if (zzc.isEmpty()) {
            if (zzc instanceof zzve) {
                zzvd = new zzvd(i);
            } else if ((zzc instanceof zzwg) && (zzc instanceof zzuu)) {
                zzvd = ((zzuu) zzc).zzal(i);
            } else {
                zzvd = new ArrayList(i);
            }
            zzxj.zza(obj, j, zzvd);
            return zzvd;
        } else if (zzcac.isAssignableFrom(zzc.getClass())) {
            r1 = new ArrayList(zzc.size() + i);
            r1.addAll(zzc);
            zzxj.zza(obj, j, (Object) r1);
            return r1;
        } else if (zzc instanceof zzxg) {
            r1 = new zzvd(zzc.size() + i);
            r1.addAll((zzxg) zzc);
            zzxj.zza(obj, j, (Object) r1);
            return r1;
        } else if (!(zzc instanceof zzwg) || !(zzc instanceof zzuu) || ((zzuu) zzc).zztz()) {
            return zzc;
        } else {
            zzvd = ((zzuu) zzc).zzal(zzc.size() + i);
            zzxj.zza(obj, j, zzvd);
            return zzvd;
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
        zzxj.zza(obj, j, zza);
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzxj.zzp(obj, j);
    }
}
