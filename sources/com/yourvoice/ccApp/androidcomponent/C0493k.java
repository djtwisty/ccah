package com.yourvoice.ccApp.androidcomponent;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import com.google.gson.Gson;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.protocol.HTTP;

/* renamed from: com.yourvoice.ccApp.androidcomponent.k */
public class C0493k {
    /* renamed from: a */
    public static boolean m1277a(String str) {
        if (str == null || "".equals(str) || "null".equals(str)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static void m1276a(Context context, String str) {
        try {
            C0485d c0485d = (C0485d) new Gson().fromJson(str, C0485d.class);
            if (c0485d != null) {
                int parseInt;
                C0490h.m1264c();
                C0492j.m1270a(context, "access_token", c0485d.m1244a());
                C0492j.m1270a(context, "token_type", c0485d.m1245b());
                C0492j.m1270a(context, "user_name", c0485d.m1248e());
                C0492j.m1270a(context, "expires_in", c0485d.m1246c());
                C0492j.m1270a(context, "scope", c0485d.m1249f());
                C0492j.m1270a(context, ".expires", c0485d.m1251h());
                C0492j.m1270a(context, ".issued", c0485d.m1250g());
                C0492j.m1270a(context, "refresh_token", c0485d.m1247d());
                String str2 = "0";
                String b = C0492j.m1272b(context, "expires_in", str2);
                if (b.equals("")) {
                    parseInt = Integer.parseInt(str2);
                } else {
                    parseInt = Integer.parseInt(b);
                }
                if (parseInt != 0) {
                    C0492j.m1269a(context, "expire_minute", parseInt / 60);
                }
                if (C0493k.m1277a(c0485d.m1252i())) {
                    C0493k.m1275a(context);
                    return;
                }
                return;
            }
            C0493k.m1275a(context);
        } catch (Exception e) {
            C0493k.m1275a(context);
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m1275a(Context context) {
        C0490h.m1263b();
        ArrayList arrayList = new ArrayList();
        arrayList.add("access_token");
        arrayList.add("token_type");
        arrayList.add("user_name");
        arrayList.add("expires_in");
        arrayList.add("scope");
        arrayList.add(".expires");
        arrayList.add(".issued");
        arrayList.add("refresh_token");
        int i = 0;
        while (i < arrayList.size()) {
            try {
                C0492j.m1270a(context, (String) arrayList.get(i), "");
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    /* renamed from: b */
    public static boolean m1281b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static String m1273a() {
        String str = "";
        Calendar instance = Calendar.getInstance();
        int i = instance.get(11);
        return instance.get(1) + "-" + instance.get(2) + "-" + instance.get(5) + " " + i + ":" + instance.get(12);
    }

    /* renamed from: c */
    public static boolean m1282c(Context context) {
        int parseInt;
        String b = C0492j.m1272b(context, "initial_time", C0493k.m1273a());
        String str = "0";
        String b2 = C0492j.m1272b(context, "expires_in", str);
        if (b2.equals("")) {
            parseInt = Integer.parseInt(str);
        } else {
            parseInt = Integer.parseInt(b2);
        }
        if (parseInt != 0) {
            C0492j.m1269a(context, "expire_minute", parseInt / 60);
        }
        parseInt = C0492j.m1271b(context, "expire_minute", 0);
        long a = C0484c.m1242a(C0484c.m1243a(b), C0484c.m1243a(C0493k.m1273a()));
        if (a == ((long) (parseInt - 5))) {
            return true;
        }
        if (a >= ((long) parseInt)) {
            C0493k.m1283d(context);
            return true;
        } else if (a >= 0) {
            return false;
        } else {
            C0493k.m1283d(context);
            return true;
        }
    }

    /* renamed from: d */
    public static void m1283d(Context context) {
        C0492j.m1270a(context, "access_token", "");
        C0492j.m1270a(context, "token_type", "");
        C0492j.m1270a(context, "user_name", "");
        C0492j.m1270a(context, "expires_in", "");
        C0492j.m1270a(context, "scope", "");
        C0492j.m1270a(context, ".expires", "");
        C0492j.m1270a(context, ".issued", "");
        C0492j.m1270a(context, "refresh_token", "");
    }

    /* renamed from: e */
    public static boolean m1284e(Context context) {
        String b = C0492j.m1272b(context, "initial_notification_time", C0493k.m1273a());
        int b2 = C0492j.m1271b(context, "poll_time", 600);
        if (C0484c.m1242a(C0484c.m1243a(b), C0484c.m1243a(C0493k.m1273a())) * 60 >= ((long) b2)) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public static String m1285f(Context context) {
        String str = "";
        try {
            str = Locale.getDefault().getLanguage();
            C0492j.m1270a(context, "locale", str);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    /* renamed from: a */
    public static byte[] m1278a(String str, String str2, byte[] bArr) {
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(str.getBytes());
        byte[] digest = instance.digest();
        MessageDigest instance2 = MessageDigest.getInstance("SHA-256");
        instance2.update(str2.getBytes());
        return C0493k.m1279a(digest, instance2.digest(), bArr);
    }

    /* renamed from: a */
    static byte[] m1279a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        Key secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr3);
    }

    /* renamed from: a */
    public static String m1274a(String str, String str2, String str3) {
        return new String(C0493k.m1278a(str2, str2, Base64.decode(str3.getBytes(HTTP.UTF_8), 0)), HTTP.UTF_8);
    }

    /* renamed from: b */
    public static void m1280b() {
        try {
            C0490h.f828g = C0493k.m1274a("Network Error", "Connection Lost", new String(C0490h.f832k));
            C0490h.f829h = C0493k.m1274a("Wrong Enter", "Invalid Password", new String(C0490h.f833l));
            C0490h.f830i = C0493k.m1274a("Cannot change name", "Cannot Rename", new String(C0490h.f834m));
            C0490h.f831j = C0493k.m1274a("Invalid Credential", "Login Failed", new String(C0490h.f835n));
        } catch (Exception e) {
        }
    }
}
