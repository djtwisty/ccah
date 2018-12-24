package com.google.android.gms.internal.config;

import java.nio.charset.Charset;
import java.util.Arrays;
import org.apache.http.protocol.HTTP;

public final class zzbf {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    protected static final Charset UTF_8 = Charset.forName(HTTP.UTF_8);
    public static final Object zzcp = new Object();

    public static boolean zza(byte[][] bArr, byte[][] bArr2) {
        boolean length = bArr == null ? false : bArr.length;
        int length2 = bArr2 == null ? 0 : bArr2.length;
        int i = 0;
        boolean z = false;
        while (true) {
            if (z >= length || bArr[z] != null) {
                boolean z2;
                int i2 = i;
                while (i2 < length2 && bArr2[i2] == null) {
                    i2++;
                }
                boolean z3 = z >= length;
                if (i2 >= length2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z3 && z2) {
                    return true;
                }
                if (z3 != z2 || !Arrays.equals(bArr[z], bArr2[i2])) {
                    return false;
                }
                i = i2 + 1;
                z++;
            } else {
                z++;
            }
        }
    }

    public static boolean equals(Object[] objArr, Object[] objArr2) {
        boolean length = objArr == null ? false : objArr.length;
        int length2 = objArr2 == null ? 0 : objArr2.length;
        int i = 0;
        boolean z = false;
        while (true) {
            if (z >= length || objArr[z] != null) {
                boolean z2;
                int i2 = i;
                while (i2 < length2 && objArr2[i2] == null) {
                    i2++;
                }
                boolean z3 = z >= length;
                if (i2 >= length2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z3 && z2) {
                    return true;
                }
                if (z3 != z2 || !objArr[z].equals(objArr2[i2])) {
                    return false;
                }
                i = i2 + 1;
                z++;
            } else {
                z++;
            }
        }
    }

    public static int zza(byte[][] bArr) {
        int length = bArr == null ? 0 : bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int hashCode;
            byte[] bArr2 = bArr[i];
            if (bArr2 != null) {
                hashCode = Arrays.hashCode(bArr2) + (i2 * 31);
            } else {
                hashCode = i2;
            }
            i++;
            i2 = hashCode;
        }
        return i2;
    }

    public static int hashCode(Object[] objArr) {
        int length = objArr == null ? 0 : objArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int hashCode;
            Object obj = objArr[i];
            if (obj != null) {
                hashCode = obj.hashCode() + (i2 * 31);
            } else {
                hashCode = i2;
            }
            i++;
            i2 = hashCode;
        }
        return i2;
    }

    public static void zza(zzbb zzbb, zzbb zzbb2) {
        if (zzbb.zzch != null) {
            zzbb2.zzch = (zzbd) zzbb.zzch.clone();
        }
    }
}
