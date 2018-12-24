package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.tagmanager.zzck;

final class zzip extends zzck {
    final /* synthetic */ zzin zzblk;

    zzip(zzin zzin) {
        this.zzblk = zzin;
    }

    public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
        this.zzblk.zzbif.execute(new zziq(this, str2, bundle, new StringBuilder(String.valueOf(str).length() + 4).append(str).append("+gtm").toString(), j, str));
    }
}
