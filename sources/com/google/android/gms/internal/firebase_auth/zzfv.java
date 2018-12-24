package com.google.android.gms.internal.firebase_auth;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.apache.http.protocol.HTTP;

public final class zzfv {
    public static final byte[] EMPTY_BYTE_ARRAY;
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    static final Charset UTF_8 = Charset.forName(HTTP.UTF_8);
    private static final ByteBuffer zzxv;
    private static final zzet zzxw;

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

    public static boolean zzd(byte[] bArr) {
        return zziy.zzd(bArr);
    }

    public static String zze(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static int zzk(long j) {
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

    static boolean zzg(zzhc zzhc) {
        return false;
    }

    static Object zza(Object obj, Object obj2) {
        return ((zzhc) obj).zzhg().zzb((zzhc) obj2).zzhm();
    }

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        zzxv = ByteBuffer.wrap(bArr);
        bArr = EMPTY_BYTE_ARRAY;
        zzxw = zzet.zza(bArr, 0, bArr.length, false);
    }
}
