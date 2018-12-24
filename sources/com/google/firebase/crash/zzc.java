package com.google.firebase.crash;

import com.google.android.gms.tasks.OnSuccessListener;

final /* synthetic */ class zzc implements OnSuccessListener {
    private final FirebaseCrash zzn;
    private final boolean zzo;
    private final boolean zzp;

    zzc(FirebaseCrash firebaseCrash, boolean z, boolean z2) {
        this.zzn = firebaseCrash;
        this.zzo = z;
        this.zzp = z2;
    }

    public final void onSuccess(Object obj) {
        this.zzn.zza(this.zzo, this.zzp, (Void) obj);
    }
}
