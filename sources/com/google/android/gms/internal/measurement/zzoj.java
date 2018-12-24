package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.common.internal.Preconditions;

public final class zzoj implements zzjo {
    private DisplayMetrics zzbnc = new DisplayMetrics();
    private Context zzri;

    public zzoj(Context context) {
        this.zzri = context;
    }

    public final zzqp<?> zzb(zzia zzia, zzqp<?>... zzqpArr) {
        boolean z = true;
        Preconditions.checkArgument(zzqpArr != null);
        if (zzqpArr.length != 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        ((WindowManager) this.zzri.getSystemService("window")).getDefaultDisplay().getMetrics(this.zzbnc);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.zzbnc.widthPixels);
        stringBuilder.append("x");
        stringBuilder.append(this.zzbnc.heightPixels);
        return new zzrb(stringBuilder.toString());
    }
}
