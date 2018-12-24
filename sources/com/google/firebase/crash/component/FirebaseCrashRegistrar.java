package com.google.firebase.crash.component;

import android.support.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.events.Subscriber;
import java.util.Arrays;
import java.util.List;

@Keep
public class FirebaseCrashRegistrar implements ComponentRegistrar {
    public List<Component<?>> getComponents() {
        return Arrays.asList(new Component[]{Component.builder(FirebaseCrash.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(Subscriber.class)).add(Dependency.optional(AnalyticsConnector.class)).factory(zza.zzaj).eagerInDefaultApp().build()});
    }
}
