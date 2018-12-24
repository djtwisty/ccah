package com.google.android.gms.internal.measurement;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzsi<T> {
    private static final Object zzbrm = new Object();
    private static boolean zzbrn = false;
    private static final AtomicInteger zzbrq = new AtomicInteger();
    @SuppressLint({"StaticFieldLeak"})
    private static Context zzri = null;
    private final String name;
    private volatile T zzalj;
    private final zzso zzbro;
    private final T zzbrp;
    private volatile int zzbrr;

    public static void zzae(Context context) {
        synchronized (zzbrm) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzri != context) {
                synchronized (zzrx.class) {
                    zzrx.zzbrb.clear();
                }
                synchronized (zzsp.class) {
                    zzsp.zzbrz.clear();
                }
                synchronized (zzse.class) {
                    zzse.zzbrj = null;
                }
                zzbrq.incrementAndGet();
                zzri = context;
            }
        }
    }

    abstract T zzs(Object obj);

    static void zztq() {
        zzbrq.incrementAndGet();
    }

    private zzsi(zzso zzso, String str, T t) {
        this.zzbrr = -1;
        if (zzso.zzbrt == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.zzbro = zzso;
        this.name = str;
        this.zzbrp = t;
    }

    private final String zzfr(String str) {
        if (str != null && str.isEmpty()) {
            return this.name;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.name);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final String zztr() {
        return zzfr(this.zzbro.zzbrv);
    }

    public final T getDefaultValue() {
        return this.zzbrp;
    }

    public final T get() {
        int i = zzbrq.get();
        if (this.zzbrr < i) {
            synchronized (this) {
                if (this.zzbrr < i) {
                    if (zzri == null) {
                        throw new IllegalStateException("Must call PhenotypeFlag.init() first");
                    }
                    zzso zzso = this.zzbro;
                    Object zzts = zzts();
                    if (zzts == null) {
                        zzts = zztt();
                        if (zzts == null) {
                            zzts = this.zzbrp;
                        }
                    }
                    this.zzalj = zzts;
                    this.zzbrr = i;
                }
            }
        }
        return this.zzalj;
    }

    private final T zzts() {
        zzso zzso = this.zzbro;
        String str = (String) zzse.zzad(zzri).zzfn("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
        Object obj = (str == null || !zzru.zzbqo.matcher(str).matches()) ? null : 1;
        if (obj != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            zzsb zza;
            if (this.zzbro.zzbrt != null) {
                zza = zzrx.zza(zzri.getContentResolver(), this.zzbro.zzbrt);
            } else {
                Context context = zzri;
                zzso zzso2 = this.zzbro;
                zza = zzsp.zzi(context, null);
            }
            if (zza != null) {
                obj = zza.zzfn(zztr());
                if (obj != null) {
                    return zzs(obj);
                }
            }
        }
        String str2 = "PhenotypeFlag";
        String str3 = "Bypass reading Phenotype values for flag: ";
        str = String.valueOf(zztr());
        Log.w(str2, str.length() != 0 ? str3.concat(str) : new String(str3));
        return null;
    }

    private final T zztt() {
        zzso zzso = this.zzbro;
        zzsb zzad = zzse.zzad(zzri);
        zzso zzso2 = this.zzbro;
        Object zzfn = zzad.zzfn(zzfr(this.zzbro.zzbru));
        if (zzfn != null) {
            return zzs(zzfn);
        }
        return null;
    }

    private static zzsi<Long> zza(zzso zzso, String str, long j) {
        return new zzsj(zzso, str, Long.valueOf(j));
    }

    private static zzsi<Integer> zza(zzso zzso, String str, int i) {
        return new zzsk(zzso, str, Integer.valueOf(i));
    }

    private static zzsi<Boolean> zza(zzso zzso, String str, boolean z) {
        return new zzsl(zzso, str, Boolean.valueOf(z));
    }

    private static zzsi<Double> zza(zzso zzso, String str, double d) {
        return new zzsm(zzso, str, Double.valueOf(d));
    }

    private static zzsi<String> zza(zzso zzso, String str, String str2) {
        return new zzsn(zzso, str, str2);
    }
}
