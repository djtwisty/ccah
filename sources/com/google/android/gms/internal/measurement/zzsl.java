package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzsl extends zzsi<Boolean> {
    zzsl(zzso zzso, String str, Boolean bool) {
        super(zzso, str, bool);
    }

    final /* synthetic */ Object zzs(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzru.zzbqo.matcher(str).matches()) {
                return Boolean.valueOf(true);
            }
            if (zzru.zzbqp.matcher(str).matches()) {
                return Boolean.valueOf(false);
            }
        }
        String zztr = super.zztr();
        String valueOf = String.valueOf(obj);
        Log.e("PhenotypeFlag", new StringBuilder((String.valueOf(zztr).length() + 28) + String.valueOf(valueOf).length()).append("Invalid boolean value for ").append(zztr).append(": ").append(valueOf).toString());
        return null;
    }
}
