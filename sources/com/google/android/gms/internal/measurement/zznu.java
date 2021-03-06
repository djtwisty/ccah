package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class zznu extends zzjq {
    private static final Pattern zzbmy = Pattern.compile("(.+)/(.+)/(.+)");

    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        String valueOf;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzqpArr.length >= 3);
        String zzd = zzjp.zzd(zzqpArr[0]);
        String zzd2 = zzjp.zzd(zzqpArr[1]);
        String zzd3 = zzjp.zzd(zzqpArr[2]);
        Object zzd4 = zzqpArr.length < 4 ? "AES/CBC/NoPadding" : zzjp.zzd(zzqpArr[3]);
        Matcher matcher = zzbmy.matcher(zzd4);
        if (matcher.matches()) {
            try {
                return new zzrb(zza(Cipher.getInstance(zzd4), zzd, new SecretKeySpec(zzd2.getBytes(), matcher.group(1)), new IvParameterSpec(zzd3.getBytes())));
            } catch (NoSuchAlgorithmException e) {
                zzd = "Encrypt: invalid transformation:";
                valueOf = String.valueOf(zzd4);
                throw new RuntimeException(valueOf.length() == 0 ? zzd.concat(valueOf) : new String(zzd));
            } catch (NoSuchPaddingException e2) {
                zzd = "Encrypt: invalid transformation:";
                valueOf = String.valueOf(zzd4);
                if (valueOf.length() == 0) {
                }
                throw new RuntimeException(valueOf.length() == 0 ? zzd.concat(valueOf) : new String(zzd));
            }
        }
        zzd = "Encrypt: invalid transformation:";
        valueOf = String.valueOf(zzd4);
        if (valueOf.length() != 0) {
            valueOf = zzd.concat(valueOf);
        } else {
            valueOf = new String(zzd);
        }
        throw new RuntimeException(valueOf);
    }

    private static String zza(Cipher cipher, String str, SecretKeySpec secretKeySpec, IvParameterSpec ivParameterSpec) {
        if (str == null || str.length() == 0) {
            throw new RuntimeException("Encrypt: empty input string");
        }
        try {
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return zzge.encode(cipher.doFinal(str.getBytes()));
        } catch (Exception e) {
            String str2 = "Encrypt: ";
            String valueOf = String.valueOf(e.getMessage());
            throw new RuntimeException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
    }
}
