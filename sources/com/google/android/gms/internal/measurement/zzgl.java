package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

final class zzgl implements zzpe, Runnable {
    private final /* synthetic */ zzgf zzbim;

    private zzgl(zzgf zzgf) {
        this.zzbim = zzgf;
    }

    public final void run() {
        Preconditions.checkState(this.zzbim.state == 2);
        if (!zzhs.zzrf().zzem(this.zzbim.zzazo)) {
            String zzd = this.zzbim.zzazo;
            zzhk.m1082v(new StringBuilder(String.valueOf(zzd).length() + 24).append("Refreshing container ").append(zzd).append("...").toString());
            List arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(0));
            this.zzbim.zzbie.zza(this.zzbim.zzazo, this.zzbim.zzbic, this.zzbim.zzbib, arrayList, this, this.zzbim.zzbii);
        }
    }

    public final void zza(zzpm zzpm) {
        if (zzpm.getStatus() == Status.RESULT_SUCCESS) {
            String zzd = this.zzbim.zzazo;
            zzhk.m1082v(new StringBuilder(String.valueOf(zzd).length() + 47).append("Refreshed container ").append(zzd).append(". Reinitializing runtime...").toString());
            this.zzbim.zzbif.execute(new zzgm(this.zzbim, zzpm));
            return;
        }
        this.zzbim.zzar(this.zzbim.zzbii.zzoa());
    }
}
