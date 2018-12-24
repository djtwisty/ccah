package com.google.android.gms.internal.measurement;

public abstract class zzyc<M extends zzyc<M>> extends zzyi {
    protected zzye zzcet;

    protected int zzf() {
        if (this.zzcet == null) {
            return 0;
        }
        int i = 0;
        int i2 = 0;
        while (i < this.zzcet.size()) {
            i++;
            i2 = this.zzcet.zzcf(i).zzf() + i2;
        }
        return i2;
    }

    public void zza(zzya zzya) {
        if (this.zzcet != null) {
            for (int i = 0; i < this.zzcet.size(); i++) {
                this.zzcet.zzcf(i).zza(zzya);
            }
        }
    }

    public final <T> T zza(zzyd<M, T> zzyd) {
        if (this.zzcet == null) {
            return null;
        }
        zzyf zzce = this.zzcet.zzce(zzyd.tag >>> 3);
        if (zzce != null) {
            return zzce.zzb(zzyd);
        }
        return null;
    }

    protected final boolean zza(zzxz zzxz, int i) {
        int position = zzxz.getPosition();
        if (!zzxz.zzaq(i)) {
            return false;
        }
        int i2 = i >>> 3;
        zzyk zzyk = new zzyk(i, zzxz.zzs(position, zzxz.getPosition() - position));
        zzyf zzyf = null;
        if (this.zzcet == null) {
            this.zzcet = new zzye();
        } else {
            zzyf = this.zzcet.zzce(i2);
        }
        if (zzyf == null) {
            zzyf = new zzyf();
            this.zzcet.zza(i2, zzyf);
        }
        zzyf.zza(zzyk);
        return true;
    }

    public final /* synthetic */ zzyi zzzb() {
        return (zzyc) clone();
    }

    public /* synthetic */ Object clone() {
        zzyc zzyc = (zzyc) super.zzzb();
        zzyg.zza(this, zzyc);
        return zzyc;
    }
}
