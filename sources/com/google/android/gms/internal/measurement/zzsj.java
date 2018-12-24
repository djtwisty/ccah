package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzsj extends zzsi<Long> {
    zzsj(zzso zzso, String str, Long l) {
        super(zzso, str, l);
    }

    private final Long zzt(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException e) {
            }
        }
        String zztr = super.zztr();
        String valueOf = String.valueOf(obj);
        Log.e("PhenotypeFlag", new StringBuilder((String.valueOf(zztr).length() + 25) + String.valueOf(valueOf).length()).append("Invalid long value for ").append(zztr).append(": ").append(valueOf).toString());
        return null;
    }

    final /* synthetic */ Object zzs(Object obj) {
        return zzt(obj);
    }
}
