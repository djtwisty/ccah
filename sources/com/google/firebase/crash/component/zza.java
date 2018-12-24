package com.google.firebase.crash.component;

import com.google.firebase.FirebaseApp;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.events.Subscriber;

final /* synthetic */ class zza implements ComponentFactory {
    static final ComponentFactory zzaj = new zza();

    private zza() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new FirebaseCrash((FirebaseApp) componentContainer.get(FirebaseApp.class), (Subscriber) componentContainer.get(Subscriber.class));
    }
}
