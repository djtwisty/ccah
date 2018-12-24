package de.appplant.cordova.emailcomposer;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v4.p013b.C0206b;
import android.text.Html;
import android.util.Base64;
import android.util.Log;
import android.util.Patterns;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: de.appplant.cordova.emailcomposer.a */
class C0497a {
    C0497a() {
    }

    /* renamed from: a */
    void m1317a(Context context) {
        try {
            File file = new File(context.getExternalCacheDir() + "/email_composer");
            if (file.isDirectory()) {
                for (File delete : file.listFiles()) {
                    delete.delete();
                }
            }
        } catch (Exception e) {
            Log.w("EmailComposer", "Missing external cache dir");
        }
    }

    /* renamed from: a */
    boolean[] m1318a(String str, Context context) {
        boolean i = m1315i(str, context);
        return new boolean[]{m1307b(context), i};
    }

    /* renamed from: a */
    Intent m1316a(JSONObject jSONObject, Context context) {
        Intent a = C0497a.m1297a();
        String optString = jSONObject.optString("app", "mailto:");
        if (jSONObject.has("subject")) {
            m1300a(jSONObject.getString("subject"), a);
        }
        if (jSONObject.has("body")) {
            m1301a(jSONObject.getString("body"), Boolean.valueOf(jSONObject.optBoolean("isHtml")), a);
        }
        if (jSONObject.has("to")) {
            m1302a(jSONObject.getJSONArray("to"), a);
        }
        if (jSONObject.has("cc")) {
            m1306b(jSONObject.getJSONArray("cc"), a);
        }
        if (jSONObject.has("bcc")) {
            m1309c(jSONObject.getJSONArray("bcc"), a);
        }
        if (jSONObject.has("attachments")) {
            m1303a(jSONObject.getJSONArray("attachments"), a, context);
        }
        if (!optString.equals("mailto:") && m1315i(optString, context)) {
            a.setPackage(optString);
        }
        return a;
    }

    /* renamed from: a */
    private void m1300a(String str, Intent intent) {
        intent.putExtra("android.intent.extra.SUBJECT", str);
    }

    /* renamed from: a */
    private void m1301a(String str, Boolean bool, Intent intent) {
        if (bool.booleanValue()) {
            str = Html.fromHtml(str);
        }
        intent.putExtra("android.intent.extra.TEXT", str);
    }

