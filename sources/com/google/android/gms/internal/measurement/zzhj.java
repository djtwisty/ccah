package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

@ShowFirstParty
@VisibleForTesting
public class zzhj {
    private static String zzbcu;
    @VisibleForTesting
    private static Map<String, String> zzbcv = new HashMap();

    public static String zzg(Context context, String str) {
        if (zzbcu == null) {
            synchronized (zzhj.class) {
                if (zzbcu == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_install_referrer", 0);
                    if (sharedPreferences != null) {
                        zzbcu = sharedPreferences.getString("referrer", "");
                    } else {
                        zzbcu = "";
                    }
                }
            }
        }
        return zzw(zzbcu, str);
    }

    public static String zzw(String str, String str2) {
        if (str2 != null) {
            String str3 = "http://hostname/?";
            String valueOf = String.valueOf(str);
            return Uri.parse(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3)).getQueryParameter(str2);
        } else if (str.length() > 0) {
            return str;
        } else {
            return null;
        }
    }
}
