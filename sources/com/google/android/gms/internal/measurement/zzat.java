package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

public class zzat {
    private final zzaw zzvy;

    protected zzat(zzaw zzaw) {
        Preconditions.checkNotNull(zzaw);
        this.zzvy = zzaw;
    }

    public final zzaw zzbw() {
        return this.zzvy;
    }

    protected final Clock zzbx() {
        return this.zzvy.zzbx();
    }

    protected final Context getContext() {
        return this.zzvy.getContext();
    }

    protected final zzcp zzby() {
        return this.zzvy.zzby();
    }

    protected final zzbx zzbz() {
        return this.zzvy.zzbz();
    }

    protected final zzk zzca() {
        return this.zzvy.zzca();
    }

    public final GoogleAnalytics zzcb() {
        return this.zzvy.zzco();
    }

    protected final zzal zzcc() {
        return this.zzvy.zzcc();
    }

    protected final zzcc zzcd() {
        return this.zzvy.zzcd();
    }

    protected final zzdh zzce() {
        return this.zzvy.zzce();
    }

    protected final zzct zzcf() {
        return this.zzvy.zzcf();
    }

    protected final zzbo zzcg() {
        return this.zzvy.zzcr();
    }

    protected final zzak zzch() {
        return this.zzvy.zzcq();
    }

    protected final zzbh zzci() {
        return this.zzvy.zzci();
    }

    protected final zzcb zzcj() {
        return this.zzvy.zzcj();
    }

    public final void zzq(String str) {
        zza(2, str, null, null, null);
    }

    public final void zza(String str, Object obj) {
        zza(2, str, obj, null, null);
    }

    public final void zza(String str, Object obj, Object obj2) {
        zza(2, str, obj, obj2, null);
    }

    public final void zzr(String str) {
        zza(3, str, null, null, null);
    }

    public final void zzb(String str, Object obj) {
        zza(3, str, obj, null, null);
    }

    public final void zzb(String str, Object obj, Object obj2) {
        zza(3, str, obj, obj2, null);
    }

    public final void zza(String str, Object obj, Object obj2, Object obj3) {
        zza(3, str, obj, obj2, obj3);
    }

    public final void zzs(String str) {
        zza(4, str, null, null, null);
    }

    public final void zzc(String str, Object obj) {
        zza(4, str, obj, null, null);
    }

    public final void zzt(String str) {
        zza(5, str, null, null, null);
    }

    public final void zzd(String str, Object obj) {
        zza(5, str, obj, null, null);
    }

    public final void zzc(String str, Object obj, Object obj2) {
        zza(5, str, obj, obj2, null);
    }

    public final void zzb(String str, Object obj, Object obj2, Object obj3) {
        zza(5, str, obj, obj2, obj3);
    }

    public final void zzu(String str) {
        zza(6, str, null, null, null);
    }

    public final void zze(String str, Object obj) {
        zza(6, str, obj, null, null);
    }

    public final void zzd(String str, Object obj, Object obj2) {
        zza(6, str, obj, obj2, null);
    }

    public static boolean zzck() {
        return Log.isLoggable((String) zzcf.zzyx.get(), 2);
    }

    private final void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        zzcp zzcp = null;
        if (this.zzvy != null) {
            zzcp = this.zzvy.zzcn();
        }
        if (zzcp != null) {
            String str2 = (String) zzcf.zzyx.get();
            if (Log.isLoggable(str2, i)) {
                Log.println(i, str2, zzc(str, obj, obj2, obj3));
            }
            if (i >= 5) {
                zzcp.zzb(i, str, obj, obj2, obj3);
                return;
            }
            return;
        }
        String str3 = (String) zzcf.zzyx.get();
        if (Log.isLoggable(str3, i)) {
            Log.println(i, str3, zzc(str, obj, obj2, obj3));
        }
    }

    protected static String zzc(String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            str = "";
        }
        Object zzb = zzb(obj);
        Object zzb2 = zzb(obj2);
        Object zzb3 = zzb(obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(zzb)) {
            stringBuilder.append(str2);
            stringBuilder.append(zzb);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzb2)) {
            stringBuilder.append(str2);
            stringBuilder.append(zzb2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzb3)) {
            stringBuilder.append(str2);
            stringBuilder.append(zzb3);
        }
        return stringBuilder.toString();
    }

    private static String zzb(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Boolean) {
            return obj == Boolean.TRUE ? "true" : "false";
        } else {
            if (obj instanceof Throwable) {
                return ((Throwable) obj).toString();
            }
            return obj.toString();
        }
    }
}
