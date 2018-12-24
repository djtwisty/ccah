package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.tagmanager.zzch;

final class zzir extends zzch {
    final /* synthetic */ zzin zzblk;

    zzir(zzin zzin) {
        this.zzblk = zzin;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        if (!str.endsWith("+gtm")) {
            this.zzblk.zzbif.execute(new zzis(this, str2, bundle, new StringBuilder(String.valueOf(str).length() + 4).append(str).append("+gtm").toString(), j, str));
        }
    }
}
