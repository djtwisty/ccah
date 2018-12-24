package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzjw extends zzjq {
    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        CharSequence charSequence;
        Preconditions.checkNotNull(zzqpArr);
        boolean z = zzqpArr.length == 1 || zzqpArr.length == 2;
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzqw);
        List<zzqp> list = (List) ((zzqw) zzqpArr[0]).value();
        zzqp zzqp = zzqpArr.length < 2 ? zzqv.zzbpr : zzqpArr[1];
        if (zzqp == zzqv.zzbpr) {
            charSequence = ",";
        } else {
            charSequence = zzjp.zzd(zzqp);
        }
        Iterable arrayList = new ArrayList();
        for (zzqp zzqp2 : list) {
            if (zzqp2 == zzqv.zzbpq || zzqp2 == zzqv.zzbpr) {
                arrayList.add("");
            } else {
                arrayList.add(zzjp.zzd(zzqp2));
            }
        }
        return new zzrb(TextUtils.join(charSequence, arrayList));
    }
}
