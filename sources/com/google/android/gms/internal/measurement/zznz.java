package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.Preconditions;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.protocol.HTTP;

public final class zznz extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        int i = 2;
        boolean z = true;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzqpArr.length > 0);
        zzqp zzqp = zzqpArr[0];
        zzqp zzqp2 = zzqpArr.length > 1 ? zzqpArr[1] : zzqv.zzbpr;
        String str = "";
        if (zzqpArr.length > 2) {
            if (zzqpArr[2] == zzqv.zzbpr) {
                str = "";
            } else {
                str = zzjp.zzd(zzqpArr[2]);
            }
        }
        String str2 = "=";
        if (zzqpArr.length > 3) {
            if (zzqpArr[3] == zzqv.zzbpr) {
                str2 = "=";
            } else {
                str2 = zzjp.zzd(zzqpArr[3]);
            }
        }
        Set set = null;
        if (zzqp2 != zzqv.zzbpr) {
            Preconditions.checkArgument(zzqp2 instanceof zzrb);
            if (ImagesContract.URL.equals(zzqp2.value())) {
                i = 1;
            } else if (!"backslash".equals(zzqp2.value())) {
                return new zzrb("");
            } else {
                Set hashSet = new HashSet();
                zza(hashSet, str);
                zza(hashSet, str2);
                hashSet.remove(Character.valueOf('\\'));
                set = hashSet;
            }
        } else {
            i = 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (zzqp instanceof zzqw) {
            for (zzqp zzqp3 : (List) ((zzqw) zzqp3).value()) {
                if (!z) {
                    stringBuilder.append(str);
                }
                zzb(stringBuilder, zzjp.zzd(zzqp3), i, set);
                z = false;
            }
        } else if (zzqp3 instanceof zzqz) {
            Map map = (Map) ((zzqz) zzqp3).value();
            boolean z2 = true;
            for (String str3 : map.keySet()) {
                if (!z2) {
                    stringBuilder.append(str);
                }
                String zzd = zzjp.zzd((zzqp) map.get(str3));
                zzb(stringBuilder, str3, i, set);
                stringBuilder.append(str2);
                zzb(stringBuilder, zzd, i, set);
                z2 = false;
            }
        } else {
            zzb(stringBuilder, zzjp.zzd(zzqp3), i, set);
        }
        return new zzrb(stringBuilder.toString());
    }

    private static void zza(Set<Character> set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    private static void zzb(StringBuilder stringBuilder, String str, int i, Set<Character> set) {
        stringBuilder.append(zzb(str, i, set));
    }

    private static String zzb(String str, int i, Set<Character> set) {
        switch (i) {
            case 1:
                try {
                    return URLEncoder.encode(str, HTTP.UTF_8).replaceAll("\\+", "%20");
                } catch (UnsupportedEncodingException e) {
                    return str;
                }
            case 2:
                String replace = str.replace("\\", "\\\\");
                String str2 = replace;
                for (Character ch : set) {
                    CharSequence ch2 = ch.toString();
                    String str3 = "\\";
                    replace = String.valueOf(ch2);
                    str2 = str2.replace(ch2, replace.length() != 0 ? str3.concat(replace) : new String(str3));
                }
                return str2;
            default:
                return str;
        }
    }
}
