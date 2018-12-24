package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;

class zzto extends zztn {
    protected final byte[] zzbtx;

    zzto(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException();
        }
        this.zzbtx = bArr;
    }

    public byte zzam(int i) {
        return this.zzbtx[i];
    }

    byte zzan(int i) {
        return this.zzbtx[i];
    }

    public int size() {
        return this.zzbtx.length;
    }

    public final zzte zzb(int i, int i2) {
        int zzb = zzte.zzb(0, i2, size());
        if (zzb == 0) {
            return zzte.zzbtq;
        }
        return new zztj(this.zzbtx, zzug(), zzb);
    }

    final void zza(zztd zztd) {
        zztd.zza(this.zzbtx, zzug(), size());
    }

    protected final String zza(Charset charset) {
        return new String(this.zzbtx, zzug(), size(), charset);
    }

    public final boolean zzue() {
        int zzug = zzug();
        return zzxl.zzf(this.zzbtx, zzug, size() + zzug);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzte)) {
            return false;
        }
        if (size() != ((zzte) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzto)) {
            return obj.equals(this);
        }
        zzto zzto = (zzto) obj;
        int zzuf = zzuf();
        int zzuf2 = zzto.zzuf();
        if (zzuf == 0 || zzuf2 == 0 || zzuf == zzuf2) {
            return zza((zzto) obj, 0, size());
        }
        return false;
    }

    final boolean zza(zzte zzte, int i, int i2) {
        if (i2 > zzte.size()) {
            throw new IllegalArgumentException("Length too large: " + i2 + size());
        } else if (i2 > zzte.size()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + i2 + ", " + zzte.size());
        } else if (!(zzte instanceof zzto)) {
            return zzte.zzb(0, i2).equals(zzb(0, i2));
        } else {
            zzto zzto = (zzto) zzte;
            byte[] bArr = this.zzbtx;
            byte[] bArr2 = zzto.zzbtx;
            int zzug = zzug() + i2;
            int zzug2 = zzug();
            int zzug3 = zzto.zzug();
            while (zzug2 < zzug) {
                if (bArr[zzug2] != bArr2[zzug3]) {
                    return false;
                }
                zzug2++;
                zzug3++;
            }
            return true;
        }
    }

    protected final int zza(int i, int i2, int i3) {
        return zzuq.zza(i, this.zzbtx, zzug(), i3);
    }

    protected int zzug() {
        return 0;
    }
}
