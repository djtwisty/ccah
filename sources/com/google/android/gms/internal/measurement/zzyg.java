package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.Arrays;
import org.apache.http.protocol.HTTP;

public final class zzyg {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    protected static final Charset UTF_8 = Charset.forName(HTTP.UTF_8);
    public static final Object zzcfc = new Object();

    public static boolean equals(int[] iArr, int[] iArr2) {
        if (iArr == null || iArr.length == 0) {
            return iArr2 == null || iArr2.length == 0;
        } else {
            return Arrays.equals(iArr, iArr2);
        }
    }

    public static boolean equals(long[] jArr, long[] jArr2) {
        if (jArr == null || jArr.length == 0) {
            return jArr2 == null || jArr2.length == 0;
        } else {
            return Arrays.equals(jArr, jArr2);
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

    public static int hashCode(int[] iArr) {
        return (iArr == null || iArr.length == 0) ? 0 : Arrays.hashCode(iArr);
    }

    public static int hashCode(long[] jArr) {
        return (jArr == null || jArr.length == 0) ? 0 : Arrays.hashCode(jArr);
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

    public static void zza(zzyc zzyc, zzyc zzyc2) {
        if (zzyc.zzcet != null) {
            zzyc2.zzcet = (zzye) zzyc.zzcet.clone();
        }
    }
}
