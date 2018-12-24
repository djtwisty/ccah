package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tagmanager.zzcd;
import com.google.android.gms.tagmanager.zzcm;

@VisibleForTesting
public final class zzhz {
    private final String zzazo;
    private final zzcm zzbih;
    private final zzcd zzbir;
    private final Context zzri;

    public zzhz(Context context, zzcm zzcm, zzcd zzcd, String str) {
        this.zzri = context.getApplicationContext();
        this.zzbih = zzcm;
        this.zzbir = zzcd;
        this.zzazo = str;
    }

    public final zzhu zza(zzqb zzqb, zzqj zzqj) {
        return new zzhu(this.zzri, this.zzazo, zzqb, zzqj, this.zzbih, this.zzbir);
    }
}
