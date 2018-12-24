package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONArray;

public final class zznb extends zzjq {
    private final int type;
    private final zzia zzbkf;

    public zznb(int i, zzia zzia) {
        this.type = i;
        this.zzbkf = zzia;
    }

    public final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z = true;
        Preconditions.checkArgument(true);
        if (zzqpArr.length != 1) {
            z = false;
        }
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzrb);
        try {
            zzjq zzp = zzpb.zzp(new JSONArray((String) ((zzrb) zzqpArr[0]).value()).getJSONArray(0));
            zzp.zza(this.zzbkf);
            zzqp<?> zzb = zzp.zzb(zzia, new zzqp[0]);
            if (this.type == 0) {
                return zzqv.zzbpr;
            }
            return zzb;
        } catch (Throwable e) {
            zzhk.zza("Unable to convert Custom Pixie to instruction", e);
            return zzqv.zzbpr;
        }
    }
}
