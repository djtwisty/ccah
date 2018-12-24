package com.securekeystore.plugin;

import android.content.Context;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* renamed from: com.securekeystore.plugin.a */
public final class C0478a {
    /* renamed from: a */
    public static void m1218a(Context context, String str, byte[] bArr) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput("SKS_KEY_FILE" + str, 0);
            openFileOutput.write(bArr);
            openFileOutput.close();
        } catch (Exception e) {
            Log.e("SecureKeyStore", "Exception: " + e.getMessage());
        }
    }

    /* renamed from: a */
    public static byte[] m1219a(Context context, String str) {
        try {
            FileInputStream openFileInput = context.openFileInput("SKS_KEY_FILE" + str);
            byte[] bArr = new byte[8192];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = openFileInput.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    bArr = byteArrayOutputStream.toByteArray();
                    openFileInput.close();
                    return bArr;
                }
            }
        } catch (Exception e) {
            Log.e("SecureKeyStore", "Exception: " + e.getMessage());
            return new byte[0];
        }
    }

    /* renamed from: b */
    public static void m1220b(Context context, String str) {
        try {
            context.deleteFile("SKS_KEY_FILE" + str);
        } catch (Exception e) {
            Log.e("SecureKeyStore", "Exception: " + e.getMessage());
        }
    }
}
