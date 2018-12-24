package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft.zze;
import java.util.Arrays;

public final class zzir {
    private static final zzir zzabp = new zzir(0, new int[0], new Object[0], false);
    private int count;
    private int[] zzabq;
    private boolean zzsh;
    private int zzwz;
    private Object[] zzzm;

    public static zzir zzjp() {
        return zzabp;
    }

    static zzir zzjq() {
        return new zzir();
    }

    static zzir zza(zzir zzir, zzir zzir2) {
        int i = zzir.count + zzir2.count;
        Object copyOf = Arrays.copyOf(zzir.zzabq, i);
        System.arraycopy(zzir2.zzabq, 0, copyOf, zzir.count, zzir2.count);
        Object copyOf2 = Arrays.copyOf(zzir.zzzm, i);
        System.arraycopy(zzir2.zzzm, 0, copyOf2, zzir.count, zzir2.count);
        return new zzir(i, copyOf, copyOf2, true);
    }

    private zzir() {
        this(0, new int[8], new Object[8], true);
    }

    private zzir(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzwz = -1;
        this.count = i;
        this.zzabq = iArr;
        this.zzzm = objArr;
        this.zzsh = z;
    }

    public final void zzev() {
        this.zzsh = false;
    }

    final void zza(zzjl zzjl) {
        int i;
        if (zzjl.zzgl() == zze.zzxr) {
            for (i = this.count - 1; i >= 0; i--) {
                zzjl.zza(this.zzabq[i] >>> 3, this.zzzm[i]);
            }
            return;
        }
        for (i = 0; i < this.count; i++) {
            zzjl.zza(this.zzabq[i] >>> 3, this.zzzm[i]);
        }
    }

    public final void zzb(zzjl zzjl) {
        if (this.count != 0) {
            int i;
            if (zzjl.zzgl() == zze.zzxq) {
                for (i = 0; i < this.count; i++) {
                    zzb(this.zzabq[i], this.zzzm[i], zzjl);
                }
                return;
            }
            for (i = this.count - 1; i >= 0; i--) {
                zzb(this.zzabq[i], this.zzzm[i], zzjl);
            }
        }
    }

    private static void zzb(int i, Object obj, zzjl zzjl) {
        int i2 = i >>> 3;
        switch (i & 7) {
            case 0:
                zzjl.zzi(i2, ((Long) obj).longValue());
                return;
            case 1:
                zzjl.zzc(i2, ((Long) obj).longValue());
                return;
            case 2:
                zzjl.zza(i2, (zzeh) obj);
                return;
            case 3:
                if (zzjl.zzgl() == zze.zzxq) {
                    zzjl.zzap(i2);
                    ((zzir) obj).zzb(zzjl);
                    zzjl.zzaq(i2);
                    return;
                }
                zzjl.zzaq(i2);
                ((zzir) obj).zzb(zzjl);
                zzjl.zzap(i2);
                return;
            case 5:
                zzjl.zzj(i2, ((Integer) obj).intValue());
                return;
            default:
                throw new RuntimeException(zzgc.zzhv());
        }
    }

    public final int zzjr() {
        int i = this.zzwz;
        if (i == -1) {
            i = 0;
            for (int i2 = 0; i2 < this.count; i2++) {
                i += zzfa.zzd(this.zzabq[i2] >>> 3, (zzeh) this.zzzm[i2]);
            }
            this.zzwz = i;
        }
        return i;
    }

    public final int zzgw() {
        int i = this.zzwz;
        if (i == -1) {
            i = 0;
            for (int i2 = 0; i2 < this.count; i2++) {
                int i3 = this.zzabq[i2];
                int i4 = i3 >>> 3;
                switch (i3 & 7) {
                    case 0:
                        i += zzfa.zze(i4, ((Long) this.zzzm[i2]).longValue());
                        break;
                    case 1:
                        i += zzfa.zzg(i4, ((Long) this.zzzm[i2]).longValue());
                        break;
                    case 2:
                        i += zzfa.zzc(i4, (zzeh) this.zzzm[i2]);
                        break;
                    case 3:
                        i += ((zzir) this.zzzm[i2]).zzgw() + (zzfa.zzag(i4) << 1);
                        break;
                    case 5:
                        i += zzfa.zzn(i4, ((Integer) this.zzzm[i2]).intValue());
                        break;
                    default:
                        throw new IllegalStateException(zzgc.zzhv());
                }
            }
            this.zzwz = i;
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
        if (!(obj instanceof zzir)) {
            return false;
        }
        zzir zzir = (zzir) obj;
        if (this.count == zzir.count) {
            int i;
            boolean z;
            int[] iArr = this.zzabq;
            int[] iArr2 = zzir.zzabq;
            int i2 = this.count;
            for (i = 0; i < i2; i++) {
                if (iArr[i] != iArr2[i]) {
                    z = false;
                    break;
                }
            }
            z = true;
            if (z) {
                Object[] objArr = this.zzzm;
                Object[] objArr2 = zzir.zzzm;
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
        int[] iArr = this.zzabq;
        int i5 = 17;
        for (i = 0; i < this.count; i++) {
            i5 = (i5 * 31) + iArr[i];
        }
        i = (i4 + i5) * 31;
        Object[] objArr = this.zzzm;
        while (i3 < this.count) {
            i2 = (i2 * 31) + objArr[i3].hashCode();
            i3++;
        }
        return i + i2;
    }

    final void zza(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzhf.zza(stringBuilder, i, String.valueOf(this.zzabq[i2] >>> 3), this.zzzm[i2]);
        }
    }

    final void zzb(int i, Object obj) {
        if (this.zzsh) {
            if (this.count == this.zzabq.length) {
                int i2 = (this.count < 4 ? 8 : this.count >> 1) + this.count;
                this.zzabq = Arrays.copyOf(this.zzabq, i2);
                this.zzzm = Arrays.copyOf(this.zzzm, i2);
            }
            this.zzabq[this.count] = i;
            this.zzzm[this.count] = obj;
            this.count++;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
