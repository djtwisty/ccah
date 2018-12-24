package com.google.android.gms.internal.firebase_auth;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzw {
    public static String zza(@NullableDecl String str, @NullableDecl Object... objArr) {
        int i;
        CharSequence valueOf = String.valueOf(str);
        for (i = 0; i < objArr.length; i++) {
            objArr[i] = zza(objArr[i]);
        }
        StringBuilder stringBuilder = new StringBuilder(valueOf.length() + (objArr.length * 16));
        i = 0;
        int i2 = 0;
        while (i < objArr.length) {
            int indexOf = valueOf.indexOf("%s", i2);
            if (indexOf == -1) {
                break;
            }
            stringBuilder.append(valueOf, i2, indexOf);
            int i3 = i + 1;
            stringBuilder.append(objArr[i]);
            i2 = indexOf + 2;
            i = i3;
        }
        stringBuilder.append(valueOf, i2, valueOf.length());
        if (i < objArr.length) {
            stringBuilder.append(" [");
            i3 = i + 1;
            stringBuilder.append(objArr[i]);
            i = i3;
            while (i < objArr.length) {
                stringBuilder.append(", ");
                i3 = i + 1;
                stringBuilder.append(objArr[i]);
                i = i3;
            }
            stringBuilder.append(']');
        }
        return stringBuilder.toString();
    }

    private static String zza(@NullableDecl Object obj) {
        try {
            return String.valueOf(obj);
        } catch (Throwable e) {
            String name = obj.getClass().getName();
            String toHexString = Integer.toHexString(System.identityHashCode(obj));
            String stringBuilder = new StringBuilder((String.valueOf(name).length() + 1) + String.valueOf(toHexString).length()).append(name).append('@').append(toHexString).toString();
            Logger logger = Logger.getLogger("com.google.common.base.Strings");
            Level level = Level.WARNING;
            String str = "com.google.common.base.Strings";
            String str2 = "lenientToString";
            String str3 = "Exception during lenientFormat for ";
            String valueOf = String.valueOf(stringBuilder);
            logger.logp(level, str, str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), e);
            name = e.getClass().getName();
            return new StringBuilder((String.valueOf(stringBuilder).length() + 9) + String.valueOf(name).length()).append("<").append(stringBuilder).append(" threw ").append(name).append(">").toString();
        }
    }
}
