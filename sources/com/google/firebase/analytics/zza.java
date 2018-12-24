package com.google.firebase.analytics;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

final class zza implements Callable<String> {
    private final /* synthetic */ FirebaseAnalytics zzbso;

    zza(FirebaseAnalytics firebaseAnalytics) {
        this.zzbso = firebaseAnalytics;
    }

    public final /* synthetic */ Object call() {
        Object zza = this.zzbso.zzgc();
        if (zza == null) {
            zza = this.zzbso.zzada.zzgj().zzag(120000);
            if (zza == null) {
                throw new TimeoutException();
            }
            this.zzbso.zzcp(zza);
        }
        return zza;
    }
}
