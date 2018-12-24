package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.security.MessageDigest;

public final class zznx extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzqpArr.length > 0);
        if (zzqpArr[0] == zzqv.zzbpr) {
            return zzqv.zzbpr;
        }
        byte[] bytes;
        String zzd = zzjp.zzd(zzqpArr[0]);
        String str = "MD5";
        if (zzqpArr.length > 1) {
            if (zzqpArr[1] == zzqv.zzbpr) {
                str = "MD5";
            } else {
                str = zzjp.zzd(zzqpArr[1]);
            }
        }
        Object obj = "text";
        if (zzqpArr.length > 2) {
            if (zzqpArr[2] == zzqv.zzbpr) {
                obj = "text";
            } else {
                obj = zzjp.zzd(zzqpArr[2]);
            }
        }
        if ("text".equals(obj)) {
            bytes = zzd.getBytes();
        } else if ("base16".equals(obj)) {
            bytes = zzge.decode(zzd);
        } else {
            String str2 = "Hash: Unknown input format: ";
            str = String.valueOf(obj);
            throw new RuntimeException(str.length() != 0 ? str2.concat(str) : new String(str2));
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bytes);
            return new zzrb(zzge.encode(instance.digest()));
        } catch (Throwable e) {
            str2 = "Hash: Unknown algorithm: ";
            str = String.valueOf(str);
            throw new RuntimeException(str.length() != 0 ? str2.concat(str) : new String(str2), e);
        }
    }
}
