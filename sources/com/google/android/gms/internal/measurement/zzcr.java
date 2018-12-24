package com.google.android.gms.internal.measurement;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.analytics.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.zip.GZIPOutputStream;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;

final class zzcr extends zzau {
    private static final byte[] zzabn = "\n".getBytes();
    private final String zzabl;
    private final zzdc zzabm;

    zzcr(zzaw zzaw) {
        super(zzaw);
        String str = zzav.VERSION;
        String str2 = VERSION.RELEASE;
        String zza = zzdg.zza(Locale.getDefault());
        String str3 = Build.MODEL;
        String str4 = Build.ID;
        this.zzabl = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{"GoogleAnalytics", str, str2, zza, str3, str4});
        this.zzabm = new zzdc(zzaw.zzbx());
    }

    protected final void zzag() {
        zza("Network initialized. User agent", this.zzabl);
    }

    public final boolean zzfb() {
        NetworkInfo activeNetworkInfo;
        zzk.zzaf();
        zzcl();
        try {
            activeNetworkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzq("No network connectivity");
        return false;
    }

    public final List<Long> zzb(List<zzck> list) {
        boolean z;
        boolean z2;
        List<Long> arrayList;
        String zza;
        URL zzb;
        String zza2;
        byte[] bytes;
        zzcs zzcs;
        List<Long> arrayList2;
        URL zzfc;
        int zza3;
        boolean z3 = true;
        zzk.zzaf();
        zzcl();
        Preconditions.checkNotNull(list);
        if (zzbz().zzeg().isEmpty() || !this.zzabm.zzj(((long) ((Integer) zzcf.zzzx.get()).intValue()) * 1000)) {
            z = false;
        } else {
            if (zzbn.zzz((String) zzcf.zzzq.get()) != zzbn.NONE) {
                z = true;
            } else {
                z = false;
            }
            if (zzbt.zzaa((String) zzcf.zzzr.get()) == zzbt.GZIP) {
                z2 = true;
                if (z) {
                    arrayList = new ArrayList(list.size());
                    for (zzck zzck : list) {
                        Preconditions.checkNotNull(zzck);
                        zza = zza(zzck, zzck.zzet());
                        if (zza != null) {
                            zzby().zza(zzck, "Error formatting hit for upload");
                            z = true;
                        } else {
                            if (zza.length() > ((Integer) zzcf.zzzp.get()).intValue()) {
                                zzb = zzb(zzck, zza);
                                if (zzb == null) {
                                    zzu("Failed to build collect GET endpoint url");
                                } else {
                                    z = zza(zzb) != HttpStatus.SC_OK;
                                }
                            } else {
                                zza2 = zza(zzck, false);
                                if (zza2 != null) {
                                    zzby().zza(zzck, "Error formatting hit for POST upload");
                                    z = true;
                                } else {
                                    bytes = zza2.getBytes();
                                    if (bytes.length <= ((Integer) zzcf.zzzu.get()).intValue()) {
                                        zzby().zza(zzck, "Hit payload exceeds size limit");
                                        z = true;
                                    } else {
                                        zzb = zzd(zzck);
                                        if (zzb == null) {
                                            zzu("Failed to build collect POST endpoint url");
                                        } else if (zza(zzb, bytes) == HttpStatus.SC_OK) {
                                            z = true;
                                        }
                                    }
                                }
                            }
                            z = false;
                        }
                        if (!z) {
                            arrayList.add(Long.valueOf(zzck.zzeq()));
                            if (arrayList.size() >= zzbx.zzeb()) {
                                break;
                            }
                        }
                        break;
                    }
                    return arrayList;
                }
                if (list.isEmpty()) {
                    z3 = false;
                }
                Preconditions.checkArgument(z3);
                zza("Uploading batched hits. compression, count", Boolean.valueOf(z2), Integer.valueOf(list.size()));
                zzcs = new zzcs(this);
                arrayList2 = new ArrayList();
                for (zzck zzck2 : list) {
                    if (zzcs.zze(zzck2)) {
                        break;
                    }
                    arrayList2.add(Long.valueOf(zzck2.zzeq()));
                }
                if (zzcs.zzfe() == 0) {
                    return arrayList2;
                }
                zzfc = zzfc();
                if (zzfc != null) {
                    zzu("Failed to build batching endpoint url");
                } else {
                    if (z2) {
                        zza3 = zza(zzfc, zzcs.getPayload());
                    } else {
                        zza3 = zzb(zzfc, zzcs.getPayload());
                    }
                    if (HttpStatus.SC_OK != zza3) {
                        zza("Batched upload completed. Hits batched", Integer.valueOf(zzcs.zzfe()));
                        return arrayList2;
                    }
                    zza("Network error uploading hits. status code", Integer.valueOf(zza3));
                    if (zzbz().zzeg().contains(Integer.valueOf(zza3))) {
                        zzt("Server instructed the client to stop batching");
                        this.zzabm.start();
                    }
                }
                return Collections.emptyList();
            }
        }
        z2 = false;
        if (z) {
            arrayList = new ArrayList(list.size());
            for (zzck zzck22 : list) {
                Preconditions.checkNotNull(zzck22);
                if (zzck22.zzet()) {
                }
                zza = zza(zzck22, zzck22.zzet());
                if (zza != null) {
                    if (zza.length() > ((Integer) zzcf.zzzp.get()).intValue()) {
                        zza2 = zza(zzck22, false);
                        if (zza2 != null) {
                            bytes = zza2.getBytes();
                            if (bytes.length <= ((Integer) zzcf.zzzu.get()).intValue()) {
                                zzb = zzd(zzck22);
                                if (zzb == null) {
                                    zzu("Failed to build collect POST endpoint url");
                                } else if (zza(zzb, bytes) == HttpStatus.SC_OK) {
                                    z = true;
                                }
                            } else {
                                zzby().zza(zzck22, "Hit payload exceeds size limit");
                                z = true;
                            }
                        } else {
                            zzby().zza(zzck22, "Error formatting hit for POST upload");
                            z = true;
                        }
                    } else {
                        zzb = zzb(zzck22, zza);
                        if (zzb == null) {
                            zzu("Failed to build collect GET endpoint url");
                        } else if (zza(zzb) != HttpStatus.SC_OK) {
                        }
                    }
                    z = false;
                } else {
                    zzby().zza(zzck22, "Error formatting hit for upload");
                    z = true;
                }
                if (!z) {
                    break;
                }
                arrayList.add(Long.valueOf(zzck22.zzeq()));
                if (arrayList.size() >= zzbx.zzeb()) {
                    break;
                }
            }
            return arrayList;
        }
        if (list.isEmpty()) {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        zza("Uploading batched hits. compression, count", Boolean.valueOf(z2), Integer.valueOf(list.size()));
        zzcs = new zzcs(this);
        arrayList2 = new ArrayList();
        for (zzck zzck222 : list) {
            if (zzcs.zze(zzck222)) {
                break;
            }
            arrayList2.add(Long.valueOf(zzck222.zzeq()));
        }
        if (zzcs.zzfe() == 0) {
            return arrayList2;
        }
        zzfc = zzfc();
        if (zzfc != null) {
            if (z2) {
                zza3 = zza(zzfc, zzcs.getPayload());
            } else {
                zza3 = zzb(zzfc, zzcs.getPayload());
            }
            if (HttpStatus.SC_OK != zza3) {
                zza("Network error uploading hits. status code", Integer.valueOf(zza3));
                if (zzbz().zzeg().contains(Integer.valueOf(zza3))) {
                    zzt("Server instructed the client to stop batching");
                    this.zzabm.start();
                }
            } else {
                zza("Batched upload completed. Hits batched", Integer.valueOf(zzcs.zzfe()));
                return arrayList2;
            }
        }
        zzu("Failed to build batching endpoint url");
        return Collections.emptyList();
    }

    private final int zza(URL url) {
        Preconditions.checkNotNull(url);
        zzb("GET request", url);
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = zzb(url);
            httpURLConnection.connect();
            zza(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpStatus.SC_OK) {
                zzcc().zzbv();
            }
            zzb("GET status", Integer.valueOf(responseCode));
            if (httpURLConnection == null) {
                return responseCode;
            }
            httpURLConnection.disconnect();
            return responseCode;
        } catch (IOException e) {
            zzd("Network GET connection error", e);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return 0;
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private final int zza(URL url, byte[] bArr) {
        HttpURLConnection zzb;
        OutputStream outputStream;
        Object e;
        Throwable th;
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(bArr);
        zzb("POST bytes, url", Integer.valueOf(bArr.length), url);
        if (zzat.zzck()) {
            zza("Post payload\n", new String(bArr));
        }
        try {
            getContext().getPackageName();
            zzb = zzb(url);
            try {
                zzb.setDoOutput(true);
                zzb.setFixedLengthStreamingMode(bArr.length);
                zzb.connect();
                outputStream = zzb.getOutputStream();
            } catch (IOException e2) {
                e = e2;
                outputStream = null;
                try {
                    zzd("Network POST connection error", e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e3) {
                            zze("Error closing http post connection output stream", e3);
                        }
                    }
                    if (zzb != null) {
                        zzb.disconnect();
                    }
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                            zze("Error closing http post connection output stream", e4);
                        }
                    }
                    if (zzb != null) {
                        zzb.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream = null;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (zzb != null) {
                    zzb.disconnect();
                }
                throw th;
            }
            try {
                outputStream.write(bArr);
                zza(zzb);
                int responseCode = zzb.getResponseCode();
                if (responseCode == HttpStatus.SC_OK) {
                    zzcc().zzbv();
                }
                zzb("POST status", Integer.valueOf(responseCode));
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e42) {
                        zze("Error closing http post connection output stream", e42);
                    }
                }
                if (zzb == null) {
                    return responseCode;
                }
                zzb.disconnect();
                return responseCode;
            } catch (IOException e5) {
                e = e5;
                zzd("Network POST connection error", e);
                if (outputStream != null) {
                    outputStream.close();
                }
                if (zzb != null) {
                    zzb.disconnect();
                }
                return 0;
            }
        } catch (IOException e6) {
            e = e6;
            outputStream = null;
            zzb = null;
            zzd("Network POST connection error", e);
            if (outputStream != null) {
                outputStream.close();
            }
            if (zzb != null) {
                zzb.disconnect();
            }
            return 0;
        } catch (Throwable th4) {
            th = th4;
            outputStream = null;
            zzb = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (zzb != null) {
                zzb.disconnect();
            }
            throw th;
        }
    }

    private final int zzb(URL url, byte[] bArr) {
        Object concat;
        HttpURLConnection zzb;
        OutputStream outputStream;
        Throwable th;
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(bArr);
        try {
            getContext().getPackageName();
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            zza("POST compressed size, ratio %, url", Integer.valueOf(toByteArray.length), Long.valueOf((100 * ((long) toByteArray.length)) / ((long) bArr.length)), url);
            if (toByteArray.length > bArr.length) {
                zzc("Compressed payload is larger then uncompressed. compressed, uncompressed", Integer.valueOf(toByteArray.length), Integer.valueOf(bArr.length));
            }
            if (zzat.zzck()) {
                String str = "Post payload";
                String str2 = "\n";
                String valueOf = String.valueOf(new String(bArr));
                if (valueOf.length() != 0) {
                    concat = str2.concat(valueOf);
                } else {
                    concat = new String(str2);
                }
                zza(str, concat);
            }
            zzb = zzb(url);
            try {
                zzb.setDoOutput(true);
                zzb.addRequestProperty(HTTP.CONTENT_ENCODING, "gzip");
                zzb.setFixedLengthStreamingMode(toByteArray.length);
                zzb.connect();
                outputStream = zzb.getOutputStream();
            } catch (IOException e) {
                concat = e;
                outputStream = null;
                try {
                    zzd("Network compressed POST connection error", concat);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e2) {
                            zze("Error closing http compressed post connection output stream", e2);
                        }
                    }
                    if (zzb != null) {
                        zzb.disconnect();
                    }
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e3) {
                            zze("Error closing http compressed post connection output stream", e3);
                        }
                    }
                    if (zzb != null) {
                        zzb.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream = null;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (zzb != null) {
                    zzb.disconnect();
                }
                throw th;
            }
            try {
                outputStream.write(toByteArray);
                outputStream.close();
                zza(zzb);
                int responseCode = zzb.getResponseCode();
                if (responseCode == HttpStatus.SC_OK) {
                    zzcc().zzbv();
                }
                zzb("POST status", Integer.valueOf(responseCode));
                if (zzb == null) {
                    return responseCode;
                }
                zzb.disconnect();
                return responseCode;
            } catch (IOException e4) {
                concat = e4;
                zzd("Network compressed POST connection error", concat);
                if (outputStream != null) {
                    outputStream.close();
                }
                if (zzb != null) {
                    zzb.disconnect();
                }
                return 0;
            }
        } catch (IOException e5) {
            concat = e5;
            outputStream = null;
            zzb = null;
            zzd("Network compressed POST connection error", concat);
            if (outputStream != null) {
                outputStream.close();
            }
            if (zzb != null) {
                zzb.disconnect();
            }
            return 0;
        } catch (Throwable th4) {
            th = th4;
            outputStream = null;
            zzb = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (zzb != null) {
                zzb.disconnect();
            }
            throw th;
        }
    }

    private final void zza(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            do {
            } while (inputStream.read(new byte[1024]) > 0);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    zze("Error closing http connection input stream", e);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    zze("Error closing http connection input stream", e2);
                }
            }
        }
    }

    @VisibleForTesting
    private final HttpURLConnection zzb(URL url) {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(((Integer) zzcf.zzzz.get()).intValue());
            httpURLConnection.setReadTimeout(((Integer) zzcf.zzaaa.get()).intValue());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty(HTTP.USER_AGENT, this.zzabl);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain http connection");
    }

    private final URL zzd(zzck zzck) {
        String valueOf;
        String valueOf2;
        if (zzck.zzet()) {
            valueOf = String.valueOf(zzbx.zzed());
            valueOf2 = String.valueOf(zzbx.zzef());
            valueOf = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        } else {
            valueOf = String.valueOf(zzbx.zzee());
            valueOf2 = String.valueOf(zzbx.zzef());
            valueOf = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        try {
            return new URL(valueOf);
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private final URL zzb(zzck zzck, String str) {
        String zzef;
        String zzed;
        if (zzck.zzet()) {
            zzed = zzbx.zzed();
            zzef = zzbx.zzef();
            zzef = new StringBuilder(((String.valueOf(zzed).length() + 1) + String.valueOf(zzef).length()) + String.valueOf(str).length()).append(zzed).append(zzef).append("?").append(str).toString();
        } else {
            zzed = zzbx.zzee();
            zzef = zzbx.zzef();
            zzef = new StringBuilder(((String.valueOf(zzed).length() + 1) + String.valueOf(zzef).length()) + String.valueOf(str).length()).append(zzed).append(zzef).append("?").append(str).toString();
        }
        try {
            return new URL(zzef);
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private final URL zzfc() {
        String valueOf = String.valueOf(zzbx.zzed());
        String valueOf2 = String.valueOf((String) zzcf.zzzo.get());
        try {
            return new URL(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    @VisibleForTesting
    final String zza(zzck zzck, boolean z) {
        Preconditions.checkNotNull(zzck);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Entry entry : zzck.zzcw().entrySet()) {
                String str = (String) entry.getKey();
                if (!("ht".equals(str) || "qt".equals(str) || "AppUID".equals(str) || "z".equals(str) || "_gmsv".equals(str))) {
                    zza(stringBuilder, str, (String) entry.getValue());
                }
            }
            zza(stringBuilder, "ht", String.valueOf(zzck.zzer()));
            zza(stringBuilder, "qt", String.valueOf(zzbx().currentTimeMillis() - zzck.zzer()));
            if (z) {
                String valueOf;
                long zzeu = zzck.zzeu();
                if (zzeu != 0) {
                    valueOf = String.valueOf(zzeu);
                } else {
                    valueOf = String.valueOf(zzck.zzeq());
                }
                zza(stringBuilder, "z", valueOf);
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            zze("Failed to encode name or value", e);
            return null;
        }
    }

    private static void zza(StringBuilder stringBuilder, String str, String str2) {
        if (stringBuilder.length() != 0) {
            stringBuilder.append('&');
        }
        stringBuilder.append(URLEncoder.encode(str, HTTP.UTF_8));
        stringBuilder.append('=');
        stringBuilder.append(URLEncoder.encode(str2, HTTP.UTF_8));
    }
}
