package com.google.android.gms.internal.firebase_auth;

import java.nio.charset.Charset;

class zzer extends zzeq {
    protected final byte[] zzsw;

    zzer(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException();
        }
        this.zzsw = bArr;
    }

    public byte zzk(int i) {
        return this.zzsw[i];
    }

    byte zzl(int i) {
        return this.zzsw[i];
    }

    public int size() {
        return this.zzsw.length;
    }

    public final zzeh zzd(int i, int i2) {
        int zzd = zzeh.zzd(i, i2, size());
        if (zzd == 0) {
            return zzeh.zzso;
        }
        return new zzem(this.zzsw, zzff() + i, zzd);
    }

    protected void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzsw, i, bArr, i2, i3);
    }

    final void zza(zzeg zzeg) {
        zzeg.zza(this.zzsw, zzff(), size());
    }

    protected final String zza(Charset charset) {
        return new String(this.zzsw, zzff(), size(), charset);
    }

    public final boolean zzfb() {
        int zzff = zzff();
        return zziy.zze(this.zzsw, zzff, size() + zzff);
    }

    protected final int zzb(int i, int i2, int i3) {
        int zzff = zzff() + i2;
        return zziy.zzb(i, this.zzsw, zzff, zzff + i3);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeh)) {
            return false;
        }
        if (size() != ((zzeh) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzer)) {
            return obj.equals(this);
        }
        zzer zzer = (zzer) obj;
        int zzfe = zzfe();
        int zzfe2 = zzer.zzfe();
        if (zzfe == 0 || zzfe2 == 0 || zzfe == zzfe2) {
            return zza((zzer) obj, 0, size());
        }
        return false;
    }

    final boolean zza(zzeh zzeh, int i, int i2) {
        if (i2 > zzeh.size()) {
            throw new IllegalArgumentException("Length too large: " + i2 + size());
        } else if (i + i2 > zzeh.size()) {
            throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + zzeh.size());
        } else if (!(zzeh instanceof zzer)) {
            return zzeh.zzd(i, i + i2).equals(zzd(0, i2));
        } else {
            zzer zzer = (zzer) zzeh;
            byte[] bArr = this.zzsw;
            byte[] bArr2 = zzer.zzsw;
            int zzff = zzff() + i2;
            int zzff2 = zzff();
            int zzff3 = zzer.zzff() + i;
            while (zzff2 < zzff) {
                if (bArr[zzff2] != bArr2[zzff3]) {
                    return false;
                }
                zzff2++;
                zzff3++;
            }
            return true;
        }
    }

    protected final int zzc(int i, int i2, int i3) {
        return zzfv.zza(i, this.zzsw, zzff() + i2, i3);
    }

    protected int zzff() {
        return 0;
    }
}
