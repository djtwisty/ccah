package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.firebase_auth.zzas;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzaz implements RemoteCall {
    private final zzay zzkk;

    zzaz(zzay zzay) {
        this.zzkk = zzay;
    }

    public final void accept(Object obj, Object obj2) {
        zzeo zzeo = this.zzkk;
        zzdq zzdq = (zzdq) obj;
        zzeo.zzng = new zzew(zzeo, (TaskCompletionSource) obj2);
        if (zzeo.zznr) {
            zzdq.zzdh().zzg(zzeo.zznd.zzch(), zzeo.zznc);
        } else {
            zzdq.zzdh().zza(new zzas(zzeo.zznd.zzch()), zzeo.zznc);
        }
    }
}
