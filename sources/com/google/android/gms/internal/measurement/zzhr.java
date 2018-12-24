package com.google.android.gms.internal.measurement;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class zzhr implements OnClickListener {
    private final /* synthetic */ zzhq zzbjy;

    zzhr(zzhq zzhq) {
        this.zzbjy = zzhq;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String packageName = this.zzbjy.zzbjw.getPackageName();
        Intent launchIntentForPackage = this.zzbjy.zzbjw.getPackageManager().getLaunchIntentForPackage(packageName);
        if (launchIntentForPackage != null) {
            String str = "Invoke the launch activity for package name: ";
            packageName = String.valueOf(packageName);
            zzhk.zzdm(packageName.length() != 0 ? str.concat(packageName) : new String(str));
            this.zzbjy.zzbjw.startActivity(launchIntentForPackage);
            return;
        }
        String str2 = "No launch activity found for package name: ";
        packageName = String.valueOf(packageName);
        zzhk.zzab(packageName.length() != 0 ? str2.concat(packageName) : new String(str2));
    }
}
