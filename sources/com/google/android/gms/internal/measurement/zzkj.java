package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Comparator;

final class zzkj implements Comparator<zzqp<?>> {
    private final /* synthetic */ zzqu zzbmn;
    private final /* synthetic */ zzia zzbmo;

    zzkj(zzkh zzkh, zzqu zzqu, zzia zzia) {
        this.zzbmn = zzqu;
        this.zzbmo = zzia;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzqp zzqp = (zzqp) obj;
        zzqp zzqp2 = (zzqp) obj2;
        if (zzqp == null) {
            if (zzqp2 != null) {
                return 1;
            }
            return 0;
        } else if (zzqp2 == null) {
            return zzqp != null ? -1 : 0;
        } else {
            zzqp zzb = ((zzjo) this.zzbmn.value()).zzb(this.zzbmo, zzqp, zzqp2);
            Preconditions.checkState(zzb instanceof zzqt);
            return (int) ((Double) ((zzqt) zzb).value()).doubleValue();
        }
    }
}
