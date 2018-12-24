package com.google.android.gms.internal.firebase_abt;

public abstract class zzd<M extends zzd<M>> extends zzj {
    protected zzf zzs;

    public /* synthetic */ Object clone() {
        zzd zzd = (zzd) super.zzj();
        zzh.zza(this, zzd);
        return zzd;
    }

    protected final boolean zza(zza zza, int i) {
        int position = zza.getPosition();
        if (!zza.zzb(i)) {
            return false;
        }
        int i2 = i >>> 3;
        zzl zzl = new zzl(i, zza.zza(position, zza.getPosition() - position));
        zzg zzg = null;
        if (this.zzs == null) {
            this.zzs = new zzf();
        } else {
            zzg = this.zzs.zzg(i2);
        }
        if (zzg == null) {
            zzg = new zzg();
            this.zzs.zza(i2, zzg);
        }
        zzg.zza(zzl);
        return true;
    }

    public final /* synthetic */ zzj zzj() {
        return (zzd) clone();
    }
}
