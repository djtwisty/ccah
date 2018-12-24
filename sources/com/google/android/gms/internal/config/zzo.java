package com.google.android.gms.internal.config;

import android.os.Bundle;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataBufferSafeParcelable;
import com.google.android.gms.common.data.DataHolder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Pattern;
import org.apache.http.protocol.HTTP;

public final class zzo implements zzg {
    private static final Charset UTF_8 = Charset.forName(HTTP.UTF_8);
    private static final Pattern zzm = Pattern.compile("^(1|true|t|yes|y|on)$", 2);
    private static final Pattern zzn = Pattern.compile("^(0|false|f|no|n|off|)$", 2);

    public final PendingResult<zzk> zza(GoogleApiClient googleApiClient, zzi zzi) {
        if (googleApiClient == null || zzi == null) {
            return null;
        }
        return googleApiClient.enqueue(new zzp(this, googleApiClient, zzi));
    }

    private static Status zzd(int i) {
        String str;
        switch (i) {
            case -6508:
                str = "SUCCESS_CACHE_STALE";
                break;
            case -6506:
                str = "SUCCESS_CACHE";
                break;
            case -6505:
                str = "SUCCESS_FRESH";
                break;
            case 6500:
                str = "NOT_AUTHORIZED_TO_FETCH";
                break;
            case 6501:
                str = "ANOTHER_FETCH_INFLIGHT";
                break;
            case 6502:
                str = "FETCH_THROTTLED";
                break;
            case 6503:
                str = "NOT_AVAILABLE";
                break;
            case 6504:
                str = "FAILURE_CACHE";
                break;
            case 6507:
                str = "FETCH_THROTTLED_STALE";
                break;
            default:
                str = CommonStatusCodes.getStatusCodeString(i);
                break;
        }
        return new Status(i, str);
    }

    private static HashMap<String, TreeMap<String, byte[]>> zza(zzad zzad) {
        if (zzad == null) {
            return null;
        }
        DataHolder zzj = zzad.zzj();
        if (zzj == null) {
            return null;
        }
        zzaj zzaj = (zzaj) new DataBufferSafeParcelable(zzj, zzaj.CREATOR).get(0);
        zzad.zzl();
        HashMap<String, TreeMap<String, byte[]>> hashMap = new HashMap();
        for (String str : zzaj.zzn().keySet()) {
            TreeMap treeMap = new TreeMap();
            hashMap.put(str, treeMap);
            Bundle bundle = zzaj.zzn().getBundle(str);
            for (String str2 : bundle.keySet()) {
                treeMap.put(str2, bundle.getByteArray(str2));
            }
        }
        return hashMap;
    }

    static List<byte[]> zzb(zzad zzad) {
        if (zzad == null) {
            return null;
        }
        DataHolder zzk = zzad.zzk();
        if (zzk == null) {
            return null;
        }
        List<byte[]> arrayList = new ArrayList();
        for (zzx payload : new DataBufferSafeParcelable(zzk, zzx.CREATOR)) {
            arrayList.add(payload.getPayload());
        }
        zzad.zzm();
        return arrayList;
    }
}
