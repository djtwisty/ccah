package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.apache.http.protocol.HTTP;

public final class zzmu extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkArgument(true);
        try {
            return new zzrb(decode(zzjp.zzd(zzqpArr.length > 0 ? (zzqp) Preconditions.checkNotNull(zzqpArr[0]) : zzqv.zzbpr), "#;/?:@&=+$,"));
        } catch (UnsupportedEncodingException e) {
            return zzqv.zzbpr;
        }
    }

    static String decode(String str, String str2) {
        Charset forName = Charset.forName(HTTP.UTF_8);
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt != '%') {
                stringBuilder.append((char) charAt);
                i++;
            } else {
                byte zzc = zzc(str, i);
                int i2 = i + 3;
                if ((zzc & 128) != 0) {
                    int i3 = 0;
                    while (((zzc << i3) & 128) != 0) {
                        i3++;
                    }
                    if (i3 < 2 || i3 > 4) {
                        throw new UnsupportedEncodingException();
                    }
                    byte[] bArr = new byte[i3];
                    bArr[0] = zzc;
                    for (int i4 = 1; i4 < i3; i4++) {
                        zzc = zzc(str, i2);
                        i2 += 3;
                        if ((zzc & 192) != 128) {
                            throw new UnsupportedEncodingException();
                        }
                        bArr[i4] = zzc;
                    }
                    CharSequence decode = forName.decode(ByteBuffer.wrap(bArr));
                    if (decode.length() != 1 || str2.indexOf(decode.charAt(0)) == -1) {
                        stringBuilder.append(decode);
                        i = i2;
                    } else {
                        stringBuilder.append(str.substring(i, i2));
                        i = i2;
                    }
                } else if (str2.indexOf(zzc) == -1) {
                    stringBuilder.append((char) zzc);
                    i = i2;
                } else {
                    stringBuilder.append(str.substring(i2 - 3, i2));
                    i = i2;
                }
            }
        }
        return stringBuilder.toString();
    }

    private static byte zzc(String str, int i) {
        if (i + 3 > str.length() || str.charAt(i) != '%') {
            throw new UnsupportedEncodingException();
        }
        String substring = str.substring(i + 1, i + 3);
        if (substring.charAt(0) == '+' || substring.charAt(0) == '-') {
            throw new UnsupportedEncodingException();
        }
        try {
            return (byte) Integer.parseInt(substring, 16);
        } catch (NumberFormatException e) {
            throw new UnsupportedEncodingException();
        }
    }
}
