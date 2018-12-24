package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.firebase_auth.zzbe;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzcf implements RemoteCall {
    private final zzce zzlh;

    zzcf(zzce zzce) {
        this.zzlh = zzce;
    }

    public final void accept(Object obj, Object obj2) {
        zzeo zzeo = this.zzlh;
        zzdq zzdq = (zzdq) obj;
        zzeo.zzng = new zzew(zzeo, (TaskCompletionSource) obj2);
        if (zzeo.zznr) {
            zzdq.zzdh().zzf(zzeo.zznd.zzch(), zzeo.zznc);
        } else {
            zzdq.zzdh().zza(new zzbe(zzeo.zznd.zzch()), zzeo.zznc);
        }
    }
}
