package com.securekeystore.plugin;

import android.content.Context;
import android.os.Build.VERSION;
import android.security.KeyPairGeneratorSpec.Builder;
import android.util.Log;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.security.auth.x500.X500Principal;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;

public class SecureKeyStore extends CordovaPlugin {
    public boolean execute(String str, JSONArray jSONArray, CallbackContext callbackContext) {
        if (str.equals("set")) {
            m1214a(jSONArray.getString(0), jSONArray.getString(1), callbackContext);
            return true;
        } else if (str.equals("get")) {
            m1215a(jSONArray.getString(0), callbackContext);
            return true;
        } else if (!str.equals(ProductAction.ACTION_REMOVE)) {
            return false;
        } else {
            m1217b(jSONArray.getString(0), callbackContext);
            return true;
        }
    }

    /* renamed from: a */
    private void m1214a(String str, String str2, CallbackContext callbackContext) {
        try {
            KeyStore instance = KeyStore.getInstance(m1216b());
            instance.load(null);
            if (!instance.containsAlias(str)) {
                Calendar instance2 = Calendar.getInstance();
                Calendar instance3 = Calendar.getInstance();
                instance3.add(1, 1);
                AlgorithmParameterSpec build = new Builder(m1213a()).setAlias(str).setSubject(new X500Principal("CN=" + str)).setSerialNumber(BigInteger.ONE).setStartDate(instance2.getTime()).setEndDate(instance3.getTime()).build();
                KeyPairGenerator instance4 = KeyPairGenerator.getInstance("RSA", m1216b());
                instance4.initialize(build);
                instance4.generateKeyPair();
                Log.i("SecureKeyStore", "created new key pairs");
            }
            Key publicKey = instance.getCertificate(str).getPublicKey();
            if (str2.isEmpty()) {
                Log.d("SecureKeyStore", "Exception: input text is empty");
                return;
            }
            Cipher instance5 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance5.init(1, publicKey);
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, instance5);
            cipherOutputStream.write(str2.getBytes(HTTP.UTF_8));
            cipherOutputStream.close();
            C0478a.m1218a(m1213a(), str, byteArrayOutputStream.toByteArray());
            Log.i("SecureKeyStore", "key created and stored successfully");
            callbackContext.success("key created and stored successfully");
        } catch (Exception e) {
            Log.e("SecureKeyStore", "Exception: " + e.getMessage());
            callbackContext.error("{\"code\":9,\"api-level\":" + VERSION.SDK_INT + ",\"message\":" + e.getMessage() + "}");
        }
    }

    /* renamed from: a */
    private void m1215a(String str, CallbackContext callbackContext) {
        try {
            KeyStore instance = KeyStore.getInstance(m1216b());
            instance.load(null);
            PrivateKey privateKey = (PrivateKey) instance.getKey(str, null);
            Cipher instance2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance2.init(2, privateKey);
            CipherInputStream cipherInputStream = new CipherInputStream(new ByteArrayInputStream(C0478a.m1219a(m1213a(), str)), instance2);
            ArrayList arrayList = new ArrayList();
            while (true) {
                int read = cipherInputStream.read();
                if (read == -1) {
                    break;
                }
                arrayList.add(Byte.valueOf((byte) read));
            }
            byte[] bArr = new byte[arrayList.size()];
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = ((Byte) arrayList.get(i)).byteValue();
            }
            callbackContext.success(new String(bArr, 0, bArr.length, HTTP.UTF_8));
        } catch (Exception e) {
            Log.e("SecureKeyStore", "Exception: " + e.getMessage());
            callbackContext.error("{\"code\":1,\"api-level\":" + VERSION.SDK_INT + ",\"message\":" + e.getMessage() + "}");
        }
    }

    /* renamed from: b */
    private void m1217b(String str, CallbackContext callbackContext) {
        try {
            C0478a.m1220b(m1213a(), str);
            Log.i("SecureKeyStore", "keys removed successfully");
            callbackContext.success("keys removed successfully");
        } catch (Exception e) {
            Log.e("SecureKeyStore", "Exception: " + e.getMessage());
            callbackContext.error("{\"code\":6,\"api-level\":" + VERSION.SDK_INT + ",\"message\":" + e.getMessage() + "}");
        }
    }

    /* renamed from: a */
    private Context m1213a() {
        return this.cordova.getActivity().getApplicationContext();
    }

    /* renamed from: b */
    private String m1216b() {
        try {
            KeyStore.getInstance("AndroidKeyStore");
            return "AndroidKeyStore";
        } catch (Exception e) {
            try {
                KeyStore.getInstance("AndroidKeyStoreBCWorkaround");
                return "AndroidKeyStoreBCWorkaround";
            } catch (Exception e2) {
                return "AndroidOpenSSL";
            }
        }
    }
}
