package com.google.android.gms.internal.measurement;

import android.util.Base64;
import com.google.android.gms.common.internal.Preconditions;

public final class zznt extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        int i;
        boolean z = true;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzqpArr.length > 0);
        String zzd = zzjp.zzd(zzqpArr[0]);
        Object obj = "text";
        if (zzqpArr.length > 1) {
            obj = zzjp.zzd(zzqpArr[1]);
        }
        Object obj2 = "base16";
        if (zzqpArr.length > 2) {
            obj2 = zzjp.zzd(zzqpArr[2]);
        }
        if (zzqpArr.length <= 3 || !zzjp.zza(zzqpArr[3])) {
            z = false;
        }
        if (z) {
            i = 3;
        } else {
            i = 2;
        }
        String encode;
        String str;
        try {
            byte[] bytes;
            if ("text".equals(obj)) {
                bytes = zzd.getBytes();
            } else if ("base16".equals(obj)) {
                bytes = zzge.decode(zzd);
            } else if ("base64".equals(obj)) {
                bytes = Base64.decode(zzd, i);
            } else if ("base64url".equals(obj)) {
                bytes = Base64.decode(zzd, i | 8);
            } else {
                String str2 = "Encode: unknown input format: ";
                String valueOf = String.valueOf(obj);
                throw new UnsupportedOperationException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }
            if ("base16".equals(obj2)) {
                encode = zzge.encode(bytes);
            } else if ("base64".equals(obj2)) {
                encode = Base64.encodeToString(bytes, i);
            } else if ("base64url".equals(obj2)) {
                encode = Base64.encodeToString(bytes, i | 8);
            } else {
                str = "Encode: unknown output format: ";
                encode = String.valueOf(obj2);
                throw new RuntimeException(encode.length() != 0 ? str.concat(encode) : new String(str));
            }
            return new zzrb(encode);
        } catch (IllegalArgumentException e) {
            str = "Encode: invalid input:";
            encode = String.valueOf(obj);
            throw new RuntimeException(encode.length() != 0 ? str.concat(encode) : new String(str));
        }
    }
}
