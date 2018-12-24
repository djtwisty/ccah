package com.google.android.gms.internal.firebase_abt;

public final class zzf implements Cloneable {
    private static final zzg zzu = new zzg();
    private int mSize;
    private boolean zzv;
    private int[] zzw;
    private zzg[] zzx;

    zzf() {
        this(10);
    }

    private zzf(int i) {
        this.zzv = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzw = new int[idealIntArraySize];
        this.zzx = new zzg[idealIntArraySize];
        this.mSize = 0;
    }

    private static int idealIntArraySize(int i) {
        int i2 = i << 2;
        for (int i3 = 4; i3 < 32; i3++) {
            if (i2 <= (1 << i3) - 12) {
                i2 = (1 << i3) - 12;
                break;
            }
        }
        return i2 / 4;
    }

    private final int zzh(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.zzw[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    public final /* synthetic */ Object clone() {
        int i = this.mSize;
        zzf zzf = new zzf(i);
        System.arraycopy(this.zzw, 0, zzf.zzw, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zzx[i2] != null) {
                zzf.zzx[i2] = (zzg) this.zzx[i2].clone();
            }
        }
        zzf.mSize = i;
        return zzf;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzf)) {
            return false;
        }
        zzf zzf = (zzf) obj;
        if (this.mSize != zzf.mSize) {
            return false;
        }
        int i;
        boolean z;
        int[] iArr = this.zzw;
        int[] iArr2 = zzf.zzw;
        int i2 = this.mSize;
        for (i = 0; i < i2; i++) {
            if (iArr[i] != iArr2[i]) {
                z = false;
                break;
            }
        }
        z = true;
        if (z) {
            zzg[] zzgArr = this.zzx;
            zzg[] zzgArr2 = zzf.zzx;
            i2 = this.mSize;
            for (i = 0; i < i2; i++) {
                if (!zzgArr[i].equals(zzgArr2[i])) {
                    z = false;
                    break;
                }
            }
            z = true;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzw[i2]) * 31) + this.zzx[i2].hashCode();
        }
        return i;
    }

    final void zza(int i, zzg zzg) {
        int zzh = zzh(i);
        if (zzh >= 0) {
            this.zzx[zzh] = zzg;
            return;
        }
        zzh ^= -1;
        if (zzh >= this.mSize || this.zzx[zzh] != zzu) {
            if (this.mSize >= this.zzw.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                Object obj = new int[idealIntArraySize];
                Object obj2 = new zzg[idealIntArraySize];
                System.arraycopy(this.zzw, 0, obj, 0, this.zzw.length);
                System.arraycopy(this.zzx, 0, obj2, 0, this.zzx.length);
                this.zzw = obj;
                this.zzx = obj2;
            }
            if (this.mSize - zzh != 0) {
                System.arraycopy(this.zzw, zzh, this.zzw, zzh + 1, this.mSize - zzh);
                System.arraycopy(this.zzx, zzh, this.zzx, zzh + 1, this.mSize - zzh);
            }
            this.zzw[zzh] = i;
            this.zzx[zzh] = zzg;
            this.mSize++;
            return;
        }
        this.zzw[zzh] = i;
        this.zzx[zzh] = zzg;
    }

    final zzg zzg(int i) {
        int zzh = zzh(i);
        return (zzh < 0 || this.zzx[zzh] == zzu) ? null : this.zzx[zzh];
    }
}
