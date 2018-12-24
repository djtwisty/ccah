package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.apache.http.protocol.HTTP;

public final class zzuq {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    static final Charset UTF_8 = Charset.forName(HTTP.UTF_8);
    public static final byte[] zzbza;
    private static final ByteBuffer zzbzb;
    private static final zztq zzbzc;

    static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    static <T> T zza(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean zzl(byte[] bArr) {
        return zzxl.zzl(bArr);
    }

    public static String zzm(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static int zzbd(long j) {
        return (int) ((j >>> 32) ^ j);
    }

    public static int zzu(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        length = zza(length, bArr, 0, length);
        if (length == 0) {
            return 1;
        }
        return length;
    }

    static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static boolean zzf(zzvv zzvv) {
        return false;
    }

    static Object zzb(Object obj, Object obj2) {
        return ((zzvv) obj).zzwh().zza((zzvv) obj2).zzwn();
    }

    static {
        byte[] bArr = new byte[0];
        zzbza = bArr;
        zzbzb = ByteBuffer.wrap(bArr);
        bArr = zzbza;
        zzbzc = zztq.zza(bArr, 0, bArr.length, false);
    }
}
