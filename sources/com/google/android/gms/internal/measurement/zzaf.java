package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.measurement.AppMeasurement.Param;
import java.util.HashMap;
import java.util.Map;

@ShowFirstParty
public final class zzaf extends zzi<zzaf> {
    public String zzum;
    public boolean zzun;

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("description", this.zzum);
        hashMap.put(Param.FATAL, Boolean.valueOf(this.zzun));
        return zzi.zza((Object) hashMap);
    }

    public final /* synthetic */ void zzb(zzi zzi) {
        zzaf zzaf = (zzaf) zzi;
        if (!TextUtils.isEmpty(this.zzum)) {
            zzaf.zzum = this.zzum;
        }
        if (this.zzun) {
            zzaf.zzun = this.zzun;
        }
    }
}
