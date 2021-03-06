package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

@TargetApi(14)
final class zzdu implements ActivityLifecycleCallbacks {
    private final /* synthetic */ zzda zzare;

    private zzdu(zzda zzda) {
        this.zzare = zzda;
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Object obj = 1;
        try {
            this.zzare.zzgt().zzjo().zzby("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data != null && data.isHierarchical()) {
                    if (bundle == null) {
                        String str;
                        Bundle zza = this.zzare.zzgr().zza(data);
                        this.zzare.zzgr();
                        if (zzfy.zzc(intent)) {
                            str = "gs";
                        } else {
                            str = "auto";
                        }
                        if (zza != null) {
                            this.zzare.logEvent(str, "_cmp", zza);
                        }
                    }
                    Object queryParameter = data.getQueryParameter("referrer");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        if (!(queryParameter.contains("gclid") && (queryParameter.contains("utm_campaign") || queryParameter.contains("utm_source") || queryParameter.contains("utm_medium") || queryParameter.contains("utm_term") || queryParameter.contains("utm_content")))) {
                            obj = null;
                        }
                        if (obj == null) {
                            this.zzare.zzgt().zzjn().zzby("Activity created with data 'referrer' param without gclid and at least one utm field");
                            return;
                        }
                        this.zzare.zzgt().zzjn().zzg("Activity created with referrer", queryParameter);
                        if (!TextUtils.isEmpty(queryParameter)) {
                            this.zzare.zzb("auto", "_ldl", queryParameter, true);
                        }
                    } else {
                        return;
                    }
                }
            }
        } catch (Exception e) {
            this.zzare.zzgt().zzjg().zzg("Throwable caught in onActivityCreated", e);
        }
        this.zzare.zzgm().onActivityCreated(activity, bundle);
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zzare.zzgm().onActivityDestroyed(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.zzare.zzgm().onActivityPaused(activity);
        zzcr zzgo = this.zzare.zzgo();
        zzgo.zzgs().zzc(new zzfi(zzgo, zzgo.zzbx().elapsedRealtime()));
    }

    public final void onActivityResumed(Activity activity) {
        this.zzare.zzgm().onActivityResumed(activity);
        zzcr zzgo = this.zzare.zzgo();
        zzgo.zzgs().zzc(new zzfh(zzgo, zzgo.zzbx().elapsedRealtime()));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zzare.zzgm().onActivitySaveInstanceState(activity, bundle);
    }
}
