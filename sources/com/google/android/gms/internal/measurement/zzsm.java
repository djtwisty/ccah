package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzsm extends zzsi<Double> {
    zzsm(zzso zzso, String str, Double d) {
        super(zzso, str, d);
    }

    private final Double zzv(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException e) {
            }
        }
        String zztr = super.zztr();
        String valueOf = String.valueOf(obj);
        Log.e("PhenotypeFlag", new StringBuilder((String.valueOf(zztr).length() + 27) + String.valueOf(valueOf).length()).append("Invalid double value for ").append(zztr).append(": ").append(valueOf).toString());
        return null;
    }

    final /* synthetic */ Object zzs(Object obj) {
        return zzv(obj);
    }
}
