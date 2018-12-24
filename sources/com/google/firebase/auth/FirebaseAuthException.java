package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseException;
import com.google.firebase.annotations.PublicApi;

@PublicApi
public class FirebaseAuthException extends FirebaseException {
    private final String zza;

    @PublicApi
    public FirebaseAuthException(String str, String str2) {
        super(str2);
        this.zza = Preconditions.checkNotEmpty(str);
    }

    @PublicApi
    public String getErrorCode() {
        return this.zza;
    }
}
