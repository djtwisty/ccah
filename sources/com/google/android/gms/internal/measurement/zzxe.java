package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo.zze;
import java.util.Arrays;

public final class zzxe {
    private static final zzxe zzccf = new zzxe(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzbtl;
    private int zzbye;
    private Object[] zzcar;
    private int[] zzccg;

    public static zzxe zzyl() {
        return zzccf;
    }

    static zzxe zzym() {
        return new zzxe();
    }

    static zzxe zza(zzxe zzxe, zzxe zzxe2) {
        int i = zzxe.count + zzxe2.count;
        Object copyOf = Arrays.copyOf(zzxe.zzccg, i);
        System.arraycopy(zzxe2.zzccg, 0, copyOf, zzxe.count, zzxe2.count);
        Object copyOf2 = Arrays.copyOf(zzxe.zzcar, i);
        System.arraycopy(zzxe2.zzcar, 0, copyOf2, zzxe.count, zzxe2.count);
        return new zzxe(i, copyOf, copyOf2, true);
    }

    private zzxe() {
        this(0, new int[8], new Object[8], true);
    }

    private zzxe(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzbye = -1;
        this.count = i;
        this.zzccg = iArr;
        this.zzcar = objArr;
        this.zzbtl = z;
    }

    public final void zzsw() {
        this.zzbtl = false;
    }

    final void zza(zzxy zzxy) {
        int i;
        if (zzxy.zzvm() == zze.zzbyw) {
            for (i = this.count - 1; i >= 0; i--) {
                zzxy.zza(this.zzccg[i] >>> 3, this.zzcar[i]);
            }
            return;
        }
        for (i = 0; i < this.count; i++) {
            zzxy.zza(this.zzccg[i] >>> 3, this.zzcar[i]);
        }
    }

    public final void zzb(zzxy zzxy) {
        if (this.count != 0) {
            int i;
            if (zzxy.zzvm() == zze.zzbyv) {
                for (i = 0; i < this.count; i++) {
                    zzb(this.zzccg[i], this.zzcar[i], zzxy);
                }
                return;
            }
            for (i = this.count - 1; i >= 0; i--) {
                zzb(this.zzccg[i], this.zzcar[i], zzxy);
            }
        }
    }

    private static void zzb(int i, Object obj, zzxy zzxy) {
        int i2 = i >>> 3;
        switch (i & 7) {
            case 0:
                zzxy.zzi(i2, ((Long) obj).longValue());
                return;
            case 1:
                zzxy.zzc(i2, ((Long) obj).longValue());
                return;
            case 2:
                zzxy.zza(i2, (zzte) obj);
                return;
            case 3:
                if (zzxy.zzvm() == zze.zzbyv) {
                    zzxy.zzbm(i2);
                    ((zzxe) obj).zzb(zzxy);
                    zzxy.zzbn(i2);
                    return;
                }
                zzxy.zzbn(i2);
                ((zzxe) obj).zzb(zzxy);
                zzxy.zzbm(i2);
                return;
            case 5:
                zzxy.zzg(i2, ((Integer) obj).intValue());
                return;
            default:
                throw new RuntimeException(zzuv.zzwu());
        }
    }

    public final int zzyn() {
        int i = this.zzbye;
        if (i == -1) {
            i = 0;
            for (int i2 = 0; i2 < this.count; i2++) {
                i += zztv.zzd(this.zzccg[i2] >>> 3, (zzte) this.zzcar[i2]);
            }
            this.zzbye = i;
        }
        return i;
    }

    public final int zzvx() {
        int i = this.zzbye;
        if (i == -1) {
            i = 0;
            for (int i2 = 0; i2 < this.count; i2++) {
                int i3 = this.zzccg[i2];
                int i4 = i3 >>> 3;
                switch (i3 & 7) {
                    case 0:
                        i += zztv.zze(i4, ((Long) this.zzcar[i2]).longValue());
                        break;
                    case 1:
                        i += zztv.zzg(i4, ((Long) this.zzcar[i2]).longValue());
                        break;
                    case 2:
                        i += zztv.zzc(i4, (zzte) this.zzcar[i2]);
                        break;
                    case 3:
                        i += ((zzxe) this.zzcar[i2]).zzvx() + (zztv.zzbd(i4) << 1);
                        break;
                    case 5:
                        i += zztv.zzk(i4, ((Integer) this.zzcar[i2]).intValue());
                        break;
                    default:
                        throw new IllegalStateException(zzuv.zzwu());
                }
            }
            this.zzbye = i;
        }
        return i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof zzxe)) {
            return false;
        }
        zzxe zzxe = (zzxe) obj;
        if (this.count == zzxe.count) {
            int i;
            boolean z;
            int[] iArr = this.zzccg;
            int[] iArr2 = zzxe.zzccg;
            int i2 = this.count;
            for (i = 0; i < i2; i++) {
                if (iArr[i] != iArr2[i]) {
                    z = false;
                    break;
                }
            }
            z = true;
            if (z) {
                Object[] objArr = this.zzcar;
                Object[] objArr2 = zzxe.zzcar;
                i2 = this.count;
                for (i = 0; i < i2; i++) {
                    if (!objArr[i].equals(objArr2[i])) {
                        z = false;
                        break;
                    }
                }
                z = true;
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int i2 = 17;
        int i3 = 0;
        int i4 = (this.count + 527) * 31;
        int[] iArr = this.zzccg;
        int i5 = 17;
        for (i = 0; i < this.count; i++) {
            i5 = (i5 * 31) + iArr[i];
        }
        i = (i4 + i5) * 31;
        Object[] objArr = this.zzcar;
        while (i3 < this.count) {
            i2 = (i2 * 31) + objArr[i3].hashCode();
            i3++;
        }
        return i + i2;
    }

    final void zzb(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzvy.zzb(stringBuilder, i, String.valueOf(this.zzccg[i2] >>> 3), this.zzcar[i2]);
        }
    }

    final void zzb(int i, Object obj) {
        if (this.zzbtl) {
            if (this.count == this.zzccg.length) {
                int i2 = (this.count < 4 ? 8 : this.count >> 1) + this.count;
                this.zzccg = Arrays.copyOf(this.zzccg, i2);
                this.zzcar = Arrays.copyOf(this.zzcar, i2);
            }
            this.zzccg[this.count] = i;
            this.zzcar[this.count] = obj;
            this.count++;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
