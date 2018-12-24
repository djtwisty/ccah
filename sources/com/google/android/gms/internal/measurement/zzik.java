package com.google.android.gms.internal.measurement;

import java.net.HttpURLConnection;
import java.net.URL;

final class zzik implements zzim {
    zzik() {
    }

    public final HttpURLConnection zzc(URL url) {
        return (HttpURLConnection) url.openConnection();
    }
}
