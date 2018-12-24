package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo.zze;

final class zzun implements zzvu {
    private static final zzun zzbyc = new zzun();

    private zzun() {
    }

    public static zzun zzwe() {
        return zzbyc;
    }

    public final boolean zze(Class<?> cls) {
        return zzuo.class.isAssignableFrom(cls);
    }

    public final zzvt zzf(Class<?> cls) {
        if (zzuo.class.isAssignableFrom(cls)) {
            try {
                return (zzvt) zzuo.zzg(cls.asSubclass(zzuo.class)).zza(zze.zzbym, null, null);
            } catch (Throwable e) {
                Throwable th = e;
                String str = "Unable to get message info for ";
                String valueOf = String.valueOf(cls.getName());
                throw new RuntimeException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
            }
        }
        String str2 = "Unsupported message type: ";
        valueOf = String.valueOf(cls.getName());
        throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }
}
