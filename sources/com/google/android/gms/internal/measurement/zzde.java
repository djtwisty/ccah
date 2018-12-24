package com.google.android.gms.internal.measurement;

final class zzde extends zzat implements zzbw<zzdf> {
    private final zzdf zzach = new zzdf();

    public zzde(zzaw zzaw) {
        super(zzaw);
    }

    public final void zzb(String str, String str2) {
        this.zzach.zzaco.put(str, str2);
    }

    public final void zzc(String str, String str2) {
        if ("ga_trackingId".equals(str)) {
            this.zzach.zzaci = str2;
        } else if ("ga_sampleFrequency".equals(str)) {
            try {
                this.zzach.zzacj = Double.parseDouble(str2);
            } catch (NumberFormatException e) {
                zzc("Error parsing ga_sampleFrequency value", str2, e);
            }
        } else {
            zzd("string configuration name not recognized", str);
        }
    }

    public final void zza(String str, boolean z) {
        int i = 1;
        zzdf zzdf;
        if ("ga_autoActivityTracking".equals(str)) {
            zzdf = this.zzach;
            if (!z) {
                i = 0;
            }
            zzdf.zzacl = i;
        } else if ("ga_anonymizeIp".equals(str)) {
            zzdf = this.zzach;
            if (!z) {
                i = 0;
            }
            zzdf.zzacm = i;
        } else if ("ga_reportUncaughtExceptions".equals(str)) {
            zzdf = this.zzach;
            if (!z) {
                i = 0;
            }
            zzdf.zzacn = i;
        } else {
            zzd("bool configuration name not recognized", str);
        }
    }

    public final void zzb(String str, int i) {
        if ("ga_sessionTimeout".equals(str)) {
            this.zzach.zzack = i;
        } else {
            zzd("int configuration name not recognized", str);
        }
    }

    public final /* synthetic */ zzbu zzdv() {
        return this.zzach;
    }
}
