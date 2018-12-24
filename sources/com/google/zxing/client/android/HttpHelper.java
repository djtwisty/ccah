package com.google.zxing.client.android;

import android.util.Log;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.protocol.HTTP;

public final class HttpHelper {
    private static final Collection<String> REDIRECTOR_DOMAINS = new HashSet(Arrays.asList(new String[]{"amzn.to", "bit.ly", "bitly.com", "fb.me", "goo.gl", "is.gd", "j.mp", "lnkd.in", "ow.ly", "R.BEETAGG.COM", "r.beetagg.com", "SCN.BY", "su.pr", "t.co", "tinyurl.com", "tr.im"}));
    private static final String TAG = HttpHelper.class.getSimpleName();

    public enum ContentType {
        HTML,
        JSON,
        XML,
        TEXT
    }

    private HttpHelper() {
    }

    public static CharSequence downloadViaHttp(String str, ContentType contentType) {
        return downloadViaHttp(str, contentType, (int) BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public static CharSequence downloadViaHttp(String str, ContentType contentType, int i) {
        String str2;
        switch (contentType) {
            case HTML:
                str2 = "application/xhtml+xml,text/html,text/*,*/*";
                break;
            case JSON:
                str2 = "application/json,text/*,*/*";
                break;
            case XML:
                str2 = "application/xml,text/*,*/*";
                break;
            default:
                str2 = "text/*,*/*";
                break;
        }
        return downloadViaHttp(str, str2, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.CharSequence downloadViaHttp(java.lang.String r5, java.lang.String r6, int r7) {
        /*
        r0 = 0;
    L_0x0001:
        r1 = 5;
        if (r0 >= r1) goto L_0x0067;
    L_0x0004:
        r1 = new java.net.URL;
        r1.<init>(r5);
        r1 = safelyOpenConnection(r1);
        r2 = 1;
        r1.setInstanceFollowRedirects(r2);
        r2 = "Accept";
        r1.setRequestProperty(r2, r6);
        r2 = "Accept-Charset";
        r3 = "utf-8,*";
        r1.setRequestProperty(r2, r3);
        r2 = "User-Agent";
        r3 = "ZXing (Android)";
        r1.setRequestProperty(r2, r3);
        r2 = safelyConnect(r1);	 Catch:{ all -> 0x0044 }
        switch(r2) {
            case 200: goto L_0x0049;
            case 302: goto L_0x0051;
            default: goto L_0x002b;
        };	 Catch:{ all -> 0x0044 }
    L_0x002b:
        r0 = new java.io.IOException;	 Catch:{ all -> 0x0044 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0044 }
        r3.<init>();	 Catch:{ all -> 0x0044 }
        r4 = "Bad HTTP response: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0044 }
        r2 = r3.append(r2);	 Catch:{ all -> 0x0044 }
        r2 = r2.toString();	 Catch:{ all -> 0x0044 }
        r0.<init>(r2);	 Catch:{ all -> 0x0044 }
        throw r0;	 Catch:{ all -> 0x0044 }
    L_0x0044:
        r0 = move-exception;
        r1.disconnect();
        throw r0;
    L_0x0049:
        r0 = consume(r1, r7);	 Catch:{ all -> 0x0044 }
        r1.disconnect();
        return r0;
    L_0x0051:
        r2 = "Location";
        r5 = r1.getHeaderField(r2);	 Catch:{ all -> 0x0044 }
        if (r5 == 0) goto L_0x005f;
    L_0x0059:
        r0 = r0 + 1;
        r1.disconnect();
        goto L_0x0001;
    L_0x005f:
        r0 = new java.io.IOException;	 Catch:{ all -> 0x0044 }
        r2 = "No Location";
        r0.<init>(r2);	 Catch:{ all -> 0x0044 }
        throw r0;	 Catch:{ all -> 0x0044 }
    L_0x0067:
        r0 = new java.io.IOException;
        r1 = "Too many redirects";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.android.HttpHelper.downloadViaHttp(java.lang.String, java.lang.String, int):java.lang.CharSequence");
    }

    private static String getEncoding(URLConnection uRLConnection) {
        String headerField = uRLConnection.getHeaderField(HTTP.CONTENT_TYPE);
        if (headerField != null) {
            int indexOf = headerField.indexOf("charset=");
            if (indexOf >= 0) {
                return headerField.substring(indexOf + "charset=".length());
            }
        }
        return HTTP.UTF_8;
    }

    private static CharSequence consume(URLConnection uRLConnection, int i) {
        Throwable th;
        String encoding = getEncoding(uRLConnection);
        CharSequence stringBuilder = new StringBuilder();
        Reader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(uRLConnection.getInputStream(), encoding);
            try {
                char[] cArr = new char[1024];
                while (stringBuilder.length() < i) {
                    int read = inputStreamReader.read(cArr);
                    if (read <= 0) {
                        break;
                    }
                    stringBuilder.append(cArr, 0, read);
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e) {
                    } catch (NullPointerException e2) {
                    }
                }
                return stringBuilder;
            } catch (Throwable th2) {
                th = th2;
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e3) {
                    } catch (NullPointerException e4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            throw th;
        }
    }

    public static URI unredirect(URI uri) {
        if (!REDIRECTOR_DOMAINS.contains(uri.getHost())) {
            return uri;
        }
        HttpURLConnection safelyOpenConnection = safelyOpenConnection(uri.toURL());
        safelyOpenConnection.setInstanceFollowRedirects(false);
        safelyOpenConnection.setDoInput(false);
        safelyOpenConnection.setRequestMethod(HttpHead.METHOD_NAME);
        safelyOpenConnection.setRequestProperty(HTTP.USER_AGENT, "ZXing (Android)");
        try {
            switch (safelyConnect(safelyOpenConnection)) {
                case HttpStatus.SC_MULTIPLE_CHOICES /*300*/:
                case HttpStatus.SC_MOVED_PERMANENTLY /*301*/:
                case HttpStatus.SC_MOVED_TEMPORARILY /*302*/:
                case HttpStatus.SC_SEE_OTHER /*303*/:
                case HttpStatus.SC_TEMPORARY_REDIRECT /*307*/:
                    String headerField = safelyOpenConnection.getHeaderField("Location");
                    if (headerField != null) {
                        try {
                            URI uri2 = new URI(headerField);
                            safelyOpenConnection.disconnect();
                            return uri2;
                        } catch (URISyntaxException e) {
                            break;
                        }
                    }
                    break;
            }
            safelyOpenConnection.disconnect();
            return uri;
        } catch (Throwable th) {
            safelyOpenConnection.disconnect();
        }
    }

    private static HttpURLConnection safelyOpenConnection(URL url) {
        try {
            URLConnection openConnection = url.openConnection();
            if (openConnection instanceof HttpURLConnection) {
                return (HttpURLConnection) openConnection;
            }
            throw new IOException();
        } catch (Throwable e) {
            Log.w(TAG, "Bad URI? " + url);
            throw new IOException(e);
        }
    }

    private static int safelyConnect(HttpURLConnection httpURLConnection) {
        Throwable e;
        try {
            httpURLConnection.connect();
            try {
                return httpURLConnection.getResponseCode();
            } catch (NullPointerException e2) {
                e = e2;
                throw new IOException(e);
            } catch (StringIndexOutOfBoundsException e3) {
                e = e3;
                throw new IOException(e);
            } catch (IllegalArgumentException e4) {
                e = e4;
                throw new IOException(e);
            }
        } catch (NullPointerException e5) {
            e = e5;
            throw new IOException(e);
        } catch (IllegalArgumentException e6) {
            e = e6;
            throw new IOException(e);
        } catch (IndexOutOfBoundsException e7) {
            e = e7;
            throw new IOException(e);
        } catch (SecurityException e8) {
            e = e8;
            throw new IOException(e);
        }
    }
}
