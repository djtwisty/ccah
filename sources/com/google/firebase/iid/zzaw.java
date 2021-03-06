package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.p013b.C0100a;
import android.support.v4.p017e.C0238a;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Map;

final class zzaw {
    private final SharedPreferences zzdc;
    private final zzy zzdd;
    private final Map<String, zzz> zzde;
    private final Context zzx;

    public zzaw(Context context) {
        this(context, new zzy());
    }

    private zzaw(Context context, zzy zzy) {
        this.zzde = new C0238a();
        this.zzx = context;
        this.zzdc = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.zzdd = zzy;
        File file = new File(C0100a.m127b(this.zzx), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !isEmpty()) {
                    Log.i("FirebaseInstanceId", "App restored, clearing state");
                    zzal();
                    FirebaseInstanceId.getInstance().zzm();
                }
            } catch (IOException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String str = "FirebaseInstanceId";
                    String str2 = "Error creating file in no backup dir: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
            }
        }
    }

    public final synchronized String zzak() {
        return this.zzdc.getString("topic_operaion_queue", "");
    }

    public final synchronized void zzf(String str) {
        this.zzdc.edit().putString("topic_operaion_queue", str).apply();
    }

    private final synchronized boolean isEmpty() {
        return this.zzdc.getAll().isEmpty();
    }

    private static String zza(String str, String str2, String str3) {
        return new StringBuilder(((String.valueOf(str).length() + 4) + String.valueOf(str2).length()) + String.valueOf(str3).length()).append(str).append("|T|").append(str2).append("|").append(str3).toString();
    }

    static String zzd(String str, String str2) {
        return new StringBuilder((String.valueOf(str).length() + 3) + String.valueOf(str2).length()).append(str).append("|S|").append(str2).toString();
    }

    public final synchronized void zzal() {
        this.zzde.clear();
        zzy.zza(this.zzx);
        this.zzdc.edit().clear().commit();
    }

    public final synchronized zzax zzb(String str, String str2, String str3) {
        return zzax.zzi(this.zzdc.getString(zza(str, str2, str3), null));
    }

    public final synchronized void zza(String str, String str2, String str3, String str4, String str5) {
        String zza = zzax.zza(str4, str5, System.currentTimeMillis());
        if (zza != null) {
            Editor edit = this.zzdc.edit();
            edit.putString(zza(str, str2, str3), zza);
            edit.commit();
        }
    }

    public final synchronized void zzc(String str, String str2, String str3) {
        String zza = zza(str, str2, str3);
        Editor edit = this.zzdc.edit();
        edit.remove(zza);
        edit.commit();
    }

    public final synchronized zzz zzg(String str) {
        zzz zzz;
        zzz = (zzz) this.zzde.get(str);
        if (zzz == null) {
            try {
                zzz = this.zzdd.zzb(this.zzx, str);
            } catch (zzaa e) {
                Log.w("FirebaseInstanceId", "Stored data is corrupt, generating new identity");
                FirebaseInstanceId.getInstance().zzm();
                zzz = this.zzdd.zzc(this.zzx, str);
            }
            this.zzde.put(str, zzz);
        }
        return zzz;
    }

    public final synchronized void zzh(String str) {
        String concat = String.valueOf(str).concat("|T|");
        Editor edit = this.zzdc.edit();
        for (String str2 : this.zzdc.getAll().keySet()) {
            if (str2.startsWith(concat)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }
}
