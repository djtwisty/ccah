package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzhy {
    private static final Class<?> zzaau = zzjd();
    private static final zziq<?, ?> zzaav = zzv(false);
    private static final zziq<?, ?> zzaaw = zzv(true);
    private static final zziq<?, ?> zzaax = new zzis();

    public static void zzg(Class<?> cls) {
        if (!zzft.class.isAssignableFrom(cls) && zzaau != null && !zzaau.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzjl zzjl, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzjl.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzjl zzjl, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzjl.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzjl zzjl, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzjl.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzjl zzjl, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzjl.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzjl zzjl, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzjl.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzjl zzjl, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzjl.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzjl zzjl, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzjl.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzjl zzjl, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzjl.zza(i, (List) list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzjl zzjl, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzjl.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzjl zzjl, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzjl.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzjl zzjl, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzjl.zzb(i, (List) list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzjl zzjl, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzjl.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzjl zzjl, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzjl.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzjl zzjl, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzjl.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzjl zzjl) {
        if (list != null && !list.isEmpty()) {
            zzjl.zza(i, (List) list);
        }
    }

    public static void zzb(int i, List<zzeh> list, zzjl zzjl) {
        if (list != null && !list.isEmpty()) {
            zzjl.zzb(i, (List) list);
        }
    }

    public static void zza(int i, List<?> list, zzjl zzjl, zzhw zzhw) {
        if (list != null && !list.isEmpty()) {
            zzjl.zza(i, (List) list, zzhw);
        }
    }

    public static void zzb(int i, List<?> list, zzjl zzjl, zzhw zzhw) {
        if (list != null && !list.isEmpty()) {
            zzjl.zzb(i, (List) list, zzhw);
        }
    }

    static int zzt(List<Long> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i;
        if (list instanceof zzgq) {
            zzgq zzgq = (zzgq) list;
            int i2 = 0;
            for (i = 0; i < size; i++) {
                i2 += zzfa.zze(zzgq.getLong(i));
            }
            return i2;
        }
        i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i += zzfa.zze(((Long) list.get(i3)).longValue());
        }
        return i;
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzt(list) + (list.size() * zzfa.zzag(i));
    }

    static int zzu(List<Long> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i;
        if (list instanceof zzgq) {
            zzgq zzgq = (zzgq) list;
            int i2 = 0;
            for (i = 0; i < size; i++) {
                i2 += zzfa.zzf(zzgq.getLong(i));
            }
            return i2;
        }
        i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i += zzfa.zzf(((Long) list.get(i3)).longValue());
        }
        return i;
    }

    static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzfa.zzag(i)) + zzu(list);
    }

    static int zzv(List<Long> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i;
        if (list instanceof zzgq) {
            zzgq zzgq = (zzgq) list;
            int i2 = 0;
            for (i = 0; i < size; i++) {
                i2 += zzfa.zzg(zzgq.getLong(i));
            }
            return i2;
        }
        i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i += zzfa.zzg(((Long) list.get(i3)).longValue());
        }
        return i;
    }

    static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzfa.zzag(i)) + zzv((List) list);
    }

    static int zzw(List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i;
        if (list instanceof zzfu) {
            zzfu zzfu = (zzfu) list;
            int i2 = 0;
            for (i = 0; i < size; i++) {
                i2 += zzfa.zzam(zzfu.getInt(i));
            }
            return i2;
        }
        i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i += zzfa.zzam(((Integer) list.get(i3)).intValue());
        }
        return i;
    }

    static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzfa.zzag(i)) + zzw(list);
    }

    static int zzx(List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i;
        if (list instanceof zzfu) {
            zzfu zzfu = (zzfu) list;
            int i2 = 0;
            for (i = 0; i < size; i++) {
                i2 += zzfa.zzah(zzfu.getInt(i));
            }
            return i2;
        }
        i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i += zzfa.zzah(((Integer) list.get(i3)).intValue());
        }
        return i;
    }

    static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzfa.zzag(i)) + zzx(list);
    }

    static int zzy(List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i;
        if (list instanceof zzfu) {
            zzfu zzfu = (zzfu) list;
            int i2 = 0;
            for (i = 0; i < size; i++) {
                i2 += zzfa.zzai(zzfu.getInt(i));
            }
            return i2;
        }
        i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i += zzfa.zzai(((Integer) list.get(i3)).intValue());
        }
        return i;
    }

    static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzfa.zzag(i)) + zzy(list);
    }

    static int zzz(List<Integer> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i;
        if (list instanceof zzfu) {
            zzfu zzfu = (zzfu) list;
            int i2 = 0;
            for (i = 0; i < size; i++) {
                i2 += zzfa.zzaj(zzfu.getInt(i));
            }
            return i2;
        }
        i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i += zzfa.zzaj(((Integer) list.get(i3)).intValue());
        }
        return i;
    }

    static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzfa.zzag(i)) + zzz(list);
    }

    static int zzaa(List<?> list) {
        return list.size() << 2;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzfa.zzn(i, 0) * size;
    }

    static int zzab(List<?> list) {
        return list.size() << 3;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzfa.zzg(i, 0);
    }

    static int zzac(List<?> list) {
        return list.size();
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzfa.zzc(i, true);
    }

    static int zzc(int i, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzag = zzfa.zzag(i) * size;
        int i2;
        Object zzat;
        int zzb;
        if (list instanceof zzgl) {
            zzgl zzgl = (zzgl) list;
            i2 = 0;
            while (i2 < size) {
                zzat = zzgl.zzat(i2);
                if (zzat instanceof zzeh) {
                    zzb = zzfa.zzb((zzeh) zzat) + zzag;
                } else {
                    zzb = zzfa.zzdb((String) zzat) + zzag;
                }
                i2++;
                zzag = zzb;
            }
            return zzag;
        }
        i2 = 0;
        while (i2 < size) {
            zzat = list.get(i2);
            if (zzat instanceof zzeh) {
                zzb = zzfa.zzb((zzeh) zzat) + zzag;
            } else {
                zzb = zzfa.zzdb((String) zzat) + zzag;
            }
            i2++;
            zzag = zzb;
        }
        return zzag;
    }

    static int zzc(int i, Object obj, zzhw zzhw) {
        if (obj instanceof zzgj) {
            return zzfa.zza(i, (zzgj) obj);
        }
        return zzfa.zzb(i, (zzhc) obj, zzhw);
    }

    static int zzc(int i, List<?> list, zzhw zzhw) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzag = zzfa.zzag(i) * size;
        int i2 = 0;
        while (i2 < size) {
            int zza;
            Object obj = list.get(i2);
            if (obj instanceof zzgj) {
                zza = zzfa.zza((zzgj) obj) + zzag;
            } else {
                zza = zzfa.zza((zzhc) obj, zzhw) + zzag;
            }
            i2++;
            zzag = zza;
        }
        return zzag;
    }

    static int zzd(int i, List<zzeh> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzag = zzfa.zzag(i) * size;
        for (size = 0; size < list.size(); size++) {
            zzag += zzfa.zzb((zzeh) list.get(size));
        }
        return zzag;
    }

    static int zzd(int i, List<zzhc> list, zzhw zzhw) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzfa.zzc(i, (zzhc) list.get(i3), zzhw);
        }
        return i2;
    }

    public static zziq<?, ?> zzja() {
        return zzaav;
    }

    public static zziq<?, ?> zzjb() {
        return zzaaw;
    }

    public static zziq<?, ?> zzjc() {
        return zzaax;
    }

    private static zziq<?, ?> zzv(boolean z) {
        try {
            Class zzje = zzje();
            if (zzje == null) {
                return null;
            }
            return (zziq) zzje.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable th) {
            return null;
        }
    }

    private static Class<?> zzjd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable th) {
            return null;
        }
    }

    private static Class<?> zzje() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable th) {
            return null;
        }
    }

    static boolean zzd(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <T> void zza(zzgx zzgx, T t, T t2, long j) {
        zziw.zza((Object) t, j, zzgx.zzb(zziw.zzp(t, j), zziw.zzp(t2, j)));
    }

    static <T, FT extends zzfm<FT>> void zza(zzfh<FT> zzfh, T t, T t2) {
        zzfk zzd = zzfh.zzd(t2);
        if (!zzd.isEmpty()) {
            zzfh.zze(t).zza(zzd);
        }
    }

    static <T, UT, UB> void zza(zziq<UT, UB> zziq, T t, T t2) {
        zziq.zze(t, zziq.zzg(zziq.zzs(t), zziq.zzs(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzfy zzfy, UB ub, zziq<UT, UB> zziq) {
        if (zzfy == null) {
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
                if (zzfy.zzc(intValue)) {
                    if (i2 != i3) {
                        list.set(i3, Integer.valueOf(intValue));
                    }
                    intValue = i3 + 1;
                } else {
                    ub2 = zza(i, intValue, (Object) ub2, (zziq) zziq);
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
                if (!zzfy.zzc(intValue)) {
                    ub = zza(i, intValue, (Object) ub, (zziq) zziq);
                    it.remove();
                }
            }
            ub2 = ub;
        }
        return ub2;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zziq<UT, UB> zziq) {
        Object zzjo;
        if (ub == null) {
            zzjo = zziq.zzjo();
        }
        zziq.zza(zzjo, i, (long) i2);
        return zzjo;
    }
}
