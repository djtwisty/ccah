package com.google.firebase.crash;

import android.app.Application;
import android.util.Log;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.crash.zzk;
import com.google.android.gms.internal.crash.zzm;
import com.google.android.gms.internal.crash.zzo;
import com.google.firebase.FirebaseOptions;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class zzh implements Runnable {
    private final /* synthetic */ long zzaa = 10000;
    private final /* synthetic */ zzj zzab;
    private final /* synthetic */ zzf zzy;
    private final /* synthetic */ Future zzz;

    zzh(zzf zzf, Future future, long j, zzj zzj) {
        this.zzy = zzf;
        this.zzz = future;
        this.zzab = zzj;
    }

    public final void run() {
        Throwable e;
        FirebaseOptions options;
        String valueOf;
        zzm zzm = null;
        try {
            zzm = (zzm) this.zzz.get(this.zzaa, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            e = e2;
            Log.e("FirebaseCrash", "Failed to load crash reporting in time", e);
            this.zzz.cancel(true);
            if (zzm != null) {
                try {
                    options = this.zzy.zzh.getOptions();
                    zzm.zza(ObjectWrapper.wrap(this.zzy.zzf), new zzk(options.getApplicationId(), options.getApiKey()));
                    zzm.zza(new ArrayList());
                    BackgroundDetector.initialize((Application) this.zzy.zzf.getApplicationContext());
                    zzm.zza(BackgroundDetector.getInstance().isInBackground());
                    BackgroundDetector.getInstance().addListener(new zzi(this));
                    valueOf = String.valueOf(zzo.zzl());
                    Log.i("FirebaseCrash", new StringBuilder(String.valueOf(valueOf).length() + 36).append("FirebaseCrash reporting initialized ").append(valueOf).toString());
                    this.zzab.zzc(zzm);
                } catch (Throwable e3) {
                    Log.e("FirebaseCrash", "Failed to initialize crash reporting", e3);
                    CrashUtils.addDynamiteErrorToDropBox(this.zzy.zzf, e3);
                    this.zzab.zzi();
                    return;
                }
            }
            this.zzab.zzi();
            return;
        } catch (ExecutionException e4) {
            e3 = e4;
            Log.e("FirebaseCrash", "Failed to load crash reporting in time", e3);
            this.zzz.cancel(true);
            if (zzm != null) {
                this.zzab.zzi();
                return;
            }
            options = this.zzy.zzh.getOptions();
            zzm.zza(ObjectWrapper.wrap(this.zzy.zzf), new zzk(options.getApplicationId(), options.getApiKey()));
            zzm.zza(new ArrayList());
            BackgroundDetector.initialize((Application) this.zzy.zzf.getApplicationContext());
            if (BackgroundDetector.getInstance().isInBackground()) {
            }
            zzm.zza(BackgroundDetector.getInstance().isInBackground());
            BackgroundDetector.getInstance().addListener(new zzi(this));
            valueOf = String.valueOf(zzo.zzl());
            Log.i("FirebaseCrash", new StringBuilder(String.valueOf(valueOf).length() + 36).append("FirebaseCrash reporting initialized ").append(valueOf).toString());
            this.zzab.zzc(zzm);
        } catch (TimeoutException e5) {
            e3 = e5;
            Log.e("FirebaseCrash", "Failed to load crash reporting in time", e3);
            this.zzz.cancel(true);
            if (zzm != null) {
                options = this.zzy.zzh.getOptions();
                zzm.zza(ObjectWrapper.wrap(this.zzy.zzf), new zzk(options.getApplicationId(), options.getApiKey()));
                zzm.zza(new ArrayList());
                BackgroundDetector.initialize((Application) this.zzy.zzf.getApplicationContext());
                if (BackgroundDetector.getInstance().isInBackground()) {
                }
                zzm.zza(BackgroundDetector.getInstance().isInBackground());
                BackgroundDetector.getInstance().addListener(new zzi(this));
                valueOf = String.valueOf(zzo.zzl());
                Log.i("FirebaseCrash", new StringBuilder(String.valueOf(valueOf).length() + 36).append("FirebaseCrash reporting initialized ").append(valueOf).toString());
                this.zzab.zzc(zzm);
            }
            this.zzab.zzi();
            return;
        }
        if (zzm != null) {
            this.zzab.zzi();
            return;
        }
        options = this.zzy.zzh.getOptions();
        zzm.zza(ObjectWrapper.wrap(this.zzy.zzf), new zzk(options.getApplicationId(), options.getApiKey()));
        zzm.zza(new ArrayList());
        BackgroundDetector.initialize((Application) this.zzy.zzf.getApplicationContext());
        if (BackgroundDetector.getInstance().isInBackground()) {
        }
        zzm.zza(BackgroundDetector.getInstance().isInBackground());
        BackgroundDetector.getInstance().addListener(new zzi(this));
        valueOf = String.valueOf(zzo.zzl());
        Log.i("FirebaseCrash", new StringBuilder(String.valueOf(valueOf).length() + 36).append("FirebaseCrash reporting initialized ").append(valueOf).toString());
        this.zzab.zzc(zzm);
    }
}
