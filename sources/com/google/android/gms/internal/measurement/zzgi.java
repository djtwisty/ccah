package com.google.android.gms.internal.measurement;

final class zzgi implements Runnable {
    private final /* synthetic */ zzgf zzbim;

    private zzgi(zzgf zzgf) {
        this.zzbim = zzgf;
    }

    public final void run() {
        this.zzbim.state = 3;
        String zzd = this.zzbim.zzazo;
        zzhk.zzab(new StringBuilder(String.valueOf(zzd).length() + 26).append("Container ").append(zzd).append(" loading failed.").toString());
        if (this.zzbim.zzbik != null) {
            for (zzgt zzgt : this.zzbim.zzbik) {
                if (zzgt.zzqw()) {
                    try {
                        this.zzbim.zzbih.logEventInternalNoInterceptor("app", zzgt.zzqt(), zzgt.zzqu(), zzgt.currentTimeMillis());
                        zzd = zzgt.zzqt();
                        zzhk.m1082v(new StringBuilder(String.valueOf(zzd).length() + 50).append("Logged event ").append(zzd).append(" to Firebase (marked as passthrough).").toString());
                    } catch (Throwable e) {
                        zzgp.zza("Error logging event with measurement proxy:", e, this.zzbim.zzri);
                    }
                } else {
                    zzd = zzgt.zzqt();
                    zzhk.m1082v(new StringBuilder(String.valueOf(zzd).length() + 45).append("Discarded event ").append(zzd).append(" (marked as non-passthrough).").toString());
                }
            }
            this.zzbim.zzbik = null;
        }
    }
}
