package com.google.android.gms.common.api;

import android.support.v4.p017e.C0238a;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public class AvailabilityException extends Exception {
    private final C0238a<zai<?>, ConnectionResult> zaay;

    public AvailabilityException(C0238a<zai<?>, ConnectionResult> c0238a) {
        this.zaay = c0238a;
    }

    public ConnectionResult getConnectionResult(GoogleApi<? extends ApiOptions> googleApi) {
        zai zak = googleApi.zak();
        Preconditions.checkArgument(this.zaay.get(zak) != null, "The given API was not part of the availability request.");
        return (ConnectionResult) this.zaay.get(zak);
    }

    public final C0238a<zai<?>, ConnectionResult> zaj() {
        return this.zaay;
    }

    public String getMessage() {
        Iterable arrayList = new ArrayList();
        Object obj = 1;
        for (zai zai : this.zaay.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) this.zaay.get(zai);
            if (connectionResult.isSuccess()) {
                obj = null;
            }
            String zan = zai.zan();
            String valueOf = String.valueOf(connectionResult);
            arrayList.add(new StringBuilder((String.valueOf(zan).length() + 2) + String.valueOf(valueOf).length()).append(zan).append(": ").append(valueOf).toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (obj != null) {
            stringBuilder.append("None of the queried APIs are available. ");
        } else {
            stringBuilder.append("Some of the queried APIs are unavailable. ");
        }
        stringBuilder.append(TextUtils.join("; ", arrayList));
        return stringBuilder.toString();
    }
}
