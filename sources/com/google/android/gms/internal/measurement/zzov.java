package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;

public final class zzov extends zzjq {
    private static final Set<String> zzbne = new HashSet(Arrays.asList(new String[]{HttpGet.METHOD_NAME, HttpHead.METHOD_NAME, HttpPost.METHOD_NAME, HttpPut.METHOD_NAME}));
    private final zzgx zzbnd;

    public zzov(zzgx zzgx) {
        this.zzbnd = zzgx;
    }

    protected final zzqp<?> zza(zzia zzia, zzqp<?>... zzqpArr) {
        String str;
        boolean z;
        Map map;
        boolean z2;
        String str2 = null;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzqpArr.length == 1);
        Preconditions.checkArgument(zzqpArr[0] instanceof zzqz);
        zzqp zzfe = zzqpArr[0].zzfe(ImagesContract.URL);
        Preconditions.checkArgument(zzfe instanceof zzrb);
        String str3 = (String) ((zzrb) zzfe).value();
        zzfe = zzqpArr[0].zzfe(Param.METHOD);
        if (zzfe == zzqv.zzbpr) {
            zzfe = new zzrb(HttpGet.METHOD_NAME);
        }
        Preconditions.checkArgument(zzfe instanceof zzrb);
        String str4 = (String) ((zzrb) zzfe).value();
        Preconditions.checkArgument(zzbne.contains(str4));
        zzfe = zzqpArr[0].zzfe("uniqueId");
        boolean z3 = zzfe == zzqv.zzbpr || zzfe == zzqv.zzbpq || (zzfe instanceof zzrb);
        Preconditions.checkArgument(z3);
        if (zzfe == zzqv.zzbpr || zzfe == zzqv.zzbpq) {
            str = null;
        } else {
            str = (String) ((zzrb) zzfe).value();
        }
        zzfe = zzqpArr[0].zzfe("headers");
        if (zzfe == zzqv.zzbpr || (zzfe instanceof zzqz)) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        Map hashMap = new HashMap();
        if (zzfe == zzqv.zzbpr) {
            map = null;
        } else {
            for (Entry entry : ((Map) ((zzqz) zzfe).value()).entrySet()) {
                String str5 = (String) entry.getKey();
                zzfe = (zzqp) entry.getValue();
                if (zzfe instanceof zzrb) {
                    hashMap.put(str5, (String) ((zzrb) zzfe).value());
                } else {
                    zzhk.zzab(String.format("Ignore the non-string value of header key %s.", new Object[]{str5}));
                }
            }
            map = hashMap;
        }
        zzfe = zzqpArr[0].zzfe("body");
        if (zzfe == zzqv.zzbpr || (zzfe instanceof zzrb)) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        if (zzfe != zzqv.zzbpr) {
            str2 = (String) ((zzrb) zzfe).value();
        }
        if ((str4.equals(HttpGet.METHOD_NAME) || str4.equals(HttpHead.METHOD_NAME)) && str2 != null) {
            zzhk.zzab(String.format("Body of %s hit will be ignored: %s.", new Object[]{str4, str2}));
        }
        this.zzbnd.zza(str3, str4, str, map, str2);
        zzhk.m1082v(String.format("QueueRequest:\n  url = %s,\n  method = %s,\n  uniqueId = %s,\n  headers = %s,\n  body = %s", new Object[]{str3, str4, str, map, str2}));
        return zzqv.zzbpr;
    }
}
