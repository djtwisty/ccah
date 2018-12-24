package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.api.Api.BaseClientBuilder;

public abstract class zzet {
    int zzsx;
    int zzsy;
    int zzsz;
    zzey zzta;
    private boolean zztb;

    static zzet zza(byte[] bArr, int i, int i2, boolean z) {
        zzet zzev = new zzev(bArr, 0, i2, false);
        try {
            zzev.zzp(i2);
            return zzev;
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract double readDouble();

    public abstract float readFloat();

    public abstract String readString();

    public abstract int zzfi();

    public abstract long zzfj();

    public abstract long zzfk();

    public abstract int zzfl();

    public abstract long zzfm();

    public abstract int zzfn();

    public abstract boolean zzfo();

    public abstract String zzfp();

    public abstract zzeh zzfq();

    public abstract int zzfr();

    public abstract int zzfs();

    public abstract int zzft();

    public abstract long zzfu();

    public abstract int zzfv();

    public abstract long zzfw();

    abstract long zzfx();

    public abstract boolean zzfy();

    public abstract int zzfz();

    public abstract void zzn(int i);

    public abstract boolean zzo(int i);

    public abstract int zzp(int i);

    public abstract void zzq(int i);

    private zzet() {
        this.zzsy = 100;
        this.zzsz = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zztb = false;
    }

    public static int zzr(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static long zza(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }
}
