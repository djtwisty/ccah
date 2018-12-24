package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

interface zzwk {
    int getTag();

    double readDouble();

    float readFloat();

    String readString();

    void readStringList(List<String> list);

    <T> T zza(zzwl<T> zzwl, zzub zzub);

    <T> void zza(List<T> list, zzwl<T> zzwl, zzub zzub);

    <K, V> void zza(Map<K, V> map, zzvo<K, V> zzvo, zzub zzub);

    @Deprecated
    <T> T zzb(zzwl<T> zzwl, zzub zzub);

    @Deprecated
    <T> void zzb(List<T> list, zzwl<T> zzwl, zzub zzub);

    void zzi(List<Double> list);

    void zzj(List<Float> list);

    void zzk(List<Long> list);

    void zzl(List<Long> list);

    void zzm(List<Integer> list);

    void zzn(List<Long> list);

    void zzo(List<Integer> list);

    void zzp(List<Boolean> list);

    void zzq(List<String> list);

    void zzr(List<zzte> list);

    void zzs(List<Integer> list);

    void zzt(List<Integer> list);

    void zzu(List<Integer> list);

    long zzuk();

    long zzul();

    int zzum();

    long zzun();

    int zzuo();

    boolean zzup();

    String zzuq();

    zzte zzur();

    int zzus();

    int zzut();

    int zzuu();

    long zzuv();

    int zzuw();

    long zzux();

    void zzv(List<Long> list);

    int zzvh();

    boolean zzvi();

    void zzw(List<Integer> list);

    void zzx(List<Long> list);
}
