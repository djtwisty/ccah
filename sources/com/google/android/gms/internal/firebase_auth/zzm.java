package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft.zzb;

public final class zzm extends zzft<zzm, zza> implements zzhe {
    private static final zzm zzet = new zzm();
    private static volatile zzhm<zzm> zzm;
    private String zzat = "";
    private String zzby = "";
    private String zzcd = "";
    private String zzcn = "";
    private String zzdk = "";
    private String zzei = "";
    private String zzes = "";
    private int zzi;
    private String zzr = "";

    public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzm, zza> implements zzhe {
        private zza() {
            super(zzm.zzet);
        }
    }

    private zzm() {
    }

    public final String getProviderId() {
        return this.zzr;
    }

    public final String getDisplayName() {
        return this.zzcd;
    }

    public final String zzal() {
        return this.zzcn;
    }

    public final String zzbg() {
        return this.zzdk;
    }

    public final String getEmail() {
        return this.zzat;
    }

    public final String getPhoneNumber() {
        return this.zzby;
    }

    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzn.zzn[i - 1]) {
            case 1:
                return new zzm();
            case 2:
                return new zza();
            case 3:
                Object[] objArr = new Object[]{"zzi", "zzr", "zzcd", "zzcn", "zzdk", "zzat", "zzes", "zzei", "zzby"};
                return zzft.zza(zzet, "\u0001\b\u0000\u0001\u0001\t\b\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\t\b\u0007", objArr);
            case 4:
                return zzet;
            case 5:
                Object obj3 = zzm;
                if (obj3 != null) {
                    return obj3;
                }
                synchronized (zzm.class) {
                    obj3 = zzm;
                    if (obj3 == null) {
                        obj3 = new zzb(zzet);
                        zzm = obj3;
                    }
                }
                return obj3;
            case 6:
                return Byte.valueOf((byte) 1);
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        zzft.zza(zzm.class, zzet);
    }
}
