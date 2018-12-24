package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzw;

final class zzm implements zza, zzw {
    private final /* synthetic */ FirebaseAuth zzhc;

    zzm(FirebaseAuth firebaseAuth) {
        this.zzhc = firebaseAuth;
    }

    public final void zza(zzcz zzcz, FirebaseUser firebaseUser) {
        this.zzhc.zza(firebaseUser, zzcz, true);
    }

    public final void zza(Status status) {
        int statusCode = status.getStatusCode();
        if (statusCode == FirebaseError.ERROR_USER_NOT_FOUND || statusCode == FirebaseError.ERROR_USER_TOKEN_EXPIRED || statusCode == FirebaseError.ERROR_USER_DISABLED) {
            this.zzhc.signOut();
        }
    }
}
