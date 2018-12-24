package com.google.firebase.auth.api.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.firebase.FirebaseExceptionMapper;
import java.util.Collections;
import java.util.concurrent.Callable;

final class zzdo implements Callable<zzai<zzef>> {
    private final Context zzjx;
    private final zzef zzjy;

    public zzdo(zzef zzef, Context context) {
        this.zzjy = zzef;
        this.zzjx = context;
    }

    private final GoogleApi<zzef> zza(boolean z, Context context) {
        zzef zzef = (zzef) this.zzjy.clone();
        zzef.zzjt = z;
        return new zzal(context, zzed.zzmn, zzef, new FirebaseExceptionMapper());
    }

    public final /* synthetic */ Object call() {
        GoogleApi zza;
        GoogleApi googleApi = null;
        int i = 1;
        int localVersion = DynamiteModule.getLocalVersion(this.zzjx, "com.google.firebase.auth");
        if (localVersion != 0) {
            zza = zza(true, this.zzjx);
        } else {
            zza = null;
        }
        if (localVersion != 0) {
            switch (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.zzjx, 12451000)) {
                case 0:
                case 2:
                    i = DynamiteModule.getRemoteVersion(this.zzjx, "com.google.android.gms.firebase_auth");
                    break;
                default:
                    i = 0;
                    break;
            }
        }
        if (i != 0) {
            googleApi = zza(false, this.zzjx);
        }
        return new zzai(googleApi, zza, new zzak(i, localVersion, Collections.emptyMap()));
    }
}
