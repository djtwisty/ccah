package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Api.BaseClientBuilder;

public abstract class zztq {
    int zzbty;
    int zzbtz;
    private int zzbua;
    zztt zzbub;
    private boolean zzbuc;

    public static zztq zzd(byte[] bArr, int i, int i2) {
        return zza(bArr, i, i2, false);
    }

    public abstract double readDouble();

    public abstract float readFloat();

    public abstract String readString();

    public abstract <T extends zzvv> T zza(zzwf<T> zzwf, zzub zzub);

    public abstract void zzap(int i);

    public abstract boolean zzaq(int i);

    public abstract int zzas(int i);

    public abstract void zzat(int i);

    public abstract void zzau(int i);

    public abstract int zzuj();

    public abstract long zzuk();

    public abstract long zzul();

    public abstract int zzum();

    public abstract long zzun();

    public abstract int zzuo();

    public abstract boolean zzup();

    public abstract String zzuq();

    public abstract zzte zzur();

    public abstract int zzus();

    public abstract int zzut();

    public abstract int zzuu();

    public abstract long zzuv();

    public abstract int zzuw();

    public abstract long zzux();

    abstract long zzuy();

    public abstract boolean zzuz();

    public abstract int zzva();

    static zztq zza(byte[] bArr, int i, int i2, boolean z) {
        zztq zzts = new zzts(bArr, i, i2, false, null);
        try {
            zzts.zzas(i2);
            return zzts;
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    private zztq() {
        this.zzbtz = 100;
        this.zzbua = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zzbuc = false;
    }

    public final int zzar(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Recursion limit cannot be negative: " + i);
        }
        int i2 = this.zzbtz;
        this.zzbtz = i;
        return i2;
    }
}
