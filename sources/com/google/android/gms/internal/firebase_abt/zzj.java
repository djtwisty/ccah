package com.google.android.gms.internal.firebase_abt;

public abstract class zzj {
    protected volatile int zzab = -1;

    public static final <T extends zzj> T zza(T t, byte[] bArr, int i, int i2) {
        try {
            zza zza = zza.zza(bArr, 0, i2);
            t.zza(zza);
            zza.zza(0);
            return t;
        } catch (zzi e) {
            throw e;
        } catch (Throwable e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
        }
    }

    public /* synthetic */ Object clone() {
        return zzj();
    }

    public String toString() {
        return zzk.zzb(this);
    }

    public abstract zzj zza(zza zza);

    public zzj zzj() {
        return (zzj) super.clone();
    }
}
