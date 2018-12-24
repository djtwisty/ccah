package com.google.firebase.crash;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.internal.crash.zzm;
import com.google.android.gms.internal.crash.zzo;
import com.google.android.gms.internal.crash.zzp;
import com.google.android.gms.internal.crash.zzs;
import com.google.firebase.FirebaseApp;

public final class zzf {
    private final Context zzf;
    private final FirebaseApp zzh;

    zzf(FirebaseApp firebaseApp) {
        this.zzf = firebaseApp.getApplicationContext();
        this.zzh = firebaseApp;
    }

    public final zzm zzj() {
        Throwable th;
        zzs.initialize(this.zzf);
        if (((Boolean) zzs.zzap.get()).booleanValue()) {
            zzm zzm;
            try {
                zzo.zzl().init(this.zzf);
                zzm = zzo.zzl().zzm();
                try {
                    String valueOf = String.valueOf(zzo.zzl());
                    Log.i("FirebaseCrash", new StringBuilder(String.valueOf(valueOf).length() + 33).append("FirebaseCrash reporting loaded - ").append(valueOf).toString());
                    return zzm;
                } catch (Throwable e) {
                    th = e;
                }
            } catch (zzp e2) {
                th = e2;
                zzm = null;
                Log.e("FirebaseCrash", "Failed to load crash reporting", th);
                CrashUtils.addDynamiteErrorToDropBox(this.zzf, th);
                return zzm;
            }
        }
        Log.w("FirebaseCrash", "Crash reporting is disabled");
        return null;
    }
}
