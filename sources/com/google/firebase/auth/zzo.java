package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.internal.zzv;

final class zzo implements zzv {
    private final /* synthetic */ FirebaseAuth zzhc;
    private final /* synthetic */ FirebaseUser zzhg;

    zzo(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        this.zzhc = firebaseAuth;
        this.zzhg = firebaseUser;
    }

    public final void zzcd() {
        if (this.zzhc.zzgr.getUid().equalsIgnoreCase(this.zzhg.getUid())) {
            this.zzhc.zzca();
        }
    }

    public final void zza(Status status) {
        if (status.getStatusCode() == FirebaseError.ERROR_USER_NOT_FOUND || status.getStatusCode() == FirebaseError.ERROR_USER_TOKEN_EXPIRED || status.getStatusCode() == FirebaseError.ERROR_USER_DISABLED) {
            this.zzhc.signOut();
        }
    }
}
