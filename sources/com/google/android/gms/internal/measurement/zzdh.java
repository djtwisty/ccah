package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import java.util.Locale;

public final class zzdh extends zzau {
    private String zzaaq;
    private String zzaar;
    protected int zzaat;
    private int zzacq;
    protected boolean zzacr;
    private boolean zzacs;
    private boolean zzact;

    public zzdh(zzaw zzaw) {
        super(zzaw);
    }

    protected final void zzag() {
        ApplicationInfo applicationInfo;
        Context context = getContext();
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (NameNotFoundException e) {
            zzd("PackageManager doesn't know about the app package", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            zzt("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null) {
            int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
            if (i > 0) {
                zzcj zzcj = (zzcj) new zzch(zzbw()).zzq(i);
                if (zzcj != null) {
                    String str;
                    boolean z;
                    int i2;
                    zzq("Loading global XML config values");
                    if (zzcj.zzaaq != null) {
                        str = zzcj.zzaaq;
                        this.zzaaq = str;
                        zzb("XML config - app name", str);
                    }
                    if (zzcj.zzaar != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        str = zzcj.zzaar;
                        this.zzaar = str;
                        zzb("XML config - app version", str);
                    }
                    if (zzcj.zzaas != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        str = zzcj.zzaas.toLowerCase(Locale.US);
                        i2 = "verbose".equals(str) ? 0 : "info".equals(str) ? 1 : "warning".equals(str) ? 2 : "error".equals(str) ? 3 : -1;
                        if (i2 >= 0) {
                            this.zzacq = i2;
                            zza("XML config - log level", Integer.valueOf(i2));
                        }
                    }
                    if (zzcj.zzaat >= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        i2 = zzcj.zzaat;
                        this.zzaat = i2;
                        this.zzacr = true;
                        zzb("XML config - dispatch period (sec)", Integer.valueOf(i2));
                    }
                    if (zzcj.zzaau != -1) {
                        boolean z2 = zzcj.zzaau == 1;
                        this.zzact = z2;
                        this.zzacs = true;
                        zzb("XML config - dry run", Boolean.valueOf(z2));
                    }
                }
            }
        }
    }

    public final String zzak() {
        zzcl();
        return this.zzaar;
    }

    public final String zzaj() {
        zzcl();
        return this.zzaaq;
    }

    public final boolean zzfr() {
        zzcl();
        return false;
    }

    public final boolean zzfs() {
        zzcl();
        return this.zzacs;
    }

    public final boolean zzft() {
        zzcl();
        return this.zzact;
    }
}
