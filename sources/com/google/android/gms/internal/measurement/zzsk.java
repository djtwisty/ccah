package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzsk extends zzsi<Integer> {
    zzsk(zzso zzso, String str, Integer num) {
        super(zzso, str, num);
    }

    private final Integer zzu(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Long) {
            return Integer.valueOf(((Long) obj).intValue());
        }
        if (obj instanceof String) {
            try {
                return Integer.valueOf(Integer.parseInt((String) obj));
            } catch (NumberFormatException e) {
            }
        }
        String zztr = super.zztr();
        String valueOf = String.valueOf(obj);
        Log.e("PhenotypeFlag", new StringBuilder((String.valueOf(zztr).length() + 24) + String.valueOf(valueOf).length()).append("Invalid int value for ").append(zztr).append(": ").append(valueOf).toString());
        return null;
    }

    final /* synthetic */ Object zzs(Object obj) {
        return zzu(obj);
    }
}
