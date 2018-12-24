package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.LogPrinter;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@VisibleForTesting
public final class zze implements zzo {
    private static final Uri zzrd;
    private final LogPrinter zzrx = new LogPrinter(4, "GA/LogCatTransport");

    public final Uri zzo() {
        return zzrd;
    }

    public final void zzb(zzg zzg) {
        List arrayList = new ArrayList(zzg.zzt());
        Collections.sort(arrayList, new zzf(this));
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList arrayList2 = (ArrayList) arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            obj = ((zzi) obj).toString();
            if (!TextUtils.isEmpty(obj)) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(obj);
            }
        }
        this.zzrx.println(stringBuilder.toString());
    }

    static {
        Builder builder = new Builder();
        builder.scheme("uri");
        builder.authority(ImagesContract.LOCAL);
        zzrd = builder.build();
    }
}
