package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.List;

public final class zzjn extends zzjq {
    private final String name;
    private zzia zzbkn = null;
    private final List<String> zzbml;
    private final List<zzra> zzbmm;

    public zzjn(zzia zzia, String str, List<String> list, List<zzra> list2) {
        this.name = str;
        this.zzbml = list;
        this.zzbmm = list2;
    }

    public final void zza(zzia zzia) {
        this.zzbkn = zzia;
    }

    public final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        try {
            zzia zzri = this.zzbkn.zzri();
            for (int i = 0; i < this.zzbml.size(); i++) {
                if (zzqpArr.length > i) {
                    zzri.zza((String) this.zzbml.get(i), zzqpArr[i]);
                } else {
                    zzri.zza((String) this.zzbml.get(i), zzqv.zzbpr);
                }
            }
            zzri.zza("arguments", new zzqw(Arrays.asList(zzqpArr)));
            for (zzra zza : this.zzbmm) {
                zzqp zza2 = zzrd.zza(zzri, zza);
                if ((zza2 instanceof zzqv) && ((zzqv) zza2).zzsv()) {
                    return (zzqp) ((zzqv) zza2).value();
                }
            }
        } catch (RuntimeException e) {
            String str = this.name;
            String message = e.getMessage();
            zzhk.m1081e(new StringBuilder((String.valueOf(str).length() + 33) + String.valueOf(message).length()).append("Internal error - Function call: ").append(str).append("\n").append(message).toString());
        }
        return zzqv.zzbpr;
    }

    public final String getName() {
        return this.name;
    }

    public final String toString() {
        String str = this.name;
        String obj = this.zzbml.toString();
        String obj2 = this.zzbmm.toString();
        return new StringBuilder(((String.valueOf(str).length() + 26) + String.valueOf(obj).length()) + String.valueOf(obj2).length()).append(str).append("\n\tparams: ").append(obj).append("\n\t: statements: ").append(obj2).toString();
    }
}
