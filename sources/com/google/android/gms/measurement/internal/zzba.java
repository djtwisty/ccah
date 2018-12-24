package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.protocol.HTTP;

final class zzba implements Runnable {
    private final String packageName;
    private final URL url;
    private final byte[] zzamr;
    private final zzay zzams;
    private final Map<String, String> zzamt;
    private final /* synthetic */ zzaw zzamu;

    public zzba(zzaw zzaw, String str, URL url, byte[] bArr, Map<String, String> map, zzay zzay) {
        this.zzamu = zzaw;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzay);
        this.url = url;
        this.zzamr = bArr;
        this.zzams = zzay;
        this.packageName = str;
        this.zzamt = map;
    }

    public final void run() {
        OutputStream outputStream;
        Throwable e;
        Map map;
        int i;
        HttpURLConnection httpURLConnection;
        Throwable th;
        Map map2;
        OutputStream outputStream2;
        this.zzamu.zzgh();
        int i2 = 0;
        HttpURLConnection zzb;
        try {
            zzb = this.zzamu.zzb(this.url);
            try {
                if (this.zzamt != null) {
                    for (Entry entry : this.zzamt.entrySet()) {
                        zzb.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                if (this.zzamr != null) {
                    byte[] zzb2 = this.zzamu.zzjr().zzb(this.zzamr);
                    this.zzamu.zzgt().zzjo().zzg("Uploading data. size", Integer.valueOf(zzb2.length));
                    zzb.setDoOutput(true);
                    zzb.addRequestProperty(HTTP.CONTENT_ENCODING, "gzip");
                    zzb.setFixedLengthStreamingMode(zzb2.length);
                    zzb.connect();
                    outputStream = zzb.getOutputStream();
                    try {
                        outputStream.write(zzb2);
                        outputStream.close();
                    } catch (IOException e2) {
                        e = e2;
                        map = null;
                        i = 0;
                        httpURLConnection = zzb;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e3) {
                                this.zzamu.zzgt().zzjg().zze("Error closing HTTP compressed POST connection output stream. appId", zzas.zzbw(this.packageName), e3);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.zzamu.zzgs().zzc(new zzaz(this.packageName, this.zzams, i, e, null, map));
                    } catch (Throwable th2) {
                        th = th2;
                        map2 = null;
                        outputStream2 = outputStream;
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (IOException e32) {
                                this.zzamu.zzgt().zzjg().zze("Error closing HTTP compressed POST connection output stream. appId", zzas.zzbw(this.packageName), e32);
                            }
                        }
                        if (zzb != null) {
                            zzb.disconnect();
                        }
                        this.zzamu.zzgs().zzc(new zzaz(this.packageName, this.zzams, i2, null, null, map2));
                        throw th;
                    }
                }
                i2 = zzb.getResponseCode();
                map2 = zzb.getHeaderFields();
            } catch (IOException e4) {
                e = e4;
                map = null;
                i = i2;
                outputStream = null;
                httpURLConnection = zzb;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                this.zzamu.zzgs().zzc(new zzaz(this.packageName, this.zzams, i, e, null, map));
            } catch (Throwable th3) {
                th = th3;
                map2 = null;
                outputStream2 = null;
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                if (zzb != null) {
                    zzb.disconnect();
                }
                this.zzamu.zzgs().zzc(new zzaz(this.packageName, this.zzams, i2, null, null, map2));
                throw th;
            }
            try {
                byte[] zza = zzaw.zzb(zzb);
                if (zzb != null) {
                    zzb.disconnect();
                }
                this.zzamu.zzgs().zzc(new zzaz(this.packageName, this.zzams, i2, null, zza, map2));
            } catch (IOException e5) {
                e = e5;
                map = map2;
                i = i2;
                outputStream = null;
                httpURLConnection = zzb;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                this.zzamu.zzgs().zzc(new zzaz(this.packageName, this.zzams, i, e, null, map));
            } catch (Throwable th32) {
                th = th32;
                outputStream2 = null;
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                if (zzb != null) {
                    zzb.disconnect();
                }
                this.zzamu.zzgs().zzc(new zzaz(this.packageName, this.zzams, i2, null, null, map2));
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            map = null;
            i = 0;
            outputStream = null;
            httpURLConnection = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            this.zzamu.zzgs().zzc(new zzaz(this.packageName, this.zzams, i, e, null, map));
        } catch (Throwable th322) {
            th = th322;
            map2 = null;
            outputStream2 = null;
            zzb = null;
            if (outputStream2 != null) {
                outputStream2.close();
            }
            if (zzb != null) {
                zzb.disconnect();
            }
            this.zzamu.zzgs().zzc(new zzaz(this.packageName, this.zzams, i2, null, null, map2));
            throw th;
        }
    }
}
