package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public abstract class zzeh implements Serializable, Iterable<Byte> {
    public static final zzeh zzso = new zzer(zzfv.EMPTY_BYTE_ARRAY);
    private static final zzen zzsp = (zzee.zzex() ? new zzes() : new zzel());
    private static final Comparator<zzeh> zzsr = new zzej();
    private int zzsq = 0;

    zzeh() {
    }

    public abstract boolean equals(Object obj);

    public abstract int size();

    protected abstract String zza(Charset charset);

    abstract void zza(zzeg zzeg);

    protected abstract int zzb(int i, int i2, int i3);

    protected abstract void zzb(byte[] bArr, int i, int i2, int i3);

    protected abstract int zzc(int i, int i2, int i3);

    public abstract zzeh zzd(int i, int i2);

    public abstract boolean zzfb();

    protected abstract int zzfc();

    protected abstract boolean zzfd();

    public abstract byte zzk(int i);

    abstract byte zzl(int i);

    public zzeo zzez() {
        return new zzei(this);
    }

    private static int zza(byte b) {
        return b & 255;
    }

    public static zzeh zzb(byte[] bArr, int i, int i2) {
        zzd(i, i + i2, bArr.length);
        return new zzer(zzsp.zzc(bArr, i, i2));
    }

    static zzeh zza(byte[] bArr) {
        return new zzer(bArr);
    }

    public static zzeh zzcz(String str) {
        return new zzer(str.getBytes(zzfv.UTF_8));
    }

    public static zzeh zze(Iterable<zzeh> iterable) {
        int size = ((Collection) iterable).size();
        if (size == 0) {
            return zzso;
        }
        return zza(iterable.iterator(), size);
    }

    private static zzeh zza(Iterator<zzeh> it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(i)}));
        } else if (i == 1) {
            return (zzeh) it.next();
        } else {
            int i2 = i >>> 1;
            zzeh zza = zza(it, i2);
            zzeh zza2 = zza(it, i - i2);
            if (BaseClientBuilder.API_PRIORITY_OTHER - zza.size() >= zza2.size()) {
                return zzhs.zza(zza, zza2);
            }
            int size = zza.size();
            throw new IllegalArgumentException("ByteString would be too long: " + size + "+" + zza2.size());
        }
    }

    @Deprecated
    public final void zza(byte[] bArr, int i, int i2, int i3) {
        zzd(0, i3 + 0, size());
        zzd(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            zzb(bArr, 0, i2, i3);
        }
    }

    public final String zzfa() {
        return size() == 0 ? "" : zza(zzfv.UTF_8);
    }

    public final int hashCode() {
        int i = this.zzsq;
        if (i == 0) {
            i = size();
            i = zzc(i, 0, i);
            if (i == 0) {
                i = 1;
            }
            this.zzsq = i;
        }
        return i;
    }

    static zzep zzm(int i) {
        return new zzep(i);
    }

    protected final int zzfe() {
        return this.zzsq;
    }

    static void zze(int i, int i2) {
        if (((i2 - (i + 1)) | i) >= 0) {
            return;
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
    }

    static int zzd(int i, int i2, int i3) {
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
        return zzez();
    }
}
