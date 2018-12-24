package com.google.android.gms.internal.measurement;

public final class zzye implements Cloneable {
    private static final zzyf zzcew = new zzyf();
    private int mSize;
    private boolean zzcex;
    private int[] zzcey;
    private zzyf[] zzcez;

    zzye() {
        this(10);
    }

    private zzye(int i) {
        this.zzcex = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzcey = new int[idealIntArraySize];
        this.zzcez = new zzyf[idealIntArraySize];
        this.mSize = 0;
    }

    final zzyf zzce(int i) {
        int zzcg = zzcg(i);
        if (zzcg < 0 || this.zzcez[zzcg] == zzcew) {
            return null;
        }
        return this.zzcez[zzcg];
    }

    final void zza(int i, zzyf zzyf) {
        int zzcg = zzcg(i);
        if (zzcg >= 0) {
            this.zzcez[zzcg] = zzyf;
            return;
        }
        zzcg ^= -1;
        if (zzcg >= this.mSize || this.zzcez[zzcg] != zzcew) {
            if (this.mSize >= this.zzcey.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                Object obj = new int[idealIntArraySize];
                Object obj2 = new zzyf[idealIntArraySize];
                System.arraycopy(this.zzcey, 0, obj, 0, this.zzcey.length);
                System.arraycopy(this.zzcez, 0, obj2, 0, this.zzcez.length);
                this.zzcey = obj;
                this.zzcez = obj2;
            }
            if (this.mSize - zzcg != 0) {
                System.arraycopy(this.zzcey, zzcg, this.zzcey, zzcg + 1, this.mSize - zzcg);
                System.arraycopy(this.zzcez, zzcg, this.zzcez, zzcg + 1, this.mSize - zzcg);
            }
            this.zzcey[zzcg] = i;
            this.zzcez[zzcg] = zzyf;
            this.mSize++;
            return;
        }
        this.zzcey[zzcg] = i;
        this.zzcez[zzcg] = zzyf;
    }

    final int size() {
        return this.mSize;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    final zzyf zzcf(int i) {
        return this.zzcez[i];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzye)) {
            return false;
        }
        zzye zzye = (zzye) obj;
        if (this.mSize != zzye.mSize) {
            return false;
        }
        int i;
        boolean z;
        int[] iArr = this.zzcey;
        int[] iArr2 = zzye.zzcey;
        int i2 = this.mSize;
        for (i = 0; i < i2; i++) {
            if (iArr[i] != iArr2[i]) {
                z = false;
                break;
            }
        }
        z = true;
        if (z) {
            zzyf[] zzyfArr = this.zzcez;
            zzyf[] zzyfArr2 = zzye.zzcez;
            i2 = this.mSize;
            for (i = 0; i < i2; i++) {
                if (!zzyfArr[i].equals(zzyfArr2[i])) {
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
            i = (((i * 31) + this.zzcey[i2]) * 31) + this.zzcez[i2].hashCode();
        }
        return i;
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

    private final int zzcg(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.zzcey[i4];
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
        zzye zzye = new zzye(i);
        System.arraycopy(this.zzcey, 0, zzye.zzcey, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zzcez[i2] != null) {
                zzye.zzcez[i2] = (zzyf) this.zzcez[i2].clone();
            }
        }
        zzye.mSize = i;
        return zzye;
    }
}
