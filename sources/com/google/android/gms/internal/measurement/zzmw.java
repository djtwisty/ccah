package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.apache.http.protocol.HTTP;

public final class zzmw extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkArgument(true);
        try {
            return new zzrb(encode(zzjp.zzd(zzqpArr.length > 0 ? (zzqp) Preconditions.checkNotNull(zzqpArr[0]) : zzqv.zzbpr), "#;/?:@&=+$,abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_.!~*'()0123456789"));
        } catch (UnsupportedEncodingException e) {
            return zzqv.zzbpr;
        }
    }

    static String encode(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        Charset forName = Charset.forName(HTTP.UTF_8);
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (str2.indexOf(charAt) != -1) {
                stringBuilder.append((char) charAt);
                i++;
            } else {
                int i2 = 1;
                if (Character.isHighSurrogate((char) charAt)) {
                    if (i + 1 >= str.length()) {
                        throw new UnsupportedEncodingException();
                    } else if (Character.isLowSurrogate(str.charAt(i + 1))) {
                        i2 = 2;
                    } else {
                        throw new UnsupportedEncodingException();
                    }
                }
                byte[] bytes = str.substring(i, i + i2).getBytes(forName);
                for (int i3 = 0; i3 < bytes.length; i3++) {
                    stringBuilder.append("%");
                    stringBuilder.append(Character.toUpperCase(Character.forDigit((bytes[i3] >> 4) & 15, 16)));
                    stringBuilder.append(Character.toUpperCase(Character.forDigit(bytes[i3] & 15, 16)));
                }
                i += i2;
            }
        }
        return stringBuilder.toString().replaceAll(" ", "%20");
    }
}
