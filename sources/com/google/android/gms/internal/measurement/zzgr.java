package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;

public final class zzgr implements zzgx {
    private static final Object zzazc = new Object();
    private static zzgr zzbit;
    private static final Set<String> zzbiw = new HashSet(Arrays.asList(new String[]{HttpGet.METHOD_NAME, HttpHead.METHOD_NAME, HttpPost.METHOD_NAME, HttpPut.METHOD_NAME}));
    private zzht zzbiu;
    private zzgy zzbiv;

    private zzgr(Context context) {
        this(zzgz.zzz(context), new zzib());
    }

    @VisibleForTesting
    private zzgr(zzgy zzgy, zzht zzht) {
        this.zzbiv = zzgy;
        this.zzbiu = zzht;
    }

    public static zzgx zzy(Context context) {
        zzgx zzgx;
        synchronized (zzazc) {
            if (zzbit == null) {
                zzbit = new zzgr(context);
            }
            zzgx = zzbit;
        }
        return zzgx;
    }

    public final boolean zzdo(String str) {
        return zza(str, null, null, null, null);
    }

    public final boolean zzx(String str, String str2) {
        return zza(str, null, str2, null, null);
    }

    public final boolean zza(String str, String str2, String str3, Map<String, String> map, String str4) {
        if (str2 != null && !zzbiw.contains(str2)) {
            zzhk.zzab(String.format("Unsupport http method %s. Drop the hit.", new Object[]{str2}));
            return false;
        } else if (zzhs.zzrf().isPreview() || this.zzbiu.zzew()) {
            this.zzbiv.zzb(str, str2, str3, map, str4);
            return true;
        } else {
            zzhk.zzab("Too many hits sent too quickly (rate throttled).");
            return false;
        }
    }

    public final void dispatch() {
        zzid.zzrj().dispatch();
    }
}
