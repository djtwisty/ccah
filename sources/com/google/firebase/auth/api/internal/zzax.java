package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzax implements RemoteCall {
    private final zzaw zzkj;

    zzax(zzaw zzaw) {
        this.zzkj = zzaw;
    }

    public final void accept(Object obj, Object obj2) {
        zzeo zzeo = this.zzkj;
        zzdq zzdq = (zzdq) obj;
        zzeo.zzng = new zzew(zzeo, (TaskCompletionSource) obj2);
        if (zzeo.zznr) {
            zzdq.zzdh().zzc(zzeo.zzki.getEmail(), zzeo.zzki.getPassword(), zzeo.zznc);
        } else {
            zzdq.zzdh().zza(zzeo.zzki, zzeo.zznc);
        }
    }
}
