package com.google.android.gms.internal.measurement;

import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class zzox extends zzjq {
    private final zzgx zzbnd;

    public zzox(zzgx zzgx) {
        this.zzbnd = zzgx;
    }

    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzqpArr.length > 0);
        zzqp zzqp = zzqpArr[0];
        if (zzqp instanceof zzqv) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        zzqv zzqv = zzqpArr.length > 1 ? zzqpArr[1] : zzqv.zzbpr;
        if (zzqv == zzqv.zzbpr || (zzqv instanceof zzqw)) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        zzqp zzqp2 = zzqpArr.length > 2 ? zzqpArr[2] : zzqv.zzbpr;
        if (zzqp2 == zzqv.zzbpr || !(zzqp2 instanceof zzqv)) {
            z3 = true;
        }
        Preconditions.checkArgument(z3);
        Builder buildUpon = Uri.parse(zzjp.zzd(zzqp)).buildUpon();
        if (zzqv != zzqv.zzbpr) {
            for (zzqp zzqp3 : (List) ((zzqw) zzqv).value()) {
                Preconditions.checkArgument(zzqp3 instanceof zzqz);
                for (Entry entry : ((Map) ((zzqz) zzqp3).value()).entrySet()) {
                    buildUpon.appendQueryParameter(((String) entry.getKey()).toString(), zzjp.zzd(zzrd.zza(zzia, (zzqp) entry.getValue())));
                }
            }
        }
        String uri = buildUpon.build().toString();
        String str;
        if (zzqp2 == zzqv.zzbpr) {
            this.zzbnd.zzdo(uri);
            str = "SendPixel: url = ";
            uri = String.valueOf(uri);
            zzhk.m1082v(uri.length() != 0 ? str.concat(uri) : new String(str));
        } else {
            str = zzjp.zzd(zzqp2);
            this.zzbnd.zzx(uri, str);
            zzhk.m1082v(new StringBuilder((String.valueOf(uri).length() + 30) + String.valueOf(str).length()).append("SendPixel: url = ").append(uri).append(", uniqueId = ").append(str).toString());
        }
        return zzqv.zzbpr;
    }
}
