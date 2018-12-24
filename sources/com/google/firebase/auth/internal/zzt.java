package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

final class zzt implements Runnable {
    private final String zzqt;
    final /* synthetic */ zzs zzrh;

    zzt(zzs zzs, String str) {
        this.zzrh = zzs;
        this.zzqt = Preconditions.checkNotEmpty(str);
    }

    public final void run() {
        boolean booleanValue;
        FirebaseApp instance = FirebaseApp.getInstance(this.zzqt);
        FirebaseAuth instance2 = FirebaseAuth.getInstance(instance);
        zzy.initialize(instance.getApplicationContext());
        try {
            booleanValue = ((Boolean) zzy.zzrn.get()).booleanValue();
        } catch (SecurityException e) {
            booleanValue = true;
        }
        if (instance2.getCurrentUser() != null && r0) {
            Task accessToken = instance2.getAccessToken(true);
            zzs.zzgg.m1074v("Token refreshing started", new Object[0]);
            accessToken.addOnFailureListener(new zzu(this));
        }
    }
}
