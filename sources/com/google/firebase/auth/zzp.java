package com.google.firebase.auth;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.zzj;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.internal.InternalTokenProvider;

final /* synthetic */ class zzp implements ComponentFactory {
    static final ComponentFactory zzhh = new zzp();

    private zzp() {
    }

    public final Object create(ComponentContainer componentContainer) {
        FirebaseApp firebaseApp = (FirebaseApp) componentContainer.get(FirebaseApp.class);
        InternalTokenProvider zzj = new zzj(firebaseApp);
        firebaseApp.setTokenProvider(zzj);
        return zzj;
    }
}
