package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

public final class zzbm {
    private final zzbp zzaod;

    public zzbm(zzbp zzbp) {
        Preconditions.checkNotNull(zzbp);
        this.zzaod = zzbp;
    }

    public static boolean zza(Context context) {
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            ActivityInfo receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0);
            if (receiverInfo == null || !receiverInfo.enabled) {
                return false;
            }
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public final void onReceive(Context context, Intent intent) {
        zzbw zza = zzbw.zza(context, null);
        zzas zzgt = zza.zzgt();
        if (intent == null) {
            zzgt.zzjj().zzby("Receiver called with null intent");
            return;
        }
        zza.zzgw();
        String action = intent.getAction();
        zzgt.zzjo().zzg("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzgt.zzjo().zzby("Starting wakeful intent.");
            this.zzaod.doStartService(context, className);
        } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            try {
                zza.zzgs().zzc(new zzbn(this, zza, zzgt));
            } catch (Exception e) {
                zzgt.zzjj().zzg("Install Referrer Reporter encountered a problem", e);
            }
            PendingResult doGoAsync = this.zzaod.doGoAsync();
            action = intent.getStringExtra("referrer");
            if (action == null) {
                zzgt.zzjo().zzby("Install referrer extras are null");
                if (doGoAsync != null) {
                    doGoAsync.finish();
                    return;
                }
                return;
            }
            zzgt.zzjm().zzg("Install referrer extras are", action);
            if (!action.contains("?")) {
                String str = "?";
                action = String.valueOf(action);
                action = action.length() != 0 ? str.concat(action) : new String(str);
            }
            Bundle zza2 = zza.zzgr().zza(Uri.parse(action));
            if (zza2 == null) {
                zzgt.zzjo().zzby("No campaign defined in install referrer broadcast");
                if (doGoAsync != null) {
                    doGoAsync.finish();
                    return;
                }
                return;
            }
            long longExtra = 1000 * intent.getLongExtra("referrer_timestamp_seconds", 0);
            if (longExtra == 0) {
                zzgt.zzjj().zzby("Install referrer is missing timestamp");
            }
            zza.zzgs().zzc(new zzbo(this, zza, longExtra, zza2, context, zzgt, doGoAsync));
        }
    }
}