    /* renamed from: a */
    private void m1302a(JSONArray jSONArray, Intent intent) {
        String[] strArr = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            strArr[i] = jSONArray.getString(i);
        }
        intent.putExtra("android.intent.extra.EMAIL", strArr);
    }

    /* renamed from: b */
    private void m1306b(JSONArray jSONArray, Intent intent) {
        String[] strArr = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            strArr[i] = jSONArray.getString(i);
        }
        intent.putExtra("android.intent.extra.CC", strArr);
    }

    /* renamed from: c */
    private void m1309c(JSONArray jSONArray, Intent intent) {
        String[] strArr = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            strArr[i] = jSONArray.getString(i);
        }
        intent.putExtra("android.intent.extra.BCC", strArr);
    }

    /* renamed from: a */
    private void m1303a(JSONArray jSONArray, Intent intent, Context context) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Uri b = m1305b(jSONArray.getString(i), context);
            if (b != null) {
                arrayList.add(b);
            }
        }
        if (!arrayList.isEmpty()) {
            intent.setAction("android.intent.action.SEND_MULTIPLE").setType("message/rfc822").addFlags(1).putExtra("android.intent.extra.STREAM", arrayList);
            if (arrayList.size() <= 1) {
                intent.setAction("android.intent.action.SEND").putExtra("android.intent.extra.STREAM", (Parcelable) arrayList.get(0));
            }
        }
    }

    /* renamed from: b */
    private Uri m1305b(String str, Context context) {
        if (str.startsWith("res:")) {
            return m1312f(str, context);
        }
        if (str.startsWith("app://")) {
            return m1311e(str, context);
        }
        if (str.startsWith("file:///")) {
            return m1308c(str, context);
        }
        if (str.startsWith("file://")) {
            return m1310d(str, context);
        }
        if (str.startsWith("base64:")) {
            return m1313g(str, context);
        }
        return Uri.parse(str);
    }

    /* renamed from: c */
    private Uri m1308c(String str, Context context) {
        File file = new File(str.replaceFirst("file://", ""));
        if (!file.exists()) {
            Log.e("EmailComposer", "File not found: " + file.getAbsolutePath());
        }
        return m1298a(context, file);
    }

    /* renamed from: d */
    private Uri m1310d(String str, Context context) {
        FileOutputStream fileOutputStream;
        Exception e;
        Throwable th;
        String replaceFirst = str.replaceFirst("file:/", "www");
        String substring = replaceFirst.substring(replaceFirst.lastIndexOf(47) + 1);
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            Log.e("EmailComposer", "Missing external cache dir");
            return Uri.EMPTY;
        }
        String str2 = externalCacheDir.toString() + "/email_composer";
        File file = new File(str2, substring);
        new File(str2).mkdir();
        try {
            AssetManager assets = context.getAssets();
            fileOutputStream = new FileOutputStream(file);
            try {
                m1299a(assets.open(replaceFirst), (OutputStream) fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                if (fileOutputStream != null) {
                    C0497a.m1304a(fileOutputStream);
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    Log.e("EmailComposer", "File not found: assets/" + replaceFirst);
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        C0497a.m1304a(fileOutputStream);
                    }
                    return m1298a(context, file);
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        C0497a.m1304a(fileOutputStream);
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
            Log.e("EmailComposer", "File not found: assets/" + replaceFirst);
            e.printStackTrace();
            if (fileOutputStream != null) {
                C0497a.m1304a(fileOutputStream);
            }
            return m1298a(context, file);
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                C0497a.m1304a(fileOutputStream);
            }
            throw th;
        }
        return m1298a(context, file);
    }

    /* renamed from: e */
    private Uri m1311e(String str, Context context) {
        String replaceFirst = str.replaceFirst("app:/", "");
        String substring = replaceFirst.substring(replaceFirst.lastIndexOf(47) + 1);
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            Log.e("EmailComposer", "Missing external cache dir");
            return Uri.EMPTY;
        }
        String str2 = externalCacheDir.toString() + "/email_composer";
        File file = new File(str2, substring);
        new File(str2).mkdir();
        substring = context.getFilesDir().getAbsolutePath() + "/.." + replaceFirst;
        try {
            OutputStream fileOutputStream = new FileOutputStream(file);
            m1299a(new FileInputStream(substring), fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            Log.e("EmailComposer", "File not found: " + substring);
            e.printStackTrace();
        }
        return m1298a(context, file);
    }

    /* renamed from: f */
    private Uri m1312f(String str, Context context) {
        FileOutputStream fileOutputStream;
        Exception e;
        Throwable th;
        String replaceFirst = str.replaceFirst("res://", "");
        String substring = replaceFirst.substring(replaceFirst.lastIndexOf(47) + 1);
        substring = substring.substring(0, substring.lastIndexOf(46));
        String substring2 = replaceFirst.substring(replaceFirst.lastIndexOf(46));
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            Log.e("EmailComposer", "Missing external cache dir");
            return Uri.EMPTY;
        }
        String str2 = externalCacheDir.toString() + "/email_composer";
        int h = m1314h(replaceFirst, context);
        File file = new File(str2, substring + substring2);
        if (h == 0) {
            Log.e("EmailComposer", "File not found: " + replaceFirst);
        }
        new File(str2).mkdir();
        try {
            Resources resources = context.getResources();
            fileOutputStream = new FileOutputStream(file);
            try {
                m1299a(resources.openRawResource(h), (OutputStream) fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                if (fileOutputStream != null) {
                    C0497a.m1304a(fileOutputStream);
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        C0497a.m1304a(fileOutputStream);
                    }
                    return m1298a(context, file);
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        C0497a.m1304a(fileOutputStream);
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
            e.printStackTrace();
            if (fileOutputStream != null) {
                C0497a.m1304a(fileOutputStream);
            }
            return m1298a(context, file);
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                C0497a.m1304a(fileOutputStream);
            }
            throw th;
        }
        return m1298a(context, file);
    }

    /* renamed from: g */
    private Uri m1313g(String str, Context context) {
        FileOutputStream fileOutputStream;
        Exception e;
        Throwable th;
        String substring = str.substring(str.indexOf(":") + 1, str.indexOf("//"));
        String substring2 = str.substring(str.indexOf("//") + 2);
        File externalCacheDir = context.getExternalCacheDir();
        try {
            byte[] decode = Base64.decode(substring2, 0);
            if (externalCacheDir == null) {
                Log.e("EmailComposer", "Missing external cache dir");
                return Uri.EMPTY;
            }
            substring2 = externalCacheDir.toString() + "/email_composer";
            File file = new File(substring2, substring);
            new File(substring2).mkdir();
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(decode);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    if (fileOutputStream != null) {
                        C0497a.m1304a(fileOutputStream);
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            C0497a.m1304a(fileOutputStream);
                        }
                        return m1298a(context, file);
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            C0497a.m1304a(fileOutputStream);
                        }
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                e.printStackTrace();
                if (fileOutputStream != null) {
                    C0497a.m1304a(fileOutputStream);
                }
                return m1298a(context, file);
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    C0497a.m1304a(fileOutputStream);
                }
                throw th;
            }
            return m1298a(context, file);
        } catch (Exception e4) {
            Log.e("EmailComposer", "Invalid Base64 string");
            return Uri.EMPTY;
        }
    }

    /* renamed from: a */
    private void m1299a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    /* renamed from: h */
    private int m1314h(String str, Context context) {
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        String str2 = "drawable";
        if (str.contains("/")) {
            str2 = str.substring(0, str.lastIndexOf(47));
            str = str.substring(str.lastIndexOf(47) + 1);
        }
        String substring = str.substring(0, str.lastIndexOf(46));
        int identifier = resources.getIdentifier(substring, str2, packageName);
        if (identifier == 0) {
            identifier = resources.getIdentifier(substring, "mipmap", packageName);
        }
        if (identifier == 0) {
            return resources.getIdentifier(substring, "drawable", packageName);
        }
        return identifier;
    }

    /* renamed from: a */
    private Uri m1298a(Context context, File file) {
        return C0206b.m630a(context, context.getPackageName() + ".provider", file);
    }

    /* renamed from: b */
    private boolean m1307b(Context context) {
        AccountManager accountManager = AccountManager.get(context);
        try {
            Pattern pattern = Patterns.EMAIL_ADDRESS;
            for (Account account : accountManager.getAccounts()) {
                if (pattern.matcher(account.name).matches()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            Log.i("EmailComposer", "Missing GET_ACCOUNTS permission.");
            return false;
        }
    }

    /* renamed from: i */
    private boolean m1315i(String str, Context context) {
        if (str.equalsIgnoreCase("mailto:")) {
            if (context.getPackageManager().queryIntentActivities(C0497a.m1297a(), 0).size() > 0) {
                return true;
            }
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    /* renamed from: a */
    private static Intent m1297a() {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("mailto:"));
        intent.addFlags(268435456);
        return intent;
    }

    /* renamed from: a */
    private static boolean m1304a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
                return true;
            } catch (IOException e) {
                Log.e("EmailComposer", "Error attempting to safely close resource: " + e.getMessage());
            }
        }
        return false;
    }
}
