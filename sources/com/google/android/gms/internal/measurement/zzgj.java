package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

final class zzgj implements zzpe, Runnable {
    private final /* synthetic */ zzgf zzbim;

    private zzgj(zzgf zzgf) {
        this.zzbim = zzgf;
    }

    public final void run() {
        Preconditions.checkState(this.zzbim.state == 1);
        List arrayList = new ArrayList();
        this.zzbim.zzbil = false;
        if (zzhs.zzrf().zzem(this.zzbim.zzazo)) {
            arrayList.add(Integer.valueOf(0));
        } else {
            this.zzbim.zzbil = this.zzbim.zzbii.zzqs();
            if (this.zzbim.zzbil) {
                arrayList.add(Integer.valueOf(1));
                arrayList.add(Integer.valueOf(0));
            } else {
                arrayList.add(Integer.valueOf(0));
                arrayList.add(Integer.valueOf(1));
            }
            arrayList.add(Integer.valueOf(2));
        }
        this.zzbim.zzbie.zza(this.zzbim.zzazo, this.zzbim.zzbic, this.zzbim.zzbib, arrayList, this, this.zzbim.zzbii);
    }

    public final void zza(zzpm zzpm) {
        if (zzpm.getStatus() == Status.RESULT_SUCCESS) {
            this.zzbim.zzbif.execute(new zzgm(this.zzbim, zzpm));
        } else {
            this.zzbim.zzbif.execute(new zzgi(this.zzbim, null));
        }
    }
}
