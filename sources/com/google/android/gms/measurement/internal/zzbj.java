package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzu;
import java.util.List;

public final class zzbj {
    final zzbw zzada;

    zzbj(zzbw zzbw) {
        this.zzada = zzbw;
    }

    protected final void zzce(String str) {
        if (str == null || str.isEmpty()) {
            this.zzada.zzgt().zzjm().zzby("Install Referrer Reporter was called with invalid app package name");
            return;
        }
        this.zzada.zzgs().zzaf();
        if (zzke()) {
            this.zzada.zzgt().zzjm().zzby("Install Referrer Reporter is initializing");
            ServiceConnection zzbk = new zzbk(this, str);
            this.zzada.zzgs().zzaf();
            Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
            intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
            PackageManager packageManager = this.zzada.getContext().getPackageManager();
            if (packageManager == null) {
                this.zzada.zzgt().zzjj().zzby("Failed to obtain Package Manager to verify binding conditions");
                return;
            }
            List queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                this.zzada.zzgt().zzjm().zzby("Play Service for fetching Install Referrer is unavailable on device");
                return;
            }
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentServices.get(0);
            if (resolveInfo.serviceInfo != null) {
                String str2 = resolveInfo.serviceInfo.packageName;
                if (resolveInfo.serviceInfo.name != null && "com.android.vending".equals(str2) && zzke()) {
                    try {
                        this.zzada.zzgt().zzjm().zzg("Install Referrer Service is", ConnectionTracker.getInstance().bindService(this.zzada.getContext(), new Intent(intent), zzbk, 1) ? "available" : "not available");
                        return;
                    } catch (Exception e) {
                        this.zzada.zzgt().zzjg().zzg("Exception occurred while binding to Install Referrer Service", e.getMessage());
                        return;
                    }
                }
                this.zzada.zzgt().zzjm().zzby("Play Store missing or incompatible. Version 8.3.73 or later required");
                return;
            }
            return;
        }
        this.zzada.zzgt().zzjm().zzby("Install Referrer Reporter is not available");
    }

    @VisibleForTesting
    private final boolean zzke() {
        try {
            PackageManagerWrapper packageManager = Wrappers.packageManager(this.zzada.getContext());
            if (packageManager == null) {
                this.zzada.zzgt().zzjm().zzby("Failed to retrieve Package Manager to check Play Store compatibility");
                return false;
            } else if (packageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            this.zzada.zzgt().zzjm().zzg("Failed to retrieve Play Store version", e);
            return false;
        }
    }

    @VisibleForTesting
    final Bundle zza(String str, zzu zzu) {
        this.zzada.zzgs().zzaf();
        if (zzu == null) {
            this.zzada.zzgt().zzjj().zzby("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            bundle = zzu.zza(bundle);
            if (bundle != null) {
                return bundle;
            }
            this.zzada.zzgt().zzjg().zzby("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e) {
            this.zzada.zzgt().zzjg().zzg("Exception occurred while retrieving the Install Referrer", e.getMessage());
            return null;
        }
    }
}
