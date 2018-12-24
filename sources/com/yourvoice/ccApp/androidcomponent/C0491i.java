package com.yourvoice.ccApp.androidcomponent;

import android.content.Context;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AUTH;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;

/* renamed from: com.yourvoice.ccApp.androidcomponent.i */
public class C0491i {
    /* renamed from: a */
    public static String m1268a(String str, String str2) {
        String str3 = "";
        try {
            HttpClient defaultHttpClient = new DefaultHttpClient();
            HttpUriRequest httpPost = new HttpPost(new URI(str));
            Log.e("TAG", "ENTITY VALUE " + str2);
            HttpConnectionParams.setConnectionTimeout(new BasicHttpParams(), 10000);
            httpPost.setHeader(HTTP.CONTENT_TYPE, "application/json");
            httpPost.setHeader("Accept", "application/json");
            httpPost.setEntity(new StringEntity(str2));
            HttpEntity entity = defaultHttpClient.execute(httpPost).getEntity();
            str3 = C0491i.m1267a(entity.getContent());
            Log.e("", "Result: " + str3);
            if (entity != null) {
                entity.consumeContent();
            }
            if (str3 == null) {
                str3 = "";
            }
            Log.e("TAG", " post : result :: " + str3);
            defaultHttpClient.getConnectionManager().shutdown();
        } catch (ConnectTimeoutException e) {
            Log.e("TAG", "postMethod Exception: " + e);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str3;
    }

    /* renamed from: a */
    public static String m1265a(Context context, String str, String str2) {
        String str3 = "";
        try {
            String str4 = str + "?notificationtype=" + 3;
            HttpUriRequest httpGet = new HttpGet(str4);
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 20000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
            Log.e("TAG", "get Url " + str4);
            httpGet.addHeader(AUTH.WWW_AUTH_RESP, "bearer " + str2);
            Log.e("TAG", "get Url Token" + str2);
            httpGet.setHeader(HTTP.CONTENT_TYPE, "application/json");
            httpGet.setHeader("Accept", "application/json");
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
            HttpEntity entity = defaultHttpClient.execute(httpGet).getEntity();
            str3 = C0491i.m1267a(entity.getContent());
            if (entity != null) {
                entity.consumeContent();
            }
            if (str3 == null) {
                str3 = "";
            }
            defaultHttpClient.getConnectionManager().shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str3;
    }

    /* renamed from: a */
    public static String m1266a(Context context, String str, String str2, int i, int i2, String str3) {
        String str4;
        Exception e;
        try {
            C0492j.m1270a(context, "initial_notification_time", C0493k.m1273a());
            str4 = str + "?count=" + 20 + "&startindex=0&locale=" + str2;
            HttpUriRequest httpGet = new HttpGet(str4);
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 20000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
            Log.e("TAG", "get Url " + str4);
            httpGet.addHeader(AUTH.WWW_AUTH_RESP, "bearer " + str3);
            Log.e("TAG", "get User Token" + str3);
            httpGet.setHeader(HTTP.CONTENT_TYPE, "application/json");
            httpGet.setHeader("Accept", "application/json");
            httpGet.setHeader("charset", "utf-8");
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
            HttpResponse execute = defaultHttpClient.execute(httpGet);
            Header[] allHeaders = execute.getAllHeaders();
            str4 = "600";
            if (allHeaders.length > 0) {
                for (int i3 = 0; i3 < allHeaders.length; i3++) {
                    if (allHeaders[i3].getName().equals("MPay-Poll-Time")) {
                        str4 = allHeaders[i3].getValue();
                    }
                }
            }
            Log.e("TAG", "Poll Time" + str4);
            C0492j.m1269a(context, "poll_time", Integer.parseInt(str4));
            HttpEntity entity = execute.getEntity();
            str4 = C0491i.m1267a(entity.getContent());
            if (entity != null) {
                try {
                    entity.consumeContent();
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return str4;
                }
            }
            if (str4 == null) {
                str4 = "";
            }
            Log.e("TAG", "Notification JSOn:::::" + str4);
            defaultHttpClient.getConnectionManager().shutdown();
        } catch (Exception e3) {
            e = e3;
            str4 = "";
            e.printStackTrace();
            return str4;
        }
        return str4;
    }

    /* renamed from: a */
    public static String m1267a(InputStream inputStream) {
        String str = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, HTTP.UTF_8));
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(readLine + "\n");
            }
            inputStream.close();
            str = stringBuilder.toString();
        } catch (Exception e) {
        }
        return str;
    }
}
