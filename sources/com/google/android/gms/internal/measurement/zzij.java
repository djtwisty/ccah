package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.protocol.HTTP;

final class zzij implements zzgs {
    private final String zzabl;
    private final zzim zzbkx;
    private final zzil zzbky;
    private final Context zzri;

    @VisibleForTesting
    private zzij(zzim zzim, Context context, zzil zzil) {
        String str = null;
        this.zzbkx = zzim;
        this.zzri = context.getApplicationContext();
        this.zzbky = zzil;
        String str2 = "GoogleTagManager";
        String str3 = "5.06";
        String str4 = VERSION.RELEASE;
        Locale locale = Locale.getDefault();
        if (!(locale == null || locale.getLanguage() == null || locale.getLanguage().length() == 0)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(locale.getLanguage().toLowerCase());
            if (!(locale.getCountry() == null || locale.getCountry().length() == 0)) {
                stringBuilder.append("-").append(locale.getCountry().toLowerCase());
            }
            str = stringBuilder.toString();
        }
        String str5 = Build.MODEL;
        String str6 = Build.ID;
        this.zzabl = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str2, str3, str4, str, str5, str6});
    }

    @VisibleForTesting
    zzij(Context context, zzil zzil) {
        this(new zzik(), context, zzil);
    }

    public final boolean zzom() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.zzri.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzhk.m1082v("...no network connectivity");
        return false;
    }

    public final void zzf(List<zzgw> list) {
        Object obj;
        Throwable th;
        InputStream inputStream;
        IOException e;
        Throwable th2;
        int min = Math.min(list.size(), 40);
        Object obj2 = 1;
        int i = 0;
        while (i < min) {
            zzgw zzgw = (zzgw) list.get(i);
            URL zzd = zzd(zzgw);
            String zzqx = zzgw.zzqx();
            Map zzqy = zzgw.zzqy();
            String zzqz = zzgw.zzqz();
            if (zzd == null) {
                zzhk.zzab("No destination: discarding hit.");
                this.zzbky.zzb(zzgw);
                obj = obj2;
            } else {
                try {
                    Object obj3;
                    HttpURLConnection zzc = this.zzbkx.zzc(zzd);
                    if (obj2 != null) {
                        try {
                            zzhm.zzw(this.zzri);
                            obj3 = null;
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = null;
                            obj3 = obj2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e2) {
                                    e = e2;
                                    obj2 = obj3;
                                }
                            }
                            zzc.disconnect();
                            throw th;
                        }
                    }
                    obj3 = obj2;
                    try {
                        zzc.setRequestProperty(HTTP.USER_AGENT, this.zzabl);
                        if (zzqy != null) {
                            for (Entry entry : zzqy.entrySet()) {
                                zzc.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                            }
                        }
                        if (zzqx == null) {
                            zzhk.zzab(String.format("Hit %d retrieved from the store has null HTTP method.", new Object[]{Long.valueOf(zzgw.zzov())}));
                            this.zzbky.zzb(zzgw);
                            zzc.disconnect();
                            obj = obj3;
                        } else if (zzqx.equals(HttpGet.METHOD_NAME) || zzqx.equals(HttpHead.METHOD_NAME) || zzqx.equals(HttpPost.METHOD_NAME) || zzqx.equals(HttpPut.METHOD_NAME)) {
                            obj2 = -1;
                            switch (zzqx.hashCode()) {
                                case 70454:
                                    if (zzqx.equals(HttpGet.METHOD_NAME)) {
                                        obj2 = null;
                                        break;
                                    }
                                    break;
                                case 79599:
                                    if (zzqx.equals(HttpPut.METHOD_NAME)) {
                                        obj2 = 3;
                                        break;
                                    }
                                    break;
                                case 2213344:
                                    if (zzqx.equals(HttpHead.METHOD_NAME)) {
                                        obj2 = 1;
                                        break;
                                    }
                                    break;
                                case 2461856:
                                    if (zzqx.equals(HttpPost.METHOD_NAME)) {
                                        obj2 = 2;
                                        break;
                                    }
                                    break;
                            }
                            switch (obj2) {
                                case null:
                                case 1:
                                    if (zzqz != null) {
                                        zzhk.zzab(String.format("Body of %s hit is ignored: %s.", new Object[]{zzqx, zzqz}));
                                    }
                                    zzc.setRequestMethod(zzqx);
                                    break;
                                case 2:
                                case 3:
                                    zzc.setRequestMethod(zzqx);
                                    if (zzqz != null) {
                                        zzc.setDoOutput(true);
                                        byte[] bytes = zzqz.getBytes(Charset.forName(HTTP.UTF_8));
                                        zzc.setFixedLengthStreamingMode(bytes.length);
                                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zzc.getOutputStream());
                                        bufferedOutputStream.write(bytes);
                                        bufferedOutputStream.flush();
                                        bufferedOutputStream.close();
                                        break;
                                    }
                                    break;
                            }
                            int responseCode = zzc.getResponseCode();
                            String valueOf;
                            if (responseCode < HttpStatus.SC_OK || responseCode >= HttpStatus.SC_MULTIPLE_CHOICES) {
                                String valueOf2 = String.valueOf(zzd);
                                zzhk.zzab(new StringBuilder(String.valueOf(valueOf2).length() + 39).append("Bad response received for ").append(valueOf2).append(": ").append(responseCode).toString());
                                StringBuilder stringBuilder = new StringBuilder();
                                BufferedReader bufferedReader;
                                try {
                                    InputStream errorStream = zzc.getErrorStream();
                                    if (errorStream != null) {
                                        bufferedReader = new BufferedReader(new InputStreamReader(errorStream));
                                        while (true) {
                                            try {
                                                zzqz = bufferedReader.readLine();
                                                if (zzqz != null) {
                                                    stringBuilder.append(zzqz);
                                                } else {
                                                    zzqz = "Error Message: ";
                                                    valueOf = String.valueOf(stringBuilder.toString());
                                                    zzhk.zzab(valueOf.length() != 0 ? zzqz.concat(valueOf) : new String(zzqz));
                                                }
                                            } catch (Throwable th4) {
                                                th2 = th4;
                                            }
                                        }
                                    } else {
                                        bufferedReader = null;
                                    }
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    this.zzbky.zzc(zzgw);
                                    inputStream = null;
                                } catch (Throwable th5) {
                                    th2 = th5;
                                    bufferedReader = null;
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    throw th2;
                                }
                            }
                            inputStream = zzc.getInputStream();
                            try {
                                valueOf = String.valueOf(zzd);
                                zzhk.m1082v(new StringBuilder((String.valueOf(valueOf).length() + 23) + String.valueOf(zzqx).length()).append("Hit sent to ").append(valueOf).append("(method = ").append(zzqx).append(")").toString());
                                this.zzbky.zza(zzgw);
                            } catch (Throwable th22) {
                                th = th22;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                zzc.disconnect();
                                throw th;
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            zzc.disconnect();
                            obj = obj3;
                        } else {
                            zzhk.zzab(String.format("Unrecongnized HTTP method %s. Supported methods are GET, HEAD, PUT and/or POST", new Object[]{zzqx}));
                            this.zzbky.zzb(zzgw);
                            zzc.disconnect();
                            obj = obj3;
                        }
                    } catch (Throwable th222) {
                        th = th222;
                        inputStream = null;
                    }
                } catch (IOException e3) {
                    e = e3;
                    String valueOf3 = String.valueOf(zzd);
                    zzqz = e.getClass().getSimpleName();
                    zzhk.zzab(new StringBuilder((String.valueOf(valueOf3).length() + 27) + String.valueOf(zzqz).length()).append("Exception sending hit to ").append(valueOf3).append(": ").append(zzqz).toString());
                    zzhk.zzab(e.getMessage());
                    this.zzbky.zzc(zzgw);
                    obj = obj2;
                    i++;
                    obj2 = obj;
                }
            }
            i++;
            obj2 = obj;
        }
    }

    @VisibleForTesting
    private static URL zzd(zzgw zzgw) {
        try {
            return new URL(zzgw.zzox());
        } catch (MalformedURLException e) {
            zzhk.m1081e("Error trying to parse the GTM url.");
            return null;
        }
    }
}
