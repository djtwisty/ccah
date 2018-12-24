package com.google.android.gms.internal.measurement;

import android.os.Binder;

public final /* synthetic */ class zzsc {
    public static <V> V zza(zzsd<V> zzsd) {
        V zzto;
        long clearCallingIdentity;
        try {
            zzto = zzsd.zzto();
        } catch (SecurityException e) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            zzto = zzsd.zzto();
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
        return zzto;
    }
}
