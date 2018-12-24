package com.google.android.gms.internal.measurement;

final class zztj extends zzto {
    private final int zzbtu;
    private final int zzbtv;

    zztj(byte[] bArr, int i, int i2) {
        super(bArr);
        zzte.zzb(i, i + i2, bArr.length);
        this.zzbtu = i;
        this.zzbtv = i2;
    }

    public final byte zzam(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzbtx[this.zzbtu + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + size);
    }

    final byte zzan(int i) {
        return this.zzbtx[this.zzbtu + i];
    }

    public final int size() {
        return this.zzbtv;
    }

    protected final int zzug() {
        return this.zzbtu;
    }
}
