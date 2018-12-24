package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;
import java.util.Map.Entry;

public class zzcp extends zzau {
    private static zzcp zzabh;

    public zzcp(zzaw zzaw) {
        super(zzaw);
    }

    protected final void zzag() {
        synchronized (zzcp.class) {
            zzabh = this;
        }
    }

    public static zzcp zzex() {
        return zzabh;
    }

    public final void zza(zzck zzck, String str) {
        Object zzck2 = zzck != null ? zzck.toString() : "no hit data";
        String str2 = "Discarding hit. ";
        String valueOf = String.valueOf(str);
        zzd(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), zzck2);
    }

    public final void zza(Map<String, String> map, String str) {
        Object stringBuilder;
        if (map != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (Entry entry : map.entrySet()) {
                if (stringBuilder2.length() > 0) {
                    stringBuilder2.append(',');
                }
                stringBuilder2.append((String) entry.getKey());
                stringBuilder2.append('=');
                stringBuilder2.append((String) entry.getValue());
            }
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = "no hit data";
        }
        String str2 = "Discarding hit. ";
        String valueOf = String.valueOf(str);
        zzd(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), stringBuilder);
    }

    public final synchronized void zzb(int i, String str, Object obj, Object obj2, Object obj3) {
        int i2 = 0;
        synchronized (this) {
            int i3;
            char c;
            Preconditions.checkNotNull(str);
            if (i >= 0) {
                i2 = i;
            }
            if (i2 >= 9) {
                i3 = 8;
            } else {
                i3 = i2;
            }
            if (zzbz().zzdw()) {
                c = 'C';
            } else {
                c = 'c';
            }
            char charAt = "01VDIWEA?".charAt(i3);
            String str2 = zzav.VERSION;
            String zzc = zzat.zzc(str, zzd(obj), zzd(obj2), zzd(obj3));
            String stringBuilder = new StringBuilder((String.valueOf(str2).length() + 4) + String.valueOf(zzc).length()).append("3").append(charAt).append(c).append(str2).append(":").append(zzc).toString();
            if (stringBuilder.length() > 1024) {
                stringBuilder = stringBuilder.substring(0, 1024);
            }
            zzct zzcp = zzbw().zzcp();
            if (zzcp != null) {
                zzcp.zzfk().zzad(stringBuilder);
            }
        }
    }

    @VisibleForTesting
    private static String zzd(Object obj) {
        if (obj == null) {
            return null;
        }
        Object valueOf;
        if (obj instanceof Integer) {
            valueOf = Long.valueOf((long) ((Integer) obj).intValue());
        } else {
            valueOf = obj;
        }
        if (valueOf instanceof Long) {
            if (Math.abs(((Long) valueOf).longValue()) < 100) {
                return String.valueOf(valueOf);
            }
            String str = String.valueOf(valueOf).charAt(0) == '-' ? "-" : "";
            String valueOf2 = String.valueOf(Math.abs(((Long) valueOf).longValue()));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(Math.round(Math.pow(10.0d, (double) (valueOf2.length() - 1))));
            stringBuilder.append("...");
            stringBuilder.append(str);
            stringBuilder.append(Math.round(Math.pow(10.0d, (double) valueOf2.length()) - 1.0d));
            return stringBuilder.toString();
        } else if (valueOf instanceof Boolean) {
            return String.valueOf(valueOf);
        } else {
            if (valueOf instanceof Throwable) {
                return valueOf.getClass().getCanonicalName();
            }
            return "-";
        }
    }
}
