package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

public abstract class zzte implements Serializable, Iterable<Byte> {
    public static final zzte zzbtq = new zzto(zzuq.zzbza);
    private static final zztk zzbtr = (zztb.zzub() ? new zztp() : new zzti());
    private static final Comparator<zzte> zzbts = new zztg();
    private int zzbsi = 0;

    zzte() {
    }

    public abstract boolean equals(Object obj);

    public abstract int size();

    protected abstract int zza(int i, int i2, int i3);

    protected abstract String zza(Charset charset);

    abstract void zza(zztd zztd);

    public abstract byte zzam(int i);

    abstract byte zzan(int i);

    public abstract zzte zzb(int i, int i2);

    public abstract boolean zzue();

    private static int zza(byte b) {
        return b & 255;
    }

    public static zzte zzb(byte[] bArr, int i, int i2) {
        zzb(i, i + i2, bArr.length);
        return new zzto(zzbtr.zzc(bArr, i, i2));
    }

    static zzte zzi(byte[] bArr) {
        return new zzto(bArr);
    }

    public static zzte zzga(String str) {
        return new zzto(str.getBytes(zzuq.UTF_8));
    }

    public final String zzud() {
        return size() == 0 ? "" : zza(zzuq.UTF_8);
    }

    public final int hashCode() {
        int i = this.zzbsi;
        if (i == 0) {
            i = size();
            i = zza(i, 0, i);
            if (i == 0) {
                i = 1;
            }
            this.zzbsi = i;
        }
        return i;
    }

    static zztm zzao(int i) {
        return new zztm(i);
    }

    protected final int zzuf() {
        return this.zzbsi;
    }

    static int zzb(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((((i | i2) | i4) | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
        }
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public /* synthetic */ Iterator iterator() {
        return new zztf(this);
    }
}
