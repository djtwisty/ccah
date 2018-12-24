package com.google.android.gms.internal.measurement;

import android.net.Uri;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.apache.http.protocol.HTTP;

@VisibleForTesting
public class zzhs {
    private static zzhs zzbjz;
    private volatile String zzazo = null;
    private volatile String zzbed = null;
    private volatile int zzbka = zza.zzbkb;

    enum zza {
        public static final int zzbkb = 1;
        public static final int zzbkc = 2;
        private static final /* synthetic */ int[] zzbkd = new int[]{1, 2};
    }

    zzhs() {
    }

    @VisibleForTesting
    public static zzhs zzrf() {
        zzhs zzhs;
        synchronized (zzhs.class) {
            if (zzbjz == null) {
                zzbjz = new zzhs();
            }
            zzhs = zzbjz;
        }
        return zzhs;
    }

    public final synchronized boolean zza(String str, Uri uri) {
        boolean z = false;
        synchronized (this) {
            String decode;
            try {
                decode = URLDecoder.decode(uri.toString(), HTTP.UTF_8);
                String queryParameter;
                if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\S+")) {
                    queryParameter = uri.getQueryParameter("id");
                    String queryParameter2 = uri.getQueryParameter("gtm_auth");
                    String queryParameter3 = uri.getQueryParameter("gtm_preview");
                    if (!str.equals(queryParameter)) {
                        zzhk.zzab("Preview fails (container doesn't match the container specified by the asset)");
                    } else if (queryParameter == null || queryParameter.length() <= 0) {
                        queryParameter = "Bad preview url: ";
                        decode = String.valueOf(decode);
                        zzhk.zzab(decode.length() != 0 ? queryParameter.concat(decode) : new String(queryParameter));
                    } else {
                        if (queryParameter3 == null || queryParameter3.length() != 0) {
                            if (queryParameter3 == null || queryParameter3.length() <= 0 || queryParameter2 == null || queryParameter2.length() <= 0) {
                                queryParameter = "Bad preview url: ";
                                decode = String.valueOf(decode);
                                zzhk.zzab(decode.length() != 0 ? queryParameter.concat(decode) : new String(queryParameter));
                            } else {
                                this.zzbka = zza.zzbkc;
                                this.zzbed = uri.getQuery();
                                this.zzazo = queryParameter;
                            }
                        } else if (!queryParameter.equals(this.zzazo) || this.zzbka == zza.zzbkb) {
                            zzhk.zzab("Error in exiting preview mode. The container is not in preview.");
                        } else {
                            decode = "Exit preview mode for container: ";
                            String valueOf = String.valueOf(this.zzazo);
                            zzhk.m1082v(valueOf.length() != 0 ? decode.concat(valueOf) : new String(decode));
                            this.zzbka = zza.zzbkb;
                            this.zzazo = null;
                            this.zzbed = null;
                        }
                        z = true;
                    }
                } else {
                    queryParameter = "Bad preview url: ";
                    decode = String.valueOf(decode);
                    if (decode.length() != 0) {
                        decode = queryParameter.concat(decode);
                    } else {
                        decode = new String(queryParameter);
                    }
                    zzhk.zzab(decode);
                }
            } catch (UnsupportedEncodingException e) {
                decode = String.valueOf(e);
                zzhk.zzab(new StringBuilder(String.valueOf(decode).length() + 32).append("Error decoding the preview url: ").append(decode).toString());
            }
        }
        return z;
    }

    public final boolean isPreview() {
        return this.zzbka == zza.zzbkc;
    }

    public final boolean zzem(String str) {
        return isPreview() && this.zzazo.equals(str);
    }

    public final String zzrg() {
        return this.zzbed;
    }

    public final String getContainerId() {
        return this.zzazo;
    }
}
