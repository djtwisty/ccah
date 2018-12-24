package com.google.android.gms.internal.measurement;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.http.protocol.HTTP;

public final class zzpu {
    private String zzbaw = "https://www.google-analytics.com";

    public final String zzb(zzoz zzoz) {
        String zzrv;
        String str = this.zzbaw;
        if (zzoz.zzru()) {
            zzrv = zzoz.zzrv();
        } else if (zzoz == null) {
            zzrv = "";
        } else {
            if (zzoz.zzrw().trim().equals("")) {
                zzrv = "-1";
            } else {
                zzrv = zzoz.zzrw().trim();
            }
            StringBuilder stringBuilder = new StringBuilder();
            if (zzoz.zzrs() != null) {
                stringBuilder.append(zzoz.zzrs());
            } else {
                stringBuilder.append("id");
            }
            stringBuilder.append("=").append(zzei(zzoz.getContainerId())).append("&pv=").append(zzei(zzrv)).append("&rv=5.0");
            if (zzoz.zzru()) {
                stringBuilder.append("&gtm_debug=x");
            }
            zzrv = stringBuilder.toString();
        }
        return new StringBuilder((String.valueOf(str).length() + 13) + String.valueOf(zzrv).length()).append(str).append("/gtm/android?").append(zzrv).toString();
    }

    private static String zzei(String str) {
        try {
            return URLEncoder.encode(str, HTTP.UTF_8).replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            String str2 = "Cannot encode the string: ";
            String valueOf = String.valueOf(str);
            zzhk.m1081e(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return "";
        }
    }
}
