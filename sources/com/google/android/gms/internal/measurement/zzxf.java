package com.google.android.gms.internal.measurement;

final class zzxf extends zzxd<zzxe, zzxe> {
    zzxf() {
    }

    final boolean zza(zzwk zzwk) {
        return false;
    }

    private static void zza(Object obj, zzxe zzxe) {
        ((zzuo) obj).zzbyd = zzxe;
    }

    final void zzy(Object obj) {
        ((zzuo) obj).zzbyd.zzsw();
    }

    final /* synthetic */ int zzai(Object obj) {
        return ((zzxe) obj).zzvx();
    }

    final /* synthetic */ int zzan(Object obj) {
        return ((zzxe) obj).zzyn();
    }

    final /* synthetic */ Object zzh(Object obj, Object obj2) {
        zzxe zzxe = (zzxe) obj;
        zzxe zzxe2 = (zzxe) obj2;
        if (zzxe2.equals(zzxe.zzyl())) {
            return zzxe;
        }
        return zzxe.zza(zzxe, zzxe2);
    }

    final /* synthetic */ void zzc(Object obj, zzxy zzxy) {
        ((zzxe) obj).zza(zzxy);
    }

    final /* synthetic */ void zza(Object obj, zzxy zzxy) {
        ((zzxe) obj).zzb(zzxy);
    }

    final /* synthetic */ void zzg(Object obj, Object obj2) {
        zza(obj, (zzxe) obj2);
    }

    final /* synthetic */ Object zzam(Object obj) {
        zzxe zzxe = ((zzuo) obj).zzbyd;
        if (zzxe != zzxe.zzyl()) {
            return zzxe;
        }
        zzxe = zzxe.zzym();
        zza(obj, zzxe);
        return zzxe;
    }

    final /* synthetic */ Object zzal(Object obj) {
        return ((zzuo) obj).zzbyd;
    }

    final /* synthetic */ void zzf(Object obj, Object obj2) {
        zza(obj, (zzxe) obj2);
    }

    final /* synthetic */ Object zzaf(Object obj) {
        zzxe zzxe = (zzxe) obj;
        zzxe.zzsw();
        return zzxe;
    }

    final /* synthetic */ Object zzyk() {
        return zzxe.zzym();
    }

    final /* synthetic */ void zza(Object obj, int i, Object obj2) {
        ((zzxe) obj).zzb((i << 3) | 3, (zzxe) obj2);
    }

    final /* synthetic */ void zza(Object obj, int i, zzte zzte) {
        ((zzxe) obj).zzb((i << 3) | 2, (Object) zzte);
    }

    final /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzxe) obj).zzb((i << 3) | 1, Long.valueOf(j));
    }

    final /* synthetic */ void zzc(Object obj, int i, int i2) {
        ((zzxe) obj).zzb((i << 3) | 5, Integer.valueOf(i2));
    }

    final /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzxe) obj).zzb(i << 3, Long.valueOf(j));
    }
}
