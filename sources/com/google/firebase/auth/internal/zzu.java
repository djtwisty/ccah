package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.FirebaseNetworkException;

final class zzu implements OnFailureListener {
    private final /* synthetic */ zzt zzri;

    zzu(zzt zzt) {
        this.zzri = zzt;
    }

    public final void onFailure(Exception exception) {
        if (exception instanceof FirebaseNetworkException) {
            zzs.zzgg.m1074v("Failure to refresh token; scheduling refresh after failure", new Object[0]);
            this.zzri.zzrh.zzei();
        }
    }
}
