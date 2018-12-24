package com.google.firebase.auth.api.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;

public final class zzfa {
    private final String packageName;
    private final String zzof;

    public zzfa(Context context) {
        this(context, context.getPackageName());
    }

    private zzfa(Context context, String str) {
        Preconditions.checkNotNull(context);
        this.packageName = Preconditions.checkNotEmpty(str);
        String str2;
        String str3;
        String valueOf;
        try {
            byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context, this.packageName);
            if (packageCertificateHashBytes == null) {
                str2 = "FBA-PackageInfo";
                str3 = "single cert required: ";
                valueOf = String.valueOf(str);
                Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                this.zzof = null;
                return;
            }
            this.zzof = Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
        } catch (NameNotFoundException e) {
            str2 = "FBA-PackageInfo";
            str3 = "no pkg: ";
            valueOf = String.valueOf(str);
            Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            this.zzof = null;
        }
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String zzdq() {
        return this.zzof;
    }
}
