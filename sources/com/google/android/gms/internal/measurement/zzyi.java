package com.google.android.gms.internal.measurement;

public abstract class zzyi {
    protected volatile int zzcfd = -1;

    public abstract zzyi zza(zzxz zzxz);

    public final int zzzh() {
        if (this.zzcfd < 0) {
            zzvx();
        }
        return this.zzcfd;
    }

    public final int zzvx() {
        int zzf = zzf();
        this.zzcfd = zzf;
        return zzf;
    }

    protected int zzf() {
        return 0;
    }

    public void zza(zzya zzya) {
    }

    public static final void zza(zzyi zzyi, byte[] bArr, int i, int i2) {
        try {
            zzya zzk = zzya.zzk(bArr, 0, i2);
            zzyi.zza(zzk);
            zzk.zzza();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final <T extends zzyi> T zza(T t, byte[] bArr) {
        return zzb(t, bArr, 0, bArr.length);
    }

    private static final <T extends zzyi> T zzb(T t, byte[] bArr, int i, int i2) {
        try {
            zzxz zzj = zzxz.zzj(bArr, 0, i2);
            t.zza(zzj);
            zzj.zzap(0);
            return t;
        } catch (zzyh e) {
            throw e;
        } catch (Throwable e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
        }
    }

    public String toString() {
        return zzyj.zzc(this);
    }

    public zzyi zzzb() {
        return (zzyi) super.clone();
    }

    public /* synthetic */ Object clone() {
        return zzzb();
    }
}
