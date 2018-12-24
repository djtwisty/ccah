package com.google.android.gms.internal.measurement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.HttpStatus;

final class zzpv implements zzpw {
    private HttpURLConnection zzbop;
    private InputStream zzboq = null;

    zzpv() {
    }

    public final InputStream zzez(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(20000);
        this.zzbop = httpURLConnection;
        httpURLConnection = this.zzbop;
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == HttpStatus.SC_OK) {
            this.zzboq = httpURLConnection.getInputStream();
            return this.zzboq;
        }
        String str2 = "Bad response: " + responseCode;
        if (responseCode == HttpStatus.SC_NOT_FOUND) {
            throw new FileNotFoundException(str2);
        } else if (responseCode == HttpStatus.SC_SERVICE_UNAVAILABLE) {
            throw new zzqa(str2);
        } else {
            throw new IOException(str2);
        }
    }

    public final void close() {
        HttpURLConnection httpURLConnection = this.zzbop;
        try {
            if (this.zzboq != null) {
                this.zzboq.close();
            }
        } catch (Throwable e) {
            Throwable th = e;
            String str = "HttpUrlConnectionNetworkClient: Error when closing http input stream: ";
            String valueOf = String.valueOf(th.getMessage());
            zzhk.zza(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
}
