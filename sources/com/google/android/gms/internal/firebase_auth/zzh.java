package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft.zzb;

public final class zzh extends zzft<zzh, zza> implements zzhe {
    private static final zzh zzl = new zzh();
    private static volatile zzhm<zzh> zzm;
    private int zzi;
    private String zzj = "";
    private String zzk = "";

    public static final class zza extends com.google.android.gms.internal.firebase_auth.zzft.zza<zzh, zza> implements zzhe {
        private zza() {
            super(zzh.zzl);
        }
    }

    private zzh() {
    }

    protected final Object zza(int i, Object obj, Object obj2) {
        switch (zzi.zzn[i - 1]) {
            case 1:
                return new zzh();
            case 2:
                return new zza();
            case 3:
                Object[] objArr = new Object[]{"zzi", "zzj", "zzk"};
                return zzft.zza(zzl, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", objArr);
            case 4:
                return zzl;
            case 5:
                Object obj3 = zzm;
                if (obj3 != null) {
                    return obj3;
                }
                synchronized (zzh.class) {
                    obj3 = zzm;
                    if (obj3 == null) {
                        obj3 = new zzb(zzl);
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
        zzft.zza(zzh.class, zzl);
    }
}
