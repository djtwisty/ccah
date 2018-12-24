package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzwn {
    private static final Class<?> zzcbn = zzya();
    private static final zzxd<?, ?> zzcbo = zzv(false);
    private static final zzxd<?, ?> zzcbp = zzv(true);
    private static final zzxd<?, ?> zzcbq = new zzxf();

    public static void zzj(Class<?> cls) {
        if (!zzuo.class.isAssignableFrom(cls) && zzcbn != null && !zzcbn.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzxy zzxy, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzxy.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzxy zzxy, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzxy.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzxy zzxy, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzxy.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzxy zzxy, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzxy.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzxy zzxy, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzxy.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzxy zzxy, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzxy.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzxy zzxy, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzxy.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzxy zzxy, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzxy.zza(i, (List) list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzxy zzxy, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzxy.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzxy zzxy, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzxy.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzxy zzxy, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzxy.zzb(i, (List) list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzxy zzxy, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzxy.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzxy zzxy, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzxy.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzxy zzxy, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzxy.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzxy zzxy) {
        if (list != null && !list.isEmpty()) {
            zzxy.zza(i, (List) list);
        }
    }

    public static void zzb(int i, List<zzte> list, zzxy zzxy) {
        if (list != null && !list.isEmpty()) {
            zzxy.zzb(i, (List) list);
        }
    }

    public static void zza(int i, List<?> list, zzxy zzxy, zzwl zzwl) {
        if (list != null && !list.isEmpty()) {
            zzxy.zza(i, (List) list, zzwl);
        }
    }

    public static void zzb(int i, List<?> list, zzxy zzxy, zzwl zzwl) {
        if (list != null && !list.isEmpty()) {
            zzxy.zzb(i, (List) list, zzwl);
        }
    }

    static int zzy(List<Long> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i;
        if (list instanceof zzvj) {
            zzvj zzvj = (zzvj) list;
            int i2 = 0;
            for (i = 0; i < size; i++) {
                i2 += zztv.zzaw(zzvj.getLong(i));
            }
            return i2;
        }
        i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i += zztv.zzaw(((Long) list.get(i3)).longValue());
        }
        return i;
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzy(list) + (list.size() * zztv.zzbd(i));
    }

    static int zzz(List<Long> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i;
        if (list instanceof zzvj) {
            zzvj zzvj = (zzvj) list;
            int i2 = 0;
            for (i = 0; i < size; i++) {
                i2 += zztv.zzax(zzvj.getLong(i));
            }
            return i2;
        }
        i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i += zztv.zzax(((Long) list.get(i3)).longValue());
        }
        return i;
    }

    static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zztv.zzbd(i)) + zzz(list);
    }

    static int zzaa(List<Long> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i;
        if (list instanceof zzvj) {
            zzvj zzvj = (zzvj) list;
            int i2 = 0;
            for (i = 0; i < size; i++) {
                i2 += zztv.zzay(zzvj.getLong(i));
            }
            return i2;
        }
        i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i += zztv.zzay(((Long) list.get(i3)).longValue());
        }
        return i;
    }

    static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zztv.zzbd(i)) + zzaa(list);
    }

    static int zzab(List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i;
        if (list instanceof zzup) {
            zzup zzup = (zzup) list;
            int i2 = 0;
            for (i = 0; i < size; i++) {
                i2 += zztv.zzbj(zzup.getInt(i));
            }
            return i2;
        }
        i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i += zztv.zzbj(((Integer) list.get(i3)).intValue());
        }
        return i;
    }

    static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zztv.zzbd(i)) + zzab(list);
    }

    static int zzac(List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i;
        if (list instanceof zzup) {
            zzup zzup = (zzup) list;
            int i2 = 0;
            for (i = 0; i < size; i++) {
                i2 += zztv.zzbe(zzup.getInt(i));
            }
            return i2;
        }
        i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i += zztv.zzbe(((Integer) list.get(i3)).intValue());
        }
        return i;
    }

    static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zztv.zzbd(i)) + zzac(list);
    }

    static int zzad(List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i;
        if (list instanceof zzup) {
            zzup zzup = (zzup) list;
            int i2 = 0;
            for (i = 0; i < size; i++) {
                i2 += zztv.zzbf(zzup.getInt(i));
            }
            return i2;
        }
        i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i += zztv.zzbf(((Integer) list.get(i3)).intValue());
        }
        return i;
    }

    static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zztv.zzbd(i)) + zzad(list);
    }

    static int zzae(List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i;
        if (list instanceof zzup) {
            zzup zzup = (zzup) list;
            int i2 = 0;
            for (i = 0; i < size; i++) {
                i2 += zztv.zzbg(zzup.getInt(i));
            }
            return i2;
        }
        i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i += zztv.zzbg(((Integer) list.get(i3)).intValue());
        }
        return i;
    }

    static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zztv.zzbd(i)) + zzae(list);
    }

    static int zzaf(List<?> list) {
        return list.size() << 2;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zztv.zzk(i, 0) * size;
    }

    static int zzag(List<?> list) {
        return list.size() << 3;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zztv.zzg(i, 0);
    }

    static int zzah(List<?> list) {
        return list.size();
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zztv.zzc(i, true);
    }

    static int zzc(int i, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbd = zztv.zzbd(i) * size;
        int i2;
        Object zzbp;
        int zzb;
        if (list instanceof zzve) {
            zzve zzve = (zzve) list;
            i2 = 0;
            while (i2 < size) {
                zzbp = zzve.zzbp(i2);
                if (zzbp instanceof zzte) {
                    zzb = zztv.zzb((zzte) zzbp) + zzbd;
                } else {
                    zzb = zztv.zzgc((String) zzbp) + zzbd;
                }
                i2++;
                zzbd = zzb;
            }
            return zzbd;
        }
        i2 = 0;
        while (i2 < size) {
            zzbp = list.get(i2);
            if (zzbp instanceof zzte) {
                zzb = zztv.zzb((zzte) zzbp) + zzbd;
            } else {
                zzb = zztv.zzgc((String) zzbp) + zzbd;
            }
            i2++;
            zzbd = zzb;
        }
        return zzbd;
    }

    static int zzc(int i, Object obj, zzwl zzwl) {
        if (obj instanceof zzvc) {
            return zztv.zza(i, (zzvc) obj);
        }
        return zztv.zzb(i, (zzvv) obj, zzwl);
    }

    static int zzc(int i, List<?> list, zzwl zzwl) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbd = zztv.zzbd(i) * size;
        int i2 = 0;
        while (i2 < size) {
            int zza;
            Object obj = list.get(i2);
            if (obj instanceof zzvc) {
                zza = zztv.zza((zzvc) obj) + zzbd;
            } else {
                zza = zztv.zzb((zzvv) obj, zzwl) + zzbd;
            }
            i2++;
            zzbd = zza;
        }
        return zzbd;
    }

    static int zzd(int i, List<zzte> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbd = zztv.zzbd(i) * size;
        for (size = 0; size < list.size(); size++) {
            zzbd += zztv.zzb((zzte) list.get(size));
        }
        return zzbd;
    }

    static int zzd(int i, List<zzvv> list, zzwl zzwl) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zztv.zzc(i, (zzvv) list.get(i3), zzwl);
        }
        return i2;
    }

    public static zzxd<?, ?> zzxx() {
        return zzcbo;
    }

    public static zzxd<?, ?> zzxy() {
        return zzcbp;
    }

    public static zzxd<?, ?> zzxz() {
        return zzcbq;
    }

    private static zzxd<?, ?> zzv(boolean z) {
        try {
            Class zzyb = zzyb();
            if (zzyb == null) {
                return null;
            }
            return (zzxd) zzyb.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable th) {
            return null;
        }
    }

    private static Class<?> zzya() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable th) {
            return null;
        }
    }

    private static Class<?> zzyb() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable th) {
            return null;
        }
    }

    static boolean zze(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <T> void zza(zzvq zzvq, T t, T t2, long j) {
        zzxj.zza((Object) t, j, zzvq.zzc(zzxj.zzp(t, j), zzxj.zzp(t2, j)));
    }

    static <T, FT extends zzuh<FT>> void zza(zzuc<FT> zzuc, T t, T t2) {
        zzuf zzw = zzuc.zzw(t2);
        if (!zzw.isEmpty()) {
            zzuc.zzx(t).zza(zzw);
        }
    }

    static <T, UT, UB> void zza(zzxd<UT, UB> zzxd, T t, T t2) {
        zzxd.zzf(t, zzxd.zzh(zzxd.zzal(t), zzxd.zzal(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzut zzut, UB ub, zzxd<UT, UB> zzxd) {
        if (zzut == null) {
            return ub;
        }
        UB ub2;
        int intValue;
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            int i3 = 0;
            ub2 = ub;
            while (i2 < size) {
                intValue = ((Integer) list.get(i2)).intValue();
                if (zzut.zzb(intValue)) {
                    if (i2 != i3) {
                        list.set(i3, Integer.valueOf(intValue));
                    }
                    intValue = i3 + 1;
                } else {
                    ub2 = zza(i, intValue, (Object) ub2, (zzxd) zzxd);
                    intValue = i3;
                }
                i2++;
                i3 = intValue;
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                intValue = ((Integer) it.next()).intValue();
                if (!zzut.zzb(intValue)) {
                    ub = zza(i, intValue, (Object) ub, (zzxd) zzxd);
                    it.remove();
                }
            }
            ub2 = ub;
        }
        return ub2;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzxd<UT, UB> zzxd) {
        Object zzyk;
        if (ub == null) {
            zzyk = zzxd.zzyk();
        }
        zzxd.zza(zzyk, i, (long) i2);
        return zzyk;
    }
}
