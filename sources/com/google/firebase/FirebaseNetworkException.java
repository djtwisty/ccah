package com.google.firebase;

import com.google.firebase.annotations.PublicApi;

@PublicApi
public class FirebaseNetworkException extends FirebaseException {
    @PublicApi
    public FirebaseNetworkException(String str) {
        super(str);
    }
}
