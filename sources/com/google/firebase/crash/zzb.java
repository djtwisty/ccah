package com.google.firebase.crash;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;

final /* synthetic */ class zzb implements EventHandler {
    private final FirebaseCrash zzn;

    zzb(FirebaseCrash firebaseCrash) {
        this.zzn = firebaseCrash;
    }

    public final void handle(Event event) {
        this.zzn.zza(event);
    }
}
