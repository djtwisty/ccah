package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;

public final class zzas extends zzcs {
    private long zzade = -1;
    private char zzals = '\u0000';
    private String zzalt;
    private final zzau zzalu = new zzau(this, 6, false, false);
    private final zzau zzalv = new zzau(this, 6, true, false);
    private final zzau zzalw = new zzau(this, 6, false, true);
    private final zzau zzalx = new zzau(this, 5, false, false);
    private final zzau zzaly = new zzau(this, 5, true, false);
    private final zzau zzalz = new zzau(this, 5, false, true);
    private final zzau zzama = new zzau(this, 4, false, false);
    private final zzau zzamb = new zzau(this, 3, false, false);
    private final zzau zzamc = new zzau(this, 2, false, false);

    zzas(zzbw zzbw) {
        super(zzbw);
    }

    public final zzau zzjg() {
        return this.zzalu;
    }

    public final zzau zzjh() {
        return this.zzalv;
    }

    public final zzau zzji() {
        return this.zzalw;
    }

    public final zzau zzjj() {
        return this.zzalx;
    }

    public final zzau zzjk() {
        return this.zzaly;
    }

    public final zzau zzjl() {
        return this.zzalz;
    }

    public final zzau zzjm() {
        return this.zzama;
    }

    public final zzau zzjn() {
        return this.zzamb;
    }

    public final zzau zzjo() {
        return this.zzamc;
    }

    protected final boolean zzgy() {
        return false;
    }

    protected static Object zzbw(String str) {
        if (str == null) {
            return null;
        }
        return new zzav(str);
    }

    protected final void zza(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        int i2 = 0;
        if (!z && isLoggable(i)) {
            zza(i, zza(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            Preconditions.checkNotNull(str);
            zzcs zzkl = this.zzada.zzkl();
            if (zzkl == null) {
                zza(6, "Scheduler not set. Not logging error/warn");
            } else if (zzkl.isInitialized()) {
                if (i >= 0) {
                    i2 = i;
                }
                if (i2 >= 9) {
                    i2 = 8;
                }
                zzkl.zzc(new zzat(this, i2, str, obj, obj2, obj3));
            } else {
                zza(6, "Scheduler not initialized. Not logging error/warn");
            }
        }
    }

    @VisibleForTesting
    protected final boolean isLoggable(int i) {
        return Log.isLoggable(zzjp(), i);
    }

    @VisibleForTesting
    protected final void zza(int i, String str) {
        Log.println(i, zzjp(), str);
    }

    @VisibleForTesting
    private final String zzjp() {
        String str;
        synchronized (this) {
            if (this.zzalt == null) {
                if (this.zzada.zzkq() != null) {
                    this.zzalt = this.zzada.zzkq();
                } else {
                    this.zzalt = zzq.zzhy();
                }
            }
            str = this.zzalt;
        }
        return str;
    }

    static String zza(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            str = "";
        }
        Object zza = zza(z, obj);
        Object zza2 = zza(z, obj2);
        Object zza3 = zza(z, obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(zza)) {
            stringBuilder.append(str2);
            stringBuilder.append(zza);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zza2)) {
            stringBuilder.append(str2);
            stringBuilder.append(zza2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zza3)) {
            stringBuilder.append(str2);
            stringBuilder.append(zza3);
        }
        return stringBuilder.toString();
    }

    @VisibleForTesting
    private static String zza(boolean z, Object obj) {
        if (obj == null) {
            return "";
        }
        Object valueOf;
        if (obj instanceof Integer) {
            valueOf = Long.valueOf((long) ((Integer) obj).intValue());
        } else {
            valueOf = obj;
        }
        if (valueOf instanceof Long) {
            if (!z) {
                return String.valueOf(valueOf);
            }
            if (Math.abs(((Long) valueOf).longValue()) < 100) {
                return String.valueOf(valueOf);
            }
            String str = String.valueOf(valueOf).charAt(0) == '-' ? "-" : "";
            String valueOf2 = String.valueOf(Math.abs(((Long) valueOf).longValue()));
            return new StringBuilder((String.valueOf(str).length() + 43) + String.valueOf(str).length()).append(str).append(Math.round(Math.pow(10.0d, (double) (valueOf2.length() - 1)))).append("...").append(str).append(Math.round(Math.pow(10.0d, (double) valueOf2.length()) - 1.0d)).toString();
        } else if (valueOf instanceof Boolean) {
            return String.valueOf(valueOf);
        } else {
            if (valueOf instanceof Throwable) {
                Throwable th = (Throwable) valueOf;
                StringBuilder stringBuilder = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String zzbx = zzbx(AppMeasurement.class.getCanonicalName());
                String zzbx2 = zzbx(zzbw.class.getCanonicalName());
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (!stackTraceElement.isNativeMethod()) {
                        String className = stackTraceElement.getClassName();
                        if (className != null) {
                            className = zzbx(className);
                            if (className.equals(zzbx) || className.equals(zzbx2)) {
                                stringBuilder.append(": ");
                                stringBuilder.append(stackTraceElement);
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return stringBuilder.toString();
            } else if (valueOf instanceof zzav) {
                return ((zzav) valueOf).zzaml;
            } else {
                if (z) {
                    return "-";
                }
                return String.valueOf(valueOf);
            }
        }
    }

    private static String zzbx(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    public final String zzjq() {
        Pair zzfm = zzgu().zzamz.zzfm();
        if (zzfm == null || zzfm == zzbd.zzamy) {
            return null;
        }
        String valueOf = String.valueOf(zzfm.second);
        String str = (String) zzfm.first;
        return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()).append(valueOf).append(":").append(str).toString();
    }

    public final /* bridge */ /* synthetic */ void zzgf() {
        super.zzgf();
    }

    public final /* bridge */ /* synthetic */ void zzgg() {
        super.zzgg();
    }

    public final /* bridge */ /* synthetic */ void zzgh() {
        super.zzgh();
    }

    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    public final /* bridge */ /* synthetic */ zzaa zzgp() {
        return super.zzgp();
    }

    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final /* bridge */ /* synthetic */ zzaq zzgq() {
        return super.zzgq();
    }

    public final /* bridge */ /* synthetic */ zzfy zzgr() {
        return super.zzgr();
    }

    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    public final /* bridge */ /* synthetic */ zzas zzgt() {
        return super.zzgt();
    }

    public final /* bridge */ /* synthetic */ zzbd zzgu() {
        return super.zzgu();
    }

    public final /* bridge */ /* synthetic */ zzq zzgv() {
        return super.zzgv();
    }

    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }
}
