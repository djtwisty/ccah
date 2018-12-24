package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.firebase_auth.zzca;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzcz implements RemoteCall {
    private final zzcy zzlx;

    zzcz(zzcy zzcy) {
        this.zzlx = zzcy;
    }

    public final void accept(Object obj, Object obj2) {
        zzeo zzeo = this.zzlx;
        zzdq zzdq = (zzdq) obj;
        zzeo.zzng = new zzew(zzeo, (TaskCompletionSource) obj2);
        if (zzeo.zznr) {
            zzdq.zzdh().zze(zzeo.zznd.zzch(), zzeo.zznc);
        } else {
            zzdq.zzdh().zza(new zzca(zzeo.zznd.zzch()), zzeo.zznc);
        }
    }
}
